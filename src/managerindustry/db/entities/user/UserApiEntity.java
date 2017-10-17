/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author lele
 */
@Entity
@NamedQueries({
// get all user with flag TRUE or FALSE     
@NamedQuery(name = "getUserApiEntities", query = "SELECT a FROM UserApiEntity a WHERE a.userEnable= :userEnable"),
// get user with flag TRUE or FALSE     
@NamedQuery(name = "getUserApiEntity", query = "SELECT a FROM UserApiEntity a WHERE a.nameCharacter= :nameCharacter AND a.userEnable= :userEnable"),

})

public class UserApiEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
//    @OneToMany(cascade = CascadeType.ALL)
//    private List < ContractEntity > contractEntitys = new ArrayList<>();
    
//    @OneToOne(cascade = CascadeType.ALL)
//    private ContractEntity contractEntity;
    
    // https://esi.tech.ccp.is/latest/characters/USERID/skills/?datasource=tranquility
    
    private String url = "https://esi.tech.ccp.is/latest/characters/";
    private String urlCharacterId = null;
    private String nameCharacter = null;
    
    private String urlContactIndex = "Contracts.xml.aspx?";
    private String urlKeyIdString = "keyID=";
    private String urlKeyIdValue = null;
    private String urlVerificationCodeString = "&vCode=";
    @Column(unique = true)
    private String urlVerificationCodeValue = null;
    private boolean userEnable;

    /**
     * Get if is User Enable
     * @return boolean
     */
    public boolean isUserEnable() {
        return userEnable;
    }

    /**
     * Set User Enable
     * @param userEnable 
     */
    public void setUserEnable(boolean userEnable) {
        this.userEnable = userEnable;
    }
    
//    /**
//     * Get all contract Entitys
//     * @return List < ContractEntity >
//     */
//    public List<ContractEntity> getAllContractEntitys() {
//        return contractEntitys;
//    }
//
//    /**
//     * unused
//     * @param List<ContractEntity> contractEntitys 
//     */
//    public void setContractEntitys(List<ContractEntity> contractEntitys) {
//        this.contractEntitys = contractEntitys;
//    }

//    /**
//     * Add Contract Entitys
//     * @param contractEntity 
//     */
//    public void addContractEntitys (ContractEntity contractEntity) {
//        this.contractEntitys.add(contractEntity);
//    }
    
//    public ContractEntity getContractEntity() {
//        return contractEntity;
//    }
//
//    public void setContractEntity(ContractEntity contractEntitys) {
//        this.contractEntity = contractEntitys;
//    }
    
    /**
     * Get Short Report
     * @return String
     */
    public String getShortReport(){
        String shortReport = this.nameCharacter +  " - " + this.urlKeyIdValue +  " - " + this.urlVerificationCodeValue;
        return shortReport;
    }    
    
    public UserApiEntity(){
        
    }

    /**
     * Create a user with urlKeyIdValue, urlVerificationCode and nameCharacter
     * @param urlKeyIdValue
     * @param urlVerificationCode
     * @param nameCharacter 
     */
    public UserApiEntity( String urlKeyIdValue, String urlVerificationCode, String nameCharacter, boolean userEnable) {
        this.urlKeyIdValue = urlKeyIdValue;
        this.urlVerificationCodeValue = urlVerificationCode;    
        this.nameCharacter = nameCharacter;
        this.userEnable = userEnable;
    }    
    
    /**
     * Get Contract Index
     * @return String
     */
    public String getUrlContactIndex() {
        return urlContactIndex;
    }

    /**
     * Set Contract Index
     * @param contractIndex 
     */
    public void setUrlContactIndex(String contractIndex) {
        this.urlContactIndex = contractIndex;
    }       
    
  /**
     * Get Url Verification Code Value
     * @return String
     */
    public String getUrlVerificationCodeValue() {
        return urlVerificationCodeValue;
    }

    /**
     * Set Url Verification Code Value
     * @param urlVerificationCodeValue 
     */
    public void setUrlVerificationCodeValue(String urlVerificationCodeValue) {
        this.urlVerificationCodeValue = urlVerificationCodeValue;
    }

    /**
     * Get Name Character
     * @return String
     */
    public String getNameCharacter() {
        return nameCharacter;
    }

    /**
     * Set Name Character
     * @param nameCharacter 
     */
    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }

    /**
     * Get Url
     * @return String
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set Url
     * @param url 
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get Character
     * @return String
     */
    public String getUrlCharacterId() {
        return urlCharacterId;
    }

    /**
     * Set Character
     * @param urlCharacterId 
     */
    public void setUrlCharacterId(String urlCharacterId) {
        this.urlCharacterId = urlCharacterId;
    }

    /**
     * Get Key Id String
     * @return String
     */
    public String getUrlKeyIdString() {
        return urlKeyIdString;
    }

    /**
     * Set Key Id String
     * @param urlKeyIdString 
     */
    public void setUrlKeyIdString(String urlKeyIdString) {
        this.urlKeyIdString = urlKeyIdString;
    }

    /**
     * Get Key Id Value
     * @return String
     */
    public String getUrlKeyIdValue() {
        return urlKeyIdValue;
    }

    /**
     * Set Key Id Value
     * @param urlKeyIdValue 
     */
    public void setUrlKeyIdValue(String urlKeyIdValue) {
        this.urlKeyIdValue = urlKeyIdValue;
    }

    /**
     * Get urlVerificationCodeString
     * @return String
     */
    public String getUrlVerificationCodeString() {
        return urlVerificationCodeString;
    }

    /**
     * Set urlVerificationCodeString
     * @param urlVerificationCodeString 
     */
    public void setUrlVerificationCodeString(String urlVerificationCodeString) {
        this.urlVerificationCodeString = urlVerificationCodeString;
    }       
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserApiEntity)) {
            return false;
        }
        UserApiEntity other = (UserApiEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "alliancecontractmanager.db.entities.UserApiEntity[ id=" + id + " ]";
    }
    
}
