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

public class ICCTTask extends ICCT {
  public ICCTTask(Connection connection) {
    super(connection);
  }

  public ICCTTask(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String taskName, String taskDescription, String taskDefinitionName, StringHolder taskUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(taskName);
    args_[3] = TcUtility.createArg(taskDescription);
    args_[4] = TcUtility.createArg(taskDefinitionName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    taskUid.value = TcUtility.queryArg(response.output[0], taskUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void getAttachments(String objUid, int attachmentScope, int attachmentType, uidSeq_tHolder attachmentUids, uidSeq_tHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(attachmentScope);
    args_[4] = TcUtility.createArg(attachmentType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "getAttachments", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attachmentUids.value = TcUtility.queryArg(response.output[0], attachmentUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[1], componentTypeUids.value);
  }

  public void getAllAttachments(String objUid, int attachmentScope, longSeq_tHolder attachmentTypes, uidSeq_tHolder attachmentUids, uidSeq_tHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(attachmentScope);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "getAllAttachments", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attachmentTypes.value = TcUtility.queryArg(response.output[0], attachmentTypes.value);
    attachmentUids.value = TcUtility.queryArg(response.output[1], attachmentUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[2], componentTypeUids.value);
  }

  public void addAttachments(String objUid, int attachmentScope, int[] attachmentTypes, String[] attachmentUids) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(attachmentScope);
    args_[4] = TcUtility.createArg(attachmentTypes);
    args_[5] = TcUtility.createArg(attachmentUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "addAttachments", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeAttachments(String objUid, String[] attachmentUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(attachmentUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "removeAttachments", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void performAction(String objUid, int action, String comments) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(action);
    args_[4] = TcUtility.createArg(comments);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "performAction", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void performSecureAction(String objUid, int action, String comments, String password) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(action);
    args_[4] = TcUtility.createArg(comments);
    args_[5] = TcUtility.createArg(password);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "performSecureAction", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void performOnSubTasks(String objUid, int action, String comments) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(action);
    args_[4] = TcUtility.createArg(comments);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "performOnSubTasks", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void updateSignoffs(String objUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "updateSignoffs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void checkRule(String objUid, int action, IntHolder decision) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(action);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "checkRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    decision.value = TcUtility.queryArg(response.output[0], decision.value);
  }

  public void findSubtask(String objUid, String name, StringHolder componentUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "findSubtask", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUid.value = TcUtility.queryArg(response.output[0], componentUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void getAssignedProfiles(String objUid, IntHolder count, stringSeqValue_uHolder profiles, uidSeqValue_uHolder componentUids, uidSeqValue_uHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "getAssignedProfiles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    count.value = TcUtility.queryArg(response.output[0], count.value);
    profiles.value = TcUtility.queryArg(response.output[1], profiles.value);
    componentUids.value = TcUtility.queryArg(response.output[2], componentUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[3], componentTypeUids.value);
  }

  public void getUnassignedProfiles(String objUid, stringSeqValue_uHolder profiles) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "getUnassignedProfiles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    profiles.value = TcUtility.queryArg(response.output[0], profiles.value);
  }

  public void isPrivilegedUser(String objUid, String userUid, BooleanHolder isPrivileged) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(objUid);
    args_[3] = TcUtility.createArgStringUnion(userUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "isPrivilegedUser", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isPrivileged.value = TcUtility.queryArg(response.output[0], isPrivileged.value);
  }

  public void transferCheckoutsOfTargets(String taskUid, String fromUserUid, String toUserUid, uidSeqValue_uHolder componentUids, uidSeqValue_uHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(taskUid);
    args_[3] = TcUtility.createArg(fromUserUid);
    args_[4] = TcUtility.createArgStringUnion(toUserUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "transferCheckoutsOfTargets", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUids.value = TcUtility.queryArg(response.output[0], componentUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[1], componentTypeUids.value);
  }

  public void setStandIn(String signoffUid, String surrogateUid, boolean xferChkouts, uidSeqValue_uHolder objectUids, uidSeqValue_uHolder objectTypeUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signoffUid);
    args_[3] = TcUtility.createArg(surrogateUid);
    args_[4] = TcUtility.createArg(xferChkouts);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "setStandIn", args_);
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
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTask", "releaseStandIn", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectUids.value = TcUtility.queryArg(response.output[0], objectUids.value);
    objectTypeUids.value = TcUtility.queryArg(response.output[1], objectTypeUids.value);
  }

}
