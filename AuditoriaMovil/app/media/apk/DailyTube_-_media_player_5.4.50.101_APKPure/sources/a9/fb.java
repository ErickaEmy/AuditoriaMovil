package a9;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import m1.kp;
/* loaded from: classes.dex */
public class fb extends a9.y {

    /* renamed from: f  reason: collision with root package name */
    public long f55f;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public ByteBuffer f56fb;

    /* renamed from: p  reason: collision with root package name */
    public final int f57p;

    /* renamed from: s  reason: collision with root package name */
    public boolean f58s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public ByteBuffer f59t;

    /* renamed from: v  reason: collision with root package name */
    public final zn f60v;

    /* renamed from: w  reason: collision with root package name */
    public final int f61w;

    /* loaded from: classes.dex */
    public static final class y extends IllegalStateException {
        public final int currentCapacity;
        public final int requiredCapacity;

        public y(int i, int i5) {
            super("Buffer too small (" + i + " < " + i5 + ")");
            this.currentCapacity = i;
            this.requiredCapacity = i5;
        }
    }

    static {
        kp.y("goog.exo.decoder");
    }

    public fb(int i) {
        this(i, 0);
    }

    public static fb r() {
        return new fb(0);
    }

    @Override // a9.y
    public void a() {
        super.a();
        ByteBuffer byteBuffer = this.f56fb;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f59t;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f58s = false;
    }

    public final void co() {
        ByteBuffer byteBuffer = this.f56fb;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f59t;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public void mt(int i) {
        int i5 = i + this.f57p;
        ByteBuffer byteBuffer = this.f56fb;
        if (byteBuffer == null) {
            this.f56fb = p(i5);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i6 = i5 + position;
        if (capacity >= i6) {
            this.f56fb = byteBuffer;
            return;
        }
        ByteBuffer p2 = p(i6);
        p2.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            p2.put(byteBuffer);
        }
        this.f56fb = p2;
    }

    public final ByteBuffer p(int i) {
        int capacity;
        int i5 = this.f61w;
        if (i5 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i5 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.f56fb;
        if (byteBuffer == null) {
            capacity = 0;
        } else {
            capacity = byteBuffer.capacity();
        }
        throw new y(capacity, i);
    }

    public void x4(int i) {
        ByteBuffer byteBuffer = this.f59t;
        if (byteBuffer != null && byteBuffer.capacity() >= i) {
            this.f59t.clear();
        } else {
            this.f59t = ByteBuffer.allocate(i);
        }
    }

    public final boolean z() {
        return s(1073741824);
    }

    public fb(int i, int i5) {
        this.f60v = new zn();
        this.f61w = i;
        this.f57p = i5;
    }
}
