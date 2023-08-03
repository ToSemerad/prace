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

public class ICCTCodeGenAutotestService {
  ICTService m_service;

  Connection m_connection;


  public ICCTCodeGenAutotestService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void testString(String inArg, StringHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testString", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testUid(String inArg, StringHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testUid", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testStringValue_t(String inArg, StringHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testStringValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArgStringUnion(response.output[0], outArg.value);
  }

  public void testTagValue_t(int inArg, IntHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testTagValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testUidValue_t(String inArg, StringHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testUidValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArgStringUnion(response.output[0], outArg.value);
  }

  public void testShortValue_t(short inArg, ShortHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testShortValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testBooleanValue_t(boolean inArg, BooleanHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testBooleanValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testFloatValue_t(float inArg, FloatHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testFloatValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testDoubleValue_t(double inArg, DoubleHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testDoubleValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testLongValue_t(int inArg, IntHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testLongValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testStringSeq_t(String[] inArg, stringSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testStringSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testStringSeqValue_t(stringSeqValue_u inArg, stringSeqValue_uHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testStringSeqValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testStringValueSeq_t(String[] inArg, stringValueSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testStringValueSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArgStringUnion(response.output[0], outArg.value);
  }

  public void testStringSeqSeq_t(String[][] inArg, stringSeqSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testStringSeqSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testLongSeq_t(int[] inArg, longSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testLongSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testLongSeqValue_t(longSeqValue_u inArg, longSeqValue_uHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testLongSeqValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testTagSeq_t(int[] inArg, tagSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testTagSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testTagSeqValue_t(tagSeqValue_u inArg, tagSeqValue_uHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testTagSeqValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testTagSeqSeq_t(int[][] inArg, tagSeqSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testTagSeqSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testUidSeq_t(String[] inArg, uidSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testUidSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testUidSeqValue_t(uidSeqValue_u inArg, uidSeqValue_uHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testUidSeqValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testUidValueSeq_t(String[] inArg, uidValueSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testUidValueSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArgStringUnion(response.output[0], outArg.value);
  }

  public void testUidSeqSeq_t(String[][] inArg, uidSeqSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testUidSeqSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testBooleanSeq_t(boolean[] inArg, booleanSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testBooleanSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testBooleanSeqValue_t(booleanSeqValue_u inArg, booleanSeqValue_uHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testBooleanSeqValue_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testBooleanValueSeq_t(boolean[] inArg, booleanValueSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testBooleanValueSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testBooleanSeqSeq_t(boolean[][] inArg, booleanSeqSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testBooleanSeqSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testDoubleSeq_t(double[] inArg, doubleSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testDoubleSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testDoubleValueSeq_t(double[] inArg, doubleValueSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testDoubleValueSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testFloatValueSeq_t(float[] inArg, floatValueSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testFloatValueSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testPropertyDescriptor_t(propertyDescriptor_s inArg, propertyDescriptor_sHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testPropertyDescriptor_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testPropertyDescriptorSeq_t(propertyDescriptor_s[] inArg, propertyDescriptorSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testPropertyDescriptorSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testPropertyData_t(propertyData_u inArg, propertyData_uHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testPropertyData_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testPropertyDataSeq_t(propertyData_u[] inArg, propertyDataSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testPropertyDataSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testPropertyDataSeqSeq_t(propertyData_u[][] inArg, propertyDataSeqSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testPropertyDataSeqSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testLovData_t(lovData_u inArg, lovData_uHolder outArrg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testLovData_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArrg.value = TcUtility.queryArg(response.output[0], outArrg.value);
  }

  public void testLovDataSeq_t(lovData_u[] inArg, lovDataSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testLovDataSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testAclInfo_t(aclInfo_s inArg, aclInfo_sHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testAclInfo_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testAclInfoSeq_t(aclInfo_s[] inArg, aclInfoSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testAclInfoSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testIcsPropSeq_t(ICSProperty_s[] inArg, icspropSeqHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testIcsPropSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testCannedMethodInfoSeq_t(cannedMethodInfo_s[] inArg, cannedMethodInfoSeq_tHolder outArg) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(inArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testCannedMethodInfoSeq_t", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    outArg.value = TcUtility.queryArg(response.output[0], outArg.value);
  }

  public void testExceptionHandling(int errorCodeCount, int[] errorSeverities, int[] errorCodes, String[] errorStrings) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(errorCodeCount);
    args_[1] = TcUtility.createArg(errorSeverities);
    args_[2] = TcUtility.createArg(errorCodes);
    args_[3] = TcUtility.createArg(errorStrings);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCodeGenAutotestService", "testExceptionHandling", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
