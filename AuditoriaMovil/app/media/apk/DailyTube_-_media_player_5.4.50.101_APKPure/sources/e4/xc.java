package e4;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import m1.ne;
/* loaded from: classes.dex */
public final class xc {
    public static boolean gv(tl tlVar, byte[] bArr, int i, int i5) throws IOException {
        try {
            tlVar.readFully(bArr, i, i5);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean n3(tl tlVar, byte[] bArr, int i, int i5, boolean z2) throws IOException {
        try {
            return tlVar.v(bArr, i, i5, z2);
        } catch (EOFException e2) {
            if (z2) {
                return false;
            }
            throw e2;
        }
    }

    public static boolean v(tl tlVar, int i) throws IOException {
        try {
            tlVar.p(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static void y(boolean z2, @Nullable String str) throws ne {
        if (z2) {
            return;
        }
        throw ne.y(str, null);
    }

    public static int zn(tl tlVar, byte[] bArr, int i, int i5) throws IOException {
        int i6 = 0;
        while (i6 < i5) {
            int w4 = tlVar.w(bArr, i + i6, i5 - i6);
            if (w4 == -1) {
                break;
            }
            i6 += w4;
        }
        return i6;
    }
}
