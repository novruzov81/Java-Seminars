package Seminar1;
//Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

public class Task1 {
    public static void main(String[] args) {
        int n = 6; // Переменная n, для которой нужно вычислить треугольное число и факториал

        int triangleNumber = calculateTriangleNumber(n);
        int factorial = calculateFactorial(n);

        System.out.println("Треугольное число для " + n + " = " + triangleNumber);
        System.out.println("Факториал числа " + n + " = " + factorial);
    }

    public static int calculateTriangleNumber(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    public static int calculateFactorial(int n) {
        int factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
