/**
 * 食べ物全般を表すクラス(食べ物の設計図)
 * このクラスはTaiyaki.javaとMedamayaki.javaのスーパークラス(親クラス)
 * classはオブジェクトの設計図と覚える
 *
 * このクラスで覚えて欲しいこと
 * - 継承(superクラス)
 * - getterの使い方 → Human.java(呼ぶ側)とセットで使い方を覚える
 *    - 戻り値
 */
public class Food {
	// 属性 (通常 メンバ変数[※1] と呼ばれる)
	private int kaihukuValue;
	private String name;


	public Food(int kaihukuValue, String name) {
		// コンストラクタの説明は割愛 → Human.javaのコンストラクタを参照
		this.kaihukuValue = kaihukuValue;
		this.name = name;

		System.out.println(name + "(回復バリュー:" + kaihukuValue + ")ができたよー。めしあがれ！");
	}

	// メンバ変数[※1]「private kaihukuValue」のgetter
	// Human.javaのeat()メソッド内(呼び出す側)で使ってる → Human.javaのeat()メソッドを見てみる
	public int getKaihukuValue() {
		return kaihukuValue;
	}
}
