package wd1;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class zn {
    public n3 y;

    public zn(n3 level) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.y = level;
    }

    public final void a(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        zn(n3.INFO, msg);
    }

    public final void c5(n3 lvl, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (fb(lvl)) {
            zn(lvl, msg.invoke());
        }
    }

    public final boolean fb(n3 lvl) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        if (this.y.compareTo(lvl) <= 0) {
            return true;
        }
        return false;
    }

    public final void gv(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        zn(n3.ERROR, msg);
    }

    public final void n3(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        zn(n3.DEBUG, msg);
    }

    public abstract void s(n3 n3Var, String str);

    public final n3 v() {
        return this.y;
    }

    public final boolean y(n3 n3Var) {
        if (this.y.compareTo(n3Var) <= 0) {
            return true;
        }
        return false;
    }

    public final void zn(n3 n3Var, String str) {
        if (y(n3Var)) {
            s(n3Var, str);
        }
    }
}
