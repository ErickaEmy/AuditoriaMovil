package org.acra.collector;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
import org.json.JSONObject;
/* compiled from: SettingsCollector.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0012¨\u0006\u0018"}, d2 = {"Lorg/acra/collector/SettingsCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "collect", "", "reportField", "Lorg/acra/ReportField;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", "target", "Lorg/acra/data/CrashReportData;", "collectSettings", "Lorg/json/JSONObject;", "settings", "Ljava/lang/Class;", "isAuthorized", "", Action.KEY_ATTRIBUTE, "Ljava/lang/reflect/Field;", "Companion", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class SettingsCollector extends BaseReportFieldCollector {
    public static final Companion Companion = new Companion(null);
    private static final String ERROR = "Error: ";

    /* compiled from: SettingsCollector.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsCollector.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReportField.values().length];
            try {
                iArr[ReportField.SETTINGS_SYSTEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReportField.SETTINGS_SECURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReportField.SETTINGS_GLOBAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public SettingsCollector() {
        super(ReportField.SETTINGS_SYSTEM, ReportField.SETTINGS_SECURE, ReportField.SETTINGS_GLOBAL);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) throws Exception {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        int i = WhenMappings.$EnumSwitchMapping$0[reportField.ordinal()];
        if (i == 1) {
            target.put(ReportField.SETTINGS_SYSTEM, collectSettings(context, config, Settings.System.class));
        } else if (i == 2) {
            target.put(ReportField.SETTINGS_SECURE, collectSettings(context, config, Settings.Secure.class));
        } else if (i == 3) {
            target.put(ReportField.SETTINGS_GLOBAL, collectSettings(context, config, Settings.Global.class));
        } else {
            throw new IllegalArgumentException();
        }
    }

    private JSONObject collectSettings(Context context, CoreConfiguration coreConfiguration, Class<?> cls) throws NoSuchMethodException {
        JSONObject jSONObject = new JSONObject();
        Field[] fields = cls.getFields();
        Method method = cls.getMethod("getString", ContentResolver.class, String.class);
        Intrinsics.checkNotNull(fields);
        for (Field field : fields) {
            if (!field.isAnnotationPresent(Deprecated.class) && Intrinsics.areEqual(field.getType(), String.class) && isAuthorized(coreConfiguration, field)) {
                try {
                    Object invoke = method.invoke(null, context.getContentResolver(), field.get(null));
                    if (invoke != null) {
                        jSONObject.put(field.getName(), invoke);
                    }
                } catch (Exception e) {
                    ACRA.log.w(ACRA.LOG_TAG, ERROR, e);
                }
            }
        }
        return jSONObject;
    }

    private boolean isAuthorized(CoreConfiguration coreConfiguration, Field field) {
        boolean startsWith$default;
        if (field != null) {
            String name = field.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "WIFI_AP", false, 2, null);
            if (!startsWith$default) {
                for (String str : coreConfiguration.getExcludeMatchingSettingsKeys()) {
                    String name2 = field.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    if (new Regex(str).matches(name2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
