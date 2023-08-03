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

public class ICCTActionHandler extends ICCT {
  public ICCTActionHandler(Connection connection) {
    super(connection);
  }

  public ICCTActionHandler(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String taskDefinitionUid, int epmAction, String actionHandlerName, String[] actionHandlerArgs, StringHolder actionHandlerDefinitionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(taskDefinitionUid);
    args_[3] = TcUtility.createArg(epmAction);
    args_[4] = TcUtility.createArg(actionHandlerName);
    args_[5] = TcUtility.createArg(actionHandlerArgs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTActionHandler", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    actionHandlerDefinitionUid.value = TcUtility.queryArg(response.output[0], actionHandlerDefinitionUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void removeActionHandler(String actionHandlerUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionHandlerUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTActionHandler", "removeActionHandler", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
