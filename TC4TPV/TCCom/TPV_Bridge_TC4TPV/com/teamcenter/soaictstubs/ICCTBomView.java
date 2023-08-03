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

public class ICCTBomView extends ICCT {
  public ICCTBomView(Connection connection) {
    super(connection);
  }

  public ICCTBomView(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String viewType, String viewName, String viewDesc, String parentItemObj, StringHolder bomViewObj, StringHolder bomViewTypeObj) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(viewType);
    args_[3] = TcUtility.createArgStringUnion(viewName);
    args_[4] = TcUtility.createArgStringUnion(viewDesc);
    args_[5] = TcUtility.createArg(parentItemObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomView", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomViewObj.value = TcUtility.queryArg(response.output[0], bomViewObj.value);
    bomViewTypeObj.value = TcUtility.queryArg(response.output[1], bomViewTypeObj.value);
  }

}
