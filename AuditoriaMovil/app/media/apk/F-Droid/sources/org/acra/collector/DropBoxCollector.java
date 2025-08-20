package org.acra.collector;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.DropBoxManager;
import ch.qos.logback.core.CoreConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.collector.Collector;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.log.ACRALog;
import org.acra.plugins.Plugin;
import org.acra.prefs.SharedPreferencesFactory;
import org.acra.util.SystemServices;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: DropBoxCollector.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lorg/acra/collector/DropBoxCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "order", "Lorg/acra/collector/Collector$Order;", "getOrder", "()Lorg/acra/collector/Collector$Order;", "collect", "", "reportField", "Lorg/acra/ReportField;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", "target", "Lorg/acra/data/CrashReportData;", "shouldCollect", "", "Companion", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DropBoxCollector extends BaseReportFieldCollector {
    public static final Companion Companion = new Companion(null);
    private static final String[] SYSTEM_TAGS = {"system_app_anr", "system_app_wtf", "system_app_crash", "system_server_anr", "system_server_wtf", "system_server_crash", "BATTERY_DISCHARGE_INFO", "SYSTEM_RECOVERY_LOG", "SYSTEM_BOOT", "SYSTEM_LAST_KMSG", "APANIC_CONSOLE", "APANIC_THREADS", "SYSTEM_RESTART", "SYSTEM_TOMBSTONE", "data_app_strictmode"};
    private final SimpleDateFormat dateFormat;

    /* compiled from: DropBoxCollector.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public DropBoxCollector() {
        super(ReportField.DROPBOX);
        this.dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.getDefault());
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector
    public Collector.Order getOrder() {
        return Collector.Order.FIRST;
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    @SuppressLint({"MissingPermission"})
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) throws Exception {
        List list;
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        DropBoxManager dropBoxManager = SystemServices.getDropBoxManager(context);
        Calendar calendar = Calendar.getInstance();
        calendar.roll(12, -config.getDropboxCollectionMinutes());
        long timeInMillis = calendar.getTimeInMillis();
        this.dateFormat.format(calendar.getTime());
        ArrayList<String> arrayList = new ArrayList();
        if (config.getIncludeDropBoxSystemTags()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, SYSTEM_TAGS);
        }
        list = CollectionsKt___CollectionsKt.toList(config.getAdditionalDropBoxTags());
        if (!list.isEmpty()) {
            arrayList.addAll(list);
        }
        if (!arrayList.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (String str : arrayList) {
                StringBuilder sb = new StringBuilder();
                DropBoxManager.Entry nextEntry = dropBoxManager.getNextEntry(str, timeInMillis);
                if (nextEntry == null) {
                    sb.append("Nothing.");
                    sb.append('\n');
                } else {
                    while (nextEntry != null) {
                        long timeMillis = nextEntry.getTimeMillis();
                        calendar.setTimeInMillis(timeMillis);
                        sb.append('@');
                        sb.append(this.dateFormat.format(calendar.getTime()));
                        sb.append('\n');
                        String text = nextEntry.getText(500);
                        if (text != null) {
                            sb.append("Text: ");
                            sb.append(text);
                            sb.append('\n');
                        } else {
                            sb.append("Not Text!");
                            sb.append('\n');
                        }
                        nextEntry.close();
                        nextEntry = dropBoxManager.getNextEntry(str, timeMillis);
                    }
                    try {
                        jSONObject.put(str, sb.toString());
                    } catch (JSONException e) {
                        ACRALog aCRALog = ACRA.log;
                        String str2 = ACRA.LOG_TAG;
                        aCRALog.w(str2, "Failed to collect data for tag " + str, e);
                    }
                }
            }
            target.put(ReportField.DROPBOX, jSONObject);
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public boolean shouldCollect(Context context, CoreConfiguration config, ReportField collect, ReportBuilder reportBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(collect, "collect");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        return super.shouldCollect(context, config, collect, reportBuilder) && new SharedPreferencesFactory(context, config).create().getBoolean("acra.syslog.enable", true);
    }
}
