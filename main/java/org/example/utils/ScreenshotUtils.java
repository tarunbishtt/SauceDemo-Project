package org.example.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    public static  String takeScreenshot(
            WebDriver driver,
            String testName) {
    String timeStamp = new SimpleDateFormat
            ("yyyy-MM-dd_HH-mm-ss")
            .format(new Date());

    String fileName = testName + "_" + timeStamp + ".png";

    String filePath = System.getProperty("user.dir") + "\\screenshots\\" + fileName;

    try{
        File screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(filePath));
        System.out.println("Screenshot saved: " + fileName);
    }
    catch (IOException e) {
        System.out.println("Screenshot failed: " + e.getMessage());
    }
        return filePath;
    }
}
