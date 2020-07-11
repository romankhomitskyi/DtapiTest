package dtapi.components;

import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SpecialityTableContainer extends Paginator {
    private final String specialityTableContainerXpath = "//table/tbody/tr";
    private WaitUtils wait;

    public SpecialityTableContainer(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
    }

    public List<SpecialityTableContainerComponent> getSpecialityContainerComponents() {
        WebDriverWait waits = new WebDriverWait(driver, 10);

        sleep(1500);

        List<SpecialityTableContainerComponent> containerComponents = new ArrayList<>();
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(specialityTableContainerXpath))));

        for (WebElement current : rows) {

            containerComponents.add(new SpecialityTableContainerComponent(current));
        }
        return containerComponents;
    }
    public int getSpecialityContainerComponentsCount() {
        return getSpecialityContainerComponents().size();
    }
    public List<String> getSpecialityContainerComponentNames() {
        List<String> containerComponentNames = new ArrayList<>();
        for (SpecialityTableContainerComponent current : getSpecialityContainerComponents()) {
            containerComponentNames.add(current.getSpecialityNameText());
        }
        return containerComponentNames;
    }
    public String getContainerComponentSpecialityIdBySpecialityName(String specialityName) {
        return getContainerComponentBySpecialityName(specialityName).getSpecialityIdText();
    }


    public void clickContainerComponentEditSpecialityIconBySpecialityName(String specialityName) {
        getContainerComponentBySpecialityName(specialityName).clickSpecialityEditIcon();
    }

    public void clickContainerComponentDeleteIconByFacultyName(String specialityName) {
        getContainerComponentBySpecialityName(specialityName).clickDeleteSpecialityIcon();
    }
    public SpecialityTableContainerComponent getContainerComponentBySpecialitiesName(String specialityName) {
        return getContainerComponentBySpecialityName(specialityName);
    }
    protected SpecialityTableContainerComponent getContainerComponentBySpecialityName(String specialityName) {
        SpecialityTableContainerComponent result = null;
        WebDriverWait waits = new WebDriverWait(driver, 10);

        sleep(1500);

        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(specialityTableContainerXpath))));
        List<SpecialityTableContainerComponent> containerComponents = new ArrayList<>();
        for (WebElement current : rows) {

            containerComponents.add(new SpecialityTableContainerComponent(current));
        }
        for (SpecialityTableContainerComponent current : containerComponents) {

            if (current.getSpecialityNameText().toLowerCase().equals(specialityName.toLowerCase())) {
                result = current;
                break;
            }

        }
        if (result == null){

            boolean isEnabled = isNextArrowEnabled();
            while (isEnabled) {
                clickNextButton();
                waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(specialityTableContainerXpath))));
                List<SpecialityTableContainerComponent> containerComponents2 = new ArrayList<>();
                for (WebElement current2 : rows2) {
                    containerComponents2.add(new SpecialityTableContainerComponent(current2));

                }
                for (SpecialityTableContainerComponent current3 : containerComponents2) {

                    if (current3.getSpecialityNameText().toLowerCase().equals(specialityName.toLowerCase())) {
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
            throw new RuntimeException(String.format("Speciality with specialityName: %s not found", specialityName));
        }

        return result;


    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
