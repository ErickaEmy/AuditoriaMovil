package o6;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class w implements Closeable, Flushable {

    /* renamed from: f  reason: collision with root package name */
    public String f12221f;

    /* renamed from: p  reason: collision with root package name */
    public boolean f12223p;

    /* renamed from: t  reason: collision with root package name */
    public boolean f12225t;

    /* renamed from: w  reason: collision with root package name */
    public boolean f12227w;
    public int y;

    /* renamed from: v  reason: collision with root package name */
    public int[] f12226v = new int[32];

    /* renamed from: fb  reason: collision with root package name */
    public String[] f12222fb = new String[32];

    /* renamed from: s  reason: collision with root package name */
    public int[] f12224s = new int[32];

    /* renamed from: co  reason: collision with root package name */
    public int f12220co = -1;

    public static w x4(zc1.a aVar) {
        return new wz(aVar);
    }

    public final void b(int i) {
        this.f12226v[this.y - 1] = i;
    }

    public abstract w co(String str) throws IOException;

    public final void d() throws IOException {
        int ta2 = ta();
        if (ta2 != 5 && ta2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.f12223p = true;
    }

    public final String getPath() {
        return t.y(this.y, this.f12226v, this.f12222fb, this.f12224s);
    }

    public abstract w j(String str) throws IOException;

    public abstract w j5(Number number) throws IOException;

    public abstract w jz(boolean z2) throws IOException;

    public abstract w k5(double d2) throws IOException;

    public abstract w mt() throws IOException;

    public abstract w p() throws IOException;

    public abstract w r() throws IOException;

    public final boolean s() {
        int i = this.y;
        int[] iArr = this.f12226v;
        if (i != iArr.length) {
            return false;
        }
        if (i != 256) {
            this.f12226v = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f12222fb;
            this.f12222fb = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f12224s;
            this.f12224s = Arrays.copyOf(iArr2, iArr2.length * 2);
            if (this instanceof xc) {
                xc xcVar = (xc) this;
                Object[] objArr = xcVar.f12233z;
                xcVar.f12233z = Arrays.copyOf(objArr, objArr.length * 2);
                return true;
            }
            return true;
        }
        throw new s("Nesting too deep at " + getPath() + ": circular reference?");
    }

    public final int ta() {
        int i = this.y;
        if (i != 0) {
            return this.f12226v[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void ud(int i) {
        int[] iArr = this.f12226v;
        int i5 = this.y;
        this.y = i5 + 1;
        iArr[i5] = i;
    }

    public abstract w v() throws IOException;

    public abstract w y() throws IOException;

    public abstract w yt(long j2) throws IOException;
}
