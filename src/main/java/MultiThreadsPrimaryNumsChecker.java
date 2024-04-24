public class MultiThreadsPrimaryNumsChecker extends Thread {

    private Integer[] unchecked, checked;
    private static final Integer MAX_THREADS = 10;

    public MultiThreadsPrimaryNumsChecker(Integer[] unchecked) {
        this.unchecked = unchecked;
    }

    public Integer[] getChecked() {
        return checked;
    }

    public void run() {
        Integer middle;
        Integer[] left, right;

        if (unchecked.length <= 1) {
            checked = unchecked;
        } else {

            middle = unchecked.length / 2;

            left = new Integer[middle];
            right = new Integer[unchecked.length - middle];

            System.arraycopy(unchecked, 0, left, 0, middle);
            System.arraycopy(unchecked, middle, right, 0, unchecked.length - middle);

            if (activeCount() < MAX_THREADS) {
                MultiThreadsPrimaryNumsChecker leftNums = new MultiThreadsPrimaryNumsChecker(left);
                MultiThreadsPrimaryNumsChecker rightNums = new MultiThreadsPrimaryNumsChecker(right);

                leftNums.start();
                rightNums.start();
                try {
                    leftNums.join();
                    rightNums.join();

                    leftNums.unchecked = BasePrimaryNumsChecker.getPrimaryNums(leftNums.unchecked);
                    rightNums.unchecked = BasePrimaryNumsChecker.getPrimaryNums(rightNums.unchecked);
                    checked = new Integer[leftNums.unchecked.length + rightNums.unchecked.length];
                    checked = ArrayMerger.arrayMerger(leftNums.unchecked, rightNums.unchecked);
                } catch (Exception e) {

                }

            } else {

                BasePrimaryNumsChecker leftNums = new BasePrimaryNumsChecker(BasePrimaryNumsChecker.getPrimaryNums(left));
                BasePrimaryNumsChecker rightNums = new BasePrimaryNumsChecker(BasePrimaryNumsChecker.getPrimaryNums(right));


                checked = new Integer[BasePrimaryNumsChecker.primaryNumsMerger(leftNums.unchecked, rightNums.unchecked).length];
                System.arraycopy(BasePrimaryNumsChecker.primaryNumsMerger(leftNums.unchecked, rightNums.unchecked), 0, checked, 0, BasePrimaryNumsChecker.primaryNumsMerger(leftNums.unchecked, rightNums.unchecked).length);
            }

        }
    }
}
