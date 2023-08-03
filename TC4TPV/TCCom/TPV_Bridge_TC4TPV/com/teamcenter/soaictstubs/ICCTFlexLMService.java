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

public class ICCTFlexLMService {
  ICTService m_service;

  Connection m_connection;


  public ICCTFlexLMService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void checkModule(int licenseNo, IntHolder number, BooleanHolder result) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(licenseNo);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFlexLMService", "checkModule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    number.value = TcUtility.queryArg(response.output[0], number.value);
    result.value = TcUtility.queryArg(response.output[1], result.value);
  }

  public void enterModule(int licenseNo, int key, BooleanHolder result) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(licenseNo);
    args_[1] = TcUtility.createArg(key);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFlexLMService", "enterModule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    result.value = TcUtility.queryArg(response.output[0], result.value);
  }

  public void leaveModule(int licenseNo, int key, BooleanHolder result) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(licenseNo);
    args_[1] = TcUtility.createArg(key);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFlexLMService", "leaveModule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    result.value = TcUtility.queryArg(response.output[0], result.value);
  }

  public void enterModuleShared(int licenseNo, int key, BooleanHolder result) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(licenseNo);
    args_[1] = TcUtility.createArg(key);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFlexLMService", "enterModuleShared", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    result.value = TcUtility.queryArg(response.output[0], result.value);
  }

  public void leaveModuleShared(int licenseNo, int key, BooleanHolder result) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(licenseNo);
    args_[1] = TcUtility.createArg(key);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFlexLMService", "leaveModuleShared", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    result.value = TcUtility.queryArg(response.output[0], result.value);
  }

  public void getModule(IntHolder licenseNo) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFlexLMService", "getModule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    licenseNo.value = TcUtility.queryArg(response.output[0], licenseNo.value);
  }

  public void checkModuleStr(String licenseStr, BooleanHolder result) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(licenseStr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFlexLMService", "checkModuleStr", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    result.value = TcUtility.queryArg(response.output[0], result.value);
  }

  public void enterModuleStr(String licenseStr, BooleanHolder result) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(licenseStr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFlexLMService", "enterModuleStr", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    result.value = TcUtility.queryArg(response.output[0], result.value);
  }

  public void leaveModuleStr(String licenseStr, BooleanHolder result) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(licenseStr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFlexLMService", "leaveModuleStr", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    result.value = TcUtility.queryArg(response.output[0], result.value);
  }

  public void isModuleActive(String licenseStr, BooleanHolder result) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(licenseStr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFlexLMService", "isModuleActive", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    result.value = TcUtility.queryArg(response.output[0], result.value);
  }

}
