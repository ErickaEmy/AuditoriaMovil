package io.ktor.utils.io.charsets;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Encoding.kt */
/* loaded from: classes.dex */
public abstract class EncodingKt {
    public static final ByteReadPacket encode(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        try {
            encodeToImpl(charsetEncoder, bytePacketBuilder, input, i, i2);
            return bytePacketBuilder.build();
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static /* synthetic */ ByteReadPacket encode$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encode(charsetEncoder, charSequence, i, i2);
    }

    public static /* synthetic */ String decode$default(CharsetDecoder charsetDecoder, Input input, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return decode(charsetDecoder, input, i);
    }

    public static final String decode(CharsetDecoder charsetDecoder, Input input, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        StringBuilder sb = new StringBuilder((int) Math.min(i, sizeEstimate(input)));
        CharsetJVMKt.decode(charsetDecoder, input, sb, i);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final long sizeEstimate(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return input instanceof ByteReadPacket ? input.getRemaining() : Math.max(input.getRemaining(), 16L);
    }

    private static final int encodeCompleteImpl(CharsetEncoder charsetEncoder, Output output) {
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        int i = 1;
        int i2 = 0;
        while (true) {
            try {
                int limit = prepareWriteHead.getLimit() - prepareWriteHead.getWritePosition();
                i = CharsetJVMKt.encodeComplete(charsetEncoder, prepareWriteHead) ? 0 : i + 1;
                i2 += limit - (prepareWriteHead.getLimit() - prepareWriteHead.getWritePosition());
                if (i <= 0) {
                    return i2;
                }
                prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x005c, code lost:
        throw new java.lang.IllegalStateException("Check failed.".toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int encodeToImpl(java.nio.charset.CharsetEncoder r8, io.ktor.utils.io.core.Output r9, java.lang.CharSequence r10, int r11, int r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "destination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 0
            if (r11 < r12) goto L13
            return r0
        L13:
            r1 = 0
            r2 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r9, r2, r1)
            r3 = r0
        L1a:
            int r4 = r1.getLimit()     // Catch: java.lang.Throwable -> L46
            int r5 = r1.getWritePosition()     // Catch: java.lang.Throwable -> L46
            int r4 = r4 - r5
            int r5 = io.ktor.utils.io.charsets.CharsetJVMKt.encodeImpl(r8, r10, r11, r12, r1)     // Catch: java.lang.Throwable -> L46
            if (r5 < 0) goto L51
            int r11 = r11 + r5
            int r6 = r1.getLimit()     // Catch: java.lang.Throwable -> L46
            int r7 = r1.getWritePosition()     // Catch: java.lang.Throwable -> L46
            int r6 = r6 - r7
            int r4 = r4 - r6
            int r3 = r3 + r4
            if (r11 < r12) goto L39
            r4 = r0
            goto L3f
        L39:
            if (r5 != 0) goto L3e
            r4 = 8
            goto L3f
        L3e:
            r4 = r2
        L3f:
            if (r4 <= 0) goto L48
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r9, r4, r1)     // Catch: java.lang.Throwable -> L46
            goto L1a
        L46:
            r8 = move-exception
            goto L5d
        L48:
            r9.afterHeadWrite()
            int r8 = encodeCompleteImpl(r8, r9)
            int r3 = r3 + r8
            return r3
        L51:
            java.lang.String r8 = "Check failed."
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L46
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L46
            r10.<init>(r8)     // Catch: java.lang.Throwable -> L46
            throw r10     // Catch: java.lang.Throwable -> L46
        L5d:
            r9.afterHeadWrite()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.EncodingKt.encodeToImpl(java.nio.charset.CharsetEncoder, io.ktor.utils.io.core.Output, java.lang.CharSequence, int, int):int");
    }
}
