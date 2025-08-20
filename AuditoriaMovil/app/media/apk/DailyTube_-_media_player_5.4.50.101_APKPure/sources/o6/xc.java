package o6;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class xc extends w {

    /* renamed from: r  reason: collision with root package name */
    public String f12232r;

    /* renamed from: z  reason: collision with root package name */
    public Object[] f12233z = new Object[32];

    public xc() {
        ud(6);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
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
                if (ta() == 3 && this.f12232r == null && !this.f12223p) {
                    this.f12232r = str;
                    this.f12222fb[this.y - 1] = str;
                    return this;
                }
                throw new IllegalStateException("Nesting problem.");
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new NullPointerException("name == null");
    }

    public final xc dm(Object obj) {
        String str;
        Object put;
        int ta2 = ta();
        int i = this.y;
        if (i == 1) {
            if (ta2 == 6) {
                this.f12226v[i - 1] = 7;
                this.f12233z[i - 1] = obj;
            } else {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        } else if (ta2 == 3 && (str = this.f12232r) != null) {
            if ((obj == null && !this.f12227w) || (put = ((Map) this.f12233z[i - 1]).put(str, obj)) == null) {
                this.f12232r = null;
            } else {
                throw new IllegalArgumentException("Map key '" + this.f12232r + "' has multiple values at path " + getPath() + ": " + put + " and " + obj);
            }
        } else if (ta2 == 1) {
            ((List) this.f12233z[i - 1]).add(obj);
        } else if (ta2 == 9) {
            throw new IllegalStateException("Sink from valueSink() was not closed");
        } else {
            throw new IllegalStateException("Nesting problem.");
        }
        return this;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.y != 0) {
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    @Override // o6.w
    public w j(String str) throws IOException {
        if (this.f12223p) {
            this.f12223p = false;
            return co(str);
        }
        dm(str);
        int[] iArr = this.f12224s;
        int i = this.y - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    @Override // o6.w
    public w j5(Number number) throws IOException {
        BigDecimal bigDecimal;
        if (!(number instanceof Byte) && !(number instanceof Short) && !(number instanceof Integer) && !(number instanceof Long)) {
            if (!(number instanceof Float) && !(number instanceof Double)) {
                if (number == null) {
                    return r();
                }
                if (number instanceof BigDecimal) {
                    bigDecimal = (BigDecimal) number;
                } else {
                    bigDecimal = new BigDecimal(number.toString());
                }
                if (this.f12223p) {
                    this.f12223p = false;
                    return co(bigDecimal.toString());
                }
                dm(bigDecimal);
                int[] iArr = this.f12224s;
                int i = this.y - 1;
                iArr[i] = iArr[i] + 1;
                return this;
            }
            return k5(number.doubleValue());
        }
        return yt(number.longValue());
    }

    @Override // o6.w
    public w jz(boolean z2) throws IOException {
        if (!this.f12223p) {
            dm(Boolean.valueOf(z2));
            int[] iArr = this.f12224s;
            int i = this.y - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // o6.w
    public w k5(double d2) throws IOException {
        if (!this.f12225t && (Double.isNaN(d2) || d2 == Double.NEGATIVE_INFINITY || d2 == Double.POSITIVE_INFINITY)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        } else if (this.f12223p) {
            this.f12223p = false;
            return co(Double.toString(d2));
        } else {
            dm(Double.valueOf(d2));
            int[] iArr = this.f12224s;
            int i = this.y - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
    }

    @Override // o6.w
    public w mt() throws IOException {
        if (ta() == 3) {
            if (this.f12232r == null) {
                int i = this.y;
                int i5 = this.f12220co;
                if (i == (~i5)) {
                    this.f12220co = ~i5;
                    return this;
                }
                this.f12223p = false;
                int i6 = i - 1;
                this.y = i6;
                this.f12233z[i6] = null;
                this.f12222fb[i6] = null;
                int[] iArr = this.f12224s;
                int i8 = i - 2;
                iArr[i8] = iArr[i8] + 1;
                return this;
            }
            throw new IllegalStateException("Dangling name: " + this.f12232r);
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override // o6.w
    public w p() throws IOException {
        if (ta() == 1) {
            int i = this.y;
            int i5 = this.f12220co;
            if (i == (~i5)) {
                this.f12220co = ~i5;
                return this;
            }
            int i6 = i - 1;
            this.y = i6;
            this.f12233z[i6] = null;
            int[] iArr = this.f12224s;
            int i8 = i - 2;
            iArr[i8] = iArr[i8] + 1;
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override // o6.w
    public w r() throws IOException {
        if (!this.f12223p) {
            dm(null);
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
            int i = this.y;
            int i5 = this.f12220co;
            if (i == i5 && this.f12226v[i - 1] == 3) {
                this.f12220co = ~i5;
                return this;
            }
            s();
            p pVar = new p();
            dm(pVar);
            this.f12233z[this.y] = pVar;
            ud(3);
            return this;
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // o6.w
    public w y() throws IOException {
        if (!this.f12223p) {
            int i = this.y;
            int i5 = this.f12220co;
            if (i == i5 && this.f12226v[i - 1] == 1) {
                this.f12220co = ~i5;
                return this;
            }
            s();
            ArrayList arrayList = new ArrayList();
            dm(arrayList);
            Object[] objArr = this.f12233z;
            int i6 = this.y;
            objArr[i6] = arrayList;
            this.f12224s[i6] = 0;
            ud(1);
            return this;
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // o6.w
    public w yt(long j2) throws IOException {
        if (this.f12223p) {
            this.f12223p = false;
            return co(Long.toString(j2));
        }
        dm(Long.valueOf(j2));
        int[] iArr = this.f12224s;
        int i = this.y - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }
}
