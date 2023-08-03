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

public class ICCTPropertyService {
  ICTService m_service;

  Connection m_connection;


  public ICCTPropertyService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getProperty(String obj, String propertyName, StringHolder propertyValue) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyValue.value = TcUtility.queryArgStringUnion(response.output[0], propertyValue.value);
  }

  public void getProperties(String obj, String[] propertyNames, stringValueSeq_tHolder propertyUIFValues) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyUIFValues.value = TcUtility.queryArgStringUnion(response.output[0], propertyUIFValues.value);
  }

  public void getAllProperties(String obj, stringSeq_tHolder propertyNames, stringValueSeq_tHolder propertyUIFValues) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getAllProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyNames.value = TcUtility.queryArg(response.output[0], propertyNames.value);
    propertyUIFValues.value = TcUtility.queryArgStringUnion(response.output[1], propertyUIFValues.value);
  }

  public void getTCProperty(String obj, String propertyName, StringHolder uifValue, propertyData_uHolder value, BooleanHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getTCProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValue.value = TcUtility.queryArgStringUnion(response.output[0], uifValue.value);
    value.value = TcUtility.queryArg(response.output[1], value.value);
    isModifiable.value = TcUtility.queryArg(response.output[2], isModifiable.value);
  }

  public void getTCProperties(String obj, String[] propertyNames, stringValueSeq_tHolder uifValues, propertyDataSeq_tHolder values, booleanSeq_tHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getTCProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValues.value = TcUtility.queryArgStringUnion(response.output[0], uifValues.value);
    values.value = TcUtility.queryArg(response.output[1], values.value);
    isModifiable.value = TcUtility.queryArg(response.output[2], isModifiable.value);
  }

  public void getAllTCProperties(String obj, stringSeq_tHolder propertyNames, stringValueSeq_tHolder uifValues, propertyDataSeq_tHolder values, booleanSeq_tHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getAllTCProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyNames.value = TcUtility.queryArg(response.output[0], propertyNames.value);
    uifValues.value = TcUtility.queryArgStringUnion(response.output[1], uifValues.value);
    values.value = TcUtility.queryArg(response.output[2], values.value);
    isModifiable.value = TcUtility.queryArg(response.output[3], isModifiable.value);
  }

  public void setProperty(String obj, String propertyName, String propValue) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    args_[2] = TcUtility.createArgStringUnion(propValue);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setProperties(String obj, String[] propertyNames, String[] propValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyNames);
    args_[2] = TcUtility.createArgStringUnion(propValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setTCProperty(String obg, String propertyName, propertyData_u propData, StringHolder uifValue) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obg);
    args_[1] = TcUtility.createArg(propertyName);
    args_[2] = TcUtility.createArg(propData);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setTCProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValue.value = TcUtility.queryArgStringUnion(response.output[0], uifValue.value);
  }

  public void setTCProperties(String obj, String[] propertyNames, propertyData_u[] propData, stringValueSeq_tHolder uifValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyNames);
    args_[2] = TcUtility.createArg(propData);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setTCProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValues.value = TcUtility.queryArgStringUnion(response.output[0], uifValues.value);
  }

  public void getPropertyDescriptions(String type, stringSeq_tHolder propertyNames, stringValueSeq_tHolder propertyDisplayNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getPropertyDescriptions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyNames.value = TcUtility.queryArg(response.output[0], propertyNames.value);
    propertyDisplayNames.value = TcUtility.queryArgStringUnion(response.output[1], propertyDisplayNames.value);
  }

  public void getAllPropertyDescriptions(String type, propertyDescriptorSeq_tHolder propDescriptors) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getAllPropertyDescriptions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propDescriptors.value = TcUtility.queryArg(response.output[0], propDescriptors.value);
  }

  public void getRelatedInfo(String obj, stringSeqValue_u relatedTypes, uidSeqValue_uHolder components, uidSeqValue_uHolder componentTypes, stringSeqValue_uHolder componentContextNames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(relatedTypes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getRelatedInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
    componentTypes.value = TcUtility.queryArg(response.output[1], componentTypes.value);
    componentContextNames.value = TcUtility.queryArg(response.output[2], componentContextNames.value);
  }

  public void setRelated(String obj, String componentContextName, String[] components) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(componentContextName);
    args_[2] = TcUtility.createArg(components);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setRelated", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void insertRelated(String obj, String componentContextName, String[] components, int index) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(componentContextName);
    args_[2] = TcUtility.createArg(components);
    args_[3] = TcUtility.createArg(index);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "insertRelated", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeRelated(String obj, String componentContextName, String[] components) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(componentContextName);
    args_[2] = TcUtility.createArg(components);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "removeRelated", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyStringArray(String obj, String propertyName, stringValueSeq_tHolder stringValues, BooleanHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getTCPropertyStringArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    stringValues.value = TcUtility.queryArgStringUnion(response.output[0], stringValues.value);
    isModifiable.value = TcUtility.queryArg(response.output[1], isModifiable.value);
  }

  public void setTCPropertyStringArray(String obj, String propertyName, String[] stringValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    args_[2] = TcUtility.createArgStringUnion(stringValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setTCPropertyStringArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyTagArray(String obj, String propertyName, uidValueSeq_tHolder objValues, uidValueSeq_tHolder typeObjs, BooleanHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getTCPropertyTagArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objValues.value = TcUtility.queryArgStringUnion(response.output[0], objValues.value);
    typeObjs.value = TcUtility.queryArgStringUnion(response.output[1], typeObjs.value);
    isModifiable.value = TcUtility.queryArg(response.output[2], isModifiable.value);
  }

  public void setTCPropertyTagArray(String obj, String propertyName, String[] objValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    args_[2] = TcUtility.createArgStringUnion(objValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setTCPropertyTagArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyIntArray(String obj, String propertyName, longValueSeq_tHolder longValues, BooleanHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getTCPropertyIntArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    longValues.value = TcUtility.queryArg(response.output[0], longValues.value);
    isModifiable.value = TcUtility.queryArg(response.output[1], isModifiable.value);
  }

  public void setTCPropertyIntArray(String obj, String propertyName, int[] longValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    args_[2] = TcUtility.createArg(longValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setTCPropertyIntArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyDoubleArray(String obj, String propertyName, doubleValueSeq_tHolder doubleValues, BooleanHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getTCPropertyDoubleArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    doubleValues.value = TcUtility.queryArg(response.output[0], doubleValues.value);
    isModifiable.value = TcUtility.queryArg(response.output[1], isModifiable.value);
  }

  public void setTCPropertyDoubleArray(String obj, String propertyName, double[] doubleValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    args_[2] = TcUtility.createArg(doubleValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setTCPropertyDoubleArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyFloatArray(String obj, String propertyName, floatValueSeq_tHolder floatValues, BooleanHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getTCPropertyFloatArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    floatValues.value = TcUtility.queryArg(response.output[0], floatValues.value);
    isModifiable.value = TcUtility.queryArg(response.output[1], isModifiable.value);
  }

  public void setTCPropertyFloatArray(String obj, String propertyName, float[] floatValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    args_[2] = TcUtility.createArg(floatValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setTCPropertyFloatArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTCPropertyLogicalArray(String obj, String propertyName, booleanValueSeq_tHolder booleanValues, BooleanHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getTCPropertyLogicalArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    booleanValues.value = TcUtility.queryArg(response.output[0], booleanValues.value);
    isModifiable.value = TcUtility.queryArg(response.output[1], isModifiable.value);
  }

  public void setTCPropertyLogicalArray(String obj, String propertyName, boolean[] booleanValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    args_[2] = TcUtility.createArg(booleanValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setTCPropertyLogicalArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getLogicalProperty(String obj, String propertyName, BooleanHolder booleanValue, StringHolder displayValue, BooleanHolder isModifiable) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getLogicalProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    booleanValue.value = TcUtility.queryArg(response.output[0], booleanValue.value);
    displayValue.value = TcUtility.queryArgStringUnion(response.output[1], displayValue.value);
    isModifiable.value = TcUtility.queryArg(response.output[2], isModifiable.value);
  }

  public void setLogicalProperty(String obj, String propertyName, boolean booleanValue) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(propertyName);
    args_[2] = TcUtility.createArg(booleanValue);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "setLogicalProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAllCompoundPropertyDefs(uidSeqValue_uHolder cpdefObjs, uidSeqValue_uHolder cpdefTypeObjs) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPropertyService", "getAllCompoundPropertyDefs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    cpdefObjs.value = TcUtility.queryArg(response.output[0], cpdefObjs.value);
    cpdefTypeObjs.value = TcUtility.queryArg(response.output[1], cpdefTypeObjs.value);
  }

}
