package qg;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
/* loaded from: classes.dex */
public final class n3 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final y f12820a;
    @NonNull

    /* renamed from: fb  reason: collision with root package name */
    public final y f12821fb;
    @NonNull

    /* renamed from: gv  reason: collision with root package name */
    public final y f12822gv;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final y f12823n3;
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    public final Paint f12824s;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public final y f12825v;
    @NonNull
    public final y y;
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public final y f12826zn;

    public n3(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(pv.n3.zn(context, R$attr.frv, com.google.android.material.datepicker.y.class.getCanonicalName()), R$styleable.gm);
        this.y = y.y(context, obtainStyledAttributes.getResourceId(R$styleable.mf, 0));
        this.f12821fb = y.y(context, obtainStyledAttributes.getResourceId(R$styleable.jf, 0));
        this.f12823n3 = y.y(context, obtainStyledAttributes.getResourceId(R$styleable.x2, 0));
        this.f12826zn = y.y(context, obtainStyledAttributes.getResourceId(R$styleable.fm, 0));
        ColorStateList y = pv.zn.y(context, obtainStyledAttributes, R$styleable.w5);
        this.f12822gv = y.y(context, obtainStyledAttributes.getResourceId(R$styleable.ik, 0));
        this.f12825v = y.y(context, obtainStyledAttributes.getResourceId(R$styleable.p4, 0));
        this.f12820a = y.y(context, obtainStyledAttributes.getResourceId(R$styleable.ni, 0));
        Paint paint = new Paint();
        this.f12824s = paint;
        paint.setColor(y.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
