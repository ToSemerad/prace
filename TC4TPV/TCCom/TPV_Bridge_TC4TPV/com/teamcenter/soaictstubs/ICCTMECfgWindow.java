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

public class ICCTMECfgWindow extends ICCT {
  public ICCTMECfgWindow(Connection connection) {
    super(connection);
  }

  public ICCTMECfgWindow(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createTopLine(String win_uid, String obj, StringHolder top_line, StringHolder top_line_type) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(win_uid);
    args_[3] = TcUtility.createArgStringUnion(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgWindow", "createTopLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    top_line.value = TcUtility.queryArg(response.output[0], top_line.value);
    top_line_type.value = TcUtility.queryArg(response.output[1], top_line_type.value);
  }

  public void packAll(String win_uid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(win_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgWindow", "packAll", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unpackAll(String win_uid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(win_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgWindow", "unpackAll", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void loadObjectToWindow(String win_uid, String key, StringHolder line, StringHolder line_type) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(win_uid);
    args_[3] = TcUtility.createArgStringUnion(key);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgWindow", "loadObjectToWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    line.value = TcUtility.queryArg(response.output[0], line.value);
    line_type.value = TcUtility.queryArg(response.output[1], line_type.value);
  }

  public void loadAllObjectsToWindow(String win_uid, String key, uidSeq_tHolder lines, uidSeq_tHolder lineTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(win_uid);
    args_[3] = TcUtility.createArgStringUnion(key);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgWindow", "loadAllObjectsToWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lines.value = TcUtility.queryArg(response.output[0], lines.value);
    lineTypes.value = TcUtility.queryArg(response.output[1], lineTypes.value);
  }

  public void setEffectivity(String win_uid, String date, int unit_no, String end_item) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(win_uid);
    args_[3] = TcUtility.createArgStringUnion(date);
    args_[4] = TcUtility.createArg(unit_no);
    args_[5] = TcUtility.createArgStringUnion(end_item);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgWindow", "setEffectivity", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void showUnconfiguredChanges(String win_uid, boolean showUnconfigured) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(win_uid);
    args_[3] = TcUtility.createArg(showUnconfigured);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgWindow", "showUnconfiguredChanges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void closeWindow(String win_uid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(win_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgWindow", "closeWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getBulletinBoardEvents(longSeq_tHolder eventTypes, uidSeq_tHolder lines, uidSeq_tHolder parents) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgWindow", "getBulletinBoardEvents", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    eventTypes.value = TcUtility.queryArg(response.output[0], eventTypes.value);
    lines.value = TcUtility.queryArg(response.output[1], lines.value);
    parents.value = TcUtility.queryArg(response.output[2], parents.value);
  }

}
