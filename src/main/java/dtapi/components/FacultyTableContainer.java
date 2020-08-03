package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FacultyTableContainer  {
   private WebDriver driver;
   private Paginator paginator;
    private final String facultyTableContainerXpath = "//tbody/tr";
    private List<FacultyTableContainerComponent> containerComponents;

    public FacultyTableContainer(WebDriver driver) {
        this.driver = driver;
        paginator = new Paginator(driver);
      initElements();
    }

    private void initElements(){
        containerComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath(facultyTableContainerXpath))) {

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
            if (!paginator.isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Faculty with facultyName: %s not found", facultyName));
            }
            paginator.clickNextButton();
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
