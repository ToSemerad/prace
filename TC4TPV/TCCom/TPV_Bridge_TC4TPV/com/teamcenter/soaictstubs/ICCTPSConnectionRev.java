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

public class ICCTPSConnectionRev extends ICCTItemRevision {
  public ICCTPSConnectionRev(Connection connection) {
    super(connection);
  }

  public ICCTPSConnectionRev(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String connection, String revisionId, StringHolder newRev, StringHolder newRevType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(connection);
    args_[3] = TcUtility.createArgStringUnion(revisionId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPSConnectionRev", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRev.value = TcUtility.queryArg(response.output[0], newRev.value);
    newRevType.value = TcUtility.queryArg(response.output[1], newRevType.value);
  }

}
