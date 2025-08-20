package com.google.protobuf;
/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public final class ManifestSchemaFactory implements SchemaFactory {

    /* renamed from: n3  reason: collision with root package name */
    public static final MessageInfoFactory f6472n3 = new MessageInfoFactory() { // from class: com.google.protobuf.ManifestSchemaFactory.1
        @Override // com.google.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> cls) {
            return false;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    };
    public final MessageInfoFactory y;

    /* renamed from: com.google.protobuf.ManifestSchemaFactory$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[ProtoSyntax.values().length];
            y = iArr;
            try {
                iArr[ProtoSyntax.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CompositeMessageInfoFactory implements MessageInfoFactory {
        public MessageInfoFactory[] y;

        public CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.y = messageInfoFactoryArr;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.y) {
                if (messageInfoFactory.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> cls) {
            MessageInfoFactory[] messageInfoFactoryArr;
            for (MessageInfoFactory messageInfoFactory : this.y) {
                if (messageInfoFactory.isSupported(cls)) {
                    return messageInfoFactory.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    public ManifestSchemaFactory() {
        this(n3());
    }

    public static <T> Schema<T> gv(Class<T> cls, MessageInfo messageInfo) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            if (y(messageInfo)) {
                return MessageSchema.a8(cls, messageInfo, NewInstanceSchemas.n3(), ListFieldSchema.n3(), SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.n3(), MapFieldSchemas.n3());
            }
            return MessageSchema.a8(cls, messageInfo, NewInstanceSchemas.n3(), ListFieldSchema.n3(), SchemaUtil.unknownFieldSetLiteSchema(), null, MapFieldSchemas.n3());
        } else if (y(messageInfo)) {
            return MessageSchema.a8(cls, messageInfo, NewInstanceSchemas.y(), ListFieldSchema.y(), SchemaUtil.unknownFieldSetFullSchema(), ExtensionSchemas.y(), MapFieldSchemas.y());
        } else {
            return MessageSchema.a8(cls, messageInfo, NewInstanceSchemas.y(), ListFieldSchema.y(), SchemaUtil.unknownFieldSetFullSchema(), null, MapFieldSchemas.y());
        }
    }

    public static MessageInfoFactory n3() {
        return new CompositeMessageInfoFactory(GeneratedMessageInfoFactory.getInstance(), zn());
    }

    public static boolean y(MessageInfo messageInfo) {
        if (AnonymousClass2.y[messageInfo.getSyntax().ordinal()] != 1) {
            return true;
        }
        return false;
    }

    public static MessageInfoFactory zn() {
        try {
            return (MessageInfoFactory) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f6472n3;
        }
    }

    @Override // com.google.protobuf.SchemaFactory
    public <T> Schema<T> createSchema(Class<T> cls) {
        SchemaUtil.requireGeneratedMessage(cls);
        MessageInfo messageInfoFor = this.y.messageInfoFor(cls);
        if (messageInfoFor.isMessageSetWireFormat()) {
            if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                return MessageSetSchema.zn(SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.n3(), messageInfoFor.getDefaultInstance());
            }
            return MessageSetSchema.zn(SchemaUtil.unknownFieldSetFullSchema(), ExtensionSchemas.y(), messageInfoFor.getDefaultInstance());
        }
        return gv(cls, messageInfoFor);
    }

    public ManifestSchemaFactory(MessageInfoFactory messageInfoFactory) {
        this.y = (MessageInfoFactory) Internal.n3(messageInfoFactory, "messageInfoFactory");
    }
}
