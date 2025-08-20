package org.fdroid.fdroid.views.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestPermission;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.bouncycastle.i18n.ErrorBundle;
import org.fdroid.fdroid.AppUpdateStatusManager;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.nearby.SDCardScannerService;
import org.fdroid.fdroid.nearby.SwapService;
import org.fdroid.fdroid.nearby.TreeUriScannerIntentService;
import org.fdroid.fdroid.nearby.WifiStateChangeService;
import org.fdroid.fdroid.views.AppDetailsActivity;
import org.fdroid.fdroid.views.apps.AppListActivity;
import org.fdroid.fdroid.work.RepoUpdateWorker;
/* loaded from: classes2.dex */
public class MainActivity extends AppCompatActivity {
    public static final String ACTION_REQUEST_SWAP = "requestSwap";
    private static final String EXTRA_VIEW_CATEGORIES = "org.fdroid.fdroid.views.main.MainActivity.VIEW_CATEGORIES";
    public static final String EXTRA_VIEW_LATEST = "org.fdroid.fdroid.views.main.MainActivity.VIEW_LATEST";
    private static final String EXTRA_VIEW_NEARBY = "org.fdroid.fdroid.views.main.MainActivity.VIEW_NEARBY";
    public static final String EXTRA_VIEW_SETTINGS = "org.fdroid.fdroid.views.main.MainActivity.VIEW_SETTINGS";
    public static final String EXTRA_VIEW_UPDATES = "org.fdroid.fdroid.views.main.MainActivity.VIEW_UPDATES";
    static final int REQUEST_LOCATION_PERMISSIONS = 61199;
    static final int REQUEST_STORAGE_ACCESS = 16613;
    static final int REQUEST_STORAGE_PERMISSIONS = 45060;
    private static final String TAG = "MainActivity";
    private MainViewAdapter adapter;
    private BottomNavigationView bottomNavigation;
    private RecyclerView pager;
    private final ActivityResultLauncher permissionLauncher = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new ActivityResultCallback() { // from class: org.fdroid.fdroid.views.main.MainActivity$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            MainActivity.lambda$new$0((Boolean) obj);
        }
    });
    private BadgeDrawable updatesBadge;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FDroidApp fDroidApp = (FDroidApp) getApplication();
        fDroidApp.setSecureWindow(this);
        fDroidApp.applyPureBlackBackgroundInDarkTheme(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.adapter = new MainViewAdapter(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_view_pager);
        this.pager = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.pager.setLayoutManager(new NonScrollingHorizontalLayoutManager(this));
        this.pager.setAdapter(this.adapter);
        this.bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        setSelectedMenuInNav(Preferences.get().getBottomNavigationViewName());
        this.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { // from class: org.fdroid.fdroid.views.main.MainActivity$$ExternalSyntheticLambda1
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean lambda$onCreate$1;
                lambda$onCreate$1 = MainActivity.this.lambda$onCreate$1(menuItem);
                return lambda$onCreate$1;
            }
        });
        BadgeDrawable orCreateBadge = this.bottomNavigation.getOrCreateBadge(R.id.updates);
        this.updatesBadge = orCreateBadge;
        orCreateBadge.setVisible(false);
        initialRepoUpdateIfRequired();
        AppUpdateStatusManager.getInstance(this).getNumUpdatableApps().observe(this, new Observer() { // from class: org.fdroid.fdroid.views.main.MainActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.refreshUpdatesBadge(((Integer) obj).intValue());
            }
        });
        Intent intent = getIntent();
        if (handleMainViewSelectIntent(intent)) {
            return;
        }
        handleSearchOrAppViewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$1(MenuItem menuItem) {
        this.pager.scrollToPosition(menuItem.getOrder());
        if (menuItem.getItemId() == R.id.latest) {
            Preferences.get().setBottomNavigationViewName(EXTRA_VIEW_LATEST);
            return true;
        } else if (menuItem.getItemId() == R.id.categories) {
            Preferences.get().setBottomNavigationViewName(EXTRA_VIEW_CATEGORIES);
            return true;
        } else if (menuItem.getItemId() == R.id.nearby) {
            Preferences.get().setBottomNavigationViewName(EXTRA_VIEW_NEARBY);
            NearbyViewBinder.updateUsbOtg(this);
            return true;
        } else if (menuItem.getItemId() == R.id.updates) {
            Preferences.get().setBottomNavigationViewName(EXTRA_VIEW_UPDATES);
            return true;
        } else if (menuItem.getItemId() == R.id.settings) {
            Preferences.get().setBottomNavigationViewName(EXTRA_VIEW_SETTINGS);
            return true;
        } else {
            return true;
        }
    }

    private void setSelectedMenuInNav(int i) {
        int adapterPositionFromItemId = this.adapter.adapterPositionFromItemId(i);
        if (adapterPositionFromItemId < 0) {
            Log.e(TAG, "Invalid menu position: " + adapterPositionFromItemId);
            return;
        }
        this.pager.scrollToPosition(adapterPositionFromItemId);
        this.bottomNavigation.getMenu().getItem(adapterPositionFromItemId).setChecked(true);
    }

    private void setSelectedMenuInNav(String str) {
        if (EXTRA_VIEW_LATEST.equals(str)) {
            setSelectedMenuInNav(R.id.latest);
        } else if (EXTRA_VIEW_CATEGORIES.equals(str)) {
            setSelectedMenuInNav(R.id.categories);
        } else if (EXTRA_VIEW_NEARBY.equals(str)) {
            setSelectedMenuInNav(R.id.nearby);
        } else if (EXTRA_VIEW_UPDATES.equals(str)) {
            setSelectedMenuInNav(R.id.updates);
        } else if (EXTRA_VIEW_SETTINGS.equals(str)) {
            setSelectedMenuInNav(R.id.settings);
        }
    }

    private void initialRepoUpdateIfRequired() {
        if (!Preferences.get().isIndexNeverUpdated() || ((Boolean) FDroidApp.getRepoUpdateManager(this).isUpdating().getValue()).booleanValue()) {
            return;
        }
        Utils.debugLog(TAG, "We haven't done an update yet. Forcing repo update.");
        RepoUpdateWorker.updateNow(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        FDroidApp.checkStartTor(this, Preferences.get());
        NearbyViewBinder.updateExternalStorageViews(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            return;
        }
        this.permissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (handleMainViewSelectIntent(intent)) {
            return;
        }
        handleSearchOrAppViewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == REQUEST_STORAGE_ACCESS) {
            TreeUriScannerIntentService.onActivityResult(this, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == REQUEST_LOCATION_PERMISSIONS) {
            WifiStateChangeService.start(this, null);
            ContextCompat.startForegroundService(this, new Intent(this, SwapService.class));
        } else if (i == REQUEST_STORAGE_PERMISSIONS) {
            Toast.makeText(this, getString(R.string.scan_removable_storage_toast, ""), 0).show();
            SDCardScannerService.scan(this);
        }
    }

    private boolean handleMainViewSelectIntent(Intent intent) {
        if (intent.hasExtra(EXTRA_VIEW_NEARBY)) {
            setSelectedMenuInNav(R.id.nearby);
            return true;
        } else if (intent.hasExtra(EXTRA_VIEW_UPDATES)) {
            setSelectedMenuInNav(R.id.updates);
            return true;
        } else if (intent.hasExtra(EXTRA_VIEW_SETTINGS)) {
            setSelectedMenuInNav(R.id.settings);
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void handleSearchOrAppViewIntent(Intent intent) {
        String schemeSpecificPart;
        String schemeSpecificPart2;
        if ("android.intent.action.SEARCH".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("query");
            if (stringExtra != null) {
                performSearch(stringExtra);
                return;
            }
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            return;
        }
        String scheme = data.getScheme();
        String path = data.getPath();
        String str = null;
        if (data.isHierarchical()) {
            String host = data.getHost();
            if (host != null) {
                char c = 65535;
                switch (host.hashCode()) {
                    case -906336856:
                        if (host.equals("search")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3000946:
                        if (host.equals("apps")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 28462918:
                        if (host.equals("play.google.com")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 110087831:
                        if (host.equals("amazon.com")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 430031819:
                        if (host.equals("f-droid.org")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 495754740:
                        if (host.equals("www.f-droid.org")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 574755480:
                        if (host.equals("staging.f-droid.org")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 943491918:
                        if (host.equals("www.amazon.com")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1557721666:
                        if (host.equals(ErrorBundle.DETAIL_ENTRY)) {
                            c = '\b';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        schemeSpecificPart = data.getQueryParameter("q");
                        String str2 = str;
                        str = schemeSpecificPart;
                        schemeSpecificPart2 = str2;
                        break;
                    case 1:
                    case 3:
                    case 7:
                        str = data.getQueryParameter("p");
                        schemeSpecificPart = data.getQueryParameter("s");
                        String str22 = str;
                        str = schemeSpecificPart;
                        schemeSpecificPart2 = str22;
                        break;
                    case 2:
                        if (path.startsWith("/store/apps/details")) {
                            schemeSpecificPart2 = data.getQueryParameter("id");
                            break;
                        } else {
                            if (path.startsWith("/store/search")) {
                                schemeSpecificPart = data.getQueryParameter("q");
                                String str222 = str;
                                str = schemeSpecificPart;
                                schemeSpecificPart2 = str222;
                                break;
                            }
                            schemeSpecificPart2 = null;
                            break;
                        }
                    case 4:
                    case 5:
                    case 6:
                        if (path.startsWith("/app/") || path.startsWith("/packages/") || path.matches("^/[a-z][a-z][a-zA-Z_-]*/packages/.*")) {
                            schemeSpecificPart2 = data.getLastPathSegment();
                            break;
                        } else if (path.startsWith("/repository/browse")) {
                            str = data.getQueryParameter("fdfilter");
                            schemeSpecificPart2 = data.getQueryParameter("fdid");
                            break;
                        } else {
                            if (!"/app".equals(data.getPath())) {
                                "/packages".equals(data.getPath());
                            }
                            schemeSpecificPart2 = null;
                            break;
                        }
                    case '\b':
                        schemeSpecificPart2 = data.getQueryParameter("id");
                        break;
                    default:
                        schemeSpecificPart2 = null;
                        break;
                }
            } else {
                return;
            }
        } else if ("fdroid.app".equals(scheme)) {
            schemeSpecificPart2 = data.getSchemeSpecificPart();
        } else {
            if ("fdroid.search".equals(scheme)) {
                schemeSpecificPart = data.getSchemeSpecificPart();
                String str2222 = str;
                str = schemeSpecificPart;
                schemeSpecificPart2 = str2222;
            }
            schemeSpecificPart2 = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("pname:")) {
                schemeSpecificPart2 = str.split(":")[1];
            }
            if (str.contains(":")) {
                str = str.split(":")[1];
            }
        }
        if (!TextUtils.isEmpty(schemeSpecificPart2)) {
            String replaceAll = schemeSpecificPart2.replaceAll("[^A-Za-z\\d_.]", "");
            Utils.debugLog(TAG, "FDroid launched via app link for '" + replaceAll + "'");
            Intent intent2 = new Intent(this, AppDetailsActivity.class);
            intent2.putExtra(AppDetailsActivity.EXTRA_APPID, replaceAll);
            startActivity(intent2);
            finish();
        } else if (TextUtils.isEmpty(str)) {
        } else {
            Utils.debugLog(TAG, "FDroid launched via search link for '" + str + "'");
            performSearch(str);
        }
    }

    static String sanitizeSearchTerms(String str) {
        return str.replaceAll("[^\\p{L}\\d_ -]", " ");
    }

    private void performSearch(String str) {
        Intent intent = new Intent(this, AppListActivity.class);
        intent.putExtra(AppListActivity.EXTRA_SEARCH_TERMS, sanitizeSearchTerms(str));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUpdatesBadge(int i) {
        if (i <= 0) {
            this.updatesBadge.setVisible(false);
            this.updatesBadge.clearNumber();
            return;
        }
        this.updatesBadge.setNumber(i);
        this.updatesBadge.setVisible(true);
    }

    /* loaded from: classes2.dex */
    private static class NonScrollingHorizontalLayoutManager extends LinearLayoutManager {
        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }

        NonScrollingHorizontalLayoutManager(Context context) {
            super(context, 0, false);
        }
    }
}
