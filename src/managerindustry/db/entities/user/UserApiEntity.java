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
    
    private String nameCharacter = null;    
    private String urlKeyIdValue = null;

//    @Column(unique = true)
//    private String urlVerificationCodeValue = null;
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
            
    /**
     * Get Short Report
     * @return String
     */
    public String getShortReport(){
        String shortReport = this.nameCharacter +  " - " + this.urlKeyIdValue; // +  " - " + this.urlVerificationCodeValue;
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
//        this.urlVerificationCodeValue = urlVerificationCode;    
        this.nameCharacter = nameCharacter;
        this.userEnable = userEnable;
    }        
    
//  /**
//     * Get Url Verification Code Value
//     * @return String
//     */
//    public String getUrlVerificationCodeValue() {
//        return urlVerificationCodeValue;
//    }
//
//    /**
//     * Set Url Verification Code Value
//     * @param urlVerificationCodeValue 
//     */
//    public void setUrlVerificationCodeValue(String urlVerificationCodeValue) {
//        this.urlVerificationCodeValue = urlVerificationCodeValue;
//    }

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
