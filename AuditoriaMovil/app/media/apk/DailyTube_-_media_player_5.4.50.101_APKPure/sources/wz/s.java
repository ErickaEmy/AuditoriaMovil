package wz;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public boolean f14801a;

    /* renamed from: gv  reason: collision with root package name */
    public boolean f14802gv;

    /* renamed from: n3  reason: collision with root package name */
    public ColorStateList f14803n3;

    /* renamed from: v  reason: collision with root package name */
    public boolean f14804v;
    @NonNull
    public final CompoundButton y;

    /* renamed from: zn  reason: collision with root package name */
    public PorterDuff.Mode f14805zn;

    public s(@NonNull CompoundButton compoundButton) {
        this.y = compoundButton;
    }

    public void a() {
        if (this.f14801a) {
            this.f14801a = false;
            return;
        }
        this.f14801a = true;
        y();
    }

    public void fb(ColorStateList colorStateList) {
        this.f14803n3 = colorStateList;
        this.f14802gv = true;
        y();
    }

    public PorterDuff.Mode gv() {
        return this.f14805zn;
    }

    public void s(@Nullable PorterDuff.Mode mode) {
        this.f14805zn = mode;
        this.f14804v = true;
        y();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:16:0x0056, B:18:0x005e, B:19:0x0067, B:21:0x006f, B:11:0x003b, B:13:0x0043, B:15:0x0049), top: B:29:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #1 {all -> 0x0039, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:16:0x0056, B:18:0x005e, B:19:0x0067, B:21:0x006f, B:11:0x003b, B:13:0x0043, B:15:0x0049), top: B:29:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v(@androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CompoundButton r0 = r9.y
            android.content.Context r0 = r0.getContext()
            int[] r3 = androidx.appcompat.R$styleable.f884q5
            r8 = 0
            wz.hw r0 = wz.hw.x4(r0, r10, r3, r11, r8)
            android.widget.CompoundButton r1 = r9.y
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.mt()
            r7 = 0
            r4 = r10
            r6 = r11
            hw.i4.kp(r1, r2, r3, r4, r5, r6, r7)
            int r10 = androidx.appcompat.R$styleable.f862le     // Catch: java.lang.Throwable -> L39
            boolean r11 = r0.co(r10)     // Catch: java.lang.Throwable -> L39
            if (r11 == 0) goto L3b
            int r10 = r0.wz(r10, r8)     // Catch: java.lang.Throwable -> L39
            if (r10 == 0) goto L3b
            android.widget.CompoundButton r11 = r9.y     // Catch: java.lang.Throwable -> L39 android.content.res.Resources.NotFoundException -> L3b
            android.content.Context r1 = r11.getContext()     // Catch: java.lang.Throwable -> L39 android.content.res.Resources.NotFoundException -> L3b
            android.graphics.drawable.Drawable r10 = c5.y.gv(r1, r10)     // Catch: java.lang.Throwable -> L39 android.content.res.Resources.NotFoundException -> L3b
            r11.setButtonDrawable(r10)     // Catch: java.lang.Throwable -> L39 android.content.res.Resources.NotFoundException -> L3b
            goto L56
        L39:
            r10 = move-exception
            goto L82
        L3b:
            int r10 = androidx.appcompat.R$styleable.f868mp     // Catch: java.lang.Throwable -> L39
            boolean r11 = r0.co(r10)     // Catch: java.lang.Throwable -> L39
            if (r11 == 0) goto L56
            int r10 = r0.wz(r10, r8)     // Catch: java.lang.Throwable -> L39
            if (r10 == 0) goto L56
            android.widget.CompoundButton r11 = r9.y     // Catch: java.lang.Throwable -> L39
            android.content.Context r1 = r11.getContext()     // Catch: java.lang.Throwable -> L39
            android.graphics.drawable.Drawable r10 = c5.y.gv(r1, r10)     // Catch: java.lang.Throwable -> L39
            r11.setButtonDrawable(r10)     // Catch: java.lang.Throwable -> L39
        L56:
            int r10 = androidx.appcompat.R$styleable.f819cs     // Catch: java.lang.Throwable -> L39
            boolean r11 = r0.co(r10)     // Catch: java.lang.Throwable -> L39
            if (r11 == 0) goto L67
            android.widget.CompoundButton r11 = r9.y     // Catch: java.lang.Throwable -> L39
            android.content.res.ColorStateList r10 = r0.zn(r10)     // Catch: java.lang.Throwable -> L39
            j.zn.zn(r11, r10)     // Catch: java.lang.Throwable -> L39
        L67:
            int r10 = androidx.appcompat.R$styleable.f892ro     // Catch: java.lang.Throwable -> L39
            boolean r11 = r0.co(r10)     // Catch: java.lang.Throwable -> L39
            if (r11 == 0) goto L7e
            android.widget.CompoundButton r11 = r9.y     // Catch: java.lang.Throwable -> L39
            r1 = -1
            int r10 = r0.f(r10, r1)     // Catch: java.lang.Throwable -> L39
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = wz.n.v(r10, r1)     // Catch: java.lang.Throwable -> L39
            j.zn.gv(r11, r10)     // Catch: java.lang.Throwable -> L39
        L7e:
            r0.i4()
            return
        L82:
            r0.i4()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: wz.s.v(android.util.AttributeSet, int):void");
    }

    public void y() {
        Drawable y = j.zn.y(this.y);
        if (y != null) {
            if (this.f14802gv || this.f14804v) {
                Drawable mutate = ej.y.mt(y).mutate();
                if (this.f14802gv) {
                    ej.y.xc(mutate, this.f14803n3);
                }
                if (this.f14804v) {
                    ej.y.w(mutate, this.f14805zn);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.y.getDrawableState());
                }
                this.y.setButtonDrawable(mutate);
            }
        }
    }

    public ColorStateList zn() {
        return this.f14803n3;
    }

    public int n3(int i) {
        return i;
    }
}
