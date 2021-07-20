package service.menu;

import entity.User;
import service.ApplicationObject;
import service.PrintMessage;

import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu implements UserMenuInterface {
    @Override
    public void signUp() throws SQLException {
        User user = new User();
        System.out.println("-+-+-+-+-+-+-+ S I G N U P -+-+-+-+-+-+-+-+");
        user.setFirstName(ApplicationObject.getValidation().entryData("What's your name : ", ApplicationObject.NAME_REGEX));
        user.setLastName(ApplicationObject.getValidation().entryData("What's your last name : ", ApplicationObject.LAST_NAME_REGEX));
       /*
        For check nat code in db
        */
        while (true) {
            String natCode = ApplicationObject.getValidation().entryData("What's your nationalCode :",
                    ApplicationObject.NAT_CODE_REGEX);
            if (!ApplicationObject.getUserRepo().isNatioalCodeExist(natCode)) {
                user.setNationalCode(natCode);
                break;
            } else PrintMessage.printError("This national code is exist !");
        }
        user.setBirthday(ApplicationObject.getValidation().entryData("Ente your birth day (13xx-xx-xx): ", ApplicationObject.DATE_REGEX));
        /*
        For check username in db
        */
        while (true) {
            String username = ApplicationObject.getValidation().entryData("Choose an username : ", ApplicationObject.USERNAME_REGEX);
            if (!ApplicationObject.getUserRepo().isUsernameExist(username)) {
                user.setUsername(username);
                break;
            } else PrintMessage.printError("This username was taken !");
        }
        System.out.println(" ** NOTE: Your password is your national code. ** ");
        user.setPassword(user.getNationalCode());
        user.setCreadit(Integer.parseInt(ApplicationObject.getValidation().entryData("How much do you want charge your account ?", ApplicationObject.DECIMAL_REGEX)));
        ApplicationObject.getUserRepo().addNewUser(user);
    }

    @Override
    public void Login() throws SQLException {
        System.out.println("-+-+-+-+-+-+-+ L O G I N -+-+-+-+-+-+-+-+");
        //TODO why new user is grayout
        User user = new User();
        String username, password;
        System.out.print(" - Enter your username : ");
        username = new Scanner(System.in).next();
        System.out.print(" - Enter your password : ");
        password = new Scanner(System.in).next();
        if (ApplicationObject.getUserRepo().isUsernameExist(username)) {
            user = ApplicationObject.getUserRepo().getUserInfo(username);
            if (user.getPassword().equals(password) && user.getUsername().equals(username)) {
                if (user.isApprove()) {
                    ApplicationObject.getMenu().runAuthorMenu(user);
                } else PrintMessage.printMsg("Your account does not approved yet !");
            } else PrintMessage.printError("Username or password is incorrect !");
        } else PrintMessage.printError("This account was not found !");
    }

    @Override
    public void chargeCreadit() throws SQLException {
        System.out.print(" - Enter your username : ");
        String username = new Scanner(System.in).next();
        if (ApplicationObject.getUserRepo().isUsernameExist(username)) {
            int currentBalance = ApplicationObject.getUserRepo().getCreadit(username);
            PrintMessage.printMsg
                    ("Your current balance is " +
                            currentBalance + " tomans.");
            System.out.print(" - How much do you want charge your account ? ");
            int price = new Scanner(System.in).nextInt();
            ApplicationObject.getUserRepo().updateCreadit(username, price, currentBalance);
        } else PrintMessage.printError("This username does not found !");
    }

    @Override
    public void chargeCreadit(String username) throws SQLException {
        int currentBalance = ApplicationObject.getUserRepo().getCreadit(username);
        PrintMessage.printMsg
                ("Your current balance is " +
                        currentBalance + " tomans.");
        System.out.print(" - How much do you want charge your account ? ");
        int price = new Scanner(System.in).nextInt();
        ApplicationObject.getUserRepo().updateCreadit(username, price, currentBalance);


    }

    @Override
    public void changeUsername(int id) throws SQLException {

        while (true) {
            String username = ApplicationObject.getValidation().entryData("Choose an username : ", ApplicationObject.USERNAME_REGEX);
            if (!username.equals("Untitled")) {
                if (!ApplicationObject.getUserRepo().isUsernameExist(username)) {
                    ApplicationObject.getUserRepo().setUserPassUpdate(id, "username", username);
                    break;
                } else PrintMessage.printError("This username was taken !");
            } else break;
        }
    }

    @Override
    public void changePassword(int id) throws SQLException {
        String password = ApplicationObject.getValidation().entryData("Choose a password : ", ApplicationObject.PASSWORD_REGEX);
        if (!password.equals("Untitled"))
            ApplicationObject.getUserRepo().setUserPassUpdate(id, "password", password);

    }

    @Override
    public void removeAccount(int id) throws SQLException {
        ApplicationObject.getUserRepo().deleteAccount(id);

    }

    public void approveAccount() throws SQLException {
        ApplicationObject.getUserRepo().getUnApprovedAccount();
        if (ApplicationObject.getValidation().yesOrNoQuestion("Do you want approve any account ? (yes/no) ",
                "(^yes$)|(^no$)")) {
            System.out.print(" - Enter account id :");
            String user_id = new Scanner(System.in).next();
            if (ApplicationObject.getValidation().checkInteger(user_id)) {
                if (ApplicationObject.getUserRepo().isUserExist(Integer.parseInt(user_id))) {
                    ApplicationObject.getUserRepo().setApproveAccount(Integer.parseInt(user_id));
                } else PrintMessage.printError("This user does not exist !");
            }
        }


    }

    public void blockAccount() throws SQLException {
        ApplicationObject.getUserRepo().getActiveAccount();
        if (ApplicationObject.getValidation().yesOrNoQuestion("Do you want block any account ? (yes/no) ",
                "(^yes$)|(^no$)")) {
            System.out.print(" - Enter account id :");
            String user_id = new Scanner(System.in).next();
            if (ApplicationObject.getValidation().checkInteger(user_id)) {
                if (ApplicationObject.getUserRepo().isUserExist(Integer.parseInt(user_id))) {
                    ApplicationObject.getUserRepo().seBlockAccount(Integer.parseInt(user_id));
                } else PrintMessage.printError("This user does not exist !");
            }
        }


    }
}
