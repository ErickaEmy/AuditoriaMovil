package org.acra.file;

import android.content.Context;
import android.os.Environment;
import ch.qos.logback.core.CoreConstants;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Directory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lorg/acra/file/Directory;", "", "(Ljava/lang/String;I)V", "getFile", "Ljava/io/File;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "fileName", "", "FILES_LEGACY", "FILES", "EXTERNAL_FILES", "CACHE", "EXTERNAL_CACHE", "NO_BACKUP_FILES", "EXTERNAL_STORAGE", "ROOT", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Directory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Directory[] $VALUES;
    public static final Directory FILES_LEGACY = new Directory("FILES_LEGACY", 0) { // from class: org.acra.file.Directory.FILES_LEGACY
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            boolean startsWith$default;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(fileName, "/", false, 2, null);
            return (startsWith$default ? Directory.ROOT : Directory.FILES).getFile(context, fileName);
        }
    };
    public static final Directory FILES = new Directory("FILES", 1) { // from class: org.acra.file.Directory.FILES
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new File(context.getFilesDir(), fileName);
        }
    };
    public static final Directory EXTERNAL_FILES = new Directory("EXTERNAL_FILES", 2) { // from class: org.acra.file.Directory.EXTERNAL_FILES
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new File(context.getExternalFilesDir(null), fileName);
        }
    };
    public static final Directory CACHE = new Directory("CACHE", 3) { // from class: org.acra.file.Directory.CACHE
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new File(context.getCacheDir(), fileName);
        }
    };
    public static final Directory EXTERNAL_CACHE = new Directory("EXTERNAL_CACHE", 4) { // from class: org.acra.file.Directory.EXTERNAL_CACHE
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new File(context.getExternalCacheDir(), fileName);
        }
    };
    public static final Directory NO_BACKUP_FILES = new Directory("NO_BACKUP_FILES", 5) { // from class: org.acra.file.Directory.NO_BACKUP_FILES
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            File noBackupFilesDir = context.getNoBackupFilesDir();
            Intrinsics.checkNotNull(noBackupFilesDir);
            return new File(noBackupFilesDir, fileName);
        }
    };
    public static final Directory EXTERNAL_STORAGE = new Directory("EXTERNAL_STORAGE", 6) { // from class: org.acra.file.Directory.EXTERNAL_STORAGE
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new File(Environment.getExternalStorageDirectory(), fileName);
        }
    };
    public static final Directory ROOT = new Directory("ROOT", 7) { // from class: org.acra.file.Directory.ROOT
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            List split$default;
            String replace$default;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            split$default = StringsKt__StringsKt.split$default((CharSequence) fileName, new String[]{separator}, false, 2, 2, (Object) null);
            if (split$default.size() == 1) {
                return new File(fileName);
            }
            File[] listRoots = File.listRoots();
            Intrinsics.checkNotNull(listRoots);
            for (File file : listRoots) {
                Object obj = split$default.get(0);
                String path = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                String separator2 = File.separator;
                Intrinsics.checkNotNullExpressionValue(separator2, "separator");
                replace$default = StringsKt__StringsJVMKt.replace$default(path, separator2, "", false, 4, (Object) null);
                if (Intrinsics.areEqual(obj, replace$default)) {
                    return new File(file, (String) split$default.get(1));
                }
            }
            return new File(listRoots[0], fileName);
        }
    };

    private static final /* synthetic */ Directory[] $values() {
        return new Directory[]{FILES_LEGACY, FILES, EXTERNAL_FILES, CACHE, EXTERNAL_CACHE, NO_BACKUP_FILES, EXTERNAL_STORAGE, ROOT};
    }

    public /* synthetic */ Directory(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    public static Directory valueOf(String str) {
        return (Directory) Enum.valueOf(Directory.class, str);
    }

    public static Directory[] values() {
        return (Directory[]) $VALUES.clone();
    }

    public abstract File getFile(Context context, String str);

    private Directory(String str, int i) {
    }

    static {
        Directory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
