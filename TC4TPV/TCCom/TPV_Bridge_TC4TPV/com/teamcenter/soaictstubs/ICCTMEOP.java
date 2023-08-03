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

public class ICCTMEOP extends ICCTItem {
  public ICCTMEOP(Connection connection) {
    super(connection);
  }

  public ICCTMEOP(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createMEOP(String id, String revid, String meOpType, String meOpName, String meOpDesc, StringHolder meOpUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    args_[3] = TcUtility.createArgStringUnion(revid);
    args_[4] = TcUtility.createArgStringUnion(meOpType);
    args_[5] = TcUtility.createArgStringUnion(meOpName);
    args_[6] = TcUtility.createArgStringUnion(meOpDesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEOP", "createMEOP", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    meOpUid.value = TcUtility.queryArg(response.output[0], meOpUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

}
