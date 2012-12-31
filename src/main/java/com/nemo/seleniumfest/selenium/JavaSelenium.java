package com.nemo.seleniumfest.selenium;

import com.nemo.seleniumfest.fixture.AppletFixture;

public interface JavaSelenium {

	String eval(String action);

	AppletFixture applet(String name);
	
//	String getJSPrefix();
}
