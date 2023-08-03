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

public class ICCTCAEItemRevision extends ICCTItemRevision {
  public ICCTCAEItemRevision(Connection connection) {
    super(connection);
  }

  public ICCTCAEItemRevision(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void getSecondaryRelations(String primaryItemID, String primaryItemRevID, String RelationType, IntHolder numRelations, stringSeq_tHolder secondaryItemIDs, stringSeq_tHolder secondaryItemRevIDs) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(primaryItemID);
    args_[3] = TcUtility.createArgStringUnion(primaryItemRevID);
    args_[4] = TcUtility.createArgStringUnion(RelationType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEItemRevision", "getSecondaryRelations", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    numRelations.value = TcUtility.queryArg(response.output[0], numRelations.value);
    secondaryItemIDs.value = TcUtility.queryArg(response.output[1], secondaryItemIDs.value);
    secondaryItemRevIDs.value = TcUtility.queryArg(response.output[2], secondaryItemRevIDs.value);
  }

  public void getPrimaryRelations(String secondaryItemID, String secondaryItemRevID, String RelationType, IntHolder numRelations, stringSeq_tHolder primaryItemIDs, stringSeq_tHolder primaryItemRevIDs) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(secondaryItemID);
    args_[3] = TcUtility.createArgStringUnion(secondaryItemRevID);
    args_[4] = TcUtility.createArgStringUnion(RelationType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEItemRevision", "getPrimaryRelations", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    numRelations.value = TcUtility.queryArg(response.output[0], numRelations.value);
    primaryItemIDs.value = TcUtility.queryArg(response.output[1], primaryItemIDs.value);
    primaryItemRevIDs.value = TcUtility.queryArg(response.output[2], primaryItemRevIDs.value);
  }

  public void getAllSecondaryRevisionRelations(String primaryItemID, String primaryItemRevID, stringSeq_tHolder RelationTypes, longValueSeq_tHolder numIRsOfEachRelationType, stringSeq_tHolder secondaryItemIDs, stringSeq_tHolder secondaryItemRevIDs) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(primaryItemID);
    args_[3] = TcUtility.createArgStringUnion(primaryItemRevID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEItemRevision", "getAllSecondaryRevisionRelations", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    RelationTypes.value = TcUtility.queryArg(response.output[0], RelationTypes.value);
    numIRsOfEachRelationType.value = TcUtility.queryArg(response.output[1], numIRsOfEachRelationType.value);
    secondaryItemIDs.value = TcUtility.queryArg(response.output[2], secondaryItemIDs.value);
    secondaryItemRevIDs.value = TcUtility.queryArg(response.output[3], secondaryItemRevIDs.value);
  }

  public void getAllPrimaryRevisionRelations(String secondaryItemID, String secondaryItemRevID, stringSeq_tHolder RelationTypes, longValueSeq_tHolder numIRsOfEachRelationType, stringSeq_tHolder primaryItemIDs, stringSeq_tHolder primaryItemRevIDs) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(secondaryItemID);
    args_[3] = TcUtility.createArgStringUnion(secondaryItemRevID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEItemRevision", "getAllPrimaryRevisionRelations", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    RelationTypes.value = TcUtility.queryArg(response.output[0], RelationTypes.value);
    numIRsOfEachRelationType.value = TcUtility.queryArg(response.output[1], numIRsOfEachRelationType.value);
    primaryItemIDs.value = TcUtility.queryArg(response.output[2], primaryItemIDs.value);
    primaryItemRevIDs.value = TcUtility.queryArg(response.output[3], primaryItemRevIDs.value);
  }

  public void setRelations(String primaryItemID, String primaryItemRevID, String[] RelationTypes, int[] numIRsOfEachRelationType, String[] secondaryItemIDs, String[] secondaryItemRevIDs) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(primaryItemID);
    args_[3] = TcUtility.createArgStringUnion(primaryItemRevID);
    args_[4] = TcUtility.createArg(RelationTypes);
    args_[5] = TcUtility.createArg(numIRsOfEachRelationType);
    args_[6] = TcUtility.createArg(secondaryItemIDs);
    args_[7] = TcUtility.createArg(secondaryItemRevIDs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEItemRevision", "setRelations", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deleteRelations(String primaryItemID, String primaryItemRevID, String RelationType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(primaryItemID);
    args_[3] = TcUtility.createArgStringUnion(primaryItemRevID);
    args_[4] = TcUtility.createArgStringUnion(RelationType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEItemRevision", "deleteRelations", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deleteRelation(String primaryItemID, String primaryItemRevID, String RelationType, String secondaryItemID, String secondaryItemRevID) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(primaryItemID);
    args_[3] = TcUtility.createArgStringUnion(primaryItemRevID);
    args_[4] = TcUtility.createArgStringUnion(RelationType);
    args_[5] = TcUtility.createArgStringUnion(secondaryItemID);
    args_[6] = TcUtility.createArgStringUnion(secondaryItemRevID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEItemRevision", "deleteRelation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
