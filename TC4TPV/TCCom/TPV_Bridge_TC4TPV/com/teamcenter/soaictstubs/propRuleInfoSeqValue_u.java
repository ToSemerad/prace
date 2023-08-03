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

public class propRuleInfoSeqValue_u {
  private boolean __discriminator;

  private Object __value;


  public propRuleInfoSeqValue_u() {
    __default();
  }

  public boolean discriminator() {
    return __discriminator;
  }

  public void __default() {
    this.__discriminator = false;
    this.__value = null;
  }

  public propRuleInfo_s[] proprule_seq_value() {
    return (propRuleInfo_s[])__value;
  }

  public void proprule_seq_value(propRuleInfo_s[] value) {
    this.__discriminator = true;
    this.__value = value;
  }

  public boolean is_proprule_seq_value() {
    return __discriminator;
  }

}
