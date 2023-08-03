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

public class ICCTSearchCriteriaBoxZone extends ICCTSearchCriteria {
  public ICCTSearchCriteriaBoxZone(Connection connection) {
    super(connection);
  }

  public ICCTSearchCriteriaBoxZone(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String inputBoxZoneType, int noCoordinates, double[] coordinates, int zoneComparator, StringHolder newSearchCriteriaBoxZone, StringHolder searchCriteriaBoxZoneType) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(inputBoxZoneType);
    args_[3] = TcUtility.createArg(noCoordinates);
    args_[4] = TcUtility.createArg(coordinates);
    args_[5] = TcUtility.createArg(zoneComparator);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaBoxZone", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSearchCriteriaBoxZone.value = TcUtility.queryArg(response.output[0], newSearchCriteriaBoxZone.value);
    searchCriteriaBoxZoneType.value = TcUtility.queryArg(response.output[1], searchCriteriaBoxZoneType.value);
  }

  public void getCoordinates(String searchCriteriaBoxZone, IntHolder noCoordinates, doubleSeqValue_uHolder coordinates) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaBoxZone);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaBoxZone", "getCoordinates", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noCoordinates.value = TcUtility.queryArg(response.output[0], noCoordinates.value);
    coordinates.value = TcUtility.queryArg(response.output[1], coordinates.value);
  }

  public void getZoneComparator(String searchCriteriaBoxZone, IntHolder zoneComparator) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaBoxZone);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaBoxZone", "getZoneComparator", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    zoneComparator.value = TcUtility.queryArg(response.output[0], zoneComparator.value);
  }

}
