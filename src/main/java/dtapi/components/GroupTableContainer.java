package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupTableContainer extends Paginator {
    private final String groupTableContainerXpath = "//div[@class='table-container']/table/tbody/tr";
    private List<GroupTableContainerComponent> containerComponents;

    public GroupTableContainer(WebDriver driver) {
        super(driver);
        initElements();

    }

    private void initElements(){
        containerComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath(groupTableContainerXpath))) {
            containerComponents.add(new GroupTableContainerComponent(current));
        }
    }


    public List<GroupTableContainerComponent> getContainerComponents() {
        return containerComponents;
    }

    public GroupTableContainerComponent getContainerComponentByGroupCode(String groupCode) {
        return getContainerComponentByName(groupCode);
    }
    private GroupTableContainerComponent getContainerComponentByName(String groupCode) {
        GroupTableContainerComponent result = findGroup(groupCode);

        while (result == null ) {
            if (!isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Group with groupCode: %s not found", groupCode));
            }
            clickNextButton();
            initElements();
            result = findGroup(groupCode);

        }

        return result;

    }

    private GroupTableContainerComponent findGroup( String groupCode) {
        for (GroupTableContainerComponent current : containerComponents) {

            if (current.getGroupCodeText().toLowerCase().equals(groupCode.toLowerCase())) {

                return current;
            }
        }
        return null;
    }
}