package com.journeyapps.barcodescanner;

import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes.dex */
public class DefaultDecoderFactory implements DecoderFactory {
    private String characterSet;
    private Collection decodeFormats;
    private Map hints;
    private int scanType;

    public DefaultDecoderFactory() {
    }

    public DefaultDecoderFactory(Collection collection, Map map, String str, int i) {
        this.decodeFormats = collection;
        this.hints = map;
        this.characterSet = str;
        this.scanType = i;
    }

    @Override // com.journeyapps.barcodescanner.DecoderFactory
    public Decoder createDecoder(Map map) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map map2 = this.hints;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection collection = this.decodeFormats;
        if (collection != null) {
            enumMap.put((EnumMap) DecodeHintType.POSSIBLE_FORMATS, (DecodeHintType) collection);
        }
        String str = this.characterSet;
        if (str != null) {
            enumMap.put((EnumMap) DecodeHintType.CHARACTER_SET, (DecodeHintType) str);
        }
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        multiFormatReader.setHints(enumMap);
        int i = this.scanType;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return new MixedDecoder(multiFormatReader);
                }
                return new Decoder(multiFormatReader);
            }
            return new InvertedDecoder(multiFormatReader);
        }
        return new Decoder(multiFormatReader);
    }
}
