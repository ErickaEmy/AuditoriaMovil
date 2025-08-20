package androidx.compose.ui.text.font;

import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.caches.SimpleArrayMap;
import androidx.compose.ui.text.font.AsyncTypefaceCache;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* loaded from: classes.dex */
public abstract class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair firstImmediatelyAvailable(List list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1 function1) {
        SynchronizedObject synchronizedObject;
        LruCache lruCache;
        Object loadBlocking;
        SimpleArrayMap simpleArrayMap;
        SynchronizedObject synchronizedObject2;
        LruCache lruCache2;
        Object m2081constructorimpl;
        SimpleArrayMap simpleArrayMap2;
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            Font font = (Font) list.get(i);
            int mo1624getLoadingStrategyPKNRLFQ = font.mo1624getLoadingStrategyPKNRLFQ();
            FontLoadingStrategy.Companion companion = FontLoadingStrategy.Companion;
            if (FontLoadingStrategy.m1631equalsimpl0(mo1624getLoadingStrategyPKNRLFQ, companion.m1635getBlockingPKNRLFQ())) {
                synchronizedObject = asyncTypefaceCache.cacheLock;
                synchronized (synchronizedObject) {
                    try {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        lruCache = asyncTypefaceCache.resultCache;
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) lruCache.get(key);
                        if (asyncTypefaceResult == null) {
                            simpleArrayMap = asyncTypefaceCache.permanentCache;
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) simpleArrayMap.get(key);
                        }
                        if (asyncTypefaceResult != null) {
                            loadBlocking = asyncTypefaceResult.m1623unboximpl();
                        } else {
                            Unit unit = Unit.INSTANCE;
                            try {
                                loadBlocking = platformFontLoader.loadBlocking(font);
                                AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, loadBlocking, false, 8, null);
                            } catch (Exception e) {
                                throw new IllegalStateException("Unable to load font " + font, e);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (loadBlocking != null) {
                    return TuplesKt.to(list2, FontSynthesis_androidKt.m1660synthesizeTypefaceFxwP2eA(typefaceRequest.m1671getFontSynthesisGVVA2EU(), loadBlocking, font, typefaceRequest.getFontWeight(), typefaceRequest.m1670getFontStyle_LCdwA()));
                }
                throw new IllegalStateException("Unable to load font " + font);
            }
            if (FontLoadingStrategy.m1631equalsimpl0(mo1624getLoadingStrategyPKNRLFQ, companion.m1636getOptionalLocalPKNRLFQ())) {
                synchronizedObject2 = asyncTypefaceCache.cacheLock;
                synchronized (synchronizedObject2) {
                    try {
                        AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        lruCache2 = asyncTypefaceCache.resultCache;
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) lruCache2.get(key2);
                        if (asyncTypefaceResult2 == null) {
                            simpleArrayMap2 = asyncTypefaceCache.permanentCache;
                            asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) simpleArrayMap2.get(key2);
                        }
                        if (asyncTypefaceResult2 != null) {
                            m2081constructorimpl = asyncTypefaceResult2.m1623unboximpl();
                        } else {
                            Unit unit2 = Unit.INSTANCE;
                            try {
                                Result.Companion companion2 = Result.Companion;
                                m2081constructorimpl = Result.m2081constructorimpl(platformFontLoader.loadBlocking(font));
                            } catch (Throwable th2) {
                                Result.Companion companion3 = Result.Companion;
                                m2081constructorimpl = Result.m2081constructorimpl(ResultKt.createFailure(th2));
                            }
                            if (Result.m2086isFailureimpl(m2081constructorimpl)) {
                                m2081constructorimpl = null;
                            }
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, m2081constructorimpl, false, 8, null);
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (m2081constructorimpl != null) {
                    return TuplesKt.to(list2, FontSynthesis_androidKt.m1660synthesizeTypefaceFxwP2eA(typefaceRequest.m1671getFontSynthesisGVVA2EU(), m2081constructorimpl, font, typefaceRequest.getFontWeight(), typefaceRequest.m1670getFontStyle_LCdwA()));
                }
            } else if (!FontLoadingStrategy.m1631equalsimpl0(mo1624getLoadingStrategyPKNRLFQ, companion.m1634getAsyncPKNRLFQ())) {
                throw new IllegalStateException("Unknown font type " + font);
            } else {
                AsyncTypefaceCache.AsyncTypefaceResult m1616get1ASDuI8 = asyncTypefaceCache.m1616get1ASDuI8(font, platformFontLoader);
                if (m1616get1ASDuI8 == null) {
                    if (list2 == null) {
                        list2 = CollectionsKt__CollectionsKt.mutableListOf(font);
                    } else {
                        list2.add(font);
                    }
                } else if (!AsyncTypefaceCache.AsyncTypefaceResult.m1621isPermanentFailureimpl(m1616get1ASDuI8.m1623unboximpl()) && m1616get1ASDuI8.m1623unboximpl() != null) {
                    return TuplesKt.to(list2, FontSynthesis_androidKt.m1660synthesizeTypefaceFxwP2eA(typefaceRequest.m1671getFontSynthesisGVVA2EU(), m1616get1ASDuI8.m1623unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m1670getFontStyle_LCdwA()));
                }
            }
        }
        return TuplesKt.to(list2, function1.invoke(typefaceRequest));
    }
}
