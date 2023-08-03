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

public class ICCTAIEPersistentConnService {
  ICTService m_service;

  Connection m_connection;


  public ICCTAIEPersistentConnService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void initializeExport(String connectionID, int exportRule) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArg(exportRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "initializeExport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void performExport(String connectionID, String changeID, String comments, boolean createArchive, IntHolder logFilePosition) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArgStringUnion(changeID);
    args_[2] = TcUtility.createArgStringUnion(comments);
    args_[3] = TcUtility.createArg(createArchive);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "performExport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logFilePosition.value = TcUtility.queryArg(response.output[0], logFilePosition.value);
  }

  public void performBatchExport(String connectionID, String changeID, String comments, boolean notifyByEmail, String startDate, String startTime, String serverName, String userName, String password, boolean createArchive, IntHolder logFilePosition) throws Exception {
    Arg[] args_ = new Arg[10];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArgStringUnion(changeID);
    args_[2] = TcUtility.createArgStringUnion(comments);
    args_[3] = TcUtility.createArg(notifyByEmail);
    args_[4] = TcUtility.createArgStringUnion(startDate);
    args_[5] = TcUtility.createArgStringUnion(startTime);
    args_[6] = TcUtility.createArgStringUnion(serverName);
    args_[7] = TcUtility.createArgStringUnion(userName);
    args_[8] = TcUtility.createArgStringUnion(password);
    args_[9] = TcUtility.createArg(createArchive);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "performBatchExport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logFilePosition.value = TcUtility.queryArg(response.output[0], logFilePosition.value);
  }

