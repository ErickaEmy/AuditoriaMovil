package rz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.v;
import hw.a;
import y5.co;
/* loaded from: classes.dex */
public class fb extends Activity implements co, a.y {
    private z.s<Class<? extends y>, y> mExtraDataMap = new z.s<>();
    private androidx.lifecycle.fb mLifecycleRegistry = new androidx.lifecycle.fb(this);

    @Deprecated
    /* loaded from: classes.dex */
    public static class y {
    }

    private static boolean shouldSkipDump(@Nullable String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            String str = strArr[0];
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -645125871:
                    if (str.equals("--translation")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 100470631:
                    if (str.equals("--dump-dumpable")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 472614934:
                    if (str.equals("--list-dumpables")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1159329357:
                    if (str.equals("--contentcapture")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1455016274:
                    if (str.equals("--autofill")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (Build.VERSION.SDK_INT >= 31) {
                        return true;
                    }
                    return false;
                case 1:
                case 2:
                    if (Build.VERSION.SDK_INT >= 33) {
                        return true;
                    }
                    return false;
                case 3:
                    if (Build.VERSION.SDK_INT >= 29) {
                        return true;
                    }
                    return false;
                case 4:
                    if (Build.VERSION.SDK_INT >= 26) {
                        return true;
                    }
                    return false;
            }
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView != null && hw.a.gv(decorView, keyEvent)) {
            return true;
        }
        return hw.a.v(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView != null && hw.a.gv(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Deprecated
    public <T extends y> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.get(cls);
    }

    @NonNull
    public androidx.lifecycle.v getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.f.fb(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        this.mLifecycleRegistry.i9(v.zn.CREATED);
        super.onSaveInstanceState(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void putExtraData(y yVar) {
        this.mExtraDataMap.put(yVar.getClass(), yVar);
    }

    public final boolean shouldDumpInternalState(@Nullable String[] strArr) {
        return !shouldSkipDump(strArr);
    }

    @Override // hw.a.y
    public boolean superDispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
