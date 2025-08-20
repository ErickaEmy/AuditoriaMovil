package kotlinx.serialization.json.internal;

import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
/* compiled from: JsonNamesMap.kt */
/* loaded from: classes2.dex */
public abstract class JsonNamesMapKt {
    private static final DescriptorSchemaCache.Key JsonAlternativeNamesKey = new DescriptorSchemaCache.Key();

    public static final DescriptorSchemaCache.Key getJsonAlternativeNamesKey() {
        return JsonAlternativeNamesKey;
    }

    private static final void buildAlternativeNamesMap$putOrThrow(Map map, SerialDescriptor serialDescriptor, String str, int i) {
        Object value;
        if (map.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The suggested name '");
            sb.append(str);
            sb.append("' for property ");
            sb.append(serialDescriptor.getElementName(i));
            sb.append(" is already one of the names for property ");
            value = MapsKt__MapsKt.getValue(map, str);
            sb.append(serialDescriptor.getElementName(((Number) value).intValue()));
            sb.append(" in ");
            sb.append(serialDescriptor);
            throw new JsonException(sb.toString());
        }
        map.put(str, Integer.valueOf(i));
    }

    public static final Map buildAlternativeNamesMap(SerialDescriptor serialDescriptor) {
        Map emptyMap;
        Object singleOrNull;
        String[] names;
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        int elementsCount = serialDescriptor.getElementsCount();
        Map map = null;
        for (int i = 0; i < elementsCount; i++) {
            List elementAnnotations = serialDescriptor.getElementAnnotations(i);
            ArrayList arrayList = new ArrayList();
            for (Object obj : elementAnnotations) {
                if (obj instanceof JsonNames) {
                    arrayList.add(obj);
                }
            }
            singleOrNull = CollectionsKt___CollectionsKt.singleOrNull((List) arrayList);
            JsonNames jsonNames = (JsonNames) singleOrNull;
            if (jsonNames != null && (names = jsonNames.names()) != null) {
                for (String str : names) {
                    if (map == null) {
                        map = CreateMapForCacheKt.createMapForCache(serialDescriptor.getElementsCount());
                    }
                    Intrinsics.checkNotNull(map);
                    buildAlternativeNamesMap$putOrThrow(map, serialDescriptor, str, i);
                }
            }
        }
        if (map == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        return map;
    }

    public static final int getJsonNameIndex(SerialDescriptor serialDescriptor, Json json, String name) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        int elementIndex = serialDescriptor.getElementIndex(name);
        if (elementIndex == -3 && json.getConfiguration().getUseAlternativeNames()) {
            Integer num = (Integer) ((Map) JsonSchemaCacheKt.getSchemaCache(json).getOrPut(serialDescriptor, JsonAlternativeNamesKey, new JsonNamesMapKt$getJsonNameIndex$alternativeNamesMap$1(serialDescriptor))).get(name);
            if (num != null) {
                return num.intValue();
            }
            return -3;
        }
        return elementIndex;
    }

    public static /* synthetic */ int getJsonNameIndexOrThrow$default(SerialDescriptor serialDescriptor, Json json, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return getJsonNameIndexOrThrow(serialDescriptor, json, str, str2);
    }

    public static final int getJsonNameIndexOrThrow(SerialDescriptor serialDescriptor, Json json, String name, String suffix) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        int jsonNameIndex = getJsonNameIndex(serialDescriptor, json, name);
        if (jsonNameIndex != -3) {
            return jsonNameIndex;
        }
        throw new SerializationException(serialDescriptor.getSerialName() + " does not contain element with name '" + name + CoreConstants.SINGLE_QUOTE_CHAR + suffix);
    }
}
