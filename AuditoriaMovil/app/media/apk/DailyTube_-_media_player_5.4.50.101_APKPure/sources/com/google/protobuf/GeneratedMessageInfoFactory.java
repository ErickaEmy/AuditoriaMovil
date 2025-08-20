package com.google.protobuf;
/* loaded from: classes.dex */
class GeneratedMessageInfoFactory implements MessageInfoFactory {
    public static final GeneratedMessageInfoFactory y = new GeneratedMessageInfoFactory();

    public static GeneratedMessageInfoFactory getInstance() {
        return y;
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public boolean isSupported(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public MessageInfo messageInfoFor(Class<?> cls) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            try {
                return (MessageInfo) GeneratedMessageLite.getDefaultInstance(cls.asSubclass(GeneratedMessageLite.class)).buildMessageInfo();
            } catch (Exception e2) {
                throw new RuntimeException("Unable to get message info for " + cls.getName(), e2);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
    }
}
