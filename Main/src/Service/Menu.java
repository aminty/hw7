package Service;

import java.util.Scanner;

public class Menu {

    public void runPublicMenu() {
        outer:
        {
            while (true) {
                PrintMessage.printMenu(new String[]{"Login",
                        "Sign up",
                        "Show article",
                        "Charge Creadit",
                        "Exit"});
                System.out.print("- Choose an item :");
                String selectedItem = new Scanner(System.in).next();
                switch (ApplicationObject.getValidation().checkInt(selectedItem)) {
                    case 0:
                        PrintMessage.printError("Wrong input !");
                        break;
                    case 1:
                        break;
                    case 2:
                        ApplicationObject.getUserMenu().signUp();
                        break;
                    case 3:
                        break;
                    case 4:
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

}
