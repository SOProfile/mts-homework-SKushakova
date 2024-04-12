public class MultiThreadsSorter extends Thread {
    private Integer[] unsorted, sorted;
    private static final Integer MAX_THREADS = 10;

    public MultiThreadsSorter(Integer[] unsorted) {
        this.unsorted = unsorted;
    }

    public Integer[] getSorted() {
        return sorted;
    }

    public void run() {
        Integer middle;
        Integer[] left, right;

        if (unsorted.length <= 1) {
            sorted = unsorted;
        } else {

            middle = unsorted.length / 2;

            left = new Integer[middle];
            right = new Integer[unsorted.length - middle];

            System.arraycopy(unsorted, 0, left, 0, middle);
            System.arraycopy(unsorted, middle, right, 0, unsorted.length - middle);

            if (activeCount() < MAX_THREADS) {
                MultiThreadsSorter leftSort = new MultiThreadsSorter(left);
                MultiThreadsSorter rightSort = new MultiThreadsSorter(right);

                leftSort.start();
                rightSort.start();
                try {
                    leftSort.join();
                    rightSort.join();

                    sorted = ArrayMerger.merge(leftSort.getSorted(), rightSort.getSorted());
                } catch (Exception e) {

                }

            } else {
                BaseSorter leftSort = new BaseSorter(left);
                BaseSorter rightSort = new BaseSorter(right);

                leftSort.sort();
                rightSort.sort();

                sorted = ArrayMerger.merge(leftSort.getSorted(), rightSort.getSorted());
            }

        }
    }

}
