package Service;

import Entity.User;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void runPublicMenu() throws SQLException {
        outer:
        {
            while (true) {
                System.out.println("--------------------------");
                PrintMessage.printMenu(ApplicationObject.PUBLIC_MENU);
                System.out.print("- Choose an item :");
                String selectedItem = new Scanner(System.in).next();
                switch (ApplicationObject.getValidation().checkInt(selectedItem)) {
                    case 0:
                        PrintMessage.printError("Wrong input !");
                        break;
                    case 1:
                        ApplicationObject.getUserMenu().Login();
                        break;
                    case 2:
                        ApplicationObject.getUserMenu().signUp();
                        break;
                    case 3:
                        //todo show and reduce wallet article
                        break;
                    case 4:
                        ApplicationObject.getUserMenu().chargeCreadit();
                        break;
                    case 5:
                        PrintMessage.printMsg("See you later ");
                        break outer;
                    default:
                        PrintMessage.printError("Wrong input !");
                        break;
                }
            }
        }
    }


    public void runAuthorMenu(User user) throws SQLException {
        outer:
        {
            while (true) {
                System.out.println("--------------------------");
                PrintMessage.printMsg("Hello dear " + user.getFirstName());
                if (user.isAdmin())
                    PrintMessage.printMenu(ApplicationObject.ADMIN_AUTHOR_MENU);
                else PrintMessage.printMenu(ApplicationObject.AUTHOR_MENU);
                System.out.print("- Choose an item :");
                String selectedItem = new Scanner(System.in).next();
                switch (ApplicationObject.getValidation().checkInt(selectedItem)) {
                    case 0:
                        PrintMessage.printError("Wrong input !");
                        break;
                    case 1:
                        ApplicationObject.getArticleMenu().PublishNewOne(user.getId());
                        break;
                    case 2:
                        //todo edit my  article
                        break;
                    case 3:
                        //todo show my article
                        break;
                    case 4:
                        ApplicationObject.getUserMenu().chargeCreadit(user.getUsername());
                        break;
                    case 5:
                        //todo unpublished article
                        break;
                    case 6:
                        runEditInfoMenu(user);
                        if (!ApplicationObject.getUserRepo().isUserExist(user.getId())) break outer;
                        break ;
                    case 7:
                        PrintMessage.printMsg("See you later ");
                        break outer;
                    case 8:
                        if (user.isAdmin()) {
                            //Todo approve or block account.
                        }
                        break;
                    default:
                        PrintMessage.printError("Wrong input !");
                        break;
                }
            }
        }
    }

    public void runEditInfoMenu(User user) throws SQLException {
        outer:{
            while (true) {
                System.out.println("--------------------------");
                PrintMessage.printMenu(ApplicationObject.EDIT_INFO_MENU);
                System.out.print("- Choose an item :");
                String selectedItem = new Scanner(System.in).next();
                switch (ApplicationObject.getValidation().checkInt(selectedItem)) {
                    case 0:
                        PrintMessage.printError("Wrong input !");
                        break;
                    case 1:
                        ApplicationObject.getUserMenu().changeUsername(user.getId());
                        break;
                    case 2:
                        ApplicationObject.getUserMenu().changePassword(user.getId());
                        break ;
                    case 3:
                        ApplicationObject.getUserMenu().removeAccount(user.getId());
                        break outer;
                    case 4:
                        break outer;
                    default:
                        PrintMessage.printError("Wrong input !");
                        break;


                }
            }
        }
    }
}
