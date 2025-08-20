package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;
/* loaded from: classes2.dex */
public class GF2nONBField extends GF2nField {
    private static final int MAXLONG = 64;
    private int mBit;
    private int mLength;
    int[][] mMult;
    private int mType;

    public GF2nONBField(int i, SecureRandom secureRandom) throws RuntimeException {
        super(secureRandom);
        if (i < 3) {
            throw new IllegalArgumentException("k must be at least 3");
        }
        this.mDegree = i;
        int i2 = i / 64;
        this.mLength = i2;
        int i3 = i & 63;
        this.mBit = i3;
        if (i3 == 0) {
            this.mBit = 64;
        } else {
            this.mLength = i2 + 1;
        }
        computeType();
        if (this.mType >= 3) {
            throw new RuntimeException("\nThe type of this field is " + this.mType);
        }
        this.mMult = (int[][]) Array.newInstance(Integer.TYPE, this.mDegree, 2);
        for (int i4 = 0; i4 < this.mDegree; i4++) {
            int[] iArr = this.mMult[i4];
            iArr[0] = -1;
            iArr[1] = -1;
        }
        computeMultMatrix();
        computeFieldPolynomial();
        this.fields = new java.util.Vector();
        this.matrices = new java.util.Vector();
    }

    private void computeMultMatrix() {
        int i;
        int i2 = this.mType;
        if ((i2 & 7) == 0) {
            throw new RuntimeException("bisher nur fuer Gausssche Normalbasen implementiert");
        }
        int i3 = this.mDegree * i2;
        int i4 = i3 + 1;
        int[] iArr = new int[i4];
        int elementOfOrder = i2 == 1 ? 1 : i2 == 2 ? i3 : elementOfOrder(i2, i4);
        int i5 = 1;
        int i6 = 0;
        while (true) {
            i = this.mType;
            if (i6 >= i) {
                break;
            }
            int i7 = i5;
            for (int i8 = 0; i8 < this.mDegree; i8++) {
                iArr[i7] = i8;
                i7 = (i7 << 1) % i4;
                if (i7 < 0) {
                    i7 += i4;
                }
            }
            i5 = (i5 * elementOfOrder) % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            i6++;
        }
        if (i != 1) {
            if (i != 2) {
                throw new RuntimeException("only type 1 or type 2 implemented");
            }
            int i9 = 1;
            while (i9 < i3) {
                int i10 = i9 + 1;
                int[] iArr2 = this.mMult[iArr[i10]];
                int i11 = i4 - i9;
                if (iArr2[0] == -1) {
                    iArr2[0] = iArr[i11];
                } else {
                    iArr2[1] = iArr[i11];
                }
                i9 = i10;
            }
            return;
        }
        int i12 = 1;
        while (i12 < i3) {
            int i13 = i12 + 1;
            int[] iArr3 = this.mMult[iArr[i13]];
            int i14 = i4 - i12;
            if (iArr3[0] == -1) {
                iArr3[0] = iArr[i14];
            } else {
                iArr3[1] = iArr[i14];
            }
            i12 = i13;
        }
        int i15 = this.mDegree >> 1;
        for (int i16 = 1; i16 <= i15; i16++) {
            int[][] iArr4 = this.mMult;
            int i17 = i16 - 1;
            int[] iArr5 = iArr4[i17];
            if (iArr5[0] == -1) {
                iArr5[0] = (i15 + i16) - 1;
            } else {
                iArr5[1] = (i15 + i16) - 1;
            }
            int[] iArr6 = iArr4[(i15 + i16) - 1];
            if (iArr6[0] == -1) {
                iArr6[0] = i17;
            } else {
                iArr6[1] = i17;
            }
        }
    }

    private void computeType() throws RuntimeException {
        if ((this.mDegree & 7) == 0) {
            throw new RuntimeException("The extension degree is divisible by 8!");
        }
        this.mType = 1;
        int i = 0;
        while (i != 1) {
            int i2 = (this.mType * this.mDegree) + 1;
            if (IntegerFunctions.isPrime(i2)) {
                int order = IntegerFunctions.order(2, i2);
                int i3 = this.mType;
                int i4 = this.mDegree;
                i = IntegerFunctions.gcd((i3 * i4) / order, i4);
            }
            this.mType++;
        }
        int i5 = this.mType - 1;
        this.mType = i5;
        if (i5 == 1) {
            int i6 = (this.mDegree << 1) + 1;
            if (IntegerFunctions.isPrime(i6)) {
                int order2 = IntegerFunctions.order(2, i6);
                int i7 = this.mDegree;
                if (IntegerFunctions.gcd((i7 << 1) / order2, i7) == 1) {
                    this.mType++;
                }
            }
        }
    }

