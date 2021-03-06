package com.hrms.utils;

import com.hrms.testbase.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CommonMethods extends PageInitializer {
    public static List<WebElement> ddOptions;
    /**
     * this method will clear a textBox and send text to it
     * @param element
     * @param textToSend
     */
    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    /**
     * this method will return an object of Explicit wait with time set to 20 sec
     * @return
     */
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    /**
     * this method will wait until given element becomes clickable
     * @param element
     */
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * this method will wait until and then click
     * @param element
     */
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    /**
     * this method will create an object of JS executor
     * @return
     */
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return js;
    }

    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    /**
     *
     * @param fileName
     */
    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot)driver;
        byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * Example pattern: "yyyy-MM-dd-HH-mm-ss"
     * @param pattern
     * @return
     */
    public static String getTimeStamp(String pattern){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * this method will click on a radio button or a check box by the given list of web-elements and the value
     * @param radioOrCheckBoxes
     * @param value
     */
    public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBoxes, String value){
        for(WebElement radioOrCheckBox:radioOrCheckBoxes){
            String actualValue = radioOrCheckBox.getAttribute("value").trim();
            if(radioOrCheckBox.isEnabled() && actualValue.equals("value")){
                jsClick(radioOrCheckBox);
                break;
            }
        }
    }

    /**
     * this method will select a value from dd be the given visible text
     * @param dd
     * @param visibleText
     */
    public static void selectDDValue(WebElement dd, String visibleText){
        try{
            Select select = new Select(dd);
            List<WebElement> options = select.getOptions();
            for (WebElement option:options) {
                if(option.getText().trim().equals(visibleText)){
                    select.selectByVisibleText(visibleText);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e){
            e.printStackTrace();
        }
    }

    /**
     * this method will select a value from dd be the given index
     * @param dd
     * @param index
     */
    public static void selectDDValue(WebElement dd, int index){
        try{
            Select select = new Select(dd);
            List<WebElement> options = select.getOptions();
            int ddSize = options.size();
            if(ddSize>index){
                select.selectByIndex(index);
            }
        }catch (UnexpectedTagNameException e){
            e.printStackTrace();
        }
    }

    /**
     * this method will get all the options from dd in form of List
     * @param dd
     */
    public static List<WebElement> getAllOptionsFromDD(WebElement dd){
        try{
            Select select = new Select(dd);
            ddOptions = select.getOptions();
        } catch (UnexpectedTagNameException e){
            e.printStackTrace();
        }
        return ddOptions;
    }

    /**
     * this method switch to a frame by given frame index
     * @param frameIndex
     */
    public static void switchToFrame(int frameIndex){
        try{
            driver.switchTo().frame(frameIndex);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    /**
     * this method switch to a frame by given frame name or id
     * @param nameOrId
     */
    public static void switchToFrame(String nameOrId){
        try{
            driver.switchTo().frame(nameOrId);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    /**
     * this method will switch to a child window
     */
    public static void switchToChildWindow(){
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for(String window:allWindows) {
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
    }
    /**
     * this method will click on a radio button or a check box by the given list of web-elements and the text
     * @param radioOrCheckBoxes
     * @param value
     */
    public static void clickRadioOrCheckBoxByText(List<WebElement> radioOrCheckBoxes, String value){
        for(WebElement radioOrCheckBox:radioOrCheckBoxes){
            String actualValue = radioOrCheckBox.getText().trim();
            if(radioOrCheckBox.isEnabled() && actualValue.equals("value")){
                click(radioOrCheckBox);
                break;
            }
        }
    }

    /**
     * this method will read json file and return as a string
     */
    static String jsonFile;
    public static String readJson(String FileName){
        try{
            jsonFile = new String(Files.readAllBytes(Paths.get(FileName)));
        }catch (IOException e){
            e.printStackTrace();
        }
        return jsonFile;
    }





}
