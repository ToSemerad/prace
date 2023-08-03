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

public class ICCTGroupMember extends ICCT {
  public ICCTGroupMember(Connection connection) {
    super(connection);
  }

  public ICCTGroupMember(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String group, String user, String role, boolean groupPrivilege, StringHolder newGroupMember, StringHolder newGroupMemberType) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    args_[3] = TcUtility.createArg(user);
    args_[4] = TcUtility.createArgStringUnion(role);
    args_[5] = TcUtility.createArg(groupPrivilege);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newGroupMember.value = TcUtility.queryArg(response.output[0], newGroupMember.value);
    newGroupMemberType.value = TcUtility.queryArg(response.output[1], newGroupMemberType.value);
  }

  public void getGroupMembers(String user, String group, String role, uidSeqValue_uHolder members, uidSeqValue_uHolder memberTypes) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(user);
    args_[3] = TcUtility.createArgStringUnion(group);
    args_[4] = TcUtility.createArgStringUnion(role);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "getGroupMembers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    members.value = TcUtility.queryArg(response.output[0], members.value);
    memberTypes.value = TcUtility.queryArg(response.output[1], memberTypes.value);
  }

  public void getGroupMemberNames(String groupName, String roleName, stringSeqValue_uHolder userList, stringSeqValue_uHolder userIdList) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(groupName);
    args_[3] = TcUtility.createArgStringUnion(roleName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "getGroupMemberNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    userList.value = TcUtility.queryArg(response.output[0], userList.value);
    userIdList.value = TcUtility.queryArg(response.output[1], userIdList.value);
  }

  public void getGroupMemberAndIconIdList(String groupName, String roleName, stringSeqValue_uHolder userList, stringSeqValue_uHolder userIdList, stringSeqValue_uHolder userSiteList, longSeqValue_uHolder groupMemberIconIdList) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(groupName);
    args_[3] = TcUtility.createArgStringUnion(roleName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "getGroupMemberAndIconIdList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    userList.value = TcUtility.queryArg(response.output[0], userList.value);
    userIdList.value = TcUtility.queryArg(response.output[1], userIdList.value);
    userSiteList.value = TcUtility.queryArg(response.output[2], userSiteList.value);
    groupMemberIconIdList.value = TcUtility.queryArg(response.output[3], groupMemberIconIdList.value);
  }

  public void setGroup(String groupMember, String group) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupMember);
    args_[3] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "setGroup", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setUser(String groupMember, String user) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupMember);
    args_[3] = TcUtility.createArg(user);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "setUser", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setRole(String groupMember, String role) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupMember);
    args_[3] = TcUtility.createArgStringUnion(role);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "setRole", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPrivilege(String groupMember, boolean groupPrivilege) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupMember);
    args_[3] = TcUtility.createArg(groupPrivilege);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "setPrivilege", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void hasReleaseObject(String groupMember, BooleanHolder hasReleObj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupMember);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "hasReleaseObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    hasReleObj.value = TcUtility.queryArg(response.output[0], hasReleObj.value);
  }

  public void askMemberStatus(String groupMember, BooleanHolder isInActive) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupMember);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "askMemberStatus", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isInActive.value = TcUtility.queryArg(response.output[0], isInActive.value);
  }

  public void setMemberStatus(String groupMember, boolean isInActive) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupMember);
    args_[3] = TcUtility.createArg(isInActive);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "setMemberStatus", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void isDefaultRole(String groupMember, BooleanHolder isDefaultRole) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupMember);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "isDefaultRole", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isDefaultRole.value = TcUtility.queryArg(response.output[0], isDefaultRole.value);
  }

  public void setDefaultRole(String user, String group, String defaultRole) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(group);
    args_[4] = TcUtility.createArgStringUnion(defaultRole);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "setDefaultRole", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askDefaultRole(String user, String group, StringHolder defaultRole, StringHolder defaultRoleType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroupMember", "askDefaultRole", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    defaultRole.value = TcUtility.queryArg(response.output[0], defaultRole.value);
    defaultRoleType.value = TcUtility.queryArg(response.output[1], defaultRoleType.value);
  }

}
