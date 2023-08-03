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

public class ICCSGCSService {
  ICTService m_service;

  String m_typeName;

  String m_objectUid;

  Connection m_connection;


  public ICCSGCSService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public ICCSGCSService(Connection connection, String typeName, String objectUid) {
    m_service = ICTService.getService( connection );
    m_typeName = typeName;
    m_objectUid = objectUid;
    m_connection = connection;
  }

  public void setObjectUid(String objectUid) {
    m_objectUid= objectUid;
  }

  public String getObjectUid() {
    return m_objectUid;
  }

  public void setTypeName(String typeName) {
    m_typeName = typeName;
  }

  public String getTypeName() {
    return m_typeName;
  }

  public void ct_ask(uidSeqValue_uHolder theCTUids) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "ct_ask", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCTUids.value = TcUtility.queryArg(response.output[0], theCTUids.value);
  }

  public void ct_describe(String theCTUid, StringHolder theCTId, StringHolder theCTName, longValueSeq_tHolder theCTAttIds, stringValueSeq_tHolder theCTAttName, stringValueSeq_tHolder theCTCompCriteria) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCTUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "ct_describe", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCTId.value = TcUtility.queryArgStringUnion(response.output[0], theCTId.value);
    theCTName.value = TcUtility.queryArgStringUnion(response.output[1], theCTName.value);
    theCTAttIds.value = TcUtility.queryArg(response.output[2], theCTAttIds.value);
    theCTAttName.value = TcUtility.queryArgStringUnion(response.output[3], theCTAttName.value);
    theCTCompCriteria.value = TcUtility.queryArgStringUnion(response.output[4], theCTCompCriteria.value);
  }

  public void ct_create(String theCTName, int[] theCTAttIds, String[] theCTCompCriteria, StringHolder theCTUid, StringHolder theCTId) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCTName);
    args_[3] = TcUtility.createArg(theCTAttIds);
    args_[4] = TcUtility.createArg(theCTCompCriteria);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "ct_create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCTUid.value = TcUtility.queryArg(response.output[0], theCTUid.value);
    theCTId.value = TcUtility.queryArgStringUnion(response.output[1], theCTId.value);
  }

  public void ct_set(String theCTUid, String theCTName, int[] theCTAttIds, String[] theCTCompCriteria) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCTUid);
    args_[3] = TcUtility.createArg(theCTName);
    args_[4] = TcUtility.createArg(theCTAttIds);
    args_[5] = TcUtility.createArg(theCTCompCriteria);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "ct_set", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void ct_remove(String theCTUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCTUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "ct_remove", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void ct_update(String theCTUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCTUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "ct_update", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void ct_update_wsos(String theCTUid, boolean theCreateWsos) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCTUid);
    args_[3] = TcUtility.createArg(theCreateWsos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "ct_update_wsos", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void ct_where_referenced(String theCTUid, stringValueSeq_tHolder theClassIds, uidSeqValue_uHolder theClassUids, uidSeqValue_uHolder theCPDUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCTUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "ct_where_referenced", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theClassIds.value = TcUtility.queryArgStringUnion(response.output[0], theClassIds.value);
    theClassUids.value = TcUtility.queryArg(response.output[1], theClassUids.value);
    theCPDUids.value = TcUtility.queryArg(response.output[2], theCPDUids.value);
  }

  public void cpd_ask(String theClassUid, uidSeqValue_uHolder theCPDUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theClassUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "cpd_ask", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCPDUids.value = TcUtility.queryArg(response.output[0], theCPDUids.value);
  }

  public void cpd_describe(String theCPDUid, StringHolder theClassUid, StringHolder theCTUid, IntHolder theCPDIndex, StringHolder theCPQuantity, StringHolder theDirection, StringHolder theShape, longValueSeq_tHolder theAttributeIds, stringValueSeq_tHolder theAttributeMappings) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCPDUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "cpd_describe", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theClassUid.value = TcUtility.queryArg(response.output[0], theClassUid.value);
    theCTUid.value = TcUtility.queryArg(response.output[1], theCTUid.value);
    theCPDIndex.value = TcUtility.queryArg(response.output[2], theCPDIndex.value);
    theCPQuantity.value = TcUtility.queryArgStringUnion(response.output[3], theCPQuantity.value);
    theDirection.value = TcUtility.queryArgStringUnion(response.output[4], theDirection.value);
    theShape.value = TcUtility.queryArgStringUnion(response.output[5], theShape.value);
    theAttributeIds.value = TcUtility.queryArg(response.output[6], theAttributeIds.value);
    theAttributeMappings.value = TcUtility.queryArgStringUnion(response.output[7], theAttributeMappings.value);
  }

  public void cpd_add(String theClassUid, String theCTUid, int theCPDIndex, String theCPQuantity, String theDirection, String theShape, int[] theAttributeIds, String[] theAttributeMappings, StringHolder theCPDUid) throws Exception {
    Arg[] args_ = new Arg[10];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theClassUid);
    args_[3] = TcUtility.createArg(theCTUid);
    args_[4] = TcUtility.createArg(theCPDIndex);
    args_[5] = TcUtility.createArg(theCPQuantity);
    args_[6] = TcUtility.createArg(theDirection);
    args_[7] = TcUtility.createArg(theShape);
    args_[8] = TcUtility.createArg(theAttributeIds);
    args_[9] = TcUtility.createArg(theAttributeMappings);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "cpd_add", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCPDUid.value = TcUtility.queryArg(response.output[0], theCPDUid.value);
  }

  public void cpd_add_wsos(String theClassUid, String theCTUid, int theCPDIndex, String theCPQuantity, String theDirection, String theShape, int[] theAttributeIds, String[] theAttributeMappings, boolean theCreateWsos, StringHolder theCPDUid) throws Exception {
    Arg[] args_ = new Arg[11];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theClassUid);
    args_[3] = TcUtility.createArg(theCTUid);
    args_[4] = TcUtility.createArg(theCPDIndex);
    args_[5] = TcUtility.createArg(theCPQuantity);
    args_[6] = TcUtility.createArg(theDirection);
    args_[7] = TcUtility.createArg(theShape);
    args_[8] = TcUtility.createArg(theAttributeIds);
    args_[9] = TcUtility.createArg(theAttributeMappings);
    args_[10] = TcUtility.createArg(theCreateWsos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "cpd_add_wsos", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCPDUid.value = TcUtility.queryArg(response.output[0], theCPDUid.value);
  }

  public void cpd_set(String theCPDUid, String theClassUid, String theCTUid, int theCPDIndex, String theCPQuantity, String theDirection, String theShape, int[] theAttributeIds, String[] theAttributeMappings) throws Exception {
    Arg[] args_ = new Arg[11];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCPDUid);
    args_[3] = TcUtility.createArg(theClassUid);
    args_[4] = TcUtility.createArg(theCTUid);
    args_[5] = TcUtility.createArg(theCPDIndex);
    args_[6] = TcUtility.createArg(theCPQuantity);
    args_[7] = TcUtility.createArg(theDirection);
    args_[8] = TcUtility.createArg(theShape);
    args_[9] = TcUtility.createArg(theAttributeIds);
    args_[10] = TcUtility.createArg(theAttributeMappings);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "cpd_set", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void cpd_set_wsos(String theCPDUid, String theClassUid, String theCTUid, int theCPDIndex, String theCPQuantity, String theDirection, String theShape, int[] theAttributeIds, String[] theAttributeMappings, boolean theCreateWsos) throws Exception {
    Arg[] args_ = new Arg[12];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCPDUid);
    args_[3] = TcUtility.createArg(theClassUid);
    args_[4] = TcUtility.createArg(theCTUid);
    args_[5] = TcUtility.createArg(theCPDIndex);
    args_[6] = TcUtility.createArg(theCPQuantity);
    args_[7] = TcUtility.createArg(theDirection);
    args_[8] = TcUtility.createArg(theShape);
    args_[9] = TcUtility.createArg(theAttributeIds);
    args_[10] = TcUtility.createArg(theAttributeMappings);
    args_[11] = TcUtility.createArg(theCreateWsos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "cpd_set_wsos", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void cpd_remove(String theCPDUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCPDUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "cpd_remove", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void cpd_update(String theCPDUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCPDUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "cpd_update", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void cpd_update_wsos(String theCPDUid, boolean theCreateWsos) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCPDUid);
    args_[3] = TcUtility.createArg(theCreateWsos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "cpd_update_wsos", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void cpd_ask_instances(String theCPDUid, uidSeqValue_uHolder theCPUids, uidSeqValue_uHolder theICOUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCPDUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "cpd_ask_instances", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCPUids.value = TcUtility.queryArg(response.output[0], theCPUids.value);
    theICOUids.value = TcUtility.queryArg(response.output[1], theICOUids.value);
  }

  public void cp_ask_cp_of_occ(String theOccurrenceUid, StringHolder theCPUid, StringHolder theComponentUid, StringHolder theCPDUid, StringHolder theCTUid, IntHolder theCPDIndex, IntHolder theCPIndex, StringHolder theDirection, StringHolder theShape, longValueSeq_tHolder theAttributeIds, stringValueSeq_tHolder theAttributeValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theOccurrenceUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "cp_ask_cp_of_occ", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCPUid.value = TcUtility.queryArg(response.output[0], theCPUid.value);
    theComponentUid.value = TcUtility.queryArg(response.output[1], theComponentUid.value);
    theCPDUid.value = TcUtility.queryArg(response.output[2], theCPDUid.value);
    theCTUid.value = TcUtility.queryArg(response.output[3], theCTUid.value);
    theCPDIndex.value = TcUtility.queryArg(response.output[4], theCPDIndex.value);
    theCPIndex.value = TcUtility.queryArg(response.output[5], theCPIndex.value);
    theDirection.value = TcUtility.queryArgStringUnion(response.output[6], theDirection.value);
    theShape.value = TcUtility.queryArgStringUnion(response.output[7], theShape.value);
    theAttributeIds.value = TcUtility.queryArg(response.output[8], theAttributeIds.value);
    theAttributeValues.value = TcUtility.queryArgStringUnion(response.output[9], theAttributeValues.value);
  }

  public void class_search_by_occ(String theOccUid, uidSeqValue_uHolder theCPUids, uidSeqValue_uHolder theICOUids, stringValueSeq_tHolder theClassIds) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theOccUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "class_search_by_occ", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCPUids.value = TcUtility.queryArg(response.output[0], theCPUids.value);
    theICOUids.value = TcUtility.queryArg(response.output[1], theICOUids.value);
    theClassIds.value = TcUtility.queryArgStringUnion(response.output[2], theClassIds.value);
  }

  public void search(String theCPUid, uidSeqValue_uHolder theCPUids, uidSeqValue_uHolder theICOUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCPUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "search", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCPUids.value = TcUtility.queryArg(response.output[0], theCPUids.value);
    theICOUids.value = TcUtility.queryArg(response.output[1], theICOUids.value);
  }

  public void class_search(String theCPUid, uidSeqValue_uHolder theCPUids, uidSeqValue_uHolder theICOUids, stringValueSeq_tHolder theClassIds) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theCPUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSGCSService", "class_search", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theCPUids.value = TcUtility.queryArg(response.output[0], theCPUids.value);
    theICOUids.value = TcUtility.queryArg(response.output[1], theICOUids.value);
    theClassIds.value = TcUtility.queryArgStringUnion(response.output[2], theClassIds.value);
  }

}
