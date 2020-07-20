package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class StudentTableContainer extends Paginator{
        private final String studentTableContainerXpath = "//div[contains(@class,'mat-table-wrapper')]/table/tbody/tr";
        private List<StudentTableContainerComponent> containerComponents;



        public StudentTableContainer(WebDriver driver) {
            super(driver);
            initElements();
        }

        private void initElements(){
            containerComponents = new ArrayList<>();

            for (WebElement current : driver.findElements(By.xpath(studentTableContainerXpath))) {
                containerComponents.add(new StudentTableContainerComponent(current));
            }

        }


        public List<StudentTableContainerComponent> getStudentContainerComponents() {

            return containerComponents;
        }
    private StudentTableContainerComponent getStudentContainerComponentByName(String studentNSF) {
        StudentTableContainerComponent result = findStudent(studentNSF);

        while (result == null ) {
            if (!isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Student with studentNSF: %s not found", studentNSF));
            }
            clickNextButton();
            initElements();
            result = findStudent(studentNSF);

        }
        return result;

    }

    private StudentTableContainerComponent findStudent( String studentNSF) {
        for (StudentTableContainerComponent current : containerComponents) {

            if (current.getStudentNSFText().toLowerCase().contains(studentNSF.toLowerCase())) {

                return current;
            }
        }
        return null;
    }

    }
