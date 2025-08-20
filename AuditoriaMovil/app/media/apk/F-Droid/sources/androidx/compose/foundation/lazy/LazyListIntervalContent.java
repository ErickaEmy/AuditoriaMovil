package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LazyListIntervalContent.kt */
/* loaded from: classes.dex */
public final class LazyListIntervalContent extends LazyLayoutIntervalContent implements LazyListScope {
    private List _headerIndexes;
    private final MutableIntervalList intervals;

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public MutableIntervalList getIntervals() {
        return this.intervals;
    }

    public LazyListIntervalContent(Function1 content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.intervals = new MutableIntervalList();
        content.invoke(this);
    }

    public final List getHeaderIndexes() {
        List emptyList;
        List list = this._headerIndexes;
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public void items(int i, Function1 function1, Function1 contentType, Function4 itemContent) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        getIntervals().addInterval(i, new LazyListInterval(function1, contentType, itemContent));
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public void item(final Object obj, final Object obj2, final Function3 content) {
        Intrinsics.checkNotNullParameter(content, "content");
        getIntervals().addInterval(1, new LazyListInterval(obj != null ? new Function1() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Object invoke(int i) {
                return obj;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                return invoke(((Number) obj3).intValue());
            }
        } : null, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Object invoke(int i) {
                return obj2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                return invoke(((Number) obj3).intValue());
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1010194746, true, new Function4() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4, Object obj5, Object obj6) {
                invoke((LazyItemScope) obj3, ((Number) obj4).intValue(), (Composer) obj5, ((Number) obj6).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $receiver, int i, Composer composer, int i2) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                if ((i2 & 14) == 0) {
                    i2 |= composer.changed($receiver) ? 4 : 2;
                }
                if ((i2 & 651) == 130 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1010194746, i2, -1, "androidx.compose.foundation.lazy.LazyListIntervalContent.item.<anonymous> (LazyListIntervalContent.kt:58)");
                }
                Function3.this.invoke($receiver, composer, Integer.valueOf(i2 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        })));
    }
}
