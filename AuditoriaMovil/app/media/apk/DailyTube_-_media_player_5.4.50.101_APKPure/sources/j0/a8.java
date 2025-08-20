package j0;

import java.io.File;
import java.util.Set;
/* loaded from: classes.dex */
public final class a8 implements x4 {
    @Override // j0.x4
    public final void n3(ClassLoader classLoader, Set set) {
        ej.zn(classLoader, set, new d());
    }

    @Override // j0.x4
    public final boolean y(ClassLoader classLoader, File file, File file2, boolean z2) {
        return ej.gv(classLoader, file, file2, z2, "zip");
    }
}
