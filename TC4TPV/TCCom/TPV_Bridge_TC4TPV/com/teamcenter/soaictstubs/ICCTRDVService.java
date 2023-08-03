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

public class ICCTRDVService {
  ICTService m_service;

  Connection m_connection;


  public ICCTRDVService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getQPLBuilds(IntHolder noOfBuilds, stringSeq_tHolder buildInfo) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "getQPLBuilds", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfBuilds.value = TcUtility.queryArg(response.output[0], noOfBuilds.value);
    buildInfo.value = TcUtility.queryArg(response.output[1], buildInfo.value);
  }

  public void getQPLSchema(String buildInfo, stringSeq_tHolder schemaInfo) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(buildInfo);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "getQPLSchema", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    schemaInfo.value = TcUtility.queryArg(response.output[0], schemaInfo.value);
  }

  public void executeQPLFilter(String qplContext, String distance, String booleanOperator, int attrCount, stringSeqValue_u attNames, int optrCount, stringSeqValue_u optrNames, int valueCount, stringSeqValue_u valueNames, int zoneAttCount, stringSeqValue_u zoneAttNames, int zoneOpCount, stringSeqValue_u zoneOpNames, int occCount, stringSeqValue_u occTags, IntHolder resOccCount, stringSeq_tHolder resOccTags) throws Exception {
    Arg[] args_ = new Arg[15];
    args_[0] = TcUtility.createArgStringUnion(qplContext);
    args_[1] = TcUtility.createArgStringUnion(distance);
    args_[2] = TcUtility.createArgStringUnion(booleanOperator);
    args_[3] = TcUtility.createArg(attrCount);
    args_[4] = TcUtility.createArg(attNames);
    args_[5] = TcUtility.createArg(optrCount);
    args_[6] = TcUtility.createArg(optrNames);
    args_[7] = TcUtility.createArg(valueCount);
    args_[8] = TcUtility.createArg(valueNames);
    args_[9] = TcUtility.createArg(zoneAttCount);
    args_[10] = TcUtility.createArg(zoneAttNames);
    args_[11] = TcUtility.createArg(zoneOpCount);
    args_[12] = TcUtility.createArg(zoneOpNames);
    args_[13] = TcUtility.createArg(occCount);
    args_[14] = TcUtility.createArg(occTags);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "executeQPLFilter", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    resOccCount.value = TcUtility.queryArg(response.output[0], resOccCount.value);
    resOccTags.value = TcUtility.queryArg(response.output[1], resOccTags.value);
  }

  public void getExecuteQPLFilterCount(String qplContext, String distance, String booleanOperator, int attrCount, stringSeqValue_u attNames, int optrCount, stringSeqValue_u optrNames, int valueCount, stringSeqValue_u valueNames, int zoneAttCount, stringSeqValue_u zoneAttNames, int zoneOpCount, stringSeqValue_u zoneOpNames, int occCount, stringSeqValue_u occTags, IntHolder resOccCount, stringSeq_tHolder resOccTags) throws Exception {
    Arg[] args_ = new Arg[15];
    args_[0] = TcUtility.createArgStringUnion(qplContext);
    args_[1] = TcUtility.createArgStringUnion(distance);
    args_[2] = TcUtility.createArgStringUnion(booleanOperator);
    args_[3] = TcUtility.createArg(attrCount);
    args_[4] = TcUtility.createArg(attNames);
    args_[5] = TcUtility.createArg(optrCount);
    args_[6] = TcUtility.createArg(optrNames);
    args_[7] = TcUtility.createArg(valueCount);
    args_[8] = TcUtility.createArg(valueNames);
    args_[9] = TcUtility.createArg(zoneAttCount);
    args_[10] = TcUtility.createArg(zoneAttNames);
    args_[11] = TcUtility.createArg(zoneOpCount);
    args_[12] = TcUtility.createArg(zoneOpNames);
    args_[13] = TcUtility.createArg(occCount);
    args_[14] = TcUtility.createArg(occTags);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "getExecuteQPLFilterCount", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    resOccCount.value = TcUtility.queryArg(response.output[0], resOccCount.value);
    resOccTags.value = TcUtility.queryArg(response.output[1], resOccTags.value);
  }

  public void getInstallationAssemblies(int noOfBOMLines, String[] bomlines, IntHolder noOfVals, rdvInstallationAssembliesDataSeq_tHolder iaStructs) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(noOfBOMLines);
    args_[1] = TcUtility.createArgStringUnion(bomlines);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "getInstallationAssemblies", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfVals.value = TcUtility.queryArg(response.output[0], noOfVals.value);
    iaStructs.value = TcUtility.queryArg(response.output[1], iaStructs.value);
  }

  public void addObjectToContext(String objectToBeAddedToContext, IntHolder objectsAdded, uidSeqValue_uHolder objectUids, uidSeqValue_uHolder objectTypeUids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectToBeAddedToContext);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "addObjectToContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectsAdded.value = TcUtility.queryArg(response.output[0], objectsAdded.value);
    objectUids.value = TcUtility.queryArg(response.output[1], objectUids.value);
    objectTypeUids.value = TcUtility.queryArg(response.output[2], objectTypeUids.value);
  }

  public void getVariableVariantOptions(int noOfBOMLines, String[] bomLineUidList, String variantRuleUid, IntHolder numberOfVariantOptions, uidSeqValue_uHolder variantOptions, uidSeqValue_uHolder variantOptionTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(noOfBOMLines);
    args_[1] = TcUtility.createArg(bomLineUidList);
    args_[2] = TcUtility.createArg(variantRuleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "getVariableVariantOptions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    numberOfVariantOptions.value = TcUtility.queryArg(response.output[0], numberOfVariantOptions.value);
    variantOptions.value = TcUtility.queryArg(response.output[1], variantOptions.value);
    variantOptionTypes.value = TcUtility.queryArg(response.output[2], variantOptionTypes.value);
  }

  public void getVariantRules(int noOfBOMLines, String[] bomLineUidList, IntHolder numberOfVariantRules, uidSeqValue_uHolder variantRules, uidSeqValue_uHolder variantRuleTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(noOfBOMLines);
    args_[1] = TcUtility.createArg(bomLineUidList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "getVariantRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    numberOfVariantRules.value = TcUtility.queryArg(response.output[0], numberOfVariantRules.value);
    variantRules.value = TcUtility.queryArg(response.output[1], variantRules.value);
    variantRuleTypes.value = TcUtility.queryArg(response.output[2], variantRuleTypes.value);
  }

  public void exportConfiguredUGAssembly(uidSeqValue_u targetUids, uidSeqValue_u backgrndUids, boolean checkoutTargets, String namingFormat, stringSeq_tHolder fileInfo) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(targetUids);
    args_[1] = TcUtility.createArg(backgrndUids);
    args_[2] = TcUtility.createArg(checkoutTargets);
    args_[3] = TcUtility.createArg(namingFormat);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "exportConfiguredUGAssembly", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileInfo.value = TcUtility.queryArg(response.output[0], fileInfo.value);
  }

  public void createStructureContextObject(String scoType, String scoName, String scoDesc, String productItemRevUid, String revisionRuleUid, String variantRuleUid, int noOfWorkparts, String[] workpartsUids, int noOfTargetBOMLines, String[] targetBOMLinesUids, int noOfBackgroundBOMLines, String[] backgroundBOMLinesUids, String targetSCGroupingUid, String backgroundSCGroupingUid, StringHolder structureContextObjectUid, StringHolder structureContextObjectTypeUid) throws Exception {
    Arg[] args_ = new Arg[14];
    args_[0] = TcUtility.createArgStringUnion(scoType);
    args_[1] = TcUtility.createArgStringUnion(scoName);
    args_[2] = TcUtility.createArgStringUnion(scoDesc);
    args_[3] = TcUtility.createArgStringUnion(productItemRevUid);
    args_[4] = TcUtility.createArgStringUnion(revisionRuleUid);
    args_[5] = TcUtility.createArgStringUnion(variantRuleUid);
    args_[6] = TcUtility.createArg(noOfWorkparts);
    args_[7] = TcUtility.createArgStringUnion(workpartsUids);
    args_[8] = TcUtility.createArg(noOfTargetBOMLines);
    args_[9] = TcUtility.createArgStringUnion(targetBOMLinesUids);
    args_[10] = TcUtility.createArg(noOfBackgroundBOMLines);
    args_[11] = TcUtility.createArgStringUnion(backgroundBOMLinesUids);
    args_[12] = TcUtility.createArgStringUnion(targetSCGroupingUid);
    args_[13] = TcUtility.createArgStringUnion(backgroundSCGroupingUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "createStructureContextObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    structureContextObjectUid.value = TcUtility.queryArgStringUnion(response.output[0], structureContextObjectUid.value);
    structureContextObjectTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], structureContextObjectTypeUid.value);
  }

  public void interpretStructureContextObject(String scoUid, StringHolder revRuleUid, StringHolder revRuleTypeUid, StringHolder variantRuleUid, StringHolder variantRuleTypeUid, StringHolder prodItemRevUid, StringHolder prodItemRevTypeUid, IntHolder noOfWorkparts, uidValueSeq_tHolder workpartsUid, uidValueSeq_tHolder workpartsTypeUid, IntHolder noOfTargetAppGroups, uidValueSeq_tHolder targetAppGroupsUid, uidValueSeq_tHolder targetAppGroupsTypeUid, IntHolder noOfBgAppGroups, uidValueSeq_tHolder bgAppGroupsUid, uidValueSeq_tHolder bgAppGroupsTypeUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(scoUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "interpretStructureContextObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    revRuleUid.value = TcUtility.queryArgStringUnion(response.output[0], revRuleUid.value);
    revRuleTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], revRuleTypeUid.value);
    variantRuleUid.value = TcUtility.queryArgStringUnion(response.output[2], variantRuleUid.value);
    variantRuleTypeUid.value = TcUtility.queryArgStringUnion(response.output[3], variantRuleTypeUid.value);
    prodItemRevUid.value = TcUtility.queryArgStringUnion(response.output[4], prodItemRevUid.value);
    prodItemRevTypeUid.value = TcUtility.queryArgStringUnion(response.output[5], prodItemRevTypeUid.value);
    noOfWorkparts.value = TcUtility.queryArg(response.output[6], noOfWorkparts.value);
    workpartsUid.value = TcUtility.queryArgStringUnion(response.output[7], workpartsUid.value);
    workpartsTypeUid.value = TcUtility.queryArgStringUnion(response.output[8], workpartsTypeUid.value);
    noOfTargetAppGroups.value = TcUtility.queryArg(response.output[9], noOfTargetAppGroups.value);
    targetAppGroupsUid.value = TcUtility.queryArgStringUnion(response.output[10], targetAppGroupsUid.value);
    targetAppGroupsTypeUid.value = TcUtility.queryArgStringUnion(response.output[11], targetAppGroupsTypeUid.value);
    noOfBgAppGroups.value = TcUtility.queryArg(response.output[12], noOfBgAppGroups.value);
    bgAppGroupsUid.value = TcUtility.queryArgStringUnion(response.output[13], bgAppGroupsUid.value);
    bgAppGroupsTypeUid.value = TcUtility.queryArgStringUnion(response.output[14], bgAppGroupsTypeUid.value);
  }

  public void updateStructureContextObject(String scoUid, String productItemRevUid, String revisionRuleUid, String variantRuleUid, int noOfWorkparts, String[] workpartsUids, int noOfTargetBOMLines, String[] targetBOMLinesUids, int noOfBackgroundBOMLines, String[] backgroundBOMLinesUids, String targetSCGroupingUid, String backgroundSCGroupingUid) throws Exception {
    Arg[] args_ = new Arg[12];
    args_[0] = TcUtility.createArg(scoUid);
    args_[1] = TcUtility.createArgStringUnion(productItemRevUid);
    args_[2] = TcUtility.createArgStringUnion(revisionRuleUid);
    args_[3] = TcUtility.createArgStringUnion(variantRuleUid);
    args_[4] = TcUtility.createArg(noOfWorkparts);
    args_[5] = TcUtility.createArgStringUnion(workpartsUids);
    args_[6] = TcUtility.createArg(noOfTargetBOMLines);
    args_[7] = TcUtility.createArgStringUnion(targetBOMLinesUids);
    args_[8] = TcUtility.createArg(noOfBackgroundBOMLines);
    args_[9] = TcUtility.createArgStringUnion(backgroundBOMLinesUids);
    args_[10] = TcUtility.createArgStringUnion(targetSCGroupingUid);
    args_[11] = TcUtility.createArgStringUnion(backgroundSCGroupingUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "updateStructureContextObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void evaluateStructureContextObject(String scoUid, int mode, String bomWindow, IntHolder noOfTargetBOMLines, uidValueSeq_tHolder targetBOMLineUids, uidValueSeq_tHolder targetBOMLineTypeUids, IntHolder noOfUnconfiguredTargetBOMLines, uidValueSeq_tHolder unconfiguredTargetBOMLineUids, uidValueSeq_tHolder unconfiguredTargetBOMLineTypeUids, IntHolder noOfUnconfigurableTargetBOMLines, uidValueSeq_tHolder unconfigurableTargetBOMLineUids, uidValueSeq_tHolder unconfigurableTargetBOMLineTypeUids, IntHolder noOfBgBOMLines, uidValueSeq_tHolder bgBOMLineUids, uidValueSeq_tHolder bgBOMLineTypeUids, IntHolder noOfUnconfiguredBgBOMLines, uidValueSeq_tHolder unconfiguredBgBOMLineUids, uidValueSeq_tHolder unconfiguredBgBOMLineTypeUids, IntHolder noOfUnconfigurableBgBOMLines, uidValueSeq_tHolder unconfigurableBgBOMLineUids, uidValueSeq_tHolder unconfigurableBgBOMLineTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(scoUid);
    args_[1] = TcUtility.createArg(mode);
    args_[2] = TcUtility.createArg(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "evaluateStructureContextObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfTargetBOMLines.value = TcUtility.queryArg(response.output[0], noOfTargetBOMLines.value);
    targetBOMLineUids.value = TcUtility.queryArgStringUnion(response.output[1], targetBOMLineUids.value);
    targetBOMLineTypeUids.value = TcUtility.queryArgStringUnion(response.output[2], targetBOMLineTypeUids.value);
    noOfUnconfiguredTargetBOMLines.value = TcUtility.queryArg(response.output[3], noOfUnconfiguredTargetBOMLines.value);
    unconfiguredTargetBOMLineUids.value = TcUtility.queryArgStringUnion(response.output[4], unconfiguredTargetBOMLineUids.value);
    unconfiguredTargetBOMLineTypeUids.value = TcUtility.queryArgStringUnion(response.output[5], unconfiguredTargetBOMLineTypeUids.value);
    noOfUnconfigurableTargetBOMLines.value = TcUtility.queryArg(response.output[6], noOfUnconfigurableTargetBOMLines.value);
    unconfigurableTargetBOMLineUids.value = TcUtility.queryArgStringUnion(response.output[7], unconfigurableTargetBOMLineUids.value);
    unconfigurableTargetBOMLineTypeUids.value = TcUtility.queryArgStringUnion(response.output[8], unconfigurableTargetBOMLineTypeUids.value);
    noOfBgBOMLines.value = TcUtility.queryArg(response.output[9], noOfBgBOMLines.value);
    bgBOMLineUids.value = TcUtility.queryArgStringUnion(response.output[10], bgBOMLineUids.value);
    bgBOMLineTypeUids.value = TcUtility.queryArgStringUnion(response.output[11], bgBOMLineTypeUids.value);
    noOfUnconfiguredBgBOMLines.value = TcUtility.queryArg(response.output[12], noOfUnconfiguredBgBOMLines.value);
    unconfiguredBgBOMLineUids.value = TcUtility.queryArgStringUnion(response.output[13], unconfiguredBgBOMLineUids.value);
    unconfiguredBgBOMLineTypeUids.value = TcUtility.queryArgStringUnion(response.output[14], unconfiguredBgBOMLineTypeUids.value);
    noOfUnconfigurableBgBOMLines.value = TcUtility.queryArg(response.output[15], noOfUnconfigurableBgBOMLines.value);
    unconfigurableBgBOMLineUids.value = TcUtility.queryArgStringUnion(response.output[16], unconfigurableBgBOMLineUids.value);
    unconfigurableBgBOMLineTypeUids.value = TcUtility.queryArgStringUnion(response.output[17], unconfigurableBgBOMLineTypeUids.value);
  }

  public void adoptBOMLines(int noOfBOMLines, String[] bomLineList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(noOfBOMLines);
    args_[1] = TcUtility.createArg(bomLineList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "adoptBOMLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askCompositePropertyObjects(String comp, int noOfProps, String[] compositeProps, IntHolder noOfObjArrays, rdvCompositePropObjectInfoSeq_tHolder objectStructs) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(comp);
    args_[1] = TcUtility.createArg(noOfProps);
    args_[2] = TcUtility.createArgStringUnion(compositeProps);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "askCompositePropertyObjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfObjArrays.value = TcUtility.queryArg(response.output[0], noOfObjArrays.value);
    objectStructs.value = TcUtility.queryArg(response.output[1], objectStructs.value);
  }

  public void askCompositeProperties(String comp, int noOfProps, String[] compositeProps, IntHolder noOfValues, stringValueSeq_tHolder propValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(comp);
    args_[1] = TcUtility.createArg(noOfProps);
    args_[2] = TcUtility.createArgStringUnion(compositeProps);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "askCompositeProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfValues.value = TcUtility.queryArg(response.output[0], noOfValues.value);
    propValues.value = TcUtility.queryArgStringUnion(response.output[1], propValues.value);
  }

  public void askProductItems(int noOfComps, String[] comps, IntHolder noOfValues, rdvProductItemsDataSeq_tHolder prodItemStructs) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(noOfComps);
    args_[1] = TcUtility.createArgStringUnion(comps);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "askProductItems", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfValues.value = TcUtility.queryArg(response.output[0], noOfValues.value);
    prodItemStructs.value = TcUtility.queryArg(response.output[1], prodItemStructs.value);
  }

  public void convertUIDToBomline(String bomWindowUid, stringSeqValue_u apprPathNodeUIDServer, int apprUIDLength, uidSeqValue_uHolder UidHolder) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(bomWindowUid);
    args_[1] = TcUtility.createArg(apprPathNodeUIDServer);
    args_[2] = TcUtility.createArg(apprUIDLength);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "convertUIDToBomline", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    UidHolder.value = TcUtility.queryArg(response.output[0], UidHolder.value);
  }

  public void addDesignToIA(String componentRevUid, String iaRevUid, uidSeqValue_u productRevUids, String archApnUid, int noofOccs, uidSeqValue_u authNamedVariantUids, uidSeqValue_u breakNamedVariantUids, int noOfLOUs, uidSeqValue_u louUids, uidValueSeq_tHolder occurrences, uidValueSeq_tHolder occTypeUids) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(componentRevUid);
    args_[1] = TcUtility.createArg(iaRevUid);
    args_[2] = TcUtility.createArg(productRevUids);
    args_[3] = TcUtility.createArg(archApnUid);
    args_[4] = TcUtility.createArg(noofOccs);
    args_[5] = TcUtility.createArg(authNamedVariantUids);
    args_[6] = TcUtility.createArg(breakNamedVariantUids);
    args_[7] = TcUtility.createArg(noOfLOUs);
    args_[8] = TcUtility.createArg(louUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "addDesignToIA", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    occurrences.value = TcUtility.queryArgStringUnion(response.output[0], occurrences.value);
    occTypeUids.value = TcUtility.queryArgStringUnion(response.output[1], occTypeUids.value);
  }

  public void addPartToProduct(String componentRevUid, String genericObjectBOMLine, int productRevCount, uidSeqValue_u productRevUids, String goApnUid, int authCount, uidSeqValue_u authNamedVariantUids, int quantity, StringHolder occurrence, StringHolder occTypeUid) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(componentRevUid);
    args_[1] = TcUtility.createArg(genericObjectBOMLine);
    args_[2] = TcUtility.createArg(productRevCount);
    args_[3] = TcUtility.createArg(productRevUids);
    args_[4] = TcUtility.createArg(goApnUid);
    args_[5] = TcUtility.createArg(authCount);
    args_[6] = TcUtility.createArg(authNamedVariantUids);
    args_[7] = TcUtility.createArg(quantity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "addPartToProduct", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    occurrence.value = TcUtility.queryArgStringUnion(response.output[0], occurrence.value);
    occTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], occTypeUid.value);
  }

  public void replaceDesignInProduct(String componentUid, boolean isUpdate, uidSeqValue_u bomLineUids, uidSeqValue_u productRevUids, String archApnUid, uidSeqValue_u authNamedVariantUids, uidSeqValue_u breakNamedVariantUids, int noOfLOUs, uidSeqValue_u louUids) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArgStringUnion(componentUid);
    args_[1] = TcUtility.createArg(isUpdate);
    args_[2] = TcUtility.createArg(bomLineUids);
    args_[3] = TcUtility.createArg(productRevUids);
    args_[4] = TcUtility.createArg(archApnUid);
    args_[5] = TcUtility.createArg(authNamedVariantUids);
    args_[6] = TcUtility.createArg(breakNamedVariantUids);
    args_[7] = TcUtility.createArg(noOfLOUs);
    args_[8] = TcUtility.createArg(louUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "replaceDesignInProduct", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void replacePartInProduct(String componentUid, String bomLineUid, String archApnUid, uidSeqValue_u authNamedVariantUids, boolean splitAndClone, boolean carrySubstitutes) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(componentUid);
    args_[1] = TcUtility.createArg(bomLineUid);
    args_[2] = TcUtility.createArg(archApnUid);
    args_[3] = TcUtility.createArg(authNamedVariantUids);
    args_[4] = TcUtility.createArg(splitAndClone);
    args_[5] = TcUtility.createArg(carrySubstitutes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "replacePartInProduct", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeDesignsFromIA(String productItem, int noOfCompsToBeCut, String[] compsToBeCut) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(productItem);
    args_[1] = TcUtility.createArg(noOfCompsToBeCut);
    args_[2] = TcUtility.createArgStringUnion(compsToBeCut);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "removeDesignsFromIA", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askVariantExprXOChartData(int noOfVarExprs, String[] varExprs, rdvVariantExprXOChartData_sHolder objectStruct) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(noOfVarExprs);
    args_[1] = TcUtility.createArgStringUnion(varExprs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "askVariantExprXOChartData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectStruct.value = TcUtility.queryArg(response.output[0], objectStruct.value);
  }

  public void askVariantExprAsText(String varExpr, StringHolder asText) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(varExpr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "askVariantExprAsText", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    asText.value = TcUtility.queryArgStringUnion(response.output[0], asText.value);
  }

  public void bomVariantExprAsText(String varExpr, StringHolder asText) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(varExpr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "bomVariantExprAsText", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    asText.value = TcUtility.queryArgStringUnion(response.output[0], asText.value);
  }

  public void setNamedVariantExpressionsToBOMLines(int noOfBOMLines, String[] bomLines, int noOfNVEs, String[] nves) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(noOfBOMLines);
    args_[1] = TcUtility.createArgStringUnion(bomLines);
    args_[2] = TcUtility.createArg(noOfNVEs);
    args_[3] = TcUtility.createArgStringUnion(nves);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "setNamedVariantExpressionsToBOMLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeNamedVariantExpressionsFromBOMLines(int noOfBOMLines, String[] bomLines, int noOfNVEs, String[] nves) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(noOfBOMLines);
    args_[1] = TcUtility.createArgStringUnion(bomLines);
    args_[2] = TcUtility.createArg(noOfNVEs);
    args_[3] = TcUtility.createArgStringUnion(nves);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "removeNamedVariantExpressionsFromBOMLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void mapSearchResultsToBOMLines(String bomWindow, int noOfResults, String[] results, IntHolder noOfBOMLines, uidValueSeq_tHolder bomLines, uidValueSeq_tHolder bomLineTypes, IntHolder noOfUnconfiguredBOMLines, uidValueSeq_tHolder unconfiguredBOMLines, uidValueSeq_tHolder unconfiguredBOMLineTypes, IntHolder noOfUnconfigurableBOMLines, uidValueSeq_tHolder unconfigurableBOMLines, uidValueSeq_tHolder unconfigurableBOMLineTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(bomWindow);
    args_[1] = TcUtility.createArg(noOfResults);
    args_[2] = TcUtility.createArgStringUnion(results);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "mapSearchResultsToBOMLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfBOMLines.value = TcUtility.queryArg(response.output[0], noOfBOMLines.value);
    bomLines.value = TcUtility.queryArgStringUnion(response.output[1], bomLines.value);
    bomLineTypes.value = TcUtility.queryArgStringUnion(response.output[2], bomLineTypes.value);
    noOfUnconfiguredBOMLines.value = TcUtility.queryArg(response.output[3], noOfUnconfiguredBOMLines.value);
    unconfiguredBOMLines.value = TcUtility.queryArgStringUnion(response.output[4], unconfiguredBOMLines.value);
    unconfiguredBOMLineTypes.value = TcUtility.queryArgStringUnion(response.output[5], unconfiguredBOMLineTypes.value);
    noOfUnconfigurableBOMLines.value = TcUtility.queryArg(response.output[6], noOfUnconfigurableBOMLines.value);
    unconfigurableBOMLines.value = TcUtility.queryArgStringUnion(response.output[7], unconfigurableBOMLines.value);
    unconfigurableBOMLineTypes.value = TcUtility.queryArgStringUnion(response.output[8], unconfigurableBOMLineTypes.value);
  }

  public void addNamedVariantExpression(String archRevOrBOMLineUid, String code, String desc, String nve, boolean ignoreDuplicate, StringHolder newNVEUid, StringHolder newNVETypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(archRevOrBOMLineUid);
    args_[1] = TcUtility.createArgStringUnion(code);
    args_[2] = TcUtility.createArgStringUnion(desc);
    args_[3] = TcUtility.createArg(nve);
    args_[4] = TcUtility.createArg(ignoreDuplicate);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "addNamedVariantExpression", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newNVEUid.value = TcUtility.queryArg(response.output[0], newNVEUid.value);
    newNVETypeUid.value = TcUtility.queryArg(response.output[1], newNVETypeUid.value);
  }

  public void getNamedVariantExpressions(String archUid, IntHolder noOfNVEs, uidValueSeq_tHolder nveUids, uidValueSeq_tHolder nveTypeUids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(archUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "getNamedVariantExpressions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfNVEs.value = TcUtility.queryArg(response.output[0], noOfNVEs.value);
    nveUids.value = TcUtility.queryArgStringUnion(response.output[1], nveUids.value);
    nveTypeUids.value = TcUtility.queryArgStringUnion(response.output[2], nveTypeUids.value);
  }

  public void executeWorkpartsQuery(String stringItemId, IntHolder noOfInstances, uidSeqValue_uHolder resultInstancesHolder, uidSeqValue_uHolder instanceTypeTags) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(stringItemId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "executeWorkpartsQuery", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfInstances.value = TcUtility.queryArg(response.output[0], noOfInstances.value);
    resultInstancesHolder.value = TcUtility.queryArg(response.output[1], resultInstancesHolder.value);
    instanceTypeTags.value = TcUtility.queryArg(response.output[2], instanceTypeTags.value);
  }

  public void executeProcessesQuery(String stringObjectName, IntHolder noOfInstances, uidSeqValue_uHolder resultInstancesHolder, uidSeqValue_uHolder instanceTypeTags) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(stringObjectName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "executeProcessesQuery", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfInstances.value = TcUtility.queryArg(response.output[0], noOfInstances.value);
    resultInstancesHolder.value = TcUtility.queryArg(response.output[1], resultInstancesHolder.value);
    instanceTypeTags.value = TcUtility.queryArg(response.output[2], instanceTypeTags.value);
  }

  public void executeEngChangeQuery(String stringItemId, String stringItemRevisionId, IntHolder noOfInstances, uidSeqValue_uHolder resultInstancesHolder, uidSeqValue_uHolder instanceTypeTags) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArgStringUnion(stringItemId);
    args_[1] = TcUtility.createArgStringUnion(stringItemRevisionId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "executeEngChangeQuery", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfInstances.value = TcUtility.queryArg(response.output[0], noOfInstances.value);
    resultInstancesHolder.value = TcUtility.queryArg(response.output[1], resultInstancesHolder.value);
    instanceTypeTags.value = TcUtility.queryArg(response.output[2], instanceTypeTags.value);
  }

  public void setVariabilityForBOMLine(String variantUid, int noOfSelectedValues, String[] selectedValues, String bomlineComp, IntHolder noOfExprs, uidValueSeq_tHolder varExprUids, uidValueSeq_tHolder varExprTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(variantUid);
    args_[1] = TcUtility.createArg(noOfSelectedValues);
    args_[2] = TcUtility.createArgStringUnion(selectedValues);
    args_[3] = TcUtility.createArg(bomlineComp);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "setVariabilityForBOMLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfExprs.value = TcUtility.queryArg(response.output[0], noOfExprs.value);
    varExprUids.value = TcUtility.queryArgStringUnion(response.output[1], varExprUids.value);
    varExprTypeUids.value = TcUtility.queryArgStringUnion(response.output[2], varExprTypeUids.value);
  }

  public void setVariabilityForItemRev(String variantUid, int noOfSelectedValues, String[] selectedValues, int noOfComps, String[] comps, IntHolder noOfExprs, uidValueSeq_tHolder varExprUids, uidValueSeq_tHolder varExprTypeUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(variantUid);
    args_[1] = TcUtility.createArg(noOfSelectedValues);
    args_[2] = TcUtility.createArgStringUnion(selectedValues);
    args_[3] = TcUtility.createArg(noOfComps);
    args_[4] = TcUtility.createArgStringUnion(comps);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "setVariabilityForItemRev", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfExprs.value = TcUtility.queryArg(response.output[0], noOfExprs.value);
    varExprUids.value = TcUtility.queryArgStringUnion(response.output[1], varExprUids.value);
    varExprTypeUids.value = TcUtility.queryArgStringUnion(response.output[2], varExprTypeUids.value);
  }

  public void removeVariabilityFromBOMLine(String variantUid, int noOfVariabilityValues, String[] variabilityValues, String bomline, IntHolder noOfVariabilityVEs, uidValueSeq_tHolder variabilityVEs, uidValueSeq_tHolder variabilityVETypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(variantUid);
    args_[1] = TcUtility.createArg(noOfVariabilityValues);
    args_[2] = TcUtility.createArgStringUnion(variabilityValues);
    args_[3] = TcUtility.createArg(bomline);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "removeVariabilityFromBOMLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfVariabilityVEs.value = TcUtility.queryArg(response.output[0], noOfVariabilityVEs.value);
    variabilityVEs.value = TcUtility.queryArgStringUnion(response.output[1], variabilityVEs.value);
    variabilityVETypes.value = TcUtility.queryArgStringUnion(response.output[2], variabilityVETypes.value);
  }

  public void removeVariabilityFromItemRev(String variantUid, int noOfVariabilityValues, String[] variabilityValues, String itemRev, IntHolder noOfVariabilityVEs, uidValueSeq_tHolder variabilityVEs, uidValueSeq_tHolder variabilityVETypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(variantUid);
    args_[1] = TcUtility.createArg(noOfVariabilityValues);
    args_[2] = TcUtility.createArgStringUnion(variabilityValues);
    args_[3] = TcUtility.createArg(itemRev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "removeVariabilityFromItemRev", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfVariabilityVEs.value = TcUtility.queryArg(response.output[0], noOfVariabilityVEs.value);
    variabilityVEs.value = TcUtility.queryArgStringUnion(response.output[1], variabilityVEs.value);
    variabilityVETypes.value = TcUtility.queryArgStringUnion(response.output[2], variabilityVETypes.value);
  }

  public void getVariabilitiesFromBOMLine(String bomLineUid, IntHolder noOfVariabilitiesForComp, uidValueSeq_tHolder variabilitiesForComp, uidValueSeq_tHolder variabilityTypesForComp, IntHolder noOfVariabilitiesForTopLevelComp, uidValueSeq_tHolder variabilitiesForTopLevelComp, uidValueSeq_tHolder variabilityTypesForTopLevelComp) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "getVariabilitiesFromBOMLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfVariabilitiesForComp.value = TcUtility.queryArg(response.output[0], noOfVariabilitiesForComp.value);
    variabilitiesForComp.value = TcUtility.queryArgStringUnion(response.output[1], variabilitiesForComp.value);
    variabilityTypesForComp.value = TcUtility.queryArgStringUnion(response.output[2], variabilityTypesForComp.value);
    noOfVariabilitiesForTopLevelComp.value = TcUtility.queryArg(response.output[3], noOfVariabilitiesForTopLevelComp.value);
    variabilitiesForTopLevelComp.value = TcUtility.queryArgStringUnion(response.output[4], variabilitiesForTopLevelComp.value);
    variabilityTypesForTopLevelComp.value = TcUtility.queryArgStringUnion(response.output[5], variabilityTypesForTopLevelComp.value);
  }

  public void executeRDVTouchpointAlgorithm(String parentUid, String componentUid, boolean processParents, boolean processChildren) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(parentUid);
    args_[1] = TcUtility.createArg(componentUid);
    args_[2] = TcUtility.createArg(processParents);
    args_[3] = TcUtility.createArg(processChildren);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "executeRDVTouchpointAlgorithm", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void generateVariantMap(String datasetTag, StringHolder revisionRule, StringHolder productId) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(datasetTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "generateVariantMap", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    revisionRule.value = TcUtility.queryArgStringUnion(response.output[0], revisionRule.value);
    productId.value = TcUtility.queryArgStringUnion(response.output[1], productId.value);
  }

  public void generatePrunedPlmxml(String datasetTag, String prodRevTag, String window, String svrTag, String entityHandles, StringHolder pruneFilePath) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(datasetTag);
    args_[1] = TcUtility.createArg(prodRevTag);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArgStringUnion(svrTag);
    args_[4] = TcUtility.createArgStringUnion(entityHandles);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "generatePrunedPlmxml", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pruneFilePath.value = TcUtility.queryArgStringUnion(response.output[0], pruneFilePath.value);
  }

  public void getGOIOptionData(IntHolder n_values, rdvGOIOptionDataSeq_tHolder goiOptionData) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "getGOIOptionData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    n_values.value = TcUtility.queryArg(response.output[0], n_values.value);
    goiOptionData.value = TcUtility.queryArg(response.output[1], goiOptionData.value);
  }

  public void getVRuleVariantValues(String bomWindow, String optionRev, IntHolder noOfVals, stringValueSeq_tHolder optionValues) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(bomWindow);
    args_[1] = TcUtility.createArg(optionRev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "getVRuleVariantValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfVals.value = TcUtility.queryArg(response.output[0], noOfVals.value);
    optionValues.value = TcUtility.queryArgStringUnion(response.output[1], optionValues.value);
  }

  public void clearHashTable() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRDVService", "clearHashTable", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
