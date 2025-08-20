package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Ih  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0705Ih {
    public static C0705Ih A01;
    public static byte[] A02;
    public static String[] A03 = {"lby1W0wNbQrJZLPqMH4DTOw3yxUdqdf", "kgmV30Pytio8Y45c0SmevPSfJ", "GuqAlZnTPhAyqf6xpABukX78gW1eK", "0NViSQPmvGXLcgxETt4LuQqf8msO5qX", "Lug9XUXTwCkms8e17b8k", "9KOEFfUvG6glq1MfonBkT6Lvp1EWxJyS", "tUrZTe4M4NOwFWRIXhIm4QJOvCAxV", "2InOXM9Ds0dFubkAVSo31GYyY3vE8A8q"};
    public static final String[] A04;
    public static final String[] A05;
    public final SharedPreferences A00;

    public static String A0S(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[5].charAt(10) != 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "rwxiKY1yX8M1uCycGOqUPfCL86zZ3gS";
            strArr[0] = "P38LhqS18Cw18aUWRDVsuYtPAT7MPJu";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 46);
            i8++;
        }
    }

    public static void A0Z() {
        A02 = new byte[]{108, 81, 70, 78, 95, 39, 58, 39, 58, 87, 74, 93, 85, 68, 60, 32, 60, 32, 33, 33, 33, 76, 27, 12, 4, 21, 29, 104, 110, 60, 62, 62, 52, 57, 56, 51, 41, 60, 49, 2, 62, 49, 52, 62, 54, 46, 2, 62, 50, 51, 59, 52, 58, 23, 18, 24, 1, 41, 23, 21, 21, 19, 6, 2, 23, 20, 26, 19, 41, 5, 2, 23, 21, 29, 2, 4, 23, 21, 19, 41, 21, 25, 24, 2, 19, 14, 2, 41, 16, 31, 26, 2, 19, 4, 41, 5, 31, 12, 19, 65, 68, 78, 87, Byte.MAX_VALUE, 65, 67, 67, 69, 80, 84, 65, 66, 76, 69, Byte.MAX_VALUE, 83, 84, 65, 67, 75, 84, 82, 65, 67, 69, Byte.MAX_VALUE, 76, 69, 78, 71, 84, 72, 54, 51, 57, 32, 8, 54, 51, 8, 51, 50, 35, 54, 62, 59, 36, 8, 52, 59, 62, 52, 60, 54, 53, 59, 50, 121, 124, 118, 111, 71, 121, 124, 71, 124, 125, 108, 121, 113, 116, 107, 71, 113, 118, 71, 123, 112, 121, 113, 118, 125, 124, 71, 113, 117, 121, Byte.MAX_VALUE, 125, 71, 121, 124, 71, 126, 119, 119, 108, 125, 106, 71, 123, 116, 113, 123, 115, 121, 122, 116, 125, 34, 39, 45, 52, 28, 34, 47, 52, 34, 58, 48, 28, 32, 34, 47, 47, 28, 34, 32, 55, 42, 53, 42, 55, 58, 28, 44, 45, 28, 39, 38, 48, 55, 49, 44, 58, 25, 28, 22, 15, 39, 25, 22, 28, 10, 23, 17, 28, 39, 25, 20, 20, 23, 15, 39, 20, 23, 25, 28, 39, 28, 13, 10, 17, 22, 31, 39, 11, 16, 23, 15, 17, 22, 31, 3, 6, 12, 21, 61, 3, 12, 6, 16, 13, 11, 6, 61, 3, 12, 16, 61, 6, 7, 22, 7, 1, 22, 13, 16, 61, 7, 12, 3, 0, 14, 7, 68, 65, 75, 82, 122, 68, 75, 65, 87, 74, 76, 65, 122, 68, 75, 87, 122, 65, 64, 81, 64, 70, 81, 74, 87, 122, 81, 76, 72, 64, 74, 80, 81, 122, 72, 86, 30, 27, 17, 8, 32, 30, 17, 27, 13, 16, 22, 27, 32, 29, 30, 17, 17, 26, 13, 32, 26, 7, 11, 13, 30, 32, 23, 22, 17, 11, 12, 32, 25, 22, 7, 32, 26, 17, 30, 29, 19, 26, 27, 100, 97, 107, 114, 90, 100, 107, 97, 119, 106, 108, 97, 90, 103, 105, 100, 102, 110, 105, 108, 118, 113, 96, 97, 90, 108, 107, 113, 96, 107, 113, 90, 112, 119, 105, 90, 117, 119, 96, 99, 108, 125, 96, 118, 23, 18, 24, 1, 41, 23, 24, 18, 4, 25, 31, 18, 41, 20, 26, 25, 21, 29, 41, 3, 24, 5, 23, 16, 19, 41, 6, 26, 23, 15, 23, 20, 26, 19, 41, 17, 23, 27, 19, 5, 41, 21, 23, 21, 30, 19, 63, 58, 48, 41, 1, 63, 48, 58, 44, 49, 55, 58, 1, 60, 39, 46, 63, 45, 45, 1, 46, 63, 61, 53, 63, 57, 59, 1, 58, 59, 42, 59, 61, 42, 55, 49, 48, 1, 56, 49, 44, 1, 58, 59, 59, 46, 50, 55, 48, 53, 45, 121, 124, 118, 111, 71, 121, 118, 124, 106, 119, 113, 124, 71, 123, 121, 123, 112, 125, 71, 117, 119, 124, 109, 116, 125, 71, 117, 121, 96, 71, 107, 113, 98, 125, 31, 26, 16, 9, 33, 31, 16, 26, 12, 17, 23, 26, 33, 29, 31, 29, 22, 27, 33, 19, 17, 26, 11, 18, 27, 33, 12, 27, 10, 12, 7, 33, 18, 23, 19, 23, 10, 46, 43, 33, 56, 16, 46, 33, 43, 61, 32, 38, 43, 16, 44, 32, 34, 63, 61, 42, 60, 60, 16, 38, 34, 46, 40, 42, 60, 16, 43, 58, 61, 38, 33, 40, 16, 43, 32, 56, 33, 35, 32, 46, 43, 62, 59, 49, 40, 0, 62, 49, 59, 45, 48, 54, 59, 0, 59, 58, 57, 62, 42, 51, 43, 0, 62, 44, 44, 58, 43, 0, 47, 45, 58, 51, 48, 62, 59, 0, 44, 54, 37, 58, 0, 61, 38, 43, 58, 44, 112, 117, Byte.MAX_VALUE, 102, 78, 112, Byte.MAX_VALUE, 117, 99, 126, 120, 117, 78, 117, 120, 98, 112, 115, 125, 116, 78, 97, 125, 112, 104, 112, 115, 125, 116, 78, 97, 99, 116, 114, 112, 114, 121, 116, 33, 36, 46, 55, 31, 33, 46, 36, 50, 47, 41, 36, 31, 36, 47, 31, 46, 47, 52, 31, 53, 51, 37, 31, 51, 52, 33, 52, 37, 31, 40, 33, 46, 36, 44, 37, 50, 5, 0, 10, 19, 59, 5, 10, 0, 22, 11, 13, 0, 59, 1, 10, 5, 6, 8, 1, 59, 10, 5, 16, 13, 18, 1, 59, 2, 17, 10, 10, 1, 8, 115, 118, 124, 101, 77, 115, 124, 118, 96, 125, 123, 118, 77, 119, 106, 125, 77, 98, 126, 115, 107, 119, 96, 77, 113, 115, 113, 122, 119, 77, Byte.MAX_VALUE, 115, 106, 77, 97, 123, 104, 119, 28, 25, 19, 10, 34, 28, 19, 25, 15, 18, 20, 25, 34, 27, 28, 20, 17, 34, 28, 25, 34, 17, 18, 28, 25, 34, 18, 19, 34, 25, 20, 14, 22, 34, 24, 15, 15, 18, 15, 14, 69, 64, 74, 83, 123, 69, 74, 64, 86, 75, 77, 64, 123, 66, 69, 77, 72, 123, 75, 74, 123, 83, 65, 70, 82, 77, 65, 83, 123, 65, 86, 86, 75, 86, 87, 97, 100, 110, 119, 95, 97, 110, 100, 114, 111, 105, 100, 95, 102, 111, 114, 99, 101, 95, 104, 97, 114, 100, 119, 97, 114, 101, 95, 97, 99, 99, 101, 108, 101, 114, 97, 116, 105, 111, 110, 71, 66, 72, 81, 121, 71, 72, 66, 84, 73, 79, 66, 121, 78, 79, 66, 67, 121, 80, 79, 66, 67, 73, 86, 84, 73, 65, 84, 67, 85, 85, 121, 71, 72, 79, 75, 71, 82, 79, 73, 72, 126, 123, 113, 
        104, 64, 126, 113, 123, 109, 112, 118, 123, 64, 118, 114, 126, 120, 122, 64, 124, 126, 124, 119, 122, 64, 108, 107, 112, 109, 122, 64, 125, 102, 107, 122, 64, 124, 112, 106, 113, 107, 125, 120, 114, 107, 67, 125, 114, 120, 110, 115, 117, 120, 67, 117, 114, 104, 121, 114, 104, 67, 114, 115, 67, 114, 121, 107, 67, 104, 125, 111, 119, 55, 50, 56, 33, 9, 55, 56, 50, 36, 57, 63, 50, 9, 59, 51, 59, 57, 36, 47, 9, 57, 38, 34, 80, 85, 95, 70, 110, 80, 95, 85, 67, 94, 88, 85, 110, 92, 67, 82, 110, 88, 92, 65, 67, 84, 66, 66, 88, 94, 95, 110, 87, 94, 67, 110, 95, 80, 69, 88, 71, 84, 110, 71, 88, 85, 84, 94, 110, 80, 85, 66, 110, 71, 3, 12, 9, 3, 26, 50, 12, 3, 9, 31, 2, 4, 9, 50, 3, 12, 25, 4, 27, 8, 50, 14, 12, 31, 2, 24, 30, 8, 1, 50, 8, 21, 25, 8, 3, 30, 4, 2, 3, 50, 27, 12, 31, 4, 12, 3, 25, 120, 125, 119, 110, 70, 120, 119, 125, 107, 118, 112, 125, 70, 119, 120, 109, 112, 111, 124, 70, 119, 124, 110, 70, 122, 120, 107, 118, 108, 106, 124, 117, 70, 125, 124, 106, 112, 126, 119, 106, 111, 101, 124, 84, 106, 101, 111, 121, 100, 98, 111, 84, 101, 110, Byte.MAX_VALUE, 124, 100, 121, 96, 84, 111, 110, 109, 106, 126, 103, Byte.MAX_VALUE, 84, 104, 100, 101, 101, 110, 104, Byte.MAX_VALUE, 98, 100, 101, 84, Byte.MAX_VALUE, 98, 102, 110, 100, 126, Byte.MAX_VALUE, 84, 102, 120, 10, 15, 5, 28, 52, 10, 5, 15, 25, 4, 2, 15, 52, 5, 14, 31, 28, 4, 25, 0, 52, 15, 14, 13, 10, 30, 7, 31, 52, 25, 14, 10, 15, 52, 31, 2, 6, 14, 4, 30, 31, 52, 6, 24, 21, 16, 26, 3, 43, 21, 26, 16, 6, 27, 29, 16, 43, 26, 17, 0, 3, 27, 6, 31, 43, 16, 17, 18, 21, 1, 24, 0, 43, 6, 17, 0, 6, 29, 17, 7, 43, 26, 1, 25, 106, 111, 101, 124, 84, 106, 101, 111, 121, 100, 98, 111, 84, 101, 110, Byte.MAX_VALUE, 124, 100, 121, 96, 84, 111, 110, 109, 106, 126, 103, Byte.MAX_VALUE, 84, Byte.MAX_VALUE, 99, 121, 100, Byte.MAX_VALUE, Byte.MAX_VALUE, 103, 110, 84, Byte.MAX_VALUE, 98, 102, 110, 100, 126, Byte.MAX_VALUE, 84, 102, 120, 43, 46, 36, 61, 21, 43, 36, 46, 56, 37, 35, 46, 21, 36, 47, 62, 61, 37, 56, 33, 21, 46, 47, 44, 43, 63, 38, 62, 21, 62, 35, 39, 47, 37, 63, 62, 21, 39, 57, 71, 66, 72, 81, 121, 71, 72, 66, 84, 73, 79, 66, 121, 73, 82, 85, 74, 121, 67, 72, 71, 68, 74, 67, 66, 121, 124, 118, 111, 71, 121, 118, 124, 106, 119, 113, 124, 71, 106, 125, 117, 119, 110, 125, 71, 105, 109, 125, 106, 97, 71, 104, 121, 106, 108, 71, 126, 106, 119, 117, 71, 123, 121, 123, 112, 125, 71, 115, 125, 97, 103, 98, 104, 113, 89, 103, 104, 98, 116, 105, 111, 98, 89, 116, 99, 118, 105, 116, 114, 89, 118, 116, 99, 117, 99, 104, 114, 103, 114, 111, 105, 104, 89, 99, 116, 116, 105, 116, 89, 113, 110, 99, 104, 89, 104, 105, 89, 111, 107, 118, 116, 99, 117, 117, 111, 105, 104, 124, 121, 115, 106, 66, 124, 115, 121, 111, 114, 116, 121, 66, 111, 120, 109, 114, 111, 105, 66, 109, 111, 120, 110, 120, 115, 105, 124, 105, 116, 114, 115, 66, 120, 111, 111, 114, 111, 110, 66, 116, 115, 110, 105, 120, 124, 121, 66, 114, 123, 66, 116, 115, 105, 120, 111, 115, 124, 113, 56, 61, 55, 46, 6, 56, 55, 61, 43, 54, 48, 61, 6, 42, 49, 54, 44, 53, 61, 6, 59, 53, 54, 58, 50, 6, 42, 32, 55, 58, 6, 54, 55, 6, 59, 56, 58, 50, 62, 43, 54, 44, 55, 61, 86, 83, 89, 64, 104, 86, 89, 83, 69, 88, 94, 83, 104, 68, 95, 88, 66, 91, 83, 104, 95, 94, 83, 82, 104, 91, 88, 86, 83, 82, 69, 91, 94, 84, 77, 101, 91, 84, 94, 72, 85, 83, 94, 101, 73, 82, 85, 79, 86, 94, 101, 83, 84, 83, 78, 101, 79, 84, 73, 81, 83, 74, 74, 91, 88, 86, 95, 101, 73, 95, 89, 85, 84, 94, 73, 101, 89, 85, 87, 74, 86, 95, 78, 95, 52, 49, 59, 34, 10, 52, 59, 49, 39, 58, 60, 49, 10, 38, 61, 58, 32, 57, 49, 10, 57, 52, 32, 59, 54, 61, 10, 37, 57, 52, 44, 10, 38, 33, 58, 39, 48, 10, 60, 59, 10, 58, 35, 48, 39, 57, 52, 44, 14, 11, 1, 24, 48, 14, 1, 11, 29, 0, 6, 11, 48, 28, 7, 0, 26, 3, 11, 48, 29, 10, 28, 10, 27, 48, 9, 0, 12, 26, 28, 48, 0, 1, 48, 1, 14, 27, 6, 25, 10, 48, 29, 10, 31, 0, 29, 27, 6, 1, 8, 109, 104, 98, 123, 83, 109, 98, 104, 126, 99, 101, 104, 83, 121, 110, 122, 126, 111, 58, 63, 53, 44, 4, 58, 53, 63, 41, 52, 50, 63, 4, 46, 40, 62, 4, 56, 58, 56, 51, 62, 4, 54, 52, 63, 46, 55, 62, 4, 61, 52, 41, 4, 50, 54, 58, 60, 62, 40, 35, 38, 44, 53, 29, 35, 44, 38, 48, 45, 43, 38, 29, 55, 49, 39, 29, 49, 54, 39, 35, 47, 43, 44, 37, 29, 43, 47, 35, 37, 39, 29, 38, 39, 33, 45, 38, 43, 44, 37, 91, 94, 84, 77, 101, 91, 84, 94, 72, 85, 83, 94, 101, 77, 82, 83, 78, 95, 86, 83, 73, 78, 95, 94, 101, 83, 84, 78, 95, 84, 78, 101, 79, 72, 86, 101, 74, 72, 95, 92, 
        83, 66, 95, 73, 45, 40, 34, 59, 19, 45, 63, 63, 41, 56, 19, 42, 41, 56, 47, 36, 37, 34, 43, 19, 57, 34, 37, 42, 37, 41, 40, 7, 2, 8, 17, 57, 4, 7, 8, 8, 3, 20, 57, 8, 9, 18, 15, 0, 31, 57, 7, 2, 57, 10, 9, 7, 2, 3, 2, 57, 9, 8, 57, 7, 21, 21, 3, 18, 21, 57, 10, 9, 7, 2, 3, 2, 41, 44, 38, 63, 23, 42, 45, 38, 43, 32, 37, 41, 58, 35, 23, 58, 45, 56, 39, 58, 60, 23, 33, 38, 60, 45, 58, 62, 41, 36, 23, 37, 59, 114, 119, 125, 100, 76, 113, Byte.MAX_VALUE, 124, 112, 120, 76, 117, 99, 76, 112, 126, 99, 76, 114, 97, 122, Byte.MAX_VALUE, 117, 108, 68, 121, 119, 116, 120, 112, 68, 119, 116, 120, 112, 104, 120, 105, 126, 126, 117, 21, 16, 26, 3, 43, 23, 21, 23, 43, 25, 21, 29, 43, 27, 26, 24, 13, 43, 7, 4, 24, 29, 0, 43, 7, 23, 6, 17, 17, 26, 91, 94, 84, 77, 101, 89, 86, 83, 89, 81, 73, 101, 73, 95, 89, 85, 84, 94, 101, 89, 82, 91, 84, 84, 95, 86, 101, 95, 84, 91, 88, 86, 95, 94, 51, 54, 60, 37, 13, 49, 32, 51, 33, 58, 13, 33, 58, 59, 55, 62, 54, 13, 55, 60, 51, 48, 62, 55, 54, 35, 38, 44, 53, 29, 33, 54, 35, 29, 35, 44, 43, 47, 35, 54, 43, 45, 44, 29, 38, 39, 46, 35, 59, 29, 47, 49, 26, 31, 21, 12, 36, 24, 15, 26, 36, 22, 18, 21, 36, 8, 24, 26, 23, 30, 36, 26, 21, 18, 22, 26, 15, 18, 20, 21, 36, 11, 30, 9, 24, 30, 21, 15, 26, 28, 30, 66, 71, 77, 84, 124, 71, 70, 80, 87, 81, 76, 90, 124, 76, 77, 124, 71, 74, 80, 78, 74, 80, 80, 52, 49, 59, 34, 10, 49, 60, 38, 52, 55, 57, 48, 10, 35, 60, 49, 48, 58, 10, 51, 32, 57, 57, 38, 54, 39, 48, 48, 59, 10, 58, 59, 10, 59, 52, 33, 60, 35, 48, 37, 32, 42, 51, 27, 32, 43, 27, 40, 33, 55, 55, 27, 55, 48, 54, 45, 39, 48, 27, 55, 33, 39, 43, 42, 32, 27, 39, 44, 37, 42, 42, 33, 40, 27, 45, 41, 52, 89, 92, 86, 79, 103, 93, 86, 89, 90, 84, 93, 103, 89, 77, 76, 87, 103, 92, 93, 75, 76, 74, 87, 65, 103, 84, 93, 89, 83, 75, 87, 82, 88, 65, 105, 83, 88, 87, 84, 90, 83, 105, 84, 95, 82, 82, 83, 68, 105, 66, 89, 93, 83, 88, 105, 95, 88, 80, 89, 58, 63, 53, 44, 4, 62, 53, 58, 57, 55, 62, 4, 63, 62, 57, 46, 60, 4, 52, 45, 62, 41, 55, 58, 34, 47, 42, 32, 57, 17, 43, 32, 47, 44, 34, 43, 17, 43, 54, 33, 62, 34, 47, 55, 43, 60, 17, 45, 47, 45, 38, 43, 10, 15, 5, 28, 52, 14, 5, 10, 9, 7, 14, 52, 14, 19, 4, 27, 7, 10, 18, 14, 25, 52, 8, 10, 8, 3, 14, 52, 13, 4, 25, 52, 15, 24, 7, 65, 68, 78, 87, Byte.MAX_VALUE, 69, 78, 65, 66, 76, 69, Byte.MAX_VALUE, 69, 88, 79, 80, 76, 65, 89, 69, 82, Byte.MAX_VALUE, 86, 18, 94, 91, 81, 72, 96, 90, 81, 94, 93, 83, 90, 96, 89, 74, 81, 81, 90, 83, 24, 29, 23, 14, 38, 28, 23, 24, 27, 21, 28, 38, 16, 23, 21, 16, 23, 28, 38, 1, 38, 22, 12, 13, 38, 23, 22, 23, 38, 31, 12, 21, 21, 10, 26, 11, 28, 28, 23, 38, 22, 23, 38, 10, 29, 18, 13, 8, 2, 27, 51, 9, 2, 13, 14, 0, 9, 51, 2, 9, 24, 27, 3, 30, 7, 77, 72, 66, 91, 115, 73, 66, 77, 78, 64, 73, 115, 92, 94, 73, 64, 67, 77, 72, 27, 30, 20, 13, 37, 31, 20, 27, 24, 22, 31, 37, 8, 27, 29, 31, 37, 9, 18, 27, 17, 31, 100, 97, 107, 114, 90, 96, 107, 100, 103, 105, 96, 90, 118, 124, 107, 102, 79, 74, 64, 89, 113, 75, 64, 74, 113, 77, 79, 92, 74, 93, 113, 77, 66, 71, 77, 69, 79, 76, 66, 75, 96, 101, 111, 118, 94, 100, 121, 113, 110, 114, 100, 94, 119, 104, 101, 100, 110, 94, 118, 96, 117, 98, 105, 94, 117, 104, 108, 100, 15, 10, 0, 25, 49, 11, 22, 26, 28, 15, 49, 29, 30, 2, 49, 29, 13, 28, 49, 13, 6, 11, 13, 5, 29, 20, 17, 27, 2, 42, 19, 23, 42, 18, 5, 42, 26, 3, 16, 7, 25, 20, 12, 42, 6, 16, 22, 0, 7, 16, 33, 26, 30, 16, 27, 117, 112, 122, 99, 75, 114, 118, 75, 115, 100, 75, 123, 98, 113, 102, 120, 117, 109, 75, 98, 113, 102, 103, 125, 123, 122, 121, 124, 118, 111, 71, 126, 113, 116, 108, 125, 106, 71, 122, 113, 124, 124, 113, 118, Byte.MAX_VALUE, 71, 108, 119, 115, 125, 118, 123, 126, 116, 109, 69, 124, 117, 104, 121, Byte.MAX_VALUE, 69, 126, Byte.MAX_VALUE, 108, 115, 121, Byte.MAX_VALUE, 69, 105, 121, 104, Byte.MAX_VALUE, Byte.MAX_VALUE, 116, 69, 123, 118, 109, 123, 99, 105, 69, 117, 116, 43, 46, 36, 61, 21, 45, 58, 21, 37, 60, 47, 56, 38, 43, 51, 21, 47, 36, 43, 40, 38, 47, 46, 56, 61, 55, 46, 6, 48, 56, 59, 6, 58, 44, 42, 45, 54, 52, 6, 42, 58, 49, 60, 52, 56, 42, 6, 63, 48, 33, 6, 60, 55, 56, 59, 53, 60, 61, 109, 104, 98, 123, 83, 101, 97, 124, Byte.MAX_VALUE, 83, Byte.MAX_VALUE, 105, 111, 99, 98, 104, 83, 111, 100, 109, 98, 98, 105, 96, 83, 105, 98, 109, 110, 96, 105, 104, 10, 15, 5, 
        28, 52, 2, 5, 31, 52, 2, 6, 10, 12, 14, 52, 10, 24, 52, 8, 31, 10, 52, 14, 5, 10, 9, 7, 14, 15, 100, 97, 107, 114, 90, 108, 107, 113, 90, 108, 104, 100, 98, 96, 90, 100, 118, 90, 102, 113, 100, 90, 108, 107, 107, 96, 119, 90, 118, 116, 112, 100, 119, 96, 0, 5, 15, 22, 62, 8, 15, 21, 62, 19, 23, 62, 8, 15, 18, 21, 0, 13, 13, 62, 8, 15, 23, 0, 13, 8, 5, 0, 21, 8, 14, 15, 18, 23, 18, 24, 1, 41, 31, 24, 2, 41, 4, 0, 41, 0, 31, 18, 19, 25, 41, 23, 5, 41, 21, 2, 23, 41, 19, 24, 23, 20, 26, 19, 18, 52, 49, 59, 34, 10, 60, 59, 33, 10, 39, 35, 10, 35, 60, 49, 48, 58, 10, 52, 38, 10, 54, 33, 52, 10, 60, 59, 59, 48, 39, 10, 38, 36, 32, 52, 39, 48, 81, 84, 94, 71, 111, 89, 94, 68, 85, 66, 67, 68, 89, 68, 89, 81, 92, 111, 94, 85, 71, 111, 89, 93, 81, 87, 85, 111, 84, 85, 67, 89, 87, 94, 115, 118, 124, 101, 77, 126, 125, 117, 77, 113, 97, 77, 113, Byte.MAX_VALUE, 98, 61, 56, 50, 43, 3, 48, 51, 59, 59, 53, 50, 59, 3, 57, 50, 56, 44, 51, 53, 50, 40, 3, 44, 46, 57, 58, 53, 36, 71, 66, 72, 81, 121, 72, 71, 82, 79, 80, 67, 121, 69, 71, 84, 73, 83, 85, 67, 74, 121, 69, 73, 75, 86, 71, 69, 82, 121, 82, 78, 84, 67, 85, 78, 73, 74, 66, 99, 102, 108, 117, 93, 108, 99, 118, 107, 116, 103, 93, 116, 107, 102, 103, 109, 93, 110, 109, 109, 114, 107, 108, 101, 93, 103, 108, 99, 96, 110, 103, 102, 58, 63, 53, 44, 4, 53, 58, 47, 50, 45, 62, 4, 45, 50, 62, 44, 4, 40, 53, 58, 43, 40, 51, 52, 47, 4, 55, 52, 60, 60, 50, 53, 60, 4, 62, 53, 58, 57, 55, 62, 63, 121, 124, 118, 111, 71, 119, 118, 124, 125, 110, 113, 123, 125, 71, 112, 113, 107, 108, 119, 106, 97, 71, 124, 121, 108, 121, 71, 125, 118, 121, 122, 116, 125, 124, 34, 39, 45, 52, 28, 44, 51, 38, 45, 28, 37, 33, 28, 34, 51, 51, 28, 34, 47, 52, 34, 58, 48, 25, 28, 22, 15, 39, 8, 20, 25, 1, 25, 26, 20, 29, 39, 27, 20, 17, 27, 19, 39, 21, 25, 0, 39, 28, 29, 20, 25, 1, 39, 21, 11, 94, 91, 81, 72, 96, 79, 83, 94, 70, 94, 93, 83, 90, 96, 91, 86, 76, 94, 93, 83, 90, 96, 77, 90, 82, 80, 75, 90, 96, 80, 81, 96, 81, 90, 75, 72, 80, 77, 84, 96, 83, 80, 76, 76, 44, 41, 35, 58, 18, 61, 33, 44, 52, 44, 47, 33, 40, 62, 18, 33, 34, 42, 42, 36, 35, 42, 18, 40, 35, 44, 47, 33, 40, 41, 32, 37, 47, 54, 30, 49, 45, 32, 56, 32, 35, 45, 36, 50, 30, 50, 41, 46, 54, 30, 36, 47, 37, 34, 32, 51, 37, 125, 120, 114, 107, 67, 108, 110, 121, 112, 115, 125, 120, 67, 117, 114, 104, 121, 110, 111, 104, 117, 104, 117, 125, 112, 67, 120, 101, 114, 125, 113, 117, Byte.MAX_VALUE, 67, 107, 121, 126, 106, 117, 121, 107, 68, 65, 75, 82, 122, 85, 87, 64, 73, 74, 68, 65, 122, 75, 68, 81, 76, 83, 64, 122, 65, 92, 75, 68, 72, 76, 70, 122, 82, 64, 71, 83, 76, 64, 82, 34, 39, 45, 52, 28, 51, 49, 38, 47, 44, 34, 39, 28, 49, 53, 28, 39, 58, 45, 34, 46, 42, 32, 28, 52, 38, 33, 53, 42, 38, 52, 10, 15, 5, 28, 52, 27, 25, 14, 29, 14, 5, 31, 52, 27, 7, 10, 18, 10, 9, 7, 14, 52, 10, 30, 31, 4, 52, 8, 7, 2, 8, 0, 46, 43, 33, 56, 16, 63, 58, 61, 40, 42, 16, 32, 33, 16, 123, 126, 124, 16, 61, 42, 60, 63, 32, 33, 60, 42, 1, 4, 14, 23, 63, 18, 5, 3, 15, 13, 16, 21, 20, 5, 63, 2, 20, 63, 1, 6, 20, 5, 18, 63, 5, 24, 20, 18, 1, 19, 63, 3, 8, 1, 14, 7, 5, 52, 49, 59, 34, 10, 39, 35, 10, 55, 32, 51, 51, 48, 39, 10, 54, 61, 48, 54, 62, 10, 48, 59, 52, 55, 57, 48, 49, 76, 73, 67, 90, 114, 95, 91, 114, 93, 65, 76, 84, 79, 76, 78, 70, 114, 78, 95, 76, 94, 69, 114, 75, 76, 65, 65, 79, 76, 78, 70, 12, 9, 3, 26, 50, 30, 8, 3, 9, 4, 3, 10, 50, 11, 31, 8, 28, 24, 8, 3, 14, 20, 50, 14, 12, 29, 29, 4, 3, 10, 50, 12, 1, 1, 2, 26, 8, 9, 79, 74, 64, 89, 113, 93, 75, 90, 113, 90, 75, 86, 90, 113, 77, 65, 66, 65, 92, 113, 74, 87, 64, 79, 67, 71, 77, 79, 66, 66, 87, 55, 50, 56, 33, 9, 37, 62, 57, 35, 58, 50, 9, 55, 50, 50, 9, 51, 46, 34, 51, 56, 37, 63, 57, 56, 9, 34, 57, 9, 38, 58, 55, 47, 55, 52, 58, 51, 37, 126, 123, 113, 104, 64, 108, 119, 112, 106, 115, 123, 64, 124, 115, 122, 126, 109, 64, 121, 122, 126, 107, 106, 109, 122, 64, 124, 112, 113, 121, 118, 120, 64, 112, 113, 64, 124, 109, 126, 108, 119, 122, 108, 3, 6, 12, 21, 61, 17, 10, 13, 23, 14, 6, 61, 11, 5, 12, 13, 16, 7, 61, 6, 7, 17, 22, 16, 13, 27, 61, 1, 3, 14, 14, 121, 124, 118, 111, 71, 107, 112, 119, 109, 116, 124, 71, 113, 118, 123, 106, 125, 
        117, 125, 118, 108, 71, 106, 125, 108, 106, 97, 71, 123, 119, 109, 118, 108, 125, 106, 71, 119, 118, 71, 125, 117, 104, 108, 97, 71, 106, 125, 107, 104, 119, 118, 107, 125, 33, 36, 46, 55, 31, 51, 40, 47, 53, 44, 36, 31, 41, 46, 41, 52, 31, 38, 50, 47, 45, 31, 35, 47, 46, 52, 37, 46, 52, 31, 48, 50, 47, 54, 41, 36, 37, 50, 104, 109, 103, 126, 86, 122, 97, 102, 124, 101, 109, 86, 96, 103, 96, 125, 86, 102, 103, 86, 106, 101, 104, 122, 122, 86, 101, 102, 104, 109, 96, 103, 110, 7, 2, 8, 17, 57, 21, 14, 9, 19, 10, 2, 57, 10, 9, 1, 57, 7, 21, 21, 3, 18, 57, 19, 20, 10, 98, 103, 109, 116, 92, 112, 107, 108, 118, 111, 103, 92, 115, 113, 102, 96, 108, 110, 115, 118, 119, 102, 92, 97, 106, 103, 103, 102, 113, 92, 119, 108, 104, 102, 109, 123, 126, 116, 109, 69, 105, 113, 115, 106, 69, 108, 115, 126, Byte.MAX_VALUE, 117, 69, 116, 117, 116, 69, 114, 123, 104, 126, 109, 123, 104, Byte.MAX_VALUE, 69, 123, 121, 121, Byte.MAX_VALUE, 118, Byte.MAX_VALUE, 104, 123, 110, Byte.MAX_VALUE, 126, 35, 38, 44, 53, 29, 49, 50, 46, 43, 54, 29, 49, 33, 48, 39, 39, 44, 29, 39, 44, 35, 32, 46, 39, 38, 29, 116, 29, 115, 117, 96, 101, 111, 118, 94, 114, 117, 96, 98, 106, 117, 115, 96, 98, 100, 94, 102, 115, 110, 116, 113, 104, 111, 102, 94, 100, 111, 96, 99, 109, 100, 101, 106, 111, 101, 124, 84, 120, 114, 101, 104, 84, 106, 109, Byte.MAX_VALUE, 110, 121, 84, 106, 111, 84, 103, 100, 106, 111, 69, 64, 74, 83, 123, 87, 93, 74, 71, 123, 65, 74, 64, 84, 75, 77, 74, 80, 123, 84, 86, 65, 66, 77, 92, 83, 86, 92, 69, 109, 70, 91, 95, 87, 109, 70, 93, 109, 69, 83, 91, 70, 109, 84, 93, 64, 109, 68, 91, 86, 87, 93, 109, 66, 94, 83, 75, 109, 95, 65, 115, 118, 124, 101, 77, 102, 123, Byte.MAX_VALUE, 119, 77, 102, 125, 77, 101, 115, 123, 102, 77, 116, 125, 96, 77, 100, 123, 118, 119, 125, 77, 98, 96, 119, 98, 115, 96, 119, 118, 77, Byte.MAX_VALUE, 97, 125, 120, 114, 107, 67, 104, 117, 113, 121, 115, 105, 104, 67, 110, 121, 107, 125, 110, 120, 121, 120, 67, 106, 117, 120, 121, 115, 54, 51, 57, 32, 8, 35, 37, 62, 48, 48, 50, 37, 8, 57, 54, 35, 62, 33, 50, 8, 37, 50, 48, 62, 36, 35, 50, 37, 8, 33, 62, 50, 32, 8, 50, 37, 37, 56, 37, 8, 52, 54, 59, 59, 53, 54, 52, 60, 72, 77, 71, 94, 118, 92, 71, 64, 88, 92, 76, 118, 77, 75, 118, 71, 72, 68, 76, 118, 89, 76, 91, 118, 89, 91, 70, 74, 76, 90, 90, 50, 55, 61, 36, 12, 38, 35, 55, 50, 39, 54, 12, 54, 43, 39, 33, 50, 12, 59, 58, 61, 39, 32, 12, 53, 60, 33, 12, 48, 59, 50, 58, 61, 58, 61, 52, 53, 48, 58, 35, 11, 33, 39, 49, 11, 53, 36, 36, 11, 48, 61, 51, 49, 39, 32, 11, 53, 36, 61, 113, 116, 126, 103, 79, 101, 99, 117, 79, 115, 113, 115, 120, 117, 116, 79, 117, 104, 117, 115, 101, 100, Byte.MAX_VALUE, 98, 79, 118, Byte.MAX_VALUE, 98, 79, 126, 117, 100, 103, Byte.MAX_VALUE, 98, 123, 30, 27, 17, 8, 32, 10, 12, 26, 32, 28, 30, 28, 23, 26, 27, 32, 26, 7, 26, 28, 10, 11, 16, 13, 32, 22, 17, 32, 28, 30, 28, 23, 26, 32, 18, 30, 17, 30, 24, 26, 13, 34, 39, 45, 52, 28, 54, 48, 38, 28, 37, 51, 28, 51, 38, 49, 28, 33, 54, 45, 39, 47, 38, 31, 26, 16, 9, 33, 11, 13, 27, 33, 12, 23, 14, 14, 18, 27, 33, 31, 16, 23, 19, 31, 10, 23, 17, 16, 25, 28, 22, 15, 39, 13, 11, 29, 39, 11, 29, 27, 13, 10, 29, 39, 13, 10, 17, 39, 8, 25, 10, 11, 29, 10, 75, 78, 68, 93, 117, 95, 89, 79, 117, 89, 90, 70, 67, 94, 117, 89, 73, 88, 79, 79, 68, 117, 75, 70, 93, 75, 83, 89, 105, 108, 102, Byte.MAX_VALUE, 87, 126, 97, 108, 109, 103, 87, 123, 109, 107, 103, 102, 108, 87, 107, 96, 105, 102, 102, 109, 100, 87, 107, 103, 102, 123, 124, 105, 102, 124, 87, 110, 100, 125, 123, 96, 87, 109, 102, 105, 106, 100, 109, 108, 42, 47, 37, 60, 20, 61, 34, 47, 46, 36, 20, 56, 46, 40, 36, 37, 47, 20, 40, 35, 42, 37, 37, 46, 39, 20, 46, 37, 42, 41, 39, 46, 47, 125, 105, 104, 115, 110, 115, 104, 125, 104, 121, 67, 120, 117, 111, 125, 126, 112, 121, 120, 11, 31, 30, 5, 24, 5, 30, 11, 30, 15, 53, 15, 4, 11, 8, 6, 15, 14, 96, 111, 106, 96, 104, 100, 118, 98, 113, 103, 92, 119, 106, 110, 102, 92, 110, 112, 94, 82, 80, 19, 91, 92, 94, 88, 95, 82, 82, 86, 19, 92, 89, 78, 19, 123, 120, 124, 105, 104, 111, 120, 98, 126, 114, 115, 123, 116, 122, 92, 84, 87, 106, 87, 90, 65, 65, 90, 88, 106, 70, 93, 80, 80, 65, 106, 80, 91, 84, 87, 89, 80, 81, 51, 62, 44, 43, 0, 42, 47, 59, 62, 43, 58, 0, 43, 54, 50, 58, 44, 43, 62, 50, 47, 66, 70, 65, 70, 66, 90, 66, 112, 74, 67, 78, 95, 92, 74, 75, 112, 91, 70, 66, 74, 112, 78, 73, 91, 74, 93, 112, 70, 66, 95, 93, 74, 92, 92, 70, 64, 65, 17, 10, 19, 19, 124, 107, 125, 122, 124, 103, 109, 122, 107, 106, 81, 106, 111, 
        122, 111, 81, 126, 124, 97, 109, 107, 125, 125, 103, 96, 105, 81, 109, 97, 99, 108, 103, 96, 111, 122, 103, 97, 96, 125, 41, 46, 59, 57, 49, 5, 46, 40, 59, 57, 63, 5, 41, 59, 55, 42, 54, 63, 5, 40, 59, 46, 63, 20, 11, 6, 7, 13, 61, 3, 12, 6, 61, 7, 12, 6, 1, 3, 16, 6, 61, 3, 23, 22, 13, 16, 13, 22, 3, 22, 7, 6, 6, 6};
    }

    static {
        A0Z();
        A04 = new String[0];
        A05 = new String[]{A0S(22, 5, R.styleable.AppCompatTheme_textColorAlertDialogListItem), A0S(1, 9, 36), A0S(10, 12, 63)};
    }

    public C0705Ih(Context context) {
        this.A00 = context.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A0S(4870, 31, 19), context), 0);
    }

    public static float A00(Context context) {
        return A0R(context).A01(A0S(2266, 39, 85), 0.98f);
    }

    private final float A01(String str, float f4) {
        String string = this.A00.getString(str, String.valueOf(f4));
        if (string != null) {
            try {
                String value = A0S(4983, 4, 81);
                if (string.equals(value)) {
                    return f4;
                }
                f4 = Float.parseFloat(string);
                return f4;
            } catch (NumberFormatException unused) {
                return f4;
            }
        }
        return f4;
    }

    public static int A02(Context context) {
        return A0R(context).A2T(A0S(99, 33, 14), 100);
    }

    public static int A03(Context context) {
        return A0R(context).A2T(A0S(2076, 33, 102), 0);
    }

    public static int A04(Context context) {
        return A0R(context).A2T(A0S(2239, 27, 108), -1);
    }

    public static int A05(Context context) {
        return A0R(context).A2T(A0S(569, 37, 80), 3);
    }

    public static int A06(Context context) {
        return A0R(context).A2T(A0S(4852, 18, 45), 0);
    }

    public static int A07(Context context) {
        return A0R(context).A2T(A0S(315, 36, 11), 3000);
    }

    public static int A08(Context context) {
        return A0R(context).A2T(A0S(1228, 50, 37), 30000);
    }

    public static int A09(Context context) {
        return A0R(context).A2T(A0S(1322, 40, 90), 3);
    }

    public static int A0A(Context context) {
        return A0R(context).A2T(A0S(1278, 44, 69), 8000);
    }

    public static int A0B(Context context) {
        return A0R(context).A2T(A0S(1362, 48, 37), 100);
    }

    public static int A0C(Context context) {
        return A0R(context).A2T(A0S(1410, 39, 100), 60000);
    }

    public static int A0D(Context context) {
        return A0R(context).A2T(A0S(2822, 26, 58), -1);
    }

    public static int A0E(Context context) {
        return A0R(context).A2T(A0S(3239, 38, 8), 225);
    }

    public static int A0F(Context context) {
        return A0R(context).A2T(A0S(997, 41, 49), 3145728);
    }

    public static int A0G(Context context) {
        return A0R(context).A2T(A0S(4946, 37, 1), -1);
    }

    public static int A0H(Context context) {
        return A0R(context).A2T(A0S(3408, 32, 86), 2000);
    }

    public static int A0I(Context context) {
        return A0R(context).A2T(A0S(53, 46, 88), -1);
    }

    public static int A0J(Context context) {
        return A0R(context).A2T(A0S(5026, 23, 116), 0);
    }

    public static int A0K(Context context) {
        return A0R(context).A2T(A0S(4317, 35, 28), 3000);
    }

    public static int A0L(Context context) {
        return A0R(context).A2T(A0S(4352, 39, 60), 3000);
    }

    public static int A0M(Context context) {
        return A0R(context).A2T(A0S(1143, 46, 67), 0);
    }

    public static long A0N(Context context) {
        return A0R(context).A2U(A0S(535, 34, 54), 67108864L);
    }

    public static long A0O(Context context) {
        return A0R(context).A2U(A0S(650, 45, R.styleable.AppCompatTheme_toolbarStyle), 1048576L);
    }

    public static long A0P(Context context) {
        return A0R(context).A2U(A0S(803, 38, 60), 33554432L);
    }

    public static long A0Q(Context context) {
        return A0R(context).A2U(A0S(4925, 21, R.styleable.AppCompatTheme_toolbarStyle), -1L);
    }

    public static synchronized C0705Ih A0R(Context context) {
        C0705Ih c0705Ih;
        synchronized (C0705Ih.class) {
            if (A01 == null) {
                A01 = new C0705Ih(context);
            }
            c0705Ih = A01;
        }
        return c0705Ih;
    }

    public static String A0T(Context context) {
        return A0R(context).A2V(A0S(3211, 28, R.styleable.AppCompatTheme_tooltipForegroundColor), A0S(5077, 3, 95));
    }

    public static String A0U(Context context) {
        return A0R(context).A2V(A0S(4292, 25, 10), A0S(5077, 3, 95));
    }

    public static Set<String> A0V(Context context) {
        return A0R(context).A0Y(A0S(394, 44, 43), A04);
    }

    public static Set<String> A0W(Context context) {
        return A0R(context).A0Y(A0S(4987, 39, 32), A05);
    }

    public static Set<String> A0X(Context context) {
        return A0R(context).A0Y(A0S(1960, 44, 20), A04);
    }

    private Set<String> A0Y(String str, String[] strArr) {
        JSONArray jSONArray;
        String jsonArrayString = A2V(str, null);
        try {
            if (jsonArrayString == null) {
                jSONArray = new JSONArray((Collection) Arrays.asList(strArr));
            } else {
                jSONArray = new JSONArray(jsonArrayString);
            }
            int length = jSONArray.length();
            LinkedHashSet linkedHashSet = new LinkedHashSet(length);
            for (int i = 0; i < length; i++) {
                linkedHashSet.add(jSONArray.getString(i));
            }
            return linkedHashSet;
        } catch (JSONException unused) {
            return new LinkedHashSet();
        }
    }

    public static void A0a(Context context) {
        A0R(context).A00.edit().clear().commit();
    }

    private void A0b(String str, String str2) throws JSONException {
        if (str == null || str.isEmpty() || str.equals(A0S(27, 2, 29))) {
            return;
        }
        JSONObject json = new JSONObject(str);
        A0c(json, str2);
    }

    private void A0c(JSONObject jSONObject, String str) throws JSONException {
        SharedPreferences.Editor edit = this.A00.edit();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.equals(A0S(29, 24, R.styleable.AppCompatTheme_tooltipFrameBackground))) {
                A0b(jSONObject.getString(next), next);
            } else {
                String str2 = next;
                if (str != null) {
                    str2 = str + A0S(0, 1, 108) + str2;
                }
                edit.putString(str2, jSONObject.getString(next));
            }
        }
        String sharedPrefKey = Long.toString(System.currentTimeMillis());
        edit.putString(A0S(4925, 21, R.styleable.AppCompatTheme_toolbarStyle), sharedPrefKey);
        edit.apply();
    }

    public static boolean A0d(Context context) {
        return A0R(context).A2V(A0S(5049, 28, 76), A0S(4815, 19, 50)).equals(A0S(4834, 18, 68));
    }

    public static boolean A0e(Context context) {
        return A0R(context).A2Z(A0S(245, 38, 86), false);
    }

    public static boolean A0f(Context context) {
        return A0R(context).A2Z(A0S(3706, 37, 78), false);
    }

    public static boolean A0g(Context context) {
        return A0R(context).A2Z(A0S(351, 43, 81), true);
    }

    public static boolean A0h(Context context) {
        return A0R(context).A2Z(A0S(2435, 29, 24), true);
    }

    public static boolean A0i(Context context) {
        return A0R(context).A2Z(A0S(2109, 20, 61), false);
    }

    public static boolean A0j(Context context) {
        return A0R(context).A2Z(A0S(3514, 27, R.styleable.AppCompatTheme_textColorSearchUrl), false);
    }

    public static boolean A0k(Context context) {
        return A0R(context).A2Z(A0S(606, 44, 97), true);
    }

    public static boolean A0l(Context context) {
        return A0R(context).A2Z(A0S(2214, 25, 124), true);
    }

    public static boolean A0m(Context context) {
        return A0R(context).A2Z(A0S(3440, 44, 17), true);
    }

    public static boolean A0n(Context context) {
        return A0R(context).A2Z(A0S(2328, 39, 123), false);
    }

    public static boolean A0o(Context context) {
        return A0R(context).A2Z(A0S(733, 37, R.styleable.AppCompatTheme_textColorAlertDialogListItem), true);
    }

    public static boolean A0p(Context context) {
        return A0R(context).A2Z(A0S(2405, 30, 22), false);
    }

    public static boolean A0q(Context context) {
        return A0R(context).A2Z(A0S(3060, 33, 79), false);
    }

    public static boolean A0r(Context context) {
        return A0R(context).A2Z(A0S(770, 33, 74), true);
    }

    public static boolean A0s(Context context) {
        return A0R(context).A2Z(A0S(2739, 28, 47), false);
    }

    public static boolean A0t(Context context) {
        return A0R(context).A2Z(A0S(841, 40, 83), true);
    }

    public static boolean A0u(Context context) {
        return A0R(context).A2Z(A0S(881, 35, 10), false);
    }

    public static boolean A0v(Context context) {
        return A0R(context).A2Z(A0S(2575, 18, 17), false);
    }

    public static boolean A0w(Context context) {
        return A0R(context).A2Z(A0S(2930, 35, 119), true);
    }

    public static boolean A0x(Context context) {
        return A0R(context).A2Z(A0S(283, 32, 76), false);
    }

    public static boolean A0y(Context context) {
        return A0R(context).A2Z(A0S(132, 25, 121), false);
    }

    public static boolean A0z(Context context) {
        return A0R(context).A2Z(A0S(157, 52, 54), false);
    }

    public static boolean A10(Context context) {
        return A0R(context).A2Z(A0S(2848, 25, 54), false);
    }

    public static boolean A11(Context context) {
        if (Build.VERSION.SDK_INT >= 18) {
            C0705Ih A0R = A0R(context);
            String A0S = A0S(2464, 25, 117);
            if (A03[5].charAt(10) != 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "eVi9wsoxiKuO8fS3Ni664QsxmOwf4Hz";
            strArr[0] = "nOcXZ0DMfofG3U9htYbEeRQSfAelmGW";
            return A0R.A2Z(A0S, false);
        }
        return false;
    }

    public static boolean A12(Context context) {
        return A0R(context).A2Z(A0S(2715, 24, 0), false);
    }

    public static boolean A13(Context context) {
        return A0R(context).A2Z(A0S(3351, 34, 54), false);
    }

    public static boolean A14(Context context) {
        return A0R(context).A2Z(A0S(2907, 23, 100), false);
    }

    public static boolean A15(Context context) {
        return A0R(context).A2Z(A0S(2792, 30, 91), true);
    }

    public static boolean A16(Context context) {
        return A0R(context).A2Z(A0S(2997, 29, 69), false);
    }

    public static boolean A17(Context context) {
        return A0R(context).A2Z(A0S(3026, 34, 43), false);
    }

    public static boolean A18(Context context) {
        return A0R(context).A2Z(A0S(3093, 32, 88), false);
    }

    public static boolean A19(Context context) {
        return A0R(context).A2Z(A0S(3125, 37, 123), false);
    }

    public static boolean A1A(Context context) {
        return A0R(context).A2Z(A0S(1069, 23, 120), false);
    }

    public static boolean A1B(Context context) {
        return A0R(context).A2Z(A0S(3310, 41, 117), false);
    }

    public static boolean A1C(Context context) {
        return A0R(context).A2Z(A0S(2677, 22, 84), false);
    }

    public static boolean A1D(Context context) {
        return A0R(context).A2Z(A0S(3743, 28, 123), true);
    }

    public static boolean A1E(Context context) {
        return A0R(context).A2Z(A0S(3771, 31, 3), true);
    }

    public static boolean A1F(Context context) {
        return A0R(context).A2Z(A0S(4207, 30, 108), false);
    }

    public static boolean A1G(Context context) {
        return A0R(context).A2Z(A0S(4237, 32, 47), false);
    }

    public static boolean A1H(Context context) {
        return A0R(context).A2Z(A0S(3277, 33, 44), false);
    }

    public static boolean A1I(Context context) {
        return A0R(context).A2Z(A0S(3196, 15, 60), false);
    }

    public static boolean A1J(Context context) {
        return A0R(context).A2Z(A0S(2367, 38, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader), false);
    }

    public static boolean A1K(Context context) {
        return A0R(context).A2Z(A0S(2150, 30, 90), false);
    }

    public static boolean A1L(Context context) {
        return A0R(context).A2Z(A0S(2639, 19, 66), true);
    }

    public static boolean A1M(Context context) {
        return A0R(context).A2Z(A0S(2031, 45, 72), false);
    }

    public static boolean A1N(Context context) {
        return A0R(context).A2Z(A0S(1449, 25, 8), true);
    }

    public static boolean A1O(Context context) {
        return A0R(context).A2Z(A0S(3541, 41, 50), true);
    }

    public static boolean A1P(Context context) {
        return A0R(context).A2Z(A0S(2658, 19, 2), true);
    }

    public static boolean A1Q(Context context) {
        return A0R(context).A2Z(A0S(3582, 35, 11), true);
    }

    public static boolean A1R(Context context) {
        return A0R(context).A2Z(A0S(3617, 31, 109), true);
    }

    public static boolean A1S(Context context) {
        return A0R(context).A2Z(A0S(3648, 32, 69), true);
    }

    public static boolean A1T(Context context) {
        return A0R(context).A2Z(A0S(1474, 45, 54), true);
    }

    public static boolean A1U(Context context) {
        return A0R(context).A2Z(A0S(1519, 57, 40), false);
    }

    public static boolean A1V(Context context) {
        return A0R(context).A2Z(A0S(1576, 59, 51), true);
    }

    public static boolean A1W(Context context) {
        return A0R(context).A2Z(A0S(2965, 32, 34), false);
    }

    public static boolean A1X(Context context) {
        return A0R(context).A2Z(A0S(4782, 33, 101), false);
    }

    public static boolean A1Y(Context context) {
        return A0R(context).A2Z(A0S(3802, 38, 67), true);
    }

    public static boolean A1Z(Context context) {
        return A0R(context).A2Z(A0S(3871, 38, 120), true);
    }

    public static boolean A1a(Context context) {
        return A0R(context).A2Z(A0S(209, 36, 109), false);
    }

    public static boolean A1b(Context context) {
        return A0R(context).A2Z(A0S(3385, 23, 109), true);
    }

    public static boolean A1c(Context context) {
        return A0R(context).A2Z(A0S(4706, 28, 4), false);
    }

    public static boolean A1d(Context context) {
        return A0R(context).A2Z(A0S(2129, 21, 53), false);
    }

    public static boolean A1e(Context context) {
        return A0R(context).A2Z(A0S(1635, 44, 119), true);
    }

    public static boolean A1f(Context context) {
        return Build.VERSION.SDK_INT >= 16 && A0R(context).A2Z(A0S(438, 46, 88), false);
    }

    public static boolean A1g(Context context) {
        return A0R(context).A2Z(A0S(484, 51, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle), true);
    }

    public static boolean A1h(Context context) {
        return A0R(context).A2Z(A0S(3909, 43, 49), true);
    }

    public static boolean A1i(Context context) {
        return A0R(context).A2Z(A0S(4734, 48, 38), false);
    }

    public static boolean A1j(Context context) {
        return A0R(context).A2Z(A0S(2305, 23, 13), false);
    }

    public static boolean A1k(Context context) {
        return A0R(context).A2Z(A0S(695, 38, 63), false);
    }

    public static boolean A1l(Context context) {
        return A0R(context).A2Z(A0S(2767, 25, 64), true);
    }

    public static boolean A1m(Context context) {
        return A0R(context).A2Z(A0S(3484, 30, 99), true);
    }

    public static boolean A1n(Context context) {
        return A0R(context).A2Z(A0S(2004, 27, 98), false);
    }

    public static boolean A1o(Context context) {
        return A0R(context).A2Z(A0S(1092, 51, 31), false);
    }

    public static boolean A1p(Context context) {
        return A0R(context).A2Z(A0S(916, 40, 46), true);
    }

    public static boolean A1q(Context context) {
        return A0R(context).A2Z(A0S(1679, 31, 25), false);
    }

    public static boolean A1r(Context context) {
        return A0R(context).A2Z(A0S(956, 41, 8), false);
    }

    public static boolean A1s(Context context) {
        return A0R(context).A2Z(A0S(3952, 31, 76), false);
    }

    public static boolean A1t(Context context) {
        return A0R(context).A2Z(A0S(3983, 53, 54), false);
    }

    public static boolean A1u(Context context) {
        return A0R(context).A2Z(A0S(4036, 38, R.styleable.AppCompatTheme_textColorAlertDialogListItem), true);
    }

    public static boolean A1v(Context context) {
        return A0R(context).A2Z(A0S(4074, 33, 39), false);
    }

    public static boolean A1w(Context context) {
        return A0R(context).A2Z(A0S(1710, 53, 20), false);
    }

    public static boolean A1x(Context context) {
        return A0R(context).A2Z(A0S(2873, 34, 52), false);
    }

    public static boolean A1y(Context context) {
        return A0R(context).A2Z(A0S(1763, 48, 123), false);
    }

    public static boolean A1z(Context context) {
        return A0R(context).A2Z(A0S(4107, 25, 72), false);
    }

    public static boolean A20(Context context) {
        return A0R(context).A2Z(A0S(2180, 34, 20), false);
    }

    public static boolean A21(Context context) {
        return A0R(context).A2Z(A0S(4132, 35, 45), false);
    }

    public static boolean A22(Context context) {
        return A0R(context).A2Z(A0S(3680, 26, 97), false);
    }

    public static boolean A23(Context context) {
        return A0R(context).A2Z(A0S(1811, 51, 65), true);
    }

    public static boolean A24(Context context) {
        return A0R(context).A2Z(A0S(3840, 31, 0), false);
    }

    public static boolean A25(Context context) {
        return A0R(context).A2Z(A0S(1038, 31, 50), false);
    }

    public static boolean A26(Context context) {
        return A0R(context).A2Z(A0S(4269, 23, 37), true);
    }

    public static boolean A27(Context context) {
        return A0R(context).A2Z(A0S(4391, 27, 50), false);
    }

    public static boolean A28(Context context) {
        return A0R(context).A2Z(A0S(4497, 36, 125), false);
    }

    public static boolean A29(Context context) {
        return A0R(context).A2Z(A0S(2593, 46, 87), true);
    }

    public static boolean A2A(Context context) {
        return A0R(context).A2Z(A0S(3162, 34, 30), false);
    }

    public static boolean A2B(Context context) {
        return A0R(context).A2Z(A0S(4655, 25, 80), false);
    }

    public static boolean A2C(Context context) {
        return A0R(context).A2Z(A0S(4466, 31, 7), false);
    }

    public static boolean A2D(Context context) {
        return A0R(context).A2Z(A0S(4167, 40, 52), true);
    }

    public static boolean A2E(Context context) {
        return A0R(context).A2Z(A0S(2699, 16, 43), true);
    }

    public static boolean A2F(Context context) {
        return A0R(context).A2Z(A0S(4418, 48, 121), false);
    }

    public static boolean A2G(Context context) {
        return A0R(context).A2Z(A0S(4533, 23, 122), true);
    }

    public static boolean A2H(Context context) {
        return A0R(context).A2Z(A0S(1862, 18, 34), false);
    }

    public static boolean A2I(Context context) {
        return A0R(context).A2Z(A0S(1880, 40, 117), false);
    }

    public static boolean A2J(Context context) {
        return A0R(context).A2Z(A0S(4556, 36, 62), false);
    }

    public static boolean A2K(Context context) {
        return A0R(context).A2Z(A0S(4592, 41, 81), true);
    }

    public static boolean A2L(Context context) {
        return A0R(context).A2Z(A0S(4633, 22, 109), false);
    }

    public static boolean A2M(Context context) {
        return A0R(context).A2Z(A0S(1189, 39, 55), false);
    }

    public static boolean A2N(Context context) {
        return A0R(context).A2Z(A0S(4901, 24, 27), false);
    }

    public static boolean A2O(Context context) {
        return A0R(context).A2Z(A0S(4680, 26, 86), true);
    }

    public static boolean A2P(Context context) {
        return A0R(context).A2Z(A0S(1920, 40, 108), true);
    }

    public static boolean A2Q(Context context, boolean z2) {
        return A2S(context, z2) && A0R(context).A2Z(A0S(2489, 27, 96), false);
    }

    public static boolean A2R(Context context, boolean z2) {
        return Build.VERSION.SDK_INT >= 21 && A2Q(context, z2) && A0R(context).A2Z(A0S(2516, 35, 69), true);
    }

    public static boolean A2S(Context context, boolean z2) {
        return z2 && Build.VERSION.SDK_INT >= 19 && A0R(context).A2Z(A0S(2551, 24, 14), false);
    }

    public final int A2T(String str, int i) {
        String string = this.A00.getString(str, String.valueOf(i));
        if (string != null) {
            try {
                String value = A0S(4983, 4, 81);
                if (string.equals(value)) {
                    return i;
                }
                i = Integer.parseInt(string);
                return i;
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i;
    }

    public final long A2U(String str, long j2) {
        String string = this.A00.getString(str, String.valueOf(j2));
        if (string != null) {
            try {
                String value = A0S(4983, 4, 81);
                if (string.equals(value)) {
                    return j2;
                }
                j2 = Long.parseLong(string);
                return j2;
            } catch (NumberFormatException unused) {
                return j2;
            }
        }
        return j2;
    }

    public final String A2V(String str, String str2) {
        String string = this.A00.getString(str, str2);
        if (string != null) {
            String value = A0S(4983, 4, 81);
            return string.equals(value) ? str2 : string;
        }
        return str2;
    }

    public final void A2W(String str) {
        this.A00.edit().remove(str).apply();
    }

    public final void A2X(String str) throws JSONException {
        A0b(str, null);
    }

    public final void A2Y(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        A0c(jSONObject, null);
    }

    public final boolean A2Z(String str, boolean z2) {
        String string = this.A00.getString(str, String.valueOf(z2));
        if (string != null) {
            String value = A0S(4983, 4, 81);
            boolean equals = string.equals(value);
            if (A03[5].charAt(10) != 'g') {
                throw new RuntimeException();
            }
            A03[7] = "2ZyfpebDvRtNljKwQKDVcWpHPVLB6mST";
            return equals ? z2 : Boolean.parseBoolean(string);
        }
        return z2;
    }
}
