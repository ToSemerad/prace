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

public class ICCTSearchCriteriaAppearances extends ICCTSearchCriteria {
  public ICCTSearchCriteriaAppearances(Connection connection) {
    super(connection);
  }

  public ICCTSearchCriteriaAppearances(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String inputType, int noOfSelectedMEApprPathNodes, String[] selectedMEApprPathNodes, int noOfUnselectedMEApprPathNodes, String[] unselectedMEApprPathNodes, StringHolder newSearchCriteriaAppearances, StringHolder searchCriteriaAppearancesType) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(inputType);
    args_[3] = TcUtility.createArg(noOfSelectedMEApprPathNodes);
    args_[4] = TcUtility.createArg(selectedMEApprPathNodes);
    args_[5] = TcUtility.createArg(noOfUnselectedMEApprPathNodes);
    args_[6] = TcUtility.createArg(unselectedMEApprPathNodes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaAppearances", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSearchCriteriaAppearances.value = TcUtility.queryArg(response.output[0], newSearchCriteriaAppearances.value);
    searchCriteriaAppearancesType.value = TcUtility.queryArg(response.output[1], searchCriteriaAppearancesType.value);
  }

  public void getSelectedMEApprPathNodes(String searchCriteriaAppearances, IntHolder noOfSelectedMEApprPathNodes, uidSeqValue_uHolder selectedMEApprPathNodes, uidSeqValue_uHolder selectedMEApprPathNodeTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaAppearances);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaAppearances", "getSelectedMEApprPathNodes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfSelectedMEApprPathNodes.value = TcUtility.queryArg(response.output[0], noOfSelectedMEApprPathNodes.value);
    selectedMEApprPathNodes.value = TcUtility.queryArg(response.output[1], selectedMEApprPathNodes.value);
    selectedMEApprPathNodeTypes.value = TcUtility.queryArg(response.output[2], selectedMEApprPathNodeTypes.value);
  }

  public void getUnselectedMEApprPathNodes(String searchCriteriaAppearances, IntHolder noOfUnselectedMEApprPathNodes, uidSeqValue_uHolder unselectedMEApprPathNodes, uidSeqValue_uHolder unselectedMEApprPathNodeTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaAppearances);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaAppearances", "getUnselectedMEApprPathNodes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfUnselectedMEApprPathNodes.value = TcUtility.queryArg(response.output[0], noOfUnselectedMEApprPathNodes.value);
    unselectedMEApprPathNodes.value = TcUtility.queryArg(response.output[1], unselectedMEApprPathNodes.value);
    unselectedMEApprPathNodeTypes.value = TcUtility.queryArg(response.output[2], unselectedMEApprPathNodeTypes.value);
  }

}
