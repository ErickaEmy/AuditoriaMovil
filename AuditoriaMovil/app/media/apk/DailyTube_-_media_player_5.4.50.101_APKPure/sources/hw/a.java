package hw;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class a {

    /* renamed from: gv  reason: collision with root package name */
    public static Field f8932gv;

    /* renamed from: n3  reason: collision with root package name */
    public static Method f8933n3;
    public static boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public static boolean f8934zn;

    /* loaded from: classes.dex */
    public interface y {
        boolean superDispatchKeyEvent(@NonNull KeyEvent keyEvent);
    }

    public static DialogInterface.OnKeyListener a(Dialog dialog) {
        if (!f8934zn) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                f8932gv = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f8934zn = true;
        }
        Field field = f8932gv;
        if (field != null) {
            try {
                return (DialogInterface.OnKeyListener) field.get(dialog);
            } catch (IllegalAccessException unused2) {
                return null;
            }
        }
        return null;
    }

    public static boolean gv(@NonNull View view, @NonNull KeyEvent keyEvent) {
        return i4.f(view, keyEvent);
    }

    public static boolean n3(Activity activity, KeyEvent keyEvent) {
        KeyEvent.DispatcherState dispatcherState;
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && y(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (i4.i9(decorView, keyEvent)) {
            return true;
        }
        if (decorView != null) {
            dispatcherState = decorView.getKeyDispatcherState();
        } else {
            dispatcherState = null;
        }
        return keyEvent.dispatch(activity, dispatcherState, activity);
    }

    @SuppressLint({"LambdaLast"})
    public static boolean v(@NonNull y yVar, @Nullable View view, @Nullable Window.Callback callback, @NonNull KeyEvent keyEvent) {
        if (yVar == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return yVar.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            return n3((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return zn((Dialog) callback, keyEvent);
        }
        if ((view == null || !i4.i9(view, keyEvent)) && !yVar.superDispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public static boolean y(ActionBar actionBar, KeyEvent keyEvent) {
        if (!y) {
            try {
                f8933n3 = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException unused) {
            }
            y = true;
        }
        Method method = f8933n3;
        if (method != null) {
            try {
                Object invoke = method.invoke(actionBar, keyEvent);
                if (invoke == null) {
                    return false;
                }
                return ((Boolean) invoke).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    public static boolean zn(Dialog dialog, KeyEvent keyEvent) {
        KeyEvent.DispatcherState dispatcherState;
        DialogInterface.OnKeyListener a2 = a(dialog);
        if (a2 != null && a2.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (i4.i9(decorView, keyEvent)) {
            return true;
        }
        if (decorView != null) {
            dispatcherState = decorView.getKeyDispatcherState();
        } else {
            dispatcherState = null;
        }
        return keyEvent.dispatch(dialog, dispatcherState, dialog);
    }
}
