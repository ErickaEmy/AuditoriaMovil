package di;

import androidx.annotation.Nullable;
import java.io.File;
/* loaded from: classes.dex */
public class c5 implements Comparable<c5> {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final File f7250f;

    /* renamed from: fb  reason: collision with root package name */
    public final long f7251fb;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f7252s;

    /* renamed from: t  reason: collision with root package name */
    public final long f7253t;

    /* renamed from: v  reason: collision with root package name */
    public final long f7254v;
    public final String y;

    public c5(String str, long j2, long j4, long j6, @Nullable File file) {
        boolean z2;
        this.y = str;
        this.f7254v = j2;
        this.f7251fb = j4;
        if (file != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f7252s = z2;
        this.f7250f = file;
        this.f7253t = j6;
    }

    public boolean n3() {
        return !this.f7252s;
    }

    public String toString() {
        return "[" + this.f7254v + ", " + this.f7251fb + "]";
    }

    @Override // java.lang.Comparable
    /* renamed from: y */
    public int compareTo(c5 c5Var) {
        if (!this.y.equals(c5Var.y)) {
            return this.y.compareTo(c5Var.y);
        }
        int i = ((this.f7254v - c5Var.f7254v) > 0L ? 1 : ((this.f7254v - c5Var.f7254v) == 0L ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        if (i < 0) {
            return -1;
        }
        return 1;
    }

    public boolean zn() {
        if (this.f7251fb == -1) {
            return true;
        }
        return false;
    }
}
