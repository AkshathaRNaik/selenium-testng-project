package com.project.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    public static ExtentReports getInstance(){
        if(extent==null){
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
            sparkReporter.config().setReportName("Automation test report");
            sparkReporter.config().setDocumentTitle("Execution report");
            // ✅ UI Customization
            sparkReporter.config().setReportName("Automation Test Execution Report");
            sparkReporter.config().setDocumentTitle("QA Execution Report");
            sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
            sparkReporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");

            // ✅ Custom CSS
            sparkReporter.config().setCss(
                    ".nav-wrapper { background-color: #0f172a; }" +
                            ".test-status.pass { background-color: #22c55e !important; }" +
                            ".test-status.fail { background-color: #ef4444 !important; }" +
                            ".test-status.skip { background-color: #f59e0b !important; }"
            );

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Project", "Selenium TestNG Framework");
            extent.setSystemInfo("Tester", "Akshatha");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
