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

public class ICCTAuditReport extends ICCT {
  public ICCTAuditReport(Connection connection) {
    super(connection);
  }

  public ICCTAuditReport(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void getAuditedLines(int n_nodes, String[] tNodes, String rev_rule_tag, String var_rule_tag, IntHolder noOfTargetAuditedLines, uidValueSeq_tHolder targetAuditedLineUids, uidValueSeq_tHolder targetAuditedLineTypeUids) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(n_nodes);
    args_[3] = TcUtility.createArg(tNodes);
    args_[4] = TcUtility.createArg(rev_rule_tag);
    args_[5] = TcUtility.createArgStringUnion(var_rule_tag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditReport", "getAuditedLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfTargetAuditedLines.value = TcUtility.queryArg(response.output[0], noOfTargetAuditedLines.value);
    targetAuditedLineUids.value = TcUtility.queryArgStringUnion(response.output[1], targetAuditedLineUids.value);
    targetAuditedLineTypeUids.value = TcUtility.queryArgStringUnion(response.output[2], targetAuditedLineTypeUids.value);
  }

  public void getAuditData(int n_nodes, String[] tNodes, String rev_rule_tag, String var_rule_tag, IntHolder noOfAuditedLines, rdvAuditDataSeq_tHolder outputAuditedLineTags, StringHolder targetAuditReportTag, StringHolder targetAuditReportTypeTag) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(n_nodes);
    args_[3] = TcUtility.createArg(tNodes);
    args_[4] = TcUtility.createArg(rev_rule_tag);
    args_[5] = TcUtility.createArgStringUnion(var_rule_tag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditReport", "getAuditData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfAuditedLines.value = TcUtility.queryArg(response.output[0], noOfAuditedLines.value);
    outputAuditedLineTags.value = TcUtility.queryArg(response.output[1], outputAuditedLineTags.value);
    targetAuditReportTag.value = TcUtility.queryArg(response.output[2], targetAuditReportTag.value);
    targetAuditReportTypeTag.value = TcUtility.queryArg(response.output[3], targetAuditReportTypeTag.value);
  }

  public void getDesignAuditData(int n_nodes, String[] tNodes, String rev_rule_tag, IntHolder noOfAuditedLines, rdvAuditDataSeq_tHolder outputAuditedLineTags, StringHolder targetAuditReportTag, StringHolder targetAuditReportTypeTag) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(n_nodes);
    args_[3] = TcUtility.createArg(tNodes);
    args_[4] = TcUtility.createArg(rev_rule_tag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditReport", "getDesignAuditData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfAuditedLines.value = TcUtility.queryArg(response.output[0], noOfAuditedLines.value);
    outputAuditedLineTags.value = TcUtility.queryArg(response.output[1], outputAuditedLineTags.value);
    targetAuditReportTag.value = TcUtility.queryArg(response.output[2], targetAuditReportTag.value);
    targetAuditReportTypeTag.value = TcUtility.queryArg(response.output[3], targetAuditReportTypeTag.value);
  }

  public void clear(String report_tag) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(report_tag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditReport", "clear", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void closeTargetWindow(String report_tag) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(report_tag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAuditReport", "closeTargetWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
