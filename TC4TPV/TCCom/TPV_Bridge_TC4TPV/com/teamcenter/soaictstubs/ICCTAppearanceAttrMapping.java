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

public class ICCTAppearanceAttrMapping extends ICCT {
  public ICCTAppearanceAttrMapping(Connection connection) {
    super(connection);
  }

  public ICCTAppearanceAttrMapping(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(uidSeqValue_u noteTypes, uidSeqValue_u attrs, boolean externalFlag, StringHolder newMapping, StringHolder newType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteTypes);
    args_[3] = TcUtility.createArg(attrs);
    args_[4] = TcUtility.createArg(externalFlag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceAttrMapping", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newMapping.value = TcUtility.queryArg(response.output[0], newMapping.value);
    newType.value = TcUtility.queryArg(response.output[1], newType.value);
  }

}
