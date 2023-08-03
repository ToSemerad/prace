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

public class ICCTSearchResult extends ICCT {
  public ICCTSearchResult(Connection connection) {
    super(connection);
  }

  public ICCTSearchResult(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String appRoot, String revRule, String bomWindow, String[] mappedAttributeNames, String[] mappedAttributeValues, String[] inClassClassNames, ICSProperty_s[] inClassAttributes, String savedQuery, String[] entries, String[] values, uidSeqValue_u targets, double distance, boolean includeSubTree, int boxPlaneRelativePosition, double[] planeNormals, double[] planeDisplacements, StringHolder objectUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[18];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(appRoot);
    args_[3] = TcUtility.createArgStringUnion(revRule);
    args_[4] = TcUtility.createArgStringUnion(bomWindow);
    args_[5] = TcUtility.createArgStringUnion(mappedAttributeNames);
    args_[6] = TcUtility.createArgStringUnion(mappedAttributeValues);
    args_[7] = TcUtility.createArgStringUnion(inClassClassNames);
    args_[8] = TcUtility.createArg(inClassAttributes);
    args_[9] = TcUtility.createArgStringUnion(savedQuery);
    args_[10] = TcUtility.createArgStringUnion(entries);
    args_[11] = TcUtility.createArgStringUnion(values);
    args_[12] = TcUtility.createArg(targets);
    args_[13] = TcUtility.createArg(distance);
    args_[14] = TcUtility.createArg(includeSubTree);
    args_[15] = TcUtility.createArg(boxPlaneRelativePosition);
    args_[16] = TcUtility.createArg(planeNormals);
    args_[17] = TcUtility.createArg(planeDisplacements);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchResult", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectUid.value = TcUtility.queryArg(response.output[0], objectUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void askBOMLineNumber(String objectUid, IntHolder numBOMLines) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchResult", "askBOMLineNumber", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    numBOMLines.value = TcUtility.queryArg(response.output[0], numBOMLines.value);
  }

  public void askNextBOMLines(String objectUid, int numBOMLines, uidSeq_tHolder resultBOMLines) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    args_[3] = TcUtility.createArg(numBOMLines);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchResult", "askNextBOMLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    resultBOMLines.value = TcUtility.queryArg(response.output[0], resultBOMLines.value);
  }

  public void askAllAppearances(String objectUid, uidSeq_tHolder resultAppearances) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchResult", "askAllAppearances", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    resultAppearances.value = TcUtility.queryArg(response.output[0], resultAppearances.value);
  }

  public void askAllBOMLines(String objectUid, uidSeq_tHolder resultBOMLines) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSearchResult", "askAllBOMLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    resultBOMLines.value = TcUtility.queryArg(response.output[0], resultBOMLines.value);
  }

}
