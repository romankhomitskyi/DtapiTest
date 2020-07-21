package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdminTableContainer extends Paginator {

    private final String adminTableContainerXpath = "//table/tbody/tr";
    private List<AdminTableContainerComponent> containerComponents;

    public AdminTableContainer(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        containerComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath(adminTableContainerXpath))) {
            containerComponents.add(new AdminTableContainerComponent(current));
        }
    }

    public List<AdminTableContainerComponent> getAdminContainerComponents() {
        return containerComponents;
    }


    public AdminTableContainerComponent getAdminContainerComponentByLogin(String adminLog) {
        return getAdminContainerComponentsByLogin(adminLog);
    }

    private AdminTableContainerComponent getAdminContainerComponentsByLogin(String adminLog) {
        AdminTableContainerComponent result = findAdmin(adminLog);

        while (result == null ) {
            if (!isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Admin with adminLog: %s not found", adminLog));
            }
            clickNextButton();
            initElements();
            result = findAdmin(adminLog);

        }

        return result;

    }

    private AdminTableContainerComponent findAdmin( String adminLog) {
        for (AdminTableContainerComponent current : containerComponents) {

            if (current.getAdminLoginText().toLowerCase().equals(adminLog.toLowerCase())) {

                return current;
            }
        }
        return null;
    }
}
