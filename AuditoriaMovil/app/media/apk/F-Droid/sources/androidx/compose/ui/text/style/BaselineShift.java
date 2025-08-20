package androidx.compose.ui.text.style;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BaselineShift.kt */
/* loaded from: classes.dex */
public final class BaselineShift {
    private final float multiplier;
    public static final Companion Companion = new Companion(null);
    private static final float Superscript = m1744constructorimpl(0.5f);
    private static final float Subscript = m1744constructorimpl(-0.5f);
    private static final float None = m1744constructorimpl(0.0f);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ BaselineShift m1743boximpl(float f) {
        return new BaselineShift(f);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float m1744constructorimpl(float f) {
        return f;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1745equalsimpl(float f, Object obj) {
        return (obj instanceof BaselineShift) && Float.compare(f, ((BaselineShift) obj).m1749unboximpl()) == 0;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1746equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1747hashCodeimpl(float f) {
        return Float.floatToIntBits(f);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1748toStringimpl(float f) {
        return "BaselineShift(multiplier=" + f + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        return m1745equalsimpl(this.multiplier, obj);
    }

    public int hashCode() {
        return m1747hashCodeimpl(this.multiplier);
    }

    public String toString() {
        return m1748toStringimpl(this.multiplier);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float m1749unboximpl() {
        return this.multiplier;
    }

    private /* synthetic */ BaselineShift(float f) {
        this.multiplier = f;
    }

    /* compiled from: BaselineShift.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNone-y9eOQZs  reason: not valid java name */
        public final float m1750getNoney9eOQZs() {
            return BaselineShift.None;
        }
    }
}
