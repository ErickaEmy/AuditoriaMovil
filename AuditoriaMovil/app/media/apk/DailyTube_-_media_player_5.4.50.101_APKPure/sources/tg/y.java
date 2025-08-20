package tg;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.startup.InitializationProvider;
import androidx.startup.R$string;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: gv  reason: collision with root package name */
    public static volatile y f13967gv;

    /* renamed from: v  reason: collision with root package name */
    public static final Object f13968v = new Object();
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final Set<Class<? extends n3<?>>> f13969n3 = new HashSet();
    @NonNull
    public final Map<Class<?>, Object> y = new HashMap();
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public final Context f13970zn;

    public y(@NonNull Context context) {
        this.f13970zn = context.getApplicationContext();
    }

    @NonNull
    public static y zn(@NonNull Context context) {
        if (f13967gv == null) {
            synchronized (f13968v) {
                try {
                    if (f13967gv == null) {
                        f13967gv = new y(context);
                    }
                } finally {
                }
            }
        }
        return f13967gv;
    }

    @NonNull
    public <T> T n3(@NonNull Class<? extends n3<?>> cls, @NonNull Set<Class<?>> set) {
        T t2;
        synchronized (f13968v) {
            if (pq.y.gv()) {
                pq.y.y(cls.getSimpleName());
            }
            if (!set.contains(cls)) {
                if (!this.y.containsKey(cls)) {
                    set.add(cls);
                    n3<?> newInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    List<Class<? extends n3<?>>> dependencies = newInstance.dependencies();
                    if (!dependencies.isEmpty()) {
                        for (Class<? extends n3<?>> cls2 : dependencies) {
                            if (!this.y.containsKey(cls2)) {
                                n3(cls2, set);
                            }
                        }
                    }
                    t2 = (T) newInstance.create(this.f13970zn);
                    set.remove(cls);
                    this.y.put(cls, t2);
                } else {
                    t2 = (T) this.y.get(cls);
                }
                pq.y.n3();
            } else {
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
            }
        }
        return t2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void y() {
        try {
            try {
                pq.y.y("Startup");
                Bundle bundle = this.f13970zn.getPackageManager().getProviderInfo(new ComponentName(this.f13970zn.getPackageName(), InitializationProvider.class.getName()), NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
                String string = this.f13970zn.getString(R$string.bj);
                if (bundle != null) {
                    HashSet hashSet = new HashSet();
                    for (String str : bundle.keySet()) {
                        if (string.equals(bundle.getString(str, null))) {
                            Class<?> cls = Class.forName(str);
                            if (n3.class.isAssignableFrom(cls)) {
                                this.f13969n3.add(cls);
                                n3(cls, hashSet);
                            }
                        }
                    }
                }
            } finally {
                pq.y.n3();
            }
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException e2) {
            throw new zn(e2);
        }
    }
}
