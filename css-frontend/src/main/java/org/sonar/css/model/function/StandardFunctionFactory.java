/*
 * SonarQube CSS Plugin
 * Copyright (C) 2013-2016 Tamas Kende and David RACODON
 * mailto: kende.tamas@gmail.com and david.racodon@gmail.com
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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.css.model.function;

import com.google.common.collect.ImmutableSet;

import java.util.*;

import org.sonar.css.model.function.standard.*;

public class StandardFunctionFactory {

  private static final Set<Class> ALL_FUNCTION_CLASSES = ImmutableSet.of(
    Alpha.class,
    Annotation.class,
    Attr.class,
    Basicimage.class,
    Blendtrans.class,
    Blur.class,
    Brightness.class,
    Calc.class,
    CharacterVariant.class,
    Chroma.class,
    Circle.class,
    ColorStop.class,
    Compositor.class,
    ConicGradient.class,
    Contrast.class,
    Counter.class,
    Counters.class,
    CrossFade.class,
    CubicBezier.class,
    Domain.class,
    DropShadow.class,
    Ease.class,
    EaseIn.class,
    EaseInOut.class,
    EaseOut.class,
    Element.class,
    Ellipse.class,
    Emboss.class,
    Engrave.class,
    Expression.class,
    FitContent.class,
    Fliph.class,
    Flipv.class,
    Format.class,
    From.class,
    Glow.class,
    Gradient.class,
    Gray.class,
    Grayscale.class,
    Hsl.class,
    Hsla.class,
    HueRotate.class,
    Icmfilter.class,
    Image.class,
    ImageSet.class,
    Inset.class,
    Invert.class,
    Light.class,
    Linear.class,
    LinearGradient.class,
    Local.class,
    MaskFilter.class,
    Matrix.class,
    Matrix3d.class,
    Max.class,
    MicrosoftFilterAlpha.class,
    MicrosoftFilterBasicImage.class,
    MicrosoftFilterBlendTrans.class,
    MicrosoftFilterBlur.class,
    MicrosoftFilterChroma.class,
    MicrosoftFilterCompositor.class,
    MicrosoftFilterDropShadow.class,
    MicrosoftFilterEmboss.class,
    MicrosoftFilterEngrave.class,
    MicrosoftFilterFlipH.class,
    MicrosoftFilterFlipV.class,
    MicrosoftFilterGlow.class,
    MicrosoftFilterGray.class,
    MicrosoftFilterICMFilter.class,
    MicrosoftFilterInvert.class,
    MicrosoftFilterLight.class,
    MicrosoftFilterMaskFilter.class,
    MicrosoftFilterMatrix.class,
    MicrosoftFilterMotionBlur.class,
    MicrosoftFilterRedirect.class,
    MicrosoftFilterRevealTrans.class,
    MicrosoftFilterShadow.class,
    MicrosoftFilterWave.class,
    MicrosoftFilterXray.class,
    MicrosoftSurfaceAlphaImageLoader.class,
    MicrosoftSurfaceGradient.class,
    MicrosoftTransitionBarn.class,
    MicrosoftTransitionBlinds.class,
    MicrosoftTransitionCheckerBoard.class,
    MicrosoftTransitionFade.class,
    MicrosoftTransitionGradientWipe.class,
    MicrosoftTransitionInset.class,
    MicrosoftTransitionIris.class,
    MicrosoftTransitionPixelate.class,
    MicrosoftTransitionRadialWipe.class,
    MicrosoftTransitionRandomBars.class,
    MicrosoftTransitionRandomDissolve.class,
    MicrosoftTransitionSide.class,
    MicrosoftTransitionSpiral.class,
    MicrosoftTransitionStretch.class,
    MicrosoftTransitionStrips.class,
    MicrosoftTransitionWheel.class,
    MicrosoftTransitionZigzag.class,
    Min.class,
    Minmax.class,
    Motionblur.class,
    Opacity.class,
    Ornaments.class,
    Perspective.class,
    Polygon.class,
    RadialGradient.class,
    Rect.class,
    Redirect.class,
    Regexp.class,
    RepeatingConicGradient.class,
    RepeatingLinearGradient.class,
    RepeatingRadialGradient.class,
    Revealtrans.class,
    Rgb.class,
    Rgba.class,
    Rotate.class,
    Rotate3d.class,
    Rotatex.class,
    Rotatey.class,
    Rotatez.class,
    Running.class,
    Saturate.class,
    Scale.class,
    Scale3d.class,
    Scalex.class,
    Scaley.class,
    Scalez.class,
    Sepia.class,
    Shadow.class,
    Skew.class,
    Skewx.class,
    Skewy.class,
    Snapinterval.class,
    Snaplist.class,
    StepEnd.class,
    Steps.class,
    StepStart.class,
    Styleset.class,
    Stylistic.class,
    Supports.class,
    Swash.class,
    Symbols.class,
    To.class,
    Toggle.class,
    Translate.class,
    Translate3d.class,
    Translatex.class,
    Translatey.class,
    Translatez.class,
    Url.class,
    UrlPrefix.class,
    Var.class,
    Wave.class,
    Xray.class);

  private static final Map<String, StandardFunction> ALL = new HashMap<>();

  static {
    try {
      StandardFunction standardFunction;
      for (Class clazz : ALL_FUNCTION_CLASSES) {
        standardFunction = (StandardFunction) clazz.newInstance();
        ALL.put(standardFunction.getName(), standardFunction);
      }
    } catch (InstantiationException | IllegalAccessException e) {
      throw new IllegalStateException("CSS function full list cannot be created.", e);
    }
  }

  private StandardFunctionFactory() {
  }

  public static StandardFunction getByName(String functionName) {
    StandardFunction standardFunction = ALL.get(functionName.toLowerCase(Locale.ENGLISH));
    return standardFunction != null ? standardFunction : new UnknownFunction(functionName);
  }

  public static List<StandardFunction> getAll() {
    return new ArrayList<>(ALL.values());
  }

}
