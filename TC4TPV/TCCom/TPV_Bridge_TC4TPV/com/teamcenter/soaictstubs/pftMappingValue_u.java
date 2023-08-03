package com.teamcenter.soaictstubs;

/** 
 * ***********************************************************
 * *                                                         *
 * *      THE FOLLOWING SOURCE FILE HAS BEEN AUTOMATICALLY   *
 * *      GENERATED.  ANY HAND CRAFTED CHANGES WILL BE LOST! *
 * *                                                         *
 * ***********************************************************
 * 
 */

public class pftMappingValue_u {
  private boolean __discriminator;

  private Object __value;


  public pftMappingValue_u() {
    __default();
  }

  public boolean discriminator() {
    return __discriminator;
  }

  public void __default() {
    this.__discriminator = false;
    this.__value = null;
  }

  public pftMapping_t pftMapping_value() {
    return (pftMapping_t)__value;
  }

  public void pftMapping_value(pftMapping_t value) {
    this.__discriminator = true;
    this.__value = value;
  }

  public boolean is_pftMapping_value() {
    return __discriminator;
  }

}
