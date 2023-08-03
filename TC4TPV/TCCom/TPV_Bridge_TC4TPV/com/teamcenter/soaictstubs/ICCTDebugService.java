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

public class ICCTDebugService {
  ICTService m_service;

  Connection m_connection;


  public ICCTDebugService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void askMemoryStatistics(stringSeqValue_uHolder names, longSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "askMemoryStatistics", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    names.value = TcUtility.queryArg(response.output[0], names.value);
    values.value = TcUtility.queryArg(response.output[1], values.value);
  }

  public void startSMLogging() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "startSMLogging", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void reportSMLogging() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "reportSMLogging", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void startIPA() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "startIPA", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void stopIPA() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "stopIPA", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void startBMFdebug() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "startBMFdebug", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void stopBMFdebug() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "stopBMFdebug", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void catchThisIfail(int ifail) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(ifail);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "catchThisIfail", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askCatchingIfail(IntHolder ifail) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "askCatchingIfail", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ifail.value = TcUtility.queryArg(response.output[0], ifail.value);
  }

  public void dumpFile(int whichFile, int howMuch, stringSeqValue_uHolder contents) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(whichFile);
    args_[1] = TcUtility.createArg(howMuch);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "dumpFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    contents.value = TcUtility.queryArg(response.output[0], contents.value);
  }

  public void omPrintObject(String obj, stringSeqValue_uHolder results) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "omPrintObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    results.value = TcUtility.queryArg(response.output[0], results.value);
  }

  public void uidToTag(String objUid, IntHolder objTag) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "uidToTag", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objTag.value = TcUtility.queryArg(response.output[0], objTag.value);
  }

  public void dumpByClass() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "dumpByClass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void rereadPreferences() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "rereadPreferences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getSqlSwitches(BooleanHolder debugState, BooleanHolder showBindVariables, BooleanHolder profile, BooleanHolder toJournal, BooleanHolder timing) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "getSqlSwitches", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    debugState.value = TcUtility.queryArg(response.output[0], debugState.value);
    showBindVariables.value = TcUtility.queryArg(response.output[1], showBindVariables.value);
    profile.value = TcUtility.queryArg(response.output[2], profile.value);
    toJournal.value = TcUtility.queryArg(response.output[3], toJournal.value);
    timing.value = TcUtility.queryArg(response.output[4], timing.value);
  }

  public void setSqlSwitches(boolean debugState, boolean showBindVariables, boolean profile, boolean toJournal, boolean timing) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(debugState);
    args_[1] = TcUtility.createArg(showBindVariables);
    args_[2] = TcUtility.createArg(profile);
    args_[3] = TcUtility.createArg(toJournal);
    args_[4] = TcUtility.createArg(timing);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "setSqlSwitches", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void sqlProfileAndReset() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "sqlProfileAndReset", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void sqlProfileReportAndReset(String comment, IntHolder n_calls, IntHolder n_rows, IntHolder n_errors, DoubleHolder tot_time, DoubleHolder server_cpu, DoubleHolder server_real) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(comment);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "sqlProfileReportAndReset", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    n_calls.value = TcUtility.queryArg(response.output[0], n_calls.value);
    n_rows.value = TcUtility.queryArg(response.output[1], n_rows.value);
    n_errors.value = TcUtility.queryArg(response.output[2], n_errors.value);
    tot_time.value = TcUtility.queryArg(response.output[3], tot_time.value);
    server_cpu.value = TcUtility.queryArg(response.output[4], server_cpu.value);
    server_real.value = TcUtility.queryArg(response.output[5], server_real.value);
  }

  public void dumpPreferences() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "dumpPreferences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void dumpCollections() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "dumpCollections", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void explainPlans(boolean onOrOff) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(onOrOff);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "explainPlans", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askExplainPlans(BooleanHolder onOrOff) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "askExplainPlans", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    onOrOff.value = TcUtility.queryArg(response.output[0], onOrOff.value);
  }

  public void isEnabled(String service, BooleanHolder verdict) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(service);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "isEnabled", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void journalComment(String comment) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(comment);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "journalComment", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void corbaProfileControl(int op) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(op);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "corbaProfileControl", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void ipa(boolean startStop) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(startStop);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "ipa", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void SMTracking(int area, int op) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(area);
    args_[1] = TcUtility.createArg(op);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "SMTracking", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getServerLogFilenames(StringHolder syslogFilename, StringHolder journalFilename) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTDebugService", "getServerLogFilenames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    syslogFilename.value = TcUtility.queryArg(response.output[0], syslogFilename.value);
    journalFilename.value = TcUtility.queryArg(response.output[1], journalFilename.value);
  }

}
