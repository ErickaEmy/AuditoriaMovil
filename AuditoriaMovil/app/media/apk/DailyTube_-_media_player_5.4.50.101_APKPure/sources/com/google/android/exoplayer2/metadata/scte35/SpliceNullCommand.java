package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class SpliceNullCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceNullCommand> CREATOR = new y();

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<SpliceNullCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public SpliceNullCommand[] newArray(int i) {
            return new SpliceNullCommand[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public SpliceNullCommand createFromParcel(Parcel parcel) {
            return new SpliceNullCommand();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
