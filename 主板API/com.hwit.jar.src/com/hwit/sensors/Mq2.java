/*    */ package com.hwit.sensors;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ public class Mq2
/*    */ {
/* 11 */   final String MQ2_PARAM_PATH = "/sys/SensorsS0/SmokeSensor";
/* 12 */   final String TAG = "MQ2";
/*    */   
/*    */   public boolean IsExist()
/*    */   {
/* 16 */     File somke = new File("/sys/SensorsS0/SmokeSensor");
/* 17 */     if (somke.exists()) {
/* 18 */       return true;
/*    */     }
/* 20 */     return false;
/*    */   }
/*    */   
/*    */   public int isWarnning() {
/* 24 */     String smoke = Get1LineString("/sys/SensorsS0/SmokeSensor");
/* 25 */     if (smoke == null)
/* 26 */       return -1;
/* 27 */     String temp = smoke.substring(smoke.indexOf("iswarning=") + "iswarning=".length(), smoke.length());
/* 28 */     if (temp.equals("1")) {
/* 29 */       return 1;
/*    */     }
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */   private String Get1LineString(String path) {
/* 35 */     BufferedReader reader = null;
/* 36 */     String readline = null;
/*    */     try {
/* 38 */       reader = new BufferedReader(new FileReader(path));
/* 39 */       readline = reader.readLine();
/*    */     }
/*    */     catch (Exception e) {}finally {}
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     try
/*    */     {
/* 48 */       if (reader != null) {
/* 49 */         reader.close();
/*    */       }
/* 51 */       return readline;
/*    */     }
/*    */     catch (IOException localIOException) {}
/*    */     
/* 55 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\luclo\OneDrive\桌面\万智联接口\com.hwit(6).jar!\com\hwit\sensors\Mq2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */