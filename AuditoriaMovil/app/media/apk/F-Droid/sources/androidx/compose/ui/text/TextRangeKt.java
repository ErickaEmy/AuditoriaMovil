package androidx.compose.ui.text;

import kotlin.ranges.RangesKt___RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: TextRange.kt */
/* loaded from: classes.dex */
public abstract class TextRangeKt {
    public static final long TextRange(int i, int i2) {
        return TextRange.m1574constructorimpl(packWithCheck(i, i2));
    }

    public static final long TextRange(int i) {
        return TextRange(i, i);
    }

    /* renamed from: coerceIn-8ffj60Q  reason: not valid java name */
    public static final long m1591coerceIn8ffj60Q(long j, int i, int i2) {
        int coerceIn;
        int coerceIn2;
        coerceIn = RangesKt___RangesKt.coerceIn(TextRange.m1585getStartimpl(j), i, i2);
        coerceIn2 = RangesKt___RangesKt.coerceIn(TextRange.m1580getEndimpl(j), i, i2);
        return (coerceIn == TextRange.m1585getStartimpl(j) && coerceIn2 == TextRange.m1580getEndimpl(j)) ? j : TextRange(coerceIn, coerceIn2);
    }

    private static final long packWithCheck(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException(("start cannot be negative. [start: " + i + ", end: " + i2 + ']').toString());
        } else if (i2 >= 0) {
            return (i2 & BodyPartID.bodyIdMax) | (i << 32);
        } else {
            throw new IllegalArgumentException(("end cannot be negative. [start: " + i + ", end: " + i2 + ']').toString());
        }
    }
}
