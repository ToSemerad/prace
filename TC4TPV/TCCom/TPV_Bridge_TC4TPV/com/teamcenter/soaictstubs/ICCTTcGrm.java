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

public class ICCTTcGrm extends ICCT {
  public ICCTTcGrm(Connection connection) {
    super(connection);
  }

  public ICCTTcGrm(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createRule(String primaryTypeUid, String[] secondaryTypeUids, String relType, int matchFlag, int primaryCardinality, int secondaryCardinality, int bitwiseConstraints, uidSeqValue_uHolder newTcGRMs, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(primaryTypeUid);
    args_[3] = TcUtility.createArg(secondaryTypeUids);
    args_[4] = TcUtility.createArgStringUnion(relType);
    args_[5] = TcUtility.createArg(matchFlag);
    args_[6] = TcUtility.createArg(primaryCardinality);
    args_[7] = TcUtility.createArg(secondaryCardinality);
    args_[8] = TcUtility.createArg(bitwiseConstraints);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcGrm", "createRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newTcGRMs.value = TcUtility.queryArg(response.output[0], newTcGRMs.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void findRule(String priObj, String secObj, String relType, int matchFlag, int primaryCardinality, int secondaryCardinality, int bitwiseConstraints, uidSeqValue_uHolder relations, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(priObj);
    args_[3] = TcUtility.createArgStringUnion(secObj);
    args_[4] = TcUtility.createArgStringUnion(relType);
    args_[5] = TcUtility.createArg(matchFlag);
    args_[6] = TcUtility.createArg(primaryCardinality);
    args_[7] = TcUtility.createArg(secondaryCardinality);
    args_[8] = TcUtility.createArg(bitwiseConstraints);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcGrm", "findRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    relations.value = TcUtility.queryArg(response.output[0], relations.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void destroyRule(String grmUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(grmUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcGrm", "destroyRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void findConstraint(String priObj, String secObj, String relType, int matchFlag, IntHolder primaryCardinality, IntHolder secondaryCardinality, IntHolder bitwiseConstraints, StringHolder tcGrm) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(priObj);
    args_[3] = TcUtility.createArgStringUnion(secObj);
    args_[4] = TcUtility.createArgStringUnion(relType);
    args_[5] = TcUtility.createArg(matchFlag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcGrm", "findConstraint", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    primaryCardinality.value = TcUtility.queryArg(response.output[0], primaryCardinality.value);
    secondaryCardinality.value = TcUtility.queryArg(response.output[1], secondaryCardinality.value);
    bitwiseConstraints.value = TcUtility.queryArg(response.output[2], bitwiseConstraints.value);
    tcGrm.value = TcUtility.queryArgStringUnion(response.output[3], tcGrm.value);
  }

  public void matchConstraint(String priObj, String secObj, String relType, int matchFlag, IntHolder primaryCardinality, IntHolder secondaryCardinality, IntHolder bitwiseConstraints, StringHolder tcGrm) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(priObj);
    args_[3] = TcUtility.createArgStringUnion(secObj);
    args_[4] = TcUtility.createArgStringUnion(relType);
    args_[5] = TcUtility.createArg(matchFlag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcGrm", "matchConstraint", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    primaryCardinality.value = TcUtility.queryArg(response.output[0], primaryCardinality.value);
    secondaryCardinality.value = TcUtility.queryArg(response.output[1], secondaryCardinality.value);
    bitwiseConstraints.value = TcUtility.queryArg(response.output[2], bitwiseConstraints.value);
    tcGrm.value = TcUtility.queryArgStringUnion(response.output[3], tcGrm.value);
  }

  public void findRedundancy(String priObj, String secObj, String relType, int matchFlag, uidSeqValue_uHolder relations, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(priObj);
    args_[3] = TcUtility.createArgStringUnion(secObj);
    args_[4] = TcUtility.createArgStringUnion(relType);
    args_[5] = TcUtility.createArg(matchFlag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcGrm", "findRedundancy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    relations.value = TcUtility.queryArg(response.output[0], relations.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

}
