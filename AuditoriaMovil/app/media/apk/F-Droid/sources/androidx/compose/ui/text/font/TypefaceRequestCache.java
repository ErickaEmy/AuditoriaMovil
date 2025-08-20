package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FontFamilyResolver.kt */
/* loaded from: classes.dex */
public final class TypefaceRequestCache {
    private final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();
    private final LruCache resultCache = new LruCache(16);

    public final SynchronizedObject getLock$ui_text_release() {
        return this.lock;
    }

    public final State runCached(final TypefaceRequest typefaceRequest, Function1 resolveTypeface) {
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        synchronized (this.lock) {
            TypefaceResult typefaceResult = (TypefaceResult) this.resultCache.get(typefaceRequest);
            if (typefaceResult != null) {
                if (typefaceResult.getCacheable()) {
                    return typefaceResult;
                }
                TypefaceResult typefaceResult2 = (TypefaceResult) this.resultCache.remove(typefaceRequest);
            }
            try {
                TypefaceResult typefaceResult3 = (TypefaceResult) resolveTypeface.invoke(new Function1() { // from class: androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((TypefaceResult) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(TypefaceResult finalResult) {
                        LruCache lruCache;
                        LruCache lruCache2;
                        Intrinsics.checkNotNullParameter(finalResult, "finalResult");
                        SynchronizedObject lock$ui_text_release = TypefaceRequestCache.this.getLock$ui_text_release();
                        TypefaceRequestCache typefaceRequestCache = TypefaceRequestCache.this;
                        TypefaceRequest typefaceRequest2 = typefaceRequest;
                        synchronized (lock$ui_text_release) {
                            try {
                                if (finalResult.getCacheable()) {
                                    lruCache2 = typefaceRequestCache.resultCache;
                                    lruCache2.put(typefaceRequest2, finalResult);
                                } else {
                                    lruCache = typefaceRequestCache.resultCache;
                                    lruCache.remove(typefaceRequest2);
                                }
                                Unit unit = Unit.INSTANCE;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
                synchronized (this.lock) {
                    try {
                        if (this.resultCache.get(typefaceRequest) == null && typefaceResult3.getCacheable()) {
                            this.resultCache.put(typefaceRequest, typefaceResult3);
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return typefaceResult3;
            } catch (Exception e) {
                throw new IllegalStateException("Could not load font", e);
            }
        }
    }
}
