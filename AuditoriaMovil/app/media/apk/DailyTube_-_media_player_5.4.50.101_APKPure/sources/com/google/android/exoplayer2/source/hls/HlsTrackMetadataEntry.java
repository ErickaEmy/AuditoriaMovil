package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m1.m;
import m1.qk;
/* loaded from: classes.dex */
public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new y();

    /* renamed from: fb  reason: collision with root package name */
    public final List<VariantInfo> f4529fb;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final String f4530v;
    @Nullable
    public final String y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<HlsTrackMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public HlsTrackMetadataEntry[] newArray(int i) {
            return new HlsTrackMetadataEntry[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public HlsTrackMetadataEntry createFromParcel(Parcel parcel) {
            return new HlsTrackMetadataEntry(parcel);
        }
    }

    public HlsTrackMetadataEntry(@Nullable String str, @Nullable String str2, List<VariantInfo> list) {
        this.y = str;
        this.f4530v = str2;
        this.f4529fb = Collections.unmodifiableList(new ArrayList(list));
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
        if (obj == null || HlsTrackMetadataEntry.class != obj.getClass()) {
            return false;
        }
        HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
        if (TextUtils.equals(this.y, hlsTrackMetadataEntry.y) && TextUtils.equals(this.f4530v, hlsTrackMetadataEntry.f4530v) && this.f4529fb.equals(hlsTrackMetadataEntry.f4529fb)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        String str = this.y;
        int i5 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i6 = i * 31;
        String str2 = this.f4530v;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return ((i6 + i5) * 31) + this.f4529fb.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void m(qk.n3 n3Var) {
        hd.y.zn(this, n3Var);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("HlsTrackMetadataEntry");
        if (this.y != null) {
            str = " [" + this.y + ", " + this.f4530v + "]";
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] w2() {
        return hd.y.y(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.y);
        parcel.writeString(this.f4530v);
        int size = this.f4529fb.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeParcelable(this.f4529fb.get(i5), 0);
        }
    }

    public HlsTrackMetadataEntry(Parcel parcel) {
        this.y = parcel.readString();
        this.f4530v = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((VariantInfo) parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.f4529fb = Collections.unmodifiableList(arrayList);
    }

    /* loaded from: classes.dex */
    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new y();
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final String f4531f;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public final String f4532fb;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public final String f4533s;
        @Nullable

        /* renamed from: t  reason: collision with root package name */
        public final String f4534t;

        /* renamed from: v  reason: collision with root package name */
        public final int f4535v;
        public final int y;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<VariantInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public VariantInfo[] newArray(int i) {
                return new VariantInfo[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public VariantInfo createFromParcel(Parcel parcel) {
                return new VariantInfo(parcel);
            }
        }

        public VariantInfo(int i, int i5, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.y = i;
            this.f4535v = i5;
            this.f4532fb = str;
            this.f4533s = str2;
            this.f4531f = str3;
            this.f4534t = str4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VariantInfo.class != obj.getClass()) {
                return false;
            }
            VariantInfo variantInfo = (VariantInfo) obj;
            if (this.y == variantInfo.y && this.f4535v == variantInfo.f4535v && TextUtils.equals(this.f4532fb, variantInfo.f4532fb) && TextUtils.equals(this.f4533s, variantInfo.f4533s) && TextUtils.equals(this.f4531f, variantInfo.f4531f) && TextUtils.equals(this.f4534t, variantInfo.f4534t)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i5;
            int i6;
            int i8 = ((this.y * 31) + this.f4535v) * 31;
            String str = this.f4532fb;
            int i10 = 0;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            int i11 = (i8 + i) * 31;
            String str2 = this.f4533s;
            if (str2 != null) {
                i5 = str2.hashCode();
            } else {
                i5 = 0;
            }
            int i12 = (i11 + i5) * 31;
            String str3 = this.f4531f;
            if (str3 != null) {
                i6 = str3.hashCode();
            } else {
                i6 = 0;
            }
            int i13 = (i12 + i6) * 31;
            String str4 = this.f4534t;
            if (str4 != null) {
                i10 = str4.hashCode();
            }
            return i13 + i10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.y);
            parcel.writeInt(this.f4535v);
            parcel.writeString(this.f4532fb);
            parcel.writeString(this.f4533s);
            parcel.writeString(this.f4531f);
            parcel.writeString(this.f4534t);
        }

        public VariantInfo(Parcel parcel) {
            this.y = parcel.readInt();
            this.f4535v = parcel.readInt();
            this.f4532fb = parcel.readString();
            this.f4533s = parcel.readString();
            this.f4531f = parcel.readString();
            this.f4534t = parcel.readString();
        }
    }
}
