package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes.dex */
public final class Streams {
    public Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader jsonReader) throws JsonParseException {
        boolean z2;
        try {
            try {
                jsonReader.peek();
                z2 = false;
                try {
                    return TypeAdapters.JSON_ELEMENT.read(jsonReader);
                } catch (EOFException e2) {
                    e = e2;
                    if (z2) {
                        return JsonNull.INSTANCE;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (EOFException e3) {
                e = e3;
                z2 = true;
            }
        } catch (MalformedJsonException e5) {
            throw new JsonSyntaxException(e5);
        } catch (IOException e6) {
            throw new JsonIOException(e6);
        } catch (NumberFormatException e8) {
            throw new JsonSyntaxException(e8);
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new AppendableWriter(appendable);
    }

    /* loaded from: classes.dex */
    public static final class AppendableWriter extends Writer {

        /* renamed from: v  reason: collision with root package name */
        public final CurrentWrite f6218v = new CurrentWrite();
        public final Appendable y;

        /* loaded from: classes.dex */
        public static class CurrentWrite implements CharSequence {
            public char[] y;

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.y[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.y.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i5) {
                return new String(this.y, i, i5 - i);
            }
        }

        public AppendableWriter(Appendable appendable) {
            this.y = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i5) throws IOException {
            CurrentWrite currentWrite = this.f6218v;
            currentWrite.y = cArr;
            this.y.append(currentWrite, i, i5 + i);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.y.append((char) i);
        }
    }
}
