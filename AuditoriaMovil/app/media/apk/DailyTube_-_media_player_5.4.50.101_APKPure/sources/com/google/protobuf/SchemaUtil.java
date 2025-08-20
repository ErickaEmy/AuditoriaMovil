package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public final class SchemaUtil {
    public static final Class<?> y = fh();

    /* renamed from: n3  reason: collision with root package name */
    public static final UnknownFieldSchema<?, ?> f6509n3 = rz();

    /* renamed from: zn  reason: collision with root package name */
    public static final UnknownFieldSchema<?, ?> f6510zn = new UnknownFieldSetLiteSchema();

    public static int a(int i, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z2) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.gv(size * 4);
        }
        return size * CodedOutputStream.computeFixed32Size(i, 0);
    }

    public static void a8(int i, String str, Writer writer) throws IOException {
        if (str != null && !str.isEmpty()) {
            writer.writeString(i, str);
        }
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB c(Object obj, int i, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                Integer num = list.get(i6);
                int intValue = num.intValue();
                if (enumLiteMap.findValueByNumber(intValue) != null) {
                    if (i6 != i5) {
                        list.set(i5, num);
                    }
                    i5++;
                } else {
                    ub = (UB) ud(obj, i, intValue, ub, unknownFieldSchema);
                }
            }
            if (i5 != size) {
                list.subList(i5, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (enumLiteMap.findValueByNumber(intValue2) == null) {
                    ub = (UB) ud(obj, i, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static int c5(List<?> list) {
        return list.size() * 8;
    }

    public static int co(int i, List<Long> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int z3 = z(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.gv(z3);
        }
        return z3 + (size * CodedOutputStream.computeTagSize(i));
    }

    public static <T> void d(MapFieldSchema mapFieldSchema, T t2, T t3, long j2) {
        UnsafeUtil.f7(t2, j2, mapFieldSchema.mergeFrom(UnsafeUtil.ej(t2, j2), UnsafeUtil.ej(t3, j2)));
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB d0(Object obj, int i, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                Integer num = list.get(i6);
                int intValue = num.intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i6 != i5) {
                        list.set(i5, num);
                    }
                    i5++;
                } else {
                    ub = (UB) ud(obj, i, intValue, ub, unknownFieldSchema);
                }
            }
            if (i5 != size) {
                list.subList(i5, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!enumVerifier.isInRange(intValue2)) {
                    ub = (UB) ud(obj, i, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static boolean ej(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static int f(int i, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t2 = t(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.gv(t2);
        }
        return t2 + (size * CodedOutputStream.computeTagSize(i));
    }

    public static int f3(int i, List<Long> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int n2 = n(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.gv(n2);
        }
        return n2 + (size * CodedOutputStream.computeTagSize(i));
    }

    public static int fb(List<?> list) {
        return list.size() * 4;
    }

    public static Class<?> fh() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int gv(int i, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int v2 = v(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.gv(v2);
        }
        return v2 + (size * CodedOutputStream.computeTagSize(i));
    }

    public static int i4(List<Integer> list) {
        int i;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
        } else {
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeUInt32SizeNoTag(list.get(i5).intValue());
                i5++;
            }
        }
        return i;
    }

    public static int i9(int i, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += CodedOutputStream.n3(i, list.get(i6), schema);
        }
        return i5;
    }

    public static Class<?> mg() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int mt(List<Integer> list) {
        int i;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
        } else {
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeSInt32SizeNoTag(list.get(i5).intValue());
                i5++;
            }
        }
        return i;
    }

    public static int n(List<Long> list) {
        int i;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i5));
                i5++;
            }
        } else {
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeUInt64SizeNoTag(list.get(i5).longValue());
                i5++;
            }
        }
        return i;
    }

    public static int n3(List<?> list) {
        return list.size();
    }

    public static int p(int i, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int mt2 = mt(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.gv(mt2);
        }
        return mt2 + (size * CodedOutputStream.computeTagSize(i));
    }

    public static int r(int i, List<?> list) {
        int computeStringSizeNoTag;
        int computeStringSizeNoTag2;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i5 < size) {
                Object raw = lazyStringList.getRaw(i5);
                if (raw instanceof ByteString) {
                    computeStringSizeNoTag2 = CodedOutputStream.computeBytesSizeNoTag((ByteString) raw);
                } else {
                    computeStringSizeNoTag2 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                computeTagSize += computeStringSizeNoTag2;
                i5++;
            }
        } else {
            while (i5 < size) {
                Object obj = list.get(i5);
                if (obj instanceof ByteString) {
                    computeStringSizeNoTag = CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                } else {
                    computeStringSizeNoTag = CodedOutputStream.computeStringSizeNoTag((String) obj);
                }
                computeTagSize += computeStringSizeNoTag;
                i5++;
            }
        }
        return computeTagSize;
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = y) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    public static UnknownFieldSchema<?, ?> rz() {
        try {
            Class<?> mg2 = mg();
            if (mg2 == null) {
                return null;
            }
            return (UnknownFieldSchema) mg2.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int s(int i, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z2) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.gv(size * 8);
        }
        return size * CodedOutputStream.computeFixed64Size(i, 0L);
    }

    public static boolean shouldUseTableSwitch(int i, int i5, int i6) {
        if (i5 < 40) {
            return true;
        }
        long j2 = i5 - i;
        long j4 = i6;
        return j2 + 10 <= ((2 * j4) + 3) + ((j4 + 3) * 3);
    }

    public static int t(List<Integer> list) {
        int i;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
        } else {
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeInt32SizeNoTag(list.get(i5).intValue());
                i5++;
            }
        }
        return i;
    }

    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void ta(ExtensionSchema<FT> extensionSchema, T t2, T t3) {
        FieldSet<FT> zn2 = extensionSchema.zn(t3);
        if (!zn2.w()) {
            extensionSchema.gv(t2).mergeFrom(zn2);
        }
    }

    public static int tl(int i, List<Long> list, boolean z2) {
        if (list.size() == 0) {
            return 0;
        }
        int wz2 = wz(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.gv(wz2);
        }
        return wz2 + (list.size() * CodedOutputStream.computeTagSize(i));
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB ud(Object obj, int i, int i5, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.a(obj);
        }
        unknownFieldSchema.v(ub, i, i5);
        return ub;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetFullSchema() {
        return f6509n3;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return f6510zn;
    }

    public static int v(List<Integer> list) {
        int i;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
        } else {
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeEnumSizeNoTag(list.get(i5).intValue());
                i5++;
            }
        }
        return i;
    }

    public static int w(int i, List<?> list, Schema schema) {
        int a2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof LazyFieldLite) {
                a2 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                a2 = CodedOutputStream.a((MessageLite) obj, schema);
            }
            computeTagSize += a2;
        }
        return computeTagSize;
    }

    public static void writeBool(int i, boolean z2, Writer writer) throws IOException {
        if (z2) {
            writer.writeBool(i, true);
        }
    }

    public static void writeBoolList(int i, List<Boolean> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBoolList(i, list, z2);
        }
    }

    public static void writeBytes(int i, ByteString byteString, Writer writer) throws IOException {
        if (byteString != null && !byteString.isEmpty()) {
            writer.writeBytes(i, byteString);
        }
    }

    public static void writeBytesList(int i, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBytesList(i, list);
        }
    }

    public static void writeDouble(int i, double d2, Writer writer) throws IOException {
        if (Double.doubleToRawLongBits(d2) != 0) {
            writer.writeDouble(i, d2);
        }
    }

    public static void writeDoubleList(int i, List<Double> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeDoubleList(i, list, z2);
        }
    }

    public static void writeEnum(int i, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeEnum(i, i5);
        }
    }

    public static void writeEnumList(int i, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeEnumList(i, list, z2);
        }
    }

    public static void writeFixed32(int i, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeFixed32(i, i5);
        }
    }

    public static void writeFixed32List(int i, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed32List(i, list, z2);
        }
    }

    public static void writeFixed64(int i, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.writeFixed64(i, j2);
        }
    }

    public static void writeFixed64List(int i, List<Long> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed64List(i, list, z2);
        }
    }

    public static void writeFloat(int i, float f4, Writer writer) throws IOException {
        if (Float.floatToRawIntBits(f4) != 0) {
            writer.writeFloat(i, f4);
        }
    }

    public static void writeFloatList(int i, List<Float> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFloatList(i, list, z2);
        }
    }

    public static void writeGroupList(int i, List<?> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(i, list);
    }

    public static void writeInt32(int i, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeInt32(i, i5);
        }
    }

    public static void writeInt32List(int i, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt32List(i, list, z2);
        }
    }

    public static void writeInt64(int i, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.writeInt64(i, j2);
        }
    }

    public static void writeInt64List(int i, List<Long> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt64List(i, list, z2);
        }
    }

    public static void writeLazyFieldList(int i, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                ((LazyFieldLite) it.next()).gv(writer, i);
            }
        }
    }

    public static void writeMessage(int i, Object obj, Writer writer) throws IOException {
        if (obj != null) {
            writer.writeMessage(i, obj);
        }
    }

    public static void writeMessageList(int i, List<?> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(i, list);
    }

    public static void writeSFixed32(int i, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeSFixed32(i, i5);
        }
    }

    public static void writeSFixed32List(int i, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed32List(i, list, z2);
        }
    }

    public static void writeSFixed64(int i, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.writeSFixed64(i, j2);
        }
    }

    public static void writeSFixed64List(int i, List<Long> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed64List(i, list, z2);
        }
    }

    public static void writeSInt32(int i, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeSInt32(i, i5);
        }
    }

    public static void writeSInt32List(int i, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt32List(i, list, z2);
        }
    }

    public static void writeSInt64(int i, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.writeSInt64(i, j2);
        }
    }

    public static void writeSInt64List(int i, List<Long> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt64List(i, list, z2);
        }
    }

    public static void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            a8(i, (String) obj, writer);
        } else {
            writeBytes(i, (ByteString) obj, writer);
        }
    }

    public static void writeStringList(int i, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeStringList(i, list);
        }
    }

    public static void writeUInt32(int i, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeUInt32(i, i5);
        }
    }

    public static void writeUInt32List(int i, List<Integer> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt32List(i, list, z2);
        }
    }

    public static void writeUInt64(int i, long j2, Writer writer) throws IOException {
        if (j2 != 0) {
            writer.writeUInt64(i, j2);
        }
    }

    public static void writeUInt64List(int i, List<Long> list, Writer writer, boolean z2) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt64List(i, list, z2);
        }
    }

    public static int wz(List<Long> list) {
        int i;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i5));
                i5++;
            }
        } else {
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeInt64SizeNoTag(list.get(i5).longValue());
                i5++;
            }
        }
        return i;
    }

    public static int x4(int i, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i42 = i4(list);
        if (z2) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.gv(i42);
        }
        return i42 + (size * CodedOutputStream.computeTagSize(i));
    }

    public static int xc(int i, Object obj, Schema schema) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.computeLazyFieldSize(i, (LazyFieldLite) obj);
        }
        return CodedOutputStream.v(i, (MessageLite) obj, schema);
    }

    public static int y(int i, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z2) {
            return CodedOutputStream.computeTagSize(i) + CodedOutputStream.gv(size);
        }
        return size * CodedOutputStream.computeBoolSize(i, true);
    }

    public static int z(List<Long> list) {
        int i;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i5));
                i5++;
            }
        } else {
            i = 0;
            while (i5 < size) {
                i += CodedOutputStream.computeSInt64SizeNoTag(list.get(i5).longValue());
                i5++;
            }
        }
        return i;
    }

    public static <T, UT, UB> void z6(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t2, T t3) {
        unknownFieldSchema.w(t2, unknownFieldSchema.f(unknownFieldSchema.fb(t2), unknownFieldSchema.fb(t3)));
    }

    public static int zn(int i, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = size * CodedOutputStream.computeTagSize(i);
        for (int i5 = 0; i5 < list.size(); i5++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i5));
        }
        return computeTagSize;
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    public static void writeGroupList(int i, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(i, list, schema);
    }

    public static void writeMessageList(int i, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(i, list, schema);
    }
}
