package com.wipro.wess.ods.sca;

import java.nio.charset.Charset;
import java.util.StringTokenizer;

import com.google.common.io.BaseEncoding;
import com.wipro.wess.ods.upload.ProvisioningConstants;

// Generated Jan 7, 2014 12:15:31 PM by Hibernate Tools 3.2.2.GA

/**
 * OmScaConfigExtAttrId generated by hbm2java
 */
public class OmScaConfigExtAttrPK implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7650542347914376952L;

    public ScaConfigPK scaUid;

    public String attributeName;

    public OmScaConfigExtAttrPK() {
    }

    public OmScaConfigExtAttrPK(ScaConfigPK scaUid, String attributeName) {
        this.scaUid = scaUid;
        this.attributeName = attributeName;
    }

    public OmScaConfigExtAttrPK(String key) {
        StringTokenizer token = new StringTokenizer(decode(key), ProvisioningConstants.DOMAIN_OBJ_SEPERATOR);
        this.attributeName = token.nextToken();
        this.scaUid = new ScaConfigPK(token.nextToken());
    }

    public ScaConfigPK getScaUid() {
        return this.scaUid;
    }

    public void setScaUid(ScaConfigPK scaUid) {
        this.scaUid = scaUid;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public String toString() {
        return encode(this.attributeName + ProvisioningConstants.DOMAIN_OBJ_SEPERATOR + this.scaUid);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((attributeName == null) ? 0 : attributeName.hashCode());
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
        OmScaConfigExtAttrPK other = (OmScaConfigExtAttrPK) obj;
        if (attributeName == null) {
            if (other.attributeName != null)
                return false;
        } else if (!attributeName.equals(other.attributeName))
            return false;
        if (scaUid == null) {
            if (other.scaUid != null)
                return false;
        } else if (!scaUid.equals(other.scaUid))
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
