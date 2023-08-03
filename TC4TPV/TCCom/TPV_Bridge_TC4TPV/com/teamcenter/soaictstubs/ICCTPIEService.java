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

public class ICCTPIEService {
  ICTService m_service;

  Connection m_connection;


  public ICCTPIEService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getClosureRuleByName(String name, pieRulesInfo_sHolder closureRule) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getClosureRuleByName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    closureRule.value = TcUtility.queryArg(response.output[0], closureRule.value);
  }

  public void getClosureRuleByScope(int scope, pieRulesInfoSeq_tHolder closureRules) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(scope);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getClosureRuleByScope", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    closureRules.value = TcUtility.queryArg(response.output[0], closureRules.value);
  }

  public void addClosureRule(String name, String desc, int scope, stringSeqValue_u clauses, StringHolder closureRule) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(name);
    args_[1] = TcUtility.createArgStringUnion(desc);
    args_[2] = TcUtility.createArg(scope);
    args_[3] = TcUtility.createArg(clauses);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "addClosureRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    closureRule.value = TcUtility.queryArg(response.output[0], closureRule.value);
  }

  public void modifyClosureRule(String closureRule, String desc, int scope, stringSeqValue_u clauses) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(closureRule);
    args_[1] = TcUtility.createArgStringUnion(desc);
    args_[2] = TcUtility.createArg(scope);
    args_[3] = TcUtility.createArg(clauses);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "modifyClosureRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeClosureRule(String closureRule) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(closureRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "removeClosureRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getFilterRuleByName(String name, pieRulesInfo_sHolder filterRule) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getFilterRuleByName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    filterRule.value = TcUtility.queryArg(response.output[0], filterRule.value);
  }

  public void getFilterRuleByScope(int scope, pieRulesInfoSeq_tHolder filterRules) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(scope);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getFilterRuleByScope", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    filterRules.value = TcUtility.queryArg(response.output[0], filterRules.value);
  }

  public void addFilterRule(String name, String desc, int scope, stringSeqValue_u clauses, StringHolder filterRule) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(name);
    args_[1] = TcUtility.createArgStringUnion(desc);
    args_[2] = TcUtility.createArg(scope);
    args_[3] = TcUtility.createArg(clauses);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "addFilterRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    filterRule.value = TcUtility.queryArg(response.output[0], filterRule.value);
  }

  public void modifyFilterRule(String filterRule, String desc, int scope, stringSeqValue_u clauses) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(filterRule);
    args_[1] = TcUtility.createArgStringUnion(desc);
    args_[2] = TcUtility.createArg(scope);
    args_[3] = TcUtility.createArg(clauses);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "modifyFilterRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeFilterRule(String filterRule) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(filterRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "removeFilterRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getFilterHandlerNames(stringValueSeq_tHolder names) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getFilterHandlerNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    names.value = TcUtility.queryArgStringUnion(response.output[0], names.value);
  }

  public void getFilterHandlerNamesBySchema(int schema, stringValueSeq_tHolder names) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(schema);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getFilterHandlerNamesBySchema", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    names.value = TcUtility.queryArgStringUnion(response.output[0], names.value);
  }

  public void getActionRuleByName(String name, pieActionInfo_sHolder actionRule) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getActionRuleByName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    actionRule.value = TcUtility.queryArg(response.output[0], actionRule.value);
  }

  public void getActionRuleByScope(int scope, pieActionInfoSeq_tHolder actionRules) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(scope);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getActionRuleByScope", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    actionRules.value = TcUtility.queryArg(response.output[0], actionRules.value);
  }

  public void addActionRule(String name, String desc, int scope, int location, String funcName, StringHolder actionRuleTag) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(name);
    args_[1] = TcUtility.createArgStringUnion(desc);
    args_[2] = TcUtility.createArg(scope);
    args_[3] = TcUtility.createArg(location);
    args_[4] = TcUtility.createArg(funcName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "addActionRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    actionRuleTag.value = TcUtility.queryArg(response.output[0], actionRuleTag.value);
  }

  public void modifyActionRule(String actionRuleTag, String desc, int scope, int location, String funcName) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(actionRuleTag);
    args_[1] = TcUtility.createArgStringUnion(desc);
    args_[2] = TcUtility.createArg(scope);
    args_[3] = TcUtility.createArg(location);
    args_[4] = TcUtility.createArg(funcName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "modifyActionRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeActionRule(String actionRuleTag) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(actionRuleTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "removeActionRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getActionHandleNames(stringValueSeq_tHolder names) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getActionHandleNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    names.value = TcUtility.queryArgStringUnion(response.output[0], names.value);
  }

  public void getActionHandleNamesBySchema(int schema, stringValueSeq_tHolder names) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(schema);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getActionHandleNamesBySchema", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    names.value = TcUtility.queryArgStringUnion(response.output[0], names.value);
  }

  public void getPropertySetByName(String name, pieRulesInfo_sHolder propertySet) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getPropertySetByName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertySet.value = TcUtility.queryArg(response.output[0], propertySet.value);
  }

  public void getPropertySetByScope(int scope, pieRulesInfoSeq_tHolder propertySets) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(scope);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getPropertySetByScope", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertySets.value = TcUtility.queryArg(response.output[0], propertySets.value);
  }

  public void addPropertySet(String name, String desc, int scope, stringSeqValue_u clauses, StringHolder propertySet) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(name);
    args_[1] = TcUtility.createArgStringUnion(desc);
    args_[2] = TcUtility.createArg(scope);
    args_[3] = TcUtility.createArg(clauses);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "addPropertySet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertySet.value = TcUtility.queryArg(response.output[0], propertySet.value);
  }

  public void modifyPropertySet(String propertySet, String desc, int scope, stringSeqValue_u clauses) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(propertySet);
    args_[1] = TcUtility.createArgStringUnion(desc);
    args_[2] = TcUtility.createArg(scope);
    args_[3] = TcUtility.createArg(clauses);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "modifyPropertySet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removePropertySet(String propertySet) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(propertySet);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "removePropertySet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTransferModeForContext(String contextStr, pieTransferModeInfo_sHolder transferMode) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(contextStr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getTransferModeForContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    transferMode.value = TcUtility.queryArg(response.output[0], transferMode.value);
  }

  public void extentTransferModes(pieTransferModeInfoSeq_tHolder transferModes) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "extentTransferModes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    transferModes.value = TcUtility.queryArg(response.output[0], transferModes.value);
  }

  public void createTransferMode(String transferModeName, String transferModeDesc, String contextString, String closureRule, String filterRule, String propertySet, int direction, boolean incremental, uidSeqValue_u configObjs, uidSeqValue_u xsltFiles, uidSeqValue_u actionLists, StringHolder transferMode) throws Exception {
    Arg[] args_ = new Arg[11];
    args_[0] = TcUtility.createArgStringUnion(transferModeName);
    args_[1] = TcUtility.createArgStringUnion(transferModeDesc);
    args_[2] = TcUtility.createArg(contextString);
    args_[3] = TcUtility.createArg(closureRule);
    args_[4] = TcUtility.createArg(filterRule);
    args_[5] = TcUtility.createArg(propertySet);
    args_[6] = TcUtility.createArg(direction);
    args_[7] = TcUtility.createArg(incremental);
    args_[8] = TcUtility.createArg(configObjs);
    args_[9] = TcUtility.createArg(xsltFiles);
    args_[10] = TcUtility.createArg(actionLists);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "createTransferMode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    transferMode.value = TcUtility.queryArg(response.output[0], transferMode.value);
  }

  public void setContextStringForTransferMode(String transferMode, String contextString) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(transferMode);
    args_[1] = TcUtility.createArg(contextString);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "setContextStringForTransferMode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setXSLTForTransferMode(String transferMode, uidSeqValue_u xsltFiles) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(transferMode);
    args_[1] = TcUtility.createArg(xsltFiles);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "setXSLTForTransferMode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setTransferModeDirection(String transferMode, int direction) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(transferMode);
    args_[1] = TcUtility.createArg(direction);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "setTransferModeDirection", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setTransferModeIncrementalInfo(String transferMode, boolean isIncremental) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(transferMode);
    args_[1] = TcUtility.createArg(isIncremental);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "setTransferModeIncrementalInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setTransferModeClosureRule(String transferMode, String closureRule) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(transferMode);
    args_[1] = TcUtility.createArg(closureRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "setTransferModeClosureRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setTransferModeFilter(String transferMode, String filter) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(transferMode);
    args_[1] = TcUtility.createArg(filter);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "setTransferModeFilter", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setTransferModePropertySet(String transferMode, String propertySet) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(transferMode);
    args_[1] = TcUtility.createArg(propertySet);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "setTransferModePropertySet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setTransferModeConfigObjs(String transferMode, uidSeqValue_u configObjs) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(transferMode);
    args_[1] = TcUtility.createArg(configObjs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "setTransferModeConfigObjs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setTransferModeActionLists(String transferMode, uidSeqValue_u actionLists) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(transferMode);
    args_[1] = TcUtility.createArg(actionLists);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "setTransferModeActionLists", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeTransferMode(String transferMode) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(transferMode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "removeTransferMode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createPIESession(String contextStr, String fileName, String logFileName, StringHolder pieSession) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArgStringUnion(contextStr);
    args_[1] = TcUtility.createArgStringUnion(fileName);
    args_[2] = TcUtility.createArgStringUnion(logFileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "createPIESession", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pieSession.value = TcUtility.queryArg(response.output[0], pieSession.value);
  }

  public void exportObjectsInSession(String session, String[] exportObjects) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(session);
    args_[1] = TcUtility.createArg(exportObjects);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "exportObjectsInSession", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void importObjectsInSession(String session, boolean dryRun, uidSeqValue_uHolder importObjects) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(session);
    args_[1] = TcUtility.createArg(dryRun);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "importObjectsInSession", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    importObjects.value = TcUtility.queryArg(response.output[0], importObjects.value);
  }

  public void exportObjects(String contextStr, String fileName, String logFileName, String[] exportObjects, StringHolder pieSession) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArgStringUnion(contextStr);
    args_[1] = TcUtility.createArgStringUnion(fileName);
    args_[2] = TcUtility.createArgStringUnion(logFileName);
    args_[3] = TcUtility.createArg(exportObjects);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "exportObjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pieSession.value = TcUtility.queryArg(response.output[0], pieSession.value);
  }

  public void exportObjectsToPLMXML(String contextStr, String[] exportObjects, String exportDirectory, String fileName, String revRule, String iorPDIServer, StringHolder plmxmlFileLocation, StringHolder logFileLocation, StringHolder extRefFilesDir, BooleanHolder waitForFileExport) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArgStringUnion(contextStr);
    args_[1] = TcUtility.createArg(exportObjects);
    args_[2] = TcUtility.createArgStringUnion(exportDirectory);
    args_[3] = TcUtility.createArgStringUnion(fileName);
    args_[4] = TcUtility.createArgStringUnion(revRule);
    args_[5] = TcUtility.createArgStringUnion(iorPDIServer);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "exportObjectsToPLMXML", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    plmxmlFileLocation.value = TcUtility.queryArg(response.output[0], plmxmlFileLocation.value);
    logFileLocation.value = TcUtility.queryArg(response.output[1], logFileLocation.value);
    extRefFilesDir.value = TcUtility.queryArgStringUnion(response.output[2], extRefFilesDir.value);
    waitForFileExport.value = TcUtility.queryArg(response.output[3], waitForFileExport.value);
  }

  public void exportObjectsToJT(String contextStr, String[] exportObjects, String[] exportObjectsEdit, String exportDirectory, String fileName, String revRule, String iorPDIServer, StringHolder plmxmlFileLocation, StringHolder logFileLocation, StringHolder extRefFilesDir, BooleanHolder waitForFileExport) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArgStringUnion(contextStr);
    args_[1] = TcUtility.createArg(exportObjects);
    args_[2] = TcUtility.createArg(exportObjectsEdit);
    args_[3] = TcUtility.createArgStringUnion(exportDirectory);
    args_[4] = TcUtility.createArgStringUnion(fileName);
    args_[5] = TcUtility.createArgStringUnion(revRule);
    args_[6] = TcUtility.createArgStringUnion(iorPDIServer);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "exportObjectsToJT", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    plmxmlFileLocation.value = TcUtility.queryArg(response.output[0], plmxmlFileLocation.value);
    logFileLocation.value = TcUtility.queryArg(response.output[1], logFileLocation.value);
    extRefFilesDir.value = TcUtility.queryArgStringUnion(response.output[2], extRefFilesDir.value);
    waitForFileExport.value = TcUtility.queryArg(response.output[3], waitForFileExport.value);
  }

  public void exportObjectsInSessionToPLMXML(String session, String[] exportObjectTags, String exportDirectory, String fileName, StringHolder plmxmlFileLocation, StringHolder logFileLocation, StringHolder extRefFilesDir) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(session);
    args_[1] = TcUtility.createArg(exportObjectTags);
    args_[2] = TcUtility.createArgStringUnion(exportDirectory);
    args_[3] = TcUtility.createArgStringUnion(fileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "exportObjectsInSessionToPLMXML", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    plmxmlFileLocation.value = TcUtility.queryArg(response.output[0], plmxmlFileLocation.value);
    logFileLocation.value = TcUtility.queryArg(response.output[1], logFileLocation.value);
    extRefFilesDir.value = TcUtility.queryArgStringUnion(response.output[2], extRefFilesDir.value);
  }

  public void importObjects(String contextStr, String fileName, String logFileName, StringHolder pieSession, uidSeqValue_uHolder importObjects) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArgStringUnion(contextStr);
    args_[1] = TcUtility.createArgStringUnion(fileName);
    args_[2] = TcUtility.createArgStringUnion(logFileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "importObjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pieSession.value = TcUtility.queryArg(response.output[0], pieSession.value);
    importObjects.value = TcUtility.queryArg(response.output[1], importObjects.value);
  }

  public void importObjectsFromPLMXML(String contextStr, String fileName, String dirName, String icRev, String iorPDIServer, BooleanHolder waitForFileImport, StringHolder logFileLocation) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArgStringUnion(contextStr);
    args_[1] = TcUtility.createArg(fileName);
    args_[2] = TcUtility.createArg(dirName);
    args_[3] = TcUtility.createArg(icRev);
    args_[4] = TcUtility.createArgStringUnion(iorPDIServer);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "importObjectsFromPLMXML", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    waitForFileImport.value = TcUtility.queryArg(response.output[0], waitForFileImport.value);
    logFileLocation.value = TcUtility.queryArg(response.output[1], logFileLocation.value);
  }

  public void importObjectsInSessionFromPLMXML(String sessionTag, String fileName, String dirName, String bulkXMLName, StringHolder logFileLocation, StringHolder bulkXmlFileLocation) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(sessionTag);
    args_[1] = TcUtility.createArg(fileName);
    args_[2] = TcUtility.createArg(dirName);
    args_[3] = TcUtility.createArg(bulkXMLName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "importObjectsInSessionFromPLMXML", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logFileLocation.value = TcUtility.queryArg(response.output[0], logFileLocation.value);
    bulkXmlFileLocation.value = TcUtility.queryArg(response.output[1], bulkXmlFileLocation.value);
  }

  public void getObjectDetailsForImport(String session, String elementName, String attrName, stringSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(session);
    args_[1] = TcUtility.createArg(elementName);
    args_[2] = TcUtility.createArg(attrName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getObjectDetailsForImport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArg(response.output[0], values.value);
  }

  public void importObjectsWithSpecifiedValues(String session, String elementName, String attrName, String[] values, uidSeqValue_uHolder importObjects) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(session);
    args_[1] = TcUtility.createArg(elementName);
    args_[2] = TcUtility.createArg(attrName);
    args_[3] = TcUtility.createArg(values);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "importObjectsWithSpecifiedValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    importObjects.value = TcUtility.queryArg(response.output[0], importObjects.value);
  }

  public void getPIESessionLogLines(String session, stringSeqValue_uHolder logLines) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(session);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getPIESessionLogLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logLines.value = TcUtility.queryArg(response.output[0], logLines.value);
  }

  public void getPIESessionErrors(String session, uidSeqValue_uHolder errorObjs, longSeqValue_uHolder errorCodes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(session);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getPIESessionErrors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errorObjs.value = TcUtility.queryArg(response.output[0], errorObjs.value);
    errorCodes.value = TcUtility.queryArg(response.output[1], errorCodes.value);
  }

  public void addPIESessionInfo(String session, stringSeqValue_u titles, String[] values) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(session);
    args_[1] = TcUtility.createArg(titles);
    args_[2] = TcUtility.createArgStringUnion(values);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "addPIESessionInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askPIESessionInfo(String session, stringSeqValue_uHolder titles, stringValueSeq_tHolder values) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(session);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "askPIESessionInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    titles.value = TcUtility.queryArg(response.output[0], titles.value);
    values.value = TcUtility.queryArgStringUnion(response.output[1], values.value);
  }

  public void setPIESessionICContext(String session, String icRev) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(session);
    args_[1] = TcUtility.createArg(icRev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "setPIESessionICContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getPIESessionICContext(String session, StringHolder icRev) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(session);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getPIESessionICContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    icRev.value = TcUtility.queryArg(response.output[0], icRev.value);
  }

  public void deletePIESession(String session) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(session);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "deletePIESession", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getPersistentObjects(String[] anyObjects, uidSeqValue_uHolder persistentObjects) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(anyObjects);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getPersistentObjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    persistentObjects.value = TcUtility.queryArg(response.output[0], persistentObjects.value);
  }

  public void isDone(String dirPathName, BooleanHolder waitFor) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(dirPathName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "isDone", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    waitFor.value = TcUtility.queryArg(response.output[0], waitFor.value);
  }

  public void exportProductViewStructure(String contextStr, String topLine, String pvDS, String root_context, String revRule, String iorPDIServer, int type, BooleanHolder waitForFileExport) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArgStringUnion(contextStr);
    args_[1] = TcUtility.createArgStringUnion(topLine);
    args_[2] = TcUtility.createArgStringUnion(pvDS);
    args_[3] = TcUtility.createArgStringUnion(root_context);
    args_[4] = TcUtility.createArgStringUnion(revRule);
    args_[5] = TcUtility.createArgStringUnion(iorPDIServer);
    args_[6] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "exportProductViewStructure", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    waitForFileExport.value = TcUtility.queryArg(response.output[0], waitForFileExport.value);
  }

  public void getAttributesValues(String window, IntHolder valuesCount, stringValueSeq_tHolder values) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPIEService", "getAttributesValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    valuesCount.value = TcUtility.queryArg(response.output[0], valuesCount.value);
    values.value = TcUtility.queryArgStringUnion(response.output[1], values.value);
  }

}
