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

public class ICCTSignoffProfile extends ICCT {
  public ICCTSignoffProfile(Connection connection) {
    super(connection);
  }

  public ICCTSignoffProfile(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String group, String role, boolean allowSubgroups, int numToSignoff, StringHolder componentUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(group);
    args_[3] = TcUtility.createArgStringUnion(role);
    args_[4] = TcUtility.createArg(allowSubgroups);
    args_[5] = TcUtility.createArg(numToSignoff);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSignoffProfile", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUid.value = TcUtility.queryArg(response.output[0], componentUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

}
