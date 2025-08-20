package org.fdroid.fdroid.views;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.util.ObjectsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.preference.SeekBarPreference;
import androidx.preference.SwitchPreferenceCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.CoreConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import info.guardianproject.netcipher.proxy.OrbotHelper;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.fdroid.fdroid.AppUpdateStatusManager;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.Languages;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.RepoUpdateManager;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.installer.InstallHistoryService;
import org.fdroid.fdroid.installer.PrivilegedInstaller;
import org.fdroid.fdroid.installer.SessionInstallManager;
import org.fdroid.fdroid.views.LiveSeekBarPreference;
import org.fdroid.fdroid.work.CleanCacheWorker;
import org.fdroid.fdroid.work.FDroidMetricsWorker;
import org.fdroid.fdroid.work.RepoUpdateWorker;
/* loaded from: classes2.dex */
public class PreferencesFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final int REQUEST_INSTALL_ORBOT = 4660;
    public static final String TAG = "PreferencesFragment";
    private long currentKeepCacheTime;
    private SwitchPreferenceCompat enableProxyCheckPref;
    private RequestManager glideRequestManager;
    private Preference installHistoryPref;
    private Preference ipfsGateways;
    private SwitchPreferenceCompat keepInstallHistoryPref;
    private PreferenceGroup otherPrefGroup;
    private LiveSeekBarPreference overDataSeekBar;
    private LiveSeekBarPreference overWifiSeekBar;
    private RepoUpdateManager repoUpdateManager;
    private SwitchPreferenceCompat sendToFDroidMetricsPref;
    private LinearSmoothScroller topScroller;
    private Preference updateAutoDownloadPref;
    private LiveSeekBarPreference updateIntervalSeekBar;
    private SwitchPreferenceCompat useDnsCacheCheckPref;
    private SwitchPreferenceCompat useTorCheckPref;
    private static final String[] SUMMARIES_TO_UPDATE = {Preferences.PREF_OVER_WIFI, Preferences.PREF_OVER_DATA, Preferences.PREF_UPDATE_INTERVAL, Preferences.PREF_UPDATE_NOTIFICATION_ENABLED, Preferences.PREF_SHOW_ANTI_FEATURES, Preferences.PREF_SHOW_INCOMPAT_VERSIONS, Preferences.PREF_THEME, Preferences.PREF_USE_PURE_BLACK_DARK_THEME, Preferences.PREF_FORCE_TOUCH_APPS, Preferences.PREF_LOCAL_REPO_NAME, Preferences.PREF_LANGUAGE, Preferences.PREF_KEEP_CACHE_TIME, Preferences.PREF_EXPERT, Preferences.PREF_PRIVILEGED_INSTALLER, Preferences.PREF_ENABLE_PROXY, Preferences.PREF_PROXY_HOST, Preferences.PREF_PROXY_PORT};
    private static final int[] UPDATE_INTERVAL_NAMES = {R.string.interval_never, R.string.interval_2w, R.string.interval_1w, R.string.interval_1d, R.string.interval_12h, R.string.interval_4h, R.string.interval_1h};
    private long nextUpdateCheck = Preferences.UPDATE_INTERVAL_DISABLED;
    private final Preference.OnPreferenceClickListener aboutPrefClickedListener = new Preference.OnPreferenceClickListener() { // from class: org.fdroid.fdroid.views.PreferencesFragment$$ExternalSyntheticLambda3
        @Override // androidx.preference.Preference.OnPreferenceClickListener
        public final boolean onPreferenceClick(Preference preference) {
            boolean lambda$new$2;
            lambda$new$2 = PreferencesFragment.this.lambda$new$2(preference);
            return lambda$new$2;
        }
    };
    private final Preference.OnPreferenceChangeListener useTorChangedListener = new Preference.OnPreferenceChangeListener() { // from class: org.fdroid.fdroid.views.PreferencesFragment.2
        @Override // androidx.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (((Boolean) obj).booleanValue()) {
                PreferencesFragment.this.enableProxyCheckPref.setChecked(false);
                AppCompatActivity appCompatActivity = (AppCompatActivity) PreferencesFragment.this.requireActivity();
                if (OrbotHelper.isOrbotInstalled(appCompatActivity)) {
                    return true;
                }
                appCompatActivity.startActivityForResult(OrbotHelper.getOrbotInstallIntent(appCompatActivity), PreferencesFragment.REQUEST_INSTALL_ORBOT);
                return true;
            }
            return true;
        }
    };
    private final Preference.OnPreferenceChangeListener proxyEnabledChangedListener = new Preference.OnPreferenceChangeListener() { // from class: org.fdroid.fdroid.views.PreferencesFragment.3
        @Override // androidx.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (((Boolean) obj).booleanValue()) {
                PreferencesFragment.this.useTorCheckPref.setChecked(false);
                return true;
            }
            return true;
        }
    };

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        CreationExtras creationExtras;
        creationExtras = CreationExtras.Empty.INSTANCE;
        return creationExtras;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        Preferences preferences = Preferences.get();
        preferences.migrateOldPreferences();
        addPreferencesFromResource(R.xml.preferences);
        this.otherPrefGroup = (PreferenceGroup) findPreference("pref_category_other");
        this.repoUpdateManager = FDroidApp.getRepoUpdateManager(requireContext());
        Preference findPreference = findPreference("pref_about");
        if (findPreference != null) {
            findPreference.setOnPreferenceClickListener(this.aboutPrefClickedListener);
        }
        this.keepInstallHistoryPref = (SwitchPreferenceCompat) findPreference(Preferences.PREF_KEEP_INSTALL_HISTORY);
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) ObjectsCompat.requireNonNull((SwitchPreferenceCompat) findPreference(Preferences.PREF_SEND_TO_FDROID_METRICS));
        this.sendToFDroidMetricsPref = switchPreferenceCompat;
        switchPreferenceCompat.setEnabled(this.keepInstallHistoryPref.isChecked());
        Preference preference = (Preference) ObjectsCompat.requireNonNull(findPreference("installHistory"));
        this.installHistoryPref = preference;
        preference.setVisible(this.keepInstallHistoryPref.isChecked());
        if (preferences.isSendingToFDroidMetrics()) {
            this.installHistoryPref.setTitle(R.string.install_history_and_metrics);
        } else {
            this.installHistoryPref.setTitle(R.string.install_history);
        }
        this.useDnsCacheCheckPref = (SwitchPreferenceCompat) ObjectsCompat.requireNonNull((SwitchPreferenceCompat) findPreference(Preferences.PREF_USE_DNS_CACHE));
        SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) ObjectsCompat.requireNonNull((SwitchPreferenceCompat) findPreference(Preferences.PREF_USE_TOR));
        this.useTorCheckPref = switchPreferenceCompat2;
        switchPreferenceCompat2.setOnPreferenceChangeListener(this.useTorChangedListener);
        SwitchPreferenceCompat switchPreferenceCompat3 = (SwitchPreferenceCompat) ObjectsCompat.requireNonNull((SwitchPreferenceCompat) findPreference(Preferences.PREF_ENABLE_PROXY));
        this.enableProxyCheckPref = switchPreferenceCompat3;
        switchPreferenceCompat3.setOnPreferenceChangeListener(this.proxyEnabledChangedListener);
        this.updateAutoDownloadPref = findPreference(Preferences.PREF_AUTO_DOWNLOAD_INSTALL_UPDATES);
        LiveSeekBarPreference liveSeekBarPreference = (LiveSeekBarPreference) ObjectsCompat.requireNonNull((LiveSeekBarPreference) findPreference(Preferences.PREF_OVER_WIFI));
        this.overWifiSeekBar = liveSeekBarPreference;
        liveSeekBarPreference.setSeekBarLiveUpdater(new LiveSeekBarPreference.SeekBarLiveUpdater() { // from class: org.fdroid.fdroid.views.PreferencesFragment$$ExternalSyntheticLambda5
            @Override // org.fdroid.fdroid.views.LiveSeekBarPreference.SeekBarLiveUpdater
            public final String seekBarUpdated(int i) {
                String networkSeekBarSummary;
                networkSeekBarSummary = PreferencesFragment.this.getNetworkSeekBarSummary(i);
                return networkSeekBarSummary;
            }
        });
        LiveSeekBarPreference liveSeekBarPreference2 = (LiveSeekBarPreference) ObjectsCompat.requireNonNull((LiveSeekBarPreference) findPreference(Preferences.PREF_OVER_DATA));
        this.overDataSeekBar = liveSeekBarPreference2;
        liveSeekBarPreference2.setSeekBarLiveUpdater(new LiveSeekBarPreference.SeekBarLiveUpdater() { // from class: org.fdroid.fdroid.views.PreferencesFragment$$ExternalSyntheticLambda5
            @Override // org.fdroid.fdroid.views.LiveSeekBarPreference.SeekBarLiveUpdater
            public final String seekBarUpdated(int i) {
                String networkSeekBarSummary;
                networkSeekBarSummary = PreferencesFragment.this.getNetworkSeekBarSummary(i);
                return networkSeekBarSummary;
            }
        });
        LiveSeekBarPreference liveSeekBarPreference3 = (LiveSeekBarPreference) ObjectsCompat.requireNonNull((LiveSeekBarPreference) findPreference(Preferences.PREF_UPDATE_INTERVAL));
        this.updateIntervalSeekBar = liveSeekBarPreference3;
        liveSeekBarPreference3.setSeekBarLiveUpdater(new LiveSeekBarPreference.SeekBarLiveUpdater() { // from class: org.fdroid.fdroid.views.PreferencesFragment$$ExternalSyntheticLambda6
            @Override // org.fdroid.fdroid.views.LiveSeekBarPreference.SeekBarLiveUpdater
            public final String seekBarUpdated(int i) {
                String updateIntervalSeekbarSummary;
                updateIntervalSeekbarSummary = PreferencesFragment.this.getUpdateIntervalSeekbarSummary(i);
                return updateIntervalSeekbarSummary;
            }
        });
        this.ipfsGateways = (Preference) ObjectsCompat.requireNonNull(findPreference("ipfsGateways"));
        updateIpfsGatewaySummary();
        ListPreference listPreference = (ListPreference) ObjectsCompat.requireNonNull((ListPreference) findPreference(Preferences.PREF_LANGUAGE));
        if (Build.VERSION.SDK_INT >= 24) {
            ((PreferenceCategory) ObjectsCompat.requireNonNull((PreferenceCategory) findPreference("pref_category_display"))).removePreference(listPreference);
        } else {
            Languages languages = Languages.get((AppCompatActivity) getActivity());
            listPreference.setDefaultValue("");
            listPreference.setEntries(languages.getAllNames());
            listPreference.setEntryValues(languages.getSupportedLocales());
        }
        if (requireActivity().getPackageManager().hasSystemFeature("android.hardware.touchscreen")) {
            ((PreferenceCategory) ObjectsCompat.requireNonNull((PreferenceCategory) findPreference("pref_category_appcompatibility"))).removePreference((Preference) ObjectsCompat.requireNonNull(findPreference(Preferences.PREF_FORCE_TOUCH_APPS)));
        }
        this.topScroller = new LinearSmoothScroller(requireActivity()) { // from class: org.fdroid.fdroid.views.PreferencesFragment.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int getVerticalSnapPreference() {
                return -1;
            }
        };
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.repoUpdateManager.getNextUpdateLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: org.fdroid.fdroid.views.PreferencesFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PreferencesFragment.this.lambda$onViewCreated$0((Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(Long l) {
        this.nextUpdateCheck = l.longValue();
        updateSummary(Preferences.PREF_UPDATE_INTERVAL, false);
    }

    private void checkSummary(String str, int i) {
        Preference findPreference = findPreference(str);
        if (findPreference != null) {
            findPreference.setSummary(i);
        }
    }

    private void entrySummary(String str) {
        ListPreference listPreference = (ListPreference) findPreference(str);
        if (listPreference != null) {
            listPreference.setSummary(listPreference.getEntry());
        }
    }

    private void textSummary(String str, int i) {
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(str);
        if (editTextPreference != null) {
            editTextPreference.setSummary(getString(i, editTextPreference.getText()));
            return;
        }
        Utils.debugLog(TAG, "null preference found for " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getNetworkSeekBarSummary(int i) {
        if (i == 0) {
            return getString(R.string.over_network_never_summary);
        }
        if (i == 1) {
            return getString(R.string.over_network_on_demand_summary);
        }
        if (i == 2) {
            return getString(R.string.over_network_always_summary);
        }
        throw new IllegalArgumentException("Unknown seekbar position");
    }

    private void setNetworkSeekBarSummary(SeekBarPreference seekBarPreference) {
        seekBarPreference.setSummary(getNetworkSeekBarSummary(seekBarPreference.getValue()));
    }

    private void enableUpdateInterval() {
        if (this.overWifiSeekBar.getValue() == 0 && this.overDataSeekBar.getValue() == 0) {
            this.updateIntervalSeekBar.setEnabled(false);
            this.updateIntervalSeekBar.setSummary(UPDATE_INTERVAL_NAMES[0]);
            return;
        }
        this.updateIntervalSeekBar.setEnabled(true);
        LiveSeekBarPreference liveSeekBarPreference = this.updateIntervalSeekBar;
        liveSeekBarPreference.setSummary(getUpdateIntervalSeekbarSummary(liveSeekBarPreference.getValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUpdateIntervalSeekbarSummary(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(getString(UPDATE_INTERVAL_NAMES[i]));
        long j = this.nextUpdateCheck;
        if (j < 0) {
            sb.append("\n");
            sb.append(getString(R.string.auto_update_time_past));
        } else if (j < Preferences.UPDATE_INTERVAL_DISABLED) {
            sb.append("\n");
            sb.append(getString(R.string.auto_update_time, DateUtils.getRelativeTimeSpanString(this.nextUpdateCheck, System.currentTimeMillis(), CoreConstants.MILLIS_IN_ONE_MINUTE, PKIFailureInfo.transactionIdInUse)));
        } else if (i != 0) {
            sb.append("\n");
            sb.append(getString(R.string.auto_update_time, getString(R.string.repositories_last_update_never)));
        }
        return sb.toString();
    }

    private void updateSummary(String str, boolean z) {
        AppCompatActivity appCompatActivity;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2016772754:
                if (str.equals(Preferences.PREF_LOCAL_REPO_HTTPS)) {
                    c = 0;
                    break;
                }
                break;
            case -1925409547:
                if (str.equals(Preferences.PREF_PRIVILEGED_INSTALLER)) {
                    c = 1;
                    break;
                }
                break;
            case -1866012248:
                if (str.equals(Preferences.PREF_LOCAL_REPO_NAME)) {
                    c = 2;
                    break;
                }
                break;
            case -1789270358:
                if (str.equals(Preferences.PREF_SEND_TO_FDROID_METRICS)) {
                    c = 3;
                    break;
                }
                break;
            case -1613589672:
                if (str.equals(Preferences.PREF_LANGUAGE)) {
                    c = 4;
                    break;
                }
                break;
            case -1612110023:
                if (str.equals(Preferences.PREF_FORCE_TOUCH_APPS)) {
                    c = 5;
                    break;
                }
                break;
            case -1578654285:
                if (str.equals(Preferences.PREF_USE_PURE_BLACK_DARK_THEME)) {
                    c = 6;
                    break;
                }
                break;
            case -1525115020:
                if (str.equals(Preferences.PREF_SHOW_INCOMPAT_VERSIONS)) {
                    c = 7;
                    break;
                }
                break;
            case -1515401890:
                if (str.equals(Preferences.PREF_KEEP_INSTALL_HISTORY)) {
                    c = '\b';
                    break;
                }
                break;
            case -1442730325:
                if (str.equals(Preferences.PREF_ENABLE_PROXY)) {
                    c = '\t';
                    break;
                }
                break;
            case -1289163222:
                if (str.equals(Preferences.PREF_EXPERT)) {
                    c = '\n';
                    break;
                }
                break;
            case -1087946382:
                if (str.equals(Preferences.PREF_UPDATE_NOTIFICATION_ENABLED)) {
                    c = 11;
                    break;
                }
                break;
            case -476361418:
                if (str.equals(Preferences.PREF_PROXY_HOST)) {
                    c = '\f';
                    break;
                }
                break;
            case -476123121:
                if (str.equals(Preferences.PREF_PROXY_PORT)) {
                    c = '\r';
                    break;
                }
                break;
            case 100410716:
                if (str.equals(Preferences.PREF_SHOW_ANTI_FEATURES)) {
                    c = 14;
                    break;
                }
                break;
            case 110327241:
                if (str.equals(Preferences.PREF_THEME)) {
                    c = 15;
                    break;
                }
                break;
            case 510154892:
                if (str.equals(Preferences.PREF_KEEP_CACHE_TIME)) {
                    c = 16;
                    break;
                }
                break;
            case 528619166:
                if (str.equals(Preferences.PREF_OVER_DATA)) {
                    c = 17;
                    break;
                }
                break;
            case 529192457:
                if (str.equals(Preferences.PREF_OVER_WIFI)) {
                    c = 18;
                    break;
                }
                break;
            case 1485320758:
                if (str.equals(Preferences.PREF_UPDATE_INTERVAL)) {
                    c = 19;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                checkSummary(str, R.string.local_repo_https_on);
                return;
            case 1:
                if (((SwitchPreferenceCompat) findPreference(Preferences.PREF_PRIVILEGED_INSTALLER)) != null) {
                    checkSummary(str, R.string.system_installer_on);
                    return;
                }
                return;
            case 2:
                textSummary(str, R.string.local_repo_name_summary);
                return;
            case 3:
                setFDroidMetricsWorker();
                return;
            case 4:
                entrySummary(str);
                if (z) {
                    AppCompatActivity appCompatActivity2 = (AppCompatActivity) requireActivity();
                    Languages.setLanguage(appCompatActivity2);
                    FDroidApp.onLanguageChanged(appCompatActivity2.getApplicationContext());
                    Languages.forceChangeLanguage(appCompatActivity2);
                    return;
                }
                return;
            case 5:
                checkSummary(str, R.string.force_touch_apps_on);
                return;
            case 6:
                if (!z || (appCompatActivity = (AppCompatActivity) getActivity()) == null) {
                    return;
                }
                ActivityCompat.recreate(appCompatActivity);
                return;
            case 7:
                checkSummary(str, R.string.show_incompat_versions_on);
                return;
            case '\b':
                if (this.keepInstallHistoryPref.isChecked()) {
                    InstallHistoryService.register(getActivity());
                    this.installHistoryPref.setVisible(true);
                    this.sendToFDroidMetricsPref.setEnabled(true);
                } else {
                    InstallHistoryService.unregister(getActivity());
                    this.installHistoryPref.setVisible(false);
                    this.sendToFDroidMetricsPref.setEnabled(false);
                }
                setFDroidMetricsWorker();
                return;
            case '\t':
                ((SwitchPreferenceCompat) ObjectsCompat.requireNonNull((SwitchPreferenceCompat) findPreference(str))).setSummary(R.string.enable_proxy_summary);
                return;
            case '\n':
                checkSummary(str, R.string.expert_on);
                boolean expertMode = Preferences.get().expertMode();
                int i = 0;
                for (int i2 = 0; i2 < this.otherPrefGroup.getPreferenceCount(); i2++) {
                    Preference preference = this.otherPrefGroup.getPreference(i2);
                    if (TextUtils.equals(Preferences.PREF_EXPERT, preference.getDependency())) {
                        preference.setVisible(expertMode);
                        i++;
                    }
                }
                if (z) {
                    RecyclerView listView = getListView();
                    this.topScroller.setTargetPosition((listView.getAdapter().getItemCount() - (expertMode ? i : 0)) - 1);
                    listView.getLayoutManager().startSmoothScroll(this.topScroller);
                    return;
                }
                return;
            case 11:
                checkSummary(str, R.string.notify_on);
                return;
            case '\f':
                EditTextPreference editTextPreference = (EditTextPreference) ObjectsCompat.requireNonNull((EditTextPreference) findPreference(str));
                String proxyHost = Preferences.get().getProxyHost();
                if (TextUtils.isEmpty(proxyHost) || proxyHost.equals(Preferences.DEFAULT_PROXY_HOST)) {
                    editTextPreference.setSummary(R.string.proxy_host_summary);
                    return;
                } else {
                    editTextPreference.setSummary(proxyHost);
                    return;
                }
            case '\r':
                EditTextPreference editTextPreference2 = (EditTextPreference) ObjectsCompat.requireNonNull((EditTextPreference) findPreference(str));
                int proxyPort = Preferences.get().getProxyPort();
                if (proxyPort == 8118) {
                    editTextPreference2.setSummary(R.string.proxy_port_summary);
                    return;
                } else {
                    editTextPreference2.setSummary(String.valueOf(proxyPort));
                    return;
                }
            case 14:
                checkSummary(str, R.string.show_anti_feature_apps_on);
                return;
            case 15:
                entrySummary(str);
                if (z) {
                    FDroidApp.applyTheme();
                    return;
                }
                return;
            case 16:
                entrySummary(str);
                if (!z || this.currentKeepCacheTime == Preferences.get().getKeepCacheTime()) {
                    return;
                }
                CleanCacheWorker.schedule(requireContext());
                return;
            case 17:
                this.overDataSeekBar.setMax(2);
                setNetworkSeekBarSummary(this.overDataSeekBar);
                enableUpdateInterval();
                return;
            case 18:
                this.overWifiSeekBar.setMax(2);
                setNetworkSeekBarSummary(this.overWifiSeekBar);
                enableUpdateInterval();
                return;
            case 19:
                this.updateIntervalSeekBar.setMax(Preferences.UPDATE_INTERVAL_VALUES.length - 1);
                this.updateIntervalSeekBar.setSummary(getUpdateIntervalSeekbarSummary(this.updateIntervalSeekBar.getValue()));
                return;
            default:
                return;
        }
    }

    private void setFDroidMetricsWorker() {
        if (this.sendToFDroidMetricsPref.isEnabled() && this.sendToFDroidMetricsPref.isChecked()) {
            FDroidMetricsWorker.schedule(getContext());
        } else {
            FDroidMetricsWorker.cancel(getContext());
        }
    }

    private void updateIpfsGatewaySummary() {
        Preferences preferences = Preferences.get();
        if (preferences.isIpfsEnabled()) {
            int size = preferences.getActiveIpfsGateways().size();
            this.ipfsGateways.setSummary(getResources().getQuantityString(R.plurals.ipfsgw_summary, size, Integer.valueOf(size)));
            return;
        }
        this.ipfsGateways.setSummary(getString(R.string.ipfsgw_summary_disabled));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$2(Preference preference) {
        View inflate = getLayoutInflater().inflate(R.layout.about, (ViewGroup) null);
        Context requireContext = requireContext();
        String versionName = Utils.getVersionName(requireContext);
        if (versionName != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.version);
            textView.setText(versionName);
            textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: org.fdroid.fdroid.views.PreferencesFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean lambda$new$1;
                    lambda$new$1 = PreferencesFragment.lambda$new$1(view);
                    return lambda$new$1;
                }
            });
        }
        new MaterialAlertDialogBuilder(requireContext).setView(inflate).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$1(View view) {
        throw new RuntimeException("BOOM!");
    }

    private void initPrivilegedInstallerPreference() {
        final SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(Preferences.PREF_PRIVILEGED_INSTALLER);
        if (switchPreferenceCompat == null) {
            return;
        }
        boolean isPrivilegedInstallerEnabled = Preferences.get().isPrivilegedInstallerEnabled();
        if (PrivilegedInstaller.isExtensionInstalledCorrectly(getActivity()) != 1) {
            this.otherPrefGroup.removePreference(switchPreferenceCompat);
            return;
        }
        switchPreferenceCompat.setEnabled(true);
        switchPreferenceCompat.setDefaultValue(Boolean.TRUE);
        switchPreferenceCompat.setChecked(isPrivilegedInstallerEnabled);
        switchPreferenceCompat.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: org.fdroid.fdroid.views.PreferencesFragment$$ExternalSyntheticLambda2
            @Override // androidx.preference.Preference.OnPreferenceClickListener
            public final boolean onPreferenceClick(Preference preference) {
                boolean lambda$initPrivilegedInstallerPreference$3;
                lambda$initPrivilegedInstallerPreference$3 = PreferencesFragment.lambda$initPrivilegedInstallerPreference$3(SwitchPreferenceCompat.this, preference);
                return lambda$initPrivilegedInstallerPreference$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$initPrivilegedInstallerPreference$3(SwitchPreferenceCompat switchPreferenceCompat, Preference preference) {
        SharedPreferences.Editor edit = switchPreferenceCompat.getSharedPreferences().edit();
        if (switchPreferenceCompat.isChecked()) {
            edit.remove(Preferences.PREF_PRIVILEGED_INSTALLER);
        } else {
            edit.putBoolean(Preferences.PREF_PRIVILEGED_INSTALLER, false);
        }
        edit.apply();
        return true;
    }

    private void initAutoFetchUpdatesPreference() {
        this.updateAutoDownloadPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: org.fdroid.fdroid.views.PreferencesFragment$$ExternalSyntheticLambda1
            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                boolean lambda$initAutoFetchUpdatesPreference$4;
                lambda$initAutoFetchUpdatesPreference$4 = PreferencesFragment.this.lambda$initAutoFetchUpdatesPreference$4(preference, obj);
                return lambda$initAutoFetchUpdatesPreference$4;
            }
        });
        if (PrivilegedInstaller.isDefault(getActivity()) || SessionInstallManager.canBeUsed(getContext())) {
            this.updateAutoDownloadPref.setTitle(R.string.update_auto_install);
            this.updateAutoDownloadPref.setSummary(R.string.update_auto_install_summary);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initAutoFetchUpdatesPreference$4(Preference preference, Object obj) {
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            AppUpdateStatusManager.getInstance(getActivity()).checkForUpdatesAndInstall();
            return true;
        }
        return true;
    }

    private void initUseDnsCachePreference() {
        this.useDnsCacheCheckPref.setDefaultValue(Boolean.FALSE);
        this.useDnsCacheCheckPref.setChecked(Preferences.get().isDnsCacheEnabled());
    }

    private void initUseTorPreference(Context context) {
        this.useTorCheckPref.setDefaultValue(Boolean.valueOf(OrbotHelper.isOrbotInstalled(context)));
        this.useTorCheckPref.setChecked(Preferences.get().isTorEnabled());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        for (String str : SUMMARIES_TO_UPDATE) {
            updateSummary(str, false);
        }
        this.currentKeepCacheTime = Preferences.get().getKeepCacheTime();
        initAutoFetchUpdatesPreference();
        initPrivilegedInstallerPreference();
        initUseDnsCachePreference();
        initUseTorPreference(requireContext().getApplicationContext());
        updateIpfsGatewaySummary();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        FDroidApp.configureProxy(Preferences.get());
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        updateSummary(str, true);
        if (str.equals(Preferences.PREF_PREVENT_SCREENSHOTS)) {
            if (Preferences.get().preventScreenshots()) {
                requireActivity().getWindow().addFlags(8192);
            } else {
                requireActivity().getWindow().clearFlags(8192);
            }
        } else if (Preferences.PREF_SEND_TO_FDROID_METRICS.equals(str)) {
            if (Preferences.get().isSendingToFDroidMetrics()) {
                Toast.makeText(getContext(), getString(R.string.toast_metrics_in_install_history, requireContext().getString(R.string.app_name)), 1).show();
                this.installHistoryPref.setTitle(R.string.install_history_and_metrics);
                Intent intent = new Intent(getActivity(), InstallHistoryActivity.class);
                intent.putExtra("showFDroidMetrics", true);
                startActivity(intent);
                return;
            }
            this.installHistoryPref.setTitle(R.string.install_history);
        } else if (Preferences.PREF_OVER_DATA.equals(str) || Preferences.PREF_OVER_WIFI.equals(str)) {
            if (this.glideRequestManager == null) {
                this.glideRequestManager = Glide.with(requireContext());
            }
            this.glideRequestManager.applyDefaultRequestOptions((RequestOptions) new RequestOptions().onlyRetrieveFromCache(Preferences.get().isBackgroundDownloadAllowed()));
            RepoUpdateWorker.scheduleOrCancel(requireContext());
        } else if (Preferences.PREF_UPDATE_INTERVAL.equals(str)) {
            RepoUpdateWorker.scheduleOrCancel(requireContext());
        }
    }
}
