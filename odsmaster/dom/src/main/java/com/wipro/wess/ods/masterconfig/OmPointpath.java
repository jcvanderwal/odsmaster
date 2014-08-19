package com.wipro.wess.ods.masterconfig;

// Generated Jan 7, 2014 12:15:31 PM by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.List;

import javax.jdo.InstanceCallbacks;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Columns;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bulk;
import org.apache.isis.applib.annotation.CssClass;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Mandatory;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

import com.wipro.wess.ods.asset.OmAsset;
import com.wipro.wess.ods.asset.OmAssetService;
import com.wipro.wess.ods.reporting.OmLocationHierarchy;
import com.wipro.wess.ods.reporting.OmLocationHierarchyService;

/**
 * OmPointpath generated by hbm2java
 */
@Named("Pointpath")
@Bookmarkable
@Audited
@ObjectType("OmPointpath")
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "om_pointpath", objectIdClass = OmPointpathPK.class, identityType = IdentityType.APPLICATION)
@javax.jdo.annotations.Queries({ @javax.jdo.annotations.Query(name = "fetch_ompointpaths_by_user", language = "JPQL", value = "SELECT pointpath FROM com.wipro.wess.ods.masterconfig.OmPointpath pointpath "
        + " JOIN pointpath.omLocationHierarchy loc_hcy "
        + " JOIN loc_hcy.omSite site WHERE EXISTS "
        + " (SELECT 1 FROM com.wipro.wess.pdm.security.OmPermission permission WHERE permission.site = site AND permission IN "
        + " (SELECT "
        + " OmRolesPermissions.permission FROM com.wipro.wess.pdm.security.OmRolesPermissions OmRolesPermissions "
        + " WHERE role IN ( SELECT OmUsersRoles.role FROM com.wipro.wess.pdm.security.OmUsersRoles OmUsersRoles WHERE OmUsersRoles.user.userName = :userName) ) ) ") })
