package RestAPI_package;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager 
{
    static ExtentReports extent;

    public static ExtentReports getReportObject()
    {
        String path = System.getProperty("user.dir") + "/reports/APIReport.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("REST API Automation Report");
        reporter.config().setDocumentTitle("API Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Aryan Raj");

        return extent;
    }
}