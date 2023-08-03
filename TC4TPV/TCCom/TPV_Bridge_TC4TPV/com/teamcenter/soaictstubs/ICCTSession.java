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

public class ICCTSession {
  ICTService m_service;

  Connection m_connection;


  public ICCTSession(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public boolean login(String userName, String password, String groupName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArgStringUnion(userName);
    args_[1] = TcUtility.createArgStringUnion(password);
    args_[2] = TcUtility.createArgStringUnion(groupName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "login", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    boolean argValue_ =false;
    return (boolean) TcUtility.queryArg(response.output[0], argValue_);
  }

  public void logout(boolean suspension) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(suspension);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "logout", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getRelatedInfo(String[] relatedTypes, uidSeq_tHolder components, uidSeq_tHolder componentTypes, stringValueSeq_tHolder componentContextNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(relatedTypes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getRelatedInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
    componentTypes.value = TcUtility.queryArg(response.output[1], componentTypes.value);
    componentContextNames.value = TcUtility.queryArgStringUnion(response.output[2], componentContextNames.value);
  }

  public void getComponentFactoryInfo(String comp, StringHolder factoryName) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(comp);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getComponentFactoryInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    factoryName.value = TcUtility.queryArg(response.output[0], factoryName.value);
  }

  public void getComponentFactoriesInfo(String[] components, stringSeq_tHolder factoryNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(components);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getComponentFactoriesInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    factoryNames.value = TcUtility.queryArg(response.output[0], factoryNames.value);
  }

  public void getAvailableFactories(stringSeq_tHolder factoryNames) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getAvailableFactories", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    factoryNames.value = TcUtility.queryArg(response.output[0], factoryNames.value);
  }

  public void getAvailableServices(stringSeq_tHolder serviceNames) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getAvailableServices", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    serviceNames.value = TcUtility.queryArg(response.output[0], serviceNames.value);
  }

  public void registerClientFactories(String[] clientFactoryNames, String[] clientFactoryVersions, longValueSeq_tHolder unsupportedFactoryIndices) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(clientFactoryNames);
    args_[1] = TcUtility.createArg(clientFactoryVersions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "registerClientFactories", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    unsupportedFactoryIndices.value = TcUtility.queryArg(response.output[0], unsupportedFactoryIndices.value);
  }

  public void getFactory(String factoryName) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(factoryName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getFactory", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getFactoriesAndComponents(String[] typeUids, stringSeq_tHolder factoryNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(typeUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getFactoriesAndComponents", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    factoryNames.value = TcUtility.queryArg(response.output[0], factoryNames.value);
  }

