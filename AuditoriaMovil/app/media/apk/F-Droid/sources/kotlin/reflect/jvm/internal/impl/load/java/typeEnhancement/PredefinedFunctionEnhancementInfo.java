package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: predefinedEnhancementInfo.kt */
/* loaded from: classes2.dex */
public final class PredefinedFunctionEnhancementInfo {
    private final List parametersInfo;
    private final TypeEnhancementInfo returnTypeInfo;

    public final List getParametersInfo() {
        return this.parametersInfo;
    }

    public final TypeEnhancementInfo getReturnTypeInfo() {
        return this.returnTypeInfo;
    }

    public PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List parametersInfo) {
        Intrinsics.checkNotNullParameter(parametersInfo, "parametersInfo");
        this.returnTypeInfo = typeEnhancementInfo;
        this.parametersInfo = parametersInfo;
    }
}
