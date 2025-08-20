package v5;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
/* loaded from: classes.dex */
public final class ta {
    public final Object y = new Object();

    /* renamed from: n3  reason: collision with root package name */
    public final PriorityQueue<Integer> f14394n3 = new PriorityQueue<>(10, Collections.reverseOrder());

    /* renamed from: zn  reason: collision with root package name */
    public int f14395zn = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public static class y extends IOException {
        public y(int i, int i5) {
            super("Priority too low [priority=" + i + ", highest=" + i5 + "]");
        }
    }

    public void n3(int i) throws y {
        synchronized (this.y) {
            try {
                if (this.f14395zn != i) {
                    throw new y(i, this.f14395zn);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void y(int i) {
        synchronized (this.y) {
            this.f14394n3.add(Integer.valueOf(i));
            this.f14395zn = Math.max(this.f14395zn, i);
        }
    }

    public void zn(int i) {
        int intValue;
        synchronized (this.y) {
            this.f14394n3.remove(Integer.valueOf(i));
            if (this.f14394n3.isEmpty()) {
                intValue = Integer.MIN_VALUE;
            } else {
                intValue = ((Integer) j5.i9(this.f14394n3.peek())).intValue();
            }
            this.f14395zn = intValue;
            this.y.notifyAll();
        }
    }
}
