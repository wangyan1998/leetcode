package medium;

import java.util.Random;

/**
 * @author wy
 * @date 2021/11/22 9:18
 */
public class ShuffleArray384 {
    private int[] arr;
    private int[] tempArr;
    private Random rand = new Random();

    public ShuffleArray384(int[] nums) {
        arr = new int[nums.length];
        tempArr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
            tempArr[i]=nums[i];
        }
    }

    public int[] reset() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tempArr[i];
        }
        return arr;
    }

    public int[] shuffle() {
        int length = arr.length;
        for (int i = length; i > 0; i--) {
            int randInd = rand.nextInt();
            swap(arr, randInd, i - 1);
        }
        return arr;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
