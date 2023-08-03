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

public class ICCSHeader extends ICCSAdmin {
  public ICCSHeader(Connection connection) {
    super(connection);
  }

  public ICCSHeader(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void loadPFTMappings(pftMappingNSeq_tHolder pftMappings) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSHeader", "loadPFTMappings", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pftMappings.value = TcUtility.queryArg(response.output[0], pftMappings.value);
  }

  public void setPFTMappings(pftMappingW_t[] pftMappings) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(pftMappings);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSHeader", "setPFTMappings", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createPFTMapping(String itemOrRevisionUid, pftMappingN_tHolder pftMappingN) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemOrRevisionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSHeader", "createPFTMapping", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pftMappingN.value = TcUtility.queryArg(response.output[0], pftMappingN.value);
  }

  public void importPFTAndCreateMapping(String fileSpec, String itemName, boolean attachRevision, pftMappingN_tHolder pftMappingN) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(fileSpec);
    args_[3] = TcUtility.createArgStringUnion(itemName);
    args_[4] = TcUtility.createArg(attachRevision);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSHeader", "importPFTAndCreateMapping", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pftMappingN.value = TcUtility.queryArg(response.output[0], pftMappingN.value);
  }

  public void refreshPFTColumns(String itemOrRevisionUid, pftColumnDescriptorSeq_tHolder pftColumnDescriptorSeq) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemOrRevisionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSHeader", "refreshPFTColumns", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pftColumnDescriptorSeq.value = TcUtility.queryArg(response.output[0], pftColumnDescriptorSeq.value);
  }

  public void validatePFTMapping(String itemOrRevisionUid, StringHolder result) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemOrRevisionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSHeader", "validatePFTMapping", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    result.value = TcUtility.queryArg(response.output[0], result.value);
  }

  public void createIcosForAllPFTMembers(String itemOrRevisionUid, boolean connectExistingIcos, StringHolder theConnectableICOs, StringHolder result) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemOrRevisionUid);
    args_[3] = TcUtility.createArg(connectExistingIcos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSHeader", "createIcosForAllPFTMembers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theConnectableICOs.value = TcUtility.queryArg(response.output[0], theConnectableICOs.value);
    result.value = TcUtility.queryArg(response.output[1], result.value);
  }

  public void connectExistingIcosToPFT(String itemOrRevisionUid, StringHolder result) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemOrRevisionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSHeader", "connectExistingIcosToPFT", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    result.value = TcUtility.queryArg(response.output[0], result.value);
  }

  public void listGraphicsInformation(iccsGraphicsInformationNodeSeq_tHolder iccsGraphicsInformationNodeSeq) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSHeader", "listGraphicsInformation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iccsGraphicsInformationNodeSeq.value = TcUtility.queryArg(response.output[0], iccsGraphicsInformationNodeSeq.value);
  }

}
