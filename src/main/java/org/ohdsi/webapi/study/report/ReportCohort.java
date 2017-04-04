/**
 * This file was generated by the JPA Modeler
 */ 

package org.ohdsi.webapi.study.report;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.ohdsi.webapi.study.StudyCohort;

/**
 * @author Chris Knoll <cknoll@ohdsi.org>
 */

@Embeddable
public class ReportCohort { 

    @Column(name="IS_ACTIVE")
    @Basic
    private boolean isActive;

    @OneToOne(targetEntity = StudyCohort.class)
    @JoinColumn(name="COHORT_ID",referencedColumnName="ID")
    private StudyCohort cohort;


    public boolean isIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public StudyCohort getCohort() {
        return this.cohort;
    }

    public void setCohort(StudyCohort cohort) {
        this.cohort = cohort;
    }


}