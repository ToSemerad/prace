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

public class ICCSService {
  ICTService m_service;

  Connection m_connection;


  public ICCSService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void newICCSApplication(String icsApplName, ICCSApplicationObjectHolder iccsApplication) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(icsApplName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "newICCSApplication", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iccsApplication.value = new ICCSApplicationObject( m_connection, "ICCSApplicationObject", response.output[0].val);
  }

  public void freeICCSApplication(ICCSApplicationObject iccsApplication) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = new Arg();
    args_[0].val = iccsApplication.getObjectUid();
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "freeICCSApplication", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void newICCSGCSService() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "newICCSGCSService", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void freeICCSGCSService() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "freeICCSGCSService", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void newICCSDictionary(ICCSDictionaryHolder iccsDict) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "newICCSDictionary", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iccsDict.value = new ICCSDictionary( m_connection, "ICCSDictionary", response.output[0].val);
  }

  public void freeICCSDictionary(ICCSDictionary iccsDict) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = new Arg();
    args_[0].val = iccsDict.getObjectUid();
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "freeICCSDictionary", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void newICCSKeyLov(ICCSKeyLovHolder iccsLov) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "newICCSKeyLov", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iccsLov.value = new ICCSKeyLov( m_connection, "ICCSKeyLov", response.output[0].val);
  }

  public void freeICCSKeyLov(ICCSKeyLov iccsLov) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = new Arg();
    args_[0].val = iccsLov.getObjectUid();
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "freeICCSKeyLov", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void newICCSClass(ICCSClassHolder iccsClasses) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "newICCSClass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iccsClasses.value = new ICCSClass( m_connection, "ICCSClass", response.output[0].val);
  }

  public void freeICCSClass(ICCSClass iccsClasses) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = new Arg();
    args_[0].val = iccsClasses.getObjectUid();
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "freeICCSClass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void newICCSView(ICCSViewHolder iccsViews) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "newICCSView", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iccsViews.value = new ICCSView( m_connection, "ICCSView", response.output[0].val);
  }

  public void freeICCSView(ICCSView iccsViews) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = new Arg();
    args_[0].val = iccsViews.getObjectUid();
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "freeICCSView", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void newICCSData(ICCSDataHolder iccsDatas) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "newICCSData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iccsDatas.value = new ICCSData( m_connection, "ICCSData", response.output[0].val);
  }

  public void freeICCSData(ICCSData iccsDatas) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = new Arg();
    args_[0].val = iccsDatas.getObjectUid();
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "freeICCSData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getPopupDefinition(int format, stringSeq_tHolder keys, stringSeq_tHolder values) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(format);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "getPopupDefinition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    keys.value = TcUtility.queryArg(response.output[0], keys.value);
    values.value = TcUtility.queryArg(response.output[1], values.value);
  }

  public void searchICOs(String theClassId, ICSProperty_s[] theProperties, int theOptions, IntHolder theCount, stringSeqValue_uHolder theIcoIds, stringSeqValue_uHolder theClassIds, stringSeqValue_uHolder theIcoUids, stringSeqValue_uHolder theWsoUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(theClassId);
    args_[1] = TcUtility.createArg(theProperties);
    args_[2] = TcUtility.createArg(theOptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "searchICOs", args_);
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

  public void loadICOs(String[] theICOUIDs, String theClass2loadAs, icoSeqHolder theICOs, longSeq_tHolder theErrors) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(theICOUIDs);
    args_[1] = TcUtility.createArg(theClass2loadAs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "loadICOs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theICOs.value = TcUtility.queryArg(response.output[0], theICOs.value);
    theErrors.value = TcUtility.queryArg(response.output[1], theErrors.value);
  }

  public void moveICOs(String[] theICOUIDs, String theTargetClassUid, longSeqValue_uHolder theErrorCodes, stringSeqValue_uHolder theErrorMessages, uidSeqValue_uHolder theErrorICOUids) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(theICOUIDs);
    args_[1] = TcUtility.createArg(theTargetClassUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "moveICOs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theErrorCodes.value = TcUtility.queryArg(response.output[0], theErrorCodes.value);
    theErrorMessages.value = TcUtility.queryArg(response.output[1], theErrorMessages.value);
    theErrorICOUids.value = TcUtility.queryArg(response.output[2], theErrorICOUids.value);
  }

  public void askProblemAttributesBeforeICOMove(String theTargetClassId, String[] theSourceClassIds, icspropSeqSeq_tHolder theProblemAttributes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(theTargetClassId);
    args_[1] = TcUtility.createArg(theSourceClassIds);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askProblemAttributesBeforeICOMove", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theProblemAttributes.value = TcUtility.queryArg(response.output[0], theProblemAttributes.value);
  }

  public void searchClass(String query, int resultStyle, stringSeq_tHolder classes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(query);
    args_[1] = TcUtility.createArg(resultStyle);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "searchClass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    classes.value = TcUtility.queryArg(response.output[0], classes.value);
  }

  public void searchHeaderObject(String query, int resultStyle, stringSeq_tHolder classes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(query);
    args_[1] = TcUtility.createArg(resultStyle);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "searchHeaderObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    classes.value = TcUtility.queryArg(response.output[0], classes.value);
  }

  public void askChildren(String nodeID, int sortOption, int countOptions, icschildrenSeqHolder children, BooleanHolder hasUnreadableChildren) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(nodeID);
    args_[1] = TcUtility.createArg(sortOption);
    args_[2] = TcUtility.createArg(countOptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askChildren", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    children.value = TcUtility.queryArg(response.output[0], children.value);
    hasUnreadableChildren.value = TcUtility.queryArg(response.output[1], hasUnreadableChildren.value);
  }

  public void describeNode(String theNodeId, int theOptions, ICSChildren_sHolder theClass) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(theNodeId);
    args_[1] = TcUtility.createArg(theOptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "describeNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theClass.value = TcUtility.queryArg(response.output[0], theClass.value);
  }

  public void askParent(String nodeID, StringHolder parentNode) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(nodeID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askParent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    parentNode.value = TcUtility.queryArgStringUnion(response.output[0], parentNode.value);
  }

  public void askAvailableMeasures(stringSeqValue_uHolder theMeasures) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askAvailableMeasures", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theMeasures.value = TcUtility.queryArg(response.output[0], theMeasures.value);
  }

  public void loadUnitDefinitions(String idKey, String idValue, String unitSystem, icsunitdefinitionSeqHolder units) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(idKey);
    args_[1] = TcUtility.createArg(idValue);
    args_[2] = TcUtility.createArg(unitSystem);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "loadUnitDefinitions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    units.value = TcUtility.queryArg(response.output[0], units.value);
  }

  public void isObjectClassified(String wsObjectUid, BooleanHolder isClassified) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(wsObjectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "isObjectClassified", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isClassified.value = TcUtility.queryArg(response.output[0], isClassified.value);
  }

  public void askClassificationObjects(String theWSObjectUid, uidSeqValue_uHolder theIcoUids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(theWSObjectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askClassificationObjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theIcoUids.value = TcUtility.queryArg(response.output[0], theIcoUids.value);
  }

  public void askActualClassifiedObject(String wsObjectUid, StringHolder actualClassifiedObjectUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(wsObjectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askActualClassifiedObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    actualClassifiedObjectUid.value = TcUtility.queryArg(response.output[0], actualClassifiedObjectUid.value);
  }

  public void isObjectClassifiable(String wsObjectUid, BooleanHolder classifiableType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(wsObjectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "isObjectClassifiable", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    classifiableType.value = TcUtility.queryArg(response.output[0], classifiableType.value);
  }

  public void icsFormatValue(int formatMethod, int format, String minimumValue, String maximumValue, String rawString, StringHolder formattedString) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(formatMethod);
    args_[1] = TcUtility.createArg(format);
    args_[2] = TcUtility.createArg(minimumValue);
    args_[3] = TcUtility.createArg(maximumValue);
    args_[4] = TcUtility.createArg(rawString);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "icsFormatValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    formattedString.value = TcUtility.queryArgStringUnion(response.output[0], formattedString.value);
  }

  public void icsAskFormatExampleStrings(int[] theFormats, stringValueSeq_tHolder theExampleStrings) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(theFormats);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "icsAskFormatExampleStrings", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theExampleStrings.value = TcUtility.queryArgStringUnion(response.output[0], theExampleStrings.value);
  }

  public void getImageReferenceNames(String datasetUid, stringSeq_tHolder referenceNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(datasetUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "getImageReferenceNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    referenceNames.value = TcUtility.queryArg(response.output[0], referenceNames.value);
  }

  public void askNodeUid(String nodeId, StringHolder nodeUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(nodeId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askNodeUid", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nodeUid.value = TcUtility.queryArg(response.output[0], nodeUid.value);
  }

  public void isNodeClassified(String nodeUid, BooleanHolder isClassified) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(nodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "isNodeClassified", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isClassified.value = TcUtility.queryArg(response.output[0], isClassified.value);
  }

  public void askDatasetForNode(String nodeUid, StringHolder datasetUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(nodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askDatasetForNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    datasetUid.value = TcUtility.queryArg(response.output[0], datasetUid.value);
  }

  public void classifyNode(String datasetUid, String nodeUid) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(datasetUid);
    args_[1] = TcUtility.createArg(nodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "classifyNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeNodeClassification(String datasetUid, String nodeUid) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(datasetUid);
    args_[1] = TcUtility.createArg(nodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "removeNodeClassification", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void checkAccessControl() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "checkAccessControl", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void refreshAccessControl() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "refreshAccessControl", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askRootRules(String theCid, String theSid, uidSeqValue_uHolder theRootUids, uidSeqValue_uHolder theTypeUids) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(theCid);
    args_[1] = TcUtility.createArg(theSid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askRootRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theRootUids.value = TcUtility.queryArg(response.output[0], theRootUids.value);
    theTypeUids.value = TcUtility.queryArg(response.output[1], theTypeUids.value);
  }

  public void askRootRule(String theCid, String theSid, boolean getIcoRule, StringHolder theRootUid, StringHolder theTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(theCid);
    args_[1] = TcUtility.createArg(theSid);
    args_[2] = TcUtility.createArg(getIcoRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askRootRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theRootUid.value = TcUtility.queryArg(response.output[0], theRootUid.value);
    theTypeUid.value = TcUtility.queryArg(response.output[1], theTypeUid.value);
  }

  public void askChildrenRules(String parentUid, String theId, boolean isClass, uidSeqValue_uHolder theChildrenUids, uidSeqValue_uHolder theTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(parentUid);
    args_[1] = TcUtility.createArg(theId);
    args_[2] = TcUtility.createArg(isClass);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askChildrenRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theChildrenUids.value = TcUtility.queryArg(response.output[0], theChildrenUids.value);
    theTypeUids.value = TcUtility.queryArg(response.output[1], theTypeUids.value);
  }

  public void removeChildlessRules(String[] theRuleUids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(theRuleUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "removeChildlessRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void xmlImport(String pathName, String fileName, int objectTypeFilter, boolean updFlag, boolean relCreateFlag) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(pathName);
    args_[1] = TcUtility.createArg(fileName);
    args_[2] = TcUtility.createArg(objectTypeFilter);
    args_[3] = TcUtility.createArg(updFlag);
    args_[4] = TcUtility.createArg(relCreateFlag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "xmlImport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void xmlExport(StringHolder outputFileLocation, int objectType, String objectId, int objectTypeFilter, int expObjOptions) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(objectType);
    args_[1] = TcUtility.createArg(objectId);
    args_[2] = TcUtility.createArg(objectTypeFilter);
    args_[3] = TcUtility.createArg(expObjOptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "xmlExport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outputFileLocation.value = TcUtility.queryArg(response.output[0], outputFileLocation.value);
  }

  public void xmlExportICOs(String[] theICOUids, String theConfig, int theOptions, String theFileName, stringSeqValue_uHolder theOutputFileLocations, stringSeqValue_uHolder theOutputFileTypes, stringSeqValue_uHolder theMessages) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(theICOUids);
    args_[1] = TcUtility.createArgStringUnion(theConfig);
    args_[2] = TcUtility.createArg(theOptions);
    args_[3] = TcUtility.createArgStringUnion(theFileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "xmlExportICOs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theOutputFileLocations.value = TcUtility.queryArg(response.output[0], theOutputFileLocations.value);
    theOutputFileTypes.value = TcUtility.queryArg(response.output[1], theOutputFileTypes.value);
    theMessages.value = TcUtility.queryArg(response.output[2], theMessages.value);
  }

  public void xmlExportClasses(String[] theClassIds, String theConfig, int theOptions, String theFileName, stringSeqValue_uHolder theOutputFileLocations, stringSeqValue_uHolder theOutputFileTypes, stringSeqValue_uHolder theMessages) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(theClassIds);
    args_[1] = TcUtility.createArgStringUnion(theConfig);
    args_[2] = TcUtility.createArg(theOptions);
    args_[3] = TcUtility.createArgStringUnion(theFileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "xmlExportClasses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theOutputFileLocations.value = TcUtility.queryArg(response.output[0], theOutputFileLocations.value);
    theOutputFileTypes.value = TcUtility.queryArg(response.output[1], theOutputFileTypes.value);
    theMessages.value = TcUtility.queryArg(response.output[2], theMessages.value);
  }

  public void askTclDefaultSettings(IntHolder defaultSetting, BooleanHolder isEnabled) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askTclDefaultSettings", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    defaultSetting.value = TcUtility.queryArg(response.output[0], defaultSetting.value);
    isEnabled.value = TcUtility.queryArg(response.output[1], isEnabled.value);
  }

  public void icsCommand(String theCommandName, stringSeqValue_u theParameter, stringSeqValue_uHolder theResult) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(theCommandName);
    args_[1] = TcUtility.createArg(theParameter);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "icsCommand", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theResult.value = TcUtility.queryArg(response.output[0], theResult.value);
  }

  public void getAllPopupDefinition(int theKeyLovId, stringSeq_tHolder theKeys, stringSeq_tHolder theValues, stringSeqValue_uHolder theDepkeys) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(theKeyLovId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "getAllPopupDefinition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theKeys.value = TcUtility.queryArg(response.output[0], theKeys.value);
    theValues.value = TcUtility.queryArg(response.output[1], theValues.value);
    theDepkeys.value = TcUtility.queryArg(response.output[2], theDepkeys.value);
  }

  public void createWSO4ICO(String theClassId, longSeqValue_u theAttrIds, stringSeqValue_u theAttrValues, int theOptions, StringHolder theNewICOTag) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(theClassId);
    args_[1] = TcUtility.createArg(theAttrIds);
    args_[2] = TcUtility.createArg(theAttrValues);
    args_[3] = TcUtility.createArg(theOptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "createWSO4ICO", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theNewICOTag.value = TcUtility.queryArg(response.output[0], theNewICOTag.value);
  }

  public void findValues(int[] theAttrIds, String[] theAttrExpression, int theOptions, int theAttributeId, stringSeqValue_uHolder theValues, longSeqValue_uHolder theValueCounts) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(theAttrIds);
    args_[1] = TcUtility.createArg(theAttrExpression);
    args_[2] = TcUtility.createArg(theOptions);
    args_[3] = TcUtility.createArg(theAttributeId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "findValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theValues.value = TcUtility.queryArg(response.output[0], theValues.value);
    theValueCounts.value = TcUtility.queryArg(response.output[1], theValueCounts.value);
  }

  public void classExists(String theClassId, BooleanHolder exists) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(theClassId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "classExists", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    exists.value = TcUtility.queryArg(response.output[0], exists.value);
  }

  public void createUniqueClassId(String theParentId, StringHolder uniqueclassId) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(theParentId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "createUniqueClassId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uniqueclassId.value = TcUtility.queryArgStringUnion(response.output[0], uniqueclassId.value);
  }

  public void getClassAliasNames(String theClassId, stringSeq_tHolder aliasNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(theClassId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "getClassAliasNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    aliasNames.value = TcUtility.queryArg(response.output[0], aliasNames.value);
  }

  public void askClassMappingSources(String theTargetClassId, int theViewType, stringSeqValue_uHolder theSourceClassIDs, stringSeqValue_uHolder theSourceClassNames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(theTargetClassId);
    args_[1] = TcUtility.createArg(theViewType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askClassMappingSources", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theSourceClassIDs.value = TcUtility.queryArg(response.output[0], theSourceClassIDs.value);
    theSourceClassNames.value = TcUtility.queryArg(response.output[1], theSourceClassNames.value);
  }

  public void askClassMappingTargets(String theSourceClassId, int theViewType, stringSeqValue_uHolder theTargetClassIDs, stringSeqValue_uHolder theTargetClassNames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(theSourceClassId);
    args_[1] = TcUtility.createArg(theViewType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "askClassMappingTargets", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theTargetClassIDs.value = TcUtility.queryArg(response.output[0], theTargetClassIDs.value);
    theTargetClassNames.value = TcUtility.queryArg(response.output[1], theTargetClassNames.value);
  }

  public void convertAttributeValues(stringSeqValue_u theAttributeIDs, stringSeqValue_u theInputUnits, stringSeqValue_u theInputValues, stringSeqValue_u theOutputUnits, int[] theOutputAttributeFormats, stringSeqValue_uHolder theOutputValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(theAttributeIDs);
    args_[1] = TcUtility.createArg(theInputUnits);
    args_[2] = TcUtility.createArg(theInputValues);
    args_[3] = TcUtility.createArg(theOutputUnits);
    args_[4] = TcUtility.createArg(theOutputAttributeFormats);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSService", "convertAttributeValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theOutputValues.value = TcUtility.queryArg(response.output[0], theOutputValues.value);
  }

}
