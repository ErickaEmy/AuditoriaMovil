package rs;

import android.app.Notification;
import android.media.session.MediaSession;
import android.support.v4.media.session.MediaSessionCompat;
/* loaded from: classes.dex */
public class y {
    public static void gv(Notification.Builder builder, Notification.MediaStyle mediaStyle) {
        builder.setStyle(mediaStyle);
    }

    public static Notification.MediaStyle n3(Notification.MediaStyle mediaStyle, int[] iArr, MediaSessionCompat.Token token) {
        if (iArr != null) {
            v(mediaStyle, iArr);
        }
        if (token != null) {
            zn(mediaStyle, (MediaSession.Token) token.v());
        }
        return mediaStyle;
    }

    public static void v(Notification.MediaStyle mediaStyle, int... iArr) {
        mediaStyle.setShowActionsInCompactView(iArr);
    }

    public static Notification.MediaStyle y() {
        return new Notification.MediaStyle();
    }

    public static void zn(Notification.MediaStyle mediaStyle, MediaSession.Token token) {
        mediaStyle.setMediaSession(token);
    }
}
