package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new y();

    /* renamed from: fb  reason: collision with root package name */
    public final int f619fb;

    /* renamed from: s  reason: collision with root package name */
    public final int f620s;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final Intent f621v;
    @NonNull
    public final IntentSender y;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public int f622gv;

        /* renamed from: n3  reason: collision with root package name */
        public Intent f623n3;
        public IntentSender y;

        /* renamed from: zn  reason: collision with root package name */
        public int f624zn;

        public n3(@NonNull IntentSender intentSender) {
            this.y = intentSender;
        }

        @NonNull
        public n3 n3(@Nullable Intent intent) {
            this.f623n3 = intent;
            return this;
        }

        @NonNull
        public IntentSenderRequest y() {
            return new IntentSenderRequest(this.y, this.f623n3, this.f624zn, this.f622gv);
        }

        @NonNull
        public n3 zn(int i, int i5) {
            this.f622gv = i;
            this.f624zn = i5;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<IntentSenderRequest> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public IntentSenderRequest[] newArray(int i) {
            return new IntentSenderRequest[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }
    }

    public IntentSenderRequest(@NonNull IntentSender intentSender, @Nullable Intent intent, int i, int i5) {
        this.y = intentSender;
        this.f621v = intent;
        this.f619fb = i;
        this.f620s = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public IntentSender gv() {
        return this.y;
    }

    public int n3() {
        return this.f619fb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.y, i);
        parcel.writeParcelable(this.f621v, i);
        parcel.writeInt(this.f619fb);
        parcel.writeInt(this.f620s);
    }

    @Nullable
    public Intent y() {
        return this.f621v;
    }

    public int zn() {
        return this.f620s;
    }

    public IntentSenderRequest(@NonNull Parcel parcel) {
        this.y = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f621v = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f619fb = parcel.readInt();
        this.f620s = parcel.readInt();
    }
}
