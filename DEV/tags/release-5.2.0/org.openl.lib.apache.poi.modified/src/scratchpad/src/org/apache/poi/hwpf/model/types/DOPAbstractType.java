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

package org.apache.poi.hwpf.model.types;

import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.hdf.model.hdftypes.HDFType;

/**
 * Document Properties. NOTE: This source is automatically generated please do
 * not modify this file. Either subclass or remove the record in
 * src/records/definitions.
 *
 * @author S. Ryan Ackley
 */
public abstract class DOPAbstractType implements HDFType {

    private static BitField fFacingPages = new BitField(0x01);
    private static BitField fWidowControl = new BitField(0x02);
    private static BitField fPMHMainDoc = new BitField(0x04);
    private static BitField grfSupression = new BitField(0x18);
    private static BitField fpc = new BitField(0x60);
    private static BitField unused1 = new BitField(0x80);
    private static BitField rncFtn = new BitField(0x0003);
    private static BitField nFtn = new BitField(0xfffc);
    private static BitField fOnlyMacPics = new BitField(0x01);
    private static BitField fOnlyWinPics = new BitField(0x02);
    private static BitField fLabelDoc = new BitField(0x04);
    private static BitField fHyphCapitals = new BitField(0x08);
    private static BitField fAutoHyphen = new BitField(0x10);
    private static BitField fFormNoFields = new BitField(0x20);
    private static BitField fLinkStyles = new BitField(0x40);
    private static BitField fRevMarking = new BitField(0x80);
    private static BitField fBackup = new BitField(0x01);
    private static BitField fExactCWords = new BitField(0x02);
    private static BitField fPagHidden = new BitField(0x04);
    private static BitField fPagResults = new BitField(0x08);
    private static BitField fLockAtn = new BitField(0x10);
    private static BitField fMirrorMargins = new BitField(0x20);
    private static BitField unused3 = new BitField(0x40);
    private static BitField fDfltTrueType = new BitField(0x80);
    private static BitField fPagSupressTopSpacing = new BitField(0x01);
    private static BitField fProtEnabled = new BitField(0x02);
    private static BitField fDispFormFldSel = new BitField(0x04);
    private static BitField fRMView = new BitField(0x08);
    private static BitField fRMPrint = new BitField(0x10);
    private static BitField unused4 = new BitField(0x20);
    private static BitField fLockRev = new BitField(0x40);
    private static BitField fEmbedFonts = new BitField(0x80);
    private static BitField oldfNoTabForInd = new BitField(0x0001);
    private static BitField oldfNoSpaceRaiseLower = new BitField(0x0002);
    private static BitField oldfSuppressSpbfAfterPageBreak = new BitField(0x0004);
    private static BitField oldfWrapTrailSpaces = new BitField(0x0008);
    private static BitField oldfMapPrintTextColor = new BitField(0x0010);
    private static BitField oldfNoColumnBalance = new BitField(0x0020);
    private static BitField oldfConvMailMergeEsc = new BitField(0x0040);
    private static BitField oldfSupressTopSpacing = new BitField(0x0080);
    private static BitField oldfOrigWordTableRules = new BitField(0x0100);
    private static BitField oldfTransparentMetafiles = new BitField(0x0200);
    private static BitField oldfShowBreaksInFrames = new BitField(0x0400);
    private static BitField oldfSwapBordersFacingPgs = new BitField(0x0800);
    private static BitField unused5 = new BitField(0xf000);
    private static BitField rncEdn = new BitField(0x0003);
    private static BitField nEdn = new BitField(0xfffc);
    private static BitField epc = new BitField(0x0003);
    private static BitField nfcFtnRef1 = new BitField(0x003c);
    private static BitField nfcEdnRef1 = new BitField(0x03c0);
    private static BitField fPrintFormData = new BitField(0x0400);
    private static BitField fSaveFormData = new BitField(0x0800);
    private static BitField fShadeFormData = new BitField(0x1000);
    private static BitField fWCFtnEdn = new BitField(0x8000);
    private static BitField wvkSaved = new BitField(0x0007);
    private static BitField wScaleSaved = new BitField(0x0ff8);
    private static BitField zkSaved = new BitField(0x3000);
    private static BitField fRotateFontW6 = new BitField(0x4000);
    private static BitField iGutterPos = new BitField(0x8000);
    private static BitField fNoTabForInd = new BitField(0x00000001);
    private static BitField fNoSpaceRaiseLower = new BitField(0x00000002);
    private static BitField fSupressSpdfAfterPageBreak = new BitField(0x00000004);
    private static BitField fWrapTrailSpaces = new BitField(0x00000008);
    private static BitField fMapPrintTextColor = new BitField(0x00000010);
    private static BitField fNoColumnBalance = new BitField(0x00000020);
    private static BitField fConvMailMergeEsc = new BitField(0x00000040);
    private static BitField fSupressTopSpacing = new BitField(0x00000080);
    private static BitField fOrigWordTableRules = new BitField(0x00000100);
    private static BitField fTransparentMetafiles = new BitField(0x00000200);
    private static BitField fShowBreaksInFrames = new BitField(0x00000400);
    private static BitField fSwapBordersFacingPgs = new BitField(0x00000800);
    private static BitField fSuppressTopSPacingMac5 = new BitField(0x00010000);
    private static BitField fTruncDxaExpand = new BitField(0x00020000);
    private static BitField fPrintBodyBeforeHdr = new BitField(0x00040000);
    private static BitField fNoLeading = new BitField(0x00080000);
    private static BitField fMWSmallCaps = new BitField(0x00200000);
    private static BitField lvl = new BitField(0x001e);
    private static BitField fGramAllDone = new BitField(0x0020);
    private static BitField fGramAllClean = new BitField(0x0040);
    private static BitField fSubsetFonts = new BitField(0x0080);
    private static BitField fHideLastVersion = new BitField(0x0100);
    private static BitField fHtmlDoc = new BitField(0x0200);
    private static BitField fSnapBorder = new BitField(0x0800);
    private static BitField fIncludeHeader = new BitField(0x1000);
    private static BitField fIncludeFooter = new BitField(0x2000);
    private static BitField fForcePageSizePag = new BitField(0x4000);
    private static BitField fMinFontSizePag = new BitField(0x8000);
    private static BitField fHaveVersions = new BitField(0x0001);
    private static BitField fAutoVersions = new BitField(0x0002);
    private static BitField fVirusPrompted = new BitField(0x0001);
    private static BitField fVirusLoadSafe = new BitField(0x0002);
    private static BitField KeyVirusSession30 = new BitField(0xfffffffc);
    protected byte field_1_formatFlags;
    protected byte field_2_unused2;
    protected short field_3_footnoteInfo;
    protected byte field_4_fOutlineDirtySave;
    protected byte field_5_docinfo;
    protected byte field_6_docinfo1;
    protected byte field_7_docinfo2;
    protected short field_8_docinfo3;
    protected int field_9_dxaTab;
    protected int field_10_wSpare;
    protected int field_11_dxaHotz;
    protected int field_12_cConsexHypLim;
    protected int field_13_wSpare2;
    protected int field_14_dttmCreated;
    protected int field_15_dttmRevised;
    protected int field_16_dttmLastPrint;
    protected int field_17_nRevision;
    protected int field_18_tmEdited;
    protected int field_19_cWords;
    protected int field_20_cCh;
    protected int field_21_cPg;
    protected int field_22_cParas;
    protected short field_23_Edn;
    protected short field_24_Edn1;
    protected int field_25_cLines;
    protected int field_26_cWordsFtnEnd;
    protected int field_27_cChFtnEdn;
    protected short field_28_cPgFtnEdn;
    protected int field_29_cParasFtnEdn;
    protected int field_30_cLinesFtnEdn;
    protected int field_31_lKeyProtDoc;
    protected short field_32_view;
    protected int field_33_docinfo4;
    protected short field_34_adt;
    protected byte[] field_35_doptypography;
    protected byte[] field_36_dogrid;
    protected short field_37_docinfo5;
    protected short field_38_docinfo6;
    protected byte[] field_39_asumyi;
    protected int field_40_cChWS;
    protected int field_41_cChWSFtnEdn;
    protected int field_42_grfDocEvents;
    protected int field_43_virusinfo;
    protected byte[] field_44_Spare;
    protected int field_45_reserved1;
    protected int field_46_reserved2;
    protected int field_47_cDBC;
    protected int field_48_cDBCFtnEdn;
    protected int field_49_reserved;
    protected short field_50_nfcFtnRef;
    protected short field_51_nfcEdnRef;
    protected short field_52_hpsZoonFontPag;
    protected short field_53_dywDispPag;

    public DOPAbstractType() {

    }

