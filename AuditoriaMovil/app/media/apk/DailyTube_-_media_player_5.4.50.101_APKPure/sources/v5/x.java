package v5;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import v5.p;
/* loaded from: classes.dex */
public final class x implements p {

    /* renamed from: n3  reason: collision with root package name */
    public static final List<n3> f14403n3 = new ArrayList(50);
    public final Handler y;

    /* loaded from: classes.dex */
    public static final class n3 implements p.y {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public x f14404n3;
        @Nullable
        public Message y;

        public n3() {
        }

        public n3 gv(Message message, x xVar) {
            this.y = message;
            this.f14404n3 = xVar;
            return this;
        }

        public final void n3() {
            this.y = null;
            this.f14404n3 = null;
            x.xc(this);
        }

        @Override // v5.p.y
        public void y() {
            ((Message) v5.y.v(this.y)).sendToTarget();
            n3();
        }

        public boolean zn(Handler handler) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) v5.y.v(this.y));
            n3();
            return sendMessageAtFrontOfQueue;
        }
    }

    public x(Handler handler) {
        this.y = handler;
    }

    public static n3 wz() {
        n3 remove;
        List<n3> list = f14403n3;
        synchronized (list) {
            try {
                if (list.isEmpty()) {
                    remove = new n3();
                } else {
                    remove = list.remove(list.size() - 1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return remove;
    }

    public static void xc(n3 n3Var) {
        List<n3> list = f14403n3;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(n3Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // v5.p
    public Looper a() {
        return this.y.getLooper();
    }

    @Override // v5.p
    public boolean c5(Runnable runnable) {
        return this.y.post(runnable);
    }

    @Override // v5.p
    public boolean f(int i, long j2) {
        return this.y.sendEmptyMessageAtTime(i, j2);
    }

    @Override // v5.p
    public p.y fb(int i, int i5, int i6) {
        return wz().gv(this.y.obtainMessage(i, i5, i6), this);
    }

    @Override // v5.p
    public p.y gv(int i, @Nullable Object obj) {
        return wz().gv(this.y.obtainMessage(i, obj), this);
    }

    @Override // v5.p
    public boolean i9(int i) {
        return this.y.sendEmptyMessage(i);
    }

    @Override // v5.p
    public boolean n3(int i) {
        return this.y.hasMessages(i);
    }

    @Override // v5.p
    public boolean s(p.y yVar) {
        return ((n3) yVar).zn(this.y);
    }

    @Override // v5.p
    public void t(int i) {
        this.y.removeMessages(i);
    }

    @Override // v5.p
    public void v(@Nullable Object obj) {
        this.y.removeCallbacksAndMessages(obj);
    }

    @Override // v5.p
    public p.y y(int i) {
        return wz().gv(this.y.obtainMessage(i), this);
    }

    @Override // v5.p
    public p.y zn(int i, int i5, int i6, @Nullable Object obj) {
        return wz().gv(this.y.obtainMessage(i, i5, i6, obj), this);
    }
}
