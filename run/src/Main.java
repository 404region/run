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
    static String eval(String a, String operator, String b) {
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

    static String replaceRomanNumber(String romanNumber) {
        String r = "1";

        switch (romanNumber) {
            case "I":
                r = "1";
                break;
            case "II":
                r = "2";
                break;
            case "III":
                r = "3";
                break;
            case "IV":
                r = "4";
                break;
            case "V":
                r = "5";
                break;
            case "VI":
                r = "6";
                break;
            case "VII":
                r = "7";
                break;
            case "VIII":
                r = "8";
                break;
            case "IX":
                r = "9";
                break;
            case "X":
                r = "10";
                break;
            default:
                //  выкинуть ошибку
                break;
        }

        return r;
    }
    static String replaceArabicNumberToRoman(String arabicNumber) {
        String r = "I";

        switch (arabicNumber) {
            case "1":
                r = "I";
                break;
            case "2":
                r = "II";
                break;
            case "3":
                r = "III";
                break;
            case "4":
                r = "IV";
                break;
            case "5":
                r = "V";
                break;
            case "6":
                r = "VI";
                break;
            case "7":
                r = "VII";
                break;
            case "8":
                r = "VIII";
                break;
            case "9":
                r = "IX";
                break;
            case "10":
                r = "X";
                break;
            case "11":
                r = "XI";
                break;
            case "12":
                r = "XII";
                break;
            case "13":
                r = "XIII";
                break;
            case "14":
                r = "XIV";
                break;
            case "15":
                r = "XV";
                break;
            case "16":
                r = "XVI";
                break;
            case "17":
                r = "XVII";
                break;
            case "18":
                r = "XVIII";
                break;
            case "19":
                r = "XIX";
                break;
            case "20":
                r = "XX";
                break;
            default:
                //  выкинуть ошибку
                break;
        }

        return r;
    }

    static Boolean checkForRoman(String str) {
        String patternStr = "I|V|X";
        return Pattern.compile(patternStr).matcher(str).find();
    }
    public static String calc(String input) {
        System.out.print("calc function ");
        // Надо выкинуть из строки пробелы
        String formatInput = input.replaceAll(" ", "");
        System.out.print("formatInput ");
        System.out.print(formatInput);

        // Проверить что нету римских чисел
        if(checkForRoman(formatInput)) {
            // итак римские цифры есть
            // получить операнды и оператор для римских чисел
            String patternRomanStr = "([I|V|X]+)([^I|V|X])([I|V|X]+)";
            Pattern patternRoman = Pattern.compile(patternRomanStr);
            Matcher matcher = patternRoman.matcher(formatInput);

            if (matcher.find())
            {
                String operand1 = matcher.group(1);
                String operator = matcher.group(2);
                String operand3 = matcher.group(3);
                System.out.println("group");
                System.out.println(matcher.group(1));
                System.out.println(matcher.group(2));
                System.out.println(matcher.group(3));

                String resultString = eval(replaceRomanNumber(operand1), operator, replaceRomanNumber(operand3));

                // сделать мат операцию
                System.out.println(replaceArabicNumberToRoman(resultString));
                return replaceArabicNumberToRoman(resultString);
            } else {
                // выбросить исключение?
            }
        }


        // получить операнды и оператор для арабских чисел
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