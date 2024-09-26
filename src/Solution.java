import java.util.Arrays;

public class Solution {
    public static int findMissingNumber(int[] arr){

        // If the array is empty, throw an exception
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        // Sort the array to arrange numbers in sequence
        Arrays.sort(arr);

        // If the next element is not greater than the current by 1, a missing number is found
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i + 1] != arr[i] + 1) {
                return arr[i] + 1; // Return the missing number
            }
        }

        // If no missing number was found in the array, it's either the first or the last number.
        // If the first element is greater than zero, the missing number is one less than the first element
        // Otherwise, the missing number is one greater than the last element.
        return arr[0] > 0 ? arr[0] - 1 : arr[arr.length - 1] + 1;
    }

    // Method for testing
    private static void test(int[] arr, int expected) { // Accepts an array and the expected missing number
        int result = findMissingNumber(arr); // Calls the function to find the missing number
        System.out.println("Array: " + Arrays.toString(arr) + " Missing number: " + result + " Expected: " + expected);
    // Check if the missing number found by the function matches the expected number
        assert result == expected : "Test failed for input: " + Arrays.toString(arr);
    }

    public static void main(String[] args) {
        test(new int[]{6, 1, 5, 3, 2}, 4); // Missing number in the middle of the sequence
        test(new int[]{4, 5, 6}, 3); // Missing number at the start of the sequence
        test(new int[]{0, 1, 2}, 3); // Missing number at the end of the sequence
        test(new int[]{7, 9, 10, 11, 12}, 8); // Missing number in the middle of a sorted array
        test(new int[]{0}, 1); // Array with one element
        try {
            test(new int[]{}, -1);  // Expecting an exception since the array is empty
        } catch (IllegalArgumentException e) {
            System.out.println("Passed empty array test: " + e.getMessage());
        }
    }


}