  public void cancelExport(String connectionID) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(connectionID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "cancelExport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void analyzeRoot(String connectionID, String itemRevUid, String datasetUid, boolean assyRootFromFolder, String[] namedRefs, String toolName, int action) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArg(itemRevUid);
    args_[2] = TcUtility.createArg(datasetUid);
    args_[3] = TcUtility.createArg(assyRootFromFolder);
    args_[4] = TcUtility.createArgStringUnion(namedRefs);
    args_[5] = TcUtility.createArgStringUnion(toolName);
    args_[6] = TcUtility.createArg(action);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "analyzeRoot", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void analyzePSERoot(String connectionID, String window, String topBOMLine, String itemRevUid, String[] datasetTypeUids, String toolName, int action) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArg(window);
    args_[2] = TcUtility.createArg(topBOMLine);
    args_[3] = TcUtility.createArg(itemRevUid);
    args_[4] = TcUtility.createArgStringUnion(datasetTypeUids);
    args_[5] = TcUtility.createArgStringUnion(toolName);
    args_[6] = TcUtility.createArg(action);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "analyzePSERoot", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setComponentInfo(String connectionID, String topBOMLine, String selBOMLine, String[] datasetTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArg(topBOMLine);
    args_[2] = TcUtility.createArg(selBOMLine);
    args_[3] = TcUtility.createArgStringUnion(datasetTypeUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "setComponentInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setExportInfo(String connectionID, String topBOMLine, String selBOMLine, boolean exportComp, boolean exportChild, boolean checkoutComp, boolean checkoutChild) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArg(topBOMLine);
    args_[2] = TcUtility.createArg(selBOMLine);
    args_[3] = TcUtility.createArg(exportComp);
    args_[4] = TcUtility.createArg(exportChild);
    args_[5] = TcUtility.createArg(checkoutComp);
    args_[6] = TcUtility.createArg(checkoutChild);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "setExportInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void updateImportInfo(String connectionID, String[] fileSpecs, String[] itemIDs, String[] revIDs, String[] itemNames, String[] itemTypes, boolean[] retainCOFlags) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArg(fileSpecs);
    args_[2] = TcUtility.createArg(itemIDs);
    args_[3] = TcUtility.createArg(revIDs);
    args_[4] = TcUtility.createArg(itemNames);
    args_[5] = TcUtility.createArg(itemTypes);
    args_[6] = TcUtility.createArg(retainCOFlags);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "updateImportInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void performImport(String connectionID, String[] fileSpecs, String importFolderUid, String supplierUser, String coChangeID, String coComments, boolean[] overwriteExistingFlags, IntHolder logFilePosition, IntHolder num_files_not_imported, stringSeqValue_uHolder files_not_imported, uidSeqValue_uHolder revUids, uidSeqValue_uHolder datasetUids) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArg(fileSpecs);
    args_[2] = TcUtility.createArgStringUnion(importFolderUid);
    args_[3] = TcUtility.createArgStringUnion(supplierUser);
    args_[4] = TcUtility.createArgStringUnion(coChangeID);
    args_[5] = TcUtility.createArgStringUnion(coComments);
    args_[6] = TcUtility.createArg(overwriteExistingFlags);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "performImport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logFilePosition.value = TcUtility.queryArg(response.output[0], logFilePosition.value);
    num_files_not_imported.value = TcUtility.queryArg(response.output[1], num_files_not_imported.value);
    files_not_imported.value = TcUtility.queryArg(response.output[2], files_not_imported.value);
    revUids.value = TcUtility.queryArg(response.output[3], revUids.value);
    datasetUids.value = TcUtility.queryArg(response.output[4], datasetUids.value);
  }

  public void performBatchImport(String connectionID, String[] fileSpecs, String importFolderUid, String supplierUser, String coChangeID, String coComments, IntHolder logFilePosition, IntHolder num_files_not_imported, stringSeqValue_uHolder files_not_imported, uidSeqValue_uHolder revUids, uidSeqValue_uHolder datasetUids, boolean notifyByEmail, String startDate, String startTime, String serverName, String userName, String password, boolean processDatasets, String processName) throws Exception {
    Arg[] args_ = new Arg[14];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArg(fileSpecs);
    args_[2] = TcUtility.createArgStringUnion(importFolderUid);
    args_[3] = TcUtility.createArgStringUnion(supplierUser);
    args_[4] = TcUtility.createArgStringUnion(coChangeID);
    args_[5] = TcUtility.createArgStringUnion(coComments);
    args_[6] = TcUtility.createArg(notifyByEmail);
    args_[7] = TcUtility.createArgStringUnion(startDate);
    args_[8] = TcUtility.createArgStringUnion(startTime);
    args_[9] = TcUtility.createArgStringUnion(serverName);
    args_[10] = TcUtility.createArgStringUnion(userName);
    args_[11] = TcUtility.createArgStringUnion(password);
    args_[12] = TcUtility.createArg(processDatasets);
    args_[13] = TcUtility.createArgStringUnion(processName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "performBatchImport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logFilePosition.value = TcUtility.queryArg(response.output[0], logFilePosition.value);
    num_files_not_imported.value = TcUtility.queryArg(response.output[1], num_files_not_imported.value);
    files_not_imported.value = TcUtility.queryArg(response.output[2], files_not_imported.value);
    revUids.value = TcUtility.queryArg(response.output[3], revUids.value);
    datasetUids.value = TcUtility.queryArg(response.output[4], datasetUids.value);
  }

  public void getPreImportInfo(String connectionID, boolean retainCheckoutDefault, String supplierUser, stringSeqValue_uHolder filenames, stringSeqValue_uHolder dsTypes, stringSeqValue_uHolder errors, stringSeqValue_uHolder tcItemIDs, stringSeqValue_uHolder tcItemNames, stringSeqValue_uHolder tcRevIDs, stringSeqValue_uHolder tcItemTypes, stringSeqValue_uHolder importItemIDs, stringSeqValue_uHolder importItemNames, stringSeqValue_uHolder importRevIDs, stringSeqValue_uHolder importItemTypes, booleanSeqValue_uHolder isImplicitCheckoutOK, booleanSeqValue_uHolder isNewFile, stringSeqValue_uHolder rootFilenames) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArg(retainCheckoutDefault);
    args_[2] = TcUtility.createArgStringUnion(supplierUser);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "getPreImportInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    filenames.value = TcUtility.queryArg(response.output[0], filenames.value);
    dsTypes.value = TcUtility.queryArg(response.output[1], dsTypes.value);
    errors.value = TcUtility.queryArg(response.output[2], errors.value);
    tcItemIDs.value = TcUtility.queryArg(response.output[3], tcItemIDs.value);
    tcItemNames.value = TcUtility.queryArg(response.output[4], tcItemNames.value);
    tcRevIDs.value = TcUtility.queryArg(response.output[5], tcRevIDs.value);
    tcItemTypes.value = TcUtility.queryArg(response.output[6], tcItemTypes.value);
    importItemIDs.value = TcUtility.queryArg(response.output[7], importItemIDs.value);
    importItemNames.value = TcUtility.queryArg(response.output[8], importItemNames.value);
    importRevIDs.value = TcUtility.queryArg(response.output[9], importRevIDs.value);
    importItemTypes.value = TcUtility.queryArg(response.output[10], importItemTypes.value);
    isImplicitCheckoutOK.value = TcUtility.queryArg(response.output[11], isImplicitCheckoutOK.value);
    isNewFile.value = TcUtility.queryArg(response.output[12], isNewFile.value);
    rootFilenames.value = TcUtility.queryArg(response.output[13], rootFilenames.value);
  }

  public void updateConnData(String connectionID, int exportRule, IntHolder logFilePosition) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArg(exportRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "updateConnData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logFilePosition.value = TcUtility.queryArg(response.output[0], logFilePosition.value);
  }

  public void startRMOperation(String connectionID) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(connectionID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "startRMOperation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void finishRMOperation(String connectionID) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(connectionID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "finishRMOperation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void checkDatasetLicenses(String connectionID, String[] datasets, stringSeqValue_uHolder errors) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArgStringUnion(datasets);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "checkDatasetLicenses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errors.value = TcUtility.queryArg(response.output[0], errors.value);
  }

  public void cancelAllUnmodifiedCheckouts(String connectionID) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(connectionID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "cancelAllUnmodifiedCheckouts", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getChildren(String connectionID, String parentFile, IntHolder numberOfChildren, longSeqValue_uHolder actionArray, stringSeqValue_uHolder childFilespecArray) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(connectionID);
    args_[1] = TcUtility.createArgStringUnion(parentFile);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "getChildren", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    numberOfChildren.value = TcUtility.queryArg(response.output[0], numberOfChildren.value);
    actionArray.value = TcUtility.queryArg(response.output[1], actionArray.value);
    childFilespecArray.value = TcUtility.queryArg(response.output[2], childFilespecArray.value);
  }

  public void endImportOperation(String connectionID) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(connectionID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "endImportOperation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAllSupplierUsers(stringSeqValue_uHolder suppliers) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnService", "getAllSupplierUsers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    suppliers.value = TcUtility.queryArg(response.output[0], suppliers.value);
  }

}
