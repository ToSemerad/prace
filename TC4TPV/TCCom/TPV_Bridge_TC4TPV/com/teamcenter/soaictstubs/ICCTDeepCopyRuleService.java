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

public class ICCTDeepCopyRuleService {
  ICTService m_service;

  Connection m_connection;


  public ICCTDeepCopyRuleService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getDeepCopyRulesForIRType(String revTypeName, String operationType, String[] copyType, deepcopyruleInfoSeqSeq_tHolder rules) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(revTypeName);
    args_[1] = TcUtility.createArg(operationType);
    args_[2] = TcUtility.createArg(copyType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDeepCopyRuleService", "getDeepCopyRulesForIRType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rules.value = TcUtility.queryArg(response.output[0], rules.value);
  }

  public void createDeepCopyRules(String revTypeName, String operationType, String[] copyType, deepcopyruleInfo_s[][] rules, uidSeqSeq_tHolder rulesUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(revTypeName);
    args_[1] = TcUtility.createArg(operationType);
    args_[2] = TcUtility.createArg(copyType);
    args_[3] = TcUtility.createArg(rules);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDeepCopyRuleService", "createDeepCopyRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rulesUids.value = TcUtility.queryArg(response.output[0], rulesUids.value);
  }

  public void deleteDeepCopyRules(String revTypeName, String operationType, String[] copyType, deepcopyruleInfo_s[][] rules) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(revTypeName);
    args_[1] = TcUtility.createArg(operationType);
    args_[2] = TcUtility.createArg(copyType);
    args_[3] = TcUtility.createArg(rules);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDeepCopyRuleService", "deleteDeepCopyRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void modifyDeepCopyRules(String revTypeName, String operationType, String[] copyType, deepcopyruleInfo_s[][] Origrules, deepcopyruleInfo_s[][] rules) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(revTypeName);
    args_[1] = TcUtility.createArg(operationType);
    args_[2] = TcUtility.createArg(copyType);
    args_[3] = TcUtility.createArg(Origrules);
    args_[4] = TcUtility.createArg(rules);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDeepCopyRuleService", "modifyDeepCopyRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void isRuleExists(String itemRevType, String opType, String copyType, deepcopyruleInfo_s rule, BooleanHolder isExists) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(itemRevType);
    args_[1] = TcUtility.createArg(opType);
    args_[2] = TcUtility.createArg(copyType);
    args_[3] = TcUtility.createArg(rule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDeepCopyRuleService", "isRuleExists", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isExists.value = TcUtility.queryArg(response.output[0], isExists.value);
  }

}
