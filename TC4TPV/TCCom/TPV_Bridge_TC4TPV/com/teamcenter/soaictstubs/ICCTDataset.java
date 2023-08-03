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

public class ICCTDataset extends ICCT {
  public ICCTDataset(Connection connection) {
    super(connection);
  }

  public ICCTDataset(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String description, String type, String tool, String id, String revId, StringHolder datasetObj, StringHolder typeObj) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(name);
    args_[3] = TcUtility.createArgStringUnion(description);
    args_[4] = TcUtility.createArg(type);
    args_[5] = TcUtility.createArgStringUnion(tool);
    args_[6] = TcUtility.createArgStringUnion(id);
    args_[7] = TcUtility.createArgStringUnion(revId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    datasetObj.value = TcUtility.queryArg(response.output[0], datasetObj.value);
    typeObj.value = TcUtility.queryArg(response.output[1], typeObj.value);
  }

  public void find(String name, StringHolder datasetObj, StringHolder typeObj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    datasetObj.value = TcUtility.queryArgStringUnion(response.output[0], datasetObj.value);
    typeObj.value = TcUtility.queryArgStringUnion(response.output[1], typeObj.value);
  }

  public void findAll(String name, uidSeqValue_uHolder componentObjs, uidSeqValue_uHolder componentTypeObjs) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "findAll", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentObjs.value = TcUtility.queryArg(response.output[0], componentObjs.value);
    componentTypeObjs.value = TcUtility.queryArg(response.output[1], componentTypeObjs.value);
  }

  public void getSecuredFiles(String datasetObj, String[] types, stringSeqValue_uHolder originalFileNames, stringSeqValue_uHolder fileLocations, uidSeqValue_uHolder fileUids, stringSeqValue_uHolder namedRefs, stringSeqValue_uHolder fileTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArg(types);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getSecuredFiles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    originalFileNames.value = TcUtility.queryArg(response.output[0], originalFileNames.value);
    fileLocations.value = TcUtility.queryArg(response.output[1], fileLocations.value);
    fileUids.value = TcUtility.queryArg(response.output[2], fileUids.value);
    namedRefs.value = TcUtility.queryArg(response.output[3], namedRefs.value);
    fileTypes.value = TcUtility.queryArg(response.output[4], fileTypes.value);
  }

  public void getSecuredFilesByTool(String toolObj, String datasetObj, int action_name, stringSeqValue_uHolder originalFileNames, stringSeqValue_uHolder fileLocations, uidSeqValue_uHolder fileUids, stringSeqValue_uHolder namedRefs, stringSeqValue_uHolder fileTypes) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(toolObj);
    args_[3] = TcUtility.createArg(datasetObj);
    args_[4] = TcUtility.createArg(action_name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getSecuredFilesByTool", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    originalFileNames.value = TcUtility.queryArg(response.output[0], originalFileNames.value);
    fileLocations.value = TcUtility.queryArg(response.output[1], fileLocations.value);
    fileUids.value = TcUtility.queryArg(response.output[2], fileUids.value);
    namedRefs.value = TcUtility.queryArg(response.output[3], namedRefs.value);
    fileTypes.value = TcUtility.queryArg(response.output[4], fileTypes.value);
  }

  public void purge(String datasetObj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "purge", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void revise(String datasetObj, StringHolder newRevObj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "revise", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRevObj.value = TcUtility.queryArg(response.output[0], newRevObj.value);
  }

  public void saveRevision(String newRevObj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newRevObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "saveRevision", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addNamedReference(String datasetObj, String tcFileObj, String reference_name) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArg(tcFileObj);
    args_[4] = TcUtility.createArg(reference_name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "addNamedReference", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeNamedReference(String datasetObj, String reference_name) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArg(reference_name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "removeNamedReference", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeFiles(String datasetObj, String[] fileNames, String[] referenceNames) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArg(fileNames);
    args_[4] = TcUtility.createArg(referenceNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "removeFiles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getNewFile(String datasetObj, String filePathName, String referenceName, StringHolder newFileLocation, StringHolder tcFileUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArg(filePathName);
    args_[4] = TcUtility.createArg(referenceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getNewFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newFileLocation.value = TcUtility.queryArg(response.output[0], newFileLocation.value);
    tcFileUid.value = TcUtility.queryArg(response.output[1], tcFileUid.value);
  }

  public void saveAs(String obj, String name, String id, String revId, StringHolder newObj) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArgStringUnion(name);
    args_[4] = TcUtility.createArgStringUnion(id);
    args_[5] = TcUtility.createArgStringUnion(revId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newObj.value = TcUtility.queryArg(response.output[0], newObj.value);
  }

  public void saveVersionAs(String obj, int sourceVersion, String name, String id, String revId, StringHolder newObj, StringHolder objType) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(sourceVersion);
    args_[4] = TcUtility.createArgStringUnion(name);
    args_[5] = TcUtility.createArgStringUnion(id);
    args_[6] = TcUtility.createArgStringUnion(revId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "saveVersionAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newObj.value = TcUtility.queryArg(response.output[0], newObj.value);
    objType.value = TcUtility.queryArg(response.output[1], objType.value);
  }

  public void latest(String datasetObj, StringHolder latestDataset) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "latest", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    latestDataset.value = TcUtility.queryArg(response.output[0], latestDataset.value);
  }

  public void getDatasetRevs(String datasetObj, uidSeqValue_uHolder datasets) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getDatasetRevs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    datasets.value = TcUtility.queryArg(response.output[0], datasets.value);
  }

  public void getPrimaryFileNames(String datasetObj, String toolObj, int operationCode, stringValueSeq_tHolder fileNamesHolder) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArgStringUnion(toolObj);
    args_[4] = TcUtility.createArg(operationCode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getPrimaryFileNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileNamesHolder.value = TcUtility.queryArgStringUnion(response.output[0], fileNamesHolder.value);
  }

  public void getFileNames(String datasetObj, String type, stringValueSeq_tHolder fileNamesHolder) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArgStringUnion(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getFileNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileNamesHolder.value = TcUtility.queryArgStringUnion(response.output[0], fileNamesHolder.value);
  }

  public void getPrimaryNamedReference(String datasetObj, String toolObj, int operationCode, StringHolder ref_name, StringHolder format, StringHolder filename, StringHolder mimeType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArgStringUnion(toolObj);
    args_[4] = TcUtility.createArg(operationCode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getPrimaryNamedReference", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ref_name.value = TcUtility.queryArgStringUnion(response.output[0], ref_name.value);
    format.value = TcUtility.queryArgStringUnion(response.output[1], format.value);
    filename.value = TcUtility.queryArgStringUnion(response.output[2], filename.value);
    mimeType.value = TcUtility.queryArgStringUnion(response.output[3], mimeType.value);
  }

  public void getNewId(String relatedObj, String datasetType, BooleanHolder idCanBeModified, StringHolder datasetId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(relatedObj);
    args_[3] = TcUtility.createArg(datasetType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getNewId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    idCanBeModified.value = TcUtility.queryArg(response.output[0], idCanBeModified.value);
    datasetId.value = TcUtility.queryArg(response.output[1], datasetId.value);
  }

  public void getNewRevisionId(String datasetId, String datasetType, BooleanHolder idCanBeModified, StringHolder revisionId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(datasetId);
    args_[3] = TcUtility.createArg(datasetType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getNewRevisionId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    idCanBeModified.value = TcUtility.queryArg(response.output[0], idCanBeModified.value);
    revisionId.value = TcUtility.queryArg(response.output[1], revisionId.value);
  }

  public void pasteNamedReference(String datasetObj, String tcFileObj, String referenceName) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArg(tcFileObj);
    args_[4] = TcUtility.createArg(referenceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "pasteNamedReference", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setExportedFiles(String datasetObj, String[] newFileLocations, String[] referenceNames, String[] fileUids) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArg(newFileLocations);
    args_[4] = TcUtility.createArg(referenceNames);
    args_[5] = TcUtility.createArg(fileUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "setExportedFiles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDefaultTool(String datasetObj, String tool) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArgStringUnion(tool);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "setDefaultTool", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getDefaultTool(String datasetObj, StringHolder toolObj, StringHolder toolTypeObj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getDefaultTool", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    toolObj.value = TcUtility.queryArgStringUnion(response.output[0], toolObj.value);
    toolTypeObj.value = TcUtility.queryArgStringUnion(response.output[1], toolTypeObj.value);
  }

  public void addObjectNamedRef(String datasetObj, String componentObj, String referenceName) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArg(componentObj);
    args_[4] = TcUtility.createArg(referenceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "addObjectNamedRef", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getObjectNamedRefs(String datasetObj, String referenceName, uidSeqValue_uHolder componentObjs, uidSeqValue_uHolder componentTypeObjs) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArg(referenceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getObjectNamedRefs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentObjs.value = TcUtility.queryArg(response.output[0], componentObjs.value);
    componentTypeObjs.value = TcUtility.queryArg(response.output[1], componentTypeObjs.value);
  }

  public void newDatasetName(String owner, String datasetType, String relationType, String basisName, StringHolder datasetName, BooleanHolder nameCanBeModified) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(owner);
    args_[3] = TcUtility.createArgStringUnion(datasetType);
    args_[4] = TcUtility.createArgStringUnion(relationType);
    args_[5] = TcUtility.createArgStringUnion(basisName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "newDatasetName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    datasetName.value = TcUtility.queryArgStringUnion(response.output[0], datasetName.value);
    nameCanBeModified.value = TcUtility.queryArg(response.output[1], nameCanBeModified.value);
  }

  public void getHighestRevision(String datasetObj, IntHolder highestRevision) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "getHighestRevision", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    highestRevision.value = TcUtility.queryArg(response.output[0], highestRevision.value);
  }

  public void checkinExportedFiles(String datasetObj, String[] newFileUids, String[] referenceNames, String[] fileNames, boolean backgroundCheckIn) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArg(newFileUids);
    args_[4] = TcUtility.createArg(referenceNames);
    args_[5] = TcUtility.createArg(fileNames);
    args_[6] = TcUtility.createArg(backgroundCheckIn);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "checkinExportedFiles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setInIcContext(String dataset) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataset);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "setInIcContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void resetInIcContext(String dataset) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataset);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDataset", "resetInIcContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
