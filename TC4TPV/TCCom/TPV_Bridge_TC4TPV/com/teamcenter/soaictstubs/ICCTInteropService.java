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

public class ICCTInteropService {
  ICTService m_service;

  Connection m_connection;


  public ICCTInteropService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void generateBookmarkFromDataset(String datasetUid, int type, StringHolder buffer) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(datasetUid);
    args_[1] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTInteropService", "generateBookmarkFromDataset", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    buffer.value = TcUtility.queryArgStringUnion(response.output[0], buffer.value);
  }

  public void generateBookmarkFromBom(String bomWindow, int type, String[] objectUids, StringHolder buffer) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(bomWindow);
    args_[1] = TcUtility.createArg(type);
    args_[2] = TcUtility.createArg(objectUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTInteropService", "generateBookmarkFromBom", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    buffer.value = TcUtility.queryArgStringUnion(response.output[0], buffer.value);
  }

  public void generateNXPlmxmlFromNav(uidSeqValue_u objectUids, StringHolder fileLocation, StringHolder fileType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTInteropService", "generateNXPlmxmlFromNav", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileLocation.value = TcUtility.queryArg(response.output[0], fileLocation.value);
    fileType.value = TcUtility.queryArg(response.output[1], fileType.value);
  }

  public void generatePlmxmlFromBom(String bomWindow, uidSeqValue_u objectUids, int pruning, String plmxmlStyle, StringHolder fileLocation, StringHolder fileType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(bomWindow);
    args_[1] = TcUtility.createArg(objectUids);
    args_[2] = TcUtility.createArg(pruning);
    args_[3] = TcUtility.createArgStringUnion(plmxmlStyle);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTInteropService", "generatePlmxmlFromBom", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileLocation.value = TcUtility.queryArg(response.output[0], fileLocation.value);
    fileType.value = TcUtility.queryArg(response.output[1], fileType.value);
  }

  public void getToolComponent(String toolName, StringHolder default_tool_uid, StringHolder tool_type_uid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(toolName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTInteropService", "getToolComponent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    default_tool_uid.value = TcUtility.queryArgStringUnion(response.output[0], default_tool_uid.value);
    tool_type_uid.value = TcUtility.queryArgStringUnion(response.output[1], tool_type_uid.value);
  }

  public void getToolMimeType(String toolName, StringHolder mimeType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(toolName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTInteropService", "getToolMimeType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mimeType.value = TcUtility.queryArgStringUnion(response.output[0], mimeType.value);
  }

  public void whereUsedInfo(String uid, int whereUsedType, String revisionRule, IntHolder componentCount, uidSeq_tHolder componentUids, uidSeq_tHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(uid);
    args_[1] = TcUtility.createArg(whereUsedType);
    args_[2] = TcUtility.createArgStringUnion(revisionRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTInteropService", "whereUsedInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentCount.value = TcUtility.queryArg(response.output[0], componentCount.value);
    componentUids.value = TcUtility.queryArg(response.output[1], componentUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[2], componentTypeUids.value);
  }

  public void getInfoForVvi(uidSeqValue_u objectUids, String configRule, String clientSidePLMXMLFileName, String bomWindow, stringSeqValue_uHolder vviObids, StringHolder mergeContextId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(objectUids);
    args_[1] = TcUtility.createArgStringUnion(configRule);
    args_[2] = TcUtility.createArgStringUnion(clientSidePLMXMLFileName);
    args_[3] = TcUtility.createArgStringUnion(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTInteropService", "getInfoForVvi", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    vviObids.value = TcUtility.queryArg(response.output[0], vviObids.value);
    mergeContextId.value = TcUtility.queryArgStringUnion(response.output[1], mergeContextId.value);
  }

}
