package af;

import java.util.Arrays;
import java.util.Random;
/* loaded from: classes.dex */
public interface u {

    /* loaded from: classes.dex */
    public static final class n3 implements u {
        public final int y;

        public n3(int i) {
            this.y = i;
        }

        @Override // af.u
        public u co(int i, int i5) {
            return new n3((this.y - i5) + i);
        }

        @Override // af.u
        public u f3(int i, int i5) {
            return new n3(this.y + i5);
        }

        @Override // af.u
        public int getLength() {
            return this.y;
        }

        @Override // af.u
        public int i4() {
            if (this.y > 0) {
                return 0;
            }
            return -1;
        }

        @Override // af.u
        public int mt() {
            int i = this.y;
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }

        @Override // af.u
        public int r(int i) {
            int i5 = i + 1;
            if (i5 >= this.y) {
                return -1;
            }
            return i5;
        }

        @Override // af.u
        public u x4() {
            return new n3(0);
        }

        @Override // af.u
        public int z(int i) {
            int i5 = i - 1;
            if (i5 < 0) {
                return -1;
            }
            return i5;
        }
    }

    /* loaded from: classes.dex */
    public static class y implements u {

        /* renamed from: n3  reason: collision with root package name */
        public final int[] f383n3;
        public final Random y;

        /* renamed from: zn  reason: collision with root package name */
        public final int[] f384zn;

        public y(int i) {
            this(i, new Random());
        }

        public static int[] y(int i, Random random) {
            int[] iArr = new int[i];
            int i5 = 0;
            while (i5 < i) {
                int i6 = i5 + 1;
                int nextInt = random.nextInt(i6);
                iArr[i5] = iArr[nextInt];
                iArr[nextInt] = i5;
                i5 = i6;
            }
            return iArr;
        }

        @Override // af.u
        public u co(int i, int i5) {
            int i6 = i5 - i;
            int[] iArr = new int[this.f383n3.length - i6];
            int i8 = 0;
            int i10 = 0;
            while (true) {
                int[] iArr2 = this.f383n3;
                if (i8 < iArr2.length) {
                    int i11 = iArr2[i8];
                    if (i11 >= i && i11 < i5) {
                        i10++;
                    } else {
                        int i12 = i8 - i10;
                        if (i11 >= i) {
                            i11 -= i6;
                        }
                        iArr[i12] = i11;
                    }
                    i8++;
                } else {
                    return new y(iArr, new Random(this.y.nextLong()));
                }
            }
        }

        @Override // af.u
        public u f3(int i, int i5) {
            int[] iArr = new int[i5];
            int[] iArr2 = new int[i5];
            int i6 = 0;
            int i8 = 0;
            while (i8 < i5) {
                iArr[i8] = this.y.nextInt(this.f383n3.length + 1);
                int i10 = i8 + 1;
                int nextInt = this.y.nextInt(i10);
                iArr2[i8] = iArr2[nextInt];
                iArr2[nextInt] = i8 + i;
                i8 = i10;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f383n3.length + i5];
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int[] iArr4 = this.f383n3;
                if (i6 < iArr4.length + i5) {
                    if (i11 < i5 && i12 == iArr[i11]) {
                        iArr3[i6] = iArr2[i11];
                        i11++;
                    } else {
                        int i13 = i12 + 1;
                        int i14 = iArr4[i12];
                        iArr3[i6] = i14;
                        if (i14 >= i) {
                            iArr3[i6] = i14 + i5;
                        }
                        i12 = i13;
                    }
                    i6++;
                } else {
                    return new y(iArr3, new Random(this.y.nextLong()));
                }
            }
        }

        @Override // af.u
        public int getLength() {
            return this.f383n3.length;
        }

        @Override // af.u
        public int i4() {
            int[] iArr = this.f383n3;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // af.u
        public int mt() {
            int[] iArr = this.f383n3;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // af.u
        public int r(int i) {
            int i5 = this.f384zn[i] + 1;
            int[] iArr = this.f383n3;
            if (i5 < iArr.length) {
                return iArr[i5];
            }
            return -1;
        }

        @Override // af.u
        public u x4() {
            return new y(0, new Random(this.y.nextLong()));
        }

        @Override // af.u
        public int z(int i) {
            int i5 = this.f384zn[i] - 1;
            if (i5 < 0) {
                return -1;
            }
            return this.f383n3[i5];
        }

        public y(int i, Random random) {
            this(y(i, random), random);
        }

        public y(int[] iArr, Random random) {
            this.f383n3 = iArr;
            this.y = random;
            this.f384zn = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.f384zn[iArr[i]] = i;
            }
        }
    }

    u co(int i, int i5);

    u f3(int i, int i5);

    int getLength();

    int i4();

    int mt();

    int r(int i);

    u x4();

    int z(int i);
}
