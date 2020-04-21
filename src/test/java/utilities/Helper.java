package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static void captureScreenshot(WebDriver helperDriver,String screenshotname)
	{
		Path dest = Paths.get("./Screenshots",screenshotname+".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream outputStream= new FileOutputStream(dest.toString());
			outputStream.write(((TakesScreenshot)helperDriver).getScreenshotAs(OutputType.BYTES));
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Exception while taking screenshots"+e.getMessage());
			e.printStackTrace();
		}
	}

}
