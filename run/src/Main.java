
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) throws Exception {
        // Press Opt+Enter with your caret at the highlighted text to see how
        Scanner in = new Scanner(System.in);
        System.out.print("Введите математическое выражение в одну строку: ");
        String calcStringIn = in.nextLine();
        String result = "";
        try {
            result = calc(calcStringIn);
        } catch (Exception e) {
            System.out.println("Ошибка при вычислении выражения: " + e.getMessage());
        }

        System.out.print(result);
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

    /*static String replaceRomanNumber(String romanNumber) throws Exception {
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
                throw new Exception("В справочнике нет нужного числа");
        }

        return r;
    }*/
    static String replaceRomanNumber(String romanNumber) throws Exception {
        String result;

        result = Integer.toString(romanList.indexOf(romanNumber));

        return result;
    }
    /*static String replaceArabicNumberToRoman(String arabicNumber) throws Exception {
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
                throw new Exception("В справочнике нет нужного числа");
        }

        return r;
    }*/

    static List<String> romanList = Arrays.asList("N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
            "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII",
            "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV",
            "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
            "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
            "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV",
            "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
            "XCVII", "XCVIII", "XCIX", "C");

    static String replaceArabicNumberToRoman(String arabicNumber) throws Exception {
        String result;
        int number = Integer.parseInt(arabicNumber);

        if(number < 0 || number > 100) {
            throw new Exception("Число должно быть не менее 0 и не более 100");
        }

        result = romanList.get(number);

        return result;
    }



    static Boolean checkForRoman(String str) {
        String patternStr = "I|V|X|L|C";
        return Pattern.compile(patternStr).matcher(str).find();
    }
    public static String calc(String input) throws Exception {
        // Надо выкинуть из строки пробелы
        String formatInput = input.replaceAll(" ", "");

        // Проверить на римские чисел
        if(checkForRoman(formatInput)) {
            // итак римские цифры есть
            // получить операнды и оператор для римских чисел
            String patternRomanStr = "^([I|V|X|L|C]+)([^I|V|X|L|C])([I|V|X|L|C]+)$";
            Pattern patternRoman = Pattern.compile(patternRomanStr);
            Matcher matcher = patternRoman.matcher(formatInput);

            if (matcher.find())
            {
                try {
                    String operand1 = matcher.group(1);
                    String operator = matcher.group(2);
                    String operand2 = matcher.group(3);

                    String resultString = eval(replaceRomanNumber(operand1), operator, replaceRomanNumber(operand2));

                    // сделать мат операцию
                    return replaceArabicNumberToRoman(resultString);
                } catch (Exception e) {
                    System.out.println("Ошибка при вычислении выражения: " + e.getMessage());
                }
            } else {
                throw new Exception("Оба операнда должны быть в одной системе исчисления  и количество операндов должно быть строго 2");
            }
        } else {
            // получить операнды и оператор для арабских чисел
            String patternStr = "^(\\d+)(\\D)(\\d+)$";
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(formatInput);

            if (matcher.find())
            {
                try {
                    String operand1 = matcher.group(1);
                    String operator = matcher.group(2);
                    String operand2 = matcher.group(3);

                    if(Integer.parseInt(operand1) < 1 || Integer.parseInt(operand2) < 1 || Integer.parseInt(operand1) > 10 || Integer.parseInt(operand2) > 10) {
                        throw new Exception("Оба операнда должны быть не более 10 и не менее 1-го");
                    }

                    // сделать мат операцию
                    String resultString = eval(operand1, operator, operand2);
                    return resultString;
                } catch (Exception e) {
                    System.out.println("Ошибка при вычислении выражения: " + e.getMessage());
                }
            } else {
                throw new Exception("Оба операнда должны быть в одной системе исчисления и количество операндов должно быть строго 2");
            }
        }

        return input;
    }

}
