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

public class ICCTClassService {
  ICTService m_service;

  Connection m_connection;


  public ICCTClassService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void find(String className, StringHolder classObj) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(className);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTClassService", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    classObj.value = TcUtility.queryArgStringUnion(response.output[0], classObj.value);
  }

  public void findByClass(String className, String attributeName, String searchString, uidSeqValue_uHolder foundObjs, uidSeqValue_uHolder foundTypeObjs) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(className);
    args_[1] = TcUtility.createArg(attributeName);
    args_[2] = TcUtility.createArg(searchString);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTClassService", "findByClass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    foundObjs.value = TcUtility.queryArg(response.output[0], foundObjs.value);
    foundTypeObjs.value = TcUtility.queryArg(response.output[1], foundTypeObjs.value);
  }

  public void findByClassMulti(String className, String[] attributeNames, String[] searchStrings, uidSeqValue_uHolder foundObjs, uidSeqValue_uHolder foundTypeObjs) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(className);
    args_[1] = TcUtility.createArg(attributeNames);
    args_[2] = TcUtility.createArg(searchStrings);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTClassService", "findByClassMulti", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    foundObjs.value = TcUtility.queryArg(response.output[0], foundObjs.value);
    foundTypeObjs.value = TcUtility.queryArg(response.output[1], foundTypeObjs.value);
  }

  public TCClassFactory getTCClassFactory() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTClassService", "getTCClassFactory", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    return new TCClassFactory(m_connection);
  }

}
