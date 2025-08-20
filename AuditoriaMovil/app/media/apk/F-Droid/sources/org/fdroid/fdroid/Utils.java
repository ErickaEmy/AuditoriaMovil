package org.fdroid.fdroid;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Supplier;
import androidx.core.view.DisplayCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ch.qos.logback.classic.spi.CallerData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.encode.QRCodeEncoder;
import info.guardianproject.netcipher.NetCipher;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.fdroid.IndexFile;
import org.fdroid.database.AppOverviewItem;
import org.fdroid.database.Repository;
import org.fdroid.download.DownloadRequest;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.compat.FileCompat;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.data.SanitizedFile;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.fdroid.net.TreeUriDownloader;
import org.fdroid.index.v2.FileV2;
import org.json.JSONArray;
import org.json.JSONException;
import org.xml.sax.XMLReader;
import vendored.org.apache.commons.codec.binary.Hex;
import vendored.org.apache.commons.codec.digest.DigestUtils;
/* loaded from: classes2.dex */
public final class Utils {
    private static final int BUFFER_SIZE = 4096;
    private static final String TAG = "Utils";
    private static RequestOptions alwaysShowIconRequestOptions;
    private static RequestOptions iconRequestOptions;
    private static Pattern safePackageNamePattern;
    private static Handler toastHandler;
    private static final String[] FRIENDLY_SIZE_FORMAT = {"%.0f B", "%.0f KiB", "%.1f MiB", "%.2f GiB"};
    private static final String[] ANDROID_VERSION_NAMES = {CallerData.NA, "1.0", "1.1", "1.5", "1.6", "2.0", "2.0.1", "2.1", "2.2", "2.3", "2.3.3", "3.0", "3.1", "3.2", "4.0", "4.0.3", "4.1", "4.2", "4.3", "4.4", "4.4W", "5.0", "5.1", "6.0", "7.0", "7.1", "8.0", "8.1", "9", "10", "11", "12", "12.1", "13", "14"};

    public static void debugLog(String str, String str2) {
    }

    public static void debugLog(String str, String str2, Throwable th) {
    }

    public static String getUserAgent() {
        return "F-Droid 1.21.1";
    }

