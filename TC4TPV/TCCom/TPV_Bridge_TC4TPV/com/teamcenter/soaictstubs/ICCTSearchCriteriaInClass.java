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

public class ICCTSearchCriteriaInClass extends ICCTSearchCriteria {
  public ICCTSearchCriteriaInClass(Connection connection) {
    super(connection);
  }

  public ICCTSearchCriteriaInClass(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String inputInclassType, String icsClass, int icsOptions, int noOfUncts, int[] uncts, String[] unctValues, StringHolder newSearchCriteriaInClass, StringHolder searchCriteriaInClassType) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(inputInclassType);
    args_[3] = TcUtility.createArg(icsClass);
    args_[4] = TcUtility.createArg(icsOptions);
    args_[5] = TcUtility.createArg(noOfUncts);
    args_[6] = TcUtility.createArg(uncts);
    args_[7] = TcUtility.createArgStringUnion(unctValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaInClass", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSearchCriteriaInClass.value = TcUtility.queryArg(response.output[0], newSearchCriteriaInClass.value);
    searchCriteriaInClassType.value = TcUtility.queryArg(response.output[1], searchCriteriaInClassType.value);
  }

  public void getIcsClass(String searchCriteriaInClass, StringHolder icsClass, StringHolder icsClassType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaInClass);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaInClass", "getIcsClass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    icsClass.value = TcUtility.queryArgStringUnion(response.output[0], icsClass.value);
    icsClassType.value = TcUtility.queryArgStringUnion(response.output[1], icsClassType.value);
  }

  public void getIcsOptions(String searchCriteriaInClass, IntHolder icsOptions) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaInClass);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaInClass", "getIcsOptions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    icsOptions.value = TcUtility.queryArg(response.output[0], icsOptions.value);
  }

  public void getUnct(String searchCriteriaInClass, IntHolder noOfUncts, longSeqValue_uHolder uncts) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaInClass);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaInClass", "getUnct", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfUncts.value = TcUtility.queryArg(response.output[0], noOfUncts.value);
    uncts.value = TcUtility.queryArg(response.output[1], uncts.value);
  }

  public void getValue(String searchCriteriaInClass, IntHolder noOfUncts, stringSeqValue_uHolder unctValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaInClass);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaInClass", "getValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfUncts.value = TcUtility.queryArg(response.output[0], noOfUncts.value);
    unctValues.value = TcUtility.queryArg(response.output[1], unctValues.value);
  }

}
