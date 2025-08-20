package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class CommonUtils {
    private static Boolean clsTrace;
    private static final char[] HEX_VALUES = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long totalRamInBytes = -1;
    public static final Comparator<File> FILE_MODIFIED_COMPARATOR = new 1();

    public static long calculateFreeRamInBytes(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long calculateUsedDiskSpaceInBytes(String str) {
        StatFs statFs;
        long blockSize = new StatFs(str).getBlockSize();
        return (statFs.getBlockCount() * blockSize) - (blockSize * statFs.getAvailableBlocks());
    }

    @SuppressLint({"MissingPermission"})
    public static boolean canTryConnection(Context context) {
        if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static boolean checkPermission(Context context, String str) {
        if (context.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static void closeOrLog(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                Logger.getLogger().e(str, e2);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static long convertMemInfoToBytes(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * i;
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    @Deprecated
    public static Cipher createCipher(int i, String str) throws InvalidKeyException {
        throw new InvalidKeyException("This method is deprecated");
    }

    public static String createInstanceIdFrom(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            sb.append(str2);
        }
        String sb2 = sb.toString();
        if (sb2.length() <= 0) {
            return null;
        }
        return sha1(sb2);
    }

    public static byte[] dehexify(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
        r2 = r3[1];
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String extractFieldFromSystemFile(java.io.File r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "Failed to close system file reader."
            boolean r1 = r6.exists()
            r2 = 0
            if (r1 == 0) goto L60
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            r4 = 1024(0x400, float:1.435E-42)
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
        L15:
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            if (r3 == 0) goto L3b
            java.lang.String r4 = "\\s*:\\s*"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            r5 = 2
            java.lang.String[] r3 = r4.split(r3, r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            int r4 = r3.length     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            r5 = 1
            if (r4 <= r5) goto L15
            r4 = 0
            r4 = r3[r4]     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            boolean r4 = r4.equals(r7)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            if (r4 == 0) goto L15
            r2 = r3[r5]     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            goto L3b
        L36:
            r6 = move-exception
            r2 = r1
            goto L5c
        L39:
            r7 = move-exception
            goto L43
        L3b:
            closeOrLog(r1, r0)
            goto L60
        L3f:
            r6 = move-exception
            goto L5c
        L41:
            r7 = move-exception
            r1 = r2
        L43:
            com.google.firebase.crashlytics.internal.Logger r3 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch: java.lang.Throwable -> L36
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36
            r4.<init>()     // Catch: java.lang.Throwable -> L36
            java.lang.String r5 = "Error parsing "
            r4.append(r5)     // Catch: java.lang.Throwable -> L36
            r4.append(r6)     // Catch: java.lang.Throwable -> L36
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L36
            r3.e(r6, r7)     // Catch: java.lang.Throwable -> L36
            goto L3b
        L5c:
            closeOrLog(r2, r0)
            throw r6
        L60:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CommonUtils.extractFieldFromSystemFile(java.io.File, java.lang.String):java.lang.String");
    }

    @TargetApi(16)
    public static void finishAffinity(Context context, int i) {
        if (context instanceof Activity) {
            finishAffinity((Activity) context, i);
        }
    }

    public static void flushOrLog(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e2) {
                Logger.getLogger().e(str, e2);
            }
        }
    }

    public static String getAppIconHashOrNull(Context context) {
        Throwable th;
        InputStream inputStream;
        String str = null;
        try {
            inputStream = context.getResources().openRawResource(getAppIconResourceId(context));
            try {
                try {
                    String sha1 = sha1(inputStream);
                    if (!isNullOrEmpty(sha1)) {
                        str = sha1;
                    }
                    closeOrLog(inputStream, "Failed to close icon input stream.");
                    return str;
                } catch (Exception e2) {
                    e = e2;
                    Logger.getLogger().w("Could not calculate hash for app icon:" + e.getMessage());
                    closeOrLog(inputStream, "Failed to close icon input stream.");
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                closeOrLog(inputStream, "Failed to close icon input stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            closeOrLog(inputStream, "Failed to close icon input stream.");
            throw th;
        }
    }

    public static int getAppIconResourceId(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static ActivityManager.RunningAppProcessInfo getAppProcessInfo(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static boolean getBooleanResourceValue(Context context, String str, boolean z2) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int resourcesIdentifier = getResourcesIdentifier(context, str, "bool");
            if (resourcesIdentifier > 0) {
                return resources.getBoolean(resourcesIdentifier);
            }
            int resourcesIdentifier2 = getResourcesIdentifier(context, str, "string");
            if (resourcesIdentifier2 > 0) {
                return Boolean.parseBoolean(context.getString(resourcesIdentifier2));
            }
        }
        return z2;
    }

    public static int getCpuArchitectureInt() {
        return Architecture.getValue().ordinal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static int getDeviceState(Context context) {
        boolean isEmulator = isEmulator(context);
        ?? r0 = isEmulator;
        if (isRooted(context)) {
            r0 = (isEmulator ? 1 : 0) | true;
        }
        if (isDebuggerAttached()) {
            return r0 | 4;
        }
        return r0;
    }

    public static SharedPreferences getLegacySharedPrefs(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String getMappingFileId(Context context) {
        int resourcesIdentifier = getResourcesIdentifier(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (resourcesIdentifier == 0) {
            resourcesIdentifier = getResourcesIdentifier(context, "com.crashlytics.android.build_id", "string");
        }
        if (resourcesIdentifier != 0) {
            return context.getResources().getString(resourcesIdentifier);
        }
        return null;
    }

    public static boolean getProximitySensorEnabled(Context context) {
        if (isEmulator(context) || ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) == null) {
            return false;
        }
        return true;
    }

    public static String getResourcePackageName(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            try {
                String resourcePackageName = context.getResources().getResourcePackageName(i);
                if ("android".equals(resourcePackageName)) {
                    return context.getPackageName();
                }
                return resourcePackageName;
            } catch (Resources.NotFoundException unused) {
                return context.getPackageName();
            }
        }
        return context.getPackageName();
    }

    public static int getResourcesIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getResourcePackageName(context));
    }

    public static SharedPreferences getSharedPrefs(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    public static String getStringsFileValue(Context context, String str) {
        int resourcesIdentifier = getResourcesIdentifier(context, str, "string");
        if (resourcesIdentifier > 0) {
            return context.getString(resourcesIdentifier);
        }
        return "";
    }

    public static synchronized long getTotalRamInBytes() {
        long j2;
        synchronized (CommonUtils.class) {
            try {
                if (totalRamInBytes == -1) {
                    String extractFieldFromSystemFile = extractFieldFromSystemFile(new File("/proc/meminfo"), "MemTotal");
                    long j4 = 0;
                    if (!TextUtils.isEmpty(extractFieldFromSystemFile)) {
                        String upperCase = extractFieldFromSystemFile.toUpperCase(Locale.US);
                        try {
                            if (upperCase.endsWith("KB")) {
                                j4 = convertMemInfoToBytes(upperCase, "KB", 1024);
                            } else if (upperCase.endsWith("MB")) {
                                j4 = convertMemInfoToBytes(upperCase, "MB", 1048576);
                            } else if (upperCase.endsWith("GB")) {
                                j4 = convertMemInfoToBytes(upperCase, "GB", 1073741824);
                            } else {
                                Logger logger = Logger.getLogger();
                                logger.d("Unexpected meminfo format while computing RAM: " + upperCase);
                            }
                        } catch (NumberFormatException e2) {
                            Logger logger2 = Logger.getLogger();
                            logger2.e("Unexpected meminfo format while computing RAM: " + upperCase, e2);
                        }
                    }
                    totalRamInBytes = j4;
                }
                j2 = totalRamInBytes;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j2;
    }

    private static String hash(String str, String str2) {
        return hash(str.getBytes(), str2);
    }

    public static String hexify(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i5 = i * 2;
            char[] cArr2 = HEX_VALUES;
            cArr[i5] = cArr2[(b2 & 255) >>> 4];
            cArr[i5 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static void hideKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean isAppDebuggable(Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isClsTrace(Context context) {
        if (clsTrace == null) {
            clsTrace = Boolean.valueOf(getBooleanResourceValue(context, "com.crashlytics.Trace", false));
        }
        return clsTrace.booleanValue();
    }

    public static boolean isDebuggerAttached() {
        if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger()) {
            return false;
        }
        return true;
    }

    public static boolean isEmulator(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        String str = Build.PRODUCT;
        if (!"sdk".equals(str) && !"google_sdk".equals(str) && string != null) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean isLoggingEnabled(Context context) {
        return false;
    }

    public static boolean isNullOrEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isRooted(Context context) {
        boolean isEmulator = isEmulator(context);
        String str = Build.TAGS;
        if ((!isEmulator && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (!isEmulator && file.exists()) {
            return true;
        }
        return false;
    }

    public static void logControlled(Context context, String str) {
        if (isClsTrace(context)) {
            Logger.getLogger().d(str);
        }
    }

    public static void logControlledError(Context context, String str, Throwable th) {
        if (isClsTrace(context)) {
            Logger.getLogger().e(str);
        }
    }

    public static String logPriorityToString(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    public static void openKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInputFromInputMethod(view.getWindowToken(), 0);
        }
    }

    public static String padWithZerosToMaxIntWidth(int i) {
        if (i >= 0) {
            return String.format(Locale.US, "%1$10s", Integer.valueOf(i)).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    public static String resolveUnityEditorVersion(Context context) {
        int resourcesIdentifier = getResourcesIdentifier(context, "com.google.firebase.crashlytics.unity_version", "string");
        if (resourcesIdentifier != 0) {
            String string = context.getResources().getString(resourcesIdentifier);
            Logger logger = Logger.getLogger();
            logger.d("Unity Editor version is: " + string);
            return string;
        }
        return null;
    }

    public static String sha1(String str) {
        return hash(str, "SHA-1");
    }

    public static String sha256(String str) {
        return hash(str, "SHA-256");
    }

    public static String streamToString(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        if (useDelimiter.hasNext()) {
            return useDelimiter.next();
        }
        return "";
    }

    public static boolean stringsEqualIncludingNull(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str != null) {
            return str.equals(str2);
        }
        return false;
    }

    private static String hash(InputStream inputStream, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return hexify(messageDigest.digest());
                }
            }
        } catch (Exception e2) {
            Logger.getLogger().e("Could not calculate hash for app icon.", e2);
            return "";
        }
    }

    public static String sha1(InputStream inputStream) {
        return hash(inputStream, "SHA-1");
    }

    @TargetApi(16)
    public static void finishAffinity(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        activity.finishAffinity();
    }

    public static void logControlled(Context context, int i, String str, String str2) {
        if (isClsTrace(context)) {
            Logger.getLogger().log(i, str2);
        }
    }

    private static String hash(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return hexify(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            Logger logger = Logger.getLogger();
            logger.e("Could not create hashing algorithm: " + str + ", returning empty string.", e2);
            return "";
        }
    }
}
