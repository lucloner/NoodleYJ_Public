/*     */ package com.hwit;
/*     */ 
/*     */ import android.util.Log;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArmFreqUtils
/*     */ {
/*     */   private static final String TAG = "ArmFreqUtils";
/*  21 */   private static File frequenciesFile = new File(
/*  22 */     "/sys/devices/system/cpu/cpu0/cpufreq/scaling_available_frequencies");
/*  23 */   private static File cur_freqFile = new File(
/*  24 */     "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
/*  25 */   private static File governor_freqFile = new File(
/*  26 */     "/sys/devices/system/cpu/cpu0/cpufreq/scaling_governor");
/*  27 */   private static File setspeed_freqFile = new File(
/*  28 */     "/sys/devices/system/cpu/cpu0/cpufreq/scaling_setspeed");
/*  29 */   private static File gpu_availableFreqsFile = new File("/sys/mali400_utility/param");
/*  30 */   private static File gpu_freqFile_3188 = new File("/sys/mali400_utility/utility");
/*  31 */   private static File gpu_freqFile = new File("/proc/pvr/freq");
/*  32 */   private static File ddr_freqFile = new File("/proc/driver/ddr_ts");
/*     */   public static final String USERSPACE_MODE = "userspace";
/*     */   public static final String INTERACTIVE_MODE = "interactive";
/*  35 */   public static int GPU_AVAILABLE_FREQ_COUNT = 6;
/*     */   
/*     */   public static void setDDRFreq(String value)
/*     */     throws FileNotFoundException, IOException
/*     */   {
/*  40 */     PMwriteFile(ddr_freqFile, value);
/*     */   }
/*     */   
/*     */   public static void openGpuEcho()
/*     */     throws FileNotFoundException, IOException
/*     */   {
/*  46 */     PMwriteFile(gpu_freqFile, "debug_lo");
/*     */   }
/*     */   
/*     */ 
/*     */   public static void setGpuFreq(String value)
/*     */     throws FileNotFoundException, IOException
/*     */   {
/*  53 */     PMwriteFile(gpu_freqFile, value);
/*     */   }
/*     */   
/*     */   public static void setGpuFreqFor3188(String value)
/*     */     throws FileNotFoundException, IOException
/*     */   {
/*  59 */     PMwriteFile(gpu_freqFile_3188, value);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void setGovernorMode(String mode)
/*     */     throws FileNotFoundException, IOException
/*     */   {
/*  66 */     PMwriteFile(governor_freqFile, mode);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setSpeedFreq(int value)
/*     */     throws FileNotFoundException, IOException
/*     */   {
/*  78 */     PMwriteFile(setspeed_freqFile, String.valueOf(value));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean PMwriteFile(File file, String message)
/*     */     throws FileNotFoundException, IOException
/*     */   {
/*  91 */     if (!file.exists()) {
/*  92 */       throw new FileNotFoundException();
/*     */     }
/*  94 */     if (file.canWrite()) {
/*  95 */       FileOutputStream fout = new FileOutputStream(file);
/*  96 */       byte[] bytes = message.getBytes();
/*  97 */       fout.write(bytes);
/*  98 */       fout.close();
/*     */     } else {
/* 100 */       Log.e("ArmFreqUtils", file.toString() + "can not write");
/* 101 */       IOException io = new IOException();
/* 102 */       throw io;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   public static List<String> getAvailableFrequencies()
/*     */   {
/* 113 */     List<String> result = new ArrayList();
/* 114 */     if (frequenciesFile.exists()) {
/*     */       try {
/* 116 */         FileReader fread = new FileReader(frequenciesFile);
/* 117 */         BufferedReader buffer = new BufferedReader(fread);
/* 118 */         String str = null;
/* 119 */         StringBuilder sb = new StringBuilder();
/* 120 */         while ((str = buffer.readLine()) != null) {
/* 121 */           sb.append(str);
/*     */         }
/* 123 */         String[] temp = sb.toString().split(" ");
/* 124 */         if ((temp != null) && (temp.length > 0)) {
/* 125 */           for (int i = 0; i < temp.length; i++) {
/* 126 */             result.add(Integer.valueOf(temp[i]).intValue() / 1000 + "M");
/*     */           }
/*     */         }
/*     */       } catch (IOException e) {
/* 130 */         Log.e("ArmFreqUtils", "IO Exception");
/*     */       }
/*     */     }
/*     */     
/* 134 */     return result;
/*     */   }
/*     */   
/*     */   public static Integer getCurFrequencies() {
/* 138 */     Integer result = Integer.valueOf(0);
/* 139 */     if (cur_freqFile.exists()) {
/*     */       try {
/* 141 */         FileReader fread = new FileReader(cur_freqFile);
/* 142 */         BufferedReader buffer = new BufferedReader(fread);
/* 143 */         String str = null;
/* 144 */         StringBuilder sb = new StringBuilder();
/* 145 */         while ((str = buffer.readLine()) != null) {
/* 146 */           sb.append(str);
/*     */         }
/* 148 */         result = Integer.valueOf(sb.toString());
/*     */       } catch (IOException e) {
/* 150 */         Log.e("ArmFreqUtils", "IO Exception");
/*     */       }
/*     */     }
/*     */     
/* 154 */     return result;
/*     */   }
/*     */   
/*     */   public static String getCurDDR() {
/* 158 */     String result = "";
/* 159 */     if (ddr_freqFile.exists()) {
/*     */       try {
/* 161 */         FileReader fread = new FileReader(ddr_freqFile);
/* 162 */         BufferedReader buffer = new BufferedReader(fread);
/* 163 */         String str = null;
/* 164 */         StringBuilder sb = new StringBuilder();
/* 165 */         while ((str = buffer.readLine()) != null) {
/* 166 */           sb.append(str);
/*     */         }
/* 168 */         result = sb.toString();
/*     */       } catch (IOException e) {
/* 170 */         Log.e("ArmFreqUtils", "IO Exception");
/*     */       }
/*     */     }
/*     */     
/* 174 */     return result;
/*     */   }
/*     */   
/*     */   public static List<String> getAvailableGpuFreqs() {
/* 178 */     List<String> result = new ArrayList();
/* 179 */     if (gpu_availableFreqsFile.exists()) {
/*     */       try {
/* 181 */         FileReader fread = new FileReader(gpu_availableFreqsFile);
/* 182 */         BufferedReader buffer = new BufferedReader(fread);
/* 183 */         String str = null;
/* 184 */         StringBuilder sb = new StringBuilder();
/* 185 */         while ((str = buffer.readLine()) != null) {
/* 186 */           sb.append(str);
/*     */         }
/* 188 */         String[] temp = sb.toString().split(",");
/* 189 */         if ((temp != null) && (temp.length > 0)) {
/* 190 */           GPU_AVAILABLE_FREQ_COUNT = Integer.valueOf(temp[0]).intValue();
/* 191 */           for (int i = 0; i < GPU_AVAILABLE_FREQ_COUNT; i++) {
/* 192 */             result.add(Integer.valueOf(temp[(i + 1)]));
/*     */           }
/*     */         }
/*     */       } catch (IOException e) {
/* 196 */         Log.e("ArmFreqUtils", "IO Exception");
/*     */       }
/*     */     }
/*     */     
/* 200 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\Users\luclo\OneDrive\桌面\万智联接口\com.hwit(6).jar!\com\hwit\ArmFreqUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */