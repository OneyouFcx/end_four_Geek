package end.s2.nb.entity;

import java.math.BigDecimal;

public class UserDetail {
    private Integer id;

    private Integer userId;

    private String userName;

    private String userPhone;

    private Long groosAmt;

    private Integer type;

    private BigDecimal weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Long getGroosAmt() {
        return groosAmt;
    }

    public void setGroosAmt(Long groosAmt) {
        this.groosAmt = groosAmt;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}