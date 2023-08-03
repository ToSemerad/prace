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

public class ICCTCAEGeometryItemRevision extends ICCTCAEItemRevision {
  public ICCTCAEGeometryItemRevision(Connection connection) {
    super(connection);
  }

  public ICCTCAEGeometryItemRevision(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void setAttributes(String revTag, String preProcessorType, String[] analysisTypes) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revTag);
    args_[3] = TcUtility.createArgStringUnion(preProcessorType);
    args_[4] = TcUtility.createArg(analysisTypes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEGeometryItemRevision", "setAttributes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
