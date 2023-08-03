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

public class ICCTMECfgLine extends ICCT {
  public ICCTMECfgLine(Connection connection) {
    super(connection);
  }

  public ICCTMECfgLine(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void add(String parent, String obj, String rel_type, StringHolder line, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(parent);
    args_[3] = TcUtility.createArgStringUnion(obj);
    args_[4] = TcUtility.createArgStringUnion(rel_type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgLine", "add", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    line.value = TcUtility.queryArg(response.output[0], line.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void remove(String parent, String child) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(parent);
    args_[3] = TcUtility.createArg(child);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgLine", "remove", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void reparent(String child, String new_parent) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(child);
    args_[3] = TcUtility.createArg(new_parent);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgLine", "reparent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void refreshChildren(String child) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(child);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgLine", "refreshChildren", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void bomCompareSetStopLines(String rootLine, String[] lines) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rootLine);
    args_[3] = TcUtility.createArg(lines);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgLine", "bomCompareSetStopLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeMECfgLineIncrementalChanges(String lineUid, String[] iceUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    args_[3] = TcUtility.createArg(iceUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMECfgLine", "removeMECfgLineIncrementalChanges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
