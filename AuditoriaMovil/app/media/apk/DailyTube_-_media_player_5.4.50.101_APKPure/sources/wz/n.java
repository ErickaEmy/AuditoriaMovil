package wz;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class n {

    /* renamed from: gv  reason: collision with root package name */
    public static Class<?> f14735gv;
    public static final int[] y = {16842912};

    /* renamed from: n3  reason: collision with root package name */
    public static final int[] f14736n3 = new int[0];

    /* renamed from: zn  reason: collision with root package name */
    public static final Rect f14737zn = new Rect();

    static {
        try {
            f14735gv = Class.forName("android.graphics.Insets");
        } catch (ClassNotFoundException unused) {
        }
    }

    public static Rect gv(Drawable drawable) {
        Field[] fields;
        char c2;
        if (Build.VERSION.SDK_INT >= 29) {
            Insets opticalInsets = drawable.getOpticalInsets();
            Rect rect = new Rect();
            rect.left = opticalInsets.left;
            rect.right = opticalInsets.right;
            rect.top = opticalInsets.top;
            rect.bottom = opticalInsets.bottom;
            return rect;
        }
        if (f14735gv != null) {
            try {
                Drawable p2 = ej.y.p(drawable);
                Object invoke = p2.getClass().getMethod("getOpticalInsets", null).invoke(p2, null);
                if (invoke != null) {
                    Rect rect2 = new Rect();
                    for (Field field : f14735gv.getFields()) {
                        String name = field.getName();
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        if (c2 != 0) {
                            if (c2 != 1) {
                                if (c2 != 2) {
                                    if (c2 == 3) {
                                        rect2.bottom = field.getInt(invoke);
                                    }
                                } else {
                                    rect2.right = field.getInt(invoke);
                                }
                            } else {
                                rect2.top = field.getInt(invoke);
                            }
                        } else {
                            rect2.left = field.getInt(invoke);
                        }
                    }
                    return rect2;
                }
            } catch (Exception unused) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f14737zn;
    }

    public static void n3(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            zn(drawable);
        }
    }

    public static PorterDuff.Mode v(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static boolean y(@NonNull Drawable drawable) {
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                    if (!y(drawable2)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        } else if (drawable instanceof ej.fb) {
            return y(((ej.fb) drawable).y());
        } else {
            if (drawable instanceof i9.zn) {
                return y(((i9.zn) drawable).y());
            }
            if (drawable instanceof ScaleDrawable) {
                return y(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
    }

    public static void zn(Drawable drawable) {
        int[] state = drawable.getState();
        if (state != null && state.length != 0) {
            drawable.setState(f14736n3);
        } else {
            drawable.setState(y);
        }
        drawable.setState(state);
    }
}
