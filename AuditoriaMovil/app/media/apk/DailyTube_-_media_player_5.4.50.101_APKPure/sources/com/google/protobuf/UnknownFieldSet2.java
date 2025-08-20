package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public final class UnknownFieldSet2 implements MessageLite {
    private final Map<Integer, Field> fields;
    private final Map<Integer, Field> fieldsDescending;
    private static final UnknownFieldSet2 defaultInstance = new UnknownFieldSet2(Collections.emptyMap(), Collections.emptyMap());
    private static final Parser PARSER = new Parser();

    /* loaded from: classes.dex */
    public static final class Builder implements MessageLite.Builder {
        private Map<Integer, Field> fields;
        private Field.Builder lastField;
        private int lastFieldNumber;

        private Builder() {
        }

        public static /* synthetic */ Builder access$000() {
            return create();
        }

        private static Builder create() {
            Builder builder = new Builder();
            builder.reinitialize();
            return builder;
        }

        private Field.Builder getFieldBuilder(int i) {
            Field.Builder builder = this.lastField;
            if (builder != null) {
                int i5 = this.lastFieldNumber;
                if (i == i5) {
                    return builder;
                }
                addField(i5, builder.build());
            }
            if (i == 0) {
                return null;
            }
            Field field = this.fields.get(Integer.valueOf(i));
            this.lastFieldNumber = i;
            Field.Builder newBuilder = Field.newBuilder();
            this.lastField = newBuilder;
            if (field != null) {
                newBuilder.mergeFrom(field);
            }
            return this.lastField;
        }

        private void reinitialize() {
            this.fields = Collections.emptyMap();
            this.lastFieldNumber = 0;
            this.lastField = null;
        }

        public Builder addField(int i, Field field) {
            if (i != 0) {
                if (this.lastField != null && this.lastFieldNumber == i) {
                    this.lastField = null;
                    this.lastFieldNumber = 0;
                }
                if (this.fields.isEmpty()) {
                    this.fields = new TreeMap();
                }
                this.fields.put(Integer.valueOf(i), field);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public Map<Integer, Field> asMap() {
            getFieldBuilder(0);
            return Collections.unmodifiableMap(this.fields);
        }

        public Builder clearField(int i) {
            if (i != 0) {
                if (this.lastField != null && this.lastFieldNumber == i) {
                    this.lastField = null;
                    this.lastFieldNumber = 0;
                }
                if (this.fields.containsKey(Integer.valueOf(i))) {
                    this.fields.remove(Integer.valueOf(i));
                }
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public boolean hasField(int i) {
            if (i != 0) {
                if (i != this.lastFieldNumber && !this.fields.containsKey(Integer.valueOf(i))) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
            return true;
        }

        public Builder mergeField(int i, Field field) {
            if (i != 0) {
                if (hasField(i)) {
                    getFieldBuilder(i).mergeFrom(field);
                } else {
                    addField(i, field);
                }
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public boolean mergeFieldFrom(int i, CodedInputStream codedInputStream) throws IOException {
            int tagFieldNumber = WireFormat.getTagFieldNumber(i);
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType != 0) {
                if (tagWireType != 1) {
                    if (tagWireType != 2) {
                        if (tagWireType != 3) {
                            if (tagWireType != 4) {
                                if (tagWireType == 5) {
                                    getFieldBuilder(tagFieldNumber).addFixed32(codedInputStream.readFixed32());
                                    return true;
                                }
                                throw new InvalidProtocolBufferException.InvalidWireTypeException("Protocol message tag had invalid wire type.");
                            }
                            return false;
                        }
                        Builder newBuilder = UnknownFieldSet2.newBuilder();
                        codedInputStream.readGroup(tagFieldNumber, newBuilder, ExtensionRegistryLite.getEmptyRegistry());
                        getFieldBuilder(tagFieldNumber).addGroup(newBuilder.build());
                        return true;
                    }
                    getFieldBuilder(tagFieldNumber).addLengthDelimited(codedInputStream.readBytes());
                    return true;
                }
                getFieldBuilder(tagFieldNumber).addFixed64(codedInputStream.readFixed64());
                return true;
            }
            getFieldBuilder(tagFieldNumber).addVarint(codedInputStream.readInt64());
            return true;
        }

        public Builder mergeLengthDelimitedField(int i, ByteString byteString) {
            if (i != 0) {
                getFieldBuilder(i).addLengthDelimited(byteString);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public Builder mergeVarintField(int i, int i5) {
            if (i != 0) {
                getFieldBuilder(i).addVarint(i5);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public UnknownFieldSet2 build() {
            UnknownFieldSet2 unknownFieldSet2;
            getFieldBuilder(0);
            if (this.fields.isEmpty()) {
                unknownFieldSet2 = UnknownFieldSet2.getDefaultInstance();
            } else {
                unknownFieldSet2 = new UnknownFieldSet2(Collections.unmodifiableMap(this.fields), Collections.unmodifiableMap(((TreeMap) this.fields).descendingMap()));
            }
            this.fields = null;
            return unknownFieldSet2;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public UnknownFieldSet2 buildPartial() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder clear() {
            reinitialize();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public UnknownFieldSet2 getDefaultInstanceForType() {
            return UnknownFieldSet2.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: clone */
        public Builder m24clone() {
            getFieldBuilder(0);
            return UnknownFieldSet2.newBuilder().mergeFrom(new UnknownFieldSet2(this.fields, Collections.unmodifiableMap(((TreeMap) this.fields).descendingMap())));
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeDelimitedFrom(inputStream);
        }

        public Builder mergeFrom(UnknownFieldSet2 unknownFieldSet2) {
            if (unknownFieldSet2 != UnknownFieldSet2.getDefaultInstance()) {
                for (Map.Entry entry : unknownFieldSet2.fields.entrySet()) {
                    mergeField(((Integer) entry.getKey()).intValue(), (Field) entry.getValue());
                }
            }
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream) throws IOException {
            int readTag;
            do {
                readTag = codedInputStream.readTag();
                if (readTag == 0) {
                    break;
                }
            } while (mergeFieldFrom(readTag, codedInputStream));
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newCodedInput = byteString.newCodedInput();
                mergeFrom(newCodedInput);
                newCodedInput.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e3);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newInstance = CodedInputStream.newInstance(bArr);
                mergeFrom(newInstance);
                newInstance.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(InputStream inputStream) throws IOException {
            CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
            mergeFrom(newInstance);
            newInstance.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return mergeFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(byte[] bArr, int i, int i5) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i, i5);
                mergeFrom(newInstance);
                newInstance.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return mergeFrom(bArr);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(byte[] bArr, int i, int i5, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, i, i5);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(inputStream);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(MessageLite messageLite) {
            if (messageLite instanceof UnknownFieldSet2) {
                return mergeFrom((UnknownFieldSet2) messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    /* loaded from: classes.dex */
    public static final class Field {

        /* renamed from: a  reason: collision with root package name */
        public static final Field f6535a = newBuilder().build();

        /* renamed from: gv  reason: collision with root package name */
        public List<ByteString> f6536gv;

        /* renamed from: n3  reason: collision with root package name */
        public List<Integer> f6537n3;

        /* renamed from: v  reason: collision with root package name */
        public List<UnknownFieldSet2> f6538v;
        public List<Long> y;

        /* renamed from: zn  reason: collision with root package name */
        public List<Long> f6539zn;

        /* loaded from: classes.dex */
        public static final class Builder {
            public Field y;

            public static Builder n3() {
                Builder builder = new Builder();
                builder.y = new Field();
                return builder;
            }

            public static /* synthetic */ Builder y() {
                return n3();
            }

            public Builder addFixed32(int i) {
                if (this.y.f6537n3 == null) {
                    this.y.f6537n3 = new ArrayList();
                }
                this.y.f6537n3.add(Integer.valueOf(i));
                return this;
            }

            public Builder addFixed64(long j2) {
                if (this.y.f6539zn == null) {
                    this.y.f6539zn = new ArrayList();
                }
                this.y.f6539zn.add(Long.valueOf(j2));
                return this;
            }

            public Builder addGroup(UnknownFieldSet2 unknownFieldSet2) {
                if (this.y.f6538v == null) {
                    this.y.f6538v = new ArrayList();
                }
                this.y.f6538v.add(unknownFieldSet2);
                return this;
            }

            public Builder addLengthDelimited(ByteString byteString) {
                if (this.y.f6536gv == null) {
                    this.y.f6536gv = new ArrayList();
                }
                this.y.f6536gv.add(byteString);
                return this;
            }

            public Builder addVarint(long j2) {
                if (this.y.y == null) {
                    this.y.y = new ArrayList();
                }
                this.y.y.add(Long.valueOf(j2));
                return this;
            }

            public Field build() {
                if (this.y.y == null) {
                    this.y.y = Collections.emptyList();
                } else {
                    Field field = this.y;
                    field.y = Collections.unmodifiableList(field.y);
                }
                if (this.y.f6537n3 == null) {
                    this.y.f6537n3 = Collections.emptyList();
                } else {
                    Field field2 = this.y;
                    field2.f6537n3 = Collections.unmodifiableList(field2.f6537n3);
                }
                if (this.y.f6539zn == null) {
                    this.y.f6539zn = Collections.emptyList();
                } else {
                    Field field3 = this.y;
                    field3.f6539zn = Collections.unmodifiableList(field3.f6539zn);
                }
                if (this.y.f6536gv == null) {
                    this.y.f6536gv = Collections.emptyList();
                } else {
                    Field field4 = this.y;
                    field4.f6536gv = Collections.unmodifiableList(field4.f6536gv);
                }
                if (this.y.f6538v == null) {
                    this.y.f6538v = Collections.emptyList();
                } else {
                    Field field5 = this.y;
                    field5.f6538v = Collections.unmodifiableList(field5.f6538v);
                }
                Field field6 = this.y;
                this.y = null;
                return field6;
            }

            public Builder clear() {
                this.y = new Field();
                return this;
            }

            public Builder mergeFrom(Field field) {
                if (!field.y.isEmpty()) {
                    if (this.y.y == null) {
                        this.y.y = new ArrayList();
                    }
                    this.y.y.addAll(field.y);
                }
                if (!field.f6537n3.isEmpty()) {
                    if (this.y.f6537n3 == null) {
                        this.y.f6537n3 = new ArrayList();
                    }
                    this.y.f6537n3.addAll(field.f6537n3);
                }
                if (!field.f6539zn.isEmpty()) {
                    if (this.y.f6539zn == null) {
                        this.y.f6539zn = new ArrayList();
                    }
                    this.y.f6539zn.addAll(field.f6539zn);
                }
                if (!field.f6536gv.isEmpty()) {
                    if (this.y.f6536gv == null) {
                        this.y.f6536gv = new ArrayList();
                    }
                    this.y.f6536gv.addAll(field.f6536gv);
                }
                if (!field.f6538v.isEmpty()) {
                    if (this.y.f6538v == null) {
                        this.y.f6538v = new ArrayList();
                    }
                    this.y.f6538v.addAll(field.f6538v);
                }
                return this;
            }
        }

        public static Field getDefaultInstance() {
            return f6535a;
        }

        public static Builder newBuilder() {
            return Builder.y();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Field)) {
                return false;
            }
            return Arrays.equals(t(), ((Field) obj).t());
        }

        public List<Integer> getFixed32List() {
            return this.f6537n3;
        }

        public List<Long> getFixed64List() {
            return this.f6539zn;
        }

        public List<UnknownFieldSet2> getGroupList() {
            return this.f6538v;
        }

        public List<ByteString> getLengthDelimitedList() {
            return this.f6536gv;
        }

        public int getSerializedSize(int i) {
            int i5 = 0;
            for (Long l2 : this.y) {
                i5 += CodedOutputStream.computeUInt64Size(i, l2.longValue());
            }
            for (Integer num : this.f6537n3) {
                i5 += CodedOutputStream.computeFixed32Size(i, num.intValue());
            }
            for (Long l3 : this.f6539zn) {
                i5 += CodedOutputStream.computeFixed64Size(i, l3.longValue());
            }
            for (ByteString byteString : this.f6536gv) {
                i5 += CodedOutputStream.computeBytesSize(i, byteString);
            }
            for (UnknownFieldSet2 unknownFieldSet2 : this.f6538v) {
                i5 += CodedOutputStream.computeGroupSize(i, unknownFieldSet2);
            }
            return i5;
        }

        public int getSerializedSizeAsMessageSetExtension(int i) {
            int i5 = 0;
            for (ByteString byteString : this.f6536gv) {
                i5 += CodedOutputStream.computeRawMessageSetExtensionSize(i, byteString);
            }
            return i5;
        }

        public List<Long> getVarintList() {
            return this.y;
        }

        public int hashCode() {
            return Arrays.hashCode(t());
        }

        public final Object[] t() {
            return new Object[]{this.y, this.f6537n3, this.f6539zn, this.f6536gv, this.f6538v};
        }

        public final void tl(int i, Writer writer) throws IOException {
            if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
                List<ByteString> list = this.f6536gv;
                ListIterator<ByteString> listIterator = list.listIterator(list.size());
                while (listIterator.hasPrevious()) {
                    writer.writeMessageSetItem(i, listIterator.previous());
                }
                return;
            }
            for (ByteString byteString : this.f6536gv) {
                writer.writeMessageSetItem(i, byteString);
            }
        }

        public ByteString toByteString(int i) {
            try {
                ByteString.CodedBuilder r2 = ByteString.r(getSerializedSize(i));
                writeTo(i, r2.getCodedOutput());
                return r2.build();
            } catch (IOException e2) {
                throw new RuntimeException("Serializing to a ByteString should never fail with an IOException", e2);
            }
        }

        public void writeAsMessageSetExtensionTo(int i, CodedOutputStream codedOutputStream) throws IOException {
            for (ByteString byteString : this.f6536gv) {
                codedOutputStream.writeRawMessageSetExtension(i, byteString);
            }
        }

        public void writeTo(int i, CodedOutputStream codedOutputStream) throws IOException {
            for (Long l2 : this.y) {
                codedOutputStream.writeUInt64(i, l2.longValue());
            }
            for (Integer num : this.f6537n3) {
                codedOutputStream.writeFixed32(i, num.intValue());
            }
            for (Long l3 : this.f6539zn) {
                codedOutputStream.writeFixed64(i, l3.longValue());
            }
            for (ByteString byteString : this.f6536gv) {
                codedOutputStream.writeBytes(i, byteString);
            }
            for (UnknownFieldSet2 unknownFieldSet2 : this.f6538v) {
                codedOutputStream.writeGroup(i, unknownFieldSet2);
            }
        }

        public void wz(int i, Writer writer) throws IOException {
            writer.writeInt64List(i, this.y, false);
            writer.writeFixed32List(i, this.f6537n3, false);
            writer.writeFixed64List(i, this.f6539zn, false);
            writer.writeBytesList(i, this.f6536gv);
            if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
                for (int i5 = 0; i5 < this.f6538v.size(); i5++) {
                    writer.writeStartGroup(i);
                    this.f6538v.get(i5).writeTo(writer);
                    writer.writeEndGroup(i);
                }
                return;
            }
            for (int size = this.f6538v.size() - 1; size >= 0; size--) {
                writer.writeEndGroup(i);
                this.f6538v.get(size).writeTo(writer);
                writer.writeStartGroup(i);
            }
        }

        public Field() {
        }

        public static Builder newBuilder(Field field) {
            return newBuilder().mergeFrom(field);
        }
    }

    /* loaded from: classes.dex */
    public static final class Parser extends AbstractParser<UnknownFieldSet2> {
        @Override // com.google.protobuf.Parser
        public UnknownFieldSet2 parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder newBuilder = UnknownFieldSet2.newBuilder();
            try {
                newBuilder.mergeFrom(codedInputStream);
                return newBuilder.buildPartial();
            } catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(newBuilder.buildPartial());
            } catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(newBuilder.buildPartial());
            }
        }
    }

    private UnknownFieldSet2() {
    }

    public static UnknownFieldSet2 getDefaultInstance() {
        return defaultInstance;
    }

    public static Builder newBuilder() {
        return Builder.access$000();
    }

    public static UnknownFieldSet2 parseFrom(CodedInputStream codedInputStream) throws IOException {
        return newBuilder().mergeFrom(codedInputStream).build();
    }

    public Map<Integer, Field> asMap() {
        return this.fields;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof UnknownFieldSet2) && this.fields.equals(((UnknownFieldSet2) obj).fields)) {
            return true;
        }
        return false;
    }

    public Field getField(int i) {
        Field field = this.fields.get(Integer.valueOf(i));
        if (field == null) {
            return Field.getDefaultInstance();
        }
        return field;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        for (Map.Entry<Integer, Field> entry : this.fields.entrySet()) {
            i += entry.getValue().getSerializedSize(entry.getKey().intValue());
        }
        return i;
    }

    public int getSerializedSizeAsMessageSet() {
        int i = 0;
        for (Map.Entry<Integer, Field> entry : this.fields.entrySet()) {
            i += entry.getValue().getSerializedSizeAsMessageSetExtension(entry.getKey().intValue());
        }
        return i;
    }

    public boolean hasField(int i) {
        return this.fields.containsKey(Integer.valueOf(i));
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr);
            writeTo(newInstance);
            newInstance.checkNoSpaceLeft();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        try {
            ByteString.CodedBuilder r2 = ByteString.r(getSerializedSize());
            writeTo(r2.getCodedOutput());
            return r2.build();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        return "";
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry<Integer, Field> entry : this.fields.entrySet()) {
            entry.getValue().writeAsMessageSetExtensionTo(entry.getKey().intValue(), codedOutputStream);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream);
        newInstance.writeRawVarint32(getSerializedSize());
        writeTo(newInstance);
        newInstance.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry<Integer, Field> entry : this.fields.entrySet()) {
            entry.getValue().writeTo(entry.getKey().intValue(), codedOutputStream);
        }
    }

    public UnknownFieldSet2(Map<Integer, Field> map, Map<Integer, Field> map2) {
        this.fields = map;
        this.fieldsDescending = map2;
    }

    public static Builder newBuilder(UnknownFieldSet2 unknownFieldSet2) {
        return newBuilder().mergeFrom(unknownFieldSet2);
    }

    public static UnknownFieldSet2 parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(byteString).build();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public UnknownFieldSet2 getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // com.google.protobuf.MessageLite
    public final Parser getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder().mergeFrom(this);
    }

    public static UnknownFieldSet2 parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(bArr).build();
    }

    public void writeAsMessageSetTo(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (Map.Entry<Integer, Field> entry : this.fieldsDescending.entrySet()) {
                entry.getValue().tl(entry.getKey().intValue(), writer);
            }
            return;
        }
        for (Map.Entry<Integer, Field> entry2 : this.fields.entrySet()) {
            entry2.getValue().tl(entry2.getKey().intValue(), writer);
        }
    }

    public static UnknownFieldSet2 parseFrom(InputStream inputStream) throws IOException {
        return newBuilder().mergeFrom(inputStream).build();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream);
        writeTo(newInstance);
        newInstance.flush();
    }

    public void writeTo(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (Map.Entry<Integer, Field> entry : this.fieldsDescending.entrySet()) {
                entry.getValue().wz(entry.getKey().intValue(), writer);
            }
            return;
        }
        for (Map.Entry<Integer, Field> entry2 : this.fields.entrySet()) {
            entry2.getValue().wz(entry2.getKey().intValue(), writer);
        }
    }
}
