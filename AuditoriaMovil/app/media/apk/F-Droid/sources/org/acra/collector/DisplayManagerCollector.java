package org.acra.collector;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: DisplayManagerCollector.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0012J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0012J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\u0018\u0010#\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\u0018\u0010$\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\u0018\u0010%\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170'2\u0006\u0010\r\u001a\u00020\u000eH\u0012¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\bH\u0012¨\u0006+"}, d2 = {"Lorg/acra/collector/DisplayManagerCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "activeFlags", "", "flagNames", "Landroid/util/SparseArray;", "bitfield", "", "collect", "", "reportField", "Lorg/acra/ReportField;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", "target", "Lorg/acra/data/CrashReportData;", "collectCurrentSizeRange", "display", "Landroid/view/Display;", "container", "Lorg/json/JSONObject;", "collectDisplayData", "collectFlags", "collectIsValid", "collectMetrics", "metrics", "Landroid/util/DisplayMetrics;", "collectName", "collectRealMetrics", "collectRealSize", "collectRectSize", "collectRotation", "collectSize", "getDisplays", "", "(Landroid/content/Context;)[Landroid/view/Display;", "rotationToString", "rotation", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DisplayManagerCollector extends BaseReportFieldCollector {
    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public DisplayManagerCollector() {
        super(ReportField.DISPLAY);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) {
        Display[] displays;
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        JSONObject jSONObject = new JSONObject();
        for (Display display : getDisplays(context)) {
            try {
                jSONObject.put(String.valueOf(display.getDisplayId()), collectDisplayData(display));
            } catch (JSONException e) {
                ACRA.log.w(ACRA.LOG_TAG, "Failed to collect data for display " + display.getDisplayId(), e);
            }
        }
        target.put(ReportField.DISPLAY, jSONObject);
    }

    private Display[] getDisplays(Context context) {
        Object systemService = context.getSystemService("display");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Display[] displays = ((DisplayManager) systemService).getDisplays();
        Intrinsics.checkNotNull(displays);
        return displays;
    }

    private JSONObject collectDisplayData(Display display) throws JSONException {
        display.getMetrics(new DisplayMetrics());
        JSONObject jSONObject = new JSONObject();
        collectCurrentSizeRange(display, jSONObject);
        collectFlags(display, jSONObject);
        collectMetrics(display, jSONObject);
        collectRealMetrics(display, jSONObject);
        collectName(display, jSONObject);
        collectRealSize(display, jSONObject);
        collectRectSize(display, jSONObject);
        collectSize(display, jSONObject);
        collectRotation(display, jSONObject);
        collectIsValid(display, jSONObject);
        jSONObject.put("orientation", display.getRotation()).put("refreshRate", display.getRefreshRate()).put("height", display.getHeight()).put("width", display.getWidth()).put("pixelFormat", display.getPixelFormat());
        return jSONObject;
    }

    private void collectIsValid(Display display, JSONObject jSONObject) throws JSONException {
        jSONObject.put("isValid", display.isValid());
    }

    private void collectRotation(Display display, JSONObject jSONObject) throws JSONException {
        jSONObject.put("rotation", rotationToString(display.getRotation()));
    }

    private String rotationToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? String.valueOf(i) : "ROTATION_270" : "ROTATION_180" : "ROTATION_90" : "ROTATION_0";
    }

    private void collectRectSize(Display display, JSONObject jSONObject) throws JSONException {
        List listOf;
        Rect rect = new Rect();
        display.getRectSize(rect);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(rect.top), Integer.valueOf(rect.left), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())});
        jSONObject.put("rectSize", new JSONArray((Collection) listOf));
    }

    private void collectSize(Display display, JSONObject jSONObject) throws JSONException {
        List listOf;
        Point point = new Point();
        display.getSize(point);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(point.x), Integer.valueOf(point.y)});
        jSONObject.put("size", new JSONArray((Collection) listOf));
    }

    private void collectRealSize(Display display, JSONObject jSONObject) throws JSONException {
        List listOf;
        Point point = new Point();
        display.getRealSize(point);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(point.x), Integer.valueOf(point.y)});
        jSONObject.put("realSize", new JSONArray((Collection) listOf));
    }

    private void collectCurrentSizeRange(Display display, JSONObject jSONObject) throws JSONException {
        List listOf;
        List listOf2;
        Point point = new Point();
        Point point2 = new Point();
        display.getCurrentSizeRange(point, point2);
        JSONObject jSONObject2 = new JSONObject();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(point.x), Integer.valueOf(point.y)});
        jSONObject2.put("smallest", new JSONArray((Collection) listOf));
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(point2.x), Integer.valueOf(point2.y)});
        jSONObject2.put("largest", new JSONArray((Collection) listOf2));
        jSONObject.put("currentSizeRange", jSONObject2);
    }

    private void collectFlags(Display display, JSONObject jSONObject) throws JSONException {
        boolean startsWith$default;
        SparseArray<String> sparseArray = new SparseArray<>();
        int flags = display.getFlags();
        Field[] fields = display.getClass().getFields();
        Intrinsics.checkNotNullExpressionValue(fields, "getFields(...)");
        for (Field field : fields) {
            String name = field.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "FLAG_", false, 2, null);
            if (startsWith$default) {
                try {
                    sparseArray.put(field.getInt(null), field.getName());
                } catch (IllegalAccessException unused) {
                }
            }
        }
        jSONObject.put("flags", activeFlags(sparseArray, flags));
    }

    private void collectName(Display display, JSONObject jSONObject) throws JSONException {
        jSONObject.put("name", display.getName());
    }

    private void collectMetrics(Display display, JSONObject jSONObject) throws JSONException {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        JSONObject jSONObject2 = new JSONObject();
        collectMetrics(displayMetrics, jSONObject2);
        jSONObject.put("metrics", jSONObject2);
    }

    private void collectRealMetrics(Display display, JSONObject jSONObject) throws JSONException {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        JSONObject jSONObject2 = new JSONObject();
        collectMetrics(displayMetrics, jSONObject2);
        jSONObject.put("realMetrics", jSONObject2);
    }

    private void collectMetrics(DisplayMetrics displayMetrics, JSONObject jSONObject) throws JSONException {
        JSONObject put = jSONObject.put("density", displayMetrics.density).put("densityDpi", displayMetrics.densityDpi);
        float f = displayMetrics.scaledDensity;
        put.put("scaledDensity", "x" + f).put("widthPixels", displayMetrics.widthPixels).put("heightPixels", displayMetrics.heightPixels).put("xdpi", displayMetrics.xdpi).put("ydpi", displayMetrics.ydpi);
    }

    private String activeFlags(SparseArray<String> sparseArray, int i) {
        StringBuilder sb = new StringBuilder();
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2) & i;
            if (keyAt > 0) {
                if (sb.length() > 0) {
                    sb.append('+');
                }
                sb.append(sparseArray.get(keyAt));
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
