package t;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import hw.c5;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;
import wz.hw;
import wz.n;
/* loaded from: classes.dex */
public class fb extends MenuInflater {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?>[] f13863a;

    /* renamed from: v  reason: collision with root package name */
    public static final Class<?>[] f13864v;

    /* renamed from: gv  reason: collision with root package name */
    public Object f13865gv;

    /* renamed from: n3  reason: collision with root package name */
    public final Object[] f13866n3;
    public final Object[] y;

    /* renamed from: zn  reason: collision with root package name */
    public Context f13867zn;

    /* loaded from: classes.dex */
    public class n3 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f13868a;

        /* renamed from: c  reason: collision with root package name */
        public String f13869c;

        /* renamed from: c5  reason: collision with root package name */
        public int f13870c5;

        /* renamed from: co  reason: collision with root package name */
        public boolean f13871co;

        /* renamed from: d0  reason: collision with root package name */
        public hw.n3 f13873d0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f13874f;

        /* renamed from: f3  reason: collision with root package name */
        public String f13875f3;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f13876fb;

        /* renamed from: fh  reason: collision with root package name */
        public CharSequence f13877fh;

        /* renamed from: gv  reason: collision with root package name */
        public int f13878gv;

        /* renamed from: i4  reason: collision with root package name */
        public int f13879i4;

        /* renamed from: i9  reason: collision with root package name */
        public int f13880i9;

        /* renamed from: mg  reason: collision with root package name */
        public ColorStateList f13881mg;

        /* renamed from: mt  reason: collision with root package name */
        public int f13882mt;

        /* renamed from: n  reason: collision with root package name */
        public String f13883n;

        /* renamed from: n3  reason: collision with root package name */
        public int f13884n3;

        /* renamed from: p  reason: collision with root package name */
        public int f13885p;

        /* renamed from: r  reason: collision with root package name */
        public boolean f13886r;

        /* renamed from: rz  reason: collision with root package name */
        public CharSequence f13887rz;

        /* renamed from: s  reason: collision with root package name */
        public boolean f13888s;

        /* renamed from: t  reason: collision with root package name */
        public CharSequence f13889t;

        /* renamed from: ta  reason: collision with root package name */
        public PorterDuff.Mode f13890ta;

        /* renamed from: tl  reason: collision with root package name */
        public int f13891tl;

        /* renamed from: v  reason: collision with root package name */
        public int f13892v;

        /* renamed from: w  reason: collision with root package name */
        public char f13893w;

        /* renamed from: wz  reason: collision with root package name */
        public char f13894wz;

        /* renamed from: x4  reason: collision with root package name */
        public int f13895x4;

        /* renamed from: xc  reason: collision with root package name */
        public int f13896xc;
        public Menu y;

        /* renamed from: z  reason: collision with root package name */
        public boolean f13897z;

        /* renamed from: zn  reason: collision with root package name */
        public int f13898zn;

        public n3(Menu menu) {
            this.y = menu;
            s();
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = fb.this.f13867zn.obtainStyledAttributes(attributeSet, R$styleable.r6);
            this.f13884n3 = obtainStyledAttributes.getResourceId(R$styleable.zq, 0);
            this.f13898zn = obtainStyledAttributes.getInt(R$styleable.k3, 0);
            this.f13878gv = obtainStyledAttributes.getInt(R$styleable.ic, 0);
            this.f13892v = obtainStyledAttributes.getInt(R$styleable.gn, 0);
            this.f13868a = obtainStyledAttributes.getBoolean(R$styleable.hk, true);
            this.f13876fb = obtainStyledAttributes.getBoolean(R$styleable.jr, true);
            obtainStyledAttributes.recycle();
        }

