package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TextOverflow.kt */
/* loaded from: classes.dex */
public abstract class TextOverflow {
    public static final Companion Companion = new Companion(null);
    private static final int Clip = m1853constructorimpl(1);
    private static final int Ellipsis = m1853constructorimpl(2);
    private static final int Visible = m1853constructorimpl(3);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1853constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1854equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1855hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1856toStringimpl(int i) {
        return m1854equalsimpl0(i, Clip) ? "Clip" : m1854equalsimpl0(i, Ellipsis) ? "Ellipsis" : m1854equalsimpl0(i, Visible) ? "Visible" : "Invalid";
    }

    /* compiled from: TextOverflow.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getClip-gIe3tQ8  reason: not valid java name */
        public final int m1857getClipgIe3tQ8() {
            return TextOverflow.Clip;
        }

        /* renamed from: getEllipsis-gIe3tQ8  reason: not valid java name */
        public final int m1858getEllipsisgIe3tQ8() {
            return TextOverflow.Ellipsis;
        }

        /* renamed from: getVisible-gIe3tQ8  reason: not valid java name */
        public final int m1859getVisiblegIe3tQ8() {
            return TextOverflow.Visible;
        }
    }
}
