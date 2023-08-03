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

public class TCClassFactory {
  ICTService m_service;

  Connection m_connection;


  public TCClassFactory(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getTCClass(String classObj, TCClassHolder theClass) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(classObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClassFactory", "getTCClass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theClass.value = new TCClass( m_connection, "TCClass", response.output[0].val);
  }

  public void getTCClasses(String[] objList, TCClassSeq_tHolder classList) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClassFactory", "getTCClasses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    classList.value = new TCClass[response.output[0].array[0].entries.length];
    for( int i = 0; i < response.output[0].array[0].entries.length; i++)
    {
      classList.value[i] = new TCClass(m_connection, "TCClass", response.output[0].array[0].entries[i].val);
    }
  }

}
