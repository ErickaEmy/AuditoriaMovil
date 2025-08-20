package m0;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.StrictMode;
import android.util.Log;
import j0.j;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public final class n3 {
    public final a y;

    public n3(a aVar) {
        this.y = aVar;
    }

    public static final int zn(AssetManager assetManager, File file) {
        return ((Integer) j.gv(assetManager, "addAssetPath", Integer.class, String.class, file.getPath())).intValue();
    }

    public final synchronized boolean n3(Context context, Set set) {
        StrictMode.ThreadPolicy threadPolicy;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.allowThreadDiskReads();
                StrictMode.allowThreadDiskWrites();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            threadPolicy = null;
        }
        try {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(this.y.fb((String) it.next()));
            }
            y(context, hashSet);
            if (threadPolicy != null) {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error installing additional splits", e2);
            if (threadPolicy != null) {
                StrictMode.setThreadPolicy(threadPolicy);
                return false;
            }
            return false;
        }
        return true;
    }

    public final synchronized void y(Context context, Set set) {
        AssetManager assets = context.getAssets();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zn(assets, (File) it.next());
        }
    }
}
