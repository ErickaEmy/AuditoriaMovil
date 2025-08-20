package org.acra.interaction;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.log.ACRALog;
/* compiled from: ReportInteractionExecutor.kt */
/* loaded from: classes2.dex */
public final class ReportInteractionExecutor {
    private final CoreConfiguration config;
    private final Context context;
    private final List reportInteractions;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean performInteractions$lambda$2$lambda$1(ReportInteraction it, ReportInteractionExecutor this$0, File reportFile) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportFile, "$reportFile");
        if (ACRA.DEV_LOGGING) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            String name = it.getClass().getName();
            aCRALog.d(str, "Calling ReportInteraction of class " + name);
        }
        return Boolean.valueOf(it.performInteraction(this$0.context, this$0.config, reportFile));
    }

    public ReportInteractionExecutor(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.reportInteractions = config.getPluginLoader().loadEnabled(config, ReportInteraction.class);
    }

    public final boolean hasInteractions() {
        return !this.reportInteractions.isEmpty();
    }

    public final boolean performInteractions(final File reportFile) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(reportFile, "reportFile");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        List<ReportInteraction> list = this.reportInteractions;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList<Future> arrayList = new ArrayList(collectionSizeOrDefault);
        for (final ReportInteraction reportInteraction : list) {
            arrayList.add(newCachedThreadPool.submit(new Callable() { // from class: org.acra.interaction.ReportInteractionExecutor$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean performInteractions$lambda$2$lambda$1;
                    performInteractions$lambda$2$lambda$1 = ReportInteractionExecutor.performInteractions$lambda$2$lambda$1(ReportInteraction.this, this, reportFile);
                    return performInteractions$lambda$2$lambda$1;
                }
            }));
        }
        boolean z = true;
        for (Future future : arrayList) {
            do {
                try {
                    Object obj = future.get();
                    Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                    z &= ((Boolean) obj).booleanValue();
                } catch (InterruptedException unused) {
                } catch (ExecutionException e) {
                    ACRA.log.w(ACRA.LOG_TAG, "Report interaction threw exception, will be ignored.", e);
                }
            } while (!future.isDone());
        }
        return z;
    }
}
