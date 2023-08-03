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

public class ICCTIDService {
  ICTService m_service;

  Connection m_connection;


  public ICCTIDService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getNextID(String idname, StringHolder nextId) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(idname);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIDService", "getNextID", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nextId.value = TcUtility.queryArgStringUnion(response.output[0], nextId.value);
  }

}
