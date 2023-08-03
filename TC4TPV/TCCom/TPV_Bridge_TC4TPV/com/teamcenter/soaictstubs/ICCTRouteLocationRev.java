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

public class ICCTRouteLocationRev extends ICCTItemRevision {
  public ICCTRouteLocationRev(Connection connection) {
    super(connection);
  }

  public ICCTRouteLocationRev(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createRouteLocationRev(String locationUid, String rev_id, StringHolder newRouteLocationRevUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(locationUid);
    args_[3] = TcUtility.createArg(rev_id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteLocationRev", "createRouteLocationRev", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRouteLocationRevUid.value = TcUtility.queryArg(response.output[0], newRouteLocationRevUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

}
