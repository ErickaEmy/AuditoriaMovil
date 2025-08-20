package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import hw.i4;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class AlertController {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f932a;

    /* renamed from: a8  reason: collision with root package name */
    public int f933a8;

    /* renamed from: b  reason: collision with root package name */
    public int f934b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f935c;

    /* renamed from: c5  reason: collision with root package name */
    public int f936c5;

    /* renamed from: co  reason: collision with root package name */
    public Button f937co;

    /* renamed from: d  reason: collision with root package name */
    public TextView f938d;

    /* renamed from: d0  reason: collision with root package name */
    public NestedScrollView f939d0;

    /* renamed from: ej  reason: collision with root package name */
    public ListAdapter f940ej;

    /* renamed from: f  reason: collision with root package name */
    public int f941f;

    /* renamed from: f3  reason: collision with root package name */
    public CharSequence f942f3;

    /* renamed from: fb  reason: collision with root package name */
    public ListView f943fb;

    /* renamed from: fh  reason: collision with root package name */
    public int f944fh;

    /* renamed from: gv  reason: collision with root package name */
    public final int f945gv;

    /* renamed from: hw  reason: collision with root package name */
    public boolean f946hw;

    /* renamed from: i4  reason: collision with root package name */
    public Button f947i4;

    /* renamed from: i9  reason: collision with root package name */
    public int f948i9;

    /* renamed from: j5  reason: collision with root package name */
    public int f949j5;

    /* renamed from: k5  reason: collision with root package name */
    public int f950k5;

    /* renamed from: mg  reason: collision with root package name */
    public ImageView f951mg;

    /* renamed from: mt  reason: collision with root package name */
    public Drawable f952mt;

    /* renamed from: n  reason: collision with root package name */
    public Message f953n;

    /* renamed from: n3  reason: collision with root package name */
    public final s.a f954n3;

    /* renamed from: p  reason: collision with root package name */
    public Message f956p;

    /* renamed from: qn  reason: collision with root package name */
    public Handler f957qn;

    /* renamed from: r  reason: collision with root package name */
    public Message f958r;

    /* renamed from: rz  reason: collision with root package name */
    public Drawable f959rz;

    /* renamed from: s  reason: collision with root package name */
    public View f960s;

    /* renamed from: t  reason: collision with root package name */
    public int f961t;

    /* renamed from: ta  reason: collision with root package name */
    public TextView f962ta;

    /* renamed from: tl  reason: collision with root package name */
    public int f963tl;

    /* renamed from: v  reason: collision with root package name */
    public CharSequence f965v;

    /* renamed from: vl  reason: collision with root package name */
    public int f966vl;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f967w;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f968wz;

    /* renamed from: x  reason: collision with root package name */
    public int f969x;

    /* renamed from: x4  reason: collision with root package name */
    public Drawable f970x4;

    /* renamed from: xc  reason: collision with root package name */
    public Button f971xc;
    public final Context y;

    /* renamed from: yt  reason: collision with root package name */
    public int f972yt;

    /* renamed from: z  reason: collision with root package name */
    public CharSequence f973z;

    /* renamed from: z6  reason: collision with root package name */
    public View f974z6;

    /* renamed from: zn  reason: collision with root package name */
    public final Window f975zn;

    /* renamed from: ud  reason: collision with root package name */
    public int f964ud = -1;

    /* renamed from: o  reason: collision with root package name */
    public final View.OnClickListener f955o = new y();

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: v  reason: collision with root package name */
        public final int f976v;
        public final int y;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.w7);
            this.f976v = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ou, -1);
            this.y = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.vi, -1);
        }

        public void y(boolean z2, boolean z3) {
            int i;
            int i5;
            if (!z3 || !z2) {
                int paddingLeft = getPaddingLeft();
                if (z2) {
                    i = getPaddingTop();
                } else {
                    i = this.y;
                }
                int paddingRight = getPaddingRight();
                if (z3) {
                    i5 = getPaddingBottom();
                } else {
                    i5 = this.f976v;
                }
                setPadding(paddingLeft, i, paddingRight, i5);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f977a;

        /* renamed from: a8  reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f978a8;

        /* renamed from: b  reason: collision with root package name */
        public String f979b;

        /* renamed from: c  reason: collision with root package name */
        public View f980c;

        /* renamed from: c5  reason: collision with root package name */
        public CharSequence f981c5;

        /* renamed from: co  reason: collision with root package name */
        public DialogInterface.OnCancelListener f982co;

        /* renamed from: d  reason: collision with root package name */
        public boolean[] f983d;

        /* renamed from: d0  reason: collision with root package name */
        public int f984d0;

        /* renamed from: ej  reason: collision with root package name */
        public boolean f985ej;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnClickListener f986f;

        /* renamed from: f3  reason: collision with root package name */
        public DialogInterface.OnClickListener f987f3;

        /* renamed from: fb  reason: collision with root package name */
        public View f988fb;

        /* renamed from: fh  reason: collision with root package name */
        public int f989fh;

        /* renamed from: gv  reason: collision with root package name */
        public Drawable f990gv;

        /* renamed from: i4  reason: collision with root package name */
        public ListAdapter f991i4;

        /* renamed from: i9  reason: collision with root package name */
        public Drawable f992i9;

        /* renamed from: k5  reason: collision with root package name */
        public String f993k5;

        /* renamed from: mg  reason: collision with root package name */
        public int f994mg;

        /* renamed from: n  reason: collision with root package name */
        public int f996n;

        /* renamed from: n3  reason: collision with root package name */
        public final LayoutInflater f997n3;

        /* renamed from: p  reason: collision with root package name */
        public DialogInterface.OnClickListener f998p;

        /* renamed from: r  reason: collision with root package name */
        public DialogInterface.OnKeyListener f999r;

        /* renamed from: rz  reason: collision with root package name */
        public int f1000rz;

        /* renamed from: s  reason: collision with root package name */
        public CharSequence f1001s;

        /* renamed from: t  reason: collision with root package name */
        public CharSequence f1002t;

        /* renamed from: ta  reason: collision with root package name */
        public boolean f1003ta;

        /* renamed from: tl  reason: collision with root package name */
        public Drawable f1004tl;

        /* renamed from: v  reason: collision with root package name */
        public int f1006v;

        /* renamed from: w  reason: collision with root package name */
        public Drawable f1008w;

        /* renamed from: wz  reason: collision with root package name */
        public DialogInterface.OnClickListener f1009wz;

        /* renamed from: x  reason: collision with root package name */
        public Cursor f1010x;

        /* renamed from: x4  reason: collision with root package name */
        public CharSequence[] f1011x4;

        /* renamed from: xc  reason: collision with root package name */
        public CharSequence f1012xc;
        public final Context y;

        /* renamed from: yt  reason: collision with root package name */
        public AdapterView.OnItemSelectedListener f1013yt;

        /* renamed from: z  reason: collision with root package name */
        public DialogInterface.OnDismissListener f1014z;

        /* renamed from: z6  reason: collision with root package name */
        public boolean f1015z6;

        /* renamed from: zn  reason: collision with root package name */
        public int f1016zn;

        /* renamed from: ud  reason: collision with root package name */
        public int f1005ud = -1;

        /* renamed from: vl  reason: collision with root package name */
        public boolean f1007vl = true;

        /* renamed from: mt  reason: collision with root package name */
        public boolean f995mt = true;

        /* loaded from: classes.dex */
        public class gv implements AdapterView.OnItemClickListener {

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ AlertController f1018v;
            public final /* synthetic */ RecycleListView y;

            public gv(RecycleListView recycleListView, AlertController alertController) {
                this.y = recycleListView;
                this.f1018v = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
                boolean[] zArr = a.this.f983d;
                if (zArr != null) {
                    zArr[i] = this.y.isItemChecked(i);
                }
                a.this.f978a8.onClick(this.f1018v.f954n3, i, this.y.isItemChecked(i));
            }
        }

        /* loaded from: classes.dex */
        public class n3 extends CursorAdapter {

            /* renamed from: fb  reason: collision with root package name */
            public final /* synthetic */ RecycleListView f1020fb;

            /* renamed from: s  reason: collision with root package name */
            public final /* synthetic */ AlertController f1021s;

            /* renamed from: v  reason: collision with root package name */
            public final int f1022v;
            public final int y;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public n3(Context context, Cursor cursor, boolean z2, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z2);
                this.f1020fb = recycleListView;
                this.f1021s = alertController;
                Cursor cursor2 = getCursor();
                this.y = cursor2.getColumnIndexOrThrow(a.this.f979b);
                this.f1022v = cursor2.getColumnIndexOrThrow(a.this.f993k5);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.y));
                RecycleListView recycleListView = this.f1020fb;
                int position = cursor.getPosition();
                boolean z2 = true;
                if (cursor.getInt(this.f1022v) != 1) {
                    z2 = false;
                }
                recycleListView.setItemChecked(position, z2);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return a.this.f997n3.inflate(this.f1021s.f950k5, viewGroup, false);
            }
        }

        /* loaded from: classes.dex */
        public class y extends ArrayAdapter<CharSequence> {
            public final /* synthetic */ RecycleListView y;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public y(Context context, int i, int i5, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i, i5, charSequenceArr);
                this.y = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                boolean[] zArr = a.this.f983d;
                if (zArr != null && zArr[i]) {
                    this.y.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* loaded from: classes.dex */
        public class zn implements AdapterView.OnItemClickListener {
            public final /* synthetic */ AlertController y;

            public zn(AlertController alertController) {
                this.y = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
                a.this.f987f3.onClick(this.y.f954n3, i);
                if (!a.this.f985ej) {
                    this.y.f954n3.dismiss();
                }
            }
        }

        public a(Context context) {
            this.y = context;
            this.f997n3 = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public final void n3(AlertController alertController) {
            int i;
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f997n3.inflate(alertController.f934b, (ViewGroup) null);
            if (this.f1015z6) {
                if (this.f1010x == null) {
                    listAdapter = new y(this.y, alertController.f950k5, 16908308, this.f1011x4, recycleListView);
                } else {
                    listAdapter = new n3(this.y, this.f1010x, false, recycleListView, alertController);
                }
            } else {
                if (this.f985ej) {
                    i = alertController.f972yt;
                } else {
                    i = alertController.f966vl;
                }
                int i5 = i;
                if (this.f1010x != null) {
                    listAdapter = new SimpleCursorAdapter(this.y, i5, this.f1010x, new String[]{this.f979b}, new int[]{16908308});
                } else {
                    listAdapter = this.f991i4;
                    if (listAdapter == null) {
                        listAdapter = new s(this.y, i5, 16908308, this.f1011x4);
                    }
                }
            }
            alertController.f940ej = listAdapter;
            alertController.f964ud = this.f1005ud;
            if (this.f987f3 != null) {
                recycleListView.setOnItemClickListener(new zn(alertController));
            } else if (this.f978a8 != null) {
                recycleListView.setOnItemClickListener(new gv(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1013yt;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.f985ej) {
                recycleListView.setChoiceMode(1);
            } else if (this.f1015z6) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f943fb = recycleListView;
        }

        public void y(AlertController alertController) {
            View view = this.f988fb;
            if (view != null) {
                alertController.t(view);
            } else {
                CharSequence charSequence = this.f977a;
                if (charSequence != null) {
                    alertController.p(charSequence);
                }
                Drawable drawable = this.f990gv;
                if (drawable != null) {
                    alertController.wz(drawable);
                }
                int i = this.f1016zn;
                if (i != 0) {
                    alertController.tl(i);
                }
                int i5 = this.f1006v;
                if (i5 != 0) {
                    alertController.tl(alertController.zn(i5));
                }
            }
            CharSequence charSequence2 = this.f1001s;
            if (charSequence2 != null) {
                alertController.xc(charSequence2);
            }
            CharSequence charSequence3 = this.f981c5;
            if (charSequence3 != null || this.f992i9 != null) {
                alertController.f(-1, charSequence3, this.f986f, null, this.f992i9);
            }
            CharSequence charSequence4 = this.f1002t;
            if (charSequence4 != null || this.f1004tl != null) {
                alertController.f(-2, charSequence4, this.f1009wz, null, this.f1004tl);
            }
            CharSequence charSequence5 = this.f1012xc;
            if (charSequence5 != null || this.f1008w != null) {
                alertController.f(-3, charSequence5, this.f998p, null, this.f1008w);
            }
            if (this.f1011x4 != null || this.f1010x != null || this.f991i4 != null) {
                n3(alertController);
            }
            View view2 = this.f980c;
            if (view2 != null) {
                if (this.f1003ta) {
                    alertController.z(view2, this.f984d0, this.f989fh, this.f1000rz, this.f994mg);
                    return;
                } else {
                    alertController.co(view2);
                    return;
                }
            }
            int i6 = this.f996n;
            if (i6 != 0) {
                alertController.mt(i6);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class fb extends Handler {
        public WeakReference<DialogInterface> y;

        public fb(DialogInterface dialogInterface) {
            this.y = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != -3 && i != -2 && i != -1) {
                if (i == 1) {
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
                return;
            }
            ((DialogInterface.OnClickListener) message.obj).onClick(this.y.get(), message.what);
        }
    }

    /* loaded from: classes.dex */
    public class gv implements AbsListView.OnScrollListener {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ View f1025n3;
        public final /* synthetic */ View y;

        public gv(View view, View view2) {
            this.y = view;
            this.f1025n3 = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i5, int i6) {
            AlertController.a(absListView, this.y, this.f1025n3);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements NestedScrollView.zn {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ View f1027n3;
        public final /* synthetic */ View y;

        public n3(View view, View view2) {
            this.y = view;
            this.f1027n3 = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.zn
        public void y(NestedScrollView nestedScrollView, int i, int i5, int i6, int i8) {
            AlertController.a(nestedScrollView, this.y, this.f1027n3);
        }
    }

    /* loaded from: classes.dex */
    public static class s extends ArrayAdapter<CharSequence> {
        public s(Context context, int i, int i5, CharSequence[] charSequenceArr) {
            super(context, i, i5, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class v implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ View f1030v;
        public final /* synthetic */ View y;

        public v(View view, View view2) {
            this.y = view;
            this.f1030v = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.a(AlertController.this.f943fb, this.y, this.f1030v);
        }
    }

    /* loaded from: classes.dex */
    public class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.f971xc && (message4 = alertController.f956p) != null) {
                message = Message.obtain(message4);
            } else if (view == alertController.f937co && (message3 = alertController.f958r) != null) {
                message = Message.obtain(message3);
            } else if (view == alertController.f947i4 && (message2 = alertController.f953n) != null) {
                message = Message.obtain(message2);
            } else {
                message = null;
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f957qn.obtainMessage(1, alertController2.f954n3).sendToTarget();
        }
    }

    /* loaded from: classes.dex */
    public class zn implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ View f1032v;
        public final /* synthetic */ View y;

        public zn(View view, View view2) {
            this.y = view;
            this.f1032v = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.a(AlertController.this.f939d0, this.y, this.f1032v);
        }
    }

    public AlertController(Context context, s.a aVar, Window window) {
        this.y = context;
        this.f954n3 = aVar;
        this.f975zn = window;
        this.f957qn = new fb(aVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.f822d, R$attr.f657wz, 0);
        this.f933a8 = obtainStyledAttributes.getResourceId(R$styleable.f930z6, 0);
        this.f969x = obtainStyledAttributes.getResourceId(R$styleable.f904ud, 0);
        this.f934b = obtainStyledAttributes.getResourceId(R$styleable.f917x, 0);
        this.f950k5 = obtainStyledAttributes.getResourceId(R$styleable.f811b, 0);
        this.f972yt = obtainStyledAttributes.getResourceId(R$styleable.f928yt, 0);
        this.f966vl = obtainStyledAttributes.getResourceId(R$styleable.f807a8, 0);
        this.f946hw = obtainStyledAttributes.getBoolean(R$styleable.f856k5, true);
        this.f945gv = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f831ej, 0);
        obtainStyledAttributes.recycle();
        aVar.gv(1);
    }

    public static void a(View view, View view2, View view3) {
        int i;
        int i5 = 4;
        if (view2 != null) {
            if (view.canScrollVertically(-1)) {
                i = 0;
            } else {
                i = 4;
            }
            view2.setVisibility(i);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1)) {
                i5 = 0;
            }
            view3.setVisibility(i5);
        }
    }

    public static boolean c(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.f652tl, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public static boolean y(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (y(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final ViewGroup c5(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public void co(View view) {
        this.f960s = view;
        this.f936c5 = 0;
        this.f968wz = false;
    }

    public void f(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f957qn.obtainMessage(i, onClickListener);
        }
        if (i != -3) {
            if (i != -2) {
                if (i == -1) {
                    this.f967w = charSequence;
                    this.f956p = message;
                    this.f952mt = drawable;
                    return;
                }
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f973z = charSequence;
            this.f958r = message;
            this.f970x4 = drawable;
            return;
        }
        this.f942f3 = charSequence;
        this.f953n = message;
        this.f935c = drawable;
    }

    public final void f3(ViewGroup viewGroup) {
        if (this.f974z6 != null) {
            viewGroup.addView(this.f974z6, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f975zn.findViewById(R$id.f761vl).setVisibility(8);
            return;
        }
        this.f951mg = (ImageView) this.f975zn.findViewById(16908294);
        if (!TextUtils.isEmpty(this.f965v) && this.f946hw) {
            TextView textView = (TextView) this.f975zn.findViewById(R$id.f746i9);
            this.f962ta = textView;
            textView.setText(this.f965v);
            int i = this.f944fh;
            if (i != 0) {
                this.f951mg.setImageResource(i);
                return;
            }
            Drawable drawable = this.f959rz;
            if (drawable != null) {
                this.f951mg.setImageDrawable(drawable);
                return;
            }
            this.f962ta.setPadding(this.f951mg.getPaddingLeft(), this.f951mg.getPaddingTop(), this.f951mg.getPaddingRight(), this.f951mg.getPaddingBottom());
            this.f951mg.setVisibility(8);
            return;
        }
        this.f975zn.findViewById(R$id.f761vl).setVisibility(8);
        this.f951mg.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    public boolean fb(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f939d0;
        if (nestedScrollView != null && nestedScrollView.co(keyEvent)) {
            return true;
        }
        return false;
    }

    public ListView gv() {
        return this.f943fb;
    }

    public final void i4(ViewGroup viewGroup) {
        View view = this.f960s;
        boolean z2 = false;
        if (view == null) {
            if (this.f936c5 != 0) {
                view = LayoutInflater.from(this.y).inflate(this.f936c5, viewGroup, false);
            } else {
                view = null;
            }
        }
        if (view != null) {
            z2 = true;
        }
        if (!z2 || !y(view)) {
            this.f975zn.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) this.f975zn.findViewById(R$id.f763wz);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f968wz) {
                frameLayout.setPadding(this.f948i9, this.f941f, this.f961t, this.f963tl);
            }
            if (this.f943fb != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.y) viewGroup.getLayoutParams())).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final int i9() {
        int i = this.f969x;
        if (i == 0) {
            return this.f933a8;
        }
        if (this.f949j5 == 1) {
            return i;
        }
        return this.f933a8;
    }

    public void mt(int i) {
        this.f960s = null;
        this.f936c5 = i;
        this.f968wz = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n() {
        boolean z2;
        boolean z3;
        boolean z4;
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3;
        View findViewById4 = this.f975zn.findViewById(R$id.f768z);
        int i = R$id.f744hw;
        View findViewById5 = findViewById4.findViewById(i);
        int i5 = R$id.f758tl;
        View findViewById6 = findViewById4.findViewById(i5);
        int i6 = R$id.f739f;
        View findViewById7 = findViewById4.findViewById(i6);
        ViewGroup viewGroup = (ViewGroup) findViewById4.findViewById(R$id.f766xc);
        i4(viewGroup);
        View findViewById8 = viewGroup.findViewById(i);
        View findViewById9 = viewGroup.findViewById(i5);
        View findViewById10 = viewGroup.findViewById(i6);
        ViewGroup c52 = c5(findViewById8, findViewById5);
        ViewGroup c53 = c5(findViewById9, findViewById6);
        ViewGroup c54 = c5(findViewById10, findViewById7);
        x4(c53);
        r(c54);
        f3(c52);
        int i8 = 0;
        if (viewGroup.getVisibility() != 8) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (c52 != null && c52.getVisibility() != 8) {
            z3 = 1;
        } else {
            z3 = 0;
        }
        if (c54 != null && c54.getVisibility() != 8) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4 && c53 != null && (findViewById3 = c53.findViewById(R$id.f764x)) != null) {
            findViewById3.setVisibility(0);
        }
        if (z3) {
            NestedScrollView nestedScrollView = this.f939d0;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            if (this.f932a == null && this.f943fb == null) {
                findViewById2 = null;
            } else {
                findViewById2 = c52.findViewById(R$id.f767yt);
            }
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        } else if (c53 != null && (findViewById = c53.findViewById(R$id.f732b)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f943fb;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).y(z3, z4);
        }
        if (!z2) {
            View view = this.f943fb;
            if (view == null) {
                view = this.f939d0;
            }
            if (view != null) {
                if (z4) {
                    i8 = 2;
                }
                w(c53, view, z3 | i8, 3);
            }
        }
        ListView listView2 = this.f943fb;
        if (listView2 != null && (listAdapter = this.f940ej) != null) {
            listView2.setAdapter(listAdapter);
            int i10 = this.f964ud;
            if (i10 > -1) {
                listView2.setItemChecked(i10, true);
                listView2.setSelection(i10);
            }
        }
    }

    public final void n3(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public void p(CharSequence charSequence) {
        this.f965v = charSequence;
        TextView textView = this.f962ta;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void r(ViewGroup viewGroup) {
        boolean z2;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f971xc = button;
        button.setOnClickListener(this.f955o);
        if (TextUtils.isEmpty(this.f967w) && this.f952mt == null) {
            this.f971xc.setVisibility(8);
            z2 = false;
        } else {
            this.f971xc.setText(this.f967w);
            Drawable drawable = this.f952mt;
            if (drawable != null) {
                int i = this.f945gv;
                drawable.setBounds(0, 0, i, i);
                this.f971xc.setCompoundDrawables(this.f952mt, null, null, null);
            }
            this.f971xc.setVisibility(0);
            z2 = true;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f937co = button2;
        button2.setOnClickListener(this.f955o);
        if (TextUtils.isEmpty(this.f973z) && this.f970x4 == null) {
            this.f937co.setVisibility(8);
        } else {
            this.f937co.setText(this.f973z);
            Drawable drawable2 = this.f970x4;
            if (drawable2 != null) {
                int i5 = this.f945gv;
                drawable2.setBounds(0, 0, i5, i5);
                this.f937co.setCompoundDrawables(this.f970x4, null, null, null);
            }
            this.f937co.setVisibility(0);
            z2 |= true;
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.f947i4 = button3;
        button3.setOnClickListener(this.f955o);
        if (TextUtils.isEmpty(this.f942f3) && this.f935c == null) {
            this.f947i4.setVisibility(8);
        } else {
            this.f947i4.setText(this.f942f3);
            Drawable drawable3 = this.f935c;
            if (drawable3 != null) {
                int i6 = this.f945gv;
                drawable3.setBounds(0, 0, i6, i6);
                this.f947i4.setCompoundDrawables(this.f935c, null, null, null);
            }
            this.f947i4.setVisibility(0);
            z2 |= true;
        }
        if (c(this.y)) {
            if (z2) {
                n3(this.f971xc);
            } else if (z2) {
                n3(this.f937co);
            } else if (z2) {
                n3(this.f947i4);
            }
        }
        if (!z2) {
            viewGroup.setVisibility(8);
        }
    }

    public boolean s(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f939d0;
        if (nestedScrollView != null && nestedScrollView.co(keyEvent)) {
            return true;
        }
        return false;
    }

    public void t(View view) {
        this.f974z6 = view;
    }

    public void tl(int i) {
        this.f959rz = null;
        this.f944fh = i;
        ImageView imageView = this.f951mg;
        if (imageView != null) {
            if (i != 0) {
                imageView.setVisibility(0);
                this.f951mg.setImageResource(this.f944fh);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public void v() {
        this.f954n3.setContentView(i9());
        n();
    }

    public final void w(ViewGroup viewGroup, View view, int i, int i5) {
        View findViewById = this.f975zn.findViewById(R$id.f765x4);
        View findViewById2 = this.f975zn.findViewById(R$id.f753r);
        if (Build.VERSION.SDK_INT >= 23) {
            i4.qj(view, i, i5);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.f932a != null) {
                this.f939d0.setOnScrollChangeListener(new n3(findViewById, findViewById2));
                this.f939d0.post(new zn(findViewById, findViewById2));
                return;
            }
            ListView listView = this.f943fb;
            if (listView != null) {
                listView.setOnScrollListener(new gv(findViewById, findViewById2));
                this.f943fb.post(new v(findViewById, findViewById2));
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    public void wz(Drawable drawable) {
        this.f959rz = drawable;
        this.f944fh = 0;
        ImageView imageView = this.f951mg;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.f951mg.setImageDrawable(drawable);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public final void x4(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f975zn.findViewById(R$id.f745i4);
        this.f939d0 = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f939d0.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.f938d = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f932a;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f939d0.removeView(this.f938d);
        if (this.f943fb != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f939d0.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.f939d0);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.f943fb, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void xc(CharSequence charSequence) {
        this.f932a = charSequence;
        TextView textView = this.f938d;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void z(View view, int i, int i5, int i6, int i8) {
        this.f960s = view;
        this.f936c5 = 0;
        this.f968wz = true;
        this.f948i9 = i;
        this.f941f = i5;
        this.f961t = i6;
        this.f963tl = i8;
    }

    public int zn(int i) {
        TypedValue typedValue = new TypedValue();
        this.y.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }
}
