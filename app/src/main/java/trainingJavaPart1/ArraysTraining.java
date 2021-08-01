package trainingJavaPart1;

/**
 * Набор тренингов по работе с массивами в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ArraysTrainingTest.
 */

public class ArraysTraining {

    /**
     * Метод должен сортировать входящий массив
     * по возрастранию пузырьковым методом
     *
     * @param valuesArray массив для сортировки
     * @return отсортированный массив
     */
    public int[] sort(int[] valuesArray) {

        for (int i = 1; i < valuesArray.length; i++){
            for (int j = valuesArray.length -1; j >= i; j--){
                if (valuesArray[j-1] > valuesArray[j]){
                    int buff = valuesArray[j-1];
                    valuesArray[j-1] = valuesArray[j];
                    valuesArray[j] = buff;
                }
            }
        }
        return valuesArray;
    }

    /**
     * Метод должен возвращать максимальное
     * значение из введенных. Если входящие числа
     * отсутствуют - вернуть 0
     *
     * @param values входящие числа
     * @return максимальное число или 0
     */
    public int maxValue(int... values) {
        if (values.length == 0) return 0;
        int save = values[0];

        for (int i = 0; i < values.length; i++){
            if (values[i] > save) save = values[i];
        }
        return save;
    }

    /**
     * Переставить элементы массива
     * в обратном порядке
     *
     * @param array массив для преобразования
     * @return входящий массив в обратном порядке
     */
    public int[] reverse(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    /**
     * Метод должен вернуть массив,
     * состоящий из чисел Фибоначчи
     *
     * @param numbersCount количество чисел Фибоначчи,
     *                     требуемое в исходящем массиве.
     *                     Если numbersCount < 1, исходный
     *                     массив должен быть пуст.
     * @return массив из чисел Фибоначчи
     */
    public int[] fibonacciNumbers(int numbersCount) {

        // Проверяем не является ли входящий аргумент 0
        if (numbersCount == 0 || numbersCount < 0){
            return new int[]{};
        }else {
            // Объявляем первые две цифры последовательности
            int firstNumber = 1;
            int secondNumber = 1;

            int[] result = new int[numbersCount];
            result[0] = firstNumber;
            result[1] = secondNumber;

            // Проходимся циклом по массиву и заполняем его числами
            for (int i = 2; i < result.length; i++){
                result[i] = firstNumber + secondNumber;
                firstNumber = secondNumber;
                secondNumber = result[i];
            }
            return result;
        }
    }

    /**
     * В данном массиве найти максимальное
     * количество одинаковых элементов.
     *
     * @param array массив для выборки
     * @return количество максимально встречающихся
     * элементов
     */
    public int maxCountSymbol(int[] array) {

        // Если входящий массиву пустой возврщаем 0
        if (array == null || array.length == 0) return 0;

        int current = 0;
        int last = array[0];
        int count = 1;

        // Сортируем массив
        sort(array);

        // Сверяем элементы массива
        for (int i = 1; i < array.length; i++){
            if(array[i] == last) count++;
            else{
                // С помощью тернарного оператора сверяем а потом присваеваем значение
                current = current > count ? current : count;
                count = 1;
            }
            last = array[i];
        }
        current = current > count ? current: count;

        return current;
    }
}
