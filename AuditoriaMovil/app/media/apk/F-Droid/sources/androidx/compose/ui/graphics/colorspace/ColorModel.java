package androidx.compose.ui.graphics.colorspace;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: ColorModel.kt */
/* loaded from: classes.dex */
public abstract class ColorModel {
    private static final long Cmyk;
    public static final Companion Companion = new Companion(null);
    private static final long Lab;
    private static final long Rgb;
    private static final long Xyz;

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m994constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m995equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getComponentCount-impl  reason: not valid java name */
    public static final int m996getComponentCountimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m997hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    /* compiled from: ColorModel.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getRgb-xdoWZVw  reason: not valid java name */
        public final long m1000getRgbxdoWZVw() {
            return ColorModel.Rgb;
        }

        /* renamed from: getXyz-xdoWZVw  reason: not valid java name */
        public final long m1001getXyzxdoWZVw() {
            return ColorModel.Xyz;
        }

        /* renamed from: getLab-xdoWZVw  reason: not valid java name */
        public final long m999getLabxdoWZVw() {
            return ColorModel.Lab;
        }
    }

    static {
        long j = 3;
        long j2 = j << 32;
        Rgb = m994constructorimpl((0 & BodyPartID.bodyIdMax) | j2);
        Xyz = m994constructorimpl((1 & BodyPartID.bodyIdMax) | j2);
        Lab = m994constructorimpl(j2 | (2 & BodyPartID.bodyIdMax));
        Cmyk = m994constructorimpl((j & BodyPartID.bodyIdMax) | (4 << 32));
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m998toStringimpl(long j) {
        return m995equalsimpl0(j, Rgb) ? "Rgb" : m995equalsimpl0(j, Xyz) ? "Xyz" : m995equalsimpl0(j, Lab) ? "Lab" : m995equalsimpl0(j, Cmyk) ? "Cmyk" : "Unknown";
    }
}
