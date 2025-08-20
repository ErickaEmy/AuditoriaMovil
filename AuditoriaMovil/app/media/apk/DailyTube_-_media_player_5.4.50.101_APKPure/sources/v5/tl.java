package v5;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class tl {
    public static int n3(Map<String, List<String>> map) {
        String str;
        List<String> list = map.get("Content-Type");
        if (list != null && !list.isEmpty()) {
            str = list.get(0);
        } else {
            str = null;
        }
        return y(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int y(@Nullable String str) {
        char c2;
        if (str == null) {
            return -1;
        }
        String z2 = n.z(str);
        z2.hashCode();
        switch (z2.hashCode()) {
            case -2123537834:
                if (z2.equals("audio/eac3-joc")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1662384011:
                if (z2.equals("video/mp2p")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1662384007:
                if (z2.equals("video/mp2t")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1662095187:
                if (z2.equals("video/webm")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1606874997:
                if (z2.equals("audio/amr-wb")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1487394660:
                if (z2.equals("image/jpeg")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1248337486:
                if (z2.equals("application/mp4")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -1079884372:
                if (z2.equals("video/x-msvideo")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -1004728940:
                if (z2.equals("text/vtt")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -387023398:
                if (z2.equals("audio/x-matroska")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -43467528:
                if (z2.equals("application/webm")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 13915911:
                if (z2.equals("video/x-flv")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 187078296:
                if (z2.equals("audio/ac3")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 187078297:
                if (z2.equals("audio/ac4")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case 187078669:
                if (z2.equals("audio/amr")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case 187090232:
                if (z2.equals("audio/mp4")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case 187091926:
                if (z2.equals("audio/ogg")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case 187099443:
                if (z2.equals("audio/wav")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case 1331848029:
                if (z2.equals("video/mp4")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case 1503095341:
                if (z2.equals("audio/3gpp")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case 1504578661:
                if (z2.equals("audio/eac3")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            case 1504619009:
                if (z2.equals("audio/flac")) {
                    c2 = 21;
                    break;
                }
                c2 = 65535;
                break;
            case 1504824762:
                if (z2.equals("audio/midi")) {
                    c2 = 22;
                    break;
                }
                c2 = 65535;
                break;
            case 1504831518:
                if (z2.equals("audio/mpeg")) {
                    c2 = 23;
                    break;
                }
                c2 = 65535;
                break;
            case 1505118770:
                if (z2.equals("audio/webm")) {
                    c2 = 24;
                    break;
                }
                c2 = 65535;
                break;
            case 2039520277:
                if (z2.equals("video/x-matroska")) {
                    c2 = 25;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case '\f':
            case 20:
                return 0;
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
            case '\t':
            case '\n':
            case 24:
            case 25:
                return 6;
            case 4:
            case 14:
            case 19:
                return 3;
            case 5:
                return 14;
            case 6:
            case 15:
            case 18:
                return 8;
            case 7:
                return 16;
            case '\b':
                return 13;
            case 11:
                return 5;
            case '\r':
                return 1;
            case 16:
                return 9;
            case 17:
                return 12;
            case 21:
                return 4;
            case 22:
                return 15;
            case 23:
                return 7;
            default:
                return -1;
        }
    }

    public static int zn(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (!lastPathSegment.endsWith(".ac3") && !lastPathSegment.endsWith(".ec3")) {
            if (lastPathSegment.endsWith(".ac4")) {
                return 1;
            }
            if (!lastPathSegment.endsWith(".adts") && !lastPathSegment.endsWith(".aac")) {
                if (lastPathSegment.endsWith(".amr")) {
                    return 3;
                }
                if (lastPathSegment.endsWith(".flac")) {
                    return 4;
                }
                if (lastPathSegment.endsWith(".flv")) {
                    return 5;
                }
                if (!lastPathSegment.endsWith(".mid") && !lastPathSegment.endsWith(".midi") && !lastPathSegment.endsWith(".smf")) {
                    if (!lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) && !lastPathSegment.endsWith(".webm")) {
                        if (lastPathSegment.endsWith(".mp3")) {
                            return 7;
                        }
                        if (!lastPathSegment.endsWith(".mp4") && !lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) && !lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) && !lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
                            if (!lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) && !lastPathSegment.endsWith(".opus")) {
                                if (!lastPathSegment.endsWith(".ps") && !lastPathSegment.endsWith(".mpeg") && !lastPathSegment.endsWith(".mpg") && !lastPathSegment.endsWith(".m2p")) {
                                    if (!lastPathSegment.endsWith(".ts") && !lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
                                        if (!lastPathSegment.endsWith(".wav") && !lastPathSegment.endsWith(".wave")) {
                                            if (!lastPathSegment.endsWith(".vtt") && !lastPathSegment.endsWith(".webvtt")) {
                                                if (!lastPathSegment.endsWith(".jpg") && !lastPathSegment.endsWith(".jpeg")) {
                                                    if (!lastPathSegment.endsWith(".avi")) {
                                                        return -1;
                                                    }
                                                    return 16;
                                                }
                                                return 14;
                                            }
                                            return 13;
                                        }
                                        return 12;
                                    }
                                    return 11;
                                }
                                return 10;
                            }
                            return 9;
                        }
                        return 8;
                    }
                    return 6;
                }
                return 15;
            }
            return 2;
        }
        return 0;
    }
}
