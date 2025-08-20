package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new y();

    /* renamed from: co  reason: collision with root package name */
    public MediaDescription f490co;

    /* renamed from: f  reason: collision with root package name */
    public final Bitmap f491f;

    /* renamed from: fb  reason: collision with root package name */
    public final CharSequence f492fb;

    /* renamed from: p  reason: collision with root package name */
    public final Uri f493p;

    /* renamed from: s  reason: collision with root package name */
    public final CharSequence f494s;

    /* renamed from: t  reason: collision with root package name */
    public final Uri f495t;

    /* renamed from: v  reason: collision with root package name */
    public final CharSequence f496v;

    /* renamed from: w  reason: collision with root package name */
    public final Bundle f497w;
    public final String y;

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: a  reason: collision with root package name */
        public Uri f498a;

        /* renamed from: fb  reason: collision with root package name */
        public Bundle f499fb;

        /* renamed from: gv  reason: collision with root package name */
        public CharSequence f500gv;

        /* renamed from: n3  reason: collision with root package name */
        public CharSequence f501n3;

        /* renamed from: s  reason: collision with root package name */
        public Uri f502s;

        /* renamed from: v  reason: collision with root package name */
        public Bitmap f503v;
        public String y;

        /* renamed from: zn  reason: collision with root package name */
        public CharSequence f504zn;

        public gv a(@Nullable String str) {
            this.y = str;
            return this;
        }

        public gv c5(@Nullable CharSequence charSequence) {
            this.f501n3 = charSequence;
            return this;
        }

        public gv fb(@Nullable Uri uri) {
            this.f502s = uri;
            return this;
        }

        public gv gv(@Nullable Bitmap bitmap) {
            this.f503v = bitmap;
            return this;
        }

        public gv n3(@Nullable CharSequence charSequence) {
            this.f500gv = charSequence;
            return this;
        }

        public gv s(@Nullable CharSequence charSequence) {
            this.f504zn = charSequence;
            return this;
        }

        public gv v(@Nullable Uri uri) {
            this.f498a = uri;
            return this;
        }

        public MediaDescriptionCompat y() {
            return new MediaDescriptionCompat(this.y, this.f501n3, this.f504zn, this.f500gv, this.f503v, this.f498a, this.f499fb, this.f502s);
        }

        public gv zn(@Nullable Bundle bundle) {
            this.f499fb = bundle;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {
        @Nullable
        public static Uri a(MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }

        @Nullable
        public static CharSequence c5(MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }

        public static void f(MediaDescription.Builder builder, @Nullable Bundle bundle) {
            builder.setExtras(bundle);
        }

        @Nullable
        public static String fb(MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }

        @Nullable
        public static Bundle gv(MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }

        public static void i9(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        public static MediaDescription.Builder n3() {
            return new MediaDescription.Builder();
        }

        @Nullable
        public static CharSequence s(MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }

        public static void t(MediaDescription.Builder builder, @Nullable Bitmap bitmap) {
            builder.setIconBitmap(bitmap);
        }

        public static void tl(MediaDescription.Builder builder, @Nullable Uri uri) {
            builder.setIconUri(uri);
        }

        @Nullable
        public static Bitmap v(MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }

        public static void w(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setTitle(charSequence);
        }

        public static void wz(MediaDescription.Builder builder, @Nullable String str) {
            builder.setMediaId(str);
        }

        public static void xc(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        public static MediaDescription y(MediaDescription.Builder builder) {
            return builder.build();
        }

        @Nullable
        public static CharSequence zn(MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }
    }

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<MediaDescriptionCompat> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.y(MediaDescription.CREATOR.createFromParcel(parcel));
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public static void n3(MediaDescription.Builder builder, @Nullable Uri uri) {
            builder.setMediaUri(uri);
        }

        @Nullable
        public static Uri y(MediaDescription mediaDescription) {
            return mediaDescription.getMediaUri();
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.y = str;
        this.f496v = charSequence;
        this.f492fb = charSequence2;
        this.f494s = charSequence3;
        this.f491f = bitmap;
        this.f495t = uri;
        this.f497w = bundle;
        this.f493p = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.support.v4.media.MediaDescriptionCompat y(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L7f
            int r1 = android.os.Build.VERSION.SDK_INT
            android.support.v4.media.MediaDescriptionCompat$gv r2 = new android.support.v4.media.MediaDescriptionCompat$gv
            r2.<init>()
            android.media.MediaDescription r9 = (android.media.MediaDescription) r9
            java.lang.String r3 = android.support.v4.media.MediaDescriptionCompat.n3.fb(r9)
            r2.a(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.n3.c5(r9)
            r2.c5(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.n3.s(r9)
            r2.s(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.n3.zn(r9)
            r2.n3(r3)
            android.graphics.Bitmap r3 = android.support.v4.media.MediaDescriptionCompat.n3.v(r9)
            r2.gv(r3)
            android.net.Uri r3 = android.support.v4.media.MediaDescriptionCompat.n3.a(r9)
            r2.v(r3)
            android.os.Bundle r3 = android.support.v4.media.MediaDescriptionCompat.n3.gv(r9)
            if (r3 == 0) goto L40
            android.os.Bundle r3 = android.support.v4.media.session.MediaSessionCompat.w(r3)
        L40:
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L4b
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L4c
        L4b:
            r5 = r0
        L4c:
            if (r5 == 0) goto L64
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L5e
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L5e
            goto L65
        L5e:
            r3.remove(r4)
            r3.remove(r6)
        L64:
            r0 = r3
        L65:
            r2.zn(r0)
            if (r5 == 0) goto L6e
            r2.fb(r5)
            goto L79
        L6e:
            r0 = 23
            if (r1 < r0) goto L79
            android.net.Uri r0 = android.support.v4.media.MediaDescriptionCompat.zn.y(r9)
            r2.fb(r0)
        L79:
            android.support.v4.media.MediaDescriptionCompat r0 = r2.y()
            r0.f490co = r9
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.y(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    @Nullable
    public Uri c5() {
        return this.f493p;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public CharSequence f() {
        return this.f496v;
    }

    public Object fb() {
        Bundle bundle;
        MediaDescription mediaDescription = this.f490co;
        if (mediaDescription == null) {
            int i = Build.VERSION.SDK_INT;
            MediaDescription.Builder n32 = n3.n3();
            n3.wz(n32, this.y);
            n3.w(n32, this.f496v);
            n3.xc(n32, this.f492fb);
            n3.i9(n32, this.f494s);
            n3.t(n32, this.f491f);
            n3.tl(n32, this.f495t);
            if (i < 23 && this.f493p != null) {
                if (this.f497w == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                } else {
                    bundle = new Bundle(this.f497w);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f493p);
                n3.f(n32, bundle);
            } else {
                n3.f(n32, this.f497w);
            }
            if (i >= 23) {
                zn.n3(n32, this.f493p);
            }
            MediaDescription y2 = n3.y(n32);
            this.f490co = y2;
            return y2;
        }
        return mediaDescription;
    }

    @Nullable
    public Bitmap gv() {
        return this.f491f;
    }

    @Nullable
    public CharSequence i9() {
        return this.f492fb;
    }

    @Nullable
    public CharSequence n3() {
        return this.f494s;
    }

    @Nullable
    public String s() {
        return this.y;
    }

    public String toString() {
        return ((Object) this.f496v) + ", " + ((Object) this.f492fb) + ", " + ((Object) this.f494s);
    }

    @Nullable
    public Uri v() {
        return this.f495t;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((MediaDescription) fb()).writeToParcel(parcel, i);
    }

    @Nullable
    public Bundle zn() {
        return this.f497w;
    }
}
