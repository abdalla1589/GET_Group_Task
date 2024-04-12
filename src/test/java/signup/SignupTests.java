package signup;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class SignupTests extends BaseTest {
    private String firstName = "test";
    private String lastName = "Test";
    private String phone = "01063826650";
    private String email = "Test@gmail.com";
   // private String password = "Pass00rd";
    private String course = "manual-web-automation-selenium";
    private String month = "may";
    @Test
    public void verifyFirstNameMustStartWithCapitalLetter()
    {
        test = extent.createTest("verify first name","verify that first name start with capital letter");
        signupPage.setfirstName(firstName);
        Assert.assertTrue(checkCapitalLetter(firstName));
    }
    @Test
    public void verifyLastNameStartWithCapitalLetterAndNotEqualfirstName()
    {
        test = extent.createTest("verify last name","verify that last name start with capital letter And Not Equal first Name");
        signupPage.setlastName(lastName);
        Assert.assertTrue(checkCapitalLetterAndNotEqualFirstName(firstName,lastName));
    }
    @Test
    public void verifyMobileNumber()
    {
        test = extent.createTest("verify mobile number","verify that mobile number start with 0 and 11 numbers");
        signupPage.setPhone(phone);
        Assert.assertTrue(checkPhoneNumber(phone));
    }
    @Test
    public void verifyEmail()
    {
        test = extent.createTest("verify Email address","verify that email address contains @ and .com");
        signupPage.setEmailAddress(email);
        Assert.assertTrue(checkEmail(email));
    }
  @Test
  public void setRegistrationForm()
  {
      signupPage.setfirstName(firstName);
      signupPage.setlastName(lastName);
      signupPage.setEmailAddress(email);
      signupPage.setPhone(phone);
      signupPage.setCourse(course);
      signupPage.setMonth(month);
      signupPage.clickOnradiobutton();
      signupPage.clickOnRegister();

  }
    private Boolean checkCapitalLetter(String Name)
    {
        boolean isUpperCase = Character.isUpperCase(Name.charAt(0));
        return isUpperCase;
    }
    private boolean checkCapitalLetterAndNotEqualFirstName(String firstName,String lastName){
        if(checkCapitalLetter(lastName) && !lastName.equals(firstName))
        {
            return true;
        }
        else
            return false;


}
    private boolean checkPhoneNumber(String number){
        final int phoneNumberLength = 11;
        final String firstNumber="0";
        if(number.startsWith(firstNumber) && number.length()==phoneNumberLength)
        {
            return true;
        }
        else
            return false;

    }
    private boolean checkEmail(String email){
        final String mailSymbol = "@";
        final String com=".com";
        if(email.contains(mailSymbol)&&email.contains(com))
        {
            return true;
        }
        else return false;
    }
    private boolean checkPassword(String password)
    {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
             if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }
}
