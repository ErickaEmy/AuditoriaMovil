package k5;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;
import k5.a;
import k5.fb;
/* loaded from: classes.dex */
public class y {
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final Handler f9596n3;
    @NonNull
    public final fb.zn y;

    /* loaded from: classes.dex */
    public class n3 implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ int f9598v;
        public final /* synthetic */ fb.zn y;

        public n3(fb.zn znVar, int i) {
            this.y = znVar;
            this.f9598v = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.y.y(this.f9598v);
        }
    }

    /* renamed from: k5.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0131y implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Typeface f9600v;
        public final /* synthetic */ fb.zn y;

        public RunnableC0131y(fb.zn znVar, Typeface typeface) {
            this.y = znVar;
            this.f9600v = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.y.n3(this.f9600v);
        }
    }

    public y(@NonNull fb.zn znVar, @NonNull Handler handler) {
        this.y = znVar;
        this.f9596n3 = handler;
    }

    public void n3(@NonNull a.v vVar) {
        if (vVar.y()) {
            zn(vVar.y);
        } else {
            y(vVar.f9574n3);
        }
    }

    public final void y(int i) {
        this.f9596n3.post(new n3(this.y, i));
    }

    public final void zn(@NonNull Typeface typeface) {
        this.f9596n3.post(new RunnableC0131y(this.y, typeface));
    }
}
