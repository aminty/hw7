package Service;

import Entity.Article;
import Entity.Tag;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static Service.ApplicationObject.DECIMAL_REGEX;

public class ArticleMenu {
    public void PublishNewOne(int id) throws SQLException {
        Date date = new Date();
        Article article = new Article();
        System.out.println("-+-+-+-+-+-+-+ A D D - A R T I C L E -+-+-+-+-+-+-+-+");
        article.setUserId(id);
        article.setCategory_id(checkCategory());
        article.setTitle(setTitleForArticle());
        article.setBrief(getBriefForArticle());
        article.setContent(setContentForArticle());
        article.setIsFree(ApplicationObject.getValidation().yesOrNoQuestion("Do you want publish your article as free ?",
                "(^yes$)|(^no$)"));
        article.setPrice(!article.getIsFree() ?setPriceForArticle():0);
        article.setIsPublished(ApplicationObject.getValidation().yesOrNoQuestion("Do you want publish your article ?",
                "(^yes$)|(^no$)"));

        article.setCreatedDate(new Timestamp(date.getTime()));
        article.setPublishedDate(new Timestamp(date.getTime()));
        article.setLastUpdateDate(new Timestamp(date.getTime()));

        ApplicationObject.getArticleRepo().addNewArticle(article);

        article.setTags(setTgForArticle());
        for (int i: article.getTags()) {
            ApplicationObject.getTagRepo().takenTagByArticle(id,
                    getArticleId(article.getTitle())
                    ,i);

        }
        PrintMessage.printMsg("Your article wrote successfuly .");


    }

    private int getArticleId(String title) throws SQLException {
        return ApplicationObject.getArticleRepo().getId(title);
    }

    private int[] setTgForArticle() throws SQLException {
        ArrayList<Integer> listTagId=new ArrayList<>();
        ApplicationObject.getTagRepo().getTagTable();
        if (ApplicationObject.getValidation().yesOrNoQuestion("Do you want to add new tag ? (yes/no) ",
                "(^yes$)|(^no$)")) {
            addNewTag();
            return setTgForArticle();
        }else
        while (true) {
            ApplicationObject.getTagRepo().getTagTable();
            System.out.print(" - Choose a tag : ");
            String tag_id = new Scanner(System.in).next();
            if (tag_id.equals("0"))break;
            if (ApplicationObject.getValidation().checkInteger(tag_id)) {
                if (ApplicationObject.getCategoryRepo().isCategoryExist(Integer.parseInt(tag_id))){
                    if (!listTagId.contains(Integer.parseInt(tag_id))){
                    listTagId.add(Integer.parseInt(tag_id));}
            }else {
                    PrintMessage.printError("This category does not exsit !");
                    if (ApplicationObject.getValidation().yesOrNoQuestion("Do you want to add new category ? (yes/no) ",
                            "(^yes$)|(^no$)")) {
                        addNewTag();
                    }else break;
                }
            } else {
                PrintMessage.printError("Invalid format !");
                if( ApplicationObject.getValidation().yesOrNoQuestion("Do you want to add new category ? (yes/no) ",
                        "(^yes$)|(^no$)")) {
                    addNewTag();
                    int[] arr = listTagId.stream().mapToInt(i -> i).toArray();
                    return arr;
                }
            }
        }
        int[] arr = listTagId.stream().mapToInt(i -> i).toArray();
        return arr;
    }

    private void addNewTag() throws SQLException {
        while (true) {
            ApplicationObject.getTagRepo().getTagTable();
            System.out.print(" - Enter your tag : ");
            String tag = new Scanner(System.in).nextLine();
            if (tag.equals("0")) break;
            if (!ApplicationObject.getTagRepo().isTagExist(tag)) {
                ApplicationObject.getTagRepo().addNewTag(tag);
                break;
            } else {
                PrintMessage.printError("This tag is exist !");
                setTgForArticle();
            }
        }
    }

    private int setPriceForArticle() {
        String price=ApplicationObject.getValidation().entryData("How much is your price ?",DECIMAL_REGEX);
        return Integer.parseInt(price);
    }

    private String setContentForArticle() {
        System.out.print(" - Write your content : ");
        return new Scanner(System.in).nextLine();
    }

    private String getBriefForArticle() {
        System.out.print(" - Write a brief : ");
        return new Scanner(System.in).nextLine();

    }

    private String setTitleForArticle() throws SQLException {
        while (true) {
            System.out.print(" - Enter your title : ");
            String title = new Scanner(System.in).nextLine();
            if (!ApplicationObject.getArticleRepo().isTitleExist(title)) {
                return title;
            } else PrintMessage.printError("This title is exist !");
        }
    }

    private int checkCategory() throws SQLException {
        ApplicationObject.getCategoryRepo().getCategoryTable();
        if (ApplicationObject.getValidation().yesOrNoQuestion("Do you want to add new category ? (yes/no) ",
                "(^yes$)|(^no$)")) {
            addNewCategory();
            return checkCategory();
        }
        while (true) {
            System.out.print(" - Choose a category : ");
            String category_id = new Scanner(System.in).next();
            if (category_id.equals("0"))break;
            if (ApplicationObject.getValidation().checkInteger(category_id)) {
                if (ApplicationObject.getCategoryRepo().isCategoryExist(Integer.parseInt(category_id)))
                    return Integer.parseInt(category_id);
                else {
                    PrintMessage.printError("This category does not exsit !");
                    if (ApplicationObject.getValidation().yesOrNoQuestion("Do you want to add new category ? (yes/no) ",
                            "(^yes$)|(^no$)")) {
                        addNewCategory();
                        return checkCategory();
                    }
                }
            } else {
                PrintMessage.printError("Invalid format !");
                if( ApplicationObject.getValidation().yesOrNoQuestion("Do you want to add new category ? (yes/no) ",
                        "(^yes$)|(^no$)")) {
                    addNewCategory();
                    return checkCategory();
                }
            }
        }
        return 1;
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
