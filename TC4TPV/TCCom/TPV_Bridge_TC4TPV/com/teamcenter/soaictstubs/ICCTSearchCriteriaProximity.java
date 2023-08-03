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

public class ICCTSearchCriteriaProximity extends ICCTSearchCriteria {
  public ICCTSearchCriteriaProximity(Connection connection) {
    super(connection);
  }

  public ICCTSearchCriteriaProximity(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String inputProximityType, double distance, String targetAppearance, String bgAppearance, StringHolder newSearchCriteriaProximity, StringHolder searchCriteriaProximityType) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(inputProximityType);
    args_[3] = TcUtility.createArg(distance);
    args_[4] = TcUtility.createArgStringUnion(targetAppearance);
    args_[5] = TcUtility.createArgStringUnion(bgAppearance);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaProximity", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSearchCriteriaProximity.value = TcUtility.queryArg(response.output[0], newSearchCriteriaProximity.value);
    searchCriteriaProximityType.value = TcUtility.queryArg(response.output[1], searchCriteriaProximityType.value);
  }

  public void getDistance(String searchCriteriaProximity, DoubleHolder distance) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaProximity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaProximity", "getDistance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    distance.value = TcUtility.queryArg(response.output[0], distance.value);
  }

  public void getTargetAppearance(String searchCriteriaProximity, StringHolder targetAppearance, StringHolder targetAppearanceType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaProximity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaProximity", "getTargetAppearance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    targetAppearance.value = TcUtility.queryArgStringUnion(response.output[0], targetAppearance.value);
    targetAppearanceType.value = TcUtility.queryArgStringUnion(response.output[1], targetAppearanceType.value);
  }

  public void getBackgroundAppearance(String searchCriteriaProximity, StringHolder bgAppearance, StringHolder bgAppearanceType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaProximity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaProximity", "getBackgroundAppearance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bgAppearance.value = TcUtility.queryArgStringUnion(response.output[0], bgAppearance.value);
    bgAppearanceType.value = TcUtility.queryArgStringUnion(response.output[1], bgAppearanceType.value);
  }

}
