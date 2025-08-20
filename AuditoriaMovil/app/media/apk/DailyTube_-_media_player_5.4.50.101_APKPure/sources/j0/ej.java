package j0;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class ej implements x4 {
    public static boolean gv(ClassLoader classLoader, File file, File file2, boolean z2, String str) {
        return rz.v(classLoader, file, file2, z2, new ta(), "zip", new c());
    }

    public static void zn(ClassLoader classLoader, Set set, z6 z6Var) {
        if (set.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((File) it.next()).getParentFile());
        }
        Object zn2 = rz.zn(classLoader);
        o n32 = j.n3(zn2, "nativeLibraryDirectories", List.class);
        synchronized (n0.hw.class) {
            ArrayList arrayList = new ArrayList((Collection) n32.y());
            hashSet.removeAll(arrayList);
            arrayList.addAll(hashSet);
            n32.zn(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Object[] y = z6Var.y(zn2, new ArrayList(hashSet), null, arrayList2);
        if (!arrayList2.isEmpty()) {
            j5 j5Var = new j5("Error in makePathElements");
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                IOException iOException = (IOException) arrayList2.get(i);
            }
            throw j5Var;
        }
        synchronized (n0.hw.class) {
            j.y(zn2, "nativeLibraryPathElements", Object.class).v(Arrays.asList(y));
        }
    }

    @Override // j0.x4
    public final void n3(ClassLoader classLoader, Set set) {
        zn(classLoader, set, new d());
    }

    @Override // j0.x4
    public final boolean y(ClassLoader classLoader, File file, File file2, boolean z2) {
        return gv(classLoader, file, file2, z2, "zip");
    }
}
