package androidx.core.app;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import java.util.ArrayList;
/* loaded from: classes.dex */
abstract class ShareCompat$Api16Impl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void migrateExtraStreamToClipData(Intent intent, ArrayList<Uri> arrayList) {
        ClipData clipData = new ClipData(null, new String[]{intent.getType()}, new ClipData.Item(intent.getCharSequenceExtra("android.intent.extra.TEXT"), intent.getStringExtra("android.intent.extra.HTML_TEXT"), null, arrayList.get(0)));
        int size = arrayList.size();
        for (int i = 1; i < size; i++) {
            clipData.addItem(new ClipData.Item(arrayList.get(i)));
        }
        intent.setClipData(clipData);
        intent.addFlags(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeClipData(Intent intent) {
        intent.setClipData(null);
        intent.setFlags(intent.getFlags() & (-2));
    }

    static String escapeHtml(CharSequence charSequence) {
        return Html.escapeHtml(charSequence);
    }
}
