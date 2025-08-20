package rz;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class wz implements Iterable<Intent> {

    /* renamed from: v  reason: collision with root package name */
    public final Context f13370v;
    public final ArrayList<Intent> y = new ArrayList<>();

    /* loaded from: classes.dex */
    public interface y {
        @Nullable
        Intent getSupportParentActivityIntent();
    }

    public wz(Context context) {
        this.f13370v = context;
    }

    @NonNull
    public static wz v(@NonNull Context context) {
        return new wz(context);
    }

    public void c5(@Nullable Bundle bundle) {
        if (!this.y.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.y.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!mg.y.wz(this.f13370v, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f13370v.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    public void fb() {
        c5(null);
    }

    @NonNull
    public wz gv(@NonNull ComponentName componentName) {
        int size = this.y.size();
        try {
            Intent n32 = s.n3(this.f13370v, componentName);
            while (n32 != null) {
                this.y.add(size, n32);
                n32 = s.n3(this.f13370v, n32.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // java.lang.Iterable
    @NonNull
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.y.iterator();
    }

    @NonNull
    public wz n3(@NonNull Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f13370v.getPackageManager());
        }
        if (component != null) {
            gv(component);
        }
        y(intent);
        return this;
    }

    @NonNull
    public wz y(@NonNull Intent intent) {
        this.y.add(intent);
        return this;
    }

    @NonNull
    public wz zn(@NonNull Activity activity) {
        Intent intent;
        if (activity instanceof y) {
            intent = ((y) activity).getSupportParentActivityIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = s.y(activity);
        }
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(this.f13370v.getPackageManager());
            }
            gv(component);
            y(intent);
        }
        return this;
    }
}
