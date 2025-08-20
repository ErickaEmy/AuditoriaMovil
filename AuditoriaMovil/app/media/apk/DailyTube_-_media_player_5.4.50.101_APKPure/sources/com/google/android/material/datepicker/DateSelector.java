package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import qg.fb;
/* loaded from: classes.dex */
public interface DateSelector<S> extends Parcelable {
    @NonNull
    Collection<Long> ad();

    @NonNull
    String dm(Context context);

    @NonNull
    View j5(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull CalendarConstraints calendarConstraints, @NonNull fb<S> fbVar);

    int k5(Context context);

    @NonNull
    Collection<vl.gv<Long, Long>> o4();

    boolean pq();

    @Nullable
    S qj();

    void x5(long j2);
}
