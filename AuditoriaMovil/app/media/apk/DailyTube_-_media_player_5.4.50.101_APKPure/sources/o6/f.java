package o6;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class f implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    public boolean f12156f;

    /* renamed from: t  reason: collision with root package name */
    public boolean f12159t;
    public int y;

    /* renamed from: v  reason: collision with root package name */
    public int[] f12160v = new int[32];

    /* renamed from: fb  reason: collision with root package name */
    public String[] f12157fb = new String[32];

    /* renamed from: s  reason: collision with root package name */
    public int[] f12158s = new int[32];

    /* loaded from: classes.dex */
    public enum n3 {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final zc1.z f12171n3;
        public final String[] y;

        public y(String[] strArr, zc1.z zVar) {
            this.y = strArr;
            this.f12171n3 = zVar;
        }

        public static y y(String... strArr) {
            try {
                zc1.s[] sVarArr = new zc1.s[strArr.length];
                zc1.v vVar = new zc1.v();
                for (int i = 0; i < strArr.length; i++) {
                    wz.m(vVar, strArr[i]);
                    vVar.readByte();
                    sVarArr[i] = vVar.bk();
                }
                return new y((String[]) strArr.clone(), zc1.z.mt(sVarArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public static f k5(zc1.fb fbVar) {
        return new tl(fbVar);
    }

    public final c5 ap(String str) throws c5 {
        throw new c5(str + " at path " + getPath());
    }

    public abstract String b() throws IOException;

    public final boolean co() {
        return this.f12156f;
    }

    public abstract void ct() throws IOException;

    public abstract long d() throws IOException;

    public abstract int dm(y yVar) throws IOException;

    public final String getPath() {
        return t.y(this.y, this.f12160v, this.f12157fb, this.f12158s);
    }

    public final void j(int i) {
        int i5 = this.y;
        int[] iArr = this.f12160v;
        if (i5 == iArr.length) {
            if (i5 != 256) {
                this.f12160v = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f12157fb;
                this.f12157fb = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f12158s;
                this.f12158s = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new s("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f12160v;
        int i6 = this.y;
        this.y = i6 + 1;
        iArr3[i6] = i;
    }

    public abstract void j5() throws IOException;

    public abstract int jz(y yVar) throws IOException;

    public abstract boolean mt() throws IOException;

    public abstract void o4() throws IOException;

    public abstract void p() throws IOException;

    public abstract boolean r() throws IOException;

    public abstract void s() throws IOException;

    public abstract int ta() throws IOException;

    public abstract <T> T ud() throws IOException;

    public abstract void v() throws IOException;

    public abstract double x4() throws IOException;

    public abstract void y() throws IOException;

    public abstract n3 yt() throws IOException;
}
