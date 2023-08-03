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

public class ICCTBomViewRevision extends ICCT {
  public ICCTBomViewRevision(Connection connection) {
    super(connection);
  }

  public ICCTBomViewRevision(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String id, String revisionId, String viewType, boolean isPrecise, StringHolder bvrObj, StringHolder bvrTypeObj) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(id);
    args_[3] = TcUtility.createArg(revisionId);
    args_[4] = TcUtility.createArg(viewType);
    args_[5] = TcUtility.createArg(isPrecise);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomViewRevision", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bvrObj.value = TcUtility.queryArg(response.output[0], bvrObj.value);
    bvrTypeObj.value = TcUtility.queryArg(response.output[1], bvrTypeObj.value);
  }

  public void saveAs(String bvr, String itemId, String revisionId, String viewType, StringHolder bvrObj, StringHolder bvrTypeObj) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bvr);
    args_[3] = TcUtility.createArg(itemId);
    args_[4] = TcUtility.createArg(revisionId);
    args_[5] = TcUtility.createArg(viewType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomViewRevision", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bvrObj.value = TcUtility.queryArg(response.output[0], bvrObj.value);
    bvrTypeObj.value = TcUtility.queryArg(response.output[1], bvrTypeObj.value);
  }

  public void getAvailableViewTypes(String itemId, String revisionId, uidSeqValue_uHolder viewObjs, uidSeqValue_uHolder viewTypeObjs) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemId);
    args_[3] = TcUtility.createArg(revisionId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomViewRevision", "getAvailableViewTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    viewObjs.value = TcUtility.queryArg(response.output[0], viewObjs.value);
    viewTypeObjs.value = TcUtility.queryArg(response.output[1], viewTypeObjs.value);
  }

  public void getUnreleasedComponents(String bvr, String revRule, boolean includePhysicalComps, boolean includeLogicalComps, uidSeqValue_uHolder components, uidSeqValue_uHolder componentTypes) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bvr);
    args_[3] = TcUtility.createArg(revRule);
    args_[4] = TcUtility.createArg(includePhysicalComps);
    args_[5] = TcUtility.createArg(includeLogicalComps);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomViewRevision", "getUnreleasedComponents", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
    componentTypes.value = TcUtility.queryArg(response.output[1], componentTypes.value);
  }

}
