package y5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class x4 extends Service implements co {
    public final androidx.lifecycle.tl y = new androidx.lifecycle.tl(this);

    @Override // y5.co
    @NonNull
    public androidx.lifecycle.v getLifecycle() {
        return this.y.y();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NonNull Intent intent) {
        this.y.n3();
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.y.zn();
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.y.gv();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(@Nullable Intent intent, int i) {
        this.y.v();
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i5) {
        return super.onStartCommand(intent, i, i5);
    }
}
