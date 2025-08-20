package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;
@KeepForSdk
/* loaded from: classes.dex */
public final class UidVerifier {
    private UidVerifier() {
    }

    @KeepForSdk
    public static boolean isGooglePlayServicesUid(@NonNull Context context, int i) {
        if (!uidHasPackageName(context, i, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_PACKAGE)) {
            return false;
        }
        try {
            return GoogleSignatureVerifier.getInstance(context).isGooglePublicSignedPackage(context.getPackageManager().getPackageInfo(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_PACKAGE, 64));
        } catch (PackageManager.NameNotFoundException unused) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    @KeepForSdk
    @TargetApi(19)
    public static boolean uidHasPackageName(@NonNull Context context, int i, @NonNull String str) {
        return Wrappers.packageManager(context).zza(i, str);
    }
}
