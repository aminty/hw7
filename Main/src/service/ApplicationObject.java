package service;

import repository.ArticleRepo;
import repository.CategoryRepo;
import repository.TagRepo;
import repository.UserRepo;
import service.menu.ArticleMenu;
import service.menu.Menu;
import service.menu.UserMenu;

import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationObject {
    public static final String DATE_REGEX = "(^[12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$";
    public static final String NAME_REGEX = "^[A-Za-z]*";
    public static final String LAST_NAME_REGEX = "^[A-Za-z]*";
    public static final String NAT_CODE_REGEX = "^\\d{10}$";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    public static final String USERNAME_REGEX = "^[A-Za-z]\\w{5,29}$";
    public static final String DECIMAL_REGEX = "^\\d+$";
    public static final String[] AUTHOR_MENU = {"Publish new", "Edit Article", "Show my article", "Charge creadit", "Change article status", "Change info", "Exit"};
    public static final String[] ADMIN_AUTHOR_MENU = {"Publish new", "Edit Article", "Show my article", "Charge creadit", "Change article status", "Change info", "Exit", "Account managment"};
    public static final String[] PUBLIC_MENU = {"Login", "Sign up", "Show article", "Charge creadit", "Exit"};
    public static final String[] EDIT_INFO_MENU = {"Edit username", "Change password", "Delete Account", "Exit"};
    public static final String[] MANAGE_ACCOUNT = {"Approve account", "Block Account", "Exit"};
    public static final String[] CHANGE_STATUS = {"Make public", "Make private", "Exit"};

    private static Connection connection = new DatabaseInitiator().getCreatedConnection();
    private static Menu menu = new Menu();
    private static Validation validation = new Validation();
    private static UserMenu userMenu = new UserMenu();
    private static ArticleMenu articleMenu = new ArticleMenu();
    private static UserRepo userRepo = new UserRepo();
    private static ArticleRepo articleRepo = new ArticleRepo();
    private static CategoryRepo categoryRepo = new CategoryRepo();
    private static TagRepo tagRepo = new TagRepo();

    public static CategoryRepo getCategoryRepo() {
        return categoryRepo;
    }

    public static TagRepo getTagRepo() {
        return tagRepo;
    }

    public static ArticleRepo getArticleRepo() {
        return articleRepo;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static Validation getValidation() {
        return validation;
    }

    public static ArticleMenu getArticleMenu() {
        return articleMenu;
    }

    public static UserMenu getUserMenu() {
        return userMenu;
    }

    public static UserRepo getUserRepo() {
        return userRepo;
    }

    public static void tableCreator() throws SQLException {
        new UserRepo().createUserTable();
        new TagRepo().createTagTable();
        new CategoryRepo().createCategoryTable();
        new ArticleRepo().createArticleTable();
        new TagRepo().createTakenTag();
    }

}
