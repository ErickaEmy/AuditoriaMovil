package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    public static final ExtensionRegistryLite y = ExtensionRegistryLite.getEmptyRegistry();

    public final UninitializedMessageException n3(MessageType messagetype) {
        if (messagetype instanceof AbstractMessageLite) {
            return ((AbstractMessageLite) messagetype).newUninitializedMessageException();
        }
        return new UninitializedMessageException(messagetype);
    }

    public final MessageType y(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype != null && !messagetype.isInitialized()) {
            throw n3(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
        }
        return messagetype;
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return y(parsePartialDelimitedFrom(inputStream, extensionRegistryLite));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return parsePartialFrom((InputStream) new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)), extensionRegistryLite);
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2);
        }
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(inputStream, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(inputStream, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(codedInputStream, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream newCodedInput = byteString.newCodedInput();
        MessageType messagetype = (MessageType) parsePartialFrom(newCodedInput, extensionRegistryLite);
        try {
            newCodedInput.checkLastTagWas(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.setUnfinishedMessage(messagetype);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MessageType) y((MessageLite) parsePartialFrom(codedInputStream, extensionRegistryLite));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return parseFrom(codedInputStream, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return y(parsePartialFrom(byteString, extensionRegistryLite));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return parsePartialFrom(byteString, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return parseFrom(byteString, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] bArr, int i, int i5, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i, i5);
        MessageType messagetype = (MessageType) parsePartialFrom(newInstance, extensionRegistryLite);
        try {
            newInstance.checkLastTagWas(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.setUnfinishedMessage(messagetype);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream newInstance = CodedInputStream.newInstance(byteBuffer);
        MessageLite messageLite = (MessageLite) parsePartialFrom(newInstance, extensionRegistryLite);
        try {
            newInstance.checkLastTagWas(0);
            return (MessageType) y(messageLite);
        } catch (InvalidProtocolBufferException e2) {
            throw e2.setUnfinishedMessage(messageLite);
        }
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] bArr, int i, int i5) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, i, i5, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, 0, bArr.length, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return parseFrom(byteBuffer, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, 0, bArr.length, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] bArr, int i, int i5, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return y(parsePartialFrom(bArr, i, i5, extensionRegistryLite));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
        MessageType messagetype = (MessageType) parsePartialFrom(newInstance, extensionRegistryLite);
        try {
            newInstance.checkLastTagWas(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.setUnfinishedMessage(messagetype);
        }
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] bArr, int i, int i5) throws InvalidProtocolBufferException {
        return parseFrom(bArr, i, i5, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return parseFrom(bArr, 0, bArr.length, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return parseFrom(bArr, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return y(parsePartialFrom(inputStream, extensionRegistryLite));
    }

    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parsePartialFrom(inputStream, y);
    }

    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parseFrom(inputStream, y);
    }
}
