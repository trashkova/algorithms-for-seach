package ru.trashkova.search;

public class LinearSearch {

    public static int search(int[] array, int elementToSearch) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == elementToSearch)
                return index;
        }
        return -1;
    }

}