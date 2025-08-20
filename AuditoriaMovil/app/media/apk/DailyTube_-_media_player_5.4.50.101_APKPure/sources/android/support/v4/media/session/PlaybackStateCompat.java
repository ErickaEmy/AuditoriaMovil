package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new y();

    /* renamed from: co  reason: collision with root package name */
    public List<CustomAction> f554co;

    /* renamed from: f  reason: collision with root package name */
    public final long f555f;

    /* renamed from: f3  reason: collision with root package name */
    public PlaybackState f556f3;

    /* renamed from: fb  reason: collision with root package name */
    public final long f557fb;

    /* renamed from: p  reason: collision with root package name */
    public final long f558p;

    /* renamed from: r  reason: collision with root package name */
    public final Bundle f559r;

    /* renamed from: s  reason: collision with root package name */
    public final float f560s;

    /* renamed from: t  reason: collision with root package name */
    public final int f561t;

    /* renamed from: v  reason: collision with root package name */
    public final long f562v;

    /* renamed from: w  reason: collision with root package name */
    public final CharSequence f563w;
    public final int y;

    /* renamed from: z  reason: collision with root package name */
    public final long f564z;

    /* loaded from: classes.dex */
    public static class n3 {
        public static String a(PlaybackState.CustomAction customAction) {
            return customAction.getAction();
        }

        public static long c5(PlaybackState playbackState) {
            return playbackState.getBufferedPosition();
        }

        public static void co(PlaybackState.Builder builder, long j2) {
            builder.setActions(j2);
        }

        public static CharSequence f(PlaybackState playbackState) {
            return playbackState.getErrorMessage();
        }

        public static void f3(PlaybackState.Builder builder, int i, long j2, float f4, long j4) {
            builder.setState(i, j2, f4, j4);
        }

        public static long fb(PlaybackState playbackState) {
            return playbackState.getActions();
        }

        public static PlaybackState.Builder gv() {
            return new PlaybackState.Builder();
        }

        public static void i4(PlaybackState.CustomAction.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        public static List<PlaybackState.CustomAction> i9(PlaybackState playbackState) {
            return playbackState.getCustomActions();
        }

        public static int mt(PlaybackState playbackState) {
            return playbackState.getState();
        }

        public static PlaybackState.CustomAction n3(PlaybackState.CustomAction.Builder builder) {
            return builder.build();
        }

        public static long p(PlaybackState playbackState) {
            return playbackState.getPosition();
        }

        public static void r(PlaybackState.Builder builder, long j2) {
            builder.setBufferedPosition(j2);
        }

        public static long s(PlaybackState playbackState) {
            return playbackState.getActiveQueueItemId();
        }

        public static Bundle t(PlaybackState.CustomAction customAction) {
            return customAction.getExtras();
        }

        public static int tl(PlaybackState.CustomAction customAction) {
            return customAction.getIcon();
        }

        public static PlaybackState.CustomAction.Builder v(String str, CharSequence charSequence, int i) {
            return new PlaybackState.CustomAction.Builder(str, charSequence, i);
        }

        public static float w(PlaybackState playbackState) {
            return playbackState.getPlaybackSpeed();
        }

        public static long wz(PlaybackState playbackState) {
            return playbackState.getLastPositionUpdateTime();
        }

        public static void x4(PlaybackState.Builder builder, CharSequence charSequence) {
            builder.setErrorMessage(charSequence);
        }

        public static CharSequence xc(PlaybackState.CustomAction customAction) {
            return customAction.getName();
        }

        public static void y(PlaybackState.Builder builder, PlaybackState.CustomAction customAction) {
            builder.addCustomAction(customAction);
        }

        public static void z(PlaybackState.Builder builder, long j2) {
            builder.setActiveQueueItemId(j2);
        }

        public static PlaybackState zn(PlaybackState.Builder builder) {
            return builder.build();
        }
    }

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<PlaybackStateCompat> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public static void n3(PlaybackState.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        public static Bundle y(PlaybackState playbackState) {
            return playbackState.getExtras();
        }
    }

    public PlaybackStateCompat(int i, long j2, long j4, float f4, long j6, int i5, CharSequence charSequence, long j7, List<CustomAction> list, long j8, Bundle bundle) {
        this.y = i;
        this.f562v = j2;
        this.f557fb = j4;
        this.f560s = f4;
        this.f555f = j6;
        this.f561t = i5;
        this.f563w = charSequence;
        this.f558p = j7;
        this.f554co = new ArrayList(list);
        this.f564z = j8;
        this.f559r = bundle;
    }

    public static PlaybackStateCompat y(Object obj) {
        ArrayList arrayList;
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) obj;
        List<PlaybackState.CustomAction> i92 = n3.i9(playbackState);
        if (i92 != null) {
            ArrayList arrayList2 = new ArrayList(i92.size());
            for (PlaybackState.CustomAction customAction : i92) {
                arrayList2.add(CustomAction.y(customAction));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = zn.y(playbackState);
            MediaSessionCompat.y(bundle);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(n3.mt(playbackState), n3.p(playbackState), n3.c5(playbackState), n3.w(playbackState), n3.fb(playbackState), 0, n3.f(playbackState), n3.wz(playbackState), arrayList, n3.s(playbackState), bundle);
        playbackStateCompat.f556f3 = playbackState;
        return playbackStateCompat;
    }

    public int c5() {
        return this.y;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object fb() {
        if (this.f556f3 == null) {
            PlaybackState.Builder gv2 = n3.gv();
            n3.f3(gv2, this.y, this.f562v, this.f560s, this.f558p);
            n3.r(gv2, this.f557fb);
            n3.co(gv2, this.f555f);
            n3.x4(gv2, this.f563w);
            for (CustomAction customAction : this.f554co) {
                n3.y(gv2, (PlaybackState.CustomAction) customAction.zn());
            }
            n3.z(gv2, this.f564z);
            if (Build.VERSION.SDK_INT >= 22) {
                zn.n3(gv2, this.f559r);
            }
            this.f556f3 = n3.zn(gv2);
        }
        return this.f556f3;
    }

    public long gv() {
        return this.f558p;
    }

    public long n3() {
        return this.f555f;
    }

    public long s() {
        return this.f562v;
    }

    public String toString() {
        return "PlaybackState {state=" + this.y + ", position=" + this.f562v + ", buffered position=" + this.f557fb + ", speed=" + this.f560s + ", updated=" + this.f558p + ", actions=" + this.f555f + ", error code=" + this.f561t + ", error message=" + this.f563w + ", custom actions=" + this.f554co + ", active item id=" + this.f564z + "}";
    }

    public float v() {
        return this.f560s;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.y);
        parcel.writeLong(this.f562v);
        parcel.writeFloat(this.f560s);
        parcel.writeLong(this.f558p);
        parcel.writeLong(this.f557fb);
        parcel.writeLong(this.f555f);
        TextUtils.writeToParcel(this.f563w, parcel, i);
        parcel.writeTypedList(this.f554co);
        parcel.writeLong(this.f564z);
        parcel.writeBundle(this.f559r);
        parcel.writeInt(this.f561t);
    }

    public long zn() {
        return this.f564z;
    }

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: a  reason: collision with root package name */
        public long f569a;

        /* renamed from: c5  reason: collision with root package name */
        public long f570c5;

        /* renamed from: f  reason: collision with root package name */
        public Bundle f571f;

        /* renamed from: fb  reason: collision with root package name */
        public int f572fb;

        /* renamed from: gv  reason: collision with root package name */
        public long f573gv;

        /* renamed from: i9  reason: collision with root package name */
        public long f574i9;

        /* renamed from: n3  reason: collision with root package name */
        public int f575n3;

        /* renamed from: s  reason: collision with root package name */
        public CharSequence f576s;

        /* renamed from: v  reason: collision with root package name */
        public float f577v;
        public final List<CustomAction> y;

        /* renamed from: zn  reason: collision with root package name */
        public long f578zn;

        public gv() {
            this.y = new ArrayList();
            this.f574i9 = -1L;
        }

        public gv a(int i, CharSequence charSequence) {
            this.f572fb = i;
            this.f576s = charSequence;
            return this;
        }

        public gv c5(int i, long j2, float f4, long j4) {
            this.f575n3 = i;
            this.f578zn = j2;
            this.f570c5 = j4;
            this.f577v = f4;
            return this;
        }

        public gv fb(Bundle bundle) {
            this.f571f = bundle;
            return this;
        }

        public gv gv(long j2) {
            this.f574i9 = j2;
            return this;
        }

        public PlaybackStateCompat n3() {
            return new PlaybackStateCompat(this.f575n3, this.f578zn, this.f573gv, this.f577v, this.f569a, this.f572fb, this.f576s, this.f570c5, this.y, this.f574i9, this.f571f);
        }

        public gv s(int i, long j2, float f4) {
            return c5(i, j2, f4, SystemClock.elapsedRealtime());
        }

        public gv v(long j2) {
            this.f573gv = j2;
            return this;
        }

        public gv y(CustomAction customAction) {
            if (customAction != null) {
                this.y.add(customAction);
                return this;
            }
            throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat");
        }

        public gv zn(long j2) {
            this.f569a = j2;
            return this;
        }

        public gv(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.y = arrayList;
            this.f574i9 = -1L;
            this.f575n3 = playbackStateCompat.y;
            this.f578zn = playbackStateCompat.f562v;
            this.f577v = playbackStateCompat.f560s;
            this.f570c5 = playbackStateCompat.f558p;
            this.f573gv = playbackStateCompat.f557fb;
            this.f569a = playbackStateCompat.f555f;
            this.f572fb = playbackStateCompat.f561t;
            this.f576s = playbackStateCompat.f563w;
            List<CustomAction> list = playbackStateCompat.f554co;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f574i9 = playbackStateCompat.f564z;
            this.f571f = playbackStateCompat.f559r;
        }
    }

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new y();

        /* renamed from: f  reason: collision with root package name */
        public PlaybackState.CustomAction f565f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f566fb;

        /* renamed from: s  reason: collision with root package name */
        public final Bundle f567s;

        /* renamed from: v  reason: collision with root package name */
        public final CharSequence f568v;
        public final String y;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<CustomAction> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }
        }

        public CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.y = str;
            this.f568v = charSequence;
            this.f566fb = i;
            this.f567s = bundle;
        }

        public static CustomAction y(Object obj) {
            if (obj != null) {
                PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) obj;
                Bundle t2 = n3.t(customAction);
                MediaSessionCompat.y(t2);
                CustomAction customAction2 = new CustomAction(n3.a(customAction), n3.xc(customAction), n3.tl(customAction), t2);
                customAction2.f565f = customAction;
                return customAction2;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String n3() {
            return this.y;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f568v) + ", mIcon=" + this.f566fb + ", mExtras=" + this.f567s;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.y);
            TextUtils.writeToParcel(this.f568v, parcel, i);
            parcel.writeInt(this.f566fb);
            parcel.writeBundle(this.f567s);
        }

        public Object zn() {
            PlaybackState.CustomAction customAction = this.f565f;
            if (customAction == null) {
                PlaybackState.CustomAction.Builder v2 = n3.v(this.y, this.f568v, this.f566fb);
                n3.i4(v2, this.f567s);
                return n3.n3(v2);
            }
            return customAction;
        }

        public CustomAction(Parcel parcel) {
            this.y = parcel.readString();
            this.f568v = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f566fb = parcel.readInt();
            this.f567s = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.y = parcel.readInt();
        this.f562v = parcel.readLong();
        this.f560s = parcel.readFloat();
        this.f558p = parcel.readLong();
        this.f557fb = parcel.readLong();
        this.f555f = parcel.readLong();
        this.f563w = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f554co = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f564z = parcel.readLong();
        this.f559r = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f561t = parcel.readInt();
    }
}
