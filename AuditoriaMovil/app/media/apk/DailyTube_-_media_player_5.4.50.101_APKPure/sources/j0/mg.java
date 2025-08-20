package j0;

import java.io.File;
import java.util.Set;
/* loaded from: classes.dex */
public final class mg implements x4 {
    @Override // j0.x4
    public final void n3(ClassLoader classLoader, Set set) {
        rz.gv(classLoader, set);
    }

    @Override // j0.x4
    public final boolean y(ClassLoader classLoader, File file, File file2, boolean z2) {
        return rz.v(classLoader, file, file2, z2, new n(), "zip", new c());
    }
}
