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

public class ICCTServer {
  ICTService m_service;

  Connection m_connection;


  public ICCTServer(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void createSessionAndServices(stringSeq_tHolder serviceNames) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTServer", "createSessionAndServices", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    serviceNames.value = TcUtility.queryArg(response.output[0], serviceNames.value);
  }

  public String getServerID() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTServer", "getServerID", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    String argValue_ =null;
    return (String) TcUtility.queryArg(response.output[0], argValue_);
  }

  public void getServerEncodingName(StringHolder encodingName) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTServer", "getServerEncodingName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    encodingName.value = TcUtility.queryArg(response.output[0], encodingName.value);
  }

  public void getServerPlatformName(StringHolder platformName) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTServer", "getServerPlatformName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    platformName.value = TcUtility.queryArg(response.output[0], platformName.value);
  }

  public void getHostname(StringHolder hostname) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTServer", "getHostname", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    hostname.value = TcUtility.queryArg(response.output[0], hostname.value);
  }

  public void shutdown() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTServer", "shutdown", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void registerClientCallback() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTServer", "registerClientCallback", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getServerVersion(String clientVersion, StringHolder version) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(clientVersion);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTServer", "getServerVersion", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    version.value = TcUtility.queryArgStringUnion(response.output[0], version.value);
  }

  public void setMode(String mode) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(mode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTServer", "setMode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void authenticate(String user, String password, String group, boolean ssoEnabled) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(user);
    args_[1] = TcUtility.createArg(password);
    args_[2] = TcUtility.createArgStringUnion(group);
    args_[3] = TcUtility.createArg(ssoEnabled);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTServer", "authenticate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
