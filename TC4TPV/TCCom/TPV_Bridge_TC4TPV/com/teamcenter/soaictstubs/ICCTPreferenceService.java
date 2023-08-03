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

public class ICCTPreferenceService {
  ICTService m_service;

  Connection m_connection;


  public ICCTPreferenceService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getStringValues(int searchScope, String preferenceName, stringSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(searchScope);
    args_[1] = TcUtility.createArg(preferenceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "getStringValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArg(response.output[0], values.value);
  }

  public void setStringValues(int searchScope, String preferenceName, String[] values) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(searchScope);
    args_[1] = TcUtility.createArg(preferenceName);
    args_[2] = TcUtility.createArgStringUnion(values);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "setStringValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getIntegerValues(int searchScope, String preferenceName, longSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(searchScope);
    args_[1] = TcUtility.createArg(preferenceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "getIntegerValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArg(response.output[0], values.value);
  }

  public void setIntegerValues(int searchScope, String preferenceName, int[] values) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(searchScope);
    args_[1] = TcUtility.createArg(preferenceName);
    args_[2] = TcUtility.createArg(values);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "setIntegerValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getDoubleValues(int searchScope, String preferenceName, doubleSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(searchScope);
    args_[1] = TcUtility.createArg(preferenceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "getDoubleValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArg(response.output[0], values.value);
  }

  public void setDoubleValues(int searchScope, String preferenceName, double[] values) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(searchScope);
    args_[1] = TcUtility.createArg(preferenceName);
    args_[2] = TcUtility.createArg(values);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "setDoubleValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeEntry(int searchScope, String preferenceName) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(searchScope);
    args_[1] = TcUtility.createArg(preferenceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "removeEntry", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getMultipleStringValues(int[] searchScope, String[] preferenceName, stringValueSeq_tHolder values) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(searchScope);
    args_[1] = TcUtility.createArg(preferenceName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "getMultipleStringValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArgStringUnion(response.output[0], values.value);
  }

  public void getMultipleValues(int[] searchScopes, String[] preferenceNames, stringValueSeqSeq_tHolder values) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(searchScopes);
    args_[1] = TcUtility.createArg(preferenceNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "getMultipleValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArgStringUnion(response.output[0], values.value);
  }

  public void setMultipleValues(int[] searchScopes, String[] preferenceNames, String[][] values) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(searchScopes);
    args_[1] = TcUtility.createArg(preferenceNames);
    args_[2] = TcUtility.createArgStringUnion(values);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "setMultipleValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askAllPreferences(preferenceObjectSeq_tHolder sitePreferences, preferenceObjectSeqValue_uHolder groupPreferences, preferenceObjectSeqValue_uHolder rolePreferences, preferenceObjectSeqValue_uHolder userPreferences) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "askAllPreferences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    sitePreferences.value = TcUtility.queryArg(response.output[0], sitePreferences.value);
    groupPreferences.value = TcUtility.queryArg(response.output[1], groupPreferences.value);
    rolePreferences.value = TcUtility.queryArg(response.output[2], rolePreferences.value);
    userPreferences.value = TcUtility.queryArg(response.output[3], userPreferences.value);
  }

  public void exportPreferences(stringSeqValue_u preferenceNames, longSeqValue_u scopes, String fileName, StringHolder fileLocation) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(preferenceNames);
    args_[1] = TcUtility.createArg(scopes);
    args_[2] = TcUtility.createArg(fileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "exportPreferences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileLocation.value = TcUtility.queryArgStringUnion(response.output[0], fileLocation.value);
  }

  public void exportScopedPreferences(int scope, String fileName, StringHolder fileLocation) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(scope);
    args_[1] = TcUtility.createArg(fileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "exportScopedPreferences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileLocation.value = TcUtility.queryArgStringUnion(response.output[0], fileLocation.value);
  }

  public void importPreferences(int scope, preferenceObject_s[] preferences, int action, boolean viewLog, StringHolder logFileLocation) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(scope);
    args_[1] = TcUtility.createArg(preferences);
    args_[2] = TcUtility.createArg(action);
    args_[3] = TcUtility.createArg(viewLog);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "importPreferences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logFileLocation.value = TcUtility.queryArgStringUnion(response.output[0], logFileLocation.value);
  }

  public void importPreferencesXML(int scope, String xmlFileName, int action, boolean viewLog, StringHolder logFileLocation) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(scope);
    args_[1] = TcUtility.createArg(xmlFileName);
    args_[2] = TcUtility.createArg(action);
    args_[3] = TcUtility.createArg(viewLog);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "importPreferencesXML", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logFileLocation.value = TcUtility.queryArgStringUnion(response.output[0], logFileLocation.value);
  }

  public void importDryRun(int scope, String xmlFileName, preferenceObjectSeqValue_uHolder existingDBPrefs, preferenceObjectSeqValue_uHolder xmlPrefs) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(scope);
    args_[1] = TcUtility.createArg(xmlFileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "importDryRun", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    existingDBPrefs.value = TcUtility.queryArg(response.output[0], existingDBPrefs.value);
    xmlPrefs.value = TcUtility.queryArg(response.output[1], xmlPrefs.value);
  }

  public void refresh() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "refresh", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askDeltas(int scope, preferenceObjectSeqValue_uHolder prefDeltas) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(scope);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "askDeltas", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    prefDeltas.value = TcUtility.queryArg(response.output[0], prefDeltas.value);
  }

  public void getNewFile(StringHolder newFileLocation) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "getNewFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newFileLocation.value = TcUtility.queryArg(response.output[0], newFileLocation.value);
  }

  public void createPreference(int scope, preferenceObject_s prefToBeCreated) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(scope);
    args_[1] = TcUtility.createArg(prefToBeCreated);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "createPreference", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void modifyPreference(int scope, preferenceObject_s prefToBeModified) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(scope);
    args_[1] = TcUtility.createArg(prefToBeModified);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPreferenceService", "modifyPreference", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
