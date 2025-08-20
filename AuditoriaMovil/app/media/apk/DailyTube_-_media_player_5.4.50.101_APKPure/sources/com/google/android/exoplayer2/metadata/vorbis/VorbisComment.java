package com.google.android.exoplayer2.metadata.vorbis;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class VorbisComment extends com.google.android.exoplayer2.metadata.flac.VorbisComment {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new y();

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<VorbisComment> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public VorbisComment[] newArray(int i) {
            return new VorbisComment[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }
    }

    public VorbisComment(String str, String str2) {
        super(str, str2);
    }

    public VorbisComment(Parcel parcel) {
        super(parcel);
    }
}
