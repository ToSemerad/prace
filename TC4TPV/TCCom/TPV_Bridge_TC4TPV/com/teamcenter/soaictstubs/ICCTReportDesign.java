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

public class ICCTReportDesign extends ICCT {
  public ICCTReportDesign(Connection connection) {
    super(connection);
  }

  public ICCTReportDesign(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String description, String tcQuery, String dataFormatter, uidSeqValue_u reportFormatters, StringHolder reportDesign, StringHolder reportDesignType) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArgStringUnion(description);
    args_[4] = TcUtility.createArg(tcQuery);
    args_[5] = TcUtility.createArgStringUnion(dataFormatter);
    args_[6] = TcUtility.createArg(reportFormatters);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReportDesign", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    reportDesign.value = TcUtility.queryArg(response.output[0], reportDesign.value);
    reportDesignType.value = TcUtility.queryArg(response.output[1], reportDesignType.value);
  }

  public void find(String name, StringHolder reportDesign, StringHolder reportDesignType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReportDesign", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    reportDesign.value = TcUtility.queryArgStringUnion(response.output[0], reportDesign.value);
    reportDesignType.value = TcUtility.queryArgStringUnion(response.output[1], reportDesignType.value);
  }

  public void generate_report(String reportDesign, String[] entryNames, String[] entryValues, uidSeqValue_u limits, StringHolder xmlFileLocation) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(reportDesign);
    args_[3] = TcUtility.createArg(entryNames);
    args_[4] = TcUtility.createArgStringUnion(entryValues);
    args_[5] = TcUtility.createArg(limits);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReportDesign", "generate_report", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    xmlFileLocation.value = TcUtility.queryArg(response.output[0], xmlFileLocation.value);
  }

  public void getDefaultXSLFile(StringHolder xslFileLocation) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReportDesign", "getDefaultXSLFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    xslFileLocation.value = TcUtility.queryArg(response.output[0], xslFileLocation.value);
  }

}
