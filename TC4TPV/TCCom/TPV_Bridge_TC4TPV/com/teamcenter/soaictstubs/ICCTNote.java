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

public class ICCTNote extends ICCT {
  public ICCTNote(Connection connection) {
    super(connection);
  }

  public ICCTNote(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createType(String noteName, String noteDescription, StringHolder noteTypeUid, StringHolder noteTypeTypeTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteName);
    args_[3] = TcUtility.createArg(noteDescription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNote", "createType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noteTypeUid.value = TcUtility.queryArg(response.output[0], noteTypeUid.value);
    noteTypeTypeTypeUid.value = TcUtility.queryArg(response.output[1], noteTypeTypeTypeUid.value);
  }

  public void removeType(String noteTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteTypeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNote", "removeType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setNoteTypeName(String noteTypeUid, String name) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteTypeUid);
    args_[3] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNote", "setNoteTypeName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setNoteTypeDesc(String noteTypeUid, String description) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteTypeUid);
    args_[3] = TcUtility.createArg(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNote", "setNoteTypeDesc", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setNoteTypeInfo(String noteTypeUid, String name, String desc) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteTypeUid);
    args_[3] = TcUtility.createArg(name);
    args_[4] = TcUtility.createArg(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNote", "setNoteTypeInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
