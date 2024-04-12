public class BaseSorter {
    private Integer[] unsorted, sorted;

    public BaseSorter(Integer[] unsorted) {
        this.unsorted = unsorted;
    }

    public void sort() {
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

            BaseSorter leftSort = new BaseSorter(left);
            BaseSorter rightSort = new BaseSorter(right);

            leftSort.sort();
            rightSort.sort();

            sorted = ArrayMerger.merge(leftSort.getSorted(), rightSort.getSorted());
        }
    }

    public Integer[] getSorted() {
        return sorted;
    }
}