  public void getAllServices(stringSeq_tHolder serviceNames) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getAllServices", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    serviceNames.value = TcUtility.queryArg(response.output[0], serviceNames.value);
  }

  public void getService(String serviceName) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(serviceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getService", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void registerClientServices(String[] clientServiceNames, String[] clientServiceVersions, longValueSeq_tHolder unsupportedServiceIndices) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(clientServiceNames);
    args_[1] = TcUtility.createArg(clientServiceVersions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "registerClientServices", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    unsupportedServiceIndices.value = TcUtility.queryArg(response.output[0], unsupportedServiceIndices.value);
  }

  public void getErrorStack(IntHolder errorCodeCount, longValueSeq_tHolder errorSeverities, longValueSeq_tHolder errorCodes, stringValueSeq_tHolder errorStrings) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getErrorStack", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errorCodeCount.value = TcUtility.queryArg(response.output[0], errorCodeCount.value);
    errorSeverities.value = TcUtility.queryArg(response.output[1], errorSeverities.value);
    errorCodes.value = TcUtility.queryArg(response.output[2], errorCodes.value);
    errorStrings.value = TcUtility.queryArgStringUnion(response.output[3], errorStrings.value);
  }

  public void getObjFromString(String tagString, StringHolder obj) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(tagString);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getObjFromString", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    obj.value = TcUtility.queryArg(response.output[0], obj.value);
  }

  public void getObjsFromStrings(String[] tagStrings, uidSeqValue_uHolder objs) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(tagStrings);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getObjsFromStrings", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objs.value = TcUtility.queryArg(response.output[0], objs.value);
  }

  public void getStringFromObj(String obj, StringHolder tagString) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getStringFromObj", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    tagString.value = TcUtility.queryArg(response.output[0], tagString.value);
  }

  public void getStringsFromObjs(String[] objects, stringValueSeq_tHolder tagStrings) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objects);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getStringsFromObjs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    tagStrings.value = TcUtility.queryArgStringUnion(response.output[0], tagStrings.value);
  }

  public void convertTagsToUids(int[] tags, uidSeqValue_uHolder uids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(tags);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "convertTagsToUids", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uids.value = TcUtility.queryArg(response.output[0], uids.value);
  }

  public void convertUidsToTags(String[] uids, tagSeqValue_uHolder tags) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(uids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "convertUidsToTags", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    tags.value = TcUtility.queryArg(response.output[0], tags.value);
  }

  public void convertUidsArrayToTagsArray(String[][] uidsArray, tagSeqSeq_tHolder tagsArray) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(uidsArray);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "convertUidsArrayToTagsArray", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    tagsArray.value = TcUtility.queryArg(response.output[0], tagsArray.value);
  }

  public void getObjectType(String obj, StringHolder typeObj) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getObjectType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeObj.value = TcUtility.queryArg(response.output[0], typeObj.value);
  }

  public void getObjectTypeName(String ob, StringHolder typeName) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(ob);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getObjectTypeName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeName.value = TcUtility.queryArg(response.output[0], typeName.value);
  }

  public void getObjectTypes(String[] objs, uidSeq_tHolder typeObjs) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getObjectTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeObjs.value = TcUtility.queryArg(response.output[0], typeObjs.value);
  }

  public void getObjectTypeNames(String[] objs, stringSeq_tHolder typeNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getObjectTypeNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeNames.value = TcUtility.queryArg(response.output[0], typeNames.value);
  }

  public void getUpdatedComponents(int option, uidSeqValue_uHolder changedObjs, stringSeqValue_uHolder changedProperties, uidSeqValue_uHolder deletedObjs, uidSeqValue_uHolder refreshNotifyObjs, uidSeqValue_uHolder refreshNotifyTypes, stringSeqValue_uHolder refreshNotifyEvents, booleanSeqValue_uHolder objectLoaded) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getUpdatedComponents", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    changedObjs.value = TcUtility.queryArg(response.output[0], changedObjs.value);
    changedProperties.value = TcUtility.queryArg(response.output[1], changedProperties.value);
    deletedObjs.value = TcUtility.queryArg(response.output[2], deletedObjs.value);
    refreshNotifyObjs.value = TcUtility.queryArg(response.output[3], refreshNotifyObjs.value);
    refreshNotifyTypes.value = TcUtility.queryArg(response.output[4], refreshNotifyTypes.value);
    refreshNotifyEvents.value = TcUtility.queryArg(response.output[5], refreshNotifyEvents.value);
    objectLoaded.value = TcUtility.queryArg(response.output[6], objectLoaded.value);
  }

  public void getUserSessionInformation(userSessionInfo_sHolder userSessionInfo) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getUserSessionInformation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    userSessionInfo.value = TcUtility.queryArg(response.output[0], userSessionInfo.value);
  }

  public void isUserSystemAdmin(BooleanHolder verdict) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "isUserSystemAdmin", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void isUserSystemMember(BooleanHolder verdict) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "isUserSystemMember", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void setCurrentGroupMember(String group, String role) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(group);
    args_[1] = TcUtility.createArg(role);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "setCurrentGroupMember", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setCurrentVolume(String volume) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(volume);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "setCurrentVolume", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void enableBypass(boolean state) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(state);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "enableBypass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void enableJournaling(boolean state) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(state);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "enableJournaling", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void enableApplicationJournaling(boolean state) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(state);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "enableApplicationJournaling", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void enableSecurityJournaling(boolean state) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(state);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "enableSecurityJournaling", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void enableAdministrationJournaling(boolean state) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(state);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "enableAdministrationJournaling", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getCurrentSite(StringHolder currentSite, StringHolder currentSiteType) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getCurrentSite", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    currentSite.value = TcUtility.queryArg(response.output[0], currentSite.value);
    currentSiteType.value = TcUtility.queryArg(response.output[1], currentSiteType.value);
  }

  public int placeMarkpoint(String[] typeNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(typeNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "placeMarkpoint", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    int argValue_ =0;
    return (int) TcUtility.queryArg(response.output[0], argValue_);
  }

  public boolean rollToMarkpoint(int markpoint) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(markpoint);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "rollToMarkpoint", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    boolean argValue_ =false;
    return (boolean) TcUtility.queryArg(response.output[0], argValue_);
  }

  public void forgetMarkpoint(int markpoint) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(markpoint);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "forgetMarkpoint", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public boolean isInV7Mode() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "isInV7Mode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    boolean argValue_ =false;
    return (boolean) TcUtility.queryArg(response.output[0], argValue_);
  }

  public void heartbeat() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "heartbeat", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getPDIServerIOR(StringHolder ior) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getPDIServerIOR", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ior.value = TcUtility.queryArgStringUnion(response.output[0], ior.value);
  }

  public void getClientsConnected(IntHolder client) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getClientsConnected", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    client.value = TcUtility.queryArg(response.output[0], client.value);
  }

  public void listLoginUsers(ListUsersSeq_tHolder users, BooleanHolder deadUserPresent) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "listLoginUsers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    users.value = TcUtility.queryArg(response.output[0], users.value);
    deadUserPresent.value = TcUtility.queryArg(response.output[1], deadUserPresent.value);
  }

  public void clearDeadUsers(ListUsersSeq_tHolder users) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "clearDeadUsers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    users.value = TcUtility.queryArg(response.output[0], users.value);
  }

  public void getServerConfigInfo(StringHolder serverId, StringHolder webKey, StringHolder tcData, StringHolder tcRoot, StringHolder tcDBConnect) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getServerConfigInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    serverId.value = TcUtility.queryArgStringUnion(response.output[0], serverId.value);
    webKey.value = TcUtility.queryArgStringUnion(response.output[1], webKey.value);
    tcData.value = TcUtility.queryArgStringUnion(response.output[2], tcData.value);
    tcRoot.value = TcUtility.queryArgStringUnion(response.output[3], tcRoot.value);
    tcDBConnect.value = TcUtility.queryArgStringUnion(response.output[4], tcDBConnect.value);
  }

  public void getSessionCookie(StringHolder sessionCookie) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getSessionCookie", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    sessionCookie.value = TcUtility.queryArgStringUnion(response.output[0], sessionCookie.value);
  }

  public void setCurrentWorkContext(String workContext) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(workContext);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "setCurrentWorkContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setCurrentProject(String project) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(project);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "setCurrentProject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTransientVolRootDir(StringHolder path) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getTransientVolRootDir", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    path.value = TcUtility.queryArg(response.output[0], path.value);
  }

  public void isNXManagerRunning(BooleanHolder verdict) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "isNXManagerRunning", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void getRACCorbaSessionInfo(String[] typeNames, uidSeq_tHolder typeUids, stringSeq_tHolder allFactoryNames, stringSeq_tHolder factoryNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(typeNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSession", "getRACCorbaSessionInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeUids.value = TcUtility.queryArg(response.output[0], typeUids.value);
    allFactoryNames.value = TcUtility.queryArg(response.output[1], allFactoryNames.value);
    factoryNames.value = TcUtility.queryArg(response.output[2], factoryNames.value);
  }

}
