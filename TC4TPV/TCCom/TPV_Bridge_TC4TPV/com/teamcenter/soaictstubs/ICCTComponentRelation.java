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

public class ICCTComponentRelation extends ICCT {
  public ICCTComponentRelation(Connection connection) {
    super(connection);
  }

  public ICCTComponentRelation(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createType(String relationName, StringHolder relationType, StringHolder relationTypeType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(relationName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTComponentRelation", "createType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    relationType.value = TcUtility.queryArg(response.output[0], relationType.value);
    relationTypeType.value = TcUtility.queryArg(response.output[1], relationTypeType.value);
  }

  public void removeType(String relationType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(relationType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTComponentRelation", "removeType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