    protected void fillFields(byte[] data, int offset) {
        field_1_formatFlags = data[0x0 + offset];
        field_2_unused2 = data[0x1 + offset];
        field_3_footnoteInfo = LittleEndian.getShort(data, 0x2 + offset);
        field_4_fOutlineDirtySave = data[0x4 + offset];
        field_5_docinfo = data[0x5 + offset];
        field_6_docinfo1 = data[0x6 + offset];
        field_7_docinfo2 = data[0x7 + offset];
        field_8_docinfo3 = LittleEndian.getShort(data, 0x8 + offset);
        field_9_dxaTab = LittleEndian.getShort(data, 0xa + offset);
        field_10_wSpare = LittleEndian.getShort(data, 0xc + offset);
        field_11_dxaHotz = LittleEndian.getShort(data, 0xe + offset);
        field_12_cConsexHypLim = LittleEndian.getShort(data, 0x10 + offset);
        field_13_wSpare2 = LittleEndian.getShort(data, 0x12 + offset);
        field_14_dttmCreated = LittleEndian.getInt(data, 0x14 + offset);
        field_15_dttmRevised = LittleEndian.getInt(data, 0x18 + offset);
        field_16_dttmLastPrint = LittleEndian.getInt(data, 0x1c + offset);
        field_17_nRevision = LittleEndian.getShort(data, 0x20 + offset);
        field_18_tmEdited = LittleEndian.getInt(data, 0x22 + offset);
        field_19_cWords = LittleEndian.getInt(data, 0x26 + offset);
        field_20_cCh = LittleEndian.getInt(data, 0x2a + offset);
        field_21_cPg = LittleEndian.getShort(data, 0x2e + offset);
        field_22_cParas = LittleEndian.getInt(data, 0x30 + offset);
        field_23_Edn = LittleEndian.getShort(data, 0x34 + offset);
        field_24_Edn1 = LittleEndian.getShort(data, 0x36 + offset);
        field_25_cLines = LittleEndian.getInt(data, 0x38 + offset);
        field_26_cWordsFtnEnd = LittleEndian.getInt(data, 0x3c + offset);
        field_27_cChFtnEdn = LittleEndian.getInt(data, 0x40 + offset);
        field_28_cPgFtnEdn = LittleEndian.getShort(data, 0x44 + offset);
        field_29_cParasFtnEdn = LittleEndian.getInt(data, 0x46 + offset);
        field_30_cLinesFtnEdn = LittleEndian.getInt(data, 0x4a + offset);
        field_31_lKeyProtDoc = LittleEndian.getInt(data, 0x4e + offset);
        field_32_view = LittleEndian.getShort(data, 0x52 + offset);
        field_33_docinfo4 = LittleEndian.getInt(data, 0x54 + offset);
        field_34_adt = LittleEndian.getShort(data, 0x58 + offset);
        field_35_doptypography = LittleEndian.getByteArray(data, 0x5a + offset, 310);
        field_36_dogrid = LittleEndian.getByteArray(data, 0x190 + offset, 10);
        field_37_docinfo5 = LittleEndian.getShort(data, 0x19a + offset);
        field_38_docinfo6 = LittleEndian.getShort(data, 0x19c + offset);
        field_39_asumyi = LittleEndian.getByteArray(data, 0x19e + offset, 12);
        field_40_cChWS = LittleEndian.getInt(data, 0x1aa + offset);
        field_41_cChWSFtnEdn = LittleEndian.getInt(data, 0x1ae + offset);
        field_42_grfDocEvents = LittleEndian.getInt(data, 0x1b2 + offset);
        field_43_virusinfo = LittleEndian.getInt(data, 0x1b6 + offset);
        field_44_Spare = LittleEndian.getByteArray(data, 0x1ba + offset, 30);
        field_45_reserved1 = LittleEndian.getInt(data, 0x1d8 + offset);
        field_46_reserved2 = LittleEndian.getInt(data, 0x1dc + offset);
        field_47_cDBC = LittleEndian.getInt(data, 0x1e0 + offset);
        field_48_cDBCFtnEdn = LittleEndian.getInt(data, 0x1e4 + offset);
        field_49_reserved = LittleEndian.getInt(data, 0x1e8 + offset);
        field_50_nfcFtnRef = LittleEndian.getShort(data, 0x1ec + offset);
        field_51_nfcEdnRef = LittleEndian.getShort(data, 0x1ee + offset);
        field_52_hpsZoonFontPag = LittleEndian.getShort(data, 0x1f0 + offset);
        field_53_dywDispPag = LittleEndian.getShort(data, 0x1f2 + offset);

    }

    /**
     * Get the adt field for the DOP record.
     */
    public short getAdt() {
        return field_34_adt;
    }

    /**
     * Get the asumyi field for the DOP record.
     */
    public byte[] getAsumyi() {
        return field_39_asumyi;
    }

    /**
     * Get the cCh field for the DOP record.
     */
    public int getCCh() {
        return field_20_cCh;
    }

    /**
     * Get the cChFtnEdn field for the DOP record.
     */
    public int getCChFtnEdn() {
        return field_27_cChFtnEdn;
    }

    /**
     * Get the cChWS field for the DOP record.
     */
    public int getCChWS() {
        return field_40_cChWS;
    }

    /**
     * Get the cChWSFtnEdn field for the DOP record.
     */
    public int getCChWSFtnEdn() {
        return field_41_cChWSFtnEdn;
    }

    /**
     * Get the cConsexHypLim field for the DOP record.
     */
    public int getCConsexHypLim() {
        return field_12_cConsexHypLim;
    }

    /**
     * Get the cDBC field for the DOP record.
     */
    public int getCDBC() {
        return field_47_cDBC;
    }

    /**
     * Get the cDBCFtnEdn field for the DOP record.
     */
    public int getCDBCFtnEdn() {
        return field_48_cDBCFtnEdn;
    }

    /**
     * Get the cLines field for the DOP record.
     */
    public int getCLines() {
        return field_25_cLines;
    }

    /**
     * Get the cLinesFtnEdn field for the DOP record.
     */
    public int getCLinesFtnEdn() {
        return field_30_cLinesFtnEdn;
    }

    /**
     * Get the cParas field for the DOP record.
     */
    public int getCParas() {
        return field_22_cParas;
    }

    /**
     * Get the cParasFtnEdn field for the DOP record.
     */
    public int getCParasFtnEdn() {
        return field_29_cParasFtnEdn;
    }

    /**
     * Get the cPg field for the DOP record.
     */
    public int getCPg() {
        return field_21_cPg;
    }

    /**
     * Get the cPgFtnEdn field for the DOP record.
     */
    public short getCPgFtnEdn() {
        return field_28_cPgFtnEdn;
    }

    /**
     * Get the cWords field for the DOP record.
     */
    public int getCWords() {
        return field_19_cWords;
    }

    /**
     * Get the cWordsFtnEnd field for the DOP record.
     */
    public int getCWordsFtnEnd() {
        return field_26_cWordsFtnEnd;
    }

    /**
     * Get the docinfo field for the DOP record.
     */
    public byte getDocinfo() {
        return field_5_docinfo;
    }

    /**
     * Get the docinfo1 field for the DOP record.
     */
    public byte getDocinfo1() {
        return field_6_docinfo1;
    }

    /**
     * Get the docinfo2 field for the DOP record.
     */
    public byte getDocinfo2() {
        return field_7_docinfo2;
    }

    /**
     * Get the docinfo3 field for the DOP record.
     */
    public short getDocinfo3() {
        return field_8_docinfo3;
    }

    /**
     * Get the docinfo4 field for the DOP record.
     */
    public int getDocinfo4() {
        return field_33_docinfo4;
    }

    /**
     * Get the docinfo5 field for the DOP record.
     */
    public short getDocinfo5() {
        return field_37_docinfo5;
    }

    /**
     * Get the docinfo6 field for the DOP record.
     */
    public short getDocinfo6() {
        return field_38_docinfo6;
    }

    /**
     * Get the dogrid field for the DOP record.
     */
    public byte[] getDogrid() {
        return field_36_dogrid;
    }

    /**
     * Get the doptypography field for the DOP record.
     */
    public byte[] getDoptypography() {
        return field_35_doptypography;
    }

    /**
     * Get the dttmCreated field for the DOP record.
     */
    public int getDttmCreated() {
        return field_14_dttmCreated;
    }

    /**
     * Get the dttmLastPrint field for the DOP record.
     */
    public int getDttmLastPrint() {
        return field_16_dttmLastPrint;
    }

    /**
     * Get the dttmRevised field for the DOP record.
     */
    public int getDttmRevised() {
        return field_15_dttmRevised;
    }

    /**
     * Get the dxaHotz field for the DOP record.
     */
    public int getDxaHotz() {
        return field_11_dxaHotz;
    }

    /**
     * Get the dxaTab field for the DOP record.
     */
    public int getDxaTab() {
        return field_9_dxaTab;
    }

    /**
     * Get the dywDispPag field for the DOP record.
     */
    public short getDywDispPag() {
        return field_53_dywDispPag;
    }

    /**
     * Get the Edn field for the DOP record.
     */
    public short getEdn() {
        return field_23_Edn;
    }

    /**
     * Get the Edn1 field for the DOP record.
     */
    public short getEdn1() {
        return field_24_Edn1;
    }

    /**
     *
     * @return the epc field value.
     */
    public byte getEpc() {
        return (byte) epc.getValue(field_24_Edn1);

    }

    /**
     * Get the footnoteInfo field for the DOP record.
     */
    public short getFootnoteInfo() {
        return field_3_footnoteInfo;
    }

    /**
     * Get the formatFlags field for the DOP record.
     */
    public byte getFormatFlags() {
        return field_1_formatFlags;
    }

    /**
     * Get the fOutlineDirtySave field for the DOP record.
     */
    public byte getFOutlineDirtySave() {
        return field_4_fOutlineDirtySave;
    }

    /**
     *
     * @return the fpc field value.
     */
    public byte getFpc() {
        return (byte) fpc.getValue(field_1_formatFlags);

    }

    /**
     * Get the grfDocEvents field for the DOP record.
     */
    public int getGrfDocEvents() {
        return field_42_grfDocEvents;
    }

    /**
     *
     * @return the grfSupression field value.
     */
    public byte getGrfSupression() {
        return (byte) grfSupression.getValue(field_1_formatFlags);

    }

    /**
     * Get the hpsZoonFontPag field for the DOP record.
     */
    public short getHpsZoonFontPag() {
        return field_52_hpsZoonFontPag;
    }

    /**
     *
     * @return the KeyVirusSession30 field value.
     */
    public int getKeyVirusSession30() {
        return KeyVirusSession30.getValue(field_43_virusinfo);

    }

    /**
     * Get the lKeyProtDoc field for the DOP record.
     */
    public int getLKeyProtDoc() {
        return field_31_lKeyProtDoc;
    }

    /**
     *
     * @return the lvl field value.
     */
    public byte getLvl() {
        return (byte) lvl.getValue(field_37_docinfo5);

    }

    /**
     *
     * @return the nEdn field value.
     */
    public short getNEdn() {
        return (short) nEdn.getValue(field_23_Edn);

    }

    /**
     * Get the nfcEdnRef field for the DOP record.
     */
    public short getNfcEdnRef() {
        return field_51_nfcEdnRef;
    }

    /**
     *
     * @return the nfcEdnRef1 field value.
     */
    public byte getNfcEdnRef1() {
        return (byte) nfcEdnRef1.getValue(field_24_Edn1);

    }

    /**
     * Get the nfcFtnRef field for the DOP record.
     */
    public short getNfcFtnRef() {
        return field_50_nfcFtnRef;
    }

    /**
     *
     * @return the nfcFtnRef1 field value.
     */
    public byte getNfcFtnRef1() {
        return (byte) nfcFtnRef1.getValue(field_24_Edn1);

    }

    /**
     *
     * @return the nFtn field value.
     */
    public short getNFtn() {
        return (short) nFtn.getValue(field_3_footnoteInfo);

    }

    /**
     * Get the nRevision field for the DOP record.
     */
    public int getNRevision() {
        return field_17_nRevision;
    }

    /**
     * Get the reserved field for the DOP record.
     */
    public int getReserved() {
        return field_49_reserved;
    }

    /**
     * Get the reserved1 field for the DOP record.
     */
    public int getReserved1() {
        return field_45_reserved1;
    }

    /**
     * Get the reserved2 field for the DOP record.
     */
    public int getReserved2() {
        return field_46_reserved2;
    }

    /**
     *
     * @return the rncEdn field value.
     */
    public byte getRncEdn() {
        return (byte) rncEdn.getValue(field_23_Edn);

    }

    /**
     *
     * @return the rncFtn field value.
     */
    public byte getRncFtn() {
        return (byte) rncFtn.getValue(field_3_footnoteInfo);

    }

