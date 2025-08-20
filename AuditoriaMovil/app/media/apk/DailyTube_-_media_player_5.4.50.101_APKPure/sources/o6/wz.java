package o6;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
/* loaded from: classes.dex */
public final class wz extends w {

    /* renamed from: n  reason: collision with root package name */
    public static final String[] f12228n = new String[NotificationCompat.FLAG_HIGH_PRIORITY];

    /* renamed from: f3  reason: collision with root package name */
    public String f12229f3;

    /* renamed from: r  reason: collision with root package name */
    public String f12230r = ":";

    /* renamed from: z  reason: collision with root package name */
    public final zc1.a f12231z;

    static {
        for (int i = 0; i <= 31; i++) {
            f12228n[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f12228n;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public wz(zc1.a aVar) {
        if (aVar != null) {
            this.f12231z = aVar;
            ud(6);
            return;
        }
        throw new NullPointerException("sink == null");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m(zc1.a r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = o6.wz.f12228n
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.c(r8, r4, r3)
        L2e:
            r7.n(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.c(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.wz.m(zc1.a, java.lang.String):void");
    }

    public final void ap() throws IOException {
        if (this.f12221f == null) {
            return;
        }
        this.f12231z.writeByte(10);
        int i = this.y;
        for (int i5 = 1; i5 < i; i5++) {
            this.f12231z.n(this.f12221f);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12231z.close();
        int i = this.y;
        if (i <= 1 && (i != 1 || this.f12226v[i - 1] == 7)) {
            this.y = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // o6.w
    public w co(String str) throws IOException {
        if (str != null) {
            if (this.y != 0) {
                int ta2 = ta();
                if ((ta2 == 3 || ta2 == 5) && this.f12229f3 == null && !this.f12223p) {
                    this.f12229f3 = str;
                    this.f12222fb[this.y - 1] = str;
                    return this;
                }
                throw new IllegalStateException("Nesting problem.");
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new NullPointerException("name == null");
    }

    public final void ct() throws IOException {
        int ta2 = ta();
        int i = 2;
        if (ta2 != 1) {
            if (ta2 != 2) {
                if (ta2 != 4) {
                    if (ta2 != 9) {
                        i = 7;
                        if (ta2 != 6) {
                            if (ta2 == 7) {
                                if (!this.f12225t) {
                                    throw new IllegalStateException("JSON must have only one top-level value.");
                                }
                            } else {
                                throw new IllegalStateException("Nesting problem.");
                            }
                        }
                    } else {
                        throw new IllegalStateException("Sink from valueSink() was not closed");
                    }
                } else {
                    this.f12231z.n(this.f12230r);
                    i = 5;
                }
                b(i);
            }
            this.f12231z.writeByte(44);
        }
        ap();
        b(i);
    }

    public final void dm() throws IOException {
        int ta2 = ta();
        if (ta2 == 5) {
            this.f12231z.writeByte(44);
        } else if (ta2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        ap();
        b(4);
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.y != 0) {
            this.f12231z.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    @Override // o6.w
    public w j(String str) throws IOException {
        if (str == null) {
            return r();
        }
        if (this.f12223p) {
            this.f12223p = false;
            return co(str);
        }
        pq();
        ct();
        m(this.f12231z, str);
        int[] iArr = this.f12224s;
        int i = this.y - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // o6.w
    public w j5(Number number) throws IOException {
        if (number == null) {
            return r();
        }
        String obj = number.toString();
        if (!this.f12225t && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        } else if (this.f12223p) {
            this.f12223p = false;
            return co(obj);
        } else {
            pq();
            ct();
            this.f12231z.n(obj);
            int[] iArr = this.f12224s;
            int i = this.y - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
    }

    @Override // o6.w
    public w jz(boolean z2) throws IOException {
        String str;
        if (!this.f12223p) {
            pq();
            ct();
            zc1.a aVar = this.f12231z;
            if (z2) {
                str = "true";
            } else {
                str = "false";
            }
            aVar.n(str);
            int[] iArr = this.f12224s;
            int i = this.y - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // o6.w
    public w k5(double d2) throws IOException {
        if (!this.f12225t && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        } else if (this.f12223p) {
            this.f12223p = false;
            return co(Double.toString(d2));
        } else {
            pq();
            ct();
            this.f12231z.n(Double.toString(d2));
            int[] iArr = this.f12224s;
            int i = this.y - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
    }

    @Override // o6.w
    public w mt() throws IOException {
        this.f12223p = false;
        return o4(3, 5, '}');
    }

    public final w o4(int i, int i5, char c2) throws IOException {
        int ta2 = ta();
        if (ta2 != i5 && ta2 != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f12229f3 == null) {
            int i6 = this.y;
            int i8 = this.f12220co;
            if (i6 == (~i8)) {
                this.f12220co = ~i8;
                return this;
            }
            int i10 = i6 - 1;
            this.y = i10;
            this.f12222fb[i10] = null;
            int[] iArr = this.f12224s;
            int i11 = i6 - 2;
            iArr[i11] = iArr[i11] + 1;
            if (ta2 == i5) {
                ap();
            }
            this.f12231z.writeByte(c2);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f12229f3);
    }

    @Override // o6.w
    public w p() throws IOException {
        return o4(1, 2, ']');
    }

    public final void pq() throws IOException {
        if (this.f12229f3 != null) {
            dm();
            m(this.f12231z, this.f12229f3);
            this.f12229f3 = null;
        }
    }

    @Override // o6.w
    public w r() throws IOException {
        if (!this.f12223p) {
            if (this.f12229f3 != null) {
                if (this.f12227w) {
                    pq();
                } else {
                    this.f12229f3 = null;
                    return this;
                }
            }
            ct();
            this.f12231z.n("null");
            int[] iArr = this.f12224s;
            int i = this.y - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
        throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // o6.w
    public w v() throws IOException {
        if (!this.f12223p) {
            pq();
            return yc(3, 5, '{');
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // o6.w
    public w y() throws IOException {
        if (!this.f12223p) {
            pq();
            return yc(1, 2, '[');
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    public final w yc(int i, int i5, char c2) throws IOException {
        int i6 = this.y;
        int i8 = this.f12220co;
        if (i6 == i8) {
            int[] iArr = this.f12226v;
            if (iArr[i6 - 1] == i || iArr[i6 - 1] == i5) {
                this.f12220co = ~i8;
                return this;
            }
        }
        ct();
        s();
        ud(i);
        this.f12224s[this.y - 1] = 0;
        this.f12231z.writeByte(c2);
        return this;
    }

    @Override // o6.w
    public w yt(long j2) throws IOException {
        if (this.f12223p) {
            this.f12223p = false;
            return co(Long.toString(j2));
        }
        pq();
        ct();
        this.f12231z.n(Long.toString(j2));
        int[] iArr = this.f12224s;
        int i = this.y - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }
}
