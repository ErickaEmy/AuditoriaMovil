package hw;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public abstract class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public y f8984n3;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public InterfaceC0109n3 f8985zn;

    /* renamed from: hw.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0109n3 {
        void onActionProviderVisibilityChanged(boolean z2);
    }

    /* loaded from: classes.dex */
    public interface y {
    }

    public n3(@NonNull Context context) {
        this.y = context;
    }

    public void c5(@Nullable y yVar) {
        this.f8984n3 = yVar;
    }

    public boolean fb() {
        return false;
    }

    @NonNull
    public View gv(@NonNull MenuItem menuItem) {
        return zn();
    }

    public void i9(@Nullable InterfaceC0109n3 interfaceC0109n3) {
        if (this.f8985zn != null && interfaceC0109n3 != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f8985zn = interfaceC0109n3;
    }

    public boolean n3() {
        return true;
    }

    public void s() {
        this.f8985zn = null;
        this.f8984n3 = null;
    }

    public boolean v() {
        return false;
    }

    public boolean y() {
        return false;
    }

    @NonNull
    public abstract View zn();

    public void a(@NonNull SubMenu subMenu) {
    }
}
