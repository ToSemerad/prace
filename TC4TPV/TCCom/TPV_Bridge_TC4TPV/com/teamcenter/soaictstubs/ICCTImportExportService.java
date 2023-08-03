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

public class ICCTImportExportService {
  ICTService m_service;

  Connection m_connection;


  public ICCTImportExportService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void remoteImport(String objectUid, String reason, boolean useSessionPrefs, StringHolder progRecUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(objectUid);
    args_[1] = TcUtility.createArgStringUnion(reason);
    args_[2] = TcUtility.createArg(useSessionPrefs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "remoteImport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    progRecUid.value = TcUtility.queryArgStringUnion(response.output[0], progRecUid.value);
  }

  public void remoteImportBackground(String objectUid, String reason) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(objectUid);
    args_[1] = TcUtility.createArgStringUnion(reason);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "remoteImportBackground", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void remoteExport(String[] objectUids, String reason, String[] targetSites, boolean remoteCheckout, String checkoutId, boolean useSessionPrefs) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(objectUids);
    args_[1] = TcUtility.createArgStringUnion(reason);
    args_[2] = TcUtility.createArg(targetSites);
    args_[3] = TcUtility.createArg(remoteCheckout);
    args_[4] = TcUtility.createArgStringUnion(checkoutId);
    args_[5] = TcUtility.createArg(useSessionPrefs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "remoteExport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void locateObjectLocal(String objectUid, BooleanHolder isLocal, BooleanHolder isOwningSite, StringHolder actualObject, StringHolder actualObjectType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "locateObjectLocal", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isLocal.value = TcUtility.queryArg(response.output[0], isLocal.value);
    isOwningSite.value = TcUtility.queryArg(response.output[1], isOwningSite.value);
    actualObject.value = TcUtility.queryArg(response.output[2], actualObject.value);
    actualObjectType.value = TcUtility.queryArg(response.output[3], actualObjectType.value);
  }

  public void tcExport(String[] objectUids, String directoryName, String reason, String[] targetSites, stringSeqValue_uHolder fileLocations, stringSeqValue_uHolder fileTypes, boolean useSessionPrefs) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(objectUids);
    args_[1] = TcUtility.createArgStringUnion(directoryName);
    args_[2] = TcUtility.createArgStringUnion(reason);
    args_[3] = TcUtility.createArg(targetSites);
    args_[4] = TcUtility.createArg(useSessionPrefs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "tcExport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileLocations.value = TcUtility.queryArg(response.output[0], fileLocations.value);
    fileTypes.value = TcUtility.queryArg(response.output[1], fileTypes.value);
  }

  public void tcImport(String directoryName, String[] selectedObjects, uidSeqValue_u excludedObjects) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArgStringUnion(directoryName);
    args_[1] = TcUtility.createArg(selectedObjects);
    args_[2] = TcUtility.createArg(excludedObjects);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "tcImport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listContents(String directoryName, uidSeqValue_uHolder objectUids, uidSeqValue_uHolder objectTypeUids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(directoryName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "listContents", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectUids.value = TcUtility.queryArg(response.output[0], objectUids.value);
    objectTypeUids.value = TcUtility.queryArg(response.output[1], objectTypeUids.value);
  }

  public void getNewFile(String directoryName, String fileName, StringHolder aFileLocation) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(directoryName);
    args_[1] = TcUtility.createArg(fileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "getNewFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    aFileLocation.value = TcUtility.queryArg(response.output[0], aFileLocation.value);
  }

