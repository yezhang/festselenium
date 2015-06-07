# Applet test demo #
## 1, The demo applet we want to verify: ##
```
package com.nemo.festselenium.demo;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class DemoApplet extends JApplet implements AdjustmentListener{

	private static final long serialVersionUID = 1L;
	JScrollBar slider;		
	JTextComponent text;		
	JPanel panel;
	
	public void adjustmentValueChanged(AdjustmentEvent e) {
		text.setText(new Integer(slider.getValue()).toString());
	} 
	
	public DemoApplet(){
		slider = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 100);
		text = new JTextArea("0");
		panel = new JPanel();
		panel.add(text);
		panel.add(slider);
		add(panel);
		slider.addAdjustmentListener(this);
	}
}

```

## 2, create a test fixture for this applet ##
```
package com.nemo.festselenium.demo;

import org.fest.swing.fixture.JAppletFixture;

public class JTestFixture extends DemoApplet {
	JAppletFixture fixture;
	
	public JTestFixture() {
		super();
		
		setName("demo_applet");
		fixture=new JAppletFixture(this);
	}
	  public JAppletFixture getTestFixture() {
		  return fixture;
	  }
}

```
We need create a public function getTestFixture and call setName("demo\_applet") in order festselenium can communicate with it.

## 3 create a test html with applet ID=demo\_applet ##
```
<html>
<head>
<title>Test</title>
</head>
<body>
<div>
<object id="demo_applet" width="300" height="150" type="application/x-java-applet">
    <param name="java_code" value="com.nemo.festselenium.demo.JTestFixture.class" />
    <param name="java_archive" value="fest-swing-1.2a3.jar,fest-assert-1.1.jar,fest-util-1.1.jar,fest-reflect-1.2-SNAPSHOT.jar" />
</object>
</div>
</body>
</html>
```
Notes: this applet depends on _**fest-swing-1.2a3.jar,fest-assert-1.1.jar,fest-util-1.1.jar,fest-reflect-1.2-SNAPSHOT.jar**, you can download it from [fest project](http://code.google.com/p/fest/)_

## 4, create the unit test cases ##
```
package com.nemo.festselenium.demo;

import static org.junit.Assert.*;

import org.junit.*;
import com.nemo.festselenium.fixture.*;
import com.nemo.festselenium.selenium.*;

public class DemoTest {
	DefaultJavaSelenium selenium;
	
	@Before
	public void setUp() {
		selenium = new DefaultJavaSelenium("localhost",4444, "*iexplore" , "http://localhost:8080");		
	}
	
	@After
	public void tearDown() {
		selenium.stop();
	}
	@Test
	public void test() {

		selenium.start();
		selenium.open("demo_applet.html");
		selenium.windowMaximize();
		AppletFixture fixture = selenium.applet("demo_applet");
		ScrollBarFixture scrollbar = fixture.scrollBar();
		TextComponentFixture text = fixture.textBox();
		scrollbar.scrollUnitUp();
		assertEquals(text.text(), "1");		
	}	

}
```

Note: The unit test depends on _**festselenium-1.0.jar, selenium-server-standalone-2.25.0.jar and selenium-java-2.25.0.jar** . the last two jar can be download from [selenium offical site](http://www.eclipse.org/downloads/)_

## selenium interaction ##
```

D:\Automation>java -jar D:\Automation\selenium-server-standalone-2.25.0.jar  -ti
meout 10000000
2012-12-31 15:19:49 org.openqa.grid.selenium.GridLauncher main
信息: Launching a standalone server
15:19:49.751 INFO - Java: Sun Microsystems Inc. 11.3-b02
15:19:49.751 INFO - OS: Windows Vista 6.1 x86
15:19:49.751 INFO - v2.25.0, with Core v2.25.0. Built from revision 17482
15:19:49.845 INFO - RemoteWebDriver instances should connect to: http://127.0.0.
1:4444/wd/hub
15:19:49.845 INFO - Version Jetty/5.1.x
15:19:49.845 INFO - Started HttpContext[/selenium-server/driver,/selenium-server
/driver]
15:19:49.845 INFO - Started HttpContext[/selenium-server,/selenium-server]
15:19:49.845 INFO - Started HttpContext[/,/]
15:19:49.876 INFO - Started org.openqa.jetty.jetty.servlet.ServletHandler@1a62c3
1
15:19:49.876 INFO - Started HttpContext[/wd,/wd]
15:19:49.876 INFO - Started SocketListener on 0.0.0.0:4444
15:19:49.876 INFO - Started org.openqa.jetty.jetty.Server@2bb514
15:19:56.179 INFO - Checking Resource aliases
15:19:56.179 INFO - Command request: getNewBrowserSession[*iexplore, http://loca
lhost:8080, ] on session null
15:19:56.179 INFO - creating new remote session
15:19:56.195 INFO - Allocated session a84fc3216d6c41f1865ab7a710189814 for http:
//localhost:8080, launching...
jar:file:/D:/Automation/selenium-server-standalone-2.25.0.jar!/core
15:19:56.725 INFO - Launching Embedded Internet Explorer...
15:19:56.959 INFO - Launching Internet Explorer HTA...
15:20:04.644 INFO - Got result: OK,a84fc3216d6c41f1865ab7a710189814 on session a
84fc3216d6c41f1865ab7a710189814
15:20:04.659 INFO - Command request: open[demo_applet.html, ] on session a84fc32
16d6c41f1865ab7a710189814
15:20:08.208 INFO - Got result: OK on session a84fc3216d6c41f1865ab7a710189814
15:20:08.223 INFO - Command request: windowMaximize[, ] on session a84fc3216d6c4
1f1865ab7a710189814
15:20:08.847 INFO - Got result: OK on session a84fc3216d6c41f1865ab7a710189814
15:20:08.847 INFO - Command request: getEval[navigator.userAgent, ] on session a
84fc3216d6c41f1865ab7a710189814
15:20:09.362 INFO - Got result: OK,Mozilla/4.0 (compatible; MSIE 7.0; Windows NT
 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CL
R 3.0.30729; eSobiSubscriber 2.0.4.16; MAAR; .NET4.0C; .NET4.0E; InfoPath.2) on
session a84fc3216d6c41f1865ab7a710189814
15:20:09.378 INFO - Command request: getEval[window.document.getElementById("dem
o_applet").getTestFixture().scrollBar().scrollUnitUp(), ] on session a84fc3216d6
c41f1865ab7a710189814
15:20:10.189 INFO - Got result: OK,org.fest.swing.fixture.JScrollBarFixture@1199
c2e on session a84fc3216d6c41f1865ab7a710189814
15:20:10.205 INFO - Command request: getEval[window.document.getElementById("dem
o_applet").getTestFixture().textBox().text(), ] on session a84fc3216d6c41f1865ab
7a710189814
15:20:10.719 INFO - Got result: OK,1 on session a84fc3216d6c41f1865ab7a710189814

15:20:10.719 INFO - Command request: testComplete[, ] on session a84fc3216d6c41f
1865ab7a710189814
15:20:10.719 WARN - Embedded iexplore seems to have ended on its own (did we kil
l the real browser???)
15:20:10.782 INFO - Got result: OK on session a84fc3216d6c41f1865ab7a710189814

```