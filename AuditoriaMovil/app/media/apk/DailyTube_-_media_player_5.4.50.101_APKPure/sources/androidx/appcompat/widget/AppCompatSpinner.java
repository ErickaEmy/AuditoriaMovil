package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.y;
import hw.i4;
import wz.b;
import wz.fh;
import wz.oz;
import wz.rz;
/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner {

    /* renamed from: co  reason: collision with root package name */
    public static final int[] f1309co = {16843505};

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1310f;

    /* renamed from: fb  reason: collision with root package name */
    public fh f1311fb;

    /* renamed from: p  reason: collision with root package name */
    public final Rect f1312p;

    /* renamed from: s  reason: collision with root package name */
    public SpinnerAdapter f1313s;

    /* renamed from: t  reason: collision with root package name */
    public a f1314t;

    /* renamed from: v  reason: collision with root package name */
    public final Context f1315v;

    /* renamed from: w  reason: collision with root package name */
    public int f1316w;
    public final wz.v y;

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();
        public boolean y;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.y ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.y = parcel.readByte() != 0;
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        CharSequence a();

        void c5(int i);

        void dismiss();

        void f(int i, int i5);

        Drawable fb();

        void i9(int i);

        void n3(Drawable drawable);

        void s(CharSequence charSequence);

        int t();

        void tl(ListAdapter listAdapter);

        void v(int i);

        boolean y();

        int zn();
    }

    /* loaded from: classes.dex */
    public static class gv implements ListAdapter, SpinnerAdapter {

        /* renamed from: v  reason: collision with root package name */
        public ListAdapter f1317v;
        public SpinnerAdapter y;

        public gv(@Nullable SpinnerAdapter spinnerAdapter, @Nullable Resources.Theme theme) {
            this.y = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1317v = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof b) {
                    b bVar = (b) spinnerAdapter;
                    if (bVar.getDropDownViewTheme() == null) {
                        bVar.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1317v;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.y;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.y;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.y;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.y;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.y;
            if (spinnerAdapter != null && spinnerAdapter.hasStableIds()) {
                return true;
            }
            return false;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            if (getCount() == 0) {
                return true;
            }
            return false;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1317v;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.y;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.y;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements ViewTreeObserver.OnGlobalLayoutListener {
        public n3() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().y()) {
                AppCompatSpinner.this.n3();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class v extends rz implements a {

        /* renamed from: ct  reason: collision with root package name */
        public CharSequence f1318ct;

        /* renamed from: eb  reason: collision with root package name */
        public int f1319eb;

        /* renamed from: o4  reason: collision with root package name */
        public ListAdapter f1321o4;

        /* renamed from: rs  reason: collision with root package name */
        public final Rect f1322rs;

        /* loaded from: classes.dex */
        public class n3 implements ViewTreeObserver.OnGlobalLayoutListener {
            public n3() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                v vVar = v.this;
                if (!vVar.j(AppCompatSpinner.this)) {
                    v.this.dismiss();
                    return;
                }
                v.this.qn();
                v.super.show();
            }
        }

        /* loaded from: classes.dex */
        public class y implements AdapterView.OnItemClickListener {
            public final /* synthetic */ AppCompatSpinner y;

            public y(AppCompatSpinner appCompatSpinner) {
                this.y = appCompatSpinner;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
                AppCompatSpinner.this.setSelection(i);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    v vVar = v.this;
                    AppCompatSpinner.this.performItemClick(view, i, vVar.f1321o4.getItemId(i));
                }
                v.this.dismiss();
            }
        }

        /* loaded from: classes.dex */
        public class zn implements PopupWindow.OnDismissListener {
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener y;

            public zn(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.y = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.y);
                }
            }
        }

        public v(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1322rs = new Rect();
            rz(AppCompatSpinner.this);
            ud(true);
            yt(0);
            x(new y(AppCompatSpinner.this));
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public CharSequence a() {
            return this.f1318ct;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public void f(int i, int i5) {
            ViewTreeObserver viewTreeObserver;
            boolean y2 = y();
            qn();
            ej(2);
            super.show();
            ListView xc2 = xc();
            xc2.setChoiceMode(1);
            xc2.setTextDirection(i);
            xc2.setTextAlignment(i5);
            vl(AppCompatSpinner.this.getSelectedItemPosition());
            if (!y2 && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                n3 n3Var = new n3();
                viewTreeObserver.addOnGlobalLayoutListener(n3Var);
                a8(new zn(n3Var));
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public void i9(int i) {
            this.f1319eb = i;
        }

        public boolean j(View view) {
            if (i4.ut(view) && view.getGlobalVisibleRect(this.f1322rs)) {
                return true;
            }
            return false;
        }

        public int o() {
            return this.f1319eb;
        }

        public void qn() {
            int i;
            int o2;
            Drawable fb2 = fb();
            if (fb2 != null) {
                fb2.getPadding(AppCompatSpinner.this.f1312p);
                if (oz.n3(AppCompatSpinner.this)) {
                    i = AppCompatSpinner.this.f1312p.right;
                } else {
                    i = -AppCompatSpinner.this.f1312p.left;
                }
            } else {
                Rect rect = AppCompatSpinner.this.f1312p;
                rect.right = 0;
                rect.left = 0;
                i = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i5 = appCompatSpinner.f1316w;
            if (i5 == -2) {
                int y2 = appCompatSpinner.y((SpinnerAdapter) this.f1321o4, fb());
                int i6 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f1312p;
                int i8 = (i6 - rect2.left) - rect2.right;
                if (y2 > i8) {
                    y2 = i8;
                }
                ta(Math.max(y2, (width - paddingLeft) - paddingRight));
            } else if (i5 == -1) {
                ta((width - paddingLeft) - paddingRight);
            } else {
                ta(i5);
            }
            if (oz.n3(AppCompatSpinner.this)) {
                o2 = i + (((width - paddingRight) - n()) - o());
            } else {
                o2 = i + paddingLeft + o();
            }
            v(o2);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public void s(CharSequence charSequence) {
            this.f1318ct = charSequence;
        }

        @Override // wz.rz, androidx.appcompat.widget.AppCompatSpinner.a
        public void tl(ListAdapter listAdapter) {
            super.tl(listAdapter);
            this.f1321o4 = listAdapter;
        }
    }

    /* loaded from: classes.dex */
    public class y extends fh {

        /* renamed from: z  reason: collision with root package name */
        public final /* synthetic */ v f1326z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(View view, v vVar) {
            super(view);
            this.f1326z = vVar;
        }

        @Override // wz.fh
        public tl.a n3() {
            return this.f1326z;
        }

        @Override // wz.fh
        @SuppressLint({"SyntheticAccessor"})
        public boolean zn() {
            if (!AppCompatSpinner.this.getInternalPopup().y()) {
                AppCompatSpinner.this.n3();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class zn implements a, DialogInterface.OnClickListener {

        /* renamed from: fb  reason: collision with root package name */
        public CharSequence f1327fb;

        /* renamed from: v  reason: collision with root package name */
        public ListAdapter f1329v;
        public androidx.appcompat.app.y y;

        public zn() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public CharSequence a() {
            return this.f1327fb;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public void c5(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public void dismiss() {
            androidx.appcompat.app.y yVar = this.y;
            if (yVar != null) {
                yVar.dismiss();
                this.y = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public void f(int i, int i5) {
            if (this.f1329v == null) {
                return;
            }
            y.C0011y c0011y = new y.C0011y(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f1327fb;
            if (charSequence != null) {
                c0011y.setTitle(charSequence);
            }
            androidx.appcompat.app.y create = c0011y.tl(this.f1329v, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
            this.y = create;
            ListView v2 = create.v();
            v2.setTextDirection(i);
            v2.setTextAlignment(i5);
            this.y.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public Drawable fb() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public void i9(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public void n3(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner.this.setSelection(i);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i, this.f1329v.getItemId(i));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public void s(CharSequence charSequence) {
            this.f1327fb = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public int t() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public void tl(ListAdapter listAdapter) {
            this.f1329v = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public void v(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public boolean y() {
            androidx.appcompat.app.y yVar = this.y;
            if (yVar != null) {
                return yVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.a
        public int zn() {
            return 0;
        }
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f658x);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        wz.v vVar = this.y;
        if (vVar != null) {
            vVar.n3();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        a aVar = this.f1314t;
        if (aVar != null) {
            return aVar.zn();
        }
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        a aVar = this.f1314t;
        if (aVar != null) {
            return aVar.t();
        }
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f1314t != null) {
            return this.f1316w;
        }
        return super.getDropDownWidth();
    }

    public final a getInternalPopup() {
        return this.f1314t;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        a aVar = this.f1314t;
        if (aVar != null) {
            return aVar.fb();
        }
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1315v;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        a aVar = this.f1314t;
        if (aVar != null) {
            return aVar.a();
        }
        return super.getPrompt();
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        wz.v vVar = this.y;
        if (vVar != null) {
            return vVar.zn();
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        wz.v vVar = this.y;
        if (vVar != null) {
            return vVar.gv();
        }
        return null;
    }

    public void n3() {
        this.f1314t.f(getTextDirection(), getTextAlignment());
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f1314t;
        if (aVar != null && aVar.y()) {
            this.f1314t.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i, int i5) {
        super.onMeasure(i, i5);
        if (this.f1314t != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), y(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.y && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new n3());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        a aVar = this.f1314t;
        if (aVar != null && aVar.y()) {
            z2 = true;
        } else {
            z2 = false;
        }
        savedState.y = z2;
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        fh fhVar = this.f1311fb;
        if (fhVar != null && fhVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        a aVar = this.f1314t;
        if (aVar != null) {
            if (!aVar.y()) {
                n3();
                return true;
            }
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        wz.v vVar = this.y;
        if (vVar != null) {
            vVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        wz.v vVar = this.y;
        if (vVar != null) {
            vVar.fb(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        a aVar = this.f1314t;
        if (aVar != null) {
            aVar.i9(i);
            this.f1314t.v(i);
            return;
        }
        super.setDropDownHorizontalOffset(i);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        a aVar = this.f1314t;
        if (aVar != null) {
            aVar.c5(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f1314t != null) {
            this.f1316w = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        a aVar = this.f1314t;
        if (aVar != null) {
            aVar.n3(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(c5.y.gv(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        a aVar = this.f1314t;
        if (aVar != null) {
            aVar.s(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        wz.v vVar = this.y;
        if (vVar != null) {
            vVar.c5(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        wz.v vVar = this.y;
        if (vVar != null) {
            vVar.i9(mode);
        }
    }

    public int y(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i5 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i5 = Math.max(i5, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f1312p);
            Rect rect = this.f1312p;
            return i5 + rect.left + rect.right;
        }
        return i5;
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1310f) {
            this.f1313s = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1314t != null) {
            Context context = this.f1315v;
            if (context == null) {
                context = getContext();
            }
            this.f1314t.tl(new gv(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        this(context, attributeSet, i, i5, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r10 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.Nullable android.util.AttributeSet r7, int r8, int r9, android.content.res.Resources.Theme r10) {
        /*
            r5 = this;
            r5.<init>(r6, r7, r8)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r5.f1312p = r0
            android.content.Context r0 = r5.getContext()
            wz.x.y(r5, r0)
            int[] r0 = androidx.appcompat.R$styleable.iu
            r1 = 0
            wz.hw r0 = wz.hw.x4(r6, r7, r0, r8, r1)
            wz.v r2 = new wz.v
            r2.<init>(r5)
            r5.y = r2
            if (r10 == 0) goto L29
            t.gv r2 = new t.gv
            r2.<init>(r6, r10)
            r5.f1315v = r2
            goto L3b
        L29:
            int r10 = androidx.appcompat.R$styleable.wv
            int r10 = r0.wz(r10, r1)
            if (r10 == 0) goto L39
            t.gv r2 = new t.gv
            r2.<init>(r6, r10)
            r5.f1315v = r2
            goto L3b
        L39:
            r5.f1315v = r6
        L3b:
            r10 = -1
            r2 = 0
            if (r9 != r10) goto L67
            int[] r10 = androidx.appcompat.widget.AppCompatSpinner.f1309co     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            android.content.res.TypedArray r10 = r6.obtainStyledAttributes(r7, r10, r8, r1)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            boolean r3 = r10.hasValue(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            if (r3 == 0) goto L55
            int r9 = r10.getInt(r1, r1)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            goto L55
        L50:
            r6 = move-exception
            r2 = r10
            goto L5e
        L53:
            goto L64
        L55:
            r10.recycle()
            goto L67
        L59:
            r6 = move-exception
            goto L5e
        L5b:
            r10 = r2
            goto L64
        L5e:
            if (r2 == 0) goto L63
            r2.recycle()
        L63:
            throw r6
        L64:
            if (r10 == 0) goto L67
            goto L55
        L67:
            r10 = 1
            if (r9 == 0) goto La4
            if (r9 == r10) goto L6d
            goto Lb4
        L6d:
            androidx.appcompat.widget.AppCompatSpinner$v r9 = new androidx.appcompat.widget.AppCompatSpinner$v
            android.content.Context r3 = r5.f1315v
            r9.<init>(r3, r7, r8)
            android.content.Context r3 = r5.f1315v
            int[] r4 = androidx.appcompat.R$styleable.iu
            wz.hw r1 = wz.hw.x4(r3, r7, r4, r8, r1)
            int r3 = androidx.appcompat.R$styleable.xh
            r4 = -2
            int r3 = r1.tl(r3, r4)
            r5.f1316w = r3
            int r3 = androidx.appcompat.R$styleable.nz
            android.graphics.drawable.Drawable r3 = r1.fb(r3)
            r9.n3(r3)
            int r3 = androidx.appcompat.R$styleable.f860l8
            java.lang.String r3 = r0.xc(r3)
            r9.s(r3)
            r1.i4()
            r5.f1314t = r9
            androidx.appcompat.widget.AppCompatSpinner$y r1 = new androidx.appcompat.widget.AppCompatSpinner$y
            r1.<init>(r5, r9)
            r5.f1311fb = r1
            goto Lb4
        La4:
            androidx.appcompat.widget.AppCompatSpinner$zn r9 = new androidx.appcompat.widget.AppCompatSpinner$zn
            r9.<init>()
            r5.f1314t = r9
            int r1 = androidx.appcompat.R$styleable.f860l8
            java.lang.String r1 = r0.xc(r1)
            r9.s(r1)
        Lb4:
            int r9 = androidx.appcompat.R$styleable.cw
            java.lang.CharSequence[] r9 = r0.p(r9)
            if (r9 == 0) goto Lcc
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r6, r3, r9)
            int r6 = androidx.appcompat.R$layout.f788z
            r1.setDropDownViewResource(r6)
            r5.setAdapter(r1)
        Lcc:
            r0.i4()
            r5.f1310f = r10
            android.widget.SpinnerAdapter r6 = r5.f1313s
            if (r6 == 0) goto Lda
            r5.setAdapter(r6)
            r5.f1313s = r2
        Lda:
            wz.v r6 = r5.y
            r6.v(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
