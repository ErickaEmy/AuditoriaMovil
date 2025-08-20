package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InputArrays.kt */
/* loaded from: classes.dex */
public abstract class InputArraysKt {
    public static final void readFully(Input input, byte[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (prepareReadFirstHead != null) {
            while (true) {
                try {
                    int min = Math.min(i2, prepareReadFirstHead.getWritePosition() - prepareReadFirstHead.getReadPosition());
                    BufferPrimitivesKt.readFully(prepareReadFirstHead, dst, i, min);
                    i2 -= min;
                    i += min;
                    if (i2 > 0) {
                        try {
                            prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, prepareReadFirstHead);
                            if (prepareReadFirstHead == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        if (i2 <= 0) {
            return;
        }
        StringsKt.prematureEndOfStream(i2);
        throw new KotlinNothingValueException();
    }
}
