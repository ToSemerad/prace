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

public class ICCTBOMLine extends ICCT {
  public ICCTBOMLine(Connection connection) {
    super(connection);
  }

  public ICCTBOMLine(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void assignAsChild(String bomline, String sourceLine, String occType, StringHolder newChildLine, StringHolder newChildLineType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArg(sourceLine);
    args_[4] = TcUtility.createArgStringUnion(occType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "assignAsChild", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newChildLine.value = TcUtility.queryArg(response.output[0], newChildLine.value);
    newChildLineType.value = TcUtility.queryArg(response.output[1], newChildLineType.value);
  }

  public void replace(String bomline, String item, String rev, String bv) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArgStringUnion(item);
    args_[4] = TcUtility.createArgStringUnion(rev);
    args_[5] = TcUtility.createArgStringUnion(bv);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "replace", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void replaceGDE(String gdeline, String gde) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(gdeline);
    args_[3] = TcUtility.createArgStringUnion(gde);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "replaceGDE", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void add(String bomline, String item, String rev, String bv, boolean asSubstitute, String occType, StringHolder newLine, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArgStringUnion(item);
    args_[4] = TcUtility.createArgStringUnion(rev);
    args_[5] = TcUtility.createArgStringUnion(bv);
    args_[6] = TcUtility.createArg(asSubstitute);
    args_[7] = TcUtility.createArgStringUnion(occType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "add", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newLine.value = TcUtility.queryArg(response.output[0], newLine.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void addline(String bomline, String childLine, boolean asSubstitute, String occType, StringHolder newLine, StringHolder type, boolean propaXform) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArg(childLine);
    args_[4] = TcUtility.createArg(asSubstitute);
    args_[5] = TcUtility.createArgStringUnion(occType);
    args_[6] = TcUtility.createArg(propaXform);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "addline", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newLine.value = TcUtility.queryArg(response.output[0], newLine.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void addGDE(String bomline, String aGDE, String occType, StringHolder newLine, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArgStringUnion(aGDE);
    args_[4] = TcUtility.createArgStringUnion(occType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "addGDE", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newLine.value = TcUtility.queryArg(response.output[0], newLine.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void addGDELine(String bomline, String aGDELine, String occType, StringHolder newLine, StringHolder typeUid, boolean propaXform) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArgStringUnion(aGDELine);
    args_[4] = TcUtility.createArgStringUnion(occType);
    args_[5] = TcUtility.createArg(propaXform);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "addGDELine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newLine.value = TcUtility.queryArg(response.output[0], newLine.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void addPredecessor(String bomline, String predBomline) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArg(predBomline);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "addPredecessor", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removePredecessor(String bomline, String predBomline) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArg(predBomline);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "removePredecessor", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void generateXML(String bomLine, String publishRulesKey, StringHolder fileLocation) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArg(publishRulesKey);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "generateXML", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileLocation.value = TcUtility.queryArg(response.output[0], fileLocation.value);
  }

  public void removeAppearance(String bomline, String appearance, boolean asRequired) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArg(appearance);
    args_[4] = TcUtility.createArg(asRequired);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "removeAppearance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void linkToAppearance(String bomline, String appline, boolean asRequired) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArg(appline);
    args_[4] = TcUtility.createArg(asRequired);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "linkToAppearance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askLinkedAppearance(String bomline, boolean getRequired, uidSeq_tHolder appearances) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArg(getRequired);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askLinkedAppearance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    appearances.value = TcUtility.queryArg(response.output[0], appearances.value);
  }

  public void askAppearanceLinks(String bomline, String relationType, uidSeq_tHolder linkedOccs) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArgStringUnion(relationType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askAppearanceLinks", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    linkedOccs.value = TcUtility.queryArg(response.output[0], linkedOccs.value);
  }

  public void askAppearancePathNode(String bomline, String contextLine, StringHolder apn, StringHolder apnType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArgStringUnion(contextLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askAppearancePathNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    apn.value = TcUtility.queryArgStringUnion(response.output[0], apn.value);
    apnType.value = TcUtility.queryArgStringUnion(response.output[1], apnType.value);
  }

  public void getNewSequenceNumber(String bomline, String item, StringHolder seqNo) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArgStringUnion(item);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "getNewSequenceNumber", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    seqNo.value = TcUtility.queryArgStringUnion(response.output[0], seqNo.value);
  }

  public void cut(String bomline) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "cut", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void bomCompare(String bomLine1, String bomLine2, short mode, short desiredOutputMode, BooleanHolder anyDiffs) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine1);
    args_[3] = TcUtility.createArg(bomLine2);
    args_[4] = TcUtility.createArg(mode);
    args_[5] = TcUtility.createArg(desiredOutputMode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "bomCompare", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    anyDiffs.value = TcUtility.queryArg(response.output[0], anyDiffs.value);
  }

  public void bomCompareModes(boolean visibleOnly, stringSeq_tHolder modes, stringSeq_tHolder displayNames) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(visibleOnly);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "bomCompareModes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    modes.value = TcUtility.queryArg(response.output[0], modes.value);
    displayNames.value = TcUtility.queryArg(response.output[1], displayNames.value);
  }

  public void bomCompareExecute(String bomLine1, String bomLine2, String modeName, short desiredOutputMode, BooleanHolder anyDiffs) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine1);
    args_[3] = TcUtility.createArg(bomLine2);
    args_[4] = TcUtility.createArgStringUnion(modeName);
    args_[5] = TcUtility.createArg(desiredOutputMode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "bomCompareExecute", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    anyDiffs.value = TcUtility.queryArg(response.output[0], anyDiffs.value);
  }

  public void bomCompareReport(String bomLine, stringSeq_tHolder reportLines, uidSeq_tHolder reportItems) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "bomCompareReport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    reportLines.value = TcUtility.queryArg(response.output[0], reportLines.value);
    reportItems.value = TcUtility.queryArg(response.output[1], reportItems.value);
  }

  public void bomCompareListBomlines(String cmpItem, uidSeq_tHolder lists1, uidSeq_tHolder listTypes1, uidSeq_tHolder lists2, uidSeq_tHolder listTypes2) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(cmpItem);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "bomCompareListBomlines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lists1.value = TcUtility.queryArg(response.output[0], lists1.value);
    listTypes1.value = TcUtility.queryArg(response.output[1], listTypes1.value);
    lists2.value = TcUtility.queryArg(response.output[2], lists2.value);
    listTypes2.value = TcUtility.queryArg(response.output[3], listTypes2.value);
  }

  public void bomCompareClear(String bomLine) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "bomCompareClear", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void bomCompareSetStopLine(String bomLine) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "bomCompareSetStopLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void bomCompareSetStopLines(String rootLine, String[] bomLines) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rootLine);
    args_[3] = TcUtility.createArg(bomLines);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "bomCompareSetStopLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void bomCompareClearStopLine(String bomLine) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "bomCompareClearStopLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void bomCompareListDiffs(String bomLine, uidSeq_tHolder diffLines, uidSeq_tHolder diffLineTypes, longSeq_tHolder diffFlags) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "bomCompareListDiffs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    diffLines.value = TcUtility.queryArg(response.output[0], diffLines.value);
    diffLineTypes.value = TcUtility.queryArg(response.output[1], diffLineTypes.value);
    diffFlags.value = TcUtility.queryArg(response.output[2], diffFlags.value);
  }

  public void listSubstitutes(String bomLine, uidSeq_tHolder substitutes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "listSubstitutes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    substitutes.value = TcUtility.queryArg(response.output[0], substitutes.value);
  }

  public void getRemoteChildren(String bomLine, uidSeq_tHolder remotes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "getRemoteChildren", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    remotes.value = TcUtility.queryArg(response.output[0], remotes.value);
  }

  public void askRemoteObjectPublicationRecords(String[] bomLines, uidSeq_tHolder pubRecs, uidSeq_tHolder pubRecTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLines);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askRemoteObjectPublicationRecords", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pubRecs.value = TcUtility.queryArg(response.output[0], pubRecs.value);
    pubRecTypes.value = TcUtility.queryArg(response.output[1], pubRecTypes.value);
  }

