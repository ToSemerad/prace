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

public class ICCTIDCWindow extends ICCT {
  public ICCTIDCWindow(Connection connection) {
    super(connection);
  }

  public ICCTIDCWindow(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String contextString, StringHolder windowUid, StringHolder windowTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(contextString);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIDCWindow", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    windowUid.value = TcUtility.queryArg(response.output[0], windowUid.value);
    windowTypeUid.value = TcUtility.queryArg(response.output[1], windowTypeUid.value);
  }

  public void close(String windowUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(windowUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIDCWindow", "close", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setWindowTopLine(String windowUid, String aliasPreferenceKey, String idcObjectUid, StringHolder topLineUid, StringHolder topLineTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(windowUid);
    args_[3] = TcUtility.createArgStringUnion(aliasPreferenceKey);
    args_[4] = TcUtility.createArg(idcObjectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIDCWindow", "setWindowTopLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    topLineUid.value = TcUtility.queryArg(response.output[0], topLineUid.value);
    topLineTypeUid.value = TcUtility.queryArg(response.output[1], topLineTypeUid.value);
  }

  public void findLinesWithAbsOccORAPN(String windowUid, boolean searchByAbsOccID, String objectUid, uidSeq_tHolder lines, uidSeq_tHolder lineTypes) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(windowUid);
    args_[3] = TcUtility.createArg(searchByAbsOccID);
    args_[4] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIDCWindow", "findLinesWithAbsOccORAPN", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lines.value = TcUtility.queryArg(response.output[0], lines.value);
    lineTypes.value = TcUtility.queryArg(response.output[1], lineTypes.value);
  }

  public void findLinesWithAbsOccID(String windowUid, String absOccID, uidSeq_tHolder lines, uidSeq_tHolder lineTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(windowUid);
    args_[3] = TcUtility.createArgStringUnion(absOccID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIDCWindow", "findLinesWithAbsOccID", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lines.value = TcUtility.queryArg(response.output[0], lines.value);
    lineTypes.value = TcUtility.queryArg(response.output[1], lineTypes.value);
  }

  public void changeTopLine(String windowUid, String topLine) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(windowUid);
    args_[3] = TcUtility.createArg(topLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIDCWindow", "changeTopLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getRoots(String windowUid, uidSeq_tHolder rootLines, uidSeq_tHolder rootLineTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(windowUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIDCWindow", "getRoots", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rootLines.value = TcUtility.queryArg(response.output[0], rootLines.value);
    rootLineTypes.value = TcUtility.queryArg(response.output[1], rootLineTypes.value);
  }

}
