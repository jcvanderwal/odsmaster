package com.wipro.wess.ods.sca;

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
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

import com.wipro.wess.ods.asset.OmAsset;

/**
 * OmScaMonitorassetMap generated by hbm2java
 */
@Named("ScaMonitorassetMap")
@Bookmarkable
@Audited
@ObjectType("OmScaMonitorassetMap")
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "om_sca_monitorasset_map", objectIdClass = OmScaMonitorassetMapPK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({
        @javax.jdo.annotations.Query(name = "fetch_OmScaMonitorassetMap_by_sca_asset_map", language = "JDOQL", value = "SELECT "
                + " OmScaMonitorassetMap FROM com.wipro.wess.ods.sca.OmScaMonitorassetMap OmScaMonitorassetMap WHERE scaUid == :scaUid && monitorAssetUid == :monitorAssetUid "),
        @javax.jdo.annotations.Query(name = "fetch_scamonitorassets_by_user", language = "JPQL", value = "SELECT scaasset FROM com.wipro.wess.ods.sca.OmScaMonitorassetMap scaasset "
                + " JOIN scaasset.scaUid sca "
                + " JOIN sca.omSite site WHERE EXISTS "
                + " (SELECT 1 FROM com.wipro.wess.pdm.security.OmPermission permission WHERE permission.site = site AND permission IN "
                + " (SELECT "
                + " OmRolesPermissions.permission FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
                + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName) ) ) ") })
public class OmScaMonitorassetMap implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = -8019048835375161330L;

    private String changeBy;

    private Date changeDt;

    private int rowseqId;

    private Long sourceId;

    // private MOrganisation orgId;

    private OmScaConfig scaUid;

    private OmAsset monitorAssetUid;

    private String configUser;

    private OmScaConfigService scaConfigService;

    public void injectOmScaConfigService(OmScaConfigService scaConfigService) {
        this.scaConfigService = scaConfigService;
    }

    public List<OmScaConfig> choicesScaUid() {
        return this.scaConfigService.listAllScaConfigs();
    }

    public List<OmAsset> choicesMonitorAssetUid() {
        return this.scaConfigService.listAllMonitoringAssets();
    }

    public OmScaMonitorassetMap() {
    }

    public OmScaMonitorassetMap(String changeBy, Date changeDt, int rowseqId) {
        this.changeBy = changeBy;
        this.changeDt = changeDt;
        this.rowseqId = rowseqId;
    }

    public OmScaMonitorassetMap(String changeBy, Date changeDt, int rowseqId, Long sourceId/* , MOrganisation orgId */) {
        this.changeBy = changeBy;
        this.changeDt = changeDt;
        this.rowseqId = rowseqId;
        this.sourceId = sourceId;
        // this.orgId = orgId;
    }

    @Column(allowsNull = "false", name = "sca_uid")
    @Title
    @Persistent(primaryKey = "true")
    public OmScaConfig getScaUid() {
        return scaUid;
    }

    public void setScaUid(OmScaConfig scaUid) {
        this.scaUid = scaUid;
    }

    @Columns(value = { @Column(allowsNull = "false", name = "monitor_asset_uid"), @Column(name = "org_id") })
    @Title
    @Persistent(primaryKey = "true")
    @Mandatory
    public OmAsset getMonitorAssetUid() {
        return monitorAssetUid;
    }

    /*
     * @Column(allowsNull = "false", name = "org_id")
     * @Title
     * @Hidden(where = Where.ANYWHERE) public MOrganisation getOrgId() { return this.orgId; } public void
     * setOrgId(MOrganisation orgId) { this.orgId = orgId; }
     */

    public void setMonitorAssetUid(OmAsset monitorAssetUid) {
        this.monitorAssetUid = monitorAssetUid;
    }

    @Column(allowsNull = "false", name = "change_by")
    @Hidden(where = Where.OBJECT_FORMS)
    public String getChangeBy() {
        return this.changeBy;
    }

    public void setChangeBy(String changeBy) {
        this.changeBy = changeBy;
    }

    @Column(allowsNull = "false", name = "change_dt")
    @Hidden(where = Where.OBJECT_FORMS)
    public Date getChangeDt() {
        return this.changeDt;
    }

    public void setChangeDt(Date changeDt) {
        this.changeDt = changeDt;
    }

    @Column(allowsNull = "false", name = "rowseq_id")
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Hidden(where = Where.ANYWHERE)
    public int getRowseqId() {
        return this.rowseqId;
    }

    public void setRowseqId(int rowseqId) {
        this.rowseqId = rowseqId;
    }

    @Column(name = "source_id")
    @Hidden(where = Where.ALL_TABLES)
    @Optional
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

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

    public void jdoPostLoad() {
    }

    public void jdoPreClear() {
    }

    public void jdoPreStore() {
        this.setChangeBy(this.container.getUser().getName());
        this.setChangeDt(new Date());
        this.setConfigUser(this.container.getUser().getName());
    }

    public void jdoPreDelete() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((monitorAssetUid == null) ? 0 : monitorAssetUid.hashCode());
        result = prime * result + ((scaUid == null) ? 0 : scaUid.hashCode());
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
        OmScaMonitorassetMap other = (OmScaMonitorassetMap) obj;
        if (monitorAssetUid == null) {
            if (other.monitorAssetUid != null)
                return false;
        } else if (!monitorAssetUid.equals(other.monitorAssetUid))
            return false;
        if (scaUid == null) {
            if (other.scaUid != null)
                return false;
        } else if (!scaUid.equals(other.scaUid))
            return false;
        return true;
    }

    @Bulk
    @CssClass("x-caution")
    public List<OmScaMonitorassetMap> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.scaConfigService.listAllScaMoniterAssetMap();

    }

}
