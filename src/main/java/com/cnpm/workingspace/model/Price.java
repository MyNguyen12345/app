	package com.cnpm.workingspace.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="price")
public class Price {
	
	@Id
	@Column(name="price_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int priceId;
	
	@Column(name="hour_price")
	private Double hourPrice;
	
	@Column(name="day_price")
	private Double dayPrice;

	@Column(name="week_price")
    private Double weekPrice;

	@Column(name="month_price")
    private Double monthPrice;
	
	public Price() {
	}

	public Price(Double hourPrice, Double dayPrice, Double weekPrice, Double monthPrice) {
		this.hourPrice = hourPrice;
		this.dayPrice = dayPrice;
		this.weekPrice = weekPrice;
		this.monthPrice = monthPrice;
	}

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public Double getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(Double hourPrice) {
		this.hourPrice = hourPrice;
	}

	public Double getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(Double dayPrice) {
		this.dayPrice = dayPrice;
	}

	public Double getWeekPrice() {
		return weekPrice;
	}

	public void setWeekPrice(Double weekPrice) {
		this.weekPrice = weekPrice;
	}

	public Double getMonthPrice() {
		return monthPrice;
	}

	public void setMonthPrice(Double monthPrice) {
		this.monthPrice = monthPrice;
	}

	@Override
	public String toString() {
		return "Price{" +
				"priceId=" + priceId +
				", hourPrice=" + hourPrice +
				", dayPrice=" + dayPrice +
				", weekPrice=" + weekPrice +
				", monthPrice=" + monthPrice +
				'}';
	}
}
