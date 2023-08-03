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

public class ICCTUser extends ICCT {
  public ICCTUser(Connection connection) {
    super(connection);
  }

  public ICCTUser(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String userID, String personName, String password, String osUserName, int licenseLevel, String licenseBundle, String licenseServer, int status, String defaultGroup, String role, String defaultVolume, String defaultLocalVolume, StringHolder newUser, StringHolder newUserType) throws Exception {
    Arg[] args_ = new Arg[14];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(userID);
    args_[3] = TcUtility.createArg(personName);
    args_[4] = TcUtility.createArg(password);
    args_[5] = TcUtility.createArg(osUserName);
    args_[6] = TcUtility.createArg(licenseLevel);
    args_[7] = TcUtility.createArg(licenseBundle);
    args_[8] = TcUtility.createArg(licenseServer);
    args_[9] = TcUtility.createArg(status);
    args_[10] = TcUtility.createArg(defaultGroup);
    args_[11] = TcUtility.createArgStringUnion(role);
    args_[12] = TcUtility.createArgStringUnion(defaultVolume);
    args_[13] = TcUtility.createArgStringUnion(defaultLocalVolume);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newUser.value = TcUtility.queryArg(response.output[0], newUser.value);
    newUserType.value = TcUtility.queryArg(response.output[1], newUserType.value);
  }

  public void find(String userID, StringHolder user, StringHolder userType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(userID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    user.value = TcUtility.queryArgStringUnion(response.output[0], user.value);
    userType.value = TcUtility.queryArgStringUnion(response.output[1], userType.value);
  }

  public void changePassword(String user, String newPassword, String oldPassword) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(newPassword);
    args_[4] = TcUtility.createArg(oldPassword);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "changePassword", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void checkPassword(String user, String password, BooleanHolder passwordCorrect) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(password);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "checkPassword", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    passwordCorrect.value = TcUtility.queryArg(response.output[0], passwordCorrect.value);
  }

  public void getGroupMembers(String user, uidSeqValue_uHolder members, uidSeqValue_uHolder memberTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "getGroupMembers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    members.value = TcUtility.queryArg(response.output[0], members.value);
    memberTypes.value = TcUtility.queryArg(response.output[1], memberTypes.value);
  }

  public void getUserInformation(String user, StringHolder person, StringHolder personType, StringHolder defaultGroup, StringHolder defaultGroupType, StringHolder defaultVolume, StringHolder defaultVolumeType, StringHolder defaultLocalVolume, StringHolder defaultLocalVolumeType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "getUserInformation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    person.value = TcUtility.queryArg(response.output[0], person.value);
    personType.value = TcUtility.queryArg(response.output[1], personType.value);
    defaultGroup.value = TcUtility.queryArg(response.output[2], defaultGroup.value);
    defaultGroupType.value = TcUtility.queryArg(response.output[3], defaultGroupType.value);
    defaultVolume.value = TcUtility.queryArg(response.output[4], defaultVolume.value);
    defaultVolumeType.value = TcUtility.queryArg(response.output[5], defaultVolumeType.value);
    defaultLocalVolume.value = TcUtility.queryArg(response.output[6], defaultLocalVolume.value);
    defaultLocalVolumeType.value = TcUtility.queryArg(response.output[7], defaultLocalVolumeType.value);
  }

