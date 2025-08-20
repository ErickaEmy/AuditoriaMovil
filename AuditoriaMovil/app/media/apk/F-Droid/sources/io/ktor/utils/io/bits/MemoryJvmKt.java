package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MemoryJvm.kt */
/* loaded from: classes.dex */
public abstract class MemoryJvmKt {
    /* renamed from: copyTo-9zorpBc  reason: not valid java name */
    public static final void m2062copyTo9zorpBc(ByteBuffer copyTo, byte[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (copyTo.hasArray() && !copyTo.isReadOnly()) {
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i, destination, i3, i2);
        } else {
            copyTo.duplicate().get(destination, i3, i2);
        }
    }

    /* renamed from: copyTo-62zg_DM  reason: not valid java name */
    public static final void m2061copyTo62zg_DM(ByteBuffer copyTo, ByteBuffer destination, int i) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int remaining = destination.remaining();
        if (copyTo.hasArray() && !copyTo.isReadOnly() && destination.hasArray() && !destination.isReadOnly()) {
            int position = destination.position();
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i, destination.array(), destination.arrayOffset() + position, remaining);
            destination.position(position + remaining);
            return;
        }
        ByteBuffer duplicate = copyTo.duplicate();
        duplicate.limit(remaining + i);
        duplicate.position(i);
        destination.put(duplicate);
    }

    /* renamed from: copyTo-SG11BkQ  reason: not valid java name */
    public static final void m2063copyToSG11BkQ(ByteBuffer copyTo, ByteBuffer destination, int i) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (copyTo.hasArray() && !copyTo.isReadOnly()) {
            byte[] array = copyTo.array();
            Intrinsics.checkNotNullExpressionValue(array, "array()");
            int arrayOffset = copyTo.arrayOffset() + copyTo.position();
            int remaining = copyTo.remaining();
            ByteBuffer order = ByteBuffer.wrap(array, arrayOffset, remaining).slice().order(ByteOrder.BIG_ENDIAN);
            Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
            Memory.m2058copyToJT6ljtQ(Memory.m2057constructorimpl(order), destination, 0, remaining, i);
            copyTo.position(copyTo.limit());
            return;
        }
        sliceSafe(destination, i, copyTo.remaining()).put(copyTo);
    }

    public static final ByteBuffer sliceSafe(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        ByteBuffer myDuplicate$lambda$1 = byteBuffer.duplicate();
        Intrinsics.checkNotNullExpressionValue(myDuplicate$lambda$1, "myDuplicate$lambda$1");
        myDuplicate$lambda$1.position(i);
        myDuplicate$lambda$1.limit(i + i2);
        ByteBuffer mySlice$lambda$2 = myDuplicate$lambda$1.slice();
        Intrinsics.checkNotNullExpressionValue(mySlice$lambda$2, "mySlice$lambda$2");
        return mySlice$lambda$2;
    }
}
