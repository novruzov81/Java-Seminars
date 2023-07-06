package Seminar2;
//*Получить исходную json строку из файла, используя FileReader или Scanner
//        Дана json строка вида:
//        String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
//        "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
//        "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
//
//        Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.
//
//        Используйте StringBuilder для подготовки ответа. Далее создайте метод, который запишет
//        результат работы в файл. Обработайте исключения и запишите ошибки в лог файл с помощью Logger.
//
//        *Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.JSONArray;
import org.json.JSONObject;
public class Task1 {
    private static final Logger LOGGER = Logger.getLogger(Task1.class.getName());
    private static final String LOG_FILE_PATH = "log.txt";

    public static void main(String[] args) {
        parseJsonString();
        bubbleSort(new int[]{5, 3, 2, 4, 1});
    }

    public static void parseJsonString() {
        StringBuilder result = new StringBuilder();

        String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},"
                + "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},"
                + "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        try {
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonItem = jsonArray.getJSONObject(i);
                String фамилия = jsonItem.getString("фамилия");
                String оценка = jsonItem.getString("оценка");
                String предмет = jsonItem.getString("предмет");

                result.append("Студент ").append(фамилия)
                        .append(" получил ").append(оценка)
                        .append(" по предмету ").append(предмет)
                        .append(".\n");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Ошибка при разборе JSON.", e);
        }

        writeToFile(result.toString());
    }

    public static void bubbleSort(int[] array) {
        StringBuilder result = new StringBuilder();

        try {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }

                result.append("Итерация ").append(i + 1).append(": [");
                for (int k = 0; k < array.length; k++) {
                    result.append(array[k]);
                    if (k != array.length - 1) {
                        result.append(", ");
                    }
                }
                result.append("]\n");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Ошибка при сортировке.", e);
        }

        writeToFile(result.toString());
    }

    public static void writeToFile(String content) {
        try (FileWriter writer = new FileWriter(LOG_FILE_PATH)) {
            writer.write(content);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при записи в файл.", e);
        }
    }

    static {
        try {
            FileHandler fileHandler = new FileHandler(LOG_FILE_PATH, true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при создании обработчика файла журнала.", e);
        }
    }
}
