import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        /* System.out.printf("Hello and welcome!");
        Info info1 = new Info();
        info1.myInt = 999;
        info1.speak();
        info1.forAll();
        */
        Scanner in = new Scanner(System.in);
        System.out.print("Введите математическое выражение: ");
        String calcStringIn = in.nextLine();
        System.out.print("calcStringIn ");
        System.out.print(calcStringIn);
        String result = calc(calcStringIn);

    }
    public static String calc(String input) {
        System.out.print("calc function ");
        System.out.print("input ");
        System.out.print(input);
        return input;
    }

}

class Info{
    int myInt;
    void speak() {
        System.out.println(myInt);
    }

    void forAll() {
        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {
            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.println("i = " + i);
        }
    }

}