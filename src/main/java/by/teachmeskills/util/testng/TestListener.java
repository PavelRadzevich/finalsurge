package by.teachmeskills.util.testng;

import by.teachmeskills.page.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {
    private Logger log = LogManager.getLogger(LoginPage.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("======================================== STARTING TEST {} ========================================", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("======================================== FINISHED TEST {} Duration: {}s ========================================", result.getName(),
                getExecutionTime(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("======================================== SKIPPING TEST {} ========================================", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private long getExecutionTime(ITestResult result) {
        return TimeUnit.MILLISECONDS.toSeconds(result.getEndMillis() - result.getStartMillis());
    }


}