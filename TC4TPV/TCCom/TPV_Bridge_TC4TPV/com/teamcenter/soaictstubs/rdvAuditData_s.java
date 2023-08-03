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

public class rdvAuditData_s {
  public String bom_line;

  public String bomLineType;

  public int n_occurrences;

  public String[] occurrences;

  public String[] occurrence_types;

  public longSeqValue_u occmatch_type;

  public longSeqValue_u occurrence_match_info;

  public String occ_nve_match_desc;

  public String occ_pnum_match_desc;

  public String occ_qty_match_desc;

  public int overall_match_info;

  public String nve_match_desc;

  public String pnum_match_desc;

  public String qty_match_desc;

  public String audit_line_summary;

  public String audit_score;


  public rdvAuditData_s() {
  }

  public rdvAuditData_s(String bom_line, String bomLineType, int n_occurrences, String[] occurrences, String[] occurrence_types, longSeqValue_u occmatch_type, longSeqValue_u occurrence_match_info, String occ_nve_match_desc, String occ_pnum_match_desc, String occ_qty_match_desc, int overall_match_info, String nve_match_desc, String pnum_match_desc, String qty_match_desc, String audit_line_summary, String audit_score) {
    this.bom_line=bom_line;
    this.bomLineType=bomLineType;
    this.n_occurrences=n_occurrences;
    this.occurrences=occurrences;
    this.occurrence_types=occurrence_types;
    this.occmatch_type=occmatch_type;
    this.occurrence_match_info=occurrence_match_info;
    this.occ_nve_match_desc=occ_nve_match_desc;
    this.occ_pnum_match_desc=occ_pnum_match_desc;
    this.occ_qty_match_desc=occ_qty_match_desc;
    this.overall_match_info=overall_match_info;
    this.nve_match_desc=nve_match_desc;
    this.pnum_match_desc=pnum_match_desc;
    this.qty_match_desc=qty_match_desc;
    this.audit_line_summary=audit_line_summary;
    this.audit_score=audit_score;
  }

}
