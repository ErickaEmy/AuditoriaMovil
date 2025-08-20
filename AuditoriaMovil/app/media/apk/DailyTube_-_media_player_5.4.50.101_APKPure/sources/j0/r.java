package j0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m0.a;
import m0.n3;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: gv  reason: collision with root package name */
    public final z f9360gv;

    /* renamed from: n3  reason: collision with root package name */
    public final p f9361n3;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public PackageInfo f9362v;
    public final a y;

    /* renamed from: zn  reason: collision with root package name */
    public final Context f9363zn;

    public r(Context context, a aVar, p pVar) {
        z zVar = new z(new n3(aVar));
        this.y = aVar;
        this.f9361n3 = pVar;
        this.f9363zn = context;
        this.f9360gv = zVar;
    }

    @Nullable
    public static X509Certificate v(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e2) {
            Log.e("SplitCompat", "Cannot decode certificate.", e2);
            return null;
        }
    }

    @Nullable
    public final PackageInfo gv() {
        if (this.f9362v == null) {
            try {
                this.f9362v = this.f9363zn.getPackageManager().getPackageInfo(this.f9363zn.getPackageName(), 64);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return this.f9362v;
    }

    public final boolean n3(List list) throws IOException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!this.y.fb(((Intent) it.next()).getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }

    public final boolean y(File[] fileArr) throws IOException, XmlPullParserException {
        long j2;
        PackageInfo gv2 = gv();
        if (Build.VERSION.SDK_INT >= 28) {
            j2 = gv2.getLongVersionCode();
        } else {
            j2 = gv2.versionCode;
        }
        AssetManager assetManager = (AssetManager) j.zn(AssetManager.class);
        int length = fileArr.length;
        do {
            length--;
            if (length >= 0) {
                this.f9360gv.n3(assetManager, fileArr[length]);
            } else {
                return true;
            }
        } while (j2 == this.f9360gv.y());
        return false;
    }

    public final boolean zn(File[] fileArr) {
        PackageInfo gv2 = gv();
        ArrayList<X509Certificate> arrayList = null;
        if (gv2 != null && gv2.signatures != null) {
            arrayList = new ArrayList();
            for (Signature signature : gv2.signatures) {
                X509Certificate v2 = v(signature);
                if (v2 != null) {
                    arrayList.add(v2);
                }
            }
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            int length = fileArr.length;
            loop1: while (true) {
                length--;
                if (length >= 0) {
                    try {
                        String absolutePath = fileArr[length].getAbsolutePath();
                        try {
                            X509Certificate[][] y = u0.y(absolutePath);
                            if (y == null || y.length == 0 || y[0].length == 0) {
                                break;
                            } else if (arrayList.isEmpty()) {
                                Log.e("SplitCompat", "No certificates found for app.");
                                break;
                            } else {
                                for (X509Certificate x509Certificate : arrayList) {
                                    for (X509Certificate[] x509CertificateArr : y) {
                                        if (!x509CertificateArr[0].equals(x509Certificate)) {
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 32);
                            sb.append("Downloaded split ");
                            sb.append(absolutePath);
                            sb.append(" is not signed.");
                            Log.e("SplitCompat", sb.toString(), e2);
                        }
                    } catch (Exception e3) {
                        Log.e("SplitCompat", "Split verification error.", e3);
                        return false;
                    }
                } else {
                    return true;
                }
            }
        } else {
            Log.e("SplitCompat", "No app certificates found.");
            return false;
        }
        Log.e("SplitCompat", "Split verification failure.");
        return false;
    }
}
