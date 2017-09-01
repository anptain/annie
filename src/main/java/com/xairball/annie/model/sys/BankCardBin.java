package com.xairball.annie.model.sys;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xairball.annie.model.AbstractModel;

@Entity
@Table(name = "t_bank_card_bin")
public class BankCardBin extends AbstractModel {
	private String bankName;
	private String bankCode;
	private Integer cardType;
	private String cardName;
	private String cardBin;
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardBin() {
		return cardBin;
	}
	public void setCardBin(String cardBin) {
		this.cardBin = cardBin;
	}
}
