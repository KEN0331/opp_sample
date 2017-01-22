/**
 * いろんな人がいろんな何かを食べるアプリ起動用クラス
 * 
 * このアプリで使うクラス一覧
 * - HumansEatsSomeFoodsApp(起動用クラス) → これはオブジェクトの設計図ではなく純粋にmainメソッドだけを実行する起動用
 * - Human.java(人間クラス)
 * - Food.java(食べ物全般クラス)
 *     - Taiyaki.java(たい焼きクラス) → Foodクラスの子クラス
 *     - Medamayaki.java(目玉焼きクラス) → Foodクラスの子クラス
 *
 * このクラスで覚えて欲しいこと
 * - main()とは何か
 * - staticとそうじゃないメソッドの違いを軽く
 */
public class HumansEatsSomeFoodsApp {

	// Application起動用method
	public static void main(String[] args) {

		// satakenというキャラクター(人)を生成
		Human sataken = new Human(9999, "さたけん");

		// katsuyaというキャラクター(人)を生成
		Human katsuya = new Human(100, "たまたま");

		// taiyakiとmedamayakiをそれぞれ1つづつ作る
		Taiyaki taiyakiForSataken = new Taiyaki();
		Medamayaki medamayakiForSataken = new Medamayaki();

		Taiyaki taiyakiForKatsuya = new Taiyaki();
		Medamayaki medamayakiForKatsuya = new Medamayaki();

		// 作ったものをsatakenが食べるものリストにする
		Food satakenFoods[] = new Food[2];
		satakenFoods[0] = taiyakiForSataken;
		satakenFoods[1] = medamayakiForSataken;

		// 作ったものをkatsuyaが食べるものリストにする
		Food katsuyaFoods[] = new Food[2];
		katsuyaFoods[0] = taiyakiForKatsuya;
		katsuyaFoods[1] = medamayakiForKatsuya;

		// 2人で食べる
		sataken.eatSome(satakenFoods);
		System.out.println(sataken.getName() + "はまだHPが" + sataken.getHp() + "も残ってるよ");
		katsuya.eatSome(katsuyaFoods);
		System.out.println(katsuya.getName() + "はまだHPが" + katsuya.getHp() + "も残ってるよ");
	}
}
