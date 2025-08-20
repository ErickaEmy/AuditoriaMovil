package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public static final File copyTo(File file, File target, boolean z2, int i) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        if (file.exists()) {
            if (target.exists()) {
                if (z2) {
                    if (!target.delete()) {
                        throw new FileAlreadyExistsException(file, target, "Tried to overwrite the destination, but failed to delete it.");
                    }
                } else {
                    throw new FileAlreadyExistsException(file, target, "The destination file already exists.");
                }
            }
            if (file.isDirectory()) {
                if (!target.mkdirs()) {
                    throw new FileSystemException(file, target, "Failed to create target directory.");
                }
            } else {
                File parentFile = target.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(target);
                    ByteStreamsKt.copyTo(fileInputStream, fileOutputStream, i);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                } finally {
                }
            }
            return target;
        }
        throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean z2, int i, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z2 = false;
        }
        if ((i5 & 4) != 0) {
            i = 8192;
        }
        return copyTo(file, file2, z2, i);
    }

    public static boolean deleteRecursively(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        while (true) {
            boolean z2 = true;
            for (File file2 : FilesKt__FileTreeWalkKt.walkBottomUp(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z2) {
                        break;
                    }
                }
                z2 = false;
            }
            return z2;
        }
    }

    public static String getNameWithoutExtension(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.substringBeforeLast$default(name, ".", null, 2, null);
    }
}
