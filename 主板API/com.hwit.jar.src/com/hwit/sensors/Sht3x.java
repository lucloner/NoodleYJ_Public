/*    */ package com.hwit.sensors;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Sht3x
/*    */ {
/* 12 */   private String TempraturePath = "/sys/SensorsTH/TempHumi";
/* 13 */   private String HumidityPath = "/sys/SensorsTH/TempHumi";
/* 14 */   final String TAG = "SHT3X";
/*    */   
/*    */   public boolean IsExist()
/*    */   {
/* 18 */     File th = new File(this.TempraturePath);
/* 19 */     if (th.exists()) {
/* 20 */       return true;
/*    */     }
/* 22 */     return false;
/*    */   }
/*    */   
/*    */   public String GetTemperature() {
/* 26 */     String tmp = Get1LineString(this.TempraturePath);
/* 27 */     if (tmp == null)
/* 28 */       return null;
/* 29 */     int p1 = tmp.indexOf("Temperature=");
/* 30 */     int p2 = tmp.indexOf(",Humidity=");
/* 31 */     int lenth = tmp.length();
/* 32 */     String temp = tmp.substring("Temperature=".length(), p2);
/* 33 */     float ftemp = Integer.valueOf(temp).intValue() / 10.0F;
/* 34 */     String humi = tmp.substring(p2 + ",Humidity=".length(), lenth);
/* 35 */     float fhumi = Integer.valueOf(humi).intValue() / 10.0F;
/* 36 */     return String.valueOf(ftemp);
/*    */   }
/*    */   
/*    */   public String GetHumidity()
/*    */   {
/* 41 */     String tmp = Get1LineString(this.TempraturePath);
/* 42 */     if (tmp == null)
/* 43 */       return null;
/* 44 */     int p1 = tmp.indexOf("Temperature=");
/* 45 */     int p2 = tmp.indexOf(",Humidity=");
/* 46 */     int lenth = tmp.length();
/* 47 */     String temp = tmp.substring("Temperature=".length(), p2);
/* 48 */     float ftemp = Integer.valueOf(temp).intValue() / 10.0F;
/* 49 */     String humi = tmp.substring(p2 + ",Humidity=".length(), lenth);
/* 50 */     float fhumi = Integer.valueOf(humi).intValue() / 10.0F;
/* 51 */     return String.valueOf(fhumi);
/*    */   }
/*    */   
/*    */   public String Get1LineString(String path) {
/* 55 */     BufferedReader reader = null;
/* 56 */     String readline = null;
/*    */     try {
/* 58 */       reader = new BufferedReader(new FileReader(path));
/* 59 */       readline = reader.readLine();
/*    */     }
/*    */     catch (Exception e) {}finally {}
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     try
/*    */     {
/* 68 */       if (reader != null) {
/* 69 */         reader.close();
/*    */       }
/* 71 */       return readline;
/*    */     }
/*    */     catch (IOException localIOException) {}
/*    */     
/* 75 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\luclo\OneDrive\桌面\万智联接口\com.hwit(6).jar!\com\hwit\sensors\Sht3x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */