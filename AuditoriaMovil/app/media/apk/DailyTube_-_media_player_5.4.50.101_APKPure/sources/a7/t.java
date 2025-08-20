package a7;

import a7.f;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public abstract class t<VH extends f> implements v {

    /* renamed from: s  reason: collision with root package name */
    public static AtomicLong f31s = new AtomicLong(0);

    /* renamed from: fb  reason: collision with root package name */
    public Map<String, Object> f32fb;

    /* renamed from: v  reason: collision with root package name */
    public final long f33v;
    public fb y;

    public t() {
        this(f31s.decrementAndGet());
    }

    public abstract void b(@NonNull VH vh, int i);

    @Override // a7.v
    public void co(@NonNull fb fbVar) {
        this.y = null;
    }

    public void dm(@Nullable Object obj) {
        fb fbVar = this.y;
        if (fbVar != null) {
            fbVar.xc(this, 0, obj);
        }
    }

    @Override // a7.v
    public int ej(@NonNull t tVar) {
        if (this == tVar) {
            return 0;
        }
        return -1;
    }

    public boolean en() {
        return true;
    }

    @Override // a7.v
    @NonNull
    public t getItem(int i) {
        if (i == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("Wanted item at position " + i + " but an Item is a Group of size 1");
    }

    public abstract int j();

    @Nullable
    public Object j5(@NonNull t tVar) {
        return null;
    }

    public boolean k(@NonNull t tVar) {
        return equals(tVar);
    }

    public void k5(@NonNull VH vh, int i, @NonNull List<Object> list) {
        b(vh, i);
    }

    @Override // a7.v
    public void n3(@NonNull fb fbVar) {
        this.y = fbVar;
    }

    public long o() {
        return this.f33v;
    }

    public int q9() {
        return j();
    }

    @Override // a7.v
    public int r() {
        return 1;
    }

    public void rs(@NonNull VH vh) {
        vh.a();
    }

    public boolean u() {
        return true;
    }

    @NonNull
    public VH vl(@NonNull View view) {
        return (VH) new f(view);
    }

    public void x4() {
        fb fbVar = this.y;
        if (fbVar != null) {
            fbVar.a(this, 0);
        }
    }

    public boolean xg(@NonNull t tVar) {
        if (q9() != tVar.q9() || o() != tVar.o()) {
            return false;
        }
        return true;
    }

    public boolean y5() {
        return true;
    }

    public void yt(@NonNull VH vh, int i, @NonNull List<Object> list, @Nullable wz wzVar, @Nullable xc xcVar) {
        vh.zn(this, wzVar, xcVar);
        k5(vh, i, list);
    }

    public t(long j2) {
        this.f32fb = new HashMap();
        this.f33v = j2;
    }

    public void ct(@NonNull VH vh) {
    }

    public void o4(@NonNull VH vh) {
    }

    public int oz(int i, int i5) {
        return i;
    }
}
