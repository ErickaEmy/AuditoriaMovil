package org.fdroid.index;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.index.v1.Localized;
import org.fdroid.index.v2.AntiFeatureV2;
import org.fdroid.index.v2.CategoryV2;
import org.fdroid.index.v2.ReleaseChannelV2;
/* compiled from: IndexConverter.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0000\u001a\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004\u001aP\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00020\u00010\t2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\b0\u000bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\b`\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\b0\u000eH\u0000\u001a6\u0010\u0006\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00010\u000f2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0010`\fH\u0000\u001aL\u0010\u0006\u001a\u00020\u0007*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004j\u0002`\u00110\u00042\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00120\u000bj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012`\fH\u0000\u001aN\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\b\u0018\u00010\u0004\"\u0004\b\u0000\u0010\b*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u00042 \u0010\u0015\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\b0\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"DEFAULT_LOCALE", "", "RELEASE_CHANNEL_BETA", "getV1ReleaseChannels", "", "Lorg/fdroid/index/v2/ReleaseChannelV2;", "mapInto", "", "T", "", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "valueGetter", "Lkotlin/Function1;", "", "Lorg/fdroid/index/v2/CategoryV2;", "Lorg/fdroid/index/v2/LocalizedTextV2;", "Lorg/fdroid/index/v2/AntiFeatureV2;", "mapValuesNotNull", "Lorg/fdroid/index/v1/Localized;", "transform", "", "index_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndexConverterKt {
    public static final String DEFAULT_LOCALE = "en-US";
    public static final String RELEASE_CHANNEL_BETA = "Beta";

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void mapInto(Collection<String> collection, HashMap<String, T> map, Function1 valueGetter) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(valueGetter, "valueGetter");
        for (String str : collection) {
            if (!map.containsKey(str)) {
                map.put(str, valueGetter.invoke(str));
            }
        }
    }

    public static final void mapInto(List<String> list, HashMap<String, CategoryV2> map) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        mapInto(list, map, new Function1() { // from class: org.fdroid.index.IndexConverterKt$mapInto$2
            @Override // kotlin.jvm.functions.Function1
            public final CategoryV2 invoke(String key) {
                Map mapOf;
                Intrinsics.checkNotNullParameter(key, "key");
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(IndexConverterKt.DEFAULT_LOCALE, key));
                return new CategoryV2((Map) null, mapOf, (Map) null, 5, (DefaultConstructorMarker) null);
            }
        });
    }

    public static final void mapInto(Map<String, ? extends Map<String, String>> map, HashMap<String, AntiFeatureV2> map2) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(map2, "map");
        mapInto(map.keySet(), map2, new Function1() { // from class: org.fdroid.index.IndexConverterKt$mapInto$3
            @Override // kotlin.jvm.functions.Function1
            public final AntiFeatureV2 invoke(String key) {
                Map mapOf;
                Intrinsics.checkNotNullParameter(key, "key");
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(IndexConverterKt.DEFAULT_LOCALE, key));
                return new AntiFeatureV2((Map) null, mapOf, (Map) null, 5, (DefaultConstructorMarker) null);
            }
        });
    }

    public static final Map<String, ReleaseChannelV2> getV1ReleaseChannels() {
        Map mapOf;
        Map emptyMap;
        Map<String, ReleaseChannelV2> mapOf2;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(DEFAULT_LOCALE, "Beta"));
        emptyMap = MapsKt__MapsKt.emptyMap();
        mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("Beta", new ReleaseChannelV2(mapOf, emptyMap)));
        return mapOf2;
    }

    public static final <T> Map<String, T> mapValuesNotNull(Map<String, Localized> map, Function1 transform) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (Map.Entry<String, Localized> entry : map.entrySet()) {
            Object invoke = transform.invoke(entry);
            if (invoke != null) {
                linkedHashMap.put(entry.getKey(), invoke);
            }
        }
        if (!linkedHashMap.isEmpty()) {
            return linkedHashMap;
        }
        return null;
    }
}
