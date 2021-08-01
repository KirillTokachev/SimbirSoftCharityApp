package trainingJavaPart2;



import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see CollectionsBlockTest.
 */
public class CollectionsBlock<T extends Comparable> {


    /**
     * Даны два упорядоченных по убыванию списка.
     * Объедините их в новый упорядоченный по убыванию список.
     * Исходные данные не проверяются на упорядоченность в рамках данного задания
     *
     * @param firstList  первый упорядоченный по убыванию список
     * @param secondList второй упорядоченный по убыванию список
     * @return объединенный упорядоченный список
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask0(@NonNull List<T> firstList, @NonNull List<T> secondList) {

        if (firstList == null || secondList == null) throw new NullPointerException("Один из параметров null");
        if (firstList.size() == 0 || secondList.size() ==0) throw new NullPointerException("У одного из параметров size() == 0");

        List<T> output = new ArrayList<T>();
        output.addAll(firstList);
        output.addAll(secondList);
        Collections.sort(output);

        return output;
    }

    /**
     * Дан список. После каждого элемента добавьте предшествующую ему часть списка.
     *
     * @param inputList с исходными данными
     * @return измененный список
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask1(@NonNull List<T> inputList) {

        if (inputList == null) throw new NullPointerException("Один из параметров null");
        if (inputList.size() == 0) throw new NullPointerException("Параметр size() == 0");

        ArrayList<T> output = new ArrayList<T>();

        for (int i = 0; i < inputList.size(); i++){
            output.add(inputList.get(i));
            output.addAll(inputList.subList(0,i));
        }
        return output;
    }

    /**
     * Даны два списка. Определите, совпадают ли множества их элементов.
     *
     * @param firstList  первый список элементов
     * @param secondList второй список элементов
     * @return <tt>true</tt> если множества списков совпадают
     * @throws NullPointerException если один из параметров null
     */
    public boolean collectionTask2(@NonNull List<T> firstList, @NonNull List<T> secondList) {

        if (firstList == null || secondList == null) throw new NullPointerException("Один из параметров null");
        if (firstList.size() == 0 || secondList.size() ==0) throw new NullPointerException("У одного из параметров size() == 0");

        Collections.sort(firstList);
        Collections.sort(secondList);

        if (firstList.equals(secondList)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Создать список из заданного количества элементов.
     * Выполнить циклический сдвиг этого списка на N элементов вправо или влево.
     * Если N > 0 циклический сдвиг вправо.
     * Если N < 0 циклический сдвиг влево.
     *
     * @param inputList список, для которого выполняется циклический сдвиг влево
     * @param n         количество шагов циклического сдвига N
     * @return список inputList после циклического сдвига
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask3(@NonNull List<T> inputList, int n) {
        // Простой способ решения задачи
        /*Collections.rotate(inputList, n);*/

        // Проверка на null значения
        if (inputList == null) throw new NullPointerException("Один из параметров null");

        // Оптимизируем сдвиг если он больше размера массива
        // через деление по модулю

        int inputN;
        if(n > inputList.size()){
            n = Math.abs(n % inputList.size());
        } else {
            inputN = n;
        }

        // Если n больше 0 то сдвигаем в право

        if(n > 0){
            for (int i = 0; i < n; i++){
                //// Сохраняем первый элемент в буфер, а на его место ставим последний элемент
                T buff = inputList.get(0);
                inputList.set(0, inputList.get(inputList.size() - 1));
                // Сам цилк по сдвигу массива
                for (int j = 1; j < inputList.size() - 1; j++){
                    inputList.set(inputList.size() - j, inputList.get(inputList.size() - j - 1));
                }
                inputList.set(1, buff);
            }
            // Если n меньше 0 то сдвигаем в лево
        }else if (n < 0){
            for (int i = 0; i > n; i--){
                // Сохраняем первый элемент в буфер, а на его место ставим последний элемент
                T buff = inputList.get(inputList.size() - 1);
                inputList.set(inputList.size() - 1, inputList.get(0));

                for (int j = 1; j < inputList.size() - 1; j++){
                    inputList.set(j - 1, inputList.get(j));
                }
                inputList.set(inputList.size() - 2, buff);
            }
        }
        return inputList;
    }

    /**
     * Элементы списка хранят слова предложения.
     * Замените каждое вхождение слова A на B.
     *
     * @param inputList список со словами предложения и пробелами для разделения слов
     * @param a         слово, которое нужно заменить
     * @param b         слово, на которое нужно заменить
     * @return список после замены каждого вхождения слова A на слово В
     * @throws NullPointerException если один из параметров null
     */
    public List<String> collectionTask4(@NonNull List<String> inputList, @NonNull String a,
                                        @NonNull String b) {
        if (inputList == null || a == null || b == null) throw new NullPointerException("Один из параметров null");

        for (int i = 0; i < inputList.size(); i++){
            String tmp = inputList.get(i);
            if(tmp == a){
                inputList.set(i, b);
            }
        }
        return inputList;
    }

    /*
      Задание подразумевает создание класса(ов) для выполнения задачи.

      Дан список студентов. Элемент списка содержит фамилию, имя, отчество, год рождения,
      курс, номер группы, оценки по пяти предметам. Заполните список и выполните задание.
      Упорядочите студентов по курсу, причем студенты одного курса располагались
      в алфавитном порядке. Найдите средний балл каждой группы по каждому предмету.
      Определите самого старшего студента и самого младшего студентов.
      Для каждой группы найдите лучшего с точки зрения успеваемости студента.
     */
}
