package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.customview.view.AbsSavedState;
import hw.i4;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import wz.a8;
import wz.hw;
import wz.j5;
import wz.oz;
/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements t.zn {

    /* renamed from: ad  reason: collision with root package name */
    public static final wz f1357ad;

    /* renamed from: ap  reason: collision with root package name */
    public boolean f1358ap;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f1359b;

    /* renamed from: bk  reason: collision with root package name */
    public final Runnable f1360bk;

    /* renamed from: cr  reason: collision with root package name */
    public final TextView.OnEditorActionListener f1361cr;

    /* renamed from: ct  reason: collision with root package name */
    public final CharSequence f1362ct;

    /* renamed from: d  reason: collision with root package name */
    public final View f1363d;

    /* renamed from: dm  reason: collision with root package name */
    public final Intent f1364dm;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f1365e;

    /* renamed from: eb  reason: collision with root package name */
    public boolean f1366eb;

    /* renamed from: ej  reason: collision with root package name */
    public final View f1367ej;

    /* renamed from: en  reason: collision with root package name */
    public final ImageView f1368en;

    /* renamed from: f7  reason: collision with root package name */
    public int[] f1369f7;

    /* renamed from: fh  reason: collision with root package name */
    public final SearchAutoComplete f1370fh;

    /* renamed from: g  reason: collision with root package name */
    public SearchableInfo f1371g;

    /* renamed from: g3  reason: collision with root package name */
    public boolean f1372g3;

    /* renamed from: j  reason: collision with root package name */
    public final View f1373j;

    /* renamed from: j5  reason: collision with root package name */
    public final ImageView f1374j5;

    /* renamed from: jz  reason: collision with root package name */
    public final Drawable f1375jz;

    /* renamed from: k  reason: collision with root package name */
    public int[] f1376k;

    /* renamed from: kp  reason: collision with root package name */
    public CharSequence f1377kp;

    /* renamed from: lc  reason: collision with root package name */
    public boolean f1378lc;

    /* renamed from: m  reason: collision with root package name */
    public int f1379m;

    /* renamed from: nf  reason: collision with root package name */
    public oz.y f1380nf;

    /* renamed from: o  reason: collision with root package name */
    public final ImageView f1381o;

    /* renamed from: o0  reason: collision with root package name */
    public final AdapterView.OnItemClickListener f1382o0;

    /* renamed from: o4  reason: collision with root package name */
    public View.OnFocusChangeListener f1383o4;

    /* renamed from: oz  reason: collision with root package name */
    public xc f1384oz;

    /* renamed from: pq  reason: collision with root package name */
    public View.OnKeyListener f1385pq;

    /* renamed from: pz  reason: collision with root package name */
    public final View.OnClickListener f1386pz;

    /* renamed from: q9  reason: collision with root package name */
    public Rect f1387q9;

    /* renamed from: qn  reason: collision with root package name */
    public final ImageView f1388qn;

    /* renamed from: ra  reason: collision with root package name */
    public boolean f1389ra;

    /* renamed from: rb  reason: collision with root package name */
    public CharSequence f1390rb;

    /* renamed from: rs  reason: collision with root package name */
    public View.OnClickListener f1391rs;

    /* renamed from: s8  reason: collision with root package name */
    public boolean f1392s8;

    /* renamed from: tg  reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f1393tg;

    /* renamed from: u  reason: collision with root package name */
    public final int f1394u;

    /* renamed from: u0  reason: collision with root package name */
    public Bundle f1395u0;

    /* renamed from: ut  reason: collision with root package name */
    public Rect f1396ut;

    /* renamed from: wf  reason: collision with root package name */
    public TextWatcher f1397wf;

    /* renamed from: x  reason: collision with root package name */
    public final View f1398x;

    /* renamed from: xb  reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f1399xb;

    /* renamed from: xg  reason: collision with root package name */
    public final Intent f1400xg;

    /* renamed from: y4  reason: collision with root package name */
    public Runnable f1401y4;

    /* renamed from: y5  reason: collision with root package name */
    public final int f1402y5;

    /* renamed from: yc  reason: collision with root package name */
    public boolean f1403yc;

    /* renamed from: yg  reason: collision with root package name */
    public int f1404yg;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: fb  reason: collision with root package name */
        public boolean f1405fb;

        /* loaded from: classes.dex */
        public class y implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: n3 */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: zn */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1405fb + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1405fb));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1405fb = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends wz.gv {

        /* renamed from: f  reason: collision with root package name */
        public SearchView f1406f;

        /* renamed from: s  reason: collision with root package name */
        public int f1407s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f1408t;

        /* renamed from: w  reason: collision with root package name */
        public final Runnable f1409w;

        /* loaded from: classes.dex */
        public class y implements Runnable {
            public y() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.zn();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.f656w);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i5 = configuration.screenHeightDp;
            if (i >= 960 && i5 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                if (i < 640 || i5 < 480) {
                    return 160;
                }
                return 192;
            }
            return 192;
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            if (this.f1407s > 0 && !super.enoughToFilter()) {
                return false;
            }
            return true;
        }

        public boolean n3() {
            if (TextUtils.getTrimmedLength(getText()) == 0) {
                return true;
            }
            return false;
        }

        @Override // wz.gv, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1408t) {
                removeCallbacks(this.f1409w);
                post(this.f1409w);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z2, int i, Rect rect) {
            super.onFocusChanged(z2, i, rect);
            this.f1406f.en();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1406f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z2) {
            super.onWindowFocusChanged(z2);
            if (z2 && this.f1406f.hasFocus() && getVisibility() == 0) {
                this.f1408t = true;
                if (SearchView.k5(getContext())) {
                    y();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z2) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z2) {
                this.f1408t = false;
                removeCallbacks(this.f1409w);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f1408t = false;
                removeCallbacks(this.f1409w);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f1408t = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f1406f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1407s = i;
        }

        public void y() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.f1357ad.zn(this);
        }

        public void zn() {
            if (this.f1408t) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1408t = false;
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1409w = new y();
            this.f1407s = getThreshold();
        }
    }

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f1359b) {
                searchView.ut();
            } else if (view == searchView.f1388qn) {
                searchView.qn();
            } else if (view == searchView.f1374j5) {
                searchView.q9();
            } else if (view == searchView.f1381o) {
                searchView.jz();
            } else if (view == searchView.f1370fh) {
                searchView.ej();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c5 implements AdapterView.OnItemClickListener {
        public c5() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
            SearchView.this.o(i, 0, null);
        }
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    /* loaded from: classes.dex */
    public class fb implements View.OnKeyListener {
        public fb() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f1371g == null) {
                return false;
            }
            if (searchView.f1370fh.isPopupShowing() && SearchView.this.f1370fh.getListSelection() != -1) {
                return SearchView.this.k(view, i, keyEvent);
            }
            if (SearchView.this.f1370fh.n3() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.hw(0, null, searchView2.f1370fh.getText().toString());
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class gv implements View.OnFocusChangeListener {
        public gv() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f1383o4;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i9 implements AdapterView.OnItemSelectedListener {
        public i9() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
            SearchView.this.j(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public n3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.ct();
        }
    }

    /* loaded from: classes.dex */
    public class s implements TextView.OnEditorActionListener {
        public s() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.q9();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface t {
    }

    /* loaded from: classes.dex */
    public interface tl {
    }

    /* loaded from: classes.dex */
    public class v implements View.OnLayoutChangeListener {
        public v() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i5, int i6, int i8, int i10, int i11, int i12, int i13) {
            SearchView.this.fh();
        }
    }

    /* loaded from: classes.dex */
    public static class wz {

        /* renamed from: n3  reason: collision with root package name */
        public Method f1410n3;
        public Method y;

        /* renamed from: zn  reason: collision with root package name */
        public Method f1411zn;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public wz() {
            gv();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                this.y = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                this.f1410n3 = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f1411zn = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void gv() {
            if (Build.VERSION.SDK_INT < 29) {
                return;
            }
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }

        public void n3(AutoCompleteTextView autoCompleteTextView) {
            gv();
            Method method = this.y;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        public void y(AutoCompleteTextView autoCompleteTextView) {
            gv();
            Method method = this.f1410n3;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        public void zn(AutoCompleteTextView autoCompleteTextView) {
            gv();
            Method method = this.f1411zn;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class xc extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1412a;

        /* renamed from: gv  reason: collision with root package name */
        public final Rect f1413gv;

        /* renamed from: n3  reason: collision with root package name */
        public final Rect f1414n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f1415v;
        public final View y;

        /* renamed from: zn  reason: collision with root package name */
        public final Rect f1416zn;

        public xc(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1415v = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1414n3 = new Rect();
            this.f1413gv = new Rect();
            this.f1416zn = new Rect();
            y(rect, rect2);
            this.y = view;
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z2;
            boolean z3;
            int x2 = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z4 = true;
            if (action != 0) {
                if (action != 1 && action != 2) {
                    if (action == 3) {
                        z3 = this.f1412a;
                        this.f1412a = false;
                    }
                    z2 = true;
                    z4 = false;
                } else {
                    z3 = this.f1412a;
                    if (z3 && !this.f1413gv.contains(x2, y)) {
                        z4 = z3;
                        z2 = false;
                    }
                }
                z4 = z3;
                z2 = true;
            } else {
                if (this.f1414n3.contains(x2, y)) {
                    this.f1412a = true;
                    z2 = true;
                }
                z2 = true;
                z4 = false;
            }
            if (!z4) {
                return false;
            }
            if (z2 && !this.f1416zn.contains(x2, y)) {
                motionEvent.setLocation(this.y.getWidth() / 2, this.y.getHeight() / 2);
            } else {
                Rect rect = this.f1416zn;
                motionEvent.setLocation(x2 - rect.left, y - rect.top);
            }
            return this.y.dispatchTouchEvent(motionEvent);
        }

        public void y(Rect rect, Rect rect2) {
            this.f1414n3.set(rect);
            this.f1413gv.set(rect);
            Rect rect3 = this.f1413gv;
            int i = this.f1415v;
            rect3.inset(-i, -i);
            this.f1416zn.set(rect2);
        }
    }

    /* loaded from: classes.dex */
    public class y implements TextWatcher {
        public y() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i5, int i6) {
            SearchView.this.f7(charSequence);
        }
    }

    /* loaded from: classes.dex */
    public class zn implements Runnable {
        public zn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            oz.y yVar = SearchView.this.f1380nf;
            if (yVar instanceof a8) {
                yVar.y(null);
            }
        }
    }

    static {
        wz wzVar;
        if (Build.VERSION.SDK_INT < 29) {
            wzVar = new wz();
        } else {
            wzVar = null;
        }
        f1357ad = wzVar;
    }

    public SearchView(@NonNull Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.f675fb);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.f679s);
    }

    public static boolean k5(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    private void setQuery(CharSequence charSequence) {
        int length;
        this.f1370fh.setText(charSequence);
        SearchAutoComplete searchAutoComplete = this.f1370fh;
        if (TextUtils.isEmpty(charSequence)) {
            length = 0;
        } else {
            length = charSequence.length();
        }
        searchAutoComplete.setSelection(length);
    }

    @Override // t.zn
    public void a() {
        xg("", false);
        clearFocus();
        nf(true);
        this.f1370fh.setImeOptions(this.f1379m);
        this.f1372g3 = false;
    }

    public final CharSequence a8(CharSequence charSequence) {
        if (this.f1366eb && this.f1375jz != null) {
            int textSize = (int) (this.f1370fh.getTextSize() * 1.25d);
            this.f1375jz.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.f1375jz), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    public boolean b() {
        return this.f1378lc;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f1358ap = true;
        super.clearFocus();
        this.f1370fh.clearFocus();
        this.f1370fh.setImeVisibility(false);
        this.f1358ap = false;
    }

    public void ct() {
        int[] iArr;
        if (this.f1370fh.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.f1367ej.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1398x.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final Intent d(Intent intent, SearchableInfo searchableInfo) {
        String flattenToShortString;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            flattenToShortString = null;
        } else {
            flattenToShortString = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", flattenToShortString);
        return intent2;
    }

    public final void dm() {
        boolean z2;
        int[] iArr;
        boolean isEmpty = TextUtils.isEmpty(this.f1370fh.getText());
        int i = 0;
        if (isEmpty && (!this.f1366eb || this.f1372g3)) {
            z2 = false;
        } else {
            z2 = true;
        }
        ImageView imageView = this.f1388qn;
        if (!z2) {
            i = 8;
        }
        imageView.setVisibility(i);
        Drawable drawable = this.f1388qn.getDrawable();
        if (drawable != null) {
            if (!isEmpty) {
                iArr = ViewGroup.ENABLED_STATE_SET;
            } else {
                iArr = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
        }
    }

    public final void eb() {
        int i;
        if (yt() && (this.f1374j5.getVisibility() == 0 || this.f1381o.getVisibility() == 0)) {
            i = 0;
        } else {
            i = 8;
        }
        this.f1398x.setVisibility(i);
    }

    public void ej() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1370fh.refreshAutoCompleteResults();
            return;
        }
        wz wzVar = f1357ad;
        wzVar.n3(this.f1370fh);
        wzVar.y(this.f1370fh);
    }

    public void en() {
        nf(b());
        u();
        if (this.f1370fh.hasFocus()) {
            ej();
        }
    }

    public void f7(CharSequence charSequence) {
        Editable text = this.f1370fh.getText();
        this.f1390rb = text;
        boolean isEmpty = TextUtils.isEmpty(text);
        lc(!isEmpty);
        ra(isEmpty);
        dm();
        eb();
        this.f1377kp = charSequence.toString();
    }

    public void fh() {
        int i;
        int i5;
        if (this.f1373j.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1367ej.getPaddingLeft();
            Rect rect = new Rect();
            boolean n32 = oz.n3(this);
            if (this.f1366eb) {
                i = resources.getDimensionPixelSize(R$dimen.f682v) + resources.getDimensionPixelSize(R$dimen.f672a);
            } else {
                i = 0;
            }
            this.f1370fh.getDropDownBackground().getPadding(rect);
            if (n32) {
                i5 = -rect.left;
            } else {
                i5 = paddingLeft - (rect.left + i);
            }
            this.f1370fh.setDropDownHorizontalOffset(i5);
            this.f1370fh.setDropDownWidth((((this.f1373j.getWidth() + rect.left) + rect.right) + i) - paddingLeft);
        }
    }

    public int getImeOptions() {
        return this.f1370fh.getImeOptions();
    }

    public int getInputType() {
        return this.f1370fh.getInputType();
    }

    public int getMaxWidth() {
        return this.f1404yg;
    }

    public CharSequence getQuery() {
        return this.f1370fh.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f1365e;
        if (charSequence == null) {
            SearchableInfo searchableInfo = this.f1371g;
            if (searchableInfo != null && searchableInfo.getHintId() != 0) {
                return getContext().getText(this.f1371g.getHintId());
            }
            return this.f1362ct;
        }
        return charSequence;
    }

    public int getSuggestionCommitIconResId() {
        return this.f1402y5;
    }

    public int getSuggestionRowLayout() {
        return this.f1394u;
    }

    public oz.y getSuggestionsAdapter() {
        return this.f1380nf;
    }

    public void hw(int i, String str, String str2) {
        getContext().startActivity(rz("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    public boolean j(int i) {
        y5(i);
        return true;
    }

    public final boolean j5(int i, int i5, String str) {
        Cursor gv2 = this.f1380nf.gv();
        if (gv2 != null && gv2.moveToPosition(i)) {
            vl(mg(gv2, i5, str));
            return true;
        }
        return false;
    }

    public void jz() {
        SearchableInfo searchableInfo = this.f1371g;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(d(this.f1400xg, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(ta(this.f1364dm, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public boolean k(View view, int i, KeyEvent keyEvent) {
        int length;
        if (this.f1371g != null && this.f1380nf != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i != 66 && i != 84 && i != 61) {
                if (i != 21 && i != 22) {
                    if (i == 19) {
                        this.f1370fh.getListSelection();
                        return false;
                    }
                } else {
                    if (i == 21) {
                        length = 0;
                    } else {
                        length = this.f1370fh.length();
                    }
                    this.f1370fh.setSelection(length);
                    this.f1370fh.setListSelection(0);
                    this.f1370fh.clearListSelection();
                    this.f1370fh.y();
                    return true;
                }
            } else {
                return o(this.f1370fh.getListSelection(), 0, null);
            }
        }
        return false;
    }

    public final void lc(boolean z2) {
        int i;
        if (this.f1389ra && yt() && hasFocus() && (z2 || !this.f1403yc)) {
            i = 0;
        } else {
            i = 8;
        }
        this.f1374j5.setVisibility(i);
    }

    public final Intent mg(Cursor cursor, int i, String str) {
        int i5;
        Uri parse;
        String xc2;
        try {
            String xc3 = a8.xc(cursor, "suggest_intent_action");
            if (xc3 == null) {
                xc3 = this.f1371g.getSuggestIntentAction();
            }
            if (xc3 == null) {
                xc3 = "android.intent.action.SEARCH";
            }
            String str2 = xc3;
            String xc4 = a8.xc(cursor, "suggest_intent_data");
            if (xc4 == null) {
                xc4 = this.f1371g.getSuggestIntentData();
            }
            if (xc4 != null && (xc2 = a8.xc(cursor, "suggest_intent_data_id")) != null) {
                xc4 = xc4 + "/" + Uri.encode(xc2);
            }
            if (xc4 == null) {
                parse = null;
            } else {
                parse = Uri.parse(xc4);
            }
            return rz(str2, parse, a8.xc(cursor, "suggest_intent_extra_data"), a8.xc(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e2) {
            try {
                i5 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i5 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i5 + " returned exception.", e2);
            return null;
        }
    }

    @Override // t.zn
    public void n3() {
        if (this.f1372g3) {
            return;
        }
        this.f1372g3 = true;
        int imeOptions = this.f1370fh.getImeOptions();
        this.f1379m = imeOptions;
        this.f1370fh.setImeOptions(imeOptions | 33554432);
        this.f1370fh.setText("");
        setIconified(false);
    }

    public final void nf(boolean z2) {
        int i;
        int i5;
        this.f1378lc = z2;
        int i6 = 8;
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        boolean isEmpty = TextUtils.isEmpty(this.f1370fh.getText());
        this.f1359b.setVisibility(i);
        lc(!isEmpty);
        View view = this.f1363d;
        if (z2) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        view.setVisibility(i5);
        if (this.f1368en.getDrawable() != null && !this.f1366eb) {
            i6 = 0;
        }
        this.f1368en.setVisibility(i6);
        dm();
        ra(isEmpty);
        eb();
    }

    public boolean o(int i, int i5, String str) {
        j5(i, 0, null);
        this.f1370fh.setImeVisibility(false);
        z6();
        return true;
    }

    public final void o4() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1370fh;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(a8(queryHint));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1360bk);
        post(this.f1401y4);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        if (z2) {
            ud(this.f1370fh, this.f1396ut);
            Rect rect = this.f1387q9;
            Rect rect2 = this.f1396ut;
            rect.set(rect2.left, 0, rect2.right, i8 - i5);
            xc xcVar = this.f1384oz;
            if (xcVar == null) {
                xc xcVar2 = new xc(this.f1387q9, this.f1396ut, this.f1370fh);
                this.f1384oz = xcVar2;
                setTouchDelegate(xcVar2);
                return;
            }
            xcVar.y(this.f1387q9, this.f1396ut);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i5) {
        int i6;
        if (b()) {
            super.onMeasure(i, i5);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824 && (i6 = this.f1404yg) > 0) {
                    size = Math.min(i6, size);
                }
            } else {
                size = this.f1404yg;
                if (size <= 0) {
                    size = getPreferredWidth();
                }
            }
        } else {
            int i8 = this.f1404yg;
            size = i8 > 0 ? Math.min(i8, size) : Math.min(getPreferredWidth(), size);
        }
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                size2 = getPreferredHeight();
            }
        } else {
            size2 = Math.min(getPreferredHeight(), size2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.y());
        nf(savedState.f1405fb);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1405fb = b();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        u();
    }

    public void oz(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void q9() {
        Editable text = this.f1370fh.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1371g != null) {
                hw(0, null, text.toString());
            }
            this.f1370fh.setImeVisibility(false);
            z6();
        }
    }

    public void qn() {
        if (TextUtils.isEmpty(this.f1370fh.getText())) {
            if (this.f1366eb) {
                clearFocus();
                nf(true);
                return;
            }
            return;
        }
        this.f1370fh.setText("");
        this.f1370fh.requestFocus();
        this.f1370fh.setImeVisibility(true);
    }

    public final void ra(boolean z2) {
        int i = 8;
        if (this.f1403yc && !b() && z2) {
            this.f1374j5.setVisibility(8);
            i = 0;
        }
        this.f1381o.setVisibility(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.f1358ap || !isFocusable()) {
            return false;
        }
        if (!b()) {
            boolean requestFocus = this.f1370fh.requestFocus(i, rect);
            if (requestFocus) {
                nf(false);
            }
            return requestFocus;
        }
        return super.requestFocus(i, rect);
    }

    public final void rs() {
        this.f1370fh.setThreshold(this.f1371g.getSuggestThreshold());
        this.f1370fh.setImeOptions(this.f1371g.getImeOptions());
        int inputType = this.f1371g.getInputType();
        int i = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1371g.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f1370fh.setInputType(inputType);
        oz.y yVar = this.f1380nf;
        if (yVar != null) {
            yVar.y(null);
        }
        if (this.f1371g.getSuggestAuthority() != null) {
            a8 a8Var = new a8(getContext(), this, this.f1371g, this.f1393tg);
            this.f1380nf = a8Var;
            this.f1370fh.setAdapter(a8Var);
            a8 a8Var2 = (a8) this.f1380nf;
            if (this.f1392s8) {
                i = 2;
            }
            a8Var2.n(i);
        }
    }

    public final Intent rz(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1390rb);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1395u0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1371g.getSearchActivity());
        return intent;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1395u0 = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            qn();
        } else {
            ut();
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.f1366eb == z2) {
            return;
        }
        this.f1366eb = z2;
        nf(z2);
        o4();
    }

    public void setImeOptions(int i) {
        this.f1370fh.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f1370fh.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f1404yg = i;
        requestLayout();
    }

    public void setOnCloseListener(f fVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1383o4 = onFocusChangeListener;
    }

    public void setOnQueryTextListener(t tVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1391rs = onClickListener;
    }

    public void setOnSuggestionListener(tl tlVar) {
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.f1365e = charSequence;
        o4();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        int i;
        this.f1392s8 = z2;
        oz.y yVar = this.f1380nf;
        if (yVar instanceof a8) {
            a8 a8Var = (a8) yVar;
            if (z2) {
                i = 2;
            } else {
                i = 1;
            }
            a8Var.n(i);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1371g = searchableInfo;
        if (searchableInfo != null) {
            rs();
            o4();
        }
        boolean x2 = x();
        this.f1403yc = x2;
        if (x2) {
            this.f1370fh.setPrivateImeOptions("nm");
        }
        nf(b());
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.f1389ra = z2;
        nf(b());
    }

    public void setSuggestionsAdapter(oz.y yVar) {
        this.f1380nf = yVar;
        this.f1370fh.setAdapter(yVar);
    }

    public final Intent ta(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int i;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1395u0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        } else {
            i = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void u() {
        post(this.f1360bk);
    }

    public final void ud(View view, Rect rect) {
        view.getLocationInWindow(this.f1376k);
        getLocationInWindow(this.f1369f7);
        int[] iArr = this.f1376k;
        int i = iArr[1];
        int[] iArr2 = this.f1369f7;
        int i5 = i - iArr2[1];
        int i6 = iArr[0] - iArr2[0];
        rect.set(i6, i5, view.getWidth() + i6, view.getHeight() + i5);
    }

    public void ut() {
        nf(false);
        this.f1370fh.requestFocus();
        this.f1370fh.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f1391rs;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public final void vl(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    public final boolean x() {
        Intent intent;
        SearchableInfo searchableInfo = this.f1371g;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        if (this.f1371g.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1400xg;
        } else if (this.f1371g.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1364dm;
        } else {
            intent = null;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    public void xg(CharSequence charSequence, boolean z2) {
        this.f1370fh.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1370fh;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1390rb = charSequence;
        }
        if (z2 && !TextUtils.isEmpty(charSequence)) {
            q9();
        }
    }

    public final void y5(int i) {
        Editable text = this.f1370fh.getText();
        Cursor gv2 = this.f1380nf.gv();
        if (gv2 == null) {
            return;
        }
        if (gv2.moveToPosition(i)) {
            CharSequence n32 = this.f1380nf.n3(gv2);
            if (n32 != null) {
                setQuery(n32);
                return;
            } else {
                setQuery(text);
                return;
            }
        }
        setQuery(text);
    }

    public final boolean yt() {
        if ((this.f1389ra || this.f1403yc) && !b()) {
            return true;
        }
        return false;
    }

    public final void z6() {
        this.f1370fh.dismissDropDown();
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f653ud);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1396ut = new Rect();
        this.f1387q9 = new Rect();
        this.f1376k = new int[2];
        this.f1369f7 = new int[2];
        this.f1360bk = new n3();
        this.f1401y4 = new zn();
        this.f1393tg = new WeakHashMap<>();
        a aVar = new a();
        this.f1386pz = aVar;
        this.f1385pq = new fb();
        s sVar = new s();
        this.f1361cr = sVar;
        c5 c5Var = new c5();
        this.f1382o0 = c5Var;
        i9 i9Var = new i9();
        this.f1399xb = i9Var;
        this.f1397wf = new y();
        hw x42 = hw.x4(context, attributeSet, R$styleable.l3, i, 0);
        LayoutInflater.from(context).inflate(x42.wz(R$styleable.mq, R$layout.f778mt), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R$id.f748mg);
        this.f1370fh = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1363d = findViewById(R$id.f733c);
        View findViewById = findViewById(R$id.f754rz);
        this.f1367ej = findViewById;
        View findViewById2 = findViewById(R$id.f731a8);
        this.f1398x = findViewById2;
        ImageView imageView = (ImageView) findViewById(R$id.f740f3);
        this.f1359b = imageView;
        ImageView imageView2 = (ImageView) findViewById(R$id.f737d0);
        this.f1374j5 = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R$id.f750n);
        this.f1388qn = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R$id.f757ta);
        this.f1381o = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R$id.f742fh);
        this.f1368en = imageView5;
        i4.u0(findViewById, x42.fb(R$styleable.x0));
        i4.u0(findViewById2, x42.fb(R$styleable.j4));
        int i5 = R$styleable.wb;
        imageView.setImageDrawable(x42.fb(i5));
        imageView2.setImageDrawable(x42.fb(R$styleable.ih));
        imageView3.setImageDrawable(x42.fb(R$styleable.eu));
        imageView4.setImageDrawable(x42.fb(R$styleable.p2));
        imageView5.setImageDrawable(x42.fb(i5));
        this.f1375jz = x42.fb(R$styleable.ez);
        j5.y(imageView, getResources().getString(R$string.f801wz));
        this.f1394u = x42.wz(R$styleable.t7, R$layout.f780p);
        this.f1402y5 = x42.wz(R$styleable.xu, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(this.f1397wf);
        searchAutoComplete.setOnEditorActionListener(sVar);
        searchAutoComplete.setOnItemClickListener(c5Var);
        searchAutoComplete.setOnItemSelectedListener(i9Var);
        searchAutoComplete.setOnKeyListener(this.f1385pq);
        searchAutoComplete.setOnFocusChangeListener(new gv());
        setIconifiedByDefault(x42.y(R$styleable.jm, true));
        int a2 = x42.a(R$styleable.yh, -1);
        if (a2 != -1) {
            setMaxWidth(a2);
        }
        this.f1362ct = x42.w(R$styleable.z8);
        this.f1365e = x42.w(R$styleable.f866mc);
        int f4 = x42.f(R$styleable.i1, -1);
        if (f4 != -1) {
            setImeOptions(f4);
        }
        int f6 = x42.f(R$styleable.nh, -1);
        if (f6 != -1) {
            setInputType(f6);
        }
        setFocusable(x42.y(R$styleable.e5, true));
        x42.i4();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f1400xg = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1364dm = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f1373j = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new v());
        }
        nf(this.f1366eb);
        o4();
    }
}
