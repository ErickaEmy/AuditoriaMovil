package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import m1.m;
import m1.qk;
import v5.j5;
/* loaded from: classes.dex */
public final class EventMessage implements Metadata.Entry {

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f4222f;

    /* renamed from: fb  reason: collision with root package name */
    public final long f4223fb;

    /* renamed from: s  reason: collision with root package name */
    public final long f4224s;

    /* renamed from: t  reason: collision with root package name */
    public int f4225t;

    /* renamed from: v  reason: collision with root package name */
    public final String f4226v;
    public final String y;

    /* renamed from: w  reason: collision with root package name */
    public static final m f4221w = new m.n3().o4("application/id3").z6();

    /* renamed from: p  reason: collision with root package name */
    public static final m f4220p = new m.n3().o4("application/x-scte35").z6();
    public static final Parcelable.Creator<EventMessage> CREATOR = new y();

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<EventMessage> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public EventMessage[] newArray(int i) {
            return new EventMessage[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }
    }

    public EventMessage(String str, String str2, long j2, long j4, byte[] bArr) {
        this.y = str;
        this.f4226v = str2;
        this.f4223fb = j2;
        this.f4224s = j4;
        this.f4222f = bArr;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @Nullable
    public m co() {
        String str = this.y;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals("urn:scte:scte35:2014:bin")) {
                    c2 = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals("https://aomedia.org/emsg/ID3")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals("https://developer.apple.com/streaming/emsg-id3")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return f4220p;
            case 1:
            case 2:
                return f4221w;
            default:
                return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        if (this.f4223fb == eventMessage.f4223fb && this.f4224s == eventMessage.f4224s && j5.zn(this.y, eventMessage.y) && j5.zn(this.f4226v, eventMessage.f4226v) && Arrays.equals(this.f4222f, eventMessage.f4222f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        if (this.f4225t == 0) {
            String str = this.y;
            int i5 = 0;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            int i6 = (527 + i) * 31;
            String str2 = this.f4226v;
            if (str2 != null) {
                i5 = str2.hashCode();
            }
            long j2 = this.f4223fb;
            long j4 = this.f4224s;
            this.f4225t = ((((((i6 + i5) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + Arrays.hashCode(this.f4222f);
        }
        return this.f4225t;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void m(qk.n3 n3Var) {
        hd.y.zn(this, n3Var);
    }

    public String toString() {
        return "EMSG: scheme=" + this.y + ", id=" + this.f4224s + ", durationMs=" + this.f4223fb + ", value=" + this.f4226v;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @Nullable
    public byte[] w2() {
        if (co() != null) {
            return this.f4222f;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.y);
        parcel.writeString(this.f4226v);
        parcel.writeLong(this.f4223fb);
        parcel.writeLong(this.f4224s);
        parcel.writeByteArray(this.f4222f);
    }

    public EventMessage(Parcel parcel) {
        this.y = (String) j5.i9(parcel.readString());
        this.f4226v = (String) j5.i9(parcel.readString());
        this.f4223fb = parcel.readLong();
        this.f4224s = parcel.readLong();
        this.f4222f = (byte[]) j5.i9(parcel.createByteArray());
    }
}
