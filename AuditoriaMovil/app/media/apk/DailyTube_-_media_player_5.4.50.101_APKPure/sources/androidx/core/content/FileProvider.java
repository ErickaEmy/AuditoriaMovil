package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File("/");
    private static final HashMap<String, n3> sCache = new HashMap<>();
    private String mAuthority;
    @Nullable
    private n3 mLocalPathStrategy;
    private int mResourceId;

    /* loaded from: classes.dex */
    public interface n3 {
        File n3(Uri uri);

        Uri y(File file);
    }

    /* loaded from: classes.dex */
    public static class y {
        public static File[] y(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    /* loaded from: classes.dex */
    public static class zn implements n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final HashMap<String, File> f2327n3 = new HashMap<>();
        public final String y;

        public zn(String str) {
            this.y = str;
        }

        @Override // androidx.core.content.FileProvider.n3
        public File n3(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f2327n3.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            }
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }

        @Override // androidx.core.content.FileProvider.n3
        public Uri y(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f2327n3.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry != null) {
                    String path2 = entry.getValue().getPath();
                    if (path2.endsWith("/")) {
                        substring = canonicalPath.substring(path2.length());
                    } else {
                        substring = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme("content").authority(this.y).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        public void zn(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f2327n3.put(str, file.getCanonicalFile());
                    return;
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e2);
                }
            }
            throw new IllegalArgumentException("Name must not be empty");
        }
    }

    public FileProvider() {
    }

    private static File buildPath(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] copyOf(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    public static XmlResourceParser getFileProviderPathsMetaData(Context context, String str, @Nullable ProviderInfo providerInfo, int i) {
        if (providerInfo != null) {
            if (providerInfo.metaData == null && i != 0) {
                Bundle bundle = new Bundle(1);
                providerInfo.metaData = bundle;
                bundle.putInt("android.support.FILE_PROVIDER_PATHS", i);
            }
            XmlResourceParser loadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
            if (loadXmlMetaData != null) {
                return loadXmlMetaData;
            }
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
    }

    private n3 getLocalPathStrategy() {
        n3 n3Var;
        synchronized (this) {
            try {
                if (this.mLocalPathStrategy == null) {
                    this.mLocalPathStrategy = getPathStrategy(getContext(), this.mAuthority, this.mResourceId);
                }
                n3Var = this.mLocalPathStrategy;
            } catch (Throwable th) {
                throw th;
            }
        }
        return n3Var;
    }

    private static n3 getPathStrategy(Context context, String str, int i) {
        n3 n3Var;
        HashMap<String, n3> hashMap = sCache;
        synchronized (hashMap) {
            try {
                n3Var = hashMap.get(str);
                if (n3Var == null) {
                    try {
                        try {
                            n3Var = parsePathStrategy(context, str, i);
                            hashMap.put(str, n3Var);
                        } catch (IOException e2) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                        }
                    } catch (XmlPullParserException e3) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return n3Var;
    }

    public static Uri getUriForFile(@NonNull Context context, @NonNull String str, @NonNull File file) {
        return getPathStrategy(context, str, 0).y(file);
    }

    private static int modeToMode(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if (!"w".equals(str) && !"wt".equals(str)) {
            if ("wa".equals(str)) {
                return 704643072;
            }
            if ("rw".equals(str)) {
                return 939524096;
            }
            if ("rwt".equals(str)) {
                return 1006632960;
            }
            throw new IllegalArgumentException("Invalid mode: " + str);
        }
        return 738197504;
    }

    private static n3 parsePathStrategy(Context context, String str, int i) throws IOException, XmlPullParserException {
        zn znVar = new zn(str);
        XmlResourceParser fileProviderPathsMetaData = getFileProviderPathsMetaData(context, str, context.getPackageManager().resolveContentProvider(str, NotificationCompat.FLAG_HIGH_PRIORITY), i);
        while (true) {
            int next = fileProviderPathsMetaData.next();
            if (next != 1) {
                if (next == 2) {
                    String name = fileProviderPathsMetaData.getName();
                    File file = null;
                    String attributeValue = fileProviderPathsMetaData.getAttributeValue(null, "name");
                    String attributeValue2 = fileProviderPathsMetaData.getAttributeValue(null, "path");
                    if ("root-path".equals(name)) {
                        file = DEVICE_ROOT;
                    } else if ("files-path".equals(name)) {
                        file = context.getFilesDir();
                    } else if ("cache-path".equals(name)) {
                        file = context.getCacheDir();
                    } else if ("external-path".equals(name)) {
                        file = Environment.getExternalStorageDirectory();
                    } else if ("external-files-path".equals(name)) {
                        File[] fb2 = mg.y.fb(context, null);
                        if (fb2.length > 0) {
                            file = fb2[0];
                        }
                    } else if ("external-cache-path".equals(name)) {
                        File[] a2 = mg.y.a(context);
                        if (a2.length > 0) {
                            file = a2[0];
                        }
                    } else if ("external-media-path".equals(name)) {
                        File[] y2 = y.y(context);
                        if (y2.length > 0) {
                            file = y2[0];
                        }
                    }
                    if (file != null) {
                        znVar.zn(attributeValue, buildPath(file, attributeValue2));
                    }
                }
            } else {
                return znVar;
            }
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                this.mAuthority = providerInfo.authority.split(";")[0];
                HashMap<String, n3> hashMap = sCache;
                synchronized (hashMap) {
                    hashMap.remove(this.mAuthority);
                }
                return;
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return getLocalPathStrategy().n3(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        File n32 = getLocalPathStrategy().n3(uri);
        int lastIndexOf = n32.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(n32.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
            return "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Nullable
    public String getTypeAnonymous(@NonNull Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri uri, @NonNull ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(getLocalPathStrategy().n3(uri), modeToMode(str));
    }

    @Override // android.content.ContentProvider
    @NonNull
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int i;
        String str3;
        File n32 = getLocalPathStrategy().n3(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i5 = 0;
        for (String str4 : strArr) {
            if ("_display_name".equals(str4)) {
                strArr3[i5] = "_display_name";
                i = i5 + 1;
                if (queryParameter == null) {
                    str3 = n32.getName();
                } else {
                    str3 = queryParameter;
                }
                objArr[i5] = str3;
            } else if ("_size".equals(str4)) {
                strArr3[i5] = "_size";
                i = i5 + 1;
                objArr[i5] = Long.valueOf(n32.length());
            }
            i5 = i;
        }
        String[] copyOf = copyOf(strArr3, i5);
        Object[] copyOf2 = copyOf(objArr, i5);
        MatrixCursor matrixCursor = new MatrixCursor(copyOf, 1);
        matrixCursor.addRow(copyOf2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @NonNull ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public FileProvider(int i) {
        this.mResourceId = i;
    }

    private static Object[] copyOf(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    @NonNull
    @SuppressLint({"StreamFiles"})
    public static Uri getUriForFile(@NonNull Context context, @NonNull String str, @NonNull File file, @NonNull String str2) {
        return getUriForFile(context, str, file).buildUpon().appendQueryParameter("displayName", str2).build();
    }
}
