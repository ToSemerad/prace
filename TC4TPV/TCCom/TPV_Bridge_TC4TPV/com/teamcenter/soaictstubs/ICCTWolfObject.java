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

public class ICCTWolfObject extends ICCT {
  public ICCTWolfObject(Connection connection) {
    super(connection);
  }

  public ICCTWolfObject(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String appGuid, String objUri, String objName, String objDesc, String objIconUrl, String appType, StringHolder wolfObj, StringHolder wolfObjTypeUid) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(appGuid);
    args_[3] = TcUtility.createArg(objUri);
    args_[4] = TcUtility.createArg(objName);
    args_[5] = TcUtility.createArg(objDesc);
    args_[6] = TcUtility.createArg(objIconUrl);
    args_[7] = TcUtility.createArg(appType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTWolfObject", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    wolfObj.value = TcUtility.queryArg(response.output[0], wolfObj.value);
    wolfObjTypeUid.value = TcUtility.queryArg(response.output[1], wolfObjTypeUid.value);
  }

  public void createProxy(String appGuid, String objUri, String appType, StringHolder wolfObj, StringHolder wolfObjTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(appGuid);
    args_[3] = TcUtility.createArg(objUri);
    args_[4] = TcUtility.createArg(appType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTWolfObject", "createProxy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    wolfObj.value = TcUtility.queryArg(response.output[0], wolfObj.value);
    wolfObjTypeUid.value = TcUtility.queryArg(response.output[1], wolfObjTypeUid.value);
  }

  public void findProxy(String appGuid, String objUri, StringHolder componentUids, StringHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(appGuid);
    args_[3] = TcUtility.createArg(objUri);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTWolfObject", "findProxy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUids.value = TcUtility.queryArgStringUnion(response.output[0], componentUids.value);
    componentTypeUids.value = TcUtility.queryArgStringUnion(response.output[1], componentTypeUids.value);
  }

  public void updateProxy(String proxyUid, String[][] propNamesAndValues) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(proxyUid);
    args_[3] = TcUtility.createArgStringUnion(propNamesAndValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTWolfObject", "updateProxy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void find(String appGuid, String objUri, String objName, uidSeqValue_uHolder componentUids, uidSeqValue_uHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(appGuid);
    args_[3] = TcUtility.createArg(objUri);
    args_[4] = TcUtility.createArg(objName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTWolfObject", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUids.value = TcUtility.queryArg(response.output[0], componentUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[1], componentTypeUids.value);
  }

  public void getComplyingTrace(String proxyUid, uidSeqValue_uHolder componentUids, uidSeqValue_uHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(proxyUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTWolfObject", "getComplyingTrace", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUids.value = TcUtility.queryArg(response.output[0], componentUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[1], componentTypeUids.value);
  }

  public void getExportedObjAppGuids(String objectUid, stringValueSeq_tHolder appGuids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTWolfObject", "getExportedObjAppGuids", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    appGuids.value = TcUtility.queryArgStringUnion(response.output[0], appGuids.value);
  }

}
