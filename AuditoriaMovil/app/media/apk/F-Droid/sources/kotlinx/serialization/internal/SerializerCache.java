package kotlinx.serialization.internal;

import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
/* compiled from: Platform.common.kt */
/* loaded from: classes2.dex */
public interface SerializerCache {
    KSerializer get(KClass kClass);
}
