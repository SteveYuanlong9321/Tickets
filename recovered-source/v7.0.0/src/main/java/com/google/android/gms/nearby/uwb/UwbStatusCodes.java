package com.google.android.gms.nearby.uwb;

import com.google.android.gms.common.api.CommonStatusCodes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class UwbStatusCodes extends CommonStatusCodes {
    public static final int ARCORE_APK_TOO_OLD = 42012;
    public static final int ARCORE_CAMERA_NOT_AVAILABLE = 42008;
    public static final int ARCORE_DEVICE_NOT_COMPATIBLE = 42014;
    public static final int ARCORE_MISSING_CAMERA_PERMISSION = 42010;
    public static final int ARCORE_MISSING_GL_CONTEXT = 42009;
    public static final int ARCORE_NOT_INSTALLED = 42011;
    public static final int ARCORE_SDK_TOO_OLD = 42013;
    public static final int INVALID_API_CALL = 42002;
    public static final int NULL_RANGING_DEVICE = 42001;
    public static final int PRECISION_FINDING_HARDWARE_AOA_PRECEDENCE = 42007;
    public static final int PRECISION_FINDING_NOT_AVAILABLE = 42006;
    public static final int RANGING_ALREADY_STARTED = 42003;
    public static final int SERVICE_NOT_AVAILABLE = 42000;
    public static final int STATUS_ERROR = 13;
    public static final int STATUS_OK = 0;
    public static final int UWB_SYSTEM_CALLBACK_FAILURE = 42005;

    private UwbStatusCodes() {
    }

    public static String zza(int i) {
        switch (i) {
            case SERVICE_NOT_AVAILABLE /* 42000 */:
                return "SERVICE_NOT_AVAILABLE";
            case NULL_RANGING_DEVICE /* 42001 */:
                return "NULL_RANGING_DEVICE";
            case INVALID_API_CALL /* 42002 */:
                return "INVALID_API_CALL";
            case RANGING_ALREADY_STARTED /* 42003 */:
                return "RANGING_ALREADY_STARTED";
            case 42004:
                return "MISSING_PERMISSION_UWB_RANGING";
            case UWB_SYSTEM_CALLBACK_FAILURE /* 42005 */:
                return "UWB_SYSTEM_CALLBACK_FAILURE";
            case PRECISION_FINDING_NOT_AVAILABLE /* 42006 */:
                return "PRECISION_FINDING_NOT_AVAILABLE";
            case PRECISION_FINDING_HARDWARE_AOA_PRECEDENCE /* 42007 */:
                return "PRECISION_FINDING_HARDWARE_AOA_PRECEDENCE";
            case ARCORE_CAMERA_NOT_AVAILABLE /* 42008 */:
                return "ARCORE_CAMERA_NOT_AVAILABLE";
            case ARCORE_MISSING_GL_CONTEXT /* 42009 */:
                return "ARCORE_MISSING_GL_CONTEXT";
            case ARCORE_MISSING_CAMERA_PERMISSION /* 42010 */:
                return "ARCORE_MISSING_CAMERA_PERMISSION";
            case ARCORE_NOT_INSTALLED /* 42011 */:
                return "ARCORE_NOT_INSTALLED";
            case ARCORE_APK_TOO_OLD /* 42012 */:
                return "ARCORE_APK_TOO_OLD";
            case ARCORE_SDK_TOO_OLD /* 42013 */:
                return "ARCORE_SDK_TOO_OLD";
            case ARCORE_DEVICE_NOT_COMPATIBLE /* 42014 */:
                return "ARCORE_DEVICE_NOT_COMPATIBLE";
            default:
                return CommonStatusCodes.getStatusCodeString(i);
        }
    }
}
