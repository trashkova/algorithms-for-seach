package ru.trashkova.search;

/**
 * Интерполяционный поиск
 */
public class InterpolationSearch {

    public static int search(int[] array, int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        int middleIndex;

        while (elementToSearch > array[firstIndex] && elementToSearch < array[lastIndex]) {

            // защита от деления на 0
            if (array[firstIndex] == array[lastIndex]) {
                break;
            }

            // формула интерполяции для поиска возможной лучшей позиции для существующего элемента
            middleIndex = (int) (firstIndex + 1.0 * ((lastIndex - firstIndex) / (array[lastIndex] - array[firstIndex])) *
                    (elementToSearch - array[firstIndex]));

            if (array[middleIndex] == elementToSearch) {
                return middleIndex;
            } else if (array[middleIndex] > elementToSearch) {
                lastIndex = middleIndex - 1; // сдвиг последнего элемента: отбрасываем всю правую часть, включая середину
            } else {
                firstIndex = middleIndex + 1; // сдвиг первого элемента: отбрасываем всю левую часть, включая середину
            }
        }

        if (array[firstIndex] == elementToSearch) {
            return firstIndex;
        }

        if (array[lastIndex] == elementToSearch) {
            return lastIndex;
        }

        return -1;
    }

}