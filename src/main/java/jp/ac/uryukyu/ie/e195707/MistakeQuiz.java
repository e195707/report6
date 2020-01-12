package jp.ac.uryukyu.ie.e195707;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class MistakeQuiz{
    private String question;
    private String answer;

    MistakeQuiz(){
        createQuiz();
    }

    void createQuiz(){
        //正しい文字
        String[] coreect = {"氷","問","鳥","緑","塊"};
        //間違いの文字
        String[] mistake = {"水","間","烏","縁","魂"};
        Random rnd = new Random();

        //何番目を問題にするか
        int qID = rnd.nextInt(coreect.length);
        //何文字目が正解か
        int answerID = rnd.nextInt(10);
        this.question = "";
        for (int i = 0; i < 10; i++){
            if (i != answerID){
                //正解文字を足す
                this.question += coreect[qID];
            }else {
                //間違い文字を足す
                this.question += mistake[qID];
            }
        }
        //文字の文字列
        this.question = ":この中で違うのは何文字目？";
        //答えの文字列
        this.answer = (answerID + 1)+ "文字目";
    }
    //その問題を教えてくれる
    String getQuestion(){
        return this.question;
    }
    //その答えを教えてくれる
    String getAnswer(){
        return this.answer;
    }

    void QuizPlay(){
        //問題数
        int quizNum = 5;
        //問題を作るインスタンスを入れる配列
        MistakeQuiz[] quiz = new MistakeQuiz[quizNum];

        for(int i = 0; i < quizNum; i++){
            quiz[i] = new MistakeQuiz();
        }
        for(int i = 0; i < quizNum; i++){
            System.out.println("問"+i+":"+quiz[i].getQuestion());
        }
        System.out.println("-------------");
        for(int i = 0; i < quizNum; i++){
            System.out.println("答"+i+":"+quiz[i].getAnswer());
        }


    }
}

