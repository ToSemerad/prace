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

public class ICCTCfgAttachmentWindow extends ICCTMECfgWindow {
  public ICCTCfgAttachmentWindow(Connection connection) {
    super(connection);
  }

  public ICCTCfgAttachmentWindow(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createAttachmentWindow(String revRule, String bomWin, StringHolder window, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(revRule);
    args_[3] = TcUtility.createArgStringUnion(bomWin);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCfgAttachmentWindow", "createAttachmentWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    window.value = TcUtility.queryArg(response.output[0], window.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

}
