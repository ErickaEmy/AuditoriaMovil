package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MemoryFactoryJvm.kt */
/* loaded from: classes.dex */
public final class DefaultAllocator implements Allocator {
    public static final DefaultAllocator INSTANCE = new DefaultAllocator();

    private DefaultAllocator() {
    }

    @Override // io.ktor.utils.io.bits.Allocator
    /* renamed from: free-3GNKZMM */
    public void mo2056free3GNKZMM(ByteBuffer instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // io.ktor.utils.io.bits.Allocator
    /* renamed from: alloc-gFv-Zug */
    public ByteBuffer mo2055allocgFvZug(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(size)");
        return Memory.m2057constructorimpl(allocate);
    }
}
