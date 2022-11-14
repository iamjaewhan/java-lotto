package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Person {
    private List<Lotto> lottos;

    public void buyLottos(LottoMachine lottoMachine) {
        this.lottos = lottoMachine.sellLottos();
    }

    private int countCorrectLottoNumber(Lotto lotto) {
        List<Integer> winningLottoNumber = WinningLotto.getWinningLottoNumber();
        Set<Integer> count = lotto.getLottoNumbers()
                .stream()
                .filter(winningLottoNumber::contains)
                .collect(Collectors.toSet());
        return count.size();
    }

    private int countCorrectBonusNumber(Lotto lotto) {
        if (lotto.getLottoNumbers()
                .contains(WinningLotto.getWinningBonusNumber()))
            return 1;
        return 0;
    }

}
