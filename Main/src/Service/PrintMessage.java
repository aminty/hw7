package Service;

public class PrintMessage {
    public static void printMsg(String message) {
        System.out.println(
                "|>>> "+message
        );

    }
    public static void printMenu(String [] items){
        for (int i=0;i< items.length; i++) {
            System.out.printf(" [%d] - %s ",i+1,items[i]);
        }

    }
}
