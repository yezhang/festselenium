package com.nemo.seleniumfest.fixture;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

public class LabelFixtureTest extends ComponentFixture_TestCaseBase {

	private LabelFixture componentFixture;
	@Before
	public void setUp() throws Exception {
		componentFixture = new LabelFixture(context);	
	}

	@Test
	public void testText() {
		assertThat(componentFixture.text()).isEqualTo(
				createQueryString("text()"));
	}

	@Test
	public void testRequireText() {
		assertThatReturnsSelf(componentFixture.requireText("expected"));
		assertThat(selenium.lastCommandResult()).isEqualTo(
				createQueryString("requireText(\"expected\")"));
	}

	@Override
	ComponentFixture<?> fixture() {
		// TODO Auto-generated method stub
		return componentFixture;
	}

}
