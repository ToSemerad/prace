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

public class ICCSApplicationObject {
  ICTService m_service;

  String m_typeName;

  String m_objectUid;

  Connection m_connection;


  public ICCSApplicationObject(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public ICCSApplicationObject(Connection connection, String typeName, String objectUid) {
    m_service = ICTService.getService( connection );
    m_typeName = typeName;
    m_objectUid = objectUid;
    m_connection = connection;
  }

  public void setObjectUid(String objectUid) {
    m_objectUid= objectUid;
  }

  public String getObjectUid() {
    return m_objectUid;
  }

  public void setTypeName(String typeName) {
    m_typeName = typeName;
  }

  public String getTypeName() {
    return m_typeName;
  }

  public void askAppProperty(int ics_ddid, StringHolder appProperty) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ics_ddid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "askAppProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    appProperty.value = TcUtility.queryArgStringUnion(response.output[0], appProperty.value);
  }

  public void setAppProperty(int ics_ddid, String appProperty) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ics_ddid);
    args_[3] = TcUtility.createArg(appProperty);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "setAppProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askChildren(String nodeID, stringSeq_tHolder children) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(nodeID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "askChildren", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    children.value = TcUtility.queryArg(response.output[0], children.value);
  }

  public void askParentNode(String nodeID, StringHolder parentNode) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(nodeID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "askParentNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    parentNode.value = TcUtility.queryArgStringUnion(response.output[0], parentNode.value);
  }

  public void setOption(String name, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArg(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "setOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void search(ICSProperty_s[] iccsPropLst, IntHolder n_instances) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(iccsPropLst);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "search", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    n_instances.value = TcUtility.queryArg(response.output[0], n_instances.value);
  }

  public void searchOption(ICSProperty_s[] iccsPropLst, int findOption, IntHolder n_instances) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(iccsPropLst);
    args_[3] = TcUtility.createArg(findOption);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "searchOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    n_instances.value = TcUtility.queryArg(response.output[0], n_instances.value);
  }

  public void searchID(String id, String erefUid, IntHolder n_instances) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(id);
    args_[3] = TcUtility.createArgStringUnion(erefUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "searchID", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    n_instances.value = TcUtility.queryArg(response.output[0], n_instances.value);
  }

  public void searchById(String theIcoId, String theWsoUid, int theOptions, IntHolder theCount, stringSeqValue_uHolder theIcoIds, stringSeqValue_uHolder theClassIds, uidSeqValue_uHolder theIcoUids, uidSeqValue_uHolder theWsoUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theIcoId);
    args_[3] = TcUtility.createArgStringUnion(theWsoUid);
    args_[4] = TcUtility.createArg(theOptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "searchById", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCount.value = TcUtility.queryArg(response.output[0], theCount.value);
    theIcoIds.value = TcUtility.queryArg(response.output[1], theIcoIds.value);
    theClassIds.value = TcUtility.queryArg(response.output[2], theClassIds.value);
    theIcoUids.value = TcUtility.queryArg(response.output[3], theIcoUids.value);
    theWsoUids.value = TcUtility.queryArg(response.output[4], theWsoUids.value);
  }

  public void searchByAttributes(String theClassId, ICSProperty_s[] theProperties, int theOptions, IntHolder theCount, stringSeqValue_uHolder theIcoIds, stringSeqValue_uHolder theClassIds, uidSeqValue_uHolder theIcoUids, uidSeqValue_uHolder theWsoUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theClassId);
    args_[3] = TcUtility.createArg(theProperties);
    args_[4] = TcUtility.createArg(theOptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "searchByAttributes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCount.value = TcUtility.queryArg(response.output[0], theCount.value);
    theIcoIds.value = TcUtility.queryArg(response.output[1], theIcoIds.value);
    theClassIds.value = TcUtility.queryArg(response.output[2], theClassIds.value);
    theIcoUids.value = TcUtility.queryArg(response.output[3], theIcoUids.value);
    theWsoUids.value = TcUtility.queryArg(response.output[4], theWsoUids.value);
  }

  public void loadProperties(String theIcoUid, String theClassId, icspropSeqHolder theClassProperties, icspropSeqHolder theSystemProperties) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theIcoUid);
    args_[3] = TcUtility.createArg(theClassId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "loadProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theClassProperties.value = TcUtility.queryArg(response.output[0], theClassProperties.value);
    theSystemProperties.value = TcUtility.queryArg(response.output[1], theSystemProperties.value);
  }

  public void loadPropertiesList(uidSeqValue_u theIcoUids, String theClassId, icspropSeqHolder theClassProperties, icspropSeqHolder theSystemProperties) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theIcoUids);
    args_[3] = TcUtility.createArg(theClassId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "loadPropertiesList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theClassProperties.value = TcUtility.queryArg(response.output[0], theClassProperties.value);
    theSystemProperties.value = TcUtility.queryArg(response.output[1], theSystemProperties.value);
  }

  public void initialize(int initOption) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(initOption);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "initialize", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void newInstance(String resourceId, String wsObjectUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(resourceId);
    args_[3] = TcUtility.createArgStringUnion(wsObjectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "newInstance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void copyInstance(String resourceId, String wsObjectUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(resourceId);
    args_[3] = TcUtility.createArgStringUnion(wsObjectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "copyInstance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void editInstance() throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "editInstance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void saveInstance() throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "saveInstance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deleteInstance() throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "deleteInstance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void cancelInstance() throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "cancelInstance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askView(String whichView, ICSViewHeader_sHolder viewHeader, icsviewattrSeqHolder viewProperties) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(whichView);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "askView", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    viewHeader.value = TcUtility.queryArg(response.output[0], viewHeader.value);
    viewProperties.value = TcUtility.queryArg(response.output[1], viewProperties.value);
  }

  public void setProperty(String objectSelectorUid, ICSProperty_s icsProperty) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(objectSelectorUid);
    args_[3] = TcUtility.createArg(icsProperty);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "setProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setProperties(String objectSelectorUid, ICSProperty_s[] icsProperties) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(objectSelectorUid);
    args_[3] = TcUtility.createArg(icsProperties);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "setProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askProperty(String objectSelectorUid, int propId, ICSProperty_sHolder icsProperty) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(objectSelectorUid);
    args_[3] = TcUtility.createArg(propId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "askProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    icsProperty.value = TcUtility.queryArg(response.output[0], icsProperty.value);
  }

  public void askProperties(int objectSelector, icspropSeqHolder icsProperties) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectSelector);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "askProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    icsProperties.value = TcUtility.queryArg(response.output[0], icsProperties.value);
  }

  public void describeViewProperties(String queryName, String option, longSeqValue_uHolder values, stringSeqValue_uHolder options) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(queryName);
    args_[3] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "describeViewProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArg(response.output[0], values.value);
    options.value = TcUtility.queryArg(response.output[1], options.value);
  }

  public void askPFTMappings(pftMappingIdSeq_tHolder thePftMappings, BooleanHolder tclScriptEvaluationEnabled) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "askPFTMappings", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    thePftMappings.value = TcUtility.queryArg(response.output[0], thePftMappings.value);
    tclScriptEvaluationEnabled.value = TcUtility.queryArg(response.output[1], tclScriptEvaluationEnabled.value);
  }

  public void askPftMappingId(pftMappingIdValue_uHolder thePftMappingId) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "askPftMappingId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    thePftMappingId.value = TcUtility.queryArg(response.output[0], thePftMappingId.value);
  }

  public void mapICO(String theTargetItemID, String theTargetItemName, String theTargetItemTypeName, String theTargetItemRevID, String theTargetItemDescription, String theTargetClassID, int theOptions, StringHolder theNewICOUid) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theTargetItemID);
    args_[3] = TcUtility.createArg(theTargetItemName);
    args_[4] = TcUtility.createArg(theTargetItemTypeName);
    args_[5] = TcUtility.createArg(theTargetItemRevID);
    args_[6] = TcUtility.createArg(theTargetItemDescription);
    args_[7] = TcUtility.createArg(theTargetClassID);
    args_[8] = TcUtility.createArg(theOptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "mapICO", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theNewICOUid.value = TcUtility.queryArg(response.output[0], theNewICOUid.value);
  }

  public void setPropertyValue(ICSProperty_s iccsProp) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(iccsProp);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "setPropertyValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPropertyVal(int ics_ddid, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ics_ddid);
    args_[3] = TcUtility.createArg(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "setPropertyVal", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setAllPropertyValues(ICSProperty_s[] iccsPropLst) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(iccsPropLst);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "setAllPropertyValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askPropertyValue(int ics_ddid, ICSProperty_sHolder iccsProp) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ics_ddid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "askPropertyValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iccsProp.value = TcUtility.queryArg(response.output[0], iccsProp.value);
  }

  public void askAllPropertyValues(icspropSeqHolder iccsPropLst) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "askAllPropertyValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iccsPropLst.value = TcUtility.queryArg(response.output[0], iccsPropLst.value);
  }

  public void evaluateTclScript() throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "evaluateTclScript", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void savePFTMember(String uid, boolean createPartFile, boolean createJTFile, int theOptions) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(uid);
    args_[3] = TcUtility.createArg(createPartFile);
    args_[4] = TcUtility.createArg(createJTFile);
    args_[5] = TcUtility.createArg(theOptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSApplicationObject", "savePFTMember", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
