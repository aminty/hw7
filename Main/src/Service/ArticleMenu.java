package Service;

import Entity.Article;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleMenu {
    public void PublishNewOne(int id) throws SQLException {
        Article article = new Article();
        System.out.println("-+-+-+-+-+-+-+ A D D - A R T I C L E -+-+-+-+-+-+-+-+");
        article.setCategory_id(checkCategory());
        article.setTitle(checkTitle());


    }

    private String checkTitle() throws SQLException {
        while (true){
            System.out.print(" - Enter your title : ");
            String title=new Scanner(System.in).nextLine();
            if (!ApplicationObject.getArticleRepo().isTitleExist(title)){
                return title;
            }
            else PrintMessage.printError("This title is exist !");
        }
    }
    private int checkCategory() throws SQLException {
        ApplicationObject.getCategoryRepo().getCategoryTable();
        switch (ApplicationObject.getValidation().entryData("Do you want to add new category ? (yes/no) ",
                "(^yes$)|(^no$)")) {
            case "yes":
                addNewCategory();
                return checkCategory();
            case "no":
                break;
            default:
                PrintMessage.printError("Invalid entry !");
        }
        while (true) {
            System.out.print(" - Choose a category : ");
            String category_id = new Scanner(System.in).next();
            if (ApplicationObject.getValidation().checkId(category_id)) {
                if (ApplicationObject.getCategoryRepo().isCategoryExist(Integer.parseInt(category_id)))
                    return Integer.parseInt(category_id);
                else {
                    PrintMessage.printError("This category does not exsit !");
                    switch (ApplicationObject.getValidation().entryData("Do you want to add new category ? (yes/no) ",
                            "(^yes$)|(^no$)")) {
                        case "yes":
                            addNewCategory();
                            return checkCategory();
                        case "no":
                            return checkCategory();
                        default:
                            PrintMessage.printError("Invalid entry !");
                    }
                }
            } else {
                PrintMessage.printError("Invalid format !");
                switch (ApplicationObject.getValidation().entryData("Do you want to add new category ? (yes/no) ",
                        "(^yes$)|(^no$)")) {
                    case "yes":
                        addNewCategory();
                        return checkCategory();
                    case "no":
                        return checkCategory();
                    default:
                        PrintMessage.printError("Invalid entry !");
                }
            }
        }
    }
    private void addNewCategory() throws SQLException {
        while (true) {
            System.out.print(" - Enter your category : ");
            String category = new Scanner(System.in).nextLine();
            if (category.equals("0")) break;
            if (!ApplicationObject.getCategoryRepo().isCategoryExist(category)) {
                ApplicationObject.getCategoryRepo().addNewCategory(category);
                break;
            } else {
                PrintMessage.printError("This category is exist !");
                checkCategory();
            }
        }
    }
}