  public void setPerson(String user, String person) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(person);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "setPerson", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDefaultGroup(String user, String group) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "setDefaultGroup", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDefaultVolume(String user, String volume) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArgStringUnion(volume);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "setDefaultVolume", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDefaultLocalVolume(String user, String localVolume) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArgStringUnion(localVolume);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "setDefaultLocalVolume", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setOSUserName(String user, String osName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(osName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "setOSUserName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setUserID(String user, String userId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(userId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "setUserID", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void resetLastLoginTime(String user) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "resetLastLoginTime", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deleteUser(String user, String newUser, String newGroup) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArgStringUnion(newUser);
    args_[4] = TcUtility.createArgStringUnion(newGroup);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "deleteUser", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void activateUser(String user) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "activateUser", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deactivateUser(String user, String newUser, String newGroup) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArgStringUnion(newUser);
    args_[4] = TcUtility.createArgStringUnion(newGroup);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "deactivateUser", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void initializeUser(String user, String userId, String userName, String osName, String password, String defaultGroup, String defaultVolume, String defaultLocalVolume) throws Exception {
    Arg[] args_ = new Arg[10];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(userId);
    args_[4] = TcUtility.createArg(userName);
    args_[5] = TcUtility.createArg(osName);
    args_[6] = TcUtility.createArg(password);
    args_[7] = TcUtility.createArg(defaultGroup);
    args_[8] = TcUtility.createArgStringUnion(defaultVolume);
    args_[9] = TcUtility.createArgStringUnion(defaultLocalVolume);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "initializeUser", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getUserListByUser(String userName, stringSeqValue_uHolder userList, stringSeqValue_uHolder userIdList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(userName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "getUserListByUser", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    userList.value = TcUtility.queryArg(response.output[0], userList.value);
    userIdList.value = TcUtility.queryArg(response.output[1], userIdList.value);
  }

  public void getUserAndIconIdListByUser(String userName, stringSeqValue_uHolder userList, stringSeqValue_uHolder userIdList, stringSeqValue_uHolder userSiteList, longSeqValue_uHolder userIconIdList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(userName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "getUserAndIconIdListByUser", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    userList.value = TcUtility.queryArg(response.output[0], userList.value);
    userIdList.value = TcUtility.queryArg(response.output[1], userIdList.value);
    userSiteList.value = TcUtility.queryArg(response.output[2], userSiteList.value);
    userIconIdList.value = TcUtility.queryArg(response.output[3], userIconIdList.value);
  }

  public void getMappedUserAttrList(stringSeqValue_uHolder mapped_user_attr_list) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "getMappedUserAttrList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mapped_user_attr_list.value = TcUtility.queryArg(response.output[0], mapped_user_attr_list.value);
  }

  public void getUserListByRole(String roleName, stringSeqValue_uHolder userList, stringSeqValue_uHolder userIdList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(roleName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "getUserListByRole", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    userList.value = TcUtility.queryArg(response.output[0], userList.value);
    userIdList.value = TcUtility.queryArg(response.output[1], userIdList.value);
  }

  public void getUserListByGroup(String groupName, stringSeqValue_uHolder userList, stringSeqValue_uHolder userIdList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(groupName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "getUserListByGroup", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    userList.value = TcUtility.queryArg(response.output[0], userList.value);
    userIdList.value = TcUtility.queryArg(response.output[1], userIdList.value);
  }

  public void getUserList(String userName, String groupName, String roleName, stringSeqValue_uHolder userList, stringSeqValue_uHolder userIdList) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(userName);
    args_[3] = TcUtility.createArgStringUnion(groupName);
    args_[4] = TcUtility.createArgStringUnion(roleName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "getUserList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    userList.value = TcUtility.queryArg(response.output[0], userList.value);
    userIdList.value = TcUtility.queryArg(response.output[1], userIdList.value);
  }

  public void getQueries(String userTag, int getType, uidSeqValue_uHolder querys, uidSeqValue_uHolder queryTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(userTag);
    args_[3] = TcUtility.createArg(getType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "getQueries", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    querys.value = TcUtility.queryArg(response.output[0], querys.value);
    queryTypes.value = TcUtility.queryArg(response.output[1], queryTypes.value);
  }

  public void setSurrogates(String userTag, String[] surrogates, String[] startDates, String[] endDates) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(userTag);
    args_[3] = TcUtility.createArg(surrogates);
    args_[4] = TcUtility.createArg(startDates);
    args_[5] = TcUtility.createArg(endDates);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "setSurrogates", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeSurrogate(String userTag, String surogateTag, uidSeqValue_uHolder claimedTasks, uidSeqValue_uHolder taskTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(userTag);
    args_[3] = TcUtility.createArg(surogateTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "removeSurrogate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    claimedTasks.value = TcUtility.queryArg(response.output[0], claimedTasks.value);
    taskTypes.value = TcUtility.queryArg(response.output[1], taskTypes.value);
  }

  public void getSurrogatesInfo(String userTag, uidSeqValue_uHolder surrogateUsers, uidSeqValue_uHolder surrogateUserTypes, stringSeqValue_uHolder startDates, stringSeqValue_uHolder endDates) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(userTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTUser", "getSurrogatesInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    surrogateUsers.value = TcUtility.queryArg(response.output[0], surrogateUsers.value);
    surrogateUserTypes.value = TcUtility.queryArg(response.output[1], surrogateUserTypes.value);
    startDates.value = TcUtility.queryArg(response.output[2], startDates.value);
    endDates.value = TcUtility.queryArg(response.output[3], endDates.value);
  }

}
