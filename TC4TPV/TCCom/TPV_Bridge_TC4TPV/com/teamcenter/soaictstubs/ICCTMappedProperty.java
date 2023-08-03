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

public class ICCTMappedProperty extends ICCT {
  public ICCTMappedProperty(Connection connection) {
    super(connection);
  }

  public ICCTMappedProperty(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String extAttrUid, String tcTypeName, String tcPropName, StringHolder mappedPropUid, StringHolder mappedPropTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(extAttrUid);
    args_[3] = TcUtility.createArg(tcTypeName);
    args_[4] = TcUtility.createArg(tcPropName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMappedProperty", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mappedPropUid.value = TcUtility.queryArg(response.output[0], mappedPropUid.value);
    mappedPropTypeUid.value = TcUtility.queryArg(response.output[1], mappedPropTypeUid.value);
  }

  public void find(String extAttUid, String tcTypeName, String tcPropName, StringHolder mappedPropUid, StringHolder mappedPropTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(extAttUid);
    args_[3] = TcUtility.createArg(tcTypeName);
    args_[4] = TcUtility.createArg(tcPropName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMappedProperty", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mappedPropUid.value = TcUtility.queryArgStringUnion(response.output[0], mappedPropUid.value);
    mappedPropTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], mappedPropTypeUid.value);
  }

}
