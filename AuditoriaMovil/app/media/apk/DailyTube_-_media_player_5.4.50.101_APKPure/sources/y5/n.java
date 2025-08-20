package y5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class n<T> extends d0<T> {

    /* renamed from: t  reason: collision with root package name */
    public w.n3<LiveData<?>, y<?>> f15289t = new w.n3<>();

    /* loaded from: classes.dex */
    public static class y<V> implements fh<V> {

        /* renamed from: n3  reason: collision with root package name */
        public final fh<? super V> f15290n3;
        public final LiveData<V> y;

        /* renamed from: zn  reason: collision with root package name */
        public int f15291zn = -1;

        public y(LiveData<V> liveData, fh<? super V> fhVar) {
            this.y = liveData;
            this.f15290n3 = fhVar;
        }

        public void n3() {
            this.y.tl(this);
        }

        @Override // y5.fh
        public void onChanged(@Nullable V v2) {
            if (this.f15291zn != this.y.a()) {
                this.f15291zn = this.y.a();
                this.f15290n3.onChanged(v2);
            }
        }

        public void y() {
            this.y.c5(this);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void f() {
        Iterator<Map.Entry<LiveData<?>, y<?>>> it = this.f15289t.iterator();
        while (it.hasNext()) {
            it.next().getValue().n3();
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void i9() {
        Iterator<Map.Entry<LiveData<?>, y<?>>> it = this.f15289t.iterator();
        while (it.hasNext()) {
            it.next().getValue().y();
        }
    }

    public <S> void p(@NonNull LiveData<S> liveData) {
        y<?> fb2 = this.f15289t.fb(liveData);
        if (fb2 != null) {
            fb2.n3();
        }
    }

    public <S> void w(@NonNull LiveData<S> liveData, @NonNull fh<? super S> fhVar) {
        y<?> yVar = new y<>(liveData, fhVar);
        y<?> a2 = this.f15289t.a(liveData, yVar);
        if (a2 != null && a2.f15290n3 != fhVar) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (a2 == null && fb()) {
            yVar.y();
        }
    }
}
