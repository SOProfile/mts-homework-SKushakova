public class ArrayMerger {
    public static Integer[] merge(Integer[] leftPart, Integer[] rightPart) {
        Integer cursorLeft = 0, cursorRight = 0, counter = 0;
        Integer[] merged = new Integer[leftPart.length + rightPart.length];

        while (cursorLeft < leftPart.length && cursorRight < rightPart.length) {
            if (leftPart[cursorLeft] <= rightPart[cursorRight]) {
                merged[counter] = leftPart[cursorLeft];
                cursorLeft++;
            } else {
                merged[counter] = rightPart[cursorRight];
                cursorRight++;
            }
            counter++;
        }

        if (cursorLeft < leftPart.length) {
            System.arraycopy(leftPart, cursorLeft, merged, counter, merged.length - counter);
        }
        if (cursorRight < rightPart.length) {
            System.arraycopy(rightPart, cursorRight, merged, counter, merged.length - counter);
        }

        return merged;
    }

    public static Integer[] arrayMerger(Integer[] leftArray, Integer[] rightArray) {
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
}
