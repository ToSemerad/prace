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

public class ICCSKeyLov extends ICCSAdmin {
  public ICCSKeyLov(Connection connection) {
    super(connection);
  }

  public ICCSKeyLov(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void load(String lovId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSKeyLov", "load", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void create(String lovId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSKeyLov", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void saveAs(String newLovId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newLovId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSKeyLov", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void rename(String newLovId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newLovId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSKeyLov", "rename", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void loadValues(StringHolder pomUID, StringHolder id, StringHolder name, IntHolder sharedSitesCount, stringSeqValue_uHolder sharedSites, IntHolder flags, IntHolder count, stringSeqValue_uHolder keys, stringSeqValue_uHolder values, StringHolder owningSite) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSKeyLov", "loadValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pomUID.value = TcUtility.queryArg(response.output[0], pomUID.value);
    id.value = TcUtility.queryArgStringUnion(response.output[1], id.value);
    name.value = TcUtility.queryArgStringUnion(response.output[2], name.value);
    sharedSitesCount.value = TcUtility.queryArg(response.output[3], sharedSitesCount.value);
    sharedSites.value = TcUtility.queryArg(response.output[4], sharedSites.value);
    flags.value = TcUtility.queryArg(response.output[5], flags.value);
    count.value = TcUtility.queryArg(response.output[6], count.value);
    keys.value = TcUtility.queryArg(response.output[7], keys.value);
    values.value = TcUtility.queryArg(response.output[8], values.value);
    owningSite.value = TcUtility.queryArgStringUnion(response.output[9], owningSite.value);
  }

  public void storeValues(String id, String name, int flags, stringSeqValue_u keys, stringSeqValue_u values, stringSeqValue_u sharedSites) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(id);
    args_[3] = TcUtility.createArg(name);
    args_[4] = TcUtility.createArg(flags);
    args_[5] = TcUtility.createArg(keys);
    args_[6] = TcUtility.createArg(values);
    args_[7] = TcUtility.createArg(sharedSites);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSKeyLov", "storeValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
