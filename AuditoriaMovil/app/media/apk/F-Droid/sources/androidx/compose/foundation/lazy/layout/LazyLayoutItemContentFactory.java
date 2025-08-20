package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LazyLayoutItemContentFactory.kt */
/* loaded from: classes.dex */
public final class LazyLayoutItemContentFactory {
    private final Function0 itemProvider;
    private final Map lambdasCache;
    private final SaveableStateHolder saveableStateHolder;

    public final Function0 getItemProvider() {
        return this.itemProvider;
    }

    public LazyLayoutItemContentFactory(SaveableStateHolder saveableStateHolder, Function0 itemProvider) {
        Intrinsics.checkNotNullParameter(saveableStateHolder, "saveableStateHolder");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        this.saveableStateHolder = saveableStateHolder;
        this.itemProvider = itemProvider;
        this.lambdasCache = new LinkedHashMap();
    }

    public final Object getContentType(Object obj) {
        if (obj == null) {
            return null;
        }
        CachedItemContent cachedItemContent = (CachedItemContent) this.lambdasCache.get(obj);
        if (cachedItemContent != null) {
            return cachedItemContent.getContentType();
        }
        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.itemProvider.invoke();
        int index = lazyLayoutItemProvider.getIndex(obj);
        if (index != -1) {
            return lazyLayoutItemProvider.getContentType(index);
        }
        return null;
    }

    public final Function2 getContent(int i, Object key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        CachedItemContent cachedItemContent = (CachedItemContent) this.lambdasCache.get(key);
        if (cachedItemContent != null && cachedItemContent.getIndex() == i && Intrinsics.areEqual(cachedItemContent.getContentType(), obj)) {
            return cachedItemContent.getContent();
        }
        CachedItemContent cachedItemContent2 = new CachedItemContent(this, i, key, obj);
        this.lambdasCache.put(key, cachedItemContent2);
        return cachedItemContent2.getContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyLayoutItemContentFactory.kt */
    /* loaded from: classes.dex */
    public final class CachedItemContent {
        private Function2 _content;
        private final Object contentType;
        private int index;
        private final Object key;
        final /* synthetic */ LazyLayoutItemContentFactory this$0;

        public final Object getContentType() {
            return this.contentType;
        }

        public final int getIndex() {
            return this.index;
        }

        public final Object getKey() {
            return this.key;
        }

        public CachedItemContent(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, int i, Object key, Object obj) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.this$0 = lazyLayoutItemContentFactory;
            this.key = key;
            this.contentType = obj;
            this.index = i;
        }

        public final Function2 getContent() {
            Function2 function2 = this._content;
            if (function2 == null) {
                Function2 createContentLambda = createContentLambda();
                this._content = createContentLambda;
                return createContentLambda;
            }
            return function2;
        }

        private final Function2 createContentLambda() {
            final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = this.this$0;
            return ComposableLambdaKt.composableLambdaInstance(1403994769, true, new Function2() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    SaveableStateHolder saveableStateHolder;
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1403994769, i, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:90)");
                        }
                        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) LazyLayoutItemContentFactory.this.getItemProvider().invoke();
                        int index = this.getIndex();
                        if ((index >= lazyLayoutItemProvider.getItemCount() || !Intrinsics.areEqual(lazyLayoutItemProvider.getKey(index), this.getKey())) && (index = lazyLayoutItemProvider.getIndex(this.getKey())) != -1) {
                            this.index = index;
                        }
                        int i2 = index;
                        boolean z = i2 != -1;
                        LazyLayoutItemContentFactory lazyLayoutItemContentFactory2 = LazyLayoutItemContentFactory.this;
                        LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = this;
                        composer.startReusableGroup(207, Boolean.valueOf(z));
                        boolean changed = composer.changed(z);
                        if (z) {
                            saveableStateHolder = lazyLayoutItemContentFactory2.saveableStateHolder;
                            LazyLayoutItemContentFactoryKt.m266access$SkippableItemJVlU9Rs(lazyLayoutItemProvider, StableValue.m272constructorimpl(saveableStateHolder), i2, StableValue.m272constructorimpl(cachedItemContent.getKey()), composer, 0);
                        } else {
                            composer.deactivateToEndGroup(changed);
                        }
                        composer.endReusableGroup();
                        Object key = this.getKey();
                        final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent2 = this;
                        EffectsKt.DisposableEffect(key, new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent3 = LazyLayoutItemContentFactory.CachedItemContent.this;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        LazyLayoutItemContentFactory.CachedItemContent.this._content = null;
                                    }
                                };
                            }
                        }, composer, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
        }
    }
}
