package dtapi.components;

import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class StudentTableContainer extends Paginator{

        private final String studentTableContainerXpath = "//div[contains(@class,'mat-table-wrapper')]/table/tbody/tr";
        private WaitUtils wait;



        public StudentTableContainer(WebDriver driver, Logger log) {
            super(driver, log);
            wait = new WaitUtils(driver, 10);
        }


        protected void sleep(long n) {
            try {
                Thread.sleep(n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public List<StudentTableContainerComponent> getStudentContainerComponents() {
            WebDriverWait waits = new WebDriverWait(driver, 10);
            sleep(2000);
            /*waits.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(groupTableContainerXpath))));*/
            List<StudentTableContainerComponent> containerComponents = new ArrayList<>();
            List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(studentTableContainerXpath))));

            for (WebElement current : rows) {
                System.out.println(current.getText());
                containerComponents.add(new StudentTableContainerComponent(current));
            }
            return containerComponents;
        }


        public int getStudentContainerComponentsCount() {
            return getStudentContainerComponents().size();
        }

        public List<String> getStudentContainerComponentNames() {
            List<String> containerComponentNames = new ArrayList<>();
            for (StudentTableContainerComponent current : getStudentContainerComponents()) {
                containerComponentNames.add(current.getStudentNSFText());
            }
            return containerComponentNames;
        }


        public String getContainerComponentGradeBookIdByStudentNSF(String studentNSF) {
            return getStudentContainerComponentByName(studentNSF).getGradeBookIdText();
        }

        public String getContainerComponentStudentIdByStudentNSF(String studentNSF) {
            return getStudentContainerComponentByName(studentNSF).getStudentIdText();
        }


        public void clickContainerComponentStudentDataByStudentNSF(String studentNSF) {
            getStudentContainerComponentByName(studentNSF).clickStudentDataIcon();
        }

        public void clickContainerComponentSwitchGroupIconByStudentNSF(String studentNSF) {
            getStudentContainerComponentByName(studentNSF).clickSwitchGroupIcon();
        }

        public void clickContainerComponentEditStudentIconByStudentNSF(String studentNSF) {
            getStudentContainerComponentByName(studentNSF).clickEditStudentIcon();
        }

        public void clickContainerComponentDeleteStudentIconByStudentNSF(String studentNSF) {
            getStudentContainerComponentByName(studentNSF).clickDeleteStudentIcon();
        }


        public StudentTableContainerComponent getStudentContainerComponentByStudentNSF(String studentNSF) {
            return getStudentContainerComponentByName(studentNSF);
        }

        /**
         * goes trough the list of components present at the page, and checks if component with name from param is present
         *
         * @param
         * @return component with name from param
         */
   /* protected GroupTableContainerComponent getContainerComponentByName(String groupCode) {
        GroupTableContainerComponent result = null;

        for (GroupTableContainerComponent current : getContainerComponents()) {
            if (current.getGroupCodeText().toLowerCase().equals(groupCode.toLowerCase())) {
                result = current;
                break;

            }
        }

        if (result == null) {
            throw new RuntimeException(String.format("Group with groupCode: %s not found", groupCode));
        }
        return result;
    }*/
        protected StudentTableContainerComponent getStudentContainerComponentByName(String studentNSF) {
            StudentTableContainerComponent result = null;
            WebDriverWait waits = new WebDriverWait(driver, 10);
            sleep(2000);
            List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(studentTableContainerXpath))));
            List<StudentTableContainerComponent> containerComponents = new ArrayList<>();
            for (WebElement current : rows) {
                containerComponents.add(new StudentTableContainerComponent(current));
            }
            for (StudentTableContainerComponent current : containerComponents) {

                if (current.getStudentNSFText().toLowerCase().contains(studentNSF.toLowerCase())) {
                    result = current;
                    break;
                }

            }
            if (result == null){

                boolean isEnabled = isNextArrowEnabled();
                while (isEnabled) {
                    clickNextButton();
                    waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                    List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(studentTableContainerXpath))));
                    List<StudentTableContainerComponent> containerComponents2 = new ArrayList<>();
                    for (WebElement current2 : rows2) {
                        containerComponents2.add(new StudentTableContainerComponent(current2));

                    }
                    for (StudentTableContainerComponent current3 : containerComponents2) {

                        if (current3.getStudentNSFText().toLowerCase().contains(studentNSF.toLowerCase())) {
                            result = current3;
                            break;
                        }
                    }

                    if (result == null) {
                        if (isNextArrowEnabled()) isEnabled = true;
                        else isEnabled = false;
                    } else return result;
                }
            }

            if (result == null) {
                throw new RuntimeException(String.format("Student with studentNSF: %s not found", studentNSF));
            }

            return result;


        }

    }
