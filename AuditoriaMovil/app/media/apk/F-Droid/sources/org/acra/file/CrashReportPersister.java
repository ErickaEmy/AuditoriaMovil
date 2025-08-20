package org.acra.file;

import java.io.File;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.data.CrashReportData;
/* compiled from: CrashReportPersister.kt */
/* loaded from: classes2.dex */
public final class CrashReportPersister {
    public final CrashReportData load(File file) {
        String readText$default;
        Intrinsics.checkNotNullParameter(file, "file");
        readText$default = FilesKt__FileReadWriteKt.readText$default(file, null, 1, null);
        return new CrashReportData(readText$default);
    }

    public final void store(CrashReportData crashData, File file) {
        Intrinsics.checkNotNullParameter(crashData, "crashData");
        Intrinsics.checkNotNullParameter(file, "file");
        FilesKt__FileReadWriteKt.writeText$default(file, crashData.toJSON(), null, 2, null);
    }
}
