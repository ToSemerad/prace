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

public class ICCTEngineeringChange extends ICCT {
  public ICCTEngineeringChange(Connection connection) {
    super(connection);
  }

  public ICCTEngineeringChange(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String id, String rev, String name, String ectype, String description, StringHolder newItem, StringHolder revUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(id);
    args_[3] = TcUtility.createArg(rev);
    args_[4] = TcUtility.createArg(name);
    args_[5] = TcUtility.createArg(ectype);
    args_[6] = TcUtility.createArgStringUnion(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newItem.value = TcUtility.queryArg(response.output[0], newItem.value);
    revUid.value = TcUtility.queryArg(response.output[1], revUid.value);
    typeUid.value = TcUtility.queryArg(response.output[2], typeUid.value);
  }

  public void setECdescription(String rev, String desc) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    args_[3] = TcUtility.createArg(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "setECdescription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getECdescription(String rev, StringHolder desc) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getECdescription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    desc.value = TcUtility.queryArg(response.output[0], desc.value);
  }

  public void setECType(String rev, String type) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    args_[3] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "setECType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getECType(String rev, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getECType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    type.value = TcUtility.queryArg(response.output[0], type.value);
  }

  public void getECFolderNames(stringSeq_tHolder folderNames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getECFolderNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    folderNames.value = TcUtility.queryArg(response.output[0], folderNames.value);
  }

