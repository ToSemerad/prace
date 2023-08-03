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

public class ICCTExternalDataSource extends ICCT {
  public ICCTExternalDataSource(Connection connection) {
    super(connection);
  }

  public ICCTExternalDataSource(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String dataSourceName, String hostName, String url, String adapterName, StringHolder dataSourceUid, StringHolder dataSourceTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceName);
    args_[3] = TcUtility.createArg(hostName);
    args_[4] = TcUtility.createArg(url);
    args_[5] = TcUtility.createArg(adapterName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    dataSourceUid.value = TcUtility.queryArg(response.output[0], dataSourceUid.value);
    dataSourceTypeUid.value = TcUtility.queryArg(response.output[1], dataSourceTypeUid.value);
  }

  public void find(String dataSourceName, uidSeqValue_uHolder dataSourceUids, uidSeqValue_uHolder dataSourceTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    dataSourceUids.value = TcUtility.queryArg(response.output[0], dataSourceUids.value);
    dataSourceTypeUids.value = TcUtility.queryArg(response.output[1], dataSourceTypeUids.value);
  }

  public void findProxyAccount(String dataSourceUid, String proxyUsername, StringHolder authUid, StringHolder authTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceUid);
    args_[3] = TcUtility.createArg(proxyUsername);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "findProxyAccount", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    authUid.value = TcUtility.queryArgStringUnion(response.output[0], authUid.value);
    authTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], authTypeUid.value);
  }

  public void addProxyAccount(String dataSourceUid, String proxyUsername, String proxyPassword, int accountType) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceUid);
    args_[3] = TcUtility.createArg(proxyUsername);
    args_[4] = TcUtility.createArg(proxyPassword);
    args_[5] = TcUtility.createArg(accountType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "addProxyAccount", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeProxyAccount(String dataSourceUid, String proxyUsername) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceUid);
    args_[3] = TcUtility.createArg(proxyUsername);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "removeProxyAccount", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setProxyAccount(String dataSourceUid, String authUid, String proxyUsername, String proxyPassword, int accountType) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceUid);
    args_[3] = TcUtility.createArg(authUid);
    args_[4] = TcUtility.createArg(proxyUsername);
    args_[5] = TcUtility.createArg(proxyPassword);
    args_[6] = TcUtility.createArg(accountType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "setProxyAccount", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getProxyAccount(String dataSourceUid, String authUid, StringHolder proxyUsername, StringHolder proxyPassword, IntHolder accountType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceUid);
    args_[3] = TcUtility.createArg(authUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "getProxyAccount", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    proxyUsername.value = TcUtility.queryArgStringUnion(response.output[0], proxyUsername.value);
    proxyPassword.value = TcUtility.queryArgStringUnion(response.output[1], proxyPassword.value);
    accountType.value = TcUtility.queryArg(response.output[2], accountType.value);
  }

  public void getGroupMemberProxyAccount(String dataSourceUid, String groupMemberUid, StringHolder proxyUsername, StringHolder proxyPassword, IntHolder accountType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceUid);
    args_[3] = TcUtility.createArg(groupMemberUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "getGroupMemberProxyAccount", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    proxyUsername.value = TcUtility.queryArgStringUnion(response.output[0], proxyUsername.value);
    proxyPassword.value = TcUtility.queryArgStringUnion(response.output[1], proxyPassword.value);
    accountType.value = TcUtility.queryArg(response.output[2], accountType.value);
  }

  public void addProxyAccountAccessors(String dataSourceUid, String authUid, String[] groupMemberUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceUid);
    args_[3] = TcUtility.createArg(authUid);
    args_[4] = TcUtility.createArg(groupMemberUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "addProxyAccountAccessors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeProxyAccountAccessors(String dataSourceUid, String authUid, String[] groupMemberUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceUid);
    args_[3] = TcUtility.createArg(authUid);
    args_[4] = TcUtility.createArg(groupMemberUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "removeProxyAccountAccessors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listProxyAccountAccessors(String dataSourceUid, String authUid, uidSeqValue_uHolder groupMemberUids, uidSeqValue_uHolder groupMemberTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceUid);
    args_[3] = TcUtility.createArg(authUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "listProxyAccountAccessors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    groupMemberUids.value = TcUtility.queryArg(response.output[0], groupMemberUids.value);
    groupMemberTypeUids.value = TcUtility.queryArg(response.output[1], groupMemberTypeUids.value);
  }

  public void clearProxyAccountAccessors(String dataSourceUid, String authUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceUid);
    args_[3] = TcUtility.createArg(authUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTExternalDataSource", "clearProxyAccountAccessors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