  public void preferSubstitute(String bomLine, BooleanHolder isTemporary) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "preferSubstitute", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isTemporary.value = TcUtility.queryArg(response.output[0], isTemporary.value);
  }

  public void isReplaceable(String bomLine, BooleanHolder verdict) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "isReplaceable", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void setPrecision(String bomLine, boolean whetherPrecise) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArg(whetherPrecise);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "setPrecision", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void pack(String bomLine) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "pack", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unpack(String bomLine) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "unpack", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void isPacked(String bomLine, BooleanHolder verdict) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "isPacked", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void setOccurrenceEffectivity(String bomLine, String effectivityObject) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArgStringUnion(effectivityObject);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "setOccurrenceEffectivity", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askOccurrenceEffectivity(String bomLine, StringHolder effectivityObject, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askOccurrenceEffectivity", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    effectivityObject.value = TcUtility.queryArg(response.output[0], effectivityObject.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void loadAncestors(String bomLine, boolean one_level) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArg(one_level);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "loadAncestors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createAddIce(String bomLine, StringHolder newIce, StringHolder newIceType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "createAddIce", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newIce.value = TcUtility.queryArg(response.output[0], newIce.value);
    newIceType.value = TcUtility.queryArg(response.output[1], newIceType.value);
  }

  public void createRemoveIce(String bomLine, StringHolder newIce, StringHolder newIceType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "createRemoveIce", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newIce.value = TcUtility.queryArg(response.output[0], newIce.value);
    newIceType.value = TcUtility.queryArg(response.output[1], newIceType.value);
  }

  public void changeToReplace(String deletedBOMLine, String addedBOMLine) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(deletedBOMLine);
    args_[3] = TcUtility.createArg(addedBOMLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "changeToReplace", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createVi(String bomLine, boolean isLinkedToGenericComponent, String itemId, String itemName, String typeName, String revId, StringHolder newItem, StringHolder newRev) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArg(isLinkedToGenericComponent);
    args_[4] = TcUtility.createArgStringUnion(itemId);
    args_[5] = TcUtility.createArgStringUnion(itemName);
    args_[6] = TcUtility.createArgStringUnion(typeName);
    args_[7] = TcUtility.createArgStringUnion(revId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "createVi", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newItem.value = TcUtility.queryArg(response.output[0], newItem.value);
    newRev.value = TcUtility.queryArg(response.output[1], newRev.value);
  }

  public void configureInVi(String bomLine, String variantItem) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArg(variantItem);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "configureInVi", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askCanSearchForViFromParent(String bomLine, BooleanHolder reuseIdIsPossible) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askCanSearchForViFromParent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    reuseIdIsPossible.value = TcUtility.queryArg(response.output[0], reuseIdIsPossible.value);
  }

  public void mapViRequirementsFromParent(String bomLine, String[] items, String[] options, int[] ops, int[] valueTypes, String[] lowValues, String[] highValues, uidSeqValue_uHolder itemsOut, stringSeqValue_uHolder optionsOut, longSeqValue_uHolder opsOut, longSeqValue_uHolder valueTypesOut, stringSeqValue_uHolder lowValuesOut, stringSeqValue_uHolder highValuesOut) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArg(items);
    args_[4] = TcUtility.createArg(options);
    args_[5] = TcUtility.createArg(ops);
    args_[6] = TcUtility.createArg(valueTypes);
    args_[7] = TcUtility.createArg(lowValues);
    args_[8] = TcUtility.createArg(highValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "mapViRequirementsFromParent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    itemsOut.value = TcUtility.queryArg(response.output[0], itemsOut.value);
    optionsOut.value = TcUtility.queryArg(response.output[1], optionsOut.value);
    opsOut.value = TcUtility.queryArg(response.output[2], opsOut.value);
    valueTypesOut.value = TcUtility.queryArg(response.output[3], valueTypesOut.value);
    lowValuesOut.value = TcUtility.queryArg(response.output[4], lowValuesOut.value);
    highValuesOut.value = TcUtility.queryArg(response.output[5], highValuesOut.value);
  }

  public void askPropertyContext(String bomLine, String propertyName, StringHolder contextLine) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArgStringUnion(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askPropertyContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    contextLine.value = TcUtility.queryArg(response.output[0], contextLine.value);
  }

  public void askPropertyArrangementContext(String bomLine, String propertyName, StringHolder contextLine, StringHolder contextArrangement) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArgStringUnion(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askPropertyArrangementContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    contextLine.value = TcUtility.queryArg(response.output[0], contextLine.value);
    contextArrangement.value = TcUtility.queryArg(response.output[1], contextArrangement.value);
  }

  public void deletePropertyContext(String bomLine, String propertyName, String contextLine) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArgStringUnion(propertyName);
    args_[4] = TcUtility.createArg(contextLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "deletePropertyContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getPropertyAndContext(String bomLine, String propertyName, StringHolder propertyUIFValue, StringHolder contextLine) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "getPropertyAndContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyUIFValue.value = TcUtility.queryArgStringUnion(response.output[0], propertyUIFValue.value);
    contextLine.value = TcUtility.queryArg(response.output[1], contextLine.value);
  }

  public void getPropertiesAndContexts(String bomLine, String[] propertyNames, stringValueSeq_tHolder propertyUIFValues, uidSeq_tHolder contextLines) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLine);
    args_[3] = TcUtility.createArg(propertyNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "getPropertiesAndContexts", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propertyUIFValues.value = TcUtility.queryArgStringUnion(response.output[0], propertyUIFValues.value);
    contextLines.value = TcUtility.queryArg(response.output[1], contextLines.value);
  }

  public void disconnect(String lineUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "disconnect", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addToConnection(String connLineUid, String[] lineUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(connLineUid);
    args_[3] = TcUtility.createArg(lineUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "addToConnection", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void connectUsingGDELink(String connName, String connType, String[] lineUids, StringHolder newConnLineUid, StringHolder newConnLineType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(connName);
    args_[3] = TcUtility.createArgStringUnion(connType);
    args_[4] = TcUtility.createArg(lineUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "connectUsingGDELink", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newConnLineUid.value = TcUtility.queryArg(response.output[0], newConnLineUid.value);
    newConnLineType.value = TcUtility.queryArg(response.output[1], newConnLineType.value);
  }

  public void Connect(String connId, String connName, String connType, String connRev, String[] lineUids, StringHolder newConnLineUid, StringHolder newConnLineType) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(connId);
    args_[3] = TcUtility.createArgStringUnion(connName);
    args_[4] = TcUtility.createArgStringUnion(connType);
    args_[5] = TcUtility.createArgStringUnion(connRev);
    args_[6] = TcUtility.createArg(lineUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "Connect", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newConnLineUid.value = TcUtility.queryArg(response.output[0], newConnLineUid.value);
    newConnLineType.value = TcUtility.queryArg(response.output[1], newConnLineType.value);
  }

  public void removeFromConnection(String connLineUid, String[] lineUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(connLineUid);
    args_[3] = TcUtility.createArg(lineUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "removeFromConnection", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listConnectedPorts(String connLineUid, uidSeq_tHolder connectedLines, uidSeq_tHolder connectedLineTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(connLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "listConnectedPorts", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    connectedLines.value = TcUtility.queryArg(response.output[0], connectedLines.value);
    connectedLineTypes.value = TcUtility.queryArg(response.output[1], connectedLineTypes.value);
  }

  public void setSignalPvariable(String signalLineUid, String pvariableLineUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signalLineUid);
    args_[3] = TcUtility.createArg(pvariableLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "setSignalPvariable", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unsetSignalPvariable(String signalLineUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signalLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "unsetSignalPvariable", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askSignalPvariable(String signalLineUid, StringHolder pvariableLineUid, StringHolder pvariableTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signalLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askSignalPvariable", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pvariableLineUid.value = TcUtility.queryArg(response.output[0], pvariableLineUid.value);
    pvariableTypeUid.value = TcUtility.queryArg(response.output[1], pvariableTypeUid.value);
  }

  public void askSignalPvariables(String signalLineUid, uidSeq_tHolder pvariableLines, uidSeq_tHolder pvariableLinesTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signalLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askSignalPvariables", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pvariableLines.value = TcUtility.queryArg(response.output[0], pvariableLines.value);
    pvariableLinesTypes.value = TcUtility.queryArg(response.output[1], pvariableLinesTypes.value);
  }

  public void askSignalsOfPvariable(String pvariableLineUid, uidSeq_tHolder signalLines, uidSeq_tHolder signalLinesTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(pvariableLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askSignalsOfPvariable", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    signalLines.value = TcUtility.queryArg(response.output[0], signalLines.value);
    signalLinesTypes.value = TcUtility.queryArg(response.output[1], signalLinesTypes.value);
  }

  public void setAssociatedSystem(String line1Uid, String line2Uid, String role) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(line1Uid);
    args_[3] = TcUtility.createArg(line2Uid);
    args_[4] = TcUtility.createArgStringUnion(role);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "setAssociatedSystem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unsetAssociatedSystem(String line1Uid, String line2Uid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(line1Uid);
    args_[3] = TcUtility.createArg(line2Uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "unsetAssociatedSystem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setAssociatedSystems(String line1Uid, String[] linesUid, String role) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(line1Uid);
    args_[3] = TcUtility.createArg(linesUid);
    args_[4] = TcUtility.createArgStringUnion(role);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "setAssociatedSystems", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unsetAssociatedSystems(String line1Uid, String[] linesUid, String role) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(line1Uid);
    args_[3] = TcUtility.createArg(linesUid);
    args_[4] = TcUtility.createArgStringUnion(role);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "unsetAssociatedSystems", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askAssociatedSystems(String lineUid, uidSeq_tHolder associatedSystemLines, uidSeq_tHolder associatedSystemTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askAssociatedSystems", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    associatedSystemLines.value = TcUtility.queryArg(response.output[0], associatedSystemLines.value);
    associatedSystemTypes.value = TcUtility.queryArg(response.output[1], associatedSystemTypes.value);
  }

  public void askAssociatedSystemRole(String line1Uid, String line2Uid, StringHolder role) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(line1Uid);
    args_[3] = TcUtility.createArg(line2Uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askAssociatedSystemRole", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    role.value = TcUtility.queryArgStringUnion(response.output[0], role.value);
  }

  public void setRedundantSignals(String signalLineUid, String[] redundantSignalLines) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signalLineUid);
    args_[3] = TcUtility.createArg(redundantSignalLines);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "setRedundantSignals", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unsetRedundantSignals(String signalLineUid, String[] redundantSignalLines) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signalLineUid);
    args_[3] = TcUtility.createArg(redundantSignalLines);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "unsetRedundantSignals", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askRedundantSignals(String signalLineUid, uidSeq_tHolder redundantSignalLines, uidSeq_tHolder redundantSignalTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signalLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askRedundantSignals", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    redundantSignalLines.value = TcUtility.queryArg(response.output[0], redundantSignalLines.value);
    redundantSignalTypes.value = TcUtility.queryArg(response.output[1], redundantSignalTypes.value);
  }

  public void setSignalLineValue(String signalLineUid, double signal_value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signalLineUid);
    args_[3] = TcUtility.createArg(signal_value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "setSignalLineValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askSignalLineValue(String signalLineUid, DoubleHolder signal_value) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(signalLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askSignalLineValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    signal_value.value = TcUtility.queryArg(response.output[0], signal_value.value);
  }

  public void askSourcesOfDevice(String lineUid, uidSeq_tHolder sourceLines, uidSeq_tHolder sourceTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askSourcesOfDevice", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    sourceLines.value = TcUtility.queryArg(response.output[0], sourceLines.value);
    sourceTypes.value = TcUtility.queryArg(response.output[1], sourceTypes.value);
  }

  public void askTargetsOfDevice(String lineUid, uidSeq_tHolder targetLines, uidSeq_tHolder targetTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askTargetsOfDevice", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    targetLines.value = TcUtility.queryArg(response.output[0], targetLines.value);
    targetTypes.value = TcUtility.queryArg(response.output[1], targetTypes.value);
  }

  public void askSourcesOfSignal(String lineUid, uidSeq_tHolder sourceLines, uidSeq_tHolder sourceTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askSourcesOfSignal", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    sourceLines.value = TcUtility.queryArg(response.output[0], sourceLines.value);
    sourceTypes.value = TcUtility.queryArg(response.output[1], sourceTypes.value);
  }

  public void askTargetsOfSignal(String lineUid, uidSeq_tHolder targetLines, uidSeq_tHolder targetTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askTargetsOfSignal", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    targetLines.value = TcUtility.queryArg(response.output[0], targetLines.value);
    targetTypes.value = TcUtility.queryArg(response.output[1], targetTypes.value);
  }

  public void askTransmittersOfSignal(String lineUid, uidSeq_tHolder txmttrLines, uidSeq_tHolder txmttrTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askTransmittersOfSignal", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    txmttrLines.value = TcUtility.queryArg(response.output[0], txmttrLines.value);
    txmttrTypes.value = TcUtility.queryArg(response.output[1], txmttrTypes.value);
  }

  public void askTransmittedSignalsOfDevice(String lineUid, uidSeq_tHolder txmttdLines, uidSeq_tHolder txmttdTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askTransmittedSignalsOfDevice", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    txmttdLines.value = TcUtility.queryArg(response.output[0], txmttdLines.value);
    txmttdTypes.value = TcUtility.queryArg(response.output[1], txmttdTypes.value);
  }

  public void askReceivedSignalsOfDevice(String lineUid, uidSeq_tHolder receivedLines, uidSeq_tHolder receivedTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "askReceivedSignalsOfDevice", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    receivedLines.value = TcUtility.queryArg(response.output[0], receivedLines.value);
    receivedTypes.value = TcUtility.queryArg(response.output[1], receivedTypes.value);
  }

  public void removeImplementedBy(String primaryLineUid, String[] lineUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(primaryLineUid);
    args_[3] = TcUtility.createArg(lineUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "removeImplementedBy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeRealizedBy(String primaryLineUid, String[] lineUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(primaryLineUid);
    args_[3] = TcUtility.createArg(lineUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "removeRealizedBy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setImplementedBy(String primaryLineUid, String secondaryLineUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(primaryLineUid);
    args_[3] = TcUtility.createArg(secondaryLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "setImplementedBy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setRealizedBy(String primaryLineUid, String secondaryLineUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(primaryLineUid);
    args_[3] = TcUtility.createArg(secondaryLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "setRealizedBy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getImplementedBy(String primaryLineUid, uidSeq_tHolder implementedByLines, uidSeq_tHolder implementedByLineTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(primaryLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "getImplementedBy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    implementedByLines.value = TcUtility.queryArg(response.output[0], implementedByLines.value);
    implementedByLineTypes.value = TcUtility.queryArg(response.output[1], implementedByLineTypes.value);
  }

  public void getRealizedBy(String primaryLineUid, uidSeq_tHolder realizedByLines, uidSeq_tHolder realizedByLineTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(primaryLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "getRealizedBy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    realizedByLines.value = TcUtility.queryArg(response.output[0], realizedByLines.value);
    realizedByLineTypes.value = TcUtility.queryArg(response.output[1], realizedByLineTypes.value);
  }

  public void getImplementingLines(String secondaryLineUid, uidSeq_tHolder implementingLines, uidSeq_tHolder implementingLineTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(secondaryLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "getImplementingLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    implementingLines.value = TcUtility.queryArg(response.output[0], implementingLines.value);
    implementingLineTypes.value = TcUtility.queryArg(response.output[1], implementingLineTypes.value);
  }

  public void getRealizingLines(String secondaryLineUid, uidSeq_tHolder realizingLines, uidSeq_tHolder realizingLineTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(secondaryLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "getRealizingLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    realizingLines.value = TcUtility.queryArg(response.output[0], realizingLines.value);
    realizingLineTypes.value = TcUtility.queryArg(response.output[1], realizingLineTypes.value);
  }

  public void removeBOMLineIncrementalChanges(String lineUid, String[] iceUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    args_[3] = TcUtility.createArg(iceUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "removeBOMLineIncrementalChanges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeAbsOccDataIncrementalChanges(String lineUid, String[] iceUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    args_[3] = TcUtility.createArg(iceUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "removeAbsOccDataIncrementalChanges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addRelatedSubstitutes(String[] subItems, String[] occurrences) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(subItems);
    args_[3] = TcUtility.createArg(occurrences);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "addRelatedSubstitutes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeRelatedSubstitutes(String[] subItems, String[] occurrences) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(subItems);
    args_[3] = TcUtility.createArg(occurrences);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "removeRelatedSubstitutes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listRelatedSubstitutes(String[] bomLines, uidSeqValue_uHolder relatedOccurrences, uidSeqValue_uHolder relatedOccTypes, uidSeqValue_uHolder relatedItems, uidSeqValue_uHolder relatedItemTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLines);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "listRelatedSubstitutes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    relatedOccurrences.value = TcUtility.queryArg(response.output[0], relatedOccurrences.value);
    relatedOccTypes.value = TcUtility.queryArg(response.output[1], relatedOccTypes.value);
    relatedItems.value = TcUtility.queryArg(response.output[2], relatedItems.value);
    relatedItemTypes.value = TcUtility.queryArg(response.output[3], relatedItemTypes.value);
  }

  public void getAllAbsOccData(String lineUid, uidSeq_tHolder absOccData, uidValueSeq_tHolder absOccIces, uidValueSeq_tHolder qualBvrs, stringValueSeq_tHolder propNames, stringValueSeq_tHolder propValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "getAllAbsOccData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    absOccData.value = TcUtility.queryArg(response.output[0], absOccData.value);
    absOccIces.value = TcUtility.queryArgStringUnion(response.output[1], absOccIces.value);
    qualBvrs.value = TcUtility.queryArgStringUnion(response.output[2], qualBvrs.value);
    propNames.value = TcUtility.queryArgStringUnion(response.output[3], propNames.value);
    propValues.value = TcUtility.queryArgStringUnion(response.output[4], propValues.value);
  }

  public void addOptional(String bomline, String item, String rev, String bv) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArgStringUnion(item);
    args_[4] = TcUtility.createArgStringUnion(rev);
    args_[5] = TcUtility.createArgStringUnion(bv);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "addOptional", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeOptional(String bomline, String item, String rev, String bv) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArgStringUnion(item);
    args_[4] = TcUtility.createArgStringUnion(rev);
    args_[5] = TcUtility.createArgStringUnion(bv);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "removeOptional", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getOptionals(String bomline, uidSeqValue_uHolder items, uidSeqValue_uHolder itemTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMLine", "getOptionals", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    items.value = TcUtility.queryArg(response.output[0], items.value);
    itemTypes.value = TcUtility.queryArg(response.output[1], itemTypes.value);
  }

}
