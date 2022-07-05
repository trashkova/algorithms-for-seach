package ru.trashkova.search;

/**
 * Поиск прыжками
 */
public class JumpSearch {

    public static int search(Integer[] array, int elementToSearch) {
        int arrayLength = array.length;
        int jumpStep = (int) Math.sqrt(arrayLength); // интервал прыжка
        int previousStep = 0; // временная переменная для сохранения проверенного элемента


        // проверка элемента, пока не найдется значение: integers[previousStep] < elementToSearch < integers[jumpStep]
        while (array[Math.min(jumpStep, arrayLength) -1] < elementToSearch) {
            previousStep = jumpStep;
            jumpStep += (int)(Math.sqrt(arrayLength));
            if (previousStep >= arrayLength) {
                return -1;
            }
        }

        // линейный поиск между integers[previousStep] и integers[jumpStep] или элементом большим, чем elementToSearch
        while (array[previousStep] < elementToSearch) {
            previousStep++;
            if (previousStep == Math.min(jumpStep, arrayLength))
                return -1;
        }

        if (array[previousStep] == elementToSearch)
            return previousStep;

        return -1; // элемент не найден
    }

}