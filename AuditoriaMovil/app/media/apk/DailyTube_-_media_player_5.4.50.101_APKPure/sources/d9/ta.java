package d9;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.uv.v7.R;
import java.nio.ByteBuffer;
import java.util.Arrays;
import m1.m;
/* loaded from: classes.dex */
public final class ta {
    public static final int[] y = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: n3  reason: collision with root package name */
    public static final int[] f7182n3 = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: zn  reason: collision with root package name */
    public static final int[] f7183zn = {64, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, NotificationCompat.FLAG_HIGH_PRIORITY, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static int a(byte[] bArr) {
        int i;
        byte b2;
        int i5;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 != -1) {
                if (b4 != 31) {
                    i = (bArr[4] & 1) << 6;
                    b2 = bArr[5];
                } else {
                    i = (bArr[5] & 7) << 4;
                    b3 = bArr[6];
                }
            } else {
                i = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            }
            i5 = b3 & 60;
            return (((i5 >> 2) | i) + 1) * 32;
        }
        i = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i5 = b2 & 252;
        return (((i5 >> 2) | i) + 1) * 32;
    }

    public static m fb(byte[] bArr, @Nullable String str, @Nullable String str2, @Nullable DrmInitData drmInitData) {
        int i;
        int i5;
        v5.fh n32 = n3(bArr);
        n32.mt(60);
        int i6 = y[n32.s(6)];
        int i8 = f7182n3[n32.s(4)];
        int s2 = n32.s(5);
        int[] iArr = f7183zn;
        if (s2 >= iArr.length) {
            i = -1;
        } else {
            i = (iArr[s2] * 1000) / 2;
        }
        n32.mt(10);
        if (n32.s(2) > 0) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        return new m.n3().oz(str).o4("audio/vnd.dts").ud(i).a8(i6 + i5).rs(i8).vl(drmInitData).k(str2).z6();
    }

    public static boolean gv(int i) {
        if (i != 2147385345 && i != -25230976 && i != 536864768 && i != -14745368) {
            return false;
        }
        return true;
    }

    public static v5.fh n3(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new v5.fh(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (zn(copyOf)) {
            for (int i = 0; i < copyOf.length - 1; i += 2) {
                byte b2 = copyOf[i];
                int i5 = i + 1;
                copyOf[i] = copyOf[i5];
                copyOf[i5] = b2;
            }
        }
        v5.fh fhVar = new v5.fh(copyOf);
        if (copyOf[0] == 31) {
            v5.fh fhVar2 = new v5.fh(copyOf);
            while (fhVar2.n3() >= 16) {
                fhVar2.mt(2);
                fhVar.a(fhVar2.s(14), 14);
            }
        }
        fhVar.wz(copyOf);
        return fhVar;
    }

    public static int v(ByteBuffer byteBuffer) {
        int i;
        byte b2;
        int i5;
        byte b3;
        int position = byteBuffer.position();
        byte b4 = byteBuffer.get(position);
        if (b4 != -2) {
            if (b4 != -1) {
                if (b4 != 31) {
                    i = (byteBuffer.get(position + 4) & 1) << 6;
                    b2 = byteBuffer.get(position + 5);
                } else {
                    i = (byteBuffer.get(position + 5) & 7) << 4;
                    b3 = byteBuffer.get(position + 6);
                }
            } else {
                i = (byteBuffer.get(position + 4) & 7) << 4;
                b3 = byteBuffer.get(position + 7);
            }
            i5 = b3 & 60;
            return (((i5 >> 2) | i) + 1) * 32;
        }
        i = (byteBuffer.get(position + 5) & 1) << 6;
        b2 = byteBuffer.get(position + 4);
        i5 = b2 & 252;
        return (((i5 >> 2) | i) + 1) * 32;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int y(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4f
            r2 = -1
            if (r1 == r2) goto L3e
            r2 = 31
            if (r1 == r2) goto L26
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L20:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L5e
        L26:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
        L36:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = 1
            goto L5e
        L3e:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
            goto L36
        L4f:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L20
        L5e:
            if (r0 == 0) goto L64
            int r7 = r7 * 16
            int r7 = r7 / 14
        L64:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d9.ta.y(byte[]):int");
    }

    public static boolean zn(byte[] bArr) {
        byte b2 = bArr[0];
        if (b2 != -2 && b2 != -1) {
            return false;
        }
        return true;
    }
}
