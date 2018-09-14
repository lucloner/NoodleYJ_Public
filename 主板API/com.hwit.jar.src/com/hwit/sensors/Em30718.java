/*    */ package com.hwit.sensors;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Em30718
/*    */ {
/* 12 */   private String LightSensorPath = "/sys/SensorsL/LightSensor";
/* 13 */   private int MAX_VALUE = 4095;
/* 14 */   private int MIN_VALUE = 0;
/* 15 */   final String TAG = "EM30718";
/*    */   
/*    */   public boolean IsExist()
/*    */   {
/* 19 */     File light = new File(this.LightSensorPath);
/* 20 */     if (light.exists()) {
/* 21 */       return true;
/*    */     }
/* 23 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public String GetMinValue()
/*    */   {
/* 29 */     return String.valueOf(this.MIN_VALUE);
/*    */   }
/*    */   
/*    */ 
/*    */   public String GetMaxValue()
/*    */   {
/* 35 */     return String.valueOf(this.MAX_VALUE);
/*    */   }
/*    */   
/*    */ 
/*    */   public String GetLight()
/*    */   {
/* 41 */     String tmp = Get1LineString(this.LightSensorPath);
/* 42 */     if (tmp == null)
/* 43 */       return null;
/* 44 */     return tmp;
/*    */   }
/*    */   
/*    */   private String Get1LineString(String path) {
/* 48 */     BufferedReader reader = null;
/* 49 */     String readline = null;
/*    */     try {
/* 51 */       reader = new BufferedReader(new FileReader(path));
/* 52 */       readline = reader.readLine();
/*    */     }
/*    */     catch (Exception e) {}finally {}
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     try
/*    */     {
/* 61 */       if (reader != null) {
/* 62 */         reader.close();
/*    */       }
/* 64 */       return readline;
/*    */     }
/*    */     catch (IOException localIOException) {}
/*    */     
/* 68 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\luclo\OneDrive\桌面\万智联接口\com.hwit(6).jar!\com\hwit\sensors\Em30718.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */