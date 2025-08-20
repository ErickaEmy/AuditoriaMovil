package j0;

import android.content.Context;
/* loaded from: classes.dex */
public final class y5 {
    public static Context y(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            return applicationContext;
        }
        return context;
    }
}
