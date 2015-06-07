## Couldn't open app window; is the pop-up blocker enabled? ##
When start the test with IE8, a error message box popped up.
The solution is [disable IE protected mode](http://stackoverflow.com/questions/1517623/internet-explorer-8-64bit-and-selenium-not-working)

  * Disable popup block. - Select "Tools/Popup Blocker/Turn off pop-up blocker"
    * Disable IE protected mode. - Untick "Tools/Internet Options/Security/Enable protected mode"

## Browser Permissions ##

One of the difficulties of running applets in the browser is the security model for applets. Due to the nature of using the awt.Robot for Swing automation, applets required elevated JRE permissions to perform its work. This can be accomplished by using signed jars or modifying the JRE permissions. Signing jars will not be covered here as there is sufficient on-line documentation to provide guidance.
Please follow  [Browser Permissions ](http://docs.codehaus.org/display/FEST/Selenium) to do the change.