    /**
     * Size of record (exluding 4 byte header)
     */
    public int getSize() {
        return 4 + +1 + 1 + 2 + 1 + 1 + 1 + 1 + 2 + 2 + 2 + 2 + 2 + 2 + 4 + 4 + 4 + 2 + 4 + 4 + 4 + 2 + 4 + 2 + 2 + 4
                + 4 + 4 + 2 + 4 + 4 + 4 + 2 + 4 + 2 + 310 + 10 + 2 + 2 + 12 + 4 + 4 + 4 + 4 + 30 + 4 + 4 + 4 + 4 + 4
                + 2 + 2 + 2 + 2;
    }

    /**
     * Get the Spare field for the DOP record.
     */
    public byte[] getSpare() {
        return field_44_Spare;
    }

    /**
     * Get the tmEdited field for the DOP record.
     */
    public int getTmEdited() {
        return field_18_tmEdited;
    }

    /**
     * Get the unused2 field for the DOP record.
     */
    public byte getUnused2() {
        return field_2_unused2;
    }

    /**
     *
     * @return the unused5 field value.
     */
    public byte getUnused5() {
        return (byte) unused5.getValue(field_8_docinfo3);

    }

    /**
     * Get the view field for the DOP record.
     */
    public short getView() {
        return field_32_view;
    }

    /**
     * Get the virusinfo field for the DOP record.
     */
    public int getVirusinfo() {
        return field_43_virusinfo;
    }

    /**
     *
     * @return the wScaleSaved field value.
     */
    public short getWScaleSaved() {
        return (short) wScaleSaved.getValue(field_32_view);

    }

    /**
     * Get the wSpare field for the DOP record.
     */
    public int getWSpare() {
        return field_10_wSpare;
    }

    /**
     * Get the wSpare2 field for the DOP record.
     */
    public int getWSpare2() {
        return field_13_wSpare2;
    }

    /**
     *
     * @return the wvkSaved field value.
     */
    public byte getWvkSaved() {
        return (byte) wvkSaved.getValue(field_32_view);

    }

    /**
     *
     * @return the zkSaved field value.
     */
    public byte getZkSaved() {
        return (byte) zkSaved.getValue(field_32_view);

    }

    /**
     *
     * @return the fAutoHyphen field value.
     */
    public boolean isFAutoHyphen() {
        return fAutoHyphen.isSet(field_5_docinfo);

    }

    /**
     *
     * @return the fAutoVersions field value.
     */
    public boolean isFAutoVersions() {
        return fAutoVersions.isSet(field_38_docinfo6);

    }

    /**
     *
     * @return the fBackup field value.
     */
    public boolean isFBackup() {
        return fBackup.isSet(field_6_docinfo1);

    }

