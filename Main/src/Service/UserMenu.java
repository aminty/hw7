package Service;

import Entity.User;

import java.sql.SQLException;

public class UserMenu {
    public User signUp() throws SQLException {
        User user = new User();
        System.out.println("-+-+-+-+-+-+-+ S I G N U P -+-+-+-+-+-+-+-+");
        user.setFirstName(ApplicationObject.getValidation().entryData("What's your name : ",
                ApplicationObject.NAME_REGEX));
        user.setLastName(ApplicationObject.getValidation().entryData("What's your last name : ",
                ApplicationObject.LAST_NAME_REGEX));
        while (true) {
            String natCode = ApplicationObject.getValidation().entryData("What's your nationalCode :",
                    ApplicationObject.NAT_CODE_REGEX);
            if (!ApplicationObject.getUserRepo().isNatioalCodeExist(natCode)) {
                user.setNationalCode(natCode);
                break;
            } else PrintMessage.printError("This national code is exist !");
        }

        user.setBirthday(ApplicationObject.getValidation().entryData("Ente your birth day (13xx-xx-xx): ",
                ApplicationObject.DATE_REGEX));

        while (true) {
            String username = ApplicationObject.getValidation().entryData("Choose an username : ",
                    ApplicationObject.USERNAME_REGEX);
            if (!ApplicationObject.getUserRepo().isUsernameExist(username)) {
                user.setUsername(username);
                break;
            } else PrintMessage.printError("This username was taken !");
        }

        System.out.println("- NOTE: Your password is your national code. ");
        user.setPassword(user.getNationalCode());
        user.setCreadit(Integer.parseInt(ApplicationObject.getValidation().entryData("How much do you want charge your account ?",
                ApplicationObject.DECIMAL_REGEX)));

        ApplicationObject.getUserRepo().addNewUser(user);
        return user;
    }
}
