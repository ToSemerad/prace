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

public class ICCTAppearanceConfigContext extends ICCT {
  public ICCTAppearanceConfigContext(Connection connection) {
    super(connection);
  }

  public ICCTAppearanceConfigContext(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String revisionRule, StringHolder newAppearanceConfigContext, StringHolder newType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceConfigContext", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newAppearanceConfigContext.value = TcUtility.queryArg(response.output[0], newAppearanceConfigContext.value);
    newType.value = TcUtility.queryArg(response.output[1], newType.value);
  }

  public void find(String revisionRule, uidSeq_tHolder foundAppearanceConfigContexts, uidSeq_tHolder foundTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(revisionRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceConfigContext", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    foundAppearanceConfigContexts.value = TcUtility.queryArg(response.output[0], foundAppearanceConfigContexts.value);
    foundTypes.value = TcUtility.queryArg(response.output[1], foundTypes.value);
  }

  public void isSuitableRevisionRule(String revisionRule, BooleanHolder verdict) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceConfigContext", "isSuitableRevisionRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

}
