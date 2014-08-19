package com.wipro.wess.ods.msa;

import java.nio.charset.Charset;
import java.util.StringTokenizer;

import com.google.common.io.BaseEncoding;
import com.wipro.wess.ods.organisation.OrganisationPK;

// Generated Jan 7, 2014 12:15:31 PM by Hibernate Tools 3.2.2.GA

/**
 * OmMsaConsStFrId generated by hbm2java
 */
public class OmMsaConsStFrPK implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1471459076328924580L;

    /**
     * 
     */

    public OrganisationPK orgId;

    public OmMsaConfigPK msaUid;

    public String typeCode;

    public String serviceType;

    public OmMsaConsStFrPK() {
    }

    public OmMsaConsStFrPK(OrganisationPK orgId, OmMsaConfigPK msaUid, String typeCode, String serviceType) {
        this.orgId = orgId;
        this.msaUid = msaUid;
        this.typeCode = typeCode;
        this.serviceType = serviceType;
    }

    public OmMsaConsStFrPK(String key) {
        StringTokenizer token = new StringTokenizer(decode(key), "-");
        this.orgId = new OrganisationPK(token.nextToken());
        this.msaUid = new OmMsaConfigPK(token.nextToken());
        this.typeCode = token.nextToken();
        this.serviceType = token.nextToken();
    }

    @Override
    public String toString() {
        return ""
                + encode(this.orgId.toString() + "-" + this.msaUid.toString() + "-" + this.typeCode + "-"
                        + this.serviceType);
    }

    public OrganisationPK getOrgId() {
        return orgId;
    }

    public void setOrgId(OrganisationPK orgId) {
        this.orgId = orgId;
    }

    public OmMsaConfigPK getMsaUid() {
        return msaUid;
    }

    public void setMsaUid(OmMsaConfigPK msaUid) {
        this.msaUid = msaUid;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
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
        OmMsaConsStFrPK other = (OmMsaConsStFrPK) obj;
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

    private static String encode(String str) {
        return BaseEncoding.base32().encode(str.getBytes(Charset.forName("UTF-8")));
    }

    private static String decode(String str) {
        return new String(BaseEncoding.base32().decode(str), Charset.forName("UTF-8"));
    }
}
