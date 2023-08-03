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

public class ICCTRouteNode extends ICCT {
  public ICCTRouteNode(Connection connection) {
    super(connection);
  }

  public ICCTRouteNode(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createRouteNode(String name, String contextLineUid, StringHolder newRouteNodeUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArg(contextLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteNode", "createRouteNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRouteNodeUid.value = TcUtility.queryArg(response.output[0], newRouteNodeUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void askNodeName(String routeNodeUid, StringHolder name) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeNodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteNode", "askNodeName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    name.value = TcUtility.queryArgStringUnion(response.output[0], name.value);
  }

  public void setNodePosition(String routeNodeUid, double x, double y, double z) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeNodeUid);
    args_[3] = TcUtility.createArg(x);
    args_[4] = TcUtility.createArg(y);
    args_[5] = TcUtility.createArg(z);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteNode", "setNodePosition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askNodePosition(String routeNodeUid, DoubleHolder x, DoubleHolder y, DoubleHolder z) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeNodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteNode", "askNodePosition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    x.value = TcUtility.queryArg(response.output[0], x.value);
    y.value = TcUtility.queryArg(response.output[1], y.value);
    z.value = TcUtility.queryArg(response.output[2], z.value);
  }

  public void listRoutes(String routeNodeUid, uidSeq_tHolder routeUids, uidSeq_tHolder routeTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeNodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteNode", "listRoutes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    routeUids.value = TcUtility.queryArg(response.output[0], routeUids.value);
    routeTypeUids.value = TcUtility.queryArg(response.output[1], routeTypeUids.value);
  }

  public void listSegments(String routeNodeUid, uidSeq_tHolder segmentUids, uidSeq_tHolder segmentTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeNodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteNode", "listSegments", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    segmentUids.value = TcUtility.queryArg(response.output[0], segmentUids.value);
    segmentTypeUids.value = TcUtility.queryArg(response.output[1], segmentTypeUids.value);
  }

}
