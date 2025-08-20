package s;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import hw.i4;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import wz.k5;
import wz.w;
import wz.x4;
import wz.xc;
/* loaded from: classes.dex */
public class s {
    public final Object[] y = new Object[2];

    /* renamed from: n3  reason: collision with root package name */
    public static final Class<?>[] f13390n3 = {Context.class, AttributeSet.class};

    /* renamed from: zn  reason: collision with root package name */
    public static final int[] f13392zn = {16843375};

    /* renamed from: gv  reason: collision with root package name */
    public static final String[] f13389gv = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: v  reason: collision with root package name */
    public static final z.s<String, Constructor<? extends View>> f13391v = new z.s<>();

    /* loaded from: classes.dex */
    public static class y implements View.OnClickListener {

        /* renamed from: fb  reason: collision with root package name */
        public Method f13393fb;

        /* renamed from: s  reason: collision with root package name */
        public Context f13394s;

        /* renamed from: v  reason: collision with root package name */
        public final String f13395v;
        public final View y;

        public y(@NonNull View view, @NonNull String str) {
            this.y = view;
            this.f13395v = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NonNull View view) {
            if (this.f13393fb == null) {
                y(this.y.getContext());
            }
            try {
                this.f13393fb.invoke(this.f13394s, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }

        public final void y(@Nullable Context context) {
            int id;
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f13395v, View.class)) != null) {
                        this.f13393fb = method;
                        this.f13394s = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    context = null;
                }
            }
            if (this.y.getId() == -1) {
                str = "";
            } else {
                str = " with id '" + this.y.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f13395v + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.y.getClass() + str);
        }
    }

    public static Context z(Context context, AttributeSet attributeSet, boolean z2, boolean z3) {
        int i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f840fj, 0, 0);
        if (z2) {
            i = obtainStyledAttributes.getResourceId(R$styleable.f824d9, 0);
        } else {
            i = 0;
        }
        if (z3 && i == 0) {
            i = obtainStyledAttributes.getResourceId(R$styleable.f825da, 0);
        }
        obtainStyledAttributes.recycle();
        if (i != 0) {
            if (!(context instanceof t.gv) || ((t.gv) context).zn() != i) {
                return new t.gv(context, i);
            }
            return context;
        }
        return context;
    }

    @NonNull
    public AppCompatEditText a(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    @NonNull
    public wz.t c5(Context context, AttributeSet attributeSet) {
        return new wz.t(context, attributeSet);
    }

    public final View co(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.y;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                int i = 0;
                while (true) {
                    String[] strArr = f13389gv;
                    if (i >= strArr.length) {
                        return null;
                    }
                    View mt2 = mt(context, str, strArr[i]);
                    if (mt2 != null) {
                        return mt2;
                    }
                    i++;
                }
            } else {
                return mt(context, str, null);
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.y;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    @NonNull
    public w f(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }

    @NonNull
    public AppCompatImageButton fb(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    @NonNull
    public wz.a gv(Context context, AttributeSet attributeSet) {
        return new wz.a(context, attributeSet);
    }

    @NonNull
    public xc i9(Context context, AttributeSet attributeSet) {
        return new xc(context, attributeSet);
    }

    public final View mt(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        z.s<String, Constructor<? extends View>> sVar = f13391v;
        Constructor<? extends View> constructor = sVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f13390n3);
            sVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.y);
    }

    @NonNull
    public wz.gv n3(Context context, AttributeSet attributeSet) {
        return new wz.gv(context, attributeSet);
    }

    public final View p(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z2, boolean z3, boolean z4, boolean z5) {
        Context context2;
        View f4;
        if (z2 && view != null) {
            context2 = view.getContext();
        } else {
            context2 = context;
        }
        if (z3 || z4) {
            context2 = z(context2, attributeSet, z3, z4);
        }
        if (z5) {
            context2 = k5.n3(context2);
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = '\r';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                f4 = f(context2, attributeSet);
                r(f4, str);
                break;
            case 1:
                f4 = v(context2, attributeSet);
                r(f4, str);
                break;
            case 2:
                f4 = c5(context2, attributeSet);
                r(f4, str);
                break;
            case 3:
                f4 = wz(context2, attributeSet);
                r(f4, str);
                break;
            case 4:
                f4 = fb(context2, attributeSet);
                r(f4, str);
                break;
            case 5:
                f4 = t(context2, attributeSet);
                r(f4, str);
                break;
            case 6:
                f4 = tl(context2, attributeSet);
                r(f4, str);
                break;
            case 7:
                f4 = i9(context2, attributeSet);
                r(f4, str);
                break;
            case '\b':
                f4 = xc(context2, attributeSet);
                r(f4, str);
                break;
            case '\t':
                f4 = s(context2, attributeSet);
                r(f4, str);
                break;
            case '\n':
                f4 = n3(context2, attributeSet);
                r(f4, str);
                break;
            case 11:
                f4 = gv(context2, attributeSet);
                r(f4, str);
                break;
            case '\f':
                f4 = a(context2, attributeSet);
                r(f4, str);
                break;
            case '\r':
                f4 = zn(context2, attributeSet);
                r(f4, str);
                break;
            default:
                f4 = w(context2, str, attributeSet);
                break;
        }
        if (f4 == null && context != context2) {
            f4 = co(context2, str, attributeSet);
        }
        if (f4 != null) {
            y(f4, attributeSet);
        }
        return f4;
    }

    public final void r(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    @NonNull
    public AppCompatImageView s(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    @NonNull
    public AppCompatSeekBar t(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    @NonNull
    public AppCompatSpinner tl(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    @NonNull
    public wz.fb v(Context context, AttributeSet attributeSet) {
        return new wz.fb(context, attributeSet);
    }

    @Nullable
    public View w(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    @NonNull
    public AppCompatTextView wz(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    @NonNull
    public x4 xc(Context context, AttributeSet attributeSet) {
        return new x4(context, attributeSet);
    }

    public final void y(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && i4.qn(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f13392zn);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new y(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public AppCompatButton zn(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }
}
