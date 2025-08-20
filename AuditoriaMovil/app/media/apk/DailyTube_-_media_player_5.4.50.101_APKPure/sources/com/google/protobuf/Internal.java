package com.google.protobuf;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;
    public static final Charset y = Charset.forName("US-ASCII");

    /* renamed from: n3  reason: collision with root package name */
    public static final Charset f6450n3 = Charset.forName("UTF-8");

    /* renamed from: zn  reason: collision with root package name */
    public static final Charset f6451zn = Charset.forName("ISO-8859-1");

    /* loaded from: classes.dex */
    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean z2);

        boolean getBoolean(int i);

        @Override // 
        ProtobufList<Boolean> mutableCopyWithCapacity(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* renamed from: mutableCopyWithCapacity  reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ ProtobufList<Boolean> mutableCopyWithCapacity2(int i);

        @CanIgnoreReturnValue
        boolean setBoolean(int i, boolean z2);
    }

    /* loaded from: classes.dex */
    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double d2);

        double getDouble(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Double> mutableCopyWithCapacity(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* renamed from: mutableCopyWithCapacity  reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ ProtobufList<Double> mutableCopyWithCapacity2(int i);

        @CanIgnoreReturnValue
        double setDouble(int i, double d2);
    }

    /* loaded from: classes.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* loaded from: classes.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i);
    }

    /* loaded from: classes.dex */
    public interface EnumVerifier {
        boolean isInRange(int i);
    }

    /* loaded from: classes.dex */
    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float f4);

        float getFloat(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Float> mutableCopyWithCapacity(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* renamed from: mutableCopyWithCapacity  reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ ProtobufList<Float> mutableCopyWithCapacity2(int i);

        @CanIgnoreReturnValue
        float setFloat(int i, float f4);
    }

    /* loaded from: classes.dex */
    public interface IntList extends ProtobufList<Integer> {
        void addInt(int i);

        int getInt(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Integer> mutableCopyWithCapacity(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* renamed from: mutableCopyWithCapacity  reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ ProtobufList<Integer> mutableCopyWithCapacity2(int i);

        @CanIgnoreReturnValue
        int setInt(int i, int i5);
    }

    /* loaded from: classes.dex */
    public interface LongList extends ProtobufList<Long> {
        void addLong(long j2);

        long getLong(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Long> mutableCopyWithCapacity(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* renamed from: mutableCopyWithCapacity  reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ ProtobufList<Long> mutableCopyWithCapacity2(int i);

        @CanIgnoreReturnValue
        long setLong(int i, long j2);
    }

    /* loaded from: classes.dex */
    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int i);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(bArr);
    }

    public static byte[] byteArrayDefaultValue(String str) {
        return str.getBytes(f6451zn);
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        return ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static ByteString bytesDefaultValue(String str) {
        return ByteString.copyFrom(str.getBytes(f6451zn));
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }

    public static boolean equals(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        Java8Compatibility.y(duplicate);
        ByteBuffer duplicate2 = byteBuffer2.duplicate();
        Java8Compatibility.y(duplicate2);
        return duplicate.equals(duplicate2);
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> cls) {
        try {
            Method method = cls.getMethod("getDefaultInstance", null);
            return (T) method.invoke(method, null);
        } catch (Exception e2) {
            throw new RuntimeException("Failed to get default instance for " + cls, e2);
        }
    }

    public static Object gv(Object obj, Object obj2) {
        return ((MessageLite) obj).toBuilder().mergeFrom((MessageLite) obj2).buildPartial();
    }

    public static int hashBoolean(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    public static int hashCode(List<byte[]> list) {
        int i = 1;
        for (byte[] bArr : list) {
            i = (i * 31) + hashCode(bArr);
        }
        return i;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        int i = 1;
        for (ByteBuffer byteBuffer : list) {
            i = (i * 31) + hashCodeByteBuffer(byteBuffer);
        }
        return i;
    }

    public static int hashEnum(EnumLite enumLite) {
        return enumLite.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        int i = 1;
        for (EnumLite enumLite : list) {
            i = (i * 31) + hashEnum(enumLite);
        }
        return i;
    }

    public static int hashLong(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static <T> T n3(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }

    public static String stringDefaultValue(String str) {
        return new String(str.getBytes(f6451zn), f6450n3);
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(f6450n3);
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, f6450n3);
    }

    public static int v(int i, byte[] bArr, int i5, int i6) {
        for (int i8 = i5; i8 < i5 + i6; i8++) {
            i = (i * 31) + bArr[i8];
        }
        return i;
    }

    public static <T> T y(T t2) {
        t2.getClass();
        return t2;
    }

    public static int zn(byte[] bArr, int i, int i5) {
        int v2 = v(i5, bArr, i, i5);
        if (v2 == 0) {
            return 1;
        }
        return v2;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.z(bArr);
    }

    public static int hashCode(byte[] bArr) {
        return zn(bArr, 0, bArr.length);
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int v2 = v(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (v2 == 0) {
                return 1;
            }
            return v2;
        }
        int capacity = byteBuffer.capacity() <= 4096 ? byteBuffer.capacity() : 4096;
        byte[] bArr = new byte[capacity];
        ByteBuffer duplicate = byteBuffer.duplicate();
        Java8Compatibility.y(duplicate);
        int capacity2 = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= capacity ? duplicate.remaining() : capacity;
            duplicate.get(bArr, 0, remaining);
            capacity2 = v(capacity2, bArr, 0, remaining);
        }
        if (capacity2 == 0) {
            return 1;
        }
        return capacity2;
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!equalsByteBuffer(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
