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

public class ICCTTcFile extends ICCT {
  public ICCTTcFile(Connection connection) {
    super(connection);
  }

  public ICCTTcFile(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void getSecuredFile(String tcFile, StringHolder originalFileName, StringHolder filetype, StringHolder fileLocation) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcFile);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcFile", "getSecuredFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    originalFileName.value = TcUtility.queryArg(response.output[0], originalFileName.value);
    filetype.value = TcUtility.queryArg(response.output[1], filetype.value);
    fileLocation.value = TcUtility.queryArg(response.output[2], fileLocation.value);
  }

  public void setOriginalFileName(String tcFile, String dataset, String newFileName) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcFile);
    args_[3] = TcUtility.createArg(dataset);
    args_[4] = TcUtility.createArgStringUnion(newFileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcFile", "setOriginalFileName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getPath(String tcFile, StringHolder pathName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcFile);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcFile", "getPath", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pathName.value = TcUtility.queryArg(response.output[0], pathName.value);
  }

  public void getOSLastModifiedDate(String tcFileUid, StringHolder osLastModifiedDate) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcFileUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcFile", "getOSLastModifiedDate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    osLastModifiedDate.value = TcUtility.queryArg(response.output[0], osLastModifiedDate.value);
  }

  public void getReadFileTickets(String application, String[] imanFiles, longSeq_tHolder ifails, stringSeqValue_uHolder errorStrings, stringSeqValue_uHolder ticketInfos) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(application);
    args_[3] = TcUtility.createArg(imanFiles);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcFile", "getReadFileTickets", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ifails.value = TcUtility.queryArg(response.output[0], ifails.value);
    errorStrings.value = TcUtility.queryArg(response.output[1], errorStrings.value);
    ticketInfos.value = TcUtility.queryArg(response.output[2], ticketInfos.value);
  }

  public void getWriteFileTickets(String datasettypeName, int version, writeTicketInfo_s[] infos, longSeq_tHolder ifails, stringSeqValue_uHolder errorStrings, stringSeqValue_uHolder ticketInfos) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasettypeName);
    args_[3] = TcUtility.createArg(version);
    args_[4] = TcUtility.createArg(infos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcFile", "getWriteFileTickets", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ifails.value = TcUtility.queryArg(response.output[0], ifails.value);
    errorStrings.value = TcUtility.queryArg(response.output[1], errorStrings.value);
    ticketInfos.value = TcUtility.queryArg(response.output[2], ticketInfos.value);
  }

  public void commitDatasetFiles(String datasetObj, boolean new_version, commitDatasetFileInfo_s[] infos, longSeq_tHolder ifails, stringSeqValue_uHolder errorStrings) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasetObj);
    args_[3] = TcUtility.createArg(new_version);
    args_[4] = TcUtility.createArg(infos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcFile", "commitDatasetFiles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ifails.value = TcUtility.queryArg(response.output[0], ifails.value);
    errorStrings.value = TcUtility.queryArg(response.output[1], errorStrings.value);
  }

  public void getTransientFileTickets(String application, transientTicketInfo_s[] infos, longSeq_tHolder ifails, stringSeqValue_uHolder errorStrings, stringSeqValue_uHolder ticketInfos) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(application);
    args_[3] = TcUtility.createArg(infos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcFile", "getTransientFileTickets", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ifails.value = TcUtility.queryArg(response.output[0], ifails.value);
    errorStrings.value = TcUtility.queryArg(response.output[1], errorStrings.value);
    ticketInfos.value = TcUtility.queryArg(response.output[2], ticketInfos.value);
  }

  public void commitFiles(commitFileInfo_s[] infos, longSeq_tHolder ifails, stringSeqValue_uHolder errorStrings) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(infos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcFile", "commitFiles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ifails.value = TcUtility.queryArg(response.output[0], ifails.value);
    errorStrings.value = TcUtility.queryArg(response.output[1], errorStrings.value);
  }

  public void getFileUidFromWriteTicket(String writeTicket, StringHolder tcFileUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(writeTicket);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcFile", "getFileUidFromWriteTicket", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    tcFileUid.value = TcUtility.queryArg(response.output[0], tcFileUid.value);
  }

  public void getVolumeTagAsString(String volumeTag, StringHolder volumeTagString) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(volumeTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcFile", "getVolumeTagAsString", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    volumeTagString.value = TcUtility.queryArg(response.output[0], volumeTagString.value);
  }

}
