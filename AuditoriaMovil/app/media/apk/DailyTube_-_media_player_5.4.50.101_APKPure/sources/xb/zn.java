package xb;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class zn extends n3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f14927a;

    /* renamed from: c5  reason: collision with root package name */
    public int f14928c5;

    /* renamed from: f  reason: collision with root package name */
    public int f14929f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f14930fb;

    /* renamed from: gv  reason: collision with root package name */
    public final SparseIntArray f14931gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f14932i9;

    /* renamed from: s  reason: collision with root package name */
    public final String f14933s;

    /* renamed from: v  reason: collision with root package name */
    public final Parcel f14934v;

    public zn(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new z.y(), new z.y(), new z.y());
    }

    @Override // xb.n3
    public byte[] c5() {
        int readInt = this.f14934v.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f14934v.readByteArray(bArr);
        return bArr;
    }

    @Override // xb.n3
    public String co() {
        return this.f14934v.readString();
    }

    @Override // xb.n3
    public void d0(byte[] bArr) {
        if (bArr != null) {
            this.f14934v.writeInt(bArr.length);
            this.f14934v.writeByteArray(bArr);
            return;
        }
        this.f14934v.writeInt(-1);
    }

    @Override // xb.n3
    public CharSequence f() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f14934v);
    }

    @Override // xb.n3
    public boolean fb() {
        if (this.f14934v.readInt() != 0) {
            return true;
        }
        return false;
    }

    @Override // xb.n3
    public void i4(int i) {
        y();
        this.f14928c5 = i;
        this.f14931gv.put(i, this.f14934v.dataPosition());
        ta(0);
        ta(i);
    }

    @Override // xb.n3
    public void n(boolean z2) {
        this.f14934v.writeInt(z2 ? 1 : 0);
    }

    @Override // xb.n3
    public n3 n3() {
        Parcel parcel = this.f14934v;
        int dataPosition = parcel.dataPosition();
        int i = this.f14932i9;
        if (i == this.f14927a) {
            i = this.f14930fb;
        }
        int i5 = i;
        return new zn(parcel, dataPosition, i5, this.f14933s + "  ", this.y, this.f14925n3, this.f14926zn);
    }

    @Override // xb.n3
    public <T extends Parcelable> T p() {
        return (T) this.f14934v.readParcelable(getClass().getClassLoader());
    }

    @Override // xb.n3
    public void rz(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f14934v, 0);
    }

    @Override // xb.n3
    public void ta(int i) {
        this.f14934v.writeInt(i);
    }

    @Override // xb.n3
    public boolean tl(int i) {
        while (this.f14932i9 < this.f14930fb) {
            int i5 = this.f14929f;
            if (i5 == i) {
                return true;
            }
            if (String.valueOf(i5).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f14934v.setDataPosition(this.f14932i9);
            int readInt = this.f14934v.readInt();
            this.f14929f = this.f14934v.readInt();
            this.f14932i9 += readInt;
        }
        if (this.f14929f != i) {
            return false;
        }
        return true;
    }

    @Override // xb.n3
    public void ud(String str) {
        this.f14934v.writeString(str);
    }

    @Override // xb.n3
    public int xc() {
        return this.f14934v.readInt();
    }

    @Override // xb.n3
    public void y() {
        int i = this.f14928c5;
        if (i >= 0) {
            int i5 = this.f14931gv.get(i);
            int dataPosition = this.f14934v.dataPosition();
            this.f14934v.setDataPosition(i5);
            this.f14934v.writeInt(dataPosition - i5);
            this.f14934v.setDataPosition(dataPosition);
        }
    }

    @Override // xb.n3
    public void z6(Parcelable parcelable) {
        this.f14934v.writeParcelable(parcelable, 0);
    }

    public zn(Parcel parcel, int i, int i5, String str, z.y<String, Method> yVar, z.y<String, Method> yVar2, z.y<String, Class> yVar3) {
        super(yVar, yVar2, yVar3);
        this.f14931gv = new SparseIntArray();
        this.f14928c5 = -1;
        this.f14929f = -1;
        this.f14934v = parcel;
        this.f14927a = i;
        this.f14930fb = i5;
        this.f14932i9 = i;
        this.f14933s = str;
    }
}
