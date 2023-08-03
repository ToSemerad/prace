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

public class ICCTSite extends ICCT {
  public ICCTSite(Connection connection) {
    super(connection);
  }

  public ICCTSite(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String siteName, int siteID, String siteNode, String soaUrl, String gmsUrl, String licenseServer, boolean odsSite, boolean hubSite, boolean httpSite, boolean plmxml, boolean offline, boolean replicaDel, boolean unmanaged, StringHolder site, StringHolder siteType) throws Exception {
    Arg[] args_ = new Arg[15];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(siteName);
    args_[3] = TcUtility.createArg(siteID);
    args_[4] = TcUtility.createArgStringUnion(siteNode);
    args_[5] = TcUtility.createArgStringUnion(soaUrl);
    args_[6] = TcUtility.createArgStringUnion(gmsUrl);
    args_[7] = TcUtility.createArgStringUnion(licenseServer);
    args_[8] = TcUtility.createArg(odsSite);
    args_[9] = TcUtility.createArg(hubSite);
    args_[10] = TcUtility.createArg(httpSite);
    args_[11] = TcUtility.createArg(plmxml);
    args_[12] = TcUtility.createArg(offline);
    args_[13] = TcUtility.createArg(replicaDel);
    args_[14] = TcUtility.createArg(unmanaged);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    site.value = TcUtility.queryArg(response.output[0], site.value);
    siteType.value = TcUtility.queryArg(response.output[1], siteType.value);
  }

  public void extentODSSites(uidSeqValue_uHolder sites, uidSeqValue_uHolder siteTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "extentODSSites", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    sites.value = TcUtility.queryArg(response.output[0], sites.value);
    siteTypes.value = TcUtility.queryArg(response.output[1], siteTypes.value);
  }

  public void findSiteByID(int siteID, StringHolder site, StringHolder siteType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(siteID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "findSiteByID", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    site.value = TcUtility.queryArgStringUnion(response.output[0], site.value);
    siteType.value = TcUtility.queryArgStringUnion(response.output[1], siteType.value);
  }

  public void getSiteInfo(String site, StringHolder siteName, IntHolder siteID) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "getSiteInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    siteName.value = TcUtility.queryArg(response.output[0], siteName.value);
    siteID.value = TcUtility.queryArg(response.output[1], siteID.value);
  }

  public void getSiteInfoEx(String site, StringHolder siteName, IntHolder siteID, BooleanHolder externalApp) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "getSiteInfoEx", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    siteName.value = TcUtility.queryArg(response.output[0], siteName.value);
    siteID.value = TcUtility.queryArg(response.output[1], siteID.value);
    externalApp.value = TcUtility.queryArg(response.output[2], externalApp.value);
  }

  public void getAllSiteInfo(stringSeqValue_uHolder siteList, longValueSeq_tHolder siteIdList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "getAllSiteInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    siteList.value = TcUtility.queryArg(response.output[0], siteList.value);
    siteIdList.value = TcUtility.queryArg(response.output[1], siteIdList.value);
  }

  public void getAllSiteInfoEx(stringSeqValue_uHolder siteList, longValueSeq_tHolder siteIdList, booleanValueSeq_tHolder externalAppList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "getAllSiteInfoEx", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    siteList.value = TcUtility.queryArg(response.output[0], siteList.value);
    siteIdList.value = TcUtility.queryArg(response.output[1], siteIdList.value);
    externalAppList.value = TcUtility.queryArg(response.output[2], externalAppList.value);
  }

  public void setSiteName(String site, String siteName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArg(siteName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setSiteName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setSiteNode(String site, String siteNode) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArgStringUnion(siteNode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setSiteNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setSoaUrl(String site, String soaUrl) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArgStringUnion(soaUrl);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setSoaUrl", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setGmsUrl(String site, String gmsUrl) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArgStringUnion(gmsUrl);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setGmsUrl", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setLicenseServer(String site, String licenseServer) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArgStringUnion(licenseServer);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setLicenseServer", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setSiteOds(String site, boolean siteOds) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArg(siteOds);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setSiteOds", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setSiteHub(String site, boolean siteHub) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArg(siteHub);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setSiteHub", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setSiteHttp(String site, boolean siteHttp) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArg(siteHttp);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setSiteHttp", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setSiteTcPlmxml(String site, boolean plmxml) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArg(plmxml);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setSiteTcPlmxml", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setSiteOffline(String site, boolean offline) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArg(offline);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setSiteOffline", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setSiteUnmanaged(String site, boolean unmanaged) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArg(unmanaged);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setSiteUnmanaged", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setMasterDeletionAllowed(String site, boolean replicaDel) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArg(replicaDel);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setMasterDeletionAllowed", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setApplicationType(String site, int applicationType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    args_[3] = TcUtility.createArg(applicationType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "setApplicationType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void isExternalApplication(String site, BooleanHolder isExternal) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(site);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "isExternalApplication", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isExternal.value = TcUtility.queryArg(response.output[0], isExternal.value);
  }

  public void askSearchableSites(uidSeqValue_uHolder sitesIncluded, uidSeqValue_uHolder sitesIncludedTypes, uidSeqValue_uHolder sitesExcluded, uidSeqValue_uHolder sitesExcludedTypes, uidSeqValue_uHolder userSitesIncluded, uidSeqValue_uHolder userSitesIncludedTypes, uidSeqValue_uHolder userSitesExcluded, uidSeqValue_uHolder userSitesExcludedTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSite", "askSearchableSites", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    sitesIncluded.value = TcUtility.queryArg(response.output[0], sitesIncluded.value);
    sitesIncludedTypes.value = TcUtility.queryArg(response.output[1], sitesIncludedTypes.value);
    sitesExcluded.value = TcUtility.queryArg(response.output[2], sitesExcluded.value);
    sitesExcludedTypes.value = TcUtility.queryArg(response.output[3], sitesExcludedTypes.value);
    userSitesIncluded.value = TcUtility.queryArg(response.output[4], userSitesIncluded.value);
    userSitesIncludedTypes.value = TcUtility.queryArg(response.output[5], userSitesIncludedTypes.value);
    userSitesExcluded.value = TcUtility.queryArg(response.output[6], userSitesExcluded.value);
    userSitesExcludedTypes.value = TcUtility.queryArg(response.output[7], userSitesExcludedTypes.value);
  }

}
