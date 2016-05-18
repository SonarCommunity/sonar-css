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

import org.sonar.css.model.property.validator.ValueElementValidator;
import org.sonar.css.model.value.CssValueElement;
import org.sonar.css.model.value.valueelement.IdentifierValueElement;

public class IdentifierValidator implements ValueElementValidator {

  private final ImmutableList<String> allowedValues;

  public IdentifierValidator() {
    allowedValues = ImmutableList.of();
  }

  public IdentifierValidator(ImmutableList<String> allowedValues) {
    this.allowedValues = allowedValues;
  }

  @Override
  public boolean isValid(@Nonnull CssValueElement cssValueElement) {
    if (cssValueElement instanceof IdentifierValueElement) {
      if (allowedValues.isEmpty()) {
        return true;
      }
      return allowedValues.contains(((IdentifierValueElement) cssValueElement).getName().toLowerCase());
    }
    return false;
  }

  @Override
  @Nonnull
  public String getValidatorFormat() {
    if (allowedValues.isEmpty()) {
      return "<identifier>";
    } else {
      StringBuilder format = new StringBuilder();
      for (String allowedValue : allowedValues) {
        if (format.length() != 0) {
          format.append(" | ");
        }
        format.append(allowedValue);
      }
      return format.toString();
    }
  }
}
