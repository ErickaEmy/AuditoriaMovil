package c3;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;
import qh.c5;
import qh.f;
import qh.n3;
import qh.s;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class y extends s {
    @Nullable

    /* renamed from: mt  reason: collision with root package name */
    public Inflater f3983mt;

    /* renamed from: p  reason: collision with root package name */
    public final C0041y f3984p;

    /* renamed from: w  reason: collision with root package name */
    public final rz f3985w;

    /* renamed from: xc  reason: collision with root package name */
    public final rz f3986xc;

    /* renamed from: c3.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0041y {

        /* renamed from: a  reason: collision with root package name */
        public int f3987a;

        /* renamed from: c5  reason: collision with root package name */
        public int f3988c5;

        /* renamed from: fb  reason: collision with root package name */
        public int f3989fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f3990gv;

        /* renamed from: s  reason: collision with root package name */
        public int f3992s;

        /* renamed from: v  reason: collision with root package name */
        public int f3993v;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f3994zn;
        public final rz y = new rz();

        /* renamed from: n3  reason: collision with root package name */
        public final int[] f3991n3 = new int[256];

        public final void a(rz rzVar, int i) {
            if (i < 19) {
                return;
            }
            this.f3990gv = rzVar.yt();
            this.f3993v = rzVar.yt();
            rzVar.ut(11);
            this.f3987a = rzVar.yt();
            this.f3989fb = rzVar.yt();
        }

        public final void fb(rz rzVar, int i) {
            if (i % 5 != 2) {
                return;
            }
            rzVar.ut(2);
            Arrays.fill(this.f3991n3, 0);
            int i5 = i / 5;
            for (int i6 = 0; i6 < i5; i6++) {
                int ej2 = rzVar.ej();
                int ej3 = rzVar.ej();
                int ej4 = rzVar.ej();
                int ej5 = rzVar.ej();
                double d2 = ej3;
                double d3 = ej4 - 128;
                double d4 = ej5 - 128;
                this.f3991n3[ej2] = (j5.p((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255) << 8) | (rzVar.ej() << 24) | (j5.p((int) ((1.402d * d3) + d2), 0, 255) << 16) | j5.p((int) (d2 + (d4 * 1.772d)), 0, 255);
            }
            this.f3994zn = true;
        }

        @Nullable
        public qh.n3 gv() {
            int i;
            int ej2;
            int i5;
            if (this.f3990gv != 0 && this.f3993v != 0 && this.f3992s != 0 && this.f3988c5 != 0 && this.y.fb() != 0 && this.y.a() == this.y.fb() && this.f3994zn) {
                this.y.oz(0);
                int i6 = this.f3992s * this.f3988c5;
                int[] iArr = new int[i6];
                int i8 = 0;
                while (i8 < i6) {
                    int ej3 = this.y.ej();
                    if (ej3 != 0) {
                        i = i8 + 1;
                        iArr[i8] = this.f3991n3[ej3];
                    } else {
                        int ej4 = this.y.ej();
                        if (ej4 != 0) {
                            if ((ej4 & 64) == 0) {
                                ej2 = ej4 & 63;
                            } else {
                                ej2 = ((ej4 & 63) << 8) | this.y.ej();
                            }
                            if ((ej4 & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                                i5 = 0;
                            } else {
                                i5 = this.f3991n3[this.y.ej()];
                            }
                            i = ej2 + i8;
                            Arrays.fill(iArr, i8, i, i5);
                        }
                    }
                    i8 = i;
                }
                return new n3.C0187n3().a(Bitmap.createBitmap(iArr, this.f3992s, this.f3988c5, Bitmap.Config.ARGB_8888)).f(this.f3987a / this.f3990gv).t(0).s(this.f3989fb / this.f3993v, 0).c5(0).wz(this.f3992s / this.f3990gv).fb(this.f3988c5 / this.f3993v).y();
            }
            return null;
        }

        public void s() {
            this.f3990gv = 0;
            this.f3993v = 0;
            this.f3987a = 0;
            this.f3989fb = 0;
            this.f3992s = 0;
            this.f3988c5 = 0;
            this.y.j5(0);
            this.f3994zn = false;
        }

        public final void v(rz rzVar, int i) {
            boolean z2;
            int x2;
            if (i < 4) {
                return;
            }
            rzVar.ut(3);
            if ((rzVar.ej() & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i5 = i - 4;
            if (z2) {
                if (i5 < 7 || (x2 = rzVar.x()) < 4) {
                    return;
                }
                this.f3992s = rzVar.yt();
                this.f3988c5 = rzVar.yt();
                this.y.j5(x2 - 4);
                i5 = i - 11;
            }
            int a2 = this.y.a();
            int fb2 = this.y.fb();
            if (a2 < fb2 && i5 > 0) {
                int min = Math.min(i5, fb2 - a2);
                rzVar.t(this.y.v(), a2, min);
                this.y.oz(a2 + min);
            }
        }
    }

    public y() {
        super("PgsDecoder");
        this.f3986xc = new rz();
        this.f3985w = new rz();
        this.f3984p = new C0041y();
    }

    @Nullable
    public static qh.n3 rz(rz rzVar, C0041y c0041y) {
        int fb2 = rzVar.fb();
        int ej2 = rzVar.ej();
        int yt2 = rzVar.yt();
        int a2 = rzVar.a() + yt2;
        qh.n3 n3Var = null;
        if (a2 > fb2) {
            rzVar.oz(fb2);
            return null;
        }
        if (ej2 != 128) {
            switch (ej2) {
                case 20:
                    c0041y.fb(rzVar, yt2);
                    break;
                case 21:
                    c0041y.v(rzVar, yt2);
                    break;
                case 22:
                    c0041y.a(rzVar, yt2);
                    break;
            }
        } else {
            n3Var = c0041y.gv();
            c0041y.s();
        }
        rzVar.oz(a2);
        return n3Var;
    }

    @Override // qh.s
    public c5 c(byte[] bArr, int i, boolean z2) throws f {
        this.f3986xc.o(bArr, i);
        fh(this.f3986xc);
        this.f3984p.s();
        ArrayList arrayList = new ArrayList();
        while (this.f3986xc.y() >= 3) {
            qh.n3 rz2 = rz(this.f3986xc, this.f3984p);
            if (rz2 != null) {
                arrayList.add(rz2);
            }
        }
        return new n3(Collections.unmodifiableList(arrayList));
    }

    public final void fh(rz rzVar) {
        if (rzVar.y() > 0 && rzVar.i9() == 120) {
            if (this.f3983mt == null) {
                this.f3983mt = new Inflater();
            }
            if (j5.rb(rzVar, this.f3985w, this.f3983mt)) {
                rzVar.o(this.f3985w.v(), this.f3985w.fb());
            }
        }
    }
}
