package com.wipro.wess.ods.msa;

// Generated Jan 7, 2014 12:15:31 PM by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.List;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bulk;
import org.apache.isis.applib.annotation.CssClass;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

import com.wipro.wess.ods.organisation.MOrganisation;

/**
 * OmMsaConsStFr generated by hbm2java
 */
@Named("MSAConsStFr")
@Bookmarkable
@Audited
@ObjectType("OmMsaConsStFr")
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "om_msa_cons_st_fr", objectIdClass = OmMsaConsStFrPK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(name = "fetch_OmMsaConsStFr_by_pk", language = "JDOQL", value = "SELECT "
                + " OmMsaConsStFr FROM com.wipro.wess.ods.msa.OmMsaConsStFr OmMsaConsStFr WHERE orgId == :orgId && typeCode == :typeCode && msaUid == :msaUid && "
                + " serviceType == :serviceType"),
        @javax.jdo.annotations.Query(name = "fetch_msaconsstfr_by_user", language = "JPQL", value = "SELECT msa FROM com.wipro.wess.ods.msa.OmMsaConsStFr msa "
                + " WHERE msa.msaUid IN ( "
                + " SELECT msasitemap.msaUid FROM com.wipro.wess.ods.site.OmMsaSiteMap msasitemap"
                + " JOIN msasitemap.omSite site WHERE EXISTS "
                + " (SELECT 1 FROM com.wipro.wess.pdm.security.OmPermission permission WHERE permission.site = site AND permission IN "
                + " (SELECT "
                + " OmRolesPermissions.permission FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
                + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName) ) ) ) ") })
public class OmMsaConsStFr implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = -6115714062262737175L;

    private MOrganisation orgId;

    private OmMsaConfig msaUid;

    private String typeCode;

    private String serviceType;

    private String meterFormula;

    private String businessLoad;

    private String insertedBy;

    private Date insertedTs;

    private String updatedBy;

    private Date updatedTimeTs;

    private Long sourceId;
    
    private String configUser;

    public OmMsaConsStFr() {
    }

    public OmMsaConsStFr(MOrganisation orgId, OmMsaConfig msaUid, String typeCode, String serviceType,
            String meterFormula, String businessLoad, String insertedBy, Date insertedTs, String updatedBy,
            Date updatedTimeTs) {
        this.orgId = orgId;
        this.msaUid = msaUid;
        this.typeCode = typeCode;
        this.serviceType = serviceType;
        this.meterFormula = meterFormula;
        this.businessLoad = businessLoad;
        this.insertedBy = insertedBy;
        this.insertedTs = insertedTs;
        this.updatedBy = updatedBy;
        this.updatedTimeTs = updatedTimeTs;
    }

    @Column(allowsNull = "false", name = "org_id")
    @Title
    @Persistent(primaryKey = "true")
    public MOrganisation getOrgId() {
        return orgId;
    }

    public void setOrgId(MOrganisation orgId) {
        this.orgId = orgId;
    }

    @Column(allowsNull = "false", name = "msa_uid")
    @Title
    @Persistent(primaryKey = "true")
    public OmMsaConfig getMsaUid() {
        return msaUid;
    }

    public void setMsaUid(OmMsaConfig msaUid) {
        this.msaUid = msaUid;
    }

    @Column(allowsNull = "false", name = "type_code")
    @Title
    @Persistent(primaryKey = "true")
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Column(allowsNull = "false", name = "service_type")
    @Title
    @Persistent(primaryKey = "true")
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Column(allowsNull = "false", name = "meter_formula")
    public String getMeterFormula() {
        return this.meterFormula;
    }

    public void setMeterFormula(String meterFormula) {
        this.meterFormula = meterFormula;
    }

    @Column(allowsNull = "false", name = "business_load")
    @Hidden(where = Where.ALL_TABLES)
    public String getBusinessLoad() {
        return this.businessLoad;
    }

    public void setBusinessLoad(String businessLoad) {
        this.businessLoad = businessLoad;
    }

    @Column(allowsNull = "false", name = "inserted_by")
    @Hidden(where = Where.ANYWHERE)
    public String getInsertedBy() {
        return this.insertedBy;
    }

    public void setInsertedBy(String insertedBy) {
        this.insertedBy = insertedBy;
    }

    @Column(allowsNull = "false", name = "inserted_ts")
    @Hidden(where = Where.ANYWHERE)
    public Date getInsertedTs() {
        return this.insertedTs;
    }

    public void setInsertedTs(Date insertedTs) {
        this.insertedTs = insertedTs;
    }

    @Column(allowsNull = "false", name = "updated_by")
    @Hidden(where = Where.OBJECT_FORMS)
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Column(allowsNull = "false", name = "updated_time_ts")
    @Hidden(where = Where.OBJECT_FORMS)
    public Date getUpdatedTimeTs() {
        return this.updatedTimeTs;
    }

    public void setUpdatedTimeTs(Date updatedTimeTs) {
        this.updatedTimeTs = updatedTimeTs;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((msaUid == null) ? 0 : msaUid.hashCode());
        result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
        result = prime * result + ((serviceType == null) ? 0 : serviceType.hashCode());
        result = prime * result + ((typeCode == null) ? 0 : typeCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OmMsaConsStFr other = (OmMsaConsStFr) obj;
        if (msaUid == null) {
            if (other.msaUid != null)
                return false;
        } else if (!msaUid.equals(other.msaUid))
            return false;
        if (orgId == null) {
            if (other.orgId != null)
                return false;
        } else if (!orgId.equals(other.orgId))
            return false;
        if (serviceType == null) {
            if (other.serviceType != null)
                return false;
        } else if (!serviceType.equals(other.serviceType))
            return false;
        if (typeCode == null) {
            if (other.typeCode != null)
                return false;
        } else if (!typeCode.equals(other.typeCode))
            return false;
        return true;
    }

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    public void jdoPostLoad() {
    }

    public void jdoPreClear() {
    }

    public void jdoPreStore() {
        this.setUpdatedBy(this.container.getUser().getName());
        this.setUpdatedTimeTs(new Date());
        this.setConfigUser(this.container.getUser().getName());
    }

    public void jdoPreDelete() {
    }
    
    private OmMsaConfigService msaConfigService;

    public void injectOmMsaConfigService(OmMsaConfigService msaConfigService) {
        this.msaConfigService = msaConfigService;
    }

    @Bulk
    @CssClass("x-caution")
    public List<OmMsaConsStFr> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.msaConfigService.listAllMsaConsStFr();

    }

}
