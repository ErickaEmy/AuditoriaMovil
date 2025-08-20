package w0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class mt {

    /* renamed from: gv  reason: collision with root package name */
    public final int f14503gv;

    /* renamed from: n3  reason: collision with root package name */
    public final boolean f14504n3;
    public final gv y;

    /* renamed from: zn  reason: collision with root package name */
    public final zn f14505zn;

    /* loaded from: classes.dex */
    public static abstract class n3 extends w0.n3<String> {

        /* renamed from: f  reason: collision with root package name */
        public final boolean f14506f;

        /* renamed from: fb  reason: collision with root package name */
        public final CharSequence f14507fb;

        /* renamed from: s  reason: collision with root package name */
        public final gv f14508s;

        /* renamed from: t  reason: collision with root package name */
        public int f14509t;

        /* renamed from: w  reason: collision with root package name */
        public int f14510w;

        public n3(mt mtVar, CharSequence charSequence) {
            this.f14508s = mtVar.y;
            this.f14506f = mtVar.f14504n3;
            this.f14510w = mtVar.f14503gv;
            this.f14507fb = charSequence;
        }

        public abstract int a(int i);

        @Override // w0.n3
        /* renamed from: gv */
        public String y() {
            int a2;
            int i = this.f14509t;
            while (true) {
                int i5 = this.f14509t;
                if (i5 != -1) {
                    a2 = a(i5);
                    if (a2 == -1) {
                        a2 = this.f14507fb.length();
                        this.f14509t = -1;
                    } else {
                        this.f14509t = v(a2);
                    }
                    int i6 = this.f14509t;
                    if (i6 == i) {
                        int i8 = i6 + 1;
                        this.f14509t = i8;
                        if (i8 > this.f14507fb.length()) {
                            this.f14509t = -1;
                        }
                    } else {
                        while (i < a2 && this.f14508s.v(this.f14507fb.charAt(i))) {
                            i++;
                        }
                        while (a2 > i && this.f14508s.v(this.f14507fb.charAt(a2 - 1))) {
                            a2--;
                        }
                        if (!this.f14506f || i != a2) {
                            break;
                        }
                        i = this.f14509t;
                    }
                } else {
                    return n3();
                }
            }
            int i10 = this.f14510w;
            if (i10 == 1) {
                a2 = this.f14507fb.length();
                this.f14509t = -1;
                while (a2 > i && this.f14508s.v(this.f14507fb.charAt(a2 - 1))) {
                    a2--;
                }
            } else {
                this.f14510w = i10 - 1;
            }
            return this.f14507fb.subSequence(i, a2).toString();
        }

        public abstract int v(int i);
    }

    /* loaded from: classes.dex */
    public class y implements zn {
        public final /* synthetic */ gv y;

        /* renamed from: w0.mt$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0242y extends n3 {
            public C0242y(mt mtVar, CharSequence charSequence) {
                super(mtVar, charSequence);
            }

            @Override // w0.mt.n3
            public int a(int i) {
                return y.this.y.zn(this.f14507fb, i);
            }

            @Override // w0.mt.n3
            public int v(int i) {
                return i + 1;
            }
        }

        public y(gv gvVar) {
            this.y = gvVar;
        }

        @Override // w0.mt.zn
        /* renamed from: n3 */
        public n3 y(mt mtVar, CharSequence charSequence) {
            return new C0242y(mtVar, charSequence);
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        Iterator<String> y(mt mtVar, CharSequence charSequence);
    }

    public mt(zn znVar) {
        this(znVar, false, gv.a(), Integer.MAX_VALUE);
    }

    public static mt gv(char c2) {
        return v(gv.gv(c2));
    }

    public static mt v(gv gvVar) {
        xc.wz(gvVar);
        return new mt(new y(gvVar));
    }

    public List<String> a(CharSequence charSequence) {
        xc.wz(charSequence);
        Iterator<String> fb2 = fb(charSequence);
        ArrayList arrayList = new ArrayList();
        while (fb2.hasNext()) {
            arrayList.add(fb2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterator<String> fb(CharSequence charSequence) {
        return this.f14505zn.y(this, charSequence);
    }

    public mt(zn znVar, boolean z2, gv gvVar, int i) {
        this.f14505zn = znVar;
        this.f14504n3 = z2;
        this.y = gvVar;
        this.f14503gv = i;
    }
}
