package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import qg.f;
/* loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public final int f5627f;
    @NonNull

    /* renamed from: fb  reason: collision with root package name */
    public final DateValidator f5628fb;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public Month f5629s;

    /* renamed from: t  reason: collision with root package name */
    public final int f5630t;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public final Month f5631v;
    @NonNull
    public final Month y;

    /* loaded from: classes.dex */
    public interface DateValidator extends Parcelable {
        boolean b(long j2);
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public DateValidator f5634gv;

        /* renamed from: n3  reason: collision with root package name */
        public long f5635n3;
        public long y;

        /* renamed from: zn  reason: collision with root package name */
        public Long f5636zn;

        /* renamed from: v  reason: collision with root package name */
        public static final long f5633v = f.y(Month.n3(1900, 0).f5642t);

        /* renamed from: a  reason: collision with root package name */
        public static final long f5632a = f.y(Month.n3(2100, 11).f5642t);

        public n3(@NonNull CalendarConstraints calendarConstraints) {
            this.y = f5633v;
            this.f5635n3 = f5632a;
            this.f5634gv = DateValidatorPointForward.y(Long.MIN_VALUE);
            this.y = calendarConstraints.y.f5642t;
            this.f5635n3 = calendarConstraints.f5631v.f5642t;
            this.f5636zn = Long.valueOf(calendarConstraints.f5629s.f5642t);
            this.f5634gv = calendarConstraints.f5628fb;
        }

        @NonNull
        public n3 n3(long j2) {
            this.f5636zn = Long.valueOf(j2);
            return this;
        }

        @NonNull
        public CalendarConstraints y() {
            Month zn2;
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f5634gv);
            Month zn3 = Month.zn(this.y);
            Month zn4 = Month.zn(this.f5635n3);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l2 = this.f5636zn;
            if (l2 == null) {
                zn2 = null;
            } else {
                zn2 = Month.zn(l2.longValue());
            }
            return new CalendarConstraints(zn3, zn4, dateValidator, zn2, null);
        }
    }

    /* loaded from: classes.dex */
    public static class y implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: n3 */
        public CalendarConstraints[] newArray(int i) {
            return new CalendarConstraints[i];
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: y */
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }
    }

    public /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, y yVar) {
        this(month, month2, dateValidator, month3);
    }

    public int c5() {
        return this.f5630t;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (this.y.equals(calendarConstraints.y) && this.f5631v.equals(calendarConstraints.f5631v) && vl.zn.y(this.f5629s, calendarConstraints.f5629s) && this.f5628fb.equals(calendarConstraints.f5628fb)) {
            return true;
        }
        return false;
    }

    @NonNull
    public Month f() {
        return this.y;
    }

    public DateValidator fb() {
        return this.f5628fb;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.y, this.f5631v, this.f5629s, this.f5628fb});
    }

    @Nullable
    public Month i9() {
        return this.f5629s;
    }

    @NonNull
    public Month s() {
        return this.f5631v;
    }

    public int t() {
        return this.f5627f;
    }

    public Month v(Month month) {
        if (month.compareTo(this.y) < 0) {
            return this.y;
        }
        if (month.compareTo(this.f5631v) > 0) {
            return this.f5631v;
        }
        return month;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.y, 0);
        parcel.writeParcelable(this.f5631v, 0);
        parcel.writeParcelable(this.f5629s, 0);
        parcel.writeParcelable(this.f5628fb, 0);
    }

    public CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3) {
        this.y = month;
        this.f5631v = month2;
        this.f5629s = month3;
        this.f5628fb = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f5630t = month.t(month2) + 1;
        this.f5627f = (month2.f5640fb - month.f5640fb) + 1;
    }
}
