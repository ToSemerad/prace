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

public class pftMappingIdValue_u {
  private boolean __discriminator;

  private Object __value;


  public pftMappingIdValue_u() {
    __default();
  }

  public boolean discriminator() {
    return __discriminator;
  }

  public void __default() {
    this.__discriminator = false;
    this.__value = null;
  }

  public pftMappingId_t pftMappingId_value() {
    return (pftMappingId_t)__value;
  }

  public void pftMappingId_value(pftMappingId_t value) {
    this.__discriminator = true;
    this.__value = value;
  }

  public boolean is_pftMappingId_value() {
    return __discriminator;
  }

}
