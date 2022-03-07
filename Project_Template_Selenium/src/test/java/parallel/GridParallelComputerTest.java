package parallel;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 */
public class GridParallelComputerTest {

    

    @Test
    public void runAllTests() {
        Class<?>[] classes = {Parallel.class};

        // ParallelComputer(true,true) will run all classes and methods
        // in parallel.  (First arg for classes, second arg for methods)
        // I set true, true this means classes and methods runs in parallel.
        JUnitCore.runClasses(new ParallelComputer(true, true), classes);
        
    }
}