package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InputPrimitives.kt */
/* loaded from: classes.dex */
public abstract class InputPrimitivesKt {
    private static final short readShortFallback(Input input) {
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 2);
        if (prepareReadFirstHead != null) {
            short readShort = BufferPrimitivesKt.readShort(prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, prepareReadFirstHead);
            return readShort;
        }
        StringsKt.prematureEndOfStream(2);
        throw new KotlinNothingValueException();
    }

    public static final short readShort(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= 2) {
            return readShortFallback(input);
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(headPosition + 2);
        return input.m2066getHeadMemorySK3TCg8().getShort(headPosition);
    }
}
