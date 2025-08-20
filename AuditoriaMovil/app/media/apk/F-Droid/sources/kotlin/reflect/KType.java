package kotlin.reflect;

import java.util.List;
/* compiled from: KType.kt */
/* loaded from: classes.dex */
public interface KType extends KAnnotatedElement {
    List getArguments();

    KClassifier getClassifier();

    boolean isMarkedNullable();
}
