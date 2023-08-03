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

public class ICCTProcessDefinition extends ICCT {
  public ICCTProcessDefinition(Connection connection) {
    super(connection);
  }

  public ICCTProcessDefinition(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void find(String name, StringHolder processDefinitionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcessDefinition", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    processDefinitionUid.value = TcUtility.queryArg(response.output[0], processDefinitionUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void create(String processDefinitionName, String processDefinitionDescription, String taskType, StringHolder processDefinitionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(processDefinitionName);
    args_[3] = TcUtility.createArgStringUnion(processDefinitionDescription);
    args_[4] = TcUtility.createArgStringUnion(taskType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcessDefinition", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    processDefinitionUid.value = TcUtility.queryArg(response.output[0], processDefinitionUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void createFromTemplate(String processDefinitionName, String processDefinitionDescription, String taskTemplateUid, StringHolder processDefinitionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(processDefinitionName);
    args_[3] = TcUtility.createArgStringUnion(processDefinitionDescription);
    args_[4] = TcUtility.createArg(taskTemplateUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcessDefinition", "createFromTemplate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    processDefinitionUid.value = TcUtility.queryArg(response.output[0], processDefinitionUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void getRegisteredHandlerNames(int handlerType, stringValueSeq_tHolder names) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(handlerType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcessDefinition", "getRegisteredHandlerNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    names.value = TcUtility.queryArgStringUnion(response.output[0], names.value);
  }

  public void getAssignedProcesses(String groupName, String objType, stringValueSeq_tHolder procNames) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(groupName);
    args_[3] = TcUtility.createArgStringUnion(objType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcessDefinition", "getAssignedProcesses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    procNames.value = TcUtility.queryArgStringUnion(response.output[0], procNames.value);
  }

  public void getAssignedProcessesForMultipleObjects(String groupName, String[] objectTypes, int numberOfObjects, stringValueSeq_tHolder procNames) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(groupName);
    args_[3] = TcUtility.createArgStringUnion(objectTypes);
    args_[4] = TcUtility.createArg(numberOfObjects);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcessDefinition", "getAssignedProcessesForMultipleObjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    procNames.value = TcUtility.queryArgStringUnion(response.output[0], procNames.value);
  }

  public void saveAssignedProcesses(String groupName, String objType, int count, stringSeqValue_u procNames) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(groupName);
    args_[3] = TcUtility.createArgStringUnion(objType);
    args_[4] = TcUtility.createArg(count);
    args_[5] = TcUtility.createArg(procNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProcessDefinition", "saveAssignedProcesses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
