package com.teamcenter.soaictstubs;

/** 
 * ***********************************************************
 * *                                                         *
 * *      THE FOLLOWING SOURCE FILE HAS BEEN AUTOMATICALLY   *
 * *      GENERATED.  ANY HAND CRAFTED CHANGES WILL BE LOST! *
 * *                                                         *
 * ***********************************************************
 * 
 */

public class pieTransferModeInfo_s {
  public String name;

  public String desc;

  public String contextStr;

  public String closureRuleStr;

  public String filterRuleStr;

  public String propertySetStr;

  public int direction;

  public boolean incremental;

  public String tmObj;

  public uidSeqValue_u configObjs;

  public uidSeqValue_u xsltFileObjs;

  public uidSeqValue_u actionList;


  public pieTransferModeInfo_s() {
  }

  public pieTransferModeInfo_s(String name, String desc, String contextStr, String closureRuleStr, String filterRuleStr, String propertySetStr, int direction, boolean incremental, String tmObj, uidSeqValue_u configObjs, uidSeqValue_u xsltFileObjs, uidSeqValue_u actionList) {
    this.name=name;
    this.desc=desc;
    this.contextStr=contextStr;
    this.closureRuleStr=closureRuleStr;
    this.filterRuleStr=filterRuleStr;
    this.propertySetStr=propertySetStr;
    this.direction=direction;
    this.incremental=incremental;
    this.tmObj=tmObj;
    this.configObjs=configObjs;
    this.xsltFileObjs=xsltFileObjs;
    this.actionList=actionList;
  }

}
