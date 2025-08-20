package com.uv.v7;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import tf.n3;
/* loaded from: classes.dex */
public class MMKVSpeeder {
    private static final String COMPILE_FILTER_QUICKEN = "quicken";
    private static final String COMPILE_FILTER_SPEED = "speed";
    private static final int MAX_RETRY_COUNT = 3;
    private static final String TAG = "Dex2OatHelper";
    private final String PACKAGE_NAME = "com.simuwang.ppw";
    int SHELL_COMMAND_TRANSACTION = 1598246212;
    private Context mContext;
    private IBinder mPmBinder;
    private Object mPmObj;

    /* loaded from: classes.dex */
    public static class y {
        public static final Executor y = Executors.newSingleThreadExecutor();

        /* renamed from: com.uv.v7.MMKVSpeeder$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0071y implements Runnable {
            public final /* synthetic */ InputStream y;

            public RunnableC0071y(InputStream inputStream) {
                this.y = inputStream;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.y == null) {
                    return;
                }
                do {
                    try {
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        try {
                            this.y.close();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                } while (this.y.read(new byte[256]) > 0);
                try {
                    this.y.close();
                } catch (Exception unused3) {
                }
            }
        }

        public static void y(InputStream inputStream) {
            y.execute(new RunnableC0071y(inputStream));
        }
    }

    private static String getCurrentInstructionSet() {
        try {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            return (String) ReflectUtils.getMethod(cls, "getCurrentInstructionSet", new Class[0]).invoke(cls, null);
        } catch (Throwable unused) {
            return "arm64";
        }
    }

    public static void makeDex2OatV2(String str, String str2) throws IOException {
        File file = new File(str2);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add("&");
        }
        arrayList.add("--dex-file=" + str);
        arrayList.add("--oat-file=" + str2);
        String currentInstructionSet = getCurrentInstructionSet();
        n3.y(TAG, "dex2oat cpuApi: " + currentInstructionSet);
        arrayList.add("--instruction-set=" + currentInstructionSet);
        if (i > 25) {
            arrayList.add("--compiler-filter=quicken");
        } else {
            arrayList.add("--compiler-filter=interpret-only");
        }
        ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
        processBuilder.redirectErrorStream(true);
        Process start = processBuilder.start();
        y.y(start.getInputStream());
        y.y(start.getErrorStream());
        try {
            int waitFor = start.waitFor();
            if (waitFor == 0) {
                return;
            }
            throw new IOException("dex2oat works unsuccessfully, exit code: " + waitFor);
        } catch (InterruptedException e2) {
            throw new IOException("dex2oat is interrupted, msg: " + e2.getMessage(), e2);
        }
    }

    public static void makeDex2oat1(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add("&");
        }
        arrayList.add("--instruction-set=" + Build.CPU_ABI);
        arrayList.add("--compiler-filter=speed");
        arrayList.add("--dex-file=" + str);
        arrayList.add("--oat-file=" + str2);
        try {
            Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()]));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
