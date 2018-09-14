/*      */ package com.hwit;
/*      */ 
/*      */ import android.content.ContentResolver;
/*      */ import android.content.Context;
/*      */ import android.content.Intent;
/*      */ import android.os.HwitInterface;
/*      */ import android.os.IWiegandService;
/*      */ import android.os.IWiegandService.Stub;
/*      */ import android.os.ServiceManager;
/*      */ import android.util.Log;
/*      */ import java.io.File;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.IOException;
/*      */ import java.io.OutputStream;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.io.PrintWriter;
/*      */ 
/*      */ public class HwitManager
/*      */ {
/*      */   static final String TAG = "HwitManager";
/*      */   static final String SVERSION = "V102@20180728";
/*      */   
/*      */   public static void DBG(String buf)
/*      */   {
/*   25 */     if (HwitInterface.HwitIsInterfaceDebugOpen()) {
/*   26 */       Log.i("HwitManager", buf);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetVersion()
/*      */   {
/*   38 */     String version = "20180415_v1.0.2_V102@20180728";
/*   39 */     return version;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitSetMouseRightKey(String mode)
/*      */   {
/*   56 */     DBG("HwitsetMouseRightKey =" + mode);
/*   57 */     return HwitInterface.HwitSetMouseRightKey(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetMouseRightKey()
/*      */   {
/*   71 */     return HwitInterface.HwitGetMouseRightKey();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetSlientInstallApp(int mode)
/*      */   {
/*   85 */     DBG("HwitsetSlientInstallApp =" + mode);
/*   86 */     HwitInterface.HwitSetSlientInstallApp(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetSlientInstallApp()
/*      */   {
/*   99 */     return HwitInterface.HwitGetSlientInstallApp();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetLcdDensity(int lcddensity)
/*      */   {
/*  112 */     DBG("HwitsetDensity,lcddensity=" + lcddensity);
/*  113 */     HwitInterface.HwitSetLcdDensity(lcddensity);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetLcdDensity()
/*      */   {
/*  126 */     return HwitInterface.HwitGetLcdDensity();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetHWrotation(int hwrotation)
/*      */   {
/*  138 */     DBG("HwitsetHWrotation,hwrotation=" + hwrotation);
/*  139 */     HwitInterface.HwitSetHWrotation(hwrotation);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetHWrotation()
/*      */   {
/*  151 */     DBG("HwitgetHWrotation");
/*  152 */     return HwitInterface.HwitGetHWrotation();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetRotation(int rotation)
/*      */   {
/*  165 */     DBG("HwitSetRotation ,rotation= " + rotation);
/*  166 */     HwitInterface.HwitSetRotation(rotation);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetRotation()
/*      */   {
/*  179 */     int rotation = HwitInterface.HwitGetRotation();
/*  180 */     DBG("HwitGetRotation ,rotation= " + rotation);
/*  181 */     return rotation;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitEnableHardKB()
/*      */   {
/*  193 */     DBG("HwitEnableHardKB");
/*  194 */     HwitInterface.HwitEnableHardKB();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitDisableHardKB()
/*      */   {
/*  207 */     DBG("HwitDisableHardKB");
/*  208 */     HwitInterface.HwitDisableHardKB();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitIsHardKBEnable()
/*      */   {
/*  221 */     DBG("HwitIsHardKBEnable=");
/*  222 */     return HwitInterface.HwitIsHardKBEnable();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitShowSoftKey()
/*      */   {
/*  235 */     DBG("HwitShowSoftKey");
/*  236 */     HwitInterface.HwitShowSoftKey();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitHideSoftKey()
/*      */   {
/*  248 */     DBG("HwitHideSoftKey");
/*  249 */     HwitInterface.HwitHideSoftKey();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitSetnetHostName(String value)
/*      */   {
/*  262 */     return HwitInterface.HwitSetnetHostName(value);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetnetHostName()
/*      */   {
/*  274 */     return HwitInterface.HwitGetnetHostName();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetSwapTouchXY(int mode)
/*      */   {
/*  298 */     DBG("HwitSetSwapTouchXY =" + mode);
/*  299 */     HwitInterface.HwitSetSwapTouchXY(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetSwapTouchXY()
/*      */   {
/*  321 */     return HwitInterface.HwitGetSwapTouchXY();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetTimeZone(Context context, String newTimeZone)
/*      */   {
/*  333 */     Intent intent = new Intent();
/*  334 */     intent.setAction("com.hwit.interface.actionid");
/*  335 */     intent.putExtra("actionid", 2129);
/*  336 */     intent.putExtra("hwitstring0", newTimeZone);
/*  337 */     context.sendBroadcast(intent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetTime(Context context, int year, int month, int day, int hour, int minute, int second)
/*      */   {
/*  350 */     Intent intent = new Intent();
/*  351 */     intent.setAction("com.hwit.interface.actionid");
/*  352 */     intent.putExtra("actionid", 2131);
/*  353 */     intent.putExtra("Year", year);
/*  354 */     intent.putExtra("Month", month);
/*  355 */     intent.putExtra("Day", day);
/*  356 */     intent.putExtra("Hour", hour);
/*  357 */     intent.putExtra("Minute", minute);
/*  358 */     intent.putExtra("Second", second);
/*  359 */     context.sendBroadcast(intent);
/*  360 */     DBG("HwitSetTime ,year=" + year + ",month=" + month + ",day=" + day + ",hour=" + hour + ",minute=" + minute + ",second=" + second);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitStartSoftWatchDog(Context c, int delay, int delayshutdown)
/*      */   {
/*  375 */     Intent intent = new Intent();
/*  376 */     intent.setAction("com.hwit.interface.actionid");
/*  377 */     intent.putExtra("actionid", 2133);
/*  378 */     intent.putExtra("hwitint0", delay);
/*  379 */     intent.putExtra("hwitint1", delayshutdown);
/*      */     
/*  381 */     c.sendBroadcast(intent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitStopSoftWatchDog(Context c)
/*      */   {
/*  393 */     Intent intent = new Intent();
/*  394 */     intent.setAction("com.hwit.interface.actionid");
/*  395 */     intent.putExtra("actionid", 2135);
/*      */     
/*  397 */     c.sendBroadcast(intent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitFeedSoftWatchDog(Context c)
/*      */   {
/*  409 */     Intent intent = new Intent();
/*  410 */     intent.setAction("com.hwit.interface.actionid");
/*  411 */     intent.putExtra("actionid", 2137);
/*      */     
/*  413 */     c.sendBroadcast(intent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitIsSoftWatchDogOpened(Context c)
/*      */   {
/*  425 */     return HwitInterface.HwitIsSoftWatchDogOpened();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetAutoPowerOnAlarm(String ontime)
/*      */   {
/*  437 */     HwitInterface.HwitSetAutoPowerOnAlarm(ontime);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitCancelAutoPowerOnAlarm()
/*      */   {
/*  448 */     DBG("HwitCancelAutoPowerOnAlarm");
/*  449 */     HwitInterface.HwitCancelAutoPowerOnAlarm();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetAutoShutdownAlarm(Context context, String time)
/*      */   {
/*  462 */     DBG("HwitSetAutoShutdownAlarm ,offtime=" + time);
/*  463 */     Intent intent = new Intent();
/*  464 */     intent.setAction("com.hwit.interface.actionid");
/*  465 */     intent.putExtra("actionid", 2143);
/*  466 */     intent.putExtra("hwitstring0", time);
/*  467 */     context.sendBroadcast(intent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitCancelAutoShutdownAlarm(Context context)
/*      */   {
/*  479 */     DBG("HwitSetAutoShutdownAlarm");
/*  480 */     HwitInterface.HwitCancelAutoShutdownAlarm(context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetModel(String model)
/*      */   {
/*  492 */     DBG("HwitSetModel=" + model);
/*  493 */     HwitInterface.HwitSetModel(model);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetModel()
/*      */   {
/*  505 */     String ret = HwitInterface.HwitGetModel();
/*  506 */     DBG("HwitGetModel=" + ret);
/*  507 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetLocalIPState(boolean enable)
/*      */   {
/*  521 */     DBG("HwitSetLocalIPState,enable=" + enable);
/*  522 */     HwitInterface.HwitSetLocalIPState(enable);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitGetLocalIPState()
/*      */   {
/*  536 */     boolean ret = HwitInterface.HwitGetLocalIPState();
/*  537 */     DBG("HwitGetLocalIPState=" + ret);
/*  538 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetLocalIP(Context context, String ipvalue, String eth, int index)
/*      */   {
/*  553 */     DBG("HwitSetLocalIP,ipvalue=" + ipvalue + "  eth=" + eth + "  index=" + index);
/*  554 */     HwitInterface.HwitSetLocalIP(context, ipvalue, eth, index);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetLocalIP(int index)
/*      */   {
/*  565 */     return HwitInterface.HwitGetLocalIP(index);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetAuxTouch(String tp_name)
/*      */   {
/*  577 */     HwitInterface.HwitSetAuxTouch(tp_name);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetAuxTouch()
/*      */   {
/*  588 */     String ret = HwitInterface.HwitGetAuxTouch();
/*  589 */     DBG("HwitGetAuxTouch=" + ret);
/*  590 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetRilPath(String rilpath)
/*      */   {
/*  602 */     DBG("HwitSetRilPath,rilpath=" + rilpath);
/*  603 */     HwitInterface.HwitSetRilPath(rilpath);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetRilPath()
/*      */   {
/*  615 */     String rilpath = HwitInterface.HwitGetRilPath();
/*  616 */     DBG("HwitGetRilPath,rilpath=" + rilpath);
/*  617 */     return rilpath;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitStopWDT()
/*      */   {
/*  628 */     DBG("HwitStopWDT");
/*  629 */     HwitInterface.HwitStopMcu();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitStartWDT()
/*      */   {
/*  640 */     DBG("HwitStartWDT");
/*  641 */     HwitInterface.HwitStartMcu();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitPoweroffWDT()
/*      */   {
/*  652 */     DBG("HwitPoweroffWDT");
/*  653 */     HwitInterface.HwitShutMcu();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetGpsUart(String ttys)
/*      */   {
/*  664 */     DBG("HwitSetGpsUart,ttys=" + ttys);
/*  665 */     HwitInterface.HwitSetGpsUart(ttys);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetGpsUart()
/*      */   {
/*  676 */     String HwitGetGpsUart = HwitInterface.HwitGetGpsUart();
/*  677 */     DBG("HwitGetGpsUart,gpsuart=" + HwitGetGpsUart);
/*  678 */     return HwitGetGpsUart;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetStaticIp(Context context, String ip, String gateway, String netmask, String dns1, String dns2)
/*      */   {
/*  696 */     DBG("HwitSetStaticIp");
/*  697 */     Intent intent = new Intent();
/*  698 */     intent.setAction("com.hwit.interface.actionid");
/*  699 */     intent.putExtra("actionid", 2165);
/*  700 */     intent.putExtra("hwitstring0", ip);
/*  701 */     intent.putExtra("hwitstring1", gateway);
/*  702 */     intent.putExtra("hwitstring2", netmask);
/*  703 */     intent.putExtra("hwitstring3", dns1);
/*  704 */     intent.putExtra("hwitstring4", dns2);
/*  705 */     context.sendBroadcast(intent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetDhcpIp(Context context)
/*      */   {
/*  717 */     DBG("HwitSetDhcpIp");
/*  718 */     Intent intent = new Intent();
/*  719 */     intent.setAction("com.hwit.interface.actionid");
/*  720 */     intent.putExtra("actionid", 2167);
/*  721 */     context.sendBroadcast(intent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetUsbDeviceAutoPermission(int mode)
/*      */   {
/*  732 */     DBG("HwitsetUsbDevicePermission =" + mode);
/*  733 */     HwitInterface.HwitSetUsbDeviceAutoPermission(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetUsbDeviceAutoPermission()
/*      */   {
/*  745 */     int ret = HwitInterface.HwitGetUsbDeviceAutoPermission();
/*  746 */     DBG("HwitGetUsbDevicePermission =" + ret);
/*  747 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetUsbHostmode(int mode)
/*      */   {
/*  760 */     DBG("HwitsetUsbHostmode =" + mode);
/*  761 */     HwitInterface.HwitSetUsbHostmode(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetUsbHostmode()
/*      */   {
/*  773 */     int ret = HwitInterface.HwitGetUsbHostmode();
/*  774 */     DBG("HwitgetUsbHostmode =" + ret);
/*  775 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetOpenUsbDebug(Context context)
/*      */   {
/*  786 */     ContentResolver resolver = context.getContentResolver();
/*  787 */     DBG("HwitsetOpenUsbDebug");
/*  788 */     HwitInterface.HwitSetOpenUsbDebug(resolver);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetCloseUsbDebug(Context context)
/*      */   {
/*  799 */     ContentResolver resolver = context.getContentResolver();
/*  800 */     DBG("HwitsetCloseUsbDebug");
/*  801 */     HwitInterface.HwitSetCloseUsbDebug(resolver);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitIsUsbDebugOpen(Context context)
/*      */   {
/*  813 */     ContentResolver resolver = context.getContentResolver();
/*  814 */     int ret = HwitInterface.HwitIsUsbDebugOpen(resolver);
/*  815 */     DBG("HwitIsUsbDebugOpen=" + ret);
/*  816 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitSetOpenAdbNetDebug(int port)
/*      */   {
/*  827 */     String ret = HwitInterface.HwitSetOpenAdbNetDebug(port);
/*  828 */     DBG("HwitSetOpenAdbNetDebug,port=" + port + ",ret=" + ret);
/*  829 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitSetCloseAdbNetDebug()
/*      */   {
/*  840 */     String ret = HwitInterface.HwitSetCloseAdbNetDebug();
/*  841 */     DBG("HwitSetCloseAdbNetDebug=" + ret);
/*  842 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitIsAdbNetDebugOpen()
/*      */   {
/*  854 */     int ret = HwitInterface.HwitIsAdbNetDebugOpen();
/*  855 */     DBG("HwitIsAdbNetDebugOpen=" + ret);
/*  856 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void HwitOpenDevelopment() {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void HwitCloseDevelopment() {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetForceRotation(int mode)
/*      */   {
/*  892 */     DBG("HwitsetForceRotation =" + mode);
/*  893 */     HwitInterface.HwitSetForceRotation(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetForceRotation()
/*      */   {
/*  906 */     int ret = HwitInterface.HwitGetForceRotation();
/*  907 */     DBG("HwitgetForceRotation=" + ret);
/*  908 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetSwapHdmiXY(int mode)
/*      */   {
/*  920 */     DBG("HwitsetSwapHdmiXY =" + mode);
/*  921 */     HwitInterface.HwitSetSwapHdmiXY(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetSwapHdmiXY()
/*      */   {
/*  934 */     DBG("HwitgetSwapHdmiXY");
/*  935 */     return HwitInterface.HwitGetSwapHdmiXY();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetHdmiRotation(int mode)
/*      */   {
/*  947 */     DBG("HwitsetHdmiRotation =" + mode);
/*  948 */     HwitInterface.HwitSetHdmiRotation(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetHdmiRotation()
/*      */   {
/*  960 */     DBG("HwitgetHdmiRotation");
/*  961 */     return HwitInterface.HwitGetHdmiRotation();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetExternalScreenRotation(int mode)
/*      */   {
/*  974 */     DBG("HwitsetExternalScreenRotation =" + mode);
/*  975 */     HwitInterface.HwitSetExternalScreenRotation(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitGetExternalScreenRotation()
/*      */   {
/*  987 */     boolean ret = HwitInterface.HwitGetExternalScreenRotation();
/*  988 */     DBG("HwitGetExternalScreenRotation =" + ret);
/*  989 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetHideSystemBar(Context context)
/*      */   {
/* 1001 */     DBG("HwitsetHideSystemBar");
/* 1002 */     HwitInterface.HwitSetHideSystemBar(context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetShowSystemBar(Context context)
/*      */   {
/* 1014 */     DBG("HwitsetShowSystemBar");
/* 1015 */     HwitInterface.HwitSetShowSystemBar(context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetSystemBarIsHide()
/*      */   {
/* 1027 */     int ret = HwitInterface.HwitGetSystemBarIsHide();
/* 1028 */     DBG("HwitgetSystemBarIsHide = " + ret);
/* 1029 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetDisableSlideShowSysBar(int mode)
/*      */   {
/* 1041 */     DBG("HwitsetDisableSlideShowSysBar =" + mode);
/* 1042 */     HwitInterface.HwitSetDisableSlideShowSysBar(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetDisableSlideShowSysBar()
/*      */   {
/* 1054 */     int ret = HwitInterface.HwitGetDisableSlideShowSysBar();
/* 1055 */     DBG("HwitgetDisableSlideShowSysBar =" + ret);
/* 1056 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitShowVoiceIcon()
/*      */   {
/* 1067 */     DBG("HwitShowVoiceIcon");
/* 1068 */     HwitInterface.HwitShowVoiceIcon();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitHideVoiceIcon()
/*      */   {
/* 1079 */     DBG("HwitHideVoiceIcon");
/* 1080 */     HwitInterface.HwitHideVoiceIcon();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitIsVoiceIconShow()
/*      */   {
/* 1092 */     boolean ret = HwitInterface.HwitIsVoiceIconShow();
/* 1093 */     DBG("HwitIsVoiceIconShow=" + ret);
/* 1094 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitShowShutdownIcon()
/*      */   {
/* 1105 */     DBG("HwitShowShutdownIcon");
/* 1106 */     HwitInterface.HwitShowShutdownIcon();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitHideShutdownIcon()
/*      */   {
/* 1117 */     DBG("HwitHideShutdownIcon");
/* 1118 */     HwitInterface.HwitHideShutdownIcon();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitIsShutdownIconShow()
/*      */   {
/* 1130 */     boolean ret = HwitInterface.HwitIsShutdownIconShow();
/* 1131 */     DBG("HwitIsShutdownIconShow=" + ret);
/* 1132 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitShowRotationIcon()
/*      */   {
/* 1143 */     DBG("HwitShowRotationIcon");
/* 1144 */     HwitInterface.HwitShowRotationIcon();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitHideRotationIcon()
/*      */   {
/* 1155 */     DBG("HwitHideRotationIcon");
/* 1156 */     HwitInterface.HwitHideRotationIcon();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitIsRotationIconShow()
/*      */   {
/* 1168 */     boolean ret = HwitInterface.HwitIsRotationIconShow();
/* 1169 */     DBG("HwitIsRotationIconShow=" + ret);
/* 1170 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitShowHidebarIcon()
/*      */   {
/* 1181 */     DBG("HwitShowHidebarIcon");
/* 1182 */     HwitInterface.HwitShowHidebarIcon();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitHideHidebarIcon()
/*      */   {
/* 1193 */     DBG("HwitHideHidebarIcon");
/* 1194 */     HwitInterface.HwitHideHidebarIcon();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitIsHidebarIconShow()
/*      */   {
/* 1207 */     boolean ret = HwitInterface.HwitIsHidebarIconShow();
/* 1208 */     DBG("HwitIsHidebarIconShow=" + ret);
/* 1209 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitAddBrightness() {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSubBrightness() {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitGetCurBrightness(ContentResolver resolver)
/*      */   {
/* 1246 */     HwitInterface.HwitGetCurBrightness(resolver);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetCurBrightness(ContentResolver resolver, int brightness)
/*      */   {
/* 1259 */     HwitInterface.HwitSetCurBrightness(resolver, brightness);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitOpenBacklight()
/*      */   {
/* 1270 */     DBG("HwitOpenBacklight");
/* 1271 */     HwitInterface.HwitOpenBacklight();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitCloseBacklight()
/*      */   {
/* 1282 */     DBG("HwitCloseBacklight");
/* 1283 */     HwitInterface.HwitCloseBacklight();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitOpenAuxBacklight()
/*      */   {
/* 1294 */     DBG("HwitOpenAuxBacklight");
/* 1295 */     HwitInterface.HwitOpenAuxBacklight();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitCloseAuxBacklight()
/*      */   {
/* 1306 */     DBG("HwitCloseAuxBacklight");
/* 1307 */     HwitInterface.HwitCloseAuxBacklight();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long HwitGetBacklightSleepTime(Context context)
/*      */   {
/* 1319 */     ContentResolver resolver = context.getContentResolver();
/* 1320 */     long currentTimeout = HwitInterface.HwitGetBacklightSleepTime(resolver);
/* 1321 */     DBG("HwitgetBacklightSleepTime =" + currentTimeout);
/* 1322 */     return currentTimeout;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long HwitSetBacklightSleepTime(Context context, int sleeptime)
/*      */   {
/* 1335 */     ContentResolver resolver = context.getContentResolver();
/* 1336 */     long ret = HwitInterface.HwitSetBacklightSleepTime(resolver, sleeptime);
/* 1337 */     DBG("HwitSetBacklightSleepTime set =" + sleeptime + ",get =" + ret);
/* 1338 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitStartScreenShot(Context context)
/*      */   {
/* 1350 */     DBG("HwitStartScreenShot");
/* 1351 */     HwitInterface.HwitStartScreenShot(context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetScreenShotPicPath()
/*      */   {
/* 1362 */     DBG("HwitGetScreenShotPicPath");
/* 1363 */     return HwitInterface.HwitGetScreenShotPicPath();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitStartScreenShot(Context context, String path)
/*      */   {
/* 1374 */     DBG("HwitStartScreenShot =" + path);
/* 1375 */     HwitInterface.HwitStartScreenShot(context, path);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetInstallAppWhiteList(Context context)
/*      */   {
/* 1387 */     String ret = HwitInterface.HwitGetInstallAppWhiteList(context);
/* 1388 */     DBG("HwitgetInstallAppWhiteList = " + ret);
/* 1389 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitAddApkToWhiteList(Context context, String whitename)
/*      */   {
/* 1401 */     DBG("HwitAddApkToWhiteList:" + whitename);
/* 1402 */     HwitInterface.HwitAddApkToWhiteList(context, whitename);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitRemoveApkFromWhiteList(Context context, String whitename)
/*      */   {
/* 1414 */     DBG("HwitRemoveApkFromWhiteList:" + whitename);
/* 1415 */     HwitInterface.HwitRemoveApkFromWhiteList(context, whitename);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetWhiteList(Context context, String whitelist)
/*      */   {
/* 1427 */     DBG("HwitSetWhiteList:" + whitelist);
/* 1428 */     HwitInterface.HwitSetWhiteList(context, whitelist);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitClearApkWhiteList(Context context)
/*      */   {
/* 1439 */     DBG("HwitClearApkWhiteList");
/* 1440 */     HwitInterface.HwitClearApkWhiteList(context);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitIsEnableInstall(Context context, String packagename)
/*      */   {
/* 1453 */     boolean ret = HwitInterface.HwitIsEnableInstall(context, packagename);
/* 1454 */     DBG("HwitIsEnableInstall,packagename=" + packagename + " ,ret=" + ret);
/* 1455 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitSetBootupAppNameWhenPoweron(String startpkgname, String startatyname)
/*      */   {
/* 1468 */     DBG("HwitsetBootupAppNameWhenPoweron,package =" + startpkgname + ",activity=" + startatyname);
/* 1469 */     return HwitInterface.HwitSetBootupAppNameWhenPoweron(startpkgname, startatyname);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetBootupAppPkgname()
/*      */   {
/* 1480 */     String name = HwitInterface.HwitGetBootupAppPkgname();
/* 1481 */     DBG("HwitGetBootupAppPkgname,package =" + name);
/* 1482 */     return name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetBootupAppAtyname()
/*      */   {
/* 1493 */     String name = HwitInterface.HwitGetBootupAppAtyname();
/* 1494 */     DBG("HwitGetBootupAppAtyname,package =" + name);
/* 1495 */     return name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitStartActivity(Context context, String pkgname, String atyname)
/*      */   {
/* 1509 */     DBG("HwitStartActivity,pkgname=" + pkgname + ",atyname" + atyname);
/* 1510 */     HwitInterface.HwitStartActivity(context, pkgname, atyname);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitInstallApp(Context mcontext, String apppath, String pkgname, String atyname)
/*      */   {
/* 1525 */     HwitInterface.HwitInstallApp(mcontext, apppath, pkgname, atyname);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitOpenHDMI()
/*      */   {
/* 1536 */     DBG("HwitOpenHDMI");
/* 1537 */     HwitInterface.HwitOpenHDMI();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitCloseHDMI()
/*      */   {
/* 1548 */     DBG("HwitCloseHDMI");
/* 1549 */     HwitInterface.HwitCloseHDMI();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetVoiceInput(int value)
/*      */   {
/* 1563 */     DBG("HwitSetVoiceInput=" + value);
/* 1564 */     HwitInterface.HwitSetMicInput(value);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetVoiceInput()
/*      */   {
/* 1577 */     int ret = HwitInterface.HwitGetMicInput();
/* 1578 */     DBG("HwitGetVoiceInput=" + ret);
/* 1579 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetMicGain(int value)
/*      */   {
/* 1591 */     DBG("HwitSetMicGain=" + value);
/* 1592 */     HwitInterface.HwitSetMicGain(value);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetMicGain()
/*      */   {
/* 1603 */     int ret = HwitInterface.HwitGetMicGain();
/* 1604 */     DBG("HwitGetMicGain=" + ret);
/* 1605 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetVoiceOutput(int value)
/*      */   {
/* 1619 */     DBG("HwitSetVoiceOutput=" + value);
/* 1620 */     HwitInterface.HwitSetSpeakerOutput(value);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetVoiceOutput()
/*      */   {
/* 1633 */     int ret = HwitInterface.HwitGetSpeakerOutput();
/* 1634 */     DBG("HwitGetVoiceOutput=" + ret);
/* 1635 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetSpeakerGain(int value)
/*      */   {
/* 1646 */     DBG("HwitSetSpeakerGain=" + value);
/* 1647 */     HwitInterface.HwitSetSpeakerGain(value);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetSpeakerGain()
/*      */   {
/* 1658 */     int ret = HwitInterface.HwitGetSpeakerGain();
/* 1659 */     DBG("HwitGetSpeakerGain=" + ret);
/* 1660 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetEarphoneGain(int value)
/*      */   {
/* 1671 */     DBG("HwitSetEarphoneGain=" + value);
/* 1672 */     HwitInterface.HwitSetEarphoneGain(value);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetEarphoneGain()
/*      */   {
/* 1683 */     int ret = HwitInterface.HwitGetEarphoneGain();
/* 1684 */     DBG("HwitGetEarphoneGain=" + ret);
/* 1685 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitHdmiInAudioIsEnable()
/*      */   {
/* 1700 */     boolean ret = HwitInterface.HwitHdmiInAudioIsEnable();
/* 1701 */     DBG("HwitHdmiInAudioIsEnable=" + ret);
/* 1702 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitsetHdmiInAudioEnable()
/*      */   {
/* 1713 */     DBG("HwitsetHdmiInAudioEnable");
/* 1714 */     HwitInterface.HwitsetHdmiInAudioEnable();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitsetHdmiInAudioDisable()
/*      */   {
/* 1725 */     DBG("HwitsetHdmiInAudioDisable");
/* 1726 */     HwitInterface.HwitsetHdmiInAudioDisable();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitHdmiOutAudioIsEnable()
/*      */   {
/* 1739 */     boolean ret = HwitInterface.HwitHdmiOutAudioIsEnable();
/* 1740 */     DBG("HwitHdmiOutAudioIsEnable=" + ret);
/* 1741 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitEnableHdmiOutAudio()
/*      */   {
/* 1752 */     DBG("HwitEnableHdmiOutAudio");
/* 1753 */     HwitInterface.HwitEnableHdmiOutAudio();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitDisableHdmiOutAudio()
/*      */   {
/* 1764 */     DBG("HwitDisableHdmiOutAudio");
/* 1765 */     HwitInterface.HwitDisableHdmiOutAudio();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitOpenHdmiInAudio()
/*      */   {
/* 1777 */     DBG("HwitOpenHdmiInAudio");
/* 1778 */     HwitInterface.HwitOpenHdmiInAudio();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitCloseHdmiInAudio()
/*      */   {
/* 1789 */     DBG("HwitCloseHdmiInAudio");
/* 1790 */     HwitInterface.HwitCloseHdmiInAudio();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetPkgAtyWhenHdmiIn(String pkg, String aty)
/*      */   {
/* 1803 */     DBG("HwitSetPkgAtyWhenHdmiIn,package=" + pkg + ",activity=" + aty);
/* 1804 */     HwitInterface.HwitSetPkgAtyWhenHdmiIn(pkg, aty);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetPkgAtyWhenHdmiIn()
/*      */   {
/* 1816 */     String ret = HwitInterface.HwitGetPkgAtyWhenHdmiIn();
/* 1817 */     DBG("HwitGetPkgAtyWhenHdmiIn=" + ret);
/* 1818 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitEnableDualAudioOutput()
/*      */   {
/* 1830 */     DBG("HwitEnableDualAudioOutput");
/* 1831 */     HwitInterface.HwitEnableDualAudioOutput();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitDisableDualAudioOutput()
/*      */   {
/* 1842 */     DBG("HwitDisableDualAudioOutput");
/* 1843 */     HwitInterface.HwitDisableDualAudioOutput();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitDualAudioOutputIsEnable()
/*      */   {
/* 1855 */     boolean ret = HwitInterface.HwitDualAudioOutputIsEnable();
/* 1856 */     DBG("HwitDualAudioOutputIsEnable=" + ret);
/* 1857 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitSetCamera0Facing(String mode)
/*      */   {
/* 1870 */     DBG("HwitsetCamera0Facing =" + mode);
/* 1871 */     return HwitInterface.HwitSetCamera0Facing(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetCamera0Facing()
/*      */   {
/* 1883 */     String ret = HwitInterface.HwitGetCamera0Facing();
/* 1884 */     DBG("HwitgetCamera0Facing=" + ret);
/* 1885 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetCamera0Mirror(int mode)
/*      */   {
/* 1897 */     DBG("HwitsetCamera0Mirror =" + mode);
/* 1898 */     HwitInterface.HwitSetCamera0Mirror(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitGetCamera0Mirror()
/*      */   {
/* 1910 */     boolean ret = HwitInterface.HwitGetCamera0Mirror();
/* 1911 */     DBG("HwitGetCamera0Mirror=" + ret);
/* 1912 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetCamera0Rotation(int mode)
/*      */   {
/* 1924 */     DBG("HwitsetCamera0Rotation =" + mode);
/* 1925 */     HwitInterface.HwitSetCamera0Rotation(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetCamera0Rotation()
/*      */   {
/* 1936 */     int ret = HwitInterface.HwitGetCamera0Rotation();
/* 1937 */     DBG("HwitGetCamera0Rotation=" + ret);
/* 1938 */     return Integer.valueOf(ret).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetCamera0UIRotation(int mode)
/*      */   {
/* 1951 */     DBG("HwitsetCamera0UIRotation =" + mode);
/* 1952 */     HwitInterface.HwitSetCamera0UIRotation(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetCamera0UIRotation()
/*      */   {
/* 1963 */     int ret = HwitInterface.HwitGetCamera0UIRotation();
/* 1964 */     DBG("HwitGetCamera0UIRotation=" + ret);
/* 1965 */     return Integer.valueOf(ret).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetCamera0PreviewWH(int width, int height)
/*      */   {
/* 1977 */     DBG("HwitsetCamera0PreviewWH,Preview size is" + width + "x" + height);
/* 1978 */     HwitInterface.HwitSetCamera0PreviewWH(width, height);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetCamera0PreviewWidth()
/*      */   {
/* 1989 */     int ret = HwitInterface.HwitGetCamera0PreviewWidth();
/* 1990 */     DBG("HwitgetCamera0PreviewWidth=" + ret);
/* 1991 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetCamera0PreviewHeight()
/*      */   {
/* 2002 */     int ret = HwitInterface.HwitGetCamera0PreviewHeight();
/* 2003 */     DBG("HwitgetCamera0PreviewHeight=" + ret);
/* 2004 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitSetCamera1Facing(String mode)
/*      */   {
/* 2017 */     DBG("HwitsetCamera1Facing =" + mode);
/* 2018 */     return HwitInterface.HwitSetCamera1Facing(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetCamera1Facing()
/*      */   {
/* 2030 */     String ret = HwitInterface.HwitGetCamera1Facing();
/* 2031 */     DBG("HwitgetCamera1Facing=" + ret);
/* 2032 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetCamera1Mirror(int mode)
/*      */   {
/* 2044 */     DBG("HwitsetCamera1Mirror =" + mode);
/* 2045 */     HwitInterface.HwitSetCamera1Mirror(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitGetCamera1Mirror()
/*      */   {
/* 2057 */     boolean ret = HwitInterface.HwitGetCamera1Mirror();
/* 2058 */     DBG("HwitGetCamera1Mirror=" + ret);
/* 2059 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetCamera1Rotation(int mode)
/*      */   {
/* 2071 */     DBG("HwitsetCamera1Rotation =" + mode);
/* 2072 */     HwitInterface.HwitSetCamera1Rotation(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetCamera1Rotation()
/*      */   {
/* 2083 */     int ret = HwitInterface.HwitGetCamera1Rotation();
/* 2084 */     DBG("HwitGetCamera1Rotation=" + ret);
/* 2085 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetCamera1UIRotation(int mode)
/*      */   {
/* 2098 */     DBG("HwitsetCamera1UIRotation =" + mode);
/* 2099 */     HwitInterface.HwitSetCamera1UIRotation(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetCamera1UIRotation()
/*      */   {
/* 2110 */     int ret = HwitInterface.HwitGetCamera1UIRotation();
/* 2111 */     DBG("HwitGetCamera1UIRotation=" + ret);
/* 2112 */     return Integer.valueOf(ret).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetCamera1PreviewWH(int width, int height)
/*      */   {
/* 2124 */     DBG("HwitsetCamera1PreviewWH,Preview size is" + width + "x" + height);
/* 2125 */     HwitInterface.HwitSetCamera1PreviewWH(width, height);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetCamera1PreviewWidth()
/*      */   {
/* 2136 */     int ret = HwitInterface.HwitGetCamera1PreviewWidth();
/* 2137 */     DBG("HwitgetCamera1PreviewWidth=" + ret);
/* 2138 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetCamera1PreviewHeight()
/*      */   {
/* 2149 */     int ret = HwitInterface.HwitGetCamera1PreviewHeight();
/* 2150 */     DBG("HwitgetCamera1PreviewHeight=" + ret);
/* 2151 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetOneCameraAsTwo(boolean value)
/*      */   {
/* 2164 */     DBG("HwitSetOneCameraAsTwo=" + value);
/* 2165 */     HwitInterface.HwitSetOneCameraAsTwo(value);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean HwitIsOneCameraAsTwo()
/*      */   {
/* 2178 */     boolean ret = HwitInterface.HwitIsOneCameraAsTwo();
/* 2179 */     DBG("HwitIsOneCameraAsTwo=" + ret);
/* 2180 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetAutoUpdate(int mode)
/*      */   {
/* 2193 */     DBG("HwitsetAutoUpdate =" + mode);
/* 2194 */     HwitInterface.HwitSetAutoUpdate(mode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetAutoUpdate()
/*      */   {
/* 2206 */     int ret = HwitInterface.HwitGetAutoUpdate();
/* 2207 */     DBG("HwitgetAutoUpdate =" + ret);
/* 2208 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitSetOtaServerIP(String ipaddress)
/*      */   {
/* 2219 */     DBG("HwitsetOtaServerIP=" + ipaddress);
/* 2220 */     return HwitInterface.HwitSetOtaServerIP(ipaddress);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetOtaServerIP()
/*      */   {
/* 2231 */     String ret = HwitInterface.HwitGetOtaServerIP();
/* 2232 */     DBG("HwitgetOtaServerIP=" + ret);
/* 2233 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitSetOtaServerPort(String port)
/*      */   {
/* 2244 */     DBG("HwitsetOtaServerPort=" + port);
/* 2245 */     return HwitInterface.HwitSetOtaServerPort(port);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetOtaServerPort()
/*      */   {
/* 2256 */     String ret = HwitInterface.HwitGetOtaServerPort();
/* 2257 */     DBG("HwitgetOtaServerPort=" + ret);
/* 2258 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetWifiMac(Context c)
/*      */   {
/* 2270 */     String ret = HwitInterface.HwitGetWifiMac(c);
/* 2271 */     DBG("HwitgetWifiMac =" + ret);
/* 2272 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetEthernetMac()
/*      */   {
/* 2283 */     String ret = HwitInterface.HwitGetEthernetMac();
/* 2284 */     DBG("HwitgetEthernetMac =" + ret);
/* 2285 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetSerial()
/*      */   {
/* 2296 */     String ret = HwitInterface.HwitGetSerial();
/* 2297 */     DBG("HwitgetSerial =" + ret);
/* 2298 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetDDRMemorySize()
/*      */   {
/* 2309 */     String ret = HwitInterface.HwitGetDDRMemorySize();
/* 2310 */     DBG("HwitGetDDRSize =" + ret);
/* 2311 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetTotalEMMCMemorySize()
/*      */   {
/* 2323 */     String ret = HwitInterface.HwitGetTotalEMMCMemorySize();
/* 2324 */     DBG("HwitGetTotalFlashSize =" + ret);
/* 2325 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetImei(Context c)
/*      */   {
/* 2336 */     String ret = HwitInterface.HwitGetImei(c);
/* 2337 */     DBG("HwitGetImei =" + ret);
/* 2338 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String HwitGetBluetoothMac()
/*      */   {
/* 2349 */     String ret = HwitInterface.HwitGetBluetoothMac();
/* 2350 */     DBG("HwitGetBluetoothMac =" + ret);
/* 2351 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetIOValue(int io_number, int io_value)
/*      */   {
/* 2363 */     DBG("HwitSetIOValue,id=" + io_number + ",value = " + io_value);
/* 2364 */     HwitInterface.HwitSetIOValue(io_number, io_value);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetIOValue(int io_number)
/*      */   {
/* 2376 */     int ret = HwitInterface.HwitGetIOValue(io_number);
/* 2377 */     DBG("HwitGetIOValue,id=" + io_number + ",value = " + ret);
/* 2378 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetIrqIOValue(int io_number)
/*      */   {
/* 2390 */     int ret = HwitInterface.HwitGetIrqIOValue(io_number);
/* 2391 */     DBG("HwitGetIrqIOValue,id=" + io_number + ",value = " + ret);
/* 2392 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitGetWiegandValue()
/*      */   {
/* 2405 */     int rdate = -1;
/* 2406 */     IWiegandService wiegandService = null;
/* 2407 */     wiegandService = IWiegandService.Stub.asInterface(
/* 2408 */       ServiceManager.getService("wiegand"));
/*      */     try {
/* 2410 */       rdate = wiegandService.getVal();
/*      */     } catch (Exception e) {
/* 2412 */       DBG("wiegandService " + e);
/*      */     }
/* 2414 */     DBG("HwitGetWiegandValue=" + rdate);
/* 2415 */     return rdate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitSetWiegandValue(int value, int bits)
/*      */   {
/* 2430 */     IWiegandService wiegandService = null;
/* 2431 */     wiegandService = IWiegandService.Stub.asInterface(
/* 2432 */       ServiceManager.getService("wiegand"));
/*      */     try {
/* 2434 */       wiegandService.setVal(value, bits);
/*      */     } catch (Exception e) {
/* 2436 */       DBG("wiegandService " + e);
/*      */     }
/* 2438 */     DBG("HwitSetWiegandValue=" + value + "," + bits);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitShutDownSystem(Context mcontext)
/*      */   {
/* 2450 */     DBG("HwitShutDownSystem");
/*      */     
/* 2452 */     Intent intent = new Intent();
/* 2453 */     intent.setAction("com.hwit.interface.actionid");
/* 2454 */     intent.putExtra("actionid", 2903);
/* 2455 */     mcontext.sendBroadcast(intent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitRebootSystem(Context mcontext)
/*      */   {
/* 2467 */     DBG("HwitRebootSystem");
/* 2468 */     Intent intent = new Intent();
/* 2469 */     intent.setAction("com.hwit.interface.actionid");
/* 2470 */     intent.putExtra("actionid", 2913);
/* 2471 */     mcontext.sendBroadcast(intent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitOpenWifi(Context mcontext)
/*      */   {
/* 2484 */     DBG("HwitOpenWifi");
/* 2485 */     HwitInterface.HwitOpenWifi(mcontext);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitCloseWifi(Context mcontext)
/*      */   {
/* 2496 */     DBG("HwitCloseWifi");
/* 2497 */     HwitInterface.HwitCloseWifi(mcontext);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitRecoverySystem(Context mcontext)
/*      */   {
/* 2508 */     DBG("HwitRecoverySystem");
/* 2509 */     HwitInterface.HwitRecoverySystem(mcontext);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitGotoSleep(Context mcontext)
/*      */   {
/* 2520 */     DBG("HwitGotoSleep");
/* 2521 */     Intent intent = new Intent();
/* 2522 */     intent.setAction("com.hwit.interface.actionid");
/* 2523 */     intent.putExtra("actionid", 2921);
/* 2524 */     mcontext.sendBroadcast(intent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitWakeUp(Context mcontext)
/*      */   {
/* 2536 */     DBG("HwitWakeUp");
/* 2537 */     Intent intent = new Intent();
/* 2538 */     intent.setAction("com.hwit.interface.actionid");
/* 2539 */     intent.putExtra("actionid", 2923);
/* 2540 */     mcontext.sendBroadcast(intent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitFetchSystemLog() {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void HwitExecutCMD(Context context, String cmd)
/*      */   {
/* 2559 */     Intent intent3 = new Intent("android.intent.action.shell");
/* 2560 */     if ((cmd != null) && (!cmd.isEmpty()))
/*      */     {
/* 2562 */       intent3.putExtra("shellstr", cmd);
/* 2563 */       context.sendBroadcast(intent3);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static void HwitWriteNand(Context context, String imei, String btmac, String wifimac, String ethmac, String serial)
/*      */   {
/* 2570 */     String writecmd = "/system/bin/rk_vendor_rw";
/*      */     
/* 2572 */     if ((imei != null) && (!imei.isEmpty()))
/*      */     {
/* 2574 */       writecmd = writecmd + " -i " + imei;
/*      */     }
/* 2576 */     if ((btmac != null) && (!btmac.isEmpty()))
/*      */     {
/* 2578 */       writecmd = writecmd + " -b " + btmac;
/*      */     }
/* 2580 */     if ((wifimac != null) && (!wifimac.isEmpty()))
/*      */     {
/* 2582 */       writecmd = writecmd + " -w " + wifimac;
/*      */     }
/* 2584 */     if ((ethmac != null) && (!ethmac.isEmpty()))
/*      */     {
/* 2586 */       writecmd = writecmd + " -e " + ethmac;
/*      */     }
/* 2588 */     if ((serial != null) && (!serial.isEmpty()))
/*      */     {
/* 2590 */       writecmd = writecmd + " -s " + serial;
/*      */     }
/* 2592 */     HwitExecutCMD(context, writecmd);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitWriteEthernetMac(Context context, String mac)
/*      */   {
/* 2605 */     HwitWriteNand(context, null, null, null, mac, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitWriteWifiMac(Context context, String mac)
/*      */   {
/* 2617 */     HwitWriteNand(context, null, null, mac, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitWriteBluetoothMac(Context context, String mac)
/*      */   {
/* 2629 */     HwitWriteNand(context, null, mac, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitWriteSerial(Context context, String sn)
/*      */   {
/* 2641 */     HwitWriteNand(context, null, null, null, null, sn);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void HwitWriteImei(Context context, String imei)
/*      */   {
/* 2653 */     HwitWriteNand(context, imei, null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static java.util.List<String> getAvailableCpuFreq()
/*      */   {
/* 2664 */     return ArmFreqUtils.getAvailableFrequencies();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitSetFixedCpuFreq(String freq)
/*      */   {
/*      */     try
/*      */     {
/* 2677 */       ArmFreqUtils.setGovernorMode("userspace");
/*      */     } catch (FileNotFoundException e) {
/* 2679 */       e.printStackTrace();
/* 2680 */       return -1;
/*      */     } catch (IOException e) {
/* 2682 */       e.printStackTrace();
/* 2683 */       return -1;
/*      */     }
/*      */     try {
/* 2686 */       ArmFreqUtils.setSpeedFreq(Integer.valueOf(freq).intValue());
/*      */     } catch (FileNotFoundException e) {
/* 2688 */       e.printStackTrace();
/* 2689 */       return -1;
/*      */     }
/*      */     catch (IOException e) {
/* 2692 */       e.printStackTrace();
/* 2693 */       return -1;
/*      */     }
/*      */     
/* 2696 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitSetRandomCpuFreq()
/*      */   {
/*      */     try
/*      */     {
/* 2710 */       ArmFreqUtils.setGovernorMode("interactive");
/*      */     } catch (FileNotFoundException e) {
/* 2712 */       e.printStackTrace();
/* 2713 */       return -1;
/*      */     } catch (IOException e) {
/* 2715 */       e.printStackTrace();
/* 2716 */       return -1;
/*      */     }
/*      */     
/* 2719 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int HwitSetCameraX7022ExposureRange(int xstart, int ystart, int xwin, int ywin)
/*      */   {
/* 2736 */     File x7022_file = new File("/sys/x7022/x7022");
/* 2737 */     if (!x7022_file.exists())
/* 2738 */       return -1;
/* 2739 */     String ret = HwitWriteStringToFile(x7022_file, "overscan " + String.valueOf(xstart) + "," + String.valueOf(ystart) + "," + String.valueOf(xwin) + "," + String.valueOf(ywin));
/* 2740 */     if (ret == null)
/* 2741 */       return -1;
/* 2742 */     if (Integer.valueOf(ret).intValue() == 0)
/* 2743 */       return -1;
/* 2744 */     return 0;
/*      */   }
/*      */   
/*      */   public static String HwitWriteStringToFile(File file, String str)
/*      */   {
/* 2749 */     if (!file.exists())
/*      */     {
/* 2751 */       Log.e("HwitManager", "File not exist");
/* 2752 */       return null;
/*      */     }
/* 2754 */     OutputStream output = null;
/* 2755 */     OutputStreamWriter outputWrite = null;
/* 2756 */     PrintWriter print = null;
/*      */     
/*      */     try
/*      */     {
/* 2760 */       output = new java.io.FileOutputStream(file);
/* 2761 */       outputWrite = new OutputStreamWriter(output);
/* 2762 */       print = new PrintWriter(outputWrite);
/*      */       
/* 2764 */       print.print(str);
/* 2765 */       print.flush();
/* 2766 */       output.close();
/* 2767 */       return str;
/*      */     } catch (IOException e) {
/* 2769 */       e.printStackTrace();
/*      */     }
/* 2771 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */   public String function()
/*      */   {
/* 2777 */     String ret = "V102@20180728\n";
/* 2778 */     ret = ret + "添加按客户指定路径保存截屏图片接口@20180811\n";
/* 2779 */     ret = ret + "添加副屏背光开关接口@20180811\n";
/* 2780 */     ret = ret + "添加韦根写入接口@20180810\n";
/* 2781 */     ret = ret + "定时关机采用广播发送@20180809\n";
/* 2782 */     ret = ret + "软件看门狗改为广播发送@20180809\n";
/* 2783 */     ret = ret + "解决客户调用设置时间时区没有权限的问题@20180807\n";
/* 2784 */     ret = ret + "添加韦根读取接口@20180806\n";
/* 2785 */     ret = ret + "添加读取中断脚IO状态接口@20180805\n";
/* 2786 */     ret = ret + "添加设置X7022关注区域接口@20180728\n";
/* 2787 */     ret = ret + "添加设置CPU频率接口@20180702\n";
/* 2788 */     ret = ret + "添加获取蓝牙Mac接口@20180415\n";
/* 2789 */     ret = ret + "添加烧写mac等到用户区接口@20180415\n";
/* 2790 */     ret = ret + "修改重启，关机接口，否则普通用户没权限调用@20180415\n";
/* 2791 */     return ret;
/*      */   }
/*      */ }


/* Location:              C:\Users\luclo\OneDrive\桌面\万智联接口\com.hwit(6).jar!\com\hwit\HwitManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */