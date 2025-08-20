package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;
/* loaded from: classes.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new y();
    public final long y;

    /* loaded from: classes.dex */
    public static class y implements Parcelable.Creator<DateValidatorPointForward> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: n3 */
        public DateValidatorPointForward[] newArray(int i) {
            return new DateValidatorPointForward[i];
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: y */
        public DateValidatorPointForward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }
    }

    public /* synthetic */ DateValidatorPointForward(long j2, y yVar) {
        this(j2);
    }

    @NonNull
    public static DateValidatorPointForward y(long j2) {
        return new DateValidatorPointForward(j2);
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean b(long j2) {
        if (j2 >= this.y) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DateValidatorPointForward) && this.y == ((DateValidatorPointForward) obj).y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.y)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(this.y);
    }

    public DateValidatorPointForward(long j2) {
        this.y = j2;
    }
}
