package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class NavBackStackEntryState implements Parcelable {
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new y();

    /* renamed from: fb  reason: collision with root package name */
    public final Bundle f2675fb;

    /* renamed from: s  reason: collision with root package name */
    public final Bundle f2676s;

    /* renamed from: v  reason: collision with root package name */
    public final int f2677v;
    public final UUID y;

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<NavBackStackEntryState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public NavBackStackEntryState[] newArray(int i) {
            return new NavBackStackEntryState[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }
    }

    public NavBackStackEntryState(lc.fb fbVar) {
        this.y = fbVar.f10292t;
        this.f2677v = fbVar.n3().f();
        this.f2675fb = fbVar.y();
        Bundle bundle = new Bundle();
        this.f2676s = bundle;
        fbVar.s(bundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public UUID gv() {
        return this.y;
    }

    public int n3() {
        return this.f2677v;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.y.toString());
        parcel.writeInt(this.f2677v);
        parcel.writeBundle(this.f2675fb);
        parcel.writeBundle(this.f2676s);
    }

    @Nullable
    public Bundle y() {
        return this.f2675fb;
    }

    @NonNull
    public Bundle zn() {
        return this.f2676s;
    }

    public NavBackStackEntryState(Parcel parcel) {
        this.y = UUID.fromString(parcel.readString());
        this.f2677v = parcel.readInt();
        this.f2675fb = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        this.f2676s = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
    }
}
