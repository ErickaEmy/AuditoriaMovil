package j0;

import android.os.Build;
/* loaded from: classes.dex */
public final class f3 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static x4 y() {
        switch (Build.VERSION.SDK_INT) {
            case 21:
                return new rz();
            case 22:
                return new mg();
            case 23:
                return new ej();
            case 24:
                return new ud();
            case 25:
                return new a8();
            case 26:
                return new k5();
            case 27:
                if (Build.VERSION.PREVIEW_SDK_INT == 0) {
                    return new yt();
                }
                break;
        }
        return new hw();
    }
}
