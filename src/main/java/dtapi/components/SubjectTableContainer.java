package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SubjectTableContainer  {
    private WebDriver driver;
    private Paginator paginator;
    private final String subjectTableContainerXpath = "//div[@class='table-container']/table/tbody/tr";
    private List<SubjectTableContainerComponent> containerComponents;


    public SubjectTableContainer(WebDriver driver) {
        this.driver = driver;
        paginator = new Paginator(driver);
        initElements();
    }

    private void initElements() {

        containerComponents = new ArrayList<>();

        for (WebElement current : driver.findElements(By.xpath(subjectTableContainerXpath))) {
            containerComponents.add(new SubjectTableContainerComponent(current));
        }
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
            if (!paginator.isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Subject with subjectName: %s not found", subjectName));
            }
            paginator.clickNextButton();
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
}



