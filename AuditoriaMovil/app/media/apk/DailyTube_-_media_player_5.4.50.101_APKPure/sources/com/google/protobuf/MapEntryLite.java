package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
/* loaded from: classes.dex */
public class MapEntryLite<K, V> {

    /* renamed from: n3  reason: collision with root package name */
    public final K f6473n3;
    public final Metadata<K, V> y;

    /* renamed from: zn  reason: collision with root package name */
    public final V f6474zn;

    /* renamed from: com.google.protobuf.MapEntryLite$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            y = iArr;
            try {
                iArr[WireFormat.FieldType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[WireFormat.FieldType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[WireFormat.FieldType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType fieldType, K k2, WireFormat.FieldType fieldType2, V v2) {
            this.keyType = fieldType;
            this.defaultKey = k2;
            this.valueType = fieldType2;
            this.defaultValue = v2;
        }
    }

    public MapEntryLite(WireFormat.FieldType fieldType, K k2, WireFormat.FieldType fieldType2, V v2) {
        this.y = new Metadata<>(fieldType, k2, fieldType2, v2);
        this.f6473n3 = k2;
        this.f6474zn = v2;
    }

    public static <T> T gv(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat.FieldType fieldType, T t2) throws IOException {
        int i = AnonymousClass1.y[fieldType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return (T) FieldSet.readPrimitiveField(codedInputStream, fieldType, true);
                }
                throw new RuntimeException("Groups are not allowed in maps.");
            }
            return (T) Integer.valueOf(codedInputStream.readEnum());
        }
        MessageLite.Builder builder = ((MessageLite) t2).toBuilder();
        codedInputStream.readMessage(builder, extensionRegistryLite);
        return (T) builder.buildPartial();
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType fieldType, K k2, WireFormat.FieldType fieldType2, V v2) {
        return new MapEntryLite<>(fieldType, k2, fieldType2, v2);
    }

    public static <K, V> void v(CodedOutputStream codedOutputStream, Metadata<K, V> metadata, K k2, V v2) throws IOException {
        FieldSet.x4(codedOutputStream, metadata.keyType, 1, k2);
        FieldSet.x4(codedOutputStream, metadata.valueType, 2, v2);
    }

    public static <K, V> int y(Metadata<K, V> metadata, K k2, V v2) {
        return FieldSet.f(metadata.keyType, 1, k2) + FieldSet.f(metadata.valueType, 2, v2);
    }

    public static <K, V> Map.Entry<K, V> zn(CodedInputStream codedInputStream, Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.y(1, metadata.keyType.getWireType())) {
                obj = gv(codedInputStream, extensionRegistryLite, metadata.keyType, obj);
            } else if (readTag == WireFormat.y(2, metadata.valueType.getWireType())) {
                obj2 = gv(codedInputStream, extensionRegistryLite, metadata.valueType, obj2);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public int computeMessageSize(int i, K k2, V v2) {
        return CodedOutputStream.computeTagSize(i) + CodedOutputStream.gv(y(this.y, k2, v2));
    }

    public K getKey() {
        return this.f6473n3;
    }

    public V getValue() {
        return this.f6474zn;
    }

    public Metadata<K, V> n3() {
        return this.y;
    }

    public Map.Entry<K, V> parseEntry(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return zn(byteString.newCodedInput(), this.y, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void parseInto(MapFieldLite<K, V> mapFieldLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
        Metadata<K, V> metadata = this.y;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.y(1, this.y.keyType.getWireType())) {
                obj = gv(codedInputStream, extensionRegistryLite, this.y.keyType, obj);
            } else if (readTag == WireFormat.y(2, this.y.valueType.getWireType())) {
                obj2 = gv(codedInputStream, extensionRegistryLite, this.y.valueType, obj2);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        codedInputStream.checkLastTagWas(0);
        codedInputStream.popLimit(pushLimit);
        mapFieldLite.put(obj, obj2);
    }

    public void serializeTo(CodedOutputStream codedOutputStream, int i, K k2, V v2) throws IOException {
        codedOutputStream.writeTag(i, 2);
        codedOutputStream.writeUInt32NoTag(y(this.y, k2, v2));
        v(codedOutputStream, this.y, k2, v2);
    }
}
