package org.fdroid.repo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RepoAdder.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lorg/fdroid/repo/AddRepoError;", "Lorg/fdroid/repo/AddRepoState;", "errorType", "Lorg/fdroid/repo/AddRepoError$ErrorType;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Lorg/fdroid/repo/AddRepoError$ErrorType;Ljava/lang/Exception;)V", "getErrorType", "()Lorg/fdroid/repo/AddRepoError$ErrorType;", "getException", "()Ljava/lang/Exception;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ErrorType", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddRepoError extends AddRepoState {
    private final ErrorType errorType;
    private final Exception exception;

    public static /* synthetic */ AddRepoError copy$default(AddRepoError addRepoError, ErrorType errorType, Exception exc, int i, Object obj) {
        if ((i & 1) != 0) {
            errorType = addRepoError.errorType;
        }
        if ((i & 2) != 0) {
            exc = addRepoError.exception;
        }
        return addRepoError.copy(errorType, exc);
    }

    public final ErrorType component1() {
        return this.errorType;
    }

    public final Exception component2() {
        return this.exception;
    }

    public final AddRepoError copy(ErrorType errorType, Exception exc) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        return new AddRepoError(errorType, exc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AddRepoError) {
            AddRepoError addRepoError = (AddRepoError) obj;
            return this.errorType == addRepoError.errorType && Intrinsics.areEqual(this.exception, addRepoError.exception);
        }
        return false;
    }

    public final ErrorType getErrorType() {
        return this.errorType;
    }

    public final Exception getException() {
        return this.exception;
    }

    public int hashCode() {
        int hashCode = this.errorType.hashCode() * 31;
        Exception exc = this.exception;
        return hashCode + (exc == null ? 0 : exc.hashCode());
    }

    public String toString() {
        ErrorType errorType = this.errorType;
        Exception exc = this.exception;
        return "AddRepoError(errorType=" + errorType + ", exception=" + exc + ")";
    }

    public /* synthetic */ AddRepoError(ErrorType errorType, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(errorType, (i & 2) != 0 ? null : exc);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: RepoAdder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lorg/fdroid/repo/AddRepoError$ErrorType;", "", "(Ljava/lang/String;I)V", "UNKNOWN_SOURCES_DISALLOWED", "INVALID_FINGERPRINT", "IS_ARCHIVE_REPO", "INVALID_INDEX", "IO_ERROR", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ErrorType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ErrorType[] $VALUES;
        public static final ErrorType UNKNOWN_SOURCES_DISALLOWED = new ErrorType("UNKNOWN_SOURCES_DISALLOWED", 0);
        public static final ErrorType INVALID_FINGERPRINT = new ErrorType("INVALID_FINGERPRINT", 1);
        public static final ErrorType IS_ARCHIVE_REPO = new ErrorType("IS_ARCHIVE_REPO", 2);
        public static final ErrorType INVALID_INDEX = new ErrorType("INVALID_INDEX", 3);
        public static final ErrorType IO_ERROR = new ErrorType("IO_ERROR", 4);

        private static final /* synthetic */ ErrorType[] $values() {
            return new ErrorType[]{UNKNOWN_SOURCES_DISALLOWED, INVALID_FINGERPRINT, IS_ARCHIVE_REPO, INVALID_INDEX, IO_ERROR};
        }

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        public static ErrorType valueOf(String str) {
            return (ErrorType) Enum.valueOf(ErrorType.class, str);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }

        private ErrorType(String str, int i) {
        }

        static {
            ErrorType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddRepoError(ErrorType errorType, Exception exc) {
        super(null);
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        this.errorType = errorType;
        this.exception = exc;
    }
}
