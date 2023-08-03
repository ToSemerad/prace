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

public class ICCTCfgAttachmentLine extends ICCTMECfgLine {
  public ICCTCfgAttachmentLine(Connection connection) {
    super(connection);
  }

  public ICCTCfgAttachmentLine(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void deleteChild(String parent, String child) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(parent);
    args_[3] = TcUtility.createArg(child);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCfgAttachmentLine", "deleteChild", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void change(String line, StringHolder newWso, StringHolder newWsoType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(line);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCfgAttachmentLine", "change", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newWso.value = TcUtility.queryArg(response.output[0], newWso.value);
    newWsoType.value = TcUtility.queryArg(response.output[1], newWsoType.value);
  }

  public void recordChange(String line, String newWso) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(line);
    args_[3] = TcUtility.createArg(newWso);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCfgAttachmentLine", "recordChange", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void previousEditByCurrentIc(String line, StringHolder previousEdit, StringHolder previousEditType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(line);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCfgAttachmentLine", "previousEditByCurrentIc", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    previousEdit.value = TcUtility.queryArg(response.output[0], previousEdit.value);
    previousEditType.value = TcUtility.queryArg(response.output[1], previousEditType.value);
  }

}
