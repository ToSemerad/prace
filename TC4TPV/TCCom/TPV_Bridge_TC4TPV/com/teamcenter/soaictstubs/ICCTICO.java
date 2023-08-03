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

public class ICCTICO extends ICCT {
  public ICCTICO(Connection connection) {
    super(connection);
  }

  public ICCTICO(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void find(String theId, StringHolder theICO, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTICO", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theICO.value = TcUtility.queryArg(response.output[0], theICO.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void askICSProperties(String theIcoUid, icspropSeqHolder iccsPropertyList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theIcoUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTICO", "askICSProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iccsPropertyList.value = TcUtility.queryArg(response.output[0], iccsPropertyList.value);
  }

  public void askICSPropertyDescriptors(String theIcoUid, icsviewattrSeqHolder thePropertyDescriptions) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theIcoUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTICO", "askICSPropertyDescriptors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    thePropertyDescriptions.value = TcUtility.queryArg(response.output[0], thePropertyDescriptions.value);
  }

}
