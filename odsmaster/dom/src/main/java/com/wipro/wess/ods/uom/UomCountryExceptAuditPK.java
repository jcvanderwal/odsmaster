package com.wipro.wess.ods.uom;

import java.io.Serializable;

public class UomCountryExceptAuditPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4821863741045027893L;
    
    public int recordId;
    public UomCountryExceptAuditPK(){}
    public UomCountryExceptAuditPK(int recordId){
        this.recordId = recordId;
    }
    
    public UomCountryExceptAuditPK(String key){
        this.recordId = Integer.parseInt(key);
    }
    
    
    @Override
    public String toString() {
        return "" + recordId;
    }
    public int getRecordId() {
        return recordId;
    }
    
    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + recordId;
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
        UomCountryExceptAuditPK other = (UomCountryExceptAuditPK) obj;
        if (recordId != other.recordId)
            return false;
        return true;
    }
    

}
