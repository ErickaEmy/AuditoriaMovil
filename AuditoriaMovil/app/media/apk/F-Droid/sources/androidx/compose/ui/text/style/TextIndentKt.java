package androidx.compose.ui.text.style;

import androidx.compose.ui.text.SpanStyleKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextIndent.kt */
/* loaded from: classes.dex */
public abstract class TextIndentKt {
    public static final TextIndent lerp(TextIndent start, TextIndent stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return new TextIndent(SpanStyleKt.m1566lerpTextUnitInheritableC3pnCVY(start.m1844getFirstLineXSAIIZE(), stop.m1844getFirstLineXSAIIZE(), f), SpanStyleKt.m1566lerpTextUnitInheritableC3pnCVY(start.m1845getRestLineXSAIIZE(), stop.m1845getRestLineXSAIIZE(), f), null);
    }
}
