package u0;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class a {
    public static final a y = new a();

    public static final void n3(Cursor cursor, ContentResolver cr2, List<? extends Uri> uris) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(cr2, "cr");
        Intrinsics.checkNotNullParameter(uris, "uris");
        cursor.setNotificationUris(cr2, uris);
    }

    public static final List<Uri> y(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        List<Uri> notificationUris = cursor.getNotificationUris();
        Intrinsics.checkNotNull(notificationUris);
        return notificationUris;
    }
}
