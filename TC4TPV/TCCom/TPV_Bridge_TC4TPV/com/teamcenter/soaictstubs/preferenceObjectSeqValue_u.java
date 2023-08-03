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

public class preferenceObjectSeqValue_u {
  private boolean __discriminator;

  private Object __value;


  public preferenceObjectSeqValue_u() {
    __default();
  }

  public boolean discriminator() {
    return __discriminator;
  }

  public void __default() {
    this.__discriminator = false;
    this.__value = null;
  }

  public preferenceObject_s[] seqValue() {
    return (preferenceObject_s[])__value;
  }

  public void seqValue(preferenceObject_s[] value) {
    this.__discriminator = true;
    this.__value = value;
  }

  public boolean is_seqValue() {
    return __discriminator;
  }

}
