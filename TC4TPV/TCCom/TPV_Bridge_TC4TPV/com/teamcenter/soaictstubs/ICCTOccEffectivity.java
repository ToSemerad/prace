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

public class ICCTOccEffectivity extends ICCT {
  public ICCTOccEffectivity(Connection connection) {
    super(connection);
  }

  public ICCTOccEffectivity(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String id, StringHolder effectivity, StringHolder effectivityType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTOccEffectivity", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    effectivity.value = TcUtility.queryArg(response.output[0], effectivity.value);
    effectivityType.value = TcUtility.queryArg(response.output[1], effectivityType.value);
  }

  public void findEffectivity(String id, StringHolder effectivity, StringHolder effectivityType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTOccEffectivity", "findEffectivity", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    effectivity.value = TcUtility.queryArg(response.output[0], effectivity.value);
    effectivityType.value = TcUtility.queryArg(response.output[1], effectivityType.value);
  }

  public void listEffectivities(uidSeq_tHolder effectivities, uidSeq_tHolder effectivityTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTOccEffectivity", "listEffectivities", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    effectivities.value = TcUtility.queryArg(response.output[0], effectivities.value);
    effectivityTypes.value = TcUtility.queryArg(response.output[1], effectivityTypes.value);
  }

}
