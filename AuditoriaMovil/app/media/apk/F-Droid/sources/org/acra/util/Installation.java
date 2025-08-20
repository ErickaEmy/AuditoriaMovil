package org.acra.util;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.log.ACRALog;
/* compiled from: Installation.kt */
/* loaded from: classes2.dex */
public final class Installation {
    public static final Installation INSTANCE = new Installation();

    private Installation() {
    }

    public static final synchronized String id(Context context) {
        String str;
        synchronized (Installation.class) {
            try {
                Intrinsics.checkNotNullParameter(context, "context");
                File file = new File(context.getFilesDir(), "ACRA-INSTALLATION");
                try {
                    if (!file.exists()) {
                        String uuid = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                        FilesKt__FileReadWriteKt.writeText$default(file, uuid, null, 2, null);
                    }
                    str = FilesKt__FileReadWriteKt.readText$default(file, null, 1, null);
                } catch (IOException e) {
                    ACRALog aCRALog = ACRA.log;
                    String str2 = ACRA.LOG_TAG;
                    String packageName = context.getPackageName();
                    aCRALog.w(str2, "Couldn't retrieve InstallationId for " + packageName, e);
                    str = "Couldn't retrieve InstallationId";
                } catch (RuntimeException e2) {
                    ACRALog aCRALog2 = ACRA.log;
                    String str3 = ACRA.LOG_TAG;
                    String packageName2 = context.getPackageName();
                    aCRALog2.w(str3, "Couldn't retrieve InstallationId for " + packageName2, e2);
                    str = "Couldn't retrieve InstallationId";
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
