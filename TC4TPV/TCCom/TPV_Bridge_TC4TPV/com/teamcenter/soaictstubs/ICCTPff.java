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

public class ICCTPff extends ICCT {
  public ICCTPff(Connection connection) {
    super(connection);
  }

  public ICCTPff(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String description, String searchClass, String clauses, StringHolder queryUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArgStringUnion(description);
    args_[4] = TcUtility.createArg(searchClass);
    args_[5] = TcUtility.createArg(clauses);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPff", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    queryUid.value = TcUtility.queryArg(response.output[0], queryUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void find(String name, StringHolder queryUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPff", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    queryUid.value = TcUtility.queryArgStringUnion(response.output[0], queryUid.value);
    typeUid.value = TcUtility.queryArgStringUnion(response.output[1], typeUid.value);
  }

  public void write_xml(String queryUid, int numtuples, int numintuple, uidSeqValue_u tuples, StringHolder xmlFileLocation) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(queryUid);
    args_[3] = TcUtility.createArg(numtuples);
    args_[4] = TcUtility.createArg(numintuple);
    args_[5] = TcUtility.createArg(tuples);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPff", "write_xml", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    xmlFileLocation.value = TcUtility.queryArg(response.output[0], xmlFileLocation.value);
  }

  public void write_xml_with_clauses(String queryUid, int numtuples, int numintuple, uidSeqValue_u tuples, stringSeqValue_u clauses, StringHolder xmlFileLocation) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(queryUid);
    args_[3] = TcUtility.createArg(numtuples);
    args_[4] = TcUtility.createArg(numintuple);
    args_[5] = TcUtility.createArg(tuples);
    args_[6] = TcUtility.createArg(clauses);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPff", "write_xml_with_clauses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    xmlFileLocation.value = TcUtility.queryArg(response.output[0], xmlFileLocation.value);
  }

  public void details(String queryUid, stringValueSeq_tHolder column_names, stringValueSeq_tHolder relation_to_base) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(queryUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPff", "details", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    column_names.value = TcUtility.queryArgStringUnion(response.output[0], column_names.value);
    relation_to_base.value = TcUtility.queryArgStringUnion(response.output[1], relation_to_base.value);
  }

}
