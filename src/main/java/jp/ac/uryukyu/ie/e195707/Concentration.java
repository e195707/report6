package jp.ac.uryukyu.ie.e195707;
import com.sun.net.httpserver.Authenticator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Concentration{
    /**
     * ユーザーにカード番号を入力させます
     *
     * @param br
     *  入出力用ストリーム
     * @param cards
     *  カードの一覧
     * @return 取得したカード
     * @throws IOException
     */
    public static Card inputCard(BufferedReader br, Card[] cards)throws IOException{
        Card card = null;
        while (card == null){
            String input = br.readLine();
            try{
                Integer index = Integer.parseInt(input);
                if(index >= cards.length){
                    System.out.println("カードは"+cards.length+"枚の中から選んでください");
                    continue;
                }
                card = cards[index];
                if(card == null){
                    System.out.println("既に選んでいるカードです。もう一度選んでください。");
                }
            }catch (NumberFormatException e){
                System.out.println("数字を入力してください！");
            }
        }
        System.out.println(card.getCardType()+"の"+card.getNumber()+"です。");
        return card;
    }

    /**
     * カードの一覧から、正解したカードを除外します。
     *
     * @param card
     *  正解したカード
     * @param fieldCards
     *  カードの一覧
     *
     */
    public static void removeCard(Card card,Card[] fieldCards){
        for(int i = 0; i < fieldCards.length; i++){
            Card fieldCard = fieldCards[i];
            if(fieldCard == null){
                continue;
            }
            if(fieldCard.getCardType().equals(card.getCardType())&&fieldCard.getNumber() == card.getNumber()){
                fieldCards[i] = null;
            }
        }
    }
    void Play(){
        CardController creator = new CardController();
        Card[] cards = creator.createCard();
        cards = creator.shuffle(cards);
        //各プレイヤーの正解数初期化
        int[] playerSuccess = {0,0};
        int totalSuccess = 0;
        //誰のターンかを保持する
        int turn = 0;
        //２プレイヤーの合計が２６になるまで繰り返す
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while(totalSuccess < 26){
            System.out.println(turn+"番目のプレイヤーの番です。");
            System.out.println("最初の番号を指定してください。");
            try{
                Card firstCard = inputCard(br, cards);
                Card secondCard = inputCard(br, cards);
                if(firstCard.getNumber() == secondCard.getNumber()){
                    //同じカードが選ばれたらやり直し
                    if(firstCard.getCardType().equals(secondCard.getCardType())){
                        System.out.println("同じカードが選ばれました。やり直してください。" );
                        continue;
                    }
                    System.out.println("正解です！");
                    //正解した場合、正解数を＋とする
                    playerSuccess[turn]++;
                    totalSuccess++;
                    //正解したカードを場からなくす
                    removeCard(firstCard, cards);
                    removeCard(secondCard, cards);
                }else{
                    System.out.println("残念！！ハズレです。");
                    turn++;
                    //ターンがプレイヤー数を超えた場合、最初の人に戻す。
                    if(turn >= playerSuccess.length){
                        turn = 0;
                    }
                }
            }catch (IOException e){
                System.out.println("不正な入力がありました。");
                System.out.println("もう一度"+turn+"番目のプレイヤーの番です");
            }
        }
        for(int i=0; i< playerSuccess.length; i++){
            System.out.println("プレイヤー"+i+"="+playerSuccess[i]);
        }
    }
}