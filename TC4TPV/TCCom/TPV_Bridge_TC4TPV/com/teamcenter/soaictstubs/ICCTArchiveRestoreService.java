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

public class ICCTArchiveRestoreService {
  ICTService m_service;

  Connection m_connection;


  public ICCTArchiveRestoreService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getPendingRequests(int operationCode, uidSeqValue_uHolder requestUids, uidSeqValue_uHolder requestTypeUids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(operationCode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "getPendingRequests", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    requestUids.value = TcUtility.queryArg(response.output[0], requestUids.value);
    requestTypeUids.value = TcUtility.queryArg(response.output[1], requestTypeUids.value);
  }

  public void modifyPendingArchiveRequest(String archiveRequest, String[] objectUids, String comments) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(archiveRequest);
    args_[1] = TcUtility.createArg(objectUids);
    args_[2] = TcUtility.createArg(comments);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "modifyPendingArchiveRequest", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void modifyPendingRestoreRequest(String restoreRequest, String[] objectUids) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(restoreRequest);
    args_[1] = TcUtility.createArg(objectUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "modifyPendingRestoreRequest", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deletePendingRequest(String pendingRequest) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(pendingRequest);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "deletePendingRequest", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void archive(String mediaName, String logicalDeviceName, String archiveFileName, String comments, String[] archivedObjects) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(mediaName);
    args_[1] = TcUtility.createArg(logicalDeviceName);
    args_[2] = TcUtility.createArg(archiveFileName);
    args_[3] = TcUtility.createArg(comments);
    args_[4] = TcUtility.createArg(archivedObjects);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "archive", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void restore(String restoreFileName, String[] restoredObjects) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(restoreFileName);
    args_[1] = TcUtility.createArg(restoredObjects);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "restore", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listMediaTOC(stringValueSeq_tHolder mediaTOCList, stringValueSeq_tHolder mediaTypes) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "listMediaTOC", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mediaTOCList.value = TcUtility.queryArgStringUnion(response.output[0], mediaTOCList.value);
    mediaTypes.value = TcUtility.queryArgStringUnion(response.output[1], mediaTypes.value);
  }

  public void getArchiveFileInfo(String archiveFileName, StringHolder mediaType, StringHolder label, StringHolder logicalDeviceName, StringHolder mediaName, StringHolder comments, StringHolder creationDate, uidSeq_tHolder objectUids, uidSeq_tHolder objectTypeUids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(archiveFileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "getArchiveFileInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mediaType.value = TcUtility.queryArgStringUnion(response.output[0], mediaType.value);
    label.value = TcUtility.queryArgStringUnion(response.output[1], label.value);
    logicalDeviceName.value = TcUtility.queryArgStringUnion(response.output[2], logicalDeviceName.value);
    mediaName.value = TcUtility.queryArgStringUnion(response.output[3], mediaName.value);
    comments.value = TcUtility.queryArgStringUnion(response.output[4], comments.value);
    creationDate.value = TcUtility.queryArgStringUnion(response.output[5], creationDate.value);
    objectUids.value = TcUtility.queryArg(response.output[6], objectUids.value);
    objectTypeUids.value = TcUtility.queryArg(response.output[7], objectTypeUids.value);
  }

  public void askFileNames(String mediaTOC, stringValueSeq_tHolder fileNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(mediaTOC);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "askFileNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileNames.value = TcUtility.queryArgStringUnion(response.output[0], fileNames.value);
  }

  public void getRemoteTcfsMessage(IntHolder mode, StringHolder message) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "getRemoteTcfsMessage", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mode.value = TcUtility.queryArg(response.output[0], mode.value);
    message.value = TcUtility.queryArgStringUnion(response.output[1], message.value);
  }

  public void recover(String objectUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "recover", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void rulesBasedArchiveQry(String queryUid, String[] entryNames, String[] entryValues, int[] filters, uidSeqValue_uHolder componentUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(queryUid);
    args_[1] = TcUtility.createArg(entryNames);
    args_[2] = TcUtility.createArgStringUnion(entryValues);
    args_[3] = TcUtility.createArg(filters);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "rulesBasedArchiveQry", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUids.value = TcUtility.queryArg(response.output[0], componentUids.value);
  }

  public void rulesBasedRestoreQry(String queryUid, String[] entryNames, String[] entryValues, int[] filters, uidSeqValue_uHolder componentUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(queryUid);
    args_[1] = TcUtility.createArg(entryNames);
    args_[2] = TcUtility.createArgStringUnion(entryValues);
    args_[3] = TcUtility.createArg(filters);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "rulesBasedRestoreQry", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUids.value = TcUtility.queryArg(response.output[0], componentUids.value);
  }

  public void rulesBasedMarkForRestore(String[] objectUids, uidSeqValue_uHolder componentUids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "rulesBasedMarkForRestore", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUids.value = TcUtility.queryArg(response.output[0], componentUids.value);
  }

  public void rulesBasedMarkForArchive(String[] objectUids, String comments, uidSeqValue_uHolder componentUids) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(objectUids);
    args_[1] = TcUtility.createArg(comments);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchiveRestoreService", "rulesBasedMarkForArchive", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUids.value = TcUtility.queryArg(response.output[0], componentUids.value);
  }

}
