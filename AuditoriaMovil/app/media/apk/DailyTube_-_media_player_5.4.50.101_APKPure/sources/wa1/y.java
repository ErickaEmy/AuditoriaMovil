package wa1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class y {
    public static final <T> T n3(Intent intent, String key, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (Build.VERSION.SDK_INT >= 33) {
            return (T) intent.getParcelableExtra(key, clazz);
        }
        return (T) intent.getParcelableExtra(key);
    }

    public static final <T> T y(Bundle bundle, String key, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (Build.VERSION.SDK_INT >= 33) {
            return (T) bundle.getParcelable(key, clazz);
        }
        return (T) bundle.getParcelable(key);
    }
}
