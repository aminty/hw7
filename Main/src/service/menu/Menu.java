package service.menu;

import entity.User;
import service.ApplicationObject;
import service.PrintMessage;

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
                switch (ApplicationObject.getValidation().checkItemSelectValue(selectedItem)) {
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
                        ApplicationObject.getArticleMenu().showArticleInPublic();
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
                switch (ApplicationObject.getValidation().checkItemSelectValue(selectedItem)) {
                    case 0:
                        PrintMessage.printError("Wrong input !");
                        break;
                    case 1:
                        ApplicationObject.getArticleMenu().PublishNewOne(user.getId());
                        break;
                    case 2:
                        ApplicationObject.getArticleMenu().editArticle(user.getId());
                        break;
                    case 3:
                        ApplicationObject.getArticleMenu().showMyArticle(user.getId());
                        break;
                    case 4:
                        ApplicationObject.getUserMenu().chargeCreadit(user.getUsername());
                        break;
                    case 5:
                        runStatusArticle();
                        break;
                    case 6:
                        runEditInfoMenu(user);
                        if (!ApplicationObject.getUserRepo().isUserExist(user.getId())) break outer;
                        break;
                    case 7:
                        PrintMessage.printMsg("See you later ");
                        break outer;
                    case 8:
                        if (user.isAdmin()) {
                            runManageAccount();
                        }
                        break;
                    default:
                        PrintMessage.printError("Wrong input !");
                        break;
                }
            }
        }
    }

    private void runManageAccount() throws SQLException {
        outer:
        {
            while (true) {
                System.out.println("--------------------------");
                PrintMessage.printMenu(ApplicationObject.MANAGE_ACCOUNT);
                System.out.print("- Choose an item :");
                String selectedItem = new Scanner(System.in).next();
                switch (ApplicationObject.getValidation().checkItemSelectValue(selectedItem)) {
                    case 0:
                        PrintMessage.printError("Wrong input !");
                        break;
                    case 1:
                        ApplicationObject.getUserMenu().approveAccount();
                        break;
                    case 2:
                        ApplicationObject.getUserMenu().blockAccount();
                        break;
                    case 3:
                        break outer;
                }
            }
        }
    }

    private void runStatusArticle() throws SQLException {
        outer:
        {
            while (true) {
                System.out.println("--------------------------");
                PrintMessage.printMenu(ApplicationObject.CHANGE_STATUS);
                System.out.print("- Choose an item :");
                String selectedItem = new Scanner(System.in).next();
                switch (ApplicationObject.getValidation().checkItemSelectValue(selectedItem)) {
                    case 0:
                        PrintMessage.printError("Wrong input !");
                        break;
                    case 1:
                        ApplicationObject.getArticleMenu().setPublic();
                        break;
                    case 2:
                        ApplicationObject.getArticleMenu().setPrivate();
                        break;
                    case 3:
                        break outer;
                }
            }
        }
    }

    public void runEditInfoMenu(User user) throws SQLException {
        outer:
        {
            while (true) {
                System.out.println("--------------------------");
                PrintMessage.printMenu(ApplicationObject.EDIT_INFO_MENU);
                System.out.print("- Choose an item :");
                String selectedItem = new Scanner(System.in).next();
                switch (ApplicationObject.getValidation().checkItemSelectValue(selectedItem)) {
                    case 0:
                        PrintMessage.printError("Wrong input !");
                        break;
                    case 1:
                        ApplicationObject.getUserMenu().changeUsername(user.getId());
                        break;
                    case 2:
                        ApplicationObject.getUserMenu().changePassword(user.getId());
                        break;
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
