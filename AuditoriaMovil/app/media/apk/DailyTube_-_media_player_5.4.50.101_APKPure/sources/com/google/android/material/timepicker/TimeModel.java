package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public int f6114f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f6115fb;

    /* renamed from: s  reason: collision with root package name */
    public int f6116s;

    /* renamed from: t  reason: collision with root package name */
    public int f6117t;

    /* renamed from: v  reason: collision with root package name */
    public final e0.y f6118v;

    /* renamed from: w  reason: collision with root package name */
    public int f6119w;
    public final e0.y y;

    /* loaded from: classes.dex */
    public static class y implements Parcelable.Creator<TimeModel> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public TimeModel[] newArray(int i) {
            return new TimeModel[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }
    }

    public TimeModel() {
        this(0);
    }

    public static String n3(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public static String y(Resources resources, CharSequence charSequence) {
        return n3(resources, charSequence, "%02d");
    }

    public static int zn(int i) {
        return i >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        if (this.f6116s == timeModel.f6116s && this.f6114f == timeModel.f6114f && this.f6115fb == timeModel.f6115fb && this.f6117t == timeModel.f6117t) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6115fb), Integer.valueOf(this.f6116s), Integer.valueOf(this.f6114f), Integer.valueOf(this.f6117t)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6116s);
        parcel.writeInt(this.f6114f);
        parcel.writeInt(this.f6117t);
        parcel.writeInt(this.f6115fb);
    }

    public TimeModel(int i) {
        this(0, 0, 10, i);
    }

    public TimeModel(int i, int i5, int i6, int i8) {
        this.f6116s = i;
        this.f6114f = i5;
        this.f6117t = i6;
        this.f6115fb = i8;
        this.f6119w = zn(i);
        this.y = new e0.y(59);
        this.f6118v = new e0.y(i8 == 1 ? 24 : 12);
    }

    public TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
