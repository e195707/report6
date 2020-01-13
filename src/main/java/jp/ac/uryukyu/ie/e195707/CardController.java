package jp.ac.uryukyu.ie.e195707;

import java.util.Random;

public class CardController {
    /**
     * ハート、ダイア、スペード、クラブの４種類×１３枚のカードを生成する
     *
     */
    public Card[] createCard() {
        Card[] cards = new Card[52];
        //ハートの生成
        addCard(cards, CardType.HART,0);
        //ダイアの生成
        addCard(cards, CardType.DIA, 13);
        //スペードの生成
        addCard(cards, CardType.SPADE,26);
        //クラブの生成
        addCard(cards,CardType.CLUB,39);
        return cards;
        }
    /**
     * 指定された種類のカードを１３枚追加する
     *
     * @param cards      追加する先のカードの一覧
     * @param cardType   カードの種類
     * @param startIndex 追加先のカード開始番号
     */
    public void addCard(Card[] cards, CardType cardType, int startIndex) {
        int cardsCount = startIndex;
        for (int i = 1; i <= 13; i++) {
            Card card = new Card(i, cardType);
            cards[cardsCount] = card;
            cardsCount++;

        }
    }
    /**
     * 引数のカードをランダムにシャッフルして返す。
     *
     * @param cards
     *  対象のカード
     * @retrun シャッフルされた結果のカード
     */
    public Card[] shuffle(Card[] cards){
        Card[] results = new Card[52];
        Random random = new Random();
        int index = 0;
        while(index < 52){
            int rand = random.nextInt(52);
            Card card = cards[rand];
            boolean stillAdd = false;
            for(Card result:results){
                if (result == null){
                    break;
                }
                if(result.getCardType().equals(card.getCardType())&&result.getNumber() == card.getNumber()){
                    stillAdd = true;
                    break;
                }
            }
            if(!stillAdd){
                results[index] = card;
                index++;
            }
        }
        return results;

    }
}