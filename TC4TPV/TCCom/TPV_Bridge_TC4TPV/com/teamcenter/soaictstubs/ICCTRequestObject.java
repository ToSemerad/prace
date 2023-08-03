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

public class ICCTRequestObject extends ICCT {
  public ICCTRequestObject(Connection connection) {
    super(connection);
  }

  public ICCTRequestObject(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String ai, short reqType, String name, String type, String desc, StringHolder compUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ai);
    args_[3] = TcUtility.createArg(reqType);
    args_[4] = TcUtility.createArgStringUnion(name);
    args_[5] = TcUtility.createArgStringUnion(type);
    args_[6] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRequestObject", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    compUid.value = TcUtility.queryArg(response.output[0], compUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void getSecuredFiles(String thisUid, stringSeqValue_uHolder originalFileNames, stringSeqValue_uHolder fileLocations, uidSeqValue_uHolder fileUids, longSeq_tHolder fileTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRequestObject", "getSecuredFiles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    originalFileNames.value = TcUtility.queryArg(response.output[0], originalFileNames.value);
    fileLocations.value = TcUtility.queryArg(response.output[1], fileLocations.value);
    fileUids.value = TcUtility.queryArg(response.output[2], fileUids.value);
    fileTypes.value = TcUtility.queryArg(response.output[3], fileTypes.value);
  }

  public void process(String thisUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRequestObject", "process", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
