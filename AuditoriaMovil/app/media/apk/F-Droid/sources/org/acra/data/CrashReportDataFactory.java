package org.acra.data;

import android.content.Context;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.builder.ReportBuilder;
import org.acra.collector.ApplicationStartupCollector;
import org.acra.collector.Collector;
import org.acra.collector.CollectorException;
import org.acra.config.CoreConfiguration;
import org.acra.log.ACRALog;
/* compiled from: CrashReportDataFactory.kt */
/* loaded from: classes2.dex */
public final class CrashReportDataFactory {
    private final List collectors;
    private final CoreConfiguration config;
    private final Context context;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collect$lambda$10$lambda$9(Collector collector, CrashReportDataFactory this$0, ReportBuilder builder, CrashReportData crashReportData) {
        Intrinsics.checkNotNullParameter(collector, "$collector");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(builder, "$builder");
        Intrinsics.checkNotNullParameter(crashReportData, "$crashReportData");
        try {
            if (ACRA.DEV_LOGGING) {
                ACRALog aCRALog = ACRA.log;
                String str = ACRA.LOG_TAG;
                String name = collector.getClass().getName();
                aCRALog.d(str, "Calling collector " + name);
            }
            collector.collect(this$0.context, this$0.config, builder, crashReportData);
            if (ACRA.DEV_LOGGING) {
                ACRALog aCRALog2 = ACRA.log;
                String str2 = ACRA.LOG_TAG;
                String name2 = collector.getClass().getName();
                aCRALog2.d(str2, "Collector " + name2 + " completed");
            }
        } catch (CollectorException e) {
            ACRA.log.w(ACRA.LOG_TAG, "", e);
        } catch (Throwable th) {
            ACRALog aCRALog3 = ACRA.log;
            String str3 = ACRA.LOG_TAG;
            String simpleName = collector.getClass().getSimpleName();
            aCRALog3.w(str3, "Error in collector " + simpleName, th);
        }
    }

    public CrashReportDataFactory(Context context, CoreConfiguration config) {
        List sortedWith;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(config.getPluginLoader().loadEnabled(config, Collector.class), new Comparator() { // from class: org.acra.data.CrashReportDataFactory$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                Collector.Order safeOrder;
                Collector.Order safeOrder2;
                int compareValues;
                safeOrder = CrashReportDataFactory.this.getSafeOrder((Collector) obj);
                safeOrder2 = CrashReportDataFactory.this.getSafeOrder((Collector) obj2);
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(safeOrder, safeOrder2);
                return compareValues;
            }
        });
        this.collectors = sortedWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collector.Order getSafeOrder(Collector collector) {
        try {
            return collector.getOrder();
        } catch (Exception unused) {
            return Collector.Order.NORMAL;
        }
    }

    public final CrashReportData createCrashData(ReportBuilder builder) {
        SortedMap sortedMap;
        Intrinsics.checkNotNullParameter(builder, "builder");
        ExecutorService newCachedThreadPool = this.config.getParallel() ? Executors.newCachedThreadPool() : Executors.newSingleThreadExecutor();
        CrashReportData crashReportData = new CrashReportData();
        List list = this.collectors;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Collector.Order safeOrder = getSafeOrder((Collector) obj);
            Object obj2 = linkedHashMap.get(safeOrder);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(safeOrder, obj2);
            }
            ((List) obj2).add(obj);
        }
        sortedMap = MapsKt__MapsJVMKt.toSortedMap(linkedHashMap);
        for (Map.Entry entry : sortedMap.entrySet()) {
            Collector.Order order = (Collector.Order) entry.getKey();
            List list2 = (List) entry.getValue();
            if (ACRA.DEV_LOGGING) {
                ACRALog aCRALog = ACRA.log;
                String str = ACRA.LOG_TAG;
                String name = order.name();
                aCRALog.d(str, "Starting collectors with priority " + name);
            }
            Intrinsics.checkNotNull(list2);
            Intrinsics.checkNotNull(newCachedThreadPool);
            collect(list2, newCachedThreadPool, builder, crashReportData);
            if (ACRA.DEV_LOGGING) {
                ACRALog aCRALog2 = ACRA.log;
                String str2 = ACRA.LOG_TAG;
                String name2 = order.name();
                aCRALog2.d(str2, "Finished collectors with priority " + name2);
            }
        }
        return crashReportData;
    }

    public final void collectStartUp() {
        for (Collector collector : this.collectors) {
            if (collector instanceof ApplicationStartupCollector) {
                try {
                    ((ApplicationStartupCollector) collector).collectApplicationStartUp(this.context, this.config);
                } catch (Throwable th) {
                    ACRALog aCRALog = ACRA.log;
                    String str = ACRA.LOG_TAG;
                    String simpleName = collector.getClass().getSimpleName();
                    aCRALog.w(str, simpleName + " failed to collect its startup data", th);
                }
            }
        }
    }

    private final void collect(List list, ExecutorService executorService, final ReportBuilder reportBuilder, final CrashReportData crashReportData) {
        int collectionSizeOrDefault;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList<Future> arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final Collector collector = (Collector) it.next();
            arrayList.add(executorService.submit(new Runnable() { // from class: org.acra.data.CrashReportDataFactory$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CrashReportDataFactory.collect$lambda$10$lambda$9(Collector.this, this, reportBuilder, crashReportData);
                }
            }));
        }
        for (Future future : arrayList) {
            while (!future.isDone()) {
                try {
                    future.get();
                } catch (InterruptedException unused) {
                } catch (ExecutionException unused2) {
                }
            }
        }
    }
}
