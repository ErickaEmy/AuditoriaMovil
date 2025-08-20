package kotlin.reflect.jvm.internal.impl.descriptors;

import ch.qos.logback.core.CoreConstants;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
/* compiled from: InlineClassRepresentation.kt */
/* loaded from: classes2.dex */
public final class InlineClassRepresentation extends ValueClassRepresentation {
    private final Name underlyingPropertyName;
    private final SimpleTypeMarker underlyingType;

    public final Name getUnderlyingPropertyName() {
        return this.underlyingPropertyName;
    }

    public final SimpleTypeMarker getUnderlyingType() {
        return this.underlyingType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineClassRepresentation(Name underlyingPropertyName, SimpleTypeMarker underlyingType) {
        super(null);
        Intrinsics.checkNotNullParameter(underlyingPropertyName, "underlyingPropertyName");
        Intrinsics.checkNotNullParameter(underlyingType, "underlyingType");
        this.underlyingPropertyName = underlyingPropertyName;
        this.underlyingType = underlyingType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public List getUnderlyingPropertyNamesToTypes() {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(TuplesKt.to(this.underlyingPropertyName, this.underlyingType));
        return listOf;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public boolean containsPropertyWithName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return Intrinsics.areEqual(this.underlyingPropertyName, name);
    }

    public String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.underlyingPropertyName + ", underlyingType=" + this.underlyingType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
