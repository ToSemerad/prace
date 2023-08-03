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

public class ICCTSubscriptionManagerService {
  ICTService m_service;

  Connection m_connection;


  public ICCTSubscriptionManagerService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void subscribe(String target, String subscriber, String evType, String handler, String exeTime, String expDate, stringSeqValue_u parameters, int revOption, stringSeqValue_u attrNames, stringSeqValue_u attrValues, stringSeqValue_u mathOperators, stringSeqValue_u logicOperators, StringHolder subscription, StringHolder subscriptionType) throws Exception {
    Arg[] args_ = new Arg[12];
    args_[0] = TcUtility.createArg(target);
    args_[1] = TcUtility.createArg(subscriber);
    args_[2] = TcUtility.createArg(evType);
    args_[3] = TcUtility.createArg(handler);
    args_[4] = TcUtility.createArgStringUnion(exeTime);
    args_[5] = TcUtility.createArgStringUnion(expDate);
    args_[6] = TcUtility.createArg(parameters);
    args_[7] = TcUtility.createArg(revOption);
    args_[8] = TcUtility.createArg(attrNames);
    args_[9] = TcUtility.createArg(attrValues);
    args_[10] = TcUtility.createArg(mathOperators);
    args_[11] = TcUtility.createArg(logicOperators);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "subscribe", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    subscription.value = TcUtility.queryArg(response.output[0], subscription.value);
    subscriptionType.value = TcUtility.queryArg(response.output[1], subscriptionType.value);
  }

  public void unsubscribe(String subscription) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(subscription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "unsubscribe", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void findSubscription(String target, String subscriber, String evType, String handler, StringHolder subscription, StringHolder subscriptionType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(target);
    args_[1] = TcUtility.createArg(subscriber);
    args_[2] = TcUtility.createArg(evType);
    args_[3] = TcUtility.createArg(handler);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "findSubscription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    subscription.value = TcUtility.queryArgStringUnion(response.output[0], subscription.value);
    subscriptionType.value = TcUtility.queryArgStringUnion(response.output[1], subscriptionType.value);
  }

  public void modifySubscription(String subscription, String newTarget, String newSubscriber, String newEventType, String newHandler, String newExecTime, String newExpDate, stringSeqValue_u newParameters, int revOption, stringSeqValue_u newAttrNames, stringSeqValue_u newAttrValues, stringSeqValue_u newMathOperators, stringSeqValue_u newLogicOperators) throws Exception {
    Arg[] args_ = new Arg[13];
    args_[0] = TcUtility.createArg(subscription);
    args_[1] = TcUtility.createArg(newTarget);
    args_[2] = TcUtility.createArg(newSubscriber);
    args_[3] = TcUtility.createArg(newEventType);
    args_[4] = TcUtility.createArg(newHandler);
    args_[5] = TcUtility.createArgStringUnion(newExecTime);
    args_[6] = TcUtility.createArgStringUnion(newExpDate);
    args_[7] = TcUtility.createArg(newParameters);
    args_[8] = TcUtility.createArg(revOption);
    args_[9] = TcUtility.createArg(newAttrNames);
    args_[10] = TcUtility.createArg(newAttrValues);
    args_[11] = TcUtility.createArg(newMathOperators);
    args_[12] = TcUtility.createArg(newLogicOperators);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "modifySubscription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listSubscriptions(String target, String subscriber, String evType, String handlerId, String execTimeBefore, String execTimeAfter, boolean executeImmediately, String expirationDateBefore, String expirationDateAfter, boolean noExpDate, uidSeqValue_uHolder subs) throws Exception {
    Arg[] args_ = new Arg[10];
    args_[0] = TcUtility.createArgStringUnion(target);
    args_[1] = TcUtility.createArgStringUnion(subscriber);
    args_[2] = TcUtility.createArgStringUnion(evType);
    args_[3] = TcUtility.createArgStringUnion(handlerId);
    args_[4] = TcUtility.createArgStringUnion(execTimeBefore);
    args_[5] = TcUtility.createArgStringUnion(execTimeAfter);
    args_[6] = TcUtility.createArg(executeImmediately);
    args_[7] = TcUtility.createArgStringUnion(expirationDateBefore);
    args_[8] = TcUtility.createArgStringUnion(expirationDateAfter);
    args_[9] = TcUtility.createArg(noExpDate);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "listSubscriptions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    subs.value = TcUtility.queryArg(response.output[0], subs.value);
  }

  public void setTarget(String subscription, String target) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(subscription);
    args_[1] = TcUtility.createArg(target);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "setTarget", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setSubscriber(String subscription, String subscriber) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(subscription);
    args_[1] = TcUtility.createArg(subscriber);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "setSubscriber", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setEventType(String subscription, String evType) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(subscription);
    args_[1] = TcUtility.createArg(evType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "setEventType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setEventHandler(String subscription, String handler) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(subscription);
    args_[1] = TcUtility.createArg(handler);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "setEventHandler", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setExpirationDate(String subscription, String expDate) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(subscription);
    args_[1] = TcUtility.createArgStringUnion(expDate);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "setExpirationDate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setExecutionTime(String subscription, String execTime) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(subscription);
    args_[1] = TcUtility.createArgStringUnion(execTime);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "setExecutionTime", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setHandlerParameters(String subscription, stringSeqValue_u parameters) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(subscription);
    args_[1] = TcUtility.createArg(parameters);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "setHandlerParameters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setConditions(String subscription, stringSeqValue_u attrNames, stringSeqValue_u attrValues, stringSeqValue_u mathOperators, stringSeqValue_u logicOperators) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(subscription);
    args_[1] = TcUtility.createArg(attrNames);
    args_[2] = TcUtility.createArg(attrValues);
    args_[3] = TcUtility.createArg(mathOperators);
    args_[4] = TcUtility.createArg(logicOperators);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "setConditions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void userHasModifyDeleteAccess(String subscription, BooleanHolder flag) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(subscription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "userHasModifyDeleteAccess", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    flag.value = TcUtility.queryArg(response.output[0], flag.value);
  }

  public void enable() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "enable", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void disable() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "disable", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void isEnabled(BooleanHolder flag) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "isEnabled", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    flag.value = TcUtility.queryArg(response.output[0], flag.value);
  }

