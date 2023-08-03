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

public class ICCTUserService {
  ICTService m_service;

  Connection m_connection;


  public ICCTUserService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getMethodParameters(String methodName, longSeqValue_uHolder argumentTypeList, IntHolder returnParameterType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(methodName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUserService", "getMethodParameters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    argumentTypeList.value = TcUtility.queryArg(response.output[0], argumentTypeList.value);
    returnParameterType.value = TcUtility.queryArg(response.output[1], returnParameterType.value);
  }

  public void callMethod(String methodName, stringSeqValue_u marshalledArguments, StringHolder returnValue) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(methodName);
    args_[1] = TcUtility.createArg(marshalledArguments);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUserService", "callMethod", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    returnValue.value = TcUtility.queryArgStringUnion(response.output[0], returnValue.value);
  }

}
