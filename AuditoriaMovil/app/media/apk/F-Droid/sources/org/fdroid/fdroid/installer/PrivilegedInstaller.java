package org.fdroid.fdroid.installer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.data.Apk;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.privileged.IPrivilegedCallback;
import org.fdroid.fdroid.privileged.IPrivilegedService;
/* loaded from: classes2.dex */
public class PrivilegedInstaller extends Installer {
    private static final int ACTION_INSTALL_REPLACE_EXISTING = 2;
    private static final int DELETE_FAILED_DEVICE_POLICY_MANAGER = -2;
    private static final int DELETE_FAILED_INTERNAL_ERROR = -1;
    private static final int DELETE_FAILED_OWNER_BLOCKED = -4;
    private static final int DELETE_FAILED_USER_RESTRICTED = -3;
    private static final int DELETE_SUCCEEDED = 1;
    private static final int INSTALL_FAILED_ALREADY_EXISTS = -1;
    private static final int INSTALL_FAILED_CONFLICTING_PROVIDER = -13;
    private static final int INSTALL_FAILED_CONTAINER_ERROR = -18;
    private static final int INSTALL_FAILED_CPU_ABI_INCOMPATIBLE = -16;
    private static final int INSTALL_FAILED_DEXOPT = -11;
    private static final int INSTALL_FAILED_DUPLICATE_PACKAGE = -5;
    private static final int INSTALL_FAILED_DUPLICATE_PERMISSION = -112;
    private static final int INSTALL_FAILED_INSUFFICIENT_STORAGE = -4;
    private static final int INSTALL_FAILED_INTERNAL_ERROR = -110;
    private static final int INSTALL_FAILED_INVALID_APK = -2;
    private static final int INSTALL_FAILED_INVALID_INSTALL_LOCATION = -19;
    private static final int INSTALL_FAILED_INVALID_URI = -3;
    private static final int INSTALL_FAILED_MEDIA_UNAVAILABLE = -20;
    private static final int INSTALL_FAILED_MISSING_FEATURE = -17;
    private static final int INSTALL_FAILED_MISSING_SHARED_LIBRARY = -9;
    private static final int INSTALL_FAILED_NEWER_SDK = -14;
    private static final int INSTALL_FAILED_NO_MATCHING_ABIS = -113;
    private static final int INSTALL_FAILED_NO_SHARED_USER = -6;
    private static final int INSTALL_FAILED_OLDER_SDK = -12;
    private static final int INSTALL_FAILED_PACKAGE_CHANGED = -23;
    private static final int INSTALL_FAILED_REPLACE_COULDNT_DELETE = -10;
    private static final int INSTALL_FAILED_SHARED_USER_INCOMPATIBLE = -8;
    private static final int INSTALL_FAILED_TEST_ONLY = -15;
    private static final int INSTALL_FAILED_UID_CHANGED = -24;
    private static final int INSTALL_FAILED_UPDATE_INCOMPATIBLE = -7;
    private static final int INSTALL_FAILED_USER_RESTRICTED = -111;
    private static final int INSTALL_FAILED_VERIFICATION_FAILURE = -22;
    private static final int INSTALL_FAILED_VERIFICATION_TIMEOUT = -21;
    private static final int INSTALL_FAILED_VERSION_DOWNGRADE = -25;
    private static final int INSTALL_PARSE_FAILED_BAD_MANIFEST = -101;
    private static final int INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME = -106;
    private static final int INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID = -107;
    private static final int INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING = -105;
    private static final int INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES = -104;
    private static final int INSTALL_PARSE_FAILED_MANIFEST_EMPTY = -109;
    private static final int INSTALL_PARSE_FAILED_MANIFEST_MALFORMED = -108;
    private static final int INSTALL_PARSE_FAILED_NOT_APK = -100;
    private static final int INSTALL_PARSE_FAILED_NO_CERTIFICATES = -103;
    private static final int INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION = -102;
    private static final HashMap<Integer, String> INSTALL_RETURN_CODES;
    private static final int INSTALL_SUCCEEDED = 1;
    private static final int IS_EXTENSION_INSTALLED_NO = 0;
    private static final int IS_EXTENSION_INSTALLED_SIGNATURE_PROBLEM = 2;
    public static final int IS_EXTENSION_INSTALLED_YES = 1;
    public static final String PRIVILEGED_EXTENSION_PACKAGE_NAME = "org.fdroid.fdroid.privileged";
    private static final String PRIVILEGED_EXTENSION_SERVICE_INTENT = "org.fdroid.fdroid.privileged.IPrivilegedService";
    private static final String TAG = "PrivilegedInstaller";
    private static final HashMap<Integer, String> UNINSTALL_RETURN_CODES;

