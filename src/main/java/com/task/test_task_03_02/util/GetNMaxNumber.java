package com.task.test_task_03_02.util;

import com.task.test_task_03_02.exception.OutOfBoundsException;

import java.util.Set;

public class GetNMaxNumber {
    public static Integer getNMaxNumber(Set<Integer> numbersSet, int n) {
        int[] numberArray = numbersSet.stream().mapToInt(Integer::intValue).toArray();
        sort(numberArray, 0, numberArray.length - 1);
        int i;
        try {
            i = numberArray[numberArray.length - n];
        } catch (IndexOutOfBoundsException exception) {
            throw new OutOfBoundsException(1, numberArray.length);
        }
        return i;
    }

    private static void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int index = sortPart(arr, startIndex, endIndex);

            sort(arr, startIndex, index - 1);
            sort(arr, index + 1, endIndex);
        }
    }

    private static int sortPart(int[] arr, int startIndex, int endIndex) {
        int index = arr[endIndex];
        int i = (startIndex - 1);

        for (int x = startIndex; x < endIndex; x++) {
            if (arr[x] <= index) {
                i++;
                int temp = arr[i];
                arr[i] = arr[x];
                arr[x] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[endIndex];
        arr[endIndex] = temp;

        return i + 1;
    }
}
