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

public class ICCTSearchCriteriaPlaneZone extends ICCTSearchCriteria {
  public ICCTSearchCriteriaPlaneZone(Connection connection) {
    super(connection);
  }

  public ICCTSearchCriteriaPlaneZone(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String inputPlaneZoneType, int noCoordinates, double[] coordinates, int zoneComparator, StringHolder newSearchCriteriaPlaneZone, StringHolder searchCriteriaPlaneZone) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(inputPlaneZoneType);
    args_[3] = TcUtility.createArg(noCoordinates);
    args_[4] = TcUtility.createArg(coordinates);
    args_[5] = TcUtility.createArg(zoneComparator);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaPlaneZone", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSearchCriteriaPlaneZone.value = TcUtility.queryArg(response.output[0], newSearchCriteriaPlaneZone.value);
    searchCriteriaPlaneZone.value = TcUtility.queryArg(response.output[1], searchCriteriaPlaneZone.value);
  }

  public void getCoordinates(String searchCriteriaPlaneZone, IntHolder noCoordinates, doubleSeqValue_uHolder coordinates) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaPlaneZone);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaPlaneZone", "getCoordinates", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noCoordinates.value = TcUtility.queryArg(response.output[0], noCoordinates.value);
    coordinates.value = TcUtility.queryArg(response.output[1], coordinates.value);
  }

  public void getZoneComparator(String searchCriteriaPlaneZone, IntHolder zoneComparator) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaPlaneZone);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaPlaneZone", "getZoneComparator", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    zoneComparator.value = TcUtility.queryArg(response.output[0], zoneComparator.value);
  }

}
