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
package org.sonar.css.model.atrule;

import org.junit.Test;
import org.sonar.css.model.atrule.standard.CharacterVariant;
import org.sonar.css.model.atrule.standard.Charset;
import org.sonar.css.model.atrule.standard.Keyframes;

import static org.junit.Assert.assertEquals;

public class StandardAtRuleFactoryTest {

  @Test
  public void should_return_a_valid_charset_at_rule_object() {
    StandardAtRule atRule = StandardAtRuleFactory.createStandardAtRule("charset");
    assertEquals(Charset.class, atRule.getClass());
    assertEquals(atRule.getName(), "charset");
    assertEquals(atRule.getLinks().size(), 1);
    assertEquals(atRule.getLinks().get(0), "https://www.w3.org/TR/css-syntax-3/#charset-rule");
    assertEquals(atRule.isObsolete(), false);
    assertEquals(atRule.isExperimental(), false);
  }

  @Test
  public void should_return_a_valid_charset_at_rule_object_uppercase_test() {
    StandardAtRule atRule = StandardAtRuleFactory.createStandardAtRule("CHARSET");
    assertEquals(Charset.class, atRule.getClass());
    assertEquals(atRule.getName(), "charset");
    assertEquals(atRule.getLinks().size(), 1);
    assertEquals(atRule.getLinks().get(0), "https://www.w3.org/TR/css-syntax-3/#charset-rule");
    assertEquals(atRule.isObsolete(), false);
    assertEquals(atRule.isExperimental(), false);
  }

  @Test
  public void should_return_a_valid_character_variant_at_rule_object() {
    StandardAtRule atRule = StandardAtRuleFactory.createStandardAtRule("character-variant");
    assertEquals(CharacterVariant.class, atRule.getClass());
    assertEquals(atRule.getName(), "character-variant");
    assertEquals(atRule.getLinks().size(), 2);
    assertEquals(atRule.getLinks().get(0), "https://drafts.csswg.org/css-fonts-3/#font-feature-values");
    assertEquals(atRule.getLinks().get(1), "https://developer.mozilla.org/en-US/docs/Web/CSS/@font-feature-values");
    assertEquals(atRule.isObsolete(), false);
    assertEquals(atRule.isExperimental(), false);
  }

  @Test
  public void should_return_a_valid_keyframes_at_rule_object() {
    StandardAtRule atRule = StandardAtRuleFactory.createStandardAtRule("keyframes");
    assertEquals(Keyframes.class, atRule.getClass());
    assertEquals(atRule.getName(), "keyframes");
    assertEquals(atRule.getLinks().size(), 1);
    assertEquals(atRule.isObsolete(), false);
    assertEquals(atRule.isExperimental(), true);
  }

}
