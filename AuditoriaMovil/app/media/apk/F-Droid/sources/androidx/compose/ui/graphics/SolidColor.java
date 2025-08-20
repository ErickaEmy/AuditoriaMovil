package androidx.compose.ui.graphics;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Brush.kt */
/* loaded from: classes.dex */
public final class SolidColor extends Brush {
    private final long value;

    public /* synthetic */ SolidColor(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: getValue-0d7_KjU  reason: not valid java name */
    public final long m962getValue0d7_KjU() {
        return this.value;
    }

    private SolidColor(long j) {
        super(null);
        this.value = j;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* renamed from: applyTo-Pq9zytI */
    public void mo831applyToPq9zytI(long j, Paint p, float f) {
        long m849copywmQWz5c$default;
        Intrinsics.checkNotNullParameter(p, "p");
        p.setAlpha(1.0f);
        if (f == 1.0f) {
            m849copywmQWz5c$default = this.value;
        } else {
            long j2 = this.value;
            m849copywmQWz5c$default = Color.m849copywmQWz5c$default(j2, Color.m852getAlphaimpl(j2) * f, 0.0f, 0.0f, 0.0f, 14, null);
        }
        p.mo777setColor8_81llA(m849copywmQWz5c$default);
        if (p.getShader() != null) {
            p.setShader(null);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SolidColor) && Color.m851equalsimpl0(this.value, ((SolidColor) obj).value);
    }

    public int hashCode() {
        return Color.m857hashCodeimpl(this.value);
    }

    public String toString() {
        return "SolidColor(value=" + ((Object) Color.m858toStringimpl(this.value)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
