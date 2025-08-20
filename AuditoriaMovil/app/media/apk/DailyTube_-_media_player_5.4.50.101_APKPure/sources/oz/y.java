package oz;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import oz.n3;
/* loaded from: classes.dex */
public abstract class y extends BaseAdapter implements Filterable, n3.y {

    /* renamed from: f  reason: collision with root package name */
    public int f12358f;

    /* renamed from: fb  reason: collision with root package name */
    public Cursor f12359fb;

    /* renamed from: p  reason: collision with root package name */
    public oz.n3 f12360p;

    /* renamed from: s  reason: collision with root package name */
    public Context f12361s;

    /* renamed from: t  reason: collision with root package name */
    public C0178y f12362t;

    /* renamed from: v  reason: collision with root package name */
    public boolean f12363v;

    /* renamed from: w  reason: collision with root package name */
    public DataSetObserver f12364w;
    public boolean y;

    /* loaded from: classes.dex */
    public class n3 extends DataSetObserver {
        public n3() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            y yVar = y.this;
            yVar.y = true;
            yVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            y yVar = y.this;
            yVar.y = false;
            yVar.notifyDataSetInvalidated();
        }
    }

    /* renamed from: oz.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0178y extends ContentObserver {
        public C0178y() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            y.this.c5();
        }
    }

    public y(Context context, Cursor cursor, boolean z2) {
        int i;
        if (z2) {
            i = 1;
        } else {
            i = 2;
        }
        a(context, cursor, i);
    }

    public void a(Context context, Cursor cursor, int i) {
        int i5;
        boolean z2 = false;
        if ((i & 1) == 1) {
            i |= 2;
            this.f12363v = true;
        } else {
            this.f12363v = false;
        }
        if (cursor != null) {
            z2 = true;
        }
        this.f12359fb = cursor;
        this.y = z2;
        this.f12361s = context;
        if (z2) {
            i5 = cursor.getColumnIndexOrThrow("_id");
        } else {
            i5 = -1;
        }
        this.f12358f = i5;
        if ((i & 2) == 2) {
            this.f12362t = new C0178y();
            this.f12364w = new n3();
        } else {
            this.f12362t = null;
            this.f12364w = null;
        }
        if (z2) {
            C0178y c0178y = this.f12362t;
            if (c0178y != null) {
                cursor.registerContentObserver(c0178y);
            }
            DataSetObserver dataSetObserver = this.f12364w;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public void c5() {
        Cursor cursor;
        if (this.f12363v && (cursor = this.f12359fb) != null && !cursor.isClosed()) {
            this.y = this.f12359fb.requery();
        }
    }

    public abstract View fb(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (this.y && (cursor = this.f12359fb) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.y) {
            this.f12359fb.moveToPosition(i);
            if (view == null) {
                view = fb(this.f12361s, this.f12359fb, viewGroup);
            }
            v(view, this.f12361s, this.f12359fb);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f12360p == null) {
            this.f12360p = new oz.n3(this);
        }
        return this.f12360p;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (this.y && (cursor = this.f12359fb) != null) {
            cursor.moveToPosition(i);
            return this.f12359fb;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (!this.y || (cursor = this.f12359fb) == null || !cursor.moveToPosition(i)) {
            return 0L;
        }
        return this.f12359fb.getLong(this.f12358f);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.y) {
            if (this.f12359fb.moveToPosition(i)) {
                if (view == null) {
                    view = s(this.f12361s, this.f12359fb, viewGroup);
                }
                v(view, this.f12361s, this.f12359fb);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    @Override // oz.n3.y
    public Cursor gv() {
        return this.f12359fb;
    }

    public Cursor i9(Cursor cursor) {
        Cursor cursor2 = this.f12359fb;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0178y c0178y = this.f12362t;
            if (c0178y != null) {
                cursor2.unregisterContentObserver(c0178y);
            }
            DataSetObserver dataSetObserver = this.f12364w;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f12359fb = cursor;
        if (cursor != null) {
            C0178y c0178y2 = this.f12362t;
            if (c0178y2 != null) {
                cursor.registerContentObserver(c0178y2);
            }
            DataSetObserver dataSetObserver2 = this.f12364w;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f12358f = cursor.getColumnIndexOrThrow("_id");
            this.y = true;
            notifyDataSetChanged();
        } else {
            this.f12358f = -1;
            this.y = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    @Override // oz.n3.y
    public abstract CharSequence n3(Cursor cursor);

    public abstract View s(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void v(View view, Context context, Cursor cursor);

    @Override // oz.n3.y
    public void y(Cursor cursor) {
        Cursor i92 = i9(cursor);
        if (i92 != null) {
            i92.close();
        }
    }
}
