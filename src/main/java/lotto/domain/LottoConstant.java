package lotto.domain;

public enum LottoConstant {
    SIZE(6),
    STARTFROM(1),
    ENDTO(45);

    private int value;
    
    LottoConstant(int value) {
        this.value = value;
    }
}
