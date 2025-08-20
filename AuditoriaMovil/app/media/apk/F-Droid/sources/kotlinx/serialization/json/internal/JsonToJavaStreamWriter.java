package kotlinx.serialization.json.internal;

import ch.qos.logback.core.CoreConstants;
import java.io.OutputStream;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: JvmJsonStreams.kt */
/* loaded from: classes2.dex */
public final class JsonToJavaStreamWriter implements JsonWriter {
    private final byte[] buffer;
    private char[] charArray;
    private int indexInBuffer;
    private final OutputStream stream;

    public JsonToJavaStreamWriter(OutputStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.stream = stream;
        this.buffer = ByteArrayPool.INSTANCE.take();
        this.charArray = CharArrayPool.INSTANCE.take();
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void writeLong(long j) {
        write(String.valueOf(j));
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void writeChar(char c) {
        writeUtf8CodePoint(c);
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void write(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        ensureTotalCapacity(0, length);
        text.getChars(0, length, this.charArray, 0);
        writeUtf8(this.charArray, length);
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public void writeQuoted(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ensureTotalCapacity(0, text.length() + 2);
        char[] cArr = this.charArray;
        cArr[0] = CoreConstants.DOUBLE_QUOTE_CHAR;
        int length = text.length();
        text.getChars(0, length, cArr, 1);
        int i = length + 1;
        for (int i2 = 1; i2 < i; i2++) {
            char c = cArr[i2];
            if (c < StringOpsKt.getESCAPE_MARKERS().length && StringOpsKt.getESCAPE_MARKERS()[c] != 0) {
                appendStringSlowPath(i2, text);
                return;
            }
        }
        cArr[i] = CoreConstants.DOUBLE_QUOTE_CHAR;
        writeUtf8(cArr, length + 2);
        flush();
    }

    private final void appendStringSlowPath(int i, String str) {
        int i2;
        int length = str.length();
        for (int i3 = i - 1; i3 < length; i3++) {
            int ensureTotalCapacity = ensureTotalCapacity(i, 2);
            char charAt = str.charAt(i3);
            if (charAt < StringOpsKt.getESCAPE_MARKERS().length) {
                byte b = StringOpsKt.getESCAPE_MARKERS()[charAt];
                if (b == 0) {
                    i2 = ensureTotalCapacity + 1;
                    this.charArray[ensureTotalCapacity] = charAt;
                } else {
                    if (b == 1) {
                        String str2 = StringOpsKt.getESCAPE_STRINGS()[charAt];
                        Intrinsics.checkNotNull(str2);
                        int ensureTotalCapacity2 = ensureTotalCapacity(ensureTotalCapacity, str2.length());
                        str2.getChars(0, str2.length(), this.charArray, ensureTotalCapacity2);
                        i = ensureTotalCapacity2 + str2.length();
                    } else {
                        char[] cArr = this.charArray;
                        cArr[ensureTotalCapacity] = CoreConstants.ESCAPE_CHAR;
                        cArr[ensureTotalCapacity + 1] = (char) b;
                        i = ensureTotalCapacity + 2;
                    }
                }
            } else {
                i2 = ensureTotalCapacity + 1;
                this.charArray[ensureTotalCapacity] = charAt;
            }
            i = i2;
        }
        ensureTotalCapacity(i, 1);
        char[] cArr2 = this.charArray;
        cArr2[i] = CoreConstants.DOUBLE_QUOTE_CHAR;
        writeUtf8(cArr2, i + 1);
        flush();
    }

    private final int ensureTotalCapacity(int i, int i2) {
        int coerceAtLeast;
        int i3 = i2 + i;
        char[] cArr = this.charArray;
        if (cArr.length <= i3) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, i * 2);
            char[] copyOf = Arrays.copyOf(cArr, coerceAtLeast);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.charArray = copyOf;
        }
        return i;
    }

    public void release() {
        flush();
        CharArrayPool.INSTANCE.release(this.charArray);
        ByteArrayPool.INSTANCE.release(this.buffer);
    }

    private final void flush() {
        this.stream.write(this.buffer, 0, this.indexInBuffer);
        this.indexInBuffer = 0;
    }

    private final void writeUtf8CodePoint(int i) {
        if (i < 128) {
            if (this.buffer.length - this.indexInBuffer < 1) {
                flush();
            }
            byte[] bArr = this.buffer;
            int i2 = this.indexInBuffer;
            this.indexInBuffer = i2 + 1;
            bArr[i2] = (byte) i;
        } else if (i < 2048) {
            if (this.buffer.length - this.indexInBuffer < 2) {
                flush();
            }
            byte[] bArr2 = this.buffer;
            int i3 = this.indexInBuffer;
            bArr2[i3] = (byte) ((i >> 6) | 192);
            this.indexInBuffer = i3 + 2;
            bArr2[i3 + 1] = (byte) ((i & 63) | 128);
        } else if (55296 <= i && i < 57344) {
            if (this.buffer.length - this.indexInBuffer < 1) {
                flush();
            }
            byte[] bArr3 = this.buffer;
            int i4 = this.indexInBuffer;
            this.indexInBuffer = i4 + 1;
            bArr3[i4] = (byte) 63;
        } else if (i < 65536) {
            if (this.buffer.length - this.indexInBuffer < 3) {
                flush();
            }
            int i5 = (i >> 12) | BERTags.FLAGS;
            byte[] bArr4 = this.buffer;
            int i6 = this.indexInBuffer;
            bArr4[i6] = (byte) i5;
            bArr4[i6 + 1] = (byte) (((i >> 6) & 63) | 128);
            this.indexInBuffer = i6 + 3;
            bArr4[i6 + 2] = (byte) ((i & 63) | 128);
        } else if (i > 1114111) {
            throw new JsonEncodingException("Unexpected code point: " + i);
        } else {
            if (this.buffer.length - this.indexInBuffer < 4) {
                flush();
            }
            byte[] bArr5 = this.buffer;
            int i7 = this.indexInBuffer;
            bArr5[i7] = (byte) ((i >> 18) | 240);
            bArr5[i7 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr5[i7 + 2] = (byte) (((i >> 6) & 63) | 128);
            this.indexInBuffer = i7 + 4;
            bArr5[i7 + 3] = (byte) ((i & 63) | 128);
        }
    }

    private final void writeUtf8(char[] cArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("count < 0".toString());
        }
        if (i > cArr.length) {
            throw new IllegalArgumentException(("count > string.length: " + i + " > " + cArr.length).toString());
        }
        int i2 = 0;
        while (i2 < i) {
            char c = cArr[i2];
            if (c < 128) {
                if (this.buffer.length - this.indexInBuffer < 1) {
                    flush();
                }
                byte[] bArr = this.buffer;
                int i3 = this.indexInBuffer;
                int i4 = i3 + 1;
                this.indexInBuffer = i4;
                bArr[i3] = (byte) c;
                i2++;
                int min = Math.min(i, (bArr.length - i4) + i2);
                while (i2 < min) {
                    char c2 = cArr[i2];
                    if (c2 < 128) {
                        byte[] bArr2 = this.buffer;
                        int i5 = this.indexInBuffer;
                        this.indexInBuffer = i5 + 1;
                        bArr2[i5] = (byte) c2;
                        i2++;
                    }
                }
            } else {
                if (c < 2048) {
                    if (this.buffer.length - this.indexInBuffer < 2) {
                        flush();
                    }
                    byte[] bArr3 = this.buffer;
                    int i6 = this.indexInBuffer;
                    bArr3[i6] = (byte) ((c >> 6) | 192);
                    this.indexInBuffer = i6 + 2;
                    bArr3[i6 + 1] = (byte) ((c & '?') | 128);
                } else if (c < 55296 || c > 57343) {
                    if (this.buffer.length - this.indexInBuffer < 3) {
                        flush();
                    }
                    int i7 = (c >> '\f') | BERTags.FLAGS;
                    byte[] bArr4 = this.buffer;
                    int i8 = this.indexInBuffer;
                    bArr4[i8] = (byte) i7;
                    bArr4[i8 + 1] = (byte) (((c >> 6) & 63) | 128);
                    this.indexInBuffer = i8 + 3;
                    bArr4[i8 + 2] = (byte) ((c & '?') | 128);
                } else {
                    int i9 = i2 + 1;
                    char c3 = i9 < i ? cArr[i9] : (char) 0;
                    if (c > 56319 || 56320 > c3 || c3 >= 57344) {
                        if (this.buffer.length - this.indexInBuffer < 1) {
                            flush();
                        }
                        byte[] bArr5 = this.buffer;
                        int i10 = this.indexInBuffer;
                        this.indexInBuffer = i10 + 1;
                        bArr5[i10] = (byte) 63;
                        i2 = i9;
                    } else {
                        int i11 = (((c & 1023) << 10) | (c3 & 1023)) + PKIFailureInfo.notAuthorized;
                        if (this.buffer.length - this.indexInBuffer < 4) {
                            flush();
                        }
                        byte[] bArr6 = this.buffer;
                        int i12 = this.indexInBuffer;
                        bArr6[i12] = (byte) ((i11 >> 18) | 240);
                        bArr6[i12 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                        bArr6[i12 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                        this.indexInBuffer = i12 + 4;
                        bArr6[i12 + 3] = (byte) ((i11 & 63) | 128);
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
    }
}
