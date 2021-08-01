package trainingJavaPart2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see StringsTrainingTest.
 */
public class StringsTraining {

    /**
     * Метод по созданию строки,
     * состоящей из нечетных символов
     * входной строки в том же порядке
     * (нумерация символов идет с нуля)
     *
     * @param text строка для выборки
     * @return новая строка из нечетных
     * элементов строки text
     */
    public String getOddCharacterString(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++ ){
            if (i % 2 != 0){
                result += text.charAt(i);
            }
        }
        return result;
    }

    /**
     * Метод для определения количества
     * символов, идентичных последнему
     * в данной строке
     *
     * @param text строка для выборки
     * @return массив с номерами символов,
     * идентичных последнему. Если таких нет,
     * вернуть пустой массив
     */
    public int[] getArrayLastSymbol(String text) {

        // Преобразуем полученную строку в массив символов
        char[] inputChars = text.toCharArray();
        if (inputChars.length == 0) return new int[]{};

        // Объявляем список что бы занести в него номера символов
        ArrayList<Integer> outList = new ArrayList();


        // Заполянем массив номерами одинаковых сиволово идентичных последнему
        for (int i = 0; i < inputChars.length; i++){
            if(inputChars[inputChars.length-1] == (inputChars[i])) outList.add((int) inputChars[i]);
        }

        // Костыль для того что бы удалить записавшийся сивол у которого нету идентичных
        if (outList.size() == 1){
            outList.remove(0);
        }

        // Объявдяем интовый массив для заполнения его идентичными номерами
        int size = outList.size()-1;
        if (size <= 0) return new int[]{};
        int[] outInt = new int[size];

        // Заполняем массив
        for (int i = 0; i < outInt.length; i++){
            outInt[i] = outList.get(i);
        }
        return outInt;
    }

    /**
     * Метод по получению количества
     * цифр в строке
     *
     * @param text строка для выборки
     * @return количество цифр в строке
     */
    public int getNumbersCount(String text) {

        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    /**
     * Дан текст. Заменить все цифры
     * соответствующими словами.
     *
     * @param text текст для поиска и замены
     * @return текст, где цифры заменены словами
     */
    public String replaceAllNumbers(String text) {

        // Создаём пустой объект строки куда будем помещать результат
        String result = "";

        // Создаем HashMap для связывания ключа цифры и значения слова
        Map<String, String> mapInt = new HashMap<String, String>();
        mapInt.put("0", "zero");
        mapInt.put("1", "one");
        mapInt.put("2", "two");
        mapInt.put("3", "three");
        mapInt.put("4", "four");
        mapInt.put("5", "five");
        mapInt.put("6", "six");
        mapInt.put("7", "seven");
        mapInt.put("8", "eight");
        mapInt.put("9", "nine");

        // Далее проходимся циклом по строке и извлекаем сиволы с помощью substring
        // Затем проверяем есть ли такоей же сивол в нашей HashMap
        for (int i = 0; i < text.length(); i++){
            String key = text.substring(i, i + 1);
            if (mapInt.containsKey(key)){
                result = result + mapInt.get(key);
            } else {
                result = result + key;
            }
        }

        return result;
    }

    /**
     * Метод должен заменить заглавные буквы
     * на прописные, а прописные на заглавные
     *
     * @param text строка для изменения
     * @return измененная строка
     */
    public String capitalReverse(String text) {

        // Преобразуем полученую строку в StringBuilder для того что бы можно было использвать
        // метод setCharAt и с ппомошью него заменять буквы
        StringBuilder output = new StringBuilder(text);

        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);
            if (Character.isLowerCase(c)) {
                output.setCharAt(i, Character.toUpperCase(c));
            } else {
                output.setCharAt(i, Character.toLowerCase(c));
            }
        }

        return output.toString();
    }

}
