package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new y();

    /* renamed from: fb  reason: collision with root package name */
    public Object f510fb;

    /* renamed from: v  reason: collision with root package name */
    public final float f511v;
    public final int y;

    /* loaded from: classes.dex */
    public static class n3 {
        public static boolean a(Rating rating) {
            return rating.isThumbUp();
        }

        public static Rating c5(int i, float f4) {
            return Rating.newStarRating(i, f4);
        }

        public static Rating f(int i) {
            return Rating.newUnratedRating(i);
        }

        public static Rating fb(boolean z2) {
            return Rating.newHeartRating(z2);
        }

        public static boolean gv(Rating rating) {
            return rating.hasHeart();
        }

        public static Rating i9(boolean z2) {
            return Rating.newThumbRating(z2);
        }

        public static int n3(Rating rating) {
            return rating.getRatingStyle();
        }

        public static Rating s(float f4) {
            return Rating.newPercentageRating(f4);
        }

        public static boolean v(Rating rating) {
            return rating.isRated();
        }

        public static float y(Rating rating) {
            return rating.getPercentRating();
        }

        public static float zn(Rating rating) {
            return rating.getStarRating();
        }
    }

    /* loaded from: classes.dex */
    public class y implements Parcelable.Creator<RatingCompat> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: n3 */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: y */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }
    }

    public RatingCompat(int i, float f4) {
        this.y = i;
        this.f511v = f4;
    }

    public static RatingCompat f(float f4) {
        if (f4 >= 0.0f && f4 <= 100.0f) {
            return new RatingCompat(6, f4);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat i9(boolean z2) {
        float f4;
        if (z2) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        return new RatingCompat(1, f4);
    }

    public static RatingCompat t(int i, float f4) {
        float f6;
        if (i != 3) {
            if (i != 4) {
                if (i != 5) {
                    Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                    return null;
                }
                f6 = 5.0f;
            } else {
                f6 = 4.0f;
            }
        } else {
            f6 = 3.0f;
        }
        if (f4 >= 0.0f && f4 <= f6) {
            return new RatingCompat(i, f4);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat tl(boolean z2) {
        float f4;
        if (z2) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        return new RatingCompat(2, f4);
    }

    public static RatingCompat wz(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    public static RatingCompat y(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int n32 = n3.n3(rating);
            if (n3.v(rating)) {
                switch (n32) {
                    case 1:
                        ratingCompat = i9(n3.gv(rating));
                        break;
                    case 2:
                        ratingCompat = tl(n3.a(rating));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = t(n32, n3.zn(rating));
                        break;
                    case 6:
                        ratingCompat = f(n3.y(rating));
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompat = wz(n32);
            }
            ratingCompat.f510fb = obj;
        }
        return ratingCompat;
    }

    public boolean c5() {
        if (this.y != 2 || this.f511v != 1.0f) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.y;
    }

    public boolean fb() {
        if (this.y != 1 || this.f511v != 1.0f) {
            return false;
        }
        return true;
    }

    public int gv() {
        return this.y;
    }

    public float n3() {
        if (this.y == 6 && s()) {
            return this.f511v;
        }
        return -1.0f;
    }

    public boolean s() {
        if (this.f511v >= 0.0f) {
            return true;
        }
        return false;
    }

    public String toString() {
        String valueOf;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.y);
        sb.append(" rating=");
        float f4 = this.f511v;
        if (f4 < 0.0f) {
            valueOf = "unrated";
        } else {
            valueOf = String.valueOf(f4);
        }
        sb.append(valueOf);
        return sb.toString();
    }

    public float v() {
        int i = this.y;
        if ((i == 3 || i == 4 || i == 5) && s()) {
            return this.f511v;
        }
        return -1.0f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.y);
        parcel.writeFloat(this.f511v);
    }

    public Object zn() {
        if (this.f510fb == null) {
            if (s()) {
                int i = this.y;
                switch (i) {
                    case 1:
                        this.f510fb = n3.fb(fb());
                        break;
                    case 2:
                        this.f510fb = n3.i9(c5());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.f510fb = n3.c5(i, v());
                        break;
                    case 6:
                        this.f510fb = n3.s(n3());
                        break;
                    default:
                        return null;
                }
            } else {
                this.f510fb = n3.f(this.y);
            }
        }
        return this.f510fb;
    }
}
