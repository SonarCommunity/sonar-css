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
package org.sonar.css.checks;

import com.google.common.collect.ImmutableList;

import java.util.Collection;

public final class CheckList {

  public static final String REPOSITORY_KEY = "css";

  public static final String REPOSITORY_NAME = "SonarQube";

  private CheckList() {
  }

  @SuppressWarnings("rawtypes")
  public static Collection<Class> getChecks() {
    return ImmutableList.<Class>of(
      AllGradientDefinitions.class,
      AlphabetizeDeclarationsCheck.class,
      BOMCheck.class,
      BewareOfBoxModel.class,
      CaseCheck.class,
      CharsetFirstCheck.class,
      CommentRegularExpressionCheck.class,
      CompatibleVendorPrefixes.class,
      FormattingCheck.class,
      DeprecatedSystemColorsCheck.class,
      DeprecatedIEStaticFiltersCheck.class,
      DisallowDuplicateBackgroundImages.class,
      DisallowEmptyRules.class,
      DisallowIdsInSelectors.class,
      DisallowImport.class,
      DisallowImportant.class,
      DisallowOverqualifiedElements.class,
      DisallowOverspecificSelectors.class,
      DisallowSelectorsLikeRegEx.class,
      DisallowStarHack.class,
      DisallowUnderscoreHack.class,
      DisallowUnitsForZeroValues.class,
      DisallowUniversalSelector.class,
      DisplayPropertyGrouping.class,
      DuplicatedProperties.class,
      EmptyDeclarationCheck.class,
      ExperimentalFunctionUsageCheck.class,
      ExperimentalAtRuleUsageCheck.class,
      ExperimentalPropertyUsageCheck.class,
      FontFaceBrowserCompatibility.class,
      FixmeTagPresenceCheck.class,
      ImportantPositionCheck.class,
      ImportNumberThreshold.class,
      ImportFirstCheck.class,
      InliningFontFilesCheck.class,
      UnnownPropertiesCheck.class,
      LeadingZerosCheck.class,
      LineLengthCheck.class,
      MaximumNumberOfRulesPerSheetCheck.class,
      NosonarTagPresenceCheck.class,
      ObsoleteFunctionsCheck.class,
      ObsoletePropertiesCheck.class,
      OneDeclarationPerLineCheck.class,
      ParsingErrorCheck.class,
      PropertyRegularExpressionCheck.class,
      SelectorNumberThreshold.class,
      SelectorNamingConventionCheck.class,
      SemicolonDeclarationCheck.class,
      ShorthandProperties.class,
      TabCharacterCheck.class,
      TrailingWhitespaceCheck.class,
      TodoTagPresenceCheck.class,
      TooManyWebFonts.class,
      UnknownFunctionsCheck.class,
      UnknownAtRulesCheck.class,
      ValidatePropertyValueCheck.class,
      VendorPrefixWithStandard.class);
  }
}
