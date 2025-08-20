package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    @NonNull
    public static IllegalStateException of(@NonNull Task<?> task) {
        String str;
        String str2;
        if (!task.isComplete()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception exception = task.getException();
        if (exception != null) {
            str = "failure";
        } else if (task.isSuccessful()) {
            str = "result ".concat(String.valueOf(task.getResult()));
        } else if (task.isCanceled()) {
            str = "cancellation";
        } else {
            str = "unknown issue";
        }
        if (str.length() != 0) {
            str2 = "Complete with: ".concat(str);
        } else {
            str2 = new String("Complete with: ");
        }
        return new DuplicateTaskCompletionException(str2, exception);
    }
}
