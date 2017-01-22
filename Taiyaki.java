/**
 * たい焼きを表すクラス(たい焼きの設計図)
 * classはオブジェクトの設計図と覚える
 * 
 * このクラスで覚えて欲しいこと
 * - 定数の指定のしかたと使い方
 * - 継承(extends) の考え方
 */
public class Taiyaki extends Food {
	// 「extends Food {」これがミソ → これを書くと「TaiyakiクラスがFoodクラスを継承した」ということになる

	// 継承すると何が起こるか？

	// ①Foodが持っているメソッドはTaiyakiクラスに書かなくてもTaiyakiが持っていることと同じようにTaiyakiでも使えるようになる
	// 例えばFood.javaが持つgetKaihukuValue()メソッドが
	// 「taiyaki.getKaihukuValue()」みたいにTaiyakiオブジェクトでも使える → Food.javaを見てみる

	// ②Foodが持ってる属性(メンバ変数[※1])はTaiyakiに書かなくてもTaiyakiが持っているのと同じことになる
	// 例えばたい焼きも「private int kaihukuValue」や「private String name」 などのメンバ変数[※1]を持っていることになる

	// たい焼きの初期回復バリューは誰がどう作っても100と決めちゃおう
	// 「private static final 型 全大文字の名前」と書くのが定数と覚える
	public static final int PREFARENCE_KAIHUKUVALUE = 100;
	private static final String PREFARENCE_FOOD_NAME = "たい焼き";

	public Taiyaki() {
		// 親クラスを持つ時はコンストラクタで必ず親クラスも初期化する(親が必要な初期設定は当然子でも必要だから)
		// その書き方が「super(親クラスのコンストラクタの引数たち)」 → Food.javaのコンストラクタを見てみる

		// ②で説明した内容を思い出しながらここを見ると
		// Food.javaのコンストラクタに(100, "たい焼き")と渡して初期化してあげることで
		// 回復バリュー 100 で 名前が"たい焼き"というFoodと同等のものが「new Taiyaki()」 とすることでできる
		// それがTaiyakiオブジェクトであることがわかる
		super(PREFARENCE_KAIHUKUVALUE, PREFARENCE_FOOD_NAME);
	}
}
