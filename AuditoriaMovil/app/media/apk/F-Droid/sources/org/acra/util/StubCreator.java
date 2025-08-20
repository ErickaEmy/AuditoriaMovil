package org.acra.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.ErrorReporter;
import org.acra.log.ACRALog;
/* compiled from: StubCreator.kt */
/* loaded from: classes2.dex */
public final class StubCreator {
    public static final StubCreator INSTANCE = new StubCreator();

    private StubCreator() {
    }

    public final ErrorReporter createErrorReporterStub() {
        return (ErrorReporter) createStub(ErrorReporter.class, new InvocationHandler() { // from class: org.acra.util.StubCreator$$ExternalSyntheticLambda0
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object createErrorReporterStub$lambda$1;
                createErrorReporterStub$lambda$1 = StubCreator.createErrorReporterStub$lambda$1(obj, method, objArr);
                return createErrorReporterStub$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createErrorReporterStub$lambda$1(Object obj, Method method, Object[] objArr) {
        String str = ACRA.isACRASenderServiceProcess() ? "in SenderService process" : "before ACRA#init (if you did call #init, check if your configuration is valid)";
        ACRALog aCRALog = ACRA.log;
        String str2 = ACRA.LOG_TAG;
        String name = method.getName();
        aCRALog.w(str2, "ErrorReporter#" + name + " called " + str + ". THIS CALL WILL BE IGNORED!");
        return null;
    }

    public static final Object createStub(Class interfaceClass, InvocationHandler handler) {
        Intrinsics.checkNotNullParameter(interfaceClass, "interfaceClass");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return Proxy.newProxyInstance(StubCreator.class.getClassLoader(), new Class[]{interfaceClass}, handler);
    }
}
