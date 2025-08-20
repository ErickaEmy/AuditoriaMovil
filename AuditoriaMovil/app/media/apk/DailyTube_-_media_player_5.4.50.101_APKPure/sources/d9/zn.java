package d9;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.nio.ByteBuffer;
import m1.m;
/* loaded from: classes.dex */
public final class zn {
    public static final int[] y = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final int f7244gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f7245n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f7246v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f7247zn;

        public n3(int i, int i5, int i6, int i8, int i10) {
            this.y = i;
            this.f7247zn = i5;
            this.f7245n3 = i6;
            this.f7244gv = i8;
            this.f7246v = i10;
        }
    }

    public static int a(v5.fh fhVar, int i) {
        int i5 = 0;
        while (true) {
            int s2 = i5 + fhVar.s(i);
            if (!fhVar.fb()) {
                return s2;
            }
            i5 = (s2 + 1) << i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
        if (r11 != 11) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008c, code lost:
        if (r11 != 11) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
        if (r11 != 8) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static d9.zn.n3 gv(v5.fh r11) {
        /*
            r0 = 16
            int r1 = r11.s(r0)
            int r0 = r11.s(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.s(r0)
            r2 = 7
            goto L19
        L18:
            r2 = 4
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.s(r0)
            r2 = 3
            if (r1 != r2) goto L2f
            int r4 = a(r11, r0)
            int r1 = r1 + r4
        L2f:
            r5 = r1
            r1 = 10
            int r1 = r11.s(r1)
            boolean r4 = r11.fb()
            if (r4 == 0) goto L45
            int r4 = r11.s(r2)
            if (r4 <= 0) goto L45
            r11.mt(r0)
        L45:
            boolean r4 = r11.fb()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r4 == 0) goto L55
            r9 = 48000(0xbb80, float:6.7262E-41)
            goto L58
        L55:
            r9 = 44100(0xac44, float:6.1797E-41)
        L58:
            int r11 = r11.s(r3)
            if (r9 != r6) goto L67
            r4 = 13
            if (r11 != r4) goto L67
            int[] r0 = d9.zn.y
            r11 = r0[r11]
            goto L95
        L67:
            if (r9 != r7) goto L94
            int[] r4 = d9.zn.y
            int r6 = r4.length
            if (r11 >= r6) goto L94
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r7 = 1
            if (r1 == r7) goto L8f
            r7 = 11
            if (r1 == r0) goto L8a
            if (r1 == r2) goto L8f
            if (r1 == r3) goto L80
            goto L88
        L80:
            if (r11 == r2) goto L86
            if (r11 == r6) goto L86
            if (r11 != r7) goto L88
        L86:
            int r4 = r4 + 1
        L88:
            r11 = r4
            goto L95
        L8a:
            if (r11 == r6) goto L86
            if (r11 != r7) goto L88
            goto L86
        L8f:
            if (r11 == r2) goto L86
            if (r11 != r6) goto L88
            goto L86
        L94:
            r11 = 0
        L95:
            d9.zn$n3 r0 = new d9.zn$n3
            r6 = 2
            r10 = 0
            r4 = r0
            r7 = r9
            r9 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d9.zn.gv(v5.fh):d9.zn$n3");
    }

    public static m n3(v5.rz rzVar, String str, String str2, @Nullable DrmInitData drmInitData) {
        int i;
        rzVar.ut(1);
        if (((rzVar.ej() & 32) >> 5) == 1) {
            i = 48000;
        } else {
            i = 44100;
        }
        return new m.n3().oz(str).o4("audio/ac4").a8(2).rs(i).vl(drmInitData).k(str2).z6();
    }

    public static int v(byte[] bArr, int i) {
        int i5 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i6 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i6 == 65535) {
            i6 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i5 = 4;
        }
        if (i == 44097) {
            i5 += 2;
        }
        return i6 + i5;
    }

    public static void y(int i, v5.rz rzVar) {
        rzVar.j5(7);
        byte[] v2 = rzVar.v();
        v2[0] = -84;
        v2[1] = 64;
        v2[2] = -1;
        v2[3] = -1;
        v2[4] = (byte) ((i >> 16) & 255);
        v2[5] = (byte) ((i >> 8) & 255);
        v2[6] = (byte) (i & 255);
    }

    public static int zn(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return gv(new v5.fh(bArr)).f7246v;
    }
}
