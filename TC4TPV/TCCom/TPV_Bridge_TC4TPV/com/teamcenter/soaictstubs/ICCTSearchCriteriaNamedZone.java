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

public class ICCTSearchCriteriaNamedZone extends ICCTSearchCriteria {
  public ICCTSearchCriteriaNamedZone(Connection connection) {
    super(connection);
  }

  public ICCTSearchCriteriaNamedZone(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String inputNamedZoneType, String name, int zoneComparator, StringHolder newSearchCriteriaNamedZone, StringHolder searchCriteriaNamedZone) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(inputNamedZoneType);
    args_[3] = TcUtility.createArgStringUnion(name);
    args_[4] = TcUtility.createArg(zoneComparator);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaNamedZone", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSearchCriteriaNamedZone.value = TcUtility.queryArg(response.output[0], newSearchCriteriaNamedZone.value);
    searchCriteriaNamedZone.value = TcUtility.queryArg(response.output[1], searchCriteriaNamedZone.value);
  }

  public void getName(String searchCriteriaNamedZone, StringHolder name) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaNamedZone);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaNamedZone", "getName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    name.value = TcUtility.queryArgStringUnion(response.output[0], name.value);
  }

  public void getZoneComparator(String searchCriteriaNamedZone, IntHolder zoneComparator) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(searchCriteriaNamedZone);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchCriteriaNamedZone", "getZoneComparator", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    zoneComparator.value = TcUtility.queryArg(response.output[0], zoneComparator.value);
  }

}
