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

public class ICCTNameRule extends ICCT {
  public ICCTNameRule(Connection connection) {
    super(connection);
  }

  public ICCTNameRule(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String ruleName, String[] patterns, boolean autoGen, String init, String max, StringHolder newRuleUid, StringHolder newRuleTypeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleName);
    args_[3] = TcUtility.createArgStringUnion(patterns);
    args_[4] = TcUtility.createArg(autoGen);
    args_[5] = TcUtility.createArg(init);
    args_[6] = TcUtility.createArg(max);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRuleUid.value = TcUtility.queryArg(response.output[0], newRuleUid.value);
    newRuleTypeUid.value = TcUtility.queryArg(response.output[1], newRuleTypeUid.value);
  }

  public void find(String ruleName, StringHolder ruleUid, StringHolder ruleTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleUid.value = TcUtility.queryArg(response.output[0], ruleUid.value);
    ruleTypeUid.value = TcUtility.queryArg(response.output[1], ruleTypeUid.value);
  }

  public void deleteRule(String ruleUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "deleteRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getRuleName(String ruleUid, StringHolder ruleName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "getRuleName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleName.value = TcUtility.queryArgStringUnion(response.output[0], ruleName.value);
  }

  public void getPatterns(String ruleUid, IntHolder nPatStrs, stringSeqValue_uHolder patStrs) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "getPatterns", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nPatStrs.value = TcUtility.queryArg(response.output[0], nPatStrs.value);
    patStrs.value = TcUtility.queryArg(response.output[1], patStrs.value);
  }

  public void insertPattern(String ruleUid, int pos, String patStr) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    args_[3] = TcUtility.createArg(pos);
    args_[4] = TcUtility.createArg(patStr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "insertPattern", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removePattern(String ruleUid, String patStr) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    args_[3] = TcUtility.createArg(patStr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "removePattern", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void modifyPattern(String ruleUid, String fromPatStr, String toPatStr) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    args_[3] = TcUtility.createArg(fromPatStr);
    args_[4] = TcUtility.createArg(toPatStr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "modifyPattern", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setAutogen(String ruleUid, boolean autoGen) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    args_[3] = TcUtility.createArg(autoGen);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "setAutogen", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAutogen(String ruleUid, BooleanHolder autoGen) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "getAutogen", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    autoGen.value = TcUtility.queryArg(response.output[0], autoGen.value);
  }

  public void getInit(String ruleUid, StringHolder init) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "getInit", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    init.value = TcUtility.queryArgStringUnion(response.output[0], init.value);
  }

  public void getMax(String ruleUid, StringHolder max) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "getMax", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    max.value = TcUtility.queryArgStringUnion(response.output[0], max.value);
  }

  public void setInit(String ruleUid, String init) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    args_[3] = TcUtility.createArg(init);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "setInit", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setMax(String ruleUid, String max) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleUid);
    args_[3] = TcUtility.createArg(max);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNameRule", "setMax", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
