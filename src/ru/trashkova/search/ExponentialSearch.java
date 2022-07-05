package ru.trashkova.search;

import java.util.Arrays;

/**
 * Экспоненциальный поиск
 */
public class ExponentialSearch {

    public static int search(int[] array, int elementToSearch) {
        if (array[0] == elementToSearch) {
            return 0;
        }

        if (array[array.length - 1] == elementToSearch) {
            return array.length - 1;
        }

        int range = 1; // диапазон поиска

        while (range < array.length && array[range] <= elementToSearch) {
            range = range * 2;
        }

        // индекс, с которого начинается бинарный поиск
        int startIndex = range / 2;

        // индекс, с которого заканчивается бинарный поиск
        int lastIndex = Math.min(range, array.length);

        return Arrays.binarySearch(array, startIndex, lastIndex, elementToSearch);
    }

}