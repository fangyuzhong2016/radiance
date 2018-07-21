/*
 * Copyright (c) 2005-2018 Substance Kirill Grouchnikov. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  o Neither the name of Substance Kirill Grouchnikov nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.pushingpixels.substance.extras.api.painterpack.decoration;

import org.pushingpixels.substance.api.SubstanceSkin;
import org.pushingpixels.substance.api.SubstanceSlices.DecorationAreaType;
import org.pushingpixels.substance.api.colorscheme.SubstanceColorScheme;
import org.pushingpixels.substance.api.painter.decoration.SubstanceDecorationPainter;

import java.awt.*;

/**
 * Decoration painter that paints a 3D glass gradient. This class is part of
 * officially supported API.
 *
 * @author Kirill Grouchnikov
 */
public class Glass3DDecorationPainter implements SubstanceDecorationPainter {
    /**
     * The display name for the decoration painters of this class.
     */
    public static final String DISPLAY_NAME = "Glass 3D";

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }

    @Override
    public void paintDecorationArea(Graphics2D graphics, Component comp,
            DecorationAreaType decorationAreaType, int width, int height,
            SubstanceSkin skin) {
        SubstanceColorScheme colorScheme = skin.getBackgroundColorScheme(decorationAreaType);
        LinearGradientPaint paint = new LinearGradientPaint(0, 0, 0, height,
                new float[] { 0.0f, 0.4f, 0.5f, 1.0f },
                new Color[] { colorScheme.getUltraLightColor(), colorScheme.getLightColor(),
                        colorScheme.getMidColor(), colorScheme.getUltraLightColor() },
                MultipleGradientPaint.CycleMethod.REPEAT);
        graphics.setPaint(paint);
        graphics.fillRect(0, 0, width, height);
    }

    @Override
    public void paintDecorationArea(Graphics2D graphics, Component comp, DecorationAreaType
            decorationAreaType, Shape contour, SubstanceColorScheme colorScheme) {
        LinearGradientPaint paint = new LinearGradientPaint(0, 0, 0, comp.getHeight(),
                new float[] { 0.0f, 0.4f, 0.5f, 1.0f },
                new Color[] { colorScheme.getUltraLightColor(), colorScheme.getLightColor(),
                        colorScheme.getMidColor(), colorScheme.getUltraLightColor() },
                MultipleGradientPaint.CycleMethod.REPEAT);
        graphics.setPaint(paint);
        graphics.fill(contour);
    }
}
