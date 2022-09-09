package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class TestListener implements ITestListener{

    public void onTestStart(ITestResult test) {
        try {
            MonteScreenRecorder.startRecord(test.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSuccess(ITestResult test) {
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File("./test-recordings/" + test.getName() + ".avi");
        file.delete();
    }

    public void onTestFailure(ITestResult test) {
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
