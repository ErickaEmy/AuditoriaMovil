package qg;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes.dex */
public class gv extends BaseAdapter {

    /* renamed from: s  reason: collision with root package name */
    public static final int f12815s;

    /* renamed from: fb  reason: collision with root package name */
    public final int f12816fb;

    /* renamed from: v  reason: collision with root package name */
    public final int f12817v;
    @NonNull
    public final Calendar y;

    static {
        int i;
        if (Build.VERSION.SDK_INT >= 26) {
            i = 4;
        } else {
            i = 1;
        }
        f12815s = i;
    }

    public gv() {
        Calendar f4 = f.f();
        this.y = f4;
        this.f12817v = f4.getMaximum(7);
        this.f12816fb = f4.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f12817v;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.wb, viewGroup, false);
        }
        this.y.set(7, n3(i));
        textView.setText(this.y.getDisplayName(7, f12815s, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.flm), this.y.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public final int n3(int i) {
        int i5 = i + this.f12816fb;
        int i6 = this.f12817v;
        if (i5 > i6) {
            return i5 - i6;
        }
        return i5;
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: y */
    public Integer getItem(int i) {
        if (i >= this.f12817v) {
            return null;
        }
        return Integer.valueOf(n3(i));
    }
}
