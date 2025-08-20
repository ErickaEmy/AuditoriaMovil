package org.acra.startup;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.CoreConfiguration;
import org.acra.plugins.Plugin;
/* compiled from: UnapprovedStartupProcessor.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lorg/acra/startup/UnapprovedStartupProcessor;", "Lorg/acra/startup/StartupProcessor;", "()V", "processReports", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reports", "", "Lorg/acra/startup/Report;", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class UnapprovedStartupProcessor implements StartupProcessor {
    @Override // org.acra.startup.StartupProcessor, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    @Override // org.acra.startup.StartupProcessor
    public void processReports(Context context, CoreConfiguration config, List<Report> reports) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reports, "reports");
        if (config.getDeleteUnapprovedReportsOnApplicationStart()) {
            ArrayList arrayList = new ArrayList();
            for (Report report : reports) {
                if (!report.getApproved()) {
                    arrayList.add(report);
                }
            }
            if (!arrayList.isEmpty()) {
                if (arrayList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator() { // from class: org.acra.startup.UnapprovedStartupProcessor$processReports$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            int compareValues;
                            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((Report) obj).getFile().lastModified()), Long.valueOf(((Report) obj2).getFile().lastModified()));
                            return compareValues;
                        }
                    });
                }
                int size = arrayList.size() - 1;
                for (int i = 0; i < size; i++) {
                    ((Report) arrayList.get(i)).setDelete(true);
                }
                ((Report) arrayList.get(arrayList.size() - 1)).setApprove(true);
            }
        }
    }
}
