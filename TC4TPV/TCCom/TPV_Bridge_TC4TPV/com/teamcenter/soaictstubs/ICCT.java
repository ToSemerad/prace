package com.teamcenter.soaictstubs;

import com.teamcenter.services.internal.loose.core.ICTService;
import com.teamcenter.services.internal.loose.core._2011_06.ICT.Arg;
import com.teamcenter.services.internal.loose.core._2011_06.ICT.InvokeICTMethodResponse;
import com.teamcenter.soa.client.Connection;


/** 
 * ***********************************************************
 * *                                                         *
 * *      THE FOLLOWING SOURCE FILE HAS BEEN AUTOMATICALLY   *
 * *      GENERATED.  ANY HAND CRAFTED CHANGES WILL BE LOST! *
 * *                                                         *
 * ***********************************************************
 * 
 */

public class ICCT {
  ICTService m_service;

  String m_typeName;

  String m_objectUid;

  Connection m_connection;


  public ICCT(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public ICCT(Connection connection, String typeName, String objectUid) {
    m_service = ICTService.getService( connection );
    m_typeName = typeName;
    m_objectUid = objectUid;
    m_connection = connection;
  }

  public void setObjectUid(String objectUid) {
    m_objectUid= objectUid;
  }

  public String getObjectUid() {
    return m_objectUid;
  }

  public void setTypeName(String typeName) {
    m_typeName = typeName;
  }

  public String getTypeName() {
    return m_typeName;
  }

  public boolean isTypeOf(String[] types) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(types);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "isTypeOf", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    boolean argValue_ =false;
    return (boolean) TcUtility.queryArg(response.output[0], argValue_);
  }

