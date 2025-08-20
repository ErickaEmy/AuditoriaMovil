package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class ManifestParser {
    private final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    private ApplicationInfo getOurApplicationInfo() {
        return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
    }

    public List parse() {
        ApplicationInfo ourApplicationInfo;
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ourApplicationInfo = getOurApplicationInfo();
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable("ManifestParser", 6)) {
                Log.e("ManifestParser", "Failed to parse glide modules", e);
            }
        }
        if (ourApplicationInfo != null && ourApplicationInfo.metaData != null) {
            if (Log.isLoggable("ManifestParser", 2)) {
                Log.v("ManifestParser", "Got app info metadata: " + ourApplicationInfo.metaData);
            }
            for (String str : ourApplicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(ourApplicationInfo.metaData.get(str))) {
                    parseModule(str);
                    arrayList.add(null);
                    if (Log.isLoggable("ManifestParser", 3)) {
                        Log.d("ManifestParser", "Loaded Glide module: " + str);
                    }
                }
            }
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Finished loading Glide modules");
            }
            return arrayList;
        }
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Got null app info metadata");
        }
        return arrayList;
    }

    private static GlideModule parseModule(String str) {
        Class cls;
        Class cls2;
        Class cls3;
        Object obj;
        Class cls4;
        try {
            try {
                obj = Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                throwInstantiateGlideModuleException(cls4, e);
                obj = null;
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
            } catch (InstantiationException e2) {
                throwInstantiateGlideModuleException(cls3, e2);
                obj = null;
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
            } catch (NoSuchMethodException e3) {
                throwInstantiateGlideModuleException(cls2, e3);
                obj = null;
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
            } catch (InvocationTargetException e4) {
                throwInstantiateGlideModuleException(cls, e4);
                obj = null;
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    private static void throwInstantiateGlideModuleException(Class cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }
}
