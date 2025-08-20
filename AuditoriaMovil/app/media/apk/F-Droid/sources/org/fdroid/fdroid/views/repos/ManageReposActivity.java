package org.fdroid.fdroid.views.repos;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.util.Consumer;
import androidx.core.util.Supplier;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.CoreConstants;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.AppUpdateStatusManager;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.views.repos.RepoAdapter;
import org.fdroid.fdroid.work.RepoUpdateWorker;
import org.fdroid.index.RepoManager;
/* loaded from: classes2.dex */
public class ManageReposActivity extends AppCompatActivity implements RepoAdapter.RepoItemListener {
    private RepoManager repoManager;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final RepoAdapter repoAdapter = new RepoAdapter(this);
    private boolean isItemReorderingEnabled = false;
    private final ItemTouchHelper.Callback itemTouchCallback = new ItemTouchHelper.SimpleCallback(3, 0) { // from class: org.fdroid.fdroid.views.repos.ManageReposActivity.1
        private int lastFromPos = -1;
        private int lastToPos = -1;

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
            int bindingAdapterPosition2 = viewHolder2.getBindingAdapterPosition();
            ManageReposActivity.this.repoAdapter.notifyItemMoved(bindingAdapterPosition, bindingAdapterPosition2);
            if (this.lastFromPos == -1) {
                this.lastFromPos = bindingAdapterPosition;
            }
            this.lastToPos = bindingAdapterPosition2;
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            super.onSelectedChanged(viewHolder, i);
            if (i == 0) {
                if (this.lastFromPos != this.lastToPos) {
                    Repository item = ManageReposActivity.this.repoAdapter.getItem(this.lastFromPos);
                    Repository item2 = ManageReposActivity.this.repoAdapter.getItem(this.lastToPos);
                    if (item != null && item2 != null) {
                        ManageReposActivity.this.isItemReorderingEnabled = false;
                        ManageReposActivity.this.repoManager.reorderRepositories(item, item2);
                    } else {
                        Log.w("ManageReposActivity", "Could not find one of the repos: " + this.lastFromPos + " to " + this.lastToPos);
                    }
                }
                this.lastFromPos = -1;
                this.lastToPos = -1;
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return ManageReposActivity.this.isItemReorderingEnabled;
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Object relativeTimeSpanString;
        FDroidApp fDroidApp = (FDroidApp) getApplication();
        fDroidApp.setSecureWindow(this);
        fDroidApp.applyPureBlackBackgroundInDarkTheme(this);
        this.repoManager = FDroidApp.getRepoManager(this);
        super.onCreate(bundle);
        setContentView(R.layout.repo_list_activity);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        setSupportActionBar(materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        long lastUpdateCheck = Preferences.get().getLastUpdateCheck();
        if (lastUpdateCheck < 0) {
            relativeTimeSpanString = getString(R.string.repositories_last_update_never);
        } else {
            relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(lastUpdateCheck, System.currentTimeMillis(), CoreConstants.MILLIS_IN_ONE_MINUTE, PKIFailureInfo.signerNotTrusted);
        }
        getSupportActionBar().setSubtitle(getString(R.string.repositories_last_update, relativeTimeSpanString));
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.ManageReposActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageReposActivity.this.lambda$onCreate$0(view);
            }
        });
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.ManageReposActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageReposActivity.this.lambda$onCreate$1(view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        new ItemTouchHelper(this.itemTouchCallback).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(this.repoAdapter);
        FDroidApp.getRepoManager(this).getLiveRepositories().observe(this, new Observer() { // from class: org.fdroid.fdroid.views.repos.ManageReposActivity$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ManageReposActivity.this.lambda$onCreate$2((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent(this, AddRepoActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        Intent parentActivityIntent = NavUtils.getParentActivityIntent(this);
        if (NavUtils.shouldUpRecreateTask(this, parentActivityIntent) || isTaskRoot()) {
            TaskStackBuilder.create(this).addNextIntentWithParentStack(parentActivityIntent).startActivities();
        } else {
            NavUtils.navigateUpTo(this, parentActivityIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(List list) {
        this.repoAdapter.updateItems(new ArrayList(list));
        this.isItemReorderingEnabled = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.compositeDisposable.dispose();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // org.fdroid.fdroid.views.repos.RepoAdapter.RepoItemListener
    public void onClicked(Repository repository) {
        RepoDetailsActivity.launch(this, repository.getRepoId());
    }

    @Override // org.fdroid.fdroid.views.repos.RepoAdapter.RepoItemListener
    public void onToggleEnabled(final Repository repository) {
        if (repository.getEnabled()) {
            new AlertDialog.Builder(this).setMessage(R.string.repo_disable_warning).setPositiveButton(R.string.repo_disable_warning_button, new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.ManageReposActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ManageReposActivity.this.lambda$onToggleEnabled$3(repository, dialogInterface, i);
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.ManageReposActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.fdroid.fdroid.views.repos.ManageReposActivity$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    ManageReposActivity.this.lambda$onToggleEnabled$5(repository, dialogInterface);
                }
            }).show();
        } else {
            Utils.runOffUiThread(new Supplier() { // from class: org.fdroid.fdroid.views.repos.ManageReposActivity$$ExternalSyntheticLambda3
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    Boolean lambda$onToggleEnabled$6;
                    lambda$onToggleEnabled$6 = ManageReposActivity.this.lambda$onToggleEnabled$6(repository);
                    return lambda$onToggleEnabled$6;
                }
            }, new Consumer() { // from class: org.fdroid.fdroid.views.repos.ManageReposActivity$$ExternalSyntheticLambda4
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ManageReposActivity.this.lambda$onToggleEnabled$7(repository, (Boolean) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onToggleEnabled$3(Repository repository, DialogInterface dialogInterface, int i) {
        disableRepo(repository);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onToggleEnabled$5(Repository repository, DialogInterface dialogInterface) {
        this.repoAdapter.updateRepoItem(repository);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$onToggleEnabled$6(Repository repository) {
        this.repoManager.setRepositoryEnabled(repository.getRepoId(), true);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onToggleEnabled$7(Repository repository, Boolean bool) {
        RepoUpdateWorker.updateNow(getApplication(), repository.getRepoId());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.repo_list, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_info) {
            new MaterialAlertDialogBuilder(this).setTitle((CharSequence) getString(R.string.repo_list_info_title)).setMessage((CharSequence) getString(R.string.repo_list_info_text)).setPositiveButton((CharSequence) getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.ManageReposActivity$$ExternalSyntheticLambda8
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void disableRepo(final Repository repository) {
        Utils.runOffUiThread(new Runnable() { // from class: org.fdroid.fdroid.views.repos.ManageReposActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                ManageReposActivity.this.lambda$disableRepo$9(repository);
            }
        });
        AppUpdateStatusManager.getInstance(this).removeAllByRepo(repository.getRepoId());
        Snackbar.make(findViewById(R.id.list), getString(R.string.repo_disabled_notification, repository.getName(App.getLocales())), 0).setTextMaxLines(3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$disableRepo$9(Repository repository) {
        this.repoManager.setRepositoryEnabled(repository.getRepoId(), false);
    }

    public static String getDisallowInstallUnknownSourcesErrorMessage(Context context) {
        UserManager userManager = (UserManager) context.getSystemService("user");
        if (Build.VERSION.SDK_INT >= 29 && userManager.hasUserRestriction("no_install_unknown_sources_globally")) {
            return context.getString(R.string.has_disallow_install_unknown_sources_globally);
        }
        return context.getString(R.string.has_disallow_install_unknown_sources);
    }
}
