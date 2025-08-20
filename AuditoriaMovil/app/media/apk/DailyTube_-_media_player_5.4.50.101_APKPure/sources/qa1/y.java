package qa1;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class y {
    public static final y y = new y();

    public static final int n3() {
        return n3.y();
    }

    public static final Application y() {
        Application zn2 = n3.zn();
        if (zn2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            return null;
        }
        return zn2;
    }

    public static final String zn() {
        String n32 = n3.n3();
        if (n32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appVersionNameHolder");
            return null;
        }
        return n32;
    }
}
