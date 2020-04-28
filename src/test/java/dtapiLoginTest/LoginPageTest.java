package dtapiLoginTest;

import dtapi.data.data_provider.DataForLoginTest;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.pages.AdminHomePage;
import dtapi.pages.UserPage;
import org.testng.Assert;

public class LoginPageTest extends TestUtilities {


    @org.testng.annotations.Test(dataProvider = "dataLoginTests", dataProviderClass = DataForLoginTest.class, priority = 1, groups = {"positiveTest", "smokeTest", "user"})
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

    }

    @org.testng.annotations.Test(dataProvider = "dataLoginTests", dataProviderClass = DataForLoginTest.class, priority = 3, groups = {"negativeTest", "smokeTest", "check"})
    public void failLoginWithInvalidPassword(IUser invalidUser, String errorMessage) {
        loadSignInPage()
                .unsuccessfulLoginPage(invalidUser);
        String error = loadSignInPage().getErrorMessageText();
        sleep(2000);
        //takeScreenshot("login");
        Assert.assertEquals(error, errorMessage);

    }

    @org.testng.annotations.Test(dataProvider = "dataLoginTests", dataProviderClass = DataForLoginTest.class, priority = 4, groups = {"negativeTest", "smokeTest", "check"})
    public void failLoginWithEmptyField(IUser invalidUser, String errorMessage) {
        loadSignInPage().unsuccessfulLoginPage(invalidUser);
        String error = loadSignInPage().getErrorMessageText();
        sleep(2000);
        //takeScreenshot("login");
        Assert.assertEquals(error, errorMessage);

    }

    @org.testng.annotations.Test(dataProvider = "dataLoginTests", dataProviderClass = DataForLoginTest.class, priority = 5, groups = {"negativeTest", "smokeTest", "check"})
    public void failLoginWithInvalidLogin(IUser invalidUser, String errorMessage) {
        loadSignInPage().unsuccessfulLoginPage(invalidUser);
        String error = loadSignInPage().getErrorMessageText();
        sleep(2000);
        //takeScreenshot("login");
        Assert.assertEquals(error, errorMessage);

    }


}
