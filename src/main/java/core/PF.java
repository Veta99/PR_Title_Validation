package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class PF {
	public static void main(String[] args) {
			String test_case_id = null;
			String url = null;
			String title_expected = null;
			Properties of_pf = new Properties();
		
			try {
			of_pf.load(new FileInputStream("C:/Workspace/PR_Title_Vavidation/src/main/resources/pf.txt"));
				test_case_id = of_pf.getProperty("test_case_id");
				url = of_pf.getProperty("url");
				title_expected = of_pf.getProperty("title_expected");
			} catch (IOException e) {
				e.printStackTrace();
}
			WebDriver driver = new HtmlUnitDriver(); //Version 1.2::HtmlUnit
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();
			
			if( title_expected.equals(title_actual)){
				System.out.println("Test Case ID: \t\t" + test_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actial: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "PASSED");
			}else {
				System.out.println("Test Case ID: \t\t" + test_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actial: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "FAILED");
			}
			driver.quit();
			}
}
//end
