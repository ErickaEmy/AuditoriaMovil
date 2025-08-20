package org.acra.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ReflectionCollector.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0012J\u001c\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0012¨\u0006\u0016"}, d2 = {"Lorg/acra/collector/ReflectionCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "collect", "", "reportField", "Lorg/acra/ReportField;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", "target", "Lorg/acra/data/CrashReportData;", "collectStaticGettersResults", "someClass", "Ljava/lang/Class;", "container", "Lorg/json/JSONObject;", "getBuildConfigClass", "Companion", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class ReflectionCollector extends BaseReportFieldCollector {
    public static final Companion Companion = new Companion(null);

    /* compiled from: ReflectionCollector.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReportField.values().length];
            try {
                iArr[ReportField.BUILD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReportField.BUILD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReportField.ENVIRONMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public ReflectionCollector() {
        super(ReportField.BUILD, ReportField.BUILD_CONFIG, ReportField.ENVIRONMENT);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) throws JSONException, ClassNotFoundException {
        List listOf;
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        JSONObject jSONObject = new JSONObject();
        int i = WhenMappings.$EnumSwitchMapping$0[reportField.ordinal()];
        if (i == 1) {
            Companion companion = Companion;
            listOf = CollectionsKt__CollectionsJVMKt.listOf("SERIAL");
            companion.collectConstants(Build.class, jSONObject, listOf);
            JSONObject jSONObject2 = new JSONObject();
            Companion.collectConstants$default(companion, Build.VERSION.class, jSONObject2, null, 4, null);
            jSONObject.put("VERSION", jSONObject2);
        } else if (i == 2) {
            Companion.collectConstants$default(Companion, getBuildConfigClass(context, config), jSONObject, null, 4, null);
        } else if (i == 3) {
            collectStaticGettersResults(Environment.class, jSONObject);
        } else {
            throw new IllegalArgumentException();
        }
        target.put(reportField, jSONObject);
    }

    private void collectStaticGettersResults(Class<?> cls, JSONObject jSONObject) throws JSONException {
        boolean startsWith$default;
        boolean startsWith$default2;
        Method[] methods = cls.getMethods();
        Intrinsics.checkNotNull(methods);
        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
            if (parameterTypes.length == 0) {
                String name = method.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "get", false, 2, null);
                if (!startsWith$default) {
                    String name2 = method.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(name2, "is", false, 2, null);
                    if (!startsWith$default2) {
                    }
                }
                if (!Intrinsics.areEqual("getClass", method.getName())) {
                    try {
                        jSONObject.put(method.getName(), method.invoke(null, new Object[0]));
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                    }
                }
            }
        }
    }

    private Class<?> getBuildConfigClass(Context context, CoreConfiguration coreConfiguration) throws ClassNotFoundException {
        Class<?> buildConfigClass = coreConfiguration.getBuildConfigClass();
        if (buildConfigClass == null) {
            String packageName = context.getPackageName();
            Class<?> cls = Class.forName(packageName + ".BuildConfig");
            Intrinsics.checkNotNullExpressionValue(cls, "forName(...)");
            return cls;
        }
        return buildConfigClass;
    }

    /* compiled from: ReflectionCollector.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static /* synthetic */ void collectConstants$default(Companion companion, Class cls, JSONObject jSONObject, Collection collection, int i, Object obj) {
            if ((i & 4) != 0) {
                collection = CollectionsKt__CollectionsKt.emptyList();
            }
            companion.collectConstants(cls, jSONObject, collection);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void collectConstants(Class cls, JSONObject jSONObject, Collection collection) {
            List listOf;
            Field[] fields = cls.getFields();
            Intrinsics.checkNotNull(fields);
            for (Field field : fields) {
                if (!collection.contains(field.getName())) {
                    try {
                        Object obj = field.get(null);
                        if (obj != null) {
                            if (field.getType().isArray()) {
                                String name = field.getName();
                                Object[] objArr = (Object[]) obj;
                                listOf = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length));
                                jSONObject.put(name, new JSONArray((Collection) listOf));
                            } else {
                                jSONObject.put(field.getName(), obj);
                            }
                        }
                    } catch (IllegalAccessException | IllegalArgumentException unused) {
                    }
                }
            }
        }
    }
}
