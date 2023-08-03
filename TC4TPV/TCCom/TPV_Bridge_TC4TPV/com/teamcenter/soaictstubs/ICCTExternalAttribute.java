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

public class ICCTExternalAttribute extends ICCT {
  public ICCTExternalAttribute(Connection connection) {
    super(connection);
  }

  public ICCTExternalAttribute(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String dataSourceName, String tableName, String attrName, int attrType, int attrLen, StringHolder extAttributeUid, StringHolder extAttributeTypeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceName);
    args_[3] = TcUtility.createArg(tableName);
    args_[4] = TcUtility.createArg(attrName);
    args_[5] = TcUtility.createArg(attrType);
    args_[6] = TcUtility.createArg(attrLen);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalAttribute", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extAttributeUid.value = TcUtility.queryArg(response.output[0], extAttributeUid.value);
    extAttributeTypeUid.value = TcUtility.queryArg(response.output[1], extAttributeTypeUid.value);
  }

  public void find(String dataSourceName, String tableName, String attrName, StringHolder extAttributeUid, StringHolder extAttributeTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceName);
    args_[3] = TcUtility.createArg(tableName);
    args_[4] = TcUtility.createArg(attrName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalAttribute", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extAttributeUid.value = TcUtility.queryArgStringUnion(response.output[0], extAttributeUid.value);
    extAttributeTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], extAttributeTypeUid.value);
  }

}
