package wz;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f14738a;

    /* renamed from: fb  reason: collision with root package name */
    public final int[] f14739fb;

    /* renamed from: gv  reason: collision with root package name */
    public final WindowManager.LayoutParams f14740gv;

    /* renamed from: n3  reason: collision with root package name */
    public final View f14741n3;

    /* renamed from: v  reason: collision with root package name */
    public final Rect f14742v;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final TextView f14743zn;

    public o(@NonNull Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f14740gv = layoutParams;
        this.f14742v = new Rect();
        this.f14738a = new int[2];
        this.f14739fb = new int[2];
        this.y = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.f773co, (ViewGroup) null);
        this.f14741n3 = inflate;
        this.f14743zn = (TextView) inflate.findViewById(R$id.f735co);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.y;
        layoutParams.flags = 24;
    }

    public static View n3(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    public boolean gv() {
        if (this.f14741n3.getParent() != null) {
            return true;
        }
        return false;
    }

    public void v(View view, int i, int i5, boolean z2, CharSequence charSequence) {
        if (gv()) {
            zn();
        }
        this.f14743zn.setText(charSequence);
        y(view, i, i5, z2, this.f14740gv);
        ((WindowManager) this.y.getSystemService("window")).addView(this.f14741n3, this.f14740gv);
    }

    public final void y(View view, int i, int i5, boolean z2, WindowManager.LayoutParams layoutParams) {
        int height;
        int i6;
        int i8;
        int i10;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.y.getResources().getDimensionPixelOffset(R$dimen.f681tl);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.y.getResources().getDimensionPixelOffset(R$dimen.f680t);
            height = i5 + dimensionPixelOffset2;
            i6 = i5 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i6 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = this.y.getResources();
        if (z2) {
            i8 = R$dimen.f684xc;
        } else {
            i8 = R$dimen.f683wz;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i8);
        View n32 = n3(view);
        if (n32 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        n32.getWindowVisibleDisplayFrame(this.f14742v);
        Rect rect = this.f14742v;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources2 = this.y.getResources();
            int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier != 0) {
                i10 = resources2.getDimensionPixelSize(identifier);
            } else {
                i10 = 0;
            }
            DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
            this.f14742v.set(0, i10, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        n32.getLocationOnScreen(this.f14739fb);
        view.getLocationOnScreen(this.f14738a);
        int[] iArr = this.f14738a;
        int i11 = iArr[0];
        int[] iArr2 = this.f14739fb;
        int i12 = i11 - iArr2[0];
        iArr[0] = i12;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i12 + i) - (n32.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f14741n3.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f14741n3.getMeasuredHeight();
        int i13 = this.f14738a[1];
        int i14 = ((i6 + i13) - dimensionPixelOffset3) - measuredHeight;
        int i15 = i13 + height + dimensionPixelOffset3;
        if (z2) {
            if (i14 >= 0) {
                layoutParams.y = i14;
            } else {
                layoutParams.y = i15;
            }
        } else if (measuredHeight + i15 <= this.f14742v.height()) {
            layoutParams.y = i15;
        } else {
            layoutParams.y = i14;
        }
    }

    public void zn() {
        if (!gv()) {
            return;
        }
        ((WindowManager) this.y.getSystemService("window")).removeView(this.f14741n3);
    }
}
