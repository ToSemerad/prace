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

public class ICCTAppearance extends ICCT {
  public ICCTAppearance(Connection connection) {
    super(connection);
  }

  public ICCTAppearance(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void find(String appearanceRoot, String savedQuery, stringSeqValue_u savedQueryEntries, stringSeqValue_u savedQueryValues, stringSeqValue_u mappedAttrNames, stringSeqValue_u mappedAttrValues, uidSeq_tHolder foundAppearances, uidSeq_tHolder foundTypes) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(appearanceRoot);
    args_[3] = TcUtility.createArgStringUnion(savedQuery);
    args_[4] = TcUtility.createArg(savedQueryEntries);
    args_[5] = TcUtility.createArg(savedQueryValues);
    args_[6] = TcUtility.createArg(mappedAttrNames);
    args_[7] = TcUtility.createArg(mappedAttrValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearance", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    foundAppearances.value = TcUtility.queryArg(response.output[0], foundAppearances.value);
    foundTypes.value = TcUtility.queryArg(response.output[1], foundTypes.value);
  }

  public void findAppearances(String item, String topItem, String bomView, String revisionRule, uidSeq_tHolder appearances) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(item);
    args_[3] = TcUtility.createArgStringUnion(topItem);
    args_[4] = TcUtility.createArgStringUnion(bomView);
    args_[5] = TcUtility.createArgStringUnion(revisionRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearance", "findAppearances", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    appearances.value = TcUtility.queryArg(response.output[0], appearances.value);
  }

}
