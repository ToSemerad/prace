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

public class ICCTIDCLine extends ICCT {
  public ICCTIDCLine(Connection connection) {
    super(connection);
  }

  public ICCTIDCLine(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void listChildren(String idcLine, uidValueSeq_tHolder childLines, uidValueSeq_tHolder childLinesTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(idcLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIDCLine", "listChildren", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    childLines.value = TcUtility.queryArgStringUnion(response.output[0], childLines.value);
    childLinesTypes.value = TcUtility.queryArgStringUnion(response.output[1], childLinesTypes.value);
  }

  public void bomCompareSetStopLines(String rootLine, String[] lines) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rootLine);
    args_[3] = TcUtility.createArg(lines);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIDCLine", "bomCompareSetStopLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
