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
import org.sonar.css.parser.CssGrammar;

import java.util.List;

public abstract class DimensionValidator implements PropertyValueValidator {

  private final boolean positiveOnly;
  private EnumValidator unitValidator;

  public DimensionValidator(boolean positiveOnly, List<String> units) {
    this.positiveOnly = positiveOnly;
    unitValidator = new EnumValidator(units);
  }

  public boolean isPositiveOnly() {
    return positiveOnly;
  }

  public boolean isValid(AstNode astNode) {
    if (astNode.getFirstChild(CssGrammar.DIMENSION) != null
      && astNode.getFirstChild(CssGrammar.DIMENSION).getFirstChild(CssGrammar.NUMBER) != null
      && astNode.getFirstChild(CssGrammar.DIMENSION).getFirstChild(CssGrammar.unit) != null) {
      if (positiveOnly) {
        return Double.valueOf(astNode.getFirstChild(CssGrammar.DIMENSION).getFirstChild(CssGrammar.NUMBER).getTokenValue()) >= 0
          && unitValidator.isValid(astNode.getFirstChild(CssGrammar.DIMENSION).getFirstChild(CssGrammar.unit));
      } else {
        return unitValidator.isValid(astNode.getFirstChild(CssGrammar.DIMENSION).getFirstChild(CssGrammar.unit));
      }
    }
    if (astNode.getFirstChild(CssGrammar.NUMBER) != null) {
      return new ZeroNumberValidator().isValid(astNode.getFirstChild(CssGrammar.NUMBER));
    }
    return false;
  }

}
