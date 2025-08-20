package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.unit.Dp;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BorderStroke.kt */
/* loaded from: classes.dex */
public final class BorderStroke {
    private final Brush brush;
    private final float width;

    public /* synthetic */ BorderStroke(float f, Brush brush, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush);
    }

    public final Brush getBrush() {
        return this.brush;
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m88getWidthD9Ej5fM() {
        return this.width;
    }

    private BorderStroke(float f, Brush brush) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.width = f;
        this.brush = brush;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BorderStroke) {
            BorderStroke borderStroke = (BorderStroke) obj;
            return Dp.m1899equalsimpl0(this.width, borderStroke.width) && Intrinsics.areEqual(this.brush, borderStroke.brush);
        }
        return false;
    }

    public int hashCode() {
        return (Dp.m1900hashCodeimpl(this.width) * 31) + this.brush.hashCode();
    }

    public String toString() {
        return "BorderStroke(width=" + ((Object) Dp.m1901toStringimpl(this.width)) + ", brush=" + this.brush + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
