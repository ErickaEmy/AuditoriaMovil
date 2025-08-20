package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* compiled from: javaElements.kt */
/* loaded from: classes2.dex */
public interface JavaPackage extends JavaAnnotationOwner, JavaElement {
    Collection getClasses(Function1 function1);

    FqName getFqName();

    Collection getSubPackages();
}
