package org.fdroid.index.v2;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JvmStreamsKt;
import org.fdroid.index.IndexParser;
/* compiled from: IndexV2DiffStreamProcessor.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lorg/fdroid/index/v2/IndexV2DiffStreamProcessor;", "Lorg/fdroid/index/v2/IndexV2StreamProcessor;", "indexStreamReceiver", "Lorg/fdroid/index/v2/IndexV2DiffStreamReceiver;", "json", "Lkotlinx/serialization/json/Json;", "(Lorg/fdroid/index/v2/IndexV2DiffStreamReceiver;Lkotlinx/serialization/json/Json;)V", "process", "", "version", "", "inputStream", "Ljava/io/InputStream;", "onAppProcessed", "Lkotlin/Function1;", "", "IndexStreamSerializer", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndexV2DiffStreamProcessor implements IndexV2StreamProcessor {
    private final IndexV2DiffStreamReceiver indexStreamReceiver;
    private final Json json;

    public IndexV2DiffStreamProcessor(IndexV2DiffStreamReceiver indexStreamReceiver, Json json) {
        Intrinsics.checkNotNullParameter(indexStreamReceiver, "indexStreamReceiver");
        Intrinsics.checkNotNullParameter(json, "json");
        this.indexStreamReceiver = indexStreamReceiver;
        this.json = json;
    }

    public /* synthetic */ IndexV2DiffStreamProcessor(IndexV2DiffStreamReceiver indexV2DiffStreamReceiver, Json json, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(indexV2DiffStreamReceiver, (i & 2) != 0 ? IndexParser.getJson() : json);
    }

    @Override // org.fdroid.index.v2.IndexV2StreamProcessor
    public void process(long j, InputStream inputStream, Function1 onAppProcessed) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(onAppProcessed, "onAppProcessed");
        JvmStreamsKt.decodeFromStream(this.json, new IndexStreamSerializer(this, j, onAppProcessed), inputStream);
    }

    /* compiled from: IndexV2DiffStreamProcessor.kt */
    /* loaded from: classes2.dex */
    private final class IndexStreamSerializer implements KSerializer {
        private int appsProcessed;
        private final SerialDescriptor descriptor;
        private final Function1 onAppProcessed;
        final /* synthetic */ IndexV2DiffStreamProcessor this$0;
        private final long version;

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return this.descriptor;
        }

        public IndexStreamSerializer(IndexV2DiffStreamProcessor indexV2DiffStreamProcessor, long j, Function1 onAppProcessed) {
            Intrinsics.checkNotNullParameter(onAppProcessed, "onAppProcessed");
            this.this$0 = indexV2DiffStreamProcessor;
            this.version = j;
            this.onAppProcessed = onAppProcessed;
            this.descriptor = IndexV2.Companion.serializer().getDescriptor();
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public IndexV2 deserialize(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            if ((decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null) == null) {
                throw new IllegalStateException("Can be deserialized only by JSON".toString());
            }
            decoder.beginStructure(getDescriptor());
            int elementIndex = getDescriptor().getElementIndex("repo");
            int elementIndex2 = getDescriptor().getElementIndex("packages");
            JsonDecoder jsonDecoder = (JsonDecoder) decoder;
            int decodeElementIndex = jsonDecoder.decodeElementIndex(getDescriptor());
            if (decodeElementIndex == elementIndex) {
                diffRepo(this.version, jsonDecoder, decodeElementIndex);
                int decodeElementIndex2 = jsonDecoder.decodeElementIndex(getDescriptor());
                if (decodeElementIndex2 == elementIndex2) {
                    diffPackages(jsonDecoder, decodeElementIndex2);
                }
            } else if (decodeElementIndex == elementIndex2) {
                diffPackages(jsonDecoder, decodeElementIndex);
                int decodeElementIndex3 = jsonDecoder.decodeElementIndex(getDescriptor());
                if (decodeElementIndex3 == elementIndex) {
                    diffRepo(this.version, jsonDecoder, decodeElementIndex3);
                }
            } else {
                throw new IllegalStateException(("Unexpected startIndex: " + decodeElementIndex).toString());
            }
            do {
            } while (jsonDecoder.decodeElementIndex(getDescriptor()) != -1);
            jsonDecoder.endStructure(getDescriptor());
            this.this$0.indexStreamReceiver.onStreamEnded();
            return null;
        }

        private final void diffRepo(long j, JsonDecoder jsonDecoder, int i) {
            if (i != getDescriptor().getElementIndex("repo")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.this$0.indexStreamReceiver.receiveRepoDiff(j, JsonElementKt.getJsonObject(jsonDecoder.decodeJsonElement()));
        }

        private final void diffPackages(JsonDecoder jsonDecoder, int i) {
            if (i != getDescriptor().getElementIndex("packages")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            SerialDescriptor elementDescriptor = getDescriptor().getElementDescriptor(i);
            CompositeDecoder beginStructure = jsonDecoder.beginStructure(elementDescriptor);
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
                if (decodeElementIndex != -1) {
                    readMapEntry(beginStructure, decodeElementIndex);
                    int i2 = this.appsProcessed + 1;
                    this.appsProcessed = i2;
                    this.onAppProcessed.invoke(Integer.valueOf(i2));
                } else {
                    beginStructure.endStructure(elementDescriptor);
                    return;
                }
            }
        }

        private final void readMapEntry(CompositeDecoder compositeDecoder, int i) {
            JsonObject jsonObject;
            int mapCapacity;
            String decodeStringElement = compositeDecoder.decodeStringElement(getDescriptor(), i);
            compositeDecoder.decodeElementIndex(getDescriptor());
            JsonElement jsonElement = (JsonElement) CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), i + 1, JsonElement.Companion.serializer(), null, 8, null);
            LinkedHashMap linkedHashMap = null;
            if (jsonElement instanceof JsonNull) {
                this.this$0.indexStreamReceiver.receivePackageMetadataDiff(decodeStringElement, null);
                return;
            }
            JsonElement jsonElement2 = (JsonElement) JsonElementKt.getJsonObject(jsonElement).get((Object) "metadata");
            if (jsonElement2 instanceof JsonNull) {
                this.this$0.indexStreamReceiver.receivePackageMetadataDiff(decodeStringElement, null);
            } else if (jsonElement2 instanceof JsonObject) {
                this.this$0.indexStreamReceiver.receivePackageMetadataDiff(decodeStringElement, (JsonObject) jsonElement2);
            }
            if (JsonElementKt.getJsonObject(jsonElement).get((Object) "versions") instanceof JsonNull) {
                this.this$0.indexStreamReceiver.receiveVersionsDiff(decodeStringElement, null);
                return;
            }
            JsonElement jsonElement3 = (JsonElement) JsonElementKt.getJsonObject(jsonElement).get((Object) "versions");
            if (jsonElement3 != null && (jsonObject = JsonElementKt.getJsonObject(jsonElement3)) != null) {
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(jsonObject.size());
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
                for (Map.Entry entry : jsonObject.entrySet()) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue() instanceof JsonNull ? null : JsonElementKt.getJsonObject((JsonElement) entry.getValue()));
                }
                linkedHashMap = linkedHashMap2;
            }
            if (linkedHashMap != null) {
                this.this$0.indexStreamReceiver.receiveVersionsDiff(decodeStringElement, linkedHashMap);
            }
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder, IndexV2 indexV2) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            throw new IllegalStateException("Not implemented".toString());
        }
    }
}