  public void stepExport(String[] objectUids, String exportDirectory, String fileName, int dataFormat, int exportSettings, String comments, boolean viewLogFile, StringHolder logFileLocation) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(objectUids);
    args_[1] = TcUtility.createArgStringUnion(exportDirectory);
    args_[2] = TcUtility.createArgStringUnion(fileName);
    args_[3] = TcUtility.createArg(dataFormat);
    args_[4] = TcUtility.createArg(exportSettings);
    args_[5] = TcUtility.createArgStringUnion(comments);
    args_[6] = TcUtility.createArg(viewLogFile);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "stepExport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logFileLocation.value = TcUtility.queryArg(response.output[0], logFileLocation.value);
  }

  public void stepImport(String stepFileName, String importDirectory, int importSettings, boolean viewLogFile, StringHolder logFileLocation) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArgStringUnion(stepFileName);
    args_[1] = TcUtility.createArg(importDirectory);
    args_[2] = TcUtility.createArg(importSettings);
    args_[3] = TcUtility.createArg(viewLogFile);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "stepImport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logFileLocation.value = TcUtility.queryArg(response.output[0], logFileLocation.value);
  }

  public void stepRemoveTempDir(String dirPathName) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(dirPathName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "stepRemoveTempDir", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void stepMakeTempDir(StringHolder dirPathName) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "stepMakeTempDir", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    dirPathName.value = TcUtility.queryArg(response.output[0], dirPathName.value);
  }

  public void stepGetFiles(String dirPathName, stringSeqValue_uHolder fileLocations, stringSeqValue_uHolder fileTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(dirPathName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "stepGetFiles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileLocations.value = TcUtility.queryArg(response.output[0], fileLocations.value);
    fileTypes.value = TcUtility.queryArg(response.output[1], fileTypes.value);
  }

  public void stepGetNewFile(String filePathName, String tempDir, StringHolder aFileLocation) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(filePathName);
    args_[1] = TcUtility.createArg(tempDir);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "stepGetNewFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    aFileLocation.value = TcUtility.queryArg(response.output[0], aFileLocation.value);
  }

  public void importBusinessRules(String businessRuleFileName, String businessRuleTempDir, StringHolder backUpFileLocation) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(businessRuleFileName);
    args_[1] = TcUtility.createArg(businessRuleTempDir);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "importBusinessRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    backUpFileLocation.value = TcUtility.queryArg(response.output[0], backUpFileLocation.value);
  }

  public void exportBusinessRules(stringSeqValue_u rulesClassNames, StringHolder businessRuleFileLocation) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(rulesClassNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "exportBusinessRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    businessRuleFileLocation.value = TcUtility.queryArg(response.output[0], businessRuleFileLocation.value);
  }

  public void getProgressData(String progRecUid, IntHolder pid, IntHolder state, IntHolder counter, StringHolder userData, StringHolder compReport, StringHolder errReport) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(progRecUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "getProgressData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pid.value = TcUtility.queryArg(response.output[0], pid.value);
    state.value = TcUtility.queryArg(response.output[1], state.value);
    counter.value = TcUtility.queryArg(response.output[2], counter.value);
    userData.value = TcUtility.queryArgStringUnion(response.output[3], userData.value);
    compReport.value = TcUtility.queryArgStringUnion(response.output[4], compReport.value);
    errReport.value = TcUtility.queryArgStringUnion(response.output[5], errReport.value);
  }

  public void deleteProgressData(String progRecUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(progRecUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "deleteProgressData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askComponentSyncInfo(String[] cmps, String revRule, int revRuleOption, boolean useSessionPrefs, uidSeqValue_uHolder objectUids, uidSeqValue_uHolder objectTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(cmps);
    args_[1] = TcUtility.createArgStringUnion(revRule);
    args_[2] = TcUtility.createArg(revRuleOption);
    args_[3] = TcUtility.createArg(useSessionPrefs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "askComponentSyncInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectUids.value = TcUtility.queryArg(response.output[0], objectUids.value);
    objectTypeUids.value = TcUtility.queryArg(response.output[1], objectTypeUids.value);
  }

  public void performComponentSync(String[] cmps, String revRule, int revRuleOption, boolean useSessionPrefs, StringHolder progRecUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(cmps);
    args_[1] = TcUtility.createArgStringUnion(revRule);
    args_[2] = TcUtility.createArg(revRuleOption);
    args_[3] = TcUtility.createArg(useSessionPrefs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "performComponentSync", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    progRecUid.value = TcUtility.queryArgStringUnion(response.output[0], progRecUid.value);
  }

  public void askAssemblySyncInfo(String[] cmps, String revRule, int revRuleOption, int assemblyLevel, boolean useSessionPrefs, uidSeqValue_uHolder objectUids, uidSeqValue_uHolder objectTypeUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(cmps);
    args_[1] = TcUtility.createArgStringUnion(revRule);
    args_[2] = TcUtility.createArg(revRuleOption);
    args_[3] = TcUtility.createArg(assemblyLevel);
    args_[4] = TcUtility.createArg(useSessionPrefs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "askAssemblySyncInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectUids.value = TcUtility.queryArg(response.output[0], objectUids.value);
    objectTypeUids.value = TcUtility.queryArg(response.output[1], objectTypeUids.value);
  }

  public void performAssemblySync(String[] cmps, String revRule, int revRuleOption, int assemblyLevel, boolean useSessionPrefs, StringHolder progRecUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(cmps);
    args_[1] = TcUtility.createArgStringUnion(revRule);
    args_[2] = TcUtility.createArg(revRuleOption);
    args_[3] = TcUtility.createArg(assemblyLevel);
    args_[4] = TcUtility.createArg(useSessionPrefs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "performAssemblySync", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    progRecUid.value = TcUtility.queryArgStringUnion(response.output[0], progRecUid.value);
  }

  public void checkObjectSyncStatus(String[] cmps, longSeq_tHolder syncStatusInts) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(cmps);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "checkObjectSyncStatus", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    syncStatusInts.value = TcUtility.queryArg(response.output[0], syncStatusInts.value);
  }

  public void multipleObjRemoteImport(String[] objectUids, String reason, boolean useSessionPrefs, StringHolder progRecUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(objectUids);
    args_[1] = TcUtility.createArgStringUnion(reason);
    args_[2] = TcUtility.createArg(useSessionPrefs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTImportExportService", "multipleObjRemoteImport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    progRecUid.value = TcUtility.queryArgStringUnion(response.output[0], progRecUid.value);
  }

}
