package Service;

public class Menu {

    public void runFirstMenu(){
        boolean flag=true;
        while (flag){
            PrintMessage.printMenu(new String[]{"Login", "Sign up","Show article","Exit"});
        }



    }

}
