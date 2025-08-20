package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
/* compiled from: JavaModuleAnnotationsProvider.kt */
/* loaded from: classes2.dex */
public interface JavaModuleAnnotationsProvider {
    List getAnnotationsForModuleOwnerOfClass(ClassId classId);
}
