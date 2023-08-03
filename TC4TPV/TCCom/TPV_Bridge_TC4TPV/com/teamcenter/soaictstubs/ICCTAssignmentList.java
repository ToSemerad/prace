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

public class ICCTAssignmentList extends ICCT {
  public ICCTAssignmentList(Connection connection) {
    super(connection);
  }

  public ICCTAssignmentList(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String listName, stringSeqValue_u listDesc, String procTemplate, resourceListInfo_s[] resources, boolean isShared, StringHolder assignmentListUid, StringHolder assignmentListTypeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(listName);
    args_[3] = TcUtility.createArg(listDesc);
    args_[4] = TcUtility.createArg(procTemplate);
    args_[5] = TcUtility.createArg(resources);
    args_[6] = TcUtility.createArg(isShared);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAssignmentList", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    assignmentListUid.value = TcUtility.queryArg(response.output[0], assignmentListUid.value);
    assignmentListTypeUid.value = TcUtility.queryArg(response.output[1], assignmentListTypeUid.value);
  }

  public void modify(String sourceAssnList, String listName, stringSeqValue_u listDesc, resourceListInfo_s[] resources, boolean isShared) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(sourceAssnList);
    args_[3] = TcUtility.createArg(listName);
    args_[4] = TcUtility.createArg(listDesc);
    args_[5] = TcUtility.createArg(resources);
    args_[6] = TcUtility.createArg(isShared);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAssignmentList", "modify", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getDetails(String assnListUid, resourceListInfoSeq_tHolder resources) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(assnListUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAssignmentList", "getDetails", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    resources.value = TcUtility.queryArg(response.output[0], resources.value);
  }

  public void replaceResource(String[] assnListUids, String oldResourceUid, String newResourceUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(assnListUids);
    args_[3] = TcUtility.createArg(oldResourceUid);
    args_[4] = TcUtility.createArgStringUnion(newResourceUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAssignmentList", "replaceResource", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void findListByResource(String memberUid, uidSeqValue_uHolder objectUids, uidSeqValue_uHolder objectTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(memberUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAssignmentList", "findListByResource", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectUids.value = TcUtility.queryArg(response.output[0], objectUids.value);
    objectTypeUids.value = TcUtility.queryArg(response.output[1], objectTypeUids.value);
  }

  public void getProcessTemplate(String assnListUid, StringHolder procTemplateUid, StringHolder procTemplateTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(assnListUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAssignmentList", "getProcessTemplate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    procTemplateUid.value = TcUtility.queryArg(response.output[0], procTemplateUid.value);
    procTemplateTypeUid.value = TcUtility.queryArg(response.output[1], procTemplateTypeUid.value);
  }

}
