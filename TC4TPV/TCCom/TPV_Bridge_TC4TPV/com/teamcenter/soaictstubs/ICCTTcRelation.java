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

public class ICCTTcRelation extends ICCT {
  public ICCTTcRelation(Connection connection) {
    super(connection);
  }

  public ICCTTcRelation(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createType(String relationName, StringHolder relationTypeUid, StringHolder relationTypeTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(relationName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcRelation", "createType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    relationTypeUid.value = TcUtility.queryArg(response.output[0], relationTypeUid.value);
    relationTypeTypeUid.value = TcUtility.queryArg(response.output[1], relationTypeTypeUid.value);
  }

  public void removeType(String relationTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(relationTypeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcRelation", "removeType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
