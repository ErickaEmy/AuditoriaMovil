package u0;

import android.app.ActivityManager;
import android.database.Cursor;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class zn {
    public static final zn y = new zn();

    public static final boolean n3(ActivityManager activityManager) {
        Intrinsics.checkNotNullParameter(activityManager, "activityManager");
        return activityManager.isLowRamDevice();
    }

    public static final Uri y(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Uri notificationUri = cursor.getNotificationUri();
        Intrinsics.checkNotNullExpressionValue(notificationUri, "cursor.notificationUri");
        return notificationUri;
    }
}
