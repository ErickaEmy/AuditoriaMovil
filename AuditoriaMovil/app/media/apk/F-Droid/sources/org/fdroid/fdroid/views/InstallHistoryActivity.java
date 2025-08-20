package org.fdroid.fdroid.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat$IntentBuilder;
import com.google.android.material.appbar.MaterialToolbar;
import fi.iki.elonen.NanoHTTPD;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.installer.InstallHistoryService;
import org.fdroid.fdroid.work.FDroidMetricsWorker;
/* loaded from: classes2.dex */
public class InstallHistoryActivity extends AppCompatActivity {
    static final String EXTRA_SHOW_FDROID_METRICS = "showFDroidMetrics";
    public static final String TAG = "InstallHistoryActivity";
    private String appName;
    private MenuItem showMenuItem;
    private boolean showingInstallHistory;
    private TextView textView;
    private MaterialToolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FDroidApp fDroidApp = (FDroidApp) getApplication();
        fDroidApp.setSecureWindow(this);
        fDroidApp.applyPureBlackBackgroundInDarkTheme(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_install_history);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        this.toolbar = materialToolbar;
        setSupportActionBar(materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.textView = (TextView) findViewById(R.id.text);
        this.appName = getString(R.string.app_name);
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra(EXTRA_SHOW_FDROID_METRICS, false)) {
            showFDroidMetricsReport();
        } else {
            showInstallHistory();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showInstallHistory() {
        /*
            r8 = this;
            android.content.ContentResolver r6 = r8.getContentResolver()     // Catch: java.lang.IllegalStateException -> L19 java.lang.SecurityException -> L1b java.io.IOException -> L1d
            android.net.Uri r7 = org.fdroid.fdroid.installer.InstallHistoryService.LOG_URI     // Catch: java.lang.IllegalStateException -> L19 java.lang.SecurityException -> L1b java.io.IOException -> L1d
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r6
            r1 = r7
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.IllegalStateException -> L19 java.lang.SecurityException -> L1b java.io.IOException -> L1d
            if (r0 == 0) goto L1f
            r0.moveToFirst()     // Catch: java.lang.IllegalStateException -> L19 java.lang.SecurityException -> L1b java.io.IOException -> L1d
            r0.close()     // Catch: java.lang.IllegalStateException -> L19 java.lang.SecurityException -> L1b java.io.IOException -> L1d
            goto L1f
        L19:
            r0 = move-exception
            goto L37
        L1b:
            r0 = move-exception
            goto L37
        L1d:
            r0 = move-exception
            goto L37
        L1f:
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r0 = r6.openFileDescriptor(r7, r0)     // Catch: java.lang.IllegalStateException -> L19 java.lang.SecurityException -> L1b java.io.IOException -> L1d
            java.io.FileDescriptor r0 = r0.getFileDescriptor()     // Catch: java.lang.IllegalStateException -> L19 java.lang.SecurityException -> L1b java.io.IOException -> L1d
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.IllegalStateException -> L19 java.lang.SecurityException -> L1b java.io.IOException -> L1d
            r1.<init>(r0)     // Catch: java.lang.IllegalStateException -> L19 java.lang.SecurityException -> L1b java.io.IOException -> L1d
            java.nio.charset.Charset r0 = java.nio.charset.Charset.defaultCharset()     // Catch: java.lang.IllegalStateException -> L19 java.lang.SecurityException -> L1b java.io.IOException -> L1d
            java.lang.String r0 = org.apache.commons.io.IOUtils.toString(r1, r0)     // Catch: java.lang.IllegalStateException -> L19 java.lang.SecurityException -> L1b java.io.IOException -> L1d
            goto L3c
        L37:
            r0.printStackTrace()
            java.lang.String r0 = ""
        L3c:
            com.google.android.material.appbar.MaterialToolbar r1 = r8.toolbar
            int r2 = org.fdroid.fdroid.R.string.install_history
            java.lang.String r2 = r8.getString(r2)
            r1.setTitle(r2)
            android.widget.TextView r1 = r8.textView
            r1.setText(r0)
            r0 = 1
            r8.showingInstallHistory = r0
            android.view.MenuItem r0 = r8.showMenuItem
            if (r0 == 0) goto L65
            org.fdroid.fdroid.Preferences r1 = org.fdroid.fdroid.Preferences.get()
            boolean r1 = r1.isSendingToFDroidMetrics()
            r0.setVisible(r1)
            android.view.MenuItem r0 = r8.showMenuItem
            int r1 = org.fdroid.fdroid.R.string.menu_show_fdroid_metrics_report
            r0.setTitle(r1)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.fdroid.views.InstallHistoryActivity.showInstallHistory():void");
    }

    private void showFDroidMetricsReport() {
        this.toolbar.setTitle(getString(R.string.fdroid_metrics_report, this.appName));
        this.textView.setText(FDroidMetricsWorker.generateReport(this));
        this.showingInstallHistory = false;
        MenuItem menuItem = this.showMenuItem;
        if (menuItem != null) {
            menuItem.setVisible(Preferences.get().isSendingToFDroidMetrics());
            this.showMenuItem.setTitle(R.string.menu_show_install_history);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.install_history, menu);
        MenuItem findItem = menu.findItem(R.id.menu_show);
        this.showMenuItem = findItem;
        findItem.setVisible(Preferences.get().isSendingToFDroidMetrics());
        if (this.showingInstallHistory) {
            this.showMenuItem.setTitle(R.string.menu_show_fdroid_metrics_report);
        } else {
            this.showMenuItem.setTitle(R.string.menu_show_install_history);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_share) {
            ShareCompat$IntentBuilder from = ShareCompat$IntentBuilder.from(this);
            if (this.showingInstallHistory) {
                StringBuilder sb = new StringBuilder();
                sb.append("Repos:\n");
                for (Repository repository : FDroidApp.getRepoManager(this).getRepositories()) {
                    if (repository.getEnabled()) {
                        sb.append("* ");
                        sb.append(repository.getAddress());
                        sb.append('\n');
                    }
                }
                from.setText(sb.toString()).setStream(InstallHistoryService.LOG_URI).setType(NanoHTTPD.MIME_PLAINTEXT).setSubject(getString(R.string.send_history_csv, this.appName)).setChooserTitle(R.string.send_install_history);
            } else {
                from.setText(this.textView.getText()).setType("application/json").setSubject(getString(R.string.send_fdroid_metrics_json, this.appName)).setChooserTitle(R.string.send_fdroid_metrics_report);
            }
            Intent intent = from.getIntent();
            intent.addFlags(1);
            startActivity(intent);
        } else if (itemId == R.id.menu_delete) {
            if (this.showingInstallHistory) {
                getContentResolver().delete(InstallHistoryService.LOG_URI, null, null);
            }
            this.textView.setText("");
        } else if (itemId == R.id.menu_show) {
            if (this.showingInstallHistory) {
                showFDroidMetricsReport();
            } else {
                showInstallHistory();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
