package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utilities.ScreenshotUtil;

public class Hooks {
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			ScreenshotUtil.capture(scenario.getName());
		}
	}
}