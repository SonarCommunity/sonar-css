/*
 * SonarQube CSS Plugin
 * Copyright (C) 2013 Tamas Kende
 * kende.tamas@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.css.checks.validators.propertyValue;

import com.sonar.sslr.api.AstNode;

public class PauseValidator implements PropertyValueValidator {

  private final TimeValidator timeValidator = new TimeValidator();

  /*
   * positiveOnly = true even if it is not properly stated that percentage may not be negative
   * at http://www.w3.org/TR/CSS21/aural.html#propdef-pause-after
   */
  private final PercentageValidator percentageValidator = new PercentageValidator(true);

  public boolean isValid(AstNode astNode) {
    return timeValidator.isValid(astNode) || percentageValidator.isValid(astNode);
  }

  public String getFormat() {
    return timeValidator.getFormat() + " | " + percentageValidator.getFormat();
  }

}
