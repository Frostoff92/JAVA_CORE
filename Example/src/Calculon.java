import java.util.Scanner;

public class Calculon {
  static   Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc( num1,  num2, operation);
        System.out.println("Равно: " + result);
    }

    public static int getInt()    {
        System.out.println("Введите число: ");
        int num;
        if (sc.hasNextInt())    {
            num = sc.nextInt();
        } else {
            System.out.println("Введено некорректное значение. Попробуйте ещё раз.");
            sc.next();
            num = getInt();
        }
        return num;
    }

    public static char getOperation()   {
        System.out.println("Введите операцию: ");
        char operation;
        if (sc.hasNext())   {
            operation = sc.next().charAt(0);
        } else {
            System.out.println("Введена некорректная операция. Попробуйте ещё раз.");
            sc.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation)  {
        int result;
        switch (operation)  {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '^':
                result = (int) Math.pow(num1, num2);
                break;
            case '#':
                result = (int) Math.sqrt(num1);
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
                break;
        }
        return result;
    }
}
