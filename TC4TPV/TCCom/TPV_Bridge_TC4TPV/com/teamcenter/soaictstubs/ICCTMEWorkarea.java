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

public class ICCTMEWorkarea extends ICCTItem {
  public ICCTMEWorkarea(Connection connection) {
    super(connection);
  }

  public ICCTMEWorkarea(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createMEWorkarea(String id, String revid, String meWorkareaType, String meWorkareaName, String meWorkareaDesc, StringHolder meWorkareaUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    args_[3] = TcUtility.createArgStringUnion(revid);
    args_[4] = TcUtility.createArgStringUnion(meWorkareaType);
    args_[5] = TcUtility.createArgStringUnion(meWorkareaName);
    args_[6] = TcUtility.createArgStringUnion(meWorkareaDesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEWorkarea", "createMEWorkarea", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    meWorkareaUid.value = TcUtility.queryArg(response.output[0], meWorkareaUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

}
