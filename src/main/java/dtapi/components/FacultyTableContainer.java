package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FacultyTableContainer extends Paginator {
    private final String facultyTableContainerXpath = "//div[@class='table-container']/table/tbody/tr";
    private List<FacultyTableContainerComponent> containerComponents;

    public FacultyTableContainer(WebDriver driver) {
        super(driver);
      initElements();
    }

    private void initElements(){
        containerComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath(facultyTableContainerXpath))) {
       ;
            containerComponents.add(new FacultyTableContainerComponent(current));
        }
    }

    public List<FacultyTableContainerComponent> getFacultyContainerComponents() {
        return containerComponents;
    }

    public FacultyTableContainerComponent getContainerComponentByFacultiesName(String facultyName) {
        return getContainerComponentByFacultyName(facultyName);
    }

    private FacultyTableContainerComponent getContainerComponentByFacultyName(String facultyName) {
        FacultyTableContainerComponent result = findFaculty(facultyName);

        while (result == null ) {
            if (!isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Faculty with facultyName: %s not found", facultyName));
            }
            clickNextButton();
            initElements();
            result = findFaculty(facultyName);

        }

        return result;

    }

    private FacultyTableContainerComponent findFaculty( String facultyName) {
        for (FacultyTableContainerComponent current : containerComponents) {

            if (current.getFacultyNameText().toLowerCase().equals(facultyName.toLowerCase())) {

                return current;
            }
        }
        return null;
    }
}
