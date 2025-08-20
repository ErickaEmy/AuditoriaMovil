package kx;

import androidx.annotation.Nullable;
import java.io.FileNotFoundException;
import java.io.IOException;
import kx.d0;
import kx.mg;
import kx.ta;
import m1.ne;
/* loaded from: classes.dex */
public class n implements mg {
    public final int y;

    public n() {
        this(-1);
    }

    @Override // kx.mg
    public long gv(mg.zn znVar) {
        IOException iOException = znVar.f10061zn;
        if (!(iOException instanceof ne) && !(iOException instanceof FileNotFoundException) && !(iOException instanceof d0.y) && !(iOException instanceof ta.s) && !wz.y(iOException)) {
            return Math.min((znVar.f10059gv - 1) * 1000, 5000);
        }
        return -9223372036854775807L;
    }

    @Override // kx.mg
    @Nullable
    public mg.n3 n3(mg.y yVar, mg.zn znVar) {
        if (!v(znVar.f10061zn)) {
            return null;
        }
        if (yVar.y(1)) {
            return new mg.n3(1, 300000L);
        }
        if (!yVar.y(2)) {
            return null;
        }
        return new mg.n3(2, 60000L);
    }

    public boolean v(IOException iOException) {
        if (!(iOException instanceof d0.v)) {
            return false;
        }
        int i = ((d0.v) iOException).responseCode;
        if (i != 403 && i != 404 && i != 410 && i != 416 && i != 500 && i != 503) {
            return false;
        }
        return true;
    }

    @Override // kx.mg
    public int y(int i) {
        int i5 = this.y;
        if (i5 == -1) {
            if (i == 7) {
                return 6;
            }
            return 3;
        }
        return i5;
    }

    @Override // kx.mg
    public /* synthetic */ void zn(long j2) {
        rz.y(this, j2);
    }

    public n(int i) {
        this.y = i;
    }
}
