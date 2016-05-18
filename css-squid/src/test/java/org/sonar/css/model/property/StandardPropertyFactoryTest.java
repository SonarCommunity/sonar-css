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
package org.sonar.css.model.property;

import org.junit.Test;
import org.sonar.css.model.Vendor;
import org.sonar.css.model.property.standard.Border;
import org.sonar.css.model.property.standard.BorderEnd;
import org.sonar.css.model.property.standard.BorderImage;

import static org.junit.Assert.assertEquals;

public class StandardPropertyFactoryTest {

  @Test
  public void should_return_a_valid_border_property_object() {
    StandardProperty property = StandardPropertyFactory.createStandardProperty("border");
    assertEquals(Border.class, property.getClass());
    assertEquals(property.getName(), "border");
    assertEquals(property.getLinks().size(), 1);
    assertEquals(property.getLinks().get(0), "http://dev.w3.org/csswg/css-backgrounds-3/#the-border-shorthands");
    assertEquals(property.getVendors().size(), 0);
    assertEquals(property.isObsolete(), false);
  }

  @Test
  public void should_return_a_valid_border_property_object_uppercase_test() {
    StandardProperty property = StandardPropertyFactory.createStandardProperty("BORDER");
    assertEquals(Border.class, property.getClass());
    assertEquals(property.getName(), "border");
    assertEquals(property.getLinks().size(), 1);
    assertEquals(property.getLinks().get(0), "http://dev.w3.org/csswg/css-backgrounds-3/#the-border-shorthands");
    assertEquals(property.getVendors().size(), 0);
    assertEquals(property.isObsolete(), false);
  }

  @Test
  public void should_return_a_valid_border_end_property_object() {
    StandardProperty property = StandardPropertyFactory.createStandardProperty("border-end");
    assertEquals(BorderEnd.class, property.getClass());
    assertEquals(property.getName(), "border-end");
    assertEquals(property.getLinks().size(), 0);
    assertEquals(property.getValidators().size(), 0);
    assertEquals(property.getVendors().size(), 0);
    assertEquals(property.isObsolete(), true);
  }

  @Test
  public void should_return_a_valid_border_image_property_object() {
    StandardProperty property = StandardPropertyFactory.createStandardProperty("border-image");
    assertEquals(BorderImage.class, property.getClass());
    assertEquals(property.getName(), "border-image");
    assertEquals(property.getLinks().size(), 1);
    assertEquals(property.getLinks().get(0), "http://dev.w3.org/csswg/css-backgrounds-3/#border-image");
    assertEquals(property.getValidators().size(), 0);
    assertEquals(property.getVendors().size(), 3);
    assertEquals(property.getVendors().contains(Vendor.WEBKIT), true);
    assertEquals(property.getVendors().contains(Vendor.MOZILLA), true);
    assertEquals(property.getVendors().contains(Vendor.OPERA), true);
    assertEquals(property.getVendors().contains(Vendor.MICROSOFT), false);
    assertEquals(property.isObsolete(), false);
  }

  @Test
  public void should_return_an_unknown_property_object() {
    StandardProperty property = StandardPropertyFactory.createStandardProperty("Bla-bla");
    assertEquals(UnknownProperty.class, property.getClass());
    assertEquals("bla-bla", property.getName());
    assertEquals(property.getLinks().size(), 0);
    assertEquals(property.getValidators().size(), 0);
    assertEquals(property.getVendors().size(), 0);
    assertEquals(property.isObsolete(), false);
  }

}
