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

public class ICCTConfigurationContext extends ICCT {
  public ICCTConfigurationContext(Connection connection) {
    super(connection);
  }

  public ICCTConfigurationContext(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String type, String desc, StringHolder comp, StringHolder componentType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(name);
    args_[3] = TcUtility.createArgStringUnion(type);
    args_[4] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTConfigurationContext", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    comp.value = TcUtility.queryArg(response.output[0], comp.value);
    componentType.value = TcUtility.queryArg(response.output[1], componentType.value);
  }

  public void saveAs(String configTag, String name, String desc, StringHolder newConfig) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(configTag);
    args_[3] = TcUtility.createArgStringUnion(name);
    args_[4] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTConfigurationContext", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newConfig.value = TcUtility.queryArg(response.output[0], newConfig.value);
  }

}
