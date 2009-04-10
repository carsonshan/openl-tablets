/* ====================================================================
 Copyright 2002-2004   Apache Software Foundation

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ==================================================================== */

package org.apache.poi.hwpf.model;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.apache.poi.hwpf.usermodel.CharacterProperties;
import org.apache.poi.hwpf.usermodel.ParagraphProperties;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndianConsts;

/**
 * Comment me
 *
 * @author Ryan Ackley
 */

public class StyleDescription implements HDFType {

    private final static int PARAGRAPH_STYLE = 1;
    private final static int CHARACTER_STYLE = 2;

    private static BitField _sti = new BitField(0xfff);
    private static BitField _fScratch = new BitField(0x1000);
    private static BitField _fInvalHeight = new BitField(0x2000);
    private static BitField _fHasUpe = new BitField(0x4000);
    private static BitField _fMassCopy = new BitField(0x8000);
    private static BitField _styleTypeCode = new BitField(0xf);
    private static BitField _baseStyle = new BitField(0xfff0);
    private static BitField _numUPX = new BitField(0xf);
    private static BitField _nextStyle = new BitField(0xfff0);
    private static BitField _fAutoRedef = new BitField(0x1);
    private static BitField _fHidden = new BitField(0x2);
    private int _istd;
    private int _baseLength;
    private short _infoShort;
    private short _infoShort2;
    private short _infoShort3;
    private short _bchUpe;
    private short _infoShort4;

    UPX[] _upxs;
    String _name;
    ParagraphProperties _pap;
    CharacterProperties _chp;

    public StyleDescription() {
        // _pap = new ParagraphProperties();
        // _chp = new CharacterProperties();
    }

    public StyleDescription(byte[] std, int baseLength, int offset, boolean word9) {
        _baseLength = baseLength;
        int nameStart = offset + baseLength;
        _infoShort = LittleEndian.getShort(std, offset);
        offset += LittleEndianConsts.SHORT_SIZE;
        _infoShort2 = LittleEndian.getShort(std, offset);
        offset += LittleEndianConsts.SHORT_SIZE;
        _infoShort3 = LittleEndian.getShort(std, offset);
        offset += LittleEndianConsts.SHORT_SIZE;
        _bchUpe = LittleEndian.getShort(std, offset);
        offset += LittleEndianConsts.SHORT_SIZE;
        _infoShort4 = LittleEndian.getShort(std, offset);
        offset += LittleEndianConsts.SHORT_SIZE;

        // first byte(s) of variable length section of std is the length of the
        // style name and aliases string
        int nameLength = 0;
        int multiplier = 1;
        if (word9) {
            nameLength = LittleEndian.getShort(std, nameStart);
            multiplier = 2;
            nameStart += LittleEndianConsts.SHORT_SIZE;
        } else {
            nameLength = std[nameStart];
        }

        try {
            _name = new String(std, nameStart, nameLength * multiplier, "UTF-16LE");
        } catch (UnsupportedEncodingException ignore) {
            // ignore
        }

        // length then null terminator.
        int grupxStart = ((nameLength + 1) * multiplier) + nameStart;

        // the spec only refers to two possible upxs but it mentions
        // that more may be added in the future
        int varOffset = grupxStart;
        int numUPX = _numUPX.getValue(_infoShort3);
        _upxs = new UPX[numUPX];
        for (int x = 0; x < numUPX; x++) {
            int upxSize = LittleEndian.getShort(std, varOffset);
            varOffset += LittleEndianConsts.SHORT_SIZE;

            byte[] upx = new byte[upxSize];
            System.arraycopy(std, varOffset, upx, 0, upxSize);
            _upxs[x] = new UPX(upx);
            varOffset += upxSize;

            // the upx will always start on a word boundary.
            if (upxSize % 2 == 1) {
                ++varOffset;
            }

        }

    }

    @Override
    public boolean equals(Object o) {
        StyleDescription sd = (StyleDescription) o;
        if (sd._infoShort == _infoShort && sd._infoShort2 == _infoShort2 && sd._infoShort3 == _infoShort3
                && sd._bchUpe == _bchUpe && sd._infoShort4 == _infoShort4 && _name.equals(sd._name)) {

            if (!Arrays.equals(_upxs, sd._upxs)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getBaseStyle() {
        return _baseStyle.getValue(_infoShort2);
    }

    public CharacterProperties getCHP() {
        return _chp;
    }

    public byte[] getCHPX() {
        switch (_styleTypeCode.getValue(_infoShort2)) {
            case PARAGRAPH_STYLE:
                if (_upxs.length > 1) {
                    return _upxs[1].getUPX();
                }
                return null;
            case CHARACTER_STYLE:
                return _upxs[0].getUPX();
            default:
                return null;
        }

    }

    public String getName() {
        return _name;
    }

    public ParagraphProperties getPAP() {
        return _pap;
    }

    public byte[] getPAPX() {
        switch (_styleTypeCode.getValue(_infoShort2)) {
            case PARAGRAPH_STYLE:
                return _upxs[0].getUPX();
            default:
                return null;
        }
    }

    void setCHP(CharacterProperties chp) {
        _chp = chp;
    }

    void setPAP(ParagraphProperties pap) {
        _pap = pap;
    }

    public byte[] toByteArray() {
        // size equals _baseLength bytes for known variables plus 2 bytes for
        // name
        // length plus name length * 2 plus 2 bytes for null plus upx's preceded
        // by
        // length
        int size = _baseLength + 2 + ((_name.length() + 1) * 2);

        // determine the size needed for the upxs. They always fall on word
        // boundaries.
        size += _upxs[0].size() + 2;
        for (int x = 1; x < _upxs.length; x++) {
            size += _upxs[x - 1].size() % 2;
            size += _upxs[x].size() + 2;
        }

        byte[] buf = new byte[size];

        int offset = 0;
        LittleEndian.putShort(buf, offset, _infoShort);
        offset += LittleEndianConsts.SHORT_SIZE;
        LittleEndian.putShort(buf, offset, _infoShort2);
        offset += LittleEndianConsts.SHORT_SIZE;
        LittleEndian.putShort(buf, offset, _infoShort3);
        offset += LittleEndianConsts.SHORT_SIZE;
        LittleEndian.putShort(buf, offset, _bchUpe);
        offset += LittleEndianConsts.SHORT_SIZE;
        LittleEndian.putShort(buf, offset, _infoShort4);
        offset = _baseLength;

        char[] letters = _name.toCharArray();
        LittleEndian.putShort(buf, _baseLength, (short) letters.length);
        offset += LittleEndianConsts.SHORT_SIZE;
        for (int x = 0; x < letters.length; x++) {
            LittleEndian.putShort(buf, offset, (short) letters[x]);
            offset += LittleEndianConsts.SHORT_SIZE;
        }
        // get past the null delimiter for the name.
        offset += LittleEndianConsts.SHORT_SIZE;

        for (int x = 0; x < _upxs.length; x++) {
            short upxSize = (short) _upxs[x].size();
            LittleEndian.putShort(buf, offset, upxSize);
            offset += LittleEndianConsts.SHORT_SIZE;
            System.arraycopy(_upxs[x].getUPX(), 0, buf, offset, upxSize);
            offset += upxSize + (upxSize % 2);
        }

        return buf;
    }
}
