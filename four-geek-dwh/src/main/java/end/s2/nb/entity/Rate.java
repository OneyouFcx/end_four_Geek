package end.s2.nb.entity;

import java.math.BigDecimal;

public class Rate {
    private Integer id;

    private Integer minWeight;

    private Integer maxWeight;

    private BigDecimal weightRate;

    private Integer cargoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Integer minWeight) {
        this.minWeight = minWeight;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public BigDecimal getWeightRate() {
        return weightRate;
    }

    public void setWeightRate(BigDecimal weightRate) {
        this.weightRate = weightRate;
    }

    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }
}