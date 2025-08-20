package kotlin.reflect;
/* loaded from: classes.dex */
public interface KClass<T> extends KDeclarationContainer {
    String getSimpleName();

    int hashCode();

    boolean isInstance(Object obj);
}
