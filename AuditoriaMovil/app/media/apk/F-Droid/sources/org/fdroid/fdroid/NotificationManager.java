package org.fdroid.fdroid;

import android.app.Notification;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NotificationManager.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ#\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J)\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lorg/fdroid/fdroid/NotificationManager;", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "(Landroid/content/Context;)V", "lastRepoUpdateNotification", "", "nm", "Landroid/app/NotificationManager;", "cancelUpdateRepoNotification", "", "getRepoUpdateNotification", "Landroidx/core/app/NotificationCompat$Builder;", "msg", "", "progress", "", "(Ljava/lang/String;Ljava/lang/Integer;)Landroidx/core/app/NotificationCompat$Builder;", "showUpdateRepoNotification", "throttle", "", "(Ljava/lang/String;ZLjava/lang/Integer;)V", "app_fullRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NotificationManager {
    public static final int $stable = 8;
    private final Context context;
    private long lastRepoUpdateNotification;
    private final android.app.NotificationManager nm;

    public NotificationManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) ContextCompat.getSystemService(context, android.app.NotificationManager.class);
        if (notificationManager == null) {
            throw new IllegalStateException("No NotificationManager".toString());
        }
        this.nm = notificationManager;
    }

    public static /* synthetic */ void showUpdateRepoNotification$default(NotificationManager notificationManager, String str, boolean z, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        notificationManager.showUpdateRepoNotification(str, z, num);
    }

    public final void showUpdateRepoNotification(String msg, boolean z, Integer num) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (!z || System.currentTimeMillis() - this.lastRepoUpdateNotification > 500) {
            Notification build = getRepoUpdateNotification(msg, num).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            this.lastRepoUpdateNotification = System.currentTimeMillis();
            this.nm.notify(0, build);
        }
    }

    public final void cancelUpdateRepoNotification() {
        this.nm.cancel(0);
    }

    public static /* synthetic */ NotificationCompat.Builder getRepoUpdateNotification$default(NotificationManager notificationManager, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        return notificationManager.getRepoUpdateNotification(str, num);
    }

    public final NotificationCompat.Builder getRepoUpdateNotification(String str, Integer num) {
        NotificationCompat.Builder progress = new NotificationCompat.Builder(this.context, "update-channel").setSmallIcon(R.drawable.ic_refresh).setCategory("service").setContentTitle(this.context.getString(R.string.banner_updating_repositories)).setContentText(str).setOngoing(true).setProgress(100, num != null ? num.intValue() : 0, num == null);
        Intrinsics.checkNotNullExpressionValue(progress, "setProgress(...)");
        return progress;
    }
}
