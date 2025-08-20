package org.acra.data;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.acra.ReportField;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: StringFormat.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lorg/acra/data/StringFormat;", "", "matchingHttpContentType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMatchingHttpContentType", "()Ljava/lang/String;", "toFormattedString", "data", "Lorg/acra/data/CrashReportData;", "order", "", "Lorg/acra/ReportField;", "mainJoiner", "subJoiner", "urlEncode", "", "JSON", "KEY_VALUE_LIST", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class StringFormat {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StringFormat[] $VALUES;
    public static final StringFormat JSON = new StringFormat("JSON", 0) { // from class: org.acra.data.StringFormat.JSON
        @Override // org.acra.data.StringFormat
        public String toFormattedString(CrashReportData data, List order, String mainJoiner, String subJoiner, boolean z) {
            Map mutableMap;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(order, "order");
            Intrinsics.checkNotNullParameter(mainJoiner, "mainJoiner");
            Intrinsics.checkNotNullParameter(subJoiner, "subJoiner");
            mutableMap = MapsKt__MapsKt.toMutableMap(data.toMap());
            JSONStringer object = new JSONStringer().object();
            Iterator it = order.iterator();
            while (it.hasNext()) {
                ReportField reportField = (ReportField) it.next();
                object.key(reportField.toString()).value(mutableMap.remove(reportField.toString()));
            }
            for (Map.Entry entry : mutableMap.entrySet()) {
                object.key((String) entry.getKey()).value(entry.getValue());
            }
            String jSONStringer = object.endObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONStringer, "toString(...)");
            return jSONStringer;
        }
    };
    public static final StringFormat KEY_VALUE_LIST = new StringFormat("KEY_VALUE_LIST", 1) { // from class: org.acra.data.StringFormat.KEY_VALUE_LIST
        @Override // org.acra.data.StringFormat
        public String toFormattedString(CrashReportData data, List order, String mainJoiner, String subJoiner, boolean z) {
            Map mutableMap;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(order, "order");
            Intrinsics.checkNotNullParameter(mainJoiner, "mainJoiner");
            Intrinsics.checkNotNullParameter(subJoiner, "subJoiner");
            mutableMap = MapsKt__MapsKt.toMutableMap(toStringMap(data.toMap(), subJoiner));
            StringBuilder sb = new StringBuilder();
            Iterator it = order.iterator();
            while (it.hasNext()) {
                ReportField reportField = (ReportField) it.next();
                append(sb, reportField.toString(), (String) mutableMap.remove(reportField.toString()), mainJoiner, z);
            }
            for (Map.Entry entry : mutableMap.entrySet()) {
                append(sb, (String) entry.getKey(), (String) entry.getValue(), mainJoiner, z);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }

        private final void append(StringBuilder sb, String str, String str2, String str3, boolean z) {
            if (sb.length() > 0) {
                sb.append(str3);
            }
            if (z) {
                str = str != null ? URLEncoder.encode(str, "UTF-8") : null;
                str2 = str2 != null ? URLEncoder.encode(str2, "UTF-8") : null;
            }
            sb.append(str);
            sb.append('=');
            sb.append(str2);
        }

        private final String valueToString(String str, Object obj) {
            String joinToString$default;
            if (obj instanceof JSONObject) {
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(flatten((JSONObject) obj), str, null, null, 0, null, null, 62, null);
                return joinToString$default;
            }
            return String.valueOf(obj);
        }

        private final List flatten(JSONObject jSONObject) {
            Sequence asSequence;
            List<String> list;
            Object obj;
            Collection listOf;
            int collectionSizeOrDefault;
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
            asSequence = SequencesKt__SequencesKt.asSequence(keys);
            list = SequencesKt___SequencesKt.toList(asSequence);
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                try {
                    obj = jSONObject.get(str);
                } catch (JSONException unused) {
                    obj = null;
                }
                if (obj instanceof JSONObject) {
                    List flatten = flatten((JSONObject) obj);
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(flatten, 10);
                    listOf = new ArrayList(collectionSizeOrDefault);
                    Iterator it = flatten.iterator();
                    while (it.hasNext()) {
                        listOf.add(str + "." + ((String) it.next()));
                    }
                } else {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(str + "=" + obj);
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, listOf);
            }
            return arrayList;
        }

        private final Map toStringMap(Map map, String str) {
            int mapCapacity;
            Map map2;
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(map.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), valueToString(str, entry.getValue()));
            }
            map2 = MapsKt__MapsKt.toMap(linkedHashMap);
            return map2;
        }
    };
    private final String matchingHttpContentType;

    private static final /* synthetic */ StringFormat[] $values() {
        return new StringFormat[]{JSON, KEY_VALUE_LIST};
    }

    public /* synthetic */ StringFormat(String str, int i, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2);
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    public static StringFormat valueOf(String str) {
        return (StringFormat) Enum.valueOf(StringFormat.class, str);
    }

    public static StringFormat[] values() {
        return (StringFormat[]) $VALUES.clone();
    }

    public final String getMatchingHttpContentType() {
        return this.matchingHttpContentType;
    }

    public abstract String toFormattedString(CrashReportData crashReportData, List<? extends ReportField> list, String str, String str2, boolean z) throws Exception;

    private StringFormat(String str, int i, String str2) {
        this.matchingHttpContentType = str2;
    }

    static {
        StringFormat[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
