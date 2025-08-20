package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import m1.qk;
import v5.j5;
/* loaded from: classes.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f4242f;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final String f4243fb;

    /* renamed from: s  reason: collision with root package name */
    public final int f4244s;

    /* renamed from: v  reason: collision with root package name */
    public final String f4245v;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<ApicFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public ApicFrame[] newArray(int i) {
            return new ApicFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }
    }

    public ApicFrame(String str, @Nullable String str2, int i, byte[] bArr) {
        super("APIC");
        this.f4245v = str;
        this.f4243fb = str2;
        this.f4244s = i;
        this.f4242f = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        if (this.f4244s == apicFrame.f4244s && j5.zn(this.f4245v, apicFrame.f4245v) && j5.zn(this.f4243fb, apicFrame.f4243fb) && Arrays.equals(this.f4242f, apicFrame.f4242f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i5 = (527 + this.f4244s) * 31;
        String str = this.f4245v;
        int i6 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i8 = (i5 + i) * 31;
        String str2 = this.f4243fb;
        if (str2 != null) {
            i6 = str2.hashCode();
        }
        return ((i8 + i6) * 31) + Arrays.hashCode(this.f4242f);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, com.google.android.exoplayer2.metadata.Metadata.Entry
    public void m(qk.n3 n3Var) {
        n3Var.ud(this.f4242f, this.f4244s);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.y + ": mimeType=" + this.f4245v + ", description=" + this.f4243fb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4245v);
        parcel.writeString(this.f4243fb);
        parcel.writeInt(this.f4244s);
        parcel.writeByteArray(this.f4242f);
    }

    public ApicFrame(Parcel parcel) {
        super("APIC");
        this.f4245v = (String) j5.i9(parcel.readString());
        this.f4243fb = parcel.readString();
        this.f4244s = parcel.readInt();
        this.f4242f = (byte[]) j5.i9(parcel.createByteArray());
    }
}