    @Override // org.fdroid.fdroid.installer.Installer
    protected boolean isUnattended() {
        return true;
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        INSTALL_RETURN_CODES = hashMap;
        hashMap.put(1, "Success");
        hashMap.put(-1, "Package is already installed.");
        hashMap.put(-2, "The package archive file is invalid.");
        hashMap.put(-3, "The URI passed in is invalid.");
        hashMap.put(-4, "The package manager service found that the device didn't have enough storage space to install the app.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_DUPLICATE_PACKAGE), "A package is already installed with the same name.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_NO_SHARED_USER), "The requested shared user does not exist.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_UPDATE_INCOMPATIBLE), "A previously installed package of the same name has a different signature than the new package (and the old package's data was not removed).");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_SHARED_USER_INCOMPATIBLE), "The new package has requested a shared user which is already installed on the device and does not have matching signature.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_MISSING_SHARED_LIBRARY), "The new package uses a shared library that is not available.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_REPLACE_COULDNT_DELETE), "Unknown");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_DEXOPT), "The package failed while optimizing and validating its dex files, either because there was not enough storage or the validation failed.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_OLDER_SDK), "The new package failed because the current SDK version is older than that required by the package.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_CONFLICTING_PROVIDER), "The new package failed because it contains a content provider with the same authority as a provider already installed in the system.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_NEWER_SDK), "The new package failed because the current SDK version is newer than that required by the package.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_TEST_ONLY), "The new package failed because it has specified that it is a test-only package and the caller has not supplied the {@link #INSTALL_ALLOW_TEST} flag.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_CPU_ABI_INCOMPATIBLE), "The package being installed contains native code, but none that is compatible with the device's CPU_ABI.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_MISSING_FEATURE), "The new package uses a feature that is not available.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_CONTAINER_ERROR), "A secure container mount point couldn't be accessed on external media.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_INVALID_INSTALL_LOCATION), "The new package couldn't be installed in the specified install location.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_MEDIA_UNAVAILABLE), "The new package couldn't be installed in the specified install location because the media is not available.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_VERIFICATION_TIMEOUT), "The new package couldn't be installed because the verification timed out.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_VERIFICATION_FAILURE), "The new package couldn't be installed because the verification did not succeed.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_PACKAGE_CHANGED), "The package changed from what the calling program expected.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_UID_CHANGED), "The new package is assigned a different UID than it previously held.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_VERSION_DOWNGRADE), "The new package has an older version code than the currently installed package.");
        hashMap.put(Integer.valueOf((int) INSTALL_PARSE_FAILED_NOT_APK), "The parser was given a path that is not a file, or does not end with the expected '.apk' extension.");
        hashMap.put(Integer.valueOf((int) INSTALL_PARSE_FAILED_BAD_MANIFEST), "the parser was unable to retrieve the AndroidManifest.xml file.");
        hashMap.put(Integer.valueOf((int) INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION), "The parser encountered an unexpected exception.");
        hashMap.put(Integer.valueOf((int) INSTALL_PARSE_FAILED_NO_CERTIFICATES), "The parser did not find any certificates in the .apk.");
        hashMap.put(Integer.valueOf((int) INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES), "The parser found inconsistent certificates on the files in the .apk.");
        hashMap.put(Integer.valueOf((int) INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING), "The parser encountered a CertificateEncodingException in one of the files in the .apk.");
        hashMap.put(Integer.valueOf((int) INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME), "The parser encountered a bad or missing package name in the manifest.");
        hashMap.put(Integer.valueOf((int) INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID), "The parser encountered a bad shared user id name in the manifest.");
        hashMap.put(Integer.valueOf((int) INSTALL_PARSE_FAILED_MANIFEST_MALFORMED), "The parser encountered some structural problem in the manifest.");
        hashMap.put(Integer.valueOf((int) INSTALL_PARSE_FAILED_MANIFEST_EMPTY), "The parser did not find any actionable tags (instrumentation or application) in the manifest.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_INTERNAL_ERROR), "The system failed to install the package because of system issues.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_USER_RESTRICTED), "The system failed to install the package because the user is restricted from installing apps.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_DUPLICATE_PERMISSION), "The system failed to install the package because it is attempting to define a permission that is already defined by some existing package.");
        hashMap.put(Integer.valueOf((int) INSTALL_FAILED_NO_MATCHING_ABIS), "The system failed to install the package because its packaged native code did not match any of the ABIs supported by the system.");
        HashMap<Integer, String> hashMap2 = new HashMap<>();
        UNINSTALL_RETURN_CODES = hashMap2;
        hashMap2.put(1, "Success");
        hashMap2.put(-1, " the system failed to delete the package for an unspecified reason.");
        hashMap2.put(-2, "the system failed to delete the package because it is the active DevicePolicy manager.");
        hashMap2.put(-3, "the system failed to delete the package since the user is restricted.");
        hashMap2.put(-4, "the system failed to delete the package because a profile or device owner has marked the package as uninstallable.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrivilegedInstaller(Context context, App app, Apk apk) {
        super(context, app, apk);
    }

    private static boolean isExtensionInstalled(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo("org.fdroid.fdroid.privileged", 1);
            return packageManager.getApplicationInfo("org.fdroid.fdroid.privileged", 0).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static int isExtensionInstalledCorrectly(Context context) {
        if (isExtensionInstalled(context)) {
            ServiceConnection serviceConnection = new ServiceConnection() { // from class: org.fdroid.fdroid.installer.PrivilegedInstaller.1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            };
            Intent intent = new Intent("org.fdroid.fdroid.privileged.IPrivilegedService");
            intent.setPackage("org.fdroid.fdroid.privileged");
            try {
                context.getApplicationContext().bindService(intent, serviceConnection, 1);
                return 1;
            } catch (SecurityException e) {
                Log.e(TAG, "IS_EXTENSION_INSTALLED_SIGNATURE_PROBLEM", e);
                return 2;
            }
        }
        return 0;
    }

    public static boolean isDefault(Context context) {
        return Preferences.get().isPrivilegedInstallerEnabled() && isExtensionInstalledCorrectly(context) == 1;
    }

    @Override // org.fdroid.fdroid.installer.Installer
    protected void installPackageInternal(final Uri uri, final Uri uri2) {
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: org.fdroid.fdroid.installer.PrivilegedInstaller.2
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                IPrivilegedService asInterface = IPrivilegedService.Stub.asInterface(iBinder);
                IPrivilegedCallback.Stub stub = new IPrivilegedCallback.Stub() { // from class: org.fdroid.fdroid.installer.PrivilegedInstaller.2.1
                    @Override // org.fdroid.fdroid.privileged.IPrivilegedCallback
                    public void handleResult(String str, int i) {
                        if (i == 1) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            PrivilegedInstaller.this.sendBroadcastInstall(uri2, Installer.ACTION_INSTALL_COMPLETE);
                            return;
                        }
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        PrivilegedInstaller privilegedInstaller = PrivilegedInstaller.this;
                        Uri uri3 = uri2;
                        privilegedInstaller.sendBroadcastInstall(uri3, Installer.ACTION_INSTALL_INTERRUPTED, "Error " + i + ": " + ((String) PrivilegedInstaller.INSTALL_RETURN_CODES.get(Integer.valueOf(i))));
                    }
                };
                try {
                    if (!asInterface.hasPrivilegedPermissions()) {
                        PrivilegedInstaller privilegedInstaller = PrivilegedInstaller.this;
                        privilegedInstaller.sendBroadcastInstall(uri2, Installer.ACTION_INSTALL_INTERRUPTED, privilegedInstaller.context.getString(R.string.system_install_denied_permissions));
                        return;
                    }
                    asInterface.installPackage(uri, 2, "org.fdroid.fdroid.privileged", stub);
                } catch (RemoteException e) {
                    Log.e(PrivilegedInstaller.TAG, "RemoteException", e);
                    PrivilegedInstaller.this.sendBroadcastInstall(uri2, Installer.ACTION_INSTALL_INTERRUPTED, "connecting to privileged service failed");
                }
            }
        };
        Intent intent = new Intent("org.fdroid.fdroid.privileged.IPrivilegedService");
        intent.setPackage("org.fdroid.fdroid.privileged");
        this.context.getApplicationContext().bindService(intent, serviceConnection, 1);
    }

    @Override // org.fdroid.fdroid.installer.Installer
    protected void uninstallPackage() {
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: org.fdroid.fdroid.installer.PrivilegedInstaller.3
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                IPrivilegedService asInterface = IPrivilegedService.Stub.asInterface(iBinder);
                IPrivilegedCallback.Stub stub = new IPrivilegedCallback.Stub() { // from class: org.fdroid.fdroid.installer.PrivilegedInstaller.3.1
                    @Override // org.fdroid.fdroid.privileged.IPrivilegedCallback
                    public void handleResult(String str, int i) {
                        if (i == 1) {
                            PrivilegedInstaller.this.sendBroadcastUninstall(Installer.ACTION_UNINSTALL_COMPLETE);
                            return;
                        }
                        PrivilegedInstaller privilegedInstaller = PrivilegedInstaller.this;
                        privilegedInstaller.sendBroadcastUninstall(Installer.ACTION_UNINSTALL_INTERRUPTED, "Error " + i + ": " + ((String) PrivilegedInstaller.UNINSTALL_RETURN_CODES.get(Integer.valueOf(i))));
                    }
                };
                try {
                    if (!asInterface.hasPrivilegedPermissions()) {
                        PrivilegedInstaller privilegedInstaller = PrivilegedInstaller.this;
                        privilegedInstaller.sendBroadcastUninstall(Installer.ACTION_UNINSTALL_INTERRUPTED, privilegedInstaller.context.getString(R.string.system_install_denied_permissions));
                        return;
                    }
                    asInterface.deletePackage(PrivilegedInstaller.this.apk.packageName, 0, stub);
                } catch (RemoteException e) {
                    Log.e(PrivilegedInstaller.TAG, "RemoteException", e);
                    PrivilegedInstaller.this.sendBroadcastUninstall(Installer.ACTION_UNINSTALL_INTERRUPTED, "connecting to privileged service failed");
                }
            }
        };
        Intent intent = new Intent("org.fdroid.fdroid.privileged.IPrivilegedService");
        intent.setPackage("org.fdroid.fdroid.privileged");
        this.context.getApplicationContext().bindService(intent, serviceConnection, 1);
    }
}