  public void askTarget(String subscription, StringHolder uid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(subscription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "askTarget", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uid.value = TcUtility.queryArg(response.output[0], uid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void askSubscriber(String subscription, StringHolder uid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(subscription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "askSubscriber", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uid.value = TcUtility.queryArg(response.output[0], uid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void askEventHandler(String subscription, StringHolder uid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(subscription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "askEventHandler", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uid.value = TcUtility.queryArg(response.output[0], uid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void askExecutionTime(String subscription, StringHolder date) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(subscription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "askExecutionTime", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    date.value = TcUtility.queryArgStringUnion(response.output[0], date.value);
  }

  public void askExpirationDate(String subscription, StringHolder date) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(subscription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "askExpirationDate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    date.value = TcUtility.queryArgStringUnion(response.output[0], date.value);
  }

  public void askHandlerParameters(String subscription, stringSeqValue_uHolder parameters) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(subscription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "askHandlerParameters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    parameters.value = TcUtility.queryArg(response.output[0], parameters.value);
  }

  public void askEventType(String subscription, StringHolder event, StringHolder evType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(subscription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "askEventType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    event.value = TcUtility.queryArg(response.output[0], event.value);
    evType.value = TcUtility.queryArg(response.output[1], evType.value);
  }

  public void askConditions(String subscription, stringSeqValue_uHolder attrNames, stringSeqValue_uHolder attrValues, stringSeqValue_uHolder mathOperators, stringSeqValue_uHolder logicOperators) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(subscription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "askConditions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attrNames.value = TcUtility.queryArg(response.output[0], attrNames.value);
    attrValues.value = TcUtility.queryArg(response.output[1], attrValues.value);
    mathOperators.value = TcUtility.queryArg(response.output[2], mathOperators.value);
    logicOperators.value = TcUtility.queryArg(response.output[3], logicOperators.value);
  }

  public void isSubscriptionValid(String subscription, BooleanHolder flag) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(subscription);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionManagerService", "isSubscriptionValid", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    flag.value = TcUtility.queryArg(response.output[0], flag.value);
  }

}
