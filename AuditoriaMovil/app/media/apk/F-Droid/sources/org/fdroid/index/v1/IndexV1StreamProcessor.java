package org.fdroid.index.v1;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JvmStreamsKt;
import org.fdroid.index.IndexConverterKt;
import org.fdroid.index.IndexParser;
import org.fdroid.index.v2.AntiFeatureV2;
import org.fdroid.index.v2.CategoryV2;
import org.fdroid.index.v2.PackageVersionV2;
import org.fdroid.index.v2.ReleaseChannelV2;
/* compiled from: IndexV1StreamProcessor.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lorg/fdroid/index/v1/IndexV1StreamProcessor;", "", "indexStreamReceiver", "Lorg/fdroid/index/v1/IndexV1StreamReceiver;", "lastTimestamp", "", "locale", "", "json", "Lkotlinx/serialization/json/Json;", "(Lorg/fdroid/index/v1/IndexV1StreamReceiver;JLjava/lang/String;Lkotlinx/serialization/json/Json;)V", "process", "", "inputStream", "Ljava/io/InputStream;", "IndexStreamSerializer", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndexV1StreamProcessor {
    private final IndexV1StreamReceiver indexStreamReceiver;
    private final Json json;
    private final long lastTimestamp;
    private final String locale;

    public IndexV1StreamProcessor(IndexV1StreamReceiver indexStreamReceiver, long j, String locale, Json json) {
        Intrinsics.checkNotNullParameter(indexStreamReceiver, "indexStreamReceiver");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(json, "json");
        this.indexStreamReceiver = indexStreamReceiver;
        this.lastTimestamp = j;
        this.locale = locale;
        this.json = json;
    }

    public /* synthetic */ IndexV1StreamProcessor(IndexV1StreamReceiver indexV1StreamReceiver, long j, String str, Json json, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(indexV1StreamReceiver, j, (i & 4) != 0 ? IndexConverterKt.DEFAULT_LOCALE : str, (i & 8) != 0 ? IndexParser.getJson() : json);
    }

    public final void process(InputStream inputStream) throws SerializationException, OldIndexException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        JvmStreamsKt.decodeFromStream(this.json, new IndexStreamSerializer(), inputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IndexV1StreamProcessor.kt */
    /* loaded from: classes2.dex */
    public final class IndexStreamSerializer implements KSerializer {
        private final SerialDescriptor descriptor = IndexV1.Companion.serializer().getDescriptor();

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return this.descriptor;
        }

        public IndexStreamSerializer() {
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public IndexV1 deserialize(Decoder decoder) {
            Map emptyMap;
            Map emptyMap2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            if ((decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null) == null) {
                throw new IllegalStateException("Can be deserialized only by JSON".toString());
            }
            decoder.beginStructure(getDescriptor());
            JsonDecoder jsonDecoder = (JsonDecoder) decoder;
            deserializeRepo(jsonDecoder, jsonDecoder.decodeElementIndex(getDescriptor()));
            int decodeElementIndex = jsonDecoder.decodeElementIndex(getDescriptor());
            if (decodeElementIndex == -1) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
                updateRepoData(emptyMap2);
                jsonDecoder.endStructure(getDescriptor());
                return null;
            }
            deserializeRequests(jsonDecoder, decodeElementIndex);
            int decodeElementIndex2 = jsonDecoder.decodeElementIndex(getDescriptor());
            if (decodeElementIndex2 == -1) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                updateRepoData(emptyMap);
                jsonDecoder.endStructure(getDescriptor());
                return null;
            }
            Map deserializeApps = deserializeApps(jsonDecoder, decodeElementIndex2);
            int decodeElementIndex3 = jsonDecoder.decodeElementIndex(getDescriptor());
            if (decodeElementIndex3 == -1) {
                updateRepoData(deserializeApps);
                jsonDecoder.endStructure(getDescriptor());
                return null;
            }
            deserializePackages(jsonDecoder, decodeElementIndex3, deserializeApps);
            jsonDecoder.endStructure(getDescriptor());
            updateRepoData(deserializeApps);
            return null;
        }

        private final void deserializeRepo(JsonDecoder jsonDecoder, int i) {
            Map<String, AntiFeatureV2> emptyMap;
            Map<String, CategoryV2> emptyMap2;
            Map<String, ReleaseChannelV2> emptyMap3;
            if (i != getDescriptor().getElementIndex("repo")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            RepoV1 repoV1 = (RepoV1) jsonDecoder.decodeSerializableValue(RepoV1.Companion.serializer());
            if (IndexV1StreamProcessor.this.lastTimestamp >= repoV1.getTimestamp()) {
                boolean z = IndexV1StreamProcessor.this.lastTimestamp == repoV1.getTimestamp();
                String address = repoV1.getAddress();
                long timestamp = repoV1.getTimestamp();
                throw new OldIndexException(z, "Old repo " + address + " " + timestamp);
            }
            emptyMap = MapsKt__MapsKt.emptyMap();
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            emptyMap3 = MapsKt__MapsKt.emptyMap();
            IndexV1StreamProcessor.this.indexStreamReceiver.receive(repoV1.toRepoV2(IndexConverterKt.DEFAULT_LOCALE, emptyMap, emptyMap2, emptyMap3), repoV1.getVersion());
        }

        private final void deserializeRequests(JsonDecoder jsonDecoder, int i) {
            if (i != getDescriptor().getElementIndex("requests")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            jsonDecoder.decodeSerializableValue(Requests.Companion.serializer());
        }

        private final Map deserializeApps(JsonDecoder jsonDecoder, int i) {
            int collectionSizeOrDefault;
            int mapCapacity;
            int coerceAtLeast;
            Map emptyMap;
            if (i != getDescriptor().getElementIndex("apps")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            HashMap hashMap = new HashMap();
            SerialDescriptor elementDescriptor = getDescriptor().getElementDescriptor(i);
            CompositeDecoder beginStructure = jsonDecoder.beginStructure(elementDescriptor);
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
                if (decodeElementIndex != -1) {
                    AppV1 appV1 = (AppV1) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(jsonDecoder, getDescriptor(), decodeElementIndex, AppV1.Companion.serializer(), null, 8, null);
                    Long l = null;
                    IndexV1StreamProcessor.this.indexStreamReceiver.receive(appV1.getPackageName(), appV1.toMetadataV2(null, IndexV1StreamProcessor.this.locale));
                    String packageName = appV1.getPackageName();
                    List<String> antiFeatures = appV1.getAntiFeatures();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(antiFeatures, 10);
                    mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                    for (Object obj : antiFeatures) {
                        String str = (String) obj;
                        emptyMap = MapsKt__MapsKt.emptyMap();
                        linkedHashMap.put(obj, emptyMap);
                    }
                    Map<String, Localized> localized = appV1.getLocalized();
                    Map mapValuesNotNull = localized != null ? IndexConverterKt.mapValuesNotNull(localized, new Function1() { // from class: org.fdroid.index.v1.IndexV1StreamProcessor$IndexStreamSerializer$deserializeApps$2
                        @Override // kotlin.jvm.functions.Function1
                        public final String invoke(Map.Entry it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return ((Localized) it.getValue()).getWhatsNew();
                        }
                    }) : null;
                    String suggestedVersionCode = appV1.getSuggestedVersionCode();
                    if (suggestedVersionCode != null) {
                        l = StringsKt__StringNumberConversionsKt.toLongOrNull(suggestedVersionCode);
                    }
                    hashMap.put(packageName, new AppData(linkedHashMap, mapValuesNotNull, l, appV1.getCategories()));
                } else {
                    beginStructure.endStructure(elementDescriptor);
                    return hashMap;
                }
            }
        }

        private final void deserializePackages(JsonDecoder jsonDecoder, int i, Map map) {
            if (i != getDescriptor().getElementIndex("packages")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            SerialDescriptor elementDescriptor = getDescriptor().getElementDescriptor(i);
            CompositeDecoder beginStructure = jsonDecoder.beginStructure(elementDescriptor);
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
                if (decodeElementIndex != -1) {
                    Intrinsics.checkNotNull(beginStructure, "null cannot be cast to non-null type kotlinx.serialization.json.JsonDecoder");
                    readPackageMapEntry((JsonDecoder) beginStructure, decodeElementIndex, map);
                } else {
                    beginStructure.endStructure(elementDescriptor);
                    return;
                }
            }
        }

        private final void readPackageMapEntry(JsonDecoder jsonDecoder, int i, Map map) {
            Map emptyMap;
            AppData appData;
            Long suggestedVersionCode;
            String decodeStringElement = jsonDecoder.decodeStringElement(getDescriptor(), i);
            jsonDecoder.decodeElementIndex(getDescriptor());
            HashMap hashMap = new HashMap();
            SerialDescriptor descriptor = BuiltinSerializersKt.ListSerializer(PackageV1.Companion.serializer()).getDescriptor();
            CompositeDecoder beginStructure = jsonDecoder.beginStructure(descriptor);
            boolean z = true;
            while (beginStructure.decodeElementIndex(getDescriptor()) != -1) {
                PackageV1 packageV1 = (PackageV1) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(jsonDecoder, getDescriptor(), i + 1, PackageV1.Companion.serializer(), null, 8, null);
                Long versionCode = packageV1.getVersionCode();
                long j = 0;
                long longValue = versionCode != null ? versionCode.longValue() : 0L;
                AppData appData2 = (AppData) map.get(decodeStringElement);
                if (appData2 != null && (suggestedVersionCode = appData2.getSuggestedVersionCode()) != null) {
                    j = suggestedVersionCode.longValue();
                }
                List<String> listOf = longValue > j ? CollectionsKt__CollectionsJVMKt.listOf("Beta") : CollectionsKt__CollectionsKt.emptyList();
                AppData appData3 = (AppData) map.get(decodeStringElement);
                if (appData3 == null || (emptyMap = appData3.getAntiFeatures()) == null) {
                    emptyMap = MapsKt__MapsKt.emptyMap();
                }
                Map map2 = null;
                if (j == longValue && (appData = (AppData) map.get(decodeStringElement)) != null) {
                    map2 = appData.getWhatsNew();
                }
                PackageVersionV2 packageVersionV2 = packageV1.toPackageVersionV2(listOf, emptyMap, map2);
                if (z) {
                    IndexV1StreamProcessor.this.indexStreamReceiver.updateAppMetadata(decodeStringElement, packageV1.getSigner());
                }
                hashMap.put(packageVersionV2.getFile().getSha256(), packageVersionV2);
                z = false;
            }
            IndexV1StreamProcessor.this.indexStreamReceiver.receive(decodeStringElement, hashMap);
            beginStructure.endStructure(descriptor);
        }

        private final void updateRepoData(Map map) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (AppData appData : map.values()) {
                IndexConverterKt.mapInto(appData.getAntiFeatures(), hashMap);
                IndexConverterKt.mapInto(appData.getCategories(), hashMap2);
            }
            IndexV1StreamProcessor.this.indexStreamReceiver.updateRepo(hashMap, hashMap2, IndexConverterKt.getV1ReleaseChannels());
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder, IndexV1 indexV1) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            throw new IllegalStateException("Not implemented".toString());
        }
    }
}
