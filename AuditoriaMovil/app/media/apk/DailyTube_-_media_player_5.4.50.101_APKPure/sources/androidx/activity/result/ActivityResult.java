package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ActivityResult implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityResult> CREATOR = new y();
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final Intent f600v;
    public final int y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<ActivityResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public ActivityResult[] newArray(int i) {
            return new ActivityResult[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public ActivityResult createFromParcel(@NonNull Parcel parcel) {
            return new ActivityResult(parcel);
        }
    }

    public ActivityResult(int i, @Nullable Intent intent) {
        this.y = i;
        this.f600v = intent;
    }

    @NonNull
    public static String zn(int i) {
        if (i != -1) {
            if (i != 0) {
                return String.valueOf(i);
            }
            return "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int n3() {
        return this.y;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + zn(this.y) + ", data=" + this.f600v + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int i5;
        parcel.writeInt(this.y);
        if (this.f600v == null) {
            i5 = 0;
        } else {
            i5 = 1;
        }
        parcel.writeInt(i5);
        Intent intent = this.f600v;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }

    @Nullable
    public Intent y() {
        return this.f600v;
    }

    public ActivityResult(Parcel parcel) {
        this.y = parcel.readInt();
        this.f600v = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
