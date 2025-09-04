package testdata;

import java.awt.image.BufferedImage;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import groovy.time.Duration;
import pages.StartupPage;

public class LocatorsFactory extends StartupPage {
	//please write all the locators for facebook page only 

	By refreshButton = By.xpath("//button[@value='Refresh']"); 
	By logoIconLink = By.xpath("//a[@class='navbar-brand']"); 
	By CollapsibleGroup3 = By.xpath("//b[contains(text(), 'Collapsible Group 3 - Methhod Chaining')]"); 
	By autoCompleteTextBox = By.xpath("//input[@type='text']");
	By firstNameTextbox = By.xpath("//input[@placeholder='First Name']"); 
	By lastNameTextbox = By.xpath("//input[@placeholder='Last Name']"); 
	By addressInputAreabox = By.xpath("//textarea[@ng-model='Adress']"); 
	By emailAddressTextbox = By.xpath("//input[@type='email']"); 
	By phoneNumberTextbox = By.xpath("//input[@type='tel']"); 
	By emailTextField = By.xpath("//input[@placeholder=\"E mail\"]"); 
	By switchToNavigationMenu = By.xpath("//a[contains(text() , 'SwitchTo')]"); 
	By shopIconButton = By.xpath("//a[.='Shop']"); 
	By alertWithOk = By.xpath("//a[.='Alert with OK ']");
	By countryDropdown = By.xpath("//span[@role='combobox']"); 
	By registerNavigationMenu = By.xpath("//a[contains(text(), 'Register')]"); 
	By hockeyCheckBox = By.xpath("//input[@value='Hockey']"); 
	By cricketCheckBox = By.xpath("//input[@value='Cricket']"); 
	By moviesCheckBox = By.xpath("//input[@value='Movies']"); 
	By maleRadioButton = By.xpath("//input[@value='Male']");
	By selectYear = By.xpath("//select[@placeholder='Year']");
	By selectMonth = By.xpath("//select[@placeholder='Month']"); 
	By selectDate = By.xpath("//select[@placeholder='Day']"); 
	By messageAfterClickingSakinaliumCrossBrowserTestingOption = By.id("feedback");
	By feMaleRadioButton = By.xpath("//input[@value='FeMale']");
	
	UserActions commonEvents;
	WebDriver driver;
	public LocatorsFactory(WebDriver driver) {
		super(driver);
		commonEvents=new UserActions(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

public boolean isFormFilled(Map<String, String> expectedData,WebDriver driver){
	
	commonEvents.driver= driver;
	if (commonEvents.getAttribute(firstNameTextbox, "value").equals(expectedData.get("firstName")) &&
	            commonEvents.getAttribute(lastNameTextbox, "value").equals(expectedData.get("lastName")) &&
	            commonEvents.getAttribute(addressInputAreabox, "value").equals(expectedData.get("adds")) &&
	            commonEvents.getAttribute(emailAddressTextbox, "value").equals(expectedData.get("emaiI")) &&
	            commonEvents.getAttribute(phoneNumberTextbox, "value").equals(expectedData.get("phoneNo")))
				return true;
				return false;

}

public boolean isAustraliaSelected(){
	String getCountryNameFromCountryDropdown = commonEvents.getText(countryDropdown);
	System.out.println(getCountryNameFromCountryDropdown);
	if(getCountryNameFromCountryDropdown.equals("Australia"))
	return true;
	return false;
}
public boolean compareImages(BufferedImage img1, BufferedImage img2) {
        // Image comparison logic
        // Example: Compare image dimensions and pixel values
        if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
        for (int x = 0; x < img1.getWidth(); x++) {
            for (int y = 0; y < img1.getHeight(); y++) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y))
                    return false;
            }
        }
    } else {
        return false;
    }
    return true;
    }

public boolean areCheckBoxSelected(){
	WebElement cricket = commonEvents.findElement(cricketCheckBox);
	WebElement movies = commonEvents.findElement(moviesCheckBox);
	WebElement hockey = commonEvents.findElement(hockeyCheckBox);
	boolean isCricketCheckBoxSelected = cricket.isSelected();
	boolean isMoviesCheckBoxSelected = movies.isSelected();
	boolean isHockeyCheckBoxSelected = hockey.isSelected();
	if (isCricketCheckBoxSelected && isMoviesCheckBoxSelected && isHockeyCheckBoxSelected) 
		return true;
	return false;	

}