    public static Uri getUri(String str, String... strArr) {
        int i = 0;
        if (str.startsWith("content://")) {
            StringBuilder sb = new StringBuilder(str);
            int length = strArr.length;
            while (i < length) {
                String str2 = strArr[i];
                sb.append(TreeUriDownloader.ESCAPED_SLASH);
                sb.append(str2);
                i++;
            }
            return Uri.parse(sb.toString());
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        int length2 = strArr.length;
        while (i < length2) {
            buildUpon.appendPath(strArr[i]);
            i++;
        }
        return buildUpon.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getRepoAddress(org.fdroid.database.Repository r4) {
        /*
            java.util.List r0 = r4.getMirrors()
            java.util.Iterator r0 = r0.iterator()
        L8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L41
            java.lang.Object r1 = r0.next()
            org.fdroid.download.Mirror r1 = (org.fdroid.download.Mirror) r1
            io.ktor.http.Url r2 = r1.getUrl()
            io.ktor.http.URLProtocol r2 = r2.getProtocol()
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "content"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L3c
            io.ktor.http.Url r2 = r1.getUrl()
            io.ktor.http.URLProtocol r2 = r2.getProtocol()
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "file"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L8
        L3c:
            java.lang.String r0 = r1.getBaseUrl()
            goto L42
        L41:
            r0 = 0
        L42:
            if (r0 != 0) goto L5c
            java.lang.String r4 = r4.getAddress()
            java.lang.String r0 = "/"
            boolean r0 = r4.endsWith(r0)
            if (r0 == 0) goto L5b
            int r0 = r4.length()
            int r0 = r0 + (-1)
            r1 = 0
            java.lang.String r4 = r4.substring(r1, r0)
        L5b:
            return r4
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.fdroid.Utils.getRepoAddress(org.fdroid.database.Repository):java.lang.String");
    }

    public static File getImageCacheDir(Context context) {
        return new File(Glide.getPhotoCacheDir(context.getApplicationContext()), "icons");
    }

    public static long getImageCacheDirAvailableMemory(Context context) {
        File imageCacheDir = getImageCacheDir(context);
        while (imageCacheDir != null && !imageCacheDir.exists()) {
            imageCacheDir = imageCacheDir.getParentFile();
        }
        if (imageCacheDir == null) {
            return 52428800L;
        }
        StatFs statFs = new StatFs(imageCacheDir.getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    public static long getImageCacheDirTotalMemory(Context context) {
        File imageCacheDir = getImageCacheDir(context);
        while (imageCacheDir != null && !imageCacheDir.exists()) {
            imageCacheDir = imageCacheDir.getParentFile();
        }
        if (imageCacheDir == null) {
            return 104857600L;
        }
        StatFs statFs = new StatFs(imageCacheDir.getPath());
        return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public static boolean symlinkOrCopyFileQuietly(SanitizedFile sanitizedFile, SanitizedFile sanitizedFile2) {
        return FileCompat.symlink(sanitizedFile, sanitizedFile2) || copyQuietly(sanitizedFile, sanitizedFile2);
    }

    public static void consumeStream(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
                return;
            }
        } while (inputStream.read(new byte[256]) != -1);
    }

    private static boolean copyQuietly(File file, File file2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                copy(fileInputStream, fileOutputStream);
                closeQuietly(fileOutputStream);
                closeQuietly(fileInputStream);
                return true;
            } catch (IOException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                Log.e(TAG, "I/O error when copying a file", e);
                closeQuietly(fileOutputStream2);
                closeQuietly(fileInputStream);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                closeQuietly(fileOutputStream2);
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static String getFriendlySize(long j) {
        String[] strArr;
        double d = j;
        int i = 0;
        while (true) {
            strArr = FRIENDLY_SIZE_FORMAT;
            if (i >= strArr.length - 1 || d < 1024.0d) {
                break;
            }
            d = ((d * 100.0d) / 1024.0d) / 100.0d;
            i++;
        }
        return String.format(strArr[i], Double.valueOf(d));
    }

    public static String getAndroidVersionName(int i) {
        if (i < 0) {
            return ANDROID_VERSION_NAMES[0];
        }
        String[] strArr = ANDROID_VERSION_NAMES;
        return i >= strArr.length ? String.format(Locale.ENGLISH, "v%d", Integer.valueOf(i)) : strArr[i];
    }

    public static String formatFingerprint(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.length() != 64 || str.matches(".*[^0-9a-fA-F].*")) {
            return context.getString(R.string.bad_fingerprint);
        }
        int i = 2;
        StringBuilder sb = new StringBuilder(str.substring(0, 2));
        while (i < str.length()) {
            sb.append(" ");
            int i2 = i + 2;
            sb.append(str.substring(i, i2));
            i = i2;
        }
        return sb.toString().toUpperCase(Locale.US);
    }

    public static Uri getLocalRepoUri(Repository repository) {
        if (TextUtils.isEmpty(repository.getAddress())) {
            return Uri.parse("http://wifi-not-enabled");
        }
        Uri.Builder buildUpon = Uri.parse(repository.getAddress()).buildUpon();
        if (!TextUtils.isEmpty(repository.getCertificate())) {
            buildUpon.appendQueryParameter(BonjourPeer.FINGERPRINT, DigestUtils.sha256Hex(repository.getCertificate()));
        }
        buildUpon.scheme(Preferences.get().isLocalRepoHttpsEnabled() ? "https" : "http");
        return buildUpon.build();
    }

    public static Uri getSharingUri(Repository repository) {
        if (repository == null || TextUtils.isEmpty(repository.getAddress())) {
            return Uri.parse("http://wifi-not-enabled");
        }
        Uri localRepoUri = getLocalRepoUri(repository);
        Uri.Builder buildUpon = localRepoUri.buildUpon();
        buildUpon.scheme(localRepoUri.getScheme().replaceFirst("http", "fdroidrepo"));
        buildUpon.appendQueryParameter("swap", "1");
        if (!TextUtils.isEmpty(FDroidApp.bssid)) {
            buildUpon.appendQueryParameter("bssid", FDroidApp.bssid);
            if (!TextUtils.isEmpty(FDroidApp.ssid)) {
                buildUpon.appendQueryParameter("ssid", FDroidApp.ssid);
            }
        }
        return buildUpon.build();
    }

    public static String calcFingerprint(Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        try {
            return calcFingerprint(certificate.getEncoded());
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    private static String calcFingerprint(byte[] bArr) {
        String str = null;
        if (bArr == null) {
            return null;
        }
        if (bArr.length < 256) {
            Log.e(TAG, "key was shorter than 256 bytes (" + bArr.length + "), cannot be valid!");
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha256");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            Formatter formatter = new Formatter(new StringBuilder());
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                formatter.format("%02X", Byte.valueOf(digest[i]));
            }
            str = formatter.toString();
            formatter.close();
            return str;
        } catch (Throwable th) {
            Log.w(TAG, "Unable to get certificate fingerprint", th);
            return str;
        }
    }

    public static boolean isFileMatchingHash(File file, String str, String str2) {
        if (file == null || !file.exists() || TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(getFileHexDigest(file, str2));
    }

    public static String getPackageSigner(PackageInfo packageInfo) {
        Signature[] signatureArr;
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length < 1) {
            return null;
        }
        return DigestUtils.sha256Hex(signatureArr[0].toByteArray());
    }

    public static RequestOptions getAlwaysShowIconRequestOptions() {
        if (alwaysShowIconRequestOptions == null) {
            alwaysShowIconRequestOptions = (RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().onlyRetrieveFromCache(false)).error(R.drawable.ic_repo_app_default)).fallback(R.drawable.ic_repo_app_default);
        }
        return alwaysShowIconRequestOptions;
    }

    public static void setIconFromRepoOrPM(App app, ImageView imageView, Context context) {
        loadWithGlide(context, app.repoId, app.iconFile, imageView);
    }

    @Deprecated
    public static void setIconFromRepoOrPM(AppOverviewItem appOverviewItem, ImageView imageView, Context context) {
        loadWithGlide(context, appOverviewItem.getRepoId(), appOverviewItem.getIcon(App.getLocales()), imageView);
    }

    public static void loadWithGlide(Context context, long j, IndexFile indexFile, ImageView imageView) {
        if (indexFile == null) {
            Glide.with(context).clear(imageView);
            imageView.setImageResource(R.drawable.ic_repo_app_default);
            return;
        }
        if (iconRequestOptions == null) {
            iconRequestOptions = (RequestOptions) ((RequestOptions) new RequestOptions().error(R.drawable.ic_repo_app_default)).fallback(R.drawable.ic_repo_app_default);
        }
        RequestOptions requestOptions = (RequestOptions) iconRequestOptions.onlyRetrieveFromCache(!Preferences.get().isBackgroundDownloadAllowed());
        Repository repository = FDroidApp.getRepoManager(context).getRepository(j);
        if (repository == null) {
            Glide.with(context).clear(imageView);
            return;
        }
        Object glideModel = getGlideModel(repository, indexFile);
        if (glideModel == null) {
            Glide.with(context).clear(imageView);
        } else {
            Glide.with(context).load(glideModel).apply((BaseRequestOptions) requestOptions).into(imageView);
        }
    }

    public static Object getGlideModel(Repository repository, IndexFile indexFile) {
        if (indexFile == null) {
            return null;
        }
        String repoAddress = getRepoAddress(repository);
        if (repoAddress.startsWith("content://") || repoAddress.startsWith("file://")) {
            return getUri(repoAddress, indexFile.getName().split("/")).toString();
        }
        return getDownloadRequest(repository, indexFile);
    }

    private static DownloadRequest getDownloadRequest(Repository repository, IndexFile indexFile) {
        if (indexFile == null) {
            return null;
        }
        return new DownloadRequest(indexFile, repository.getMirrors(), NetCipher.getProxy(), repository.getUsername(), repository.getPassword());
    }

    static String getFileHexDigest(File file, String str) {
        try {
            return Hex.encodeHexString(DigestUtils.digest(DigestUtils.getDigest(str), file));
        } catch (IOException e) {
            String message = e.getMessage();
            if (message.contains("read failed: EIO (I/O error)")) {
                debugLog(TAG, "potential filesystem corruption while accessing " + file + ": " + message);
                return null;
            } else if (message.contains(" ENOENT ")) {
                debugLog(TAG, file + " vanished: " + message);
                return null;
            } else {
                return null;
            }
        }
    }

    public static CharSequence formatAppNameAndSummary(String str, String str2) {
        String str3;
        if (str2 != null) {
            str3 = str + ' ' + str2;
        } else {
            str3 = str;
        }
        TypefaceSpan typefaceSpan = new TypefaceSpan("sans-serif");
        TypefaceSpan typefaceSpan2 = new TypefaceSpan("sans-serif-light");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        spannableStringBuilder.setSpan(typefaceSpan, 0, str.length(), 33);
        spannableStringBuilder.setSpan(typefaceSpan2, str.length(), str3.length(), 33);
        return spannableStringBuilder;
    }

    public static boolean isSafePackageName(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (safePackageNamePattern == null) {
            safePackageNamePattern = Pattern.compile("[a-zA-Z0-9._]+");
        }
        return safePackageNamePattern.matcher(str).matches();
    }

    public static int daysSince(long j) {
        return (int) TimeUnit.MILLISECONDS.toDays(Calendar.getInstance().getTimeInMillis() - j);
    }

    public static String formatLastUpdated(Resources resources, Date date) {
        return formatLastUpdated(resources, date.getTime());
    }

    public static String formatLastUpdated(Resources resources, long j) {
        double currentTimeMillis = System.currentTimeMillis() - j;
        long round = Math.round(currentTimeMillis / 8.64E7d);
        long round2 = Math.round(currentTimeMillis / 6.048E8d);
        long round3 = Math.round(currentTimeMillis / 2.592E9d);
        long round4 = Math.round(currentTimeMillis / 3.14496E10d);
        if (round < 1) {
            return resources.getString(R.string.details_last_updated_today);
        }
        return round2 < 3 ? resources.getQuantityString(R.plurals.details_last_update_days, (int) round, Long.valueOf(round)) : round3 < 2 ? resources.getQuantityString(R.plurals.details_last_update_weeks, (int) round2, Long.valueOf(round2)) : round4 < 2 ? resources.getQuantityString(R.plurals.details_last_update_months, (int) round3, Long.valueOf(round3)) : resources.getQuantityString(R.plurals.details_last_update_years, (int) round4, Long.valueOf(round4));
    }

    /* loaded from: classes2.dex */
    public static class HtmlTagHandler implements Html.TagHandler {
        int listNum;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.text.Html.TagHandler
        public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            char c;
            str.hashCode();
            switch (str.hashCode()) {
                case 3453:
                    if (str.equals("li")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3549:
                    if (str.equals("ol")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3735:
                    if (str.equals("ul")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if (!z) {
                        editable.append('\n');
                        return;
                    } else if (this.listNum == -1) {
                        editable.append("\t• ");
                        return;
                    } else {
                        editable.append("\t").append((CharSequence) Integer.toString(this.listNum)).append(". ");
                        this.listNum++;
                        return;
                    }
                case 1:
                    if (z) {
                        this.listNum = 1;
                        return;
                    } else {
                        editable.append('\n');
                        return;
                    }
                case 2:
                    if (z) {
                        this.listNum = -1;
                        return;
                    } else {
                        editable.append('\n');
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Could not get client version name", e);
            return null;
        }
    }

    public static String getApplicationLabel(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationInfo(str, 128).loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException | Resources.NotFoundException e) {
            debugLog(TAG, "Could not get application label: " + e.getMessage());
            return str;
        }
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            debugLog(TAG, "Could not get PackageInfo: ", e);
            return null;
        }
    }

    public static int bytesToKb(long j) {
        return (int) (j / 1024);
    }

    public static int getPercent(long j, long j2) {
        return (int) ((j * 100) / j2);
    }

    /* loaded from: classes2.dex */
    public static class Profiler {
        public final String logTag;
        public final long startTime = System.currentTimeMillis();

        public Profiler(String str) {
            this.logTag = str;
        }

        public void log(String str) {
            long currentTimeMillis = System.currentTimeMillis() - this.startTime;
            String str2 = this.logTag;
            Utils.debugLog(str2, "[" + currentTimeMillis + "ms] " + str);
        }
    }

    public static void showToastFromService(final Context context, final String str, final int i) {
        if (toastHandler == null) {
            toastHandler = new Handler(Looper.getMainLooper());
        }
        toastHandler.post(new Runnable() { // from class: org.fdroid.fdroid.Utils$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                Utils.lambda$showToastFromService$0(context, str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showToastFromService$0(Context context, String str, int i) {
        Toast.makeText(context.getApplicationContext(), str, i).show();
    }

    public static void applySwipeLayoutColors(SwipeRefreshLayout swipeRefreshLayout) {
        TypedValue typedValue = new TypedValue();
        swipeRefreshLayout.getContext().getTheme().resolveAttribute(16843827, typedValue, true);
        swipeRefreshLayout.setColorSchemeColors(typedValue.data);
    }

    public static boolean canConnectToSocket(String str, int i) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(str, i), 5);
            socket.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean isServerSocketInUse(int i) {
        try {
            new ServerSocket(i).close();
            return false;
        } catch (IOException unused) {
            return true;
        }
    }

    public static Single generateQrBitmap(final AppCompatActivity appCompatActivity, final String str) {
        return Single.fromCallable(new Callable() { // from class: org.fdroid.fdroid.Utils$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Bitmap lambda$generateQrBitmap$1;
                lambda$generateQrBitmap$1 = Utils.lambda$generateQrBitmap$1(AppCompatActivity.this, str);
                return lambda$generateQrBitmap$1;
            }
        }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).onErrorReturnItem(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)).doOnError(new Consumer() { // from class: org.fdroid.fdroid.Utils$$ExternalSyntheticLambda6
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                Log.e(Utils.TAG, "Could not encode QR as bitmap", (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bitmap lambda$generateQrBitmap$1(AppCompatActivity appCompatActivity, String str) throws Exception {
        DisplayCompat.ModeCompat mode = DisplayCompat.getMode(appCompatActivity, appCompatActivity.getWindowManager().getDefaultDisplay());
        int min = Math.min(mode.getPhysicalWidth(), mode.getPhysicalHeight());
        debugLog(TAG, "generating QRCode Bitmap of " + min + "x" + min);
        return new QRCodeEncoder(str, null, "TEXT_TYPE", BarcodeFormat.QR_CODE.toString(), min).encodeAsBitmap();
    }

    public static <T> Disposable runOffUiThread(final Supplier supplier, final androidx.core.util.Consumer consumer) {
        Objects.requireNonNull(supplier);
        Single doOnError = Single.fromCallable(new Callable() { // from class: org.fdroid.fdroid.Utils$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Supplier.this.get();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnError(new Consumer() { // from class: org.fdroid.fdroid.Utils$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                Log.e(Utils.TAG, "Error running off UiThread", (Throwable) obj);
            }
        });
        Objects.requireNonNull(consumer);
        return doOnError.subscribe(new Consumer() { // from class: org.fdroid.fdroid.Utils$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                androidx.core.util.Consumer.this.accept(obj);
            }
        });
    }

    public static Disposable runOffUiThread(final Runnable runnable) {
        return Single.fromCallable(new Callable() { // from class: org.fdroid.fdroid.Utils$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean lambda$runOffUiThread$4;
                lambda$runOffUiThread$4 = Utils.lambda$runOffUiThread$4(runnable);
                return lambda$runOffUiThread$4;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnError(new Consumer() { // from class: org.fdroid.fdroid.Utils$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                Log.e(Utils.TAG, "Error running off UiThread", (Throwable) obj);
            }
        }).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$runOffUiThread$4(Runnable runnable) throws Exception {
        runnable.run();
        return Boolean.TRUE;
    }

    public static <T> void observeOnce(final LiveData liveData, LifecycleOwner lifecycleOwner, final androidx.core.util.Consumer consumer) {
        liveData.observe(lifecycleOwner, new Observer() { // from class: org.fdroid.fdroid.Utils.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(T t) {
                androidx.core.util.Consumer.this.accept(t);
                liveData.removeObserver(this);
            }
        });
    }

    public static ArrayList<String> toString(List<FileV2> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<String> arrayList = new ArrayList<>(list.size());
        for (FileV2 fileV2 : list) {
            arrayList.add(fileV2.serialize());
        }
        return arrayList;
    }

    public static List<FileV2> fileV2FromStrings(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(FileV2.deserialize(str));
        }
        return arrayList;
    }

    /* loaded from: classes2.dex */
    public static class KeyboardStateMonitor {
        private boolean visible = false;

        public boolean isKeyboardVisible() {
            return this.visible;
        }

        public KeyboardStateMonitor(final View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: org.fdroid.fdroid.Utils$KeyboardStateMonitor$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    Utils.KeyboardStateMonitor.this.lambda$new$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            int height = view.getRootView().getHeight();
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            this.visible = ((double) (height - rect.bottom)) >= ((double) height) * 0.15d;
        }
    }

    public static boolean isPortInUse(String str, int i) {
        try {
            new Socket(str, i).close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void copyToClipboard(Context context, String str, String str2) {
        copyToClipboard(context, str, str2, R.string.copied_to_clipboard);
    }

    public static void copyToClipboard(Context context, String str, String str2, int i) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager == null) {
            return;
        }
        try {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(str, str2));
            if (Build.VERSION.SDK_INT < 33) {
                Toast.makeText(context, i, 0).show();
            }
        } catch (Exception e) {
            debugLog(TAG, "Could not copy to clipboard: " + e.getMessage());
        }
    }

    public static String toJsonStringArray(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        return jSONArray.toString();
    }

    public static List<String> parseJsonStringArray(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (JSONException unused) {
            return Collections.emptyList();
        }
    }
}
