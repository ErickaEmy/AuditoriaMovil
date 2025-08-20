package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.y;
import androidx.annotation.NonNull;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new y();

    /* renamed from: v  reason: collision with root package name */
    public android.support.v4.os.y f581v;
    public final Handler y;

    /* loaded from: classes.dex */
    public class n3 extends y.AbstractBinderC0008y {
        public n3() {
        }

        @Override // android.support.v4.os.y
        public void ra(int i, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.y;
            if (handler != null) {
                handler.post(new zn(i, bundle));
            } else {
                resultReceiver.y(i, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<ResultReceiver> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }
    }

    /* loaded from: classes.dex */
    public class zn implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final Bundle f583v;
        public final int y;

        public zn(int i, Bundle bundle) {
            this.y = i;
            this.f583v = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.y(this.y, this.f583v);
        }
    }

    public ResultReceiver(Parcel parcel) {
        this.f581v = y.AbstractBinderC0008y.mt(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        synchronized (this) {
            try {
                if (this.f581v == null) {
                    this.f581v = new n3();
                }
                parcel.writeStrongBinder(this.f581v.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void y(int i, Bundle bundle) {
    }
}
