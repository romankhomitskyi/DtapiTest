package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SpecialityTableContainer {
    private WebDriver driver;
    private Paginator paginator;
    private final String specialityTableContainerXpath = "//table/tbody/tr";
    private List<SpecialityTableContainerComponent> containerComponents;

    public SpecialityTableContainer(WebDriver driver) {
        this.driver = driver;
        paginator = new Paginator(driver);
      initElements();
    }
    private void initElements(){
        containerComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath(specialityTableContainerXpath))) {

            containerComponents.add(new SpecialityTableContainerComponent(current));
        }

    }

    public List<SpecialityTableContainerComponent> getSpecialityContainerComponents() {
        return containerComponents;
    }


    public SpecialityTableContainerComponent getContainerComponentBySpecialitiesName(String specialityName) {
        return getContainerComponentBySpecialityName(specialityName);
    }
    private SpecialityTableContainerComponent getContainerComponentBySpecialityName(String specialityName) {
        SpecialityTableContainerComponent result = findSpeciality(specialityName);

        while (result == null ) {
            if (!paginator.isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Speciality with specialityName: %s not found", specialityName));
            }
            paginator.clickNextButton();
            initElements();
            result = findSpeciality(specialityName);

        }
        return result;

    }

    private SpecialityTableContainerComponent findSpeciality( String speciality) {
        for (SpecialityTableContainerComponent current : containerComponents) {

            if (current.getSpecialityNameText().toLowerCase().equals(speciality.toLowerCase())) {

                return current;
            }
        }
        return null;
    }
}
