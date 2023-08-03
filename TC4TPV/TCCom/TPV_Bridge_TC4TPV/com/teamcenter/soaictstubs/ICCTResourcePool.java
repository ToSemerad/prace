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

public class ICCTResourcePool extends ICCT {
  public ICCTResourcePool(Connection connection) {
    super(connection);
  }

  public ICCTResourcePool(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String groupUid, String roleUid, boolean allowSubGroup, StringHolder componentUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(groupUid);
    args_[3] = TcUtility.createArgStringUnion(roleUid);
    args_[4] = TcUtility.createArg(allowSubGroup);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTResourcePool", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUid.value = TcUtility.queryArg(response.output[0], componentUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void find(String groupUid, String roleUid, boolean allowSubGroup, StringHolder componentUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(groupUid);
    args_[3] = TcUtility.createArgStringUnion(roleUid);
    args_[4] = TcUtility.createArg(allowSubGroup);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTResourcePool", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUid.value = TcUtility.queryArg(response.output[0], componentUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

}
