import java.util.Arrays;

public class Solution {
    public static int findMissingNumber(int[] arr){
        // Если массив пустой, то выбрасываем исключение
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        Arrays.sort(arr); // Сортируем массив, чтобы числа шли по порядку

        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i + 1] != arr[i] + 1) { // Если сл. элемент не на 1 больше пред., то найдено пропущенное число
                return arr[i] + 1; // Возвращаем пропущенное число
            }
        }

        // Если пропущенное число не было найдено в массиве, то оно либо первое, либо последнее.
        // Если первый элемент массива больше нуля, то пропущенное число - это число меньше первого элемента на 1.
        // В ином случае - это число больше последнего элемента в массиве на 1.
        return arr[0] > 0 ? arr[0] - 1 : arr[arr.length - 1] + 1;
    }

    // Метод для тестирования
    private static void test(int[] arr, int expected) { // принимаем массив и пропущенное число
        int result = findMissingNumber(arr); // вызываем функцию, которая находит пропущенное число
        System.out.println("Array: " + Arrays.toString(arr) + " Missing number: " + result + " Expected: " + expected);
        // Проверяем равно ли пропущенное число, которая нашла функция тому, что мы передали в аргумент expected
        assert result == expected : "Test failed for input: " + Arrays.toString(arr);
    }

    public static void main(String[] args) {
        test(new int[]{6, 1, 5, 3, 2}, 4); // Пропуск в середине последовательности
        test(new int[]{4, 5, 6}, 3); // Пропуск в начале последовательности
        test(new int[]{0, 1, 2}, 3); //  Пропуск в конце последовательности
        test(new int[]{7, 9, 10, 11, 12}, 8); // Пропуск в середине отсортированного массива
        test(new int[]{0}, 1); // Массив с одним элементом
        try {
            test(new int[]{}, -1);  // Ожидаем выброс исключения, так как пустой массив
        } catch (IllegalArgumentException e) {
            System.out.println("Passed empty array test: " + e.getMessage());
        }
    }


}
