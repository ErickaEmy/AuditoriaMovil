package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyField;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FieldSet<T extends FieldDescriptorLite<T>> {

    /* renamed from: gv  reason: collision with root package name */
    public static final FieldSet f6423gv = new FieldSet(true);

    /* renamed from: n3  reason: collision with root package name */
    public boolean f6424n3;
    public final SmallSortedMap<T, Object> y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f6425zn;

    /* renamed from: com.google.protobuf.FieldSet$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: n3  reason: collision with root package name */
        public static final /* synthetic */ int[] f6426n3;
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f6426n3 = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6426n3[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6426n3[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6426n3[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6426n3[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6426n3[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6426n3[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6426n3[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6426n3[WireFormat.FieldType.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6426n3[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6426n3[WireFormat.FieldType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6426n3[WireFormat.FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6426n3[WireFormat.FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6426n3[WireFormat.FieldType.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6426n3[WireFormat.FieldType.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f6426n3[WireFormat.FieldType.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f6426n3[WireFormat.FieldType.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f6426n3[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            y = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                y[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                y[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                y[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                y[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                y[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                y[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                y[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                y[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder<T extends FieldDescriptorLite<T>> {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f6427gv;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f6428n3;
        public SmallSortedMap<T, Object> y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f6429zn;

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public static Object a(Object obj, boolean z2) {
            if (!(obj instanceof MessageLite.Builder)) {
                return obj;
            }
            MessageLite.Builder builder = (MessageLite.Builder) obj;
            if (z2) {
                return builder.buildPartial();
            }
            return builder.build();
        }

        public static <T extends FieldDescriptorLite<T>> void c5(Map.Entry<T, Object> entry, boolean z2) {
            entry.setValue(fb(entry.getKey(), entry.getValue(), z2));
        }

        public static <T extends FieldDescriptorLite<T>> Object fb(T t2, Object obj, boolean z2) {
            if (obj == null) {
                return obj;
            }
            if (t2.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
                if (t2.isRepeated()) {
                    if (obj instanceof List) {
                        List list = (List) obj;
                        for (int i = 0; i < list.size(); i++) {
                            Object obj2 = list.get(i);
                            Object a2 = a(obj2, z2);
                            if (a2 != obj2) {
                                if (list == obj) {
                                    list = new ArrayList(list);
                                }
                                list.set(i, a2);
                            }
                        }
                        return list;
                    }
                    throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + obj.getClass());
                }
                return a(obj, z2);
            }
            return obj;
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> fieldSet) {
            Builder<T> builder = new Builder<>(FieldSet.s(fieldSet.y, true));
            builder.f6428n3 = fieldSet.f6425zn;
            return builder;
        }

        public static <T extends FieldDescriptorLite<T>> void s(SmallSortedMap<T, Object> smallSortedMap, boolean z2) {
            for (int i = 0; i < smallSortedMap.getNumArrayEntries(); i++) {
                c5(smallSortedMap.getArrayEntryAt(i), z2);
            }
            for (Map.Entry<T, Object> entry : smallSortedMap.getOverflowEntries()) {
                c5(entry, z2);
            }
        }

        public void addRepeatedField(T t2, Object obj) {
            boolean z2;
            List list;
            n3();
            if (t2.isRepeated()) {
                if (!this.f6427gv && !(obj instanceof MessageLite.Builder)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.f6427gv = z2;
                i9(t2, obj);
                Object zn2 = zn(t2);
                if (zn2 == null) {
                    list = new ArrayList();
                    this.y.put((SmallSortedMap<T, Object>) t2, (T) list);
                } else {
                    list = (List) zn2;
                }
                list.add(obj);
                return;
            }
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }

        public FieldSet<T> build() {
            return y(false);
        }

        public FieldSet<T> buildPartial() {
            return y(true);
        }

        public void clearField(T t2) {
            n3();
            this.y.remove(t2);
            if (this.y.isEmpty()) {
                this.f6428n3 = false;
            }
        }

        public Map<T, Object> getAllFields() {
            if (this.f6428n3) {
                SmallSortedMap s2 = FieldSet.s(this.y, false);
                if (this.y.isImmutable()) {
                    s2.makeImmutable();
                } else {
                    s(s2, true);
                }
                return s2;
            } else if (this.y.isImmutable()) {
                return this.y;
            } else {
                return Collections.unmodifiableMap(this.y);
            }
        }

        public Object getField(T t2) {
            return fb(t2, zn(t2), true);
        }

        public Object getRepeatedField(T t2, int i) {
            if (this.f6427gv) {
                n3();
            }
            return a(gv(t2, i), true);
        }

        public int getRepeatedFieldCount(T t2) {
            if (t2.isRepeated()) {
                Object zn2 = zn(t2);
                if (zn2 == null) {
                    return 0;
                }
                return ((List) zn2).size();
            }
            throw new IllegalArgumentException("getRepeatedFieldCount() can only be called on repeated fields.");
        }

        public Object gv(T t2, int i) {
            if (t2.isRepeated()) {
                Object zn2 = zn(t2);
                if (zn2 != null) {
                    return ((List) zn2).get(i);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public boolean hasField(T t2) {
            if (!t2.isRepeated()) {
                if (this.y.get(t2) != null) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public final void i9(T t2, Object obj) {
            if (!FieldSet.co(t2.getLiteType(), obj)) {
                if (t2.getLiteType().getJavaType() == WireFormat.JavaType.MESSAGE && (obj instanceof MessageLite.Builder)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t2.getNumber()), t2.getLiteType().getJavaType(), obj.getClass().getName()));
            }
        }

        public boolean isInitialized() {
            for (int i = 0; i < this.y.getNumArrayEntries(); i++) {
                if (!FieldSet.p(this.y.getArrayEntryAt(i))) {
                    return false;
                }
            }
            for (Map.Entry<T, Object> entry : this.y.getOverflowEntries()) {
                if (!FieldSet.p(entry)) {
                    return false;
                }
            }
            return true;
        }

        public void mergeFrom(FieldSet<T> fieldSet) {
            n3();
            for (int i = 0; i < fieldSet.y.getNumArrayEntries(); i++) {
                v(fieldSet.y.getArrayEntryAt(i));
            }
            for (Map.Entry<T, Object> entry : fieldSet.y.getOverflowEntries()) {
                v(entry);
            }
        }

        public final void n3() {
            if (!this.f6429zn) {
                this.y = FieldSet.s(this.y, true);
                this.f6429zn = true;
            }
        }

        public void setField(T t2, Object obj) {
            boolean z2;
            n3();
            boolean z3 = false;
            if (t2.isRepeated()) {
                if (obj instanceof List) {
                    ArrayList arrayList = new ArrayList((List) obj);
                    for (Object obj2 : arrayList) {
                        i9(t2, obj2);
                        if (!this.f6427gv && !(obj2 instanceof MessageLite.Builder)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        this.f6427gv = z2;
                    }
                    obj = arrayList;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            } else {
                i9(t2, obj);
            }
            if (obj instanceof LazyField) {
                this.f6428n3 = true;
            }
            this.f6427gv = (this.f6427gv || (obj instanceof MessageLite.Builder)) ? true : true;
            this.y.put((SmallSortedMap<T, Object>) t2, (T) obj);
        }

        public void setRepeatedField(T t2, int i, Object obj) {
            boolean z2;
            n3();
            if (t2.isRepeated()) {
                if (!this.f6427gv && !(obj instanceof MessageLite.Builder)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.f6427gv = z2;
                Object zn2 = zn(t2);
                if (zn2 != null) {
                    i9(t2, obj);
                    ((List) zn2).set(i, obj);
                    return;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public final void v(Map.Entry<T, Object> entry) {
            T key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof LazyField) {
                value = ((LazyField) value).getValue();
            }
            if (key.isRepeated()) {
                List list = (List) zn(key);
                if (list == null) {
                    list = new ArrayList();
                    this.y.put((SmallSortedMap<T, Object>) key, (T) list);
                }
                for (Object obj : (List) value) {
                    list.add(FieldSet.i9(obj));
                }
            } else if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
                Object zn2 = zn(key);
                if (zn2 == null) {
                    this.y.put((SmallSortedMap<T, Object>) key, (T) FieldSet.i9(value));
                } else if (zn2 instanceof MessageLite.Builder) {
                    key.internalMergeFrom((MessageLite.Builder) zn2, (MessageLite) value);
                } else {
                    this.y.put((SmallSortedMap<T, Object>) key, (T) key.internalMergeFrom(((MessageLite) zn2).toBuilder(), (MessageLite) value).build());
                }
            } else {
                this.y.put((SmallSortedMap<T, Object>) key, (T) FieldSet.i9(value));
            }
        }

        public final FieldSet<T> y(boolean z2) {
            if (this.y.isEmpty()) {
                return FieldSet.emptySet();
            }
            this.f6429zn = false;
            SmallSortedMap<T, Object> smallSortedMap = this.y;
            if (this.f6427gv) {
                smallSortedMap = FieldSet.s(smallSortedMap, false);
                s(smallSortedMap, z2);
            }
            FieldSet<T> fieldSet = new FieldSet<>(smallSortedMap, null);
            fieldSet.f6425zn = this.f6428n3;
            return fieldSet;
        }

        public Object zn(T t2) {
            Object obj = this.y.get(t2);
            if (obj instanceof LazyField) {
                return ((LazyField) obj).getValue();
            }
            return obj;
        }

        public Builder() {
            this(SmallSortedMap.tl(16));
        }

        public Builder(SmallSortedMap<T, Object> smallSortedMap) {
            this.y = smallSortedMap;
            this.f6429zn = true;
        }
    }

    /* loaded from: classes.dex */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    public /* synthetic */ FieldSet(SmallSortedMap smallSortedMap, AnonymousClass1 anonymousClass1) {
        this(smallSortedMap);
    }

    public static <T extends FieldDescriptorLite<T>> void c5(Map<T, Object> map, Map.Entry<T, Object> entry, boolean z2) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            map.put(key, ((LazyField) value).getValue());
        } else if (z2 && (value instanceof List)) {
            map.put(key, new ArrayList((List) value));
        } else {
            map.put(key, value);
        }
    }

    public static boolean co(WireFormat.FieldType fieldType, Object obj) {
        Internal.y(obj);
        switch (AnonymousClass1.y[fieldType.getJavaType().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                    return true;
                }
                return false;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof Internal.EnumLite)) {
                    return true;
                }
                return false;
            case 9:
                if ((obj instanceof MessageLite) || (obj instanceof LazyField)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            List<Object> list = (List) obj;
            int i = 0;
            if (fieldDescriptorLite.isPacked()) {
                if (list.isEmpty()) {
                    return 0;
                }
                for (Object obj2 : list) {
                    i += t(liteType, obj2);
                }
                return CodedOutputStream.computeTagSize(number) + i + CodedOutputStream.computeUInt32SizeNoTag(i);
            }
            for (Object obj3 : list) {
                i += f(liteType, number, obj3);
            }
            return i;
        }
        return f(liteType, number, obj);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return f6423gv;
    }

    public static int f(WireFormat.FieldType fieldType, int i, Object obj) {
        int computeTagSize = CodedOutputStream.computeTagSize(i);
        if (fieldType == WireFormat.FieldType.GROUP) {
            computeTagSize *= 2;
        }
        return computeTagSize + t(fieldType, obj);
    }

    public static void i4(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.f6426n3[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                return;
            case 10:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.writeStringNoTag((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                    return;
                }
            case 13:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    codedOutputStream.writeEnumNoTag(((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static Object i9(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    public static boolean mt(Object obj) {
        if (obj instanceof MessageLiteOrBuilder) {
            return ((MessageLiteOrBuilder) obj).isInitialized();
        }
        if (obj instanceof LazyField) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
        return new Builder<>((AnonymousClass1) null);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet<>();
    }

    public static <T extends FieldDescriptorLite<T>> boolean p(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (key.isRepeated()) {
                for (Object obj : (List) entry.getValue()) {
                    if (!mt(obj)) {
                        return false;
                    }
                }
                return true;
            }
            return mt(entry.getValue());
        }
        return true;
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z2) throws IOException {
        if (z2) {
            return WireFormat.n3(codedInputStream, fieldType, WireFormat.Utf8Validation.STRICT);
        }
        return WireFormat.n3(codedInputStream, fieldType, WireFormat.Utf8Validation.LOOSE);
    }

    public static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> s(SmallSortedMap<T, Object> smallSortedMap, boolean z2) {
        SmallSortedMap<T, Object> tl2 = SmallSortedMap.tl(16);
        for (int i = 0; i < smallSortedMap.getNumArrayEntries(); i++) {
            c5(tl2, smallSortedMap.getArrayEntryAt(i), z2);
        }
        for (Map.Entry<T, Object> entry : smallSortedMap.getOverflowEntries()) {
            c5(tl2, entry, z2);
        }
        return tl2;
    }

    public static int t(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.f6426n3[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 10:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj);
                }
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                }
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                }
                return CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 13:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber());
                }
                return CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static void writeField(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            List<Object> list = (List) obj;
            if (fieldDescriptorLite.isPacked()) {
                if (list.isEmpty()) {
                    return;
                }
                codedOutputStream.writeTag(number, 2);
                int i = 0;
                for (Object obj2 : list) {
                    i += t(liteType, obj2);
                }
                codedOutputStream.writeUInt32NoTag(i);
                for (Object obj3 : list) {
                    i4(codedOutputStream, liteType, obj3);
                }
                return;
            }
            for (Object obj4 : list) {
                x4(codedOutputStream, liteType, number, obj4);
            }
        } else if (obj instanceof LazyField) {
            x4(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
        } else {
            x4(codedOutputStream, liteType, number, obj);
        }
    }

    public static void x4(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i, (MessageLite) obj);
            return;
        }
        codedOutputStream.writeTag(i, xc(fieldType, false));
        i4(codedOutputStream, fieldType, obj);
    }

    public static int xc(WireFormat.FieldType fieldType, boolean z2) {
        if (z2) {
            return 2;
        }
        return fieldType.getWireType();
    }

    public void addRepeatedField(T t2, Object obj) {
        List list;
        if (t2.isRepeated()) {
            r(t2, obj);
            Object field = getField(t2);
            if (field == null) {
                list = new ArrayList();
                this.y.put((SmallSortedMap<T, Object>) t2, (T) list);
            } else {
                list = (List) field;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void clear() {
        this.y.clear();
        this.f6425zn = false;
    }

    public void clearField(T t2) {
        this.y.remove(t2);
        if (this.y.isEmpty()) {
            this.f6425zn = false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldSet)) {
            return false;
        }
        return this.y.equals(((FieldSet) obj).y);
    }

    public final void f3(Map.Entry<T, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        T key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated() && !key.isPacked()) {
            Object value = entry.getValue();
            if (value instanceof LazyField) {
                codedOutputStream.writeRawMessageSetExtension(entry.getKey().getNumber(), ((LazyField) value).toByteString());
                return;
            }
            codedOutputStream.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite) value);
            return;
        }
        writeField(key, entry.getValue(), codedOutputStream);
    }

    public Map<T, Object> getAllFields() {
        if (this.f6425zn) {
            SmallSortedMap s2 = s(this.y, false);
            if (this.y.isImmutable()) {
                s2.makeImmutable();
            }
            return s2;
        } else if (this.y.isImmutable()) {
            return this.y;
        } else {
            return Collections.unmodifiableMap(this.y);
        }
    }

    public Object getField(T t2) {
        Object obj = this.y.get(t2);
        if (obj instanceof LazyField) {
            return ((LazyField) obj).getValue();
        }
        return obj;
    }

    public int getMessageSetSerializedSize() {
        int i = 0;
        for (int i5 = 0; i5 < this.y.getNumArrayEntries(); i5++) {
            i += wz(this.y.getArrayEntryAt(i5));
        }
        for (Map.Entry<T, Object> entry : this.y.getOverflowEntries()) {
            i += wz(entry);
        }
        return i;
    }

    public Object getRepeatedField(T t2, int i) {
        if (t2.isRepeated()) {
            Object field = getField(t2);
            if (field != null) {
                return ((List) field).get(i);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getRepeatedFieldCount(T t2) {
        if (t2.isRepeated()) {
            Object field = getField(t2);
            if (field == null) {
                return 0;
            }
            return ((List) field).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getSerializedSize() {
        int i = 0;
        for (int i5 = 0; i5 < this.y.getNumArrayEntries(); i5++) {
            Map.Entry<T, Object> arrayEntryAt = this.y.getArrayEntryAt(i5);
            i += computeFieldSize(arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry<T, Object> entry : this.y.getOverflowEntries()) {
            i += computeFieldSize(entry.getKey(), entry.getValue());
        }
        return i;
    }

    public boolean hasField(T t2) {
        if (!t2.isRepeated()) {
            if (this.y.get(t2) != null) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    public boolean isImmutable() {
        return this.f6424n3;
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.y.getNumArrayEntries(); i++) {
            if (!p(this.y.getArrayEntryAt(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.y.getOverflowEntries()) {
            if (!p(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> iterator() {
        if (this.f6425zn) {
            return new LazyField.LazyIterator(this.y.entrySet().iterator());
        }
        return this.y.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.f6424n3) {
            return;
        }
        for (int i = 0; i < this.y.getNumArrayEntries(); i++) {
            Map.Entry<T, Object> arrayEntryAt = this.y.getArrayEntryAt(i);
            if (arrayEntryAt.getValue() instanceof GeneratedMessageLite) {
                ((GeneratedMessageLite) arrayEntryAt.getValue()).makeImmutable();
            }
        }
        this.y.makeImmutable();
        this.f6424n3 = true;
    }

    public void mergeFrom(FieldSet<T> fieldSet) {
        for (int i = 0; i < fieldSet.y.getNumArrayEntries(); i++) {
            z(fieldSet.y.getArrayEntryAt(i));
        }
        for (Map.Entry<T, Object> entry : fieldSet.y.getOverflowEntries()) {
            z(entry);
        }
    }

    public final void r(T t2, Object obj) {
        if (co(t2.getLiteType(), obj)) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t2.getNumber()), t2.getLiteType().getJavaType(), obj.getClass().getName()));
    }

    public void setField(T t2, Object obj) {
        if (t2.isRepeated()) {
            if (obj instanceof List) {
                ArrayList<Object> arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                for (Object obj2 : arrayList) {
                    r(t2, obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            r(t2, obj);
        }
        if (obj instanceof LazyField) {
            this.f6425zn = true;
        }
        this.y.put((SmallSortedMap<T, Object>) t2, (T) obj);
    }

    public void setRepeatedField(T t2, int i, Object obj) {
        if (t2.isRepeated()) {
            Object field = getField(t2);
            if (field != null) {
                r(t2, obj);
                ((List) field).set(i, obj);
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public Iterator<Map.Entry<T, Object>> tl() {
        if (this.f6425zn) {
            return new LazyField.LazyIterator(this.y.i9().iterator());
        }
        return this.y.i9().iterator();
    }

    public boolean w() {
        return this.y.isEmpty();
    }

    public void writeMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.y.getNumArrayEntries(); i++) {
            f3(this.y.getArrayEntryAt(i), codedOutputStream);
        }
        for (Map.Entry<T, Object> entry : this.y.getOverflowEntries()) {
            f3(entry, codedOutputStream);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.y.getNumArrayEntries(); i++) {
            Map.Entry<T, Object> arrayEntryAt = this.y.getArrayEntryAt(i);
            writeField(arrayEntryAt.getKey(), arrayEntryAt.getValue(), codedOutputStream);
        }
        for (Map.Entry<T, Object> entry : this.y.getOverflowEntries()) {
            writeField(entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }

    public final int wz(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated() && !key.isPacked()) {
            if (value instanceof LazyField) {
                return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(entry.getKey().getNumber(), (LazyField) value);
            }
            return CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite) value);
        }
        return computeFieldSize(key, value);
    }

    public final void z(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        if (key.isRepeated()) {
            Object field = getField(key);
            if (field == null) {
                field = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) field).add(i9(obj));
            }
            this.y.put((SmallSortedMap<T, Object>) key, (T) field);
        } else if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object field2 = getField(key);
            if (field2 == null) {
                this.y.put((SmallSortedMap<T, Object>) key, (T) i9(value));
                return;
            }
            this.y.put((SmallSortedMap<T, Object>) key, (T) key.internalMergeFrom(((MessageLite) field2).toBuilder(), (MessageLite) value).build());
        } else {
            this.y.put((SmallSortedMap<T, Object>) key, (T) i9(value));
        }
    }

    public FieldSet() {
        this.y = SmallSortedMap.tl(16);
    }

    /* renamed from: clone */
    public FieldSet<T> m23clone() {
        FieldSet<T> newFieldSet = newFieldSet();
        for (int i = 0; i < this.y.getNumArrayEntries(); i++) {
            Map.Entry<T, Object> arrayEntryAt = this.y.getArrayEntryAt(i);
            newFieldSet.setField(arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry<T, Object> entry : this.y.getOverflowEntries()) {
            newFieldSet.setField(entry.getKey(), entry.getValue());
        }
        newFieldSet.f6425zn = this.f6425zn;
        return newFieldSet;
    }

    public FieldSet(boolean z2) {
        this(SmallSortedMap.tl(0));
        makeImmutable();
    }

    public FieldSet(SmallSortedMap<T, Object> smallSortedMap) {
        this.y = smallSortedMap;
        makeImmutable();
    }
}
