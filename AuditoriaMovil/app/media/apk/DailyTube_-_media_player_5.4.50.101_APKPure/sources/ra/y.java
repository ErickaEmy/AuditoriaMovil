package ra;

import android.os.Build;
import android.os.ext.SdkExtensions;
/* loaded from: classes.dex */
public final class y {
    public static final y y = new y();

    /* renamed from: ra.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0194y {
        public static final C0194y y = new C0194y();

        public final int y() {
            return SdkExtensions.getExtensionVersion(1000000);
        }
    }

    public final int y() {
        if (Build.VERSION.SDK_INT >= 30) {
            return C0194y.y.y();
        }
        return 0;
    }
}
