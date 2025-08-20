package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import d1.gv;
import m1.m;
import m1.qk;
/* loaded from: classes.dex */
public final class SmtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<SmtaMetadataEntry> CREATOR = new y();

    /* renamed from: v  reason: collision with root package name */
    public final int f4290v;
    public final float y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<SmtaMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public SmtaMetadataEntry[] newArray(int i) {
            return new SmtaMetadataEntry[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public SmtaMetadataEntry createFromParcel(Parcel parcel) {
            return new SmtaMetadataEntry(parcel, (y) null);
        }
    }

    public /* synthetic */ SmtaMetadataEntry(Parcel parcel, y yVar) {
        this(parcel);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ m co() {
        return hd.y.n3(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SmtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
        if (this.y == smtaMetadataEntry.y && this.f4290v == smtaMetadataEntry.f4290v) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + gv.y(this.y)) * 31) + this.f4290v;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void m(qk.n3 n3Var) {
        hd.y.zn(this, n3Var);
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.y + ", svcTemporalLayerCount=" + this.f4290v;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] w2() {
        return hd.y.y(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.y);
        parcel.writeInt(this.f4290v);
    }

    public SmtaMetadataEntry(float f4, int i) {
        this.y = f4;
        this.f4290v = i;
    }

    public SmtaMetadataEntry(Parcel parcel) {
        this.y = parcel.readFloat();
        this.f4290v = parcel.readInt();
    }
}
