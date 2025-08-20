package com.google.protobuf;
@CheckReturnValue
/* loaded from: classes.dex */
final class RawMessageInfo implements MessageInfo {

    /* renamed from: gv  reason: collision with root package name */
    public final int f6505gv;

    /* renamed from: n3  reason: collision with root package name */
    public final String f6506n3;
    public final MessageLite y;

    /* renamed from: zn  reason: collision with root package name */
    public final Object[] f6507zn;

    public RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.y = messageLite;
        this.f6506n3 = str;
        this.f6507zn = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f6505gv = charAt;
            return;
        }
        int i = charAt & 8191;
        int i5 = 13;
        int i6 = 1;
        while (true) {
            int i8 = i6 + 1;
            char charAt2 = str.charAt(i6);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i5;
                i5 += 13;
                i6 = i8;
            } else {
                this.f6505gv = i | (charAt2 << i5);
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.y;
    }

    @Override // com.google.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        if ((this.f6505gv & 1) != 0) {
            return ProtoSyntax.PROTO2;
        }
        return ProtoSyntax.PROTO3;
    }

    @Override // com.google.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        if ((this.f6505gv & 2) == 2) {
            return true;
        }
        return false;
    }

    public String n3() {
        return this.f6506n3;
    }

    public Object[] y() {
        return this.f6507zn;
    }
}
