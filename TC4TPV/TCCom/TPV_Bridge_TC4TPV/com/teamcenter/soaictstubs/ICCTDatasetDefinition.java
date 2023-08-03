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

public class ICCTDatasetDefinition extends ICCT {
  public ICCTDatasetDefinition(Connection connection) {
    super(connection);
  }

  public ICCTDatasetDefinition(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String defaultToolName, String description, StringHolder dsDef, StringHolder dsDefType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArg(defaultToolName);
    args_[4] = TcUtility.createArgStringUnion(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    dsDef.value = TcUtility.queryArg(response.output[0], dsDef.value);
    dsDefType.value = TcUtility.queryArg(response.output[1], dsDefType.value);
  }

  public void find(String name, StringHolder dsDef, StringHolder dsDefType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    dsDef.value = TcUtility.queryArgStringUnion(response.output[0], dsDef.value);
    dsDefType.value = TcUtility.queryArgStringUnion(response.output[1], dsDefType.value);
  }

  public void askNamedReferences(String dsDef, stringSeqValue_uHolder refNames, stringSeqValue_uHolder refTemplates, stringSeqValue_uHolder refFormats) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsDef);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "askNamedReferences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    refNames.value = TcUtility.queryArg(response.output[0], refNames.value);
    refTemplates.value = TcUtility.queryArg(response.output[1], refTemplates.value);
    refFormats.value = TcUtility.queryArg(response.output[2], refFormats.value);
  }

  public void addNamedReferences(String dsDef, String[] refNames, String[] refTemplates, String[] refFormats) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsDef);
    args_[3] = TcUtility.createArg(refNames);
    args_[4] = TcUtility.createArg(refTemplates);
    args_[5] = TcUtility.createArg(refFormats);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "addNamedReferences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeNamedReferences(String dsDef, String[] refNames, String[] refTemplates, String[] refFormats) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsDef);
    args_[3] = TcUtility.createArg(refNames);
    args_[4] = TcUtility.createArg(refTemplates);
    args_[5] = TcUtility.createArg(refFormats);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "removeNamedReferences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTools(String dsDef, uidSeqValue_uHolder tools, uidSeqValue_uHolder toolTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsDef);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "getTools", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    tools.value = TcUtility.queryArg(response.output[0], tools.value);
    toolTypes.value = TcUtility.queryArg(response.output[1], toolTypes.value);
  }

  public void getDefaultTool(String dsDef, StringHolder defaultTool, StringHolder defaultToolType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsDef);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "getDefaultTool", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    defaultTool.value = TcUtility.queryArgStringUnion(response.output[0], defaultTool.value);
    defaultToolType.value = TcUtility.queryArgStringUnion(response.output[1], defaultToolType.value);
  }

  public void getToolMimeType(String tool, StringHolder mimeType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(tool);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "getToolMimeType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mimeType.value = TcUtility.queryArgStringUnion(response.output[0], mimeType.value);
  }

  public void getToolInputSwitches(String obj, String tool, int operationCode, stringSeqValue_uHolder switches) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "getToolInputSwitches", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    switches.value = TcUtility.queryArg(response.output[0], switches.value);
  }

  public void setOperationPreAction(String obj, String tool, int operationCode, String preactionTool) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    args_[5] = TcUtility.createArg(preactionTool);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "setOperationPreAction", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeOperationPreAction(String obj, String tool, int operationCode) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "removeOperationPreAction", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getOperationPreAction(String obj, String tool, int operationCode, StringHolder preactionTool, StringHolder preactionToolType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "getOperationPreAction", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    preactionTool.value = TcUtility.queryArgStringUnion(response.output[0], preactionTool.value);
    preactionToolType.value = TcUtility.queryArgStringUnion(response.output[1], preactionToolType.value);
  }

  public void setPreActionParameters(String obj, String tool, int operationCode, String[] parameters) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    args_[5] = TcUtility.createArg(parameters);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "setPreActionParameters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removePreActionParameters(String obj, String tool, int operationCode, String[] parameters) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    args_[5] = TcUtility.createArg(parameters);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "removePreActionParameters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getPreActionParameters(String obj, String tool, int operationCode, stringSeqValue_uHolder parameters) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "getPreActionParameters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    parameters.value = TcUtility.queryArg(response.output[0], parameters.value);
  }

  public void setOperationPostAction(String obj, String tool, int operationCode, String postactionTool) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    args_[5] = TcUtility.createArg(postactionTool);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "setOperationPostAction", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeOperationPostAction(String obj, String tool, int operationCode) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "removeOperationPostAction", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getOperationPostAction(String obj, String tool, int operationCode, StringHolder postActionTool, StringHolder postActionToolType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "getOperationPostAction", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    postActionTool.value = TcUtility.queryArgStringUnion(response.output[0], postActionTool.value);
    postActionToolType.value = TcUtility.queryArgStringUnion(response.output[1], postActionToolType.value);
  }

  public void setPostActionParameters(String obj, String tool, int operationCode, String[] parameters) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    args_[5] = TcUtility.createArg(parameters);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "setPostActionParameters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removePostActionParameters(String obj, String tool, int operationCode, String[] parameters) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    args_[5] = TcUtility.createArg(parameters);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "removePostActionParameters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getPostActionParameters(String obj, String tool, int operationCode, stringSeqValue_uHolder parameters) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operationCode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "getPostActionParameters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    parameters.value = TcUtility.queryArg(response.output[0], parameters.value);
  }

  public void setDatasetTypeName(String obj, String name) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "setDatasetTypeName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDatasetTypeDesc(String obj, String description) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArgStringUnion(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "setDatasetTypeDesc", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addTools(String dsType, String[] tool) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsType);
    args_[3] = TcUtility.createArg(tool);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "addTools", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeTools(String dsType, String[] tool) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsType);
    args_[3] = TcUtility.createArg(tool);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "removeTools", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDefaultTool(String dsType, String tool) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsType);
    args_[3] = TcUtility.createArg(tool);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "setDefaultTool", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addToolOperationRef(String dsType, String tool, int operation, String referenceName, stringSeqValue_u parameters, int exportFlag) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsType);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operation);
    args_[5] = TcUtility.createArg(referenceName);
    args_[6] = TcUtility.createArg(parameters);
    args_[7] = TcUtility.createArg(exportFlag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "addToolOperationRef", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getToolOperationRefs(String dsType, String tool, int operation, stringSeqValue_uHolder referenceNames, stringSeqValue_uHolder parameters, longSeqValue_uHolder exportFlags) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsType);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operation);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "getToolOperationRefs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    referenceNames.value = TcUtility.queryArg(response.output[0], referenceNames.value);
    parameters.value = TcUtility.queryArg(response.output[1], parameters.value);
    exportFlags.value = TcUtility.queryArg(response.output[2], exportFlags.value);
  }

  public void removeToolOperationRef(String dsType, String tool, int operation, String referenceName) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsType);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operation);
    args_[5] = TcUtility.createArg(referenceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "removeToolOperationRef", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeToolOperationParam(String dsType, String tool, int operation, String parameter) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsType);
    args_[3] = TcUtility.createArg(tool);
    args_[4] = TcUtility.createArg(operation);
    args_[5] = TcUtility.createArg(parameter);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "removeToolOperationParam", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getToolsForNamedRef(String dsType, String referenceName, int operation, uidSeqValue_uHolder toolTypes, uidSeqValue_uHolder toolTypeTypes) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dsType);
    args_[3] = TcUtility.createArg(referenceName);
    args_[4] = TcUtility.createArg(operation);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDatasetDefinition", "getToolsForNamedRef", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    toolTypes.value = TcUtility.queryArg(response.output[0], toolTypes.value);
    toolTypeTypes.value = TcUtility.queryArg(response.output[1], toolTypeTypes.value);
  }

}
