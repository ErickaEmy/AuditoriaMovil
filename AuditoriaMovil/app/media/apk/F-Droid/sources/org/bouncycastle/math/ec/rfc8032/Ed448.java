package org.bouncycastle.math.ec.rfc8032;

import java.security.SecureRandom;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.math.ec.rfc7748.X448;
import org.bouncycastle.math.ec.rfc7748.X448Field;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;
/* loaded from: classes2.dex */
public abstract class Ed448 {
    private static final int COORD_INTS = 14;
    private static final int C_d = -39081;
    private static final int L4_0 = 43969588;
    private static final int L4_1 = 30366549;
    private static final int L4_2 = 163752818;
    private static final int L4_3 = 258169998;
    private static final int L4_4 = 96434764;
    private static final int L4_5 = 227822194;
    private static final int L4_6 = 149865618;
    private static final int L4_7 = 550336261;
    private static final int L_0 = 78101261;
    private static final int L_1 = 141809365;
    private static final int L_2 = 175155932;
    private static final int L_3 = 64542499;
    private static final int L_4 = 158326419;
    private static final int L_5 = 191173276;
    private static final int L_6 = 104575268;
    private static final int L_7 = 137584065;
    private static final long M26L = 67108863;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;
    private static final int POINT_BYTES = 57;
    private static final int PRECOMP_BLOCKS = 5;
    private static final int PRECOMP_MASK = 15;
    private static final int PRECOMP_POINTS = 16;
    private static final int PRECOMP_RANGE = 450;
    private static final int PRECOMP_SPACING = 18;
    private static final int PRECOMP_TEETH = 5;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 57;
    private static final int SCALAR_BYTES = 57;
    private static final int SCALAR_INTS = 14;
    public static final int SECRET_KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private static final int WNAF_WIDTH_BASE = 7;
    private static final byte[] DOM4_PREFIX = {83, 105, 103, 69, 100, 52, 52, 56};
    private static final int[] P = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    private static final int[] L = {-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, 1073741823};
    private static final int[] B_x = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};
    private static final int[] B_y = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};
    private static final Object precompLock = new Object();
    private static PointExt[] precompBaseTable = null;
    private static int[] precompBase = null;

    /* loaded from: classes2.dex */
    public static final class Algorithm {
        public static final int Ed448 = 0;
        public static final int Ed448ph = 1;
    }

    /* loaded from: classes2.dex */
    private static class F extends X448Field {
        private F() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class PointExt {
        int[] x;
        int[] y;
        int[] z;

        private PointExt() {
            this.x = X448Field.create();
            this.y = X448Field.create();
            this.z = X448Field.create();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class PointPrecomp {
        int[] x;
        int[] y;

        private PointPrecomp() {
            this.x = X448Field.create();
            this.y = X448Field.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[28];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[14];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[14];
        decodeScalar(bArr3, 0, iArr3);
        Nat.mulAddTo(14, iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[114];
        for (int i = 0; i < 28; i++) {
            encode32(iArr[i], bArr4, i * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr) {
        return bArr != null && bArr.length < 256;
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        X448Field.sqr(iArr, create2);
        X448Field.sqr(iArr2, create3);
        X448Field.mul(create2, create3, create);
        X448Field.add(create2, create3, create2);
        X448Field.mul(create, 39081, create);
        X448Field.subOne(create);
        X448Field.add(create, create2, create);
        X448Field.normalize(create);
        return X448Field.isZero(create);
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        X448Field.sqr(iArr, create2);
        X448Field.sqr(iArr2, create3);
        X448Field.sqr(iArr3, create4);
        X448Field.mul(create2, create3, create);
        X448Field.add(create2, create3, create2);
        X448Field.mul(create2, create4, create2);
        X448Field.sqr(create4, create4);
        X448Field.mul(create, 39081, create);
        X448Field.sub(create, create4, create);
        X448Field.add(create, create2, create);
        X448Field.normalize(create);
        return X448Field.isZero(create);
    }

    private static boolean checkPointVar(byte[] bArr) {
        if ((bArr[56] & Byte.MAX_VALUE) != 0) {
            return false;
        }
        int[] iArr = new int[14];
        decode32(bArr, 0, iArr, 0, 14);
        return !Nat.gte(14, iArr, P);
    }

    private static boolean checkScalarVar(byte[] bArr, int[] iArr) {
        if (bArr[56] != 0) {
            return false;
        }
        decodeScalar(bArr, 0, iArr);
        return !Nat.gte(14, iArr, L);
    }

    private static byte[] copy(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static Xof createPrehash() {
        return createXof();
    }

    private static Xof createXof() {
        return new SHAKEDigest(256);
    }

    private static int decode16(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    private static int decode24(byte[] bArr, int i) {
        return ((bArr[i + 2] & 255) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    private static int decode32(byte[] bArr, int i) {
        return (bArr[i + 3] << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static void decode32(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = decode32(bArr, (i4 * 4) + i);
        }
    }

    private static boolean decodePointVar(byte[] bArr, int i, boolean z, PointExt pointExt) {
        byte[] copy = copy(bArr, i, 57);
        if (checkPointVar(copy)) {
            byte b = copy[56];
            int i2 = (b & 128) >>> 7;
            copy[56] = (byte) (b & Byte.MAX_VALUE);
            X448Field.decode(copy, 0, pointExt.y);
            int[] create = X448Field.create();
            int[] create2 = X448Field.create();
            X448Field.sqr(pointExt.y, create);
            X448Field.mul(create, 39081, create2);
            X448Field.negate(create, create);
            X448Field.addOne(create);
            X448Field.addOne(create2);
            if (X448Field.sqrtRatioVar(create, create2, pointExt.x)) {
                X448Field.normalize(pointExt.x);
                if (i2 == 1 && X448Field.isZeroVar(pointExt.x)) {
                    return false;
                }
                int[] iArr = pointExt.x;
                if (z ^ (i2 != (iArr[0] & 1))) {
                    X448Field.negate(iArr, iArr);
                }
                pointExtendXY(pointExt);
                return true;
            }
            return false;
        }
        return false;
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        decode32(bArr, i, iArr, 0, 14);
    }

    private static void dom4(Xof xof, byte b, byte[] bArr) {
        byte[] bArr2 = DOM4_PREFIX;
        int length = bArr2.length;
        int i = length + 2;
        int length2 = bArr.length + i;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        bArr3[length] = b;
        bArr3[length + 1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr3, i, bArr.length);
        xof.update(bArr3, 0, length2);
    }

    private static void encode24(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
    }

    private static void encode32(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    private static void encode56(long j, byte[] bArr, int i) {
        encode32((int) j, bArr, i);
        encode24((int) (j >>> 32), bArr, i + 4);
    }

    private static int encodePoint(PointExt pointExt, byte[] bArr, int i) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        X448Field.inv(pointExt.z, create2);
        X448Field.mul(pointExt.x, create2, create);
        X448Field.mul(pointExt.y, create2, create2);
        X448Field.normalize(create);
        X448Field.normalize(create2);
        int checkPoint = checkPoint(create, create2);
        X448Field.encode(create2, bArr, i);
        bArr[i + 56] = (byte) ((create[0] & 1) << 7);
        return checkPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        Xof createXof = createXof();
        byte[] bArr3 = new byte[114];
        createXof.update(bArr, i, 57);
        createXof.doFinal(bArr3, 0, 114);
        byte[] bArr4 = new byte[57];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i2);
    }

    private static int getWindow4(int[] iArr, int i) {
        return (iArr[i >>> 3] >>> ((i & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] iArr, int i) {
        int[] iArr2 = new int[28];
        int i2 = 0;
        int i3 = 14;
        int i4 = 28;
        int i5 = 0;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            int i6 = iArr[i3];
            iArr2[i4 - 1] = (i5 << 16) | (i6 >>> 16);
            i4 -= 2;
            iArr2[i4] = i6;
            i5 = i6;
        }
        byte[] bArr = new byte[447];
        int i7 = 32 - i;
        int i8 = 0;
        int i9 = 0;
        while (i2 < 28) {
            int i10 = iArr2[i2];
            while (i8 < 16) {
                int i11 = i10 >>> i8;
                if ((i11 & 1) == i9) {
                    i8++;
                } else {
                    int i12 = (i11 | 1) << i7;
                    bArr[(i2 << 4) + i8] = (byte) (i12 >> i7);
                    i8 += i;
                    i9 = i12 >>> 31;
                }
            }
            i2++;
            i8 -= 16;
        }
        return bArr;
    }

    private static void implSign(Xof xof, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b, byte[] bArr5, int i2, int i3, byte[] bArr6, int i4) {
        dom4(xof, b, bArr4);
        xof.update(bArr, 57, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] reduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(reduceScalar, bArr7, 0);
        dom4(xof, b, bArr4);
        xof.update(bArr7, 0, 57);
        xof.update(bArr3, i, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] calculateS = calculateS(reduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i4, 57);
        System.arraycopy(calculateS, 0, bArr6, i4 + 57, 57);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, byte b, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        if (!checkContextVar(bArr2)) {
            throw new IllegalArgumentException("ctx");
        }
        Xof createXof = createXof();
        byte[] bArr5 = new byte[114];
        createXof.update(bArr, i, 57);
        createXof.doFinal(bArr5, 0, 114);
        byte[] bArr6 = new byte[57];
        pruneScalar(bArr5, 0, bArr6);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(bArr6, bArr7, 0);
        implSign(createXof, bArr5, bArr6, bArr7, 0, bArr2, b, bArr3, i2, i3, bArr4, i4);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        if (!checkContextVar(bArr3)) {
            throw new IllegalArgumentException("ctx");
        }
        Xof createXof = createXof();
        byte[] bArr6 = new byte[114];
        createXof.update(bArr, i, 57);
        createXof.doFinal(bArr6, 0, 114);
        byte[] bArr7 = new byte[57];
        pruneScalar(bArr6, 0, bArr7);
        implSign(createXof, bArr6, bArr7, bArr2, i2, bArr3, b, bArr4, i3, i4, bArr5, i5);
    }

    private static boolean implVerify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4) {
        if (checkContextVar(bArr3)) {
            byte[] copy = copy(bArr, i, 57);
            byte[] copy2 = copy(bArr, i + 57, 57);
            if (checkPointVar(copy)) {
                int[] iArr = new int[14];
                if (checkScalarVar(copy2, iArr)) {
                    PointExt pointExt = new PointExt();
                    if (decodePointVar(bArr2, i2, true, pointExt)) {
                        Xof createXof = createXof();
                        byte[] bArr5 = new byte[114];
                        dom4(createXof, b, bArr3);
                        createXof.update(copy, 0, 57);
                        createXof.update(bArr2, i2, 57);
                        createXof.update(bArr4, i3, i4);
                        createXof.doFinal(bArr5, 0, 114);
                        int[] iArr2 = new int[14];
                        decodeScalar(reduceScalar(bArr5), 0, iArr2);
                        PointExt pointExt2 = new PointExt();
                        scalarMultStrausVar(iArr, iArr2, pointExt, pointExt2);
                        byte[] bArr6 = new byte[57];
                        return encodePoint(pointExt2, bArr6, 0) != 0 && Arrays.areEqual(bArr6, copy);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean isNeutralElementVar(int[] iArr, int[] iArr2, int[] iArr3) {
        return X448Field.isZeroVar(iArr) && X448Field.areEqualVar(iArr2, iArr3);
    }

    private static void pointAdd(PointExt pointExt, PointExt pointExt2) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        int[] create8 = X448Field.create();
        X448Field.mul(pointExt.z, pointExt2.z, create);
        X448Field.sqr(create, create2);
        X448Field.mul(pointExt.x, pointExt2.x, create3);
        X448Field.mul(pointExt.y, pointExt2.y, create4);
        X448Field.mul(create3, create4, create5);
        X448Field.mul(create5, 39081, create5);
        X448Field.add(create2, create5, create6);
        X448Field.sub(create2, create5, create7);
        X448Field.add(pointExt.x, pointExt.y, create2);
        X448Field.add(pointExt2.x, pointExt2.y, create5);
        X448Field.mul(create2, create5, create8);
        X448Field.add(create4, create3, create2);
        X448Field.sub(create4, create3, create5);
        X448Field.carry(create2);
        X448Field.sub(create8, create2, create8);
        X448Field.mul(create8, create, create8);
        X448Field.mul(create5, create, create5);
        X448Field.mul(create6, create8, pointExt2.x);
        X448Field.mul(create5, create7, pointExt2.y);
        X448Field.mul(create6, create7, pointExt2.z);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointExt pointExt) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        X448Field.sqr(pointExt.z, create);
        X448Field.mul(pointPrecomp.x, pointExt.x, create2);
        X448Field.mul(pointPrecomp.y, pointExt.y, create3);
        X448Field.mul(create2, create3, create4);
        X448Field.mul(create4, 39081, create4);
        X448Field.add(create, create4, create5);
        X448Field.sub(create, create4, create6);
        X448Field.add(pointPrecomp.x, pointPrecomp.y, create);
        X448Field.add(pointExt.x, pointExt.y, create4);
        X448Field.mul(create, create4, create7);
        X448Field.add(create3, create2, create);
        X448Field.sub(create3, create2, create4);
        X448Field.carry(create);
        X448Field.sub(create7, create, create7);
        X448Field.mul(create7, pointExt.z, create7);
        X448Field.mul(create4, pointExt.z, create4);
        X448Field.mul(create5, create7, pointExt.x);
        X448Field.mul(create4, create6, pointExt.y);
        X448Field.mul(create5, create6, pointExt.z);
    }

    private static void pointAddVar(boolean z, PointExt pointExt, PointExt pointExt2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        int[] create8 = X448Field.create();
        if (z) {
            X448Field.sub(pointExt.y, pointExt.x, create8);
            iArr2 = create2;
            iArr = create5;
            iArr4 = create6;
            iArr3 = create7;
        } else {
            X448Field.add(pointExt.y, pointExt.x, create8);
            iArr = create2;
            iArr2 = create5;
            iArr3 = create6;
            iArr4 = create7;
        }
        X448Field.mul(pointExt.z, pointExt2.z, create);
        X448Field.sqr(create, create2);
        X448Field.mul(pointExt.x, pointExt2.x, create3);
        X448Field.mul(pointExt.y, pointExt2.y, create4);
        X448Field.mul(create3, create4, create5);
        X448Field.mul(create5, 39081, create5);
        X448Field.add(create2, create5, iArr3);
        X448Field.sub(create2, create5, iArr4);
        X448Field.add(pointExt2.x, pointExt2.y, create5);
        X448Field.mul(create8, create5, create8);
        X448Field.add(create4, create3, iArr);
        X448Field.sub(create4, create3, iArr2);
        X448Field.carry(iArr);
        X448Field.sub(create8, create2, create8);
        X448Field.mul(create8, create, create8);
        X448Field.mul(create5, create, create5);
        X448Field.mul(create6, create8, pointExt2.x);
        X448Field.mul(create5, create7, pointExt2.y);
        X448Field.mul(create6, create7, pointExt2.z);
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        X448Field.copy(pointExt.x, 0, pointExt2.x, 0);
        X448Field.copy(pointExt.y, 0, pointExt2.y, 0);
        X448Field.copy(pointExt.z, 0, pointExt2.z, 0);
    }

    private static void pointDouble(PointExt pointExt) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        X448Field.add(pointExt.x, pointExt.y, create);
        X448Field.sqr(create, create);
        X448Field.sqr(pointExt.x, create2);
        X448Field.sqr(pointExt.y, create3);
        X448Field.add(create2, create3, create4);
        X448Field.carry(create4);
        X448Field.sqr(pointExt.z, create5);
        X448Field.add(create5, create5, create5);
        X448Field.carry(create5);
        X448Field.sub(create4, create5, create6);
        X448Field.sub(create, create4, create);
        X448Field.sub(create2, create3, create2);
        X448Field.mul(create, create6, pointExt.x);
        X448Field.mul(create4, create2, pointExt.y);
        X448Field.mul(create4, create6, pointExt.z);
    }

    private static void pointExtendXY(PointExt pointExt) {
        X448Field.one(pointExt.z);
    }

    private static void pointLookup(int i, int i2, PointPrecomp pointPrecomp) {
        int i3 = i * 512;
        for (int i4 = 0; i4 < 16; i4++) {
            int i5 = ((i4 ^ i2) - 1) >> 31;
            X448Field.cmov(i5, precompBase, i3, pointPrecomp.x, 0);
            X448Field.cmov(i5, precompBase, i3 + 16, pointPrecomp.y, 0);
            i3 += 32;
        }
    }

    private static void pointLookup(int[] iArr, int i, int[] iArr2, PointExt pointExt) {
        int window4 = getWindow4(iArr, i);
        int i2 = (window4 >>> 3) ^ 1;
        int i3 = (window4 ^ (-i2)) & 7;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = ((i5 ^ i3) - 1) >> 31;
            X448Field.cmov(i6, iArr2, i4, pointExt.x, 0);
            X448Field.cmov(i6, iArr2, i4 + 16, pointExt.y, 0);
            X448Field.cmov(i6, iArr2, i4 + 32, pointExt.z, 0);
            i4 += 48;
        }
        X448Field.cnegate(i2, pointExt.x);
    }

    private static void pointLookup15(int[] iArr, PointExt pointExt) {
        X448Field.copy(iArr, 336, pointExt.x, 0);
        X448Field.copy(iArr, 352, pointExt.y, 0);
        X448Field.copy(iArr, 368, pointExt.z, 0);
    }

    private static int[] pointPrecompute(PointExt pointExt, int i) {
        PointExt pointCopy = pointCopy(pointExt);
        PointExt pointCopy2 = pointCopy(pointCopy);
        pointDouble(pointCopy2);
        int[] createTable = X448Field.createTable(i * 3);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            X448Field.copy(pointCopy.x, 0, createTable, i2);
            X448Field.copy(pointCopy.y, 0, createTable, i2 + 16);
            X448Field.copy(pointCopy.z, 0, createTable, i2 + 32);
            i2 += 48;
            i3++;
            if (i3 == i) {
                return createTable;
            }
            pointAdd(pointCopy2, pointCopy);
        }
    }

    private static PointExt[] pointPrecomputeVar(PointExt pointExt, int i) {
        PointExt pointCopy = pointCopy(pointExt);
        pointDouble(pointCopy);
        PointExt[] pointExtArr = new PointExt[i];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i2 = 1; i2 < i; i2++) {
            PointExt pointCopy2 = pointCopy(pointExtArr[i2 - 1]);
            pointExtArr[i2] = pointCopy2;
            pointAddVar(false, pointCopy, pointCopy2);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointExt pointExt) {
        X448Field.zero(pointExt.x);
        X448Field.one(pointExt.y);
        X448Field.one(pointExt.z);
    }

    public static void precompute() {
        synchronized (precompLock) {
            try {
                if (precompBase != null) {
                    return;
                }
                PointExt pointExt = new PointExt();
                X448Field.copy(B_x, 0, pointExt.x, 0);
                X448Field.copy(B_y, 0, pointExt.y, 0);
                pointExtendXY(pointExt);
                precompBaseTable = pointPrecomputeVar(pointExt, 32);
                precompBase = X448Field.createTable(160);
                int i = 0;
                for (int i2 = 0; i2 < 5; i2++) {
                    PointExt[] pointExtArr = new PointExt[5];
                    PointExt pointExt2 = new PointExt();
                    pointSetNeutral(pointExt2);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 5) {
                            break;
                        }
                        pointAddVar(true, pointExt, pointExt2);
                        pointDouble(pointExt);
                        pointExtArr[i3] = pointCopy(pointExt);
                        if (i2 + i3 != 8) {
                            for (int i4 = 1; i4 < 18; i4++) {
                                pointDouble(pointExt);
                            }
                        }
                        i3++;
                    }
                    PointExt[] pointExtArr2 = new PointExt[16];
                    pointExtArr2[0] = pointExt2;
                    int i5 = 1;
                    for (int i6 = 0; i6 < 4; i6++) {
                        int i7 = 1 << i6;
                        int i8 = 0;
                        while (i8 < i7) {
                            PointExt pointCopy = pointCopy(pointExtArr2[i5 - i7]);
                            pointExtArr2[i5] = pointCopy;
                            pointAddVar(false, pointExtArr[i6], pointCopy);
                            i8++;
                            i5++;
                        }
                    }
                    int[] createTable = X448Field.createTable(16);
                    int[] create = X448Field.create();
                    X448Field.copy(pointExtArr2[0].z, 0, create, 0);
                    X448Field.copy(create, 0, createTable, 0);
                    int i9 = 0;
                    while (true) {
                        int i10 = i9 + 1;
                        if (i10 >= 16) {
                            break;
                        }
                        X448Field.mul(create, pointExtArr2[i10].z, create);
                        X448Field.copy(create, 0, createTable, i10 * 16);
                        i9 = i10;
                    }
                    X448Field.invVar(create, create);
                    int[] create2 = X448Field.create();
                    while (i9 > 0) {
                        int i11 = i9 - 1;
                        X448Field.copy(createTable, i11 * 16, create2, 0);
                        X448Field.mul(create2, create, create2);
                        X448Field.copy(create2, 0, createTable, i9 * 16);
                        X448Field.mul(create, pointExtArr2[i9].z, create);
                        i9 = i11;
                    }
                    X448Field.copy(create, 0, createTable, 0);
                    for (int i12 = 0; i12 < 16; i12++) {
                        PointExt pointExt3 = pointExtArr2[i12];
                        X448Field.copy(createTable, i12 * 16, pointExt3.z, 0);
                        int[] iArr = pointExt3.x;
                        X448Field.mul(iArr, pointExt3.z, iArr);
                        int[] iArr2 = pointExt3.y;
                        X448Field.mul(iArr2, pointExt3.z, iArr2);
                        X448Field.copy(pointExt3.x, 0, precompBase, i);
                        X448Field.copy(pointExt3.y, 0, precompBase, i + 16);
                        i += 32;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | 128);
        bArr2[56] = 0;
    }

    private static byte[] reduceScalar(byte[] bArr) {
        long decode32 = decode32(bArr, 84);
        long j = decode32 & 4294967295L;
        long decode322 = decode32(bArr, 91);
        long j2 = decode322 & 4294967295L;
        long decode323 = decode32(bArr, 98);
        long j3 = decode323 & 4294967295L;
        long decode324 = decode32(bArr, 105);
        long j4 = decode324 & 4294967295L;
        long decode16 = decode16(bArr, 112) & 4294967295L;
        long decode24 = ((decode24(bArr, 109) << 4) & 4294967295L) + (j4 >>> 28);
        long j5 = decode324 & M28L;
        long decode325 = (decode32(bArr, 56) & 4294967295L) + (decode16 * 43969588) + (decode24 * 30366549);
        long decode242 = ((decode24(bArr, 60) << 4) & 4294967295L) + (decode16 * 30366549) + (decode24 * 163752818);
        long decode326 = (decode32(bArr, 63) & 4294967295L) + (decode16 * 163752818) + (decode24 * 258169998);
        long decode243 = ((decode24(bArr, 67) << 4) & 4294967295L) + (decode16 * 258169998) + (decode24 * 96434764);
        long decode327 = (decode32(bArr, 77) & 4294967295L) + (decode16 * 149865618) + (decode24 * 550336261);
        long decode328 = (decode32(bArr, 49) & 4294967295L) + (j5 * 43969588);
        long decode244 = ((decode24(bArr, 102) << 4) & 4294967295L) + (j3 >>> 28);
        long j6 = decode323 & M28L;
        long decode329 = (decode32(bArr, 70) & 4294967295L) + (decode16 * 96434764) + (decode24 * 227822194) + (j5 * 149865618) + (decode244 * 550336261);
        long decode3210 = (decode32(bArr, 42) & 4294967295L) + (j6 * 43969588);
        long decode245 = ((decode24(bArr, 95) << 4) & 4294967295L) + (j2 >>> 28);
        long j7 = decode322 & M28L;
        long j8 = decode326 + (j5 * 96434764) + (decode244 * 227822194) + (j6 * 149865618) + (decode245 * 550336261);
        long j9 = decode242 + (j5 * 258169998) + (decode244 * 96434764) + (j6 * 227822194) + (decode245 * 149865618) + (j7 * 550336261);
        long decode246 = ((decode24(bArr, 88) << 4) & 4294967295L) + (j >>> 28);
        long j10 = decode32 & M28L;
        long decode247 = ((decode24(bArr, 74) << 4) & 4294967295L) + (decode16 * 227822194) + (decode24 * 149865618) + (j5 * 550336261) + (decode329 >>> 28);
        long j11 = decode329 & M28L;
        long j12 = decode327 + (decode247 >>> 28);
        long j13 = decode247 & M28L;
        long decode248 = ((decode24(bArr, 81) << 4) & 4294967295L) + (decode16 * 550336261) + (j12 >>> 28);
        long j14 = j12 & M28L;
        long j15 = j10 + (decode248 >>> 28);
        long j16 = decode248 & M28L;
        long decode249 = ((decode24(bArr, 25) << 4) & 4294967295L) + (j16 * 43969588);
        long decode3211 = (decode32(bArr, 28) & 4294967295L) + (j15 * 43969588) + (j16 * 30366549);
        long decode2410 = ((decode24(bArr, 32) << 4) & 4294967295L) + (decode246 * 43969588) + (j15 * 30366549) + (j16 * 163752818);
        long decode3212 = (decode32(bArr, 35) & 4294967295L) + (j7 * 43969588) + (decode246 * 30366549) + (j15 * 163752818) + (j16 * 258169998);
        long decode2411 = ((decode24(bArr, 39) << 4) & 4294967295L) + (decode245 * 43969588) + (j7 * 30366549) + (decode246 * 163752818) + (j15 * 258169998) + (j16 * 96434764);
        long j17 = decode3210 + (decode245 * 30366549) + (j7 * 163752818) + (decode246 * 258169998) + (j15 * 96434764) + (j16 * 227822194);
        long j18 = decode328 + (decode244 * 30366549) + (j6 * 163752818) + (decode245 * 258169998) + (j7 * 96434764) + (decode246 * 227822194) + (j15 * 149865618) + (j16 * 550336261);
        long decode3213 = (decode32(bArr, 21) & 4294967295L) + (j14 * 43969588);
        long j19 = j8 + (j9 >>> 28);
        long j20 = j9 & M28L;
        long j21 = decode243 + (j5 * 227822194) + (decode244 * 149865618) + (j6 * 550336261) + (j19 >>> 28);
        long j22 = j19 & M28L;
        long j23 = j11 + (j21 >>> 28);
        long j24 = j21 & M28L;
        long j25 = j13 + (j23 >>> 28);
        long j26 = j23 & M28L;
        long j27 = decode2411 + (j14 * 227822194) + (j25 * 149865618) + (j26 * 550336261);
        long decode3214 = (decode32(bArr, 14) & 4294967295L) + (j26 * 43969588) + (j24 * 30366549);
        long decode2412 = ((decode24(bArr, 18) << 4) & 4294967295L) + (j25 * 43969588) + (j26 * 30366549) + (j24 * 163752818);
        long j28 = decode3213 + (j25 * 30366549) + (j26 * 163752818) + (j24 * 258169998);
        long j29 = decode249 + (j14 * 30366549) + (j25 * 163752818) + (j26 * 258169998) + (j24 * 96434764);
        long j30 = decode3211 + (j14 * 163752818) + (j25 * 258169998) + (j26 * 96434764) + (j24 * 227822194);
        long j31 = decode2410 + (j14 * 258169998) + (j25 * 96434764) + (j26 * 227822194) + (j24 * 149865618);
        long j32 = decode3212 + (j14 * 96434764) + (j25 * 227822194) + (j26 * 149865618) + (j24 * 550336261);
        long decode2413 = ((decode24(bArr, 53) << 4) & 4294967295L) + (decode24 * 43969588) + (j5 * 30366549) + (decode244 * 163752818) + (j6 * 258169998) + (decode245 * 96434764) + (j7 * 227822194) + (decode246 * 149865618) + (j15 * 550336261) + (j18 >>> 28);
        long j33 = j18 & M28L;
        long j34 = decode325 + (j5 * 163752818) + (decode244 * 258169998) + (j6 * 96434764) + (decode245 * 227822194) + (j7 * 149865618) + (decode246 * 550336261) + (decode2413 >>> 28);
        long j35 = decode2413 & M28L;
        long j36 = j20 + (j34 >>> 28);
        long j37 = j34 & M28L;
        long j38 = j22 + (j36 >>> 28);
        long j39 = j36 & M28L;
        long j40 = j28 + (j38 * 96434764);
        long j41 = j31 + (j38 * 550336261);
        long j42 = decode2413 & M26L;
        long j43 = (j37 * 4) + (j35 >>> 26) + 1;
        long decode3215 = (decode32(bArr, 0) & 4294967295L) + (78101261 * j43);
        long decode3216 = (decode32(bArr, 7) & 4294967295L) + (j38 * 43969588) + (30366549 * j39) + (175155932 * j43);
        long decode2414 = ((decode24(bArr, 11) << 4) & 4294967295L) + (j24 * 43969588) + (j38 * 30366549) + (163752818 * j39) + (64542499 * j43);
        long j44 = decode3214 + (j38 * 163752818) + (258169998 * j39) + (158326419 * j43);
        long j45 = decode2412 + (j38 * 258169998) + (96434764 * j39) + (191173276 * j43);
        long j46 = j29 + (j38 * 227822194) + (149865618 * j39) + (j43 * 137584065);
        long decode2415 = ((decode24(bArr, 4) << 4) & 4294967295L) + (43969588 * j39) + (141809365 * j43) + (decode3215 >>> 28);
        long j47 = decode3215 & M28L;
        long j48 = decode3216 + (decode2415 >>> 28);
        long j49 = decode2415 & M28L;
        long j50 = decode2414 + (j48 >>> 28);
        long j51 = j48 & M28L;
        long j52 = j44 + (j50 >>> 28);
        long j53 = j50 & M28L;
        long j54 = j45 + (j52 >>> 28);
        long j55 = j52 & M28L;
        long j56 = j40 + (227822194 * j39) + (104575268 * j43) + (j54 >>> 28);
        long j57 = j54 & M28L;
        long j58 = j46 + (j56 >>> 28);
        long j59 = j56 & M28L;
        long j60 = j30 + (j38 * 149865618) + (j39 * 550336261) + (j58 >>> 28);
        long j61 = j58 & M28L;
        long j62 = j41 + (j60 >>> 28);
        long j63 = j60 & M28L;
        long j64 = j32 + (j62 >>> 28);
        long j65 = j62 & M28L;
        long j66 = j27 + (j64 >>> 28);
        long j67 = j64 & M28L;
        long j68 = j17 + (j14 * 149865618) + (j25 * 550336261) + (j66 >>> 28);
        long j69 = j66 & M28L;
        long decode2416 = ((decode24(bArr, 46) << 4) & 4294967295L) + (decode244 * 43969588) + (j6 * 30366549) + (decode245 * 163752818) + (j7 * 258169998) + (decode246 * 96434764) + (j15 * 227822194) + (j16 * 149865618) + (j14 * 550336261) + (j68 >>> 28);
        long j70 = j68 & M28L;
        long j71 = j33 + (decode2416 >>> 28);
        long j72 = decode2416 & M28L;
        long j73 = j42 + (j71 >>> 28);
        long j74 = j71 & M28L;
        long j75 = j73 & M26L;
        long j76 = (j73 >>> 26) - 1;
        long j77 = j47 - (j76 & 78101261);
        long j78 = (j49 - (j76 & 141809365)) + (j77 >> 28);
        long j79 = j77 & M28L;
        long j80 = (j51 - (j76 & 175155932)) + (j78 >> 28);
        long j81 = j78 & M28L;
        long j82 = (j53 - (j76 & 64542499)) + (j80 >> 28);
        long j83 = j80 & M28L;
        long j84 = (j55 - (j76 & 158326419)) + (j82 >> 28);
        long j85 = j82 & M28L;
        long j86 = (j57 - (j76 & 191173276)) + (j84 >> 28);
        long j87 = j84 & M28L;
        long j88 = (j59 - (j76 & 104575268)) + (j86 >> 28);
        long j89 = j86 & M28L;
        long j90 = (j61 - (j76 & 137584065)) + (j88 >> 28);
        long j91 = j88 & M28L;
        long j92 = j63 + (j90 >> 28);
        long j93 = j90 & M28L;
        long j94 = j65 + (j92 >> 28);
        long j95 = j92 & M28L;
        long j96 = j67 + (j94 >> 28);
        long j97 = j94 & M28L;
        long j98 = j69 + (j96 >> 28);
        long j99 = j96 & M28L;
        long j100 = j70 + (j98 >> 28);
        long j101 = j98 & M28L;
        long j102 = j72 + (j100 >> 28);
        long j103 = j100 & M28L;
        long j104 = j74 + (j102 >> 28);
        long j105 = j102 & M28L;
        long j106 = j104 & M28L;
        byte[] bArr2 = new byte[57];
        encode56((j81 << 28) | j79, bArr2, 0);
        encode56((j85 << 28) | j83, bArr2, 7);
        encode56(j87 | (j89 << 28), bArr2, 14);
        encode56(j91 | (j93 << 28), bArr2, 21);
        encode56(j95 | (j97 << 28), bArr2, 28);
        encode56(j99 | (j101 << 28), bArr2, 35);
        encode56(j103 | (j105 << 28), bArr2, 42);
        encode56(((j75 + (j104 >> 28)) << 28) | j106, bArr2, 49);
        return bArr2;
    }

    private static void scalarMult(byte[] bArr, PointExt pointExt, PointExt pointExt2) {
        int[] iArr = new int[14];
        decodeScalar(bArr, 0, iArr);
        Nat.shiftDownBit(14, iArr, Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr));
        int[] pointPrecompute = pointPrecompute(pointExt, 8);
        PointExt pointExt3 = new PointExt();
        pointLookup15(pointPrecompute, pointExt2);
        pointAdd(pointExt, pointExt2);
        int i = 111;
        while (true) {
            pointLookup(iArr, i, pointPrecompute, pointExt3);
            pointAdd(pointExt3, pointExt2);
            i--;
            if (i < 0) {
                return;
            }
            for (int i2 = 0; i2 < 4; i2++) {
                pointDouble(pointExt2);
            }
        }
    }

    private static void scalarMultBase(byte[] bArr, PointExt pointExt) {
        precompute();
        int[] iArr = new int[15];
        decodeScalar(bArr, 0, iArr);
        iArr[14] = Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr) + 4;
        Nat.shiftDownBit(15, iArr, 0);
        PointPrecomp pointPrecomp = new PointPrecomp();
        pointSetNeutral(pointExt);
        int i = 17;
        while (true) {
            int i2 = i;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < 5; i5++) {
                    i4 = (i4 & (~(1 << i5))) ^ ((iArr[i2 >>> 5] >>> (i2 & 31)) << i5);
                    i2 += 18;
                }
                int i6 = (i4 >>> 4) & 1;
                pointLookup(i3, ((-i6) ^ i4) & 15, pointPrecomp);
                X448Field.cnegate(i6, pointPrecomp.x);
                pointAddPrecomp(pointPrecomp, pointExt);
            }
            i--;
            if (i < 0) {
                return;
            }
            pointDouble(pointExt);
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i) {
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr, pointExt);
        if (encodePoint(pointExt, bArr2, i) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseXY(X448.Friend friend, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by X448");
        }
        byte[] bArr2 = new byte[57];
        pruneScalar(bArr, i, bArr2);
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr2, pointExt);
        if (checkPoint(pointExt.x, pointExt.y, pointExt.z) == 0) {
            throw new IllegalStateException();
        }
        X448Field.copy(pointExt.x, 0, iArr, 0);
        X448Field.copy(pointExt.y, 0, iArr2, 0);
    }

    private static void scalarMultOrderVar(PointExt pointExt, PointExt pointExt2) {
        byte[] wnafVar = getWnafVar(L, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i = 446;
        while (true) {
            byte b = wnafVar[i];
            if (b != 0) {
                int i2 = b >> 31;
                pointAddVar(i2 != 0, pointPrecomputeVar[(b ^ i2) >>> 1], pointExt2);
            }
            i--;
            if (i < 0) {
                return;
            }
            pointDouble(pointExt2);
        }
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointExt pointExt, PointExt pointExt2) {
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i = 446;
        while (true) {
            byte b = wnafVar[i];
            if (b != 0) {
                int i2 = b >> 31;
                pointAddVar(i2 != 0, precompBaseTable[(b ^ i2) >>> 1], pointExt2);
            }
            byte b2 = wnafVar2[i];
            if (b2 != 0) {
                int i3 = b2 >> 31;
                pointAddVar(i3 != 0, pointPrecomputeVar[(b2 ^ i3) >>> 1], pointExt2);
            }
            i--;
            if (i < 0) {
                return;
            }
            pointDouble(pointExt2);
        }
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4, bArr5, i5);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        implSign(bArr, i, bArr2, (byte) 0, bArr3, i2, i3, bArr4, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof, byte[] bArr4, int i3) {
        byte[] bArr5 = new byte[64];
        if (64 != xof.doFinal(bArr5, 0, 64)) {
            throw new IllegalArgumentException("ph");
        }
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i3);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, int i4) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64, bArr5, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, Xof xof, byte[] bArr3, int i2) {
        byte[] bArr4 = new byte[64];
        if (64 != xof.doFinal(bArr4, 0, 64)) {
            throw new IllegalArgumentException("ph");
        }
        implSign(bArr, i, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i2);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3) {
        implSign(bArr, i, bArr2, (byte) 1, bArr3, i2, 64, bArr4, i3);
    }

    public static boolean validatePublicKeyFull(byte[] bArr, int i) {
        PointExt pointExt = new PointExt();
        if (decodePointVar(bArr, i, false, pointExt)) {
            X448Field.normalize(pointExt.x);
            X448Field.normalize(pointExt.y);
            X448Field.normalize(pointExt.z);
            if (isNeutralElementVar(pointExt.x, pointExt.y, pointExt.z)) {
                return false;
            }
            PointExt pointExt2 = new PointExt();
            scalarMultOrderVar(pointExt, pointExt2);
            X448Field.normalize(pointExt2.x);
            X448Field.normalize(pointExt2.y);
            X448Field.normalize(pointExt2.z);
            return isNeutralElementVar(pointExt2.x, pointExt2.y, pointExt2.z);
        }
        return false;
    }

    public static boolean validatePublicKeyPartial(byte[] bArr, int i) {
        return decodePointVar(bArr, i, false, new PointExt());
    }

    public static boolean verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64);
    }
}
