package mt;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import n3.n3;
/* loaded from: classes.dex */
public abstract class v implements ServiceConnection {
    @Nullable
    private Context mApplicationContext;

    /* loaded from: classes.dex */
    public class y extends zn {
        public y(n3.n3 n3Var, ComponentName componentName, Context context) {
            super(n3Var, componentName, context);
        }
    }

    @Nullable
    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull zn znVar);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        if (this.mApplicationContext != null) {
            onCustomTabsServiceConnected(componentName, new y(n3.y.mt(iBinder), componentName, this.mApplicationContext));
            return;
        }
        throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
    }

    public void setApplicationContext(@NonNull Context context) {
        this.mApplicationContext = context;
    }
}
