package com.google.protobuf;

import java.io.IOException;
/* loaded from: classes.dex */
public class LazyFieldLite {

    /* renamed from: v  reason: collision with root package name */
    public static final ExtensionRegistryLite f6461v = ExtensionRegistryLite.getEmptyRegistry();

    /* renamed from: gv  reason: collision with root package name */
    public volatile ByteString f6462gv;

    /* renamed from: n3  reason: collision with root package name */
    public ExtensionRegistryLite f6463n3;
    public ByteString y;

    /* renamed from: zn  reason: collision with root package name */
    public volatile MessageLite f6464zn;

    public LazyFieldLite(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        y(extensionRegistryLite, byteString);
        this.f6463n3 = extensionRegistryLite;
        this.y = byteString;
    }

    public static LazyFieldLite fromValue(MessageLite messageLite) {
        LazyFieldLite lazyFieldLite = new LazyFieldLite();
        lazyFieldLite.setValue(messageLite);
        return lazyFieldLite;
    }

    public static void y(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        if (extensionRegistryLite != null) {
            if (byteString != null) {
                return;
            }
            throw new NullPointerException("found null ByteString");
        }
        throw new NullPointerException("found null ExtensionRegistry");
    }

    public static MessageLite zn(MessageLite messageLite, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return messageLite.toBuilder().mergeFrom(byteString, extensionRegistryLite).build();
        } catch (InvalidProtocolBufferException unused) {
            return messageLite;
        }
    }

    public void clear() {
        this.y = null;
        this.f6464zn = null;
        this.f6462gv = null;
    }

    public boolean containsDefaultInstance() {
        ByteString byteString;
        ByteString byteString2 = this.f6462gv;
        ByteString byteString3 = ByteString.EMPTY;
        if (byteString2 != byteString3 && (this.f6464zn != null || ((byteString = this.y) != null && byteString != byteString3))) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.f6464zn;
        MessageLite messageLite2 = lazyFieldLite.f6464zn;
        if (messageLite == null && messageLite2 == null) {
            return toByteString().equals(lazyFieldLite.toByteString());
        }
        if (messageLite != null && messageLite2 != null) {
            return messageLite.equals(messageLite2);
        }
        if (messageLite != null) {
            return messageLite.equals(lazyFieldLite.getValue(messageLite.getDefaultInstanceForType()));
        }
        return getValue(messageLite2.getDefaultInstanceForType()).equals(messageLite2);
    }

    public int getSerializedSize() {
        if (this.f6462gv != null) {
            return this.f6462gv.size();
        }
        ByteString byteString = this.y;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f6464zn != null) {
            return this.f6464zn.getSerializedSize();
        }
        return 0;
    }

    public MessageLite getValue(MessageLite messageLite) {
        n3(messageLite);
        return this.f6464zn;
    }

    public void gv(Writer writer, int i) throws IOException {
        if (this.f6462gv != null) {
            writer.writeBytes(i, this.f6462gv);
            return;
        }
        ByteString byteString = this.y;
        if (byteString != null) {
            writer.writeBytes(i, byteString);
        } else if (this.f6464zn != null) {
            writer.writeMessage(i, this.f6464zn);
        } else {
            writer.writeBytes(i, ByteString.EMPTY);
        }
    }

    public int hashCode() {
        return 1;
    }

    public void merge(LazyFieldLite lazyFieldLite) {
        ByteString byteString;
        if (lazyFieldLite.containsDefaultInstance()) {
            return;
        }
        if (containsDefaultInstance()) {
            set(lazyFieldLite);
            return;
        }
        if (this.f6463n3 == null) {
            this.f6463n3 = lazyFieldLite.f6463n3;
        }
        ByteString byteString2 = this.y;
        if (byteString2 != null && (byteString = lazyFieldLite.y) != null) {
            this.y = byteString2.concat(byteString);
        } else if (this.f6464zn == null && lazyFieldLite.f6464zn != null) {
            setValue(zn(lazyFieldLite.f6464zn, this.y, this.f6463n3));
        } else if (this.f6464zn != null && lazyFieldLite.f6464zn == null) {
            setValue(zn(this.f6464zn, lazyFieldLite.y, lazyFieldLite.f6463n3));
        } else {
            setValue(this.f6464zn.toBuilder().mergeFrom(lazyFieldLite.f6464zn).build());
        }
    }

    public void mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (containsDefaultInstance()) {
            setByteString(codedInputStream.readBytes(), extensionRegistryLite);
            return;
        }
        if (this.f6463n3 == null) {
            this.f6463n3 = extensionRegistryLite;
        }
        ByteString byteString = this.y;
        if (byteString != null) {
            setByteString(byteString.concat(codedInputStream.readBytes()), this.f6463n3);
            return;
        }
        try {
            setValue(this.f6464zn.toBuilder().mergeFrom(codedInputStream, extensionRegistryLite).build());
        } catch (InvalidProtocolBufferException unused) {
        }
    }

    public void n3(MessageLite messageLite) {
        if (this.f6464zn != null) {
            return;
        }
        synchronized (this) {
            if (this.f6464zn != null) {
                return;
            }
            try {
                if (this.y != null) {
                    this.f6464zn = messageLite.getParserForType().parseFrom(this.y, this.f6463n3);
                    this.f6462gv = this.y;
                } else {
                    this.f6464zn = messageLite;
                    this.f6462gv = ByteString.EMPTY;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f6464zn = messageLite;
                this.f6462gv = ByteString.EMPTY;
            }
        }
    }

    public void set(LazyFieldLite lazyFieldLite) {
        this.y = lazyFieldLite.y;
        this.f6464zn = lazyFieldLite.f6464zn;
        this.f6462gv = lazyFieldLite.f6462gv;
        ExtensionRegistryLite extensionRegistryLite = lazyFieldLite.f6463n3;
        if (extensionRegistryLite != null) {
            this.f6463n3 = extensionRegistryLite;
        }
    }

    public void setByteString(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        y(extensionRegistryLite, byteString);
        this.y = byteString;
        this.f6463n3 = extensionRegistryLite;
        this.f6464zn = null;
        this.f6462gv = null;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.f6464zn;
        this.y = null;
        this.f6462gv = null;
        this.f6464zn = messageLite;
        return messageLite2;
    }

    public ByteString toByteString() {
        if (this.f6462gv != null) {
            return this.f6462gv;
        }
        ByteString byteString = this.y;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            try {
                if (this.f6462gv != null) {
                    return this.f6462gv;
                }
                if (this.f6464zn == null) {
                    this.f6462gv = ByteString.EMPTY;
                } else {
                    this.f6462gv = this.f6464zn.toByteString();
                }
                return this.f6462gv;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public LazyFieldLite() {
    }
}
