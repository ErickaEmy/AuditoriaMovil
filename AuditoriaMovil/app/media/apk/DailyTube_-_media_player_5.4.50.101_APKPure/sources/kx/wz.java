package kx;

import androidx.annotation.Nullable;
import java.io.IOException;
/* loaded from: classes.dex */
public class wz extends IOException {
    public final int reason;

    public wz(int i) {
        this.reason = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r2 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean y(java.io.IOException r2) {
        /*
        L0:
            if (r2 == 0) goto L16
            boolean r0 = r2 instanceof kx.wz
            if (r0 == 0) goto L11
            r0 = r2
            kx.wz r0 = (kx.wz) r0
            int r0 = r0.reason
            r1 = 2008(0x7d8, float:2.814E-42)
            if (r0 != r1) goto L11
            r2 = 1
            return r2
        L11:
            java.lang.Throwable r2 = r2.getCause()
            goto L0
        L16:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kx.wz.y(java.io.IOException):boolean");
    }

    public wz(@Nullable Throwable th, int i) {
        super(th);
        this.reason = i;
    }

    public wz(@Nullable String str, int i) {
        super(str);
        this.reason = i;
    }

    public wz(@Nullable String str, @Nullable Throwable th, int i) {
        super(str, th);
        this.reason = i;
    }
}
