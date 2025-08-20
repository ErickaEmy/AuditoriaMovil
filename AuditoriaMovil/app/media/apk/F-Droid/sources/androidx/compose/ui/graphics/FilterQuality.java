package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FilterQuality.kt */
/* loaded from: classes.dex */
public abstract class FilterQuality {
    public static final Companion Companion = new Companion(null);
    private static final int None = m879constructorimpl(0);
    private static final int Low = m879constructorimpl(1);
    private static final int Medium = m879constructorimpl(2);
    private static final int High = m879constructorimpl(3);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m879constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m880equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m881hashCodeimpl(int i) {
        return i;
    }

    /* compiled from: FilterQuality.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNone-f-v9h1I  reason: not valid java name */
        public final int m884getNonefv9h1I() {
            return FilterQuality.None;
        }

        /* renamed from: getLow-f-v9h1I  reason: not valid java name */
        public final int m883getLowfv9h1I() {
            return FilterQuality.Low;
        }
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m882toStringimpl(int i) {
        return m880equalsimpl0(i, None) ? "None" : m880equalsimpl0(i, Low) ? "Low" : m880equalsimpl0(i, Medium) ? "Medium" : m880equalsimpl0(i, High) ? "High" : "Unknown";
    }
}
