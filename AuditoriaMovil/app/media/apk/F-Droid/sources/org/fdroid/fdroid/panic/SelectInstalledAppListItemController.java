package org.fdroid.fdroid.panic;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Set;
import org.fdroid.fdroid.AppUpdateStatusManager;
import org.fdroid.fdroid.data.Apk;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.views.apps.AppListItemState;
import org.fdroid.fdroid.views.installed.InstalledAppListItemController;
/* loaded from: classes2.dex */
public class SelectInstalledAppListItemController extends InstalledAppListItemController {
    private final Set<String> selectedApps;

    public SelectInstalledAppListItemController(AppCompatActivity appCompatActivity, View view, Set<String> set) {
        super(appCompatActivity, view);
        this.selectedApps = set;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.fdroid.fdroid.views.installed.InstalledAppListItemController, org.fdroid.fdroid.views.apps.AppListItemController
    public AppListItemState getCurrentViewState(App app, AppUpdateStatusManager.AppUpdateStatus appUpdateStatus) {
        return new AppListItemState(app).setCheckBoxStatus(this.selectedApps.contains(app.packageName));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.fdroid.fdroid.views.apps.AppListItemController
    public void onActionButtonPressed(App app, Apk apk) {
        super.onActionButtonPressed(app, apk);
    }
}
