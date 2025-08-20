package ha;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import e4.f3;
import m1.m;
import v5.r;
import v5.rz;
import z0.x4;
/* loaded from: classes.dex */
public final class s {
    public static final String[] y = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    @Nullable
    public static MdtaMetadataEntry a(rz rzVar, int i, String str) {
        while (true) {
            int a2 = rzVar.a();
            if (a2 < i) {
                int p2 = rzVar.p();
                if (rzVar.p() == 1684108385) {
                    int p3 = rzVar.p();
                    int p4 = rzVar.p();
                    int i5 = p2 - 16;
                    byte[] bArr = new byte[i5];
                    rzVar.t(bArr, 0, i5);
                    return new MdtaMetadataEntry(str, bArr, p4, p3);
                }
                rzVar.oz(a2 + p2);
            } else {
                return null;
            }
        }
    }

    @Nullable
    public static Id3Frame c5(int i, String str, rz rzVar, boolean z2, boolean z3) {
        int i92 = i9(rzVar);
        if (z3) {
            i92 = Math.min(1, i92);
        }
        if (i92 >= 0) {
            if (z2) {
                return new TextInformationFrame(str, null, x4.o(Integer.toString(i92)));
            }
            return new CommentFrame("und", str, Integer.toString(i92));
        }
        r.c5("MetadataUtil", "Failed to parse uint8 attribute: " + y.y(i));
        return null;
    }

