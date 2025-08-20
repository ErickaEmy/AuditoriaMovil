package androidx.compose.ui.text.style;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextMotion.android.kt */
/* loaded from: classes.dex */
public final class TextMotion {
    private static final TextMotion Animated;
    public static final Companion Companion = new Companion(null);
    private static final TextMotion Static;
    private final int linearity;
    private final boolean subpixelTextPositioning;

    public /* synthetic */ TextMotion(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z);
    }

    /* renamed from: getLinearity-4e0Vf04$ui_text_release  reason: not valid java name */
    public final int m1846getLinearity4e0Vf04$ui_text_release() {
        return this.linearity;
    }

    public final boolean getSubpixelTextPositioning$ui_text_release() {
        return this.subpixelTextPositioning;
    }

    private TextMotion(int i, boolean z) {
        this.linearity = i;
        this.subpixelTextPositioning = z;
    }

    /* compiled from: TextMotion.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextMotion getStatic() {
            return TextMotion.Static;
        }
    }

    static {
        Linearity.Companion companion = Linearity.Companion;
        Static = new TextMotion(companion.m1850getFontHinting4e0Vf04(), false, null);
        Animated = new TextMotion(companion.m1851getLinear4e0Vf04(), true, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextMotion) {
            TextMotion textMotion = (TextMotion) obj;
            return Linearity.m1848equalsimpl0(this.linearity, textMotion.linearity) && this.subpixelTextPositioning == textMotion.subpixelTextPositioning;
        }
        return false;
    }

    public int hashCode() {
        return (Linearity.m1849hashCodeimpl(this.linearity) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.subpixelTextPositioning);
    }

    public String toString() {
        return Intrinsics.areEqual(this, Static) ? "TextMotion.Static" : Intrinsics.areEqual(this, Animated) ? "TextMotion.Animated" : "Invalid";
    }

    /* compiled from: TextMotion.android.kt */
    /* loaded from: classes.dex */
    public static final class Linearity {
        public static final Companion Companion = new Companion(null);
        private static final int Linear = m1847constructorimpl(1);
        private static final int FontHinting = m1847constructorimpl(2);
        private static final int None = m1847constructorimpl(3);

        /* renamed from: constructor-impl  reason: not valid java name */
        private static int m1847constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1848equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m1849hashCodeimpl(int i) {
            return i;
        }

        /* compiled from: TextMotion.android.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getLinear-4e0Vf04  reason: not valid java name */
            public final int m1851getLinear4e0Vf04() {
                return Linearity.Linear;
            }

            /* renamed from: getFontHinting-4e0Vf04  reason: not valid java name */
            public final int m1850getFontHinting4e0Vf04() {
                return Linearity.FontHinting;
            }

            /* renamed from: getNone-4e0Vf04  reason: not valid java name */
            public final int m1852getNone4e0Vf04() {
                return Linearity.None;
            }
        }
    }
}
