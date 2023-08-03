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

public class ICCTGroup extends ICCT {
  public ICCTGroup(Connection connection) {
    super(connection);
  }

  public ICCTGroup(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String groupName, String groupDesc, boolean privilege, String defaultVolume, String defaultLocalVolume, String parentGroup, String groupSecurity, StringHolder newGroup, StringHolder newGroupType) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupName);
    args_[3] = TcUtility.createArgStringUnion(groupDesc);
    args_[4] = TcUtility.createArg(privilege);
    args_[5] = TcUtility.createArgStringUnion(defaultVolume);
    args_[6] = TcUtility.createArgStringUnion(defaultLocalVolume);
    args_[7] = TcUtility.createArgStringUnion(parentGroup);
    args_[8] = TcUtility.createArgStringUnion(groupSecurity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newGroup.value = TcUtility.queryArg(response.output[0], newGroup.value);
    newGroupType.value = TcUtility.queryArg(response.output[1], newGroupType.value);
  }

  public void find(String groupName, StringHolder group, StringHolder groupType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    group.value = TcUtility.queryArgStringUnion(response.output[0], group.value);
    groupType.value = TcUtility.queryArgStringUnion(response.output[1], groupType.value);
  }

  public void getFullName(String group, StringHolder fullGroupName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getFullName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fullGroupName.value = TcUtility.queryArg(response.output[0], fullGroupName.value);
  }

  public void addRole(String group, String role) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    args_[3] = TcUtility.createArg(role);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "addRole", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeRole(String group, String role) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    args_[3] = TcUtility.createArg(role);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "removeRole", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getRoles(String groupTag, uidSeqValue_uHolder roles, uidSeqValue_uHolder roleTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getRoles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    roles.value = TcUtility.queryArg(response.output[0], roles.value);
    roleTypes.value = TcUtility.queryArg(response.output[1], roleTypes.value);
  }

  public void getRootGroups(uidSeqValue_uHolder rootGroups, uidSeqValue_uHolder groupTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getRootGroups", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rootGroups.value = TcUtility.queryArg(response.output[0], rootGroups.value);
    groupTypes.value = TcUtility.queryArg(response.output[1], groupTypes.value);
  }

  public void getGroupAndIconIdList(stringSeqValue_uHolder groupList, stringSeqValue_uHolder groupSiteList, longSeqValue_uHolder groupIconIdList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getGroupAndIconIdList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    groupList.value = TcUtility.queryArg(response.output[0], groupList.value);
    groupSiteList.value = TcUtility.queryArg(response.output[1], groupSiteList.value);
    groupIconIdList.value = TcUtility.queryArg(response.output[2], groupIconIdList.value);
  }

  public void getMappedGroupAttrList(stringSeqValue_uHolder mapped_group_attr_list) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getMappedGroupAttrList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mapped_group_attr_list.value = TcUtility.queryArg(response.output[0], mapped_group_attr_list.value);
  }

  public void getRootGroupAndIconIdList(stringSeqValue_uHolder rootgroupList, stringSeqValue_uHolder rootGroupSiteList, longSeqValue_uHolder rootGroupIconIdList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getRootGroupAndIconIdList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rootgroupList.value = TcUtility.queryArg(response.output[0], rootgroupList.value);
    rootGroupSiteList.value = TcUtility.queryArg(response.output[1], rootGroupSiteList.value);
    rootGroupIconIdList.value = TcUtility.queryArg(response.output[2], rootGroupIconIdList.value);
  }

  public void getChildGroupAndIconIdList(String childGroupName, stringSeqValue_uHolder childGroupList, stringSeqValue_uHolder childGroupSiteList, longSeqValue_uHolder childGroupIconIdList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(childGroupName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getChildGroupAndIconIdList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    childGroupList.value = TcUtility.queryArg(response.output[0], childGroupList.value);
    childGroupSiteList.value = TcUtility.queryArg(response.output[1], childGroupSiteList.value);
    childGroupIconIdList.value = TcUtility.queryArg(response.output[2], childGroupIconIdList.value);
  }

  public void getRoleAndIconIdListForGroup(String groupFullName, stringSeqValue_uHolder roleNameList, stringSeqValue_uHolder roleGroupSiteList, longSeqValue_uHolder roleGroupIconIdList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupFullName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getRoleAndIconIdListForGroup", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    roleNameList.value = TcUtility.queryArg(response.output[0], roleNameList.value);
    roleGroupSiteList.value = TcUtility.queryArg(response.output[1], roleGroupSiteList.value);
    roleGroupIconIdList.value = TcUtility.queryArg(response.output[2], roleGroupIconIdList.value);
  }

  public void getChildGroups(String group, uidSeqValue_uHolder childGroups, uidSeqValue_uHolder groupTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getChildGroups", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    childGroups.value = TcUtility.queryArg(response.output[0], childGroups.value);
    groupTypes.value = TcUtility.queryArg(response.output[1], groupTypes.value);
  }

  public void getRolesAndChildGroups(String groupTag, uidSeqValue_uHolder roleAndGroups, uidSeqValue_uHolder objTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getRolesAndChildGroups", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    roleAndGroups.value = TcUtility.queryArg(response.output[0], roleAndGroups.value);
    objTypes.value = TcUtility.queryArg(response.output[1], objTypes.value);
  }

  public void getGroupNames(stringSeqValue_uHolder groupList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getGroupNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    groupList.value = TcUtility.queryArg(response.output[0], groupList.value);
  }

  public void getRootGroupNames(stringSeqValue_uHolder groupList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getRootGroupNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    groupList.value = TcUtility.queryArg(response.output[0], groupList.value);
  }

  public void getChildGroupNames(String groupName, stringSeqValue_uHolder groupList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getChildGroupNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    groupList.value = TcUtility.queryArg(response.output[0], groupList.value);
  }

  public void getRoleNames(String groupName, stringSeqValue_uHolder groupList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getRoleNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    groupList.value = TcUtility.queryArg(response.output[0], groupList.value);
  }

  public void getRoleNamesAndChildGroupNames(String groupName, stringSeqValue_uHolder memberList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getRoleNamesAndChildGroupNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    memberList.value = TcUtility.queryArg(response.output[0], memberList.value);
  }

  public void addRoles(String[] roles, String groupTag) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(roles);
    args_[3] = TcUtility.createArg(groupTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "addRoles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeRoles(String[] roles, String groupTag) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(roles);
    args_[3] = TcUtility.createArg(groupTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "removeRoles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeParent(String[] groups) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groups);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "removeParent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addChildGroups(String[] childGroups, String group) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(childGroups);
    args_[3] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "addChildGroups", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getGroupInfo(String group, StringHolder groupName, StringHolder groupDesc, BooleanHolder groupPrivilege) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getGroupInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    groupName.value = TcUtility.queryArg(response.output[0], groupName.value);
    groupDesc.value = TcUtility.queryArgStringUnion(response.output[1], groupDesc.value);
    groupPrivilege.value = TcUtility.queryArg(response.output[2], groupPrivilege.value);
  }

  public void setGroupInfo(String group, String groupName, String groupDesc, boolean groupPrivilege) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    args_[3] = TcUtility.createArg(groupName);
    args_[4] = TcUtility.createArgStringUnion(groupDesc);
    args_[5] = TcUtility.createArg(groupPrivilege);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "setGroupInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setGroupName(String group, String groupName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    args_[3] = TcUtility.createArg(groupName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "setGroupName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setGroupDesc(String group, String groupDesc) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    args_[3] = TcUtility.createArgStringUnion(groupDesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "setGroupDesc", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setGroupPrivilege(String group, boolean privilege) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    args_[3] = TcUtility.createArg(privilege);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "setGroupPrivilege", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setGroupDefaultVolume(String group, String defaultVolume) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    args_[3] = TcUtility.createArgStringUnion(defaultVolume);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "setGroupDefaultVolume", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setGroupDefaultLocalVolume(String group, String defaultLocalVolume) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    args_[3] = TcUtility.createArgStringUnion(defaultLocalVolume);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "setGroupDefaultLocalVolume", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getDefaultRole(String group, StringHolder role, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGroup", "getDefaultRole", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    role.value = TcUtility.queryArg(response.output[0], role.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

}
