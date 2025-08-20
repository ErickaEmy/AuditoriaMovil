package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1923a;

    /* renamed from: fb  reason: collision with root package name */
    public int f1924fb;

    /* renamed from: gv  reason: collision with root package name */
    public float f1925gv;

    /* renamed from: n3  reason: collision with root package name */
    public n3 f1926n3;

    /* renamed from: v  reason: collision with root package name */
    public String f1927v;
    public String y;

    /* renamed from: zn  reason: collision with root package name */
    public int f1928zn;

    /* loaded from: classes.dex */
    public enum n3 {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    /* renamed from: androidx.constraintlayout.widget.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0016y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[n3.values().length];
            y = iArr;
            try {
                iArr[n3.COLOR_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[n3.COLOR_DRAWABLE_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[n3.INT_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[n3.FLOAT_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[n3.STRING_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                y[n3.BOOLEAN_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                y[n3.DIMENSION_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public y(String str, n3 n3Var, Object obj) {
        this.y = str;
        this.f1926n3 = n3Var;
        gv(obj);
    }

    public static void n3(Context context, XmlPullParser xmlPullParser, HashMap<String, y> hashMap) {
        n3 n3Var;
        Object string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.nz);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        n3 n3Var2 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R$styleable.f1784l8) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R$styleable.xh) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                n3Var2 = n3.BOOLEAN_TYPE;
            } else {
                if (index == R$styleable.rk) {
                    n3Var = n3.COLOR_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R$styleable.wv) {
                    n3Var = n3.COLOR_DRAWABLE_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R$styleable.gd) {
                    n3Var = n3.DIMENSION_TYPE;
                    string = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R$styleable.bx) {
                    n3Var = n3.DIMENSION_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ja) {
                    n3Var = n3.FLOAT_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R$styleable.cp) {
                    n3Var = n3.INT_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R$styleable.ng) {
                    n3Var = n3.STRING_TYPE;
                    string = obtainStyledAttributes.getString(index);
                }
                Object obj2 = string;
                n3Var2 = n3Var;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new y(str, n3Var2, obj));
        }
        obtainStyledAttributes.recycle();
    }

    public static HashMap<String, y> y(HashMap<String, y> hashMap, View view) {
        HashMap<String, y> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            y yVar = hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new y(yVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(str, new y(yVar, cls.getMethod("getMap" + str, null).invoke(view, null)));
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void zn(View view, HashMap<String, y> hashMap) {
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            y yVar = hashMap.get(str);
            String str2 = "set" + str;
            try {
                switch (C0016y.y[yVar.f1926n3.ordinal()]) {
                    case 1:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(yVar.f1924fb));
                        break;
                    case 2:
                        Method method = cls.getMethod(str2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(yVar.f1924fb);
                        method.invoke(view, colorDrawable);
                        break;
                    case 3:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(yVar.f1928zn));
                        break;
                    case 4:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(yVar.f1925gv));
                        break;
                    case 5:
                        cls.getMethod(str2, CharSequence.class).invoke(view, yVar.f1927v);
                        break;
                    case 6:
                        cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(yVar.f1923a));
                        break;
                    case 7:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(yVar.f1925gv));
                        break;
                }
            } catch (IllegalAccessException e2) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                Log.e("TransitionLayout", e3.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(str2);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e5) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e5.printStackTrace();
            }
        }
    }

    public void gv(Object obj) {
        switch (C0016y.y[this.f1926n3.ordinal()]) {
            case 1:
            case 2:
                this.f1924fb = ((Integer) obj).intValue();
                return;
            case 3:
                this.f1928zn = ((Integer) obj).intValue();
                return;
            case 4:
                this.f1925gv = ((Float) obj).floatValue();
                return;
            case 5:
                this.f1927v = (String) obj;
                return;
            case 6:
                this.f1923a = ((Boolean) obj).booleanValue();
                return;
            case 7:
                this.f1925gv = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public y(y yVar, Object obj) {
        this.y = yVar.y;
        this.f1926n3 = yVar.f1926n3;
        gv(obj);
    }
}
