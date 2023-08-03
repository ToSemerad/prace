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

public class ICCTArchRevision extends ICCTItemRevision {
  public ICCTArchRevision(Connection connection) {
    super(connection);
  }

  public ICCTArchRevision(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String id, String revid, StringHolder archRevisionUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    args_[3] = TcUtility.createArgStringUnion(revid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchRevision", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    archRevisionUid.value = TcUtility.queryArg(response.output[0], archRevisionUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void deleteNamedVariantExpression(String archRevUid, String nveUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(archRevUid);
    args_[3] = TcUtility.createArg(nveUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchRevision", "deleteNamedVariantExpression", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void saveAsArch(String archRevUid, String id, String revid, String archType, String archName, String archDesc, String gcId, boolean deepCopyRequired, DeepCopyInfo_s[] DeepCopyInfo, uidSeq_tHolder deepCopiedObjects, uidSeq_tHolder deepCopiedObjectTypes, StringHolder archUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[11];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(archRevUid);
    args_[3] = TcUtility.createArgStringUnion(id);
    args_[4] = TcUtility.createArgStringUnion(revid);
    args_[5] = TcUtility.createArgStringUnion(archType);
    args_[6] = TcUtility.createArgStringUnion(archName);
    args_[7] = TcUtility.createArgStringUnion(archDesc);
    args_[8] = TcUtility.createArgStringUnion(gcId);
    args_[9] = TcUtility.createArg(deepCopyRequired);
    args_[10] = TcUtility.createArg(DeepCopyInfo);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchRevision", "saveAsArch", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    deepCopiedObjects.value = TcUtility.queryArg(response.output[0], deepCopiedObjects.value);
    deepCopiedObjectTypes.value = TcUtility.queryArg(response.output[1], deepCopiedObjectTypes.value);
    archUid.value = TcUtility.queryArg(response.output[2], archUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[3], componentTypeUid.value);
  }

  public void reviseArch(String archRevUid, String revId, String name, String desc, boolean deepCopyRequired, DeepCopyInfo_s[] DeepCopyInfo, uidSeq_tHolder deepCopiedObjects, uidSeq_tHolder deepCopiedObjectTypes, StringHolder newRevUid, StringHolder newRevTypeUid) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(archRevUid);
    args_[3] = TcUtility.createArgStringUnion(revId);
    args_[4] = TcUtility.createArgStringUnion(name);
    args_[5] = TcUtility.createArgStringUnion(desc);
    args_[6] = TcUtility.createArg(deepCopyRequired);
    args_[7] = TcUtility.createArg(DeepCopyInfo);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArchRevision", "reviseArch", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    deepCopiedObjects.value = TcUtility.queryArg(response.output[0], deepCopiedObjects.value);
    deepCopiedObjectTypes.value = TcUtility.queryArg(response.output[1], deepCopiedObjectTypes.value);
    newRevUid.value = TcUtility.queryArg(response.output[2], newRevUid.value);
    newRevTypeUid.value = TcUtility.queryArg(response.output[3], newRevTypeUid.value);
  }

}
