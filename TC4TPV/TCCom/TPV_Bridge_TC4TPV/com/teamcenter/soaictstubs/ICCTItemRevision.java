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

public class ICCTItemRevision extends ICCT {
  public ICCTItemRevision(Connection connection) {
    super(connection);
  }

  public ICCTItemRevision(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void whereUsedInfo(String obj, int whereUsedType, String revisionRule, IntHolder componentCount, uidSeq_tHolder components, uidSeq_tHolder componentTypes) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(whereUsedType);
    args_[4] = TcUtility.createArgStringUnion(revisionRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "whereUsedInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentCount.value = TcUtility.queryArg(response.output[0], componentCount.value);
    components.value = TcUtility.queryArg(response.output[1], components.value);
    componentTypes.value = TcUtility.queryArg(response.output[2], componentTypes.value);
  }

  public void getWhereUsedCount(String comp, IntHolder whereUsedCount) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(comp);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "getWhereUsedCount", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    whereUsedCount.value = TcUtility.queryArg(response.output[0], whereUsedCount.value);
  }

  public void originalsaveAs(String rev, String revisionId, StringHolder newRev) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    args_[3] = TcUtility.createArgStringUnion(revisionId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "originalsaveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRev.value = TcUtility.queryArg(response.output[0], newRev.value);
  }

