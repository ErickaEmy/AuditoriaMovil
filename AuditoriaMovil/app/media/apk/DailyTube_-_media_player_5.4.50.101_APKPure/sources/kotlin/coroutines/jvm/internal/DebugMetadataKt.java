package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class DebugMetadataKt {
    private static final void checkDebugMetadataVersion(int i, int i5) {
        if (i5 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i5 + ". Please update the Kotlin standard library.").toString());
    }

    private static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int getLabel(BaseContinuationImpl baseContinuationImpl) {
        Integer num;
        int i;
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            return i - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl baseContinuationImpl) {
        int i;
        String str;
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation == null) {
            return null;
        }
        checkDebugMetadataVersion(1, debugMetadataAnnotation.v());
        int label = getLabel(baseContinuationImpl);
        if (label < 0) {
            i = -1;
        } else {
            i = debugMetadataAnnotation.l()[label];
        }
        String moduleName = ModuleNameRetriever.INSTANCE.getModuleName(baseContinuationImpl);
        if (moduleName == null) {
            str = debugMetadataAnnotation.c();
        } else {
            str = moduleName + '/' + debugMetadataAnnotation.c();
        }
        return new StackTraceElement(str, debugMetadataAnnotation.m(), debugMetadataAnnotation.f(), i);
    }
}
