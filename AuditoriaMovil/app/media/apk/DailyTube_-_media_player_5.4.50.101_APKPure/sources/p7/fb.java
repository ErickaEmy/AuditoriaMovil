package p7;

import androidx.annotation.Nullable;
import e4.ta;
import fj.u0;
import java.io.IOException;
import java.util.List;
import m1.m;
/* loaded from: classes.dex */
public interface fb {

    /* loaded from: classes.dex */
    public interface n3 {
        ta a(int i, int i5);
    }

    /* loaded from: classes.dex */
    public interface y {
        @Nullable
        fb y(int i, m mVar, boolean z2, List<m> list, @Nullable ta taVar, u0 u0Var);
    }

    @Nullable
    m[] gv();

    boolean n3(e4.tl tlVar) throws IOException;

    void release();

    void y(@Nullable n3 n3Var, long j2, long j4);

    @Nullable
    e4.gv zn();
}
