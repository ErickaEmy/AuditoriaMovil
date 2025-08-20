package oz;

import android.database.Cursor;
import android.widget.Filter;
/* loaded from: classes.dex */
public class n3 extends Filter {
    public y y;

    /* loaded from: classes.dex */
    public interface y {
        Cursor gv();

        CharSequence n3(Cursor cursor);

        void y(Cursor cursor);

        Cursor zn(CharSequence charSequence);
    }

    public n3(y yVar) {
        this.y = yVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.y.n3((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor zn2 = this.y.zn(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (zn2 != null) {
            filterResults.count = zn2.getCount();
            filterResults.values = zn2;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor gv2 = this.y.gv();
        Object obj = filterResults.values;
        if (obj != null && obj != gv2) {
            this.y.y((Cursor) obj);
        }
    }
}
