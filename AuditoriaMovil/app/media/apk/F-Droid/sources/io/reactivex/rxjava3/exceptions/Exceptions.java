package io.reactivex.rxjava3.exceptions;

import io.reactivex.rxjava3.internal.util.ExceptionHelper;
/* loaded from: classes.dex */
public abstract class Exceptions {
    public static RuntimeException propagate(Throwable th) {
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public static void throwIfFatal(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
