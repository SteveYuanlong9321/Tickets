package com.google.mlkit.vision.text.pipeline;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbaaj;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpb;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbf {
    static Rect zba(List list, Matrix matrix) {
        Iterator it = list.iterator();
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            Point point = (Point) it.next();
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
        }
        RectF rectF = new RectF(iMin, iMin2, iMax, iMax2);
        if (matrix != null) {
            matrix.mapRect(rectF);
        }
        Rect rect = new Rect();
        rectF.round(rect);
        return rect;
    }

    static zbpb zbb(zbaaj zbaajVar) {
        if (zbaajVar.zbi()) {
            return zbaajVar.zbc().zbd();
        }
        return zbaajVar.zbH() ? zbaajVar.zbf().zbc() : zbaajVar.zbe();
    }

    static List zbc(zbpb zbpbVar) {
        Point[] pointArr = new Point[4];
        double dSin = Math.sin(Math.toRadians(zbpbVar.zba()));
        double dCos = Math.cos(Math.toRadians(zbpbVar.zba()));
        pointArr[0] = new Point(zbpbVar.zbd(), zbpbVar.zbe());
        Point point = new Point((int) (((double) zbpbVar.zbd()) + (((double) zbpbVar.zbf()) * dCos)), (int) (((double) zbpbVar.zbe()) + (((double) zbpbVar.zbf()) * dSin)));
        pointArr[1] = point;
        pointArr[2] = new Point((int) (((double) point.x) - (((double) zbpbVar.zbc()) * dSin)), (int) (((double) pointArr[1].y) + (((double) zbpbVar.zbc()) * dCos)));
        pointArr[3] = new Point(pointArr[0].x + (pointArr[2].x - pointArr[1].x), pointArr[0].y + (pointArr[2].y - pointArr[1].y));
        return Arrays.asList(pointArr);
    }
}
