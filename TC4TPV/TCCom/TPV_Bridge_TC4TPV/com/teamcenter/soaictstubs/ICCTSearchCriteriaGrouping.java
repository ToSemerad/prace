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

public class ICCTSearchCriteriaGrouping extends ICCTSearchCriteria {
  public ICCTSearchCriteriaGrouping(Connection connection) {
    super(connection);
  }

  public ICCTSearchCriteriaGrouping(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String inputGroupingType, int noSubCriterias, String[] subCriterias, int filterOperator, StringHolder newSearchCriteriaGrouping, StringHolder SearchCriteriaGroupingType) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(inputGroupingType);
    args_[3] = TcUtility.createArg(noSubCriterias);
    args_[4] = TcUtility.createArg(subCriterias);
    args_[5] = TcUtility.createArg(filterOperator);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaGrouping", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSearchCriteriaGrouping.value = TcUtility.queryArg(response.output[0], newSearchCriteriaGrouping.value);
    SearchCriteriaGroupingType.value = TcUtility.queryArg(response.output[1], SearchCriteriaGroupingType.value);
  }

  public void getSearchCriteriaOperator(String searchCriteriaGrouping, IntHolder filterOperator) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaGrouping);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaGrouping", "getSearchCriteriaOperator", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    filterOperator.value = TcUtility.queryArg(response.output[0], filterOperator.value);
  }

  public void getSubCriteria(String searchCriteriaGrouping, IntHolder noOfSubCriterias, uidSeqValue_uHolder subCriterias, uidSeqValue_uHolder subCriteriaTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaGrouping);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaGrouping", "getSubCriteria", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfSubCriterias.value = TcUtility.queryArg(response.output[0], noOfSubCriterias.value);
    subCriterias.value = TcUtility.queryArg(response.output[1], subCriterias.value);
    subCriteriaTypes.value = TcUtility.queryArg(response.output[2], subCriteriaTypes.value);
  }

}
