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

public class ICCTSearchCriteria extends ICCT {
  public ICCTSearchCriteria(Connection connection) {
    super(connection);
  }

  public ICCTSearchCriteria(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createSearchCriteria(String inputSearchCriteriaType, StringHolder newSearchCriteria, StringHolder searchCriteriaType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(inputSearchCriteriaType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteria", "createSearchCriteria", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSearchCriteria.value = TcUtility.queryArg(response.output[0], newSearchCriteria.value);
    searchCriteriaType.value = TcUtility.queryArg(response.output[1], searchCriteriaType.value);
  }

  public void getType(String searchCriteria, StringHolder searchCriteriaType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteria);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteria", "getType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    searchCriteriaType.value = TcUtility.queryArgStringUnion(response.output[0], searchCriteriaType.value);
  }

}