  public void isTypeOfOnArray(String[] types, booleanSeq_tHolder verdicts) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(types);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "isTypeOfOnArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdicts.value = TcUtility.queryArg(response.output[0], verdicts.value);
  }

  public void getClassHierarchy(stringSeq_tHolder classNames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getClassHierarchy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    classNames.value = TcUtility.queryArg(response.output[0], classNames.value);
  }

  public void extent(boolean includeSubTypes, uidSeqValue_uHolder uidValues, uidSeqValue_uHolder typeUidValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(includeSubTypes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "extent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uidValues.value = TcUtility.queryArg(response.output[0], uidValues.value);
    typeUidValues.value = TcUtility.queryArg(response.output[1], typeUidValues.value);
  }

  public void extentPersistent(boolean includeSubTypes, uidSeqValue_uHolder uidValues, uidSeqValue_uHolder typeUidValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(includeSubTypes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "extentPersistent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uidValues.value = TcUtility.queryArg(response.output[0], uidValues.value);
    typeUidValues.value = TcUtility.queryArg(response.output[1], typeUidValues.value);
  }

  public void getRelatedTypes(uidSeqValue_uHolder ObjValues, uidSeqValue_uHolder typeObjValues) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getRelatedTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ObjValues.value = TcUtility.queryArg(response.output[0], ObjValues.value);
    typeObjValues.value = TcUtility.queryArg(response.output[1], typeObjValues.value);
  }

  public void getProperty(String objectUid, String propertyName, StringHolder propertyUIFValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyUIFValue.value = TcUtility.queryArgStringUnion(response.output[0], propertyUIFValue.value);
  }

  public void getProperties(String objectUid, String[] propertyNames, stringValueSeq_tHolder propertyUIFValues) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyUIFValues.value = TcUtility.queryArgStringUnion(response.output[0], propertyUIFValues.value);
  }

  public void getPropertiesSet(String[] objectList, String[] propertyNames, stringValueSeqSeq_tHolder propertyUIFValueSet) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectList);
    args_[3] = TcUtility.createArg(propertyNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getPropertiesSet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyUIFValueSet.value = TcUtility.queryArgStringUnion(response.output[0], propertyUIFValueSet.value);
  }

  public void getAllProperties(String objectUid, stringSeq_tHolder propertyNames, stringValueSeq_tHolder propertyUIFValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getAllProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyNames.value = TcUtility.queryArg(response.output[0], propertyNames.value);
    propertyUIFValues.value = TcUtility.queryArgStringUnion(response.output[1], propertyUIFValues.value);
  }

  public void getTCProperty(String objectUid, String propertyName, StringHolder uifValue, propertyData_uHolder value, BooleanHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValue.value = TcUtility.queryArgStringUnion(response.output[0], uifValue.value);
    value.value = TcUtility.queryArg(response.output[1], value.value);
    isModifiable.value = TcUtility.queryArg(response.output[2], isModifiable.value);
  }

  public void getTCProperties(String objectUid, String[] propertyNames, stringValueSeq_tHolder uifValues, propertyDataSeq_tHolder values, booleanSeq_tHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValues.value = TcUtility.queryArgStringUnion(response.output[0], uifValues.value);
    values.value = TcUtility.queryArg(response.output[1], values.value);
    isModifiable.value = TcUtility.queryArg(response.output[2], isModifiable.value);
  }

  public void getTCPropertiesWithErrors(String objectUid, String[] propertyNames, stringValueSeq_tHolder uifValues, propertyDataSeq_tHolder values, booleanSeq_tHolder isModifiable, errorInfoValueSeq_tHolder errors) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCPropertiesWithErrors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValues.value = TcUtility.queryArgStringUnion(response.output[0], uifValues.value);
    values.value = TcUtility.queryArg(response.output[1], values.value);
    isModifiable.value = TcUtility.queryArg(response.output[2], isModifiable.value);
    errors.value = TcUtility.queryArg(response.output[3], errors.value);
  }

  public void getAllTCProperties(String objectUid, stringSeq_tHolder propertyNames, stringValueSeq_tHolder uifValues, propertyDataSeq_tHolder values, booleanSeq_tHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getAllTCProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyNames.value = TcUtility.queryArg(response.output[0], propertyNames.value);
    uifValues.value = TcUtility.queryArgStringUnion(response.output[1], uifValues.value);
    values.value = TcUtility.queryArg(response.output[2], values.value);
    isModifiable.value = TcUtility.queryArg(response.output[3], isModifiable.value);
  }

  public void getTCPropertiesSet(String[] objectList, String[] propertyNames, stringValueSeqSeq_tHolder uifValues, propertyDataSeqSeq_tHolder values, booleanSeqSeq_tHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectList);
    args_[3] = TcUtility.createArg(propertyNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCPropertiesSet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValues.value = TcUtility.queryArgStringUnion(response.output[0], uifValues.value);
    values.value = TcUtility.queryArg(response.output[1], values.value);
    isModifiable.value = TcUtility.queryArg(response.output[2], isModifiable.value);
  }

  public void getTCPropertiesSetWithErrors(String[] objectList, String[] propertyNames, stringValueSeqSeq_tHolder uifValues, propertyDataSeqSeq_tHolder values, booleanSeqSeq_tHolder isModifiable, errorInfoValueSeqSeq_tHolder errors) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectList);
    args_[3] = TcUtility.createArg(propertyNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCPropertiesSetWithErrors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValues.value = TcUtility.queryArgStringUnion(response.output[0], uifValues.value);
    values.value = TcUtility.queryArg(response.output[1], values.value);
    isModifiable.value = TcUtility.queryArg(response.output[2], isModifiable.value);
    errors.value = TcUtility.queryArg(response.output[3], errors.value);
  }

  public void setTCPropertiesSet(String[] objectList, String[][] propertyNames, propertyData_u[][] propertyData, stringValueSeqSeq_tHolder propertyUIFValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectList);
    args_[3] = TcUtility.createArg(propertyNames);
    args_[4] = TcUtility.createArg(propertyData);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setTCPropertiesSet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyUIFValues.value = TcUtility.queryArgStringUnion(response.output[0], propertyUIFValues.value);
  }

  public void setProperty(String objectUid, String propertyName, String propertyValue) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    args_[4] = TcUtility.createArgStringUnion(propertyValue);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setProperties(String objectUid, String[] propertyNames, String[] propertyStringValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyNames);
    args_[4] = TcUtility.createArgStringUnion(propertyStringValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setTCProperty(String objectUid, String propertyName, propertyData_u propData, StringHolder uifValue) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    args_[4] = TcUtility.createArg(propData);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setTCProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValue.value = TcUtility.queryArgStringUnion(response.output[0], uifValue.value);
  }

  public void setTCProperties(String objectUid, String[] propertyNames, propertyData_u[] propData, stringValueSeq_tHolder uifValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyNames);
    args_[4] = TcUtility.createArg(propData);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setTCProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValues.value = TcUtility.queryArgStringUnion(response.output[0], uifValues.value);
  }

  public void setPropertiesSet(String[] objectList, String[][] propertyNames, propertyData_u[][] propertyData) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectList);
    args_[3] = TcUtility.createArg(propertyNames);
    args_[4] = TcUtility.createArg(propertyData);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setPropertiesSet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyStringArray(String objectUid, String propertyName, stringValueSeq_tHolder stringValues, BooleanHolder isModifiable, StringHolder propertyUIFValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCPropertyStringArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    stringValues.value = TcUtility.queryArgStringUnion(response.output[0], stringValues.value);
    isModifiable.value = TcUtility.queryArg(response.output[1], isModifiable.value);
    propertyUIFValue.value = TcUtility.queryArgStringUnion(response.output[2], propertyUIFValue.value);
  }

  public void setTCPropertyStringArray(String objectUid, String propertyName, String[] stringValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    args_[4] = TcUtility.createArgStringUnion(stringValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setTCPropertyStringArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyUidArray(String objectUid, String propertyName, uidValueSeq_tHolder objValues, uidValueSeq_tHolder typeObjList, BooleanHolder isModifiable, StringHolder propertyUIFValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCPropertyUidArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objValues.value = TcUtility.queryArgStringUnion(response.output[0], objValues.value);
    typeObjList.value = TcUtility.queryArgStringUnion(response.output[1], typeObjList.value);
    isModifiable.value = TcUtility.queryArg(response.output[2], isModifiable.value);
    propertyUIFValue.value = TcUtility.queryArgStringUnion(response.output[3], propertyUIFValue.value);
  }

  public void setTCPropertyUidArray(String objectUid, String propertyName, String[] objValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    args_[4] = TcUtility.createArgStringUnion(objValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setTCPropertyUidArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyIntArray(String objectUid, String propertyName, longValueSeq_tHolder longValues, BooleanHolder isModifiable, StringHolder propertyUIFValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCPropertyIntArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    longValues.value = TcUtility.queryArg(response.output[0], longValues.value);
    isModifiable.value = TcUtility.queryArg(response.output[1], isModifiable.value);
    propertyUIFValue.value = TcUtility.queryArgStringUnion(response.output[2], propertyUIFValue.value);
  }

  public void setTCPropertyIntArray(String objectUid, String propertyName, int[] longValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    args_[4] = TcUtility.createArg(longValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setTCPropertyIntArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyDoubleArray(String objectUid, String propertyName, doubleValueSeq_tHolder doubleValues, BooleanHolder isModifiable, StringHolder propertyUIFValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCPropertyDoubleArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    doubleValues.value = TcUtility.queryArg(response.output[0], doubleValues.value);
    isModifiable.value = TcUtility.queryArg(response.output[1], isModifiable.value);
    propertyUIFValue.value = TcUtility.queryArgStringUnion(response.output[2], propertyUIFValue.value);
  }

  public void setTCPropertyDoubleArray(String objectUid, String propertyName, double[] doubleValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    args_[4] = TcUtility.createArg(doubleValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setTCPropertyDoubleArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyFloatArray(String objectUid, String propertyName, floatValueSeq_tHolder doubleValues, BooleanHolder isModifiable, StringHolder propertyUIFValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCPropertyFloatArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    doubleValues.value = TcUtility.queryArg(response.output[0], doubleValues.value);
    isModifiable.value = TcUtility.queryArg(response.output[1], isModifiable.value);
    propertyUIFValue.value = TcUtility.queryArgStringUnion(response.output[2], propertyUIFValue.value);
  }

  public void setTCPropertyFloatArray(String objectUid, String propertyName, float[] floatValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    args_[4] = TcUtility.createArg(floatValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setTCPropertyFloatArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyLogicalArray(String objectUid, String propertyName, booleanValueSeq_tHolder booleanValues, BooleanHolder isModifiable, StringHolder propertyUIFValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCPropertyLogicalArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    booleanValues.value = TcUtility.queryArg(response.output[0], booleanValues.value);
    isModifiable.value = TcUtility.queryArg(response.output[1], isModifiable.value);
    propertyUIFValue.value = TcUtility.queryArgStringUnion(response.output[2], propertyUIFValue.value);
  }

  public void setTCPropertyLogicalArray(String objectUid, String propertyName, boolean[] booleanValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    args_[4] = TcUtility.createArg(booleanValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setTCPropertyLogicalArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyDateArray(String objectUid, String propertyName, stringValueSeq_tHolder booleanValues, BooleanHolder isModifiable, StringHolder propertyUIFValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTCPropertyDateArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    booleanValues.value = TcUtility.queryArgStringUnion(response.output[0], booleanValues.value);
    isModifiable.value = TcUtility.queryArg(response.output[1], isModifiable.value);
    propertyUIFValue.value = TcUtility.queryArgStringUnion(response.output[2], propertyUIFValue.value);
  }

  public void setTCPropertyDateArray(String objectUid, String propertyName, String[] booleanValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    args_[4] = TcUtility.createArgStringUnion(booleanValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setTCPropertyDateArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAllPropertyDescriptions(propertyDescriptorSeq_tHolder propDescriptors) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getAllPropertyDescriptions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propDescriptors.value = TcUtility.queryArg(response.output[0], propDescriptors.value);
  }

  public void getPropertyDescriptions(stringSeq_tHolder propertyNames, stringValueSeq_tHolder propertyDisplayNames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getPropertyDescriptions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyNames.value = TcUtility.queryArg(response.output[0], propertyNames.value);
    propertyDisplayNames.value = TcUtility.queryArgStringUnion(response.output[1], propertyDisplayNames.value);
  }

  public void getComponentPropertyInfo(String objectUid, String propertyName, StringHolder propertyUIFValue, stringSeq_tHolder propertyNames, stringValueSeq_tHolder propertyDisplayNames) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getComponentPropertyInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyUIFValue.value = TcUtility.queryArgStringUnion(response.output[0], propertyUIFValue.value);
    propertyNames.value = TcUtility.queryArg(response.output[1], propertyNames.value);
    propertyDisplayNames.value = TcUtility.queryArgStringUnion(response.output[2], propertyDisplayNames.value);
  }

  public void getChildrenInfo(String objectUid, stringSeqValue_u childTypes, uidValueSeq_tHolder components, uidValueSeq_tHolder componentTypes, stringValueSeq_tHolder componentContextNames) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(childTypes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getChildrenInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArgStringUnion(response.output[0], components.value);
    componentTypes.value = TcUtility.queryArgStringUnion(response.output[1], componentTypes.value);
    componentContextNames.value = TcUtility.queryArgStringUnion(response.output[2], componentContextNames.value);
  }

  public void getAvailableRelationInfo(availableRelInfoSeq_tHolder componentContextNames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getAvailableRelationInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentContextNames.value = TcUtility.queryArg(response.output[0], componentContextNames.value);
  }

  public void getRelatedInfo(String objectUid, stringSeqValue_u relatedTypes, uidSeqValue_uHolder components, uidSeqValue_uHolder componentTypes, stringSeqValue_uHolder componentContextNames) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(relatedTypes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getRelatedInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
    componentTypes.value = TcUtility.queryArg(response.output[1], componentTypes.value);
    componentContextNames.value = TcUtility.queryArg(response.output[2], componentContextNames.value);
  }

  public void getPrimaryRelatedInfo(String objectUid, uidSeqValue_uHolder components, uidSeqValue_uHolder componentTypes, stringSeqValue_uHolder componentContextNames) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getPrimaryRelatedInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
    componentTypes.value = TcUtility.queryArg(response.output[1], componentTypes.value);
    componentContextNames.value = TcUtility.queryArg(response.output[2], componentContextNames.value);
  }

  public void getSecondaryRelatedInfo(String objectUids, uidSeqValue_uHolder components, uidSeqValue_uHolder componentTypes, stringSeqValue_uHolder componentContextNames) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getSecondaryRelatedInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
    componentTypes.value = TcUtility.queryArg(response.output[1], componentTypes.value);
    componentContextNames.value = TcUtility.queryArg(response.output[2], componentContextNames.value);
  }

  public void setRelated(String objectUid, String componentContextName, String[] components) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(componentContextName);
    args_[4] = TcUtility.createArg(components);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setRelated", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void insertRelated(String objectUid, String componentContextName, String[] components, int index, uidSeqValue_uHolder objList, uidSeqValue_uHolder objTypeList) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(componentContextName);
    args_[4] = TcUtility.createArg(components);
    args_[5] = TcUtility.createArg(index);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "insertRelated", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objList.value = TcUtility.queryArg(response.output[0], objList.value);
    objTypeList.value = TcUtility.queryArg(response.output[1], objTypeList.value);
  }

  public void insertRelatedChunk(String objectUid, String componentContextName, String[] components, int index, uidSeqValue_uHolder objList, uidSeqValue_uHolder objTypeList, errorInfoSeqValue_uHolder errorInfo) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(componentContextName);
    args_[4] = TcUtility.createArg(components);
    args_[5] = TcUtility.createArg(index);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "insertRelatedChunk", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objList.value = TcUtility.queryArg(response.output[0], objList.value);
    objTypeList.value = TcUtility.queryArg(response.output[1], objTypeList.value);
    errorInfo.value = TcUtility.queryArg(response.output[2], errorInfo.value);
  }

  public void removeRelated(String objectuid, String componentContextName, String[] components) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(objectuid);
    args_[3] = TcUtility.createArg(componentContextName);
    args_[4] = TcUtility.createArg(components);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "removeRelated", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeAndDestroy(String parentUid, String contextName, String[] childUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(parentUid);
    args_[3] = TcUtility.createArg(contextName);
    args_[4] = TcUtility.createArg(childUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "removeAndDestroy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeAndDestroyWithErrors(String parentUid, String contextName, String[] childUids, errorInfoSeqValue_uHolder errorInfo) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(parentUid);
    args_[3] = TcUtility.createArg(contextName);
    args_[4] = TcUtility.createArg(childUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "removeAndDestroyWithErrors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errorInfo.value = TcUtility.queryArg(response.output[0], errorInfo.value);
  }

  public void removeAndDestroyChunk(String parentUid, String[] contextNames, String[][] childUids, errorInfoValueSeqSeq_tHolder errors) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(parentUid);
    args_[3] = TcUtility.createArg(contextNames);
    args_[4] = TcUtility.createArg(childUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "removeAndDestroyChunk", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errors.value = TcUtility.queryArg(response.output[0], errors.value);
  }

  public void changeRelation(String objectUid, String oldComponentContextName, String newComponentContextName, String[] componentUids, uidSeqValue_uHolder oldListUids, uidSeqValue_uHolder oldListtTypeUids, uidSeqValue_uHolder newListUids, uidSeqValue_uHolder newListtTypeUids) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(oldComponentContextName);
    args_[4] = TcUtility.createArg(newComponentContextName);
    args_[5] = TcUtility.createArg(componentUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "changeRelation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    oldListUids.value = TcUtility.queryArg(response.output[0], oldListUids.value);
    oldListtTypeUids.value = TcUtility.queryArg(response.output[1], oldListtTypeUids.value);
    newListUids.value = TcUtility.queryArg(response.output[2], newListUids.value);
    newListtTypeUids.value = TcUtility.queryArg(response.output[3], newListtTypeUids.value);
  }

  public void whereReferencedInfo(String objectUid, boolean interpretiveFlag, uidSeqValue_uHolder components, uidSeqValue_uHolder componentTypes, stringSeqValue_uHolder contextNames) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(interpretiveFlag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "whereReferencedInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
    componentTypes.value = TcUtility.queryArg(response.output[1], componentTypes.value);
    contextNames.value = TcUtility.queryArg(response.output[2], contextNames.value);
  }

  public void whereReferencedByTypeRelation(String objectUid, stringSeqValue_u typeNames, stringSeqValue_u relationNames, uidSeqValue_uHolder components, uidSeqValue_uHolder componentTypes, stringSeqValue_uHolder contextNames) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(typeNames);
    args_[4] = TcUtility.createArg(relationNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "whereReferencedByTypeRelation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
    componentTypes.value = TcUtility.queryArg(response.output[1], componentTypes.value);
    contextNames.value = TcUtility.queryArg(response.output[2], contextNames.value);
  }

  public void getWhereReferencedCount(String comp, IntHolder num_refs) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(comp);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getWhereReferencedCount", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    num_refs.value = TcUtility.queryArg(response.output[0], num_refs.value);
  }

  public void copyWSORecursively(String objToCopy, String configuringBOMWindow, String copyRulesKey, String name, String description, StringHolder newObj) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objToCopy);
    args_[3] = TcUtility.createArg(configuringBOMWindow);
    args_[4] = TcUtility.createArg(copyRulesKey);
    args_[5] = TcUtility.createArgStringUnion(name);
    args_[6] = TcUtility.createArgStringUnion(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "copyWSORecursively", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newObj.value = TcUtility.queryArg(response.output[0], newObj.value);
  }

  public void lock(String objUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "lock", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unlock(String objUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "unlock", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void refresh(String obj, int lockFlag) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(lockFlag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "refresh", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void save(String objUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "save", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void destroy(String objUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "destroy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void print(String objUid, String destinationName, boolean toPrinter) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArgStringUnion(destinationName);
    args_[4] = TcUtility.createArg(toPrinter);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "print", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getDefaultPasteRelation(StringHolder defaultPasteRelation) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getDefaultPasteRelation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    defaultPasteRelation.value = TcUtility.queryArgStringUnion(response.output[0], defaultPasteRelation.value);
  }

  public void getPreferredPasteRelation(String childUid, StringHolder preferredPasteRelation) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(childUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getPreferredPasteRelation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    preferredPasteRelation.value = TcUtility.queryArgStringUnion(response.output[0], preferredPasteRelation.value);
  }

  public void getPreferredPasteRelationOnArray(String[] childUidList, stringValueSeq_tHolder preferredPasteRelations) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(childUidList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getPreferredPasteRelationOnArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    preferredPasteRelations.value = TcUtility.queryArgStringUnion(response.output[0], preferredPasteRelations.value);
  }

  public void getPasteRelations(stringSeqValue_uHolder pasteRelations) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getPasteRelations", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pasteRelations.value = TcUtility.queryArg(response.output[0], pasteRelations.value);
  }

  public void getExtendedPasteRelations(String objectUid, int numChildrenToPaste, stringSeqValue_uHolder pasteRelations) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(numChildrenToPaste);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getExtendedPasteRelations", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pasteRelations.value = TcUtility.queryArg(response.output[0], pasteRelations.value);
  }

  public void getCurrentJob(String objUid, StringHolder jobUid, StringHolder objType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getCurrentJob", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    jobUid.value = TcUtility.queryArgStringUnion(response.output[0], jobUid.value);
    objType.value = TcUtility.queryArgStringUnion(response.output[1], objType.value);
  }

  public boolean isRuntimeType() throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "isRuntimeType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    boolean argValue_ =false;
    return (boolean) TcUtility.queryArg(response.output[0], argValue_);
  }

  public boolean okToModify(String obj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "okToModify", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    boolean argValue_ =false;
    return (boolean) TcUtility.queryArg(response.output[0], argValue_);
  }

  public boolean isValidUid(String obj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "isValidUid", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    boolean argValue_ =false;
    return (boolean) TcUtility.queryArg(response.output[0], argValue_);
  }

  public boolean isValid(String obj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "isValid", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    boolean argValue_ =false;
    return (boolean) TcUtility.queryArg(response.output[0], argValue_);
  }

  public void getAllEventTypesApplicable(String obj, uidSeqValue_uHolder events, uidSeqValue_uHolder eventTypes, booleanSeq_tHolder subscribableFlags, booleanSeq_tHolder auditableFlags) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getAllEventTypesApplicable", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    events.value = TcUtility.queryArg(response.output[0], events.value);
    eventTypes.value = TcUtility.queryArg(response.output[1], eventTypes.value);
    subscribableFlags.value = TcUtility.queryArg(response.output[2], subscribableFlags.value);
    auditableFlags.value = TcUtility.queryArg(response.output[3], auditableFlags.value);
  }

  public void getLogicalProperty(String obj, String propertyName, BooleanHolder booleanValue, StringHolder displayValue, BooleanHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getLogicalProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    booleanValue.value = TcUtility.queryArg(response.output[0], booleanValue.value);
    displayValue.value = TcUtility.queryArgStringUnion(response.output[1], displayValue.value);
    isModifiable.value = TcUtility.queryArg(response.output[2], isModifiable.value);
  }

  public void setLogicalProperty(String obj, String propertyName, boolean booleanValue) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(propertyName);
    args_[4] = TcUtility.createArg(booleanValue);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "setLogicalProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void changeOwner(String comp, String owner, String group) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(comp);
    args_[3] = TcUtility.createArg(owner);
    args_[4] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "changeOwner", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void moveOp(String comp, String[] componentList, int index) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(comp);
    args_[3] = TcUtility.createArg(componentList);
    args_[4] = TcUtility.createArg(index);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "moveOp", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void generateName(String comp, String parent_rev, String id, String rev, String name, String idSep, String rev_sep, String relationType, StringHolder newName) throws Exception {
    Arg[] args_ = new Arg[10];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(comp);
    args_[3] = TcUtility.createArg(parent_rev);
    args_[4] = TcUtility.createArg(id);
    args_[5] = TcUtility.createArg(rev);
    args_[6] = TcUtility.createArg(name);
    args_[7] = TcUtility.createArg(idSep);
    args_[8] = TcUtility.createArg(rev_sep);
    args_[9] = TcUtility.createArg(relationType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "generateName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newName.value = TcUtility.queryArgStringUnion(response.output[0], newName.value);
  }

  public void getClassificationClassAndSubclass(String obj, StringHolder className, StringHolder subclassName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getClassificationClassAndSubclass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    className.value = TcUtility.queryArgStringUnion(response.output[0], className.value);
    subclassName.value = TcUtility.queryArgStringUnion(response.output[1], subclassName.value);
  }

  public void getClassificationAttributes(String obj, stringSeq_tHolder attributeNames, stringValueSeq_tHolder attributeValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getClassificationAttributes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attributeNames.value = TcUtility.queryArg(response.output[0], attributeNames.value);
    attributeValues.value = TcUtility.queryArgStringUnion(response.output[1], attributeValues.value);
  }

  public void getTypeNamesSet(String[] typeCategories, stringValueSeqSeq_tHolder typeNamesSet) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeCategories);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTypeNamesSet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeNamesSet.value = TcUtility.queryArgStringUnion(response.output[0], typeNamesSet.value);
  }

  public void getTcTypesSet(String[] typeCategories, boolean[] includeSubClass, TypeInfoSeq_tHolder typeInfo) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeCategories);
    args_[3] = TcUtility.createArg(includeSubClass);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTcTypesSet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeInfo.value = TcUtility.queryArg(response.output[0], typeInfo.value);
  }

  public void getTypeNames(String typeCategory, stringValueSeq_tHolder typeNames) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeCategory);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getTypeNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeNames.value = TcUtility.queryArgStringUnion(response.output[0], typeNames.value);
  }

  public void getDisplayableTypeNames(String typeCategory, boolean includeTypesOfSubclasses, stringValueSeq_tHolder displayableTypeNames) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeCategory);
    args_[3] = TcUtility.createArg(includeTypesOfSubclasses);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getDisplayableTypeNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    displayableTypeNames.value = TcUtility.queryArgStringUnion(response.output[0], displayableTypeNames.value);
  }

  public void getValidChildrenInfo(String obj, String revisionRuleObj, uidValueSeq_tHolder components, uidValueSeq_tHolder componentTypes, stringValueSeq_tHolder componentContextNames) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArgStringUnion(revisionRuleObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getValidChildrenInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArgStringUnion(response.output[0], components.value);
    componentTypes.value = TcUtility.queryArgStringUnion(response.output[1], componentTypes.value);
    componentContextNames.value = TcUtility.queryArgStringUnion(response.output[2], componentContextNames.value);
  }

  public void getIncrementalChanges(String affObj, String parentObj, String contextName, uidSeq_tHolder pcObjs, uidSeq_tHolder typeObjs) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(affObj);
    args_[3] = TcUtility.createArgStringUnion(parentObj);
    args_[4] = TcUtility.createArg(contextName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getIncrementalChanges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pcObjs.value = TcUtility.queryArg(response.output[0], pcObjs.value);
    typeObjs.value = TcUtility.queryArg(response.output[1], typeObjs.value);
  }

  public void removeIncrementalChanges(String affObj, String parentObj, String contextName, String[] ices) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(affObj);
    args_[3] = TcUtility.createArgStringUnion(parentObj);
    args_[4] = TcUtility.createArg(contextName);
    args_[5] = TcUtility.createArg(ices);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "removeIncrementalChanges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAuditInfo(String obj, boolean full, StringHolder auditStream) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(full);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "getAuditInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    auditStream.value = TcUtility.queryArgStringUnion(response.output[0], auditStream.value);
  }

  public void isRefreshNeeded(String[] objs, booleanSeq_tHolder verdicts) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "isRefreshNeeded", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdicts.value = TcUtility.queryArg(response.output[0], verdicts.value);
  }

  public void refreshThese(String[] objs, int[] lockFlags) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objs);
    args_[3] = TcUtility.createArg(lockFlags);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCT", "refreshThese", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
