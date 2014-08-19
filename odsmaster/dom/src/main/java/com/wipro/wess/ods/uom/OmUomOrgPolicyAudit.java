package com.wipro.wess.ods.uom;

// Generated Jan 7, 2014 12:15:31 PM by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.List;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bulk;
import org.apache.isis.applib.annotation.CssClass;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

import com.wipro.wess.ods.munit.MUnit;
import com.wipro.wess.ods.munit.MUnitFamily;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.organisation.OrganisationService;

/**
 * OmUomOrgPolicyAudit generated by hbm2java
 */
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "om_uom_org_policy_audit", objectIdClass = UomOrgPolicyAuditPK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({ @javax.jdo.annotations.Query(name = "fetch_uomorgpolicyaudit_by_user", language = "JPQL", value = "SELECT orgPolicyAudit FROM com.wipro.wess.ods.uom.OmUomOrgPolicyAudit orgPolicyAudit "
        + " JOIN orgPolicyAudit.orgId organization WHERE EXISTS "
        + " (SELECT 1 FROM com.wipro.wess.pdm.security.OmPermission permission WHERE permission.site.orgId = organization AND permission IN "
        + " (SELECT "
        + " OmRolesPermissions.permission FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
        + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName) ) ) ") })
@Audited
@Bookmarkable
@ObjectType("OmUomOrgPolicyAudit")
public class OmUomOrgPolicyAudit implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = 5106244865532676779L;

    private int recordId;

    private MOrganisation orgId;

    private MMeasurementEntity measureEntityId;

    private MMeasurement measureId;

    private MUnitFamily unitFamilyId;

    private MUnit unitId;

    private Date changeDate;

    private String action;

    private Long sourceId;

    private String configUser;

    public OmUomOrgPolicyAudit() {
    }

    public OmUomOrgPolicyAudit(int recordId, MOrganisation orgId, MMeasurementEntity measureEntityId,
            MMeasurement measureId, MUnitFamily unitFamilyId, MUnit unitId, Date changeDate) {
        this.recordId = recordId;
        this.orgId = orgId;
        this.measureEntityId = measureEntityId;
        this.measureId = measureId;
        this.unitFamilyId = unitFamilyId;
        this.unitId = unitId;
        this.changeDate = changeDate;
    }

    public OmUomOrgPolicyAudit(int recordId, MOrganisation orgId, MMeasurementEntity measureEntityId,
            MMeasurement measureId, MUnitFamily unitFamilyId, MUnit unitId, Date changeDate, String action,
            Long sourceId) {
        this.recordId = recordId;
        this.orgId = orgId;
        this.measureEntityId = measureEntityId;
        this.measureId = measureId;
        this.unitFamilyId = unitFamilyId;
        this.unitId = unitId;
        this.changeDate = changeDate;
        this.action = action;
        this.sourceId = sourceId;
    }

    @Column(name = "record_id", allowsNull = "false")
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Hidden(where = Where.OBJECT_FORMS)
    public int getRecordId() {
        return this.recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @Column(name = "org_id", allowsNull = "false")
    @Title
    public MOrganisation getOrgId() {
        return orgId;
    }

    public void setOrgId(MOrganisation orgId) {
        this.orgId = orgId;
    }

    @Column(name = "measure_entity_id", allowsNull = "false")
    @Title
    public MMeasurementEntity getMeasureEntityId() {
        return measureEntityId;
    }

    public void setMeasureEntityId(MMeasurementEntity measureEntityId) {
        this.measureEntityId = measureEntityId;
    }

    @Column(name = "measure_id", allowsNull = "false")
    @Title
    public MMeasurement getMeasureId() {
        return measureId;
    }

    public void setMeasureId(MMeasurement measureId) {
        this.measureId = measureId;
    }

    @Column(name = "unit_family_id", allowsNull = "false")
    @Hidden(where = Where.ALL_TABLES)
    public MUnitFamily getUnitFamilyId() {
        return unitFamilyId;
    }

    public void setUnitFamilyId(MUnitFamily unitFamilyId) {
        this.unitFamilyId = unitFamilyId;
    }

    @Column(name = "unit_id", allowsNull = "false")
    @Hidden(where = Where.ALL_TABLES)
    public MUnit getUnitId() {
        return unitId;
    }

    public void setUnitId(MUnit unitId) {
        this.unitId = unitId;
    }

    @Column(name = "change_date", allowsNull = "false")
    @Hidden(where = Where.OBJECT_FORMS)
    public Date getChangeDate() {
        return this.changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    @Column(name = "action")
    @Hidden(where = Where.ALL_TABLES)
    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Column(name = "source_id")
    @Hidden(where = Where.ALL_TABLES)
    public Long getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Column(name = "config_user")
    @Hidden(where = Where.EVERYWHERE)
    public String getConfigUser() {
        return configUser;
    }

    public void setConfigUser(String configUser) {
        this.configUser = configUser;
    }

    private OrganisationService orgService;

    public void injectOrganisationService(OrganisationService orgService) {
        this.orgService = orgService;
    }

    public List<MOrganisation> choicesOrgId() {
        return this.orgService.listAllOrganisations();
    }

    private UOMMeasurementService uomMeasurementService;

    public void injectUOMMeasurementService(UOMMeasurementService uomMeasurementService) {
        this.uomMeasurementService = uomMeasurementService;
    }

    public List<MMeasurementEntity> choicesMeasureEntityId() {
        return this.uomMeasurementService.listAllMeasurementEntities();
    }

    public List<MMeasurement> choicesMeasureId() {
        return this.uomMeasurementService.listAllMeasurements();
    }

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    public List<MUnitFamily> choicesUnitFamilyId() {
        return this.container.allInstances(MUnitFamily.class);
    }

    public List<MUnit> choicesUnitId() {
        return this.container.allInstances(MUnit.class);
    }

    public void jdoPostLoad() {
    }

    public void jdoPreClear() {
    }

    public void jdoPreStore() {
        this.setChangeDate(new Date());
        this.setConfigUser(this.container.getUser().getName());
    }

    public void jdoPreDelete() {
    }

    private UOMService uomService;

    public void injectUOMService(UOMService uomService) {
        this.uomService = uomService;
    }

    @Bulk
    @CssClass("x-caution")
    public List<OmUomOrgPolicyAudit> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.uomService.listAllUOMOrgPolicyAudit();

    }
}
