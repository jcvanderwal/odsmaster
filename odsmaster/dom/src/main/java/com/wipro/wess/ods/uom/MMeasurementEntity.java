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

/**
 * MMeasurementEntity generated by hbm2java
 */
@javax.jdo.annotations.PersistenceCapable(schema = "gemsods", table = "m_measurement_entity", objectIdClass = MeasurementEntityPK.class, identityType = IdentityType.APPLICATION)
@Audited
@Bookmarkable
@ObjectType("MMeasurementEntity")
public class MMeasurementEntity implements java.io.Serializable, InstanceCallbacks {

    /**
     * 
     */
    private static final long serialVersionUID = -6352377481432303573L;

    private String measureEntityId;

    private int recordId;

    private String measureEntityDesc;

    private Date changeDate;

    private Long sourceId;
    
    private String configUser;

    /*
     * private Set<OmUomExtDataSourceExcept> omUomExtDataSourceExcepts = new HashSet<OmUomExtDataSourceExcept>(0);
     * private Set<OmUomOrgPolicy> omUomOrgPolicies = new HashSet<OmUomOrgPolicy>(0); private
     * Set<TtMsaProfileSummarizedDay> ttMsaProfileSummarizedDaies = new HashSet<TtMsaProfileSummarizedDay>(0); private
     * Set<MUomDefaults> MUomDefaultses = new HashSet<MUomDefaults>(0); private Set<OmUomSiteExcept> omUomSiteExcepts =
     * new HashSet<OmUomSiteExcept>(0); private Set<OmUomCountryExcept> omUomCountryExcepts = new
     * HashSet<OmUomCountryExcept>(0); private Set<OmUomCountryPolicy> omUomCountryPolicies = new
     * HashSet<OmUomCountryPolicy>(0); private Set<MOpmodeGroupConfig> MOpmodeGroupConfigs = new
     * HashSet<MOpmodeGroupConfig>(0);
     */
    public MMeasurementEntity() {
    }

    public MMeasurementEntity(String measureEntityId, int recordId, String measureEntityDesc, Date changeDate) {
        this.measureEntityId = measureEntityId;
        this.recordId = recordId;
        this.measureEntityDesc = measureEntityDesc;
        this.changeDate = changeDate;
    }

    public MMeasurementEntity(String measureEntityId, int recordId, String measureEntityDesc, Date changeDate,
            Long sourceId) {
        this.measureEntityId = measureEntityId;
        this.recordId = recordId;
        this.measureEntityDesc = measureEntityDesc;
        this.changeDate = changeDate;
        this.sourceId = sourceId;
    }

    @Column(name = "measure_entity_id", allowsNull = "false")
    @Persistent(primaryKey = "true")
    @Title
    public String getMeasureEntityId() {
        return this.measureEntityId;
    }

    public void setMeasureEntityId(String measureEntityId) {
        this.measureEntityId = measureEntityId;
    }

    @Column(name = "record_id", allowsNull = "false")
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Hidden(where = Where.OBJECT_FORMS)
    public int getRecordId() {
        return this.recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @Column(name = "measure_entity_desc", allowsNull = "false")
    public String getMeasureEntityDesc() {
        return this.measureEntityDesc;
    }

    public void setMeasureEntityDesc(String measureEntityDesc) {
        this.measureEntityDesc = measureEntityDesc;
    }

    @Column(name = "change_date", allowsNull = "false")
    @Hidden(where = Where.OBJECT_FORMS)
    public Date getChangeDate() {
        return this.changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
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
    
    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
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
    
    private UOMMeasurementService measurementService;

    public void injectUOMMeasurementService(UOMMeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @Bulk
    @CssClass("x-caution")
    public List<MMeasurementEntity> delete() {
        this.container.removeIfNotAlready(this);
        this.container.informUser("Deleted " + container.titleOf(this));
        return this.measurementService.listAllMeasurementEntities();

    }
}