package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@CheckReturnValue
/* loaded from: classes.dex */
final class StructuralMessageInfo implements MessageInfo {

    /* renamed from: gv  reason: collision with root package name */
    public final FieldInfo[] f6526gv;

    /* renamed from: n3  reason: collision with root package name */
    public final boolean f6527n3;

    /* renamed from: v  reason: collision with root package name */
    public final MessageLite f6528v;
    public final ProtoSyntax y;

    /* renamed from: zn  reason: collision with root package name */
    public final int[] f6529zn;

    public StructuralMessageInfo(ProtoSyntax protoSyntax, boolean z2, int[] iArr, FieldInfo[] fieldInfoArr, Object obj) {
        this.y = protoSyntax;
        this.f6527n3 = z2;
        this.f6529zn = iArr;
        this.f6526gv = fieldInfoArr;
        this.f6528v = (MessageLite) Internal.n3(obj, "defaultInstance");
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int[] getCheckInitialized() {
        return this.f6529zn;
    }

    @Override // com.google.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.f6528v;
    }

    public FieldInfo[] getFields() {
        return this.f6526gv;
    }

    @Override // com.google.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        return this.y;
    }

    @Override // com.google.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        return this.f6527n3;
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Object f6530a;

        /* renamed from: gv  reason: collision with root package name */
        public boolean f6531gv;

        /* renamed from: n3  reason: collision with root package name */
        public ProtoSyntax f6532n3;

        /* renamed from: v  reason: collision with root package name */
        public int[] f6533v;
        public final List<FieldInfo> y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f6534zn;

        public Builder() {
            this.y = new ArrayList();
        }

        public StructuralMessageInfo build() {
            if (!this.f6534zn) {
                if (this.f6532n3 != null) {
                    this.f6534zn = true;
                    Collections.sort(this.y);
                    return new StructuralMessageInfo(this.f6532n3, this.f6531gv, this.f6533v, (FieldInfo[]) this.y.toArray(new FieldInfo[0]), this.f6530a);
                }
                throw new IllegalStateException("Must specify a proto syntax");
            }
            throw new IllegalStateException("Builder can only build once");
        }

        public void withCheckInitialized(int[] iArr) {
            this.f6533v = iArr;
        }

        public void withDefaultInstance(Object obj) {
            this.f6530a = obj;
        }

        public void withField(FieldInfo fieldInfo) {
            if (!this.f6534zn) {
                this.y.add(fieldInfo);
                return;
            }
            throw new IllegalStateException("Builder can only build once");
        }

        public void withMessageSetWireFormat(boolean z2) {
            this.f6531gv = z2;
        }

        public void withSyntax(ProtoSyntax protoSyntax) {
            this.f6532n3 = (ProtoSyntax) Internal.n3(protoSyntax, "syntax");
        }

        public Builder(int i) {
            this.y = new ArrayList(i);
        }
    }

    public static Builder newBuilder(int i) {
        return new Builder(i);
    }
}
