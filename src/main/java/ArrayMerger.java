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
}
