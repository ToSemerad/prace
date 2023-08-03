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

public class ICCTRuleHandler extends ICCT {
  public ICCTRuleHandler(Connection connection) {
    super(connection);
  }

  public ICCTRuleHandler(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String ruleDefinitionUid, int ruleQuorum, String ruleHandlerName, String[] ruleHandlerArgs, StringHolder ruleHandlerDefinitionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleDefinitionUid);
    args_[3] = TcUtility.createArg(ruleQuorum);
    args_[4] = TcUtility.createArg(ruleHandlerName);
    args_[5] = TcUtility.createArg(ruleHandlerArgs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRuleHandler", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleHandlerDefinitionUid.value = TcUtility.queryArg(response.output[0], ruleHandlerDefinitionUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void removeRuleHandler(String ruleHandlerUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleHandlerUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRuleHandler", "removeRuleHandler", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
