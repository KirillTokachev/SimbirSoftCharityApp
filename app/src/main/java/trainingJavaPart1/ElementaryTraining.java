package trainingJavaPart1;

/**
 * Набор тренингов по работе с примитивными типами java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ElementaryTrainingTest.
 */
public class ElementaryTraining {

    /**
     * Метод должен возвращать среднее значение
     * для введенных параметров
     *
     * @param firstValue  первый элемент
     * @param secondValue второй элемент
     * @return среднее значение для введенных чисел
     */
    public double averageValue(int firstValue, int secondValue) {
        double result = 0;

        result = (firstValue + secondValue) / 2.0;

        return result;
    }

    /**
     * Пользователь вводит три числа.
     * Произвести манипуляции и вернуть сумму новых чисел
     *
     * @param firstValue  увеличить в два раза
     * @param secondValue уменьшить на три
     * @param thirdValue  возвести в квадрат
     * @return сумма новых трех чисел
     */
    public double complicatedAmount(int firstValue, int secondValue, int thirdValue) {

        double usFirstValue = firstValue*2;
        double usSecondValue = secondValue-3;
        double usThirdValue = Math.pow(thirdValue,2);

        double summ = usFirstValue+usSecondValue+usThirdValue;

        return summ;
    }

    /**
     * Метод должен поменять значение в соответствии с условием.
     * Если значение больше 3, то увеличить
     * на 10, иначе уменьшить на 10.
     *
     * @param value число для изменения
     * @return новое значение
     */
    public int changeValue(int value) {

        if (value > 3) {
            value += 10;
        } else value -= 10;

        return value;
    }

    /**
     * Метод должен менять местами первую
     * и последнюю цифру числа.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10, вернуть
     * то же число
     *
     * @param value число для перестановки
     * @return новое число
     */
    public int swapNumbers(int value) {
        int result = 0;

        if (value < 10) {
            result = value;
        } else {
            String temp = Integer.toString(value);
            int[] tempArr = new int[temp.length()];

            if (tempArr.length > 5) return value;
            for (int i = 0; i < tempArr.length; i++) {
                tempArr[i] = temp.charAt(i) - '0';
            }

            // Меняем местами первую и последнюю цифру
            int swap = tempArr[0];
            tempArr[0] = tempArr[tempArr.length - 1];
            tempArr[tempArr.length -1] = swap;

            // Преобразование массива обратно в число
            for (int i = 0; i < tempArr.length; i++) {
                result = result * 10 + tempArr[i];
            }
        }
        return result;
    }

    /**
     * Изменить значение четных цифр числа на ноль.
     * Счет начинать с единицы.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10 вернуть
     * то же число.
     *
     * @param value число для изменения
     * @return новое число
     */
    public int zeroEvenNumber(int value) {

        int result = 0;

        if (value < 10){
            result = value;
        }else {
            String temp = Integer.toString(value);
            int[] tempArr = new int[temp.length()];
            for (int i = 0; i < tempArr.length; i++) {
                tempArr[i] = temp.charAt(i) - '0';
            }

            if (tempArr.length > 5) return value;
            for (int i = 1; i < tempArr.length; i++){
                if (tempArr[i] % 2 == 0){
                    tempArr[i] = 0;
                }
            }

            for (int i = 0; i < tempArr.length; i++) {
                result = result * 10 + tempArr[i];
            }
        }
        return result;
    }

}
