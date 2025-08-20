package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    public final List<JsonElement> y;

    public JsonArray() {
        this.y = new ArrayList();
    }

    public void add(Boolean bool) {
        this.y.add(bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }

    public void addAll(JsonArray jsonArray) {
        this.y.addAll(jsonArray.y);
    }

    public boolean contains(JsonElement jsonElement) {
        return this.y.contains(jsonElement);
    }

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof JsonArray) || !((JsonArray) obj).y.equals(this.y))) {
            return false;
        }
        return true;
    }

    public JsonElement get(int i) {
        return this.y.get(i);
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsBigDecimal();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsBigInteger();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsByte();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsCharacter();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsFloat();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsNumber();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsShort();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        if (this.y.size() == 1) {
            return this.y.get(0).getAsString();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.y.iterator();
    }

    public boolean remove(JsonElement jsonElement) {
        return this.y.remove(jsonElement);
    }

    public JsonElement set(int i, JsonElement jsonElement) {
        return this.y.set(i, jsonElement);
    }

    public int size() {
        return this.y.size();
    }

    public void add(Character ch) {
        this.y.add(ch == null ? JsonNull.INSTANCE : new JsonPrimitive(ch));
    }

    @Override // com.google.gson.JsonElement
    public JsonArray deepCopy() {
        if (!this.y.isEmpty()) {
            JsonArray jsonArray = new JsonArray(this.y.size());
            for (JsonElement jsonElement : this.y) {
                jsonArray.add(jsonElement.deepCopy());
            }
            return jsonArray;
        }
        return new JsonArray();
    }

    public JsonElement remove(int i) {
        return this.y.remove(i);
    }

    public JsonArray(int i) {
        this.y = new ArrayList(i);
    }

    public void add(Number number) {
        this.y.add(number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    public void add(String str) {
        this.y.add(str == null ? JsonNull.INSTANCE : new JsonPrimitive(str));
    }

    public void add(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.y.add(jsonElement);
    }
}
