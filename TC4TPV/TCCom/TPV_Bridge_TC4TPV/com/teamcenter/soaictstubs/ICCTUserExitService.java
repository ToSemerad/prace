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

public class ICCTUserExitService {
  ICTService m_service;

  Connection m_connection;


  public ICCTUserExitService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void mapObject(String externalObject, StringHolder comp, StringHolder componentType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(externalObject);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUserExitService", "mapObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    comp.value = TcUtility.queryArgStringUnion(response.output[0], comp.value);
    componentType.value = TcUtility.queryArgStringUnion(response.output[1], componentType.value);
  }

  public void mapObjects(String[] externalObjects, uidSeqValue_uHolder components, uidSeqValue_uHolder componentTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(externalObjects);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUserExitService", "mapObjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
    componentTypes.value = TcUtility.queryArg(response.output[1], componentTypes.value);
  }

}
