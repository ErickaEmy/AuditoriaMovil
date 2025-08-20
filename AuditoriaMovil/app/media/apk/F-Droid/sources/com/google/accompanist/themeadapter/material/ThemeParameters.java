package com.google.accompanist.themeadapter.material;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MdcTheme.kt */
/* loaded from: classes.dex */
public final class ThemeParameters {
    private final Colors colors;
    private final Shapes shapes;
    private final Typography typography;

    public final Colors component1() {
        return this.colors;
    }

    public final Typography component2() {
        return this.typography;
    }

    public final Shapes component3() {
        return this.shapes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ThemeParameters) {
            ThemeParameters themeParameters = (ThemeParameters) obj;
            return Intrinsics.areEqual(this.colors, themeParameters.colors) && Intrinsics.areEqual(this.typography, themeParameters.typography) && Intrinsics.areEqual(this.shapes, themeParameters.shapes);
        }
        return false;
    }

    public int hashCode() {
        Colors colors = this.colors;
        int hashCode = (colors == null ? 0 : colors.hashCode()) * 31;
        Typography typography = this.typography;
        int hashCode2 = (hashCode + (typography == null ? 0 : typography.hashCode())) * 31;
        Shapes shapes = this.shapes;
        return hashCode2 + (shapes != null ? shapes.hashCode() : 0);
    }

    public String toString() {
        return "ThemeParameters(colors=" + this.colors + ", typography=" + this.typography + ", shapes=" + this.shapes + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ThemeParameters(Colors colors, Typography typography, Shapes shapes) {
        this.colors = colors;
        this.typography = typography;
        this.shapes = shapes;
    }
}
