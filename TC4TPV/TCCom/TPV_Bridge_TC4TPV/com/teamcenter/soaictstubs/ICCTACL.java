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

public class ICCTACL extends ICCT {
  public ICCTACL(Connection connection) {
    super(connection);
  }

  public ICCTACL(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void find(String name, StringHolder acl, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    acl.value = TcUtility.queryArg(response.output[0], acl.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void create(String name, boolean ruletreeACL, StringHolder acl, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArg(ruletreeACL);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    acl.value = TcUtility.queryArg(response.output[0], acl.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void unload(String aclUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aclUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "unload", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setName(String aclUid, String name) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aclUid);
    args_[3] = TcUtility.createArgStringUnion(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "setName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getName(String aclUid, StringHolder name) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aclUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "getName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    name.value = TcUtility.queryArgStringUnion(response.output[0], name.value);
  }

  public void clear(String aclUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aclUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "clear", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAccessors(String aclUid, uidSeqValue_uHolder accessors, uidSeqValue_uHolder accessorTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aclUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "getAccessors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    accessors.value = TcUtility.queryArg(response.output[0], accessors.value);
    accessorTypeUids.value = TcUtility.queryArg(response.output[1], accessorTypeUids.value);
  }

  public void removeAccessors(String aclUid, String[] accessorUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aclUid);
    args_[3] = TcUtility.createArg(accessorUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "removeAccessors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void grantPrivileges(String aclUid, String accessorUid, String[] privileges) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aclUid);
    args_[3] = TcUtility.createArg(accessorUid);
    args_[4] = TcUtility.createArg(privileges);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "grantPrivileges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void revokePrivileges(String aclUid, String accessorUid, String[] privileges) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aclUid);
    args_[3] = TcUtility.createArg(accessorUid);
    args_[4] = TcUtility.createArg(privileges);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "revokePrivileges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unsetPrivileges(String aclUid, String accessorUid, String[] privileges) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aclUid);
    args_[3] = TcUtility.createArg(accessorUid);
    args_[4] = TcUtility.createArg(privileges);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "unsetPrivileges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAccessorPrivileges(String aclUid, String accessorUid, uidSeqValue_uHolder grantedPrivileges, uidSeqValue_uHolder grantedTypeUids, stringSeqValue_uHolder grantedStrings, uidSeqValue_uHolder revokedPrivileges, uidSeqValue_uHolder revokedTypeUids, stringSeqValue_uHolder revokedStrings) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aclUid);
    args_[3] = TcUtility.createArg(accessorUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "getAccessorPrivileges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    grantedPrivileges.value = TcUtility.queryArg(response.output[0], grantedPrivileges.value);
    grantedTypeUids.value = TcUtility.queryArg(response.output[1], grantedTypeUids.value);
    grantedStrings.value = TcUtility.queryArg(response.output[2], grantedStrings.value);
    revokedPrivileges.value = TcUtility.queryArg(response.output[3], revokedPrivileges.value);
    revokedTypeUids.value = TcUtility.queryArg(response.output[4], revokedTypeUids.value);
    revokedStrings.value = TcUtility.queryArg(response.output[5], revokedStrings.value);
  }

  public void getACLsByType(int type, uidSeqValue_uHolder uids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTACL", "getACLsByType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uids.value = TcUtility.queryArg(response.output[0], uids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

}
