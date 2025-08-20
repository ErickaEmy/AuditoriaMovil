package l;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;
@SuppressLint({"AddedAbstractMethod"})
/* loaded from: classes.dex */
public abstract class r {
    @NonNull
    @Deprecated
    public static r a() {
        gq.c5 wz2 = gq.c5.wz();
        if (wz2 != null) {
            return wz2;
        }
        throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
    }

    @NonNull
    public static r fb(@NonNull Context context) {
        return gq.c5.xc(context);
    }

    public static void s(@NonNull Context context, @NonNull androidx.work.y yVar) {
        gq.c5.s(context, yVar);
    }

    @NonNull
    public final wz gv(@NonNull x4 x4Var) {
        return zn(Collections.singletonList(x4Var));
    }

    @NonNull
    public abstract wz n3(@NonNull String str);

    @NonNull
    public abstract wz v(@NonNull String str, @NonNull gv gvVar, @NonNull w wVar);

    @NonNull
    public abstract wz y(@NonNull String str);

    @NonNull
    public abstract wz zn(@NonNull List<? extends x4> list);
}
