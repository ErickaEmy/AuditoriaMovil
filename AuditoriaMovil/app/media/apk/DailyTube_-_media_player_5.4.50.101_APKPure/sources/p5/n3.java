package p5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qh.n3;
import v5.fh;
import v5.j5;
import v5.r;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: a  reason: collision with root package name */
    public final s f12389a;

    /* renamed from: fb  reason: collision with root package name */
    public Bitmap f12390fb;

    /* renamed from: gv  reason: collision with root package name */
    public final C0179n3 f12391gv;

    /* renamed from: n3  reason: collision with root package name */
    public final Paint f12392n3;

    /* renamed from: v  reason: collision with root package name */
    public final y f12393v;
    public final Paint y;

    /* renamed from: zn  reason: collision with root package name */
    public final Canvas f12394zn;

    /* renamed from: s  reason: collision with root package name */
    public static final byte[] f12388s = {0, 7, 8, 15};

    /* renamed from: c5  reason: collision with root package name */
    public static final byte[] f12386c5 = {0, 119, -120, -1};

    /* renamed from: i9  reason: collision with root package name */
    public static final byte[] f12387i9 = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f12395a;

        /* renamed from: c5  reason: collision with root package name */
        public final int f12396c5;

        /* renamed from: f  reason: collision with root package name */
        public final SparseArray<fb> f12397f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f12398fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f12399gv;

        /* renamed from: i9  reason: collision with root package name */
        public final int f12400i9;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f12401n3;

        /* renamed from: s  reason: collision with root package name */
        public final int f12402s;

        /* renamed from: v  reason: collision with root package name */
        public final int f12403v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f12404zn;

        public a(int i, boolean z2, int i5, int i6, int i8, int i10, int i11, int i12, int i13, int i14, SparseArray<fb> sparseArray) {
            this.y = i;
            this.f12401n3 = z2;
            this.f12404zn = i5;
            this.f12399gv = i6;
            this.f12403v = i8;
            this.f12395a = i10;
            this.f12398fb = i11;
            this.f12402s = i12;
            this.f12396c5 = i13;
            this.f12400i9 = i14;
            this.f12397f = sparseArray;
        }

        public void y(a aVar) {
            SparseArray<fb> sparseArray = aVar.f12397f;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.f12397f.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class fb {

        /* renamed from: a  reason: collision with root package name */
        public final int f12405a;

        /* renamed from: gv  reason: collision with root package name */
        public final int f12406gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f12407n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f12408v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f12409zn;

        public fb(int i, int i5, int i6, int i8, int i10, int i11) {
            this.y = i;
            this.f12407n3 = i5;
            this.f12409zn = i6;
            this.f12406gv = i8;
            this.f12408v = i10;
            this.f12405a = i11;
        }
    }

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: gv  reason: collision with root package name */
        public final SparseArray<v> f12410gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f12411n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f12412zn;

        public gv(int i, int i5, int i6, SparseArray<v> sparseArray) {
            this.y = i;
            this.f12411n3 = i5;
            this.f12412zn = i6;
            this.f12410gv = sparseArray;
        }
    }

    /* renamed from: p5.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0179n3 {

        /* renamed from: a  reason: collision with root package name */
        public final int f12413a;

        /* renamed from: gv  reason: collision with root package name */
        public final int f12414gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f12415n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f12416v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f12417zn;

        public C0179n3(int i, int i5, int i6, int i8, int i10, int i11) {
            this.y = i;
            this.f12415n3 = i5;
            this.f12417zn = i6;
            this.f12414gv = i8;
            this.f12416v = i10;
            this.f12413a = i11;
        }
    }

    /* loaded from: classes.dex */
    public static final class s {
        @Nullable

        /* renamed from: c5  reason: collision with root package name */
        public gv f12419c5;

        /* renamed from: n3  reason: collision with root package name */
        public final int f12422n3;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public C0179n3 f12423s;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final SparseArray<a> f12425zn = new SparseArray<>();

        /* renamed from: gv  reason: collision with root package name */
        public final SparseArray<y> f12421gv = new SparseArray<>();

        /* renamed from: v  reason: collision with root package name */
        public final SparseArray<zn> f12424v = new SparseArray<>();

        /* renamed from: a  reason: collision with root package name */
        public final SparseArray<y> f12418a = new SparseArray<>();

        /* renamed from: fb  reason: collision with root package name */
        public final SparseArray<zn> f12420fb = new SparseArray<>();

        public s(int i, int i5) {
            this.y = i;
            this.f12422n3 = i5;
        }

        public void y() {
            this.f12425zn.clear();
            this.f12421gv.clear();
            this.f12424v.clear();
            this.f12418a.clear();
            this.f12420fb.clear();
            this.f12423s = null;
            this.f12419c5 = null;
        }
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: n3  reason: collision with root package name */
        public final int f12426n3;
        public final int y;

        public v(int i, int i5) {
            this.y = i;
            this.f12426n3 = i5;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public final int[] f12427gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int[] f12428n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int[] f12429zn;

        public y(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.y = i;
            this.f12428n3 = iArr;
            this.f12429zn = iArr2;
            this.f12427gv = iArr3;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: gv  reason: collision with root package name */
        public final byte[] f12430gv;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f12431n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final byte[] f12432zn;

        public zn(int i, boolean z2, byte[] bArr, byte[] bArr2) {
            this.y = i;
            this.f12431n3 = z2;
            this.f12432zn = bArr;
            this.f12430gv = bArr2;
        }
    }

    public n3(int i, int i5) {
        Paint paint = new Paint();
        this.y = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f12392n3 = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f12394zn = new Canvas();
        this.f12391gv = new C0179n3(719, 575, 0, 719, 0, 575);
        this.f12393v = new y(0, zn(), gv(), v());
        this.f12389a = new s(i, i5);
    }

    public static int a(int i, int i5, int i6, int i8) {
        return (i << 24) | (i5 << 16) | (i6 << 8) | i8;
    }

    public static int c5(fh fhVar, int[] iArr, @Nullable byte[] bArr, int i, int i5, @Nullable Paint paint, Canvas canvas) {
        boolean z2;
        int s2;
        int i6 = i;
        boolean z3 = false;
        while (true) {
            byte s3 = fhVar.s(8);
            if (s3 != 0) {
                z2 = z3;
                s2 = 1;
            } else if (!fhVar.fb()) {
                int s4 = fhVar.s(7);
                if (s4 != 0) {
                    z2 = z3;
                    s2 = s4;
                    s3 = 0;
                } else {
                    s3 = 0;
                    z2 = true;
                    s2 = 0;
                }
            } else {
                z2 = z3;
                s2 = fhVar.s(7);
                s3 = fhVar.s(8);
            }
            if (s2 != 0 && paint != null) {
                if (bArr != null) {
                    s3 = bArr[s3];
                }
                paint.setColor(iArr[s3]);
                canvas.drawRect(i6, i5, i6 + s2, i5 + 1, paint);
            }
            i6 += s2;
            if (z2) {
                return i6;
            }
            z3 = z2;
        }
    }

    public static void f(zn znVar, y yVar, int i, int i5, int i6, @Nullable Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = yVar.f12427gv;
        } else if (i == 2) {
            iArr = yVar.f12429zn;
        } else {
            iArr = yVar.f12428n3;
        }
        int[] iArr2 = iArr;
        i9(znVar.f12432zn, iArr2, i, i5, i6, paint, canvas);
        i9(znVar.f12430gv, iArr2, i, i5, i6 + 1, paint, canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083 A[LOOP:0: B:3:0x0009->B:33:0x0083, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int fb(v5.fh r13, int[] r14, @androidx.annotation.Nullable byte[] r15, int r16, int r17, @androidx.annotation.Nullable android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L9:
            r3 = 2
            int r4 = r13.s(r3)
            r5 = 1
            if (r4 == 0) goto L14
            r11 = r2
        L12:
            r12 = 1
            goto L61
        L14:
            boolean r4 = r13.fb()
            r6 = 3
            if (r4 == 0) goto L28
            int r4 = r13.s(r6)
            int r4 = r4 + r6
            int r3 = r13.s(r3)
        L24:
            r11 = r2
            r12 = r4
            r4 = r3
            goto L61
        L28:
            boolean r4 = r13.fb()
            if (r4 == 0) goto L31
            r11 = r2
            r4 = 0
            goto L12
        L31:
            int r4 = r13.s(r3)
            if (r4 == 0) goto L5e
            if (r4 == r5) goto L5a
            if (r4 == r3) goto L4e
            if (r4 == r6) goto L41
            r11 = r2
            r4 = 0
        L3f:
            r12 = 0
            goto L61
        L41:
            r4 = 8
            int r4 = r13.s(r4)
            int r4 = r4 + 29
            int r3 = r13.s(r3)
            goto L24
        L4e:
            r4 = 4
            int r4 = r13.s(r4)
            int r4 = r4 + 12
            int r3 = r13.s(r3)
            goto L24
        L5a:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L61
        L5e:
            r4 = 0
            r11 = 1
            goto L3f
        L61:
            if (r12 == 0) goto L7f
            if (r8 == 0) goto L7f
            if (r15 == 0) goto L69
            r4 = r15[r4]
        L69:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L7f:
            int r10 = r10 + r12
            if (r11 == 0) goto L83
            return r10
        L83:
            r2 = r11
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.n3.fb(v5.fh, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    public static int[] gv() {
        int i;
        int i5;
        int i6;
        int i8;
        int i10;
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i11 = 1; i11 < 16; i11++) {
            if (i11 < 8) {
                if ((i11 & 1) != 0) {
                    i6 = 255;
                } else {
                    i6 = 0;
                }
                if ((i11 & 2) != 0) {
                    i8 = 255;
                } else {
                    i8 = 0;
                }
                if ((i11 & 4) != 0) {
                    i10 = 255;
                } else {
                    i10 = 0;
                }
                iArr[i11] = a(255, i6, i8, i10);
            } else {
                int i12 = 127;
                if ((i11 & 1) != 0) {
                    i = 127;
                } else {
                    i = 0;
                }
                if ((i11 & 2) != 0) {
                    i5 = 127;
                } else {
                    i5 = 0;
                }
                if ((i11 & 4) == 0) {
                    i12 = 0;
                }
                iArr[i11] = a(255, i, i5, i12);
            }
        }
        return iArr;
    }

    public static void i9(byte[] bArr, int[] iArr, int i, int i5, int i6, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        fh fhVar = new fh(bArr);
        int i8 = i5;
        int i10 = i6;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        while (fhVar.n3() != 0) {
            int s2 = fhVar.s(8);
            if (s2 != 240) {
                switch (s2) {
                    case 16:
                        if (i == 3) {
                            if (bArr6 == null) {
                                bArr3 = f12386c5;
                            } else {
                                bArr3 = bArr6;
                            }
                        } else if (i == 2) {
                            if (bArr8 == null) {
                                bArr3 = f12388s;
                            } else {
                                bArr3 = bArr8;
                            }
                        } else {
                            bArr2 = null;
                            i8 = fb(fhVar, iArr, bArr2, i8, i10, paint, canvas);
                            fhVar.zn();
                            continue;
                        }
                        bArr2 = bArr3;
                        i8 = fb(fhVar, iArr, bArr2, i8, i10, paint, canvas);
                        fhVar.zn();
                        continue;
                    case 17:
                        if (i == 3) {
                            if (bArr7 == null) {
                                bArr5 = f12387i9;
                            } else {
                                bArr5 = bArr7;
                            }
                            bArr4 = bArr5;
                        } else {
                            bArr4 = null;
                        }
                        i8 = s(fhVar, iArr, bArr4, i8, i10, paint, canvas);
                        fhVar.zn();
                        continue;
                    case 18:
                        i8 = c5(fhVar, iArr, null, i8, i10, paint, canvas);
                        continue;
                    default:
                        switch (s2) {
                            case 32:
                                bArr8 = y(4, 4, fhVar);
                                continue;
                            case 33:
                                bArr6 = y(4, 8, fhVar);
                                continue;
                            case 34:
                                bArr7 = y(16, 8, fhVar);
                                continue;
                            default:
                                continue;
                        }
                }
            } else {
                i10 += 2;
                i8 = i5;
            }
        }
    }

    public static void p(fh fhVar, s sVar) {
        a aVar;
        int s2 = fhVar.s(8);
        int s3 = fhVar.s(16);
        int s4 = fhVar.s(16);
        int gv2 = fhVar.gv() + s4;
        if (s4 * 8 > fhVar.n3()) {
            r.c5("DvbParser", "Data field length exceeds limit");
            fhVar.mt(fhVar.n3());
            return;
        }
        switch (s2) {
            case 16:
                if (s3 == sVar.y) {
                    gv gvVar = sVar.f12419c5;
                    gv xc2 = xc(fhVar, s4);
                    if (xc2.f12412zn != 0) {
                        sVar.f12419c5 = xc2;
                        sVar.f12425zn.clear();
                        sVar.f12421gv.clear();
                        sVar.f12424v.clear();
                        break;
                    } else if (gvVar != null && gvVar.f12411n3 != xc2.f12411n3) {
                        sVar.f12419c5 = xc2;
                        break;
                    }
                }
                break;
            case 17:
                gv gvVar2 = sVar.f12419c5;
                if (s3 == sVar.y && gvVar2 != null) {
                    a w4 = w(fhVar, s4);
                    if (gvVar2.f12412zn == 0 && (aVar = sVar.f12425zn.get(w4.y)) != null) {
                        w4.y(aVar);
                    }
                    sVar.f12425zn.put(w4.y, w4);
                    break;
                }
                break;
            case 18:
                if (s3 == sVar.y) {
                    y t2 = t(fhVar, s4);
                    sVar.f12421gv.put(t2.y, t2);
                    break;
                } else if (s3 == sVar.f12422n3) {
                    y t3 = t(fhVar, s4);
                    sVar.f12418a.put(t3.y, t3);
                    break;
                }
                break;
            case 19:
                if (s3 == sVar.y) {
                    zn wz2 = wz(fhVar);
                    sVar.f12424v.put(wz2.y, wz2);
                    break;
                } else if (s3 == sVar.f12422n3) {
                    zn wz3 = wz(fhVar);
                    sVar.f12420fb.put(wz3.y, wz3);
                    break;
                }
                break;
            case 20:
                if (s3 == sVar.y) {
                    sVar.f12423s = tl(fhVar);
                    break;
                }
                break;
        }
        fhVar.co(gv2 - fhVar.gv());
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[LOOP:0: B:3:0x0009->B:36:0x0090, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int s(v5.fh r13, int[] r14, @androidx.annotation.Nullable byte[] r15, int r16, int r17, @androidx.annotation.Nullable android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L9:
            r3 = 4
            int r4 = r13.s(r3)
            r5 = 1
            if (r4 == 0) goto L15
            r11 = r2
        L12:
            r12 = 1
            goto L6e
        L15:
            boolean r4 = r13.fb()
            r6 = 3
            if (r4 != 0) goto L2c
            int r3 = r13.s(r6)
            if (r3 == 0) goto L28
            int r3 = r3 + 2
            r11 = r2
            r12 = r3
            r4 = 0
            goto L6e
        L28:
            r4 = 0
            r11 = 1
        L2a:
            r12 = 0
            goto L6e
        L2c:
            boolean r4 = r13.fb()
            r7 = 2
            if (r4 != 0) goto L40
            int r4 = r13.s(r7)
            int r4 = r4 + r3
            int r3 = r13.s(r3)
        L3c:
            r11 = r2
            r12 = r4
            r4 = r3
            goto L6e
        L40:
            int r4 = r13.s(r7)
            if (r4 == 0) goto L6b
            if (r4 == r5) goto L67
            if (r4 == r7) goto L5c
            if (r4 == r6) goto L4f
            r11 = r2
            r4 = 0
            goto L2a
        L4f:
            r4 = 8
            int r4 = r13.s(r4)
            int r4 = r4 + 25
            int r3 = r13.s(r3)
            goto L3c
        L5c:
            int r4 = r13.s(r3)
            int r4 = r4 + 9
            int r3 = r13.s(r3)
            goto L3c
        L67:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L6e
        L6b:
            r11 = r2
            r4 = 0
            goto L12
        L6e:
            if (r12 == 0) goto L8c
            if (r8 == 0) goto L8c
            if (r15 == 0) goto L76
            r4 = r15[r4]
        L76:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L8c:
            int r10 = r10 + r12
            if (r11 == 0) goto L90
            return r10
        L90:
            r2 = r11
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.n3.s(v5.fh, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    public static y t(fh fhVar, int i) {
        int[] iArr;
        int s2;
        int i5;
        int s3;
        int s4;
        int i6;
        int i8 = 8;
        int s5 = fhVar.s(8);
        fhVar.mt(8);
        int i10 = 2;
        int i11 = i - 2;
        int[] zn2 = zn();
        int[] gv2 = gv();
        int[] v2 = v();
        while (i11 > 0) {
            int s7 = fhVar.s(i8);
            int s9 = fhVar.s(i8);
            if ((s9 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                iArr = zn2;
            } else if ((s9 & 64) != 0) {
                iArr = gv2;
            } else {
                iArr = v2;
            }
            if ((s9 & 1) != 0) {
                s4 = fhVar.s(i8);
                i6 = fhVar.s(i8);
                s2 = fhVar.s(i8);
                s3 = fhVar.s(i8);
                i5 = i11 - 6;
            } else {
                int s10 = fhVar.s(4) << 4;
                s2 = fhVar.s(4) << 4;
                i5 = i11 - 4;
                s3 = fhVar.s(i10) << 6;
                s4 = fhVar.s(6) << i10;
                i6 = s10;
            }
            if (s4 == 0) {
                i6 = 0;
                s2 = 0;
                s3 = 255;
            }
            double d2 = s4;
            double d3 = i6 - 128;
            double d4 = s2 - 128;
            iArr[s7] = a((byte) (255 - (s3 & 255)), j5.p((int) (d2 + (1.402d * d3)), 0, 255), j5.p((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), j5.p((int) (d2 + (d4 * 1.772d)), 0, 255));
            i11 = i5;
            s5 = s5;
            i8 = 8;
            i10 = 2;
        }
        return new y(s5, zn2, gv2, v2);
    }

    public static C0179n3 tl(fh fhVar) {
        int i;
        int i5;
        int i6;
        int i8;
        fhVar.mt(4);
        boolean fb2 = fhVar.fb();
        fhVar.mt(3);
        int s2 = fhVar.s(16);
        int s3 = fhVar.s(16);
        if (fb2) {
            int s4 = fhVar.s(16);
            int s5 = fhVar.s(16);
            int s7 = fhVar.s(16);
            i5 = fhVar.s(16);
            i = s5;
            i8 = s7;
            i6 = s4;
        } else {
            i = s2;
            i5 = s3;
            i6 = 0;
            i8 = 0;
        }
        return new C0179n3(s2, s3, i6, i, i8, i5);
    }

    public static int[] v() {
        int i;
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
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i24 = 0; i24 < 256; i24++) {
            int i25 = 255;
            if (i24 < 8) {
                if ((i24 & 1) != 0) {
                    i22 = 255;
                } else {
                    i22 = 0;
                }
                if ((i24 & 2) != 0) {
                    i23 = 255;
                } else {
                    i23 = 0;
                }
                if ((i24 & 4) == 0) {
                    i25 = 0;
                }
                iArr[i24] = a(63, i22, i23, i25);
            } else {
                int i26 = i24 & 136;
                int i27 = 170;
                int i28 = 85;
                if (i26 != 0) {
                    if (i26 != 8) {
                        int i29 = 43;
                        if (i26 != 128) {
                            if (i26 == 136) {
                                if ((i24 & 1) != 0) {
                                    i18 = 43;
                                } else {
                                    i18 = 0;
                                }
                                if ((i24 & 16) != 0) {
                                    i19 = 85;
                                } else {
                                    i19 = 0;
                                }
                                int i30 = i18 + i19;
                                if ((i24 & 2) != 0) {
                                    i20 = 43;
                                } else {
                                    i20 = 0;
                                }
                                if ((i24 & 32) != 0) {
                                    i21 = 85;
                                } else {
                                    i21 = 0;
                                }
                                int i31 = i20 + i21;
                                if ((i24 & 4) == 0) {
                                    i29 = 0;
                                }
                                if ((i24 & 64) == 0) {
                                    i28 = 0;
                                }
                                iArr[i24] = a(255, i30, i31, i29 + i28);
                            }
                        } else {
                            if ((i24 & 1) != 0) {
                                i14 = 43;
                            } else {
                                i14 = 0;
                            }
                            int i32 = i14 + 127;
                            if ((i24 & 16) != 0) {
                                i15 = 85;
                            } else {
                                i15 = 0;
                            }
                            int i33 = i32 + i15;
                            if ((i24 & 2) != 0) {
                                i16 = 43;
                            } else {
                                i16 = 0;
                            }
                            int i34 = i16 + 127;
                            if ((i24 & 32) != 0) {
                                i17 = 85;
                            } else {
                                i17 = 0;
                            }
                            int i35 = i34 + i17;
                            if ((i24 & 4) == 0) {
                                i29 = 0;
                            }
                            int i36 = i29 + 127;
                            if ((i24 & 64) == 0) {
                                i28 = 0;
                            }
                            iArr[i24] = a(255, i33, i35, i36 + i28);
                        }
                    } else {
                        if ((i24 & 1) != 0) {
                            i10 = 85;
                        } else {
                            i10 = 0;
                        }
                        if ((i24 & 16) != 0) {
                            i11 = 170;
                        } else {
                            i11 = 0;
                        }
                        int i37 = i10 + i11;
                        if ((i24 & 2) != 0) {
                            i12 = 85;
                        } else {
                            i12 = 0;
                        }
                        if ((i24 & 32) != 0) {
                            i13 = 170;
                        } else {
                            i13 = 0;
                        }
                        int i38 = i12 + i13;
                        if ((i24 & 4) == 0) {
                            i28 = 0;
                        }
                        if ((i24 & 64) == 0) {
                            i27 = 0;
                        }
                        iArr[i24] = a(127, i37, i38, i28 + i27);
                    }
                } else {
                    if ((i24 & 1) != 0) {
                        i = 85;
                    } else {
                        i = 0;
                    }
                    if ((i24 & 16) != 0) {
                        i5 = 170;
                    } else {
                        i5 = 0;
                    }
                    int i39 = i + i5;
                    if ((i24 & 2) != 0) {
                        i6 = 85;
                    } else {
                        i6 = 0;
                    }
                    if ((i24 & 32) != 0) {
                        i8 = 170;
                    } else {
                        i8 = 0;
                    }
                    int i40 = i6 + i8;
                    if ((i24 & 4) == 0) {
                        i28 = 0;
                    }
                    if ((i24 & 64) == 0) {
                        i27 = 0;
                    }
                    iArr[i24] = a(255, i39, i40, i28 + i27);
                }
            }
        }
        return iArr;
    }

    public static a w(fh fhVar, int i) {
        int i5;
        int i6;
        int s2 = fhVar.s(8);
        fhVar.mt(4);
        boolean fb2 = fhVar.fb();
        fhVar.mt(3);
        int i8 = 16;
        int s3 = fhVar.s(16);
        int s4 = fhVar.s(16);
        int s5 = fhVar.s(3);
        int s7 = fhVar.s(3);
        int i10 = 2;
        fhVar.mt(2);
        int s9 = fhVar.s(8);
        int s10 = fhVar.s(8);
        int s11 = fhVar.s(4);
        int s12 = fhVar.s(2);
        fhVar.mt(2);
        int i11 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i11 > 0) {
            int s13 = fhVar.s(i8);
            int s14 = fhVar.s(i10);
            int s15 = fhVar.s(i10);
            int s16 = fhVar.s(12);
            int i12 = s12;
            fhVar.mt(4);
            int s17 = fhVar.s(12);
            int i13 = i11 - 6;
            if (s14 != 1 && s14 != 2) {
                i11 = i13;
                i6 = 0;
                i5 = 0;
                sparseArray.put(s13, new fb(s14, s15, s16, s17, i6, i5));
                s12 = i12;
                i10 = 2;
                i8 = 16;
            }
            i11 -= 8;
            i6 = fhVar.s(8);
            i5 = fhVar.s(8);
            sparseArray.put(s13, new fb(s14, s15, s16, s17, i6, i5));
            s12 = i12;
            i10 = 2;
            i8 = 16;
        }
        return new a(s2, fb2, s3, s4, s5, s7, s9, s10, s11, s12, sparseArray);
    }

    public static zn wz(fh fhVar) {
        byte[] bArr;
        int s2 = fhVar.s(16);
        fhVar.mt(4);
        int s3 = fhVar.s(2);
        boolean fb2 = fhVar.fb();
        fhVar.mt(1);
        byte[] bArr2 = j5.f14357a;
        if (s3 == 1) {
            fhVar.mt(fhVar.s(8) * 16);
        } else if (s3 == 0) {
            int s4 = fhVar.s(16);
            int s5 = fhVar.s(16);
            if (s4 > 0) {
                bArr2 = new byte[s4];
                fhVar.f(bArr2, 0, s4);
            }
            if (s5 > 0) {
                bArr = new byte[s5];
                fhVar.f(bArr, 0, s5);
                return new zn(s2, fb2, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new zn(s2, fb2, bArr2, bArr);
    }

    public static gv xc(fh fhVar, int i) {
        int s2 = fhVar.s(8);
        int s3 = fhVar.s(4);
        int s4 = fhVar.s(2);
        fhVar.mt(2);
        int i5 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i5 > 0) {
            int s5 = fhVar.s(8);
            fhVar.mt(8);
            i5 -= 6;
            sparseArray.put(s5, new v(fhVar.s(16), fhVar.s(16)));
        }
        return new gv(s2, s3, s4, sparseArray);
    }

    public static byte[] y(int i, int i5, fh fhVar) {
        byte[] bArr = new byte[i];
        for (int i6 = 0; i6 < i; i6++) {
            bArr[i6] = (byte) fhVar.s(i5);
        }
        return bArr;
    }

    public static int[] zn() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    public void mt() {
        this.f12389a.y();
    }

    public List<qh.n3> n3(byte[] bArr, int i) {
        int i5;
        zn znVar;
        int i6;
        SparseArray<fb> sparseArray;
        Paint paint;
        fh fhVar = new fh(bArr, i);
        while (fhVar.n3() >= 48 && fhVar.s(8) == 15) {
            p(fhVar, this.f12389a);
        }
        s sVar = this.f12389a;
        gv gvVar = sVar.f12419c5;
        if (gvVar == null) {
            return Collections.emptyList();
        }
        C0179n3 c0179n3 = sVar.f12423s;
        if (c0179n3 == null) {
            c0179n3 = this.f12391gv;
        }
        Bitmap bitmap = this.f12390fb;
        if (bitmap == null || c0179n3.y + 1 != bitmap.getWidth() || c0179n3.f12415n3 + 1 != this.f12390fb.getHeight()) {
            Bitmap createBitmap = Bitmap.createBitmap(c0179n3.y + 1, c0179n3.f12415n3 + 1, Bitmap.Config.ARGB_8888);
            this.f12390fb = createBitmap;
            this.f12394zn.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<v> sparseArray2 = gvVar.f12410gv;
        for (int i8 = 0; i8 < sparseArray2.size(); i8++) {
            this.f12394zn.save();
            v valueAt = sparseArray2.valueAt(i8);
            a aVar = this.f12389a.f12425zn.get(sparseArray2.keyAt(i8));
            int i10 = valueAt.y + c0179n3.f12417zn;
            int i11 = valueAt.f12426n3 + c0179n3.f12416v;
            this.f12394zn.clipRect(i10, i11, Math.min(aVar.f12404zn + i10, c0179n3.f12414gv), Math.min(aVar.f12399gv + i11, c0179n3.f12413a));
            y yVar = this.f12389a.f12421gv.get(aVar.f12398fb);
            if (yVar == null && (yVar = this.f12389a.f12418a.get(aVar.f12398fb)) == null) {
                yVar = this.f12393v;
            }
            SparseArray<fb> sparseArray3 = aVar.f12397f;
            int i12 = 0;
            while (i12 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i12);
                fb valueAt2 = sparseArray3.valueAt(i12);
                zn znVar2 = this.f12389a.f12424v.get(keyAt);
                if (znVar2 == null) {
                    znVar = this.f12389a.f12420fb.get(keyAt);
                } else {
                    znVar = znVar2;
                }
                if (znVar != null) {
                    if (znVar.f12431n3) {
                        paint = null;
                    } else {
                        paint = this.y;
                    }
                    i6 = i12;
                    sparseArray = sparseArray3;
                    f(znVar, yVar, aVar.f12395a, valueAt2.f12409zn + i10, i11 + valueAt2.f12406gv, paint, this.f12394zn);
                } else {
                    i6 = i12;
                    sparseArray = sparseArray3;
                }
                i12 = i6 + 1;
                sparseArray3 = sparseArray;
            }
            if (aVar.f12401n3) {
                int i13 = aVar.f12395a;
                if (i13 == 3) {
                    i5 = yVar.f12427gv[aVar.f12402s];
                } else if (i13 == 2) {
                    i5 = yVar.f12429zn[aVar.f12396c5];
                } else {
                    i5 = yVar.f12428n3[aVar.f12400i9];
                }
                this.f12392n3.setColor(i5);
                this.f12394zn.drawRect(i10, i11, aVar.f12404zn + i10, aVar.f12399gv + i11, this.f12392n3);
            }
            arrayList.add(new n3.C0187n3().a(Bitmap.createBitmap(this.f12390fb, i10, i11, aVar.f12404zn, aVar.f12399gv)).f(i10 / c0179n3.y).t(0).s(i11 / c0179n3.f12415n3, 0).c5(0).wz(aVar.f12404zn / c0179n3.y).fb(aVar.f12399gv / c0179n3.f12415n3).y());
            this.f12394zn.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f12394zn.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }
}
