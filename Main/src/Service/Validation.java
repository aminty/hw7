package Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {


    public int checkInt(String input){
        Pattern pt=Pattern.compile("^\\d{1}$");
        Matcher mt=pt.matcher(String.valueOf(input));
        if (mt.matches())
            return Integer.parseInt(input);

        return 0;
    }


}
