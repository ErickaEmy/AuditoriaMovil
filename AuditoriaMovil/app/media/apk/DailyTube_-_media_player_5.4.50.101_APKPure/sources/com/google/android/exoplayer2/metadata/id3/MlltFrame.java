package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import v5.j5;
/* loaded from: classes.dex */
public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new y();

    /* renamed from: f  reason: collision with root package name */
    public final int[] f4268f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f4269fb;

    /* renamed from: s  reason: collision with root package name */
    public final int f4270s;

    /* renamed from: t  reason: collision with root package name */
    public final int[] f4271t;

    /* renamed from: v  reason: collision with root package name */
    public final int f4272v;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<MlltFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public MlltFrame[] newArray(int i) {
            return new MlltFrame[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public MlltFrame createFromParcel(Parcel parcel) {
            return new MlltFrame(parcel);
        }
    }

    public MlltFrame(int i, int i5, int i6, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f4272v = i;
        this.f4269fb = i5;
        this.f4270s = i6;
        this.f4268f = iArr;
        this.f4271t = iArr2;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MlltFrame.class != obj.getClass()) {
            return false;
        }
        MlltFrame mlltFrame = (MlltFrame) obj;
        if (this.f4272v == mlltFrame.f4272v && this.f4269fb == mlltFrame.f4269fb && this.f4270s == mlltFrame.f4270s && Arrays.equals(this.f4268f, mlltFrame.f4268f) && Arrays.equals(this.f4271t, mlltFrame.f4271t)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f4272v) * 31) + this.f4269fb) * 31) + this.f4270s) * 31) + Arrays.hashCode(this.f4268f)) * 31) + Arrays.hashCode(this.f4271t);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4272v);
        parcel.writeInt(this.f4269fb);
        parcel.writeInt(this.f4270s);
        parcel.writeIntArray(this.f4268f);
        parcel.writeIntArray(this.f4271t);
    }

    public MlltFrame(Parcel parcel) {
        super("MLLT");
        this.f4272v = parcel.readInt();
        this.f4269fb = parcel.readInt();
        this.f4270s = parcel.readInt();
        this.f4268f = (int[]) j5.i9(parcel.createIntArray());
        this.f4271t = (int[]) j5.i9(parcel.createIntArray());
    }
}
