package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
/* compiled from: Float16.kt */
/* loaded from: classes.dex */
public abstract class Float16 implements Comparable {
    private static final float FP32_DENORMAL_FLOAT;
    public static final Companion Companion = new Companion(null);
    private static final short Epsilon = m886constructorimpl((short) 5120);
    private static final short LowestValue = m886constructorimpl((short) -1025);
    private static final short MaxValue = m886constructorimpl((short) 31743);
    private static final short MinNormal = m886constructorimpl((short) 1024);
    private static final short MinValue = m886constructorimpl((short) 1);
    private static final short NaN = m886constructorimpl((short) 32256);
    private static final short NegativeInfinity = m886constructorimpl((short) -1024);
    private static final short NegativeZero = m886constructorimpl(Short.MIN_VALUE);
    private static final short PositiveInfinity = m886constructorimpl((short) 31744);
    private static final short PositiveZero = m886constructorimpl((short) 0);
    private static final short One = m885constructorimpl(1.0f);
    private static final short NegativeOne = m885constructorimpl(-1.0f);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m886constructorimpl(short s) {
        return s;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m885constructorimpl(float f) {
        return m886constructorimpl(Companion.floatToHalf(f));
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m887toFloatimpl(short s) {
        int i;
        int i2;
        int i3;
        int i4 = 32768 & s;
        int i5 = ((65535 & s) >>> 10) & 31;
        int i6 = s & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = GF2Field.MASK;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else if (i6 != 0) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            float intBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - FP32_DENORMAL_FLOAT;
            return i4 == 0 ? intBitsToFloat : -intBitsToFloat;
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i9 = (i3 << 23) | (i4 << 16) | i2;
        FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(i9);
    }

    /* compiled from: Float16.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final short floatToHalf(float f) {
            int i;
            int floatToRawIntBits = Float.floatToRawIntBits(f);
            int i2 = floatToRawIntBits >>> 31;
            int i3 = (floatToRawIntBits >>> 23) & GF2Field.MASK;
            int i4 = 8388607 & floatToRawIntBits;
            int i5 = 31;
            int i6 = 0;
            if (i3 != 255) {
                int i7 = i3 - 112;
                if (i7 >= 31) {
                    i5 = 49;
                } else if (i7 > 0) {
                    i6 = i4 >> 13;
                    if ((floatToRawIntBits & PKIFailureInfo.certConfirmed) != 0) {
                        i = (((i7 << 10) | i6) + 1) | (i2 << 15);
                        return (short) i;
                    }
                    i5 = i7;
                } else if (i7 >= -10) {
                    int i8 = (8388608 | i4) >> (1 - i7);
                    if ((i8 & PKIFailureInfo.certConfirmed) != 0) {
                        i8 += 8192;
                    }
                    i5 = 0;
                    i6 = i8 >> 13;
                } else {
                    i5 = 0;
                }
            } else if (i4 != 0) {
                i6 = 512;
            }
            i = (i2 << 15) | (i5 << 10) | i6;
            return (short) i;
        }
    }

    static {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        FP32_DENORMAL_FLOAT = Float.intBitsToFloat(1056964608);
    }
}
