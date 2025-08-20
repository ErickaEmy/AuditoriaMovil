package org.fdroid.fdroid.views.installed;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import org.fdroid.database.AppPrefs;
import org.fdroid.fdroid.AppUpdateStatusManager;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.views.apps.AppListItemController;
import org.fdroid.fdroid.views.apps.AppListItemState;
/* loaded from: classes2.dex */
public class InstalledAppListItemController extends AppListItemController {
    public InstalledAppListItemController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.fdroid.fdroid.views.apps.AppListItemController
    public AppListItemState getCurrentViewState(App app, AppUpdateStatusManager.AppUpdateStatus appUpdateStatus) {
        return new AppListItemState(app).setStatusText(getInstalledVersion(app)).setSecondaryStatusText(getIgnoreStatus(app));
    }

    private CharSequence getInstalledVersion(App app) {
        return this.activity.getString(app.autoInstallVersionCode == app.installedVersionCode ? R.string.app_recommended_version_installed : R.string.app_version_x_installed, app.installedVersionName);
    }

    private CharSequence getIgnoreStatus(App app) {
        AppPrefs appPrefs = app.prefs;
        if (appPrefs == null || !appPrefs.shouldIgnoreUpdate(app.autoInstallVersionCode)) {
            return null;
        }
        return this.activity.getString(R.string.installed_app__updates_ignored);
    }
}
