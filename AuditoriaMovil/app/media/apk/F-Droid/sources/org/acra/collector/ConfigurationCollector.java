package org.acra.collector;

import android.content.Context;
import android.content.res.Configuration;
import android.util.SparseArray;
import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.log.ACRALog;
import org.acra.plugins.Plugin;
import org.bouncycastle.i18n.TextBundle;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ConfigurationCollector.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0002%&B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\n\u001a\u00020\u000bH\u0012J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0012J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0012J2\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0 2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0012J\u001a\u0010$\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0 H\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0092\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lorg/acra/collector/ConfigurationCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "Lorg/acra/collector/ApplicationStartupCollector;", "()V", "initialConfiguration", "Lorg/json/JSONObject;", "activeFlags", "", "valueNames", "Landroid/util/SparseArray;", "bitfield", "", "collect", "", "reportField", "Lorg/acra/ReportField;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", "target", "Lorg/acra/data/CrashReportData;", "collectApplicationStartUp", "collectConfiguration", "configToJson", "conf", "Landroid/content/res/Configuration;", "getFieldValueName", "", "valueArrays", "", "Lorg/acra/collector/ConfigurationCollector$Prefix;", "f", "Ljava/lang/reflect/Field;", "getValueArrays", "Companion", "Prefix", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class ConfigurationCollector extends BaseReportFieldCollector implements ApplicationStartupCollector {
    public static final Companion Companion = new Companion(null);
    private static final String FIELD_MCC = "mcc";
    private static final String FIELD_MNC = "mnc";
    private static final String FIELD_SCREENLAYOUT = "screenLayout";
    private static final String FIELD_UIMODE = "uiMode";
    private static final String SUFFIX_MASK = "_MASK";
    private JSONObject initialConfiguration;

    /* compiled from: ConfigurationCollector.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ConfigurationCollector.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReportField.values().length];
            try {
                iArr[ReportField.INITIAL_CONFIGURATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReportField.CRASH_CONFIGURATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public ConfigurationCollector() {
        super(ReportField.INITIAL_CONFIGURATION, ReportField.CRASH_CONFIGURATION);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        int i = WhenMappings.$EnumSwitchMapping$0[reportField.ordinal()];
        if (i == 1) {
            target.put(ReportField.INITIAL_CONFIGURATION, this.initialConfiguration);
        } else if (i == 2) {
            target.put(ReportField.CRASH_CONFIGURATION, collectConfiguration(context));
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // org.acra.collector.ApplicationStartupCollector
    public void collectApplicationStartUp(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.getReportContent().contains(ReportField.INITIAL_CONFIGURATION)) {
            this.initialConfiguration = collectConfiguration(context);
        }
    }

    private JSONObject configToJson(Configuration configuration) {
        JSONObject jSONObject = new JSONObject();
        Map<Prefix, SparseArray<String>> valueArrays = getValueArrays();
        Field[] fields = configuration.getClass().getFields();
        Intrinsics.checkNotNullExpressionValue(fields, "getFields(...)");
        for (Field field : fields) {
            try {
                if (!Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    try {
                        if (Intrinsics.areEqual(field.getType(), Integer.TYPE)) {
                            Intrinsics.checkNotNull(field);
                            jSONObject.put(name, getFieldValueName(valueArrays, configuration, field));
                        } else if (field.get(configuration) != null) {
                            jSONObject.put(name, field.get(configuration));
                        }
                    } catch (JSONException e) {
                        ACRA.log.w(ACRA.LOG_TAG, "Could not collect configuration field " + name, e);
                    }
                }
            } catch (IllegalAccessException e2) {
                ACRA.log.e(ACRA.LOG_TAG, "Error while inspecting device configuration: ", e2);
            } catch (IllegalArgumentException e3) {
                ACRA.log.e(ACRA.LOG_TAG, "Error while inspecting device configuration: ", e3);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0116 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<org.acra.collector.ConfigurationCollector.Prefix, android.util.SparseArray<java.lang.String>> getValueArrays() {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.acra.collector.ConfigurationCollector.getValueArrays():java.util.Map");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r0.equals(org.acra.collector.ConfigurationCollector.FIELD_MCC) != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        return java.lang.Integer.valueOf(r11.getInt(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (r0.equals(org.acra.collector.ConfigurationCollector.FIELD_MNC) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object getFieldValueName(java.util.Map<org.acra.collector.ConfigurationCollector.Prefix, ? extends android.util.SparseArray<java.lang.String>> r9, android.content.res.Configuration r10, java.lang.reflect.Field r11) throws java.lang.IllegalAccessException {
        /*
            r8 = this;
            java.lang.String r0 = r11.getName()
            if (r0 == 0) goto L5e
            int r1 = r0.hashCode()
            switch(r1) {
                case -1896438090: goto L44;
                case -845983145: goto L29;
                case 107917: goto L17;
                case 108258: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L5e
        Le:
            java.lang.String r1 = "mnc"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L1f
            goto L5e
        L17:
            java.lang.String r1 = "mcc"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L5e
        L1f:
            int r9 = r11.getInt(r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto Lb5
        L29:
            java.lang.String r1 = "uiMode"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L32
            goto L5e
        L32:
            org.acra.collector.ConfigurationCollector$Prefix r0 = org.acra.collector.ConfigurationCollector.Prefix.UI_MODE
            java.lang.Object r9 = kotlin.collections.MapsKt.getValue(r9, r0)
            android.util.SparseArray r9 = (android.util.SparseArray) r9
            int r10 = r11.getInt(r10)
            java.lang.String r9 = r8.activeFlags(r9, r10)
            goto Lb5
        L44:
            java.lang.String r1 = "screenLayout"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L4d
            goto L5e
        L4d:
            org.acra.collector.ConfigurationCollector$Prefix r0 = org.acra.collector.ConfigurationCollector.Prefix.SCREENLAYOUT
            java.lang.Object r9 = kotlin.collections.MapsKt.getValue(r9, r0)
            android.util.SparseArray r9 = (android.util.SparseArray) r9
            int r10 = r11.getInt(r10)
            java.lang.String r9 = r8.activeFlags(r9, r10)
            goto Lb5
        L5e:
            org.acra.collector.ConfigurationCollector$Prefix[] r1 = org.acra.collector.ConfigurationCollector.Prefix.values()
            int r2 = r1.length
            r3 = 0
        L64:
            if (r3 >= r2) goto L95
            r4 = r1[r3]
            java.lang.String r5 = r4.getText()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r6 = r0.toUpperCase(r6)
            java.lang.String r7 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = "_"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L92
            goto L96
        L92:
            int r3 = r3 + 1
            goto L64
        L95:
            r4 = 0
        L96:
            if (r4 == 0) goto Lb6
            java.lang.Object r9 = kotlin.collections.MapsKt.getValue(r9, r4)
            android.util.SparseArray r9 = (android.util.SparseArray) r9
            if (r9 != 0) goto La1
            goto Lb6
        La1:
            int r0 = r11.getInt(r10)
            java.lang.Object r9 = r9.get(r0)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto Lb5
            int r9 = r11.getInt(r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
        Lb5:
            return r9
        Lb6:
            int r9 = r11.getInt(r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.acra.collector.ConfigurationCollector.getFieldValueName(java.util.Map, android.content.res.Configuration, java.lang.reflect.Field):java.lang.Object");
    }

    private String activeFlags(SparseArray<String> sparseArray, int i) {
        boolean endsWith$default;
        int i2;
        StringBuilder sb = new StringBuilder();
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = sparseArray.keyAt(i3);
            String str = sparseArray.get(keyAt);
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, SUFFIX_MASK, false, 2, null);
            if (endsWith$default && (i2 = keyAt & i) > 0) {
                if (sb.length() > 0) {
                    sb.append('+');
                }
                sb.append(sparseArray.get(i2));
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private JSONObject collectConfiguration(Context context) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
            return configToJson(configuration);
        } catch (RuntimeException e) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            String packageName = context.getPackageName();
            aCRALog.w(str, "Couldn't retrieve CrashConfiguration for : " + packageName, e);
            return null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ConfigurationCollector.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lorg/acra/collector/ConfigurationCollector$Prefix;", "", TextBundle.TEXT_ENTRY, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "UI_MODE", "TOUCHSCREEN", "SCREENLAYOUT", "ORIENTATION", "NAVIGATIONHIDDEN", "NAVIGATION", "KEYBOARDHIDDEN", "KEYBOARD", "HARDKEYBOARDHIDDEN", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Prefix {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Prefix[] $VALUES;
        private final String text;
        public static final Prefix UI_MODE = new Prefix("UI_MODE", 0, "UI_MODE_");
        public static final Prefix TOUCHSCREEN = new Prefix("TOUCHSCREEN", 1, "TOUCHSCREEN_");
        public static final Prefix SCREENLAYOUT = new Prefix("SCREENLAYOUT", 2, "SCREENLAYOUT_");
        public static final Prefix ORIENTATION = new Prefix("ORIENTATION", 3, "ORIENTATION_");
        public static final Prefix NAVIGATIONHIDDEN = new Prefix("NAVIGATIONHIDDEN", 4, "NAVIGATIONHIDDEN_");
        public static final Prefix NAVIGATION = new Prefix("NAVIGATION", 5, "NAVIGATION_");
        public static final Prefix KEYBOARDHIDDEN = new Prefix("KEYBOARDHIDDEN", 6, "KEYBOARDHIDDEN_");
        public static final Prefix KEYBOARD = new Prefix("KEYBOARD", 7, "KEYBOARD_");
        public static final Prefix HARDKEYBOARDHIDDEN = new Prefix("HARDKEYBOARDHIDDEN", 8, "HARDKEYBOARDHIDDEN_");

        private static final /* synthetic */ Prefix[] $values() {
            return new Prefix[]{UI_MODE, TOUCHSCREEN, SCREENLAYOUT, ORIENTATION, NAVIGATIONHIDDEN, NAVIGATION, KEYBOARDHIDDEN, KEYBOARD, HARDKEYBOARDHIDDEN};
        }

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        public static Prefix valueOf(String str) {
            return (Prefix) Enum.valueOf(Prefix.class, str);
        }

        public static Prefix[] values() {
            return (Prefix[]) $VALUES.clone();
        }

        public final String getText() {
            return this.text;
        }

        private Prefix(String str, int i, String str2) {
            this.text = str2;
        }

        static {
            Prefix[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
