package com.nemo.seleniumfest.fixture;

public class ComponentFixtureTestSupport extends ComponentFixture<ComponentFixtureTestSupport> {
	private String lastCommandResult; 
	ComponentFixtureTestSupport(ComponentContext context) {
		super(context);
	}
	String eval(String script) {
		lastCommandResult = script;
		return script;
	}
	
	String executeFunctionString(String functionString) {
		lastCommandResult=functionString;
		return functionString;
	}
	
	String lastResult() {
		return lastCommandResult;
	}
	
}
