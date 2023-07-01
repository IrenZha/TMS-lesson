import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(20));
        }
        System.out.println(list);
        System.out.println("Удалить дубликаты");
        int[] operationNumbers1 = list.stream()
                .distinct()
                .peek(number -> System.out.print(number + ", "))
                .mapToInt(number -> number)
                .sorted()
                .limit(4)
                .toArray();

        System.out.println();
        System.out.println("Отсортировать и вывести на экран первых 4 элемента");
        System.out.println(Arrays.toString(operationNumbers1));

        System.out.println("Вывести все четные элементы в диапазоне от 7 до 17 (включительно)");
        long operationNumbers2 = list.stream()
                .mapToInt(number -> number)
                .filter(number -> (number >= 7 && number <= 17))
                .filter(number -> (number % 2 == 0))
                .peek(number -> System.out.print(number + ", "))
                .count();
        System.out.println();
        System.out.println("Вывести количество элементов в стриме");
        System.out.println(operationNumbers2);

        int[] operationNumbers3 = list.stream()
                .mapToInt(number -> number)
                .map(number -> number * 2)
                .toArray();
        System.out.println("Каждый элемент умножить на 2");
        System.out.println(Arrays.toString(operationNumbers3));


        OptionalDouble average = list.stream()
                .mapToInt(number -> number)
                .average();
        System.out.println("Вывести среднее арифметическое всех чисел в стриме");
        System.out.println(average);
    }
}