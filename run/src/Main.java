import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.beans.Expression;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        Scanner in = new Scanner(System.in);
        System.out.print("Введите математическое выражение: ");
        String calcStringIn = in.nextLine();
        System.out.print("calcStringIn ");
        System.out.print(calcStringIn);
        String result = calc(calcStringIn);
    }
    public static String eval(String a, String operator, String b) {
        int r = 0;

        switch (operator) {
            case "/":
                r += Double.parseDouble(a) / Double.parseDouble(b);
                break;
            case "*":
                r += Double.parseDouble(a) * Double.parseDouble(b);
                break;
            case "-":
                r += Double.parseDouble(a) - Double.parseDouble(b);
                break;
            case "+":
                r += Double.parseDouble(a) + Double.parseDouble(b);
                break;
        }

        return Integer.toString(r);
    }
    public static String calc(String input) {
        System.out.print("calc function ");
        // Надо выкинуть из строки пробелы
        String formatInput = input.replaceAll(" ", "");
        System.out.print("formatInput ");
        System.out.print(formatInput);

        // получить операнды и оператор
        String patternStr = "(\\d+)(\\D)(\\d+)";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(formatInput);

        if (matcher.find())
        {
            String operand1 = matcher.group(1);
            String operator = matcher.group(2);
            String operand3 = matcher.group(3);
            System.out.println("group");
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));

            String resultString = eval(operand1, operator, operand3);

            // сделать мат операцию
            System.out.println(resultString);
            return resultString;
        } else {
            // выбросить исключение?
        }

        // выкинуть исключения

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