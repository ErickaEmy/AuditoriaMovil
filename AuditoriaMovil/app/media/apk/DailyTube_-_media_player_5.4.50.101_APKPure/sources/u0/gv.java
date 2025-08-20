package u0;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class gv {
    public static final gv y = new gv();

    public static final File y(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        Intrinsics.checkNotNullExpressionValue(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
