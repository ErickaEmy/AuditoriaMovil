package org.fdroid.index;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.system.Os;
import androidx.core.content.pm.PackageInfoCompat;
import ch.qos.logback.core.joran.action.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IndexCreator.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\r\u0010\u001b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0006H\u0004J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\b\u0010 \u001a\u00020!H\u0004R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lorg/fdroid/index/IndexCreator;", "T", "", "packageManager", "Landroid/content/pm/PackageManager;", "repoDir", "Ljava/io/File;", "packageNames", "", "", "(Landroid/content/pm/PackageManager;Ljava/io/File;Ljava/util/Set;)V", "iconDir", "iconDirs", "", "nativeCodePattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getPackageManager", "()Landroid/content/pm/PackageManager;", "getPackageNames", "()Ljava/util/Set;", "getRepoDir", "()Ljava/io/File;", "copyApkToRepo", "packageInfo", "Landroid/content/pm/PackageInfo;", "copyIconToRepo", "createRepo", "()Ljava/lang/Object;", "hashFile", Action.FILE_ATTRIBUTE, "parseNativeCode", "prepareIconFolders", "", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class IndexCreator<T> {
    private final File iconDir;
    private final List<String> iconDirs;
    private final Pattern nativeCodePattern;
    private final PackageManager packageManager;
    private final Set<String> packageNames;
    private final File repoDir;

    public abstract T createRepo() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public final PackageManager getPackageManager() {
        return this.packageManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Set<String> getPackageNames() {
        return this.packageNames;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final File getRepoDir() {
        return this.repoDir;
    }

    public IndexCreator(PackageManager packageManager, File repoDir, Set<String> packageNames) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(repoDir, "repoDir");
        Intrinsics.checkNotNullParameter(packageNames, "packageNames");
        this.packageManager = packageManager;
        this.repoDir = repoDir;
        this.packageNames = packageNames;
        this.iconDir = new File(repoDir, "icons");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"icons-120", "icons-160", "icons-240", "icons-320", "icons-480", "icons-640"});
        this.iconDirs = listOf;
        this.nativeCodePattern = Pattern.compile("^lib/([a-z0-9-]+)/.*");
        if (!repoDir.isDirectory()) {
            throw new IllegalArgumentException((repoDir + " is not a directory").toString());
        } else if (repoDir.canWrite()) {
        } else {
            throw new IllegalArgumentException(("Can not write to " + repoDir).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void prepareIconFolders() {
        this.iconDir.mkdir();
        for (String str : this.iconDirs) {
            File file = new File(this.repoDir, str);
            if (!file.exists()) {
                Os.symlink(this.iconDir.getAbsolutePath(), file.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String copyIconToRepo(PackageInfo packageInfo) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        String str = packageInfo.packageName;
        long longVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo);
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        Drawable loadIcon = applicationInfo != null ? applicationInfo.loadIcon(this.packageManager) : null;
        if (loadIcon == null) {
            return null;
        }
        if (loadIcon instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) loadIcon).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(loadIcon.getIntrinsicWidth(), loadIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(createBitmap);
            loadIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            loadIcon.draw(canvas);
            bitmap = createBitmap;
        }
        String str2 = str + "_" + longVersionCode + ".png";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(this.iconDir, str2));
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            CloseableKt.closeFinally(fileOutputStream, null);
            return str2;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final File copyApkToRepo(PackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return null;
        }
        String str = packageInfo.packageName;
        long longVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo);
        File file = new File(this.repoDir, str + "_" + longVersionCode + ".apk");
        if (file.exists()) {
            file.delete();
        }
        Os.symlink(applicationInfo.publicSourceDir, file.getAbsolutePath());
        if (!file.exists()) {
            FilesKt__UtilsKt.copyTo$default(new File(applicationInfo.publicSourceDir), file, false, 0, 6, null);
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String hashFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            Intrinsics.checkNotNull(messageDigest);
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                for (int read = fileInputStream.read(bArr); read >= 0; read = fileInputStream.read(bArr)) {
                    messageDigest.update(bArr, 0, read);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileInputStream, null);
                IndexUtils indexUtils = IndexUtils.INSTANCE;
                byte[] digest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
                return indexUtils.toHex$index_release(digest);
            } finally {
            }
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<String> parseNativeCode(PackageInfo packageInfo) {
        List<String> list;
        String group;
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        JarFile jarFile = new JarFile(applicationInfo.publicSourceDir);
        HashSet hashSet = new HashSet();
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            Matcher matcher = this.nativeCodePattern.matcher(entries.nextElement().getName());
            if (matcher.matches() && (group = matcher.group(1)) != null) {
                hashSet.add(group);
            }
        }
        list = CollectionsKt___CollectionsKt.toList(hashSet);
        return list;
    }
}
