package y5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
/* loaded from: classes.dex */
public class z6 {

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* loaded from: classes.dex */
    public class n3<X> implements fh<X> {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ n f15312n3;
        public boolean y = true;

        public n3(n nVar) {
            this.f15312n3 = nVar;
        }

        @Override // y5.fh
        public void onChanged(X x2) {
            T v2 = this.f15312n3.v();
            if (this.y || ((v2 == 0 && x2 != null) || (v2 != 0 && !v2.equals(x2)))) {
                this.y = false;
                this.f15312n3.xc(x2);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* loaded from: classes.dex */
    public class y<X> implements fh<X> {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ p.y f15313n3;
        public final /* synthetic */ n y;

        public y(n nVar, p.y yVar) {
            this.y = nVar;
            this.f15313n3 = yVar;
        }

        @Override // y5.fh
        public void onChanged(@Nullable X x2) {
            this.y.xc(this.f15313n3.apply(x2));
        }
    }

    @NonNull
    public static <X, Y> LiveData<Y> n3(@NonNull LiveData<X> liveData, @NonNull p.y<X, Y> yVar) {
        n nVar = new n();
        nVar.w(liveData, new y(nVar, yVar));
        return nVar;
    }

    @NonNull
    public static <X> LiveData<X> y(@NonNull LiveData<X> liveData) {
        n nVar = new n();
        nVar.w(liveData, new n3(nVar));
        return nVar;
    }
}
