package kotlin.reflect;
/* compiled from: KProperty.kt */
/* loaded from: classes.dex */
public interface KProperty extends KCallable {

    /* compiled from: KProperty.kt */
    /* loaded from: classes.dex */
    public interface Accessor {
        KProperty getProperty();
    }

    /* compiled from: KProperty.kt */
    /* loaded from: classes.dex */
    public interface Getter extends Accessor, KFunction {
    }

    Getter getGetter();
}
