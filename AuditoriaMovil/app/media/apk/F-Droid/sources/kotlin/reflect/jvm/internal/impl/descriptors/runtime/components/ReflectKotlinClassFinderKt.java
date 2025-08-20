package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: ReflectKotlinClassFinder.kt */
/* loaded from: classes2.dex */
public abstract class ReflectKotlinClassFinderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String toRuntimeFqName(ClassId classId) {
        String replace$default;
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        replace$default = StringsKt__StringsJVMKt.replace$default(asString, (char) CoreConstants.DOT, (char) CoreConstants.DOLLAR, false, 4, (Object) null);
        if (classId.getPackageFqName().isRoot()) {
            return replace$default;
        }
        return classId.getPackageFqName() + CoreConstants.DOT + replace$default;
    }
}
