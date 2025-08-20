package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Magnifier.kt */
/* loaded from: classes.dex */
public final class MagnifierStyle {
    public static final Companion Companion = new Companion(null);
    private static final MagnifierStyle Default;
    private static final MagnifierStyle TextDefault;
    private final boolean clippingEnabled;
    private final float cornerRadius;
    private final float elevation;
    private final boolean fishEyeEnabled;
    private final long size;
    private final boolean useTextDefault;

    public /* synthetic */ MagnifierStyle(long j, float f, float f2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, f, f2, z, z2);
    }

    public /* synthetic */ MagnifierStyle(boolean z, long j, float f, float f2, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, j, f, f2, z2, z3);
    }

    public final boolean getClippingEnabled$foundation_release() {
        return this.clippingEnabled;
    }

    /* renamed from: getCornerRadius-D9Ej5fM$foundation_release  reason: not valid java name */
    public final float m111getCornerRadiusD9Ej5fM$foundation_release() {
        return this.cornerRadius;
    }

    /* renamed from: getElevation-D9Ej5fM$foundation_release  reason: not valid java name */
    public final float m112getElevationD9Ej5fM$foundation_release() {
        return this.elevation;
    }

    public final boolean getFishEyeEnabled$foundation_release() {
        return this.fishEyeEnabled;
    }

    /* renamed from: getSize-MYxV2XQ$foundation_release  reason: not valid java name */
    public final long m113getSizeMYxV2XQ$foundation_release() {
        return this.size;
    }

    public final boolean getUseTextDefault$foundation_release() {
        return this.useTextDefault;
    }

    private MagnifierStyle(boolean z, long j, float f, float f2, boolean z2, boolean z3) {
        this.useTextDefault = z;
        this.size = j;
        this.cornerRadius = f;
        this.elevation = f2;
        this.clippingEnabled = z2;
        this.fishEyeEnabled = z3;
    }

    public /* synthetic */ MagnifierStyle(long j, float f, float f2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DpSize.Companion.m1927getUnspecifiedMYxV2XQ() : j, (i & 2) != 0 ? Dp.Companion.m1905getUnspecifiedD9Ej5fM() : f, (i & 4) != 0 ? Dp.Companion.m1905getUnspecifiedD9Ej5fM() : f2, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2, (DefaultConstructorMarker) null);
    }

    private MagnifierStyle(long j, float f, float f2, boolean z, boolean z2) {
        this(false, j, f, f2, z, z2, (DefaultConstructorMarker) null);
    }

    public final boolean isSupported() {
        return Companion.isStyleSupported$foundation_release$default(Companion, this, 0, 2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MagnifierStyle) {
            MagnifierStyle magnifierStyle = (MagnifierStyle) obj;
            return this.useTextDefault == magnifierStyle.useTextDefault && DpSize.m1921equalsimpl0(this.size, magnifierStyle.size) && Dp.m1899equalsimpl0(this.cornerRadius, magnifierStyle.cornerRadius) && Dp.m1899equalsimpl0(this.elevation, magnifierStyle.elevation) && this.clippingEnabled == magnifierStyle.clippingEnabled && this.fishEyeEnabled == magnifierStyle.fishEyeEnabled;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((ClickableElement$$ExternalSyntheticBackport0.m(this.useTextDefault) * 31) + DpSize.m1924hashCodeimpl(this.size)) * 31) + Dp.m1900hashCodeimpl(this.cornerRadius)) * 31) + Dp.m1900hashCodeimpl(this.elevation)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.clippingEnabled)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.fishEyeEnabled);
    }

    public String toString() {
        if (this.useTextDefault) {
            return "MagnifierStyle.TextDefault";
        }
        return "MagnifierStyle(size=" + ((Object) DpSize.m1925toStringimpl(this.size)) + ", cornerRadius=" + ((Object) Dp.m1901toStringimpl(this.cornerRadius)) + ", elevation=" + ((Object) Dp.m1901toStringimpl(this.elevation)) + ", clippingEnabled=" + this.clippingEnabled + ", fishEyeEnabled=" + this.fishEyeEnabled + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* compiled from: Magnifier.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MagnifierStyle getDefault() {
            return MagnifierStyle.Default;
        }

        public final MagnifierStyle getTextDefault() {
            return MagnifierStyle.TextDefault;
        }

        public static /* synthetic */ boolean isStyleSupported$foundation_release$default(Companion companion, MagnifierStyle magnifierStyle, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = Build.VERSION.SDK_INT;
            }
            return companion.isStyleSupported$foundation_release(magnifierStyle, i);
        }

        public final boolean isStyleSupported$foundation_release(MagnifierStyle style, int i) {
            Intrinsics.checkNotNullParameter(style, "style");
            if (MagnifierKt.isPlatformMagnifierSupported(i) && !style.getFishEyeEnabled$foundation_release()) {
                return style.getUseTextDefault$foundation_release() || Intrinsics.areEqual(style, getDefault()) || i >= 29;
            }
            return false;
        }
    }

    static {
        MagnifierStyle magnifierStyle = new MagnifierStyle(0L, 0.0f, 0.0f, false, false, 31, (DefaultConstructorMarker) null);
        Default = magnifierStyle;
        TextDefault = new MagnifierStyle(true, magnifierStyle.size, magnifierStyle.cornerRadius, magnifierStyle.elevation, magnifierStyle.clippingEnabled, magnifierStyle.fishEyeEnabled, (DefaultConstructorMarker) null);
    }
}
