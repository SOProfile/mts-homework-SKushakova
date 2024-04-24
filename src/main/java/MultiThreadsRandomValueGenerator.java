public class MultiThreadsRandomValueGenerator extends Thread {
    private Integer[] randomValues;
    private Integer size;

    private static final Integer MAX_THREADS = 10;

    public MultiThreadsRandomValueGenerator(Integer size) {
        this.randomValues = new Integer[size];
        this.size = size;
    }

    public Integer[] getRandomValues() {
        return randomValues;
    }

    public void run() {
        Integer middle;
        Integer[] left, right;
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

        if (size <= 1) {
            randomValues = randomValueGenerator.getRandomNums(size);
        } else {

            middle = size / 2;

            left = new Integer[middle];
            right = new Integer[size - middle];

            System.arraycopy(randomValues, 0, left, 0, middle);
            System.arraycopy(randomValues, middle, right, 0, randomValues.length - middle);

            if (activeCount() < MAX_THREADS) {
                MultiThreadsRandomValueGenerator leftNums = new MultiThreadsRandomValueGenerator(left.length);
                MultiThreadsRandomValueGenerator rightNums = new MultiThreadsRandomValueGenerator(right.length);

                leftNums.start();
                rightNums.start();
                try {
                    leftNums.join();
                    rightNums.join();

                    leftNums.randomValues = randomValueGenerator.getRandomNums(leftNums.size);
                    rightNums.randomValues = randomValueGenerator.getRandomNums(rightNums.size);
                    randomValues = new Integer[leftNums.randomValues.length + rightNums.randomValues.length];
                    randomValues = ArrayMerger.arrayMerger(leftNums.randomValues, rightNums.randomValues);
                } catch (Exception e) {

                }

            } else {

                MultiThreadsRandomValueGenerator leftNums = new MultiThreadsRandomValueGenerator(left.length);
                MultiThreadsRandomValueGenerator rightNums = new MultiThreadsRandomValueGenerator(right.length);
                randomValues = new Integer[leftNums.randomValues.length + rightNums.randomValues.length];
                randomValues = ArrayMerger.arrayMerger(leftNums.randomValues, rightNums.randomValues);
            }

        }

    }
}
