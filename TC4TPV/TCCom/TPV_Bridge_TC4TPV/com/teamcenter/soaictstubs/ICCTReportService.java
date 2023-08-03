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

public class ICCTReportService {
  ICTService m_service;

  Connection m_connection;


  public ICCTReportService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void generateReport(int reportOption, String[] parameters, StringHolder reportOutputPath) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(reportOption);
    args_[1] = TcUtility.createArgStringUnion(parameters);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReportService", "generateReport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    reportOutputPath.value = TcUtility.queryArg(response.output[0], reportOutputPath.value);
  }

  public void generateNoInputReport(int reportOption, StringHolder reportOutputPath) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(reportOption);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReportService", "generateNoInputReport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    reportOutputPath.value = TcUtility.queryArg(response.output[0], reportOutputPath.value);
  }

  public void generateArrayInputReport(int reportOption, stringSeqValue_u[] parameters, StringHolder reportOuputPath) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(reportOption);
    args_[1] = TcUtility.createArg(parameters);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReportService", "generateArrayInputReport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    reportOuputPath.value = TcUtility.queryArg(response.output[0], reportOuputPath.value);
  }

  public void removeTempReport(String filePath) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(filePath);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReportService", "removeTempReport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
