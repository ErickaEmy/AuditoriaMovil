package k5;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import k5.fb;
/* loaded from: classes.dex */
public class gv {
    public static final Comparator<byte[]> y = new Comparator() { // from class: k5.zn
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int fb2;
            fb2 = gv.fb((byte[]) obj, (byte[]) obj2);
            return fb2;
        }
    };

    /* loaded from: classes.dex */
    public static class y {
        public static Cursor y(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    @Nullable
    public static ProviderInfo a(@NonNull PackageManager packageManager, @NonNull v vVar, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        String v2 = vVar.v();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(v2, 0);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.packageName.equals(vVar.a())) {
                List<byte[]> n32 = n3(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(n32, y);
                List<List<byte[]>> gv2 = gv(vVar, resources);
                for (int i = 0; i < gv2.size(); i++) {
                    ArrayList arrayList = new ArrayList(gv2.get(i));
                    Collections.sort(arrayList, y);
                    if (zn(n32, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + v2 + ", but package was not " + vVar.a());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + v2);
    }

    public static /* synthetic */ int fb(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            byte b3 = bArr2[i];
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return 0;
    }

    public static List<List<byte[]>> gv(v vVar, Resources resources) {
        if (vVar.n3() != null) {
            return vVar.n3();
        }
        return d.v.zn(resources, vVar.zn());
    }

    public static List<byte[]> n3(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    @NonNull
    public static fb.n3[] s(Context context, v vVar, String str, CancellationSignal cancellationSignal) {
        int i;
        int i5;
        Uri withAppendedId;
        int i6;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            cursor = y.y(context.getContentResolver(), build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{vVar.fb()}, null, cancellationSignal);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    if (columnIndex != -1) {
                        i = cursor.getInt(columnIndex);
                    } else {
                        i = 0;
                    }
                    if (columnIndex4 != -1) {
                        i5 = cursor.getInt(columnIndex4);
                    } else {
                        i5 = 0;
                    }
                    if (columnIndex3 == -1) {
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    if (columnIndex5 != -1) {
                        i6 = cursor.getInt(columnIndex5);
                    } else {
                        i6 = 400;
                    }
                    if (columnIndex6 != -1) {
                        z2 = true;
                        if (cursor.getInt(columnIndex6) == 1) {
                            arrayList2.add(fb.n3.y(withAppendedId, i5, i6, z2, i));
                        }
                    }
                    z2 = false;
                    arrayList2.add(fb.n3.y(withAppendedId, i5, i6, z2, i));
                }
                arrayList = arrayList2;
            }
            if (cursor != null) {
                cursor.close();
            }
            return (fb.n3[]) arrayList.toArray(new fb.n3[0]);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @NonNull
    public static fb.y v(@NonNull Context context, @NonNull v vVar, @Nullable CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo a2 = a(context.getPackageManager(), vVar, context.getResources());
        if (a2 == null) {
            return fb.y.y(1, null);
        }
        return fb.y.y(0, s(context, vVar, a2.authority, cancellationSignal));
    }

    public static boolean zn(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
