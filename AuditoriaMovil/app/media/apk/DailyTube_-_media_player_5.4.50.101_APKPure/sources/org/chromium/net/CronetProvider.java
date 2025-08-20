package org.chromium.net;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.chromium.net.CronetEngine;
/* loaded from: classes.dex */
public abstract class CronetProvider {
    private static final String TAG = "CronetProvider";
    protected final Context mContext;

    public CronetProvider(Context context) {
        if (context != null) {
            this.mContext = context;
            return;
        }
        throw new IllegalArgumentException("Context must not be null");
    }

    private static boolean addCronetProviderFromResourceFile(Context context, Set<CronetProvider> set) {
        int identifier = context.getResources().getIdentifier("CronetProviderClassName", "string", context.getPackageName());
        boolean z2 = false;
        if (identifier == 0) {
            return false;
        }
        String string = context.getResources().getString(identifier);
        if (string != null && !string.equals("com.google.android.gms.net.PlayServicesCronetProvider") && !string.equals("com.google.android.gms.net.GmsCoreCronetProvider") && !string.equals("org.chromium.net.impl.JavaCronetProvider") && !string.equals("org.chromium.net.impl.NativeCronetProvider")) {
            z2 = true;
            if (!addCronetProviderImplByClassName(context, string, set, true)) {
                String str = TAG;
                Log.e(str, "Unable to instantiate Cronet implementation class " + string + " that is listed as in the app string resource file under CronetProviderClassName key");
            }
        }
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean addCronetProviderImplByClassName(Context context, String str, Set<CronetProvider> set, boolean z2) {
        try {
            set.add(context.getClassLoader().loadClass(str).asSubclass(CronetProvider.class).getConstructor(Context.class).newInstance(context));
            return true;
        } catch (ClassNotFoundException e2) {
            logReflectiveOperationException(str, z2, e2);
            return false;
        } catch (IllegalAccessException e3) {
            logReflectiveOperationException(str, z2, e3);
            return false;
        } catch (InstantiationException e5) {
            logReflectiveOperationException(str, z2, e5);
            return false;
        } catch (NoSuchMethodException e6) {
            logReflectiveOperationException(str, z2, e6);
            return false;
        } catch (InvocationTargetException e8) {
            logReflectiveOperationException(str, z2, e8);
            return false;
        }
    }

    public static List<CronetProvider> getAllProviders(Context context) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        addCronetProviderFromResourceFile(context, linkedHashSet);
        addCronetProviderImplByClassName(context, "com.google.android.gms.net.PlayServicesCronetProvider", linkedHashSet, false);
        addCronetProviderImplByClassName(context, "com.google.android.gms.net.GmsCoreCronetProvider", linkedHashSet, false);
        addCronetProviderImplByClassName(context, "org.chromium.net.impl.NativeCronetProvider", linkedHashSet, false);
        addCronetProviderImplByClassName(context, "org.chromium.net.impl.JavaCronetProvider", linkedHashSet, false);
        return Collections.unmodifiableList(new ArrayList(linkedHashSet));
    }

    private static void logReflectiveOperationException(String str, boolean z2, Exception exc) {
        if (z2) {
            String str2 = TAG;
            Log.e(str2, "Unable to load provider class: " + str, exc);
            return;
        }
        Log.isLoggable(TAG, 3);
    }

    public abstract CronetEngine.Builder createBuilder();

    public abstract String getName();

    public abstract String getVersion();

    public abstract boolean isEnabled();

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + getName() + ", version=" + getVersion() + ", enabled=" + isEnabled() + "]";
    }
}
