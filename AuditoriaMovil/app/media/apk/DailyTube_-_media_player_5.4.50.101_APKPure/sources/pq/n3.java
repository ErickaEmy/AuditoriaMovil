package pq;

import android.os.Trace;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class n3 {
    public static void n3() {
        Trace.endSection();
    }

    public static void y(@NonNull String str) {
        Trace.beginSection(str);
    }
}
