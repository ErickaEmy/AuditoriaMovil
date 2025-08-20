package com.bumptech.glide.integration.compose;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.integration.ktx.AsyncGlideSize;
import com.bumptech.glide.integration.ktx.ImmediateGlideSize;
import com.bumptech.glide.integration.ktx.ResolvableGlideSize;
import com.bumptech.glide.integration.ktx.Size;
import com.bumptech.glide.integration.ktx.Status;
import com.bumptech.glide.request.BaseRequestOptions;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: GlideImage.kt */
/* loaded from: classes.dex */
public abstract class GlideImageKt {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(GlideImageKt.class, "displayedDrawable", "getDisplayedDrawable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/runtime/MutableState;", 1))};
    private static final SemanticsPropertyKey DisplayedDrawableKey;
    private static final SemanticsPropertyKey displayedDrawable$delegate;

    /* compiled from: GlideImage.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            iArr[Status.RUNNING.ordinal()] = 1;
            iArr[Status.CLEARED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    public static final void GlideImage(final Object obj, final String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Placeholder placeholder, Placeholder placeholder2, Function1 function1, Composer composer, final int i, final int i2) {
        Composer startRestartGroup = composer.startRestartGroup(-496196496);
        final Modifier.Companion companion = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        final Alignment center = (i2 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        final ContentScale fit = (i2 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        final float f2 = (i2 & 32) != 0 ? 1.0f : f;
        final ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        final Placeholder placeholder3 = (i2 & 128) != 0 ? null : placeholder;
        final Placeholder placeholder4 = (i2 & 256) != 0 ? null : placeholder2;
        final GlideImageKt$GlideImage$1 glideImageKt$GlideImage$1 = (i2 & 512) != 0 ? new Function1() { // from class: com.bumptech.glide.integration.compose.GlideImageKt$GlideImage$1
            @Override // kotlin.jvm.functions.Function1
            public final RequestBuilder invoke(RequestBuilder it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it;
            }
        } : function1;
        startRestartGroup.startReplaceableGroup(482162195);
        Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(context);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = Glide.with(context);
            Intrinsics.checkNotNullExpressionValue(rememberedValue, "with(it)");
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        RequestManager requestManager = rememberedValue;
        startRestartGroup.endReplaceableGroup();
        Intrinsics.checkNotNullExpressionValue(requestManager, "LocalContext.current.let…(it) { Glide.with(it) } }");
        int i3 = i >> 3;
        RequestBuilder rememberRequestBuilderWithDefaults = rememberRequestBuilderWithDefaults(obj, requestManager, glideImageKt$GlideImage$1, fit, startRestartGroup, ((i >> 21) & 896) | 72 | (i3 & 7168));
        SizeAndModifier rememberSizeAndModifier = rememberSizeAndModifier(SizesKt.overrideSize(rememberRequestBuilderWithDefaults), companion, startRestartGroup, (i3 & 112) | 8);
        ResolvableGlideSize component1 = rememberSizeAndModifier.component1();
        Modifier component2 = rememberSizeAndModifier.component2();
        startRestartGroup.startReplaceableGroup(482162831);
        ((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue();
        startRestartGroup.endReplaceableGroup();
        int i4 = i << 3;
        SizedGlideImage(rememberRequestBuilderWithDefaults, component1, component2, str, center, fit, f2, colorFilter2, null, null, startRestartGroup, ((i << 6) & 7168) | 72 | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (i4 & 29360128));
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2(obj, str, companion, center, fit, f2, colorFilter2, placeholder3, placeholder4, glideImageKt$GlideImage$1, i, i2) { // from class: com.bumptech.glide.integration.compose.GlideImageKt$GlideImage$3
            final /* synthetic */ int $$changed;
            final /* synthetic */ int $$default;
            final /* synthetic */ Alignment $alignment;
            final /* synthetic */ float $alpha;
            final /* synthetic */ ColorFilter $colorFilter;
            final /* synthetic */ String $contentDescription;
            final /* synthetic */ ContentScale $contentScale;
            final /* synthetic */ Object $model;
            final /* synthetic */ Modifier $modifier;
            final /* synthetic */ Function1 $requestBuilderTransform;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$requestBuilderTransform = glideImageKt$GlideImage$1;
                this.$$changed = i;
                this.$$default = i2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i5) {
                GlideImageKt.GlideImage(this.$model, this.$contentDescription, this.$modifier, this.$alignment, this.$contentScale, this.$alpha, this.$colorFilter, null, null, this.$requestBuilderTransform, composer2, this.$$changed | 1, this.$$default);
            }
        });
    }

    private static final SizeAndModifier rememberSizeAndModifier(Size size, Modifier modifier, Composer composer, int i) {
        SizeAndModifier sizeAndModifier;
        composer.startReplaceableGroup(-1879820411);
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(size) | composer.changed(modifier);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            if (size != null) {
                sizeAndModifier = new SizeAndModifier(new ImmediateGlideSize(size), modifier);
            } else {
                SizeObserver sizeObserver = new SizeObserver();
                sizeAndModifier = new SizeAndModifier(new AsyncGlideSize(new GlideImageKt$rememberSizeAndModifier$1$1(sizeObserver)), sizeObservingModifier(modifier, sizeObserver));
            }
            rememberedValue = sizeAndModifier;
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        SizeAndModifier sizeAndModifier2 = (SizeAndModifier) rememberedValue;
        composer.endReplaceableGroup();
        return sizeAndModifier2;
    }

    private static final RequestBuilder rememberRequestBuilderWithDefaults(Object obj, RequestManager requestManager, Function1 function1, ContentScale contentScale, Composer composer, int i) {
        composer.startReplaceableGroup(1761561633);
        Object[] objArr = {obj, requestManager, function1, contentScale};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int i2 = 0; i2 < 4; i2++) {
            z |= composer.changed(objArr[i2]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            RequestBuilder load = requestManager.load(obj);
            Intrinsics.checkNotNullExpressionValue(load, "requestManager.load(model)");
            rememberedValue = (RequestBuilder) function1.invoke(contentScaleTransform(load, contentScale));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        RequestBuilder requestBuilder = (RequestBuilder) rememberedValue;
        composer.endReplaceableGroup();
        return requestBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RequestBuilder contentScaleTransform(RequestBuilder requestBuilder, ContentScale contentScale) {
        ContentScale.Companion companion = ContentScale.Companion;
        if (Intrinsics.areEqual(contentScale, companion.getCrop())) {
            BaseRequestOptions optionalCenterCrop = requestBuilder.optionalCenterCrop();
            Intrinsics.checkNotNullExpressionValue(optionalCenterCrop, "{\n      optionalCenterCrop()\n    }");
            return (RequestBuilder) optionalCenterCrop;
        } else if (Intrinsics.areEqual(contentScale, companion.getInside()) || Intrinsics.areEqual(contentScale, companion.getFit())) {
            BaseRequestOptions optionalCenterInside = requestBuilder.optionalCenterInside();
            Intrinsics.checkNotNullExpressionValue(optionalCenterInside, "{\n      // Outside compo…ionalCenterInside()\n    }");
            return (RequestBuilder) optionalCenterInside;
        } else {
            return requestBuilder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SizedGlideImage(final RequestBuilder requestBuilder, final ResolvableGlideSize resolvableGlideSize, final Modifier modifier, final String str, final Alignment alignment, final ContentScale contentScale, final float f, final ColorFilter colorFilter, final Function2 function2, final Function2 function22, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1979801521);
        final GlidePainter rememberGlidePainter = rememberGlidePainter(requestBuilder, resolvableGlideSize, startRestartGroup, 72);
        if (function2 != null && showPlaceholder(rememberGlidePainter.getStatus$compose_release())) {
            startRestartGroup.startReplaceableGroup(-1111934943);
            SizedGlideImage$boxed(function2, modifier, i, startRestartGroup, (i >> 24) & 14);
            startRestartGroup.endReplaceableGroup();
        } else if (function22 != null && rememberGlidePainter.getStatus$compose_release() == Status.FAILED) {
            startRestartGroup.startReplaceableGroup(-1111934852);
            SizedGlideImage$boxed(function22, modifier, i, startRestartGroup, (i >> 27) & 14);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-1111934821);
            Modifier.Companion companion = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(rememberGlidePainter);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.bumptech.glide.integration.compose.GlideImageKt$SizedGlideImage$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        GlideImageKt.setDisplayedDrawable(semantics, GlidePainter.this.getCurrentDrawable$compose_release());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            int i2 = i >> 3;
            ImageKt.Image(rememberGlidePainter, str, modifier.then(SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null)), alignment, contentScale, f, colorFilter, startRestartGroup, ((i >> 6) & 112) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (i2 & 3670016), 0);
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2() { // from class: com.bumptech.glide.integration.compose.GlideImageKt$SizedGlideImage$2
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

            public final void invoke(Composer composer2, int i3) {
                GlideImageKt.SizedGlideImage(RequestBuilder.this, resolvableGlideSize, modifier, str, alignment, contentScale, f, colorFilter, function2, function22, composer2, i | 1);
            }
        });
    }

    private static final void SizedGlideImage$boxed(Function2 function2, Modifier modifier, int i, Composer composer, int i2) {
        composer.startReplaceableGroup(-944716781);
        int i3 = (i >> 6) & 14;
        composer.startReplaceableGroup(733328855);
        int i4 = i3 >> 3;
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, (i4 & 112) | (i4 & 14));
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0 constructor = companion.getConstructor();
        Function3 materializerOf = LayoutKt.materializerOf(modifier);
        int i5 = ((((i3 << 3) & 112) << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer m624constructorimpl = Updater.m624constructorimpl(composer);
        Updater.m625setimpl(m624constructorimpl, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m625setimpl(m624constructorimpl, density, companion.getSetDensity());
        Updater.m625setimpl(m624constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m625setimpl(m624constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer)), composer, Integer.valueOf((i5 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-2137368960);
        if (((i5 >> 9) & 10) != 2 || !composer.getSkipping()) {
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (((((i3 >> 6) & 112) | 6) & 81) != 16 || !composer.getSkipping()) {
                function2.invoke(composer, Integer.valueOf(i2 & 14));
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            }
        }
        composer.skipToGroupEnd();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    private static final boolean showPlaceholder(Status status) {
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        return i == 1 || i == 2;
    }

    private static final GlidePainter rememberGlidePainter(RequestBuilder requestBuilder, ResolvableGlideSize resolvableGlideSize, Composer composer, int i) {
        composer.startReplaceableGroup(-38500790);
        composer.startReplaceableGroup(773894976);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(requestBuilder) | composer.changed(resolvableGlideSize);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new GlidePainter(requestBuilder, resolvableGlideSize, coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        GlidePainter glidePainter = (GlidePainter) rememberedValue2;
        composer.endReplaceableGroup();
        return glidePainter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sizeObservingModifier(Modifier modifier, final SizeObserver sizeObserver) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: com.bumptech.glide.integration.compose.GlideImageKt$sizeObservingModifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m2028invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m1877unboximpl());
            }

            /* renamed from: invoke-3p2s80s  reason: not valid java name */
            public final MeasureResult m2028invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                Size m2029inferredGlideSizeBRTryo0 = SizesKt.m2029inferredGlideSizeBRTryo0(j);
                if (m2029inferredGlideSizeBRTryo0 != null) {
                    SizeObserver.this.setSize(m2029inferredGlideSizeBRTryo0);
                }
                final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(j);
                return MeasureScope.CC.layout$default(layout, mo1251measureBRTryo0.getWidth(), mo1251measureBRTryo0.getHeight(), null, new Function1() { // from class: com.bumptech.glide.integration.compose.GlideImageKt$sizeObservingModifier$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        Placeable.PlacementScope.place$default(layout2, Placeable.this, 0, 0, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        });
    }

    static {
        SemanticsPropertyKey semanticsPropertyKey = new SemanticsPropertyKey("DisplayedDrawable", null, 2, null);
        DisplayedDrawableKey = semanticsPropertyKey;
        displayedDrawable$delegate = semanticsPropertyKey;
    }

    public static final void setDisplayedDrawable(SemanticsPropertyReceiver semanticsPropertyReceiver, MutableState mutableState) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(mutableState, "<set-?>");
        displayedDrawable$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[0], mutableState);
    }
}
