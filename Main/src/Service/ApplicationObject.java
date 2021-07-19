package Service;

import Entity.Category;
import Entity.User;
import Repository.ArticleRepo;
import Repository.CategoryRepo;
import Repository.TagRepo;
import Repository.UserRepo;

import java.security.PublicKey;
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
    public static final String[] AUTHOR_MENU = {"Publish new", "Edit Article", "Show my article", "Charge creadit", "Unpublished", "Change info", "Exit"};
    public static final String[] ADMIN_AUTHOR_MENU = {"Publish new", "Edit Article", "Show my article", "Charge creadit", "Unpublished", "Change info", "Exit", "Account managment"};
    public static final String [] PUBLIC_MENU={"Login", "Sign up", "Show article", "Charge creadit", "Exit"};
    public static final String [] EDIT_INFO_MENU={"Edit username", "Change password", "Delete Account", "Exit"};

    private static Connection connection = new DatabaseInitiator().getCreatedConnection();
    private static Menu menu = new Menu();
    private static Validation validation = new Validation();
    private static UserMenu userMenu = new UserMenu();
    private static UserRepo userRepo = new UserRepo();

    public static Connection getConnection() {
        return connection;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static Validation getValidation() {
        return validation;
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
