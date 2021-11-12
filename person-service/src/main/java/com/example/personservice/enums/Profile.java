package com.example.personservice.enums;

public enum Profile {
    PHYSICAL_MATHEMATICAL("Физико-математический"),
    CHEMICAL_BIOLOGICAL("Химико-биологический"),
    INFORMATION_TECHNOLOGY("Информационные технологии"),
    SOCIO_ECONOMIC("Социальная экономика"),
    HUMANITARIAN("Гуманитарный"),
    LINGUISTIC("Лингвистический"),
    ARTISTIC_AESTHETIC("Художественно-эстетический");

    private String code;

    private Profile(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    //Взято отсюда: https://www-baeldung-com.translate.goog/jpa-persisting-enums-in-jpa?_x_tr_sl=en&_x_tr_tl=ru&_x_tr_hl=ru&_x_tr_pto=nui
}
