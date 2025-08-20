package androidx.compose.ui.graphics;

import android.graphics.Shader;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Brush.kt */
/* loaded from: classes.dex */
public abstract class BrushKt {
    public static final ShaderBrush ShaderBrush(final Shader shader) {
        Intrinsics.checkNotNullParameter(shader, "shader");
        return new ShaderBrush() { // from class: androidx.compose.ui.graphics.BrushKt$ShaderBrush$1
            @Override // androidx.compose.ui.graphics.ShaderBrush
            /* renamed from: createShader-uvyYCjk  reason: not valid java name */
            public Shader mo832createShaderuvyYCjk(long j) {
                return shader;
            }
        };
    }
}
