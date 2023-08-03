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

public class ICCTBOMWindow extends ICCT {
  public ICCTBOMWindow(Connection connection) {
    super(connection);
  }

  public ICCTBOMWindow(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void isModified(String bomWindow, BooleanHolder modified) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "isModified", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    modified.value = TcUtility.queryArg(response.output[0], modified.value);
  }

  public void create(String revRule, StringHolder window, StringHolder windowType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(revRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    window.value = TcUtility.queryArg(response.output[0], window.value);
    windowType.value = TcUtility.queryArg(response.output[1], windowType.value);
  }

  public void setWindowTopLine(String window, String item, String rev, String bv, String bvr, String occGrp, StringHolder topLine, StringHolder topLineType) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArgStringUnion(item);
    args_[4] = TcUtility.createArgStringUnion(rev);
    args_[5] = TcUtility.createArgStringUnion(bv);
    args_[6] = TcUtility.createArgStringUnion(bvr);
    args_[7] = TcUtility.createArgStringUnion(occGrp);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "setWindowTopLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    topLine.value = TcUtility.queryArg(response.output[0], topLine.value);
    topLineType.value = TcUtility.queryArg(response.output[1], topLineType.value);
  }

  public void findConfigedBOMLinesForAbsOccOrAPN(String window, String appr, boolean byAbsOccID, boolean searchAllContexts, String bomContextLine_uid, uidSeq_tHolder lines, uidSeq_tHolder lineTypes) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(appr);
    args_[4] = TcUtility.createArg(byAbsOccID);
    args_[5] = TcUtility.createArg(searchAllContexts);
    args_[6] = TcUtility.createArgStringUnion(bomContextLine_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "findConfigedBOMLinesForAbsOccOrAPN", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lines.value = TcUtility.queryArg(response.output[0], lines.value);
    lineTypes.value = TcUtility.queryArg(response.output[1], lineTypes.value);
  }

  public void findConfigedBOMLinesForAbsOccID(String window, String ID, boolean searchAllContexts, String bomContextLine_uid, uidSeq_tHolder lines, uidSeq_tHolder lineTypes) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArgStringUnion(ID);
    args_[4] = TcUtility.createArg(searchAllContexts);
    args_[5] = TcUtility.createArgStringUnion(bomContextLine_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "findConfigedBOMLinesForAbsOccID", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lines.value = TcUtility.queryArg(response.output[0], lines.value);
    lineTypes.value = TcUtility.queryArg(response.output[1], lineTypes.value);
  }

  public void askVariantRule(String window, StringHolder bomVariantRule, StringHolder bomVariantRuleType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "askVariantRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomVariantRule.value = TcUtility.queryArg(response.output[0], bomVariantRule.value);
    bomVariantRuleType.value = TcUtility.queryArg(response.output[1], bomVariantRuleType.value);
  }

  public void setVrule(String window, String vrule) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(vrule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "setVrule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void showVariants(String window) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "showVariants", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void hideVariants(String window) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "hideVariants", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void close(String window) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "close", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setRevisionRule(String window, String vrule) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(vrule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "setRevisionRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setECObject(String window, String ecUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(ecUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "setECObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setECFlag(String window, boolean ecFlag) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(ecFlag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "setECFlag", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setConfigurationContext(String window, String config) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(config);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "setConfigurationContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askECObject(String window, StringHolder ecUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "askECObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ecUid.value = TcUtility.queryArg(response.output[0], ecUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void askBvr(String window, StringHolder bvrUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "askBvr", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bvrUid.value = TcUtility.queryArg(response.output[0], bvrUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void askECFlag(String window, BooleanHolder ecFlag) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "askECFlag", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ecFlag.value = TcUtility.queryArg(response.output[0], ecFlag.value);
  }

  public void getBulletinBoardEvents(longSeq_tHolder eventTypes, uidSeq_tHolder blTypes, uidSeq_tHolder bomlines, uidSeq_tHolder pTypes, uidSeq_tHolder parents, uidSeq_tHolder sibTypes, uidSeq_tHolder prevSiblings) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "getBulletinBoardEvents", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    eventTypes.value = TcUtility.queryArg(response.output[0], eventTypes.value);
    blTypes.value = TcUtility.queryArg(response.output[1], blTypes.value);
    bomlines.value = TcUtility.queryArg(response.output[2], bomlines.value);
    pTypes.value = TcUtility.queryArg(response.output[3], pTypes.value);
    parents.value = TcUtility.queryArg(response.output[4], parents.value);
    sibTypes.value = TcUtility.queryArg(response.output[5], sibTypes.value);
    prevSiblings.value = TcUtility.queryArg(response.output[6], prevSiblings.value);
  }

  public void createSnapshot(String window, String name, String description) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArgStringUnion(name);
    args_[4] = TcUtility.createArgStringUnion(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "createSnapshot", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createFromSnapshot(String snapshot, StringHolder bomWindow, StringHolder bomWindowType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(snapshot);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "createFromSnapshot", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomWindow.value = TcUtility.queryArg(response.output[0], bomWindow.value);
    bomWindowType.value = TcUtility.queryArg(response.output[1], bomWindowType.value);
  }

  public void updateForImportedItems(String window, String[] items) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(items);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "updateForImportedItems", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void newIrfWhereConfigured(String window, String itemRevision) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(itemRevision);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "newIrfWhereConfigured", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void newIrfWhereConfiguredNotPse(String window, String itemRevision) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(itemRevision);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "newIrfWhereConfiguredNotPse", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void showsUnconfiguredOccs(String window, BooleanHolder showsUnconfigured) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "showsUnconfiguredOccs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    showsUnconfigured.value = TcUtility.queryArg(response.output[0], showsUnconfigured.value);
  }

  public void showUnconfiguredOccs(String window, boolean showUnconfigured) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(showUnconfigured);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "showUnconfiguredOccs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void showsGCSCPs(String window, BooleanHolder showsGCSCPsVar) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "showsGCSCPs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    showsGCSCPsVar.value = TcUtility.queryArg(response.output[0], showsGCSCPsVar.value);
  }

  public void showGCSCPs(String window, boolean showGCSCPsVar) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(showGCSCPsVar);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "showGCSCPs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void showsSuppressedOccs(String window, BooleanHolder showsSuppressed) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "showsSuppressedOccs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    showsSuppressed.value = TcUtility.queryArg(response.output[0], showsSuppressed.value);
  }

