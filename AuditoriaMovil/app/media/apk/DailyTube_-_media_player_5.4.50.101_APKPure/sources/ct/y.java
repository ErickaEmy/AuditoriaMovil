package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f6896a = new Object();

    /* renamed from: fb  reason: collision with root package name */
    public static y f6897fb;

    /* renamed from: v  reason: collision with root package name */
    public final Handler f6900v;
    public final Context y;

    /* renamed from: n3  reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<zn>> f6899n3 = new HashMap<>();

    /* renamed from: zn  reason: collision with root package name */
    public final HashMap<String, ArrayList<zn>> f6901zn = new HashMap<>();

    /* renamed from: gv  reason: collision with root package name */
    public final ArrayList<n3> f6898gv = new ArrayList<>();

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final ArrayList<zn> f6902n3;
        public final Intent y;

        public n3(Intent intent, ArrayList<zn> arrayList) {
            this.y = intent;
            this.f6902n3 = arrayList;
        }
    }

    /* renamed from: ct.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0076y extends Handler {
        public HandlerC0076y(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                y.this.y();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f6903gv;

        /* renamed from: n3  reason: collision with root package name */
        public final BroadcastReceiver f6904n3;
        public final IntentFilter y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f6905zn;

        public zn(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.y = intentFilter;
            this.f6904n3 = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            sb.append("Receiver{");
            sb.append(this.f6904n3);
            sb.append(" filter=");
            sb.append(this.y);
            if (this.f6903gv) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public y(Context context) {
        this.y = context;
        this.f6900v = new HandlerC0076y(context.getMainLooper());
    }

    @NonNull
    public static y n3(@NonNull Context context) {
        y yVar;
        synchronized (f6896a) {
            try {
                if (f6897fb == null) {
                    f6897fb = new y(context.getApplicationContext());
                }
                yVar = f6897fb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return yVar;
    }

    public boolean gv(@NonNull Intent intent) {
        boolean z2;
        String str;
        String str2;
        int i;
        ArrayList arrayList;
        Uri uri;
        synchronized (this.f6899n3) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.y.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                intent.getFlags();
                ArrayList<zn> arrayList2 = this.f6901zn.get(intent.getAction());
                if (arrayList2 != null) {
                    ArrayList arrayList3 = null;
                    int i5 = 0;
                    while (i5 < arrayList2.size()) {
                        zn znVar = arrayList2.get(i5);
                        if (znVar.f6905zn) {
                            i = i5;
                            str = action;
                            str2 = resolveTypeIfNeeded;
                            uri = data;
                            arrayList = arrayList3;
                        } else {
                            str = action;
                            str2 = resolveTypeIfNeeded;
                            i = i5;
                            arrayList = arrayList3;
                            uri = data;
                            if (znVar.y.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager") >= 0) {
                                if (arrayList == null) {
                                    arrayList3 = new ArrayList();
                                } else {
                                    arrayList3 = arrayList;
                                }
                                arrayList3.add(znVar);
                                znVar.f6905zn = true;
                                i5 = i + 1;
                                action = str;
                                resolveTypeIfNeeded = str2;
                                data = uri;
                            }
                        }
                        arrayList3 = arrayList;
                        i5 = i + 1;
                        action = str;
                        resolveTypeIfNeeded = str2;
                        data = uri;
                    }
                    ArrayList arrayList4 = arrayList3;
                    z2 = false;
                    if (arrayList4 != null) {
                        for (int i6 = 0; i6 < arrayList4.size(); i6++) {
                            ((zn) arrayList4.get(i6)).f6905zn = false;
                        }
                        this.f6898gv.add(new n3(intent, arrayList4));
                        if (!this.f6900v.hasMessages(1)) {
                            this.f6900v.sendEmptyMessage(1);
                        }
                        return true;
                    }
                } else {
                    z2 = false;
                }
                return z2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void v(@NonNull BroadcastReceiver broadcastReceiver) {
        synchronized (this.f6899n3) {
            try {
                ArrayList<zn> remove = this.f6899n3.remove(broadcastReceiver);
                if (remove == null) {
                    return;
                }
                for (int size = remove.size() - 1; size >= 0; size--) {
                    zn znVar = remove.get(size);
                    znVar.f6903gv = true;
                    for (int i = 0; i < znVar.y.countActions(); i++) {
                        String action = znVar.y.getAction(i);
                        ArrayList<zn> arrayList = this.f6901zn.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                zn znVar2 = arrayList.get(size2);
                                if (znVar2.f6904n3 == broadcastReceiver) {
                                    znVar2.f6903gv = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f6901zn.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void y() {
        int size;
        n3[] n3VarArr;
        while (true) {
            synchronized (this.f6899n3) {
                try {
                    size = this.f6898gv.size();
                    if (size <= 0) {
                        return;
                    }
                    n3VarArr = new n3[size];
                    this.f6898gv.toArray(n3VarArr);
                    this.f6898gv.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i = 0; i < size; i++) {
                n3 n3Var = n3VarArr[i];
                int size2 = n3Var.f6902n3.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    zn znVar = n3Var.f6902n3.get(i5);
                    if (!znVar.f6903gv) {
                        znVar.f6904n3.onReceive(this.y, n3Var.y);
                    }
                }
            }
        }
    }

    public void zn(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.f6899n3) {
            try {
                zn znVar = new zn(intentFilter, broadcastReceiver);
                ArrayList<zn> arrayList = this.f6899n3.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.f6899n3.put(broadcastReceiver, arrayList);
                }
                arrayList.add(znVar);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList<zn> arrayList2 = this.f6901zn.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.f6901zn.put(action, arrayList2);
                    }
                    arrayList2.add(znVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