public class OmPointpath implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = -4010904704349348322L;

    private String pointpath;

    // private MAssetclass MAssetclass;

    private MPointlist MPointlist;

    private OmLocationHierarchy omLocationHierarchy;

    private int rowseqId;

    private OmAsset assetUid;

    private String fieldPointpath;

    private String sourceSystemtag;

    private String changeby;

    private Date changedate;

    private Long sourceId;

    private Long pointpathId;

    private String configUser;

    public OmPointpath() {
    }

    public OmPointpath(String pointpath, MPointlist MPointlist, OmLocationHierarchy omLocationHierarchy, int rowseqId,
            OmAsset assetUid, String fieldPointpath) {
        this.pointpath = pointpath;
        this.MPointlist = MPointlist;
        this.omLocationHierarchy = omLocationHierarchy;
        this.rowseqId = rowseqId;
        this.assetUid = assetUid;
        this.fieldPointpath = fieldPointpath;
    }

    public OmPointpath(String pointpath, MPointlist MPointlist, OmLocationHierarchy omLocationHierarchy, int rowseqId,
            OmAsset assetUid, String fieldPointpath, String sourceSystemtag, String changeby, Date changedate,
            Long sourceId, Long pointpathId) {
        this.pointpath = pointpath;
        this.MPointlist = MPointlist;
        this.omLocationHierarchy = omLocationHierarchy;
        this.rowseqId = rowseqId;
        this.assetUid = assetUid;
        this.fieldPointpath = fieldPointpath;
        this.sourceSystemtag = sourceSystemtag;
        this.changeby = changeby;
        this.changedate = changedate;
        this.sourceId = sourceId;
        this.pointpathId = pointpathId;
    }

    @Column(allowsNull = "false", name = "pointpath")
    @Persistent(primaryKey = "true")
    @Mandatory
    @Title
    public String getPointpath() {
        return this.pointpath;
    }

    public void setPointpath(String pointpath) {
        this.pointpath = pointpath;
    }

    @Columns(value = { @Column(allowsNull = "false", name = "assetclass_code"),
            @Column(allowsNull = "false", name = "point") })
    @Mandatory
    public MPointlist getMPointlist() {
        return this.MPointlist;
    }

    public void setMPointlist(MPointlist MPointlist) {
        this.MPointlist = MPointlist;
    }

    @Columns(value = { @Column(allowsNull = "false", name = "location_uid"),
            @Column(allowsNull = "false", name = "org_id") })
    @Mandatory
    public OmLocationHierarchy getOmLocationHierarchy() {
        return this.omLocationHierarchy;
    }

    public void setOmLocationHierarchy(OmLocationHierarchy omLocationHierarchy) {
        this.omLocationHierarchy = omLocationHierarchy;
    }

    @Column(allowsNull = "false", name = "rowseq_id")
    @Hidden(where = Where.OBJECT_FORMS)
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Disabled
    public int getRowseqId() {
        return this.rowseqId;
    }

    public void setRowseqId(int rowseqId) {
        this.rowseqId = rowseqId;
    }

    @Columns(value = { @Column(allowsNull = "false", name = "asset_uid"), @Column(name = "asset_org_id") })
    @Mandatory
    public OmAsset getAssetUid() {
        return this.assetUid;
    }

    public void setAssetUid(OmAsset assetUid) {
        this.assetUid = assetUid;
    }

    @Column(allowsNull = "false", name = "field_pointpath")
    @Hidden(where = Where.ALL_TABLES)
    @Disabled
    public String getFieldPointpath() {
        return this.fieldPointpath;
    }

    public void setFieldPointpath(String fieldPointpath) {
        this.fieldPointpath = fieldPointpath;
    }

    @Column(name = "source_systemtag")
    @Hidden(where = Where.ALL_TABLES)
    public String getSourceSystemtag() {
        return this.sourceSystemtag;
    }

    public void setSourceSystemtag(String sourceSystemtag) {
        this.sourceSystemtag = sourceSystemtag;
    }

    @Column(allowsNull = "false", name = "changeby")
    @Hidden(where = Where.OBJECT_FORMS)
    public String getChangeby() {
        return this.changeby;
    }

    public void setChangeby(String changeby) {
        this.changeby = changeby;
    }

    @Column(allowsNull = "false", name = "changedate")
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

    @Column(name = "pointpath_id")
    @Hidden(where = Where.ALL_TABLES)
    @Unique
    public Long getPointpathId() {
        return this.pointpathId;
    }

    public void setPointpathId(Long pointpathId) {
        this.pointpathId = pointpathId;
    }

    @Column(name = "config_user")
    @Hidden(where = Where.EVERYWHERE)
    public String getConfigUser() {
        return configUser;
    }

    public void setConfigUser(String configUser) {
        this.configUser = configUser;
    }
    
    private OmLocationHierarchyService hierarchyService;

    public void injectOmLocationHierarchies(OmLocationHierarchyService hierarchyService) {
        this.hierarchyService = hierarchyService;
    }

    public List<OmLocationHierarchy> choicesOmLocationHierarchy() {
        return this.hierarchyService.listAll();
    }

    private OmAssetService assetService;

    public void injectOmAssetService(OmAssetService assetService) {
        this.assetService = assetService;
    }

    public List<OmAsset> choicesAssetUid() {
        return this.assetService.listAllAssets();
    }

    private MasterConfigurationService masterConfigurationService;

    public void injectMasterConfigurationService(MasterConfigurationService masterConfigurationService) {
        this.masterConfigurationService = masterConfigurationService;
    }

    public List<MPointlist> choicesMPointlist() {
        return this.masterConfigurationService.listAllPointList();
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
        this.setChangeby(this.container.getUser().getName());
        this.setChangedate(new Date());
        this.setConfigUser(this.container.getUser().getName());
    }

    public void jdoPreDelete() {
    }


    @Bulk
    @CssClass("x-caution")
    public List<OmPointpath> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.masterConfigurationService.listAllPointpaths();

    }
}