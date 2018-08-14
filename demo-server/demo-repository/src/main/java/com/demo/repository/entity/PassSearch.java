package com.demo.repository.entity;

import javax.persistence.*;

@Table(name = "mb_pass_search")
public class PassSearch {
    @Id
    private Integer id;

    @Column(name = "encrypt_type")
    private String encryptType;

    private String pass;

    @Column(name = "search_ip")
    private String searchIp;

    @Column(name = "real_pass")
    private String realPass;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return encrypt_type
     */
    public String getEncryptType() {
        return encryptType;
    }

    /**
     * @param encryptType
     */
    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType == null ? null : encryptType.trim();
    }

    /**
     * @return pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    /**
     * @return search_ip
     */
    public String getSearchIp() {
        return searchIp;
    }

    /**
     * @param searchIp
     */
    public void setSearchIp(String searchIp) {
        this.searchIp = searchIp == null ? null : searchIp.trim();
    }

    /**
     * @return real_pass
     */
    public String getRealPass() {
        return realPass;
    }

    /**
     * @param realPass
     */
    public void setRealPass(String realPass) {
        this.realPass = realPass == null ? null : realPass.trim();
    }
}