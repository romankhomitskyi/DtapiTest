package dtapiLoginTest;

import dtapi.data.data_provider.DataForLoginTest;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import org.testng.Assert;

public class LoginPageTests extends TestUtilities {


    /*@org.testng.annotations.Test(dataProvider = "dataLoginTests", dataProviderClass = DataForLoginTest.class, priority = 1, groups = {"positiveTest", "smokeTest", "user"})
    public void login(IUser validUser) {
        UserPage userPage =
                loadSignInPage()
                        .successfulLogin(validUser);
        sleep(2000);
        String url = userPage.getStudentUrl();
        //takeScreenshot("login");
        Assert.assertEquals(url, userPage.getCurrentUrl());

    }

    @org.testng.annotations.Test(dataProvider = "dataLoginTests", dataProviderClass = DataForLoginTest.class, priority = 2, groups = {"positiveTest", "smokeTest", "admin"})
    public void loginAdmin(IUser validAdmin) {
        AdminHomePage adminHomePage = loadSignInPage()
                .successfulAdminLogin(validAdmin);
        sleep(2000);
        String url = adminHomePage.getAdminUrl();
        Assert.assertEquals(adminHomePage.getCurrentUrl(), url);

    }*/

    @org.testng.annotations.Test(dataProvider = "dataLoginTests", dataProviderClass = DataForLoginTest.class, priority = 1, groups = {"negativeTest", "smokeTest", "check"})
    public void failLogin(IUser invalidUser1, String errorMessage,IUser invalidUser2,IUser invalidUser3) {
        loadSignInPage()
                .unsuccessfulLoginPage(invalidUser1);
        String error = loadSignInPage().getErrorMessageText();
        Assert.assertEquals(error, errorMessage);
        loadSignInPage().unsuccessfulLoginPage(invalidUser2);
        Assert.assertEquals(error, errorMessage);
        loadSignInPage().unsuccessfulLoginPage(invalidUser3);
        Assert.assertEquals(error, errorMessage);

    }




}
