/**
 * origin from package org.fest.swing.core;

/*
 * Created on Sep 21, 2007
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2007-2010 the original author or authors.
 */

package com.nemo.festselenium.core;

import static java.awt.event.InputEvent.*;
import java.awt.event.InputEvent;

/**
 * Mouse buttons. Provides better type safety that the {@code int} values in AWT.
 *
 * @author Alex Ruiz
 * @see org.fest.swing.core.MouseButton
 */
public enum MouseButton {

  LEFT_BUTTON(BUTTON1_MASK), MIDDLE_BUTTON(BUTTON2_MASK), RIGHT_BUTTON(BUTTON3_MASK);

  /**
   * The mouse button modifier.
   * @see InputEvent
   */
  public final int mask;

  private MouseButton(int mask) {
    this.mask = mask;
  }

  /**
   * Returns the mouse button whose mask matches the given mask. Valid values are
   * <code>{@link InputEvent#BUTTON1_MASK}</code>, <code>{@link InputEvent#BUTTON2_MASK}</code>, and
   * <code>{@link InputEvent#BUTTON3_MASK}</code>
   * @param mask the mask of the button we are looking for.
   * @return the found button.
   * @throws IllegalArgumentException if the given mask is not a valid one.
   */
  public static MouseButton lookup(int mask) {
    for (MouseButton button : values())
      if (button.mask == mask) return button;
    throw new IllegalArgumentException(String.valueOf(mask)+" is not a valid button mask");
  }
}
