package io.ktor.utils.io.charsets;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.Input;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CharsetJVM.kt */
/* loaded from: classes.dex */
public abstract class CharsetJVMKt {
    private static final ByteBuffer EmptyByteBuffer;
    private static final CharBuffer EmptyCharBuffer = CharBuffer.allocate(0);

    public static final String getName(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "<this>");
        String name = charset.name();
        Intrinsics.checkNotNullExpressionValue(name, "name()");
        return name;
    }

    public static final byte[] encodeToByteArray(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (input instanceof String) {
            if (i == 0 && i2 == input.length()) {
                byte[] bytes = ((String) input).getBytes(charsetEncoder.charset());
                Intrinsics.checkNotNullExpressionValue(bytes, "input as java.lang.String).getBytes(charset())");
                return bytes;
            }
            String substring = ((String) input).substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes2 = substring.getBytes(charsetEncoder.charset());
            Intrinsics.checkNotNullExpressionValue(bytes2, "input.substring(fromInde…ring).getBytes(charset())");
            return bytes2;
        }
        return encodeToByteArraySlow(charsetEncoder, input, i, i2);
    }

    private static final byte[] encodeToByteArraySlow(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        ByteBuffer encode = charsetEncoder.encode(CharBuffer.wrap(charSequence, i, i2));
        byte[] bArr = null;
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            byte[] array = encode.array();
            if (array.length == encode.remaining()) {
                bArr = array;
            }
        }
        if (bArr == null) {
            byte[] bArr2 = new byte[encode.remaining()];
            encode.get(bArr2);
            return bArr2;
        }
        return bArr;
    }

    public static final int encodeImpl(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2, Buffer dst) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        CharBuffer wrap = CharBuffer.wrap(input, i, i2);
        int remaining = wrap.remaining();
        ByteBuffer m2064getMemorySK3TCg8 = dst.m2064getMemorySK3TCg8();
        int writePosition = dst.getWritePosition();
        int limit = dst.getLimit() - writePosition;
        ByteBuffer m2059slice87lwejk = Memory.m2059slice87lwejk(m2064getMemorySK3TCg8, writePosition, limit);
        CoderResult result = charsetEncoder.encode(wrap, m2059slice87lwejk, false);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            throwExceptionWrapped(result);
        }
        if (m2059slice87lwejk.limit() != limit) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        dst.commitWritten(m2059slice87lwejk.position());
        return remaining - wrap.remaining();
    }

    public static final String decodeExactBytes(CharsetDecoder charsetDecoder, Input input, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (i == 0) {
            return "";
        }
        if (input.getHeadEndExclusive() - input.getHeadPosition() >= i) {
            if (input.m2066getHeadMemorySK3TCg8().hasArray()) {
                ByteBuffer m2066getHeadMemorySK3TCg8 = input.m2066getHeadMemorySK3TCg8();
                byte[] array = m2066getHeadMemorySK3TCg8.array();
                Intrinsics.checkNotNullExpressionValue(array, "bb.array()");
                Charset charset = charsetDecoder.charset();
                Intrinsics.checkNotNullExpressionValue(charset, "charset()");
                String str = new String(array, m2066getHeadMemorySK3TCg8.arrayOffset() + m2066getHeadMemorySK3TCg8.position() + input.getHead().getReadPosition(), i, charset);
                input.discardExact(i);
                return str;
            }
            return decodeImplByteBuffer(charsetDecoder, input, i);
        }
        return decodeImplSlow(charsetDecoder, input, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a8, code lost:
        throw new java.lang.IllegalStateException("Buffer's limit change is not allowed".toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int decode(java.nio.charset.CharsetDecoder r11, io.ktor.utils.io.core.Input r12, java.lang.Appendable r13, int r14) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.CharsetJVMKt.decode(java.nio.charset.CharsetDecoder, io.ktor.utils.io.core.Input, java.lang.Appendable, int):int");
    }

    private static final String decodeImplByteBuffer(CharsetDecoder charsetDecoder, Input input, int i) {
        CharBuffer allocate = CharBuffer.allocate(i);
        ByteBuffer m2059slice87lwejk = Memory.m2059slice87lwejk(input.m2066getHeadMemorySK3TCg8(), input.getHead().getReadPosition(), i);
        CoderResult rc = charsetDecoder.decode(m2059slice87lwejk, allocate, true);
        if (rc.isMalformed() || rc.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(rc, "rc");
            throwExceptionWrapped(rc);
        }
        allocate.flip();
        input.discardExact(m2059slice87lwejk.position());
        String charBuffer = allocate.toString();
        Intrinsics.checkNotNullExpressionValue(charBuffer, "cb.toString()");
        return charBuffer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a4, code lost:
        throw new java.lang.IllegalStateException("Buffer's limit change is not allowed".toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.String decodeImplSlow(java.nio.charset.CharsetDecoder r17, io.ktor.utils.io.core.Input r18, int r19) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.CharsetJVMKt.decodeImplSlow(java.nio.charset.CharsetDecoder, io.ktor.utils.io.core.Input, int):java.lang.String");
    }

    private static final void throwExceptionWrapped(CoderResult coderResult) {
        try {
            coderResult.throwException();
        } catch (java.nio.charset.MalformedInputException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new MalformedInputException(message);
        }
    }

    static {
        ByteBuffer allocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNull(allocate);
        EmptyByteBuffer = allocate;
    }

    public static final boolean encodeComplete(CharsetEncoder charsetEncoder, Buffer dst) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer m2064getMemorySK3TCg8 = dst.m2064getMemorySK3TCg8();
        int writePosition = dst.getWritePosition();
        int limit = dst.getLimit() - writePosition;
        ByteBuffer m2059slice87lwejk = Memory.m2059slice87lwejk(m2064getMemorySK3TCg8, writePosition, limit);
        CoderResult result = charsetEncoder.encode(EmptyCharBuffer, m2059slice87lwejk, true);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            throwExceptionWrapped(result);
        }
        boolean isUnderflow = result.isUnderflow();
        if (m2059slice87lwejk.limit() != limit) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        dst.commitWritten(m2059slice87lwejk.position());
        return isUnderflow;
    }
}
