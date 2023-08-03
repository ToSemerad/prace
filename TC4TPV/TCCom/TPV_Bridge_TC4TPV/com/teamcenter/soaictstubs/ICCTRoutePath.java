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

public class ICCTRoutePath extends ICCT {
  public ICCTRoutePath(Connection connection) {
    super(connection);
  }

  public ICCTRoutePath(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createRoutePath(String name, String desc, String contextLineUid, StringHolder newRouteUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArg(desc);
    args_[4] = TcUtility.createArg(contextLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "createRoutePath", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRouteUid.value = TcUtility.queryArg(response.output[0], newRouteUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void setRealLength(String routeUid, double value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    args_[3] = TcUtility.createArg(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "setRealLength", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setRepresentedLength(String routeUid, double value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    args_[3] = TcUtility.createArg(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "setRepresentedLength", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askLength(String routeUid, DoubleHolder real_length, DoubleHolder pre_length) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "askLength", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    real_length.value = TcUtility.queryArg(response.output[0], real_length.value);
    pre_length.value = TcUtility.queryArg(response.output[1], pre_length.value);
  }

  public void addSegment(String routeUid, String segmentUid, int position) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    args_[3] = TcUtility.createArg(segmentUid);
    args_[4] = TcUtility.createArg(position);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "addSegment", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listSegments(String routeUid, uidSeq_tHolder segmentUids, uidSeq_tHolder segmentTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "listSegments", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    segmentUids.value = TcUtility.queryArg(response.output[0], segmentUids.value);
    segmentTypeUids.value = TcUtility.queryArg(response.output[1], segmentTypeUids.value);
  }

  public void removeSegment(String routeUid, String segmentUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    args_[3] = TcUtility.createArg(segmentUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "removeSegment", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addNode(String routeUid, String nodeUid, int position) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    args_[3] = TcUtility.createArg(nodeUid);
    args_[4] = TcUtility.createArg(position);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "addNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listNodes(String routeUid, uidSeq_tHolder nodeUids, uidSeq_tHolder nodeTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "listNodes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nodeUids.value = TcUtility.queryArg(response.output[0], nodeUids.value);
    nodeTypeUids.value = TcUtility.queryArg(response.output[1], nodeTypeUids.value);
  }

  public void removeNode(String routeUid, String nodeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    args_[3] = TcUtility.createArg(nodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "removeNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setCurve(String routeUid, String curveUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    args_[3] = TcUtility.createArg(curveUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "setCurve", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askCurve(String routeUid, StringHolder curveUid, StringHolder curveTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "askCurve", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    curveUid.value = TcUtility.queryArg(response.output[0], curveUid.value);
    curveTypeUid.value = TcUtility.queryArg(response.output[1], curveTypeUid.value);
  }

  public void associateRoute(String bomLineUid, String routeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLineUid);
    args_[3] = TcUtility.createArg(routeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "associateRoute", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unassociateRoute(String bomLineUid, String routeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLineUid);
    args_[3] = TcUtility.createArg(routeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "unassociateRoute", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askAssociatedRoute(String bomLineUid, StringHolder routeUid, StringHolder routeTpeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "askAssociatedRoute", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    routeUid.value = TcUtility.queryArg(response.output[0], routeUid.value);
    routeTpeUid.value = TcUtility.queryArg(response.output[1], routeTpeUid.value);
  }

  public void askAssociatedBomLines(String routeUid, String winUid, uidSeq_tHolder bomLineUids, uidSeq_tHolder bomLineTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    args_[3] = TcUtility.createArg(winUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "askAssociatedBomLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomLineUids.value = TcUtility.queryArg(response.output[0], bomLineUids.value);
    bomLineTypeUids.value = TcUtility.queryArg(response.output[1], bomLineTypeUids.value);
  }

  public void setDisplayProps(String routeUid, int font, double width, double[] colours) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    args_[3] = TcUtility.createArg(font);
    args_[4] = TcUtility.createArg(width);
    args_[5] = TcUtility.createArg(colours);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "setDisplayProps", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askDisplayProps(String routeUid, IntHolder font, DoubleHolder width, doubleSeqValue_uHolder colours) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(routeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRoutePath", "askDisplayProps", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    font.value = TcUtility.queryArg(response.output[0], font.value);
    width.value = TcUtility.queryArg(response.output[1], width.value);
    colours.value = TcUtility.queryArg(response.output[2], colours.value);
  }

}
