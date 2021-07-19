package Service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public int checkInt(String input) {
        Pattern pt = Pattern.compile("^\\d{1}$");
        Matcher mt = pt.matcher(String.valueOf(input));
        if (mt.matches())
            return Integer.parseInt(input);

        return 0;
    }

    public boolean isValidData(String input, String regex) {
        Pattern pt = Pattern.compile(regex);
        Matcher mt = pt.matcher(input);
        if (mt.matches())
            return true;
        return false;
    }

    public String entryData(String message,String regex) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.printf(" - %s ", message);
            String value = sc.nextLine().trim();
            if (isValidData(value,regex)) {
                flag = false;
                return value;
            }
            PrintMessage.printError("Invalid format , Try again !");
        }

        return "Untitled";
    }




}
