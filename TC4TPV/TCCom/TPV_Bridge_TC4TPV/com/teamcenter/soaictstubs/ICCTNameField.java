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

public class ICCTNameField extends ICCT {
  public ICCTNameField(Connection connection) {
    super(connection);
  }

  public ICCTNameField(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void attachProperty(String ruleUid, String typeName, String propertyName, int fieldCase) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    args_[3] = TcUtility.createArgStringUnion(typeName);
    args_[4] = TcUtility.createArgStringUnion(propertyName);
    args_[5] = TcUtility.createArg(fieldCase);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameField", "attachProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void detachProperty(String ruleUid, String typeName, String propertyName) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    args_[3] = TcUtility.createArgStringUnion(typeName);
    args_[4] = TcUtility.createArgStringUnion(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameField", "detachProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askAttachedRule(String typeName, String propertyName, StringHolder ruleUid, StringHolder ruleTypeUid, IntHolder fieldCase) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(typeName);
    args_[3] = TcUtility.createArgStringUnion(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameField", "askAttachedRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleUid.value = TcUtility.queryArg(response.output[0], ruleUid.value);
    ruleTypeUid.value = TcUtility.queryArg(response.output[1], ruleTypeUid.value);
    fieldCase.value = TcUtility.queryArg(response.output[2], fieldCase.value);
  }

  public void modifyCase(String typeName, String propertyName, int fieldCase) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(typeName);
    args_[3] = TcUtility.createArgStringUnion(propertyName);
    args_[4] = TcUtility.createArg(fieldCase);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameField", "modifyCase", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
