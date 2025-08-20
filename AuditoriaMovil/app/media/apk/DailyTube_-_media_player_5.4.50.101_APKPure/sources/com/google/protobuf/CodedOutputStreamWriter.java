package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public final class CodedOutputStreamWriter implements Writer {
    public final CodedOutputStream y;

    /* renamed from: com.google.protobuf.CodedOutputStreamWriter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            y = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                y[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                y[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                y[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                y[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                y[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                y[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                y[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.n3(codedOutputStream, "output");
        this.y = codedOutputStream2;
        codedOutputStream2.y = this;
    }

    private void a(int i, Object obj) throws IOException {
        if (obj instanceof String) {
            this.y.writeString(i, (String) obj);
        } else {
            this.y.writeBytes(i, (ByteString) obj);
        }
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.y;
        if (codedOutputStreamWriter != null) {
            return codedOutputStreamWriter;
        }
        return new CodedOutputStreamWriter(codedOutputStream);
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.y.getTotalBytesWritten();
    }

    public final <K, V> void gv(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.y[metadata.keyType.ordinal()]) {
            case 1:
                V v2 = map.get(Boolean.FALSE);
                if (v2 != null) {
                    y(i, false, v2, metadata);
                }
                V v3 = map.get(Boolean.TRUE);
                if (v3 != null) {
                    y(i, true, v3, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                n3(i, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                zn(i, metadata, map);
                return;
            case 12:
                v(i, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
        }
    }

    public final <V> void n3(int i, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        int i5 = 0;
        for (Integer num : map.keySet()) {
            iArr[i5] = num.intValue();
            i5++;
        }
        Arrays.sort(iArr);
        for (int i6 = 0; i6 < size; i6++) {
            int i8 = iArr[i6];
            V v2 = map.get(Integer.valueOf(i8));
            this.y.writeTag(i, 2);
            this.y.writeUInt32NoTag(MapEntryLite.y(metadata, Integer.valueOf(i8), v2));
            MapEntryLite.v(this.y, metadata, Integer.valueOf(i8), v2);
        }
    }

    public final <V> void v(int i, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        int i5 = 0;
        for (String str : map.keySet()) {
            strArr[i5] = str;
            i5++;
        }
        Arrays.sort(strArr);
        for (int i6 = 0; i6 < size; i6++) {
            String str2 = strArr[i6];
            V v2 = map.get(str2);
            this.y.writeTag(i, 2);
            this.y.writeUInt32NoTag(MapEntryLite.y(metadata, str2, v2));
            MapEntryLite.v(this.y, metadata, str2, v2);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeBool(int i, boolean z2) throws IOException {
        this.y.writeBool(i, z2);
    }

    @Override // com.google.protobuf.Writer
    public void writeBoolList(int i, List<Boolean> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeBoolSizeNoTag(list.get(i8).booleanValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeBoolNoTag(list.get(i5).booleanValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeBool(i, list.get(i5).booleanValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeBytes(int i, ByteString byteString) throws IOException {
        this.y.writeBytes(i, byteString);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytesList(int i, List<ByteString> list) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.y.writeBytes(i, list.get(i5));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeDouble(int i, double d2) throws IOException {
        this.y.writeDouble(i, d2);
    }

    @Override // com.google.protobuf.Writer
    public void writeDoubleList(int i, List<Double> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeDoubleSizeNoTag(list.get(i8).doubleValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeDoubleNoTag(list.get(i5).doubleValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeDouble(i, list.get(i5).doubleValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int i) throws IOException {
        this.y.writeTag(i, 4);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnum(int i, int i5) throws IOException {
        this.y.writeEnum(i, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnumList(int i, List<Integer> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeEnumSizeNoTag(list.get(i8).intValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeEnumNoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeEnum(i, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32(int i, int i5) throws IOException {
        this.y.writeFixed32(i, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32List(int i, List<Integer> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeFixed32SizeNoTag(list.get(i8).intValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeFixed32NoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeFixed32(i, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64(int i, long j2) throws IOException {
        this.y.writeFixed64(i, j2);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64List(int i, List<Long> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeFixed64SizeNoTag(list.get(i8).longValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeFixed64NoTag(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeFixed64(i, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFloat(int i, float f4) throws IOException {
        this.y.writeFloat(i, f4);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloatList(int i, List<Float> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeFloatSizeNoTag(list.get(i8).floatValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeFloatNoTag(list.get(i5).floatValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeFloat(i, list.get(i5).floatValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroup(int i, Object obj) throws IOException {
        this.y.writeGroup(i, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroupList(int i, List<?> list) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            writeGroup(i, list.get(i5));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32(int i, int i5) throws IOException {
        this.y.writeInt32(i, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32List(int i, List<Integer> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeInt32SizeNoTag(list.get(i8).intValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeInt32NoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeInt32(i, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64(int i, long j2) throws IOException {
        this.y.writeInt64(i, j2);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64List(int i, List<Long> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeInt64SizeNoTag(list.get(i8).longValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeInt64NoTag(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeInt64(i, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.y.c5()) {
            gv(i, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.y.writeTag(i, 2);
            this.y.writeUInt32NoTag(MapEntryLite.y(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.v(this.y, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i, Object obj) throws IOException {
        this.y.writeMessage(i, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int i, List<?> list) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            writeMessage(i, list.get(i5));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int i, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.y.writeRawMessageSetExtension(i, (ByteString) obj);
        } else {
            this.y.writeMessageSetExtension(i, (MessageLite) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32(int i, int i5) throws IOException {
        this.y.writeSFixed32(i, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32List(int i, List<Integer> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i8).intValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeSFixed32NoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeSFixed32(i, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64(int i, long j2) throws IOException {
        this.y.writeSFixed64(i, j2);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64List(int i, List<Long> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i8).longValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeSFixed64NoTag(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeSFixed64(i, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32(int i, int i5) throws IOException {
        this.y.writeSInt32(i, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32List(int i, List<Integer> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i8).intValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeSInt32NoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeSInt32(i, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64(int i, long j2) throws IOException {
        this.y.writeSInt64(i, j2);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64List(int i, List<Long> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i8).longValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeSInt64NoTag(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeSInt64(i, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int i) throws IOException {
        this.y.writeTag(i, 3);
    }

    @Override // com.google.protobuf.Writer
    public void writeString(int i, String str) throws IOException {
        this.y.writeString(i, str);
    }

    @Override // com.google.protobuf.Writer
    public void writeStringList(int i, List<String> list) throws IOException {
        int i5 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i5 < list.size()) {
                a(i, lazyStringList.getRaw(i5));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeString(i, list.get(i5));
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32(int i, int i5) throws IOException {
        this.y.writeUInt32(i, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32List(int i, List<Integer> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i8).intValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeUInt32NoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeUInt32(i, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64(int i, long j2) throws IOException {
        this.y.writeUInt64(i, j2);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64List(int i, List<Long> list, boolean z2) throws IOException {
        int i5 = 0;
        if (z2) {
            this.y.writeTag(i, 2);
            int i6 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i6 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i8).longValue());
            }
            this.y.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.y.writeUInt64NoTag(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.y.writeUInt64(i, list.get(i5).longValue());
            i5++;
        }
    }

    public final <V> void y(int i, boolean z2, V v2, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.y.writeTag(i, 2);
        this.y.writeUInt32NoTag(MapEntryLite.y(metadata, Boolean.valueOf(z2), v2));
        MapEntryLite.v(this.y, metadata, Boolean.valueOf(z2), v2);
    }

    public final <V> void zn(int i, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        int i5 = 0;
        for (Long l2 : map.keySet()) {
            jArr[i5] = l2.longValue();
            i5++;
        }
        Arrays.sort(jArr);
        for (int i6 = 0; i6 < size; i6++) {
            long j2 = jArr[i6];
            V v2 = map.get(Long.valueOf(j2));
            this.y.writeTag(i, 2);
            this.y.writeUInt32NoTag(MapEntryLite.y(metadata, Long.valueOf(j2), v2));
            MapEntryLite.v(this.y, metadata, Long.valueOf(j2), v2);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int i, Object obj, Schema schema) throws IOException {
        this.y.t(i, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i, Object obj, Schema schema) throws IOException {
        this.y.wz(i, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int i, List<?> list, Schema schema) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            writeGroup(i, list.get(i5), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int i, List<?> list, Schema schema) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            writeMessage(i, list.get(i5), schema);
        }
    }
}
