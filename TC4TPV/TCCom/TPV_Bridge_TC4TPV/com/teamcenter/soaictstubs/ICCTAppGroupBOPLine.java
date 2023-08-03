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

public class ICCTAppGroupBOPLine extends ICCTBOPLine {
  public ICCTAppGroupBOPLine(Connection connection) {
    super(connection);
  }

  public ICCTAppGroupBOPLine(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void insertChild(String appgrpLine, String child) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(appgrpLine);
    args_[3] = TcUtility.createArg(child);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppGroupBOPLine", "insertChild", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
