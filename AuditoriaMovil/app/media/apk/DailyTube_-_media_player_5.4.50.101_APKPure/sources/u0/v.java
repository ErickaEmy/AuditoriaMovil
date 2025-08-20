package u0;

import android.database.Cursor;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class v {
    public static final v y = new v();

    public static final void y(Cursor cursor, Bundle extras) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(extras, "extras");
        cursor.setExtras(extras);
    }
}
