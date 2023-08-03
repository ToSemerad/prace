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

public class ICCTItem extends ICCT {
  public ICCTItem(Connection connection) {
    super(connection);
  }

  public ICCTItem(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String id, String rev, String type, String name, String description, String uom, String masterForm, String[] propertyNamesIM, propertyData_u[] propDataIM, String revMasterForm, String[] propertyNamesIRM, propertyData_u[] propDataIRM, StringHolder newItem, StringHolder typeObj) throws Exception {
    Arg[] args_ = new Arg[14];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(id);
    args_[3] = TcUtility.createArg(rev);
    args_[4] = TcUtility.createArgStringUnion(type);
    args_[5] = TcUtility.createArg(name);
    args_[6] = TcUtility.createArgStringUnion(description);
    args_[7] = TcUtility.createArgStringUnion(uom);
    args_[8] = TcUtility.createArgStringUnion(masterForm);
    args_[9] = TcUtility.createArg(propertyNamesIM);
    args_[10] = TcUtility.createArg(propDataIM);
    args_[11] = TcUtility.createArgStringUnion(revMasterForm);
    args_[12] = TcUtility.createArg(propertyNamesIRM);
    args_[13] = TcUtility.createArg(propDataIRM);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newItem.value = TcUtility.queryArg(response.output[0], newItem.value);
    typeObj.value = TcUtility.queryArg(response.output[1], typeObj.value);
  }

