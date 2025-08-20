package com.google.accompanist.themeadapter.core;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.CutCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.TypedArrayKt;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: ResourceUtils.kt */
/* loaded from: classes.dex */
public abstract class ResourceUtilsKt {
    private static final ThreadLocal tempTypedValue = new ThreadLocal();

    /* renamed from: parseColor-mxwnekA$default  reason: not valid java name */
    public static /* synthetic */ long m2035parseColormxwnekA$default(TypedArray typedArray, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = Color.Companion.m864getUnspecified0d7_KjU();
        }
        return m2034parseColormxwnekA(typedArray, i, j);
    }

    /* renamed from: parseColor-mxwnekA  reason: not valid java name */
    public static final long m2034parseColormxwnekA(TypedArray parseColor, int i, long j) {
        Intrinsics.checkNotNullParameter(parseColor, "$this$parseColor");
        return parseColor.hasValue(i) ? ColorKt.Color(TypedArrayKt.getColorOrThrow(parseColor, i)) : j;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.text.TextStyle parseTextAppearance(android.content.Context r47, int r48, androidx.compose.ui.unit.Density r49, boolean r50, androidx.compose.ui.text.font.FontFamily r51) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.accompanist.themeadapter.core.ResourceUtilsKt.parseTextAppearance(android.content.Context, int, androidx.compose.ui.unit.Density, boolean, androidx.compose.ui.text.font.FontFamily):androidx.compose.ui.text.TextStyle");
    }

    public static final FontFamilyWithWeight parseFontFamily(TypedArray typedArray, int i) {
        boolean startsWith$default;
        boolean endsWith$default;
        FontFamilyWithWeight fontFamilyWithWeight;
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        ThreadLocal threadLocal = tempTypedValue;
        Object obj = threadLocal.get();
        if (obj == null) {
            obj = new TypedValue();
            threadLocal.set(obj);
        }
        TypedValue typedValue = (TypedValue) obj;
        if (typedArray.getValue(i, typedValue) && typedValue.type == 3) {
            CharSequence charSequence = typedValue.string;
            if (Intrinsics.areEqual(charSequence, "sans-serif")) {
                fontFamilyWithWeight = new FontFamilyWithWeight(FontFamily.Companion.getSansSerif(), null, 2, null);
            } else if (Intrinsics.areEqual(charSequence, "sans-serif-thin")) {
                return new FontFamilyWithWeight(FontFamily.Companion.getSansSerif(), FontWeight.Companion.getThin());
            } else {
                if (Intrinsics.areEqual(charSequence, "sans-serif-light")) {
                    return new FontFamilyWithWeight(FontFamily.Companion.getSansSerif(), FontWeight.Companion.getLight());
                }
                if (Intrinsics.areEqual(charSequence, "sans-serif-medium")) {
                    return new FontFamilyWithWeight(FontFamily.Companion.getSansSerif(), FontWeight.Companion.getMedium());
                }
                if (Intrinsics.areEqual(charSequence, "sans-serif-black")) {
                    return new FontFamilyWithWeight(FontFamily.Companion.getSansSerif(), FontWeight.Companion.getBlack());
                }
                if (Intrinsics.areEqual(charSequence, "serif")) {
                    fontFamilyWithWeight = new FontFamilyWithWeight(FontFamily.Companion.getSerif(), null, 2, null);
                } else if (Intrinsics.areEqual(charSequence, "cursive")) {
                    fontFamilyWithWeight = new FontFamilyWithWeight(FontFamily.Companion.getCursive(), null, 2, null);
                } else if (Intrinsics.areEqual(charSequence, "monospace")) {
                    fontFamilyWithWeight = new FontFamilyWithWeight(FontFamily.Companion.getMonospace(), null, 2, null);
                } else if (typedValue.resourceId == 0) {
                    return null;
                } else {
                    CharSequence charSequence2 = typedValue.string;
                    Intrinsics.checkNotNullExpressionValue(charSequence2, "tv.string");
                    startsWith$default = StringsKt__StringsKt.startsWith$default(charSequence2, (CharSequence) "res/", false, 2, (Object) null);
                    if (!startsWith$default) {
                        return null;
                    }
                    CharSequence charSequence3 = typedValue.string;
                    Intrinsics.checkNotNullExpressionValue(charSequence3, "tv.string");
                    endsWith$default = StringsKt__StringsKt.endsWith$default(charSequence3, (CharSequence) ".xml", false, 2, (Object) null);
                    if (endsWith$default) {
                        Resources resources = typedArray.getResources();
                        Intrinsics.checkNotNullExpressionValue(resources, "resources");
                        FontFamily parseXmlFontFamily = parseXmlFontFamily(resources, typedValue.resourceId);
                        if (parseXmlFontFamily != null) {
                            return new FontFamilyWithWeight(parseXmlFontFamily, null, 2, null);
                        }
                        return null;
                    }
                    fontFamilyWithWeight = new FontFamilyWithWeight(FontKt.toFontFamily(FontKt.m1629FontYpTlLL0$default(typedValue.resourceId, null, 0, 0, 14, null)), null, 2, null);
                }
            }
            return fontFamilyWithWeight;
        }
        return null;
    }

    public static final FontFamily parseXmlFontFamily(Resources resources, int i) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        XmlResourceParser xml = resources.getXml(i);
        Intrinsics.checkNotNullExpressionValue(xml, "getXml(id)");
        try {
            FontResourcesParserCompat.FamilyResourceEntry parse = FontResourcesParserCompat.parse(xml, resources);
            if (!(parse instanceof FontResourcesParserCompat.FontFamilyFilesResourceEntry)) {
                xml.close();
                return null;
            }
            FontResourcesParserCompat.FontFileResourceEntry[] entries = ((FontResourcesParserCompat.FontFamilyFilesResourceEntry) parse).getEntries();
            Intrinsics.checkNotNullExpressionValue(entries, "result.entries");
            ArrayList arrayList = new ArrayList(entries.length);
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : entries) {
                arrayList.add(FontKt.m1629FontYpTlLL0$default(fontFileResourceEntry.getResourceId(), fontWeightOf(fontFileResourceEntry.getWeight()), fontFileResourceEntry.isItalic() ? FontStyle.Companion.m1645getItalic_LCdwA() : FontStyle.Companion.m1646getNormal_LCdwA(), 0, 8, null));
            }
            FontFamily FontFamily = FontFamilyKt.FontFamily(arrayList);
            xml.close();
            return FontFamily;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    private static final FontWeight fontWeightOf(int i) {
        if (i < 0 || i >= 150) {
            if (150 > i || i >= 250) {
                if (250 > i || i >= 350) {
                    if (350 > i || i >= 450) {
                        if (450 > i || i >= 550) {
                            if (550 > i || i >= 650) {
                                if (650 > i || i >= 750) {
                                    if (750 > i || i >= 850) {
                                        if (850 <= i && i < 1000) {
                                            return FontWeight.Companion.getW900();
                                        }
                                        return FontWeight.Companion.getW400();
                                    }
                                    return FontWeight.Companion.getW800();
                                }
                                return FontWeight.Companion.getW700();
                            }
                            return FontWeight.Companion.getW600();
                        }
                        return FontWeight.Companion.getW500();
                    }
                    return FontWeight.Companion.getW400();
                }
                return FontWeight.Companion.getW300();
            }
            return FontWeight.Companion.getW200();
        }
        return FontWeight.Companion.getW100();
    }

    /* renamed from: parseTextUnit-lGoEivg$default  reason: not valid java name */
    public static /* synthetic */ long m2037parseTextUnitlGoEivg$default(TypedArray typedArray, int i, Density density, long j, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j = TextUnit.Companion.m1968getUnspecifiedXSAIIZE();
        }
        return m2036parseTextUnitlGoEivg(typedArray, i, density, j);
    }

    /* renamed from: parseTextUnit-lGoEivg  reason: not valid java name */
    public static final long m2036parseTextUnitlGoEivg(TypedArray parseTextUnit, int i, Density density, long j) {
        Intrinsics.checkNotNullParameter(parseTextUnit, "$this$parseTextUnit");
        Intrinsics.checkNotNullParameter(density, "density");
        ThreadLocal threadLocal = tempTypedValue;
        Object obj = threadLocal.get();
        if (obj == null) {
            obj = new TypedValue();
            threadLocal.set(obj);
        }
        TypedValue typedValue = (TypedValue) obj;
        if (parseTextUnit.getValue(i, typedValue) && typedValue.type == 5) {
            int complexUnit = typedValue.getComplexUnit();
            if (complexUnit != 1) {
                if (complexUnit == 2) {
                    return TextUnitKt.getSp(TypedValue.complexToFloat(typedValue.data));
                }
                return density.mo157toSpkPz2Gy4(parseTextUnit.getDimension(i, 0.0f));
            }
            return TextUnitKt.getEm(TypedValue.complexToFloat(typedValue.data));
        }
        return j;
    }

    public static final CornerBasedShape parseShapeAppearance(Context context, int i, LayoutDirection layoutDirection, CornerBasedShape fallbackShape) {
        CornerBasedShape roundedCornerShape;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(fallbackShape, "fallbackShape");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.ThemeAdapterShapeAppearance);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…meAdapterShapeAppearance)");
        CornerSize parseCornerSize = parseCornerSize(obtainStyledAttributes, R$styleable.ThemeAdapterShapeAppearance_cornerSize);
        CornerSize parseCornerSize2 = parseCornerSize(obtainStyledAttributes, R$styleable.ThemeAdapterShapeAppearance_cornerSizeTopLeft);
        CornerSize parseCornerSize3 = parseCornerSize(obtainStyledAttributes, R$styleable.ThemeAdapterShapeAppearance_cornerSizeTopRight);
        CornerSize parseCornerSize4 = parseCornerSize(obtainStyledAttributes, R$styleable.ThemeAdapterShapeAppearance_cornerSizeBottomLeft);
        CornerSize parseCornerSize5 = parseCornerSize(obtainStyledAttributes, R$styleable.ThemeAdapterShapeAppearance_cornerSizeBottomRight);
        boolean z = layoutDirection == LayoutDirection.Rtl;
        CornerSize cornerSize = z ? parseCornerSize3 : parseCornerSize2;
        if (!z) {
            parseCornerSize2 = parseCornerSize3;
        }
        CornerSize cornerSize2 = z ? parseCornerSize5 : parseCornerSize4;
        if (!z) {
            parseCornerSize4 = parseCornerSize5;
        }
        int i2 = obtainStyledAttributes.getInt(R$styleable.ThemeAdapterShapeAppearance_cornerFamily, 0);
        if (i2 == 0) {
            if (cornerSize == null) {
                cornerSize = parseCornerSize == null ? fallbackShape.getTopStart() : parseCornerSize;
            }
            if (parseCornerSize2 == null) {
                parseCornerSize2 = parseCornerSize == null ? fallbackShape.getTopEnd() : parseCornerSize;
            }
            if (parseCornerSize4 == null) {
                parseCornerSize4 = parseCornerSize == null ? fallbackShape.getBottomEnd() : parseCornerSize;
            }
            if (cornerSize2 != null) {
                parseCornerSize = cornerSize2;
            } else if (parseCornerSize == null) {
                parseCornerSize = fallbackShape.getBottomStart();
            }
            roundedCornerShape = new RoundedCornerShape(cornerSize, parseCornerSize2, parseCornerSize4, parseCornerSize);
        } else if (i2 == 1) {
            if (cornerSize == null) {
                cornerSize = parseCornerSize == null ? fallbackShape.getTopStart() : parseCornerSize;
            }
            if (parseCornerSize2 == null) {
                parseCornerSize2 = parseCornerSize == null ? fallbackShape.getTopEnd() : parseCornerSize;
            }
            if (parseCornerSize4 == null) {
                parseCornerSize4 = parseCornerSize == null ? fallbackShape.getBottomEnd() : parseCornerSize;
            }
            if (cornerSize2 != null) {
                parseCornerSize = cornerSize2;
            } else if (parseCornerSize == null) {
                parseCornerSize = fallbackShape.getBottomStart();
            }
            roundedCornerShape = new CutCornerShape(cornerSize, parseCornerSize2, parseCornerSize4, parseCornerSize);
        } else {
            throw new IllegalArgumentException("Unknown cornerFamily set in ShapeAppearance");
        }
        obtainStyledAttributes.recycle();
        return roundedCornerShape;
    }

    public static final CornerSize parseCornerSize(TypedArray typedArray, int i) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        ThreadLocal threadLocal = tempTypedValue;
        Object obj = threadLocal.get();
        if (obj == null) {
            obj = new TypedValue();
            threadLocal.set(obj);
        }
        TypedValue typedValue = (TypedValue) obj;
        if (typedArray.getValue(i, typedValue)) {
            int i2 = typedValue.type;
            if (i2 != 5) {
                if (i2 != 6) {
                    return null;
                }
                return CornerSizeKt.CornerSize(typedValue.getFraction(1.0f, 1.0f));
            }
            int complexUnit = typedValue.getComplexUnit();
            if (complexUnit != 0) {
                if (complexUnit == 1) {
                    return CornerSizeKt.m278CornerSize0680j_4(Dp.m1897constructorimpl(TypedValue.complexToFloat(typedValue.data)));
                }
                return CornerSizeKt.CornerSize(typedArray.getDimensionPixelSize(i, 0));
            }
            return CornerSizeKt.CornerSize(TypedValue.complexToFloat(typedValue.data));
        }
        return null;
    }
}
