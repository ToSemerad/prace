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

public class ICCTRule extends ICCT {
  public ICCTRule(Connection connection) {
    super(connection);
  }

  public ICCTRule(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String taskDefinitionUid, int epmAction, String ruleHandlerName, String[] ruleHandlerArgs, StringHolder ruleHandlerDefinitionUid, StringHolder ruleDefinitionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(taskDefinitionUid);
    args_[3] = TcUtility.createArg(epmAction);
    args_[4] = TcUtility.createArg(ruleHandlerName);
    args_[5] = TcUtility.createArg(ruleHandlerArgs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRule", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleHandlerDefinitionUid.value = TcUtility.queryArg(response.output[0], ruleHandlerDefinitionUid.value);
    ruleDefinitionUid.value = TcUtility.queryArg(response.output[1], ruleDefinitionUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[2], componentTypeUid.value);
  }

  public void getRuleHandlers(String objUid, uidSeq_tHolder ruleHandlerUids, uidSeq_tHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRule", "getRuleHandlers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleHandlerUids.value = TcUtility.queryArg(response.output[0], ruleHandlerUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[1], componentTypeUids.value);
  }

  public void addRuleHandler(String objUid, String ruleHandlerUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(ruleHandlerUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRule", "addRuleHandler", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
