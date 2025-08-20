package d9;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.uv.v7.R;
import java.nio.ByteBuffer;
import m1.m;
import v5.j5;
/* loaded from: classes.dex */
public final class n3 {
    public static final int[] y = {1, 2, 3, 6};

    /* renamed from: n3  reason: collision with root package name */
    public static final int[] f7088n3 = {48000, 44100, 32000};

    /* renamed from: zn  reason: collision with root package name */
    public static final int[] f7090zn = {24000, 22050, 16000};

    /* renamed from: gv  reason: collision with root package name */
    public static final int[] f7087gv = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: v  reason: collision with root package name */
    public static final int[] f7089v = {32, 40, 48, 56, 64, 80, 96, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, NotificationCompat.FLAG_HIGH_PRIORITY, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f7086a = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: d9.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0080n3 {

        /* renamed from: a  reason: collision with root package name */
        public final int f7091a;

        /* renamed from: fb  reason: collision with root package name */
        public final int f7092fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f7093gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f7094n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f7095v;
        @Nullable
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f7096zn;

        public C0080n3(@Nullable String str, int i, int i5, int i6, int i8, int i10, int i11) {
            this.y = str;
            this.f7094n3 = i;
            this.f7093gv = i5;
            this.f7096zn = i6;
            this.f7095v = i8;
            this.f7091a = i10;
            this.f7092fb = i11;
        }
    }

    public static C0080n3 a(v5.fh fhVar) {
        boolean z2;
        String str;
        int i;
        String str2;
        int i5;
        int i6;
        int i8;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        String str3;
        int i17;
        int i18;
        int v2 = fhVar.v();
        fhVar.mt(40);
        if (fhVar.s(5) > 10) {
            z2 = true;
        } else {
            z2 = false;
        }
        fhVar.w(v2);
        int i19 = -1;
        if (z2) {
            fhVar.mt(16);
            int s2 = fhVar.s(2);
            if (s2 != 0) {
                if (s2 != 1) {
                    if (s2 == 2) {
                        i19 = 2;
                    }
                } else {
                    i19 = 1;
                }
            } else {
                i19 = 0;
            }
            fhVar.mt(3);
            int s3 = (fhVar.s(11) + 1) * 2;
            int s4 = fhVar.s(2);
            if (s4 == 3) {
                i14 = f7090zn[fhVar.s(2)];
                i13 = 3;
                i15 = 6;
            } else {
                int s5 = fhVar.s(2);
                int i20 = y[s5];
                i13 = s5;
                i14 = f7088n3[s4];
                i15 = i20;
            }
            int i21 = i15 * 256;
            int y2 = y(s3, i14, i15);
            int s7 = fhVar.s(3);
            boolean fb2 = fhVar.fb();
            int i22 = f7087gv[s7] + (fb2 ? 1 : 0);
            fhVar.mt(10);
            if (fhVar.fb()) {
                fhVar.mt(8);
            }
            if (s7 == 0) {
                fhVar.mt(5);
                if (fhVar.fb()) {
                    fhVar.mt(8);
                }
            }
            if (i19 == 1 && fhVar.fb()) {
                fhVar.mt(16);
            }
            if (fhVar.fb()) {
                if (s7 > 2) {
                    fhVar.mt(2);
                }
                if ((s7 & 1) != 0 && s7 > 2) {
                    i17 = 6;
                    fhVar.mt(6);
                } else {
                    i17 = 6;
                }
                if ((s7 & 4) != 0) {
                    fhVar.mt(i17);
                }
                if (fb2 && fhVar.fb()) {
                    fhVar.mt(5);
                }
                if (i19 == 0) {
                    if (fhVar.fb()) {
                        i18 = 6;
                        fhVar.mt(6);
                    } else {
                        i18 = 6;
                    }
                    if (s7 == 0 && fhVar.fb()) {
                        fhVar.mt(i18);
                    }
                    if (fhVar.fb()) {
                        fhVar.mt(i18);
                    }
                    int s9 = fhVar.s(2);
                    if (s9 == 1) {
                        fhVar.mt(5);
                    } else if (s9 == 2) {
                        fhVar.mt(12);
                    } else if (s9 == 3) {
                        int s10 = fhVar.s(5);
                        if (fhVar.fb()) {
                            fhVar.mt(5);
                            if (fhVar.fb()) {
                                fhVar.mt(4);
                            }
                            if (fhVar.fb()) {
                                fhVar.mt(4);
                            }
                            if (fhVar.fb()) {
                                fhVar.mt(4);
                            }
                            if (fhVar.fb()) {
                                fhVar.mt(4);
                            }
                            if (fhVar.fb()) {
                                fhVar.mt(4);
                            }
                            if (fhVar.fb()) {
                                fhVar.mt(4);
                            }
                            if (fhVar.fb()) {
                                fhVar.mt(4);
                            }
                            if (fhVar.fb()) {
                                if (fhVar.fb()) {
                                    fhVar.mt(4);
                                }
                                if (fhVar.fb()) {
                                    fhVar.mt(4);
                                }
                            }
                        }
                        if (fhVar.fb()) {
                            fhVar.mt(5);
                            if (fhVar.fb()) {
                                fhVar.mt(7);
                                if (fhVar.fb()) {
                                    fhVar.mt(8);
                                }
                            }
                        }
                        fhVar.mt((s10 + 2) * 8);
                        fhVar.zn();
                    }
                    if (s7 < 2) {
                        if (fhVar.fb()) {
                            fhVar.mt(14);
                        }
                        if (s7 == 0 && fhVar.fb()) {
                            fhVar.mt(14);
                        }
                    }
                    if (fhVar.fb()) {
                        if (i13 == 0) {
                            fhVar.mt(5);
                        } else {
                            for (int i23 = 0; i23 < i15; i23++) {
                                if (fhVar.fb()) {
                                    fhVar.mt(5);
                                }
                            }
                        }
                    }
                }
            }
            if (fhVar.fb()) {
                fhVar.mt(5);
                if (s7 == 2) {
                    fhVar.mt(4);
                }
                if (s7 >= 6) {
                    fhVar.mt(2);
                }
                if (fhVar.fb()) {
                    fhVar.mt(8);
                }
                if (s7 == 0 && fhVar.fb()) {
                    fhVar.mt(8);
                }
                if (s4 < 3) {
                    fhVar.p();
                }
            }
            if (i19 == 0 && i13 != 3) {
                fhVar.p();
            }
            if (i19 == 2 && (i13 == 3 || fhVar.fb())) {
                i16 = 6;
                fhVar.mt(6);
            } else {
                i16 = 6;
            }
            if (fhVar.fb() && fhVar.s(i16) == 1 && fhVar.s(8) == 1) {
                str3 = "audio/eac3-joc";
            } else {
                str3 = "audio/eac3";
            }
            str2 = str3;
            i11 = i19;
            i12 = i21;
            i6 = s3;
            i8 = i14;
            i5 = y2;
            i10 = i22;
        } else {
            fhVar.mt(32);
            int s11 = fhVar.s(2);
            if (s11 == 3) {
                str = null;
            } else {
                str = "audio/ac3";
            }
            int s12 = fhVar.s(6);
            int i24 = f7089v[s12 / 2] * 1000;
            int zn2 = zn(s11, s12);
            fhVar.mt(8);
            int s13 = fhVar.s(3);
            if ((s13 & 1) != 0 && s13 != 1) {
                fhVar.mt(2);
            }
            if ((s13 & 4) != 0) {
                fhVar.mt(2);
            }
            if (s13 == 2) {
                fhVar.mt(2);
            }
            int[] iArr = f7088n3;
            if (s11 < iArr.length) {
                i = iArr[s11];
            } else {
                i = -1;
            }
            str2 = str;
            i5 = i24;
            i6 = zn2;
            i8 = i;
            i10 = f7087gv[s13] + (fhVar.fb() ? 1 : 0);
            i11 = -1;
            i12 = 1536;
        }
        return new C0080n3(str2, i11, i10, i8, i6, i12, i5);
    }

    public static int c5(ByteBuffer byteBuffer, int i) {
        boolean z2;
        int i5;
        if ((byteBuffer.get(byteBuffer.position() + i + 7) & 255) == 187) {
            z2 = true;
        } else {
            z2 = false;
        }
        int position = byteBuffer.position() + i;
        if (z2) {
            i5 = 9;
        } else {
            i5 = 8;
        }
        return 40 << ((byteBuffer.get(position + i5) >> 4) & 7);
    }

    public static int fb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b2 = bArr[4];
        return zn((b2 & 192) >> 6, b2 & 63);
    }

