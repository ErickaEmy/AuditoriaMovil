package javax.jmdns.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
/* loaded from: classes.dex */
public final class DNSOutgoing extends DNSMessage {
    public static boolean USE_DOMAIN_NAME_COMPRESSION = true;
    private final MessageOutputStream _additionalsAnswersBytes;
    private final MessageOutputStream _answersBytes;
    private final MessageOutputStream _authoritativeAnswersBytes;
    private InetSocketAddress _destination;
    private int _maxUDPPayload;
    Map _names;
    private final MessageOutputStream _questionsBytes;

    public InetSocketAddress getDestination() {
        return this._destination;
    }

    public int getMaxUDPPayload() {
        return this._maxUDPPayload;
    }

    public void setDestination(InetSocketAddress inetSocketAddress) {
        this._destination = inetSocketAddress;
    }

    /* loaded from: classes.dex */
    public static class MessageOutputStream extends ByteArrayOutputStream {
        private final int _offset;
        private final DNSOutgoing _out;

        MessageOutputStream(int i, DNSOutgoing dNSOutgoing) {
            this(i, dNSOutgoing, 0);
        }

        MessageOutputStream(int i, DNSOutgoing dNSOutgoing, int i2) {
            super(i);
            this._out = dNSOutgoing;
            this._offset = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeByte(int i) {
            write(i & GF2Field.MASK);
        }

        void writeBytes(byte[] bArr) {
            if (bArr != null) {
                writeBytes(bArr, 0, bArr.length);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeBytes(byte[] bArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                writeByte(bArr[i + i3]);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeShort(int i) {
            writeByte(i >> 8);
            writeByte(i);
        }

        void writeInt(int i) {
            writeShort(i >> 16);
            writeShort(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeUTF(String str, int i, int i2) {
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                char charAt = str.charAt(i + i4);
                i3 = (charAt < 1 || charAt > 127) ? charAt > 2047 ? i3 + 3 : i3 + 2 : i3 + 1;
            }
            writeByte(i3);
            for (int i5 = 0; i5 < i2; i5++) {
                char charAt2 = str.charAt(i + i5);
                if (charAt2 >= 1 && charAt2 <= 127) {
                    writeByte(charAt2);
                } else if (charAt2 > 2047) {
                    writeByte(((charAt2 >> '\f') & 15) | BERTags.FLAGS);
                    writeByte(((charAt2 >> 6) & 63) | 128);
                    writeByte((charAt2 & '?') | 128);
                } else {
                    writeByte(((charAt2 >> 6) & 31) | 192);
                    writeByte((charAt2 & '?') | 128);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeName(String str) {
            writeName(str, true);
        }

        void writeName(String str, boolean z) {
            while (true) {
                int indexOf = str.indexOf(46);
                if (indexOf < 0) {
                    indexOf = str.length();
                }
                if (indexOf <= 0) {
                    writeByte(0);
                    return;
                }
                String substring = str.substring(0, indexOf);
                if (z && DNSOutgoing.USE_DOMAIN_NAME_COMPRESSION) {
                    Integer num = (Integer) this._out._names.get(str);
                    if (num != null) {
                        int intValue = num.intValue();
                        writeByte((intValue >> 8) | 192);
                        writeByte(intValue & GF2Field.MASK);
                        return;
                    }
                    this._out._names.put(str, Integer.valueOf(size() + this._offset));
                    writeUTF(substring, 0, substring.length());
                } else {
                    writeUTF(substring, 0, substring.length());
                }
                str = str.substring(indexOf);
                if (str.startsWith(".")) {
                    str = str.substring(1);
                }
            }
        }

        void writeQuestion(DNSQuestion dNSQuestion) {
            writeName(dNSQuestion.getName());
            writeShort(dNSQuestion.getRecordType().indexValue());
            writeShort(dNSQuestion.getRecordClass().indexValue());
        }

        void writeRecord(DNSRecord dNSRecord, long j) {
            writeName(dNSRecord.getName());
            writeShort(dNSRecord.getRecordType().indexValue());
            writeShort(dNSRecord.getRecordClass().indexValue() | ((dNSRecord.isUnique() && this._out.isMulticast()) ? 32768 : 0));
            writeInt(j == 0 ? dNSRecord.getTTL() : dNSRecord.getRemainingTTL(j));
            MessageOutputStream messageOutputStream = new MessageOutputStream(512, this._out, this._offset + size() + 2);
            dNSRecord.write(messageOutputStream);
            byte[] byteArray = messageOutputStream.toByteArray();
            writeShort(byteArray.length);
            write(byteArray, 0, byteArray.length);
        }
    }

    public DNSOutgoing(int i) {
        this(i, true, 1460);
    }

    public DNSOutgoing(int i, boolean z, int i2) {
        super(i, 0, z);
        this._names = new HashMap();
        this._maxUDPPayload = i2 > 0 ? i2 : 1460;
        this._questionsBytes = new MessageOutputStream(i2, this);
        this._answersBytes = new MessageOutputStream(i2, this);
        this._authoritativeAnswersBytes = new MessageOutputStream(i2, this);
        this._additionalsAnswersBytes = new MessageOutputStream(i2, this);
    }

    public int availableSpace() {
        return ((((this._maxUDPPayload - 12) - this._questionsBytes.size()) - this._answersBytes.size()) - this._authoritativeAnswersBytes.size()) - this._additionalsAnswersBytes.size();
    }

    public void addQuestion(DNSQuestion dNSQuestion) {
        MessageOutputStream messageOutputStream = new MessageOutputStream(512, this);
        messageOutputStream.writeQuestion(dNSQuestion);
        byte[] byteArray = messageOutputStream.toByteArray();
        messageOutputStream.close();
        if (byteArray.length < availableSpace()) {
            this._questions.add(dNSQuestion);
            this._questionsBytes.write(byteArray, 0, byteArray.length);
            return;
        }
        throw new IOException("message full");
    }

    public void addAnswer(DNSIncoming dNSIncoming, DNSRecord dNSRecord) {
        if (dNSIncoming == null || !dNSRecord.suppressedBy(dNSIncoming)) {
            addAnswer(dNSRecord, 0L);
        }
    }

    public void addAnswer(DNSRecord dNSRecord, long j) {
        if (dNSRecord != null) {
            if (j == 0 || !dNSRecord.isExpired(j)) {
                MessageOutputStream messageOutputStream = new MessageOutputStream(512, this);
                messageOutputStream.writeRecord(dNSRecord, j);
                byte[] byteArray = messageOutputStream.toByteArray();
                messageOutputStream.close();
                if (byteArray.length < availableSpace()) {
                    this._answers.add(dNSRecord);
                    this._answersBytes.write(byteArray, 0, byteArray.length);
                    return;
                }
                throw new IOException("message full");
            }
        }
    }

    public void addAuthorativeAnswer(DNSRecord dNSRecord) {
        MessageOutputStream messageOutputStream = new MessageOutputStream(512, this);
        messageOutputStream.writeRecord(dNSRecord, 0L);
        byte[] byteArray = messageOutputStream.toByteArray();
        messageOutputStream.close();
        if (byteArray.length < availableSpace()) {
            this._authoritativeAnswers.add(dNSRecord);
            this._authoritativeAnswersBytes.write(byteArray, 0, byteArray.length);
            return;
        }
        throw new IOException("message full");
    }

    public byte[] data() {
        long currentTimeMillis = System.currentTimeMillis();
        this._names.clear();
        MessageOutputStream messageOutputStream = new MessageOutputStream(this._maxUDPPayload, this);
        messageOutputStream.writeShort(this._multicast ? 0 : getId());
        messageOutputStream.writeShort(getFlags());
        messageOutputStream.writeShort(getNumberOfQuestions());
        messageOutputStream.writeShort(getNumberOfAnswers());
        messageOutputStream.writeShort(getNumberOfAuthorities());
        messageOutputStream.writeShort(getNumberOfAdditionals());
        for (DNSQuestion dNSQuestion : this._questions) {
            messageOutputStream.writeQuestion(dNSQuestion);
        }
        for (DNSRecord dNSRecord : this._answers) {
            messageOutputStream.writeRecord(dNSRecord, currentTimeMillis);
        }
        for (DNSRecord dNSRecord2 : this._authoritativeAnswers) {
            messageOutputStream.writeRecord(dNSRecord2, currentTimeMillis);
        }
        for (DNSRecord dNSRecord3 : this._additionals) {
            messageOutputStream.writeRecord(dNSRecord3, currentTimeMillis);
        }
        byte[] byteArray = messageOutputStream.toByteArray();
        try {
            messageOutputStream.close();
        } catch (IOException unused) {
        }
        return byteArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isQuery() ? "dns[query:" : "dns[response:");
        sb.append(" id=0x");
        sb.append(Integer.toHexString(getId()));
        if (getFlags() != 0) {
            sb.append(", flags=0x");
            sb.append(Integer.toHexString(getFlags()));
            if (isResponse()) {
                sb.append(":r");
            }
            if (isAuthoritativeAnswer()) {
                sb.append(":aa");
            }
            if (isTruncated()) {
                sb.append(":tc");
            }
        }
        if (getNumberOfQuestions() > 0) {
            sb.append(", questions=");
            sb.append(getNumberOfQuestions());
        }
        if (getNumberOfAnswers() > 0) {
            sb.append(", answers=");
            sb.append(getNumberOfAnswers());
        }
        if (getNumberOfAuthorities() > 0) {
            sb.append(", authorities=");
            sb.append(getNumberOfAuthorities());
        }
        if (getNumberOfAdditionals() > 0) {
            sb.append(", additionals=");
            sb.append(getNumberOfAdditionals());
        }
        if (getNumberOfQuestions() > 0) {
            sb.append("\nquestions:");
            for (DNSQuestion dNSQuestion : this._questions) {
                sb.append("\n\t");
                sb.append(dNSQuestion);
            }
        }
        if (getNumberOfAnswers() > 0) {
            sb.append("\nanswers:");
            for (DNSRecord dNSRecord : this._answers) {
                sb.append("\n\t");
                sb.append(dNSRecord);
            }
        }
        if (getNumberOfAuthorities() > 0) {
            sb.append("\nauthorities:");
            for (DNSRecord dNSRecord2 : this._authoritativeAnswers) {
                sb.append("\n\t");
                sb.append(dNSRecord2);
            }
        }
        if (getNumberOfAdditionals() > 0) {
            sb.append("\nadditionals:");
            for (DNSRecord dNSRecord3 : this._additionals) {
                sb.append("\n\t");
                sb.append(dNSRecord3);
            }
        }
        sb.append("\nnames=");
        sb.append(this._names);
        sb.append("]");
        return sb.toString();
    }
}
