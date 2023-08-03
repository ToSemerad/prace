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

public class ICCTCAEAnalysisRevision extends ICCTCAEItemRevision {
  public ICCTCAEAnalysisRevision(Connection connection) {
    super(connection);
  }

  public ICCTCAEAnalysisRevision(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String id, String revid, StringHolder caeAnalysisRevisionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    args_[3] = TcUtility.createArgStringUnion(revid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEAnalysisRevision", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    caeAnalysisRevisionUid.value = TcUtility.queryArg(response.output[0], caeAnalysisRevisionUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void setAttributes(String revTag, String solverName, String analysisType, String solutionType, String solutionStep) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revTag);
    args_[3] = TcUtility.createArgStringUnion(solverName);
    args_[4] = TcUtility.createArgStringUnion(analysisType);
    args_[5] = TcUtility.createArgStringUnion(solutionType);
    args_[6] = TcUtility.createArgStringUnion(solutionStep);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEAnalysisRevision", "setAttributes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createAttachmentWindow(String revRule, String bomWin, StringHolder window, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(revRule);
    args_[3] = TcUtility.createArgStringUnion(bomWin);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEAnalysisRevision", "createAttachmentWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    window.value = TcUtility.queryArg(response.output[0], window.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void createTopLine(String win_uid, String obj, StringHolder top_line, StringHolder top_line_type) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(win_uid);
    args_[3] = TcUtility.createArgStringUnion(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEAnalysisRevision", "createTopLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    top_line.value = TcUtility.queryArg(response.output[0], top_line.value);
    top_line_type.value = TcUtility.queryArg(response.output[1], top_line_type.value);
  }

}
