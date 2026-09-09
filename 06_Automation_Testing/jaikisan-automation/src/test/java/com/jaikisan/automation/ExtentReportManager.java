package com.jaikisan.automation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            String reportPath = "test-output/ExtentReport/Jaikisan_Extent_Report.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setDocumentTitle(
                    "Jaikisan Automation Test Report"
            );

            sparkReporter.config().setReportName(
                    "Jaikisan Farmer Market - Selenium Automation"
            );

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project",
                    "Jaikisan Farmer Market Application");

            extent.setSystemInfo("Tester",
                    "Shreya");

            extent.setSystemInfo("Automation Tool",
                    "Selenium WebDriver");

            extent.setSystemInfo("Test Framework",
                    "TestNG");

            extent.setSystemInfo("Build Tool",
                    "Maven");
        }

        return extent;
    }
}