  public void find(String id, StringHolder obj, StringHolder typeObj) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    obj.value = TcUtility.queryArgStringUnion(response.output[0], obj.value);
    typeObj.value = TcUtility.queryArgStringUnion(response.output[1], typeObj.value);
  }

  public void revise(String obj, String revisionID, String name, String desc, StringHolder newItemRev, StringHolder typeObj) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(obj);
    args_[3] = TcUtility.createArg(revisionID);
    args_[4] = TcUtility.createArg(name);
    args_[5] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "revise", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newItemRev.value = TcUtility.queryArg(response.output[0], newItemRev.value);
    typeObj.value = TcUtility.queryArg(response.output[1], typeObj.value);
  }

  public void getNewItemId(String oldItem, String oldItemType, BooleanHolder idCanBeModified, StringHolder newItemId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(oldItem);
    args_[3] = TcUtility.createArg(oldItemType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "getNewItemId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    idCanBeModified.value = TcUtility.queryArg(response.output[0], idCanBeModified.value);
    newItemId.value = TcUtility.queryArg(response.output[1], newItemId.value);
  }

  public void getNewRevisionId(String oldItem, String typeObj, BooleanHolder idCanBeModified, StringHolder newItemId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(oldItem);
    args_[3] = TcUtility.createArg(typeObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "getNewRevisionId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    idCanBeModified.value = TcUtility.queryArg(response.output[0], idCanBeModified.value);
    newItemId.value = TcUtility.queryArg(response.output[1], newItemId.value);
  }

  public void getLatestItemRevision(String item, StringHolder itemRevision, StringHolder itemRevisionType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(item);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "getLatestItemRevision", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    itemRevision.value = TcUtility.queryArg(response.output[0], itemRevision.value);
    itemRevisionType.value = TcUtility.queryArg(response.output[1], itemRevisionType.value);
  }

  public void getConfiguredItemRevision(String item, String configRule, StringHolder itemRevision, StringHolder itemRevisionType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(item);
    args_[3] = TcUtility.createArgStringUnion(configRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "getConfiguredItemRevision", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    itemRevision.value = TcUtility.queryArg(response.output[0], itemRevision.value);
    itemRevisionType.value = TcUtility.queryArg(response.output[1], itemRevisionType.value);
  }

  public void getInProcessItemRevisions(String item, uidSeqValue_uHolder itemRevisions, uidSeqValue_uHolder itemRevisionTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(item);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "getInProcessItemRevisions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    itemRevisions.value = TcUtility.queryArg(response.output[0], itemRevisions.value);
    itemRevisionTypes.value = TcUtility.queryArg(response.output[1], itemRevisionTypes.value);
  }

  public void getReleasedItemRevisions(String item, uidSeqValue_uHolder itemRevisions, uidSeqValue_uHolder itemRevisionTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(item);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "getReleasedItemRevisions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    itemRevisions.value = TcUtility.queryArg(response.output[0], itemRevisions.value);
    itemRevisionTypes.value = TcUtility.queryArg(response.output[1], itemRevisionTypes.value);
  }

  public void getWorkingItemRevisions(String item, uidSeqValue_uHolder itemRevisions, uidSeqValue_uHolder itemRevisionTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(item);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "getWorkingItemRevisions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    itemRevisions.value = TcUtility.queryArg(response.output[0], itemRevisions.value);
    itemRevisionTypes.value = TcUtility.queryArg(response.output[1], itemRevisionTypes.value);
  }

  public void getNextLevelItems(String item, uidSeqValue_uHolder nextLevelItems, uidSeqValue_uHolder nextLevelItemTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(item);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "getNextLevelItems", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nextLevelItems.value = TcUtility.queryArg(response.output[0], nextLevelItems.value);
    nextLevelItemTypes.value = TcUtility.queryArg(response.output[1], nextLevelItemTypes.value);
  }

  public void okForRecursiveDelete(String item, String[] parentItemsInStructure, BooleanHolder verdict, StringHolder ifNotWhyNot) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(item);
    args_[3] = TcUtility.createArg(parentItemsInStructure);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "okForRecursiveDelete", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
    ifNotWhyNot.value = TcUtility.queryArgStringUnion(response.output[1], ifNotWhyNot.value);
  }

  public void isNeverUsedRelation(String partItem, String prodItem, BooleanHolder nuFlag) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(partItem);
    args_[3] = TcUtility.createArg(prodItem);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "isNeverUsedRelation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nuFlag.value = TcUtility.queryArg(response.output[0], nuFlag.value);
  }

  public void validateId(String itemId, String itemRevId, String itemType, StringHolder modifiedItemId, StringHolder modifiedItemRevId, IntHolder modificationStatus) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(itemId);
    args_[3] = TcUtility.createArg(itemRevId);
    args_[4] = TcUtility.createArgStringUnion(itemType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "validateId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    modifiedItemId.value = TcUtility.queryArgStringUnion(response.output[0], modifiedItemId.value);
    modifiedItemRevId.value = TcUtility.queryArgStringUnion(response.output[1], modifiedItemRevId.value);
    modificationStatus.value = TcUtility.queryArg(response.output[2], modificationStatus.value);
  }

  public void isVi(String itemUid, BooleanHolder isVi) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "isVi", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isVi.value = TcUtility.queryArg(response.output[0], isVi.value);
  }

  public void getSos(String itemUid, StringHolder dbSosUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "getSos", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    dbSosUid.value = TcUtility.queryArg(response.output[0], dbSosUid.value);
  }

  public void getGenericComponent(String itemUid, StringHolder genericComponentUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "getGenericComponent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    genericComponentUid.value = TcUtility.queryArg(response.output[0], genericComponentUid.value);
  }

  public void isLinkedToGeneric(String itemUid, BooleanHolder isLinked) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "isLinkedToGeneric", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isLinked.value = TcUtility.queryArg(response.output[0], isLinked.value);
  }

  public void unlinkFromGeneric(String itemUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "unlinkFromGeneric", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void findVis(String genericComponentUid, String[] items, String[] options, int[] ops, int[] valueTypes, String[] lowValues, String[] highValues, uidSeq_tHolder matches) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(genericComponentUid);
    args_[3] = TcUtility.createArg(items);
    args_[4] = TcUtility.createArg(options);
    args_[5] = TcUtility.createArg(ops);
    args_[6] = TcUtility.createArg(valueTypes);
    args_[7] = TcUtility.createArg(lowValues);
    args_[8] = TcUtility.createArg(highValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "findVis", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    matches.value = TcUtility.queryArg(response.output[0], matches.value);
  }

  public void getItemRevisionType(String itemtype, StringHolder itemRevisionType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(itemtype);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTItem", "getItemRevisionType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    itemRevisionType.value = TcUtility.queryArgStringUnion(response.output[0], itemRevisionType.value);
  }

}
