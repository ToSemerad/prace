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

public class ICCTAliasList extends ICCT {
  public ICCTAliasList(Connection connection) {
    super(connection);
  }

  public ICCTAliasList(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String aliasListName, stringSeqValue_u emailIds, StringHolder aliasListUid, StringHolder aliasListTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aliasListName);
    args_[3] = TcUtility.createArg(emailIds);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAliasList", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    aliasListUid.value = TcUtility.queryArg(response.output[0], aliasListUid.value);
    aliasListTypeUid.value = TcUtility.queryArg(response.output[1], aliasListTypeUid.value);
  }

  public void find(String aliasListName, StringHolder aliasListUid, StringHolder aliasListTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aliasListName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAliasList", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    aliasListUid.value = TcUtility.queryArg(response.output[0], aliasListUid.value);
    aliasListTypeUid.value = TcUtility.queryArg(response.output[1], aliasListTypeUid.value);
  }

  public void addMembers(String aliasListUid, String[] newMembers) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aliasListUid);
    args_[3] = TcUtility.createArg(newMembers);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAliasList", "addMembers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeMembers(String aliasListUid, String[] membersToRemove) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aliasListUid);
    args_[3] = TcUtility.createArg(membersToRemove);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAliasList", "removeMembers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
