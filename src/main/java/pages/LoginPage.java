package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericActions;

public class LoginPage {
    private WebDriver driver;
    private GenericActions genericActions;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        genericActions = new GenericActions(driver);
    }

    private By lnk_Login =By.xpath("//a[@href='/login']");
    private By input_Email =By.name("email");
    private By input_Password =By.name("password");
    private By btn_Login =By.xpath("//button[@data-qa='login-button']");
    private By txt_LoggedUser = By.xpath("//i[@class='fa fa-user']/parent::a");
    private By txt_LoginErrorMsg = By.xpath("//form[@action='/login']/p");
    private By lnk_Logout =By.xpath("//a[@href='/logout']");

    public void clickLoginLink(){
        genericActions.click(lnk_Login);
    }
    public void clickLoginButton(){

        genericActions.click(btn_Login);
    }
    public void enterEmail(String email){
        genericActions.enterValue(input_Email,email);
    }
    public void enterPassword(String Password){
        genericActions.enterValue(input_Password,Password);
    }
    public void getUrl(String url){
        genericActions.getUrl(url);
    }
    public String getLoggedUserTxt(){
        genericActions.waitUntilElementClickable(txt_LoggedUser,10);
        return genericActions.getText(txt_LoggedUser);
    }
    public String getLoginErrorMsgTxt(){
        genericActions.waitUntilElementClickable(txt_LoginErrorMsg,10);
        return genericActions.getText(txt_LoginErrorMsg);
    }
    public void clickLogoutLink(){
        genericActions.click(lnk_Logout);
    }
}
