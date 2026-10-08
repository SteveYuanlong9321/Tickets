package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class AztecReader implements Reader {
    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0040  */
    /* JADX WARN: Code duplicated, block: B:38:0x0066  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073 A[LOOP:0: B:41:0x0071->B:42:0x0073, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:45:0x0098  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a3  */
    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPoint[] points;
        int errorsCorrected;
        NotFoundException notFoundException;
        ResultPoint[] points2;
        int errorsCorrected2;
        FormatException formatException;
        ResultPoint[] resultPointArr;
        Result result;
        List<byte[]> byteSegments;
        String eCLevel;
        ResultPointCallback resultPointCallback;
        Detector detector = new Detector(binaryBitmap.getBlackMatrix());
        DecoderResult decoderResultDecode = null;
        try {
            AztecDetectorResult aztecDetectorResultDetect = detector.detect(false);
            points = aztecDetectorResultDetect.getPoints();
            try {
                errorsCorrected = aztecDetectorResultDetect.getErrorsCorrected();
                try {
                    errorsCorrected2 = errorsCorrected;
                    formatException = null;
                    decoderResultDecode = new Decoder().decode(aztecDetectorResultDetect);
                    points2 = points;
                    notFoundException = null;
                } catch (FormatException e) {
                    e = e;
                    errorsCorrected2 = errorsCorrected;
                    formatException = e;
                    points2 = points;
                    notFoundException = null;
                } catch (NotFoundException e2) {
                    e = e2;
                    ResultPoint[] resultPointArr2 = points;
                    notFoundException = e;
                    points2 = resultPointArr2;
                    errorsCorrected2 = errorsCorrected;
                    formatException = null;
                }
            } catch (FormatException e3) {
                e = e3;
                errorsCorrected = 0;
                errorsCorrected2 = errorsCorrected;
                formatException = e;
                points2 = points;
                notFoundException = null;
                if (decoderResultDecode == null) {
                    try {
                        AztecDetectorResult aztecDetectorResultDetect2 = detector.detect(true);
                        points2 = aztecDetectorResultDetect2.getPoints();
                        errorsCorrected2 = aztecDetectorResultDetect2.getErrorsCorrected();
                        decoderResultDecode = new Decoder().decode(aztecDetectorResultDetect2);
                    } catch (FormatException | NotFoundException e4) {
                        if (notFoundException != null) {
                            throw notFoundException;
                        }
                        if (formatException != null) {
                            throw formatException;
                        }
                        throw e4;
                    }
                }
                resultPointArr = points2;
                int i = errorsCorrected2;
                if (map != null) {
                    for (ResultPoint resultPoint : resultPointArr) {
                        resultPointCallback.foundPossibleResultPoint(resultPoint);
                    }
                }
                result = new Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), decoderResultDecode.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResultDecode.getByteSegments();
                if (byteSegments != null) {
                    result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                }
                eCLevel = decoderResultDecode.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                result.putMetadata(ResultMetadataType.ERRORS_CORRECTED, Integer.valueOf(i + decoderResultDecode.getErrorsCorrected().intValue()));
                result.putMetadata(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]z" + decoderResultDecode.getSymbologyModifier());
                return result;
            } catch (NotFoundException e5) {
                e = e5;
                errorsCorrected = 0;
                ResultPoint[] resultPointArr3 = points;
                notFoundException = e;
                points2 = resultPointArr3;
                errorsCorrected2 = errorsCorrected;
                formatException = null;
                if (decoderResultDecode == null) {
                    AztecDetectorResult aztecDetectorResultDetect3 = detector.detect(true);
                    points2 = aztecDetectorResultDetect3.getPoints();
                    errorsCorrected2 = aztecDetectorResultDetect3.getErrorsCorrected();
                    decoderResultDecode = new Decoder().decode(aztecDetectorResultDetect3);
                }
                resultPointArr = points2;
                int i2 = errorsCorrected2;
                if (map != null) {
                    while (i < r0) {
                        resultPointCallback.foundPossibleResultPoint(resultPoint);
                    }
                }
                result = new Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), decoderResultDecode.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResultDecode.getByteSegments();
                if (byteSegments != null) {
                    result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                }
                eCLevel = decoderResultDecode.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                result.putMetadata(ResultMetadataType.ERRORS_CORRECTED, Integer.valueOf(i2 + decoderResultDecode.getErrorsCorrected().intValue()));
                result.putMetadata(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]z" + decoderResultDecode.getSymbologyModifier());
                return result;
            }
        } catch (FormatException e6) {
            e = e6;
            points = null;
        } catch (NotFoundException e7) {
            e = e7;
            points = null;
        }
        if (decoderResultDecode == null) {
            AztecDetectorResult aztecDetectorResultDetect4 = detector.detect(true);
            points2 = aztecDetectorResultDetect4.getPoints();
            errorsCorrected2 = aztecDetectorResultDetect4.getErrorsCorrected();
            decoderResultDecode = new Decoder().decode(aztecDetectorResultDetect4);
        }
        resultPointArr = points2;
        int i3 = errorsCorrected2;
        if (map != null && (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            while (i < r0) {
                resultPointCallback.foundPossibleResultPoint(resultPoint);
            }
        }
        result = new Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), decoderResultDecode.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
        byteSegments = decoderResultDecode.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        eCLevel = decoderResultDecode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        result.putMetadata(ResultMetadataType.ERRORS_CORRECTED, Integer.valueOf(i3 + decoderResultDecode.getErrorsCorrected().intValue()));
        result.putMetadata(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]z" + decoderResultDecode.getSymbologyModifier());
        return result;
    }
}
