package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import ch.qos.logback.core.CoreConstants;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Color.kt */
/* loaded from: classes.dex */
public final class Color {
    private final long value;
    public static final Companion Companion = new Companion(null);
    private static final long Black = ColorKt.Color(4278190080L);
    private static final long DarkGray = ColorKt.Color(4282664004L);
    private static final long Gray = ColorKt.Color(4287137928L);
    private static final long LightGray = ColorKt.Color(4291611852L);
    private static final long White = ColorKt.Color((long) BodyPartID.bodyIdMax);
    private static final long Red = ColorKt.Color(4294901760L);
    private static final long Green = ColorKt.Color(4278255360L);
    private static final long Blue = ColorKt.Color(4278190335L);
    private static final long Yellow = ColorKt.Color(4294967040L);
    private static final long Cyan = ColorKt.Color(4278255615L);
    private static final long Magenta = ColorKt.Color(4294902015L);
    private static final long Transparent = ColorKt.Color(0);
    private static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Color m841boximpl(long j) {
        return new Color(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m846constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m850equalsimpl(long j, Object obj) {
        return (obj instanceof Color) && j == ((Color) obj).m859unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m851equalsimpl0(long j, long j2) {
        return ULong.m2137equalsimpl0(j, j2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m857hashCodeimpl(long j) {
        return ULong.m2138hashCodeimpl(j);
    }

    public boolean equals(Object obj) {
        return m850equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m857hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m859unboximpl() {
        return this.value;
    }

    private /* synthetic */ Color(long j) {
        this.value = j;
    }

    /* renamed from: getColorSpace-impl  reason: not valid java name */
    public static final ColorSpace m854getColorSpaceimpl(long j) {
        return ColorSpaces.INSTANCE.getColorSpacesArray$ui_graphics_release()[(int) ULong.m2135constructorimpl(j & 63)];
    }

    /* renamed from: convert-vNxB06k  reason: not valid java name */
    public static final long m847convertvNxB06k(long j, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        ColorSpace m854getColorSpaceimpl = m854getColorSpaceimpl(j);
        return Intrinsics.areEqual(colorSpace, m854getColorSpaceimpl) ? j : ColorSpaceKt.m1005connectYBCOT_4$default(m854getColorSpaceimpl, colorSpace, 0, 2, null).mo1006transformToColorwmQWz5c$ui_graphics_release(m856getRedimpl(j), m855getGreenimpl(j), m853getBlueimpl(j), m852getAlphaimpl(j));
    }

    /* renamed from: getRed-impl  reason: not valid java name */
    public static final float m856getRedimpl(long j) {
        if (ULong.m2135constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m2135constructorimpl(ULong.m2135constructorimpl(j >>> 48) & 255))) / 255.0f;
        }
        return Float16.m887toFloatimpl(Float16.m886constructorimpl((short) ULong.m2135constructorimpl(ULong.m2135constructorimpl(j >>> 48) & 65535)));
    }

    /* renamed from: getGreen-impl  reason: not valid java name */
    public static final float m855getGreenimpl(long j) {
        if (ULong.m2135constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m2135constructorimpl(ULong.m2135constructorimpl(j >>> 40) & 255))) / 255.0f;
        }
        return Float16.m887toFloatimpl(Float16.m886constructorimpl((short) ULong.m2135constructorimpl(ULong.m2135constructorimpl(j >>> 32) & 65535)));
    }

    /* renamed from: getBlue-impl  reason: not valid java name */
    public static final float m853getBlueimpl(long j) {
        if (ULong.m2135constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m2135constructorimpl(ULong.m2135constructorimpl(j >>> 32) & 255))) / 255.0f;
        }
        return Float16.m887toFloatimpl(Float16.m886constructorimpl((short) ULong.m2135constructorimpl(ULong.m2135constructorimpl(j >>> 16) & 65535)));
    }

    /* renamed from: getAlpha-impl  reason: not valid java name */
    public static final float m852getAlphaimpl(long j) {
        float ulongToDouble;
        float f;
        if (ULong.m2135constructorimpl(63 & j) == 0) {
            ulongToDouble = (float) UnsignedKt.ulongToDouble(ULong.m2135constructorimpl(ULong.m2135constructorimpl(j >>> 56) & 255));
            f = 255.0f;
        } else {
            ulongToDouble = (float) UnsignedKt.ulongToDouble(ULong.m2135constructorimpl(ULong.m2135constructorimpl(j >>> 6) & 1023));
            f = 1023.0f;
        }
        return ulongToDouble / f;
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m842component1impl(long j) {
        return m856getRedimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m843component2impl(long j) {
        return m855getGreenimpl(j);
    }

    /* renamed from: component3-impl  reason: not valid java name */
    public static final float m844component3impl(long j) {
        return m853getBlueimpl(j);
    }

    /* renamed from: component4-impl  reason: not valid java name */
    public static final float m845component4impl(long j) {
        return m852getAlphaimpl(j);
    }

    /* renamed from: copy-wmQWz5c$default  reason: not valid java name */
    public static /* synthetic */ long m849copywmQWz5c$default(long j, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m852getAlphaimpl(j);
        }
        float f5 = f;
        if ((i & 2) != 0) {
            f2 = m856getRedimpl(j);
        }
        float f6 = f2;
        if ((i & 4) != 0) {
            f3 = m855getGreenimpl(j);
        }
        float f7 = f3;
        if ((i & 8) != 0) {
            f4 = m853getBlueimpl(j);
        }
        return m848copywmQWz5c(j, f5, f6, f7, f4);
    }

    /* renamed from: copy-wmQWz5c  reason: not valid java name */
    public static final long m848copywmQWz5c(long j, float f, float f2, float f3, float f4) {
        return ColorKt.Color(f2, f3, f4, f, m854getColorSpaceimpl(j));
    }

    public String toString() {
        return m858toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m858toStringimpl(long j) {
        return "Color(" + m856getRedimpl(j) + ", " + m855getGreenimpl(j) + ", " + m853getBlueimpl(j) + ", " + m852getAlphaimpl(j) + ", " + m854getColorSpaceimpl(j).getName() + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* compiled from: Color.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getBlack-0d7_KjU  reason: not valid java name */
        public final long m860getBlack0d7_KjU() {
            return Color.Black;
        }

        /* renamed from: getWhite-0d7_KjU  reason: not valid java name */
        public final long m865getWhite0d7_KjU() {
            return Color.White;
        }

        /* renamed from: getRed-0d7_KjU  reason: not valid java name */
        public final long m862getRed0d7_KjU() {
            return Color.Red;
        }

        /* renamed from: getBlue-0d7_KjU  reason: not valid java name */
        public final long m861getBlue0d7_KjU() {
            return Color.Blue;
        }

        /* renamed from: getTransparent-0d7_KjU  reason: not valid java name */
        public final long m863getTransparent0d7_KjU() {
            return Color.Transparent;
        }

        /* renamed from: getUnspecified-0d7_KjU  reason: not valid java name */
        public final long m864getUnspecified0d7_KjU() {
            return Color.Unspecified;
        }
    }
}
