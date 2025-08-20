package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ShaderBrushSpan.android.kt */
/* loaded from: classes.dex */
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {
    private final float alpha;
    private Pair cachedShader;
    private final ShaderBrush shaderBrush;
    private long size;

    /* renamed from: setSize-uvyYCjk  reason: not valid java name */
    public final void m1742setSizeuvyYCjk(long j) {
        this.size = j;
    }

    public ShaderBrushSpan(ShaderBrush shaderBrush, float f) {
        Intrinsics.checkNotNullParameter(shaderBrush, "shaderBrush");
        this.shaderBrush = shaderBrush;
        this.alpha = f;
        this.size = Size.Companion.m750getUnspecifiedNHjbRc();
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Shader mo832createShaderuvyYCjk;
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        AndroidTextPaint_androidKt.setAlpha(textPaint, this.alpha);
        if (this.size == Size.Companion.m750getUnspecifiedNHjbRc()) {
            return;
        }
        Pair pair = this.cachedShader;
        if (pair == null || !Size.m742equalsimpl0(((Size) pair.getFirst()).m749unboximpl(), this.size)) {
            mo832createShaderuvyYCjk = this.shaderBrush.mo832createShaderuvyYCjk(this.size);
        } else {
            mo832createShaderuvyYCjk = (Shader) pair.getSecond();
        }
        textPaint.setShader(mo832createShaderuvyYCjk);
        this.cachedShader = TuplesKt.to(Size.m739boximpl(this.size), mo832createShaderuvyYCjk);
    }
}
