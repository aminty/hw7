package Service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Service.ApplicationObject.DECIMAL_REGEX;

public class Validation {

    public int checkItemSelectValue(String input) {
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
        while (true) {
            System.out.printf(" - %s ", message);
            String value = sc.nextLine().trim();
            if (value.equals("0"))break;
            if (isValidData(value,regex)) {
                flag = false;
                return value;
            }else
            PrintMessage.printError("Invalid format , Try again !");
        }
        return "Untitled";
    }

    public boolean checkInteger(String id) {
        Pattern pt = Pattern.compile(DECIMAL_REGEX);
        Matcher mt = pt.matcher(id);
        return mt.matches();
    }

    public boolean yesOrNoQuestion(String message,String regex){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.printf(" - %s ", message);
            String value = sc.next().trim();
            if (value.equals("0"))break;
            if (isValidData(value,regex)) {
                if (value.equals("yes")){
                    flag = false;
                    return true;
                }else if (value.equals("no")){
                    flag = false;
                    return false;
                }

            }else
                PrintMessage.printError("Invalid format , Try again !");
        }
        return false;
    }









}
