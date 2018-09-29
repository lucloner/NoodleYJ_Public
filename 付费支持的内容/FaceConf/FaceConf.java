package com.yujin99.libyjface.exe;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

    public class FaceConf {
        public static int PreviewHeight = 720;
        public static int PreviewWidth = 1280;
        public static int MinFaceSize = 80;
        public static int NumberOfThreads = 2;
        public static int FaceAngle = 20;
        public static boolean PreviewOpaque = false;
        public static boolean KeepScreenOn = true;
        public static int CameraType = 1;
        public static byte skipTTY = 1;
        public static byte netOffline = 1;
        public static String fingerPrint = null;
        public static Object[] obj = new Object[]{"255.255.255.255", 1};
        private static int varCnt = obj.length;

        public static void main(String[] args) {
            try {
                if (args.length > 0) {
                    String[] str = args[0].split("\\|");
                    if (str.length > 0)
                        PreviewHeight = Integer.parseInt(str[0]);//PreviewHeight
                    if (str.length > 1)
                        PreviewWidth = Integer.parseInt(str[1]);//PreviewWidth
                    if (str.length > 2)
                        MinFaceSize = Integer.parseInt(str[2]);//MinFaceSize
                    if (str.length > 3)
                        NumberOfThreads = Integer.parseInt(str[3]);//NumberOfThreads
                    if (str.length > 4)
                        FaceAngle = Integer.parseInt(str[4]);//FaceAngle
                    if (str.length > 5)
                        PreviewOpaque = Boolean.getBoolean(str[5]);//PreviewOpaque
                    if (str.length > 6)
                        KeepScreenOn = Boolean.getBoolean(str[6]);//KeepScreenOn
                    if (str.length > 7)
                        CameraType = Integer.parseInt(str[7]);//CameraType
                    if (str.length > 8)
                        skipTTY = Byte.parseByte(str[8]);//skipTTY
                    if (str.length > 9)
                        netOffline = Byte.parseByte(str[9]);//netOffline
                    if (str.length > 10)
                        fingerPrint = str[10];//fingerPrint
                    if (str.length > 11)
                        obj[0] = str[11];//hostIP
                    if (str.length > 12)
                        obj[1] = Integer.parseInt(str[12]);//ICameraControl
                    if (str.length > 14) {
                        int oCnt = Integer.parseInt(str[str.length - 1]);
                        if(oCnt!=str.length-12)
                            throw new Exception("StrErr");
                        obj = new Object[oCnt];
                        for (int i = 0; i < oCnt; i++) {
                            obj[i] = str[i + 11];
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            printConf();
        }

        public static final byte[] printConf() {
            try {
                Object oi = getConf().clone();
                ByteArrayOutputStream byt = new ByteArrayOutputStream();
                ObjectOutputStream obj = new ObjectOutputStream(byt);
                obj.writeObject(oi);
                byte[] bytes = byt.toByteArray();
                System.out.println(java.util.Base64.getEncoder().encodeToString(bytes));
                return bytes;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public static final Object[] getConf() {
            return new Object[]{FaceConf.PreviewHeight, FaceConf.PreviewWidth, FaceConf.MinFaceSize, FaceConf.NumberOfThreads, FaceConf.FaceAngle, FaceConf.PreviewOpaque, FaceConf.KeepScreenOn, FaceConf.CameraType, FaceConf.skipTTY, FaceConf.netOffline, FaceConf.fingerPrint, FaceConf.obj};
        }

        private static final boolean setConf(Object[] obj) {
            boolean ret = false;
            try {
                ret = setConf((int) obj[0], (int) obj[1], (int) obj[2], (int) obj[3], (int) obj[4], (boolean) obj[5], (boolean) obj[6], (int) obj[7], (byte) obj[8], (byte) obj[9], (String) obj[10], (Object[]) obj[11]);
            } catch (Exception e) {
                FaceConf.PreviewHeight = 720;
                FaceConf.PreviewWidth = 1280;
                FaceConf.MinFaceSize = 80;
                FaceConf.NumberOfThreads = 2;
                FaceConf.FaceAngle = 20;
                FaceConf.PreviewOpaque = false;
                FaceConf.KeepScreenOn = true;
                FaceConf.CameraType = 1;
                FaceConf.skipTTY = 1;
                FaceConf.netOffline = 1;
                FaceConf.fingerPrint = null;
                FaceConf.obj = new Object[]{"255.255.255.255", 1};
                varCnt = FaceConf.obj.length;
                ret = false;
                //Log.e("YJFACE-CONF-2", e.getMessage());
            } finally {
                return ret;
            }
        }

        private static final boolean setConf(int PreviewHeight, int PreviewWidth, int MinFaceSize, int NumberOfThreads, int FaceAngle, boolean PreviewOpaque, boolean KeepScreenOn, int CameraType, byte skipTTY, byte netOffline, String fingerPrint, Object[] obj) {
            try {
                FaceConf.PreviewHeight = PreviewHeight;
                FaceConf.PreviewWidth = PreviewWidth;
                FaceConf.MinFaceSize = MinFaceSize;
                FaceConf.NumberOfThreads = NumberOfThreads;
                FaceConf.FaceAngle = FaceAngle;
                FaceConf.PreviewOpaque = PreviewOpaque;
                FaceConf.KeepScreenOn = KeepScreenOn;
                FaceConf.CameraType = CameraType;
                FaceConf.skipTTY = skipTTY;
                FaceConf.netOffline = netOffline;
                FaceConf.fingerPrint = fingerPrint;
                FaceConf.obj = obj.clone();
                varCnt = FaceConf.obj.length;
                return true;
            } catch (Exception e) {
                //Log.e("YJFACE-CONF-3", e.toString());
                throw e;
//                return false;
            }
        }
    }