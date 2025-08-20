package io.ktor.http;

import io.ktor.util.StringValuesBuilderImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Headers.kt */
/* loaded from: classes.dex */
public final class HeadersBuilder extends StringValuesBuilderImpl {
    public HeadersBuilder(int i) {
        super(true, i);
    }

    public /* synthetic */ HeadersBuilder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 8 : i);
    }

    public Headers build() {
        return new HeadersImpl(getValues());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.util.StringValuesBuilderImpl
    public void validateName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        super.validateName(name);
        HttpHeaders.INSTANCE.checkHeaderName(name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.util.StringValuesBuilderImpl
    public void validateValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        super.validateValue(value);
        HttpHeaders.INSTANCE.checkHeaderValue(value);
    }
}
