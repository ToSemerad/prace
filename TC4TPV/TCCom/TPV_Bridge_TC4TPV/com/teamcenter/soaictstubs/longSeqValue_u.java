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

public class longSeqValue_u {
  private boolean __discriminator;

  private Object __value;


  public longSeqValue_u() {
    __default();
  }

  public boolean discriminator() {
    return __discriminator;
  }

  public void __default() {
    this.__discriminator = false;
    this.__value = null;
  }

  public int[] seqValue() {
    return (int[])__value;
  }

  public void seqValue(int[] value) {
    this.__discriminator = true;
    this.__value = value;
  }

  public boolean is_seqValue() {
    return __discriminator;
  }

}
