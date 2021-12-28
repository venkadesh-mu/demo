package WebDriver;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.awt.datatransfer.StringSelection;
import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Sample 
{
	public static void main(String[] args) throws InterruptedException, AWTException
	{
		System.setProperty("webdriver.chrome.driver", "/home/local/ZOHOCORP/venkat-pt4472/Downloads/Softwares/Extracted files/Selenium/chromedriver_linux64/chromedriver");  
	    WebDriver driver=new ChromeDriver();  
	    driver.navigate().to("http://leafground.com");
	    //driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[1]/a")).click();  
	    //driver.findElement(By.xpath("/html/body/header/div/div/div/a[2]")).click();
	    //driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).click();
	    //driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("venkadeshvlr@gmail.com"+Keys.ENTER);
	    
	    
	    
	    
	    
	    driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a")).click();
	    driver.findElement(By.id("email")).sendKeys("venkadeshabc@gmail.com");
	    driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input")).sendKeys("appended");
	   String text= driver.findElement(By.name("username")).getAttribute("value");
	   System.out.println("text is:"+text);
	   driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input")).clear();
	  boolean isenable= driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input")).isEnabled();
	  System.out.println(isenable);
	  driver.navigate().back();
	  
	  
	  
	  
	  
	  
	  
	  driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[5]/a")).click();
	  WebElement dropdown=driver.findElement(By.id("dropdown1"));
	  Select select=new Select(dropdown);
	  select.selectByIndex(1);
	  select.selectByValue("2");
	  select.selectByVisibleText("UFT/QTP");
	  driver.navigate().back();
	  
	  
	  
	  
	  driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[9]/a")).click();
	 /* WebElement alertbutton=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/button"));
	  alertbutton.click();
	  Alert alertdriver=driver.switchTo().alert();
	  alertdriver.accept();*/
	  
	   WebElement sweetalert=driver.findElement(By.xpath("//*[@id=\"btn\"]"));
	   sweetalert.click();
	   Thread.sleep(2000);
	   WebElement sweetalertdriver=driver.switchTo().activeElement();
	   sweetalertdriver.click();
	   driver.navigate().back();
	   
	   
	   
	   
	   driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[11]/a")).click();
	   String parentwindow=driver.getWindowHandle();
	   System.out.println(parentwindow);
	   WebElement donotcloseme=driver.findElement(By.id("color"));
	   donotcloseme.click();
	   Set <String> openedwindows=driver.getWindowHandles();
	   for(String openedwindow:openedwindows)
	   {
		   if(!openedwindow.equals(parentwindow))
		   {
			   driver.switchTo().window(openedwindow);
			   driver.close();
		   }
	   }
	   driver.switchTo().window(parentwindow);
	   driver.navigate().back();
	   
	   
	   
	   
	   
	   
	   driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[10]/a")).click();
	   driver.switchTo().frame(0);
	   WebElement insideframe0=driver.findElement(By.id("Click"));
	   insideframe0.click();
	   driver.switchTo().defaultContent();
	   driver.switchTo().frame(1);
	   driver.switchTo().frame("frame2");
	   WebElement insideframe1=driver.findElement(By.id("Click1"));
	   insideframe1.click();
	   driver.switchTo().defaultContent();
	   driver.switchTo().frame(2);
	   int numberofiframes=driver.findElements(By.tagName("iframe")).size();
	   System.out.println("Iframes inside iframe:"+numberofiframes);
	   driver.switchTo().defaultContent();
	   int totalnumberofiframes=driver.findElements(By.tagName("iframe")).size();
	   System.out.println("Total iframes inside the page:"+totalnumberofiframes);
	   driver.navigate().back();
	   
	   
	   
	   
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
	   jse.executeScript("window.scrollBy(0,250)");
	   driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[14]/a")).click();
	   WebElement drag=driver.findElement(By.id("draggable"));
	   WebElement drop=driver.findElement(By.id("droppable"));
	   Actions actions=new Actions(driver);
	   actions.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
	   driver.navigate().back();
	   
	   
	   
	   
	   driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[15]/a")).click();
	  List <WebElement> listelements=driver.findElements(By.xpath("//*[@id=\"selectable\"]/li"));
	  int selectablesize=listelements.size();
	  System.out.println("Number of elements in selectable is:"+selectablesize);
	  actions.keyDown(Keys.CONTROL)
	  .click(listelements.get(0))
	  .click(listelements.get(1))
	  .click(listelements.get(2))
	  .keyUp(Keys.CONTROL)
	  .build().perform();
	  driver.navigate().back();
	  System.out.println("Selecting list executed");
	   
	  
	  jse.executeScript("window.scrollBy(0,500)");
	  driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[18]/a")).click();
	  WebElement downloadlink=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[3]/div[2]/a[1]"));
	  downloadlink.click();
	  Thread.sleep(2000);
	  File filepath=new File("/home/local/ZOHOCORP/venkat-pt4472/Downloads");
	  File[] allfiles=filepath.listFiles();
	  for(File file:allfiles)
	  {
		  if(file.getName().equals("testleaf.xlsx"))
		  {
			  System.out.println("File downloaded");
		  }
	  }
	  driver.navigate().back();
	  
	  
	  
	  
	  
	  
	  
	  
	  driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[19]/a")).click();
	  WebElement uploadbutton=driver.findElement(By.name("filename"));
	  actions.moveToElement(uploadbutton).click().build().perform();
	  StringSelection pathoffile=new StringSelection("/home/local/ZOHOCORP/venkat-pt4472/Downloads/testleaf.xlsx");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pathoffile,null);
	  Robot robot=new Robot();
      robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_V);
      robot.keyRelease(KeyEvent.VK_V);
      robot.keyRelease(KeyEvent.VK_CONTROL);
      Thread.sleep(2000);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
	  
	  
	  
	  
	   
	   
	   
	}
	///home/local/ZOHOCORP/venkat-pt4472/Downloads/Softwares/Extracted files/Selenium/chromedriver_linux64
}
