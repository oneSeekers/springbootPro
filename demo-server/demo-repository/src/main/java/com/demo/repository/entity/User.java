package com.demo.repository.entity;

import javax.persistence.*;

@Table(name = "mb_user")
public class User {
    @Id
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 手机号
     */
    private String password;

    /**
     * 性别
     */
    private String gender;

    @Column(name = "face_url")
    private String faceUrl;

    @Column(name = "login_at")
    private Integer loginAt;

    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 不正常'UN_NOMAL',正常'NOMAL'
     */
    private String status;

    @Column(name = "created_at")
    private Integer createdAt;

    @Column(name = "updated_at")
    private Integer updatedAt;

    @Column(name = "deleted_at")
    private Integer deletedAt;

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
     * 获取用户名
     *
     * @return name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取手机号
     *
     * @return password - 手机号
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置手机号
     *
     * @param password 手机号
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * @return face_url
     */
    public String getFaceUrl() {
        return faceUrl;
    }

    /**
     * @param faceUrl
     */
    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl == null ? null : faceUrl.trim();
    }

    /**
     * @return login_at
     */
    public Integer getLoginAt() {
        return loginAt;
    }

    /**
     * @param loginAt
     */
    public void setLoginAt(Integer loginAt) {
        this.loginAt = loginAt;
    }

    /**
     * @return login_ip
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * @param loginIp
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 获取不正常'UN_NOMAL',正常'NOMAL'
     *
     * @return status - 不正常'UN_NOMAL',正常'NOMAL'
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置不正常'UN_NOMAL',正常'NOMAL'
     *
     * @param status 不正常'UN_NOMAL',正常'NOMAL'
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return created_at
     */
    public Integer getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return updated_at
     */
    public Integer getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     */
    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return deleted_at
     */
    public Integer getDeletedAt() {
        return deletedAt;
    }

    /**
     * @param deletedAt
     */
    public void setDeletedAt(Integer deletedAt) {
        this.deletedAt = deletedAt;
    }
}