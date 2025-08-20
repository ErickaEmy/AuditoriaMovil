package org.acra.attachment;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.acra.ACRA;
import org.acra.file.Directory;
import org.acra.log.ACRALog;
/* compiled from: AcraContentProvider.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016JK\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001cJ9\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u001eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lorg/acra/attachment/AcraContentProvider;", "Landroid/content/ContentProvider;", "()V", "authority", "", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getFileForUri", "Ljava/io/File;", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "openFile", "Landroid/os/ParcelFileDescriptor;", "mode", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AcraContentProvider extends ContentProvider {
    private String authority;
    public static final Companion Companion = new Companion(null);
    private static final String[] COLUMNS = {"_display_name", "_size"};

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (ACRA.DEV_LOGGING) {
            ACRALog aCRALog = ACRA.log;
            String str3 = ACRA.LOG_TAG;
            aCRALog.d(str3, "Query: " + uri);
        }
        File fileForUri = getFileForUri(uri);
        if (fileForUri == null) {
            return null;
        }
        if (strArr == null) {
            strArr = COLUMNS;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = ArrayIteratorKt.iterator(strArr);
        while (it.hasNext()) {
            String str4 = (String) it.next();
            if (Intrinsics.areEqual(str4, "_display_name")) {
                linkedHashMap.put("_display_name", fileForUri.getName());
            } else if (Intrinsics.areEqual(str4, "_size")) {
                linkedHashMap.put("_size", Long.valueOf(fileForUri.length()));
            }
        }
        MatrixCursor matrixCursor = new MatrixCursor((String[]) linkedHashMap.keySet().toArray(new String[0]), 1);
        matrixCursor.addRow(linkedHashMap.values());
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Companion companion = Companion;
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        String authority = companion.getAuthority(context);
        this.authority = authority;
        if (ACRA.DEV_LOGGING) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            aCRALog.d(str, "Registered content provider for authority " + authority);
            return true;
        }
        return true;
    }

    private final File getFileForUri(Uri uri) {
        List mutableList;
        if (Intrinsics.areEqual("content", uri.getScheme()) && Intrinsics.areEqual(this.authority, uri.getAuthority())) {
            List<String> pathSegments = uri.getPathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) pathSegments);
            if (mutableList.size() < 2) {
                return null;
            }
            Object remove = mutableList.remove(0);
            Intrinsics.checkNotNullExpressionValue(remove, "removeAt(...)");
            String upperCase = ((String) remove).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            try {
                Directory valueOf = Directory.valueOf(upperCase);
                Context context = getContext();
                Intrinsics.checkNotNull(context);
                String join = TextUtils.join(File.separator, mutableList);
                Intrinsics.checkNotNullExpressionValue(join, "join(...)");
                return valueOf.getFile(context, join);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Companion.guessMimeType(uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("No insert supported");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("No delete supported");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("No update supported");
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String mode) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mode, "mode");
        File fileForUri = getFileForUri(uri);
        if (fileForUri != null) {
            if (!fileForUri.exists()) {
                fileForUri = null;
            }
            if (fileForUri != null) {
                if (ACRA.DEV_LOGGING) {
                    ACRALog aCRALog = ACRA.log;
                    String str = ACRA.LOG_TAG;
                    String callingPackage = getCallingPackage();
                    String path = fileForUri.getPath();
                    aCRALog.d(str, callingPackage + " opened " + path);
                }
                ParcelFileDescriptor open = ParcelFileDescriptor.open(fileForUri, 268435456);
                Intrinsics.checkNotNullExpressionValue(open, "open(...)");
                return open;
            }
        }
        throw new FileNotFoundException("File represented by uri " + uri + " could not be found");
    }

    /* compiled from: AcraContentProvider.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getAuthority(Context context) {
            String packageName = context.getPackageName();
            return packageName + ".acra";
        }

        public final Uri getUriForFile(Context context, File file) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(file, "file");
            Directory directory = Directory.ROOT;
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            return getUriForFile(context, directory, path);
        }

        public final Uri getUriForFile(Context context, Directory directory, String relativePath) {
            List split$default;
            String[] strArr;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(directory, "directory");
            Intrinsics.checkNotNullParameter(relativePath, "relativePath");
            Uri.Builder authority = new Uri.Builder().scheme("content").authority(getAuthority(context));
            String lowerCase = directory.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            Uri.Builder appendPath = authority.appendPath(lowerCase);
            String quote = Pattern.quote(File.separator);
            Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
            split$default = StringsKt__StringsKt.split$default((CharSequence) relativePath, new String[]{quote}, false, 0, 6, (Object) null);
            for (String str : (String[]) split$default.toArray(new String[0])) {
                if (str.length() > 0) {
                    appendPath.appendPath(str);
                }
            }
            Uri build = appendPath.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        public final String guessMimeType(Uri uri) {
            String str;
            Intrinsics.checkNotNullParameter(uri, "uri");
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
            if (fileExtensionFromUrl != null) {
                MimeTypeMap singleton = MimeTypeMap.getSingleton();
                String lowerCase = fileExtensionFromUrl.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                str = singleton.getMimeTypeFromExtension(lowerCase);
                if (str == null && Intrinsics.areEqual("json", fileExtensionFromUrl)) {
                    str = "application/json";
                }
            } else {
                str = null;
            }
            return str == null ? "application/octet-stream" : str;
        }
    }
}
