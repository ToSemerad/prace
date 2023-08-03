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

public class ICCTAllocationMap extends ICCTItem {
  public ICCTAllocationMap(Connection connection) {
    super(connection);
  }

  public ICCTAllocationMap(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createAllocationMap(String map_id, String map_name, String map_type, String map_rev_id, String sourceBVUid, String targetBVUid, StringHolder newMapUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(map_id);
    args_[3] = TcUtility.createArg(map_name);
    args_[4] = TcUtility.createArg(map_type);
    args_[5] = TcUtility.createArg(map_rev_id);
    args_[6] = TcUtility.createArg(sourceBVUid);
    args_[7] = TcUtility.createArg(targetBVUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocationMap", "createAllocationMap", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newMapUid.value = TcUtility.queryArg(response.output[0], newMapUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void askSourceBV(String mapUid, StringHolder sourceBVUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(mapUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocationMap", "askSourceBV", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    sourceBVUid.value = TcUtility.queryArg(response.output[0], sourceBVUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void askTargetBV(String mapUid, StringHolder targetBVUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(mapUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocationMap", "askTargetBV", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    targetBVUid.value = TcUtility.queryArg(response.output[0], targetBVUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void copyMap(String oldMapRevUid, String new_map_id, String new_map_rev_id, StringHolder newMapUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(oldMapRevUid);
    args_[3] = TcUtility.createArg(new_map_id);
    args_[4] = TcUtility.createArg(new_map_rev_id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocationMap", "copyMap", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newMapUid.value = TcUtility.queryArg(response.output[0], newMapUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void findMap(String sourceBVUid, String targetBVUid, uidSeqValue_uHolder mapUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(sourceBVUid);
    args_[3] = TcUtility.createArg(targetBVUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocationMap", "findMap", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mapUids.value = TcUtility.queryArg(response.output[0], mapUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

}
