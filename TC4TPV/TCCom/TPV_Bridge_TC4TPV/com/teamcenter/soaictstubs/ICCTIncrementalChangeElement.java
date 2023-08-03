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

public class ICCTIncrementalChangeElement extends ICCT {
  public ICCTIncrementalChangeElement(Connection connection) {
    super(connection);
  }

  public ICCTIncrementalChangeElement(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String ecUid, String affectedUid, String parentUid, String contextName, int changeType, StringHolder icUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(ecUid);
    args_[3] = TcUtility.createArgStringUnion(affectedUid);
    args_[4] = TcUtility.createArgStringUnion(parentUid);
    args_[5] = TcUtility.createArgStringUnion(contextName);
    args_[6] = TcUtility.createArg(changeType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIncrementalChangeElement", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    icUid.value = TcUtility.queryArg(response.output[0], icUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void find(String ecRevUid, uidSeqValue_uHolder icUids, uidSeqValue_uHolder icTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ecRevUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIncrementalChangeElement", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    icUids.value = TcUtility.queryArg(response.output[0], icUids.value);
    icTypeUids.value = TcUtility.queryArg(response.output[1], icTypeUids.value);
  }

  public void getParentAndChildComponents(String objectUid, StringHolder parentComp, StringHolder childComp, StringHolder parentCompType, StringHolder childCompType, StringHolder changeContext) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIncrementalChangeElement", "getParentAndChildComponents", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    parentComp.value = TcUtility.queryArg(response.output[0], parentComp.value);
    childComp.value = TcUtility.queryArg(response.output[1], childComp.value);
    parentCompType.value = TcUtility.queryArg(response.output[2], parentCompType.value);
    childCompType.value = TcUtility.queryArg(response.output[3], childCompType.value);
    changeContext.value = TcUtility.queryArgStringUnion(response.output[4], changeContext.value);
  }

  public void splitIncrementalChange(String icRevTag, String[] iceTags, String icRevTargetTag) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(icRevTag);
    args_[3] = TcUtility.createArg(iceTags);
    args_[4] = TcUtility.createArg(icRevTargetTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIncrementalChangeElement", "splitIncrementalChange", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
