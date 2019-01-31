package N.CrossTraining.I.Easy.Move0sToTheEndII;

/**
 * Move0sToTheEnd
 *
 * @author meng
 * @date 1/24/19
 */
public class Move0sToTheEndII {
    /**
     * Move all 0's to the right end of the array while maintaining
     * the relative order of the elements
     *
     * This method copies the non-zero elements to cover the zero
     * After checking all the elements, fill the rest of the array
     * with 0's
     *
     * @param array the input array
     * @return      array with all 0's moved to the right
     */
    public int[] moveZero(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1) {
            return array;
        }
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != 0) {
                array[slow++] = array[fast];
            }
        }
        // Upon exiting the loop, slow points to the first position
        // where it is supposed to be a zero (the start of the 0's)
        for (int i = slow; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }

    /**
     * Move all 0's to the right end of the array while maintaining
     * the relative order of the elements
     *
     * This method swaps the non-zero element with the zero when
     * we see a non-zero element
     *
     * @param array the input array
     * @return      array with all 0's moved to the right
     */
    public int[] moveZeroBySwap(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != 0) {
                int temp = array[slow];
                array[slow++] = array[fast];
                array[fast] = temp;
            }
        }
        return array;
    }
}
