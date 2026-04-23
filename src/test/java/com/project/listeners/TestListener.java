package com.project.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.project.utils.ExtentManager;
import com.project.utils.ScreenshotUtil;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    ScreenshotUtil screenshotUtil = new ScreenshotUtil();
    private static ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test execution started " + " getName : " + result.getName());
        ExtentTest extentTest = ExtentManager.getInstance().createTest(result.getName());
        threadLocal.set(extentTest);
        // ✅ Add category + author
        threadLocal.get().assignCategory(result.getTestClass().getName());
        threadLocal.get().info("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case Passed" + " getName : " + result.getName() + "status : " + result.getStatus());
        threadLocal.get().pass("Test Passed");
        try {
            String path = screenshotUtil.takeScreenshot("fail" + result.getName());
            threadLocal.get().addScreenCaptureFromPath(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case failed " + "getName :" + result.getName() + "status :" + result.getStatus());
        threadLocal.get().fail("Test failed");
        threadLocal.get().fail(result.getThrowable());
        try {
            String path = screenshotUtil.takeScreenshot("fail" + result.getName());
            threadLocal.get().addScreenCaptureFromPath(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case skipped" + "getName :" + result.getName() + "status : " + result.getStatus());
        threadLocal.get().skip("Test skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test execution started OnStart " + "getName :" + context.getName() + " " + context.getStartDate());
        ExtentManager.getInstance();
        try {
            FileUtils.cleanDirectory(new File("reports/"));
            FileUtils.cleanDirectory(new File("Screenshots/"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test case execution finished OnFinish " + "getName :" + context.getName() + " " + context.getEndDate());
        ExtentManager.getInstance().flush();
    }


}
