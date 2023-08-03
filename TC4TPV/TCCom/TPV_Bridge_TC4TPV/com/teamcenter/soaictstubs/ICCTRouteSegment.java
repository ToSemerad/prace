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

public class ICCTRouteSegment extends ICCT {
  public ICCTRouteSegment(Connection connection) {
    super(connection);
  }

  public ICCTRouteSegment(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createRouteSegment(String name, String contextLineUid, StringHolder newRouteSegmentUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArg(contextLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "createRouteSegment", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRouteSegmentUid.value = TcUtility.queryArg(response.output[0], newRouteSegmentUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void askSegmentName(String routeSegmentUid, StringHolder name) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "askSegmentName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    name.value = TcUtility.queryArgStringUnion(response.output[0], name.value);
  }

  public void setRealLength(String routeSegmentUid, double value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    args_[3] = TcUtility.createArg(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "setRealLength", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setRepresentedLength(String routeSegmentUid, double value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    args_[3] = TcUtility.createArg(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "setRepresentedLength", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askLength(String routeSegmentUid, DoubleHolder real_length, DoubleHolder rep_length) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "askLength", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    real_length.value = TcUtility.queryArg(response.output[0], real_length.value);
    rep_length.value = TcUtility.queryArg(response.output[1], rep_length.value);
  }

  public void setCrossSectionalArea(String routeSegmentUid, double area) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    args_[3] = TcUtility.createArg(area);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "setCrossSectionalArea", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askCrossSectionalArea(String routeSegmentUid, DoubleHolder area) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "askCrossSectionalArea", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    area.value = TcUtility.queryArg(response.output[0], area.value);
  }

  public void setSegmentStart(String routeSegmentUid, String nodeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    args_[3] = TcUtility.createArg(nodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "setSegmentStart", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askSegmentStart(String routeSegmentUid, StringHolder nodeUid, StringHolder nodeTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "askSegmentStart", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nodeUid.value = TcUtility.queryArg(response.output[0], nodeUid.value);
    nodeTypeUid.value = TcUtility.queryArg(response.output[1], nodeTypeUid.value);
  }

  public void setSegmentEnd(String routeSegmentUid, String nodeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    args_[3] = TcUtility.createArg(nodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "setSegmentEnd", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askSegmentEnd(String routeSegmentUid, StringHolder nodeUid, StringHolder nodeTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "askSegmentEnd", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nodeUid.value = TcUtility.queryArg(response.output[0], nodeUid.value);
    nodeTypeUid.value = TcUtility.queryArg(response.output[1], nodeTypeUid.value);
  }

  public void setSegmentCenterCurve(String routeSegmentUid, String curveUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    args_[3] = TcUtility.createArg(curveUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "setSegmentCenterCurve", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askSegmentCenterCurve(String routeSegmentUid, StringHolder curveUid, StringHolder curveTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "askSegmentCenterCurve", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    curveUid.value = TcUtility.queryArg(response.output[0], curveUid.value);
    curveTypeUid.value = TcUtility.queryArg(response.output[1], curveTypeUid.value);
  }

  public void listRoutes(String routeSegmentUid, uidSeq_tHolder routeUids, uidSeq_tHolder routeTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeSegmentUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRouteSegment", "listRoutes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    routeUids.value = TcUtility.queryArg(response.output[0], routeUids.value);
    routeTypeUids.value = TcUtility.queryArg(response.output[1], routeTypeUids.value);
  }

}
