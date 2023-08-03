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

public class ICCTCannedMethodService {
  ICTService m_service;

  Connection m_connection;


  public ICCTCannedMethodService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getCannedMethodsForType(String typeName, String msgName, int actionType, cannedMethodInfoSeq_tHolder cannedMethods) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(typeName);
    args_[1] = TcUtility.createArg(msgName);
    args_[2] = TcUtility.createArg(actionType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCannedMethodService", "getCannedMethodsForType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    cannedMethods.value = TcUtility.queryArg(response.output[0], cannedMethods.value);
  }

  public void addCannedMethod(String typeName, String msgName, int actionType, String funcName, int execSeq, String[][] optionValues, StringHolder newCannedMethodUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(typeName);
    args_[1] = TcUtility.createArg(msgName);
    args_[2] = TcUtility.createArg(actionType);
    args_[3] = TcUtility.createArg(funcName);
    args_[4] = TcUtility.createArg(execSeq);
    args_[5] = TcUtility.createArgStringUnion(optionValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCannedMethodService", "addCannedMethod", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newCannedMethodUid.value = TcUtility.queryArg(response.output[0], newCannedMethodUid.value);
  }

  public void modifyCannedMethod(String cannedMethodUid, int execSeq, String[][] optionValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(cannedMethodUid);
    args_[1] = TcUtility.createArg(execSeq);
    args_[2] = TcUtility.createArgStringUnion(optionValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCannedMethodService", "modifyCannedMethod", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeCannedMethod(String cannedMethodUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(cannedMethodUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCannedMethodService", "removeCannedMethod", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
