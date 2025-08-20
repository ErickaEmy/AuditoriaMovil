package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import m1.m;
import m1.qk;
/* loaded from: classes.dex */
public final class AppInfoTable implements Metadata.Entry {
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new y();

    /* renamed from: v  reason: collision with root package name */
    public final String f4219v;
    public final int y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<AppInfoTable> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public AppInfoTable[] newArray(int i) {
            return new AppInfoTable[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public AppInfoTable createFromParcel(Parcel parcel) {
            return new AppInfoTable(parcel.readInt(), (String) v5.y.v(parcel.readString()));
        }
    }

    public AppInfoTable(int i, String str) {
        this.y = i;
        this.f4219v = str;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ m co() {
        return hd.y.n3(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void m(qk.n3 n3Var) {
        hd.y.zn(this, n3Var);
    }

    public String toString() {
        return "Ait(controlCode=" + this.y + ",url=" + this.f4219v + ")";
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] w2() {
        return hd.y.y(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4219v);
        parcel.writeInt(this.y);
    }
}
