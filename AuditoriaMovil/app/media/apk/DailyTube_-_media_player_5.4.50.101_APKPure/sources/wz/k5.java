package wz;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k5 extends ContextWrapper {

    /* renamed from: gv  reason: collision with root package name */
    public static ArrayList<WeakReference<k5>> f14726gv;

    /* renamed from: zn  reason: collision with root package name */
    public static final Object f14727zn = new Object();

    /* renamed from: n3  reason: collision with root package name */
    public final Resources.Theme f14728n3;
    public final Resources y;

    public k5(@NonNull Context context) {
        super(context);
        if (j.n3()) {
            j jVar = new j(this, context.getResources());
            this.y = jVar;
            Resources.Theme newTheme = jVar.newTheme();
            this.f14728n3 = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.y = new vl(this, context.getResources());
        this.f14728n3 = null;
    }

    public static Context n3(@NonNull Context context) {
        k5 k5Var;
        if (y(context)) {
            synchronized (f14727zn) {
                try {
                    ArrayList<WeakReference<k5>> arrayList = f14726gv;
                    if (arrayList == null) {
                        f14726gv = new ArrayList<>();
                    } else {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            WeakReference<k5> weakReference = f14726gv.get(size);
                            if (weakReference == null || weakReference.get() == null) {
                                f14726gv.remove(size);
                            }
                        }
                        for (int size2 = f14726gv.size() - 1; size2 >= 0; size2--) {
                            WeakReference<k5> weakReference2 = f14726gv.get(size2);
                            if (weakReference2 != null) {
                                k5Var = weakReference2.get();
                            } else {
                                k5Var = null;
                            }
                            if (k5Var != null && k5Var.getBaseContext() == context) {
                                return k5Var;
                            }
                        }
                    }
                    k5 k5Var2 = new k5(context);
                    f14726gv.add(new WeakReference<>(k5Var2));
                    return k5Var2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return context;
    }

    public static boolean y(@NonNull Context context) {
        if (!(context instanceof k5) && !(context.getResources() instanceof vl) && !(context.getResources() instanceof j)) {
            return j.n3();
        }
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.y.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.y;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f14728n3;
        if (theme == null) {
            return super.getTheme();
        }
        return theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.f14728n3;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
