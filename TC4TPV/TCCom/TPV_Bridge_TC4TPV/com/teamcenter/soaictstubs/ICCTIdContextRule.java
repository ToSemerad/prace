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

public class ICCTIdContextRule extends ICCT {
  public ICCTIdContextRule(Connection connection) {
    super(connection);
  }

  public ICCTIdContextRule(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void ruleCreate(String idcontextruleType, StringHolder newIdContextRule, StringHolder idcontextruleTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(idcontextruleType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdContextRule", "ruleCreate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newIdContextRule.value = TcUtility.queryArg(response.output[0], newIdContextRule.value);
    idcontextruleTypeUid.value = TcUtility.queryArg(response.output[1], idcontextruleTypeUid.value);
  }

  public void getUIAltidRules(uidValueSeq_tHolder idcontexts, uidValueSeq_tHolder idcontextTypes, uidValueSeq_tHolder identifiableTypes, uidValueSeq_tHolder identifiableTypeTypes, uidValueSeq_tHolder identiferTypes, uidValueSeq_tHolder identiferTypeTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdContextRule", "getUIAltidRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    idcontexts.value = TcUtility.queryArgStringUnion(response.output[0], idcontexts.value);
    idcontextTypes.value = TcUtility.queryArgStringUnion(response.output[1], idcontextTypes.value);
    identifiableTypes.value = TcUtility.queryArgStringUnion(response.output[2], identifiableTypes.value);
    identifiableTypeTypes.value = TcUtility.queryArgStringUnion(response.output[3], identifiableTypeTypes.value);
    identiferTypes.value = TcUtility.queryArgStringUnion(response.output[4], identiferTypes.value);
    identiferTypeTypes.value = TcUtility.queryArgStringUnion(response.output[5], identiferTypeTypes.value);
  }

  public void getUIAliasidRules(uidValueSeq_tHolder idcontexts, uidValueSeq_tHolder idcontextTypes, uidValueSeq_tHolder identiferTypes, uidValueSeq_tHolder identiferTypeTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdContextRule", "getUIAliasidRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    idcontexts.value = TcUtility.queryArgStringUnion(response.output[0], idcontexts.value);
    idcontextTypes.value = TcUtility.queryArgStringUnion(response.output[1], idcontextTypes.value);
    identiferTypes.value = TcUtility.queryArgStringUnion(response.output[2], identiferTypes.value);
    identiferTypeTypes.value = TcUtility.queryArgStringUnion(response.output[3], identiferTypeTypes.value);
  }

  public void getAltidContexts(uidValueSeq_tHolder idcontexts, uidValueSeq_tHolder idcontextTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdContextRule", "getAltidContexts", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    idcontexts.value = TcUtility.queryArgStringUnion(response.output[0], idcontexts.value);
    idcontextTypes.value = TcUtility.queryArgStringUnion(response.output[1], idcontextTypes.value);
  }

}
