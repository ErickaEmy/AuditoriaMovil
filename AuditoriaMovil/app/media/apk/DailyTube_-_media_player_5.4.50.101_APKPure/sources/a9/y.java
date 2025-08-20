package a9;
/* loaded from: classes.dex */
public abstract class y {
    public int y;

    public void a() {
        this.y = 0;
    }

    public final boolean c5() {
        return s(268435456);
    }

    public final boolean f() {
        return s(Integer.MIN_VALUE);
    }

    public final void fb(int i) {
        this.y = (~i) & this.y;
    }

    public final boolean s(int i) {
        if ((this.y & i) == i) {
            return true;
        }
        return false;
    }

    public final boolean t() {
        return s(4);
    }

    public final boolean tl() {
        return s(134217728);
    }

    public final void v(int i) {
        this.y = i | this.y;
    }

    public final void w(int i) {
        this.y = i;
    }

    public final boolean wz() {
        return s(1);
    }

    public final boolean xc() {
        return s(536870912);
    }
}
