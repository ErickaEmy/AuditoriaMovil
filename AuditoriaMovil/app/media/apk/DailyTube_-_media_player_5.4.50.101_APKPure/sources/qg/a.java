package qg;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a<S> extends s<S> {

    /* renamed from: co  reason: collision with root package name */
    public int f12811co;
    @Nullable

    /* renamed from: d0  reason: collision with root package name */
    public CalendarConstraints f12812d0;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public DateSelector<S> f12813f3;

    /* loaded from: classes.dex */
    public class y extends fb<S> {
        public y() {
        }

        @Override // qg.fb
        public void y(S s2) {
            Iterator<fb<S>> it = a.this.f12827fb.iterator();
            while (it.hasNext()) {
                it.next().y(s2);
            }
        }
    }

    @NonNull
    public static <T> a<T> gd(DateSelector<T> dateSelector, int i, @NonNull CalendarConstraints calendarConstraints) {
        a<T> aVar = new a<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f12811co = bundle.getInt("THEME_RES_ID_KEY");
        this.f12813f3 = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f12812d0 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.f12813f3.j5(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f12811co)), viewGroup, bundle, this.f12812d0, new y());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f12811co);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f12813f3);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f12812d0);
    }
}
