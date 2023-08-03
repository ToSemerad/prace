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

public class ICCTCAEService {
  ICTService m_service;

  Connection m_connection;


  public ICCTCAEService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getFilterTable(IntHolder num_table_elements, stringSeqValue_uHolder work_procedures, stringSeqValue_uHolder vppss, stringSeqValue_uHolder fillers) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEService", "getFilterTable", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    num_table_elements.value = TcUtility.queryArg(response.output[0], num_table_elements.value);
    work_procedures.value = TcUtility.queryArg(response.output[1], work_procedures.value);
    vppss.value = TcUtility.queryArg(response.output[2], vppss.value);
    fillers.value = TcUtility.queryArg(response.output[3], fillers.value);
  }

  public void addFilterRow(String work_procedure, String vpps, String filler) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArgStringUnion(work_procedure);
    args_[1] = TcUtility.createArgStringUnion(vpps);
    args_[2] = TcUtility.createArgStringUnion(filler);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEService", "addFilterRow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeFilterRow(String work_procedure, String vpps) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArgStringUnion(work_procedure);
    args_[1] = TcUtility.createArgStringUnion(vpps);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEService", "removeFilterRow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getFilterForProcedure(String procedure, IntHolder num_table_elements, stringSeqValue_uHolder work_procedures, stringSeqValue_uHolder vppss, stringSeqValue_uHolder fillers) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(procedure);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEService", "getFilterForProcedure", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    num_table_elements.value = TcUtility.queryArg(response.output[0], num_table_elements.value);
    work_procedures.value = TcUtility.queryArg(response.output[1], work_procedures.value);
    vppss.value = TcUtility.queryArg(response.output[2], vppss.value);
    fillers.value = TcUtility.queryArg(response.output[3], fillers.value);
  }

  public void removeAllFilterRows() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEService", "removeAllFilterRows", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void load_filter_mapping(String mappingFile) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(mappingFile);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEService", "load_filter_mapping", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void write_filter_mapping(String mappingFile) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(mappingFile);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEService", "write_filter_mapping", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getInternalTemplates(String folderName, IntHolder num_table_elements, stringSeqValue_uHolder templates) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(folderName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEService", "getInternalTemplates", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    num_table_elements.value = TcUtility.queryArg(response.output[0], num_table_elements.value);
    templates.value = TcUtility.queryArg(response.output[1], templates.value);
  }

}
