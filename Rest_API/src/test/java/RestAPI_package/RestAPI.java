package RestAPI_package;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class RestAPI 
{
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void config()
    {
        extent = ExtentManager.getReportObject();
    }

    @Test
    public void getUsers()
    {
        test = extent.createTest("Get User API Test");

        given()

        .when().get("https://dummyjson.com/users/1")

        .then().statusCode(200)
        .log().all();

        test.pass("User API Test Passed Successfully");
    }

    @AfterTest
    public void tearDown()
    {
        extent.flush();
    }
}