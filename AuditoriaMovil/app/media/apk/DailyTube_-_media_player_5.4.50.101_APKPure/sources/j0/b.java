package j0;

import android.util.Log;
import java.io.File;
/* loaded from: classes.dex */
public final class b implements d0 {
    @Override // j0.d0
    public final boolean y(Object obj, File file, File file2) {
        try {
            if (((Boolean) j.a(Class.forName("dalvik.system.DexFile"), "isDexOptNeeded", Boolean.class, String.class, file.getPath())).booleanValue()) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
            return false;
        }
    }
}
