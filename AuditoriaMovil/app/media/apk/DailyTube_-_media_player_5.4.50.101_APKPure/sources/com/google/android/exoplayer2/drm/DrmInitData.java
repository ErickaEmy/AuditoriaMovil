package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import v5.j5;
/* loaded from: classes.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new y();
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final String f4114fb;

    /* renamed from: s  reason: collision with root package name */
    public final int f4115s;

    /* renamed from: v  reason: collision with root package name */
    public int f4116v;
    public final SchemeData[] y;

    /* loaded from: classes.dex */
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new y();
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f4117f;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public final String f4118fb;

        /* renamed from: s  reason: collision with root package name */
        public final String f4119s;

        /* renamed from: v  reason: collision with root package name */
        public final UUID f4120v;
        public int y;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<SchemeData> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public SchemeData[] newArray(int i) {
                return new SchemeData[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }
        }

        public SchemeData(UUID uuid, String str, @Nullable byte[] bArr) {
            this(uuid, null, str, bArr);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            if (!j5.zn(this.f4118fb, schemeData.f4118fb) || !j5.zn(this.f4119s, schemeData.f4119s) || !j5.zn(this.f4120v, schemeData.f4120v) || !Arrays.equals(this.f4117f, schemeData.f4117f)) {
                return false;
            }
            return true;
        }

        public boolean gv(UUID uuid) {
            if (!m1.c5.y.equals(this.f4120v) && !uuid.equals(this.f4120v)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode;
            if (this.y == 0) {
                int hashCode2 = this.f4120v.hashCode() * 31;
                String str = this.f4118fb;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                this.y = ((((hashCode2 + hashCode) * 31) + this.f4119s.hashCode()) * 31) + Arrays.hashCode(this.f4117f);
            }
            return this.y;
        }

        @CheckResult
        public SchemeData n3(@Nullable byte[] bArr) {
            return new SchemeData(this.f4120v, this.f4118fb, this.f4119s, bArr);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f4120v.getMostSignificantBits());
            parcel.writeLong(this.f4120v.getLeastSignificantBits());
            parcel.writeString(this.f4118fb);
            parcel.writeString(this.f4119s);
            parcel.writeByteArray(this.f4117f);
        }

        public boolean y(SchemeData schemeData) {
            if (zn() && !schemeData.zn() && gv(schemeData.f4120v)) {
                return true;
            }
            return false;
        }

        public boolean zn() {
            if (this.f4117f != null) {
                return true;
            }
            return false;
        }

        public SchemeData(UUID uuid, @Nullable String str, String str2, @Nullable byte[] bArr) {
            this.f4120v = (UUID) v5.y.v(uuid);
            this.f4118fb = str;
            this.f4119s = (String) v5.y.v(str2);
            this.f4117f = bArr;
        }

        public SchemeData(Parcel parcel) {
            this.f4120v = new UUID(parcel.readLong(), parcel.readLong());
            this.f4118fb = parcel.readString();
            this.f4119s = (String) j5.i9(parcel.readString());
            this.f4117f = parcel.createByteArray();
        }
    }

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<DrmInitData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public DrmInitData[] newArray(int i) {
            return new DrmInitData[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(null, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    @Nullable
    public static DrmInitData gv(@Nullable DrmInitData drmInitData, @Nullable DrmInitData drmInitData2) {
        String str;
        SchemeData[] schemeDataArr;
        SchemeData[] schemeDataArr2;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.f4114fb;
            for (SchemeData schemeData : drmInitData.y) {
                if (schemeData.zn()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.f4114fb;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.y) {
                if (schemeData2.zn() && !n3(arrayList, size, schemeData2.f4120v)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, arrayList);
    }

    public static boolean n3(ArrayList<SchemeData> arrayList, int i, UUID uuid) {
        for (int i5 = 0; i5 < i; i5++) {
            if (arrayList.get(i5).f4120v.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public DrmInitData a(DrmInitData drmInitData) {
        boolean z2;
        String str;
        String str2 = this.f4114fb;
        if (str2 != null && (str = drmInitData.f4114fb) != null && !TextUtils.equals(str2, str)) {
            z2 = false;
        } else {
            z2 = true;
        }
        v5.y.fb(z2);
        String str3 = this.f4114fb;
        if (str3 == null) {
            str3 = drmInitData.f4114fb;
        }
        return new DrmInitData(str3, (SchemeData[]) j5.qk(this.y, drmInitData.y));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        if (j5.zn(this.f4114fb, drmInitData.f4114fb) && Arrays.equals(this.y, drmInitData.y)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        if (this.f4116v == 0) {
            String str = this.f4114fb;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            this.f4116v = (hashCode * 31) + Arrays.hashCode(this.y);
        }
        return this.f4116v;
    }

    public SchemeData v(int i) {
        return this.y[i];
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4114fb);
        parcel.writeTypedArray(this.y, 0);
    }

    @Override // java.util.Comparator
    /* renamed from: y */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = m1.c5.y;
        if (uuid.equals(schemeData.f4120v)) {
            if (uuid.equals(schemeData2.f4120v)) {
                return 0;
            }
            return 1;
        }
        return schemeData.f4120v.compareTo(schemeData2.f4120v);
    }

    @CheckResult
    public DrmInitData zn(@Nullable String str) {
        if (j5.zn(this.f4114fb, str)) {
            return this;
        }
        return new DrmInitData(str, false, this.y);
    }

    public DrmInitData(@Nullable String str, List<SchemeData> list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }

    public DrmInitData(@Nullable String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    public DrmInitData(@Nullable String str, boolean z2, SchemeData... schemeDataArr) {
        this.f4114fb = str;
        schemeDataArr = z2 ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.y = schemeDataArr;
        this.f4115s = schemeDataArr.length;
        Arrays.sort(schemeDataArr, this);
    }

    public DrmInitData(Parcel parcel) {
        this.f4114fb = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) j5.i9((SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR));
        this.y = schemeDataArr;
        this.f4115s = schemeDataArr.length;
    }
}
