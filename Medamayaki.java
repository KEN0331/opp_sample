/**
 * 目玉焼きを表すクラス(目玉焼きの設計図)
 * classはオブジェクトの設計図と覚える
 * 
 * このクラスで覚えて欲しいこと
 * - なぜ継承(extends)が便利なのかを覚える
 */
public class Medamayaki extends Food {
	// Taiyaki.javaと見比べてみる → 別の食べ物を追加して欲しいっていう仕様が追加された時に
	// 超簡単なコピペでしかも短いコードで要求仕様を追加することができる
	// 例えば、「回復バリュー200のおにぎりも作れるようにしてよ！」「あ、やっぱ回復バリューと食べ物名のリスト作っておいたからこれ全部いつでも作れるようにしといて！」
	// なんて言われることがよくある。 中身を見るとリストが100個もある。。。 とか

	// 目玉焼きとたい焼きのコードがこんな風にFood(食べ物)を継承したクラスになっているならコピペしまくって回復バリューと名前を設定のように変更していくだけでいい
	// コピペする → クラス名とコンストラクタ名を書き換える → PREFARENCE_KAIHUKUVALUEとPREFARENCE_FOOD_NAMEを要求仕様通りに設定する → 以上！！！

	// もしFood.javaを作らずにいろんな食べ物が今後追加されたらと思うとぞっとする
	// 「食べ物の名前をいろんなところから取れるようにして」とか言われた時に「え？全部の食べ物っぽいクラスにgetName()つけないと。。。 100個。。。」
	// 全部の食べ物を意味するクラスにFoodクラスを継承させてれば「OK。Food.javaにgetName()を生やして終了！」ってなる
	// 今は共通コードはgetKaihukuVakue()とkaihukuvalueとnameしかないけど普通はもっといろんな共通のメソッドが生える

	public static final int PREFARENCE_KAIHUKUVALUE = 150;
	private static final String PREFARENCE_FOOD_NAME = "目玉焼き";

	public Medamayaki() {
		super(PREFARENCE_KAIHUKUVALUE, PREFARENCE_FOOD_NAME);
	}
}
