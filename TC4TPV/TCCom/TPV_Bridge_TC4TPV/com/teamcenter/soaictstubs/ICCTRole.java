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

public class ICCTRole extends ICCT {
  public ICCTRole(Connection connection) {
    super(connection);
  }

  public ICCTRole(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String roleName, StringHolder newRole, StringHolder newRoleType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(roleName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRole", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRole.value = TcUtility.queryArg(response.output[0], newRole.value);
    newRoleType.value = TcUtility.queryArg(response.output[1], newRoleType.value);
  }

  public void find(String roleName, StringHolder role, StringHolder roleType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(roleName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRole", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    role.value = TcUtility.queryArgStringUnion(response.output[0], role.value);
    roleType.value = TcUtility.queryArgStringUnion(response.output[1], roleType.value);
  }

  public void getUsers(String role, String group, uidSeqValue_uHolder users, uidSeqValue_uHolder userTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(role);
    args_[3] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRole", "getUsers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    users.value = TcUtility.queryArg(response.output[0], users.value);
    userTypes.value = TcUtility.queryArg(response.output[1], userTypes.value);
  }

  public void getGroupmembers(String role, String group, uidSeqValue_uHolder groupMembers, uidSeqValue_uHolder groupMemberTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(role);
    args_[3] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRole", "getGroupmembers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    groupMembers.value = TcUtility.queryArg(response.output[0], groupMembers.value);
    groupMemberTypes.value = TcUtility.queryArg(response.output[1], groupMemberTypes.value);
  }

  public void getRoleNames(stringSeqValue_uHolder roleList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRole", "getRoleNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    roleList.value = TcUtility.queryArg(response.output[0], roleList.value);
  }

  public void getRoleAndIconIdList(stringSeqValue_uHolder roleList, stringSeqValue_uHolder roleSiteList, longSeqValue_uHolder roleIconIdList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRole", "getRoleAndIconIdList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    roleList.value = TcUtility.queryArg(response.output[0], roleList.value);
    roleSiteList.value = TcUtility.queryArg(response.output[1], roleSiteList.value);
    roleIconIdList.value = TcUtility.queryArg(response.output[2], roleIconIdList.value);
  }

  public void getMappedRoleAttrList(stringSeqValue_uHolder mapped_role_attr_list) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRole", "getMappedRoleAttrList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mapped_role_attr_list.value = TcUtility.queryArg(response.output[0], mapped_role_attr_list.value);
  }

  public void setRoleName(String role, String roleName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(role);
    args_[3] = TcUtility.createArg(roleName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRole", "setRoleName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setRoleDesc(String role, String roleDesc) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(role);
    args_[3] = TcUtility.createArgStringUnion(roleDesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRole", "setRoleDesc", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
