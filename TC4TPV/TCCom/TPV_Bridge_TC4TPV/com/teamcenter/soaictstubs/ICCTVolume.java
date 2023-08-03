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

public class ICCTVolume extends ICCT {
  public ICCTVolume(Connection connection) {
    super(connection);
  }

  public ICCTVolume(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String volumeName, String volumeNodeName, String[] volumePath, int volumeMachineType, String fscPath, String fscId, String filestoreGroupId, String loadBalancerId, StringHolder volume, StringHolder volumeType) throws Exception {
    Arg[] args_ = new Arg[10];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(volumeName);
    args_[3] = TcUtility.createArg(volumeNodeName);
    args_[4] = TcUtility.createArg(volumePath);
    args_[5] = TcUtility.createArg(volumeMachineType);
    args_[6] = TcUtility.createArg(fscPath);
    args_[7] = TcUtility.createArg(fscId);
    args_[8] = TcUtility.createArg(filestoreGroupId);
    args_[9] = TcUtility.createArg(loadBalancerId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    volume.value = TcUtility.queryArg(response.output[0], volume.value);
    volumeType.value = TcUtility.queryArg(response.output[1], volumeType.value);
  }

  public void find(String volumeName, StringHolder volume, StringHolder volumeType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(volumeName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    volume.value = TcUtility.queryArgStringUnion(response.output[0], volume.value);
    volumeType.value = TcUtility.queryArgStringUnion(response.output[1], volumeType.value);
  }

  public void findByPath(String pathName, int machineType, StringHolder volume, StringHolder volumeType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(pathName);
    args_[3] = TcUtility.createArg(machineType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "findByPath", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    volume.value = TcUtility.queryArgStringUnion(response.output[0], volume.value);
    volumeType.value = TcUtility.queryArgStringUnion(response.output[1], volumeType.value);
  }

  public void move(String volume, String volumeNodeName, String[] volumePath, int volumeMachineType) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(volume);
    args_[3] = TcUtility.createArg(volumeNodeName);
    args_[4] = TcUtility.createArg(volumePath);
    args_[5] = TcUtility.createArg(volumeMachineType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "move", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void modify(String volume, String volumeName, String volumeNodeName, String[] volumePath, int volumeMachineType) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(volume);
    args_[3] = TcUtility.createArg(volumeName);
    args_[4] = TcUtility.createArg(volumeNodeName);
    args_[5] = TcUtility.createArg(volumePath);
    args_[6] = TcUtility.createArg(volumeMachineType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "modify", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAccessibleVolumes(String accessor, String group, uidSeqValue_uHolder volumes, uidSeqValue_uHolder types) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(accessor);
    args_[3] = TcUtility.createArg(group);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "getAccessibleVolumes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    volumes.value = TcUtility.queryArg(response.output[0], volumes.value);
    types.value = TcUtility.queryArg(response.output[1], types.value);
  }

  public void grantAccess(String volume, String target) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(volume);
    args_[3] = TcUtility.createArg(target);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "grantAccess", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void revokeAccess(String volume, String target) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(volume);
    args_[3] = TcUtility.createArg(target);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "revokeAccess", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAccessors(String volume, uidSeqValue_uHolder accessors, uidSeqValue_uHolder accessorTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(volume);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "getAccessors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    accessors.value = TcUtility.queryArg(response.output[0], accessors.value);
    accessorTypes.value = TcUtility.queryArg(response.output[1], accessorTypes.value);
  }

  public void getStatistics(String volume, StringHolder capacity, StringHolder usedSpace, StringHolder freeSpace, StringHolder percentFull) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(volume);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "getStatistics", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    capacity.value = TcUtility.queryArgStringUnion(response.output[0], capacity.value);
    usedSpace.value = TcUtility.queryArgStringUnion(response.output[1], usedSpace.value);
    freeSpace.value = TcUtility.queryArgStringUnion(response.output[2], freeSpace.value);
    percentFull.value = TcUtility.queryArgStringUnion(response.output[3], percentFull.value);
  }

  public void getVolumeNames(stringSeqValue_uHolder volList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "getVolumeNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    volList.value = TcUtility.queryArg(response.output[0], volList.value);
  }

  public void fmsAdminOperation(int operation, StringHolder message1, StringHolder message2) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(operation);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "fmsAdminOperation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    message1.value = TcUtility.queryArg(response.output[0], message1.value);
    message2.value = TcUtility.queryArg(response.output[1], message2.value);
  }

  public void getFscInfo(String volume, StringHolder fscId, StringHolder groupId, StringHolder loadBalancerId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(volume);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "getFscInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fscId.value = TcUtility.queryArgStringUnion(response.output[0], fscId.value);
    groupId.value = TcUtility.queryArgStringUnion(response.output[1], groupId.value);
    loadBalancerId.value = TcUtility.queryArgStringUnion(response.output[2], loadBalancerId.value);
  }

  public void getAllVolumeFileStores(stringSeqValue_uHolder filestoreNodesAndTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "getAllVolumeFileStores", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    filestoreNodesAndTypes.value = TcUtility.queryArg(response.output[0], filestoreNodesAndTypes.value);
  }

  public void getAllVolumesForFileStore(String filestoreId, stringSeqValue_uHolder volumeIds) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(filestoreId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "getAllVolumesForFileStore", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    volumeIds.value = TcUtility.queryArg(response.output[0], volumeIds.value);
  }

  public void getVolumeUsageByUserAndGroup(String volumeName, boolean[] bypassFileStat, stringSeqValue_uHolder usageInfo) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(volumeName);
    args_[3] = TcUtility.createArg(bypassFileStat);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "getVolumeUsageByUserAndGroup", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    usageInfo.value = TcUtility.queryArg(response.output[0], usageInfo.value);
  }

  public void getVolumeInfoForFileStores(String[] filestoreIds, int idCount, stringSeqValue_uHolder volumeFilestoreInfo) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(filestoreIds);
    args_[3] = TcUtility.createArg(idCount);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVolume", "getVolumeInfoForFileStores", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    volumeFilestoreInfo.value = TcUtility.queryArg(response.output[0], volumeFilestoreInfo.value);
  }

}
