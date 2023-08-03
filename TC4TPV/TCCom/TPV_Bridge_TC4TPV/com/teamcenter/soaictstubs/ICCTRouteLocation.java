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

public class ICCTRouteLocation extends ICCTItem {
  public ICCTRouteLocation(Connection connection) {
    super(connection);
  }

  public ICCTRouteLocation(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createRouteLocation(String id, String name, String type, String rev_id, StringHolder newRouteLocationUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(id);
    args_[3] = TcUtility.createArg(name);
    args_[4] = TcUtility.createArg(type);
    args_[5] = TcUtility.createArg(rev_id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteLocation", "createRouteLocation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRouteLocationUid.value = TcUtility.queryArg(response.output[0], newRouteLocationUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void setAssignedLocation(String pri_obj, String loc_line, StringHolder relUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(pri_obj);
    args_[3] = TcUtility.createArg(loc_line);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteLocation", "setAssignedLocation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    relUid.value = TcUtility.queryArg(response.output[0], relUid.value);
  }

  public void unsetAssignedLocation(String pri_obj, String loc_line) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(pri_obj);
    args_[3] = TcUtility.createArg(loc_line);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteLocation", "unsetAssignedLocation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askAssignedLocations(String associating_obj, String window, uidSeq_tHolder locationUids, uidSeq_tHolder locationTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(associating_obj);
    args_[3] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteLocation", "askAssignedLocations", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    locationUids.value = TcUtility.queryArg(response.output[0], locationUids.value);
    locationTypeUids.value = TcUtility.queryArg(response.output[1], locationTypeUids.value);
  }

  public void setDefiningItem(String pri_obj, String loc_line, StringHolder relUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(pri_obj);
    args_[3] = TcUtility.createArg(loc_line);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteLocation", "setDefiningItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    relUid.value = TcUtility.queryArg(response.output[0], relUid.value);
  }

  public void unsetDefiningItem(String loc_line) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(loc_line);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteLocation", "unsetDefiningItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askDefiningItem(String loc_line, StringHolder definingUid, StringHolder definingTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(loc_line);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteLocation", "askDefiningItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    definingUid.value = TcUtility.queryArg(response.output[0], definingUid.value);
    definingTypeUid.value = TcUtility.queryArg(response.output[1], definingTypeUid.value);
  }

  public void findAssignedObjects(String location_line, uidSeq_tHolder assignedUids, uidSeq_tHolder assignedTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(location_line);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteLocation", "findAssignedObjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    assignedUids.value = TcUtility.queryArg(response.output[0], assignedUids.value);
    assignedTypeUids.value = TcUtility.queryArg(response.output[1], assignedTypeUids.value);
  }

}
