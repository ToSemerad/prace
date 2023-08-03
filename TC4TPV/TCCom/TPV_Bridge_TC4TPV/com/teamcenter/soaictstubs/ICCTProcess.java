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

public class ICCTProcess extends ICCT {
  public ICCTProcess(Connection connection) {
    super(connection);
  }

  public ICCTProcess(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String processName, String processDescription, String taskTemplateUid, String parentProcessUid, String depParentProcessTaskUid, int[] attachmentTypes, String[] attachmentUids, StringHolder processUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(processName);
    args_[3] = TcUtility.createArg(processDescription);
    args_[4] = TcUtility.createArg(taskTemplateUid);
    args_[5] = TcUtility.createArg(parentProcessUid);
    args_[6] = TcUtility.createArg(depParentProcessTaskUid);
    args_[7] = TcUtility.createArg(attachmentTypes);
    args_[8] = TcUtility.createArg(attachmentUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    processUid.value = TcUtility.queryArg(response.output[0], processUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void createWithPAL(String processName, String processDescription, String taskTemplateUid, int[] attachmentTypes, String[] attachmentUids, resourceListInfo_s[] resources, StringHolder processUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(processName);
    args_[3] = TcUtility.createArg(processDescription);
    args_[4] = TcUtility.createArg(taskTemplateUid);
    args_[5] = TcUtility.createArg(attachmentTypes);
    args_[6] = TcUtility.createArg(attachmentUids);
    args_[7] = TcUtility.createArg(resources);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "createWithPAL", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    processUid.value = TcUtility.queryArg(response.output[0], processUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void performAction(String objUid, int action, String comments) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(action);
    args_[4] = TcUtility.createArg(comments);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "performAction", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void refreshEntireProcess(String objUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "refreshEntireProcess", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void isEffectivityUser(boolean isEffUser) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(isEffUser);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "isEffectivityUser", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void findReleaseLevelTask(String objUid, String relName, StringHolder relTask) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(relName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "findReleaseLevelTask", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    relTask.value = TcUtility.queryArg(response.output[0], relTask.value);
  }

  public void isDuplicateName(String processName, BooleanHolder isDuplicate) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(processName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "isDuplicateName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isDuplicate.value = TcUtility.queryArg(response.output[0], isDuplicate.value);
  }

  public void getProcessTemplate(String objUid, StringHolder componentUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "getProcessTemplate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUid.value = TcUtility.queryArg(response.output[0], componentUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void lockProcessTemplate(String objUid, StringHolder componentUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "lockProcessTemplate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUid.value = TcUtility.queryArg(response.output[0], componentUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void saveProcessTemplate(String objUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "saveProcessTemplate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unlockProcessTemplate(String objUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "unlockProcessTemplate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void assignAllTasks(String objUid, resourceListInfo_s[] resources) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(resources);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "assignAllTasks", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void generateSignoffReport(String processUid, StringHolder dirPath, StringHolder fileName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(processUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcess", "generateSignoffReport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    dirPath.value = TcUtility.queryArgStringUnion(response.output[0], dirPath.value);
    fileName.value = TcUtility.queryArgStringUnion(response.output[1], fileName.value);
  }

}
