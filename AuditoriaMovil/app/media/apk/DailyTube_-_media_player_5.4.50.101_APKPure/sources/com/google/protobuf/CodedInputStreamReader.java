package com.google.protobuf;

import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public final class CodedInputStreamReader implements Reader {

    /* renamed from: gv  reason: collision with root package name */
    public int f6364gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f6365n3;
    public final CodedInputStream y;

    /* renamed from: zn  reason: collision with root package name */
    public int f6366zn;

    /* renamed from: com.google.protobuf.CodedInputStreamReader$1  reason: invalid class name */
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
                y[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                y[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                y[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                y[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                y[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                y[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                y[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                y[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                y[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                y[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                y[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                y[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                y[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public CodedInputStreamReader(CodedInputStream codedInputStream) {
        CodedInputStream codedInputStream2 = (CodedInputStream) Internal.n3(codedInputStream, "input");
        this.y = codedInputStream2;
        codedInputStream2.f6317gv = this;
    }

    private void a(int i) throws IOException {
        if (this.y.getTotalBytesRead() == i) {
            return;
        }
        throw InvalidProtocolBufferException.ta();
    }

    private void c5(int i) throws IOException {
        if ((i & 7) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.mt();
    }

    private void fb(int i) throws IOException {
        if (WireFormat.getTagWireType(this.f6365n3) == i) {
            return;
        }
        throw InvalidProtocolBufferException.i9();
    }

    public static CodedInputStreamReader forCodedInput(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.f6317gv;
        if (codedInputStreamReader != null) {
            return codedInputStreamReader;
        }
        return new CodedInputStreamReader(codedInputStream);
    }

    private <T> T gv(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        T newInstance = schema.newInstance();
        y(newInstance, schema, extensionRegistryLite);
        schema.makeImmutable(newInstance);
        return newInstance;
    }

    private void s(int i) throws IOException {
        if ((i & 3) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.mt();
    }

    private <T> T v(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        T newInstance = schema.newInstance();
        n3(newInstance, schema, extensionRegistryLite);
        schema.makeImmutable(newInstance);
        return newInstance;
    }

    private Object zn(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        switch (AnonymousClass1.y[fieldType.ordinal()]) {
            case 1:
                return Boolean.valueOf(readBool());
            case 2:
                return readBytes();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(readEnum());
            case 5:
                return Integer.valueOf(readFixed32());
            case 6:
                return Long.valueOf(readFixed64());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(readInt32());
            case 9:
                return Long.valueOf(readInt64());
            case 10:
                return readMessage(cls, extensionRegistryLite);
            case 11:
                return Integer.valueOf(readSFixed32());
            case 12:
                return Long.valueOf(readSFixed64());
            case 13:
                return Integer.valueOf(readSInt32());
            case 14:
                return Long.valueOf(readSInt64());
            case 15:
                return readStringRequireUtf8();
            case 16:
                return Integer.valueOf(readUInt32());
            case 17:
                return Long.valueOf(readUInt64());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    @Override // com.google.protobuf.Reader
    public int getFieldNumber() throws IOException {
        int i = this.f6364gv;
        if (i != 0) {
            this.f6365n3 = i;
            this.f6364gv = 0;
        } else {
            this.f6365n3 = this.y.readTag();
        }
        int i5 = this.f6365n3;
        if (i5 != 0 && i5 != this.f6366zn) {
            return WireFormat.getTagFieldNumber(i5);
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.google.protobuf.Reader
    public int getTag() {
        return this.f6365n3;
    }

    @Override // com.google.protobuf.Reader
    public <T> void mergeGroupField(T t2, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        fb(3);
        y(t2, schema, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    public <T> void mergeMessageField(T t2, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        fb(2);
        n3(t2, schema, extensionRegistryLite);
    }

    public final <T> void n3(T t2, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream;
        int readUInt32 = this.y.readUInt32();
        CodedInputStream codedInputStream2 = this.y;
        if (codedInputStream2.y < codedInputStream2.f6318n3) {
            int pushLimit = codedInputStream2.pushLimit(readUInt32);
            this.y.y++;
            schema.mergeFrom(t2, this, extensionRegistryLite);
            this.y.checkLastTagWas(0);
            codedInputStream.y--;
            this.y.popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferException.co();
    }

    @Override // com.google.protobuf.Reader
    public boolean readBool() throws IOException {
        fb(0);
        return this.y.readBool();
    }

    @Override // com.google.protobuf.Reader
    public void readBoolList(List<Boolean> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof BooleanArrayList) {
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.y.getTotalBytesRead() + this.y.readUInt32();
                    do {
                        booleanArrayList.addBoolean(this.y.readBool());
                    } while (this.y.getTotalBytesRead() < totalBytesRead);
                    a(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            do {
                booleanArrayList.addBoolean(this.y.readBool());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag2 = this.y.readTag();
            } while (readTag2 == this.f6365n3);
            this.f6364gv = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.y.getTotalBytesRead() + this.y.readUInt32();
                do {
                    list.add(Boolean.valueOf(this.y.readBool()));
                } while (this.y.getTotalBytesRead() < totalBytesRead2);
                a(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        do {
            list.add(Boolean.valueOf(this.y.readBool()));
            if (this.y.isAtEnd()) {
                return;
            }
            readTag = this.y.readTag();
        } while (readTag == this.f6365n3);
        this.f6364gv = readTag;
    }

    @Override // com.google.protobuf.Reader
    public ByteString readBytes() throws IOException {
        fb(2);
        return this.y.readBytes();
    }

    @Override // com.google.protobuf.Reader
    public void readBytesList(List<ByteString> list) throws IOException {
        int readTag;
        if (WireFormat.getTagWireType(this.f6365n3) == 2) {
            do {
                list.add(readBytes());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag = this.y.readTag();
            } while (readTag == this.f6365n3);
            this.f6364gv = readTag;
            return;
        }
        throw InvalidProtocolBufferException.i9();
    }

    @Override // com.google.protobuf.Reader
    public double readDouble() throws IOException {
        fb(1);
        return this.y.readDouble();
    }

    @Override // com.google.protobuf.Reader
    public void readDoubleList(List<Double> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof DoubleArrayList) {
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 1) {
                if (tagWireType == 2) {
                    int readUInt32 = this.y.readUInt32();
                    c5(readUInt32);
                    int totalBytesRead = this.y.getTotalBytesRead() + readUInt32;
                    do {
                        doubleArrayList.addDouble(this.y.readDouble());
                    } while (this.y.getTotalBytesRead() < totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            do {
                doubleArrayList.addDouble(this.y.readDouble());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag2 = this.y.readTag();
            } while (readTag2 == this.f6365n3);
            this.f6364gv = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 1) {
            if (tagWireType2 == 2) {
                int readUInt322 = this.y.readUInt32();
                c5(readUInt322);
                int totalBytesRead2 = this.y.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Double.valueOf(this.y.readDouble()));
                } while (this.y.getTotalBytesRead() < totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        do {
            list.add(Double.valueOf(this.y.readDouble()));
            if (this.y.isAtEnd()) {
                return;
            }
            readTag = this.y.readTag();
        } while (readTag == this.f6365n3);
        this.f6364gv = readTag;
    }

    @Override // com.google.protobuf.Reader
    public int readEnum() throws IOException {
        fb(0);
        return this.y.readEnum();
    }

    @Override // com.google.protobuf.Reader
    public void readEnumList(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.y.getTotalBytesRead() + this.y.readUInt32();
                    do {
                        intArrayList.addInt(this.y.readEnum());
                    } while (this.y.getTotalBytesRead() < totalBytesRead);
                    a(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            do {
                intArrayList.addInt(this.y.readEnum());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag2 = this.y.readTag();
            } while (readTag2 == this.f6365n3);
            this.f6364gv = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.y.getTotalBytesRead() + this.y.readUInt32();
                do {
                    list.add(Integer.valueOf(this.y.readEnum()));
                } while (this.y.getTotalBytesRead() < totalBytesRead2);
                a(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        do {
            list.add(Integer.valueOf(this.y.readEnum()));
            if (this.y.isAtEnd()) {
                return;
            }
            readTag = this.y.readTag();
        } while (readTag == this.f6365n3);
        this.f6364gv = readTag;
    }

    @Override // com.google.protobuf.Reader
    public int readFixed32() throws IOException {
        fb(5);
        return this.y.readFixed32();
    }

    @Override // com.google.protobuf.Reader
    public void readFixed32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 2) {
                if (tagWireType == 5) {
                    do {
                        intArrayList.addInt(this.y.readFixed32());
                        if (this.y.isAtEnd()) {
                            return;
                        }
                        readTag2 = this.y.readTag();
                    } while (readTag2 == this.f6365n3);
                    this.f6364gv = readTag2;
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            int readUInt32 = this.y.readUInt32();
            s(readUInt32);
            int totalBytesRead = this.y.getTotalBytesRead() + readUInt32;
            do {
                intArrayList.addInt(this.y.readFixed32());
            } while (this.y.getTotalBytesRead() < totalBytesRead);
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 2) {
            if (tagWireType2 == 5) {
                do {
                    list.add(Integer.valueOf(this.y.readFixed32()));
                    if (this.y.isAtEnd()) {
                        return;
                    }
                    readTag = this.y.readTag();
                } while (readTag == this.f6365n3);
                this.f6364gv = readTag;
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        int readUInt322 = this.y.readUInt32();
        s(readUInt322);
        int totalBytesRead2 = this.y.getTotalBytesRead() + readUInt322;
        do {
            list.add(Integer.valueOf(this.y.readFixed32()));
        } while (this.y.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.google.protobuf.Reader
    public long readFixed64() throws IOException {
        fb(1);
        return this.y.readFixed64();
    }

    @Override // com.google.protobuf.Reader
    public void readFixed64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 1) {
                if (tagWireType == 2) {
                    int readUInt32 = this.y.readUInt32();
                    c5(readUInt32);
                    int totalBytesRead = this.y.getTotalBytesRead() + readUInt32;
                    do {
                        longArrayList.addLong(this.y.readFixed64());
                    } while (this.y.getTotalBytesRead() < totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            do {
                longArrayList.addLong(this.y.readFixed64());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag2 = this.y.readTag();
            } while (readTag2 == this.f6365n3);
            this.f6364gv = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 1) {
            if (tagWireType2 == 2) {
                int readUInt322 = this.y.readUInt32();
                c5(readUInt322);
                int totalBytesRead2 = this.y.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Long.valueOf(this.y.readFixed64()));
                } while (this.y.getTotalBytesRead() < totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        do {
            list.add(Long.valueOf(this.y.readFixed64()));
            if (this.y.isAtEnd()) {
                return;
            }
            readTag = this.y.readTag();
        } while (readTag == this.f6365n3);
        this.f6364gv = readTag;
    }

    @Override // com.google.protobuf.Reader
    public float readFloat() throws IOException {
        fb(5);
        return this.y.readFloat();
    }

    @Override // com.google.protobuf.Reader
    public void readFloatList(List<Float> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof FloatArrayList) {
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 2) {
                if (tagWireType == 5) {
                    do {
                        floatArrayList.addFloat(this.y.readFloat());
                        if (this.y.isAtEnd()) {
                            return;
                        }
                        readTag2 = this.y.readTag();
                    } while (readTag2 == this.f6365n3);
                    this.f6364gv = readTag2;
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            int readUInt32 = this.y.readUInt32();
            s(readUInt32);
            int totalBytesRead = this.y.getTotalBytesRead() + readUInt32;
            do {
                floatArrayList.addFloat(this.y.readFloat());
            } while (this.y.getTotalBytesRead() < totalBytesRead);
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 2) {
            if (tagWireType2 == 5) {
                do {
                    list.add(Float.valueOf(this.y.readFloat()));
                    if (this.y.isAtEnd()) {
                        return;
                    }
                    readTag = this.y.readTag();
                } while (readTag == this.f6365n3);
                this.f6364gv = readTag;
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        int readUInt322 = this.y.readUInt32();
        s(readUInt322);
        int totalBytesRead2 = this.y.getTotalBytesRead() + readUInt322;
        do {
            list.add(Float.valueOf(this.y.readFloat()));
        } while (this.y.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.google.protobuf.Reader
    @Deprecated
    public <T> T readGroup(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        fb(3);
        return (T) gv(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    @Deprecated
    public <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        fb(3);
        return (T) gv(schema, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    @Deprecated
    public <T> void readGroupList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        readGroupList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    public int readInt32() throws IOException {
        fb(0);
        return this.y.readInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.y.getTotalBytesRead() + this.y.readUInt32();
                    do {
                        intArrayList.addInt(this.y.readInt32());
                    } while (this.y.getTotalBytesRead() < totalBytesRead);
                    a(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            do {
                intArrayList.addInt(this.y.readInt32());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag2 = this.y.readTag();
            } while (readTag2 == this.f6365n3);
            this.f6364gv = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.y.getTotalBytesRead() + this.y.readUInt32();
                do {
                    list.add(Integer.valueOf(this.y.readInt32()));
                } while (this.y.getTotalBytesRead() < totalBytesRead2);
                a(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        do {
            list.add(Integer.valueOf(this.y.readInt32()));
            if (this.y.isAtEnd()) {
                return;
            }
            readTag = this.y.readTag();
        } while (readTag == this.f6365n3);
        this.f6364gv = readTag;
    }

    @Override // com.google.protobuf.Reader
    public long readInt64() throws IOException {
        fb(0);
        return this.y.readInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.y.getTotalBytesRead() + this.y.readUInt32();
                    do {
                        longArrayList.addLong(this.y.readInt64());
                    } while (this.y.getTotalBytesRead() < totalBytesRead);
                    a(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            do {
                longArrayList.addLong(this.y.readInt64());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag2 = this.y.readTag();
            } while (readTag2 == this.f6365n3);
            this.f6364gv = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.y.getTotalBytesRead() + this.y.readUInt32();
                do {
                    list.add(Long.valueOf(this.y.readInt64()));
                } while (this.y.getTotalBytesRead() < totalBytesRead2);
                a(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        do {
            list.add(Long.valueOf(this.y.readInt64()));
            if (this.y.isAtEnd()) {
                return;
            }
            readTag = this.y.readTag();
        } while (readTag == this.f6365n3);
        this.f6364gv = readTag;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
        r7.y.popLimit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <K, V> void readMap(java.util.Map<K, V> r8, com.google.protobuf.MapEntryLite.Metadata<K, V> r9, com.google.protobuf.ExtensionRegistryLite r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.fb(r0)
            com.google.protobuf.CodedInputStream r1 = r7.y
            int r1 = r1.readUInt32()
            com.google.protobuf.CodedInputStream r2 = r7.y
            int r1 = r2.pushLimit(r1)
            K r2 = r9.defaultKey
            V r3 = r9.defaultValue
        L14:
            int r4 = r7.getFieldNumber()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            com.google.protobuf.CodedInputStream r5 = r7.y     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.isAtEnd()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.skipField()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            com.google.protobuf.InvalidProtocolBufferException r4 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            com.google.protobuf.WireFormat$FieldType r4 = r9.valueType     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            V r5 = r9.defaultValue     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r3 = r7.zn(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L49:
            com.google.protobuf.WireFormat$FieldType r4 = r9.keyType     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r5 = 0
            java.lang.Object r2 = r7.zn(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L51:
            boolean r4 = r7.skipField()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            com.google.protobuf.CodedInputStream r8 = r7.y
            r8.popLimit(r1)
            return
        L67:
            com.google.protobuf.CodedInputStream r9 = r7.y
            r9.popLimit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStreamReader.readMap(java.util.Map, com.google.protobuf.MapEntryLite$Metadata, com.google.protobuf.ExtensionRegistryLite):void");
    }

    @Override // com.google.protobuf.Reader
    public <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        fb(2);
        return (T) v(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    public <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        fb(2);
        return (T) v(schema, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    public <T> void readMessageList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        readMessageList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    public int readSFixed32() throws IOException {
        fb(5);
        return this.y.readSFixed32();
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 2) {
                if (tagWireType == 5) {
                    do {
                        intArrayList.addInt(this.y.readSFixed32());
                        if (this.y.isAtEnd()) {
                            return;
                        }
                        readTag2 = this.y.readTag();
                    } while (readTag2 == this.f6365n3);
                    this.f6364gv = readTag2;
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            int readUInt32 = this.y.readUInt32();
            s(readUInt32);
            int totalBytesRead = this.y.getTotalBytesRead() + readUInt32;
            do {
                intArrayList.addInt(this.y.readSFixed32());
            } while (this.y.getTotalBytesRead() < totalBytesRead);
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 2) {
            if (tagWireType2 == 5) {
                do {
                    list.add(Integer.valueOf(this.y.readSFixed32()));
                    if (this.y.isAtEnd()) {
                        return;
                    }
                    readTag = this.y.readTag();
                } while (readTag == this.f6365n3);
                this.f6364gv = readTag;
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        int readUInt322 = this.y.readUInt32();
        s(readUInt322);
        int totalBytesRead2 = this.y.getTotalBytesRead() + readUInt322;
        do {
            list.add(Integer.valueOf(this.y.readSFixed32()));
        } while (this.y.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.google.protobuf.Reader
    public long readSFixed64() throws IOException {
        fb(1);
        return this.y.readSFixed64();
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 1) {
                if (tagWireType == 2) {
                    int readUInt32 = this.y.readUInt32();
                    c5(readUInt32);
                    int totalBytesRead = this.y.getTotalBytesRead() + readUInt32;
                    do {
                        longArrayList.addLong(this.y.readSFixed64());
                    } while (this.y.getTotalBytesRead() < totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            do {
                longArrayList.addLong(this.y.readSFixed64());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag2 = this.y.readTag();
            } while (readTag2 == this.f6365n3);
            this.f6364gv = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 1) {
            if (tagWireType2 == 2) {
                int readUInt322 = this.y.readUInt32();
                c5(readUInt322);
                int totalBytesRead2 = this.y.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Long.valueOf(this.y.readSFixed64()));
                } while (this.y.getTotalBytesRead() < totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        do {
            list.add(Long.valueOf(this.y.readSFixed64()));
            if (this.y.isAtEnd()) {
                return;
            }
            readTag = this.y.readTag();
        } while (readTag == this.f6365n3);
        this.f6364gv = readTag;
    }

    @Override // com.google.protobuf.Reader
    public int readSInt32() throws IOException {
        fb(0);
        return this.y.readSInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readSInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.y.getTotalBytesRead() + this.y.readUInt32();
                    do {
                        intArrayList.addInt(this.y.readSInt32());
                    } while (this.y.getTotalBytesRead() < totalBytesRead);
                    a(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            do {
                intArrayList.addInt(this.y.readSInt32());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag2 = this.y.readTag();
            } while (readTag2 == this.f6365n3);
            this.f6364gv = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.y.getTotalBytesRead() + this.y.readUInt32();
                do {
                    list.add(Integer.valueOf(this.y.readSInt32()));
                } while (this.y.getTotalBytesRead() < totalBytesRead2);
                a(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        do {
            list.add(Integer.valueOf(this.y.readSInt32()));
            if (this.y.isAtEnd()) {
                return;
            }
            readTag = this.y.readTag();
        } while (readTag == this.f6365n3);
        this.f6364gv = readTag;
    }

    @Override // com.google.protobuf.Reader
    public long readSInt64() throws IOException {
        fb(0);
        return this.y.readSInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readSInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.y.getTotalBytesRead() + this.y.readUInt32();
                    do {
                        longArrayList.addLong(this.y.readSInt64());
                    } while (this.y.getTotalBytesRead() < totalBytesRead);
                    a(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            do {
                longArrayList.addLong(this.y.readSInt64());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag2 = this.y.readTag();
            } while (readTag2 == this.f6365n3);
            this.f6364gv = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.y.getTotalBytesRead() + this.y.readUInt32();
                do {
                    list.add(Long.valueOf(this.y.readSInt64()));
                } while (this.y.getTotalBytesRead() < totalBytesRead2);
                a(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        do {
            list.add(Long.valueOf(this.y.readSInt64()));
            if (this.y.isAtEnd()) {
                return;
            }
            readTag = this.y.readTag();
        } while (readTag == this.f6365n3);
        this.f6364gv = readTag;
    }

    @Override // com.google.protobuf.Reader
    public String readString() throws IOException {
        fb(2);
        return this.y.readString();
    }

    @Override // com.google.protobuf.Reader
    public void readStringList(List<String> list) throws IOException {
        readStringListInternal(list, false);
    }

    public void readStringListInternal(List<String> list, boolean z2) throws IOException {
        String readString;
        int readTag;
        int readTag2;
        if (WireFormat.getTagWireType(this.f6365n3) == 2) {
            if ((list instanceof LazyStringList) && !z2) {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.add(readBytes());
                    if (this.y.isAtEnd()) {
                        return;
                    }
                    readTag2 = this.y.readTag();
                } while (readTag2 == this.f6365n3);
                this.f6364gv = readTag2;
                return;
            }
            do {
                if (z2) {
                    readString = readStringRequireUtf8();
                } else {
                    readString = readString();
                }
                list.add(readString);
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag = this.y.readTag();
            } while (readTag == this.f6365n3);
            this.f6364gv = readTag;
            return;
        }
        throw InvalidProtocolBufferException.i9();
    }

    @Override // com.google.protobuf.Reader
    public void readStringListRequireUtf8(List<String> list) throws IOException {
        readStringListInternal(list, true);
    }

    @Override // com.google.protobuf.Reader
    public String readStringRequireUtf8() throws IOException {
        fb(2);
        return this.y.readStringRequireUtf8();
    }

    @Override // com.google.protobuf.Reader
    public int readUInt32() throws IOException {
        fb(0);
        return this.y.readUInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readUInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.y.getTotalBytesRead() + this.y.readUInt32();
                    do {
                        intArrayList.addInt(this.y.readUInt32());
                    } while (this.y.getTotalBytesRead() < totalBytesRead);
                    a(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            do {
                intArrayList.addInt(this.y.readUInt32());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag2 = this.y.readTag();
            } while (readTag2 == this.f6365n3);
            this.f6364gv = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.y.getTotalBytesRead() + this.y.readUInt32();
                do {
                    list.add(Integer.valueOf(this.y.readUInt32()));
                } while (this.y.getTotalBytesRead() < totalBytesRead2);
                a(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        do {
            list.add(Integer.valueOf(this.y.readUInt32()));
            if (this.y.isAtEnd()) {
                return;
            }
            readTag = this.y.readTag();
        } while (readTag == this.f6365n3);
        this.f6364gv = readTag;
    }

    @Override // com.google.protobuf.Reader
    public long readUInt64() throws IOException {
        fb(0);
        return this.y.readUInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readUInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f6365n3);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.y.getTotalBytesRead() + this.y.readUInt32();
                    do {
                        longArrayList.addLong(this.y.readUInt64());
                    } while (this.y.getTotalBytesRead() < totalBytesRead);
                    a(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.i9();
            }
            do {
                longArrayList.addLong(this.y.readUInt64());
                if (this.y.isAtEnd()) {
                    return;
                }
                readTag2 = this.y.readTag();
            } while (readTag2 == this.f6365n3);
            this.f6364gv = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f6365n3);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.y.getTotalBytesRead() + this.y.readUInt32();
                do {
                    list.add(Long.valueOf(this.y.readUInt64()));
                } while (this.y.getTotalBytesRead() < totalBytesRead2);
                a(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.i9();
        }
        do {
            list.add(Long.valueOf(this.y.readUInt64()));
            if (this.y.isAtEnd()) {
                return;
            }
            readTag = this.y.readTag();
        } while (readTag == this.f6365n3);
        this.f6364gv = readTag;
    }

    @Override // com.google.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return this.y.gv();
    }

    @Override // com.google.protobuf.Reader
    public boolean skipField() throws IOException {
        int i;
        if (!this.y.isAtEnd() && (i = this.f6365n3) != this.f6366zn) {
            return this.y.skipField(i);
        }
        return false;
    }

    public final <T> void y(T t2, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i = this.f6366zn;
        this.f6366zn = WireFormat.y(WireFormat.getTagFieldNumber(this.f6365n3), 4);
        try {
            schema.mergeFrom(t2, this, extensionRegistryLite);
            if (this.f6365n3 == this.f6366zn) {
                return;
            }
            throw InvalidProtocolBufferException.mt();
        } finally {
            this.f6366zn = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    @Deprecated
    public <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readTag;
        if (WireFormat.getTagWireType(this.f6365n3) == 3) {
            int i = this.f6365n3;
            do {
                list.add(gv(schema, extensionRegistryLite));
                if (this.y.isAtEnd() || this.f6364gv != 0) {
                    return;
                }
                readTag = this.y.readTag();
            } while (readTag == i);
            this.f6364gv = readTag;
            return;
        }
        throw InvalidProtocolBufferException.i9();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    public <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readTag;
        if (WireFormat.getTagWireType(this.f6365n3) == 2) {
            int i = this.f6365n3;
            do {
                list.add(v(schema, extensionRegistryLite));
                if (this.y.isAtEnd() || this.f6364gv != 0) {
                    return;
                }
                readTag = this.y.readTag();
            } while (readTag == i);
            this.f6364gv = readTag;
            return;
        }
        throw InvalidProtocolBufferException.i9();
    }
}
