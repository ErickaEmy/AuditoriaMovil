package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ParcelableSnapshotMutableLongState.kt */
/* loaded from: classes.dex */
public final class ParcelableSnapshotMutableLongState extends SnapshotMutableLongStateImpl implements Parcelable {
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ParcelableSnapshotMutableLongState> CREATOR = new Parcelable.Creator() { // from class: androidx.compose.runtime.ParcelableSnapshotMutableLongState$Companion$CREATOR$1
        @Override // android.os.Parcelable.Creator
        public ParcelableSnapshotMutableLongState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ParcelableSnapshotMutableLongState(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public ParcelableSnapshotMutableLongState[] newArray(int i) {
            return new ParcelableSnapshotMutableLongState[i];
        }
    };

    /* compiled from: ParcelableSnapshotMutableLongState.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableSnapshotMutableLongState(long j) {
        super(j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(getLongValue());
    }
}
