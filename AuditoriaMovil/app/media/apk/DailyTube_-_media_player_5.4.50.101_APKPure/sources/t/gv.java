package t;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;
/* loaded from: classes.dex */
public class gv extends ContextWrapper {

    /* renamed from: gv  reason: collision with root package name */
    public Configuration f13901gv;

    /* renamed from: n3  reason: collision with root package name */
    public Resources.Theme f13902n3;

    /* renamed from: v  reason: collision with root package name */
    public Resources f13903v;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public LayoutInflater f13904zn;

    public gv() {
        super(null);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return n3();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f13904zn == null) {
                this.f13904zn = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f13904zn;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f13902n3;
        if (theme != null) {
            return theme;
        }
        if (this.y == 0) {
            this.y = R$style.f803gv;
        }
        gv();
        return this.f13902n3;
    }

    public final void gv() {
        boolean z2;
        if (this.f13902n3 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f13902n3 = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f13902n3.setTo(theme);
            }
        }
        v(this.f13902n3, this.y, z2);
    }

    public final Resources n3() {
        if (this.f13903v == null) {
            Configuration configuration = this.f13901gv;
            if (configuration == null) {
                this.f13903v = super.getResources();
            } else {
                this.f13903v = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f13903v;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.y != i) {
            this.y = i;
            gv();
        }
    }

    public void v(Resources.Theme theme, int i, boolean z2) {
        theme.applyStyle(i, true);
    }

    public void y(Configuration configuration) {
        if (this.f13903v == null) {
            if (this.f13901gv == null) {
                this.f13901gv = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    public int zn() {
        return this.y;
    }

    public gv(Context context, int i) {
        super(context);
        this.y = i;
    }

    public gv(Context context, Resources.Theme theme) {
        super(context);
        this.f13902n3 = theme;
    }
}
