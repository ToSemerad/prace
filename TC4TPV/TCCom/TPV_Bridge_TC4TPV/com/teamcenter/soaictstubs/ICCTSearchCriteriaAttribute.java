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

public class ICCTSearchCriteriaAttribute extends ICCTSearchCriteria {
  public ICCTSearchCriteriaAttribute(Connection connection) {
    super(connection);
  }

  public ICCTSearchCriteriaAttribute(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String inputAttrType, String name, String value, int attrComparator, StringHolder newSearchCriteriaAttribute, StringHolder searchCriteriaAttributeType) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(inputAttrType);
    args_[3] = TcUtility.createArgStringUnion(name);
    args_[4] = TcUtility.createArgStringUnion(value);
    args_[5] = TcUtility.createArg(attrComparator);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaAttribute", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSearchCriteriaAttribute.value = TcUtility.queryArg(response.output[0], newSearchCriteriaAttribute.value);
    searchCriteriaAttributeType.value = TcUtility.queryArg(response.output[1], searchCriteriaAttributeType.value);
  }

  public void getName(String searchCriteriaAttr, StringHolder name) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaAttr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaAttribute", "getName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    name.value = TcUtility.queryArgStringUnion(response.output[0], name.value);
  }

  public void getValue(String searchCriteriaAttr, StringHolder value) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaAttr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaAttribute", "getValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    value.value = TcUtility.queryArgStringUnion(response.output[0], value.value);
  }

  public void getAttrComparator(String searchCriteriaAttr, IntHolder AttrComparator) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaAttr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaAttribute", "getAttrComparator", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    AttrComparator.value = TcUtility.queryArg(response.output[0], AttrComparator.value);
  }

}
