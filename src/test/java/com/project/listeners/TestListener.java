package com.project.listeners;

import com.project.utils.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {
    ScreenshotUtil screenshotUtil = new ScreenshotUtil();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test execution started " + " getName : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case Passed" + " getName : " +  result.getName() + "status : " + result.getStatus());
        try {
            screenshotUtil.takeScreenshot("pass" +result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case failed " + "getName :" + result.getName() + "status :" + result.getStatus());
        try {
            screenshotUtil.takeScreenshot("fail" + result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case skipped" + "getName :" + result.getName() + "status : " + result.getStatus());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test execution started OnStart "+ "getName :"  + context.getName() + " " + context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test case execution finished OnFinish " + "getName :" + context.getName() + " " + context.getEndDate());
    }


}
