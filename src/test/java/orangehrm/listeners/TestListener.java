package orangehrm.listeners;
import orangehrm.base.TestBase;
import orangehrm.utils.ExtentManager;
import orangehrm.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    private static final Logger log = LogManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getExtent();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String name = result.getMethod().getMethodName();
        log.info("STARTED: {}", name);
        ExtentTest t = ExtentManager.getExtent().createTest(name);
        ExtentManager.setTest(t);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("PASSED: {}", result.getMethod().getMethodName());
        ExtentManager.getTest().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String name = result.getMethod().getMethodName();
        log.error("FAILED: {}", name, result.getThrowable());

        ExtentTest t = ExtentManager.getTest();
        t.fail(result.getThrowable());

        Object instance = result.getInstance();
        if (instance instanceof TestBase bt && bt.getDriver() != null) {
            String img = ScreenshotUtils.asBase64(bt.getDriver());
            t.fail("Screenshot on failure",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(img).build());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("SKIPPED: {}", result.getMethod().getMethodName());
        ExtentManager.getTest().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtent().flush();
        ExtentManager.removeTest();
    }

}