  public void showSuppressedOccs(String window, boolean showSuppressed) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(showSuppressed);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "showSuppressedOccs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void showUnconfiguredChanges(String window, boolean showUnconfigured) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(showUnconfigured);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "showUnconfiguredChanges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAssemblySpatialExtents(String window, doubleValueSeq_tHolder extents) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "getAssemblySpatialExtents", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extents.value = TcUtility.queryArg(response.output[0], extents.value);
  }

  public void createBaseline(String window, String baselineRevId, String description, String baselineProcedureName, String jobName, String baselineLabelName, String jobDescription, StringHolder baselineRevUid, StringHolder baselineRevTypeUid, StringHolder reportLocation) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(baselineRevId);
    args_[4] = TcUtility.createArgStringUnion(description);
    args_[5] = TcUtility.createArgStringUnion(baselineProcedureName);
    args_[6] = TcUtility.createArgStringUnion(jobName);
    args_[7] = TcUtility.createArgStringUnion(baselineLabelName);
    args_[8] = TcUtility.createArgStringUnion(jobDescription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "createBaseline", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    baselineRevUid.value = TcUtility.queryArg(response.output[0], baselineRevUid.value);
    baselineRevTypeUid.value = TcUtility.queryArg(response.output[1], baselineRevTypeUid.value);
    reportLocation.value = TcUtility.queryArgStringUnion(response.output[2], reportLocation.value);
  }

  public void mapBOMLine(String window, String line, StringHolder mappedLineUid, StringHolder mappedLineTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(line);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "mapBOMLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mappedLineUid.value = TcUtility.queryArg(response.output[0], mappedLineUid.value);
    mappedLineTypeUid.value = TcUtility.queryArg(response.output[1], mappedLineTypeUid.value);
  }

  public void mockCreateBaseline(String window, String baselineProcedureName, StringHolder reportLocation) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArgStringUnion(baselineProcedureName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "mockCreateBaseline", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    reportLocation.value = TcUtility.queryArg(response.output[0], reportLocation.value);
  }

  public void clearSpecialLines(String window, short mode) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(mode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "clearSpecialLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getGenericComponents(String window, uidSeq_tHolder genericComponentLines) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "getGenericComponents", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    genericComponentLines.value = TcUtility.queryArg(response.output[0], genericComponentLines.value);
  }

  public void getBOMLineFromAppearancePathNode(String window, String pathNode, String intermediateParentLine, StringHolder bomLine, StringHolder bomLineType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(pathNode);
    args_[4] = TcUtility.createArgStringUnion(intermediateParentLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "getBOMLineFromAppearancePathNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomLine.value = TcUtility.queryArgStringUnion(response.output[0], bomLine.value);
    bomLineType.value = TcUtility.queryArgStringUnion(response.output[1], bomLineType.value);
  }

  public void showOrHideOccTypeFilters(String bomWindow, boolean isShown) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomWindow);
    args_[3] = TcUtility.createArg(isShown);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "showOrHideOccTypeFilters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setOccTypeFilters(String bomWindow, String[] nameList) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomWindow);
    args_[3] = TcUtility.createArg(nameList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "setOccTypeFilters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getOccTypeFilters(String bomWindow, stringSeq_tHolder nameList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "getOccTypeFilters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nameList.value = TcUtility.queryArg(response.output[0], nameList.value);
  }

  public void askActiveArrangement(String window, StringHolder arrangement, StringHolder arrangementType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "askActiveArrangement", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    arrangement.value = TcUtility.queryArg(response.output[0], arrangement.value);
    arrangementType.value = TcUtility.queryArg(response.output[1], arrangementType.value);
  }

  public void setActiveArrangement(String window, String arrangement) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    args_[3] = TcUtility.createArg(arrangement);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "setActiveArrangement", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void okToModifyInIC(String bomWindow, String compObject, BooleanHolder modifiable) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomWindow);
    args_[3] = TcUtility.createArg(compObject);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWindow", "okToModifyInIC", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    modifiable.value = TcUtility.queryArg(response.output[0], modifiable.value);
  }

}
