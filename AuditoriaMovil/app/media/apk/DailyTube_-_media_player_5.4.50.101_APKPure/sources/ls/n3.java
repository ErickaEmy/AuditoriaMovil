package ls;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import java.util.Set;
import ls.y;
import v5.j5;
/* loaded from: classes.dex */
public final /* synthetic */ class n3 {
    public static boolean y(y.s sVar, MediaMetadataCompat mediaMetadataCompat, MediaMetadataCompat mediaMetadataCompat2) {
        if (mediaMetadataCompat == mediaMetadataCompat2) {
            return true;
        }
        if (mediaMetadataCompat.s() != mediaMetadataCompat2.s()) {
            return false;
        }
        Set<String> fb2 = mediaMetadataCompat.fb();
        Bundle zn2 = mediaMetadataCompat.zn();
        Bundle zn3 = mediaMetadataCompat2.zn();
        for (String str : fb2) {
            Object obj = zn2.get(str);
            Object obj2 = zn3.get(str);
            if (obj != obj2) {
                if ((obj instanceof Bitmap) && (obj2 instanceof Bitmap)) {
                    if (!((Bitmap) obj).sameAs((Bitmap) obj2)) {
                        return false;
                    }
                } else if ((obj instanceof RatingCompat) && (obj2 instanceof RatingCompat)) {
                    RatingCompat ratingCompat = (RatingCompat) obj;
                    RatingCompat ratingCompat2 = (RatingCompat) obj2;
                    if (ratingCompat.fb() != ratingCompat2.fb() || ratingCompat.s() != ratingCompat2.s() || ratingCompat.c5() != ratingCompat2.c5() || ratingCompat.n3() != ratingCompat2.n3() || ratingCompat.v() != ratingCompat2.v() || ratingCompat.gv() != ratingCompat2.gv()) {
                        return false;
                    }
                } else if (!j5.zn(obj, obj2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
