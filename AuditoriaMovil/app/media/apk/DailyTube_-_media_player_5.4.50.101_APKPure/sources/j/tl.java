package j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import yt.zn;
/* loaded from: classes.dex */
public final class tl {

    /* loaded from: classes.dex */
    public static class a implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9319a;

        /* renamed from: gv  reason: collision with root package name */
        public Method f9320gv;

        /* renamed from: n3  reason: collision with root package name */
        public final TextView f9321n3;

        /* renamed from: v  reason: collision with root package name */
        public boolean f9322v;
        public final ActionMode.Callback y;

        /* renamed from: zn  reason: collision with root package name */
        public Class<?> f9323zn;

        public a(ActionMode.Callback callback, TextView textView) {
            this.y = callback;
            this.f9321n3 = textView;
        }

        public final void a(Menu menu) {
            Method declaredMethod;
            Context context = this.f9321n3.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f9319a) {
                this.f9319a = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f9323zn = cls;
                    this.f9320gv = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f9322v = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f9323zn = null;
                    this.f9320gv = null;
                    this.f9322v = false;
                }
            }
            try {
                if (this.f9322v && this.f9323zn.isInstance(menu)) {
                    declaredMethod = this.f9320gv;
                } else {
                    declaredMethod = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> zn2 = zn(context, packageManager);
                for (int i = 0; i < zn2.size(); i++) {
                    ResolveInfo resolveInfo = zn2.get(i);
                    menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(n3(resolveInfo, this.f9321n3)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public final boolean gv(TextView textView) {
            if ((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled()) {
                return true;
            }
            return false;
        }

        public final Intent n3(ResolveInfo resolveInfo, TextView textView) {
            Intent putExtra = y().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !gv(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.y.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.y.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.y.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            a(menu);
            return this.y.onPrepareActionMode(actionMode, menu);
        }

        public final boolean v(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            if (str == null || context.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        }

        public final Intent y() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        public final List<ResolveInfo> zn(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(y(), 0)) {
                if (v(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static class gv {
        public static DecimalFormatSymbols y(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {
        public static void a(TextView textView, int i, int i5, int i6, int i8) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i5, i6, i8);
        }

        public static void fb(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        public static Locale gv(TextView textView) {
            return textView.getTextLocale();
        }

        public static int n3(View view) {
            return view.getLayoutDirection();
        }

        public static void s(View view, int i) {
            view.setTextDirection(i);
        }

        public static void v(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        public static Drawable[] y(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        public static int zn(View view) {
            return view.getTextDirection();
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static int n3(TextView textView) {
            return textView.getMaxLines();
        }

        public static boolean y(TextView textView) {
            return textView.getIncludeFontPadding();
        }

        public static int zn(TextView textView) {
            return textView.getMinLines();
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public static void a(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        public static void fb(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        public static int gv(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        public static ColorStateList n3(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        public static void s(TextView textView, int i) {
            textView.setHyphenationFrequency(i);
        }

        public static void v(TextView textView, int i) {
            textView.setBreakStrategy(i);
        }

        public static int y(TextView textView) {
            return textView.getBreakStrategy();
        }

        public static PorterDuff.Mode zn(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }
    }

    public static TextDirectionHeuristic a(@NonNull TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(v.n3(gv.y(n3.gv(textView)))[0].codePointAt(0));
            if (directionality != 1 && directionality != 2) {
                return TextDirectionHeuristics.LTR;
            }
            return TextDirectionHeuristics.RTL;
        }
        if (n3.n3(textView) != 1) {
            z2 = false;
        }
        switch (n3.zn(textView)) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                if (z2) {
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                }
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    public static void c5(@NonNull TextView textView, @Nullable PorterDuff.Mode mode) {
        vl.s.fb(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            zn.fb(textView, mode);
        } else if (textView instanceof xc) {
            ((xc) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void f(@NonNull TextView textView, int i) {
        int i5;
        vl.s.gv(i);
        if (Build.VERSION.SDK_INT >= 28) {
            v.gv(textView, i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (y.y(textView)) {
            i5 = fontMetricsInt.top;
        } else {
            i5 = fontMetricsInt.ascent;
        }
        if (i > Math.abs(i5)) {
            textView.setPadding(textView.getPaddingLeft(), i + i5, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    @NonNull
    public static zn.n3 fb(@NonNull TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return new zn.n3(v.zn(textView));
        }
        zn.n3.y yVar = new zn.n3.y(new TextPaint(textView.getPaint()));
        if (i >= 23) {
            yVar.n3(zn.y(textView));
            yVar.zn(zn.gv(textView));
        }
        yVar.gv(a(textView));
        return yVar.y();
    }

    public static int gv(@NonNull TextView textView) {
        return y.n3(textView);
    }

    public static void i9(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        n3.v(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static int n3(@NonNull TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    @Nullable
    public static ActionMode.Callback p(@NonNull TextView textView, @Nullable ActionMode.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 && i <= 27 && !(callback instanceof a) && callback != null) {
            return new a(callback, textView);
        }
        return callback;
    }

    public static void s(@NonNull TextView textView, @Nullable ColorStateList colorStateList) {
        vl.s.fb(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            zn.a(textView, colorStateList);
        } else if (textView instanceof xc) {
            ((xc) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void t(@NonNull TextView textView, int i) {
        int i5;
        vl.s.gv(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (y.y(textView)) {
            i5 = fontMetricsInt.bottom;
        } else {
            i5 = fontMetricsInt.descent;
        }
        if (i > Math.abs(i5)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i5);
        }
    }

    public static void tl(@NonNull TextView textView, int i) {
        vl.s.gv(i);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing(i - fontMetricsInt, 1.0f);
        }
    }

    public static int v(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
        TextDirectionHeuristic textDirectionHeuristic2;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (textDirectionHeuristic == textDirectionHeuristic3 || textDirectionHeuristic == (textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 6;
        }
        if (textDirectionHeuristic != textDirectionHeuristic3) {
            return 1;
        }
        return 7;
    }

    public static void w(@NonNull TextView textView, @NonNull zn.n3 n3Var) {
        int i = Build.VERSION.SDK_INT;
        n3.s(textView, v(n3Var.gv()));
        if (i < 23) {
            float textScaleX = n3Var.v().getTextScaleX();
            textView.getPaint().set(n3Var.v());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(n3Var.v());
        zn.v(textView, n3Var.n3());
        zn.s(textView, n3Var.zn());
    }

    public static void wz(@NonNull TextView textView, @NonNull yt.zn znVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(v.y(znVar.zn()));
        } else if (fb(textView).y(znVar.n3())) {
            textView.setText(znVar);
        } else {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
    }

    public static void xc(@NonNull TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    @NonNull
    public static Drawable[] y(@NonNull TextView textView) {
        return n3.y(textView);
    }

    public static int zn(@NonNull TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    /* loaded from: classes.dex */
    public static class v {
        public static void gv(TextView textView, int i) {
            textView.setFirstBaselineToTopHeight(i);
        }

        public static String[] n3(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        public static PrecomputedText.Params zn(TextView textView) {
            return textView.getTextMetricsParams();
        }

        public static CharSequence y(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }
}
