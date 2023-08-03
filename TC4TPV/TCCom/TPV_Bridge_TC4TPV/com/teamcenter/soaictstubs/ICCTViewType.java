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

public class ICCTViewType extends ICCT {
  public ICCTViewType(Connection connection) {
    super(connection);
  }

  public ICCTViewType(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, StringHolder type, StringHolder typeTypeObj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTViewType", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    type.value = TcUtility.queryArg(response.output[0], type.value);
    typeTypeObj.value = TcUtility.queryArg(response.output[1], typeTypeObj.value);
  }

  public void remove(String typeObj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTViewType", "remove", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setName(String typeObj, String name) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeObj);
    args_[3] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTViewType", "setName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getValidOccurrenceTypes(String type, uidSeq_tHolder occTypes, StringHolder occTypeType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTViewType", "getValidOccurrenceTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    occTypes.value = TcUtility.queryArg(response.output[0], occTypes.value);
    occTypeType.value = TcUtility.queryArg(response.output[1], occTypeType.value);
  }

  public void getDefaultOccurrenceType(String viewType, StringHolder occTag, StringHolder occTypeType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(viewType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTViewType", "getDefaultOccurrenceType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    occTag.value = TcUtility.queryArg(response.output[0], occTag.value);
    occTypeType.value = TcUtility.queryArg(response.output[1], occTypeType.value);
  }

}
