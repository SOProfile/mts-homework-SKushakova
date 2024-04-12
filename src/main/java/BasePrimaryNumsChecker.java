import java.math.BigInteger;
import java.util.ArrayList;

public class BasePrimaryNumsChecker {
    public Integer[] unchecked, checked;

    public BasePrimaryNumsChecker(Integer[] unchecked) {
        this.unchecked = unchecked;
    }

    public void checkIsPrimary() {
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

            BasePrimaryNumsChecker leftNums = new BasePrimaryNumsChecker(this.getPrimaryNums(left));
            BasePrimaryNumsChecker rightNums = new BasePrimaryNumsChecker(this.getPrimaryNums(right));

            checked = new Integer[this.primaryNumsMerger(leftNums.unchecked, rightNums.unchecked).length];
            System.arraycopy(this.primaryNumsMerger(leftNums.unchecked, rightNums.unchecked), 0, checked, 0, this.primaryNumsMerger(leftNums.unchecked, rightNums.unchecked).length);
        }
    }

    public static Integer[] primaryNumsMerger(Integer[] leftArray, Integer[] rightArray) {
        Integer[] mergedArray = new Integer[leftArray.length + rightArray.length];
        if (leftArray != null && rightArray != null) {
            System.arraycopy(leftArray, 0, mergedArray, 0, leftArray.length);
            System.arraycopy(rightArray, 0, mergedArray, leftArray.length, rightArray.length);
        } else if (leftArray != null) {
            mergedArray = new Integer[leftArray.length];
            System.arraycopy(leftArray, 0, mergedArray, 0, leftArray.length);
        } else if (rightArray != null) {
            mergedArray = new Integer[rightArray.length];
            System.arraycopy(rightArray, 0, mergedArray, 0, rightArray.length);
        }
        return mergedArray;
    }

    public Integer[] getChecked() {
        return checked;
    }

    public static Integer[] getPrimaryNums(Integer[] nums) {
        ArrayList<Integer> isPrimeNums = new ArrayList<Integer>();

        for (int count = 0; count < nums.length; count++) {
            BigInteger bigInteger = BigInteger.valueOf(nums[count]);
            if (bigInteger.isProbablePrime((int) Math.log(nums[count]))) {
                isPrimeNums.add(nums[count]);
            }
        }
        return isPrimeNums.toArray(new Integer[0]);
    }


}