  public void getFormRelation(StringHolder formRelationType) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getFormRelation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    formRelationType.value = TcUtility.queryArg(response.output[0], formRelationType.value);
  }

  public void getContents(String revUid, String folderName, uidSeqValue_uHolder uids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revUid);
    args_[3] = TcUtility.createArg(folderName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getContents", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uids.value = TcUtility.queryArg(response.output[0], uids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void attachRelatedItems(String rev, String folderName, String[] att_objs) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    args_[3] = TcUtility.createArg(folderName);
    args_[4] = TcUtility.createArg(att_objs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "attachRelatedItems", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeRelatedItems(String rev, String folderName, String[] att_objs) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    args_[3] = TcUtility.createArg(folderName);
    args_[4] = TcUtility.createArg(att_objs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "removeRelatedItems", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void clearAllFolders(String rev) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "clearAllFolders", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void find(String id, String revId, StringHolder uid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(id);
    args_[3] = TcUtility.createArg(revId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uid.value = TcUtility.queryArgStringUnion(response.output[0], uid.value);
    typeUid.value = TcUtility.queryArgStringUnion(response.output[1], typeUid.value);
  }

  public void findByType(String changeType, String change_id_key, String rev_id_key, uidSeqValue_uHolder chageRevs, uidSeqValue_uHolder changeRevTypes) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(changeType);
    args_[3] = TcUtility.createArg(change_id_key);
    args_[4] = TcUtility.createArg(rev_id_key);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "findByType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    chageRevs.value = TcUtility.queryArg(response.output[0], chageRevs.value);
    changeRevTypes.value = TcUtility.queryArg(response.output[1], changeRevTypes.value);
  }

  public void askPrevBvr(String rev, String bvrUid, StringHolder prevBvr, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    args_[3] = TcUtility.createArg(bvrUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "askPrevBvr", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    prevBvr.value = TcUtility.queryArgStringUnion(response.output[0], prevBvr.value);
    typeUid.value = TcUtility.queryArgStringUnion(response.output[1], typeUid.value);
  }

  public void revise(String uid, String revisionID, String name, String desc, StringHolder newItemRev, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(uid);
    args_[3] = TcUtility.createArg(revisionID);
    args_[4] = TcUtility.createArg(name);
    args_[5] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "revise", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newItemRev.value = TcUtility.queryArg(response.output[0], newItemRev.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void saveBomChanges(String rev, String window, String probWindow) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    args_[3] = TcUtility.createArg(window);
    args_[4] = TcUtility.createArgStringUnion(probWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "saveBomChanges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getBomChanges(String rev, String affBvr, int changeType, uidSeqValue_uHolder bomChanges, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    args_[3] = TcUtility.createArg(affBvr);
    args_[4] = TcUtility.createArg(changeType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getBomChanges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomChanges.value = TcUtility.queryArg(response.output[0], bomChanges.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void isAffectedItem(String ecUid, String objUid, BooleanHolder isAff) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ecUid);
    args_[3] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "isAffectedItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isAff.value = TcUtility.queryArg(response.output[0], isAff.value);
  }

  public void isProblemItem(String ecUid, String objUid, BooleanHolder isProb) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ecUid);
    args_[3] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "isProblemItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isProb.value = TcUtility.queryArg(response.output[0], isProb.value);
  }

  public void setProblemOfAffected(String ecUid, String affUid, String probUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ecUid);
    args_[3] = TcUtility.createArg(affUid);
    args_[4] = TcUtility.createArg(probUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "setProblemOfAffected", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getProblemOfAffected(String ecUid, String affUid, StringHolder probUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ecUid);
    args_[3] = TcUtility.createArg(affUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getProblemOfAffected", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    probUid.value = TcUtility.queryArgStringUnion(response.output[0], probUid.value);
    typeUid.value = TcUtility.queryArgStringUnion(response.output[1], typeUid.value);
  }

  public void isProblemRelnSet(String ecUid, String affUid, BooleanHolder isSet) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ecUid);
    args_[3] = TcUtility.createArg(affUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "isProblemRelnSet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isSet.value = TcUtility.queryArg(response.output[0], isSet.value);
  }

  public void getRevisionRules(String ecUid, String affBvrUid, StringHolder probRuleUid, StringHolder affRuleUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ecUid);
    args_[3] = TcUtility.createArg(affBvrUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getRevisionRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    probRuleUid.value = TcUtility.queryArgStringUnion(response.output[0], probRuleUid.value);
    affRuleUid.value = TcUtility.queryArgStringUnion(response.output[1], affRuleUid.value);
    typeUid.value = TcUtility.queryArgStringUnion(response.output[2], typeUid.value);
  }

  public void findAssociatedEC(String affected_rev_uid, StringHolder uid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(affected_rev_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "findAssociatedEC", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uid.value = TcUtility.queryArgStringUnion(response.output[0], uid.value);
    typeUid.value = TcUtility.queryArgStringUnion(response.output[1], typeUid.value);
  }

  public void getInitialAffectedRevs(String itemUid, uidSeqValue_uHolder revUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getInitialAffectedRevs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    revUids.value = TcUtility.queryArg(response.output[0], revUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void getFurtherAffectedRevs(String aRevUid, uidSeqValue_uHolder revUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(aRevUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getFurtherAffectedRevs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    revUids.value = TcUtility.queryArg(response.output[0], revUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void getDynamicBomChanges(String thisWindow, String prevWindow, IntHolder numCategories, longSeq_tHolder indvCount, uidSeqValue_uHolder lineUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisWindow);
    args_[3] = TcUtility.createArg(prevWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getDynamicBomChanges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    numCategories.value = TcUtility.queryArg(response.output[0], numCategories.value);
    indvCount.value = TcUtility.queryArg(response.output[1], indvCount.value);
    lineUids.value = TcUtility.queryArg(response.output[2], lineUids.value);
    typeUids.value = TcUtility.queryArg(response.output[3], typeUids.value);
  }

  public void getProcessName(String ecRev, String[] target_objs, StringHolder processName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ecRev);
    args_[3] = TcUtility.createArg(target_objs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "getProcessName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    processName.value = TcUtility.queryArg(response.output[0], processName.value);
  }

  public void setECReleaseStatus(String rev, String releaseStatus) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    args_[3] = TcUtility.createArg(releaseStatus);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "setECReleaseStatus", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void initialRenderingDetails(String ecUid, String affWindow, String probWindow, IntHolder numCategories, longSeq_tHolder indvCount, uidSeqValue_uHolder bomLines, uidSeqValue_uHolder supercededAddCancelUids, uidSeqValue_uHolder bomLineTypeUids, uidSeqValue_uHolder bomChangeTypeUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ecUid);
    args_[3] = TcUtility.createArg(affWindow);
    args_[4] = TcUtility.createArgStringUnion(probWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "initialRenderingDetails", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    numCategories.value = TcUtility.queryArg(response.output[0], numCategories.value);
    indvCount.value = TcUtility.queryArg(response.output[1], indvCount.value);
    bomLines.value = TcUtility.queryArg(response.output[2], bomLines.value);
    supercededAddCancelUids.value = TcUtility.queryArg(response.output[3], supercededAddCancelUids.value);
    bomLineTypeUids.value = TcUtility.queryArg(response.output[4], bomLineTypeUids.value);
    bomChangeTypeUids.value = TcUtility.queryArg(response.output[5], bomChangeTypeUids.value);
  }

  public void refreshRenderingDetails(String ecUid, String addLineUid, String cancelLineUid, boolean isAddingSupersedures, uidSeqValue_uHolder affBomLines, uidSeqValue_uHolder probBomLines, uidSeqValue_uHolder affBomLineTypeUids, uidSeqValue_uHolder probBomLineTypeUids) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ecUid);
    args_[3] = TcUtility.createArg(addLineUid);
    args_[4] = TcUtility.createArg(cancelLineUid);
    args_[5] = TcUtility.createArg(isAddingSupersedures);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "refreshRenderingDetails", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    affBomLines.value = TcUtility.queryArg(response.output[0], affBomLines.value);
    probBomLines.value = TcUtility.queryArg(response.output[1], probBomLines.value);
    affBomLineTypeUids.value = TcUtility.queryArg(response.output[2], affBomLineTypeUids.value);
    probBomLineTypeUids.value = TcUtility.queryArg(response.output[3], probBomLineTypeUids.value);
  }

  public void createECSnapshot(String ecUid, String description, StringHolder snapshotUid, StringHolder snapshotTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ecUid);
    args_[3] = TcUtility.createArgStringUnion(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "createECSnapshot", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    snapshotUid.value = TcUtility.queryArg(response.output[0], snapshotUid.value);
    snapshotTypeUid.value = TcUtility.queryArg(response.output[1], snapshotTypeUid.value);
  }

  public void openECSnapshot(String snapshotUid, String styleSheet, StringHolder dirPath, StringHolder fileName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(snapshotUid);
    args_[3] = TcUtility.createArgStringUnion(styleSheet);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEngineeringChange", "openECSnapshot", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    dirPath.value = TcUtility.queryArgStringUnion(response.output[0], dirPath.value);
    fileName.value = TcUtility.queryArgStringUnion(response.output[1], fileName.value);
  }

}
