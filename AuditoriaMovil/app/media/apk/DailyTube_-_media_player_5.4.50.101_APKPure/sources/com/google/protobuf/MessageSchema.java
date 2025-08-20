package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public final class MessageSchema<T> implements Schema<T> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6478a;

    /* renamed from: c5  reason: collision with root package name */
    public final boolean f6479c5;

    /* renamed from: f  reason: collision with root package name */
    public final int f6480f;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f6481fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f6482gv;

    /* renamed from: i9  reason: collision with root package name */
    public final int[] f6483i9;

    /* renamed from: n3  reason: collision with root package name */
    public final Object[] f6484n3;

    /* renamed from: p  reason: collision with root package name */
    public final MapFieldSchema f6485p;

    /* renamed from: s  reason: collision with root package name */
    public final ProtoSyntax f6486s;

    /* renamed from: t  reason: collision with root package name */
    public final int f6487t;

    /* renamed from: tl  reason: collision with root package name */
    public final NewInstanceSchema f6488tl;

    /* renamed from: v  reason: collision with root package name */
    public final MessageLite f6489v;

    /* renamed from: w  reason: collision with root package name */
    public final ExtensionSchema<?> f6490w;

    /* renamed from: wz  reason: collision with root package name */
    public final ListFieldSchema f6491wz;

    /* renamed from: xc  reason: collision with root package name */
    public final UnknownFieldSchema<?, ?> f6492xc;
    public final int[] y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f6493zn;

    /* renamed from: mt  reason: collision with root package name */
    public static final int[] f6477mt = new int[0];

    /* renamed from: co  reason: collision with root package name */
    public static final Unsafe f6476co = UnsafeUtil.ud();

    /* renamed from: com.google.protobuf.MessageSchema$1  reason: invalid class name */
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
                y[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                y[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                y[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                y[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                y[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                y[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                y[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                y[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                y[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                y[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                y[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                y[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                y[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public MessageSchema(int[] iArr, Object[] objArr, int i, int i5, MessageLite messageLite, ProtoSyntax protoSyntax, boolean z2, int[] iArr2, int i6, int i8, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.y = iArr;
        this.f6484n3 = objArr;
        this.f6493zn = i;
        this.f6482gv = i5;
        this.f6481fb = messageLite instanceof GeneratedMessageLite;
        this.f6486s = protoSyntax;
        this.f6478a = extensionSchema != null && extensionSchema.v(messageLite);
        this.f6479c5 = z2;
        this.f6483i9 = iArr2;
        this.f6480f = i6;
        this.f6487t = i8;
        this.f6488tl = newInstanceSchema;
        this.f6491wz = listFieldSchema;
        this.f6492xc = unknownFieldSchema;
        this.f6490w = extensionSchema;
        this.f6489v = messageLite;
        this.f6485p = mapFieldSchema;
    }

    public static <T> double a(T t2, long j2) {
        return UnsafeUtil.fh(t2, j2);
    }

    public static <T> MessageSchema<T> a8(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return b((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return x((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0266  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> com.google.protobuf.MessageSchema<T> b(com.google.protobuf.RawMessageInfo r31, com.google.protobuf.NewInstanceSchema r32, com.google.protobuf.ListFieldSchema r33, com.google.protobuf.UnknownFieldSchema<?, ?> r34, com.google.protobuf.ExtensionSchema<?> r35, com.google.protobuf.MapFieldSchema r36) {
        /*
            Method dump skipped, instructions count: 993
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.b(com.google.protobuf.RawMessageInfo, com.google.protobuf.NewInstanceSchema, com.google.protobuf.ListFieldSchema, com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, com.google.protobuf.MapFieldSchema):com.google.protobuf.MessageSchema");
    }

    public static boolean d0(int i) {
        return (i & 268435456) != 0;
    }

    public static Field dm(Class<?> cls, String str) {
        Field[] declaredFields;
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            for (Field field : cls.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void eb(com.google.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            com.google.protobuf.OneofInfo r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L25
            com.google.protobuf.FieldType r2 = r8.getType()
            int r2 = r2.id()
            int r2 = r2 + 51
            java.lang.reflect.Field r3 = r0.getValueField()
            long r3 = com.google.protobuf.UnsafeUtil.k5(r3)
            int r4 = (int) r3
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r5 = com.google.protobuf.UnsafeUtil.k5(r0)
        L22:
            int r0 = (int) r5
        L23:
            r3 = 0
            goto L6b
        L25:
            com.google.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = com.google.protobuf.UnsafeUtil.k5(r2)
            int r4 = (int) r2
            int r2 = r0.id()
            boolean r3 = r0.isList()
            if (r3 != 0) goto L5a
            boolean r0 = r0.isMap()
            if (r0 != 0) goto L5a
            java.lang.reflect.Field r0 = r8.getPresenceField()
            if (r0 != 0) goto L4c
            r0 = 1048575(0xfffff, float:1.469367E-39)
            goto L51
        L4c:
            long r5 = com.google.protobuf.UnsafeUtil.k5(r0)
            int r0 = (int) r5
        L51:
            int r3 = r8.getPresenceMask()
            int r3 = java.lang.Integer.numberOfTrailingZeros(r3)
            goto L6b
        L5a:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            if (r0 != 0) goto L62
            r0 = 0
            goto L23
        L62:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            long r5 = com.google.protobuf.UnsafeUtil.k5(r0)
            goto L22
        L6b:
            int r5 = r8.getFieldNumber()
            r9[r10] = r5
            int r5 = r10 + 1
            boolean r6 = r8.isEnforceUtf8()
            if (r6 == 0) goto L7c
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L7d
        L7c:
            r6 = 0
        L7d:
            boolean r7 = r8.isRequired()
            if (r7 == 0) goto L85
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L85:
            r1 = r1 | r6
            int r2 = r2 << 20
            r1 = r1 | r2
            r1 = r1 | r4
            r9[r5] = r1
            int r1 = r10 + 2
            int r2 = r3 << 20
            r0 = r0 | r2
            r9[r1] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r0 = r8.getMapDefaultEntry()
            if (r0 == 0) goto Lbd
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r0 = r8.getMapDefaultEntry()
            r11[r10] = r0
            if (r9 == 0) goto Lae
            int r10 = r10 + 1
            r11[r10] = r9
            goto Lda
        Lae:
            com.google.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Lda
            int r10 = r10 + 1
            com.google.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
            goto Lda
        Lbd:
            if (r9 == 0) goto Lc8
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r11[r10] = r9
            goto Lda
        Lc8:
            com.google.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Lda
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            com.google.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.eb(com.google.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    public static boolean f3(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    public static <T> long fh(T t2, long j2) {
        return UnsafeUtil.d(t2, j2);
    }

    public static <T> double hw(T t2, long j2) {
        return ((Double) UnsafeUtil.ej(t2, j2)).doubleValue();
    }

    public static <T> float i9(T t2, long j2) {
        return UnsafeUtil.rz(t2, j2);
    }

    public static <T> float j5(T t2, long j2) {
        return ((Float) UnsafeUtil.ej(t2, j2)).floatValue();
    }

    public static <T> boolean n3(T t2, long j2) {
        return UnsafeUtil.r(t2, j2);
    }

    public static <T> long o(T t2, long j2) {
        return ((Long) UnsafeUtil.ej(t2, j2)).longValue();
    }

    public static boolean p(int i) {
        return (i & 536870912) != 0;
    }

    public static <T> int qn(T t2, long j2) {
        return ((Integer) UnsafeUtil.ej(t2, j2)).intValue();
    }

    public static boolean r(int i) {
        return (i & Integer.MIN_VALUE) != 0;
    }

    public static int ra(int i) {
        return (i & 267386880) >>> 20;
    }

    public static <T> boolean vl(T t2, long j2) {
        return ((Boolean) UnsafeUtil.ej(t2, j2)).booleanValue();
    }

    public static <T> int w(T t2, long j2) {
        return UnsafeUtil.mg(t2, j2);
    }

    public static UnknownFieldSetLite wz(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
            UnknownFieldSetLite f4 = UnknownFieldSetLite.f();
            generatedMessageLite.unknownFields = f4;
            return f4;
        }
        return unknownFieldSetLite;
    }

    public static <T> MessageSchema<T> x(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int[] iArr;
        int i;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr2 = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i5 = 0;
        int i6 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i5++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i6++;
            }
        }
        int[] iArr3 = null;
        if (i5 > 0) {
            iArr = new int[i5];
        } else {
            iArr = null;
        }
        if (i6 > 0) {
            iArr3 = new int[i6];
        }
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = f6477mt;
        }
        int i8 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i8 < fields.length) {
            FieldInfo fieldInfo2 = fields[i8];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            eb(fieldInfo2, iArr2, i10, objArr);
            if (i11 < checkInitialized.length && checkInitialized[i11] == fieldNumber3) {
                checkInitialized[i11] = i10;
                i11++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr[i12] = i10;
                i12++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i = i10;
                iArr3[i13] = (int) UnsafeUtil.k5(fieldInfo2.getField());
                i13++;
                i8++;
                i10 = i + 3;
            }
            i = i10;
            i8++;
            i10 = i + 3;
        }
        if (iArr == null) {
            iArr = f6477mt;
        }
        if (iArr3 == null) {
            iArr3 = f6477mt;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr, 0, iArr4, checkInitialized.length, iArr.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr.length, iArr3.length);
        return new MessageSchema<>(iArr2, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), structuralMessageInfo.getSyntax(), true, iArr4, checkInitialized.length, checkInitialized.length + iArr.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static long yt(int i) {
        return i & 1048575;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean z(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.ej(obj, yt(i)));
    }

    public static void zn(Object obj) {
        if (f3(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x058e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ap(T r11, com.google.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.ap(java.lang.Object, com.google.protobuf.Writer):void");
    }

    public final boolean c(T t2, int i, int i5) {
        if (UnsafeUtil.mg(t2, en(i5) & 1048575) == i) {
            return true;
        }
        return false;
    }

    public final <K, V, UT, UB> UB c5(int i, int i5, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.f6485p.forMapMetadata(t(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.a(obj);
                }
                ByteString.CodedBuilder r2 = ByteString.r(MapEntryLite.y(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.v(r2.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.gv(ub, i5, r2.build());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    public final boolean co(T t2, int i, int i5, int i6, int i8) {
        if (i5 == 1048575) {
            return mt(t2, i);
        }
        if ((i6 & i8) != 0) {
            return true;
        }
        return false;
    }

    public final void ct(T t2, int i) {
        int en2 = en(i);
        long j2 = 1048575 & en2;
        if (j2 == 1048575) {
            return;
        }
        UnsafeUtil.q9(t2, j2, (1 << (en2 >>> 20)) | UnsafeUtil.mg(t2, j2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(T t2, T t3, int i) {
        int k52 = k5(i);
        if (!c(t3, k52, i)) {
            return;
        }
        long yt2 = yt(e(i));
        Unsafe unsafe = f6476co;
        Object object = unsafe.getObject(t3, yt2);
        if (object != null) {
            Schema tl2 = tl(i);
            if (!c(t2, k52, i)) {
                if (!f3(object)) {
                    unsafe.putObject(t2, yt2, object);
                } else {
                    Object newInstance = tl2.newInstance();
                    tl2.mergeFrom(newInstance, object);
                    unsafe.putObject(t2, yt2, newInstance);
                }
                o4(t2, k52, i);
                return;
            }
            Object object2 = unsafe.getObject(t2, yt2);
            if (!f3(object2)) {
                Object newInstance2 = tl2.newInstance();
                tl2.mergeFrom(newInstance2, object2);
                unsafe.putObject(t2, yt2, newInstance2);
                object2 = newInstance2;
            }
            tl2.mergeFrom(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + k5(i) + " is present but null: " + t3);
    }

    public final int e(int i) {
        return this.y[i + 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object ej(T t2, int i) {
        Schema tl2 = tl(i);
        long yt2 = yt(e(i));
        if (!mt(t2, i)) {
            return tl2.newInstance();
        }
        Object object = f6476co.getObject(t2, yt2);
        if (f3(object)) {
            return object;
        }
        Object newInstance = tl2.newInstance();
        if (object != null) {
            tl2.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    public final int en(int i) {
        return this.y[i + 2];
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t2, T t3) {
        int length = this.y.length;
        for (int i = 0; i < length; i += 3) {
            if (!fb(t2, t3, i)) {
                return false;
            }
        }
        if (!this.f6492xc.fb(t2).equals(this.f6492xc.fb(t3))) {
            return false;
        }
        if (this.f6478a) {
            return this.f6490w.zn(t2).equals(this.f6490w.zn(t3));
        }
        return true;
    }

    public final Internal.EnumVerifier f(int i) {
        return (Internal.EnumVerifier) this.f6484n3[((i / 3) * 2) + 1];
    }

    public final int f7(int i, int i5) {
        if (i >= this.f6493zn && i <= this.f6482gv) {
            return rs(i, i5);
        }
        return -1;
    }

    public final boolean fb(T t2, T t3, int i) {
        int e2 = e(i);
        long yt2 = yt(e2);
        switch (ra(e2)) {
            case 0:
                if (!y(t2, t3, i) || Double.doubleToLongBits(UnsafeUtil.fh(t2, yt2)) != Double.doubleToLongBits(UnsafeUtil.fh(t3, yt2))) {
                    return false;
                }
                return true;
            case 1:
                if (!y(t2, t3, i) || Float.floatToIntBits(UnsafeUtil.rz(t2, yt2)) != Float.floatToIntBits(UnsafeUtil.rz(t3, yt2))) {
                    return false;
                }
                return true;
            case 2:
                if (!y(t2, t3, i) || UnsafeUtil.d(t2, yt2) != UnsafeUtil.d(t3, yt2)) {
                    return false;
                }
                return true;
            case 3:
                if (!y(t2, t3, i) || UnsafeUtil.d(t2, yt2) != UnsafeUtil.d(t3, yt2)) {
                    return false;
                }
                return true;
            case 4:
                if (!y(t2, t3, i) || UnsafeUtil.mg(t2, yt2) != UnsafeUtil.mg(t3, yt2)) {
                    return false;
                }
                return true;
            case 5:
                if (!y(t2, t3, i) || UnsafeUtil.d(t2, yt2) != UnsafeUtil.d(t3, yt2)) {
                    return false;
                }
                return true;
            case 6:
                if (!y(t2, t3, i) || UnsafeUtil.mg(t2, yt2) != UnsafeUtil.mg(t3, yt2)) {
                    return false;
                }
                return true;
            case 7:
                if (!y(t2, t3, i) || UnsafeUtil.r(t2, yt2) != UnsafeUtil.r(t3, yt2)) {
                    return false;
                }
                return true;
            case 8:
                if (!y(t2, t3, i) || !SchemaUtil.ej(UnsafeUtil.ej(t2, yt2), UnsafeUtil.ej(t3, yt2))) {
                    return false;
                }
                return true;
            case 9:
                if (!y(t2, t3, i) || !SchemaUtil.ej(UnsafeUtil.ej(t2, yt2), UnsafeUtil.ej(t3, yt2))) {
                    return false;
                }
                return true;
            case 10:
                if (!y(t2, t3, i) || !SchemaUtil.ej(UnsafeUtil.ej(t2, yt2), UnsafeUtil.ej(t3, yt2))) {
                    return false;
                }
                return true;
            case 11:
                if (!y(t2, t3, i) || UnsafeUtil.mg(t2, yt2) != UnsafeUtil.mg(t3, yt2)) {
                    return false;
                }
                return true;
            case 12:
                if (!y(t2, t3, i) || UnsafeUtil.mg(t2, yt2) != UnsafeUtil.mg(t3, yt2)) {
                    return false;
                }
                return true;
            case 13:
                if (!y(t2, t3, i) || UnsafeUtil.mg(t2, yt2) != UnsafeUtil.mg(t3, yt2)) {
                    return false;
                }
                return true;
            case 14:
                if (!y(t2, t3, i) || UnsafeUtil.d(t2, yt2) != UnsafeUtil.d(t3, yt2)) {
                    return false;
                }
                return true;
            case 15:
                if (!y(t2, t3, i) || UnsafeUtil.mg(t2, yt2) != UnsafeUtil.mg(t3, yt2)) {
                    return false;
                }
                return true;
            case 16:
                if (!y(t2, t3, i) || UnsafeUtil.d(t2, yt2) != UnsafeUtil.d(t3, yt2)) {
                    return false;
                }
                return true;
            case 17:
                if (!y(t2, t3, i) || !SchemaUtil.ej(UnsafeUtil.ej(t2, yt2), UnsafeUtil.ej(t3, yt2))) {
                    return false;
                }
                return true;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.ej(UnsafeUtil.ej(t2, yt2), UnsafeUtil.ej(t3, yt2));
            case 50:
                return SchemaUtil.ej(UnsafeUtil.ej(t2, yt2), UnsafeUtil.ej(t3, yt2));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!n(t2, t3, i) || !SchemaUtil.ej(UnsafeUtil.ej(t2, yt2), UnsafeUtil.ej(t3, yt2))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t2) {
        int i;
        int i5;
        int i6;
        int computeDoubleSize;
        int computeBoolSize;
        int computeSFixed32Size;
        int c52;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        Unsafe unsafe = f6476co;
        int i8 = 1048575;
        int i10 = 1048575;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < this.y.length) {
            int e2 = e(i12);
            int ra2 = ra(e2);
            int k52 = k5(i12);
            int i14 = this.y[i12 + 2];
            int i15 = i14 & i8;
            if (ra2 <= 17) {
                if (i15 != i10) {
                    i11 = i15 == i8 ? 0 : unsafe.getInt(t2, i15);
                    i10 = i15;
                }
                i = i10;
                i5 = i11;
                i6 = 1 << (i14 >>> 20);
            } else {
                i = i10;
                i5 = i11;
                i6 = 0;
            }
            long yt2 = yt(e2);
            i15 = (ra2 < FieldType.DOUBLE_LIST_PACKED.id() || ra2 > FieldType.SINT64_LIST_PACKED.id()) ? 0 : 0;
            switch (ra2) {
                case 0:
                    if (!co(t2, i12, i, i5, i6)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(k52, 0.0d);
                        i13 += computeDoubleSize;
                        break;
                    }
                case 1:
                    if (!co(t2, i12, i, i5, i6)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(k52, 0.0f);
                        i13 += computeDoubleSize;
                        break;
                    }
                case 2:
                    if (!co(t2, i12, i, i5, i6)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(k52, unsafe.getLong(t2, yt2));
                        i13 += computeDoubleSize;
                        break;
                    }
                case 3:
                    if (!co(t2, i12, i, i5, i6)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(k52, unsafe.getLong(t2, yt2));
                        i13 += computeDoubleSize;
                        break;
                    }
                case 4:
                    if (!co(t2, i12, i, i5, i6)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(k52, unsafe.getInt(t2, yt2));
                        i13 += computeDoubleSize;
                        break;
                    }
                case 5:
                    if (!co(t2, i12, i, i5, i6)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(k52, 0L);
                        i13 += computeDoubleSize;
                        break;
                    }
                case 6:
                    if (co(t2, i12, i, i5, i6)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(k52, 0);
                        i13 += computeDoubleSize;
                        break;
                    }
                    break;
                case 7:
                    if (co(t2, i12, i, i5, i6)) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(k52, true);
                        i13 += computeBoolSize;
                    }
                    break;
                case 8:
                    if (co(t2, i12, i, i5, i6)) {
                        Object object = unsafe.getObject(t2, yt2);
                        if (object instanceof ByteString) {
                            computeBoolSize = CodedOutputStream.computeBytesSize(k52, (ByteString) object);
                        } else {
                            computeBoolSize = CodedOutputStream.computeStringSize(k52, (String) object);
                        }
                        i13 += computeBoolSize;
                    }
                    break;
                case 9:
                    if (co(t2, i12, i, i5, i6)) {
                        computeBoolSize = SchemaUtil.xc(k52, unsafe.getObject(t2, yt2), tl(i12));
                        i13 += computeBoolSize;
                    }
                    break;
                case 10:
                    if (co(t2, i12, i, i5, i6)) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(k52, (ByteString) unsafe.getObject(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 11:
                    if (co(t2, i12, i, i5, i6)) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(k52, unsafe.getInt(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 12:
                    if (co(t2, i12, i, i5, i6)) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(k52, unsafe.getInt(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 13:
                    if (co(t2, i12, i, i5, i6)) {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(k52, 0);
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 14:
                    if (co(t2, i12, i, i5, i6)) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(k52, 0L);
                        i13 += computeBoolSize;
                    }
                    break;
                case 15:
                    if (co(t2, i12, i, i5, i6)) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(k52, unsafe.getInt(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 16:
                    if (co(t2, i12, i, i5, i6)) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(k52, unsafe.getLong(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 17:
                    if (co(t2, i12, i, i5, i6)) {
                        computeBoolSize = CodedOutputStream.n3(k52, (MessageLite) unsafe.getObject(t2, yt2), tl(i12));
                        i13 += computeBoolSize;
                    }
                    break;
                case 18:
                    computeBoolSize = SchemaUtil.s(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 19:
                    computeBoolSize = SchemaUtil.a(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 20:
                    computeBoolSize = SchemaUtil.tl(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 21:
                    computeBoolSize = SchemaUtil.f3(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 22:
                    computeBoolSize = SchemaUtil.f(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 23:
                    computeBoolSize = SchemaUtil.s(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 24:
                    computeBoolSize = SchemaUtil.a(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 25:
                    computeBoolSize = SchemaUtil.y(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 26:
                    computeBoolSize = SchemaUtil.r(k52, (List) unsafe.getObject(t2, yt2));
                    i13 += computeBoolSize;
                    break;
                case 27:
                    computeBoolSize = SchemaUtil.w(k52, (List) unsafe.getObject(t2, yt2), tl(i12));
                    i13 += computeBoolSize;
                    break;
                case 28:
                    computeBoolSize = SchemaUtil.zn(k52, (List) unsafe.getObject(t2, yt2));
                    i13 += computeBoolSize;
                    break;
                case 29:
                    computeBoolSize = SchemaUtil.x4(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 30:
                    computeBoolSize = SchemaUtil.gv(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 31:
                    computeBoolSize = SchemaUtil.a(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 32:
                    computeBoolSize = SchemaUtil.s(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 33:
                    computeBoolSize = SchemaUtil.p(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 34:
                    computeBoolSize = SchemaUtil.co(k52, (List) unsafe.getObject(t2, yt2), false);
                    i13 += computeBoolSize;
                    break;
                case 35:
                    c52 = SchemaUtil.c5((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 36:
                    c52 = SchemaUtil.fb((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 37:
                    c52 = SchemaUtil.wz((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 38:
                    c52 = SchemaUtil.n((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 39:
                    c52 = SchemaUtil.t((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 40:
                    c52 = SchemaUtil.c5((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 41:
                    c52 = SchemaUtil.fb((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 42:
                    c52 = SchemaUtil.n3((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 43:
                    c52 = SchemaUtil.i4((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 44:
                    c52 = SchemaUtil.v((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 45:
                    c52 = SchemaUtil.fb((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 46:
                    c52 = SchemaUtil.c5((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 47:
                    c52 = SchemaUtil.mt((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 48:
                    c52 = SchemaUtil.z((List) unsafe.getObject(t2, yt2));
                    if (c52 > 0) {
                        if (this.f6479c5) {
                            unsafe.putInt(t2, i15, c52);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(k52);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(c52);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + c52;
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 49:
                    computeBoolSize = SchemaUtil.i9(k52, (List) unsafe.getObject(t2, yt2), tl(i12));
                    i13 += computeBoolSize;
                    break;
                case 50:
                    computeBoolSize = this.f6485p.getSerializedSize(k52, unsafe.getObject(t2, yt2), t(i12));
                    i13 += computeBoolSize;
                    break;
                case 51:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeDoubleSize(k52, 0.0d);
                        i13 += computeBoolSize;
                    }
                    break;
                case 52:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeFloatSize(k52, 0.0f);
                        i13 += computeBoolSize;
                    }
                    break;
                case 53:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeInt64Size(k52, o(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 54:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeUInt64Size(k52, o(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 55:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeInt32Size(k52, qn(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 56:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeFixed64Size(k52, 0L);
                        i13 += computeBoolSize;
                    }
                    break;
                case 57:
                    if (c(t2, k52, i12)) {
                        computeSFixed32Size = CodedOutputStream.computeFixed32Size(k52, 0);
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 58:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(k52, true);
                        i13 += computeBoolSize;
                    }
                    break;
                case 59:
                    if (c(t2, k52, i12)) {
                        Object object2 = unsafe.getObject(t2, yt2);
                        if (object2 instanceof ByteString) {
                            computeBoolSize = CodedOutputStream.computeBytesSize(k52, (ByteString) object2);
                        } else {
                            computeBoolSize = CodedOutputStream.computeStringSize(k52, (String) object2);
                        }
                        i13 += computeBoolSize;
                    }
                    break;
                case 60:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = SchemaUtil.xc(k52, unsafe.getObject(t2, yt2), tl(i12));
                        i13 += computeBoolSize;
                    }
                    break;
                case 61:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(k52, (ByteString) unsafe.getObject(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 62:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(k52, qn(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 63:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(k52, qn(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 64:
                    if (c(t2, k52, i12)) {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(k52, 0);
                        i13 += computeSFixed32Size;
                    }
                    break;
                case 65:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(k52, 0L);
                        i13 += computeBoolSize;
                    }
                    break;
                case 66:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(k52, qn(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 67:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(k52, o(t2, yt2));
                        i13 += computeBoolSize;
                    }
                    break;
                case 68:
                    if (c(t2, k52, i12)) {
                        computeBoolSize = CodedOutputStream.n3(k52, (MessageLite) unsafe.getObject(t2, yt2), tl(i12));
                        i13 += computeBoolSize;
                    }
                    break;
            }
            i12 += 3;
            i10 = i;
            i11 = i5;
            i8 = 1048575;
        }
        int xc2 = i13 + xc(this.f6492xc, t2);
        return this.f6478a ? xc2 + this.f6490w.zn(t2).getSerializedSize() : xc2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public final <K, V> int gv(byte[] bArr, int i, int i5, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int i6;
        int ud2 = ArrayDecoders.ud(bArr, i, registers);
        int i8 = registers.int1;
        if (i8 >= 0 && i8 <= i5 - ud2) {
            int i10 = ud2 + i8;
            K k2 = metadata.defaultKey;
            V v2 = metadata.defaultValue;
            while (ud2 < i10) {
                int i11 = ud2 + 1;
                byte b2 = bArr[ud2];
                if (b2 < 0) {
                    i6 = ArrayDecoders.ej(b2, bArr, i11, registers);
                    b2 = registers.int1;
                } else {
                    i6 = i11;
                }
                int i12 = b2 >>> 3;
                int i13 = b2 & 7;
                if (i12 != 1) {
                    if (i12 == 2 && i13 == metadata.valueType.getWireType()) {
                        ud2 = v(bArr, i6, i5, metadata.valueType, metadata.defaultValue.getClass(), registers);
                        v2 = registers.object1;
                    }
                    ud2 = ArrayDecoders.hw(b2, bArr, i6, i5, registers);
                } else if (i13 == metadata.keyType.getWireType()) {
                    ud2 = v(bArr, i6, i5, metadata.keyType, null, registers);
                    k2 = registers.object1;
                } else {
                    ud2 = ArrayDecoders.hw(b2, bArr, i6, i5, registers);
                }
            }
            if (ud2 == i10) {
                map.put(k2, v2);
                return i10;
            }
            throw InvalidProtocolBufferException.mt();
        }
        throw InvalidProtocolBufferException.ta();
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t2) {
        int i;
        int hashLong;
        int length = this.y.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            int e2 = e(i6);
            int k52 = k5(i6);
            long yt2 = yt(e2);
            int i8 = 37;
            switch (ra(e2)) {
                case 0:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.fh(t2, yt2)));
                    i5 = i + hashLong;
                    break;
                case 1:
                    i = i5 * 53;
                    hashLong = Float.floatToIntBits(UnsafeUtil.rz(t2, yt2));
                    i5 = i + hashLong;
                    break;
                case 2:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.d(t2, yt2));
                    i5 = i + hashLong;
                    break;
                case 3:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.d(t2, yt2));
                    i5 = i + hashLong;
                    break;
                case 4:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.mg(t2, yt2);
                    i5 = i + hashLong;
                    break;
                case 5:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.d(t2, yt2));
                    i5 = i + hashLong;
                    break;
                case 6:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.mg(t2, yt2);
                    i5 = i + hashLong;
                    break;
                case 7:
                    i = i5 * 53;
                    hashLong = Internal.hashBoolean(UnsafeUtil.r(t2, yt2));
                    i5 = i + hashLong;
                    break;
                case 8:
                    i = i5 * 53;
                    hashLong = ((String) UnsafeUtil.ej(t2, yt2)).hashCode();
                    i5 = i + hashLong;
                    break;
                case 9:
                    Object ej2 = UnsafeUtil.ej(t2, yt2);
                    if (ej2 != null) {
                        i8 = ej2.hashCode();
                    }
                    i5 = (i5 * 53) + i8;
                    break;
                case 10:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.ej(t2, yt2).hashCode();
                    i5 = i + hashLong;
                    break;
                case 11:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.mg(t2, yt2);
                    i5 = i + hashLong;
                    break;
                case 12:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.mg(t2, yt2);
                    i5 = i + hashLong;
                    break;
                case 13:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.mg(t2, yt2);
                    i5 = i + hashLong;
                    break;
                case 14:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.d(t2, yt2));
                    i5 = i + hashLong;
                    break;
                case 15:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.mg(t2, yt2);
                    i5 = i + hashLong;
                    break;
                case 16:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.d(t2, yt2));
                    i5 = i + hashLong;
                    break;
                case 17:
                    Object ej3 = UnsafeUtil.ej(t2, yt2);
                    if (ej3 != null) {
                        i8 = ej3.hashCode();
                    }
                    i5 = (i5 * 53) + i8;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.ej(t2, yt2).hashCode();
                    i5 = i + hashLong;
                    break;
                case 50:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.ej(t2, yt2).hashCode();
                    i5 = i + hashLong;
                    break;
                case 51:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(Double.doubleToLongBits(hw(t2, yt2)));
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = Float.floatToIntBits(j5(t2, yt2));
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(o(t2, yt2));
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(o(t2, yt2));
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = qn(t2, yt2);
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(o(t2, yt2));
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = qn(t2, yt2);
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = Internal.hashBoolean(vl(t2, yt2));
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = ((String) UnsafeUtil.ej(t2, yt2)).hashCode();
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = UnsafeUtil.ej(t2, yt2).hashCode();
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = UnsafeUtil.ej(t2, yt2).hashCode();
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = qn(t2, yt2);
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = qn(t2, yt2);
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = qn(t2, yt2);
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(o(t2, yt2));
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = qn(t2, yt2);
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(o(t2, yt2));
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (c(t2, k52, i6)) {
                        i = i5 * 53;
                        hashLong = UnsafeUtil.ej(t2, yt2).hashCode();
                        i5 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i5 * 53) + this.f6492xc.fb(t2).hashCode();
        if (this.f6478a) {
            return (hashCode * 53) + this.f6490w.zn(t2).hashCode();
        }
        return hashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.protobuf.Schema] */
    public final boolean i4(T t2, int i, int i5) {
        Map<?, ?> forMapData = this.f6485p.forMapData(UnsafeUtil.ej(t2, yt(i)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.f6485p.forMapMetadata(t(i5)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<T> schema = 0;
        for (Object obj : forMapData.values()) {
            if (schema == null) {
                schema = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            boolean isInitialized = schema.isInitialized(obj);
            schema = schema;
            if (!isInitialized) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T t2) {
        int i;
        int i5;
        int i6 = 1048575;
        int i8 = 0;
        int i10 = 0;
        while (i10 < this.f6480f) {
            int i11 = this.f6483i9[i10];
            int k52 = k5(i11);
            int e2 = e(i11);
            int i12 = this.y[i11 + 2];
            int i13 = i12 & 1048575;
            int i14 = 1 << (i12 >>> 20);
            if (i13 != i6) {
                if (i13 != 1048575) {
                    i8 = f6476co.getInt(t2, i13);
                }
                i5 = i8;
                i = i13;
            } else {
                i = i6;
                i5 = i8;
            }
            if (d0(e2) && !co(t2, i11, i, i5, i14)) {
                return false;
            }
            int ra2 = ra(e2);
            if (ra2 != 9 && ra2 != 17) {
                if (ra2 != 27) {
                    if (ra2 != 60 && ra2 != 68) {
                        if (ra2 != 49) {
                            if (ra2 == 50 && !i4(t2, e2, i11)) {
                                return false;
                            }
                        }
                    } else if (c(t2, k52, i11) && !z(t2, e2, tl(i11))) {
                        return false;
                    }
                }
                if (!x4(t2, e2, i11)) {
                    return false;
                }
            } else if (co(t2, i11, i, i5, i14) && !z(t2, e2, tl(i11))) {
                return false;
            }
            i10++;
            i6 = i;
            i8 = i5;
        }
        if (this.f6478a && !this.f6490w.zn(t2).isInitialized()) {
            return false;
        }
        return true;
    }

    public final <K, V> int j(T t2, byte[] bArr, int i, int i5, int i6, long j2, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = f6476co;
        Object t3 = t(i6);
        Object object = unsafe.getObject(t2, j2);
        if (this.f6485p.isImmutable(object)) {
            Object newMapField = this.f6485p.newMapField(t3);
            this.f6485p.mergeFrom(newMapField, object);
            unsafe.putObject(t2, j2, newMapField);
            object = newMapField;
        }
        return gv(bArr, i, i5, this.f6485p.forMapMetadata(t3), this.f6485p.forMutableMapData(object), registers);
    }

    public final <E> void jz(Object obj, long j2, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.f6491wz.v(obj, j2), schema, extensionRegistryLite);
    }

    public final int k(int i) {
        if (i >= this.f6493zn && i <= this.f6482gv) {
            return rs(i, 0);
        }
        return -1;
    }

    public final int k5(int i) {
        return this.y[i];
    }

    public final <UT, UB> void kp(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t2, Writer writer) throws IOException {
        unknownFieldSchema.z(unknownFieldSchema.fb(t2), writer);
    }

    public final void lc(T t2, int i, Object obj) {
        f6476co.putObject(t2, yt(e(i)), obj);
        ct(t2, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t2) {
        if (!f3(t2)) {
            return;
        }
        if (t2 instanceof GeneratedMessageLite) {
            GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t2;
            generatedMessageLite.clearMemoizedSerializedSize();
            generatedMessageLite.clearMemoizedHashCode();
            generatedMessageLite.markImmutable();
        }
        int length = this.y.length;
        for (int i = 0; i < length; i += 3) {
            int e2 = e(i);
            long yt2 = yt(e2);
            int ra2 = ra(e2);
            if (ra2 != 9) {
                if (ra2 != 60 && ra2 != 68) {
                    switch (ra2) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.f6491wz.zn(t2, yt2);
                            break;
                        case 50:
                            Unsafe unsafe = f6476co;
                            Object object = unsafe.getObject(t2, yt2);
                            if (object != null) {
                                unsafe.putObject(t2, yt2, this.f6485p.toImmutable(object));
                                break;
                            } else {
                                break;
                            }
                    }
                } else if (c(t2, k5(i), i)) {
                    tl(i).makeImmutable(f6476co.getObject(t2, yt2));
                }
            }
            if (mt(t2, i)) {
                tl(i).makeImmutable(f6476co.getObject(t2, yt2));
            }
        }
        this.f6492xc.i9(t2);
        if (this.f6478a) {
            this.f6490w.a(t2);
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t2, T t3) {
        zn(t2);
        t3.getClass();
        for (int i = 0; i < this.y.length; i += 3) {
            z6(t2, t3, i);
        }
        SchemaUtil.z6(this.f6492xc, t2, t3);
        if (this.f6478a) {
            SchemaUtil.ta(this.f6490w, t2, t3);
        }
    }

    public final <K, V> void mg(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long yt2 = yt(e(i));
        Object ej2 = UnsafeUtil.ej(obj, yt2);
        if (ej2 == null) {
            ej2 = this.f6485p.newMapField(obj2);
            UnsafeUtil.f7(obj, yt2, ej2);
        } else if (this.f6485p.isImmutable(ej2)) {
            Object newMapField = this.f6485p.newMapField(obj2);
            this.f6485p.mergeFrom(newMapField, ej2);
            UnsafeUtil.f7(obj, yt2, newMapField);
            ej2 = newMapField;
        }
        reader.readMap(this.f6485p.forMutableMapData(ej2), this.f6485p.forMapMetadata(obj2), extensionRegistryLite);
    }

    public final boolean mt(T t2, int i) {
        int en2 = en(i);
        long j2 = 1048575 & en2;
        if (j2 == 1048575) {
            int e2 = e(i);
            long yt2 = yt(e2);
            switch (ra(e2)) {
                case 0:
                    if (Double.doubleToRawLongBits(UnsafeUtil.fh(t2, yt2)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(UnsafeUtil.rz(t2, yt2)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (UnsafeUtil.d(t2, yt2) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (UnsafeUtil.d(t2, yt2) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (UnsafeUtil.mg(t2, yt2) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (UnsafeUtil.d(t2, yt2) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (UnsafeUtil.mg(t2, yt2) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return UnsafeUtil.r(t2, yt2);
                case 8:
                    Object ej2 = UnsafeUtil.ej(t2, yt2);
                    if (ej2 instanceof String) {
                        return !((String) ej2).isEmpty();
                    }
                    if (ej2 instanceof ByteString) {
                        return !ByteString.EMPTY.equals(ej2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (UnsafeUtil.ej(t2, yt2) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.ej(t2, yt2));
                case 11:
                    if (UnsafeUtil.mg(t2, yt2) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (UnsafeUtil.mg(t2, yt2) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (UnsafeUtil.mg(t2, yt2) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (UnsafeUtil.d(t2, yt2) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (UnsafeUtil.mg(t2, yt2) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (UnsafeUtil.d(t2, yt2) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (UnsafeUtil.ej(t2, yt2) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((UnsafeUtil.mg(t2, j2) & (1 << (en2 >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    public final boolean n(T t2, T t3, int i) {
        long en2 = en(i) & 1048575;
        if (UnsafeUtil.mg(t2, en2) == UnsafeUtil.mg(t3, en2)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.f6488tl.newInstance(this.f6489v);
    }

    public final void nf(T t2, int i, int i5, Object obj) {
        f6476co.putObject(t2, yt(e(i5)), obj);
        o4(t2, i, i5);
    }

    public final void o4(T t2, int i, int i5) {
        UnsafeUtil.q9(t2, en(i5) & 1048575, i);
    }

    @CanIgnoreReturnValue
    public int oz(T t2, byte[] bArr, int i, int i5, int i6, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        int i8;
        MessageSchema<T> messageSchema;
        int i10;
        int i11;
        int i12;
        int i13;
        T t3;
        byte b2;
        int k2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        byte[] bArr2;
        int i20;
        int i21;
        byte[] bArr3;
        int b3;
        int i22;
        int i23;
        MessageSchema<T> messageSchema2 = this;
        T t4 = t2;
        byte[] bArr4 = bArr;
        int i24 = i5;
        int i25 = i6;
        ArrayDecoders.Registers registers2 = registers;
        zn(t2);
        Unsafe unsafe2 = f6476co;
        int i26 = i;
        int i27 = -1;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = 1048575;
        while (true) {
            if (i26 < i24) {
                int i32 = i26 + 1;
                byte b4 = bArr4[i26];
                if (b4 < 0) {
                    int ej2 = ArrayDecoders.ej(b4, bArr4, i32, registers2);
                    b2 = registers2.int1;
                    i32 = ej2;
                } else {
                    b2 = b4;
                }
                int i33 = b2 >>> 3;
                int i34 = b2 & 7;
                if (i33 > i27) {
                    k2 = messageSchema2.f7(i33, i28 / 3);
                } else {
                    k2 = messageSchema2.k(i33);
                }
                int i35 = k2;
                if (i35 == -1) {
                    i14 = i33;
                    i15 = i32;
                    i11 = b2;
                    i16 = i30;
                    i17 = i31;
                    unsafe = unsafe2;
                    i8 = i25;
                    i18 = 0;
                } else {
                    int i36 = messageSchema2.y[i35 + 1];
                    int ra2 = ra(i36);
                    long yt2 = yt(i36);
                    int i37 = b2;
                    if (ra2 <= 17) {
                        int i38 = messageSchema2.y[i35 + 2];
                        int i39 = 1 << (i38 >>> 20);
                        int i40 = 1048575;
                        int i41 = i38 & 1048575;
                        if (i41 != i31) {
                            if (i31 != 1048575) {
                                unsafe2.putInt(t4, i31, i30);
                                i40 = 1048575;
                            }
                            i17 = i41;
                            i19 = i41 == i40 ? 0 : unsafe2.getInt(t4, i41);
                        } else {
                            i19 = i30;
                            i17 = i31;
                        }
                        switch (ra2) {
                            case 0:
                                bArr2 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 1) {
                                    UnsafeUtil.oz(t4, yt2, ArrayDecoders.gv(bArr2, i32));
                                    i26 = i32 + 8;
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr2;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 1:
                                bArr2 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 5) {
                                    UnsafeUtil.ut(t4, yt2, ArrayDecoders.t(bArr2, i32));
                                    i26 = i32 + 4;
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr2;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 2:
                            case 3:
                                bArr3 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 0) {
                                    b3 = ArrayDecoders.b(bArr3, i32, registers2);
                                    unsafe2.putLong(t2, yt2, registers2.long1);
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr3;
                                    i26 = b3;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.ud(bArr2, i32, registers2);
                                    unsafe2.putInt(t4, yt2, registers2.int1);
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr2;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 1) {
                                    unsafe2.putLong(t2, yt2, ArrayDecoders.i9(bArr2, i32));
                                    i26 = i32 + 8;
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr2;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 5) {
                                    unsafe2.putInt(t4, yt2, ArrayDecoders.s(bArr2, i32));
                                    i26 = i32 + 4;
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr2;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 7:
                                bArr2 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.b(bArr2, i32, registers2);
                                    UnsafeUtil.yt(t4, yt2, registers2.long1 != 0);
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr2;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 8:
                                bArr2 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 2) {
                                    if (p(i36)) {
                                        i26 = ArrayDecoders.d(bArr2, i32, registers2);
                                    } else {
                                        i26 = ArrayDecoders.rz(bArr2, i32, registers2);
                                    }
                                    unsafe2.putObject(t4, yt2, registers2.object1);
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr2;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 9:
                                bArr2 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 2) {
                                    Object ej3 = messageSchema2.ej(t4, i20);
                                    i26 = ArrayDecoders.vl(ej3, messageSchema2.tl(i20), bArr, i32, i5, registers);
                                    messageSchema2.lc(t4, i20, ej3);
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr2;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 10:
                                bArr2 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 2) {
                                    i26 = ArrayDecoders.n3(bArr2, i32, registers2);
                                    unsafe2.putObject(t4, yt2, registers2.object1);
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr2;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 12:
                                bArr2 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.ud(bArr2, i32, registers2);
                                    int i42 = registers2.int1;
                                    Internal.EnumVerifier f4 = messageSchema2.f(i20);
                                    if (r(i36) && f4 != null && !f4.isInRange(i42)) {
                                        wz(t2).wz(i21, Long.valueOf(i42));
                                        i25 = i6;
                                        i28 = i20;
                                        i30 = i19;
                                        i29 = i21;
                                        i31 = i17;
                                        i27 = i14;
                                        i24 = i5;
                                        bArr4 = bArr2;
                                        break;
                                    } else {
                                        unsafe2.putInt(t4, yt2, i42);
                                        i30 = i19 | i39;
                                        i25 = i6;
                                        i28 = i20;
                                        bArr4 = bArr2;
                                        i29 = i21;
                                        i31 = i17;
                                        i27 = i14;
                                        i24 = i5;
                                        break;
                                    }
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.ud(bArr2, i32, registers2);
                                    unsafe2.putInt(t4, yt2, CodedInputStream.decodeZigZag32(registers2.int1));
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr2;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 16:
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                bArr3 = bArr;
                                if (i34 == 0) {
                                    b3 = ArrayDecoders.b(bArr3, i32, registers2);
                                    unsafe2.putLong(t2, yt2, CodedInputStream.decodeZigZag64(registers2.long1));
                                    i30 = i19 | i39;
                                    i25 = i6;
                                    i28 = i20;
                                    bArr4 = bArr3;
                                    i26 = b3;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            case 17:
                                if (i34 == 3) {
                                    Object ej4 = messageSchema2.ej(t4, i35);
                                    i14 = i33;
                                    i21 = i37;
                                    i26 = ArrayDecoders.yt(ej4, messageSchema2.tl(i35), bArr, i32, i5, (i33 << 3) | 4, registers);
                                    messageSchema2.lc(t4, i35, ej4);
                                    i30 = i19 | i39;
                                    bArr4 = bArr;
                                    i25 = i6;
                                    i28 = i35;
                                    i29 = i21;
                                    i31 = i17;
                                    i27 = i14;
                                    i24 = i5;
                                    break;
                                } else {
                                    i14 = i33;
                                    i21 = i37;
                                    i20 = i35;
                                    i8 = i6;
                                    i15 = i32;
                                    i18 = i20;
                                    unsafe = unsafe2;
                                    i16 = i19;
                                    i11 = i21;
                                    break;
                                }
                            default:
                                i14 = i33;
                                i20 = i35;
                                i21 = i37;
                                i8 = i6;
                                i15 = i32;
                                i18 = i20;
                                unsafe = unsafe2;
                                i16 = i19;
                                i11 = i21;
                                break;
                        }
                    } else {
                        i14 = i33;
                        int i43 = i31;
                        i16 = i30;
                        if (ra2 != 27) {
                            i17 = i43;
                            if (ra2 <= 49) {
                                int i44 = i32;
                                unsafe = unsafe2;
                                i18 = i35;
                                i23 = i37;
                                i26 = q9(t2, bArr, i32, i5, i37, i14, i34, i35, i36, ra2, yt2, registers);
                                if (i26 != i44) {
                                    messageSchema2 = this;
                                    t4 = t2;
                                    bArr4 = bArr;
                                    i24 = i5;
                                    i25 = i6;
                                    registers2 = registers;
                                    i29 = i23;
                                    i30 = i16;
                                    i28 = i18;
                                    i31 = i17;
                                    i27 = i14;
                                    unsafe2 = unsafe;
                                } else {
                                    i8 = i6;
                                    i15 = i26;
                                    i11 = i23;
                                }
                            } else {
                                i22 = i32;
                                unsafe = unsafe2;
                                i18 = i35;
                                i23 = i37;
                                if (ra2 != 50) {
                                    i26 = ut(t2, bArr, i22, i5, i23, i14, i34, i36, ra2, yt2, i18, registers);
                                    if (i26 != i22) {
                                        messageSchema2 = this;
                                        t4 = t2;
                                        bArr4 = bArr;
                                        i24 = i5;
                                        i25 = i6;
                                        registers2 = registers;
                                        i29 = i23;
                                        i30 = i16;
                                        i28 = i18;
                                        i31 = i17;
                                        i27 = i14;
                                        unsafe2 = unsafe;
                                    } else {
                                        i8 = i6;
                                        i15 = i26;
                                        i11 = i23;
                                    }
                                } else if (i34 == 2) {
                                    i26 = j(t2, bArr, i22, i5, i18, yt2, registers);
                                    if (i26 != i22) {
                                        messageSchema2 = this;
                                        t4 = t2;
                                        bArr4 = bArr;
                                        i24 = i5;
                                        i25 = i6;
                                        registers2 = registers;
                                        i29 = i23;
                                        i30 = i16;
                                        i28 = i18;
                                        i31 = i17;
                                        i27 = i14;
                                        unsafe2 = unsafe;
                                    } else {
                                        i8 = i6;
                                        i15 = i26;
                                        i11 = i23;
                                    }
                                }
                            }
                        } else if (i34 == 2) {
                            Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe2.getObject(t4, yt2);
                            if (!protobufList.isModifiable()) {
                                int size = protobufList.size();
                                protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                                unsafe2.putObject(t4, yt2, protobufList);
                            }
                            i26 = ArrayDecoders.p(messageSchema2.tl(i35), i37, bArr, i32, i5, protobufList, registers);
                            i25 = i6;
                            i28 = i35;
                            i29 = i37;
                            i30 = i16;
                            i31 = i43;
                            i27 = i14;
                            bArr4 = bArr;
                            i24 = i5;
                        } else {
                            i17 = i43;
                            i22 = i32;
                            unsafe = unsafe2;
                            i18 = i35;
                            i23 = i37;
                        }
                        i8 = i6;
                        i15 = i22;
                        i11 = i23;
                    }
                }
                if (i11 != i8 || i8 == 0) {
                    if (this.f6478a && registers.extensionRegistry != ExtensionRegistryLite.getEmptyRegistry()) {
                        i26 = ArrayDecoders.fb(i11, bArr, i15, i5, t2, this.f6489v, this.f6492xc, registers);
                    } else {
                        i26 = ArrayDecoders.z6(i11, bArr, i15, i5, wz(t2), registers);
                    }
                    t4 = t2;
                    bArr4 = bArr;
                    i24 = i5;
                    i29 = i11;
                    messageSchema2 = this;
                    registers2 = registers;
                    i30 = i16;
                    i28 = i18;
                    i31 = i17;
                    i27 = i14;
                    unsafe2 = unsafe;
                    i25 = i8;
                } else {
                    i13 = 1048575;
                    messageSchema = this;
                    i10 = i15;
                    i30 = i16;
                    i12 = i17;
                }
            } else {
                int i45 = i31;
                unsafe = unsafe2;
                i8 = i25;
                messageSchema = messageSchema2;
                i10 = i26;
                i11 = i29;
                i12 = i45;
                i13 = 1048575;
            }
        }
        if (i12 != i13) {
            t3 = t2;
            unsafe.putInt(t3, i12, i30);
        } else {
            t3 = t2;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i46 = messageSchema.f6480f; i46 < messageSchema.f6487t; i46++) {
            unknownFieldSetLite = (UnknownFieldSetLite) s(t2, messageSchema.f6483i9[i46], unknownFieldSetLite, messageSchema.f6492xc, t2);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.f6492xc.xc(t3, unknownFieldSetLite);
        }
        if (i8 == 0) {
            if (i10 != i5) {
                throw InvalidProtocolBufferException.mt();
            }
        } else if (i10 > i5 || i11 != i8) {
            throw InvalidProtocolBufferException.mt();
        }
        return i10;
    }

    public final int q9(T t2, byte[] bArr, int i, int i5, int i6, int i8, int i10, int i11, long j2, int i12, long j4, ArrayDecoders.Registers registers) throws IOException {
        int a82;
        Unsafe unsafe = f6476co;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t2, j4);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(t2, j4, protobufList);
        }
        switch (i12) {
            case 18:
            case 35:
                if (i10 == 2) {
                    return ArrayDecoders.co(bArr, i, protobufList, registers);
                }
                if (i10 == 1) {
                    return ArrayDecoders.v(i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 19:
            case 36:
                if (i10 == 2) {
                    return ArrayDecoders.x4(bArr, i, protobufList, registers);
                }
                if (i10 == 5) {
                    return ArrayDecoders.tl(i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i10 == 2) {
                    return ArrayDecoders.c(bArr, i, protobufList, registers);
                }
                if (i10 == 0) {
                    return ArrayDecoders.k5(i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i10 == 2) {
                    return ArrayDecoders.n(bArr, i, protobufList, registers);
                }
                if (i10 == 0) {
                    return ArrayDecoders.a8(i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i10 == 2) {
                    return ArrayDecoders.r(bArr, i, protobufList, registers);
                }
                if (i10 == 1) {
                    return ArrayDecoders.f(i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i10 == 2) {
                    return ArrayDecoders.z(bArr, i, protobufList, registers);
                }
                if (i10 == 5) {
                    return ArrayDecoders.c5(i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 25:
            case 42:
                if (i10 == 2) {
                    return ArrayDecoders.mt(bArr, i, protobufList, registers);
                }
                if (i10 == 0) {
                    return ArrayDecoders.y(i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 26:
                if (i10 == 2) {
                    if ((j2 & 536870912) == 0) {
                        return ArrayDecoders.mg(i6, bArr, i, i5, protobufList, registers);
                    }
                    return ArrayDecoders.ta(i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 27:
                if (i10 == 2) {
                    return ArrayDecoders.p(tl(i11), i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 28:
                if (i10 == 2) {
                    return ArrayDecoders.zn(i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 30:
            case 44:
                if (i10 == 2) {
                    a82 = ArrayDecoders.n(bArr, i, protobufList, registers);
                } else if (i10 == 0) {
                    a82 = ArrayDecoders.a8(i6, bArr, i, i5, protobufList, registers);
                }
                SchemaUtil.d0(t2, i8, protobufList, f(i11), null, this.f6492xc);
                return a82;
            case 33:
            case 47:
                if (i10 == 2) {
                    return ArrayDecoders.i4(bArr, i, protobufList, registers);
                }
                if (i10 == 0) {
                    return ArrayDecoders.d0(i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 34:
            case 48:
                if (i10 == 2) {
                    return ArrayDecoders.f3(bArr, i, protobufList, registers);
                }
                if (i10 == 0) {
                    return ArrayDecoders.fh(i6, bArr, i, i5, protobufList, registers);
                }
                break;
            case 49:
                if (i10 == 3) {
                    return ArrayDecoders.xc(tl(i11), i6, bArr, i, i5, protobufList, registers);
                }
                break;
        }
        return i;
    }

    public final int rs(int i, int i5) {
        int length = (this.y.length / 3) - 1;
        while (i5 <= length) {
            int i6 = (length + i5) >>> 1;
            int i8 = i6 * 3;
            int k52 = k5(i8);
            if (i == k52) {
                return i8;
            }
            if (i < k52) {
                length = i6 - 1;
            } else {
                i5 = i6 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:244:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
        r0 = r18.f6480f;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
        if (r0 >= r18.f6487t) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        r4 = (UB) s(r21, r18.f6483i9[r0], r4, r19, r21);
        r0 = r0 + 1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b1, code lost:
        r10 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b2, code lost:
        if (r4 == null) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b4, code lost:
        r7.xc(r10, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b7, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:172:0x064f A[Catch: all -> 0x0675, TRY_LEAVE, TryCatch #6 {all -> 0x0675, blocks: (B:170:0x0649, B:172:0x064f, B:184:0x0679, B:185:0x067e), top: B:214:0x0649 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x06b5 A[LOOP:4: B:198:0x06b1->B:200:0x06b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x06ca  */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.google.protobuf.UnknownFieldSchema] */
    /* JADX WARN: Type inference failed for: r14v4, types: [com.google.protobuf.UnknownFieldSchema] */
    /* JADX WARN: Type inference failed for: r14v57 */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.google.protobuf.Reader] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void rz(com.google.protobuf.UnknownFieldSchema<UT, UB> r19, com.google.protobuf.ExtensionSchema<ET> r20, T r21, com.google.protobuf.Reader r22, com.google.protobuf.ExtensionRegistryLite r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1884
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.rz(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    public final <UT, UB> UB s(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        int k52 = k5(i);
        Object ej2 = UnsafeUtil.ej(obj, yt(e(i)));
        if (ej2 == null) {
            return ub;
        }
        Internal.EnumVerifier f4 = f(i);
        if (f4 == null) {
            return ub;
        }
        return (UB) c5(i, k52, this.f6485p.forMutableMapData(ej2), f4, ub, unknownFieldSchema, obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x062a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s8(T r22, com.google.protobuf.Writer r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1748
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.s8(java.lang.Object, com.google.protobuf.Writer):void");
    }

    public final Object t(int i) {
        return this.f6484n3[(i / 3) * 2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void ta(T t2, T t3, int i) {
        if (!mt(t3, i)) {
            return;
        }
        long yt2 = yt(e(i));
        Unsafe unsafe = f6476co;
        Object object = unsafe.getObject(t3, yt2);
        if (object != null) {
            Schema tl2 = tl(i);
            if (!mt(t2, i)) {
                if (!f3(object)) {
                    unsafe.putObject(t2, yt2, object);
                } else {
                    Object newInstance = tl2.newInstance();
                    tl2.mergeFrom(newInstance, object);
                    unsafe.putObject(t2, yt2, newInstance);
                }
                ct(t2, i);
                return;
            }
            Object object2 = unsafe.getObject(t2, yt2);
            if (!f3(object2)) {
                Object newInstance2 = tl2.newInstance();
                tl2.mergeFrom(newInstance2, object2);
                unsafe.putObject(t2, yt2, newInstance2);
                object2 = newInstance2;
            }
            tl2.mergeFrom(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + k5(i) + " is present but null: " + t3);
    }

    public final Schema tl(int i) {
        int i5 = (i / 3) * 2;
        Schema schema = (Schema) this.f6484n3[i5];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaFor = Protobuf.getInstance().schemaFor((Class) ((Class) this.f6484n3[i5 + 1]));
        this.f6484n3[i5] = schemaFor;
        return schemaFor;
    }

    public final <E> void u(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.f6491wz.v(obj, yt(i)), schema, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object ud(T t2, int i, int i5) {
        Schema tl2 = tl(i5);
        if (!c(t2, i, i5)) {
            return tl2.newInstance();
        }
        Object object = f6476co.getObject(t2, yt(e(i5)));
        if (f3(object)) {
            return object;
        }
        Object newInstance = tl2.newInstance();
        if (object != null) {
            tl2.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    public final int ut(T t2, byte[] bArr, int i, int i5, int i6, int i8, int i10, int i11, int i12, long j2, int i13, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = f6476co;
        long j4 = this.y[i13 + 2] & 1048575;
        switch (i12) {
            case 51:
                if (i10 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(ArrayDecoders.gv(bArr, i)));
                    int i14 = i + 8;
                    unsafe.putInt(t2, j4, i8);
                    return i14;
                }
                break;
            case 52:
                if (i10 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(ArrayDecoders.t(bArr, i)));
                    int i15 = i + 4;
                    unsafe.putInt(t2, j4, i8);
                    return i15;
                }
                break;
            case 53:
            case 54:
                if (i10 == 0) {
                    int b2 = ArrayDecoders.b(bArr, i, registers);
                    unsafe.putObject(t2, j2, Long.valueOf(registers.long1));
                    unsafe.putInt(t2, j4, i8);
                    return b2;
                }
                break;
            case 55:
            case 62:
                if (i10 == 0) {
                    int ud2 = ArrayDecoders.ud(bArr, i, registers);
                    unsafe.putObject(t2, j2, Integer.valueOf(registers.int1));
                    unsafe.putInt(t2, j4, i8);
                    return ud2;
                }
                break;
            case 56:
            case 65:
                if (i10 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(ArrayDecoders.i9(bArr, i)));
                    int i16 = i + 8;
                    unsafe.putInt(t2, j4, i8);
                    return i16;
                }
                break;
            case 57:
            case 64:
                if (i10 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(ArrayDecoders.s(bArr, i)));
                    int i17 = i + 4;
                    unsafe.putInt(t2, j4, i8);
                    return i17;
                }
                break;
            case 58:
                if (i10 == 0) {
                    int b3 = ArrayDecoders.b(bArr, i, registers);
                    unsafe.putObject(t2, j2, Boolean.valueOf(registers.long1 != 0));
                    unsafe.putInt(t2, j4, i8);
                    return b3;
                }
                break;
            case 59:
                if (i10 == 2) {
                    int ud3 = ArrayDecoders.ud(bArr, i, registers);
                    int i18 = registers.int1;
                    if (i18 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i11 & 536870912) != 0 && !Utf8.r(bArr, ud3, ud3 + i18)) {
                        throw InvalidProtocolBufferException.s();
                    } else {
                        unsafe.putObject(t2, j2, new String(bArr, ud3, i18, Internal.f6450n3));
                        ud3 += i18;
                    }
                    unsafe.putInt(t2, j4, i8);
                    return ud3;
                }
                break;
            case 60:
                if (i10 == 2) {
                    Object ud4 = ud(t2, i8, i13);
                    int vl2 = ArrayDecoders.vl(ud4, tl(i13), bArr, i, i5, registers);
                    nf(t2, i8, i13, ud4);
                    return vl2;
                }
                break;
            case 61:
                if (i10 == 2) {
                    int n32 = ArrayDecoders.n3(bArr, i, registers);
                    unsafe.putObject(t2, j2, registers.object1);
                    unsafe.putInt(t2, j4, i8);
                    return n32;
                }
                break;
            case 63:
                if (i10 == 0) {
                    int ud5 = ArrayDecoders.ud(bArr, i, registers);
                    int i19 = registers.int1;
                    Internal.EnumVerifier f4 = f(i13);
                    if (f4 != null && !f4.isInRange(i19)) {
                        wz(t2).wz(i6, Long.valueOf(i19));
                    } else {
                        unsafe.putObject(t2, j2, Integer.valueOf(i19));
                        unsafe.putInt(t2, j4, i8);
                    }
                    return ud5;
                }
                break;
            case 66:
                if (i10 == 0) {
                    int ud6 = ArrayDecoders.ud(bArr, i, registers);
                    unsafe.putObject(t2, j2, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                    unsafe.putInt(t2, j4, i8);
                    return ud6;
                }
                break;
            case 67:
                if (i10 == 0) {
                    int b4 = ArrayDecoders.b(bArr, i, registers);
                    unsafe.putObject(t2, j2, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                    unsafe.putInt(t2, j4, i8);
                    return b4;
                }
                break;
            case 68:
                if (i10 == 3) {
                    Object ud7 = ud(t2, i8, i13);
                    int yt2 = ArrayDecoders.yt(ud7, tl(i13), bArr, i, i5, (i6 & (-8)) | 4, registers);
                    nf(t2, i8, i13, ud7);
                    return yt2;
                }
                break;
        }
        return i;
    }

    public final int v(byte[] bArr, int i, int i5, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        boolean z2;
        switch (AnonymousClass1.y[fieldType.ordinal()]) {
            case 1:
                int b2 = ArrayDecoders.b(bArr, i, registers);
                if (registers.long1 != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                registers.object1 = Boolean.valueOf(z2);
                return b2;
            case 2:
                return ArrayDecoders.n3(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.gv(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.s(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.i9(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.t(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int ud2 = ArrayDecoders.ud(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return ud2;
            case 12:
            case 13:
                int b3 = ArrayDecoders.b(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return b3;
            case 14:
                return ArrayDecoders.w(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i5, registers);
            case 15:
                int ud3 = ArrayDecoders.ud(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return ud3;
            case 16:
                int b4 = ArrayDecoders.b(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return b4;
            case 17:
                return ArrayDecoders.d(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t2, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            ap(t2, writer);
        } else {
            s8(t2, writer);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N> boolean x4(Object obj, int i, int i5) {
        List list = (List) UnsafeUtil.ej(obj, yt(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema tl2 = tl(i5);
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (!tl2.isInitialized(list.get(i6))) {
                return false;
            }
        }
        return true;
    }

    public final <UT, UB> int xc(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t2) {
        return unknownFieldSchema.s(unknownFieldSchema.fb(t2));
    }

    public final void xg(Object obj, int i, Reader reader) throws IOException {
        if (p(i)) {
            reader.readStringListRequireUtf8(this.f6491wz.v(obj, yt(i)));
        } else {
            reader.readStringList(this.f6491wz.v(obj, yt(i)));
        }
    }

    public final boolean y(T t2, T t3, int i) {
        if (mt(t2, i) == mt(t3, i)) {
            return true;
        }
        return false;
    }

    public final void y5(Object obj, int i, Reader reader) throws IOException {
        if (p(i)) {
            UnsafeUtil.f7(obj, yt(i), reader.readStringRequireUtf8());
        } else if (this.f6481fb) {
            UnsafeUtil.f7(obj, yt(i), reader.readString());
        } else {
            UnsafeUtil.f7(obj, yt(i), reader.readBytes());
        }
    }

    public final void yc(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    public final <K, V> void yg(Writer writer, int i, Object obj, int i5) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.f6485p.forMapMetadata(t(i5)), this.f6485p.forMapData(obj));
        }
    }

    public final void z6(T t2, T t3, int i) {
        int e2 = e(i);
        long yt2 = yt(e2);
        int k52 = k5(i);
        switch (ra(e2)) {
            case 0:
                if (mt(t3, i)) {
                    UnsafeUtil.oz(t2, yt2, UnsafeUtil.fh(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 1:
                if (mt(t3, i)) {
                    UnsafeUtil.ut(t2, yt2, UnsafeUtil.rz(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 2:
                if (mt(t3, i)) {
                    UnsafeUtil.k(t2, yt2, UnsafeUtil.d(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 3:
                if (mt(t3, i)) {
                    UnsafeUtil.k(t2, yt2, UnsafeUtil.d(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 4:
                if (mt(t3, i)) {
                    UnsafeUtil.q9(t2, yt2, UnsafeUtil.mg(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 5:
                if (mt(t3, i)) {
                    UnsafeUtil.k(t2, yt2, UnsafeUtil.d(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 6:
                if (mt(t3, i)) {
                    UnsafeUtil.q9(t2, yt2, UnsafeUtil.mg(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 7:
                if (mt(t3, i)) {
                    UnsafeUtil.yt(t2, yt2, UnsafeUtil.r(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 8:
                if (mt(t3, i)) {
                    UnsafeUtil.f7(t2, yt2, UnsafeUtil.ej(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 9:
                ta(t2, t3, i);
                return;
            case 10:
                if (mt(t3, i)) {
                    UnsafeUtil.f7(t2, yt2, UnsafeUtil.ej(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 11:
                if (mt(t3, i)) {
                    UnsafeUtil.q9(t2, yt2, UnsafeUtil.mg(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 12:
                if (mt(t3, i)) {
                    UnsafeUtil.q9(t2, yt2, UnsafeUtil.mg(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 13:
                if (mt(t3, i)) {
                    UnsafeUtil.q9(t2, yt2, UnsafeUtil.mg(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 14:
                if (mt(t3, i)) {
                    UnsafeUtil.k(t2, yt2, UnsafeUtil.d(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 15:
                if (mt(t3, i)) {
                    UnsafeUtil.q9(t2, yt2, UnsafeUtil.mg(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 16:
                if (mt(t3, i)) {
                    UnsafeUtil.k(t2, yt2, UnsafeUtil.d(t3, yt2));
                    ct(t2, i);
                    return;
                }
                return;
            case 17:
                ta(t2, t3, i);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f6491wz.gv(t2, t3, yt2);
                return;
            case 50:
                SchemaUtil.d(this.f6485p, t2, t3, yt2);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (c(t3, k52, i)) {
                    UnsafeUtil.f7(t2, yt2, UnsafeUtil.ej(t3, yt2));
                    o4(t2, k52, i);
                    return;
                }
                return;
            case 60:
                d(t2, t3, i);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (c(t3, k52, i)) {
                    UnsafeUtil.f7(t2, yt2, UnsafeUtil.ej(t3, yt2));
                    o4(t2, k52, i);
                    return;
                }
                return;
            case 68:
                d(t2, t3, i);
                return;
            default:
                return;
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t2, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        zn(t2);
        rz(this.f6492xc, this.f6490w, t2, reader, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t2, byte[] bArr, int i, int i5, ArrayDecoders.Registers registers) throws IOException {
        oz(t2, bArr, i, i5, 0, registers);
    }
}
