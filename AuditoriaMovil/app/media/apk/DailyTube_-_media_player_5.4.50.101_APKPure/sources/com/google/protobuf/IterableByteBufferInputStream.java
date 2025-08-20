package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class IterableByteBufferInputStream extends InputStream {

    /* renamed from: co  reason: collision with root package name */
    public long f6452co;

    /* renamed from: f  reason: collision with root package name */
    public int f6453f;

    /* renamed from: fb  reason: collision with root package name */
    public int f6454fb = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f6455p;

    /* renamed from: s  reason: collision with root package name */
    public int f6456s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f6457t;

    /* renamed from: v  reason: collision with root package name */
    public ByteBuffer f6458v;

    /* renamed from: w  reason: collision with root package name */
    public byte[] f6459w;
    public Iterator<ByteBuffer> y;

    public IterableByteBufferInputStream(Iterable<ByteBuffer> iterable) {
        this.y = iterable.iterator();
        for (ByteBuffer byteBuffer : iterable) {
            this.f6454fb++;
        }
        this.f6456s = -1;
        if (!y()) {
            this.f6458v = Internal.EMPTY_BYTE_BUFFER;
            this.f6456s = 0;
            this.f6453f = 0;
            this.f6452co = 0L;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f6456s == this.f6454fb) {
            return -1;
        }
        if (this.f6457t) {
            int i = this.f6459w[this.f6453f + this.f6455p] & 255;
            v(1);
            return i;
        }
        int f32 = UnsafeUtil.f3(this.f6453f + this.f6452co) & 255;
        v(1);
        return f32;
    }

    public final void v(int i) {
        int i5 = this.f6453f + i;
        this.f6453f = i5;
        if (i5 == this.f6458v.limit()) {
            y();
        }
    }

    public final boolean y() {
        this.f6456s++;
        if (!this.y.hasNext()) {
            return false;
        }
        ByteBuffer next = this.y.next();
        this.f6458v = next;
        this.f6453f = next.position();
        if (this.f6458v.hasArray()) {
            this.f6457t = true;
            this.f6459w = this.f6458v.array();
            this.f6455p = this.f6458v.arrayOffset();
        } else {
            this.f6457t = false;
            this.f6452co = UnsafeUtil.f(this.f6458v);
            this.f6459w = null;
        }
        return true;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i5) throws IOException {
        if (this.f6456s == this.f6454fb) {
            return -1;
        }
        int limit = this.f6458v.limit();
        int i6 = this.f6453f;
        int i8 = limit - i6;
        if (i5 > i8) {
            i5 = i8;
        }
        if (this.f6457t) {
            System.arraycopy(this.f6459w, i6 + this.f6455p, bArr, i, i5);
            v(i5);
        } else {
            int position = this.f6458v.position();
            Java8Compatibility.gv(this.f6458v, this.f6453f);
            this.f6458v.get(bArr, i, i5);
            Java8Compatibility.gv(this.f6458v, position);
            v(i5);
        }
        return i5;
    }
}
