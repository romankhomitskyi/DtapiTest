package paginationTest;

import dtapi.dtapiBase.TestUtilities;

public class PaginationOnAdminPageTests extends TestUtilities {

    //FIXME
    /*@Test(dataProvider = "dataPaginationTests", dataProviderClass = DataForPaginationTest.class, groups = {"dropdown"},
            description = "verifies that number of records displayed in a table and pagination are equal")
    public void checkShowDropDownMenu(IUser validAdmin, RowsOnPage five, RowsOnPage ten, RowsOnPage twenty) {
        SubjectPage subjectPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSubjectIcon();
        subjectPage.setDropDownOption(ten);
        sleep(2000);
        Assert.assertTrue("Number of records in table and pagination aren't equal",
                subjectPage.getRows().size() <= subjectPage.getFirstOptionCount());
        subjectPage.setDropDownOption(five);
        sleep(2000);
        Assert.assertTrue("Number of records in table and pagination aren't equal",
                subjectPage.getRows().size() <= subjectPage.getFirstOptionCount());
        subjectPage.setDropDownOption(twenty);
        sleep(2000);
        Assert.assertTrue("Number of records in table and pagination aren't equal",
                subjectPage.getRows().size() <= subjectPage.getFirstOptionCount());


    }


    @Test(dataProvider = "dataPaginationTests", dataProviderClass = DataForPaginationTest.class, groups = {"checkNavigation"},
            description = "verifies that Admin can navigates the Table by firs,last,next,previous buttons")
    public void checkNavigation(IUser validAdmin, Pagination next, Pagination last, Pagination first, Pagination previous) {
        SubjectPage subPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSubjectIcon();
        Assert.assertTrue("First and Previous buttons are enabled ", subPage.clickNextButton(next, first, previous));
        Assert.assertTrue("First,Previous,Next,Last buttons aren't enabled ",
                subPage.isArrowEnabled(first)
                        && subPage.isArrowEnabled(previous)
                        && subPage.isArrowEnabled(last)
                        && subPage.isArrowEnabled(next)
        );
        sleep(2000);
        Assert.assertTrue("First and Previous buttons are disabled ",
                subPage.clickLastButton(last) &&
                        subPage.isArrowEnabled(first) && subPage.isArrowEnabled(previous));
        Assert.assertFalse("Next and Last buttons are enabled ",
                subPage.isArrowEnabled(next)
                        && subPage.isArrowEnabled(last));
        sleep(1000);
        Assert.assertTrue("First,Previous,Next,Last buttons aren't enabled ",
                subPage.clickPreviousButton(previous) &&
                        subPage.isArrowEnabled(first)
                        && subPage.isArrowEnabled(previous)
                        && subPage.isArrowEnabled(last)
                        && subPage.isArrowEnabled(next)
        );

    }*/

    /*@Test(dataProvider = "dataPaginationTests", dataProviderClass = DataForPaginationTest.class, groups = {"updatePagination"},
            description = "check that new subject creation affects  pagination")
    public void checkUpdatePagination(IUser validAdmin, String name, String desc, RowsOnPage count1) {
        SubjectPage subPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSubjectIcon();
        subPage.setDropDownOption(count1);
        sleep(1000);
        int endPage = subPage.getEndPage();
        int lenght = subPage.getLenght();
        subPage.switchToModalWindow()
                .fillFieldsAndSubmitForm(name, desc);
        sleep(2000);
        Assert.assertTrue(subPage.checkEndPage() == endPage + 1 && subPage.getLenght() == lenght + 1 || subPage.getLenght() == lenght + 1);

    }*/

}





