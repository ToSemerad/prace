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

public class ICCTNoteType extends ICCT {
  public ICCTNoteType(Connection connection) {
    super(connection);
  }

  public ICCTNoteType(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String noteName, String noteDescription, StringHolder noteTypeUid, StringHolder noteTypeTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteName);
    args_[3] = TcUtility.createArg(noteDescription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNoteType", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noteTypeUid.value = TcUtility.queryArg(response.output[0], noteTypeUid.value);
    noteTypeTypeUid.value = TcUtility.queryArg(response.output[1], noteTypeTypeUid.value);
  }

  public void remove(String noteTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteTypeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNoteType", "remove", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setName(String noteTypeUid, String name) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteTypeUid);
    args_[3] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNoteType", "setName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDesc(String noteTypeUid, String description) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteTypeUid);
    args_[3] = TcUtility.createArg(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNoteType", "setDesc", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setInfo(String noteTypeUid, String name, String desc) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteTypeUid);
    args_[3] = TcUtility.createArg(name);
    args_[4] = TcUtility.createArg(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNoteType", "setInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void find(String noteTypeName, StringHolder noteTypeUid, StringHolder noteTypeTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteTypeName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNoteType", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noteTypeUid.value = TcUtility.queryArg(response.output[0], noteTypeUid.value);
    noteTypeTypeUid.value = TcUtility.queryArg(response.output[1], noteTypeTypeUid.value);
  }

}
