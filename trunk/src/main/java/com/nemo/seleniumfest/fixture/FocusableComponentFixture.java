package com.nemo.seleniumfest.fixture;

public interface FocusableComponentFixture {

	/***********From FocusableComponentFixture *********************/
	/**
	 * Origine from FocusableComponentFixture in fest swing
	 * 
	 * Gives input focus to this fixture's GUI component.
	 * @return this fixture.
	 * @throws SeleniumException
	 *             If selenium communication failed
	 * @throws SeleniumException
	 *             If fest side throw exception
	 */
	public abstract FocusableComponentFixture focus();

	/* (non-Javadoc)
	 * @see com.nemo.seleniumfest.fixture.StateVerificationFixture#requireFocused()
	 */
	public abstract FocusableComponentFixture requireFocused();

}