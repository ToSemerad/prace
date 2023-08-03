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

public class lovData_u {
  private int __discriminator;

  private Object __value;


  public lovData_u() {
    __default();
  }

  public int discriminator() {
    return __discriminator;
  }

  public void __default() {
    this.__discriminator = 0;
    this.__value = null;
  }

  public char char_value() {
    if(__value != null)
    {
      return ((CharHolder)__value).value;
    }
    else
    {
      return 0;
    }
  }

  public void char_value(char value) {
    this.__discriminator = 1;
    this.__value = new CharHolder(value);
  }

  public boolean is_char_value() {
    if(__discriminator == 1)    return true;
    else return false;
  }

  public String string_value() {
    return (String)__value;
  }

  public void string_value(String value) {
    this.__discriminator = 8;
    this.__value = value;
  }

  public boolean is_string_value() {
    if(__discriminator == 8)    return true;
    else return false;
  }

  public String uid_value() {
    return (String)__value;
  }

  public void uid_value(String value) {
    this.__discriminator = 10;
    this.__value = value;
  }

  public boolean is_uid_value() {
    if(__discriminator == 10)    return true;
    else return false;
  }

  public double double_value() {
    if(__value != null)
    {
      return ((DoubleHolder)__value).value;
    }
    else
    {
      return 0;
    }
  }

  public void double_value(double value) {
    this.__discriminator = 3;
    this.__value = new DoubleHolder(value);
  }

  public boolean is_double_value() {
    if(__discriminator == 3)    return true;
    else return false;
  }

  public int long_value() {
    if(__value != null)
    {
      return ((IntHolder)__value).value;
    }
    else
    {
      return 0;
    }
  }

  public void long_value(int value) {
    this.__discriminator = 5;
    this.__value = new IntHolder(value);
  }

  public boolean is_long_value() {
    if(__discriminator == 5)    return true;
    else return false;
  }

  public String date_value() {
    return (String)__value;
  }

  public void date_value(String value) {
    this.__discriminator = 2;
    this.__value = value;
  }

  public boolean is_date_value() {
    if(__discriminator == 2)    return true;
    else return false;
  }

}
