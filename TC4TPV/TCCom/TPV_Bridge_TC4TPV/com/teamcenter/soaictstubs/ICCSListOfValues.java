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

public class ICCSListOfValues {
  ICTService m_service;

  String m_typeName;

  String m_objectUid;

  Connection m_connection;


  public ICCSListOfValues(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public ICCSListOfValues(Connection connection, String typeName, String objectUid) {
    m_service = ICTService.getService( connection );
    m_typeName = typeName;
    m_objectUid = objectUid;
    m_connection = connection;
  }

  public void setObjectUid(String objectUid) {
    m_objectUid= objectUid;
  }

  public String getObjectUid() {
    return m_objectUid;
  }

  public void setTypeName(String typeName) {
    m_typeName = typeName;
  }

  public String getTypeName() {
    return m_typeName;
  }

  public void edit() throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSListOfValues", "edit", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
