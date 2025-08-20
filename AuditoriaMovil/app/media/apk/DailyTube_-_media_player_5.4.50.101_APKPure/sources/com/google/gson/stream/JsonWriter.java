package com.google.gson.stream;

import androidx.core.app.NotificationCompat;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
/* loaded from: classes.dex */
public class JsonWriter implements Closeable, Flushable {

    /* renamed from: r  reason: collision with root package name */
    public static final String[] f6292r;

    /* renamed from: z  reason: collision with root package name */
    public static final String[] f6293z = new String[NotificationCompat.FLAG_HIGH_PRIORITY];

    /* renamed from: co  reason: collision with root package name */
    public boolean f6294co;

    /* renamed from: f  reason: collision with root package name */
    public String f6295f;

    /* renamed from: fb  reason: collision with root package name */
    public int f6296fb;

    /* renamed from: p  reason: collision with root package name */
    public String f6297p;

    /* renamed from: s  reason: collision with root package name */
    public String f6298s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f6299t;

    /* renamed from: v  reason: collision with root package name */
    public int[] f6300v = new int[32];

    /* renamed from: w  reason: collision with root package name */
    public boolean f6301w;
    public final Writer y;

    static {
        for (int i = 0; i <= 31; i++) {
            f6293z[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f6293z;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f6292r = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        r(6);
        this.f6295f = ":";
        this.f6294co = true;
        if (writer != null) {
            this.y = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public JsonWriter beginArray() throws IOException {
        d();
        return mt(1, '[');
    }

    public JsonWriter beginObject() throws IOException {
        d();
        return mt(3, '{');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.y.close();
        int i = this.f6296fb;
        if (i <= 1 && (i != 1 || this.f6300v[i - 1] == 7)) {
            this.f6296fb = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public final int co() {
        int i = this.f6296fb;
        if (i != 0) {
            return this.f6300v[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void d() throws IOException {
        if (this.f6297p != null) {
            y();
            ta(this.f6297p);
            this.f6297p = null;
        }
    }

    public JsonWriter endArray() throws IOException {
        return s(1, 2, ']');
    }

    public JsonWriter endObject() throws IOException {
        return s(3, 5, '}');
    }

    public void flush() throws IOException {
        if (this.f6296fb != 0) {
            this.y.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final boolean getSerializeNulls() {
        return this.f6294co;
    }

    public final boolean isHtmlSafe() {
        return this.f6301w;
    }

    public boolean isLenient() {
        return this.f6299t;
    }

    public JsonWriter jsonValue(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        d();
        v();
        this.y.append((CharSequence) str);
        return this;
    }

    public final JsonWriter mt(int i, char c2) throws IOException {
        v();
        r(i);
        this.y.write(c2);
        return this;
    }

    public JsonWriter name(String str) throws IOException {
        if (str != null) {
            if (this.f6297p == null) {
                if (this.f6296fb != 0) {
                    this.f6297p = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public JsonWriter nullValue() throws IOException {
        if (this.f6297p != null) {
            if (this.f6294co) {
                d();
            } else {
                this.f6297p = null;
                return this;
            }
        }
        v();
        this.y.write("null");
        return this;
    }

    public final void p() throws IOException {
        if (this.f6298s == null) {
            return;
        }
        this.y.write(10);
        int i = this.f6296fb;
        for (int i5 = 1; i5 < i; i5++) {
            this.y.write(this.f6298s);
        }
    }

    public final void r(int i) {
        int i5 = this.f6296fb;
        int[] iArr = this.f6300v;
        if (i5 == iArr.length) {
            this.f6300v = Arrays.copyOf(iArr, i5 * 2);
        }
        int[] iArr2 = this.f6300v;
        int i6 = this.f6296fb;
        this.f6296fb = i6 + 1;
        iArr2[i6] = i;
    }

    public final JsonWriter s(int i, int i5, char c2) throws IOException {
        int co2 = co();
        if (co2 != i5 && co2 != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f6297p == null) {
            this.f6296fb--;
            if (co2 == i5) {
                p();
            }
            this.y.write(c2);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f6297p);
    }

    public final void setHtmlSafe(boolean z2) {
        this.f6301w = z2;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.f6298s = null;
            this.f6295f = ":";
            return;
        }
        this.f6298s = str;
        this.f6295f = ": ";
    }

    public final void setLenient(boolean z2) {
        this.f6299t = z2;
    }

    public final void setSerializeNulls(boolean z2) {
        this.f6294co = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ta(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f6301w
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.f6292r
            goto L9
        L7:
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.f6293z
        L9:
            java.io.Writer r1 = r8.y
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.y
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.y
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.y
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.y
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonWriter.ta(java.lang.String):void");
    }

    public final void v() throws IOException {
        int co2 = co();
        if (co2 != 1) {
            if (co2 != 2) {
                if (co2 != 4) {
                    if (co2 != 6) {
                        if (co2 == 7) {
                            if (!this.f6299t) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    x4(7);
                    return;
                }
                this.y.append((CharSequence) this.f6295f);
                x4(5);
                return;
            }
            this.y.append(',');
            p();
            return;
        }
        x4(2);
        p();
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        d();
        v();
        ta(str);
        return this;
    }

    public final void x4(int i) {
        this.f6300v[this.f6296fb - 1] = i;
    }

    public final void y() throws IOException {
        int co2 = co();
        if (co2 == 5) {
            this.y.write(44);
        } else if (co2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        p();
        x4(4);
    }

    public JsonWriter value(boolean z2) throws IOException {
        d();
        v();
        this.y.write(z2 ? "true" : "false");
        return this;
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        d();
        v();
        this.y.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public JsonWriter value(double d2) throws IOException {
        d();
        if (!this.f6299t && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        v();
        this.y.append((CharSequence) Double.toString(d2));
        return this;
    }

    public JsonWriter value(long j2) throws IOException {
        d();
        v();
        this.y.write(Long.toString(j2));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        d();
        String obj = number.toString();
        if (!this.f6299t && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        v();
        this.y.append((CharSequence) obj);
        return this;
    }
}
