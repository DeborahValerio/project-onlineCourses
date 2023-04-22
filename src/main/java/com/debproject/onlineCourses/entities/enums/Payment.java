package com.debproject.onlineCourses.entities.enums;

public enum Payment {

	PIX(1),
	BOLETO(2),
	CREDITO_AVISTA(3),
	CREDITO_APRAZO(4);

	private int code;
	
	private Payment(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Payment valueOf(int code) {
		for(Payment value : Payment.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
}
