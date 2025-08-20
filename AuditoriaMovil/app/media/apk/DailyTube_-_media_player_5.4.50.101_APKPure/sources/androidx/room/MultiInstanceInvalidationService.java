package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import rb.t;
import rb.tl;
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {
    public int y;

    /* renamed from: v  reason: collision with root package name */
    public final Map<Integer, String> f3375v = new LinkedHashMap();

    /* renamed from: fb  reason: collision with root package name */
    public final RemoteCallbackList<t> f3373fb = new n3();

    /* renamed from: s  reason: collision with root package name */
    public final tl.y f3374s = new y();

    /* loaded from: classes.dex */
    public static final class n3 extends RemoteCallbackList<t> {
        public n3() {
        }

        @Override // android.os.RemoteCallbackList
        /* renamed from: y */
        public void onCallbackDied(t callback, Object cookie) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            MultiInstanceInvalidationService.this.n3().remove((Integer) cookie);
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends tl.y {
        public y() {
        }

        @Override // rb.tl
        public int a(t callback, String str) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            int i = 0;
            if (str == null) {
                return 0;
            }
            RemoteCallbackList<t> y = MultiInstanceInvalidationService.this.y();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (y) {
                try {
                    multiInstanceInvalidationService.gv(multiInstanceInvalidationService.zn() + 1);
                    int zn2 = multiInstanceInvalidationService.zn();
                    if (multiInstanceInvalidationService.y().register(callback, Integer.valueOf(zn2))) {
                        multiInstanceInvalidationService.n3().put(Integer.valueOf(zn2), str);
                        i = zn2;
                    } else {
                        multiInstanceInvalidationService.gv(multiInstanceInvalidationService.zn() - 1);
                        multiInstanceInvalidationService.zn();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i;
        }

        @Override // rb.tl
        public void eb(int i, String[] tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            RemoteCallbackList<t> y = MultiInstanceInvalidationService.this.y();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (y) {
                String str = multiInstanceInvalidationService.n3().get(Integer.valueOf(i));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = multiInstanceInvalidationService.y().beginBroadcast();
                for (int i5 = 0; i5 < beginBroadcast; i5++) {
                    Object broadcastCookie = multiInstanceInvalidationService.y().getBroadcastCookie(i5);
                    Intrinsics.checkNotNull(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                    Integer num = (Integer) broadcastCookie;
                    int intValue = num.intValue();
                    String str2 = multiInstanceInvalidationService.n3().get(num);
                    if (i != intValue && Intrinsics.areEqual(str, str2)) {
                        try {
                            multiInstanceInvalidationService.y().getBroadcastItem(i5).co(tables);
                        } catch (RemoteException e2) {
                            Log.w("ROOM", "Error invoking a remote callback", e2);
                        }
                    }
                }
                multiInstanceInvalidationService.y().finishBroadcast();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // rb.tl
        public void o(t callback, int i) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            RemoteCallbackList<t> y = MultiInstanceInvalidationService.this.y();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (y) {
                multiInstanceInvalidationService.y().unregister(callback);
                multiInstanceInvalidationService.n3().remove(Integer.valueOf(i));
            }
        }
    }

    public final void gv(int i) {
        this.y = i;
    }

    public final Map<Integer, String> n3() {
        return this.f3375v;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.f3374s;
    }

    public final RemoteCallbackList<t> y() {
        return this.f3373fb;
    }

    public final int zn() {
        return this.y;
    }
}