        public final void c5(MenuItem menuItem) {
            boolean z2;
            MenuItem enabled = menuItem.setChecked(this.f13871co).setVisible(this.f13897z).setEnabled(this.f13886r);
            boolean z3 = false;
            if (this.f13882mt >= 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            enabled.setCheckable(z2).setTitleCondensed(this.f13889t).setIcon(this.f13891tl);
            int i = this.f13895x4;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.f13869c != null) {
                if (!fb.this.f13867zn.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new y(fb.this.n3(), this.f13869c));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f13882mt >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.fb) {
                    ((androidx.appcompat.view.menu.fb) menuItem).z(true);
                } else if (menuItem instanceof tl.zn) {
                    ((tl.zn) menuItem).s(true);
                }
            }
            String str = this.f13875f3;
            if (str != null) {
                menuItem.setActionView((View) v(str, fb.f13864v, fb.this.y));
                z3 = true;
            }
            int i5 = this.f13879i4;
            if (i5 > 0) {
                if (!z3) {
                    menuItem.setActionView(i5);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            hw.n3 n3Var = this.f13873d0;
            if (n3Var != null) {
                c5.y(menuItem, n3Var);
            }
            c5.zn(menuItem, this.f13877fh);
            c5.fb(menuItem, this.f13887rz);
            c5.n3(menuItem, this.f13894wz, this.f13896xc);
            c5.a(menuItem, this.f13893w, this.f13885p);
            PorterDuff.Mode mode = this.f13890ta;
            if (mode != null) {
                c5.v(menuItem, mode);
            }
            ColorStateList colorStateList = this.f13881mg;
            if (colorStateList != null) {
                c5.gv(menuItem, colorStateList);
            }
        }

        public void fb(AttributeSet attributeSet) {
            boolean z2;
            hw r2 = hw.r(fb.this.f13867zn, attributeSet, R$styleable.vc);
            this.f13870c5 = r2.wz(R$styleable.rv, 0);
            this.f13880i9 = (r2.f(R$styleable.cx, this.f13898zn) & (-65536)) | (r2.f(R$styleable.vh, this.f13878gv) & 65535);
            this.f13874f = r2.w(R$styleable.hy);
            this.f13889t = r2.w(R$styleable.xq);
            this.f13891tl = r2.wz(R$styleable.p1, 0);
            this.f13894wz = zn(r2.xc(R$styleable.jt));
            this.f13896xc = r2.f(R$styleable.wo, 4096);
            this.f13893w = zn(r2.xc(R$styleable.jb));
            this.f13885p = r2.f(R$styleable.vb, 4096);
            int i = R$styleable.sw;
            if (r2.co(i)) {
                this.f13882mt = r2.y(i, false) ? 1 : 0;
            } else {
                this.f13882mt = this.f13892v;
            }
            this.f13871co = r2.y(R$styleable.dp, false);
            this.f13897z = r2.y(R$styleable.hr, this.f13868a);
            this.f13886r = r2.y(R$styleable.i, this.f13876fb);
            this.f13895x4 = r2.f(R$styleable.fq, -1);
            this.f13869c = r2.xc(R$styleable.v1);
            this.f13879i4 = r2.wz(R$styleable.gi, 0);
            this.f13875f3 = r2.xc(R$styleable.l0);
            String xc2 = r2.xc(R$styleable.zx);
            this.f13883n = xc2;
            if (xc2 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && this.f13879i4 == 0 && this.f13875f3 == null) {
                this.f13873d0 = (hw.n3) v(xc2, fb.f13863a, fb.this.f13866n3);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f13873d0 = null;
            }
            this.f13877fh = r2.w(R$styleable.zh);
            this.f13887rz = r2.w(R$styleable.sx);
            int i5 = R$styleable.ob;
            if (r2.co(i5)) {
                this.f13890ta = n.v(r2.f(i5, -1), this.f13890ta);
            } else {
                this.f13890ta = null;
            }
            int i6 = R$styleable.hb;
            if (r2.co(i6)) {
                this.f13881mg = r2.zn(i6);
            } else {
                this.f13881mg = null;
            }
            r2.i4();
            this.f13888s = false;
        }

        public boolean gv() {
            return this.f13888s;
        }

        public SubMenu n3() {
            this.f13888s = true;
            SubMenu addSubMenu = this.y.addSubMenu(this.f13884n3, this.f13870c5, this.f13880i9, this.f13874f);
            c5(addSubMenu.getItem());
            return addSubMenu;
        }

        public void s() {
            this.f13884n3 = 0;
            this.f13898zn = 0;
            this.f13878gv = 0;
            this.f13892v = 0;
            this.f13868a = true;
            this.f13876fb = true;
        }

        public final <T> T v(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, fb.this.f13867zn.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        public void y() {
            this.f13888s = true;
            c5(this.y.add(this.f13884n3, this.f13870c5, this.f13880i9, this.f13874f));
        }

        public final char zn(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }
    }

    /* loaded from: classes.dex */
    public static class y implements MenuItem.OnMenuItemClickListener {

        /* renamed from: zn  reason: collision with root package name */
        public static final Class<?>[] f13899zn = {MenuItem.class};

        /* renamed from: n3  reason: collision with root package name */
        public Method f13900n3;
        public Object y;

        public y(Object obj, String str) {
            this.y = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f13900n3 = cls.getMethod(str, f13899zn);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f13900n3.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f13900n3.invoke(this.y, menuItem)).booleanValue();
                }
                this.f13900n3.invoke(this.y, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f13864v = clsArr;
        f13863a = clsArr;
    }

    public fb(Context context) {
        super(context);
        this.f13867zn = context;
        Object[] objArr = {context};
        this.y = objArr;
        this.f13866n3 = objArr;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof ud.y)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f13867zn.getResources().getLayout(i);
                    zn(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    public Object n3() {
        if (this.f13865gv == null) {
            this.f13865gv = y(this.f13867zn);
        }
        return this.f13865gv;
    }

    public final Object y(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        if (obj instanceof ContextWrapper) {
            return y(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r6 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r15 == 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r15 == 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r15 == 3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r7 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r15.equals(r8) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
        if (r15.equals("group") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
        r0.s();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r0.gv() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
        r15 = r0.f13873d0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
        if (r15 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        if (r15.y() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
        r0.n3();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
        r0.y();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
        if (r15.equals("menu") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008e, code lost:
        if (r7 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0091, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
        if (r15.equals("group") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        r0.a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a3, code lost:
        if (r15.equals("item") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a5, code lost:
        r0.fb(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ad, code lost:
        if (r15.equals("menu") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00af, code lost:
        zn(r13, r14, r0.n3());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b7, code lost:
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b9, code lost:
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c5, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c6, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zn(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r12 = this;
            t.fb$n3 r0 = new t.fb$n3
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r8 = r5
            r6 = 0
            r7 = 0
        L40:
            if (r6 != 0) goto Lc6
            if (r15 == r3) goto Lbe
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L8e
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lb9
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5e
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5e
            r8 = r5
            r7 = 0
            goto Lb9
        L5e:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L68
            r0.s()
            goto Lb9
        L68:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L86
            boolean r15 = r0.gv()
            if (r15 != 0) goto Lb9
            hw.n3 r15 = r0.f13873d0
            if (r15 == 0) goto L82
            boolean r15 = r15.y()
            if (r15 == 0) goto L82
            r0.n3()
            goto Lb9
        L82:
            r0.y()
            goto Lb9
        L86:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lb9
            r6 = 1
            goto Lb9
        L8e:
            if (r7 == 0) goto L91
            goto Lb9
        L91:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L9f
            r0.a(r14)
            goto Lb9
        L9f:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto La9
            r0.fb(r14)
            goto Lb9
        La9:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lb7
            android.view.SubMenu r15 = r0.n3()
            r12.zn(r13, r14, r15)
            goto Lb9
        Lb7:
            r8 = r15
            r7 = 1
        Lb9:
            int r15 = r13.next()
            goto L40
        Lbe:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t.fb.zn(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }
}
