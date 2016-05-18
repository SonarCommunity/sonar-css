/*
 * SonarQube CSS Plugin
 * Copyright (C) 2013 Tamas Kende and David RACODON
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
package org.sonar.css.model.property.validator.valueelement;

import com.google.common.collect.ImmutableList;

import javax.annotation.Nonnull;

import org.sonar.css.model.Color;
import org.sonar.css.model.property.validator.ValueElementValidator;
import org.sonar.css.model.property.validator.valueelement.function.FunctionValidator;
import org.sonar.css.model.value.CssValueElement;

public class ColorValidator implements ValueElementValidator {

  @Override
  public boolean isValid(@Nonnull CssValueElement cssValueElement) {
    return new IdentifierValidator(Color.SVG_COLORS).isValid(cssValueElement)
      || new IdentifierValidator(Color.CSS4_COLORS).isValid(cssValueElement)
      || new IdentifierValidator(Color.CSS2_SYSTEM_COLORS).isValid(cssValueElement)
      || new IdentifierValidator(ImmutableList.of("transparent", "currentcolor")).isValid(cssValueElement)
      || new FunctionValidator(ImmutableList.of("rgb", "rgba", "hsl", "hsla")).isValid(cssValueElement)
      || new HashValidator().isValid(cssValueElement);
  }

  @Nonnull
  @Override
  public String getValidatorFormat() {
    return "<color>";
  }

}
