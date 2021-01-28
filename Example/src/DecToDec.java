import java.util.Scanner;

public class DecToDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();

        System.out.println("Число, которое необходимо перевести: " + num);

        String bin = Long.toBinaryString(num);
        System.out.println(bin);

        String oct = Long.toOctalString(num);
        System.out.println(oct);

        String hex = Long.toHexString(num).toUpperCase();
        System.out.println(hex);
    }
}