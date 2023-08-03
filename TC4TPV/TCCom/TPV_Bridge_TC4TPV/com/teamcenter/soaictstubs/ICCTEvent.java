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

public class ICCTEvent extends ICCT {
  public ICCTEvent(Connection connection) {
    super(connection);
  }

  public ICCTEvent(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String eventTypeId, String eventTypeDesc, String implBaseClass, StringHolder eventUid, StringHolder eventTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(eventTypeId);
    args_[3] = TcUtility.createArgStringUnion(eventTypeDesc);
    args_[4] = TcUtility.createArg(implBaseClass);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEvent", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    eventUid.value = TcUtility.queryArg(response.output[0], eventUid.value);
    eventTypeUid.value = TcUtility.queryArg(response.output[1], eventTypeUid.value);
  }

  public void find(String eventTypeId, StringHolder eventUid, StringHolder eventTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(eventTypeId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEvent", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    eventUid.value = TcUtility.queryArg(response.output[0], eventUid.value);
    eventTypeUid.value = TcUtility.queryArg(response.output[1], eventTypeUid.value);
  }

  public void setId(String eventUid, String id) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(eventUid);
    args_[3] = TcUtility.createArg(id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEvent", "setId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askId(String eventUid, StringHolder id) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(eventUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEvent", "askId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    id.value = TcUtility.queryArg(response.output[0], id.value);
  }

  public void setDesc(String eventUid, String desc) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(eventUid);
    args_[3] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEvent", "setDesc", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askDesc(String eventUid, StringHolder desc) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(eventUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEvent", "askDesc", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    desc.value = TcUtility.queryArgStringUnion(response.output[0], desc.value);
  }

}
