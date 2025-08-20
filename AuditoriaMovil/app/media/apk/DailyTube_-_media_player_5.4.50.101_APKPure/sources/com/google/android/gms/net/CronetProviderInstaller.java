package com.google.android.gms.net;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.Method;
import org.chromium.net.ApiVersion;
/* loaded from: classes.dex */
public class CronetProviderInstaller {
    private static final String zza = "CronetProviderInstaller";
    private static final GoogleApiAvailabilityLight zzb = GoogleApiAvailabilityLight.getInstance();
    private static final Object zzc = new Object();
    @Nullable
    private static DynamiteModule zzd = null;
    private static String zze = "0";

    private CronetProviderInstaller() {
    }

    @NonNull
    public static Task<Void> installProvider(@NonNull final Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (isInstalled()) {
            taskCompletionSource.setResult(null);
            return taskCompletionSource.getTask();
        }
        new Thread(new Runnable() { // from class: com.google.android.gms.net.zza
            @Override // java.lang.Runnable
            public final void run() {
                Context context2 = context;
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                try {
                    CronetProviderInstaller.zzc(context2);
                    taskCompletionSource2.setResult(null);
                } catch (Exception e2) {
                    taskCompletionSource2.setException(e2);
                }
            }
        }).start();
        return taskCompletionSource.getTask();
    }

    public static boolean isInstalled() {
        if (zza() != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public static DynamiteModule zza() {
        DynamiteModule dynamiteModule;
        synchronized (zzc) {
            dynamiteModule = zzd;
        }
        return dynamiteModule;
    }

    public static String zzb() {
        String str;
        synchronized (zzc) {
            str = zze;
        }
        return str;
    }

    @ShowFirstParty
    @Deprecated
    public static void zzc(@NonNull Context context) throws GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        synchronized (zzc) {
            try {
                if (isInstalled()) {
                    return;
                }
                Preconditions.checkNotNull(context, "Context must not be null");
                try {
                    ((ClassLoader) Preconditions.checkNotNull(CronetProviderInstaller.class.getClassLoader())).loadClass("org.chromium.net.CronetEngine");
                    int apiLevel = ApiVersion.getApiLevel();
                    GoogleApiAvailabilityLight googleApiAvailabilityLight = zzb;
                    googleApiAvailabilityLight.verifyGooglePlayServicesIsAvailable(context, 11925000);
                    try {
                        DynamiteModule load = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.cronet_dynamite");
                        try {
                            Class<?> loadClass = load.getModuleContext().getClassLoader().loadClass("org.chromium.net.impl.ImplVersion");
                            if (loadClass.getClassLoader() != CronetProviderInstaller.class.getClassLoader()) {
                                Method method = loadClass.getMethod("getApiLevel", null);
                                Method method2 = loadClass.getMethod("getCronetVersion", null);
                                int intValue = ((Integer) Preconditions.checkNotNull((Integer) method.invoke(null, null))).intValue();
                                zze = (String) Preconditions.checkNotNull((String) method2.invoke(null, null));
                                if (apiLevel > intValue) {
                                    Intent errorResolutionIntent = googleApiAvailabilityLight.getErrorResolutionIntent(context, 2, "cr");
                                    if (errorResolutionIntent == null) {
                                        Log.e(zza, "Unable to fetch error resolution intent");
                                        throw new GooglePlayServicesNotAvailableException(2);
                                    }
                                    String str = zze;
                                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 174);
                                    sb.append("Google Play Services update is required. The API Level of the client is ");
                                    sb.append(apiLevel);
                                    sb.append(". The API Level of the implementation is ");
                                    sb.append(intValue);
                                    sb.append(". The Cronet implementation version is ");
                                    sb.append(str);
                                    throw new GooglePlayServicesRepairableException(2, sb.toString(), errorResolutionIntent);
                                }
                                zzd = load;
                                return;
                            }
                            Log.e(zza, "ImplVersion class is missing from Cronet module.");
                            throw new GooglePlayServicesNotAvailableException(8);
                        } catch (Exception e2) {
                            Log.e(zza, "Unable to read Cronet version from the Cronet module ", e2);
                            throw ((GooglePlayServicesNotAvailableException) new GooglePlayServicesNotAvailableException(8).initCause(e2));
                        }
                    } catch (DynamiteModule.LoadingException e3) {
                        Log.e(zza, "Unable to load Cronet module", e3);
                        throw ((GooglePlayServicesNotAvailableException) new GooglePlayServicesNotAvailableException(8).initCause(e3));
                    }
                } catch (ClassNotFoundException e5) {
                    Log.e(zza, "Cronet API is not available. Have you included all required dependencies?");
                    throw ((GooglePlayServicesNotAvailableException) new GooglePlayServicesNotAvailableException(10).initCause(e5));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
