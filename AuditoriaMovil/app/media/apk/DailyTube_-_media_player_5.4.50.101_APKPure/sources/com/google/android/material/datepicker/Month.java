package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import qg.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public final int f5639f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f5640fb;

    /* renamed from: s  reason: collision with root package name */
    public final int f5641s;

    /* renamed from: t  reason: collision with root package name */
    public final long f5642t;

    /* renamed from: v  reason: collision with root package name */
    public final int f5643v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public String f5644w;
    @NonNull
    public final Calendar y;

    /* loaded from: classes.dex */
    public static class y implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: n3 */
        public Month[] newArray(int i) {
            return new Month[i];
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: y */
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.n3(parcel.readInt(), parcel.readInt());
        }
    }

    public Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar gv2 = f.gv(calendar);
        this.y = gv2;
        this.f5643v = gv2.get(2);
        this.f5640fb = gv2.get(1);
        this.f5641s = gv2.getMaximum(7);
        this.f5639f = gv2.getActualMaximum(5);
        this.f5642t = gv2.getTimeInMillis();
    }

    @NonNull
    public static Month gv() {
        return new Month(f.c5());
    }

    @NonNull
    public static Month n3(int i, int i5) {
        Calendar f4 = f.f();
        f4.set(1, i);
        f4.set(2, i5);
        return new Month(f4);
    }

    @NonNull
    public static Month zn(long j2) {
        Calendar f4 = f.f();
        f4.setTimeInMillis(j2);
        return new Month(f4);
    }

    public long a(int i) {
        Calendar gv2 = f.gv(this.y);
        gv2.set(5, i);
        return gv2.getTimeInMillis();
    }

    public long c5() {
        return this.y.getTimeInMillis();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.f5643v == month.f5643v && this.f5640fb == month.f5640fb) {
            return true;
        }
        return false;
    }

    @NonNull
    public Month f(int i) {
        Calendar gv2 = f.gv(this.y);
        gv2.add(2, i);
        return new Month(gv2);
    }

    public int fb(long j2) {
        Calendar gv2 = f.gv(this.y);
        gv2.setTimeInMillis(j2);
        return gv2.get(5);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5643v), Integer.valueOf(this.f5640fb)});
    }

    @NonNull
    public String s(Context context) {
        if (this.f5644w == null) {
            this.f5644w = qg.zn.zn(context, this.y.getTimeInMillis());
        }
        return this.f5644w;
    }

    public int t(@NonNull Month month) {
        if (this.y instanceof GregorianCalendar) {
            return ((month.f5640fb - this.f5640fb) * 12) + (month.f5643v - this.f5643v);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public int v() {
        int firstDayOfWeek = this.y.get(7) - this.y.getFirstDayOfWeek();
        if (firstDayOfWeek < 0) {
            return firstDayOfWeek + this.f5641s;
        }
        return firstDayOfWeek;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.f5640fb);
        parcel.writeInt(this.f5643v);
    }

    @Override // java.lang.Comparable
    /* renamed from: y */
    public int compareTo(@NonNull Month month) {
        return this.y.compareTo(month.y);
    }
}
