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

public class ICCTTaskTemplate extends ICCT {
  public ICCTTaskTemplate(Connection connection) {
    super(connection);
  }

  public ICCTTaskTemplate(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String parentTaskTemplateUid, String taskDefinitionName, String taskDefinitionDescription, String taskType, StringHolder taskDefinitionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(parentTaskTemplateUid);
    args_[3] = TcUtility.createArg(taskDefinitionName);
    args_[4] = TcUtility.createArg(taskDefinitionDescription);
    args_[5] = TcUtility.createArg(taskType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    taskDefinitionUid.value = TcUtility.queryArg(response.output[0], taskDefinitionUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void createFromTemplate(String parentTaskTemplateUid, String taskDefinitionName, String taskDefinitionDescription, String taskTemplateUid, StringHolder taskDefinitionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(parentTaskTemplateUid);
    args_[3] = TcUtility.createArg(taskDefinitionName);
    args_[4] = TcUtility.createArg(taskDefinitionDescription);
    args_[5] = TcUtility.createArg(taskTemplateUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "createFromTemplate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    taskDefinitionUid.value = TcUtility.queryArg(response.output[0], taskDefinitionUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void removeTaskTemplate(String objUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "removeTaskTemplate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getActionHandlers(String objUid, int action, uidSeq_tHolder actionHandlerUids, uidSeq_tHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(action);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "getActionHandlers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    actionHandlerUids.value = TcUtility.queryArg(response.output[0], actionHandlerUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[1], componentTypeUids.value);
  }

  public void addActionHandler(String objUid, int action, String actionHandlerUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(action);
    args_[4] = TcUtility.createArg(actionHandlerUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "addActionHandler", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeActionHandler(String objUid, int action, String actionHandlerUid, boolean deleteHandler) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(action);
    args_[4] = TcUtility.createArg(actionHandlerUid);
    args_[5] = TcUtility.createArg(deleteHandler);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "removeActionHandler", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getRules(String objUid, int action, uidSeq_tHolder ruleUids, uidSeq_tHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(action);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "getRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleUids.value = TcUtility.queryArg(response.output[0], ruleUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[1], componentTypeUids.value);
  }

  public void addRule(String objUid, int action, String ruleUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(action);
    args_[4] = TcUtility.createArg(ruleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "addRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeRule(String objUid, String ruleUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(ruleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "removeRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeRuleHandler(String objUid, String ruleUid, String ruleHandlerUid, boolean deleteHandler) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(ruleUid);
    args_[4] = TcUtility.createArg(ruleHandlerUid);
    args_[5] = TcUtility.createArg(deleteHandler);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "removeRuleHandler", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getHandler(String objUid, int handlerType, int action, String handlerName, StringHolder componentUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(handlerType);
    args_[4] = TcUtility.createArg(action);
    args_[5] = TcUtility.createArg(handlerName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "getHandler", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUid.value = TcUtility.queryArg(response.output[0], componentUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void copyTaskTemplate(String objUid, StringHolder componentUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "copyTaskTemplate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUid.value = TcUtility.queryArg(response.output[0], componentUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void modifyTemplate(String objUid, boolean[] modifyFlags, StringHolder componentUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objUid);
    args_[3] = TcUtility.createArg(modifyFlags);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "modifyTemplate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUid.value = TcUtility.queryArg(response.output[0], componentUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void extentTaskTemplates(int stage, int templateType, uidSeqValue_uHolder objs, uidSeqValue_uHolder objTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(stage);
    args_[3] = TcUtility.createArg(templateType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "extentTaskTemplates", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objs.value = TcUtility.queryArg(response.output[0], objs.value);
    objTypes.value = TcUtility.queryArg(response.output[1], objTypes.value);
  }

  public void extentReadyTemplates(boolean switchOffUCTemplates, longValueSeq_tHolder stageValues, uidSeqValue_uHolder objs, uidSeqValue_uHolder objTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(switchOffUCTemplates);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "extentReadyTemplates", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    stageValues.value = TcUtility.queryArg(response.output[0], stageValues.value);
    objs.value = TcUtility.queryArg(response.output[1], objs.value);
    objTypes.value = TcUtility.queryArg(response.output[2], objTypes.value);
  }

  public void extentLockedTemplates(uidSeqValue_uHolder objs, uidSeqValue_uHolder objTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "extentLockedTemplates", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objs.value = TcUtility.queryArg(response.output[0], objs.value);
    objTypes.value = TcUtility.queryArg(response.output[1], objTypes.value);
  }

  public void extentModifiableTemplates(uidSeqValue_uHolder objs, uidSeqValue_uHolder objTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "extentModifiableTemplates", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objs.value = TcUtility.queryArg(response.output[0], objs.value);
    objTypes.value = TcUtility.queryArg(response.output[1], objTypes.value);
  }

  public void extentTemplates(int templateType, longValueSeq_tHolder stageValues, uidSeqValue_uHolder objs, uidSeqValue_uHolder objTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(templateType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "extentTemplates", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    stageValues.value = TcUtility.queryArg(response.output[0], stageValues.value);
    objs.value = TcUtility.queryArg(response.output[1], objs.value);
    objTypes.value = TcUtility.queryArg(response.output[2], objTypes.value);
  }

  public void find(String name, int templateType, StringHolder processDefinitionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(name);
    args_[3] = TcUtility.createArg(templateType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "find", args_);
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
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "getRegisteredHandlerNames", args_);
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
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "getAssignedProcesses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    procNames.value = TcUtility.queryArgStringUnion(response.output[0], procNames.value);
  }

  public void getAssignedProcessesForMultipleObjects(boolean switchOffUCTemplates, String groupName, String[] objectTypes, int numberOfObjects, uidSeqValue_uHolder objs, uidSeqValue_uHolder objTypes) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(switchOffUCTemplates);
    args_[3] = TcUtility.createArgStringUnion(groupName);
    args_[4] = TcUtility.createArgStringUnion(objectTypes);
    args_[5] = TcUtility.createArg(numberOfObjects);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "getAssignedProcessesForMultipleObjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objs.value = TcUtility.queryArg(response.output[0], objs.value);
    objTypes.value = TcUtility.queryArg(response.output[1], objTypes.value);
  }

  public void saveAssignedProcesses(String groupName, String objType, int count, stringSeqValue_u procNames) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(groupName);
    args_[3] = TcUtility.createArgStringUnion(objType);
    args_[4] = TcUtility.createArg(count);
    args_[5] = TcUtility.createArg(procNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "saveAssignedProcesses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unlockTemplates(uidSeqValue_u processTemplateUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(processTemplateUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "unlockTemplates", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void purgeObsoleteTemplates() throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTaskTemplate", "purgeObsoleteTemplates", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
