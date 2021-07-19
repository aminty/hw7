package Service;

public class PrintMessage {
    public static void printMsg(String message) {
        System.out.println("|-----------------------------");
        System.out.println("|>>> "+message);
        System.out.println("|-----------------------------");


    }


    public static void printMenu(String [] items){

        for (int i=0;i< items.length; i++) {
            System.out.printf(" [%d] - %s \n",i+1,items[i]);
        }

    }
}
