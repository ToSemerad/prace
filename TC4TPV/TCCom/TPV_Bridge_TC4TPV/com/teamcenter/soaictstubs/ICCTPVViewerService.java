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

public class ICCTPVViewerService {
  ICTService m_service;

  Connection m_connection;


  public ICCTPVViewerService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void loadPSESession(String topLevel, String revisionRule, String inBomWindowUid, String variantRule, String[] occurrenceList, String[] appearanceList, uidValueSeq_tHolder outBomLineUids, StringHolder outBomWindowUid, StringHolder outBomWindowTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArgStringUnion(topLevel);
    args_[1] = TcUtility.createArgStringUnion(revisionRule);
    args_[2] = TcUtility.createArgStringUnion(inBomWindowUid);
    args_[3] = TcUtility.createArgStringUnion(variantRule);
    args_[4] = TcUtility.createArgStringUnion(occurrenceList);
    args_[5] = TcUtility.createArgStringUnion(appearanceList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPVViewerService", "loadPSESession", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outBomLineUids.value = TcUtility.queryArgStringUnion(response.output[0], outBomLineUids.value);
    outBomWindowUid.value = TcUtility.queryArg(response.output[1], outBomWindowUid.value);
    outBomWindowTypeUid.value = TcUtility.queryArg(response.output[2], outBomWindowTypeUid.value);
  }

  public void getRevisionRuleXMLFromUid(String revRuleUid, StringHolder revisionRuleXML) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(revRuleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPVViewerService", "getRevisionRuleXMLFromUid", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    revisionRuleXML.value = TcUtility.queryArgStringUnion(response.output[0], revisionRuleXML.value);
  }

  public void getRevisionRuleUidFromXML(String revisionRuleXML, StringHolder revRuleUid, StringHolder revRuleTypeUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(revisionRuleXML);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPVViewerService", "getRevisionRuleUidFromXML", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    revRuleUid.value = TcUtility.queryArg(response.output[0], revRuleUid.value);
    revRuleTypeUid.value = TcUtility.queryArg(response.output[1], revRuleTypeUid.value);
  }

  public void getLicLevel(String licenseStr, IntHolder licLevel, BooleanHolder result) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(licenseStr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPVViewerService", "getLicLevel", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    licLevel.value = TcUtility.queryArg(response.output[0], licLevel.value);
    result.value = TcUtility.queryArg(response.output[1], result.value);
  }

  public void savePvDataset(String datasetType, String locationDataset, String baseDataset, String baseTcfile, uidSeqValue_u modifiedTcfiles, String[] layerNames, String pvDatasetName, String pvDatasetDesc, String[] writeTickets, StringHolder newPvDataset, StringHolder pvDatasetType) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArgStringUnion(datasetType);
    args_[1] = TcUtility.createArgStringUnion(locationDataset);
    args_[2] = TcUtility.createArgStringUnion(baseDataset);
    args_[3] = TcUtility.createArgStringUnion(baseTcfile);
    args_[4] = TcUtility.createArg(modifiedTcfiles);
    args_[5] = TcUtility.createArgStringUnion(layerNames);
    args_[6] = TcUtility.createArgStringUnion(pvDatasetName);
    args_[7] = TcUtility.createArgStringUnion(pvDatasetDesc);
    args_[8] = TcUtility.createArgStringUnion(writeTickets);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPVViewerService", "savePvDataset", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newPvDataset.value = TcUtility.queryArg(response.output[0], newPvDataset.value);
    pvDatasetType.value = TcUtility.queryArg(response.output[1], pvDatasetType.value);
  }

}
