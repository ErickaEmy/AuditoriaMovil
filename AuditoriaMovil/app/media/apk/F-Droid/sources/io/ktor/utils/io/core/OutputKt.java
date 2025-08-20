package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Output.kt */
/* loaded from: classes.dex */
public abstract class OutputKt {
    public static /* synthetic */ void writeFully$default(Output output, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        writeFully(output, bArr, i, i2);
    }

    public static final void writeFully(Output output, byte[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        while (true) {
            try {
                int min = Math.min(i2, prepareWriteHead.getLimit() - prepareWriteHead.getWritePosition());
                BufferPrimitivesKt.writeFully(prepareWriteHead, src, i, min);
                i += min;
                i2 -= min;
                if (i2 <= 0) {
                    return;
                }
                prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
            } finally {
                output.afterHeadWrite();
            }
        }
    }
}
