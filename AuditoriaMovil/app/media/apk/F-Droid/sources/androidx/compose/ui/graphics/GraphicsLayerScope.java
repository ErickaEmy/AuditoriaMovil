package androidx.compose.ui.graphics;

import androidx.compose.ui.unit.Density;
/* compiled from: GraphicsLayerScope.kt */
/* loaded from: classes.dex */
public interface GraphicsLayerScope extends Density {
    float getCameraDistance();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    /* renamed from: getTransformOrigin-SzJe1aQ  reason: not valid java name */
    long mo890getTransformOriginSzJe1aQ();

    float getTranslationX();

    float getTranslationY();

    void setAlpha(float f);

    /* renamed from: setAmbientShadowColor-8_81llA  reason: not valid java name */
    void mo891setAmbientShadowColor8_81llA(long j);

    void setCameraDistance(float f);

    void setClip(boolean z);

    /* renamed from: setCompositingStrategy-aDBOjCE  reason: not valid java name */
    void mo892setCompositingStrategyaDBOjCE(int i);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    void setShape(Shape shape);

    /* renamed from: setSpotShadowColor-8_81llA  reason: not valid java name */
    void mo893setSpotShadowColor8_81llA(long j);

    /* renamed from: setTransformOrigin-__ExYCQ  reason: not valid java name */
    void mo894setTransformOrigin__ExYCQ(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);
}
