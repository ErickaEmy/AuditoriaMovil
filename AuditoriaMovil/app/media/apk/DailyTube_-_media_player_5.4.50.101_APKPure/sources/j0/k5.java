package j0;

import java.io.File;
import java.util.Set;
/* loaded from: classes.dex */
public final class k5 implements x4 {
    public static boolean gv(ClassLoader classLoader, File file, File file2, boolean z2) {
        return rz.v(classLoader, file, file2, z2, new ta(), "path", new b());
    }

    public static void zn(ClassLoader classLoader, Set set) {
        ej.zn(classLoader, set, new x());
    }

    @Override // j0.x4
    public final void n3(ClassLoader classLoader, Set set) {
        zn(classLoader, set);
    }

    @Override // j0.x4
    public final boolean y(ClassLoader classLoader, File file, File file2, boolean z2) {
        return gv(classLoader, file, file2, z2);
    }
}