    public static m gv(v5.rz rzVar, String str, String str2, @Nullable DrmInitData drmInitData) {
        v5.fh fhVar = new v5.fh();
        fhVar.tl(rzVar);
        int i = f7088n3[fhVar.s(2)];
        fhVar.mt(8);
        int i5 = f7087gv[fhVar.s(3)];
        if (fhVar.s(1) != 0) {
            i5++;
        }
        int i6 = f7089v[fhVar.s(5)] * 1000;
        fhVar.zn();
        rzVar.oz(fhVar.gv());
        return new m.n3().oz(str).o4("audio/ac3").a8(i5).rs(i).vl(drmInitData).k(str2).ud(i6).u(i6).z6();
    }

    public static int i9(byte[] bArr) {
        char c2;
        boolean z2 = false;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b2 = bArr[7];
            if ((b2 & 254) == 186) {
                if ((b2 & 255) == 187) {
                    z2 = true;
                }
                if (z2) {
                    c2 = '\t';
                } else {
                    c2 = '\b';
                }
                return 40 << ((bArr[c2] >> 4) & 7);
            }
        }
        return 0;
    }

    public static int n3(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i = position; i <= limit; i++) {
            if ((j5.ud(byteBuffer, i + 4) & (-2)) == -126718022) {
                return i - position;
            }
        }
        return -1;
    }

    public static m s(v5.rz rzVar, String str, String str2, @Nullable DrmInitData drmInitData) {
        String str3;
        v5.fh fhVar = new v5.fh();
        fhVar.tl(rzVar);
        int s2 = fhVar.s(13) * 1000;
        fhVar.mt(3);
        int i = f7088n3[fhVar.s(2)];
        fhVar.mt(10);
        int i5 = f7087gv[fhVar.s(3)];
        if (fhVar.s(1) != 0) {
            i5++;
        }
        fhVar.mt(3);
        int s3 = fhVar.s(4);
        fhVar.mt(1);
        if (s3 > 0) {
            fhVar.co(6);
            if (fhVar.s(1) != 0) {
                i5 += 2;
            }
            fhVar.mt(1);
        }
        if (fhVar.n3() > 7) {
            fhVar.mt(7);
            if (fhVar.s(1) != 0) {
                str3 = "audio/eac3-joc";
                fhVar.zn();
                rzVar.oz(fhVar.gv());
                return new m.n3().oz(str).o4(str3).a8(i5).rs(i).vl(drmInitData).k(str2).u(s2).z6();
            }
        }
        str3 = "audio/eac3";
        fhVar.zn();
        rzVar.oz(fhVar.gv());
        return new m.n3().oz(str).o4(str3).a8(i5).rs(i).vl(drmInitData).k(str2).u(s2).z6();
    }

    public static int v(ByteBuffer byteBuffer) {
        int i = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
                i = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
            }
            return y[i] * 256;
        }
        return 1536;
    }

    public static int y(int i, int i5, int i6) {
        return (i * i5) / (i6 * 32);
    }

    public static int zn(int i, int i5) {
        int i6 = i5 / 2;
        if (i >= 0) {
            int[] iArr = f7088n3;
            if (i < iArr.length && i5 >= 0) {
                int[] iArr2 = f7086a;
                if (i6 < iArr2.length) {
                    int i8 = iArr[i];
                    if (i8 == 44100) {
                        return (iArr2[i6] + (i5 % 2)) * 2;
                    }
                    int i10 = f7089v[i6];
                    if (i8 == 32000) {
                        return i10 * 6;
                    }
                    return i10 * 4;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }
}