public boolean isDateSelected(){
	
	WebElement selectYeardropdown = commonEvents.findElement(selectYear);
	WebElement selectMonthdropdown = commonEvents.findElement(selectMonth);
	WebElement selectDatedropdown = commonEvents.findElement(selectDate);
    // Get the currently selected value of year
    Select yearDropdown = new Select(selectYeardropdown); // selectYear should be a WebElement
    String selectedYear = yearDropdown.getFirstSelectedOption().getText();
    
    // Get the currently selected value of month
    Select monthDropdown = new Select(selectMonthdropdown); // selectMonth should be a WebElement
    String selectedMonth = monthDropdown.getFirstSelectedOption().getText();
    
    // Get the currently selected value of day
    Select dateDropdown = new Select(selectDatedropdown); // selectDate should be a WebElement
    String selectedDate = dateDropdown.getFirstSelectedOption().getText();

    System.out.println("Selected Year: " + selectedYear);
    System.out.println("Selected Month: " + selectedMonth);
    System.out.println("Selected Date: " + selectedDate);

    if(selectedYear.equals("1996") && selectedMonth.equals("June") && selectedDate.equals("25"))
        return true;
    
    return false;

}

public boolean isFemaleRadioButtonSelected() {
	WebElement femaleRadioButtonWebElement = commonEvents.findElement(feMaleRadioButton);
	
	if (femaleRadioButtonWebElement.isSelected())
		return true;
	return false;
}




	//Expected data will be fetch from config.json file,path of the json file is:FaceBook_Automation_Dummy/src/main/resources/config.json

	public WebElement refreshButton(WebDriver driver) {
		WebElement refreshButtonWebElement = driver.findElement(refreshButton);
		return refreshButtonWebElement; 
	}
	
	public WebElement registerNavigationMenu(WebDriver driver) {
		WebElement registerNavigationMenuWebElement = driver.findElement(registerNavigationMenu);
		return registerNavigationMenuWebElement; 
	}

	public WebElement logoIcon(WebDriver driver) {
		WebElement logoIconLinkWebElement = driver.findElement(logoIconLink);
		return logoIconLinkWebElement; 
	}
	
	public WebElement CollapsibleGroup3(WebDriver driver) {
		WebElement CollapsibleGroup3WebElement = driver.findElement(CollapsibleGroup3);
		return CollapsibleGroup3WebElement; 
	}
	
	public WebElement autoCompleteTextBox(WebDriver driver) {
		WebElement autoCompleteTextBoxWebElement = driver.findElement(autoCompleteTextBox);
		return autoCompleteTextBoxWebElement; 
	}
	
	public WebElement emailTextFieldIsPresent(WebDriver driver) {
		WebElement emailTextFieldWebElement = driver.findElement(emailTextField);
        return emailTextFieldWebElement;
    }
	
	public WebElement firstNameTextboxIsPresent(WebDriver driver) {
		WebElement firstNameTextboxWebElement = driver.findElement(firstNameTextbox);
        return firstNameTextboxWebElement;
    }
	public WebElement getswitchToNavigationMenu(WebDriver driver) {
		WebElement switchToNavigationMenuWebElement = driver.findElement(switchToNavigationMenu);
        return switchToNavigationMenuWebElement;
    }
	
	public WebElement getAlertWithOkButton(WebDriver driver) {
		WebElement alertWithOkWebElement = driver.findElement(alertWithOk);
        return alertWithOkWebElement;
    }

	
	public WebElement countryDropdownIsPresent(WebDriver driver) {
		WebElement countryDropdownWebElement = driver.findElement(countryDropdown);
        return countryDropdownWebElement;
    }
	
	public WebElement hockeyCheckBox(WebDriver driver) {
		WebElement hockeyCheckBoxWebElement = driver.findElement(hockeyCheckBox);
        return hockeyCheckBoxWebElement;
    }
	
	public WebElement maleradioButton(WebDriver driver) {
		WebElement maleRadioButtonWebElement = driver.findElement(maleRadioButton);
        return maleRadioButtonWebElement;
    }
	
	public WebElement selectYearDropdown(WebDriver driver) {
		WebElement selectYearDropdownWebElement = driver.findElement(selectYear);
        return selectYearDropdownWebElement;
    }
	public WebElement messageAfterClickingSakinaliumCrossBrowserTestingOptionIsPresent(WebDriver driver) {
		WebElement messageAfterClickingSakinaliumCrossBrowserTestingOptionWebElement = driver.findElement(messageAfterClickingSakinaliumCrossBrowserTestingOption);
        return messageAfterClickingSakinaliumCrossBrowserTestingOptionWebElement;
    }

}
