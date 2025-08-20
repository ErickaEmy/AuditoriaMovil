package us;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import qh.c5;
import qh.f;
import qh.n3;
import qh.wz;
import qh.xc;
import us.zn;
import v5.fh;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class zn extends v {

    /* renamed from: f  reason: collision with root package name */
    public final int f14215f;

    /* renamed from: i9  reason: collision with root package name */
    public final boolean f14217i9;

    /* renamed from: p  reason: collision with root package name */
    public int f14218p;

    /* renamed from: t  reason: collision with root package name */
    public final n3[] f14220t;

    /* renamed from: tl  reason: collision with root package name */
    public n3 f14221tl;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public C0232zn f14222w;
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public List<qh.n3> f14223wz;
    @Nullable

    /* renamed from: xc  reason: collision with root package name */
    public List<qh.n3> f14224xc;

    /* renamed from: fb  reason: collision with root package name */
    public final rz f14216fb = new rz();

    /* renamed from: s  reason: collision with root package name */
    public final fh f14219s = new fh();

    /* renamed from: c5  reason: collision with root package name */
    public int f14214c5 = -1;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: c  reason: collision with root package name */
        public static final int[] f14225c;

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f14226d;

        /* renamed from: d0  reason: collision with root package name */
        public static final int[] f14227d0;

        /* renamed from: f3  reason: collision with root package name */
        public static final int f14228f3;

        /* renamed from: fh  reason: collision with root package name */
        public static final int[] f14229fh;

        /* renamed from: i4  reason: collision with root package name */
        public static final int f14230i4 = s(2, 2, 2, 0);

        /* renamed from: mg  reason: collision with root package name */
        public static final int[] f14231mg;

        /* renamed from: n  reason: collision with root package name */
        public static final int f14232n;

        /* renamed from: rz  reason: collision with root package name */
        public static final boolean[] f14233rz;

        /* renamed from: ta  reason: collision with root package name */
        public static final int[] f14234ta;

        /* renamed from: z6  reason: collision with root package name */
        public static final int[] f14235z6;

        /* renamed from: a  reason: collision with root package name */
        public boolean f14236a;

        /* renamed from: c5  reason: collision with root package name */
        public int f14237c5;

        /* renamed from: co  reason: collision with root package name */
        public int f14238co;

        /* renamed from: f  reason: collision with root package name */
        public boolean f14239f;

        /* renamed from: fb  reason: collision with root package name */
        public int f14240fb;

        /* renamed from: gv  reason: collision with root package name */
        public boolean f14241gv;

        /* renamed from: i9  reason: collision with root package name */
        public int f14242i9;

        /* renamed from: mt  reason: collision with root package name */
        public int f14243mt;

        /* renamed from: p  reason: collision with root package name */
        public int f14245p;

        /* renamed from: r  reason: collision with root package name */
        public int f14246r;

        /* renamed from: s  reason: collision with root package name */
        public int f14247s;

        /* renamed from: t  reason: collision with root package name */
        public int f14248t;

        /* renamed from: tl  reason: collision with root package name */
        public int f14249tl;

        /* renamed from: v  reason: collision with root package name */
        public int f14250v;

        /* renamed from: w  reason: collision with root package name */
        public int f14251w;

        /* renamed from: wz  reason: collision with root package name */
        public int f14252wz;

        /* renamed from: x4  reason: collision with root package name */
        public int f14253x4;

        /* renamed from: xc  reason: collision with root package name */
        public int f14254xc;

        /* renamed from: z  reason: collision with root package name */
        public int f14255z;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f14256zn;
        public final List<SpannableString> y = new ArrayList();

        /* renamed from: n3  reason: collision with root package name */
        public final SpannableStringBuilder f14244n3 = new SpannableStringBuilder();

        static {
            int s2 = s(0, 0, 0, 0);
            f14228f3 = s2;
            int s3 = s(0, 0, 0, 3);
            f14232n = s3;
            f14225c = new int[]{0, 0, 0, 0, 0, 2, 0};
            f14227d0 = new int[]{0, 0, 0, 0, 0, 0, 2};
            f14229fh = new int[]{3, 3, 3, 3, 3, 3, 1};
            f14233rz = new boolean[]{false, false, false, true, true, true, false};
            f14231mg = new int[]{s2, s3, s2, s2, s3, s2, s2};
            f14234ta = new int[]{0, 1, 2, 3, 4, 3, 4};
            f14226d = new int[]{0, 0, 0, 0, 0, 3, 3};
            f14235z6 = new int[]{s2, s2, s2, s2, s2, s3, s3};
        }

        public n3() {
            t();
        }

        public static int fb(int i, int i5, int i6) {
            return s(i, i5, i6, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int s(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                v5.y.zn(r4, r0, r1)
                v5.y.zn(r5, r0, r1)
                v5.y.zn(r6, r0, r1)
                v5.y.zn(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L1b
                if (r7 == r1) goto L1b
                r3 = 2
                if (r7 == r3) goto L20
                r3 = 3
                if (r7 == r3) goto L1e
            L1b:
                r7 = 255(0xff, float:3.57E-43)
                goto L22
            L1e:
                r7 = 0
                goto L22
            L20:
                r7 = 127(0x7f, float:1.78E-43)
            L22:
                if (r4 <= r1) goto L27
                r4 = 255(0xff, float:3.57E-43)
                goto L28
            L27:
                r4 = 0
            L28:
                if (r5 <= r1) goto L2d
                r5 = 255(0xff, float:3.57E-43)
                goto L2e
            L2d:
                r5 = 0
            L2e:
                if (r6 <= r1) goto L32
                r0 = 255(0xff, float:3.57E-43)
            L32:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: us.zn.n3.s(int, int, int, int):int");
        }

        public void a(boolean z2, boolean z3, boolean z4, int i, boolean z5, int i5, int i6, int i8, int i10, int i11, int i12, int i13) {
            this.f14256zn = true;
            this.f14241gv = z2;
            this.f14239f = z3;
            this.f14250v = i;
            this.f14236a = z5;
            this.f14240fb = i5;
            this.f14247s = i6;
            this.f14237c5 = i11;
            int i14 = i8 + 1;
            if (this.f14242i9 != i14) {
                this.f14242i9 = i14;
                while (true) {
                    if ((!z3 || this.y.size() < this.f14242i9) && this.y.size() < 15) {
                        break;
                    }
                    this.y.remove(0);
                }
            }
            if (i12 != 0 && this.f14249tl != i12) {
                this.f14249tl = i12;
                int i15 = i12 - 1;
                p(f14231mg[i15], f14232n, f14233rz[i15], 0, f14227d0[i15], f14229fh[i15], f14225c[i15]);
            }
            if (i13 != 0 && this.f14252wz != i13) {
                this.f14252wz = i13;
                int i16 = i13 - 1;
                tl(0, 1, 1, false, false, f14226d[i16], f14234ta[i16]);
                wz(f14230i4, f14235z6[i16], f14228f3);
            }
        }

        public boolean c5() {
            return this.f14256zn;
        }

        public boolean f() {
            return this.f14241gv;
        }

        public SpannableString gv() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f14244n3);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f14251w != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f14251w, length, 33);
                }
                if (this.f14245p != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f14245p, length, 33);
                }
                if (this.f14243mt != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f14238co), this.f14243mt, length, 33);
                }
                if (this.f14255z != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f14246r), this.f14255z, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public boolean i9() {
            if (c5() && (!this.y.isEmpty() || this.f14244n3.length() != 0)) {
                return false;
            }
            return true;
        }

        public void n3() {
            int length = this.f14244n3.length();
            if (length > 0) {
                this.f14244n3.delete(length - 1, length);
            }
        }

        public void p(int i, int i5, boolean z2, int i6, int i8, int i10, int i11) {
            this.f14254xc = i;
            this.f14248t = i11;
        }

        public void t() {
            v();
            this.f14256zn = false;
            this.f14241gv = false;
            this.f14250v = 4;
            this.f14236a = false;
            this.f14240fb = 0;
            this.f14247s = 0;
            this.f14237c5 = 0;
            this.f14242i9 = 15;
            this.f14239f = true;
            this.f14248t = 0;
            this.f14249tl = 0;
            this.f14252wz = 0;
            int i = f14228f3;
            this.f14254xc = i;
            this.f14238co = f14230i4;
            this.f14246r = i;
        }

        public void tl(int i, int i5, int i6, boolean z2, boolean z3, int i8, int i10) {
            if (this.f14251w != -1) {
                if (!z2) {
                    this.f14244n3.setSpan(new StyleSpan(2), this.f14251w, this.f14244n3.length(), 33);
                    this.f14251w = -1;
                }
            } else if (z2) {
                this.f14251w = this.f14244n3.length();
            }
            if (this.f14245p != -1) {
                if (!z3) {
                    this.f14244n3.setSpan(new UnderlineSpan(), this.f14245p, this.f14244n3.length(), 33);
                    this.f14245p = -1;
                }
            } else if (z3) {
                this.f14245p = this.f14244n3.length();
            }
        }

        public void v() {
            this.y.clear();
            this.f14244n3.clear();
            this.f14251w = -1;
            this.f14245p = -1;
            this.f14243mt = -1;
            this.f14255z = -1;
            this.f14253x4 = 0;
        }

        public void w(boolean z2) {
            this.f14241gv = z2;
        }

        public void wz(int i, int i5, int i6) {
            if (this.f14243mt != -1 && this.f14238co != i) {
                this.f14244n3.setSpan(new ForegroundColorSpan(this.f14238co), this.f14243mt, this.f14244n3.length(), 33);
            }
            if (i != f14230i4) {
                this.f14243mt = this.f14244n3.length();
                this.f14238co = i;
            }
            if (this.f14255z != -1 && this.f14246r != i5) {
                this.f14244n3.setSpan(new BackgroundColorSpan(this.f14246r), this.f14255z, this.f14244n3.length(), 33);
            }
            if (i5 != f14228f3) {
                this.f14255z = this.f14244n3.length();
                this.f14246r = i5;
            }
        }

        public void xc(int i, int i5) {
            if (this.f14253x4 != i) {
                y('\n');
            }
            this.f14253x4 = i;
        }

        public void y(char c2) {
            if (c2 == '\n') {
                this.y.add(gv());
                this.f14244n3.clear();
                if (this.f14251w != -1) {
                    this.f14251w = 0;
                }
                if (this.f14245p != -1) {
                    this.f14245p = 0;
                }
                if (this.f14243mt != -1) {
                    this.f14243mt = 0;
                }
                if (this.f14255z != -1) {
                    this.f14255z = 0;
                }
                while (true) {
                    if ((this.f14239f && this.y.size() >= this.f14242i9) || this.y.size() >= 15) {
                        this.y.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.f14244n3.append(c2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
        @androidx.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public us.zn.y zn() {
            /*
                Method dump skipped, instructions count: 196
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: us.zn.n3.zn():us.zn$y");
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: zn  reason: collision with root package name */
        public static final Comparator<y> f14257zn = new Comparator() { // from class: us.n3
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int zn2;
                zn2 = zn.y.zn((zn.y) obj, (zn.y) obj2);
                return zn2;
            }
        };

        /* renamed from: n3  reason: collision with root package name */
        public final int f14258n3;
        public final qh.n3 y;

        public y(CharSequence charSequence, Layout.Alignment alignment, float f4, int i, int i5, float f6, int i6, float f9, boolean z2, int i8, int i10) {
            n3.C0187n3 wz2 = new n3.C0187n3().xc(charSequence).w(alignment).s(f4, i).c5(i5).f(f6).t(i6).wz(f9);
            if (z2) {
                wz2.co(i8);
            }
            this.y = wz2.y();
            this.f14258n3 = i10;
        }

        public static /* synthetic */ int zn(y yVar, y yVar2) {
            return Integer.compare(yVar2.f14258n3, yVar.f14258n3);
        }
    }

    /* renamed from: us.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0232zn {

        /* renamed from: gv  reason: collision with root package name */
        public int f14259gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f14260n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final byte[] f14261zn;

        public C0232zn(int i, int i5) {
            this.y = i;
            this.f14260n3 = i5;
            this.f14261zn = new byte[(i5 * 2) - 1];
        }
    }

    public zn(int i, @Nullable List<byte[]> list) {
        boolean z2 = true;
        this.f14215f = i == -1 ? 1 : i;
        this.f14217i9 = (list == null || !v5.a.c5(list)) ? false : false;
        this.f14220t = new n3[8];
        for (int i5 = 0; i5 < 8; i5++) {
            this.f14220t[i5] = new n3();
        }
        this.f14221tl = this.f14220t[0];
    }

    private void ta() {
        for (int i = 0; i < 8; i++) {
            this.f14220t[i].t();
        }
    }

    private List<qh.n3> w() {
        y zn2;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.f14220t[i].i9() && this.f14220t[i].f() && (zn2 = this.f14220t[i].zn()) != null) {
                arrayList.add(zn2);
            }
        }
        Collections.sort(arrayList, y.f14257zn);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            arrayList2.add(((y) arrayList.get(i5)).y);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    @Override // us.v
    public void a(wz wzVar) {
        boolean z2;
        ByteBuffer byteBuffer = (ByteBuffer) v5.y.v(wzVar.f56fb);
        this.f14216fb.o(byteBuffer.array(), byteBuffer.limit());
        while (this.f14216fb.y() >= 3) {
            int ej2 = this.f14216fb.ej();
            int i = ej2 & 3;
            boolean z3 = false;
            if ((ej2 & 4) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            byte ej3 = (byte) this.f14216fb.ej();
            byte ej4 = (byte) this.f14216fb.ej();
            if (i == 2 || i == 3) {
                if (z2) {
                    if (i == 3) {
                        xc();
                        int i5 = (ej3 & 192) >> 6;
                        int i6 = this.f14214c5;
                        if (i6 != -1 && i5 != (i6 + 1) % 4) {
                            ta();
                            r.c5("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f14214c5 + " current=" + i5);
                        }
                        this.f14214c5 = i5;
                        int i8 = ej3 & 63;
                        if (i8 == 0) {
                            i8 = 64;
                        }
                        C0232zn c0232zn = new C0232zn(i5, i8);
                        this.f14222w = c0232zn;
                        byte[] bArr = c0232zn.f14261zn;
                        int i10 = c0232zn.f14259gv;
                        c0232zn.f14259gv = i10 + 1;
                        bArr[i10] = ej4;
                    } else {
                        if (i == 2) {
                            z3 = true;
                        }
                        v5.y.y(z3);
                        C0232zn c0232zn2 = this.f14222w;
                        if (c0232zn2 == null) {
                            r.zn("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0232zn2.f14261zn;
                            int i11 = c0232zn2.f14259gv;
                            int i12 = i11 + 1;
                            c0232zn2.f14259gv = i12;
                            bArr2[i11] = ej3;
                            c0232zn2.f14259gv = i11 + 2;
                            bArr2[i12] = ej4;
                        }
                    }
                    C0232zn c0232zn3 = this.f14222w;
                    if (c0232zn3.f14259gv == (c0232zn3.f14260n3 * 2) - 1) {
                        xc();
                    }
                }
            }
        }
    }

    public final void c() {
        this.f14221tl.tl(this.f14219s.s(4), this.f14219s.s(2), this.f14219s.s(2), this.f14219s.fb(), this.f14219s.fb(), this.f14219s.s(3), this.f14219s.s(3));
    }

    public final void co(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.f14219s.mt(8);
            } else if (i <= 23) {
                this.f14219s.mt(16);
            } else if (i <= 31) {
                this.f14219s.mt(24);
            }
        }
    }

    public final void d0() {
        int s2 = n3.s(this.f14219s.s(2), this.f14219s.s(2), this.f14219s.s(2), this.f14219s.s(2));
        int s3 = n3.s(this.f14219s.s(2), this.f14219s.s(2), this.f14219s.s(2), this.f14219s.s(2));
        this.f14219s.mt(2);
        this.f14221tl.wz(s2, s3, n3.fb(this.f14219s.s(2), this.f14219s.s(2), this.f14219s.s(2)));
    }

    @Override // us.v
    public boolean f() {
        if (this.f14223wz != this.f14224xc) {
            return true;
        }
        return false;
    }

    public final void f3(int i) {
        if (i != 32) {
            if (i != 33) {
                if (i != 37) {
                    if (i != 42) {
                        if (i != 44) {
                            if (i != 63) {
                                if (i != 57) {
                                    if (i != 58) {
                                        if (i != 60) {
                                            if (i != 61) {
                                                switch (i) {
                                                    case 48:
                                                        this.f14221tl.y((char) 9608);
                                                        return;
                                                    case 49:
                                                        this.f14221tl.y((char) 8216);
                                                        return;
                                                    case 50:
                                                        this.f14221tl.y((char) 8217);
                                                        return;
                                                    case 51:
                                                        this.f14221tl.y((char) 8220);
                                                        return;
                                                    case 52:
                                                        this.f14221tl.y((char) 8221);
                                                        return;
                                                    case 53:
                                                        this.f14221tl.y((char) 8226);
                                                        return;
                                                    default:
                                                        switch (i) {
                                                            case 118:
                                                                this.f14221tl.y((char) 8539);
                                                                return;
                                                            case 119:
                                                                this.f14221tl.y((char) 8540);
                                                                return;
                                                            case 120:
                                                                this.f14221tl.y((char) 8541);
                                                                return;
                                                            case 121:
                                                                this.f14221tl.y((char) 8542);
                                                                return;
                                                            case 122:
                                                                this.f14221tl.y((char) 9474);
                                                                return;
                                                            case 123:
                                                                this.f14221tl.y((char) 9488);
                                                                return;
                                                            case 124:
                                                                this.f14221tl.y((char) 9492);
                                                                return;
                                                            case 125:
                                                                this.f14221tl.y((char) 9472);
                                                                return;
                                                            case 126:
                                                                this.f14221tl.y((char) 9496);
                                                                return;
                                                            case 127:
                                                                this.f14221tl.y((char) 9484);
                                                                return;
                                                            default:
                                                                r.c5("Cea708Decoder", "Invalid G2 character: " + i);
                                                                return;
                                                        }
                                                }
                                            }
                                            this.f14221tl.y((char) 8480);
                                            return;
                                        }
                                        this.f14221tl.y((char) 339);
                                        return;
                                    }
                                    this.f14221tl.y((char) 353);
                                    return;
                                }
                                this.f14221tl.y((char) 8482);
                                return;
                            }
                            this.f14221tl.y((char) 376);
                            return;
                        }
                        this.f14221tl.y((char) 338);
                        return;
                    }
                    this.f14221tl.y((char) 352);
                    return;
                }
                this.f14221tl.y((char) 8230);
                return;
            }
            this.f14221tl.y((char) 160);
            return;
        }
        this.f14221tl.y(' ');
    }

    @Override // us.v
    @Nullable
    public /* bridge */ /* synthetic */ wz fb() throws f {
        return super.gv();
    }

    public final void fh() {
        this.f14219s.mt(4);
        int s2 = this.f14219s.s(4);
        this.f14219s.mt(2);
        this.f14221tl.xc(s2, this.f14219s.s(6));
    }

    @Override // us.v, a9.gv
    public void flush() {
        super.flush();
        this.f14223wz = null;
        this.f14224xc = null;
        this.f14218p = 0;
        this.f14221tl = this.f14220t[0];
        ta();
        this.f14222w = null;
    }

    public final void i4(int i) {
        this.f14221tl.y((char) (i & 255));
    }

    public final void mg() {
        C0232zn c0232zn = this.f14222w;
        if (c0232zn.f14259gv != (c0232zn.f14260n3 * 2) - 1) {
            r.n3("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f14222w.f14260n3 * 2) - 1) + ", but current index is " + this.f14222w.f14259gv + " (sequence number " + this.f14222w.y + ");");
        }
        fh fhVar = this.f14219s;
        C0232zn c0232zn2 = this.f14222w;
        fhVar.xc(c0232zn2.f14261zn, c0232zn2.f14259gv);
        boolean z2 = false;
        while (true) {
            if (this.f14219s.n3() <= 0) {
                break;
            }
            int s2 = this.f14219s.s(3);
            int s3 = this.f14219s.s(5);
            if (s2 == 7) {
                this.f14219s.mt(2);
                s2 = this.f14219s.s(6);
                if (s2 < 7) {
                    r.c5("Cea708Decoder", "Invalid extended service number: " + s2);
                }
            }
            if (s3 == 0) {
                if (s2 != 0) {
                    r.c5("Cea708Decoder", "serviceNumber is non-zero (" + s2 + ") when blockSize is 0");
                }
            } else if (s2 != this.f14215f) {
                this.f14219s.co(s3);
            } else {
                int v2 = this.f14219s.v() + (s3 * 8);
                while (this.f14219s.v() < v2) {
                    int s4 = this.f14219s.s(8);
                    if (s4 != 16) {
                        if (s4 <= 31) {
                            p(s4);
                        } else {
                            if (s4 <= 127) {
                                x4(s4);
                            } else if (s4 <= 159) {
                                mt(s4);
                            } else if (s4 <= 255) {
                                i4(s4);
                            } else {
                                r.c5("Cea708Decoder", "Invalid base command: " + s4);
                            }
                            z2 = true;
                        }
                    } else {
                        int s5 = this.f14219s.s(8);
                        if (s5 <= 31) {
                            co(s5);
                        } else {
                            if (s5 <= 127) {
                                f3(s5);
                            } else if (s5 <= 159) {
                                z(s5);
                            } else if (s5 <= 255) {
                                n(s5);
                            } else {
                                r.c5("Cea708Decoder", "Invalid extended command: " + s5);
                            }
                            z2 = true;
                        }
                    }
                }
            }
        }
        if (z2) {
            this.f14223wz = w();
        }
    }

    public final void mt(int i) {
        n3 n3Var;
        int i5 = 1;
        switch (i) {
            case NotificationCompat.FLAG_HIGH_PRIORITY /* 128 */:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i6 = i - 128;
                if (this.f14218p != i6) {
                    this.f14218p = i6;
                    this.f14221tl = this.f14220t[i6];
                    return;
                }
                return;
            case 136:
                while (i5 <= 8) {
                    if (this.f14219s.fb()) {
                        this.f14220t[8 - i5].v();
                    }
                    i5++;
                }
                return;
            case 137:
                for (int i8 = 1; i8 <= 8; i8++) {
                    if (this.f14219s.fb()) {
                        this.f14220t[8 - i8].w(true);
                    }
                }
                return;
            case 138:
                while (i5 <= 8) {
                    if (this.f14219s.fb()) {
                        this.f14220t[8 - i5].w(false);
                    }
                    i5++;
                }
                return;
            case 139:
                for (int i10 = 1; i10 <= 8; i10++) {
                    if (this.f14219s.fb()) {
                        this.f14220t[8 - i10].w(!n3Var.f());
                    }
                }
                return;
            case 140:
                while (i5 <= 8) {
                    if (this.f14219s.fb()) {
                        this.f14220t[8 - i5].t();
                    }
                    i5++;
                }
                return;
            case 141:
                this.f14219s.mt(8);
                return;
            case 142:
                return;
            case 143:
                ta();
                return;
            case 144:
                if (!this.f14221tl.c5()) {
                    this.f14219s.mt(16);
                    return;
                } else {
                    c();
                    return;
                }
            case 145:
                if (!this.f14221tl.c5()) {
                    this.f14219s.mt(24);
                    return;
                } else {
                    d0();
                    return;
                }
            case 146:
                if (!this.f14221tl.c5()) {
                    this.f14219s.mt(16);
                    return;
                } else {
                    fh();
                    return;
                }
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                r.c5("Cea708Decoder", "Invalid C1 command: " + i);
                return;
            case 151:
                if (!this.f14221tl.c5()) {
                    this.f14219s.mt(32);
                    return;
                } else {
                    rz();
                    return;
                }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i11 = i - 152;
                r(i11);
                if (this.f14218p != i11) {
                    this.f14218p = i11;
                    this.f14221tl = this.f14220t[i11];
                    return;
                }
                return;
        }
    }

    public final void n(int i) {
        if (i == 160) {
            this.f14221tl.y((char) 13252);
            return;
        }
        r.c5("Cea708Decoder", "Invalid G3 character: " + i);
        this.f14221tl.y('_');
    }

    public final void p(int i) {
        if (i != 0) {
            if (i != 3) {
                if (i != 8) {
                    switch (i) {
                        case 12:
                            ta();
                            return;
                        case 13:
                            this.f14221tl.y('\n');
                            return;
                        case 14:
                            return;
                        default:
                            if (i >= 17 && i <= 23) {
                                r.c5("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                                this.f14219s.mt(8);
                                return;
                            } else if (i >= 24 && i <= 31) {
                                r.c5("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                                this.f14219s.mt(16);
                                return;
                            } else {
                                r.c5("Cea708Decoder", "Invalid C0 command: " + i);
                                return;
                            }
                    }
                }
                this.f14221tl.n3();
                return;
            }
            this.f14223wz = w();
        }
    }

    public final void r(int i) {
        n3 n3Var = this.f14220t[i];
        this.f14219s.mt(2);
        boolean fb2 = this.f14219s.fb();
        boolean fb3 = this.f14219s.fb();
        boolean fb4 = this.f14219s.fb();
        int s2 = this.f14219s.s(3);
        boolean fb5 = this.f14219s.fb();
        int s3 = this.f14219s.s(7);
        int s4 = this.f14219s.s(8);
        int s5 = this.f14219s.s(4);
        int s7 = this.f14219s.s(4);
        this.f14219s.mt(2);
        int s9 = this.f14219s.s(6);
        this.f14219s.mt(2);
        n3Var.a(fb2, fb3, fb4, s2, fb5, s3, s4, s7, s9, s5, this.f14219s.s(3), this.f14219s.s(3));
    }

    @Override // us.v, a9.gv
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public final void rz() {
        int s2 = n3.s(this.f14219s.s(2), this.f14219s.s(2), this.f14219s.s(2), this.f14219s.s(2));
        int s3 = this.f14219s.s(2);
        int fb2 = n3.fb(this.f14219s.s(2), this.f14219s.s(2), this.f14219s.s(2));
        if (this.f14219s.fb()) {
            s3 |= 4;
        }
        boolean fb3 = this.f14219s.fb();
        int s4 = this.f14219s.s(2);
        int s5 = this.f14219s.s(2);
        int s7 = this.f14219s.s(2);
        this.f14219s.mt(8);
        this.f14221tl.p(s2, fb2, fb3, s3, s4, s5, s7);
    }

    @Override // us.v
    @Nullable
    public /* bridge */ /* synthetic */ xc s() throws f {
        return super.n3();
    }

    @Override // us.v
    public /* bridge */ /* synthetic */ void t(wz wzVar) throws f {
        super.zn(wzVar);
    }

    @Override // us.v
    public c5 v() {
        List<qh.n3> list = this.f14223wz;
        this.f14224xc = list;
        return new a((List) v5.y.v(list));
    }

    public final void x4(int i) {
        if (i == 127) {
            this.f14221tl.y((char) 9835);
        } else {
            this.f14221tl.y((char) (i & 255));
        }
    }

    public final void xc() {
        if (this.f14222w == null) {
            return;
        }
        mg();
        this.f14222w = null;
    }

    @Override // us.v, qh.i9
    public /* bridge */ /* synthetic */ void y(long j2) {
        super.y(j2);
    }

    public final void z(int i) {
        if (i <= 135) {
            this.f14219s.mt(32);
        } else if (i <= 143) {
            this.f14219s.mt(40);
        } else if (i <= 159) {
            this.f14219s.mt(2);
            this.f14219s.mt(this.f14219s.s(6) * 8);
        }
    }
}
