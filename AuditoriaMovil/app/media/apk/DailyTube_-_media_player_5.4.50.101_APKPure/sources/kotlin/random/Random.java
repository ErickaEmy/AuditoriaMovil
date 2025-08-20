package kotlin.random;

import java.io.Serializable;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes.dex */
public abstract class Random {
    public static final Default Default = new Default(null);
    private static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    /* loaded from: classes.dex */
    public static final class Default extends Random implements Serializable {

        /* loaded from: classes.dex */
        public static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int i) {
            return Random.defaultRandom.nextBits(i);
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        private Default() {
        }

        @Override // kotlin.random.Random
        public int nextInt(int i) {
            return Random.defaultRandom.nextInt(i);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j2) {
            return Random.defaultRandom.nextLong(j2);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i, int i5) {
            return Random.defaultRandom.nextInt(i, i5);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j2, long j4) {
            return Random.defaultRandom.nextLong(j2, j4);
        }
    }

    public abstract int nextBits(int i);

    public abstract int nextInt();

    public abstract int nextInt(int i);

    public int nextInt(int i, int i5) {
        int nextInt;
        int i6;
        int i8;
        RandomKt.checkRangeBounds(i, i5);
        int i10 = i5 - i;
        if (i10 > 0 || i10 == Integer.MIN_VALUE) {
            if (((-i10) & i10) == i10) {
                i8 = nextBits(RandomKt.fastLog2(i10));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i6 = nextInt % i10;
                } while ((nextInt - i6) + (i10 - 1) < 0);
                i8 = i6;
            }
            return i + i8;
        }
        while (true) {
            int nextInt2 = nextInt();
            if (i <= nextInt2 && nextInt2 < i5) {
                return nextInt2;
            }
        }
    }

    public abstract long nextLong();

    public long nextLong(long j2) {
        return nextLong(0L, j2);
    }

    public long nextLong(long j2, long j4) {
        long nextLong;
        long j6;
        long j7;
        int nextInt;
        RandomKt.checkRangeBounds(j2, j4);
        long j8 = j4 - j2;
        if (j8 > 0) {
            if (((-j8) & j8) == j8) {
                int i = (int) j8;
                int i5 = (int) (j8 >>> 32);
                if (i != 0) {
                    nextInt = nextBits(RandomKt.fastLog2(i));
                } else if (i5 == 1) {
                    nextInt = nextInt();
                } else {
                    j7 = (nextBits(RandomKt.fastLog2(i5)) << 32) + (nextInt() & 4294967295L);
                }
                j7 = nextInt & 4294967295L;
            } else {
                do {
                    nextLong = nextLong() >>> 1;
                    j6 = nextLong % j8;
                } while ((nextLong - j6) + (j8 - 1) < 0);
                j7 = j6;
            }
            return j2 + j7;
        }
        while (true) {
            long nextLong2 = nextLong();
            if (j2 <= nextLong2 && nextLong2 < j4) {
                return nextLong2;
            }
        }
    }
}
