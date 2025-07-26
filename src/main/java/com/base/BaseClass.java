package com.base;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class BaseClass {

	public static WebDriver driver;	
	public static ExtentReports extentReports;
	public static File file;
		
			
	protected static WebDriver launchBrowser(String browserName){
		try {
				if(browserName.equalsIgnoreCase("chrome"))
				{
					driver = new ChromeDriver();
				}
				else if(browserName.equalsIgnoreCase("firefox"))
				{
					driver = new FirefoxDriver();
				}
				else if(browserName.equalsIgnoreCase("edge"))
				{
					driver = new EdgeDriver();
				}
			} 
		catch (Exception e)	{
			Assert.fail("ERROR : OCCURED DURING BROWSER LAUNCH");
			}
		driver.manage().window().maximize();
		return driver;

	}
	
	
	protected static void launchUrl(String url, String type){
	try {
		if (type.equalsIgnoreCase("Navigateto")) {
			driver.navigate().to(url);
		} else if (type.equalsIgnoreCase("GetURL")) {
			driver.get(url);
		} 
	}
	catch (Exception e) {
		Assert.fail("ERROR : OCCURED DURING URL LAUNCH");
		}
	}
	
	protected static void passInput(WebElement element, String Value) {
		try {
			element.sendKeys(Value);
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING PASSING INPUT");
		}
	}
	
	protected static void closeBrowser(String type) {
		try {
			if(type.equalsIgnoreCase("close")) {
				driver.close();
			}else if (type.equalsIgnoreCase("quit")) {
				driver.quit();
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING CLOSING BROWSER");
		}
	}
	
	protected static void clickElement(WebElement element, String type) {
		try {
			if (type.equalsIgnoreCase("RadioButton")) {
			element.click();
			} else if (type.equalsIgnoreCase("CheckBox")) {
				element.click();
			} else if (type.equalsIgnoreCase("Clickable")) {
				element.click();
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING CLICKING ELEMENT");
		}
	}
	
	protected static void actions(String type) {
		try {
			if (type.equalsIgnoreCase("NavigateBack")) {
				driver.navigate().back();
			} else if (type.equalsIgnoreCase("NavigateForward")) {
				driver.navigate().forward();
			} else if (type.equalsIgnoreCase("NavigateRefresh")) {
				driver.navigate().refresh();
			} else if(type.equalsIgnoreCase("Title")) {
				String title = driver.getTitle();
				System.out.println(title);
			} else if (type.equalsIgnoreCase("CurrentURL")) {
				String currentUrl = driver.getCurrentUrl();
				System.out.println(currentUrl);
			}
			} catch (Exception e) {
				Assert.fail("ERROR : OCCURED DURING BROWSER ACTION");
		}
	}
	
	protected static void implicitWait(String Value) {
		try {
			int seconds = Integer.parseInt(Value);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING IMPLICIT WAIT");
		}		
	}
	
	protected static void explicitcitWait(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(element));			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING EXPLICIIT WAIT");
		}		
	}
	
	protected static void screenshot() {
		try {
			Date currentDate = new Date();
			String replace = currentDate.toString().replace(" ","_").replace(":", "_");
			System.out.println(currentDate);
			File ts = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(ts, new File("./target/Screenshots/" +replace+".png"));
		} catch (WebDriverException e) {
			Assert.fail("WEB DRIVER ERROR : OCCURED DURING TAKING SCREEN SHOT");
		} catch (IOException e) {
			Assert.fail("IO ERROR : OCCURED DURING TAKING SCREEN SHOT");
		}
	}
	
	
	protected static void getAttribute(WebElement element, String attributeName) {
		try {
			String attribute = element.getAttribute(attributeName);
			System.out.println(attribute);
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING FETCHING ATTRIBUTE");
		}
	}
	
	protected static void getText(WebElement element) {
		try {
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING FETCHING TEXT");
		}
	}
	
	protected static void selectOptions(WebElement element, String type, String Value) {
		try {
			Select select = new Select(element);
			if(type.equalsIgnoreCase("Value")) {
				select.selectByValue(Value);
			} else if (type.equalsIgnoreCase("Index")) {
				select.selectByIndex(Integer.parseInt(Value));
			} else if (type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(Value);
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING VALUE SELECT");
		}
	}
	
	protected static void deselectOptions(WebElement element, String type, String Value) {
		try {
			Select select = new Select(element);
			if(type.equalsIgnoreCase("Value")) {
				select.deselectByValue(Value);
			} else if (type.equalsIgnoreCase("Index")) {
				select.deselectByIndex(Integer.parseInt(Value));
			} else if (type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(Value);
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING VALUE DESELECT");
		}
	}
	
	protected static void getWindowHandles(int num) {
		try {
			List<String> allWindow = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(num));
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING WINDOW HANDLING");
		}
	}
	
	protected static void elementStatus(WebElement element, String type) {
		try {
			if(type.equalsIgnoreCase("Selected")) {
				boolean select = element.isSelected();
				System.out.println("Selected" + select);
			} else if (type.equalsIgnoreCase("Enabled")) {
				boolean enable = element.isEnabled();
				System.out.println("Enabled" + enable);
			} else if (type.equalsIgnoreCase("Displayed")) {
				boolean display = element.isDisplayed();
				System.out.println("Displayed" + display);
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING STATUS VALIDATION");
		}
	}
	
	protected static void robotAction(String type) {
		try {
			Robot r = new Robot();
			if(type.equalsIgnoreCase("dropArrow")) {
				r.keyPress(KeyEvent.VK_DOWN);
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING ROBOT ACTIONS");
		}
	}
	
	protected static void getDropDown(WebElement element, String type) {
		try {
			Select selectOpt = new Select(element);
			if(type.equalsIgnoreCase("getAllOptions")) {
				List<WebElement> getAllOptions = selectOpt.getOptions();
				for (WebElement value : getAllOptions) {
					System.out.println(value.getText());
				}
			} else if(type.equalsIgnoreCase("getAllSelectedOptions")) {
				List<WebElement> allSelectedOptions = selectOpt.getAllSelectedOptions();
				for (WebElement value : allSelectedOptions) {
					System.out.println(value.getText());
				}
			} else if (type.equalsIgnoreCase("isMultiple")) {
				boolean isMultiple = selectOpt.isMultiple();
				System.out.println("The Element is Multiple" + isMultiple);
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING DROPDOWN ACTIONS");
		}
	}
	
	protected static void handleAlerts(String type) {
		try {
			//driver.switchTo().alert().sendKeys(value);
			if(type.equalsIgnoreCase("accept")) {
				driver.switchTo().alert().accept();
			} else if (type.equalsIgnoreCase("decline")) {
				driver.switchTo().alert().dismiss();
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING PROMPT ALERT");
		}
	}
	
	protected static void mouseActions(WebElement element, String type) {
		try {
			Actions act = new Actions(driver);
			if(type.equalsIgnoreCase("Click")) {
				act.click(element).perform();
			} else if(type.equalsIgnoreCase("DoubleClick")) {
				act.doubleClick(element).perform();
			} else if(type.equalsIgnoreCase("RightClick")) {
				act.contextClick(element).perform();
			} else if(type.equalsIgnoreCase("ClickAndHold")) {
				act.clickAndHold(element).perform();
			} else if (type.contentEquals("Release")) {
				act.release(element).perform();
			} else if (type.equalsIgnoreCase("moveToElement")) {
				act.moveToElement(element).perform();
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING MOUSE ACTIONS");
		}
	}
	
	protected static void handerFrames(WebElement element, String type) {
		try {
			if(type.equalsIgnoreCase("ChildFrame")) {
				driver.switchTo().frame(element);
			} else if(type.equalsIgnoreCase("HomeFrame")) {
				driver.switchTo().defaultContent();
			} else if(type.equalsIgnoreCase("ParentFrame")) {
				driver.switchTo().parentFrame();
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING FRAME HANDLING");
		}
	}
	
	protected static void dragAndDrop(WebElement source, WebElement target) {
		try {
			Actions act = new Actions(driver);
			act.dragAndDrop(source, target).click().build().perform();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING DRAG AND DROP");
		}
	}
	
	protected static void assertion(WebElement actual, String Value, String type) {
		try {
			if (type.equalsIgnoreCase("HardAssertion")) {
				Assert.assertEquals(actual.getText(), Value);
				System.out.println("Hard Assertion");
			} else if (type.equalsIgnoreCase("SoftAssertion")) {
				SoftAssert soft = new SoftAssert();
				soft.assertEquals(actual.getText(), Value);
				System.out.println("Soft Assertion");
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING ASSERTION");
		}
	}
	
	protected static void javaScriptClick(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING JS CLICK");
		}
		
	}
	
	protected static void javaScriptSendKeys(WebElement element, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].value=argument[1];", element,value);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING JS SENDKEYS");
		}
		
	}
	
	protected static void jsScrollDown(int pixels) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0," + pixels +");");
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING JS SCROLL DOWN");
		}
		
	}
	
	protected static void jsScrollUp(int pixels) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("windows.scrollBy(0,-" + pixels + ")", "");
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING JS SCROLL UP");
		}
		
	}
	
	protected static void jsHorizontalRight(int pixels) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("windows.scrollBy(arguments[0], 0)",pixels);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING JS HORIZONTAL RIGHT");
		}
		
	}
	
	protected static void jsHorizontalLeft(int pixels) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("0, windows.scrollBy(arguments[0])",pixels);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING JS HORIZONTAL RIGHT");
		}
		
	}
	
	protected static void jsScrollElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",
					element);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void extentReportStart(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("java.version"));		
	}
	
	public static void extentReportTearDown(String location) throws IOException {
		extentReports.flush();
		file = new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}
	
	protected String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(new Date());
		File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("screenshot\\.png" + "-" + timeStamp  + ".png");
		FileHandler.copy(scrFile, destFile);
		return destFile.getAbsolutePath();
		
		
	}
}
