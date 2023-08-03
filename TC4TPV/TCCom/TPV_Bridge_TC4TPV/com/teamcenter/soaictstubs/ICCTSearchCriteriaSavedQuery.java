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

public class ICCTSearchCriteriaSavedQuery extends ICCTSearchCriteria {
  public ICCTSearchCriteriaSavedQuery(Connection connection) {
    super(connection);
  }

  public ICCTSearchCriteriaSavedQuery(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String inputSavedQueryType, String queryName, int noEntries, String[] entries, String[] values, StringHolder newSearchCriteriaSavedQuery, StringHolder searchCriteriaSavedQueryType) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(inputSavedQueryType);
    args_[3] = TcUtility.createArgStringUnion(queryName);
    args_[4] = TcUtility.createArg(noEntries);
    args_[5] = TcUtility.createArg(entries);
    args_[6] = TcUtility.createArg(values);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaSavedQuery", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSearchCriteriaSavedQuery.value = TcUtility.queryArg(response.output[0], newSearchCriteriaSavedQuery.value);
    searchCriteriaSavedQueryType.value = TcUtility.queryArg(response.output[1], searchCriteriaSavedQueryType.value);
  }

  public void getQueryName(String searchCriteriaSavedQuery, StringHolder queryName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaSavedQuery);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaSavedQuery", "getQueryName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    queryName.value = TcUtility.queryArgStringUnion(response.output[0], queryName.value);
  }

  public void getEntries(String searchCriteriaSavedQuery, IntHolder noEntries, stringSeqValue_uHolder entries) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaSavedQuery);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaSavedQuery", "getEntries", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noEntries.value = TcUtility.queryArg(response.output[0], noEntries.value);
    entries.value = TcUtility.queryArg(response.output[1], entries.value);
  }

  public void getValues(String searchCriteriaSavedQuery, IntHolder noValues, stringSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaSavedQuery);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaSavedQuery", "getValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noValues.value = TcUtility.queryArg(response.output[0], noValues.value);
    values.value = TcUtility.queryArg(response.output[1], values.value);
  }

}
