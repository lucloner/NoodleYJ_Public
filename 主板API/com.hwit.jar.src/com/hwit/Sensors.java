/*     */ package com.hwit;
/*     */ 
/*     */ import com.hwit.sensors.Em30718;
/*     */ import com.hwit.sensors.Mq2;
/*     */ import com.hwit.sensors.Msp880;
/*     */ import com.hwit.sensors.Sht3x;
/*     */ 
/*     */ public class Sensors
/*     */ {
/*     */   private Mq2 mMq2;
/*     */   private Msp880 mMsp880;
/*     */   private Em30718 mEm30718;
/*     */   private Sht3x mSht3x;
/*  14 */   private boolean Msp880_init = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void init()
/*     */   {
/*  25 */     this.mMq2 = new Mq2();
/*  26 */     this.mMsp880 = new Msp880();
/*  27 */     this.Msp880_init = this.mMsp880.init();
/*  28 */     this.mEm30718 = new Em30718();
/*  29 */     this.mSht3x = new Sht3x();
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
/*     */   public boolean getLightisExist_Em30718()
/*     */   {
/*  42 */     return this.mEm30718.IsExist();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLightValue_Em30718()
/*     */   {
/*  53 */     return this.mEm30718.GetLight();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLightMinValue_Em30718()
/*     */   {
/*  65 */     return this.mEm30718.GetMinValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLightMaxValue_Em30718()
/*     */   {
/*  76 */     return this.mEm30718.GetMaxValue();
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
/*     */   public boolean getSomkeisExist_Mq2()
/*     */   {
/*  89 */     return this.mMq2.IsExist();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean getSomkeIsWarnning_Mq2()
/*     */   {
/* 101 */     int value = this.mMq2.isWarnning();
/* 102 */     if (value == 1) {
/* 103 */       return true;
/*     */     }
/* 105 */     return false;
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
/*     */   public boolean getPTisExist_Msp880()
/*     */   {
/* 118 */     return this.mMq2.IsExist();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float[] getPT_Msp880()
/*     */   {
/* 130 */     if (!this.Msp880_init)
/* 131 */       return null;
/* 132 */     float[] aa = new float[2];
/* 133 */     aa = this.mMsp880.getPT();
/* 134 */     return aa;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean getTHisExist_Sht3x()
/*     */   {
/* 146 */     return this.mSht3x.IsExist();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTemperature_Sht3x()
/*     */   {
/* 157 */     return this.mSht3x.GetTemperature();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getHumidity_Sht3x()
/*     */   {
/* 168 */     return this.mSht3x.GetHumidity();
/*     */   }
/*     */ }


/* Location:              C:\Users\luclo\OneDrive\桌面\万智联接口\com.hwit(6).jar!\com\hwit\Sensors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */