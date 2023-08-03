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

public class ICCTSearchCriteriaMappedAttribute extends ICCTSearchCriteria {
  public ICCTSearchCriteriaMappedAttribute(Connection connection) {
    super(connection);
  }

  public ICCTSearchCriteriaMappedAttribute(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String inputMappedAttrType, String name, String value, int attrComparator, StringHolder newSearchCriteriaMappedAttribute, StringHolder searchCriteriaMappedAttributeType) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(inputMappedAttrType);
    args_[3] = TcUtility.createArgStringUnion(name);
    args_[4] = TcUtility.createArgStringUnion(value);
    args_[5] = TcUtility.createArg(attrComparator);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaMappedAttribute", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSearchCriteriaMappedAttribute.value = TcUtility.queryArg(response.output[0], newSearchCriteriaMappedAttribute.value);
    searchCriteriaMappedAttributeType.value = TcUtility.queryArg(response.output[1], searchCriteriaMappedAttributeType.value);
  }

  public void getName(String searchCriteriaMappedAttr, StringHolder name) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaMappedAttr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaMappedAttribute", "getName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    name.value = TcUtility.queryArgStringUnion(response.output[0], name.value);
  }

  public void getValue(String searchCriteriaMappedAttr, StringHolder value) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaMappedAttr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaMappedAttribute", "getValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    value.value = TcUtility.queryArgStringUnion(response.output[0], value.value);
  }

  public void getAttrComparator(String searchCriteriaMappedAttr, IntHolder AttrComparator) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaMappedAttr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaMappedAttribute", "getAttrComparator", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    AttrComparator.value = TcUtility.queryArg(response.output[0], AttrComparator.value);
  }

}