    public static void f(int i, f3 f3Var, m.n3 n3Var) {
        if (i == 1 && f3Var.y()) {
            n3Var.hw(f3Var.y).j5(f3Var.f7502n3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.metadata.id3.TextInformationFrame fb(v5.rz r3) {
        /*
            int r3 = i9(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = ha.s.y
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L20
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            z0.x4 r3 = z0.x4.o(r3)
            r1.<init>(r2, r0, r3)
            return r1
        L20:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            v5.r.c5(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ha.s.fb(v5.rz):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    @Nullable
    public static TextInformationFrame gv(int i, String str, rz rzVar) {
        int p2 = rzVar.p();
        if (rzVar.p() == 1684108385 && p2 >= 22) {
            rzVar.ut(10);
            int yt2 = rzVar.yt();
            if (yt2 > 0) {
                String str2 = "" + yt2;
                int yt3 = rzVar.yt();
                if (yt3 > 0) {
                    str2 = str2 + "/" + yt3;
                }
                return new TextInformationFrame(str, null, x4.o(str2));
            }
        }
        r.c5("MetadataUtil", "Failed to parse index/count attribute: " + y.y(i));
        return null;
    }

    public static int i9(rz rzVar) {
        rzVar.ut(4);
        if (rzVar.p() == 1684108385) {
            rzVar.ut(8);
            return rzVar.ej();
        }
        r.c5("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    @Nullable
    public static ApicFrame n3(rz rzVar) {
        String str;
        int p2 = rzVar.p();
        if (rzVar.p() == 1684108385) {
            int n32 = y.n3(rzVar.p());
            if (n32 == 13) {
                str = "image/jpeg";
            } else if (n32 == 14) {
                str = "image/png";
            } else {
                str = null;
            }
            if (str == null) {
                r.c5("MetadataUtil", "Unrecognized cover art flags: " + n32);
                return null;
            }
            rzVar.ut(4);
            int i = p2 - 16;
            byte[] bArr = new byte[i];
            rzVar.t(bArr, 0, i);
            return new ApicFrame(str, null, 3, bArr);
        }
        r.c5("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    @Nullable
    public static TextInformationFrame s(int i, String str, rz rzVar) {
        int p2 = rzVar.p();
        if (rzVar.p() == 1684108385) {
            rzVar.ut(8);
            return new TextInformationFrame(str, null, x4.o(rzVar.rz(p2 - 16)));
        }
        r.c5("MetadataUtil", "Failed to parse text attribute: " + y.y(i));
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
        if (r6 != null) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void t(int r5, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata r6, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata r7, m1.m.n3 r8, com.google.android.exoplayer2.metadata.Metadata... r9) {
        /*
            com.google.android.exoplayer2.metadata.Metadata r0 = new com.google.android.exoplayer2.metadata.Metadata
            r1 = 0
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r2 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r1]
            r0.<init>(r2)
            r2 = 1
            if (r5 != r2) goto Le
            if (r6 == 0) goto L3b
            goto L3c
        Le:
            r6 = 2
            if (r5 != r6) goto L3b
            if (r7 == 0) goto L3b
            r5 = 0
        L14:
            int r6 = r7.v()
            if (r5 >= r6) goto L3b
            com.google.android.exoplayer2.metadata.Metadata$Entry r6 = r7.gv(r5)
            boolean r3 = r6 instanceof com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry r6 = (com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry) r6
            java.lang.String r3 = r6.y
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.Metadata r5 = new com.google.android.exoplayer2.metadata.Metadata
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r7 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r2]
            r7[r1] = r6
            r5.<init>(r7)
            r6 = r5
            goto L3c
        L39:
            int r5 = r5 + r2
            goto L14
        L3b:
            r6 = r0
        L3c:
            int r5 = r9.length
        L3d:
            if (r1 >= r5) goto L47
            r7 = r9[r1]
            com.google.android.exoplayer2.metadata.Metadata r6 = r6.n3(r7)
            int r1 = r1 + r2
            goto L3d
        L47:
            int r5 = r6.v()
            if (r5 <= 0) goto L50
            r8.en(r6)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ha.s.t(int, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.metadata.Metadata, m1.m$n3, com.google.android.exoplayer2.metadata.Metadata[]):void");
    }

    @Nullable
    public static Id3Frame v(rz rzVar, int i) {
        String str = null;
        String str2 = null;
        int i5 = -1;
        int i6 = -1;
        while (rzVar.a() < i) {
            int a2 = rzVar.a();
            int p2 = rzVar.p();
            int p3 = rzVar.p();
            rzVar.ut(4);
            if (p3 == 1835360622) {
                str = rzVar.rz(p2 - 12);
            } else if (p3 == 1851878757) {
                str2 = rzVar.rz(p2 - 12);
            } else {
                if (p3 == 1684108385) {
                    i5 = a2;
                    i6 = p2;
                }
                rzVar.ut(p2 - 12);
            }
        }
        if (str == null || str2 == null || i5 == -1) {
            return null;
        }
        rzVar.oz(i5);
        rzVar.ut(16);
        return new InternalFrame(str, str2, rzVar.rz(i6 - 16));
    }

    @Nullable
    public static CommentFrame y(int i, rz rzVar) {
        int p2 = rzVar.p();
        if (rzVar.p() == 1684108385) {
            rzVar.ut(8);
            String rz2 = rzVar.rz(p2 - 16);
            return new CommentFrame("und", rz2, rz2);
        }
        r.c5("MetadataUtil", "Failed to parse comment attribute: " + y.y(i));
        return null;
    }

    @Nullable
    public static Metadata.Entry zn(rz rzVar) {
        int a2 = rzVar.a() + rzVar.p();
        int p2 = rzVar.p();
        int i = (p2 >> 24) & 255;
        try {
            if (i != 169 && i != 253) {
                if (p2 == 1735291493) {
                    return fb(rzVar);
                }
                if (p2 == 1684632427) {
                    return gv(p2, "TPOS", rzVar);
                }
                if (p2 == 1953655662) {
                    return gv(p2, "TRCK", rzVar);
                }
                if (p2 == 1953329263) {
                    return c5(p2, "TBPM", rzVar, true, false);
                }
                if (p2 == 1668311404) {
                    return c5(p2, "TCMP", rzVar, true, true);
                }
                if (p2 == 1668249202) {
                    return n3(rzVar);
                }
                if (p2 == 1631670868) {
                    return s(p2, "TPE2", rzVar);
                }
                if (p2 == 1936682605) {
                    return s(p2, "TSOT", rzVar);
                }
                if (p2 == 1936679276) {
                    return s(p2, "TSO2", rzVar);
                }
                if (p2 == 1936679282) {
                    return s(p2, "TSOA", rzVar);
                }
                if (p2 == 1936679265) {
                    return s(p2, "TSOP", rzVar);
                }
                if (p2 == 1936679791) {
                    return s(p2, "TSOC", rzVar);
                }
                if (p2 == 1920233063) {
                    return c5(p2, "ITUNESADVISORY", rzVar, false, false);
                }
                if (p2 == 1885823344) {
                    return c5(p2, "ITUNESGAPLESS", rzVar, false, true);
                }
                if (p2 == 1936683886) {
                    return s(p2, "TVSHOWSORT", rzVar);
                }
                if (p2 == 1953919848) {
                    return s(p2, "TVSHOW", rzVar);
                }
                if (p2 == 757935405) {
                    return v(rzVar, a2);
                }
            } else {
                int i5 = 16777215 & p2;
                if (i5 == 6516084) {
                    return y(p2, rzVar);
                }
                if (i5 != 7233901 && i5 != 7631467) {
                    if (i5 != 6516589 && i5 != 7828084) {
                        if (i5 == 6578553) {
                            return s(p2, "TDRC", rzVar);
                        }
                        if (i5 == 4280916) {
                            return s(p2, "TPE1", rzVar);
                        }
                        if (i5 == 7630703) {
                            return s(p2, "TSSE", rzVar);
                        }
                        if (i5 == 6384738) {
                            return s(p2, "TALB", rzVar);
                        }
                        if (i5 == 7108978) {
                            return s(p2, "USLT", rzVar);
                        }
                        if (i5 == 6776174) {
                            return s(p2, "TCON", rzVar);
                        }
                        if (i5 == 6779504) {
                            return s(p2, "TIT1", rzVar);
                        }
                    } else {
                        return s(p2, "TCOM", rzVar);
                    }
                } else {
                    return s(p2, "TIT2", rzVar);
                }
            }
            r.n3("MetadataUtil", "Skipped unknown metadata entry: " + y.y(p2));
            rzVar.oz(a2);
            return null;
        } finally {
            rzVar.oz(a2);
        }
    }
}
