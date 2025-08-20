package org.fdroid.database;

import androidx.core.os.LocaleListCompat;
import kotlin.Metadata;
import org.bouncycastle.i18n.ErrorBundle;
import org.fdroid.index.v2.FileV2;
/* compiled from: App.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u0012"}, d2 = {"Lorg/fdroid/database/MinimalApp;", "", "name", "", "getName", "()Ljava/lang/String;", "packageName", "getPackageName", "repoId", "", "getRepoId", "()J", ErrorBundle.SUMMARY_ENTRY, "getSummary", "getIcon", "Lorg/fdroid/index/v2/FileV2;", "localeList", "Landroidx/core/os/LocaleListCompat;", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MinimalApp {
    FileV2 getIcon(LocaleListCompat localeListCompat);

    String getName();

    String getPackageName();

    long getRepoId();

    String getSummary();
}
