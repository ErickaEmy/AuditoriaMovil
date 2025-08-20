package com.uv.v7;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.uv.v7.h;
import free.daily.tube.background.dtoapp.MxApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import pg.zn;
/* loaded from: classes.dex */
public class MMKVOptimizerWrapper {
    public static final int MODE_EXTERNAL = 1;
    public static final int MODE_INTERNAL = 0;
    private static long OPT_INTERVAL = 10800000;
    private static boolean disableDex2oat;
    private static AtomicBoolean finishDex2oat = new AtomicBoolean(false);
    private static long lastOptTime;
    private static boolean libraryLoaded;
    public static int mode;
    private static String processHash;

    /* loaded from: classes.dex */
    public class n3 implements h.y {
        @Override // com.uv.v7.h.y
        public void f() {
            MxApp.f8175v = true;
        }
    }

    /* loaded from: classes.dex */
    public class y implements h.y {
        @Override // com.uv.v7.h.y
        public void f() {
            MxApp.f8175v = true;
        }
    }

    public static void cleanMMKVCache(Application application, int i) {
        if (!zn.f12597a.booleanValue()) {
            return;
        }
        int i5 = 0;
        if (i == 0) {
            File filesDir = application.getFilesDir();
            File file = new File(filesDir, "mmkv_" + getHash(application));
            if (file.exists()) {
                try {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        while (i5 < listFiles.length) {
                            FileUtils.deleteFile(listFiles[i5]);
                            i5++;
                        }
                    }
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                }
            }
        } else if (i == 1) {
            File externalFilesDir = application.getExternalFilesDir("mmkv_" + getHash(application));
            if (externalFilesDir != null && externalFilesDir.exists()) {
                try {
                    File[] listFiles2 = externalFilesDir.listFiles();
                    if (listFiles2 != null) {
                        while (i5 < listFiles2.length) {
                            FileUtils.deleteFile(listFiles2[i5]);
                            i5++;
                        }
                    }
                } catch (RuntimeException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private static void clearOldCache(Context context, File file) {
        File[] listFiles;
        if (file == null || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].getName().startsWith("l2l") && listFiles[i].length() > 1024) {
                FileUtils.deleteFile(listFiles[i]);
            }
            if (listFiles[i].isDirectory() && listFiles[i].getName().endsWith("_mmkv") && !TextUtils.equals("mxkv", listFiles[i].getName())) {
                FileUtils.deleteFile(listFiles[i]);
            }
        }
    }

    public static String getHash(Context context) {
        String str = processHash;
        if (str != null) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    if (packageName.equals(runningAppProcessInfo.processName)) {
                        processHash = "";
                    } else {
                        processHash = String.valueOf(runningAppProcessInfo.processName.hashCode());
                    }
                }
            }
        } catch (Exception unused) {
            processHash = "error";
        }
        return processHash;
    }

    public static String getMMKVInfo(Application application) throws RuntimeException {
        File externalFilesDir;
        if (!zn.f12597a.booleanValue()) {
            return "";
        }
        if (mode == 0) {
            File filesDir = application.getFilesDir();
            externalFilesDir = new File(filesDir, "mmkv_" + getHash(application));
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
        } else {
            externalFilesDir = application.getExternalFilesDir("mmkv_" + getHash(application));
        }
        if (externalFilesDir == null) {
            return "cannot getMMKVInfo because mmkvDir is not existed, mode = " + mode;
        }
        File file = new File(externalFilesDir, "l2ldlj.t");
        StringBuilder sb = new StringBuilder();
        sb.append("mmkv mode = " + mode + " , ");
        sb.append("mmkv asset name = l2ldlj.t , ");
        sb.append("verifyFile is exists = " + file.exists() + " , ");
        sb.append("mmkvDir is exists = " + externalFilesDir.exists() + " , ");
        if (externalFilesDir.exists()) {
            try {
                File[] listFiles = externalFilesDir.listFiles();
                sb.append("dex name =");
                if (listFiles != null) {
                    for (int i = 0; i < listFiles.length; i++) {
                        sb.append(" " + listFiles[i].getName() + " , ");
                    }
                }
            } catch (RuntimeException unused) {
                sb.append("get dexes error");
            }
        }
        sb.append(";");
        return sb.toString();
    }

    public static void install(Context context, int i, Boolean bool) throws Exception {
        File file;
        if (!zn.f12597a.booleanValue()) {
            return;
        }
        if (!libraryLoaded) {
            try {
                n0.n3.y(context, BuildConfig.SO_NAME);
                libraryLoaded = true;
            } catch (UnsatisfiedLinkError unused) {
            }
        }
        File externalFilesDir = context.getExternalFilesDir("mmkv_" + getHash(context));
        if (externalFilesDir != null && new File(externalFilesDir, "l2ldlj.t").exists()) {
            mode = 1;
        } else {
            mode = i;
            if (i == 0) {
                file = new File(context.getFilesDir(), "mmkv_" + getHash(context));
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (file == null && file.exists()) {
                    File file2 = new File(file, "l2ldlj.t");
                    if (!file2.exists()) {
                        clearOldCache(context, context.getFilesDir());
                        clearOldCache(context, externalFilesDir);
                        for (File file3 : file.listFiles()) {
                            FileUtils.deleteFile(file3);
                        }
                        int b2 = new h("l2ldlj.t", file, "/mmkv%d.zip", file2, context.getAssets(), new y()).b();
                        if (b2 != 0) {
                            if (b2 == 2) {
                                throw new CreateFileException(i);
                            }
                            throw new SpeedUpException(i, b2);
                        }
                    }
                    File[] listFiles = file.listFiles();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < listFiles.length; i5++) {
                        if (listFiles[i5].getName().startsWith("mmkv") && listFiles[i5].getName().endsWith(".zip")) {
                            arrayList.add(listFiles[i5]);
                        }
                    }
                    Collections.sort(arrayList);
                    if (!arrayList.isEmpty()) {
                        try {
                            MMKVOptimizer.load(context.getClassLoader(), file, arrayList, bool);
                            return;
                        } catch (Throwable th) {
                            throw new LoadDexException(listFiles.length, th, mode);
                        }
                    }
                    throw new FileSizeException(i);
                }
                throw new CreateDirException(i);
            }
        }
        file = externalFilesDir;
        if (file == null) {
        }
        throw new CreateDirException(i);
    }

    public static void installFeature(Context context, int i, String str, String str2) throws Exception {
        if (!zn.f12597a.booleanValue()) {
            return;
        }
        if (!libraryLoaded) {
            n0.n3.y(context, BuildConfig.SO_NAME);
            libraryLoaded = true;
        }
        File externalFilesDir = context.getExternalFilesDir("mmkv_" + getHash(context));
        if (externalFilesDir != null && new File(externalFilesDir, str).exists()) {
            mode = 1;
        } else {
            mode = i;
            if (i == 0) {
                File filesDir = context.getFilesDir();
                File file = new File(filesDir, "mmkv_" + getHash(context));
                if (!file.exists()) {
                    file.mkdirs();
                }
                externalFilesDir = file;
            }
        }
        if (externalFilesDir != null && externalFilesDir.exists()) {
            File file2 = new File(externalFilesDir, str);
            if (!file2.exists()) {
                int b2 = new h(str, externalFilesDir, "/" + str2 + "%d.zip", file2, context.getAssets(), new n3()).b();
                if (b2 != 0) {
                    if (b2 == 2) {
                        throw new CreateFileException(i);
                    }
                    throw new SpeedUpException(i, b2);
                }
            }
            File[] listFiles = externalFilesDir.listFiles();
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < listFiles.length; i5++) {
                if (listFiles[i5].getName().startsWith(str2) && listFiles[i5].getName().endsWith(".zip")) {
                    arrayList.add(listFiles[i5]);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() != 0) {
                try {
                    MMKVOptimizer.load(context.getClassLoader(), externalFilesDir, arrayList, Boolean.FALSE);
                    return;
                } catch (Throwable th) {
                    throw new LoadDexException(listFiles.length, th, mode);
                }
            }
            throw new RuntimeException("try load mmkv file but fail, mode = " + mode);
        }
        throw new CreateDirException(i);
    }

    public static void speedUpMMKV(Context context) {
        int i;
        if (zn.f12597a.booleanValue() && (i = Build.VERSION.SDK_INT) < 29 && i >= 23) {
            Log.i("Dex2oatTest", "speedUpMMKV");
            if (!finishDex2oat.compareAndSet(false, true)) {
                return;
            }
            try {
                install(context, mode, Boolean.TRUE);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
