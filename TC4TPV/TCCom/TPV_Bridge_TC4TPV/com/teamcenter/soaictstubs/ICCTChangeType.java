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

public class ICCTChangeType extends ICCT {
  public ICCTChangeType(Connection connection) {
    super(connection);
  }

  public ICCTChangeType(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String idFormat, String revFormat, StringHolder typeUid, StringHolder typeTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArg(idFormat);
    args_[4] = TcUtility.createArg(revFormat);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTChangeType", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeUid.value = TcUtility.queryArg(response.output[0], typeUid.value);
    typeTypeUid.value = TcUtility.queryArg(response.output[1], typeTypeUid.value);
  }

  public void addFormType(String typeUid, String formTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeUid);
    args_[3] = TcUtility.createArg(formTypeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTChangeType", "addFormType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addProcess(String typeUid, String process) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeUid);
    args_[3] = TcUtility.createArg(process);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTChangeType", "addProcess", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setFormTypes(String typeUid, String[] formTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeUid);
    args_[3] = TcUtility.createArg(formTypeUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTChangeType", "setFormTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setProcesses(String typeUid, String[] processes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeUid);
    args_[3] = TcUtility.createArg(processes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTChangeType", "setProcesses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeFormTypes(String typeUid, String[] formTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeUid);
    args_[3] = TcUtility.createArg(formTypeUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTChangeType", "removeFormTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeProcesses(String typeUid, String[] processes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeUid);
    args_[3] = TcUtility.createArg(processes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTChangeType", "removeProcesses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setName(String typeUid, String newName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeUid);
    args_[3] = TcUtility.createArg(newName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTChangeType", "setName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setIdFormat(String typeUid, String newFormat) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeUid);
    args_[3] = TcUtility.createArg(newFormat);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTChangeType", "setIdFormat", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setRevFormat(String typeUid, String newFormat) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeUid);
    args_[3] = TcUtility.createArg(newFormat);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTChangeType", "setRevFormat", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
