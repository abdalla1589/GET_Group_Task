package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
    WebDriver driver;
    public SignupPage(WebDriver driver)
    {
        this.driver=driver;
    }
    private By firstName = By.id("nf-field-17");
    private By lastName = By.id("nf-field-18");
    private By selectCourse = By.id("nf-field-22");
    private By selectMonth = By.id("nf-field-24");
    private By radiobutton = By.id("nf-label-class-field-23-3");
    private By phone = By.id("nf-field-20");
    private By emailAddress = By.id("nf-field-19");
   // private By password = By.id("password");
   // private By captcha = By.xpath("//div[@class='recaptcha-checkbox-border']");
    private By registerButton=By.id("nf-field-15");
    public void setfirstName(String user)
    {
        driver.findElement(firstName).sendKeys(user);
    }
    public void setlastName(String user)
    {
        driver.findElement(lastName).sendKeys(user);
    }
    public void setPhone(String user)
    {
        driver.findElement(phone).sendKeys(user);
    }
    public void setEmailAddress(String user)
    {
        driver.findElement(emailAddress).sendKeys(user);
    }
    /*public void setPassword(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }
    private void clickOnCaptcha(String pass)
    {
        driver.findElement(captcha).click();
    }*/
   public void setCourse(String option)
   {
       Select country = new Select(driver.findElement(selectCourse));
       country.selectByValue(option);
   }
    public void setMonth(String option)
    {
        Select country = new Select(driver.findElement(selectMonth));
        country.selectByValue(option);
    }
   public void clickOnradiobutton()
   {
       driver.findElement(radiobutton).click();
   }
    public LoginPage clickOnRegister()
    {
        driver.findElement(registerButton).click();
        return new LoginPage(driver);

    }
}

