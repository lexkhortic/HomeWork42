package Task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralTask1 {
    public static void main(String[] args) {
        String numberPhone1 = "+375445915514";
        String numberPhone2 = "80294505349";

        System.out.println(choiceMethod(numberPhone1));
        System.out.println(choiceMethod(numberPhone2));
    }

    public static String choiceMethod(String numberPhone) {
        if (numberPhone.length() == 13){
            return refactorNumberWithPlus(numberPhone);
        } else if (numberPhone.length() == 11){
            return refactorNumberWithEight(numberPhone);
        } else {
            return "Проверьте длину номера!";
        }
    }

    public static String refactorNumberWithPlus(String number) {
        Pattern pattern = Pattern.compile("(\\+375)(44|29|33|25)(\\d{3})(\\d{2})(\\d{2})");
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
            return number.replaceAll(pattern.pattern(), "$1($2)***-$4-$5");
        } else {
            return "Введен не верный формат номера телефона!";
        }
    }

    public static String refactorNumberWithEight(String number) {
        Pattern pattern = Pattern.compile("(80)(44|29|33|25)(\\d{3})(\\d{2})(\\d{2})");
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
            return number.replaceAll(pattern.pattern(), "+375($2)***-$4-$5");
        } else {
            return "Введен не верный формат номера телефона!";
        }
    }

}
