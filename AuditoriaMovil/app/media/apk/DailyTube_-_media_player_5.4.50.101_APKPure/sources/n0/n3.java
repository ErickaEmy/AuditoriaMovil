package n0;

import android.content.Context;
import androidx.annotation.NonNull;
import j0.zn;
import java.io.File;
/* loaded from: classes.dex */
public class n3 {
    public static final zn y = new zn("SplitInstallHelper");

    public static void y(@NonNull Context context, @NonNull String str) throws UnsatisfiedLinkError {
        synchronized (hw.class) {
            try {
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError e2) {
                String str2 = context.getApplicationInfo().nativeLibraryDir;
                String mapLibraryName = System.mapLibraryName(str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(mapLibraryName).length());
                sb.append(str2);
                sb.append("/");
                sb.append(mapLibraryName);
                String sb2 = sb.toString();
                if (new File(sb2).exists()) {
                    System.load(sb2);
                } else {
                    throw e2;
                }
            }
        }
    }
}