  public void saveAs(String revision, String itemId, String revId, String name, String desc, boolean deepCopyRequired, DeepCopyInfo_s[] DeepCopyInfo, String masterForm, String[] propertyNamesIM, propertyData_u[] propDataIM, String revMasterForm, String[] propertyNamesIRM, propertyData_u[] propDataIRM, uidSeq_tHolder deepCopiedObjects, uidSeq_tHolder deepCopiedObjectTypes, StringHolder newItem, StringHolder newItemType) throws Exception {
    Arg[] args_ = new Arg[15];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revision);
    args_[3] = TcUtility.createArg(itemId);
    args_[4] = TcUtility.createArg(revId);
    args_[5] = TcUtility.createArg(name);
    args_[6] = TcUtility.createArgStringUnion(desc);
    args_[7] = TcUtility.createArg(deepCopyRequired);
    args_[8] = TcUtility.createArg(DeepCopyInfo);
    args_[9] = TcUtility.createArgStringUnion(masterForm);
    args_[10] = TcUtility.createArg(propertyNamesIM);
    args_[11] = TcUtility.createArg(propDataIM);
    args_[12] = TcUtility.createArgStringUnion(revMasterForm);
    args_[13] = TcUtility.createArg(propertyNamesIRM);
    args_[14] = TcUtility.createArg(propDataIRM);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    deepCopiedObjects.value = TcUtility.queryArg(response.output[0], deepCopiedObjects.value);
    deepCopiedObjectTypes.value = TcUtility.queryArg(response.output[1], deepCopiedObjectTypes.value);
    newItem.value = TcUtility.queryArg(response.output[2], newItem.value);
    newItemType.value = TcUtility.queryArg(response.output[3], newItemType.value);
  }

  public void revise(String rev, String revisionId, String name, String desc, boolean deepCopyRequired, DeepCopyInfo_s[] DeepCopyInfo, String revMasterForm, String[] propertyNamesIRM, propertyData_u[] propDataIRM, uidSeq_tHolder deepCopiedObjects, uidSeq_tHolder deepCopiedObjectTypes, StringHolder newRev, StringHolder newRevType) throws Exception {
    Arg[] args_ = new Arg[11];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rev);
    args_[3] = TcUtility.createArg(revisionId);
    args_[4] = TcUtility.createArg(name);
    args_[5] = TcUtility.createArgStringUnion(desc);
    args_[6] = TcUtility.createArg(deepCopyRequired);
    args_[7] = TcUtility.createArg(DeepCopyInfo);
    args_[8] = TcUtility.createArgStringUnion(revMasterForm);
    args_[9] = TcUtility.createArg(propertyNamesIRM);
    args_[10] = TcUtility.createArg(propDataIRM);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "revise", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    deepCopiedObjects.value = TcUtility.queryArg(response.output[0], deepCopiedObjects.value);
    deepCopiedObjectTypes.value = TcUtility.queryArg(response.output[1], deepCopiedObjectTypes.value);
    newRev.value = TcUtility.queryArg(response.output[2], newRev.value);
    newRevType.value = TcUtility.queryArg(response.output[3], newRevType.value);
  }

  public void saveAsItem(String revision, String itemId, String revId, StringHolder newItem, StringHolder newItemType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revision);
    args_[3] = TcUtility.createArgStringUnion(itemId);
    args_[4] = TcUtility.createArgStringUnion(revId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "saveAsItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newItem.value = TcUtility.queryArg(response.output[0], newItem.value);
    newItemType.value = TcUtility.queryArg(response.output[1], newItemType.value);
  }

  public void findRevision(String itemId, String revId, StringHolder rev, StringHolder revType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemId);
    args_[3] = TcUtility.createArg(revId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "findRevision", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rev.value = TcUtility.queryArgStringUnion(response.output[0], rev.value);
    revType.value = TcUtility.queryArgStringUnion(response.output[1], revType.value);
  }

  public void isBased(String revision, BooleanHolder isBased) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revision);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "isBased", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isBased.value = TcUtility.queryArg(response.output[0], isBased.value);
  }

  public void basedOn(String revision, StringHolder basedObj, StringHolder typeObj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revision);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "basedOn", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    basedObj.value = TcUtility.queryArg(response.output[0], basedObj.value);
    typeObj.value = TcUtility.queryArg(response.output[1], typeObj.value);
  }

  public void createBaseline(String revision, String baselineRevId, String description, String blProcedureName, String jobName, String jobDescription, StringHolder baselineRev, StringHolder revType) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revision);
    args_[3] = TcUtility.createArg(baselineRevId);
    args_[4] = TcUtility.createArgStringUnion(description);
    args_[5] = TcUtility.createArgStringUnion(blProcedureName);
    args_[6] = TcUtility.createArgStringUnion(jobName);
    args_[7] = TcUtility.createArgStringUnion(jobDescription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "createBaseline", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    baselineRev.value = TcUtility.queryArg(response.output[0], baselineRev.value);
    revType.value = TcUtility.queryArg(response.output[1], revType.value);
  }

  public void mockCreateBaseline(String revision, String blProcedureName, StringHolder errorLogLocation) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revision);
    args_[3] = TcUtility.createArgStringUnion(blProcedureName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "mockCreateBaseline", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errorLogLocation.value = TcUtility.queryArg(response.output[0], errorLogLocation.value);
  }

  public void findBaseRev(String baselineRev, StringHolder baseRev, StringHolder baseRevType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(baselineRev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "findBaseRev", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    baseRev.value = TcUtility.queryArg(response.output[0], baseRev.value);
    baseRevType.value = TcUtility.queryArg(response.output[1], baseRevType.value);
  }

  public void listBaselineRevs(String baseRev, String baselineReleaseStatus, IntHolder baselineRevCount, uidSeq_tHolder baselineRevs, uidSeq_tHolder baselineRevTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(baseRev);
    args_[3] = TcUtility.createArgStringUnion(baselineReleaseStatus);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "listBaselineRevs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    baselineRevCount.value = TcUtility.queryArg(response.output[0], baselineRevCount.value);
    baselineRevs.value = TcUtility.queryArg(response.output[1], baselineRevs.value);
    baselineRevTypes.value = TcUtility.queryArg(response.output[2], baselineRevTypes.value);
  }

  public void getNewRevisionIdAlt(String ruleSuffix, String oldItemRev, String type, BooleanHolder idCanBeModified, StringHolder newItemId) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleSuffix);
    args_[3] = TcUtility.createArgStringUnion(oldItemRev);
    args_[4] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "getNewRevisionIdAlt", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    idCanBeModified.value = TcUtility.queryArg(response.output[0], idCanBeModified.value);
    newItemId.value = TcUtility.queryArg(response.output[1], newItemId.value);
  }

  public void copyItemRevisionRecursively(String objToCopy, String configuringBOMWindow, String workingBOMWindow, String copyRulesKey, String name, String description, String id, String revId, StringHolder newObj) throws Exception {
    Arg[] args_ = new Arg[10];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objToCopy);
    args_[3] = TcUtility.createArg(configuringBOMWindow);
    args_[4] = TcUtility.createArg(workingBOMWindow);
    args_[5] = TcUtility.createArg(copyRulesKey);
    args_[6] = TcUtility.createArgStringUnion(name);
    args_[7] = TcUtility.createArgStringUnion(description);
    args_[8] = TcUtility.createArgStringUnion(id);
    args_[9] = TcUtility.createArgStringUnion(revId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "copyItemRevisionRecursively", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newObj.value = TcUtility.queryArg(response.output[0], newObj.value);
  }

  public void createICBaseline(String objToCopy, String configuringBOMWindow, String copyRulesKey, String name, String description, String id, String revId, StringHolder newObj) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objToCopy);
    args_[3] = TcUtility.createArg(configuringBOMWindow);
    args_[4] = TcUtility.createArg(copyRulesKey);
    args_[5] = TcUtility.createArgStringUnion(name);
    args_[6] = TcUtility.createArgStringUnion(description);
    args_[7] = TcUtility.createArgStringUnion(id);
    args_[8] = TcUtility.createArgStringUnion(revId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "createICBaseline", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newObj.value = TcUtility.queryArg(response.output[0], newObj.value);
  }

  public void getStoredOptionSets(String revUid, String relationTypeUid, uidSeq_tHolder storedOptionSets) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revUid);
    args_[3] = TcUtility.createArgStringUnion(relationTypeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItemRevision", "getStoredOptionSets", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    storedOptionSets.value = TcUtility.queryArg(response.output[0], storedOptionSets.value);
  }

}
