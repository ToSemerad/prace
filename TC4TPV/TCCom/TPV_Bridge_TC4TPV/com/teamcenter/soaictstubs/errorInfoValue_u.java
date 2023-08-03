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

public class errorInfoValue_u {
  private boolean __discriminator;

  private Object __value;


  public errorInfoValue_u() {
    __default();
  }

  public boolean discriminator() {
    return __discriminator;
  }

  public void __default() {
    this.__discriminator = false;
    this.__value = null;
  }

  public errorInfo_s errorvalues() {
    return (errorInfo_s)__value;
  }

  public void errorvalues(errorInfo_s value) {
    this.__discriminator = true;
    this.__value = value;
  }

  public boolean is_errorvalues() {
    return __discriminator;
  }

}
