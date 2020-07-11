package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SubjectTableContainer  extends Paginator {
    private final String subjectTableContainerXpath = "//div[@class='table-container']/table/tbody/tr";
    private List<SubjectTableContainerComponent> containerComponents;


    public SubjectTableContainer(WebDriver driver) {
        super(driver);
        initElements();
    }

    public List<SubjectTableContainerComponent> getSubjectContainerComponents() {
        return containerComponents;
    }


    public SubjectTableContainerComponent getSubjectContainerComponentBySubjectName(String subjectName) {
        return getSubjectContainerComponentByName(subjectName);
    }

    private SubjectTableContainerComponent getSubjectContainerComponentByName(String subjectName) {
        SubjectTableContainerComponent result = findSubject(subjectName);

        while (result == null ) {
            if (!isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Subject with subjectName: %s not found", subjectName));
            }
            clickNextButton();
            initElements();
            result = findSubject(subjectName);

        }
        return result;

    }

    private SubjectTableContainerComponent findSubject(String subjectName) {
        for (SubjectTableContainerComponent current : containerComponents) {

            if (current.getSubjectNameText().toLowerCase().equals(subjectName.toLowerCase())) {

                return current;
            }
        }
        return null;
    }

    private void initElements() {

        containerComponents = new ArrayList<>();

        for (WebElement current : driver.findElements(By.xpath(subjectTableContainerXpath))) {
            containerComponents.add(new SubjectTableContainerComponent(current));
        }
    }
}



