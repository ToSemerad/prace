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

public class resourceListInfo_s {
  public String taskTemplate;

  public String taskTemplateType;

  public int noOfResources;

  public longSeqValue_u resourceActions;

  public String[] resourceMembers;

  public String[] resourceMemberTypes;

  public String[] resourceProfiles;

  public String[] resourceProfileTypes;

  public int revQuorum;

  public int ackQuorum;

  public int waitForUndecidedReviewers;


  public resourceListInfo_s() {
  }

  public resourceListInfo_s(String taskTemplate, String taskTemplateType, int noOfResources, longSeqValue_u resourceActions, String[] resourceMembers, String[] resourceMemberTypes, String[] resourceProfiles, String[] resourceProfileTypes, int revQuorum, int ackQuorum, int waitForUndecidedReviewers) {
    this.taskTemplate=taskTemplate;
    this.taskTemplateType=taskTemplateType;
    this.noOfResources=noOfResources;
    this.resourceActions=resourceActions;
    this.resourceMembers=resourceMembers;
    this.resourceMemberTypes=resourceMemberTypes;
    this.resourceProfiles=resourceProfiles;
    this.resourceProfileTypes=resourceProfileTypes;
    this.revQuorum=revQuorum;
    this.ackQuorum=ackQuorum;
    this.waitForUndecidedReviewers=waitForUndecidedReviewers;
  }

}
