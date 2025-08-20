package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import m1.m;
import m1.qk;
import v5.j5;
/* loaded from: classes.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new y();

    /* renamed from: fb  reason: collision with root package name */
    public final int f4280fb;

    /* renamed from: s  reason: collision with root package name */
    public final int f4281s;

    /* renamed from: v  reason: collision with root package name */
    public final byte[] f4282v;
    public final String y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<MdtaMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public MdtaMetadataEntry[] newArray(int i) {
            return new MdtaMetadataEntry[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel, null);
        }
    }

    public /* synthetic */ MdtaMetadataEntry(Parcel parcel, y yVar) {
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
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        if (this.y.equals(mdtaMetadataEntry.y) && Arrays.equals(this.f4282v, mdtaMetadataEntry.f4282v) && this.f4280fb == mdtaMetadataEntry.f4280fb && this.f4281s == mdtaMetadataEntry.f4281s) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.y.hashCode()) * 31) + Arrays.hashCode(this.f4282v)) * 31) + this.f4280fb) * 31) + this.f4281s;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void m(qk.n3 n3Var) {
        hd.y.zn(this, n3Var);
    }

    public String toString() {
        return "mdta: key=" + this.y;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] w2() {
        return hd.y.y(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.y);
        parcel.writeByteArray(this.f4282v);
        parcel.writeInt(this.f4280fb);
        parcel.writeInt(this.f4281s);
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i, int i5) {
        this.y = str;
        this.f4282v = bArr;
        this.f4280fb = i;
        this.f4281s = i5;
    }

    public MdtaMetadataEntry(Parcel parcel) {
        this.y = (String) j5.i9(parcel.readString());
        this.f4282v = (byte[]) j5.i9(parcel.createByteArray());
        this.f4280fb = parcel.readInt();
        this.f4281s = parcel.readInt();
    }
}
