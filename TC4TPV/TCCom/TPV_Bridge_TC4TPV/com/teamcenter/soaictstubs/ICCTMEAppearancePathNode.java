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

public class ICCTMEAppearancePathNode extends ICCT {
  public ICCTMEAppearancePathNode(Connection connection) {
    super(connection);
  }

  public ICCTMEAppearancePathNode(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void getMEAppearancePathNodeFromAppearance(String apprUid, StringHolder pathNodeUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(apprUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "getMEAppearancePathNodeFromAppearance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pathNodeUid.value = TcUtility.queryArg(response.output[0], pathNodeUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void getMEAppearancePathNodeFromBOMLine(String apprUid, StringHolder pathNodeUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(apprUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "getMEAppearancePathNodeFromBOMLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pathNodeUid.value = TcUtility.queryArg(response.output[0], pathNodeUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void findOrCreatePathNodeFromAppearance(String apprUid, StringHolder pathNodeUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(apprUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "findOrCreatePathNodeFromAppearance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pathNodeUid.value = TcUtility.queryArg(response.output[0], pathNodeUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void findOrCreatePathNodeFromBOMLine(String bomLineUid, StringHolder pathNodeUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "findOrCreatePathNodeFromBOMLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pathNodeUid.value = TcUtility.queryArg(response.output[0], pathNodeUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void getConfiguredAppearance(String pathNodeUid, String revRuleUid, StringHolder apprUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(pathNodeUid);
    args_[3] = TcUtility.createArg(revRuleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "getConfiguredAppearance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    apprUid.value = TcUtility.queryArg(response.output[0], apprUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void updatePathNodeFromBOMLine(String compUid, short options, StringHolder pathNodeUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(compUid);
    args_[3] = TcUtility.createArg(options);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "updatePathNodeFromBOMLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pathNodeUid.value = TcUtility.queryArg(response.output[0], pathNodeUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void getPathNodeItem(String pathNode, String revRule, StringHolder itemUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(pathNode);
    args_[3] = TcUtility.createArgStringUnion(revRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "getPathNodeItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    itemUid.value = TcUtility.queryArg(response.output[0], itemUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void getPathNodeParentHierarchy(String pathNode, uidSeq_tHolder parentNodes, uidSeq_tHolder parentItems, uidValueSeq_tHolder parentOccThreads) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(pathNode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "getPathNodeParentHierarchy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    parentNodes.value = TcUtility.queryArg(response.output[0], parentNodes.value);
    parentItems.value = TcUtility.queryArg(response.output[1], parentItems.value);
    parentOccThreads.value = TcUtility.queryArgStringUnion(response.output[2], parentOccThreads.value);
  }

  public void getPathNodesForItem(String itemUid, String topItem, uidSeq_tHolder pathNodes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemUid);
    args_[3] = TcUtility.createArg(topItem);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "getPathNodesForItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pathNodes.value = TcUtility.queryArg(response.output[0], pathNodes.value);
  }

  public void acctabilityCheck(String[] srcLineUids, String[] tarLineUids, short options, String srcContextLine_uid, String tarContextLine_uid, uidSeq_tHolder srcLinesRet, uidSeq_tHolder srcLinesRet_types, uidSeq_tHolder matLinesRet, uidSeq_tHolder matLinesRet_types) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(srcLineUids);
    args_[3] = TcUtility.createArg(tarLineUids);
    args_[4] = TcUtility.createArg(options);
    args_[5] = TcUtility.createArgStringUnion(srcContextLine_uid);
    args_[6] = TcUtility.createArgStringUnion(tarContextLine_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "acctabilityCheck", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    srcLinesRet.value = TcUtility.queryArg(response.output[0], srcLinesRet.value);
    srcLinesRet_types.value = TcUtility.queryArg(response.output[1], srcLinesRet_types.value);
    matLinesRet.value = TcUtility.queryArg(response.output[2], matLinesRet.value);
    matLinesRet_types.value = TcUtility.queryArg(response.output[3], matLinesRet_types.value);
  }

  public void clearAcctabilityCheck(String[] windowUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(windowUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "clearAcctabilityCheck", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void processBalancing(String refWin_uid, String[] refLine_uid, String thisWin_uid, String[] bomLine_uids, String resultName, String resultDesc, short options, String refContextLine_uid, String bomContextLine_uid, StringHolder resultView_uid, StringHolder resultViewType_uid) throws Exception {
    Arg[] args_ = new Arg[11];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(refWin_uid);
    args_[3] = TcUtility.createArg(refLine_uid);
    args_[4] = TcUtility.createArgStringUnion(thisWin_uid);
    args_[5] = TcUtility.createArg(bomLine_uids);
    args_[6] = TcUtility.createArgStringUnion(resultName);
    args_[7] = TcUtility.createArgStringUnion(resultDesc);
    args_[8] = TcUtility.createArg(options);
    args_[9] = TcUtility.createArgStringUnion(refContextLine_uid);
    args_[10] = TcUtility.createArgStringUnion(bomContextLine_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "processBalancing", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    resultView_uid.value = TcUtility.queryArg(response.output[0], resultView_uid.value);
    resultViewType_uid.value = TcUtility.queryArg(response.output[1], resultViewType_uid.value);
  }

  public void getLineFromSourceOrTarget(String theLine, String theWin, BooleanHolder isTarget, StringHolder outputLine, StringHolder outputLineType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theLine);
    args_[3] = TcUtility.createArg(theWin);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathNode", "getLineFromSourceOrTarget", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isTarget.value = TcUtility.queryArg(response.output[0], isTarget.value);
    outputLine.value = TcUtility.queryArg(response.output[1], outputLine.value);
    outputLineType.value = TcUtility.queryArg(response.output[2], outputLineType.value);
  }

}
