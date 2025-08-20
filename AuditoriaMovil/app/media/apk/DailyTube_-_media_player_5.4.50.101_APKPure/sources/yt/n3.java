package yt;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class n3 {

    /* loaded from: classes.dex */
    public static class y {
        public static Spanned n3(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i, imageGetter, tagHandler);
        }

        public static Spanned y(String str, int i) {
            return Html.fromHtml(str, i);
        }

        public static String zn(Spanned spanned, int i) {
            return Html.toHtml(spanned, i);
        }
    }

    @NonNull
    public static Spanned n3(@NonNull String str, int i, @Nullable Html.ImageGetter imageGetter, @Nullable Html.TagHandler tagHandler) {
        if (Build.VERSION.SDK_INT >= 24) {
            return y.n3(str, i, imageGetter, tagHandler);
        }
        return Html.fromHtml(str, imageGetter, tagHandler);
    }

    @NonNull
    public static Spanned y(@NonNull String str, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return y.y(str, i);
        }
        return Html.fromHtml(str);
    }
}
