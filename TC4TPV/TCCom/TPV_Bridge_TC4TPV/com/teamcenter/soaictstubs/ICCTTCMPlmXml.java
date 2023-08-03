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

public class ICCTTCMPlmXml extends ICCT {
  public ICCTTCMPlmXml(Connection connection) {
    super(connection);
  }

  public ICCTTCMPlmXml(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void exportXML(String[] selectedComps, String applicationKey, String directoryName, StringHolder fileLocation) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(selectedComps);
    args_[3] = TcUtility.createArg(applicationKey);
    args_[4] = TcUtility.createArgStringUnion(directoryName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTCMPlmXml", "exportXML", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileLocation.value = TcUtility.queryArg(response.output[0], fileLocation.value);
  }

  public void importXML(String directoryName, String applicationType, String icComponent, StringHolder endItem, uidSeq_tHolder views, IntHolder errorStatus) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(directoryName);
    args_[3] = TcUtility.createArgStringUnion(applicationType);
    args_[4] = TcUtility.createArg(icComponent);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTCMPlmXml", "importXML", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    endItem.value = TcUtility.queryArg(response.output[0], endItem.value);
    views.value = TcUtility.queryArg(response.output[1], views.value);
    errorStatus.value = TcUtility.queryArg(response.output[2], errorStatus.value);
  }

}
