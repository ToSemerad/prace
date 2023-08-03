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

public class ICCTSignoff extends ICCT {
  public ICCTSignoff(Connection connection) {
    super(connection);
  }

  public ICCTSignoff(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String memberUid, StringHolder signoffUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(memberUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSignoff", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    signoffUid.value = TcUtility.queryArg(response.output[0], signoffUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void createSignoff(String memberUid, int originType, String originProfile, StringHolder signoffUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(memberUid);
    args_[3] = TcUtility.createArg(originType);
    args_[4] = TcUtility.createArgStringUnion(originProfile);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSignoff", "createSignoff", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    signoffUid.value = TcUtility.queryArg(response.output[0], signoffUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void createAdhocSignoffs(String taskUid, String memberUid, uidSeq_tHolder componentUids, uidSeq_tHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(taskUid);
    args_[3] = TcUtility.createArg(memberUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSignoff", "createAdhocSignoffs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUids.value = TcUtility.queryArg(response.output[0], componentUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[1], componentTypeUids.value);
  }

  public void initialize(String objUid, String groupMemberUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(groupMemberUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSignoff", "initialize", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void delegate(String objUid, String groupMemberUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(groupMemberUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSignoff", "delegate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDecision(String signoffUid, int decision, String comments, String password) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signoffUid);
    args_[3] = TcUtility.createArg(decision);
    args_[4] = TcUtility.createArg(comments);
    args_[5] = TcUtility.createArg(password);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSignoff", "setDecision", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setStandIn(String signoffUid, String surrogateUid, boolean xferChkouts, uidSeqValue_uHolder objectUids, uidSeqValue_uHolder objectTypeUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signoffUid);
    args_[3] = TcUtility.createArg(surrogateUid);
    args_[4] = TcUtility.createArg(xferChkouts);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSignoff", "setStandIn", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectUids.value = TcUtility.queryArg(response.output[0], objectUids.value);
    objectTypeUids.value = TcUtility.queryArg(response.output[1], objectTypeUids.value);
  }

  public void releaseStandIn(String signoffUid, boolean xferChkouts, uidSeqValue_uHolder objectUids, uidSeqValue_uHolder objectTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signoffUid);
    args_[3] = TcUtility.createArg(xferChkouts);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSignoff", "releaseStandIn", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectUids.value = TcUtility.queryArg(response.output[0], objectUids.value);
    objectTypeUids.value = TcUtility.queryArg(response.output[1], objectTypeUids.value);
  }

}