    /**
     *
     * @return the fConvMailMergeEsc field value.
     */
    public boolean isFConvMailMergeEsc() {
        return fConvMailMergeEsc.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fDfltTrueType field value.
     */
    public boolean isFDfltTrueType() {
        return fDfltTrueType.isSet(field_6_docinfo1);

    }

    /**
     *
     * @return the fDispFormFldSel field value.
     */
    public boolean isFDispFormFldSel() {
        return fDispFormFldSel.isSet(field_7_docinfo2);

    }

    /**
     *
     * @return the fEmbedFonts field value.
     */
    public boolean isFEmbedFonts() {
        return fEmbedFonts.isSet(field_7_docinfo2);

    }

    /**
     *
     * @return the fExactCWords field value.
     */
    public boolean isFExactCWords() {
        return fExactCWords.isSet(field_6_docinfo1);

    }

    /**
     *
     * @return the fFacingPages field value.
     */
    public boolean isFFacingPages() {
        return fFacingPages.isSet(field_1_formatFlags);

    }

    /**
     *
     * @return the fForcePageSizePag field value.
     */
    public boolean isFForcePageSizePag() {
        return fForcePageSizePag.isSet(field_37_docinfo5);

    }

    /**
     *
     * @return the fFormNoFields field value.
     */
    public boolean isFFormNoFields() {
        return fFormNoFields.isSet(field_5_docinfo);

    }

    /**
     *
     * @return the fGramAllClean field value.
     */
    public boolean isFGramAllClean() {
        return fGramAllClean.isSet(field_37_docinfo5);

    }

    /**
     *
     * @return the fGramAllDone field value.
     */
    public boolean isFGramAllDone() {
        return fGramAllDone.isSet(field_37_docinfo5);

    }

    /**
     *
     * @return the fHaveVersions field value.
     */
    public boolean isFHaveVersions() {
        return fHaveVersions.isSet(field_38_docinfo6);

    }

    /**
     *
     * @return the fHideLastVersion field value.
     */
    public boolean isFHideLastVersion() {
        return fHideLastVersion.isSet(field_37_docinfo5);

    }

    /**
     *
     * @return the fHtmlDoc field value.
     */
    public boolean isFHtmlDoc() {
        return fHtmlDoc.isSet(field_37_docinfo5);

    }

    /**
     *
     * @return the fHyphCapitals field value.
     */
    public boolean isFHyphCapitals() {
        return fHyphCapitals.isSet(field_5_docinfo);

    }

    /**
     *
     * @return the fIncludeFooter field value.
     */
    public boolean isFIncludeFooter() {
        return fIncludeFooter.isSet(field_37_docinfo5);

    }

    /**
     *
     * @return the fIncludeHeader field value.
     */
    public boolean isFIncludeHeader() {
        return fIncludeHeader.isSet(field_37_docinfo5);

    }

    /**
     *
     * @return the fLabelDoc field value.
     */
    public boolean isFLabelDoc() {
        return fLabelDoc.isSet(field_5_docinfo);

    }

    /**
     *
     * @return the fLinkStyles field value.
     */
    public boolean isFLinkStyles() {
        return fLinkStyles.isSet(field_5_docinfo);

    }

    /**
     *
     * @return the fLockAtn field value.
     */
    public boolean isFLockAtn() {
        return fLockAtn.isSet(field_6_docinfo1);

    }

    /**
     *
     * @return the fLockRev field value.
     */
    public boolean isFLockRev() {
        return fLockRev.isSet(field_7_docinfo2);

    }

    /**
     *
     * @return the fMapPrintTextColor field value.
     */
    public boolean isFMapPrintTextColor() {
        return fMapPrintTextColor.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fMinFontSizePag field value.
     */
    public boolean isFMinFontSizePag() {
        return fMinFontSizePag.isSet(field_37_docinfo5);

    }

    /**
     *
     * @return the fMirrorMargins field value.
     */
    public boolean isFMirrorMargins() {
        return fMirrorMargins.isSet(field_6_docinfo1);

    }

    /**
     *
     * @return the fMWSmallCaps field value.
     */
    public boolean isFMWSmallCaps() {
        return fMWSmallCaps.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fNoColumnBalance field value.
     */
    public boolean isFNoColumnBalance() {
        return fNoColumnBalance.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fNoLeading field value.
     */
    public boolean isFNoLeading() {
        return fNoLeading.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fNoSpaceRaiseLower field value.
     */
    public boolean isFNoSpaceRaiseLower() {
        return fNoSpaceRaiseLower.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fNoTabForInd field value.
     */
    public boolean isFNoTabForInd() {
        return fNoTabForInd.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fOnlyMacPics field value.
     */
    public boolean isFOnlyMacPics() {
        return fOnlyMacPics.isSet(field_5_docinfo);

    }

    /**
     *
     * @return the fOnlyWinPics field value.
     */
    public boolean isFOnlyWinPics() {
        return fOnlyWinPics.isSet(field_5_docinfo);

    }

    /**
     *
     * @return the fOrigWordTableRules field value.
     */
    public boolean isFOrigWordTableRules() {
        return fOrigWordTableRules.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fPagHidden field value.
     */
    public boolean isFPagHidden() {
        return fPagHidden.isSet(field_6_docinfo1);

    }

    /**
     *
     * @return the fPagResults field value.
     */
    public boolean isFPagResults() {
        return fPagResults.isSet(field_6_docinfo1);

    }

    /**
     *
     * @return the fPagSupressTopSpacing field value.
     */
    public boolean isFPagSupressTopSpacing() {
        return fPagSupressTopSpacing.isSet(field_7_docinfo2);

    }

    /**
     *
     * @return the fPMHMainDoc field value.
     */
    public boolean isFPMHMainDoc() {
        return fPMHMainDoc.isSet(field_1_formatFlags);

    }

    /**
     *
     * @return the fPrintBodyBeforeHdr field value.
     */
    public boolean isFPrintBodyBeforeHdr() {
        return fPrintBodyBeforeHdr.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fPrintFormData field value.
     */
    public boolean isFPrintFormData() {
        return fPrintFormData.isSet(field_24_Edn1);

    }

    /**
     *
     * @return the fProtEnabled field value.
     */
    public boolean isFProtEnabled() {
        return fProtEnabled.isSet(field_7_docinfo2);

    }

    /**
     *
     * @return the fRevMarking field value.
     */
    public boolean isFRevMarking() {
        return fRevMarking.isSet(field_5_docinfo);

    }

    /**
     *
     * @return the fRMPrint field value.
     */
    public boolean isFRMPrint() {
        return fRMPrint.isSet(field_7_docinfo2);

    }

    /**
     *
     * @return the fRMView field value.
     */
    public boolean isFRMView() {
        return fRMView.isSet(field_7_docinfo2);

    }

    /**
     *
     * @return the fRotateFontW6 field value.
     */
    public boolean isFRotateFontW6() {
        return fRotateFontW6.isSet(field_32_view);

    }

    /**
     *
     * @return the fSaveFormData field value.
     */
    public boolean isFSaveFormData() {
        return fSaveFormData.isSet(field_24_Edn1);

    }

    /**
     *
     * @return the fShadeFormData field value.
     */
    public boolean isFShadeFormData() {
        return fShadeFormData.isSet(field_24_Edn1);

    }

    /**
     *
     * @return the fShowBreaksInFrames field value.
     */
    public boolean isFShowBreaksInFrames() {
        return fShowBreaksInFrames.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fSnapBorder field value.
     */
    public boolean isFSnapBorder() {
        return fSnapBorder.isSet(field_37_docinfo5);

    }

    /**
     *
     * @return the fSubsetFonts field value.
     */
    public boolean isFSubsetFonts() {
        return fSubsetFonts.isSet(field_37_docinfo5);

    }

    /**
     *
     * @return the fSuppressTopSPacingMac5 field value.
     */
    public boolean isFSuppressTopSPacingMac5() {
        return fSuppressTopSPacingMac5.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fSupressSpdfAfterPageBreak field value.
     */
    public boolean isFSupressSpdfAfterPageBreak() {
        return fSupressSpdfAfterPageBreak.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fSupressTopSpacing field value.
     */
    public boolean isFSupressTopSpacing() {
        return fSupressTopSpacing.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fSwapBordersFacingPgs field value.
     */
    public boolean isFSwapBordersFacingPgs() {
        return fSwapBordersFacingPgs.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fTransparentMetafiles field value.
     */
    public boolean isFTransparentMetafiles() {
        return fTransparentMetafiles.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fTruncDxaExpand field value.
     */
    public boolean isFTruncDxaExpand() {
        return fTruncDxaExpand.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the fVirusLoadSafe field value.
     */
    public boolean isFVirusLoadSafe() {
        return fVirusLoadSafe.isSet(field_43_virusinfo);

    }

    /**
     *
     * @return the fVirusPrompted field value.
     */
    public boolean isFVirusPrompted() {
        return fVirusPrompted.isSet(field_43_virusinfo);

    }

    /**
     *
     * @return the fWCFtnEdn field value.
     */
    public boolean isFWCFtnEdn() {
        return fWCFtnEdn.isSet(field_24_Edn1);

    }

    /**
     *
     * @return the fWidowControl field value.
     */
    public boolean isFWidowControl() {
        return fWidowControl.isSet(field_1_formatFlags);

    }

    /**
     *
     * @return the fWrapTrailSpaces field value.
     */
    public boolean isFWrapTrailSpaces() {
        return fWrapTrailSpaces.isSet(field_33_docinfo4);

    }

    /**
     *
     * @return the iGutterPos field value.
     */
    public boolean isIGutterPos() {
        return iGutterPos.isSet(field_32_view);

    }

    /**
     *
     * @return the oldfConvMailMergeEsc field value.
     */
    public boolean isOldfConvMailMergeEsc() {
        return oldfConvMailMergeEsc.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the oldfMapPrintTextColor field value.
     */
    public boolean isOldfMapPrintTextColor() {
        return oldfMapPrintTextColor.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the oldfNoColumnBalance field value.
     */
    public boolean isOldfNoColumnBalance() {
        return oldfNoColumnBalance.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the oldfNoSpaceRaiseLower field value.
     */
    public boolean isOldfNoSpaceRaiseLower() {
        return oldfNoSpaceRaiseLower.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the oldfNoTabForInd field value.
     */
    public boolean isOldfNoTabForInd() {
        return oldfNoTabForInd.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the oldfOrigWordTableRules field value.
     */
    public boolean isOldfOrigWordTableRules() {
        return oldfOrigWordTableRules.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the oldfShowBreaksInFrames field value.
     */
    public boolean isOldfShowBreaksInFrames() {
        return oldfShowBreaksInFrames.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the oldfSuppressSpbfAfterPageBreak field value.
     */
    public boolean isOldfSuppressSpbfAfterPageBreak() {
        return oldfSuppressSpbfAfterPageBreak.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the oldfSupressTopSpacing field value.
     */
    public boolean isOldfSupressTopSpacing() {
        return oldfSupressTopSpacing.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the oldfSwapBordersFacingPgs field value.
     */
    public boolean isOldfSwapBordersFacingPgs() {
        return oldfSwapBordersFacingPgs.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the oldfTransparentMetafiles field value.
     */
    public boolean isOldfTransparentMetafiles() {
        return oldfTransparentMetafiles.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the oldfWrapTrailSpaces field value.
     */
    public boolean isOldfWrapTrailSpaces() {
        return oldfWrapTrailSpaces.isSet(field_8_docinfo3);

    }

    /**
     *
     * @return the unused1 field value.
     */
    public boolean isUnused1() {
        return unused1.isSet(field_1_formatFlags);

    }

    /**
     *
     * @return the unused3 field value.
     */
    public boolean isUnused3() {
        return unused3.isSet(field_6_docinfo1);

    }

    /**
     *
     * @return the unused4 field value.
     */
    public boolean isUnused4() {
        return unused4.isSet(field_7_docinfo2);

    }

    public void serialize(byte[] data, int offset) {
        data[0x0 + offset] = field_1_formatFlags;
        ;
        data[0x1 + offset] = field_2_unused2;
        ;
        LittleEndian.putShort(data, 0x2 + offset, field_3_footnoteInfo);
        ;
        data[0x4 + offset] = field_4_fOutlineDirtySave;
        ;
        data[0x5 + offset] = field_5_docinfo;
        ;
        data[0x6 + offset] = field_6_docinfo1;
        ;
        data[0x7 + offset] = field_7_docinfo2;
        ;
        LittleEndian.putShort(data, 0x8 + offset, field_8_docinfo3);
        ;
        LittleEndian.putShort(data, 0xa + offset, (short) field_9_dxaTab);
        ;
        LittleEndian.putShort(data, 0xc + offset, (short) field_10_wSpare);
        ;
        LittleEndian.putShort(data, 0xe + offset, (short) field_11_dxaHotz);
        ;
        LittleEndian.putShort(data, 0x10 + offset, (short) field_12_cConsexHypLim);
        ;
        LittleEndian.putShort(data, 0x12 + offset, (short) field_13_wSpare2);
        ;
        LittleEndian.putInt(data, 0x14 + offset, field_14_dttmCreated);
        ;
        LittleEndian.putInt(data, 0x18 + offset, field_15_dttmRevised);
        ;
        LittleEndian.putInt(data, 0x1c + offset, field_16_dttmLastPrint);
        ;
        LittleEndian.putShort(data, 0x20 + offset, (short) field_17_nRevision);
        ;
        LittleEndian.putInt(data, 0x22 + offset, field_18_tmEdited);
        ;
        LittleEndian.putInt(data, 0x26 + offset, field_19_cWords);
        ;
        LittleEndian.putInt(data, 0x2a + offset, field_20_cCh);
        ;
        LittleEndian.putShort(data, 0x2e + offset, (short) field_21_cPg);
        ;
        LittleEndian.putInt(data, 0x30 + offset, field_22_cParas);
        ;
        LittleEndian.putShort(data, 0x34 + offset, field_23_Edn);
        ;
        LittleEndian.putShort(data, 0x36 + offset, field_24_Edn1);
        ;
        LittleEndian.putInt(data, 0x38 + offset, field_25_cLines);
        ;
        LittleEndian.putInt(data, 0x3c + offset, field_26_cWordsFtnEnd);
        ;
        LittleEndian.putInt(data, 0x40 + offset, field_27_cChFtnEdn);
        ;
        LittleEndian.putShort(data, 0x44 + offset, field_28_cPgFtnEdn);
        ;
        LittleEndian.putInt(data, 0x46 + offset, field_29_cParasFtnEdn);
        ;
        LittleEndian.putInt(data, 0x4a + offset, field_30_cLinesFtnEdn);
        ;
        LittleEndian.putInt(data, 0x4e + offset, field_31_lKeyProtDoc);
        ;
        LittleEndian.putShort(data, 0x52 + offset, field_32_view);
        ;
        LittleEndian.putInt(data, 0x54 + offset, field_33_docinfo4);
        ;
        LittleEndian.putShort(data, 0x58 + offset, field_34_adt);
        ;
        System.arraycopy(field_35_doptypography, 0, data, 0x5a + offset, field_35_doptypography.length);
        ;
        System.arraycopy(field_36_dogrid, 0, data, 0x190 + offset, field_36_dogrid.length);
        ;
        LittleEndian.putShort(data, 0x19a + offset, field_37_docinfo5);
        ;
        LittleEndian.putShort(data, 0x19c + offset, field_38_docinfo6);
        ;
        System.arraycopy(field_39_asumyi, 0, data, 0x19e + offset, field_39_asumyi.length);
        ;
        LittleEndian.putInt(data, 0x1aa + offset, field_40_cChWS);
        ;
        LittleEndian.putInt(data, 0x1ae + offset, field_41_cChWSFtnEdn);
        ;
        LittleEndian.putInt(data, 0x1b2 + offset, field_42_grfDocEvents);
        ;
        LittleEndian.putInt(data, 0x1b6 + offset, field_43_virusinfo);
        ;
        System.arraycopy(field_44_Spare, 0, data, 0x1ba + offset, field_44_Spare.length);
        ;
        LittleEndian.putInt(data, 0x1d8 + offset, field_45_reserved1);
        ;
        LittleEndian.putInt(data, 0x1dc + offset, field_46_reserved2);
        ;
        LittleEndian.putInt(data, 0x1e0 + offset, field_47_cDBC);
        ;
        LittleEndian.putInt(data, 0x1e4 + offset, field_48_cDBCFtnEdn);
        ;
        LittleEndian.putInt(data, 0x1e8 + offset, field_49_reserved);
        ;
        LittleEndian.putShort(data, 0x1ec + offset, field_50_nfcFtnRef);
        ;
        LittleEndian.putShort(data, 0x1ee + offset, field_51_nfcEdnRef);
        ;
        LittleEndian.putShort(data, 0x1f0 + offset, field_52_hpsZoonFontPag);
        ;
        LittleEndian.putShort(data, 0x1f2 + offset, field_53_dywDispPag);
        ;

    }

    /**
     * Set the adt field for the DOP record.
     */
    public void setAdt(short field_34_adt) {
        this.field_34_adt = field_34_adt;
    }

    /**
     * Set the asumyi field for the DOP record.
     */
    public void setAsumyi(byte[] field_39_asumyi) {
        this.field_39_asumyi = field_39_asumyi;
    }

    /**
     * Set the cCh field for the DOP record.
     */
    public void setCCh(int field_20_cCh) {
        this.field_20_cCh = field_20_cCh;
    }

    /**
     * Set the cChFtnEdn field for the DOP record.
     */
    public void setCChFtnEdn(int field_27_cChFtnEdn) {
        this.field_27_cChFtnEdn = field_27_cChFtnEdn;
    }

    /**
     * Set the cChWS field for the DOP record.
     */
    public void setCChWS(int field_40_cChWS) {
        this.field_40_cChWS = field_40_cChWS;
    }

    /**
     * Set the cChWSFtnEdn field for the DOP record.
     */
    public void setCChWSFtnEdn(int field_41_cChWSFtnEdn) {
        this.field_41_cChWSFtnEdn = field_41_cChWSFtnEdn;
    }

    /**
     * Set the cConsexHypLim field for the DOP record.
     */
    public void setCConsexHypLim(int field_12_cConsexHypLim) {
        this.field_12_cConsexHypLim = field_12_cConsexHypLim;
    }

    /**
     * Set the cDBC field for the DOP record.
     */
    public void setCDBC(int field_47_cDBC) {
        this.field_47_cDBC = field_47_cDBC;
    }

    /**
     * Set the cDBCFtnEdn field for the DOP record.
     */
    public void setCDBCFtnEdn(int field_48_cDBCFtnEdn) {
        this.field_48_cDBCFtnEdn = field_48_cDBCFtnEdn;
    }

    /**
     * Set the cLines field for the DOP record.
     */
    public void setCLines(int field_25_cLines) {
        this.field_25_cLines = field_25_cLines;
    }

    /**
     * Set the cLinesFtnEdn field for the DOP record.
     */
    public void setCLinesFtnEdn(int field_30_cLinesFtnEdn) {
        this.field_30_cLinesFtnEdn = field_30_cLinesFtnEdn;
    }

    /**
     * Set the cParas field for the DOP record.
     */
    public void setCParas(int field_22_cParas) {
        this.field_22_cParas = field_22_cParas;
    }

    /**
     * Set the cParasFtnEdn field for the DOP record.
     */
    public void setCParasFtnEdn(int field_29_cParasFtnEdn) {
        this.field_29_cParasFtnEdn = field_29_cParasFtnEdn;
    }

    /**
     * Set the cPg field for the DOP record.
     */
    public void setCPg(int field_21_cPg) {
        this.field_21_cPg = field_21_cPg;
    }

    /**
     * Set the cPgFtnEdn field for the DOP record.
     */
    public void setCPgFtnEdn(short field_28_cPgFtnEdn) {
        this.field_28_cPgFtnEdn = field_28_cPgFtnEdn;
    }

    /**
     * Set the cWords field for the DOP record.
     */
    public void setCWords(int field_19_cWords) {
        this.field_19_cWords = field_19_cWords;
    }

    /**
     * Set the cWordsFtnEnd field for the DOP record.
     */
    public void setCWordsFtnEnd(int field_26_cWordsFtnEnd) {
        this.field_26_cWordsFtnEnd = field_26_cWordsFtnEnd;
    }

    /**
     * Set the docinfo field for the DOP record.
     */
    public void setDocinfo(byte field_5_docinfo) {
        this.field_5_docinfo = field_5_docinfo;
    }

    /**
     * Set the docinfo1 field for the DOP record.
     */
    public void setDocinfo1(byte field_6_docinfo1) {
        this.field_6_docinfo1 = field_6_docinfo1;
    }

    /**
     * Set the docinfo2 field for the DOP record.
     */
    public void setDocinfo2(byte field_7_docinfo2) {
        this.field_7_docinfo2 = field_7_docinfo2;
    }

    /**
     * Set the docinfo3 field for the DOP record.
     */
    public void setDocinfo3(short field_8_docinfo3) {
        this.field_8_docinfo3 = field_8_docinfo3;
    }

    /**
     * Set the docinfo4 field for the DOP record.
     */
    public void setDocinfo4(int field_33_docinfo4) {
        this.field_33_docinfo4 = field_33_docinfo4;
    }

    /**
     * Set the docinfo5 field for the DOP record.
     */
    public void setDocinfo5(short field_37_docinfo5) {
        this.field_37_docinfo5 = field_37_docinfo5;
    }

    /**
     * Set the docinfo6 field for the DOP record.
     */
    public void setDocinfo6(short field_38_docinfo6) {
        this.field_38_docinfo6 = field_38_docinfo6;
    }

    /**
     * Set the dogrid field for the DOP record.
     */
    public void setDogrid(byte[] field_36_dogrid) {
        this.field_36_dogrid = field_36_dogrid;
    }

    /**
     * Set the doptypography field for the DOP record.
     */
    public void setDoptypography(byte[] field_35_doptypography) {
        this.field_35_doptypography = field_35_doptypography;
    }

    /**
     * Set the dttmCreated field for the DOP record.
     */
    public void setDttmCreated(int field_14_dttmCreated) {
        this.field_14_dttmCreated = field_14_dttmCreated;
    }

    /**
     * Set the dttmLastPrint field for the DOP record.
     */
    public void setDttmLastPrint(int field_16_dttmLastPrint) {
        this.field_16_dttmLastPrint = field_16_dttmLastPrint;
    }

    /**
     * Set the dttmRevised field for the DOP record.
     */
    public void setDttmRevised(int field_15_dttmRevised) {
        this.field_15_dttmRevised = field_15_dttmRevised;
    }

    /**
     * Set the dxaHotz field for the DOP record.
     */
    public void setDxaHotz(int field_11_dxaHotz) {
        this.field_11_dxaHotz = field_11_dxaHotz;
    }

    /**
     * Set the dxaTab field for the DOP record.
     */
    public void setDxaTab(int field_9_dxaTab) {
        this.field_9_dxaTab = field_9_dxaTab;
    }

    /**
     * Set the dywDispPag field for the DOP record.
     */
    public void setDywDispPag(short field_53_dywDispPag) {
        this.field_53_dywDispPag = field_53_dywDispPag;
    }

    /**
     * Set the Edn field for the DOP record.
     */
    public void setEdn(short field_23_Edn) {
        this.field_23_Edn = field_23_Edn;
    }

    /**
     * Set the Edn1 field for the DOP record.
     */
    public void setEdn1(short field_24_Edn1) {
        this.field_24_Edn1 = field_24_Edn1;
    }

    /**
     * Sets the epc field value.
     *
     */
    public void setEpc(byte value) {
        field_24_Edn1 = (short) epc.setValue(field_24_Edn1, value);

    }

    /**
     * Sets the fAutoHyphen field value.
     *
     */
    public void setFAutoHyphen(boolean value) {
        field_5_docinfo = (byte) fAutoHyphen.setBoolean(field_5_docinfo, value);

    }

    /**
     * Sets the fAutoVersions field value.
     *
     */
    public void setFAutoVersions(boolean value) {
        field_38_docinfo6 = (short) fAutoVersions.setBoolean(field_38_docinfo6, value);

    }

    /**
     * Sets the fBackup field value.
     *
     */
    public void setFBackup(boolean value) {
        field_6_docinfo1 = (byte) fBackup.setBoolean(field_6_docinfo1, value);

    }

    /**
     * Sets the fConvMailMergeEsc field value.
     *
     */
    public void setFConvMailMergeEsc(boolean value) {
        field_33_docinfo4 = fConvMailMergeEsc.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fDfltTrueType field value.
     *
     */
    public void setFDfltTrueType(boolean value) {
        field_6_docinfo1 = (byte) fDfltTrueType.setBoolean(field_6_docinfo1, value);

    }

    /**
     * Sets the fDispFormFldSel field value.
     *
     */
    public void setFDispFormFldSel(boolean value) {
        field_7_docinfo2 = (byte) fDispFormFldSel.setBoolean(field_7_docinfo2, value);

    }

    /**
     * Sets the fEmbedFonts field value.
     *
     */
    public void setFEmbedFonts(boolean value) {
        field_7_docinfo2 = (byte) fEmbedFonts.setBoolean(field_7_docinfo2, value);

    }

    /**
     * Sets the fExactCWords field value.
     *
     */
    public void setFExactCWords(boolean value) {
        field_6_docinfo1 = (byte) fExactCWords.setBoolean(field_6_docinfo1, value);

    }

    /**
     * Sets the fFacingPages field value.
     *
     */
    public void setFFacingPages(boolean value) {
        field_1_formatFlags = (byte) fFacingPages.setBoolean(field_1_formatFlags, value);

    }

    /**
     * Sets the fForcePageSizePag field value.
     *
     */
    public void setFForcePageSizePag(boolean value) {
        field_37_docinfo5 = (short) fForcePageSizePag.setBoolean(field_37_docinfo5, value);

    }

    /**
     * Sets the fFormNoFields field value.
     *
     */
    public void setFFormNoFields(boolean value) {
        field_5_docinfo = (byte) fFormNoFields.setBoolean(field_5_docinfo, value);

    }

    /**
     * Sets the fGramAllClean field value.
     *
     */
    public void setFGramAllClean(boolean value) {
        field_37_docinfo5 = (short) fGramAllClean.setBoolean(field_37_docinfo5, value);

    }

    /**
     * Sets the fGramAllDone field value.
     *
     */
    public void setFGramAllDone(boolean value) {
        field_37_docinfo5 = (short) fGramAllDone.setBoolean(field_37_docinfo5, value);

    }

    /**
     * Sets the fHaveVersions field value.
     *
     */
    public void setFHaveVersions(boolean value) {
        field_38_docinfo6 = (short) fHaveVersions.setBoolean(field_38_docinfo6, value);

    }

    /**
     * Sets the fHideLastVersion field value.
     *
     */
    public void setFHideLastVersion(boolean value) {
        field_37_docinfo5 = (short) fHideLastVersion.setBoolean(field_37_docinfo5, value);

    }

    /**
     * Sets the fHtmlDoc field value.
     *
     */
    public void setFHtmlDoc(boolean value) {
        field_37_docinfo5 = (short) fHtmlDoc.setBoolean(field_37_docinfo5, value);

    }

    /**
     * Sets the fHyphCapitals field value.
     *
     */
    public void setFHyphCapitals(boolean value) {
        field_5_docinfo = (byte) fHyphCapitals.setBoolean(field_5_docinfo, value);

    }

    /**
     * Sets the fIncludeFooter field value.
     *
     */
    public void setFIncludeFooter(boolean value) {
        field_37_docinfo5 = (short) fIncludeFooter.setBoolean(field_37_docinfo5, value);

    }

    /**
     * Sets the fIncludeHeader field value.
     *
     */
    public void setFIncludeHeader(boolean value) {
        field_37_docinfo5 = (short) fIncludeHeader.setBoolean(field_37_docinfo5, value);

    }

    /**
     * Sets the fLabelDoc field value.
     *
     */
    public void setFLabelDoc(boolean value) {
        field_5_docinfo = (byte) fLabelDoc.setBoolean(field_5_docinfo, value);

    }

    /**
     * Sets the fLinkStyles field value.
     *
     */
    public void setFLinkStyles(boolean value) {
        field_5_docinfo = (byte) fLinkStyles.setBoolean(field_5_docinfo, value);

    }

    /**
     * Sets the fLockAtn field value.
     *
     */
    public void setFLockAtn(boolean value) {
        field_6_docinfo1 = (byte) fLockAtn.setBoolean(field_6_docinfo1, value);

    }

    /**
     * Sets the fLockRev field value.
     *
     */
    public void setFLockRev(boolean value) {
        field_7_docinfo2 = (byte) fLockRev.setBoolean(field_7_docinfo2, value);

    }

    /**
     * Sets the fMapPrintTextColor field value.
     *
     */
    public void setFMapPrintTextColor(boolean value) {
        field_33_docinfo4 = fMapPrintTextColor.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fMinFontSizePag field value.
     *
     */
    public void setFMinFontSizePag(boolean value) {
        field_37_docinfo5 = (short) fMinFontSizePag.setBoolean(field_37_docinfo5, value);

    }

    /**
     * Sets the fMirrorMargins field value.
     *
     */
    public void setFMirrorMargins(boolean value) {
        field_6_docinfo1 = (byte) fMirrorMargins.setBoolean(field_6_docinfo1, value);

    }

    /**
     * Sets the fMWSmallCaps field value.
     *
     */
    public void setFMWSmallCaps(boolean value) {
        field_33_docinfo4 = fMWSmallCaps.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fNoColumnBalance field value.
     *
     */
    public void setFNoColumnBalance(boolean value) {
        field_33_docinfo4 = fNoColumnBalance.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fNoLeading field value.
     *
     */
    public void setFNoLeading(boolean value) {
        field_33_docinfo4 = fNoLeading.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fNoSpaceRaiseLower field value.
     *
     */
    public void setFNoSpaceRaiseLower(boolean value) {
        field_33_docinfo4 = fNoSpaceRaiseLower.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fNoTabForInd field value.
     *
     */
    public void setFNoTabForInd(boolean value) {
        field_33_docinfo4 = fNoTabForInd.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fOnlyMacPics field value.
     *
     */
    public void setFOnlyMacPics(boolean value) {
        field_5_docinfo = (byte) fOnlyMacPics.setBoolean(field_5_docinfo, value);

    }

    /**
     * Sets the fOnlyWinPics field value.
     *
     */
    public void setFOnlyWinPics(boolean value) {
        field_5_docinfo = (byte) fOnlyWinPics.setBoolean(field_5_docinfo, value);

    }

    /**
     * Set the footnoteInfo field for the DOP record.
     */
    public void setFootnoteInfo(short field_3_footnoteInfo) {
        this.field_3_footnoteInfo = field_3_footnoteInfo;
    }

    /**
     * Sets the fOrigWordTableRules field value.
     *
     */
    public void setFOrigWordTableRules(boolean value) {
        field_33_docinfo4 = fOrigWordTableRules.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Set the formatFlags field for the DOP record.
     */
    public void setFormatFlags(byte field_1_formatFlags) {
        this.field_1_formatFlags = field_1_formatFlags;
    }

    /**
     * Set the fOutlineDirtySave field for the DOP record.
     */
    public void setFOutlineDirtySave(byte field_4_fOutlineDirtySave) {
        this.field_4_fOutlineDirtySave = field_4_fOutlineDirtySave;
    }

    /**
     * Sets the fPagHidden field value.
     *
     */
    public void setFPagHidden(boolean value) {
        field_6_docinfo1 = (byte) fPagHidden.setBoolean(field_6_docinfo1, value);

    }

    /**
     * Sets the fPagResults field value.
     *
     */
    public void setFPagResults(boolean value) {
        field_6_docinfo1 = (byte) fPagResults.setBoolean(field_6_docinfo1, value);

    }

    /**
     * Sets the fPagSupressTopSpacing field value.
     *
     */
    public void setFPagSupressTopSpacing(boolean value) {
        field_7_docinfo2 = (byte) fPagSupressTopSpacing.setBoolean(field_7_docinfo2, value);

    }

    /**
     * Sets the fpc field value.
     *
     */
    public void setFpc(byte value) {
        field_1_formatFlags = (byte) fpc.setValue(field_1_formatFlags, value);

    }

    /**
     * Sets the fPMHMainDoc field value.
     *
     */
    public void setFPMHMainDoc(boolean value) {
        field_1_formatFlags = (byte) fPMHMainDoc.setBoolean(field_1_formatFlags, value);

    }

    /**
     * Sets the fPrintBodyBeforeHdr field value.
     *
     */
    public void setFPrintBodyBeforeHdr(boolean value) {
        field_33_docinfo4 = fPrintBodyBeforeHdr.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fPrintFormData field value.
     *
     */
    public void setFPrintFormData(boolean value) {
        field_24_Edn1 = (short) fPrintFormData.setBoolean(field_24_Edn1, value);

    }

    /**
     * Sets the fProtEnabled field value.
     *
     */
    public void setFProtEnabled(boolean value) {
        field_7_docinfo2 = (byte) fProtEnabled.setBoolean(field_7_docinfo2, value);

    }

    /**
     * Sets the fRevMarking field value.
     *
     */
    public void setFRevMarking(boolean value) {
        field_5_docinfo = (byte) fRevMarking.setBoolean(field_5_docinfo, value);

    }

    /**
     * Sets the fRMPrint field value.
     *
     */
    public void setFRMPrint(boolean value) {
        field_7_docinfo2 = (byte) fRMPrint.setBoolean(field_7_docinfo2, value);

    }

    /**
     * Sets the fRMView field value.
     *
     */
    public void setFRMView(boolean value) {
        field_7_docinfo2 = (byte) fRMView.setBoolean(field_7_docinfo2, value);

    }

    /**
     * Sets the fRotateFontW6 field value.
     *
     */
    public void setFRotateFontW6(boolean value) {
        field_32_view = (short) fRotateFontW6.setBoolean(field_32_view, value);

    }

    /**
     * Sets the fSaveFormData field value.
     *
     */
    public void setFSaveFormData(boolean value) {
        field_24_Edn1 = (short) fSaveFormData.setBoolean(field_24_Edn1, value);

    }

    /**
     * Sets the fShadeFormData field value.
     *
     */
    public void setFShadeFormData(boolean value) {
        field_24_Edn1 = (short) fShadeFormData.setBoolean(field_24_Edn1, value);

    }

    /**
     * Sets the fShowBreaksInFrames field value.
     *
     */
    public void setFShowBreaksInFrames(boolean value) {
        field_33_docinfo4 = fShowBreaksInFrames.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fSnapBorder field value.
     *
     */
    public void setFSnapBorder(boolean value) {
        field_37_docinfo5 = (short) fSnapBorder.setBoolean(field_37_docinfo5, value);

    }

    /**
     * Sets the fSubsetFonts field value.
     *
     */
    public void setFSubsetFonts(boolean value) {
        field_37_docinfo5 = (short) fSubsetFonts.setBoolean(field_37_docinfo5, value);

    }

    /**
     * Sets the fSuppressTopSPacingMac5 field value.
     *
     */
    public void setFSuppressTopSPacingMac5(boolean value) {
        field_33_docinfo4 = fSuppressTopSPacingMac5.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fSupressSpdfAfterPageBreak field value.
     *
     */
    public void setFSupressSpdfAfterPageBreak(boolean value) {
        field_33_docinfo4 = fSupressSpdfAfterPageBreak.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fSupressTopSpacing field value.
     *
     */
    public void setFSupressTopSpacing(boolean value) {
        field_33_docinfo4 = fSupressTopSpacing.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fSwapBordersFacingPgs field value.
     *
     */
    public void setFSwapBordersFacingPgs(boolean value) {
        field_33_docinfo4 = fSwapBordersFacingPgs.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fTransparentMetafiles field value.
     *
     */
    public void setFTransparentMetafiles(boolean value) {
        field_33_docinfo4 = fTransparentMetafiles.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fTruncDxaExpand field value.
     *
     */
    public void setFTruncDxaExpand(boolean value) {
        field_33_docinfo4 = fTruncDxaExpand.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Sets the fVirusLoadSafe field value.
     *
     */
    public void setFVirusLoadSafe(boolean value) {
        field_43_virusinfo = fVirusLoadSafe.setBoolean(field_43_virusinfo, value);

    }

    /**
     * Sets the fVirusPrompted field value.
     *
     */
    public void setFVirusPrompted(boolean value) {
        field_43_virusinfo = fVirusPrompted.setBoolean(field_43_virusinfo, value);

    }

    /**
     * Sets the fWCFtnEdn field value.
     *
     */
    public void setFWCFtnEdn(boolean value) {
        field_24_Edn1 = (short) fWCFtnEdn.setBoolean(field_24_Edn1, value);

    }

    /**
     * Sets the fWidowControl field value.
     *
     */
    public void setFWidowControl(boolean value) {
        field_1_formatFlags = (byte) fWidowControl.setBoolean(field_1_formatFlags, value);

    }

    /**
     * Sets the fWrapTrailSpaces field value.
     *
     */
    public void setFWrapTrailSpaces(boolean value) {
        field_33_docinfo4 = fWrapTrailSpaces.setBoolean(field_33_docinfo4, value);

    }

    /**
     * Set the grfDocEvents field for the DOP record.
     */
    public void setGrfDocEvents(int field_42_grfDocEvents) {
        this.field_42_grfDocEvents = field_42_grfDocEvents;
    }

    /**
     * Sets the grfSupression field value.
     *
     */
    public void setGrfSupression(byte value) {
        field_1_formatFlags = (byte) grfSupression.setValue(field_1_formatFlags, value);

    }

    /**
     * Set the hpsZoonFontPag field for the DOP record.
     */
    public void setHpsZoonFontPag(short field_52_hpsZoonFontPag) {
        this.field_52_hpsZoonFontPag = field_52_hpsZoonFontPag;
    }

    /**
     * Sets the iGutterPos field value.
     *
     */
    public void setIGutterPos(boolean value) {
        field_32_view = (short) iGutterPos.setBoolean(field_32_view, value);

    }

    /**
     * Sets the KeyVirusSession30 field value.
     *
     */
    public void setKeyVirusSession30(int value) {
        field_43_virusinfo = KeyVirusSession30.setValue(field_43_virusinfo, value);

    }

    /**
     * Set the lKeyProtDoc field for the DOP record.
     */
    public void setLKeyProtDoc(int field_31_lKeyProtDoc) {
        this.field_31_lKeyProtDoc = field_31_lKeyProtDoc;
    }

    /**
     * Sets the lvl field value.
     *
     */
    public void setLvl(byte value) {
        field_37_docinfo5 = (short) lvl.setValue(field_37_docinfo5, value);

    }

    /**
     * Sets the nEdn field value.
     *
     */
    public void setNEdn(short value) {
        field_23_Edn = (short) nEdn.setValue(field_23_Edn, value);

    }

    /**
     * Set the nfcEdnRef field for the DOP record.
     */
    public void setNfcEdnRef(short field_51_nfcEdnRef) {
        this.field_51_nfcEdnRef = field_51_nfcEdnRef;
    }

    /**
     * Sets the nfcEdnRef1 field value.
     *
     */
    public void setNfcEdnRef1(byte value) {
        field_24_Edn1 = (short) nfcEdnRef1.setValue(field_24_Edn1, value);

    }

    /**
     * Set the nfcFtnRef field for the DOP record.
     */
    public void setNfcFtnRef(short field_50_nfcFtnRef) {
        this.field_50_nfcFtnRef = field_50_nfcFtnRef;
    }

    /**
     * Sets the nfcFtnRef1 field value.
     *
     */
    public void setNfcFtnRef1(byte value) {
        field_24_Edn1 = (short) nfcFtnRef1.setValue(field_24_Edn1, value);

    }

    /**
     * Sets the nFtn field value.
     *
     */
    public void setNFtn(short value) {
        field_3_footnoteInfo = (short) nFtn.setValue(field_3_footnoteInfo, value);

    }

    /**
     * Set the nRevision field for the DOP record.
     */
    public void setNRevision(int field_17_nRevision) {
        this.field_17_nRevision = field_17_nRevision;
    }

    /**
     * Sets the oldfConvMailMergeEsc field value.
     *
     */
    public void setOldfConvMailMergeEsc(boolean value) {
        field_8_docinfo3 = (short) oldfConvMailMergeEsc.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Sets the oldfMapPrintTextColor field value.
     *
     */
    public void setOldfMapPrintTextColor(boolean value) {
        field_8_docinfo3 = (short) oldfMapPrintTextColor.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Sets the oldfNoColumnBalance field value.
     *
     */
    public void setOldfNoColumnBalance(boolean value) {
        field_8_docinfo3 = (short) oldfNoColumnBalance.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Sets the oldfNoSpaceRaiseLower field value.
     *
     */
    public void setOldfNoSpaceRaiseLower(boolean value) {
        field_8_docinfo3 = (short) oldfNoSpaceRaiseLower.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Sets the oldfNoTabForInd field value.
     *
     */
    public void setOldfNoTabForInd(boolean value) {
        field_8_docinfo3 = (short) oldfNoTabForInd.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Sets the oldfOrigWordTableRules field value.
     *
     */
    public void setOldfOrigWordTableRules(boolean value) {
        field_8_docinfo3 = (short) oldfOrigWordTableRules.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Sets the oldfShowBreaksInFrames field value.
     *
     */
    public void setOldfShowBreaksInFrames(boolean value) {
        field_8_docinfo3 = (short) oldfShowBreaksInFrames.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Sets the oldfSuppressSpbfAfterPageBreak field value.
     *
     */
    public void setOldfSuppressSpbfAfterPageBreak(boolean value) {
        field_8_docinfo3 = (short) oldfSuppressSpbfAfterPageBreak.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Sets the oldfSupressTopSpacing field value.
     *
     */
    public void setOldfSupressTopSpacing(boolean value) {
        field_8_docinfo3 = (short) oldfSupressTopSpacing.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Sets the oldfSwapBordersFacingPgs field value.
     *
     */
    public void setOldfSwapBordersFacingPgs(boolean value) {
        field_8_docinfo3 = (short) oldfSwapBordersFacingPgs.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Sets the oldfTransparentMetafiles field value.
     *
     */
    public void setOldfTransparentMetafiles(boolean value) {
        field_8_docinfo3 = (short) oldfTransparentMetafiles.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Sets the oldfWrapTrailSpaces field value.
     *
     */
    public void setOldfWrapTrailSpaces(boolean value) {
        field_8_docinfo3 = (short) oldfWrapTrailSpaces.setBoolean(field_8_docinfo3, value);

    }

    /**
     * Set the reserved field for the DOP record.
     */
    public void setReserved(int field_49_reserved) {
        this.field_49_reserved = field_49_reserved;
    }

    /**
     * Set the reserved1 field for the DOP record.
     */
    public void setReserved1(int field_45_reserved1) {
        this.field_45_reserved1 = field_45_reserved1;
    }

    /**
     * Set the reserved2 field for the DOP record.
     */
    public void setReserved2(int field_46_reserved2) {
        this.field_46_reserved2 = field_46_reserved2;
    }

    /**
     * Sets the rncEdn field value.
     *
     */
    public void setRncEdn(byte value) {
        field_23_Edn = (short) rncEdn.setValue(field_23_Edn, value);

    }

    /**
     * Sets the rncFtn field value.
     *
     */
    public void setRncFtn(byte value) {
        field_3_footnoteInfo = (short) rncFtn.setValue(field_3_footnoteInfo, value);

    }

    /**
     * Set the Spare field for the DOP record.
     */
    public void setSpare(byte[] field_44_Spare) {
        this.field_44_Spare = field_44_Spare;
    }

    /**
     * Set the tmEdited field for the DOP record.
     */
    public void setTmEdited(int field_18_tmEdited) {
        this.field_18_tmEdited = field_18_tmEdited;
    }

    /**
     * Sets the unused1 field value.
     *
     */
    public void setUnused1(boolean value) {
        field_1_formatFlags = (byte) unused1.setBoolean(field_1_formatFlags, value);

    }

    /**
     * Set the unused2 field for the DOP record.
     */
    public void setUnused2(byte field_2_unused2) {
        this.field_2_unused2 = field_2_unused2;
    }

    /**
     * Sets the unused3 field value.
     *
     */
    public void setUnused3(boolean value) {
        field_6_docinfo1 = (byte) unused3.setBoolean(field_6_docinfo1, value);

    }

    /**
     * Sets the unused4 field value.
     *
     */
    public void setUnused4(boolean value) {
        field_7_docinfo2 = (byte) unused4.setBoolean(field_7_docinfo2, value);

    }

    /**
     * Sets the unused5 field value.
     *
     */
    public void setUnused5(byte value) {
        field_8_docinfo3 = (short) unused5.setValue(field_8_docinfo3, value);

    }

    /**
     * Set the view field for the DOP record.
     */
    public void setView(short field_32_view) {
        this.field_32_view = field_32_view;
    }

    /**
     * Set the virusinfo field for the DOP record.
     */
    public void setVirusinfo(int field_43_virusinfo) {
        this.field_43_virusinfo = field_43_virusinfo;
    }

    /**
     * Sets the wScaleSaved field value.
     *
     */
    public void setWScaleSaved(short value) {
        field_32_view = (short) wScaleSaved.setValue(field_32_view, value);

    }

    /**
     * Set the wSpare field for the DOP record.
     */
    public void setWSpare(int field_10_wSpare) {
        this.field_10_wSpare = field_10_wSpare;
    }

    /**
     * Set the wSpare2 field for the DOP record.
     */
    public void setWSpare2(int field_13_wSpare2) {
        this.field_13_wSpare2 = field_13_wSpare2;
    }

    /**
     * Sets the wvkSaved field value.
     *
     */
    public void setWvkSaved(byte value) {
        field_32_view = (short) wvkSaved.setValue(field_32_view, value);

    }

    /**
     * Sets the zkSaved field value.
     *
     */
    public void setZkSaved(byte value) {
        field_32_view = (short) zkSaved.setValue(field_32_view, value);

    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("[DOP]\n");

        buffer.append("    .formatFlags          = ");
        buffer.append(" (").append(getFormatFlags()).append(" )\n");
        buffer.append("         .fFacingPages             = ").append(isFFacingPages()).append('\n');
        buffer.append("         .fWidowControl            = ").append(isFWidowControl()).append('\n');
        buffer.append("         .fPMHMainDoc              = ").append(isFPMHMainDoc()).append('\n');
        buffer.append("         .grfSupression            = ").append(getGrfSupression()).append('\n');
        buffer.append("         .fpc                      = ").append(getFpc()).append('\n');
        buffer.append("         .unused1                  = ").append(isUnused1()).append('\n');

        buffer.append("    .unused2              = ");
        buffer.append(" (").append(getUnused2()).append(" )\n");

        buffer.append("    .footnoteInfo         = ");
        buffer.append(" (").append(getFootnoteInfo()).append(" )\n");
        buffer.append("         .rncFtn                   = ").append(getRncFtn()).append('\n');
        buffer.append("         .nFtn                     = ").append(getNFtn()).append('\n');

        buffer.append("    .fOutlineDirtySave    = ");
        buffer.append(" (").append(getFOutlineDirtySave()).append(" )\n");

        buffer.append("    .docinfo              = ");
        buffer.append(" (").append(getDocinfo()).append(" )\n");
        buffer.append("         .fOnlyMacPics             = ").append(isFOnlyMacPics()).append('\n');
        buffer.append("         .fOnlyWinPics             = ").append(isFOnlyWinPics()).append('\n');
        buffer.append("         .fLabelDoc                = ").append(isFLabelDoc()).append('\n');
        buffer.append("         .fHyphCapitals            = ").append(isFHyphCapitals()).append('\n');
        buffer.append("         .fAutoHyphen              = ").append(isFAutoHyphen()).append('\n');
        buffer.append("         .fFormNoFields            = ").append(isFFormNoFields()).append('\n');
        buffer.append("         .fLinkStyles              = ").append(isFLinkStyles()).append('\n');
        buffer.append("         .fRevMarking              = ").append(isFRevMarking()).append('\n');

        buffer.append("    .docinfo1             = ");
        buffer.append(" (").append(getDocinfo1()).append(" )\n");
        buffer.append("         .fBackup                  = ").append(isFBackup()).append('\n');
        buffer.append("         .fExactCWords             = ").append(isFExactCWords()).append('\n');
        buffer.append("         .fPagHidden               = ").append(isFPagHidden()).append('\n');
        buffer.append("         .fPagResults              = ").append(isFPagResults()).append('\n');
        buffer.append("         .fLockAtn                 = ").append(isFLockAtn()).append('\n');
        buffer.append("         .fMirrorMargins           = ").append(isFMirrorMargins()).append('\n');
        buffer.append("         .unused3                  = ").append(isUnused3()).append('\n');
        buffer.append("         .fDfltTrueType            = ").append(isFDfltTrueType()).append('\n');

        buffer.append("    .docinfo2             = ");
        buffer.append(" (").append(getDocinfo2()).append(" )\n");
        buffer.append("         .fPagSupressTopSpacing     = ").append(isFPagSupressTopSpacing()).append('\n');
        buffer.append("         .fProtEnabled             = ").append(isFProtEnabled()).append('\n');
        buffer.append("         .fDispFormFldSel          = ").append(isFDispFormFldSel()).append('\n');
        buffer.append("         .fRMView                  = ").append(isFRMView()).append('\n');
        buffer.append("         .fRMPrint                 = ").append(isFRMPrint()).append('\n');
        buffer.append("         .unused4                  = ").append(isUnused4()).append('\n');
        buffer.append("         .fLockRev                 = ").append(isFLockRev()).append('\n');
        buffer.append("         .fEmbedFonts              = ").append(isFEmbedFonts()).append('\n');

        buffer.append("    .docinfo3             = ");
        buffer.append(" (").append(getDocinfo3()).append(" )\n");
        buffer.append("         .oldfNoTabForInd          = ").append(isOldfNoTabForInd()).append('\n');
        buffer.append("         .oldfNoSpaceRaiseLower     = ").append(isOldfNoSpaceRaiseLower()).append('\n');
        buffer.append("         .oldfSuppressSpbfAfterPageBreak     = ").append(isOldfSuppressSpbfAfterPageBreak())
                .append('\n');
        buffer.append("         .oldfWrapTrailSpaces      = ").append(isOldfWrapTrailSpaces()).append('\n');
        buffer.append("         .oldfMapPrintTextColor     = ").append(isOldfMapPrintTextColor()).append('\n');
        buffer.append("         .oldfNoColumnBalance      = ").append(isOldfNoColumnBalance()).append('\n');
        buffer.append("         .oldfConvMailMergeEsc     = ").append(isOldfConvMailMergeEsc()).append('\n');
        buffer.append("         .oldfSupressTopSpacing     = ").append(isOldfSupressTopSpacing()).append('\n');
        buffer.append("         .oldfOrigWordTableRules     = ").append(isOldfOrigWordTableRules()).append('\n');
        buffer.append("         .oldfTransparentMetafiles     = ").append(isOldfTransparentMetafiles()).append('\n');
        buffer.append("         .oldfShowBreaksInFrames     = ").append(isOldfShowBreaksInFrames()).append('\n');
        buffer.append("         .oldfSwapBordersFacingPgs     = ").append(isOldfSwapBordersFacingPgs()).append('\n');
        buffer.append("         .unused5                  = ").append(getUnused5()).append('\n');

        buffer.append("    .dxaTab               = ");
        buffer.append(" (").append(getDxaTab()).append(" )\n");

        buffer.append("    .wSpare               = ");
        buffer.append(" (").append(getWSpare()).append(" )\n");

        buffer.append("    .dxaHotz              = ");
        buffer.append(" (").append(getDxaHotz()).append(" )\n");

        buffer.append("    .cConsexHypLim        = ");
        buffer.append(" (").append(getCConsexHypLim()).append(" )\n");

        buffer.append("    .wSpare2              = ");
        buffer.append(" (").append(getWSpare2()).append(" )\n");

        buffer.append("    .dttmCreated          = ");
        buffer.append(" (").append(getDttmCreated()).append(" )\n");

        buffer.append("    .dttmRevised          = ");
        buffer.append(" (").append(getDttmRevised()).append(" )\n");

        buffer.append("    .dttmLastPrint        = ");
        buffer.append(" (").append(getDttmLastPrint()).append(" )\n");

        buffer.append("    .nRevision            = ");
        buffer.append(" (").append(getNRevision()).append(" )\n");

        buffer.append("    .tmEdited             = ");
        buffer.append(" (").append(getTmEdited()).append(" )\n");

        buffer.append("    .cWords               = ");
        buffer.append(" (").append(getCWords()).append(" )\n");

        buffer.append("    .cCh                  = ");
        buffer.append(" (").append(getCCh()).append(" )\n");

        buffer.append("    .cPg                  = ");
        buffer.append(" (").append(getCPg()).append(" )\n");

        buffer.append("    .cParas               = ");
        buffer.append(" (").append(getCParas()).append(" )\n");

        buffer.append("    .Edn                  = ");
        buffer.append(" (").append(getEdn()).append(" )\n");
        buffer.append("         .rncEdn                   = ").append(getRncEdn()).append('\n');
        buffer.append("         .nEdn                     = ").append(getNEdn()).append('\n');

        buffer.append("    .Edn1                 = ");
        buffer.append(" (").append(getEdn1()).append(" )\n");
        buffer.append("         .epc                      = ").append(getEpc()).append('\n');
        buffer.append("         .nfcFtnRef1               = ").append(getNfcFtnRef1()).append('\n');
        buffer.append("         .nfcEdnRef1               = ").append(getNfcEdnRef1()).append('\n');
        buffer.append("         .fPrintFormData           = ").append(isFPrintFormData()).append('\n');
        buffer.append("         .fSaveFormData            = ").append(isFSaveFormData()).append('\n');
        buffer.append("         .fShadeFormData           = ").append(isFShadeFormData()).append('\n');
        buffer.append("         .fWCFtnEdn                = ").append(isFWCFtnEdn()).append('\n');

        buffer.append("    .cLines               = ");
        buffer.append(" (").append(getCLines()).append(" )\n");

        buffer.append("    .cWordsFtnEnd         = ");
        buffer.append(" (").append(getCWordsFtnEnd()).append(" )\n");

        buffer.append("    .cChFtnEdn            = ");
        buffer.append(" (").append(getCChFtnEdn()).append(" )\n");

        buffer.append("    .cPgFtnEdn            = ");
        buffer.append(" (").append(getCPgFtnEdn()).append(" )\n");

        buffer.append("    .cParasFtnEdn         = ");
        buffer.append(" (").append(getCParasFtnEdn()).append(" )\n");

        buffer.append("    .cLinesFtnEdn         = ");
        buffer.append(" (").append(getCLinesFtnEdn()).append(" )\n");

        buffer.append("    .lKeyProtDoc          = ");
        buffer.append(" (").append(getLKeyProtDoc()).append(" )\n");

        buffer.append("    .view                 = ");
        buffer.append(" (").append(getView()).append(" )\n");
        buffer.append("         .wvkSaved                 = ").append(getWvkSaved()).append('\n');
        buffer.append("         .wScaleSaved              = ").append(getWScaleSaved()).append('\n');
        buffer.append("         .zkSaved                  = ").append(getZkSaved()).append('\n');
        buffer.append("         .fRotateFontW6            = ").append(isFRotateFontW6()).append('\n');
        buffer.append("         .iGutterPos               = ").append(isIGutterPos()).append('\n');

        buffer.append("    .docinfo4             = ");
        buffer.append(" (").append(getDocinfo4()).append(" )\n");
        buffer.append("         .fNoTabForInd             = ").append(isFNoTabForInd()).append('\n');
        buffer.append("         .fNoSpaceRaiseLower       = ").append(isFNoSpaceRaiseLower()).append('\n');
        buffer.append("         .fSupressSpdfAfterPageBreak     = ").append(isFSupressSpdfAfterPageBreak())
                .append('\n');
        buffer.append("         .fWrapTrailSpaces         = ").append(isFWrapTrailSpaces()).append('\n');
        buffer.append("         .fMapPrintTextColor       = ").append(isFMapPrintTextColor()).append('\n');
        buffer.append("         .fNoColumnBalance         = ").append(isFNoColumnBalance()).append('\n');
        buffer.append("         .fConvMailMergeEsc        = ").append(isFConvMailMergeEsc()).append('\n');
        buffer.append("         .fSupressTopSpacing       = ").append(isFSupressTopSpacing()).append('\n');
        buffer.append("         .fOrigWordTableRules      = ").append(isFOrigWordTableRules()).append('\n');
        buffer.append("         .fTransparentMetafiles     = ").append(isFTransparentMetafiles()).append('\n');
        buffer.append("         .fShowBreaksInFrames      = ").append(isFShowBreaksInFrames()).append('\n');
        buffer.append("         .fSwapBordersFacingPgs     = ").append(isFSwapBordersFacingPgs()).append('\n');
        buffer.append("         .fSuppressTopSPacingMac5     = ").append(isFSuppressTopSPacingMac5()).append('\n');
        buffer.append("         .fTruncDxaExpand          = ").append(isFTruncDxaExpand()).append('\n');
        buffer.append("         .fPrintBodyBeforeHdr      = ").append(isFPrintBodyBeforeHdr()).append('\n');
        buffer.append("         .fNoLeading               = ").append(isFNoLeading()).append('\n');
        buffer.append("         .fMWSmallCaps             = ").append(isFMWSmallCaps()).append('\n');

        buffer.append("    .adt                  = ");
        buffer.append(" (").append(getAdt()).append(" )\n");

        buffer.append("    .doptypography        = ");
        buffer.append(" (").append(getDoptypography()).append(" )\n");

        buffer.append("    .dogrid               = ");
        buffer.append(" (").append(getDogrid()).append(" )\n");

        buffer.append("    .docinfo5             = ");
        buffer.append(" (").append(getDocinfo5()).append(" )\n");
        buffer.append("         .lvl                      = ").append(getLvl()).append('\n');
        buffer.append("         .fGramAllDone             = ").append(isFGramAllDone()).append('\n');
        buffer.append("         .fGramAllClean            = ").append(isFGramAllClean()).append('\n');
        buffer.append("         .fSubsetFonts             = ").append(isFSubsetFonts()).append('\n');
        buffer.append("         .fHideLastVersion         = ").append(isFHideLastVersion()).append('\n');
        buffer.append("         .fHtmlDoc                 = ").append(isFHtmlDoc()).append('\n');
        buffer.append("         .fSnapBorder              = ").append(isFSnapBorder()).append('\n');
        buffer.append("         .fIncludeHeader           = ").append(isFIncludeHeader()).append('\n');
        buffer.append("         .fIncludeFooter           = ").append(isFIncludeFooter()).append('\n');
        buffer.append("         .fForcePageSizePag        = ").append(isFForcePageSizePag()).append('\n');
        buffer.append("         .fMinFontSizePag          = ").append(isFMinFontSizePag()).append('\n');

        buffer.append("    .docinfo6             = ");
        buffer.append(" (").append(getDocinfo6()).append(" )\n");
        buffer.append("         .fHaveVersions            = ").append(isFHaveVersions()).append('\n');
        buffer.append("         .fAutoVersions            = ").append(isFAutoVersions()).append('\n');

        buffer.append("    .asumyi               = ");
        buffer.append(" (").append(getAsumyi()).append(" )\n");

        buffer.append("    .cChWS                = ");
        buffer.append(" (").append(getCChWS()).append(" )\n");

        buffer.append("    .cChWSFtnEdn          = ");
        buffer.append(" (").append(getCChWSFtnEdn()).append(" )\n");

        buffer.append("    .grfDocEvents         = ");
        buffer.append(" (").append(getGrfDocEvents()).append(" )\n");

        buffer.append("    .virusinfo            = ");
        buffer.append(" (").append(getVirusinfo()).append(" )\n");
        buffer.append("         .fVirusPrompted           = ").append(isFVirusPrompted()).append('\n');
        buffer.append("         .fVirusLoadSafe           = ").append(isFVirusLoadSafe()).append('\n');
        buffer.append("         .KeyVirusSession30        = ").append(getKeyVirusSession30()).append('\n');

        buffer.append("    .Spare                = ");
        buffer.append(" (").append(getSpare()).append(" )\n");

        buffer.append("    .reserved1            = ");
        buffer.append(" (").append(getReserved1()).append(" )\n");

        buffer.append("    .reserved2            = ");
        buffer.append(" (").append(getReserved2()).append(" )\n");

        buffer.append("    .cDBC                 = ");
        buffer.append(" (").append(getCDBC()).append(" )\n");

        buffer.append("    .cDBCFtnEdn           = ");
        buffer.append(" (").append(getCDBCFtnEdn()).append(" )\n");

        buffer.append("    .reserved             = ");
        buffer.append(" (").append(getReserved()).append(" )\n");

        buffer.append("    .nfcFtnRef            = ");
        buffer.append(" (").append(getNfcFtnRef()).append(" )\n");

        buffer.append("    .nfcEdnRef            = ");
        buffer.append(" (").append(getNfcEdnRef()).append(" )\n");

        buffer.append("    .hpsZoonFontPag       = ");
        buffer.append(" (").append(getHpsZoonFontPag()).append(" )\n");

        buffer.append("    .dywDispPag           = ");
        buffer.append(" (").append(getDywDispPag()).append(" )\n");

        buffer.append("[/DOP]\n");
        return buffer.toString();
    }

} // END OF CLASS

