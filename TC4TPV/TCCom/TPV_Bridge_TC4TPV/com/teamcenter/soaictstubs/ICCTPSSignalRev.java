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

public class ICCTPSSignalRev extends ICCTItemRevision {
  public ICCTPSSignalRev(Connection connection) {
    super(connection);
  }

  public ICCTPSSignalRev(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String signal, String revisionId, StringHolder newRev, StringHolder newRevType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signal);
    args_[3] = TcUtility.createArg(revisionId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPSSignalRev", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRev.value = TcUtility.queryArg(response.output[0], newRev.value);
    newRevType.value = TcUtility.queryArg(response.output[1], newRevType.value);
  }

}
