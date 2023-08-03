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

public class ICCTRouteCurve extends ICCT {
  public ICCTRouteCurve(Connection connection) {
    super(connection);
  }

  public ICCTRouteCurve(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createRouteCurve(String name, String contextLineUid, StringHolder newRouteSegmentUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArg(contextLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteCurve", "createRouteCurve", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRouteSegmentUid.value = TcUtility.queryArg(response.output[0], newRouteSegmentUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void askCurveName(String routeCurveUid, StringHolder name) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeCurveUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteCurve", "askCurveName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    name.value = TcUtility.queryArgStringUnion(response.output[0], name.value);
  }

  public void listRoutes(String routeCurveUid, uidSeq_tHolder routeUids, uidSeq_tHolder routeTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeCurveUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteCurve", "listRoutes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    routeUids.value = TcUtility.queryArg(response.output[0], routeUids.value);
    routeTypeUids.value = TcUtility.queryArg(response.output[1], routeTypeUids.value);
  }

  public void listSegments(String routeCurveUid, uidSeq_tHolder segmentUids, uidSeq_tHolder segmentTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeCurveUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteCurve", "listSegments", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    segmentUids.value = TcUtility.queryArg(response.output[0], segmentUids.value);
    segmentTypeUids.value = TcUtility.queryArg(response.output[1], segmentTypeUids.value);
  }

}
