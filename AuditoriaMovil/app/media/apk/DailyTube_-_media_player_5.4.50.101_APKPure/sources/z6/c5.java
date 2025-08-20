package z6;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.v;
import java.io.IOException;
import k5.fb;
/* loaded from: classes.dex */
public class c5 extends i9 {
    public static int c5(@NonNull FontStyle fontStyle, @NonNull FontStyle fontStyle2) {
        int i;
        int abs = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        if (fontStyle.getSlant() == fontStyle2.getSlant()) {
            i = 0;
        } else {
            i = 2;
        }
        return abs + i;
    }

    @Override // z6.i9
    public fb.n3 fb(fb.n3[] n3VarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // z6.i9
    @Nullable
    public Typeface gv(Context context, Resources resources, int i, String str, int i5) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // z6.i9
    @Nullable
    public Typeface n3(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull fb.n3[] n3VarArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (fb.n3 n3Var : n3VarArr) {
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(n3Var.gv(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (openFileDescriptor == null) {
                    if (openFileDescriptor == null) {
                    }
                } else {
                    try {
                        Font build = new Font.Builder(openFileDescriptor).setWeight(n3Var.v()).setSlant(n3Var.a() ? 1 : 0).setTtcIndex(n3Var.zn()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                        break;
                    }
                }
                openFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(s(build2, i).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    public final Font s(@NonNull FontFamily fontFamily, int i) {
        int i5;
        int i6;
        if ((i & 1) != 0) {
            i5 = 700;
        } else {
            i5 = 400;
        }
        if ((i & 2) != 0) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        FontStyle fontStyle = new FontStyle(i5, i6);
        Font font = fontFamily.getFont(0);
        int c52 = c5(fontStyle, font.getStyle());
        for (int i8 = 1; i8 < fontFamily.getSize(); i8++) {
            Font font2 = fontFamily.getFont(i8);
            int c53 = c5(fontStyle, font2.getStyle());
            if (c53 < c52) {
                font = font2;
                c52 = c53;
            }
        }
        return font;
    }

    @Override // z6.i9
    @Nullable
    public Typeface y(Context context, v.zn znVar, Resources resources, int i) {
        v.gv[] y;
        try {
            FontFamily.Builder builder = null;
            for (v.gv gvVar : znVar.y()) {
                try {
                    Font build = new Font.Builder(resources, gvVar.n3()).setWeight(gvVar.v()).setSlant(gvVar.a() ? 1 : 0).setTtcIndex(gvVar.zn()).setFontVariationSettings(gvVar.gv()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(s(build2, i).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }
}
