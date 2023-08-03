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

public class ICCTBOMWorldService {
  ICTService m_service;

  Connection m_connection;


  public ICCTBOMWorldService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void resetFormattedBOMLineTitles() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWorldService", "resetFormattedBOMLineTitles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void changedAllLines() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWorldService", "changedAllLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAllBOMWindows(uidSeq_tHolder windows, StringHolder windowType) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWorldService", "getAllBOMWindows", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    windows.value = TcUtility.queryArg(response.output[0], windows.value);
    windowType.value = TcUtility.queryArg(response.output[1], windowType.value);
  }

  public void notifyIcItemRevChanged(String icItemRev) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(icItemRev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWorldService", "notifyIcItemRevChanged", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void notifyIcItemChanged(String icItem) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(icItem);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWorldService", "notifyIcItemChanged", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void notifyIcesChanged(String[] ices) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(ices);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOMWorldService", "notifyIcesChanged", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
