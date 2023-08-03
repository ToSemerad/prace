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

public class ICCTCAEBCItemRevision extends ICCTItemRevision {
  public ICCTCAEBCItemRevision(Connection connection) {
    super(connection);
  }

  public ICCTCAEBCItemRevision(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String id, String revid, String Name, String Desc, String vaultMode, String eIntType, String[] criteriaNames, String[] criteriaValues, String linkPath, StringHolder CAEBCItemRevisionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[11];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    args_[3] = TcUtility.createArgStringUnion(revid);
    args_[4] = TcUtility.createArgStringUnion(Name);
    args_[5] = TcUtility.createArgStringUnion(Desc);
    args_[6] = TcUtility.createArgStringUnion(vaultMode);
    args_[7] = TcUtility.createArgStringUnion(eIntType);
    args_[8] = TcUtility.createArg(criteriaNames);
    args_[9] = TcUtility.createArgStringUnion(criteriaValues);
    args_[10] = TcUtility.createArgStringUnion(linkPath);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEBCItemRevision", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    CAEBCItemRevisionUid.value = TcUtility.queryArg(response.output[0], CAEBCItemRevisionUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void setVaultData(String revision, String vaultMode, String eIntType, String[] criteriaNames, String[] criteriaValues, String linkPath) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revision);
    args_[3] = TcUtility.createArgStringUnion(vaultMode);
    args_[4] = TcUtility.createArgStringUnion(eIntType);
    args_[5] = TcUtility.createArg(criteriaNames);
    args_[6] = TcUtility.createArgStringUnion(criteriaValues);
    args_[7] = TcUtility.createArgStringUnion(linkPath);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEBCItemRevision", "setVaultData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
