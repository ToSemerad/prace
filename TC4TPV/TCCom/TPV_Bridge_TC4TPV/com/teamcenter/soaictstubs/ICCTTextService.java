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

public class ICCTTextService {
  ICTService m_service;

  Connection m_connection;


  public ICCTTextService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getTextValue(String name, StringHolder value) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTextService", "getTextValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    value.value = TcUtility.queryArgStringUnion(response.output[0], value.value);
  }

  public void getTextValues(String[] names, stringValueSeq_tHolder values) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(names);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTextService", "getTextValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArgStringUnion(response.output[0], values.value);
  }

}
