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

public class ICCTPSConnection extends ICCTItem {
  public ICCTPSConnection(Connection connection) {
    super(connection);
  }

  public ICCTPSConnection(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createPSConnection(String id, String name, String type, String rev, StringHolder newConnection, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(id);
    args_[3] = TcUtility.createArg(name);
    args_[4] = TcUtility.createArgStringUnion(type);
    args_[5] = TcUtility.createArg(rev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPSConnection", "createPSConnection", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newConnection.value = TcUtility.queryArg(response.output[0], newConnection.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

}
