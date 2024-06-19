package com.wisesoftlab.utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    public static void takeScreenshot(WebDriver driver, String testName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";
        try {
            FileUtils.copyFile(scrFile, new File("screenshots/" + screenshotName));
            System.out.println("Screenshot saved: " + screenshotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
