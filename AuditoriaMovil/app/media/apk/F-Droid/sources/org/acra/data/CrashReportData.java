package org.acra.data;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.log.ACRALog;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: CrashReportData.kt */
/* loaded from: classes2.dex */
public final class CrashReportData {
    private final JSONObject content;

    public CrashReportData() {
        this.content = new JSONObject();
    }

    public CrashReportData(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.content = new JSONObject(json);
    }

    public final synchronized void put(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            this.content.put(key, z);
        } catch (JSONException unused) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            aCRALog.w(str, "Failed to put value into CrashReportData: " + z);
        }
    }

    public final synchronized void put(String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            this.content.put(key, j);
        } catch (JSONException unused) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            aCRALog.w(str, "Failed to put value into CrashReportData: " + j);
        }
    }

    public final synchronized void put(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (str == null) {
            putNA(key);
            return;
        }
        try {
            this.content.put(key, str);
        } catch (JSONException unused) {
            ACRALog aCRALog = ACRA.log;
            String str2 = ACRA.LOG_TAG;
            aCRALog.w(str2, "Failed to put value into CrashReportData: " + str);
        }
    }

    public final synchronized void put(String key, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject == null) {
            putNA(key);
            return;
        }
        try {
            this.content.put(key, jSONObject);
        } catch (JSONException unused) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            aCRALog.w(str, "Failed to put value into CrashReportData: " + jSONObject);
        }
    }

    public final synchronized void put(ReportField key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key.toString(), z);
    }

    public final synchronized void put(ReportField key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key.toString(), j);
    }

    public final synchronized void put(ReportField key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key.toString(), str);
    }

    public final synchronized void put(ReportField key, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key.toString(), jSONObject);
    }

    private final void putNA(String str) {
        try {
            this.content.put(str, "N/A");
        } catch (JSONException unused) {
        }
    }

    public final String getString(ReportField key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.content.optString(key.toString());
    }

    public final Object get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.content.opt(key);
    }

    public final String toJSON() {
        List<? extends ReportField> emptyList;
        try {
            StringFormat stringFormat = StringFormat.JSON;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return stringFormat.toFormattedString(this, emptyList, "", "", false);
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage());
        }
    }

    public final Map toMap() {
        Sequence asSequence;
        Sequence map;
        Map map2;
        Iterator<String> keys = this.content.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
        asSequence = SequencesKt__SequencesKt.asSequence(keys);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1() { // from class: org.acra.data.CrashReportData$toMap$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Pair invoke(String str) {
                CrashReportData crashReportData = CrashReportData.this;
                Intrinsics.checkNotNull(str);
                return TuplesKt.to(str, crashReportData.get(str));
            }
        });
        map2 = MapsKt__MapsKt.toMap(map);
        return map2;
    }
}
