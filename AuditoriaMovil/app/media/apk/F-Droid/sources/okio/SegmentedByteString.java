package okio;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.Buffer;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
/* compiled from: Util.kt */
/* renamed from: okio.-SegmentedByteString  reason: invalid class name */
/* loaded from: classes2.dex */
public abstract class SegmentedByteString {
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();
    private static final int DEFAULT__ByteString_size = -1234567890;

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    public static final Buffer.UnsafeCursor getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static final int reverseBytes(int i) {
        return ((i & GF2Field.MASK) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static final short reverseBytes(short s) {
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final boolean arrayRangeEquals(byte[] a, int i, byte[] b, int i2, int i3) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (a[i4 + i] != b[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final String toHexString(byte b) {
        String concatToString;
        concatToString = StringsKt__StringsJVMKt.concatToString(new char[]{okio.internal.ByteString.getHEX_DIGIT_CHARS()[(b >> 4) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[b & 15]});
        return concatToString;
    }

    public static final String toHexString(int i) {
        String concatToString;
        if (i == 0) {
            return "0";
        }
        int i2 = 0;
        char[] cArr = {okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i >> 28) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i >> 24) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i >> 20) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i >> 16) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i >> 12) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i >> 8) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i >> 4) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[i & 15]};
        while (i2 < 8 && cArr[i2] == '0') {
            i2++;
        }
        concatToString = StringsKt__StringsJVMKt.concatToString(cArr, i2, 8);
        return concatToString;
    }

    public static final Buffer.UnsafeCursor resolveDefaultParameter(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return unsafeCursor == DEFAULT__new_UnsafeCursor ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    public static final int resolveDefaultParameter(ByteString byteString, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return i == DEFAULT__ByteString_size ? byteString.size() : i;
    }

    public static final int resolveDefaultParameter(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return i == DEFAULT__ByteString_size ? bArr.length : i;
    }
}
