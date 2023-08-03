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

public class ICCTIdDisplayRule extends ICCT {
  public ICCTIdDisplayRule(Connection connection) {
    super(connection);
  }

  public ICCTIdDisplayRule(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void ruleCreate(String iddisplayruleType, StringHolder newIdDisplayRule, StringHolder iddisplayruleTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(iddisplayruleType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdDisplayRule", "ruleCreate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newIdDisplayRule.value = TcUtility.queryArg(response.output[0], newIdDisplayRule.value);
    iddisplayruleTypeUid.value = TcUtility.queryArg(response.output[1], iddisplayruleTypeUid.value);
  }

  public void ruleAdd(String[] iddisplayrules) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(iddisplayrules);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdDisplayRule", "ruleAdd", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void ruleRemove(String[] iddisplayrules) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(iddisplayrules);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdDisplayRule", "ruleRemove", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void ruleAskCurrent(StringHolder iddisplayrule, StringHolder iddisplayruleType) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdDisplayRule", "ruleAskCurrent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iddisplayrule.value = TcUtility.queryArgStringUnion(response.output[0], iddisplayrule.value);
    iddisplayruleType.value = TcUtility.queryArgStringUnion(response.output[1], iddisplayruleType.value);
  }

  public void ruleSetCurrent(String iddisplayrule) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(iddisplayrule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdDisplayRule", "ruleSetCurrent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void myRules(uidValueSeq_tHolder iddisplayrules, uidValueSeq_tHolder iddisplayruleTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdDisplayRule", "myRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iddisplayrules.value = TcUtility.queryArgStringUnion(response.output[0], iddisplayrules.value);
    iddisplayruleTypes.value = TcUtility.queryArgStringUnion(response.output[1], iddisplayruleTypes.value);
  }

  public void getRules(String user, uidValueSeq_tHolder iddisplayrules, uidValueSeq_tHolder iddisplayruleTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(user);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdDisplayRule", "getRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iddisplayrules.value = TcUtility.queryArgStringUnion(response.output[0], iddisplayrules.value);
    iddisplayruleTypes.value = TcUtility.queryArgStringUnion(response.output[1], iddisplayruleTypes.value);
  }

}
