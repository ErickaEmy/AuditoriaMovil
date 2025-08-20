package e4;

import androidx.annotation.Nullable;
import e4.ta;
import java.io.EOFException;
import java.io.IOException;
import m1.m;
/* loaded from: classes.dex */
public final class f implements ta {
    public final byte[] y = new byte[4096];

    @Override // e4.ta
    public void a(v5.rz rzVar, int i, int i5) {
        rzVar.ut(i);
    }

    @Override // e4.ta
    public /* synthetic */ int n3(kx.c5 c5Var, int i, boolean z2) {
        return mg.y(this, c5Var, i, z2);
    }

    @Override // e4.ta
    public int y(kx.c5 c5Var, int i, boolean z2, int i5) throws IOException {
        int read = c5Var.read(this.y, 0, Math.min(this.y.length, i));
        if (read == -1) {
            if (z2) {
                return -1;
            }
            throw new EOFException();
        }
        return read;
    }

    @Override // e4.ta
    public /* synthetic */ void zn(v5.rz rzVar, int i) {
        mg.n3(this, rzVar, i);
    }

    @Override // e4.ta
    public void v(m mVar) {
    }

    @Override // e4.ta
    public void gv(long j2, int i, int i5, int i6, @Nullable ta.y yVar) {
    }
}
