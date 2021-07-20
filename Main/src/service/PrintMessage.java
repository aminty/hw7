package service;

import entity.Article;

public class PrintMessage {
    public static void printMsg(String message) {
        System.out.println(">>> " + message);
    }

    public static void printError(String message) {
        System.out.println("|>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + message);


    }

    public static void printMenu(String[] items) {

        for (int i = 0; i < items.length; i++) {
            System.out.printf(" [%d] - %s \n", i + 1, items[i]);
        }

    }

    public static void printArticle(Article article) {
        System.out.println("********************************");
        System.out.println("title : " + article.getTitle());
        System.out.println("brief : " + article.getBrief());
        System.out.println("content : " + article.getContent());
        System.out.println("********************************");

    }
}
