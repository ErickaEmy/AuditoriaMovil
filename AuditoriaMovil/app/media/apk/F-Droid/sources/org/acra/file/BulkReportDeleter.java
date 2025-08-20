package org.acra.file;

import android.content.Context;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.log.ACRALog;
/* compiled from: BulkReportDeleter.kt */
/* loaded from: classes2.dex */
public final class BulkReportDeleter {
    private final ReportLocator reportLocator;

    public BulkReportDeleter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.reportLocator = new ReportLocator(context);
    }

    public final void deleteReports(boolean z, int i) {
        List sortedWith;
        sortedWith = ArraysKt___ArraysKt.sortedWith(z ? this.reportLocator.getApprovedReports() : this.reportLocator.getUnapprovedReports(), new Comparator() { // from class: org.acra.file.BulkReportDeleter$deleteReports$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((File) obj).lastModified()), Long.valueOf(((File) obj2).lastModified()));
                return compareValues;
            }
        });
        int size = sortedWith.size() - i;
        for (int i2 = 0; i2 < size; i2++) {
            if (!((File) sortedWith.get(i2)).delete()) {
                ACRALog aCRALog = ACRA.log;
                String str = ACRA.LOG_TAG;
                Object obj = sortedWith.get(i2);
                aCRALog.w(str, "Could not delete report : " + obj);
            }
        }
    }
}