    private int elementOfOrder(int i, int i2) {
        int order;
        Random random = new Random();
        int i3 = 0;
        while (i3 == 0) {
            int i4 = i2 - 1;
            i3 = random.nextInt() % i4;
            if (i3 < 0) {
                i3 += i4;
            }
        }
        while (true) {
            order = IntegerFunctions.order(i3, i2);
            if (order % i == 0 && order != 0) {
                break;
            }
            while (i3 == 0) {
                int i5 = i2 - 1;
                i3 = random.nextInt() % i5;
                if (i3 < 0) {
                    i3 += i5;
                }
            }
        }
        int i6 = i3;
        for (int i7 = 2; i7 <= i / order; i7++) {
            i6 *= i3;
        }
        return i6;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nField
    protected void computeCOBMatrix(GF2nField gF2nField) {
        GF2nElement randomRoot;
        int i = this.mDegree;
        if (i != gF2nField.mDegree) {
            throw new IllegalArgumentException("GF2nField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
        }
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[i];
        for (int i2 = 0; i2 < this.mDegree; i2++) {
            gF2PolynomialArr[i2] = new GF2Polynomial(this.mDegree);
        }
        do {
            randomRoot = gF2nField.getRandomRoot(this.fieldPolynomial);
        } while (randomRoot.isZero());
        GF2nElement[] gF2nElementArr = new GF2nPolynomialElement[this.mDegree];
        gF2nElementArr[0] = (GF2nElement) randomRoot.clone();
        for (int i3 = 1; i3 < this.mDegree; i3++) {
            gF2nElementArr[i3] = gF2nElementArr[i3 - 1].square();
        }
        for (int i4 = 0; i4 < this.mDegree; i4++) {
            for (int i5 = 0; i5 < this.mDegree; i5++) {
                if (gF2nElementArr[i4].testBit(i5)) {
                    int i6 = this.mDegree;
                    gF2PolynomialArr[(i6 - i5) - 1].setBit((i6 - i4) - 1);
                }
            }
        }
        this.fields.addElement(gF2nField);
        this.matrices.addElement(gF2PolynomialArr);
        gF2nField.fields.addElement(this);
        gF2nField.matrices.addElement(invertMatrix(gF2PolynomialArr));
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nField
    protected void computeFieldPolynomial() {
        GF2Polynomial gF2Polynomial;
        int i = this.mType;
        if (i == 1) {
            gF2Polynomial = new GF2Polynomial(this.mDegree + 1, "ALL");
        } else if (i != 2) {
            return;
        } else {
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.mDegree + 1, "ONE");
            GF2Polynomial gF2Polynomial3 = new GF2Polynomial(this.mDegree + 1, "X");
            gF2Polynomial3.addToThis(gF2Polynomial2);
            GF2Polynomial gF2Polynomial4 = gF2Polynomial2;
            gF2Polynomial = gF2Polynomial3;
            int i2 = 1;
            while (i2 < this.mDegree) {
                GF2Polynomial shiftLeft = gF2Polynomial.shiftLeft();
                shiftLeft.addToThis(gF2Polynomial4);
                i2++;
                gF2Polynomial4 = gF2Polynomial;
                gF2Polynomial = shiftLeft;
            }
        }
        this.fieldPolynomial = gF2Polynomial;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getONBBit() {
        return this.mBit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getONBLength() {
        return this.mLength;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nField
    protected GF2nElement getRandomRoot(GF2Polynomial gF2Polynomial) {
        GF2nPolynomial gcd;
        int degree;
        int degree2;
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(gF2Polynomial, this);
        while (gF2nPolynomial.getDegree() > 1) {
            while (true) {
                GF2nONBElement gF2nONBElement = new GF2nONBElement(this, this.random);
                GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(2, GF2nONBElement.ZERO(this));
                gF2nPolynomial2.set(1, gF2nONBElement);
                GF2nPolynomial gF2nPolynomial3 = new GF2nPolynomial(gF2nPolynomial2);
                for (int i = 1; i <= this.mDegree - 1; i++) {
                    gF2nPolynomial3 = gF2nPolynomial3.multiplyAndReduce(gF2nPolynomial3, gF2nPolynomial).add(gF2nPolynomial2);
                }
                gcd = gF2nPolynomial3.gcd(gF2nPolynomial);
                degree = gcd.getDegree();
                degree2 = gF2nPolynomial.getDegree();
                if (degree != 0 && degree != degree2) {
                    break;
                }
            }
            gF2nPolynomial = (degree << 1) > degree2 ? gF2nPolynomial.quotient(gcd) : new GF2nPolynomial(gcd);
        }
        return gF2nPolynomial.at(0);
    }

    int[][] invMatrix(int[][] iArr) {
        int i = this.mDegree;
        Class cls = Integer.TYPE;
        int[][] iArr2 = (int[][]) Array.newInstance(cls, i, i);
        int i2 = this.mDegree;
        int[][] iArr3 = (int[][]) Array.newInstance(cls, i2, i2);
        for (int i3 = 0; i3 < this.mDegree; i3++) {
            iArr3[i3][i3] = 1;
        }
        for (int i4 = 0; i4 < this.mDegree; i4++) {
            int i5 = i4;
            while (true) {
                int i6 = this.mDegree;
                if (i5 < i6) {
                    iArr[(i6 - 1) - i4][i5] = iArr[i4][i4];
                    i5++;
                }
            }
        }
        return null;
    }
}
