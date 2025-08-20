package ha;

import androidx.annotation.Nullable;
import java.io.IOException;
import v5.rz;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public int f8875a;

    /* renamed from: gv  reason: collision with root package name */
    public long f8879gv;

    /* renamed from: mt  reason: collision with root package name */
    public boolean f8881mt;

    /* renamed from: n3  reason: collision with root package name */
    public long f8882n3;

    /* renamed from: p  reason: collision with root package name */
    public long f8883p;

    /* renamed from: t  reason: collision with root package name */
    public boolean f8885t;

    /* renamed from: v  reason: collision with root package name */
    public int f8887v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f8888w;
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public w f8889wz;
    public zn y;

    /* renamed from: zn  reason: collision with root package name */
    public long f8891zn;

    /* renamed from: fb  reason: collision with root package name */
    public long[] f8878fb = new long[0];

    /* renamed from: s  reason: collision with root package name */
    public int[] f8884s = new int[0];

    /* renamed from: c5  reason: collision with root package name */
    public int[] f8876c5 = new int[0];

    /* renamed from: i9  reason: collision with root package name */
    public long[] f8880i9 = new long[0];

    /* renamed from: f  reason: collision with root package name */
    public boolean[] f8877f = new boolean[0];

    /* renamed from: tl  reason: collision with root package name */
    public boolean[] f8886tl = new boolean[0];

    /* renamed from: xc  reason: collision with root package name */
    public final rz f8890xc = new rz();

    public void a() {
        this.f8887v = 0;
        this.f8883p = 0L;
        this.f8881mt = false;
        this.f8885t = false;
        this.f8888w = false;
        this.f8889wz = null;
    }

    public boolean fb(int i) {
        if (this.f8885t && this.f8886tl[i]) {
            return true;
        }
        return false;
    }

    public void gv(int i) {
        this.f8890xc.j5(i);
        this.f8885t = true;
        this.f8888w = true;
    }

    public void n3(rz rzVar) {
        rzVar.t(this.f8890xc.v(), 0, this.f8890xc.fb());
        this.f8890xc.oz(0);
        this.f8888w = false;
    }

    public void v(int i, int i5) {
        this.f8887v = i;
        this.f8875a = i5;
        if (this.f8884s.length < i) {
            this.f8878fb = new long[i];
            this.f8884s = new int[i];
        }
        if (this.f8876c5.length < i5) {
            int i6 = (i5 * 125) / 100;
            this.f8876c5 = new int[i6];
            this.f8880i9 = new long[i6];
            this.f8877f = new boolean[i6];
            this.f8886tl = new boolean[i6];
        }
    }

    public void y(e4.tl tlVar) throws IOException {
        tlVar.readFully(this.f8890xc.v(), 0, this.f8890xc.fb());
        this.f8890xc.oz(0);
        this.f8888w = false;
    }

    public long zn(int i) {
        return this.f8880i9[i];
    }
}
