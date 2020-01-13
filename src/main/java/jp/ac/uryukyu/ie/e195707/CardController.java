package jp.ac.uryukyu.ie.e195707;
import java.util.Random;

public class CardController {
    /**
     * ハート、ダイア、スペード、クラブの４種類×１３枚のカードを生成する
     *
     * @return ４種類×１３枚　計５２枚のカードが入った配列
     */
    public Card[] cards = new Card[52];

    //ハートの生成
    addCard(cards, CardType.HART, 0);
    //ダイアの生成

}
/**
 * 指定された種類のカードを１３枚追加する
 *
 * @param cards
 *      追加する先のカードの一覧
 */
