package ru.trashkova.search;

/**
 * Бинарный поиск
 */
public class BinarySearch {

    public static int search(int[] array, int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        int middleIndex;

        while (firstIndex <= lastIndex) {

            middleIndex = (firstIndex + lastIndex) / 2;

            if (array[middleIndex] == elementToSearch) {
                return middleIndex;
            } else if (array[middleIndex] > elementToSearch) {
                firstIndex = middleIndex + 1; // сдвиг первого элемента: отбрасываем всю левую часть, включая середину
            } else {
                lastIndex = middleIndex - 1; // сдвиг последнего элемента: отбрасываем всю правую часть, включая середину
            }
        }

        return -1; // элемент не найден
    }

    public static int recursiveSearch(int[] array, int firstElement, int lastElement, int elementToSearch) {
        if (lastElement >= firstElement) {
            int middleIndex = firstElement + (lastElement - firstElement) / 2;

            if (array[middleIndex] == elementToSearch) {
                return middleIndex;
            } else if (array[middleIndex] > elementToSearch) {
                return recursiveSearch(array, firstElement, middleIndex - 1, elementToSearch);
            } else {
                return recursiveSearch(array, middleIndex + 1, lastElement, elementToSearch);
            }
        }

        return -1;
    }

}