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

public class ICCTPSSignal extends ICCTItem {
  public ICCTPSSignal(Connection connection) {
    super(connection);
  }

  public ICCTPSSignal(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createPSSignal(String id, String name, String type, String rev, StringHolder newSignal, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(id);
    args_[3] = TcUtility.createArg(name);
    args_[4] = TcUtility.createArgStringUnion(type);
    args_[5] = TcUtility.createArg(rev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPSSignal", "createPSSignal", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSignal.value = TcUtility.queryArg(response.output[0], newSignal.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

}
