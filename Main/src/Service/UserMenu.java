package Service;

import Entity.User;

public class UserMenu {
    public User signUp(){
        boolean flag=true;
        User user=new User();
        System.out.println("-+-+-+-+-+-+-+ S I G N U P -+-+-+-+-+-+-+-+");
        user.setFirstName(ApplicationObject.getValidation().entryData("What's your name : ",
                ApplicationObject.NAME_REGEX));
        user.setLastName(ApplicationObject.getValidation().entryData("What's your last name : ",
                ApplicationObject.LAST_NAME_REGEX));
        user.setNationalCode(ApplicationObject.getValidation().entryData("What's your nationalCode :",
                ApplicationObject.NAT_CODE_REGEX));
        user.setBirthday(ApplicationObject.getValidation().entryData("Ente your birth day (13xx-xx-xx): ",
                ApplicationObject.DATE_REGEX));
        user.setUsername(ApplicationObject.getValidation().entryData("Choose an username : ",
               ApplicationObject.USERNAME_REGEX ));
        System.out.println("- NOTE: Your password is your national code. ");
        user.setPassword(user.getNationalCode());
        user.setCreadit(Integer.parseInt(ApplicationObject.getValidation().entryData("How much do you want charge your account ?",
                ApplicationObject.DECIMAL_REGEX)));


        return user;
    }
}
