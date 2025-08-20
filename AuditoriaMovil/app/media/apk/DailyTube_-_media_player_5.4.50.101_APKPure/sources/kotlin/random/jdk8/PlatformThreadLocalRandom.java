package kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;
/* loaded from: classes.dex */
public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    @Override // kotlin.random.AbstractPlatformRandom
    public Random getImpl() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        Intrinsics.checkNotNullExpressionValue(current, "current(...)");
        return current;
    }

    @Override // kotlin.random.Random
    public int nextInt(int i, int i5) {
        return ThreadLocalRandom.current().nextInt(i, i5);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j2) {
        return ThreadLocalRandom.current().nextLong(j2);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j2, long j4) {
        return ThreadLocalRandom.current().nextLong(j2, j4);
    }
}
