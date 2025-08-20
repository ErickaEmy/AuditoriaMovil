package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.WireFormat;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public final class ArrayDecoders {

    /* renamed from: com.google.protobuf.ArrayDecoders$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            y = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[WireFormat.FieldType.INT32.ordinal()] = 5;
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
                y[WireFormat.FieldType.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                y[WireFormat.FieldType.FIXED32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                y[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                y[WireFormat.FieldType.BOOL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                y[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                y[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                y[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                y[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                y[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                y[WireFormat.FieldType.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                y[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public static int a(int i, byte[] bArr, int i5, int i6, GeneratedMessageLite.ExtendableMessage<?, ?> extendableMessage, GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        boolean z2;
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = extendableMessage.extensions;
        int i8 = i >>> 3;
        if (generatedExtension.f6444gv.isRepeated() && generatedExtension.f6444gv.isPacked()) {
            switch (AnonymousClass1.y[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    DoubleArrayList doubleArrayList = new DoubleArrayList();
                    int co2 = co(bArr, i5, doubleArrayList, registers);
                    fieldSet.setField(generatedExtension.f6444gv, doubleArrayList);
                    return co2;
                case 2:
                    FloatArrayList floatArrayList = new FloatArrayList();
                    int x42 = x4(bArr, i5, floatArrayList, registers);
                    fieldSet.setField(generatedExtension.f6444gv, floatArrayList);
                    return x42;
                case 3:
                case 4:
                    LongArrayList longArrayList = new LongArrayList();
                    int c2 = c(bArr, i5, longArrayList, registers);
                    fieldSet.setField(generatedExtension.f6444gv, longArrayList);
                    return c2;
                case 5:
                case 6:
                    IntArrayList intArrayList = new IntArrayList();
                    int n2 = n(bArr, i5, intArrayList, registers);
                    fieldSet.setField(generatedExtension.f6444gv, intArrayList);
                    return n2;
                case 7:
                case 8:
                    LongArrayList longArrayList2 = new LongArrayList();
                    int r2 = r(bArr, i5, longArrayList2, registers);
                    fieldSet.setField(generatedExtension.f6444gv, longArrayList2);
                    return r2;
                case 9:
                case 10:
                    IntArrayList intArrayList2 = new IntArrayList();
                    int z3 = z(bArr, i5, intArrayList2, registers);
                    fieldSet.setField(generatedExtension.f6444gv, intArrayList2);
                    return z3;
                case 11:
                    BooleanArrayList booleanArrayList = new BooleanArrayList();
                    int mt2 = mt(bArr, i5, booleanArrayList, registers);
                    fieldSet.setField(generatedExtension.f6444gv, booleanArrayList);
                    return mt2;
                case 12:
                    IntArrayList intArrayList3 = new IntArrayList();
                    int i42 = i4(bArr, i5, intArrayList3, registers);
                    fieldSet.setField(generatedExtension.f6444gv, intArrayList3);
                    return i42;
                case 13:
                    LongArrayList longArrayList3 = new LongArrayList();
                    int f32 = f3(bArr, i5, longArrayList3, registers);
                    fieldSet.setField(generatedExtension.f6444gv, longArrayList3);
                    return f32;
                case 14:
                    IntArrayList intArrayList4 = new IntArrayList();
                    int n4 = n(bArr, i5, intArrayList4, registers);
                    SchemaUtil.c(extendableMessage, i8, intArrayList4, generatedExtension.f6444gv.getEnumType(), null, unknownFieldSchema);
                    fieldSet.setField(generatedExtension.f6444gv, intArrayList4);
                    return n4;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.f6444gv.getLiteType());
            }
        }
        Object obj = null;
        if (generatedExtension.getLiteType() == WireFormat.FieldType.ENUM) {
            i5 = ud(bArr, i5, registers);
            if (generatedExtension.f6444gv.getEnumType().findValueByNumber(registers.int1) == null) {
                SchemaUtil.ud(extendableMessage, i8, registers.int1, null, unknownFieldSchema);
                return i5;
            }
            obj = Integer.valueOf(registers.int1);
        } else {
            switch (AnonymousClass1.y[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    obj = Double.valueOf(gv(bArr, i5));
                    i5 += 8;
                    break;
                case 2:
                    obj = Float.valueOf(t(bArr, i5));
                    i5 += 4;
                    break;
                case 3:
                case 4:
                    i5 = b(bArr, i5, registers);
                    obj = Long.valueOf(registers.long1);
                    break;
                case 5:
                case 6:
                    i5 = ud(bArr, i5, registers);
                    obj = Integer.valueOf(registers.int1);
                    break;
                case 7:
                case 8:
                    obj = Long.valueOf(i9(bArr, i5));
                    i5 += 8;
                    break;
                case 9:
                case 10:
                    obj = Integer.valueOf(s(bArr, i5));
                    i5 += 4;
                    break;
                case 11:
                    i5 = b(bArr, i5, registers);
                    if (registers.long1 != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    obj = Boolean.valueOf(z2);
                    break;
                case 12:
                    i5 = ud(bArr, i5, registers);
                    obj = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                    break;
                case 13:
                    i5 = b(bArr, i5, registers);
                    obj = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i5 = n3(bArr, i5, registers);
                    obj = registers.object1;
                    break;
                case 16:
                    i5 = rz(bArr, i5, registers);
                    obj = registers.object1;
                    break;
                case 17:
                    int i10 = (i8 << 3) | 4;
                    Schema schemaFor = Protobuf.getInstance().schemaFor((Class) generatedExtension.getMessageDefaultInstance().getClass());
                    if (generatedExtension.isRepeated()) {
                        int wz2 = wz(schemaFor, bArr, i5, i6, i10, registers);
                        fieldSet.addRepeatedField(generatedExtension.f6444gv, registers.object1);
                        return wz2;
                    }
                    Object field = fieldSet.getField(generatedExtension.f6444gv);
                    if (field == null) {
                        field = schemaFor.newInstance();
                        fieldSet.setField(generatedExtension.f6444gv, field);
                    }
                    return yt(field, schemaFor, bArr, i5, i6, i10, registers);
                case 18:
                    Schema schemaFor2 = Protobuf.getInstance().schemaFor((Class) generatedExtension.getMessageDefaultInstance().getClass());
                    if (generatedExtension.isRepeated()) {
                        int w4 = w(schemaFor2, bArr, i5, i6, registers);
                        fieldSet.addRepeatedField(generatedExtension.f6444gv, registers.object1);
                        return w4;
                    }
                    Object field2 = fieldSet.getField(generatedExtension.f6444gv);
                    if (field2 == null) {
                        field2 = schemaFor2.newInstance();
                        fieldSet.setField(generatedExtension.f6444gv, field2);
                    }
                    return vl(field2, schemaFor2, bArr, i5, i6, registers);
            }
        }
        if (generatedExtension.isRepeated()) {
            fieldSet.addRepeatedField(generatedExtension.f6444gv, obj);
        } else {
            fieldSet.setField(generatedExtension.f6444gv, obj);
        }
        return i5;
    }

    public static int a8(int i, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int ud2 = ud(bArr, i5, registers);
        intArrayList.addInt(registers.int1);
        while (ud2 < i6) {
            int ud3 = ud(bArr, ud2, registers);
            if (i != registers.int1) {
                break;
            }
            ud2 = ud(bArr, ud3, registers);
            intArrayList.addInt(registers.int1);
        }
        return ud2;
    }

    public static int b(byte[] bArr, int i, Registers registers) {
        int i5 = i + 1;
        long j2 = bArr[i];
        if (j2 >= 0) {
            registers.long1 = j2;
            return i5;
        }
        return x(j2, bArr, i5, registers);
    }

    public static int c(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1 + ud2;
        while (ud2 < i5) {
            ud2 = b(bArr, ud2, registers);
            longArrayList.addLong(registers.long1);
        }
        if (ud2 == i5) {
            return ud2;
        }
        throw InvalidProtocolBufferException.ta();
    }

    public static int c5(int i, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.addInt(s(bArr, i5));
        int i8 = i5 + 4;
        while (i8 < i6) {
            int ud2 = ud(bArr, i8, registers);
            if (i != registers.int1) {
                break;
            }
            intArrayList.addInt(s(bArr, ud2));
            i8 = ud2 + 4;
        }
        return i8;
    }

    public static int co(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1 + ud2;
        while (ud2 < i5) {
            doubleArrayList.addDouble(gv(bArr, ud2));
            ud2 += 8;
        }
        if (ud2 == i5) {
            return ud2;
        }
        throw InvalidProtocolBufferException.ta();
    }

    public static int d(byte[] bArr, int i, Registers registers) throws InvalidProtocolBufferException {
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1;
        if (i5 >= 0) {
            if (i5 == 0) {
                registers.object1 = "";
                return ud2;
            }
            registers.object1 = Utf8.s(bArr, ud2, i5);
            return ud2 + i5;
        }
        throw InvalidProtocolBufferException.p();
    }

    public static int d0(int i, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int ud2 = ud(bArr, i5, registers);
        intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        while (ud2 < i6) {
            int ud3 = ud(bArr, ud2, registers);
            if (i != registers.int1) {
                break;
            }
            ud2 = ud(bArr, ud3, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        return ud2;
    }

    public static int ej(int i, byte[] bArr, int i5, Registers registers) {
        int i6 = i & 127;
        int i8 = i5 + 1;
        byte b2 = bArr[i5];
        if (b2 >= 0) {
            registers.int1 = i6 | (b2 << 7);
            return i8;
        }
        int i10 = i6 | ((b2 & Byte.MAX_VALUE) << 7);
        int i11 = i5 + 2;
        byte b3 = bArr[i8];
        if (b3 >= 0) {
            registers.int1 = i10 | (b3 << 14);
            return i11;
        }
        int i12 = i10 | ((b3 & Byte.MAX_VALUE) << 14);
        int i13 = i5 + 3;
        byte b4 = bArr[i11];
        if (b4 >= 0) {
            registers.int1 = i12 | (b4 << 21);
            return i13;
        }
        int i14 = i12 | ((b4 & Byte.MAX_VALUE) << 21);
        int i15 = i5 + 4;
        byte b5 = bArr[i13];
        if (b5 >= 0) {
            registers.int1 = i14 | (b5 << 28);
            return i15;
        }
        int i16 = i14 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i17 = i15 + 1;
            if (bArr[i15] < 0) {
                i15 = i17;
            } else {
                registers.int1 = i16;
                return i17;
            }
        }
    }

    public static int f(int i, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.addLong(i9(bArr, i5));
        int i8 = i5 + 8;
        while (i8 < i6) {
            int ud2 = ud(bArr, i8, registers);
            if (i != registers.int1) {
                break;
            }
            longArrayList.addLong(i9(bArr, ud2));
            i8 = ud2 + 8;
        }
        return i8;
    }

    public static int f3(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1 + ud2;
        while (ud2 < i5) {
            ud2 = b(bArr, ud2, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        if (ud2 == i5) {
            return ud2;
        }
        throw InvalidProtocolBufferException.ta();
    }

    public static int fb(int i, byte[] bArr, int i5, int i6, Object obj, MessageLite messageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension findLiteExtensionByNumber = registers.extensionRegistry.findLiteExtensionByNumber(messageLite, i >>> 3);
        if (findLiteExtensionByNumber == null) {
            return z6(i, bArr, i5, i6, MessageSchema.wz(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.ensureExtensionsAreMutable();
        return a(i, bArr, i5, i6, extendableMessage, findLiteExtensionByNumber, unknownFieldSchema, registers);
    }

    public static int fh(int i, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int b2 = b(bArr, i5, registers);
        longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        while (b2 < i6) {
            int ud2 = ud(bArr, b2, registers);
            if (i != registers.int1) {
                break;
            }
            b2 = b(bArr, ud2, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        return b2;
    }

    public static double gv(byte[] bArr, int i) {
        return Double.longBitsToDouble(i9(bArr, i));
    }

    public static int hw(int i, byte[] bArr, int i5, int i6, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i) != 0) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType != 0) {
                if (tagWireType != 1) {
                    if (tagWireType != 2) {
                        if (tagWireType != 3) {
                            if (tagWireType == 5) {
                                return i5 + 4;
                            }
                            throw InvalidProtocolBufferException.v();
                        }
                        int i8 = (i & (-8)) | 4;
                        int i10 = 0;
                        while (i5 < i6) {
                            i5 = ud(bArr, i5, registers);
                            i10 = registers.int1;
                            if (i10 == i8) {
                                break;
                            }
                            i5 = hw(i10, bArr, i5, i6, registers);
                        }
                        if (i5 <= i6 && i10 == i8) {
                            return i5;
                        }
                        throw InvalidProtocolBufferException.mt();
                    }
                    return ud(bArr, i5, registers) + registers.int1;
                }
                return i5 + 8;
            }
            return b(bArr, i5, registers);
        }
        throw InvalidProtocolBufferException.v();
    }

    public static int i4(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1 + ud2;
        while (ud2 < i5) {
            ud2 = ud(bArr, ud2, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        if (ud2 == i5) {
            return ud2;
        }
        throw InvalidProtocolBufferException.ta();
    }

    public static long i9(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public static int k5(int i, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int b2 = b(bArr, i5, registers);
        longArrayList.addLong(registers.long1);
        while (b2 < i6) {
            int ud2 = ud(bArr, b2, registers);
            if (i != registers.int1) {
                break;
            }
            b2 = b(bArr, ud2, registers);
            longArrayList.addLong(registers.long1);
        }
        return b2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x001a -> B:9:0x001b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int mg(int r4, byte[] r5, int r6, int r7, com.google.protobuf.Internal.ProtobufList<?> r8, com.google.protobuf.ArrayDecoders.Registers r9) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r6 = ud(r5, r6, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L45
            java.lang.String r1 = ""
            if (r0 != 0) goto L10
            r8.add(r1)
            goto L1b
        L10:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.f6450n3
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
        L1a:
            int r6 = r6 + r0
        L1b:
            if (r6 >= r7) goto L44
            int r0 = ud(r5, r6, r9)
            int r2 = r9.int1
            if (r4 == r2) goto L26
            goto L44
        L26:
            int r6 = ud(r5, r0, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L3f
            if (r0 != 0) goto L34
            r8.add(r1)
            goto L1b
        L34:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.f6450n3
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
            goto L1a
        L3f:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.p()
            throw r4
        L44:
            return r6
        L45:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.p()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.mg(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public static int mt(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        boolean z2;
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1 + ud2;
        while (ud2 < i5) {
            ud2 = b(bArr, ud2, registers);
            if (registers.long1 != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            booleanArrayList.addBoolean(z2);
        }
        if (ud2 == i5) {
            return ud2;
        }
        throw InvalidProtocolBufferException.ta();
    }

    public static int n(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1 + ud2;
        while (ud2 < i5) {
            ud2 = ud(bArr, ud2, registers);
            intArrayList.addInt(registers.int1);
        }
        if (ud2 == i5) {
            return ud2;
        }
        throw InvalidProtocolBufferException.ta();
    }

    public static int n3(byte[] bArr, int i, Registers registers) throws InvalidProtocolBufferException {
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1;
        if (i5 >= 0) {
            if (i5 <= bArr.length - ud2) {
                if (i5 == 0) {
                    registers.object1 = ByteString.EMPTY;
                    return ud2;
                }
                registers.object1 = ByteString.copyFrom(bArr, ud2, i5);
                return ud2 + i5;
            }
            throw InvalidProtocolBufferException.ta();
        }
        throw InvalidProtocolBufferException.p();
    }

    public static int p(Schema<?> schema, int i, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int w4 = w(schema, bArr, i5, i6, registers);
        protobufList.add(registers.object1);
        while (w4 < i6) {
            int ud2 = ud(bArr, w4, registers);
            if (i != registers.int1) {
                break;
            }
            w4 = w(schema, bArr, ud2, i6, registers);
            protobufList.add(registers.object1);
        }
        return w4;
    }

    public static int r(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1 + ud2;
        while (ud2 < i5) {
            longArrayList.addLong(i9(bArr, ud2));
            ud2 += 8;
        }
        if (ud2 == i5) {
            return ud2;
        }
        throw InvalidProtocolBufferException.ta();
    }

    public static int rz(byte[] bArr, int i, Registers registers) throws InvalidProtocolBufferException {
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1;
        if (i5 >= 0) {
            if (i5 == 0) {
                registers.object1 = "";
                return ud2;
            }
            registers.object1 = new String(bArr, ud2, i5, Internal.f6450n3);
            return ud2 + i5;
        }
        throw InvalidProtocolBufferException.p();
    }

    public static int s(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static float t(byte[] bArr, int i) {
        return Float.intBitsToFloat(s(bArr, i));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0023). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int ta(int r5, byte[] r6, int r7, int r8, com.google.protobuf.Internal.ProtobufList<?> r9, com.google.protobuf.ArrayDecoders.Registers r10) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r7 = ud(r6, r7, r10)
            int r0 = r10.int1
            if (r0 < 0) goto L5f
            java.lang.String r1 = ""
            if (r0 != 0) goto L10
            r9.add(r1)
            goto L23
        L10:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.Utf8.r(r6, r7, r2)
            if (r3 == 0) goto L5a
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.f6450n3
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
        L22:
            r7 = r2
        L23:
            if (r7 >= r8) goto L59
            int r0 = ud(r6, r7, r10)
            int r2 = r10.int1
            if (r5 == r2) goto L2e
            goto L59
        L2e:
            int r7 = ud(r6, r0, r10)
            int r0 = r10.int1
            if (r0 < 0) goto L54
            if (r0 != 0) goto L3c
            r9.add(r1)
            goto L23
        L3c:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.Utf8.r(r6, r7, r2)
            if (r3 == 0) goto L4f
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.f6450n3
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
            goto L22
        L4f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.s()
            throw r5
        L54:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.p()
            throw r5
        L59:
            return r7
        L5a:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.s()
            throw r5
        L5f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.p()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.ta(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public static int tl(int i, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.addFloat(t(bArr, i5));
        int i8 = i5 + 4;
        while (i8 < i6) {
            int ud2 = ud(bArr, i8, registers);
            if (i != registers.int1) {
                break;
            }
            floatArrayList.addFloat(t(bArr, ud2));
            i8 = ud2 + 4;
        }
        return i8;
    }

    public static int ud(byte[] bArr, int i, Registers registers) {
        int i5 = i + 1;
        byte b2 = bArr[i];
        if (b2 >= 0) {
            registers.int1 = b2;
            return i5;
        }
        return ej(b2, bArr, i5, registers);
    }

    public static int v(int i, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.addDouble(gv(bArr, i5));
        int i8 = i5 + 8;
        while (i8 < i6) {
            int ud2 = ud(bArr, i8, registers);
            if (i != registers.int1) {
                break;
            }
            doubleArrayList.addDouble(gv(bArr, ud2));
            i8 = ud2 + 8;
        }
        return i8;
    }

    public static int vl(Object obj, Schema schema, byte[] bArr, int i, int i5, Registers registers) throws IOException {
        int i6 = i + 1;
        int i8 = bArr[i];
        if (i8 < 0) {
            i6 = ej(i8, bArr, i6, registers);
            i8 = registers.int1;
        }
        int i10 = i6;
        if (i8 >= 0 && i8 <= i5 - i10) {
            int i11 = i8 + i10;
            schema.mergeFrom(obj, bArr, i10, i11, registers);
            registers.object1 = obj;
            return i11;
        }
        throw InvalidProtocolBufferException.ta();
    }

    public static int w(Schema schema, byte[] bArr, int i, int i5, Registers registers) throws IOException {
        Object newInstance = schema.newInstance();
        int vl2 = vl(newInstance, schema, bArr, i, i5, registers);
        schema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return vl2;
    }

    public static int wz(Schema schema, byte[] bArr, int i, int i5, int i6, Registers registers) throws IOException {
        Object newInstance = schema.newInstance();
        int yt2 = yt(newInstance, schema, bArr, i, i5, i6, registers);
        schema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return yt2;
    }

    public static int x(long j2, byte[] bArr, int i, Registers registers) {
        int i5 = i + 1;
        byte b2 = bArr[i];
        long j4 = (j2 & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i6 = 7;
        while (b2 < 0) {
            int i8 = i5 + 1;
            byte b3 = bArr[i5];
            i6 += 7;
            j4 |= (b3 & Byte.MAX_VALUE) << i6;
            i5 = i8;
            b2 = b3;
        }
        registers.long1 = j4;
        return i5;
    }

    public static int x4(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1 + ud2;
        while (ud2 < i5) {
            floatArrayList.addFloat(t(bArr, ud2));
            ud2 += 4;
        }
        if (ud2 == i5) {
            return ud2;
        }
        throw InvalidProtocolBufferException.ta();
    }

    public static int xc(Schema schema, int i, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int i8 = (i & (-8)) | 4;
        int wz2 = wz(schema, bArr, i5, i6, i8, registers);
        protobufList.add(registers.object1);
        while (wz2 < i6) {
            int ud2 = ud(bArr, wz2, registers);
            if (i != registers.int1) {
                break;
            }
            wz2 = wz(schema, bArr, ud2, i6, i8, registers);
            protobufList.add(registers.object1);
        }
        return wz2;
    }

    public static int y(int i, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        boolean z2;
        boolean z3;
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int b2 = b(bArr, i5, registers);
        if (registers.long1 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        booleanArrayList.addBoolean(z2);
        while (b2 < i6) {
            int ud2 = ud(bArr, b2, registers);
            if (i != registers.int1) {
                break;
            }
            b2 = b(bArr, ud2, registers);
            if (registers.long1 != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            booleanArrayList.addBoolean(z3);
        }
        return b2;
    }

    public static int yt(Object obj, Schema schema, byte[] bArr, int i, int i5, int i6, Registers registers) throws IOException {
        int oz2 = ((MessageSchema) schema).oz(obj, bArr, i, i5, i6, registers);
        registers.object1 = obj;
        return oz2;
    }

    public static int z(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int ud2 = ud(bArr, i, registers);
        int i5 = registers.int1 + ud2;
        while (ud2 < i5) {
            intArrayList.addInt(s(bArr, ud2));
            ud2 += 4;
        }
        if (ud2 == i5) {
            return ud2;
        }
        throw InvalidProtocolBufferException.ta();
    }

    public static int z6(int i, byte[] bArr, int i5, int i6, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i) != 0) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType != 0) {
                if (tagWireType != 1) {
                    if (tagWireType != 2) {
                        if (tagWireType != 3) {
                            if (tagWireType == 5) {
                                unknownFieldSetLite.wz(i, Integer.valueOf(s(bArr, i5)));
                                return i5 + 4;
                            }
                            throw InvalidProtocolBufferException.v();
                        }
                        UnknownFieldSetLite f4 = UnknownFieldSetLite.f();
                        int i8 = (i & (-8)) | 4;
                        int i10 = 0;
                        while (true) {
                            if (i5 >= i6) {
                                break;
                            }
                            int ud2 = ud(bArr, i5, registers);
                            int i11 = registers.int1;
                            if (i11 == i8) {
                                i10 = i11;
                                i5 = ud2;
                                break;
                            }
                            i10 = i11;
                            i5 = z6(i11, bArr, ud2, i6, f4, registers);
                        }
                        if (i5 <= i6 && i10 == i8) {
                            unknownFieldSetLite.wz(i, f4);
                            return i5;
                        }
                        throw InvalidProtocolBufferException.mt();
                    }
                    int ud3 = ud(bArr, i5, registers);
                    int i12 = registers.int1;
                    if (i12 >= 0) {
                        if (i12 <= bArr.length - ud3) {
                            if (i12 == 0) {
                                unknownFieldSetLite.wz(i, ByteString.EMPTY);
                            } else {
                                unknownFieldSetLite.wz(i, ByteString.copyFrom(bArr, ud3, i12));
                            }
                            return ud3 + i12;
                        }
                        throw InvalidProtocolBufferException.ta();
                    }
                    throw InvalidProtocolBufferException.p();
                }
                unknownFieldSetLite.wz(i, Long.valueOf(i9(bArr, i5)));
                return i5 + 8;
            }
            int b2 = b(bArr, i5, registers);
            unknownFieldSetLite.wz(i, Long.valueOf(registers.long1));
            return b2;
        }
        throw InvalidProtocolBufferException.v();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x001b -> B:10:0x001c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zn(int r2, byte[] r3, int r4, int r5, com.google.protobuf.Internal.ProtobufList<?> r6, com.google.protobuf.ArrayDecoders.Registers r7) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r4 = ud(r3, r4, r7)
            int r0 = r7.int1
            if (r0 < 0) goto L53
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L4e
            if (r0 != 0) goto L14
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L1c
        L14:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
        L1b:
            int r4 = r4 + r0
        L1c:
            if (r4 >= r5) goto L4d
            int r0 = ud(r3, r4, r7)
            int r1 = r7.int1
            if (r2 == r1) goto L27
            goto L4d
        L27:
            int r4 = ud(r3, r0, r7)
            int r0 = r7.int1
            if (r0 < 0) goto L48
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L43
            if (r0 != 0) goto L3b
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L1c
        L3b:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
            goto L1b
        L43:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.ta()
            throw r2
        L48:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.p()
            throw r2
        L4d:
            return r4
        L4e:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.ta()
            throw r2
        L53:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.p()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.zn(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* loaded from: classes.dex */
    public static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;

        public Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        public Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.extensionRegistry = extensionRegistryLite;
        }
    }
}
