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

public class propertyData_u {
  private int __discriminator;

  private Object __value;


  public propertyData_u() {
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

  public short short_value() {
    if(__value != null)
    {
      return ((ShortHolder)__value).value;
    }
    else
    {
      return 0;
    }
  }

  public void short_value(short value) {
    this.__discriminator = 7;
    this.__value = new ShortHolder(value);
  }

  public boolean is_short_value() {
    if(__discriminator == 7)    return true;
    else return false;
  }

  public boolean boolean_value() {
    if(__value != null)
    {
      return ((BooleanHolder)__value).value;
    }
    else
    {
      return false;
    }
  }

  public void boolean_value(boolean value) {
    this.__discriminator = 6;
    this.__value = new BooleanHolder(value);
  }

  public boolean is_boolean_value() {
    if(__discriminator == 6)    return true;
    else return false;
  }

  public float float_value() {
    if(__value != null)
    {
      return ((FloatHolder)__value).value;
    }
    else
    {
      return 0;
    }
  }

  public void float_value(float value) {
    this.__discriminator = 4;
    this.__value = new FloatHolder(value);
  }

  public boolean is_float_value() {
    if(__discriminator == 4)    return true;
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

  public String typedRef_value() {
    return (String)__value;
  }

  public void typedRef_value(String value) {
    this.__discriminator = 9;
    this.__value = value;
  }

  public boolean is_typedRef_value() {
    if(__discriminator == 9)    return true;
    else return false;
  }

  public String untypedRef_value() {
    return (String)__value;
  }

  public void untypedRef_value(String value) {
    this.__discriminator = 10;
    this.__value = value;
  }

  public boolean is_untypedRef_value() {
    if(__discriminator == 10)    return true;
    else return false;
  }

  public String externalRef_value() {
    return (String)__value;
  }

  public void externalRef_value(String value) {
    this.__discriminator = 11;
    this.__value = value;
  }

  public boolean is_externalRef_value() {
    if(__discriminator == 11)    return true;
    else return false;
  }

  public String note_value() {
    return (String)__value;
  }

  public void note_value(String value) {
    this.__discriminator = 12;
    this.__value = value;
  }

  public boolean is_note_value() {
    if(__discriminator == 12)    return true;
    else return false;
  }

  public String typedRelation_value() {
    return (String)__value;
  }

  public void typedRelation_value(String value) {
    this.__discriminator = 13;
    this.__value = value;
  }

  public boolean is_typedRelation_value() {
    if(__discriminator == 13)    return true;
    else return false;
  }

  public String untypedRelation_value() {
    return (String)__value;
  }

  public void untypedRelation_value(String value) {
    this.__discriminator = 14;
    this.__value = value;
  }

  public boolean is_untypedRelation_value() {
    if(__discriminator == 14)    return true;
    else return false;
  }

  public char[] char_value_array() {
    return (char[])__value;
  }

  public void char_value_array(char[] value) {
    this.__discriminator = 101;
    this.__value = value;
  }

  public boolean is_char_value_array() {
    if(__discriminator == 101)    return true;
    else return false;
  }

  public String[] date_value_array() {
    return (String[])__value;
  }

  public void date_value_array(String[] value) {
    this.__discriminator = 102;
    this.__value = value;
  }

  public boolean is_date_value_array() {
    if(__discriminator == 102)    return true;
    else return false;
  }

  public double[] double_value_array() {
    return (double[])__value;
  }

  public void double_value_array(double[] value) {
    this.__discriminator = 103;
    this.__value = value;
  }

  public boolean is_double_value_array() {
    if(__discriminator == 103)    return true;
    else return false;
  }

  public float[] float_value_array() {
    return (float[])__value;
  }

  public void float_value_array(float[] value) {
    this.__discriminator = 104;
    this.__value = value;
  }

  public boolean is_float_value_array() {
    if(__discriminator == 104)    return true;
    else return false;
  }

  public int[] long_value_array() {
    return (int[])__value;
  }

  public void long_value_array(int[] value) {
    this.__discriminator = 105;
    this.__value = value;
  }

  public boolean is_long_value_array() {
    if(__discriminator == 105)    return true;
    else return false;
  }

  public boolean[] boolean_value_array() {
    return (boolean[])__value;
  }

  public void boolean_value_array(boolean[] value) {
    this.__discriminator = 106;
    this.__value = value;
  }

  public boolean is_boolean_value_array() {
    if(__discriminator == 106)    return true;
    else return false;
  }

  public int[] short_value_array() {
    return (int[])__value;
  }

  public void short_value_array(int[] value) {
    this.__discriminator = 107;
    this.__value = value;
  }

  public boolean is_short_value_array() {
    if(__discriminator == 107)    return true;
    else return false;
  }

  public String[] string_value_array() {
    return (String[])__value;
  }

  public void string_value_array(String[] value) {
    this.__discriminator = 108;
    this.__value = value;
  }

  public boolean is_string_value_array() {
    if(__discriminator == 108)    return true;
    else return false;
  }

  public String[] typedRef_value_array() {
    return (String[])__value;
  }

  public void typedRef_value_array(String[] value) {
    this.__discriminator = 109;
    this.__value = value;
  }

  public boolean is_typedRef_value_array() {
    if(__discriminator == 109)    return true;
    else return false;
  }

  public String[] untypedRef_value_array() {
    return (String[])__value;
  }

  public void untypedRef_value_array(String[] value) {
    this.__discriminator = 110;
    this.__value = value;
  }

  public boolean is_untypedRef_value_array() {
    if(__discriminator == 110)    return true;
    else return false;
  }

  public String[] externalRef_value_array() {
    return (String[])__value;
  }

  public void externalRef_value_array(String[] value) {
    this.__discriminator = 111;
    this.__value = value;
  }

  public boolean is_externalRef_value_array() {
    if(__discriminator == 111)    return true;
    else return false;
  }

  public String[] note_value_array() {
    return (String[])__value;
  }

  public void note_value_array(String[] value) {
    this.__discriminator = 112;
    this.__value = value;
  }

  public boolean is_note_value_array() {
    if(__discriminator == 112)    return true;
    else return false;
  }

  public String[] typedRelation_value_array() {
    return (String[])__value;
  }

  public void typedRelation_value_array(String[] value) {
    this.__discriminator = 113;
    this.__value = value;
  }

  public boolean is_typedRelation_value_array() {
    if(__discriminator == 113)    return true;
    else return false;
  }

  public String[] untypedRelation_value_array() {
    return (String[])__value;
  }

  public void untypedRelation_value_array(String[] value) {
    this.__discriminator = 114;
    this.__value = value;
  }

  public boolean is_untypedRelation_value_array() {
    if(__discriminator == 114)    return true;
    else return false;
  }

}
