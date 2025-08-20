package m0;

import android.os.Build;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
public final class wz {

    /* renamed from: n3  reason: collision with root package name */
    public static final Pattern f10562n3 = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    public final a y;

    public wz(a aVar) throws IOException {
        this.y = aVar;
    }

    public static void v(z zVar, f fVar) throws IOException {
        ZipFile zipFile;
        String[] strArr;
        try {
            zipFile = new ZipFile(zVar.y());
        } catch (IOException e2) {
            e = e2;
            zipFile = null;
        }
        try {
            zVar.n3();
            HashMap hashMap = new HashMap();
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                Matcher matcher = f10562n3.matcher(nextElement.getName());
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    Set set = (Set) hashMap.get(group);
                    if (set == null) {
                        set = new HashSet();
                        hashMap.put(group, set);
                    }
                    set.add(new tl(nextElement, group2));
                }
            }
            HashMap hashMap2 = new HashMap();
            for (String str : Build.SUPPORTED_ABIS) {
                if (hashMap.containsKey(str)) {
                    for (tl tlVar : (Set) hashMap.get(str)) {
                        if (!hashMap2.containsKey(tlVar.y)) {
                            hashMap2.put(tlVar.y, tlVar);
                        }
                    }
                }
            }
            fVar.y(zipFile, new HashSet(hashMap2.values()));
            zipFile.close();
        } catch (IOException e3) {
            e = e3;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException unused) {
                }
            }
            throw e;
        }
    }

    public static /* bridge */ /* synthetic */ Set y(wz wzVar, Set set, z zVar, ZipFile zipFile) {
        HashSet hashSet = new HashSet();
        wzVar.a(zVar, set, new i9(wzVar, hashSet, zVar, zipFile));
        return hashSet;
    }

    public final void a(z zVar, Set set, t tVar) throws IOException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            tl tlVar = (tl) it.next();
            File zn2 = this.y.zn(zVar.n3(), tlVar.y);
            boolean z2 = false;
            if (zn2.exists() && zn2.length() == tlVar.f10561n3.getSize() && a.w(zn2)) {
                z2 = true;
            }
            tVar.y(tlVar, zn2, z2);
        }
    }

    @Nullable
    public final Set n3(z zVar) throws IOException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        v(zVar, new s(this, zVar, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }

    public final Set zn() throws IOException {
        Set<z> i92 = this.y.i9();
        for (String str : this.y.s()) {
            Iterator it = i92.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((z) it.next()).n3().equals(str)) {
                        break;
                    }
                } else {
                    this.y.wz(str);
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (z zVar : i92) {
            HashSet hashSet2 = new HashSet();
            v(zVar, new c5(this, hashSet2, zVar));
            for (File file : this.y.c5(zVar.n3())) {
                if (!hashSet2.contains(file)) {
                    file.getAbsolutePath();
                    zVar.n3();
                    zVar.y().getAbsolutePath();
                    this.y.xc(file);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }
}
