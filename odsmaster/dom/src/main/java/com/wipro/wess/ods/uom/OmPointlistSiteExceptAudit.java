package com.wipro.wess.ods.uom;

// Generated Jan 7, 2014 12:15:31 PM by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.List;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Columns;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bulk;
import org.apache.isis.applib.annotation.CssClass;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Mandatory;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

import com.wipro.wess.ods.masterconfig.MPointlist;
import com.wipro.wess.ods.masterconfig.MasterConfigurationService;
import com.wipro.wess.ods.munit.MUnit;
import com.wipro.wess.ods.munit.MUnitFamily;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.organisation.OrganisationService;

/**
 * OmPointlistSiteExceptAudit generated by hbm2java
 */
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "om_pointlist_site_except_audit", objectIdClass = OmPointlistSiteExceptAuditPK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({ @javax.jdo.annotations.Query(name = "fetch_pointlistsiteexceptaudit_by_user", language = "JPQL", value = "SELECT pointlistSiteExceptAudit FROM com.wipro.wess.ods.uom.OmPointlistSiteExceptAudit pointlistSiteExceptAudit "
        + " JOIN pointlistSiteExceptAudit.orgId organization WHERE EXISTS "
        + " (SELECT 1 FROM com.wipro.wess.pdm.security.OmPermission permission WHERE permission.site.orgId = organization AND permission IN "
        + " (SELECT "
        + " OmRolesPermissions.permission FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
        + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName) ) ) ") })
@Audited
@Bookmarkable
@ObjectType("OmPointlistSiteExceptAudit")
public class OmPointlistSiteExceptAudit implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = 7137464521482594307L;

    private int rowseqId;

    private MOrganisation orgId;

    private String locationUid;

    private MPointlist pointList;

    private MUnit unitId;

    private MUnitFamily unitFamilyId;

    private String state0;

    private String state1;

    private String changeby;

    private Date changedate;

    private Long sourceId;

    private String action;

    private String configUser;

    public OmPointlistSiteExceptAudit() {
    }

    public OmPointlistSiteExceptAudit(int rowseqId, MOrganisation orgId, String locationUid, MPointlist pointList,
            Date changedate) {
        this.rowseqId = rowseqId;
        this.orgId = orgId;
        this.locationUid = locationUid;
        this.pointList = pointList;
        this.changedate = changedate;
    }

    public OmPointlistSiteExceptAudit(int rowseqId, MOrganisation orgId, String locationUid, MPointlist pointList,
            MUnit unitId, MUnitFamily unitFamilyId, String state0, String state1, String changeby, Date changedate,
            Long sourceId, String action) {
        this.rowseqId = rowseqId;
        this.orgId = orgId;
        this.locationUid = locationUid;
        this.pointList = pointList;
        this.unitId = unitId;
        this.unitFamilyId = unitFamilyId;
        this.state0 = state0;
        this.state1 = state1;
        this.changeby = changeby;
        this.changedate = changedate;
        this.sourceId = sourceId;
        this.action = action;
    }

    @Column(name = "rowseq_id", allowsNull = "false")
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Hidden(where = Where.OBJECT_FORMS)
    public int getRowseqId() {
        return this.rowseqId;
    }

    public void setRowseqId(int rowseqId) {
        this.rowseqId = rowseqId;
    }

    @Column(name = "org_id", allowsNull = "false")
    @Title
    public MOrganisation getOrgId() {
        return orgId;
    }

    public void setOrgId(MOrganisation orgId) {
        this.orgId = orgId;
    }

    @Columns(value = { @Column(name = "assetclass_code", allowsNull = "false"),
            @Column(name = "point", allowsNull = "false") })
    @Mandatory
    @Title
    public MPointlist getPointList() {
        return pointList;
    }

    public void setPointList(MPointlist pointList) {
        this.pointList = pointList;
    }

    @Column(name = "location_uid", allowsNull = "false")
    @Title
    public String getLocationUid() {
        return locationUid;
    }

    public void setLocationUid(String locationUid) {
        this.locationUid = locationUid;
    }

    @Column(name = "unit_id")
    @Hidden(where = Where.ALL_TABLES)
    public MUnit getUnitId() {
        return this.unitId;
    }

    public void setUnitId(MUnit unitId) {
        this.unitId = unitId;
    }

    @Column(name = "unit_family_id")
    @Hidden(where = Where.ALL_TABLES)
    public MUnitFamily getUnitFamilyId() {
        return this.unitFamilyId;
    }

    public void setUnitFamilyId(MUnitFamily unitFamilyId) {
        this.unitFamilyId = unitFamilyId;
    }

    @Column(name = "state_0")
    @Hidden(where = Where.ALL_TABLES)
    public String getState0() {
        return this.state0;
    }

    public void setState0(String state0) {
        this.state0 = state0;
    }

    @Column(name = "state_1")
    @Hidden(where = Where.ALL_TABLES)
    public String getState1() {
        return this.state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    @Column(name = "changeby", allowsNull = "false")
    @Hidden(where = Where.OBJECT_FORMS)
    public String getChangeby() {
        return this.changeby;
    }

    public void setChangeby(String changeby) {
        this.changeby = changeby;
    }

    @Column(name = "changedate", allowsNull = "false")
    @Hidden(where = Where.OBJECT_FORMS)
    public Date getChangedate() {
        return this.changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    @Column(name = "source_id")
    @Hidden(where = Where.ALL_TABLES)
    public Long getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Column(name = "action")
    @Hidden(where = Where.ALL_TABLES)
    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
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

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    private MasterConfigurationService masterConfigurationService;

    public void injectMasterConfigurationService(MasterConfigurationService masterConfigurationService) {
        this.masterConfigurationService = masterConfigurationService;
    }

    public List<MPointlist> choicesPointList() {
        return this.masterConfigurationService.listAllPointList();
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
        this.setChangeby(this.container.getUser().getName());
        this.setChangedate(new Date());
        this.setConfigUser(this.container.getUser().getName());
    }

    public void jdoPreDelete() {
    }

    private UOMPointListService pointListService;

    public void injectUOMPointListService(UOMPointListService pointListService) {
        this.pointListService = pointListService;
    }

    @Bulk
    @CssClass("x-caution")
    public List<OmPointlistSiteExceptAudit> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.pointListService.listAllUOMPointlistSiteExceptAudit();

    }

}
