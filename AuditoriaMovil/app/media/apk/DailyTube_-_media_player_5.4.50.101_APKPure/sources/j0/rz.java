package j0;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class rz implements x4 {
    public static void gv(ClassLoader classLoader, Set set) {
        if (set.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String valueOf = String.valueOf(file.getParentFile().getAbsolutePath());
            if (valueOf.length() != 0) {
                "Adding native library parent directory: ".concat(valueOf);
            }
            hashSet.add(file.getParentFile());
        }
        qn y = j.y(zn(classLoader), "nativeLibraryDirectories", File.class);
        hashSet.removeAll(Arrays.asList((File[]) y.y()));
        synchronized (n0.hw.class) {
            hashSet.size();
            y.v(hashSet);
        }
    }

    public static boolean v(ClassLoader classLoader, File file, File file2, boolean z2, fh fhVar, String str, d0 d0Var) {
        String str2;
        ArrayList arrayList = new ArrayList();
        Object zn2 = zn(classLoader);
        qn y = j.y(zn2, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) y.y());
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : asList) {
            arrayList2.add((File) j.n3(obj, str, File.class).y());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (!z2 && !d0Var.y(zn2, file2, file)) {
            String valueOf = String.valueOf(file2.getPath());
            if (valueOf.length() != 0) {
                str2 = "Should be optimized ".concat(valueOf);
            } else {
                str2 = new String("Should be optimized ");
            }
            Log.w("SplitCompat", str2);
            return false;
        }
        y.gv(Arrays.asList(fhVar.y(zn2, new ArrayList(Collections.singleton(file2)), file, arrayList)));
        if (arrayList.isEmpty()) {
            return true;
        }
        j5 j5Var = new j5("DexPathList.makeDexElement failed");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Log.e("SplitCompat", "DexPathList.makeDexElement failed", (IOException) arrayList.get(i));
        }
        j.y(zn2, "dexElementsSuppressedExceptions", IOException.class).gv(arrayList);
        throw j5Var;
    }

    public static Object zn(ClassLoader classLoader) {
        return j.n3(classLoader, "pathList", Object.class).y();
    }

    @Override // j0.x4
    public final void n3(ClassLoader classLoader, Set set) {
        gv(classLoader, set);
    }

    @Override // j0.x4
    public final boolean y(ClassLoader classLoader, File file, File file2, boolean z2) {
        return v(classLoader, file, file2, z2, new n(), "zip", new c());
    }
}
