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

public class ICCTAuditDefinition extends ICCT {
  public ICCTAuditDefinition(Connection connection) {
    super(connection);
  }

  public ICCTAuditDefinition(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String objectType, String evType, String[] properties, int maxDaysKept, String archiveMedia, String additionLogCreateHandler, StringHolder auditDefUid, StringHolder auditDefTypeUid) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(objectType);
    args_[3] = TcUtility.createArgStringUnion(evType);
    args_[4] = TcUtility.createArg(properties);
    args_[5] = TcUtility.createArg(maxDaysKept);
    args_[6] = TcUtility.createArgStringUnion(archiveMedia);
    args_[7] = TcUtility.createArgStringUnion(additionLogCreateHandler);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    auditDefUid.value = TcUtility.queryArg(response.output[0], auditDefUid.value);
    auditDefTypeUid.value = TcUtility.queryArg(response.output[1], auditDefTypeUid.value);
  }

  public void find(String objectType, String evType, uidSeqValue_uHolder auditDefObjs, uidSeqValue_uHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(objectType);
    args_[3] = TcUtility.createArgStringUnion(evType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    auditDefObjs.value = TcUtility.queryArg(response.output[0], auditDefObjs.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[1], componentTypeUids.value);
  }

  public void getStorageType(String auditDefUid, IntHolder storageType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "getStorageType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    storageType.value = TcUtility.queryArg(response.output[0], storageType.value);
  }

  public void setStorageType(String auditDefUid, int storageType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    args_[3] = TcUtility.createArg(storageType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "setStorageType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAuditableTypes(uidSeqValue_uHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "getAuditableTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentTypeUids.value = TcUtility.queryArg(response.output[0], componentTypeUids.value);
  }

  public void getAuditableTypeNames(stringSeqValue_uHolder componentTypeNames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "getAuditableTypeNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentTypeNames.value = TcUtility.queryArg(response.output[0], componentTypeNames.value);
  }

  public void getDefinedObjectType(String auditDefUid, StringHolder objectType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "getDefinedObjectType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectType.value = TcUtility.queryArg(response.output[0], objectType.value);
  }

  public void getEventType(String auditDefUid, StringHolder evType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "getEventType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    evType.value = TcUtility.queryArg(response.output[0], evType.value);
  }

  public void getAuditProperties(String auditDefUid, stringSeqValue_uHolder propNames) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "getAuditProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propNames.value = TcUtility.queryArg(response.output[0], propNames.value);
  }

  public void addAuditProperties(String auditDefUid, String[] propNames) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    args_[3] = TcUtility.createArg(propNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "addAuditProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeAuditProperties(String auditDefUid, String[] propNames) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    args_[3] = TcUtility.createArg(propNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "removeAuditProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getMaxDaysKept(String auditDefUid, IntHolder daysCount) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "getMaxDaysKept", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    daysCount.value = TcUtility.queryArg(response.output[0], daysCount.value);
  }

  public void setMaxDaysKept(String auditDefUid, int daysCount) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    args_[3] = TcUtility.createArg(daysCount);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "setMaxDaysKept", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getArchiveMedia(String auditDefUid, StringHolder archiveMedia, StringHolder archiveMediaType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "getArchiveMedia", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    archiveMedia.value = TcUtility.queryArg(response.output[0], archiveMedia.value);
    archiveMediaType.value = TcUtility.queryArg(response.output[1], archiveMediaType.value);
  }

  public void setArchiveMedia(String auditDefUid, String archiveMedia) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    args_[3] = TcUtility.createArgStringUnion(archiveMedia);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "setArchiveMedia", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getLogHandler(String auditDefUid, StringHolder logHandler, StringHolder logHandlerType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "getLogHandler", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logHandler.value = TcUtility.queryArg(response.output[0], logHandler.value);
    logHandlerType.value = TcUtility.queryArg(response.output[1], logHandlerType.value);
  }

  public void setLogHandler(String auditDefUid, String logHandler) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(auditDefUid);
    args_[3] = TcUtility.createArgStringUnion(logHandler);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditDefinition", "setLogHandler", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
