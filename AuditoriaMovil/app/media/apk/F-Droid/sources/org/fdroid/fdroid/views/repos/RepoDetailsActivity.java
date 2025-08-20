package org.fdroid.fdroid.views.repos;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputLayout;
import fi.iki.elonen.NanoHTTPD;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.fdroid.database.AppDao;
import org.fdroid.database.Repository;
import org.fdroid.database.RepositoryDao;
import org.fdroid.download.Mirror;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.compat.LocaleCompat;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.data.DBHelper;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.fdroid.views.apps.AppListActivity;
import org.fdroid.fdroid.views.repos.RepoDetailsActivity;
/* loaded from: classes2.dex */
public class RepoDetailsActivity extends AppCompatActivity {
    static final String ARG_REPO_ID = "repo_id";
    private static final String TAG = "RepoDetailsActivity";
    private MirrorAdapter adapterToNotify;
    private AppDao appDao;
    private Disposable disposable;
    private RepoDetailsViewModel model;
    private Repository repo;
    private long repoId;
    private View repoView;
    private RepositoryDao repositoryDao;
    private String shareUrl;
    private static final int[] SHOW_IF_EXISTS = {R.id.label_repo_name, R.id.text_repo_name, R.id.label_description, R.id.text_description, R.id.label_num_apps, R.id.text_num_apps, R.id.button_view_apps, R.id.label_last_update, R.id.text_last_update, R.id.label_last_update_downloaded, R.id.text_last_update_downloaded, R.id.label_username, R.id.text_username, R.id.button_edit_credentials, R.id.label_repo_fingerprint, R.id.text_repo_fingerprint, R.id.text_repo_fingerprint_description};
    private static final int[] HIDE_IF_EXISTS = {R.id.text_not_yet_updated};

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$promptForDelete$9(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void launch(Context context, long j) {
        Intent intent = new Intent(context, RepoDetailsActivity.class);
        intent.putExtra(ARG_REPO_ID, j);
        context.startActivity(intent);
    }

    private static void setMultipleViewVisibility(View view, int[] iArr, int i) {
        for (int i2 : iArr) {
            view.findViewById(i2).setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FDroidApp fDroidApp = (FDroidApp) getApplication();
        fDroidApp.setSecureWindow(this);
        fDroidApp.applyPureBlackBackgroundInDarkTheme(this);
        this.model = (RepoDetailsViewModel) new ViewModelProvider(this).get(RepoDetailsViewModel.class);
        this.repositoryDao = DBHelper.getDb(this).getRepositoryDao();
        this.appDao = DBHelper.getDb(this).getAppDao();
        super.onCreate(bundle);
        setContentView(R.layout.activity_repo_details);
        setSupportActionBar((MaterialToolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.repoView = findViewById(R.id.repo_view);
        long longExtra = getIntent().getLongExtra(ARG_REPO_ID, 0L);
        this.repoId = longExtra;
        this.model.initRepo(longExtra);
        Repository repository = FDroidApp.getRepoManager(this).getRepository(this.repoId);
        this.repo = repository;
        if (repository == null) {
            finish();
            return;
        }
        ((TextView) findViewById(R.id.input_repo_url)).setText(this.repo.getAddress());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.official_mirror_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Repository repository2 = this.repo;
        MirrorAdapter mirrorAdapter = new MirrorAdapter(repository2, repository2.getAllMirrors(false));
        this.adapterToNotify = mirrorAdapter;
        recyclerView.setAdapter(mirrorAdapter);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.user_mirror_list);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        Repository repository3 = this.repo;
        MirrorAdapter mirrorAdapter2 = new MirrorAdapter(repository3, repository3.getUserMirrors().size());
        mirrorAdapter2.setUserMirrors(this.repo.getUserMirrors());
        recyclerView2.setAdapter(mirrorAdapter2);
        if (this.repo.getAddress().startsWith("content://") || this.repo.getAddress().startsWith("file://")) {
            return;
        }
        Uri parse = Uri.parse(this.repo.getAddress());
        try {
            if (this.repo.getFingerprint() != null) {
                parse = parse.buildUpon().appendQueryParameter(BonjourPeer.FINGERPRINT, this.repo.getFingerprint()).build();
            }
        } catch (Exception unused) {
            Log.e(TAG, "Invalid repo fingerprint: " + this.repo.getAddress());
        }
        this.disposable = Utils.generateQrBitmap(this, parse.toString()).subscribe(new Consumer() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                RepoDetailsActivity.this.lambda$onCreate$0((Bitmap) obj);
            }
        });
        this.model.getRepoLiveData().observe(this, new Observer() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RepoDetailsActivity.this.lambda$onCreate$1((Repository) obj);
            }
        });
        final SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.archiveRepo);
        this.model.getLiveData().observe(this, new Observer() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RepoDetailsActivity.lambda$onCreate$2(SwitchCompat.this, (RepoDetailsState) obj);
            }
        });
        switchCompat.setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepoDetailsActivity.this.lambda$onCreate$3(switchCompat, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(Bitmap bitmap) throws Throwable {
        ImageView imageView = (ImageView) findViewById(R.id.qr_code);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(Repository repository) {
        if (repository == null) {
            finish();
            return;
        }
        this.repo = repository;
        updateRepoView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$2(SwitchCompat switchCompat, RepoDetailsState repoDetailsState) {
        Boolean archiveEnabled = repoDetailsState.getArchiveEnabled();
        if (archiveEnabled == null) {
            switchCompat.setEnabled(false);
            return;
        }
        switchCompat.setEnabled(true);
        switchCompat.setChecked(archiveEnabled.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(SwitchCompat switchCompat, View view) {
        this.model.setArchiveRepoEnabled(this.repo, switchCompat.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Disposable disposable = this.disposable;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.repo = FDroidApp.getRepoManager(this).getRepository(this.repoId);
        updateRepoView();
        processIntent(getIntent());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private void processIntent(Intent intent) {
        if ("android.nfc.action.NDEF_DISCOVERED".equals(intent.getAction())) {
            String str = new String(((NdefMessage) intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES")[0]).getRecords()[0].getPayload());
            Utils.debugLog(TAG, "Got this URL: " + str);
            Toast.makeText(this, "Got this URL: " + str, 1).show();
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent2.setClass(this, ManageReposActivity.class);
            startActivity(intent2);
            finish();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.repo_details_activity, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        } else if (itemId == R.id.menu_delete) {
            promptForDelete();
            return true;
        } else {
            if (itemId == R.id.action_share) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType(NanoHTTPD.MIME_PLAINTEXT);
                intent.putExtra("android.intent.extra.TEXT", this.shareUrl);
                startActivity(Intent.createChooser(intent, getResources().getString(R.string.share_repository)));
            }
            return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        prepareShareMenuItems(menu);
        return true;
    }

    private void prepareShareMenuItems(Menu menu) {
        if (!TextUtils.isEmpty(this.repo.getAddress())) {
            if (!TextUtils.isEmpty(this.repo.getCertificate())) {
                try {
                    this.shareUrl = Uri.parse(this.repo.getAddress()).buildUpon().appendQueryParameter(BonjourPeer.FINGERPRINT, this.repo.getFingerprint()).toString();
                } catch (Exception unused) {
                    Log.e(TAG, "Invalid repo fingerprint: " + this.repo.getAddress());
                    this.shareUrl = this.repo.getAddress();
                }
            } else {
                this.shareUrl = this.repo.getAddress();
            }
            menu.findItem(R.id.action_share).setVisible(true);
            return;
        }
        menu.findItem(R.id.action_share).setVisible(false);
    }

    private void setupDescription(View view, Repository repository) {
        TextView textView = (TextView) view.findViewById(R.id.label_description);
        TextView textView2 = (TextView) view.findViewById(R.id.text_description);
        String description = repository.getDescription(App.getLocales());
        if (description == null || TextUtils.isEmpty(description)) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
            textView2.setText("");
            return;
        }
        textView.setVisibility(0);
        textView2.setVisibility(0);
        textView2.setText(description.replaceAll("\n", " "));
    }

    private void setupRepoFingerprint(View view, Repository repository) {
        String formatFingerprint;
        TextView textView = (TextView) view.findViewById(R.id.text_repo_fingerprint);
        TextView textView2 = (TextView) view.findViewById(R.id.text_repo_fingerprint_description);
        if (TextUtils.isEmpty(repository.getCertificate())) {
            formatFingerprint = getResources().getString(R.string.unsigned);
            textView.setTextColor(ContextCompat.getColor(this, R.color.unsigned));
            textView2.setVisibility(0);
            textView2.setText(getResources().getString(R.string.unsigned_description));
        } else {
            formatFingerprint = Utils.formatFingerprint(this, repository.getFingerprint());
            textView2.setVisibility(8);
        }
        textView.setText(formatFingerprint);
    }

    private void setupCredentials(View view, Repository repository) {
        TextView textView = (TextView) view.findViewById(R.id.label_username);
        TextView textView2 = (TextView) view.findViewById(R.id.text_username);
        Button button = (Button) view.findViewById(R.id.button_edit_credentials);
        button.setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RepoDetailsActivity.this.showChangePasswordDialog(view2);
            }
        });
        if (TextUtils.isEmpty(repository.getUsername())) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
            textView2.setText("");
            button.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView2.setVisibility(0);
        textView2.setText(repository.getUsername());
        button.setVisibility(0);
    }

    private void updateRepoView() {
        TextView textView = (TextView) this.repoView.findViewById(R.id.label_official_mirrors);
        RecyclerView recyclerView = (RecyclerView) this.repoView.findViewById(R.id.official_mirror_list);
        if (this.repo.getAllMirrors().size() > 1) {
            textView.setVisibility(0);
            recyclerView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            recyclerView.setVisibility(8);
        }
        TextView textView2 = (TextView) this.repoView.findViewById(R.id.label_user_mirrors);
        RecyclerView recyclerView2 = (RecyclerView) this.repoView.findViewById(R.id.user_mirror_list);
        if (this.repo.getUserMirrors().size() > 0) {
            textView2.setVisibility(0);
            recyclerView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
            recyclerView2.setVisibility(8);
        }
        if (this.repo.getLastUpdated() != null) {
            updateViewForExistingRepo(this.repoView);
            return;
        }
        setMultipleViewVisibility(this.repoView, HIDE_IF_EXISTS, 0);
        setMultipleViewVisibility(this.repoView, SHOW_IF_EXISTS, 8);
    }

    private void updateViewForExistingRepo(View view) {
        setMultipleViewVisibility(view, SHOW_IF_EXISTS, 0);
        setMultipleViewVisibility(view, HIDE_IF_EXISTS, 8);
        final TextView textView = (TextView) view.findViewById(R.id.text_num_apps);
        TextView textView2 = (TextView) view.findViewById(R.id.button_view_apps);
        TextView textView3 = (TextView) view.findViewById(R.id.text_last_update);
        TextView textView4 = (TextView) view.findViewById(R.id.text_last_update_downloaded);
        ((TextView) view.findViewById(R.id.text_repo_name)).setText(this.repo.getName(App.getLocales()));
        this.disposable = Single.fromCallable(new Callable() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer lambda$updateViewForExistingRepo$4;
                lambda$updateViewForExistingRepo$4 = RepoDetailsActivity.this.lambda$updateViewForExistingRepo$4();
                return lambda$updateViewForExistingRepo$4;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda10
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                RepoDetailsActivity.lambda$updateViewForExistingRepo$5(textView, (Integer) obj);
            }
        });
        if (this.repo.getEnabled()) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RepoDetailsActivity.this.lambda$updateViewForExistingRepo$6(view2);
                }
            });
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        setupDescription(view, this.repo);
        setupRepoFingerprint(view, this.repo);
        setupCredentials(view, this.repo);
        if (this.repo.getTimestamp() == -1) {
            textView3.setText(R.string.unknown);
        } else {
            textView3.setText(DateUtils.formatDateTime(this, this.repo.getTimestamp(), DateUtils.isToday(this.repo.getTimestamp()) ? 1 : 17));
        }
        if (this.repo.getLastUpdated() == null) {
            textView4.setText(R.string.unknown);
        } else {
            textView4.setText(DateUtils.formatDateTime(this, this.repo.getLastUpdated().longValue(), DateUtils.isToday(this.repo.getLastUpdated().longValue()) ? 1 : 17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$updateViewForExistingRepo$4() throws Exception {
        return Integer.valueOf(this.appDao.getNumberOfAppsInRepository(this.repoId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateViewForExistingRepo$5(TextView textView, Integer num) throws Throwable {
        textView.setText(String.format(LocaleCompat.getDefault(), "%d", num));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateViewForExistingRepo$6(View view) {
        Intent intent = new Intent(this, AppListActivity.class);
        intent.putExtra(AppListActivity.EXTRA_REPO_ID, this.repo.getRepoId());
        startActivity(intent);
    }

    private void promptForDelete() {
        new AlertDialog.Builder(this).setTitle(R.string.repo_confirm_delete_title).setMessage(R.string.repo_confirm_delete_body).setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                RepoDetailsActivity.this.lambda$promptForDelete$8(dialogInterface, i);
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                RepoDetailsActivity.lambda$promptForDelete$9(dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$promptForDelete$8(DialogInterface dialogInterface, int i) {
        runOffUiThread(new Callable() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object lambda$promptForDelete$7;
                lambda$promptForDelete$7 = RepoDetailsActivity.this.lambda$promptForDelete$7();
                return lambda$promptForDelete$7;
            }
        });
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$promptForDelete$7() throws Exception {
        this.repositoryDao.deleteRepository(this.repoId);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showChangePasswordDialog(View view) {
        View inflate = getLayoutInflater().inflate(R.layout.login, (ViewGroup) view, false);
        AlertDialog create = new AlertDialog.Builder(this).setView(inflate).create();
        final EditText editText = ((TextInputLayout) inflate.findViewById(R.id.edit_name)).getEditText();
        final EditText editText2 = ((TextInputLayout) inflate.findViewById(R.id.edit_password)).getEditText();
        editText.setText(this.repo.getUsername());
        editText2.requestFocus();
        create.setTitle(R.string.repo_edit_credentials);
        create.setButton(-2, getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        create.setButton(-1, getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                RepoDetailsActivity.this.lambda$showChangePasswordDialog$12(editText, editText2, dialogInterface, i);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showChangePasswordDialog$12(EditText editText, EditText editText2, DialogInterface dialogInterface, int i) {
        final String obj = editText.getText().toString();
        final String obj2 = editText2.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            runOffUiThread(new Callable() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$$ExternalSyntheticLambda12
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Object lambda$showChangePasswordDialog$11;
                    lambda$showChangePasswordDialog$11 = RepoDetailsActivity.this.lambda$showChangePasswordDialog$11(obj, obj2);
                    return lambda$showChangePasswordDialog$11;
                }
            });
            updateRepoView();
            dialogInterface.dismiss();
            return;
        }
        Toast.makeText(this, R.string.repo_error_empty_username, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$showChangePasswordDialog$11(String str, String str2) throws Exception {
        this.repositoryDao.updateUsernameAndPassword(this.repo.getRepoId(), str, str2);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class MirrorAdapter extends RecyclerView.Adapter {
        private final HashSet<String> disabledMirrors;
        private final List<Mirror> mirrors;
        private final Repository repo;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class MirrorViewHolder extends RecyclerView.ViewHolder {
            View view;

            MirrorViewHolder(View view) {
                super(view);
                this.view = view;
            }
        }

        MirrorAdapter(Repository repository, List<Mirror> list) {
            this.repo = repository;
            this.mirrors = list;
            this.disabledMirrors = new HashSet<>(repository.getDisabledMirrors());
        }

        MirrorAdapter(Repository repository, int i) {
            this.repo = repository;
            this.mirrors = new ArrayList(i);
            this.disabledMirrors = new HashSet<>(repository.getDisabledMirrors());
        }

        void setUserMirrors(List<String> list) {
            for (String str : list) {
                this.mirrors.add(new Mirror(str));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MirrorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MirrorViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repo_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MirrorViewHolder mirrorViewHolder, int i) {
            boolean z;
            Mirror mirror = this.mirrors.get(i);
            ((TextView) mirrorViewHolder.view.findViewById(R.id.repo_name)).setText(mirror.getBaseUrl());
            final String baseUrl = mirror.getBaseUrl();
            Iterator<String> it = this.disabledMirrors.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (TextUtils.equals(baseUrl, it.next())) {
                    z = false;
                    break;
                }
            }
            CompoundButton compoundButton = (CompoundButton) mirrorViewHolder.view.findViewById(R.id.repo_switch);
            compoundButton.setOnCheckedChangeListener(null);
            compoundButton.setChecked(z);
            compoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$MirrorAdapter$$ExternalSyntheticLambda1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton2, boolean z2) {
                    RepoDetailsActivity.MirrorAdapter.this.lambda$onBindViewHolder$1(baseUrl, compoundButton2, z2);
                }
            });
            mirrorViewHolder.view.findViewById(R.id.repo_unverified).setVisibility(8);
            mirrorViewHolder.view.findViewById(R.id.repo_unsigned).setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(String str, CompoundButton compoundButton, boolean z) {
            if (z) {
                this.disabledMirrors.remove(str);
            } else {
                this.disabledMirrors.add(str);
            }
            if (this.disabledMirrors.size() == this.repo.getAllMirrors(true).size()) {
                this.disabledMirrors.remove(this.repo.getAddress());
                RepoDetailsActivity.this.adapterToNotify.notifyDataSetChanged();
            }
            final ArrayList arrayList = new ArrayList(this.disabledMirrors);
            RepoDetailsActivity.this.runOffUiThread(new Callable() { // from class: org.fdroid.fdroid.views.repos.RepoDetailsActivity$MirrorAdapter$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Object lambda$onBindViewHolder$0;
                    lambda$onBindViewHolder$0 = RepoDetailsActivity.MirrorAdapter.this.lambda$onBindViewHolder$0(arrayList);
                    return lambda$onBindViewHolder$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$onBindViewHolder$0(ArrayList arrayList) throws Exception {
            RepoDetailsActivity.this.repositoryDao.updateDisabledMirrors(this.repo.getRepoId(), arrayList);
            return Boolean.TRUE;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<Mirror> list = this.mirrors;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOffUiThread(Callable<?> callable) {
        this.disposable = Single.fromCallable(callable).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }
}
