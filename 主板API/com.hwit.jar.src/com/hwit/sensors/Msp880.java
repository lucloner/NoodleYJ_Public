/*     */ package com.hwit.sensors;
/*     */ 
/*     */ import android.util.Log;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class Msp880
/*     */ {
/*     */   float s0;
/*     */   float stc1;
/*     */   float stc2;
/*     */   float ftc1;
/*     */   float ftc2;
/*     */   float f0;
/*     */   float ks;
/*     */   float Tbase;
/*     */   float Temp_a;
/*     */   float Temp_b;
/*     */   float Temp_c;
/*  22 */   final String MSP880_PARAM_PATH = "/sys/SensorsPT/GetParam";
/*  23 */   final String MSP880_PRESS_PATH = "/sys/SensorsPT/PressureSensor";
/*  24 */   final String MSP880_TEMPRATURE_PATH = "/sys/SensorsPT/TempratureSensor";
/*  25 */   final String TAG = "MSP880";
/*     */   
/*     */   public boolean IsExist()
/*     */   {
/*  29 */     File press = new File("/sys/SensorsPT/PressureSensor");
/*  30 */     if (press.exists()) {
/*  31 */       return true;
/*     */     }
/*  33 */     return false;
/*     */   }
/*     */   
/*     */   public boolean init()
/*     */   {
/*  38 */     Log.e("MSP880", "MSP880 INIT");
/*  39 */     return Configuration();
/*     */   }
/*     */   
/*     */   public float[] getPT() {
/*  43 */     float[] tempf = new float[2];
/*  44 */     String Stemprature = Get1LineString("/sys/SensorsPT/TempratureSensor");
/*  45 */     if (Stemprature == null)
/*     */     {
/*  47 */       tempf[0] = 65298.0F;
/*  48 */       tempf[1] = 65332.0F;
/*  49 */       return tempf;
/*     */     }
/*  51 */     String temp = Stemprature.substring("Temprature=".length(), Stemprature.length());
/*  52 */     long temprature = Integer.valueOf(temp).intValue();
/*  53 */     String Spress = Get1LineString("/sys/SensorsPT/PressureSensor");
/*  54 */     if (Spress == null)
/*     */     {
/*  56 */       tempf[0] = 65298.0F;
/*  57 */       tempf[1] = 65332.0F;
/*  58 */       return tempf;
/*     */     }
/*  60 */     temp = Spress.substring("Pressure=".length(), Spress.length());
/*  61 */     long press = Integer.valueOf(temp).intValue();
/*  62 */     return Calculate(temprature, press);
/*     */   }
/*     */   
/*     */ 
/*     */   private float[] Calculate(long temp_Read, long press_Read)
/*     */   {
/*  68 */     float Height_factor = 0.19029495F;
/*     */     
/*  70 */     float Ttemp = (float)temp_Read * 0.0078125F;
/*     */     
/*  72 */     float Temperature = this.Temp_a * Ttemp * Ttemp + this.Temp_b * Ttemp + this.Temp_c;
/*  73 */     float deltaT = Temperature - this.Tbase;
/*  74 */     float deltaT_square = deltaT * deltaT;
/*     */     
/*  76 */     float Ptemp = (float)press_Read * 1.1920929E-7F;
/*  77 */     float Btemp = this.s0 * (1.0F + this.stc1 * deltaT + this.stc2 * deltaT_square) * (Ptemp - (this.f0 + this.ftc1 * deltaT + this.ftc2 * deltaT_square));
/*     */     
/*  79 */     float Press = Btemp + this.ks * Btemp * Btemp;
/*  80 */     Press *= 100000.0F;
/*  81 */     float[] aa = new float[2];
/*  82 */     aa[1] = Temperature;
/*  83 */     aa[0] = Press;
/*  84 */     return aa;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean Configuration()
/*     */   {
/*  97 */     int[] temp_data = new int[22];
/*     */     
/*     */ 
/* 100 */     String para = Get1LineString("/sys/SensorsPT/GetParam");
/* 101 */     if (para == null)
/* 102 */       return false;
/* 103 */     String[] params = para.split(",");
/* 104 */     Log.e("MSP880", para);
/* 105 */     Log.e("MSP880", "lenght=" + params.length);
/* 106 */     for (int i = 0; i < params.length; i++)
/* 107 */       temp_data[i] = Integer.valueOf(params[i]).intValue();
/* 108 */     long temp = temp_data[0] << 8 | temp_data[1];
/* 109 */     this.s0 = ((float)temp * 1.2207031E-4F);
/*     */     
/* 111 */     temp = temp_data[2] << 8 | temp_data[3];
/* 112 */     if (temp >= 32768L) temp -= 65536L;
/* 113 */     this.stc1 = ((float)temp * 2.3841858E-7F);
/*     */     
/* 115 */     temp = (temp_data[4] & 0x3F) << 8 | temp_data[5];
/* 116 */     if (temp >= 8192L) temp -= 16384L;
/* 117 */     this.stc2 = ((float)temp * 1.8626451E-9F);
/*     */     
/* 119 */     temp = temp_data[6] << 8 | temp_data[7];
/* 120 */     if (temp >= 32768L) temp -= 65536L;
/* 121 */     this.ftc1 = ((float)temp * 2.3841858E-7F);
/*     */     
/* 123 */     temp = (temp_data[8] & 0x3F) << 8 | temp_data[9];
/* 124 */     if (temp >= 8192L) temp -= 16384L;
/* 125 */     this.ftc2 = ((float)temp * 1.8626451E-9F);
/*     */     
/* 127 */     temp = temp_data[10] << 8 | temp_data[11];
/* 128 */     if (temp >= 32768L) temp -= 65536L;
/* 129 */     this.f0 = ((float)temp * 3.0517578E-5F);
/*     */     
/* 131 */     temp = temp_data[12] << 8 | temp_data[13];
/* 132 */     if (temp >= 32768L) temp -= 65536L;
/* 133 */     this.ks = ((float)temp * 1.5258789E-5F);
/*     */     
/* 135 */     temp = (temp_data[14] & 0xF) << 8 | temp_data[15];
/* 136 */     if (temp >= 2048L) temp -= 4096L;
/* 137 */     this.Tbase = ((float)temp * 0.0625F);
/*     */     
/* 139 */     temp = temp_data[16] % 16 << 8 | temp_data[17];
/* 140 */     if (temp >= 2048L) temp -= 4096L;
/* 141 */     this.Temp_a = ((float)temp * 4.8828124E-6F);
/*     */     
/* 143 */     temp = temp_data[18] % 16 << 8 | temp_data[19];
/* 144 */     this.Temp_b = ((float)temp * 4.8828125E-4F);
/*     */     
/* 146 */     temp = temp_data[20] % 16 << 8 | temp_data[21];
/* 147 */     if (temp >= 2048L) temp -= 4096L;
/* 148 */     this.Temp_c = ((float)temp * 0.0625F);
/* 149 */     return true;
/*     */   }
/*     */   
/* 152 */   private String Get1LineString(String path) { BufferedReader reader = null;
/* 153 */     String readline = null;
/*     */     try {
/* 155 */       reader = new BufferedReader(new FileReader(path));
/* 156 */       readline = reader.readLine();
/*     */     }
/*     */     catch (Exception e) {}finally {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 165 */       if (reader != null) {
/* 166 */         reader.close();
/*     */       }
/* 168 */       return readline;
/*     */     }
/*     */     catch (IOException localIOException) {}
/*     */     
/* 172 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\luclo\OneDrive\桌面\万智联接口\com.hwit(6).jar!\com\hwit\sensors\Msp880.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */