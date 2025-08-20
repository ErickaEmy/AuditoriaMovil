package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.v;
import y5.co;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements a {

    /* renamed from: v  reason: collision with root package name */
    public final a f2579v;
    public final y5.t y;

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[v.n3.values().length];
            y = iArr;
            try {
                iArr[v.n3.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[v.n3.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[v.n3.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[v.n3.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[v.n3.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                y[v.n3.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                y[v.n3.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public FullLifecycleObserverAdapter(y5.t tVar, a aVar) {
        this.y = tVar;
        this.f2579v = aVar;
    }

    @Override // androidx.lifecycle.a
    public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
        switch (y.y[n3Var.ordinal()]) {
            case 1:
                this.y.hw(coVar);
                break;
            case 2:
                this.y.eb(coVar);
                break;
            case 3:
                this.y.i(coVar);
                break;
            case 4:
                this.y.le(coVar);
                break;
            case 5:
                this.y.ia(coVar);
                break;
            case 6:
                this.y.t6(coVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        a aVar = this.f2579v;
        if (aVar != null) {
            aVar.onStateChanged(coVar, n3Var);
        }
    }
}
