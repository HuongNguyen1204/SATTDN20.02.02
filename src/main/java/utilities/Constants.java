package utilities;

public class Constants {

    //Common
    public static final int TIMES_WAIT_ELEMENTS = 10;
    public static final String WELCOME = "Welcome ";
    public static final int TIME_WAITS_DRIVER = 15;
    public static final int NUM_RANDOM_START = 1;
    public static final int DATE_FROM_CURRENT_DATE = 8;

    //Login Page
    public static final String BASE_URL = "http://railwayqa.somee.com/Page/HomePage.cshtml";
    public static final String VALID_EMAIL = "trasuaokinawa@gmail.com";
    public static final String VALID_PASSWORD = "11111111";
    public static final String INVALID_EMAIL = "trasuaolong";
    public static final String INVALID_PASSWORD = "1111";
    public static final String ERROR_MESSAGE = "Invalid username or password. Please try again.";
    public static final String ERROR_SEVERAL_TIMES_LOGIN = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
    public static final int SEVERAL_TIMES_LOGIN = 5;

    //Menu header
    public static final String LOGIN_TAB = "Login";
    public static final String REGISTER_TAB = "Register";
    public static final String BOOK_TICKET_TAB = "Book ticket";
    public static final String MY_TICKET_TAB = "My ticket";
    public static final String TICKET_PRICE_TAB = "Ticket price";
    public static final String LOG_OUT_TAB = "Log out";
    public static final String CHANGE_PASSWORD_TAB = "Change password";
    public static final String CONTACT_TAB = "Contact";

    //Register page
    public static final String ERROR_INVALID_EMAIL = "You must specify a username.";
    public static final String ERROR_INVALID_PASSWORD = "You must specify a password.";
    public static final String ERROR_FORM_LOGIN = "There was a problem with your login and/or errors exist in your form.";
    public static final String TITLE_REGISTER_PAGE = "Create account";
    public static final String LINK_REGISTER_PAGE = "Registration Page";
    public static final String LINK_FORGOT_PASSWORD = "Forgot Password page";
    public static final String TITLE_FORGOT_PASSWORD_FORM = "Password Reset Instructions Form";
    public static final String VALID_PASSPORT_NUMBER = "11111111";
    public static final String REGISTER_SUCCESS = "Registration Confirmed! You can now log in to the site.";

    //Contact
    public static final String EMAIL_CONTACT = "mailto:thanh.viet.le@logigear.com";

    //My Tickets
    public static final String MANAGER_TICKETS_TITLE = "Manage Tickets";

    //Reset password page
    public static final String CHANGE_PASSWORD_TITLE = "Change password";
    public static final String MESSAGE_RESET_PASS_SUCCESS = "Instructions to reset your password have been sent to trasuaokinawa@gmail.com.";
    public static final String ERROR_MESSAGE_RESET_PASS = "This email address doesn't exist.";

    // Book Ticket page
    public static final String ERROR_AMOUNT_TICKETS = "You have booked 10 tickets. You can book no more.";
    public static final String TEN_TICKETS = "10";
    public static final String HARD_SEAT = "Hard seat";
    public static final String ONE_TICKET = "1";
    public static final String EMAIL_BOOK_TICKETS = "trasuaolong123@gmail.com";
}
