package com.dubbo.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`t_order`")
public class Order implements Serializable {
    @Id
    @Column(name = "`oid`")
    private Integer oid;

    @Column(name = "`sid`")
    private Integer sid;

    @Column(name = "`count`")
    private Integer count;

    @Column(name = "`address`")
    private String address;

    @Column(name = "`oname`")
    private String oname;

    @Column(name = "`tel`")
    private String tel;

    @Column(name = "`sum`")
    private String sum;

    @Column(name = "`state`")
    private String state;

    private static final long serialVersionUID = 1L;

    /**
     * @return oid
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * @param oid
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * @return sid
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * @param sid
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return oname
     */
    public String getOname() {
        return oname;
    }

    /**
     * @param oname
     */
    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * @return sum
     */
    public String getSum() {
        return sum;
    }

    /**
     * @param sum
     */
    public void setSum(String sum) {
        this.sum = sum == null ? null : sum.trim();
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}