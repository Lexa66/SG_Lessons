import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        space(text);
        task2(text);
        task3(text);
    }

    static String space(String input) {
        String result = input.replaceAll(" {2,}", " ");
        System.out.println(result);
        return result;
    }

    static void task2(String input) {
        input.split("[,;:.!?\\s]+");

        String[] text = input.trim().split("[,;:.!?\\s]+");
        for (int i = 0; i < text.length; i++)
            System.out.println(text[i]);
    }

    static void task3(String input) {
        if (input.length() != 5) {
            System.out.println("Must be 5 letters");
        } else {
            String text = new StringBuilder(input).reverse().toString();
            if (input.equalsIgnoreCase(text)) {
                System.out.println("This is paliondrom");
            } else {
                System.out.println("This is not paliondrom");
            }
        }
    }
}
