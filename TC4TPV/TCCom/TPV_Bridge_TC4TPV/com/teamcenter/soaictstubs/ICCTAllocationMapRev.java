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

public class ICCTAllocationMapRev extends ICCTItemRevision {
  public ICCTAllocationMapRev(Connection connection) {
    super(connection);
  }

  public ICCTAllocationMapRev(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createMapRevision(String mapUid, String revId, StringHolder mapRevUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(mapUid);
    args_[3] = TcUtility.createArg(revId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocationMapRev", "createMapRevision", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mapRevUid.value = TcUtility.queryArg(response.output[0], mapRevUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

}
