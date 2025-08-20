package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;
import hd.y;
import m1.m;
import m1.qk;
/* loaded from: classes.dex */
public abstract class Id3Frame implements Metadata.Entry {
    public final String y;

    public Id3Frame(String str) {
        this.y = str;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ m co() {
        return y.n3(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void m(qk.n3 n3Var) {
        y.zn(this, n3Var);
    }

    public String toString() {
        return this.y;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] w2() {
        return y.y(this);
    }
}
