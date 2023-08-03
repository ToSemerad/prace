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

public class ICCTAppearanceAttrDefinition extends ICCT {
  public ICCTAppearanceAttrDefinition(Connection connection) {
    super(connection);
  }

  public ICCTAppearanceAttrDefinition(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String attrName, StringHolder newDefinition, StringHolder newType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(attrName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceAttrDefinition", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newDefinition.value = TcUtility.queryArg(response.output[0], newDefinition.value);
    newType.value = TcUtility.queryArg(response.output[1], newType.value);
  }

  public void deleteInstances(String definition) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(definition);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceAttrDefinition", "deleteInstances", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void list(uidSeqValue_uHolder values, uidSeqValue_uHolder typeValues) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceAttrDefinition", "list", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArg(response.output[0], values.value);
    typeValues.value = TcUtility.queryArg(response.output[1], typeValues.value);
  }

  public void askName(String attrDef, StringHolder attrName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrDef);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceAttrDefinition", "askName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attrName.value = TcUtility.queryArgStringUnion(response.output[0], attrName.value);
  }

  public void askNames(stringSeqValue_uHolder attrNames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceAttrDefinition", "askNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attrNames.value = TcUtility.queryArg(response.output[0], attrNames.value);
  }

}
