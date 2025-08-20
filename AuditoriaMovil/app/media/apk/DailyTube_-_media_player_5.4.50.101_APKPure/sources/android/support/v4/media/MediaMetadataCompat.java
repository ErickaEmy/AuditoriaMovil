package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.Set;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f505f;

    /* renamed from: fb  reason: collision with root package name */
    public static final z.y<String, Integer> f506fb;

    /* renamed from: s  reason: collision with root package name */
    public static final String[] f507s;

    /* renamed from: t  reason: collision with root package name */
    public static final String[] f508t;

    /* renamed from: v  reason: collision with root package name */
    public MediaMetadata f509v;
    public final Bundle y;

    /* loaded from: classes.dex */
    public static final class n3 {
        public final Bundle y = new Bundle();

        public n3 a(String str, CharSequence charSequence) {
            z.y<String, Integer> yVar = MediaMetadataCompat.f506fb;
            if (yVar.containsKey(str) && yVar.get(str).intValue() != 1) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
            }
            this.y.putCharSequence(str, charSequence);
            return this;
        }

        public n3 gv(String str, RatingCompat ratingCompat) {
            z.y<String, Integer> yVar = MediaMetadataCompat.f506fb;
            if (yVar.containsKey(str) && yVar.get(str).intValue() != 3) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
            }
            this.y.putParcelable(str, (Parcelable) ratingCompat.zn());
            return this;
        }

        public n3 n3(String str, Bitmap bitmap) {
            z.y<String, Integer> yVar = MediaMetadataCompat.f506fb;
            if (yVar.containsKey(str) && yVar.get(str).intValue() != 2) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
            }
            this.y.putParcelable(str, bitmap);
            return this;
        }

        public n3 v(String str, String str2) {
            z.y<String, Integer> yVar = MediaMetadataCompat.f506fb;
            if (yVar.containsKey(str) && yVar.get(str).intValue() != 1) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
            }
            this.y.putCharSequence(str, str2);
            return this;
        }

        public MediaMetadataCompat y() {
            return new MediaMetadataCompat(this.y);
        }

        public n3 zn(String str, long j2) {
            z.y<String, Integer> yVar = MediaMetadataCompat.f506fb;
            if (yVar.containsKey(str) && yVar.get(str).intValue() != 0) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
            }
            this.y.putLong(str, j2);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<MediaMetadataCompat> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public MediaMetadataCompat[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }
    }

    static {
        z.y<String, Integer> yVar = new z.y<>();
        f506fb = yVar;
        yVar.put("android.media.metadata.TITLE", 1);
        yVar.put("android.media.metadata.ARTIST", 1);
        yVar.put("android.media.metadata.DURATION", 0);
        yVar.put("android.media.metadata.ALBUM", 1);
        yVar.put("android.media.metadata.AUTHOR", 1);
        yVar.put("android.media.metadata.WRITER", 1);
        yVar.put("android.media.metadata.COMPOSER", 1);
        yVar.put("android.media.metadata.COMPILATION", 1);
        yVar.put("android.media.metadata.DATE", 1);
        yVar.put("android.media.metadata.YEAR", 0);
        yVar.put("android.media.metadata.GENRE", 1);
        yVar.put("android.media.metadata.TRACK_NUMBER", 0);
        yVar.put("android.media.metadata.NUM_TRACKS", 0);
        yVar.put("android.media.metadata.DISC_NUMBER", 0);
        yVar.put("android.media.metadata.ALBUM_ARTIST", 1);
        yVar.put("android.media.metadata.ART", 2);
        yVar.put("android.media.metadata.ART_URI", 1);
        yVar.put("android.media.metadata.ALBUM_ART", 2);
        yVar.put("android.media.metadata.ALBUM_ART_URI", 1);
        yVar.put("android.media.metadata.USER_RATING", 3);
        yVar.put("android.media.metadata.RATING", 3);
        yVar.put("android.media.metadata.DISPLAY_TITLE", 1);
        yVar.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        yVar.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        yVar.put("android.media.metadata.DISPLAY_ICON", 2);
        yVar.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        yVar.put("android.media.metadata.MEDIA_ID", 1);
        yVar.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        yVar.put("android.media.metadata.MEDIA_URI", 1);
        yVar.put("android.media.metadata.ADVERTISEMENT", 0);
        yVar.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        f507s = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        f505f = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        f508t = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        CREATOR = new y();
    }

    public MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.y = bundle2;
        MediaSessionCompat.y(bundle2);
    }

    public static MediaMetadataCompat n3(Object obj) {
        if (obj != null) {
            Parcel obtain = Parcel.obtain();
            MediaMetadata mediaMetadata = (MediaMetadata) obj;
            mediaMetadata.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
            obtain.recycle();
            createFromParcel.f509v = mediaMetadata;
            return createFromParcel;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Set<String> fb() {
        return this.y.keySet();
    }

    public long gv(String str) {
        return this.y.getLong(str, 0L);
    }

    public int s() {
        return this.y.size();
    }

    public Object v() {
        if (this.f509v == null) {
            Parcel obtain = Parcel.obtain();
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            this.f509v = (MediaMetadata) MediaMetadata.CREATOR.createFromParcel(obtain);
            obtain.recycle();
        }
        return this.f509v;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.y);
    }

    public boolean y(String str) {
        return this.y.containsKey(str);
    }

    public Bundle zn() {
        return new Bundle(this.y);
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.y = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
}
