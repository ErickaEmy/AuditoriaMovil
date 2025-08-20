package io.ktor.utils.io.core.internal;

import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.bouncycastle.asn1.BERTags;
/* compiled from: UTF8.kt */
/* loaded from: classes.dex */
public abstract class UTF8Kt {
    public static final int codePoint(char c, char c2) {
        return ((c - 55232) << 10) | (c2 - 56320);
    }

    public static final int highSurrogate(int i) {
        return (i >>> 10) + 55232;
    }

    public static final boolean isBmpCodePoint(int i) {
        return (i >>> 16) == 0;
    }

    public static final boolean isValidCodePoint(int i) {
        return i <= 1114111;
    }

    public static final int lowSurrogate(int i) {
        return (i & 1023) + 56320;
    }

    /* renamed from: encodeUTF8-lBXzO7A  reason: not valid java name */
    public static final int m2074encodeUTF8lBXzO7A(ByteBuffer encodeUTF8, CharSequence text, int i, int i2, int i3, int i4) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(encodeUTF8, "$this$encodeUTF8");
        Intrinsics.checkNotNullParameter(text, "text");
        int min = Math.min(i2, i + 65535);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i4, 65535);
        int i5 = i;
        int i6 = i3;
        while (i6 < coerceAtMost && i5 < min) {
            int i7 = i5 + 1;
            char charAt = text.charAt(i5);
            int i8 = charAt & 65535;
            if ((charAt & 65408) == 0) {
                encodeUTF8.put(i6, (byte) i8);
                i5 = i7;
                i6++;
            } else {
                return m2075encodeUTF8Stage1Vm9B2pQ(encodeUTF8, text, i5, min, i, i6, coerceAtMost, i3);
            }
        }
        return EncodeResult.m2071constructorimpl(UShort.m2158constructorimpl((short) (i5 - i)), UShort.m2158constructorimpl((short) (i6 - i3)));
    }

    /* renamed from: encodeUTF8Stage1-Vm9B2pQ  reason: not valid java name */
    private static final int m2075encodeUTF8Stage1Vm9B2pQ(ByteBuffer byteBuffer, CharSequence charSequence, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i5 - 3;
        int i10 = i;
        int i11 = i4;
        while (i9 - i11 > 0 && i10 < i2) {
            int i12 = i10 + 1;
            char charAt = charSequence.charAt(i10);
            if (!Character.isHighSurrogate(charAt)) {
                i10 = i12;
                i7 = charAt;
            } else if (i12 == i2 || !Character.isLowSurrogate(charSequence.charAt(i12))) {
                i10 = i12;
                i7 = 63;
            } else {
                i10 += 2;
                i7 = codePoint(charAt, charSequence.charAt(i12));
            }
            if (i7 >= 0 && i7 < 128) {
                byteBuffer.put(i11, (byte) i7);
                i8 = 1;
            } else if (128 <= i7 && i7 < 2048) {
                byteBuffer.put(i11, (byte) (((i7 >> 6) & 31) | 192));
                byteBuffer.put(i11 + 1, (byte) (128 | (i7 & 63)));
                i8 = 2;
            } else if (2048 <= i7 && i7 < 65536) {
                byteBuffer.put(i11, (byte) (((i7 >> 12) & 15) | BERTags.FLAGS));
                byteBuffer.put(i11 + 1, (byte) ((63 & (i7 >> 6)) | 128));
                byteBuffer.put(i11 + 2, (byte) (128 | (i7 & 63)));
                i8 = 3;
            } else if (65536 > i7 || i7 >= 1114112) {
                malformedCodePoint(i7);
                throw new KotlinNothingValueException();
            } else {
                byteBuffer.put(i11, (byte) (((i7 >> 18) & 7) | 240));
                byteBuffer.put(i11 + 1, (byte) (((i7 >> 12) & 63) | 128));
                byteBuffer.put(i11 + 2, (byte) ((63 & (i7 >> 6)) | 128));
                byteBuffer.put(i11 + 3, (byte) (128 | (i7 & 63)));
                i8 = 4;
            }
            i11 += i8;
        }
        if (i11 == i9) {
            return m2076encodeUTF8Stage2Vm9B2pQ(byteBuffer, charSequence, i10, i2, i3, i11, i5, i6);
        }
        return EncodeResult.m2071constructorimpl(UShort.m2158constructorimpl((short) (i10 - i3)), UShort.m2158constructorimpl((short) (i11 - i6)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e2, code lost:
        malformedCodePoint(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ea, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fd, code lost:
        return io.ktor.utils.io.core.internal.EncodeResult.m2071constructorimpl(kotlin.UShort.m2158constructorimpl((short) (r3 - r20)), kotlin.UShort.m2158constructorimpl((short) (r4 - r23)));
     */
    /* renamed from: encodeUTF8Stage2-Vm9B2pQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int m2076encodeUTF8Stage2Vm9B2pQ(java.nio.ByteBuffer r16, java.lang.CharSequence r17, int r18, int r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.m2076encodeUTF8Stage2Vm9B2pQ(java.nio.ByteBuffer, java.lang.CharSequence, int, int, int, int, int, int):int");
    }

    public static final Void malformedByteCount(int i) {
        throw new MalformedUTF8InputException("Expected " + i + " more character bytes");
    }

    public static final Void malformedCodePoint(int i) {
        throw new IllegalArgumentException("Malformed code-point " + i + " found");
    }
}
