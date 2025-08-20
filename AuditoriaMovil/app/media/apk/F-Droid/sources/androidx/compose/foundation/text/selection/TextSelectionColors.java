package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Color;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TextSelectionColors.kt */
/* loaded from: classes.dex */
public final class TextSelectionColors {
    private final long backgroundColor;
    private final long handleColor;

    public /* synthetic */ TextSelectionColors(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    /* renamed from: getBackgroundColor-0d7_KjU  reason: not valid java name */
    public final long m424getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    /* renamed from: getHandleColor-0d7_KjU  reason: not valid java name */
    public final long m425getHandleColor0d7_KjU() {
        return this.handleColor;
    }

    private TextSelectionColors(long j, long j2) {
        this.handleColor = j;
        this.backgroundColor = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextSelectionColors) {
            TextSelectionColors textSelectionColors = (TextSelectionColors) obj;
            return Color.m851equalsimpl0(this.handleColor, textSelectionColors.handleColor) && Color.m851equalsimpl0(this.backgroundColor, textSelectionColors.backgroundColor);
        }
        return false;
    }

    public int hashCode() {
        return (Color.m857hashCodeimpl(this.handleColor) * 31) + Color.m857hashCodeimpl(this.backgroundColor);
    }

    public String toString() {
        return "SelectionColors(selectionHandleColor=" + ((Object) Color.m858toStringimpl(this.handleColor)) + ", selectionBackgroundColor=" + ((Object) Color.m858toStringimpl(this.backgroundColor)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
