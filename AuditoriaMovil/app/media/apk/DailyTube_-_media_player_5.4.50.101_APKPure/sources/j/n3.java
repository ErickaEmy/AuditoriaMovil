package j;

import android.os.Build;
/* loaded from: classes.dex */
public interface n3 {
    @Deprecated

    /* renamed from: wz  reason: collision with root package name */
    public static final boolean f9315wz;

    static {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 27) {
            z2 = true;
        } else {
            z2 = false;
        }
        f9315wz = z2;
    }
}
